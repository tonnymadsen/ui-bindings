package com.rcpcompany.uibindings.extests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IExecutionListener;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.bindings.keys.ParseException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.ISourceProvider;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.ui.services.ISourceProviderService;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.extests.views.EmptyView;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.InternalConstants;
import com.rcpcompany.uibindings.utils.IGlobalNavigationManager;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;
import com.rcpcompany.utils.basic.ToStringUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Base class for all tests.
 * <p>
 * Provides a number of convenience methods...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BaseTestUtils {

	/**
	 * Resets the complete test environment
	 */
	public static void resetAll() {
		final IManager mng = IManager.Factory.getManager();
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__ALTERNATE_ROW_COLORS);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__ALTERNATIVE_DECORATION_POSITION);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__AUTO_APPLY_SINGLE_QUICKFIX);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__EDIT_CELL_ANY_KEY);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__EDIT_CELL_SINGLE_CLICK);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__MESSAGE_DECORATION_POSITION);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__MESSAGE_DECORATION_MINIMUM_SEVERITY);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__TEXT_COMMIT_STRATEGY);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__TEXT_COMMIT_STRATEGY_DELAY);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__VALIDATION_DELAY);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__VALIDATION_DELAY_WINDOW);
		mng.eUnset(IUIBindingsPackage.Literals.MANAGER__VALIDATION_ERRORS_ARE_FATAL);

		IValidatorAdapterManager.Factory.getManager().reset();

		IGlobalNavigationManager navMng = null;
		while ((navMng = mng.getService(IGlobalNavigationManager.class)) != null) {
			navMng.dispose();
		}
	}

	/**
	 * Returns a list of the configuration element with the specific name.
	 * 
	 * @param elementName the name
	 * @return the list of found elements
	 */
	public static List<IConfigurationElement> getElements(String elementName) {
		final List<IConfigurationElement> list = new ArrayList<IConfigurationElement>();

		final IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		for (final IConfigurationElement element : extensionRegistry
				.getConfigurationElementsFor(InternalConstants.UIBINDINGS_EXTENSION_POINT)) {
			if (element.getName().equals(elementName)) {
				list.add(element);
			}
		}

		return list;
	}

	private static int testViewSeq = 0;

	/**
	 * Opens and returns a new test view.
	 * 
	 * @param creatingObject the object of the caller - used to name the new view
	 * 
	 * @return the new view
	 */
	public static TestView createTestView(Object creatingObject) {
		TestView view = null;
		try {
			final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			view = (TestView) page.showView("com.rcpcompany.uibindings.extests.views.TestView", "" + (testViewSeq++),
					IWorkbenchPage.VIEW_ACTIVATE);
			assertNotNull(view);
			view.setPartName("Test View: " + creatingObject.getClass().getSimpleName());
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
		view.getSite().getPage().activate(view);
		return view;
	}

	/**
	 * Opens and returns the view with the specified ID
	 * 
	 * @param viewID the view id
	 * 
	 * @return the new view
	 */
	public static IViewPart showView(String viewID) {
		IViewPart view = null;
		try {
			final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			view = page.showView(viewID);
			assertNotNull(view);
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
		view.getSite().getPage().activate(view);
		return view;
	}

	/**
	 * Constructs and returns a widget of the specified type
	 * 
	 * @param <T> the widget type
	 * @param widgetType the widget type
	 * @param style the style argument
	 * @return the widget
	 */
	public static <T extends Widget> T createWidget(final Class<T> widgetType, final int style) {
		try {
			final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			final EmptyView emptyView = (EmptyView) page.showView("com.rcpcompany.uibindings.extests.views.EmptyView",
					null, IWorkbenchPage.VIEW_ACTIVATE);
			assertNotNull(emptyView);
			if (widgetType == Shell.class) {
				final Constructor<T> constructor = widgetType.getConstructor(Integer.TYPE);
				assertNotNull(constructor);

				return constructor.newInstance(style);
			}
			if (widgetType == TableColumn.class) {
				final Constructor<T> constructor = widgetType.getConstructor(Table.class, Integer.TYPE);
				assertNotNull(constructor);

				final Table table = emptyView.getTable();
				assertNotNull(table);

				final T w = constructor.newInstance(table, style);
				((TableColumn) w).setWidth(50);
				yield();
				return w;
			}
			if (widgetType == TreeColumn.class) {
				final Constructor<T> constructor = widgetType.getConstructor(Tree.class, Integer.TYPE);
				assertNotNull(constructor);

				final Tree tree = emptyView.getTree();
				assertNotNull(tree);

				final T w = constructor.newInstance(tree, style);
				((TreeColumn) w).setWidth(50);
				yield();
				return w;
			}
			if (widgetType == ToolItem.class) {
				final Constructor<T> constructor = widgetType.getConstructor(ToolBar.class, Integer.TYPE);
				assertNotNull(constructor);

				final ToolBar tb = emptyView.getToolBar();
				assertNotNull(tb);

				final T w = constructor.newInstance(tb, style);
				yield();
				return w;
			}
			if (widgetType == TabItem.class) {
				final Constructor<T> constructor = widgetType.getConstructor(TabFolder.class, Integer.TYPE);
				assertNotNull(constructor);

				final TabFolder tb = emptyView.getTabFolder();
				assertNotNull(tb);

				final T w = constructor.newInstance(tb, style);
				yield();
				return w;
			}

			final Composite top = emptyView.getTop();
			assertNotNull(top);

			final Constructor<T> constructor = widgetType.getConstructor(Composite.class, Integer.TYPE);
			assertNotNull(constructor);

			final T w = constructor.newInstance(top, style);
			yield();
			return w;
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
		return null;
	}

	/**
	 * Asserts that the specified runnable can be executed without any log messages or exceptions.
	 * 
	 * @param run the runnable
	 */
	public static void assertNoLog(Runnable run) {
		assertNoLog(run, null);
	}

	/**
	 * Asserts that the specified runnable can be executed without any log messages or exceptions expect those that
	 * match any of the ignorePatterns.
	 * 
	 * @param run the runnable
	 * @param ignorePatterns a list of {@link Pattern} for messages that are ignored
	 */
	public static void assertNoLog(Runnable run, String[] ignorePatterns) {
		final NoLogListener ll = new NoLogListener(ignorePatterns);
		Platform.addLogListener(ll);
		try {
			run.run();
		} catch (final Exception ex) {
			ex.printStackTrace();
			fail("Exception occured: " + ex.getClass() + ": " + ex.getMessage());
		}
		Platform.removeLogListener(ll);
		assertTrue("Log message: " + ll.lastMessage, ll.called == 0);
	}

	private static class NoLogListener implements ILogListener {
		public int called = 0;
		public String lastMessage;
		private final String[] myIgnorePatterns;

		public NoLogListener(String[] ignorePatterns) {
			myIgnorePatterns = ignorePatterns;
		}

		@Override
		public void logging(IStatus status, String plugin) {
			// Ignore non-error messages
			if (status.getSeverity() != IStatus.ERROR) {
				return;
			}
			final String m = status.getMessage();
			if (myIgnorePatterns != null) {
				for (final String p : myIgnorePatterns) {
					if (m.matches(p)) {
						return;
					}
				}
			}
			called++;
			lastMessage = m;
			final Throwable ex = status.getException();
			if (ex != null) {
				lastMessage = lastMessage + ": EXCEPTION: " + ex.getClass().getSimpleName() + ": " + ex.getMessage();
			}
		}
	}

	/**
	 * Sleeps for the specified number of msec.
	 * 
	 * @param msec the length
	 */
	public static void sleep(int msec) {
		cont = false;
		display.timerExec(msec, new Runnable() {
			@Override
			public void run() {
				cont = true;
			}
		});
		while (!cont) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public static void yield() {
		while (display.readAndDispatch()) {
		}
	}

	/**
	 * Posts the specified keystroke to the specified control which will get focus.
	 * 
	 * @param c the control
	 * @param stroke the text representation of the key-stroke
	 */
	public static void postKeyStroke(Control c, String stroke) {
		KeyStroke keyStroke = null;
		try {
			keyStroke = KeyStroke.getInstance(stroke);
		} catch (final ParseException ex) {
			fail(ex.getMessage());
		}
		assertTrue(keyStroke.isComplete());

		Event event;

		c.setFocus();

		postModifierKeys(c, keyStroke, true);

		event = new Event();
		event.type = SWT.KeyDown;
		event.stateMask = keyStroke.getModifierKeys();
		event.keyCode = keyStroke.getNaturalKey();
		event.character = (char) event.keyCode;
		event.widget = c;

		// System.out.println("e:: " + ToStringUtils.toString(event));

		assertTrue(c.getDisplay().post(event));

		event = new Event();
		event.type = SWT.KeyUp;
		event.stateMask = keyStroke.getModifierKeys();
		event.keyCode = keyStroke.getNaturalKey();
		event.character = (char) event.keyCode;
		event.widget = c;

		// System.out.println("e:: " + ToStringUtils.toString(event));

		assertTrue(c.getDisplay().post(event));

		postModifierKeys(c, keyStroke, false);

		yield();
	}

	/**
	 * @param c
	 * @param keyStroke
	 * @param down TODO
	 */
	public static void postModifierKeys(Control c, KeyStroke keyStroke, boolean down) {
		if ((keyStroke.getModifierKeys() & SWT.ALT) == SWT.ALT) {
			final Event event = new Event();
			event.type = down ? SWT.KeyDown : SWT.KeyUp;
			event.stateMask = 0;
			event.keyCode = SWT.ALT;
			event.widget = c;

			assertTrue(c.getDisplay().post(event));
		}
		if ((keyStroke.getModifierKeys() & SWT.SHIFT) == SWT.SHIFT) {
			final Event event = new Event();
			event.type = down ? SWT.KeyDown : SWT.KeyUp;
			event.stateMask = 0;
			event.keyCode = SWT.SHIFT;
			event.widget = c;

			assertTrue(c.getDisplay().post(event));
		}
		if ((keyStroke.getModifierKeys() & SWT.CTRL) == SWT.CTRL) {
			final Event event = new Event();
			event.type = down ? SWT.KeyDown : SWT.KeyUp;
			event.stateMask = 0;
			event.keyCode = SWT.CTRL;
			event.widget = c;

			assertTrue(c.getDisplay().post(event));
		}
	}

	/**
	 * Posts the specified keystroke to the specified control which will get focus.
	 * 
	 * @param c the control
	 * @param stroke the text representation of the key-stroke
	 * @param locator service locator used to find all relevant services
	 * @param handlerClass the expected handler class
	 */
	public static void postKeyStroke(Control c, final String stroke, IServiceLocator locator,
			final Class<? extends IHandler> handlerClass) {
		final ICommandService cs = (ICommandService) locator.getService(ICommandService.class);
		final boolean executed[] = new boolean[] { false };
		final IExecutionListener listener = new IExecutionListener() {
			@Override
			public void preExecute(String commandId, ExecutionEvent event) {
				final IHandler handler = event.getCommand().getHandler();
				assertNotNull("No handler active for " + event.getCommand().getId(), handler);
				String hName = handler.toString();
				if (hName.indexOf('@') >= 0) {
					hName = hName.substring(0, hName.indexOf('@'));
				}
				// Class<? extends IHandler> hc = handler.getClass();
				// if (hc == HandlerProxy.class) {
				// hc = ((HandlerProxy) handler).getClass();
				// }
				assertEquals("Stroke '" + stroke + "' command '" + commandId + "'", handlerClass.getName(), hName);
				executed[0] = true;
			}

			@Override
			public void postExecuteSuccess(String commandId, Object returnValue) {
				// Nothing...
			}

			@Override
			public void postExecuteFailure(String commandId, ExecutionException exception) {
				fail(exception.getMessage());
			}

			@Override
			public void notHandled(String commandId, NotHandledException exception) {
				fail(exception.getMessage());
			}
		};
		cs.addExecutionListener(listener);
		postKeyStroke(c, stroke);
		cs.removeExecutionListener(listener);
		assertTrue("Stroke '" + stroke + "' has not been executed", executed[0]);
	}

	/**
	 * Posts a mouse event for the specified control and point
	 * 
	 * @param c the control
	 * @param p the point
	 */
	public static void postMouse(Control c, Point p) {
		postMouse(c, p, 1);
	}

	/**
	 * Posts a mouse event for the specified control and point
	 * 
	 * @param c the control
	 */
	public static void postMouse(Control c) {
		final Rectangle bounds = c.getBounds();
		bounds.x = bounds.y = 0;
		postMouse(c, bounds, 1);
	}

	/**
	 * Posts a mouse event for the specified control and point
	 * 
	 * @param c the control
	 * @param p the point
	 * @param noClicks the number of clicks
	 */
	public static void postMouse(Control c, Point p, int noClicks) {
		postMouse(null, c, p, noClicks);
	}

	/**
	 * Posts a mouse move event for the specified control and point
	 * 
	 * @param c the control
	 * @param p the point in the control
	 */
	public static void postMouseMove(Control c, Point p) {
		final Point pt = c.getDisplay().map(c, null, p);

		final Event e = new Event();
		e.type = SWT.MouseMove;
		e.x = pt.x;
		e.y = pt.y;
		assertTrue(c.getDisplay().post(e));
		yield();
	}

	/**
	 * Posts a mouse event for the specified control and point
	 * 
	 * @param modifiers a key stroke specification - only the modifier part is used
	 * @param button TODO
	 * @param c the control
	 * @param noClicks the number of clicks
	 * @param p the point
	 */
	public static void postMouseDown(String modifiers, int button, Control c, int noClicks) {
		KeyStroke keyStroke = null;
		try {
			if (modifiers != null) {
				keyStroke = KeyStroke.getInstance(modifiers);
				assertTrue(keyStroke.isComplete());
			}
		} catch (final ParseException ex) {
			fail(ex.getMessage());
		}

		final Event e = new Event();

		if (keyStroke != null) {
			c.setFocus();
			postModifierKeys(c, keyStroke, true);
		}

		for (int i = 1; i <= noClicks; i++) {
			e.type = SWT.MouseDown;
			e.button = button;
			e.count = i;
			// LogUtils.debug(e, ToStringUtils.toString(e));
			assertTrue(c.getDisplay().post(e));
			yield();

			e.type = SWT.MouseUp;
			e.button = button;
			e.count = i;
			// LogUtils.debug(e, ToStringUtils.toString(e));
			assertTrue(c.getDisplay().post(e));
			yield();
		}

		if (keyStroke != null) {
			postModifierKeys(c, keyStroke, false);
		}

	}

	/**
	 * Posts a mouse event for the specified control and point
	 * 
	 * @param modifiers TODO
	 * @param c the control
	 * @param p the point
	 * @param noClicks the number of clicks
	 */
	public static void postMouse(String modifiers, Control c, Point p, int noClicks) {
		postMouseMove(c, p);
		postMouseDown(modifiers, 1, c, noClicks);
	}

	/**
	 * Posts a mouse event for the specified control and point
	 * 
	 * @param c the control
	 * @param bounds the bound of the area to click
	 */
	public static void postMouse(Control c, Rectangle bounds) {
		postMouse(c, bounds, 1);
	}

	/**
	 * Posts a mouse event for the specified control and point
	 * 
	 * @param c the control
	 * @param bounds the bound of the area to click
	 */
	public static void postMouseMove(Control c, Rectangle bounds) {
		postMouseMove(c, new Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2));
	}

	/**
	 * Posts a mouse event for the specified table cell
	 * 
	 * @param t the table
	 * @param column the column number
	 * @param row the row number
	 */
	public static void postMouse(Table t, int column, int row) {
		postMouse(t, t.getItem(row).getBounds(column), 1);
	}

	/**
	 * Posts a mouse event for the specified control and point
	 * 
	 * @param t the table
	 * @param column the column number
	 * @param row the row number
	 */
	public static void postMouseMove(Table t, int column, int row) {
		postMouseMove(t, t.getItem(row).getBounds(column));
	}

	/**
	 * Posts a mouse event for the specified control and point
	 * 
	 * @param t the table
	 * @param column the column number
	 * @param row the row number
	 * @param noClicks the number of clicks
	 */
	public static void postMouse(Table t, int column, int row, int noClicks) {
		postMouse(t, t.getItem(row).getBounds(column), noClicks);
	}

	/**
	 * Posts a mouse event for the specified control and point
	 * 
	 * @param t the table
	 * @param column the column number
	 * @param row the row number
	 * @param noClicks the number of clicks
	 */
	public static void postMouse(String modifiers, Table t, int column, int row, int noClicks) {
		postMouse(modifiers, t, t.getItem(row).getBounds(column), noClicks);
	}

	/**
	 * Posts a mouse event for the specified control and point
	 * 
	 * @param c the control
	 * @param bounds the bound of the area to click
	 * @param noClicks the number of clicks
	 */
	public static void postMouse(Control c, Rectangle bounds, int noClicks) {
		postMouse(null, c, new Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2), noClicks);
	}

	/**
	 * Posts a mouse event for the specified control and point
	 * 
	 * @param c the control
	 * @param bounds the bound of the area to click
	 * @param noClicks the number of clicks
	 */
	public static void postMouse(String modifiers, Control c, Rectangle bounds, int noClicks) {
		postMouse(modifiers, c, new Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2), noClicks);
	}

	protected static boolean cont = false;
	private static final Display display = Display.getDefault();

	/**
	 * Asserts that the specified runnable can be executed without any log messages or exceptions.
	 * 
	 * @param run the runnable
	 * @return any last state message
	 */
	public static IStatus assertOneLog(Runnable run) {
		final OneLogLogListener ll = new OneLogLogListener();
		Platform.addLogListener(ll);
		try {
			run.run();
		} catch (final Exception ex) {
			fail("Exception occured: " + ex.getMessage());
		}
		Platform.removeLogListener(ll);
		assertTrue("No log messages, expected one", ll.lastStatus != null);

		return ll.lastStatus;
	}

	private static class OneLogLogListener implements ILogListener {
		public IStatus lastStatus;

		@Override
		public void logging(IStatus status, String plugin) {
			// Ignore non-error messages
			if (status.getSeverity() != IStatus.ERROR) {
				return;
			}
			if (lastStatus != null) {
				fail("Multiple log messages: '" + lastStatus.getMessage() + "' and '" + status.getMessage() + "'");
			}
			lastStatus = status;
		}
	}

	/**
	 * Tests that the values in the validUIList are exactly as specified.
	 * 
	 * @param binding the binding
	 * @param values the exact values
	 */
	public static void testUIValidList(IValueBinding binding, String... values) {
		final IObservableList list = binding.getDecorator().getValidUIList();
		assertEquals(values.length, list.size());
		for (final String v : values) {
			assertTrue("list contains '" + v + "'", list.contains(v));
		}
	}

	/**
	 * Runs the specified {@link Runnable} while debugging the SWT events.
	 * 
	 * @param runnable the {@link Runnable} to run
	 */
	public static void swtListen(Runnable runnable) {
		final Listener l = new Listener() {
			@Override
			public void handleEvent(Event event) {
				LogUtils.debug(this, ToStringUtils.toString(event));
			}
		};
		for (int i = SWT.None; i < SWT.ImeComposition; i++) {
			Display.getCurrent().addFilter(i, l);
		}
		assertNoLog(runnable);
		for (int i = SWT.None; i < SWT.ImeComposition; i++) {
			Display.getCurrent().removeFilter(i, l);
		}
	}

	public static void dumpBindingSourceState() {
		final ISourceProviderService sourceProviders = (ISourceProviderService) PlatformUI.getWorkbench().getService(
				ISourceProviderService.class);
		final ISourceProvider provider = sourceProviders.getSourceProvider(Constants.SOURCES_ACTIVE_BINDING);
		final Map<String, Object> currentState = provider.getCurrentState();

		final StringBuilder sb = new StringBuilder("Binding sources state:");
		for (final Map.Entry<String, Object> i : currentState.entrySet()) {
			final String s = i.getKey();
			sb.append("\n  ").append(s).append("='");
			final Object v = i.getValue();
			if (v == null) {
				sb.append("<null>");
			} else if (v == IEvaluationContext.UNDEFINED_VARIABLE) {
				sb.append("<undef>");
			} else {
				sb.append(v.toString());
			}
			sb.append("'");
		}
		LogUtils.debug(provider, sb.toString());
	}

	/**
	 * Tests that the pixel of the specified control have the specified RGB value.
	 * 
	 * @param control the control
	 * @param x the x
	 * @param y the y
	 * @param expectedRGB the expected color
	 */
	public static void assertPixelColor(Control control, int x, int y, RGB expectedRGB) {
		/*
		 * Map to the shell to avoid negative coordinates
		 */
		final Display display = control.getDisplay();
		final Shell shell = control.getShell();
		final Point p = display.map(control, shell, new Point(x, y));

		final GC gc = new GC(shell);
		final Image image = new Image(display, 1, 1);
		gc.copyArea(image, p.x, p.y);
		gc.dispose();

		final ImageData imageData = image.getImageData();
		final int actualPixel = imageData.getPixel(0, 0);

		final RGB actualRGB = imageData.palette.getRGB(actualPixel);
		image.dispose();
		if (!expectedRGB.equals(actualRGB)) {
			dumpPixels(control, x, y, 3, 3);
		}
		assertEquals(expectedRGB, actualRGB);
	}

	public static void dumpPixels(Control control, int x, int y, int width, int height) {
		/*
		 * Map to the shell to avoid negative coordinates
		 */
		final Display display = control.getDisplay();
		final Shell shell = control.getShell();

		final Point p = display.map(control, shell, new Point(x, y));
		final GC gc = new GC(shell);
		final Image image = new Image(display, width * 2 + 1, height * 2 + 1);
		gc.copyArea(image, p.x - width, p.y - height);

		final ImageData imageData = image.getImageData();

		for (int dx = -width; dx < width; dx++) {
			for (int dy = -height; dy < height; dy++) {
				final int actualPixel = imageData.getPixel(dx + width, dy + height);
				final RGB actualRGB = imageData.palette.getRGB(actualPixel);
				System.out.println("(" + dx + ";" + dy + "): " + actualRGB);
			}
		}
		image.dispose();

		gc.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
		gc.drawRectangle(x - width, y - height, 2 * width, 2 * height);
		gc.dispose();
		sleep(3000);
	}

	public static void assertPixelColorVerbose(Control control, int x, int y, RGB expectedRGB) {
		/*
		 * Map to the shell to avoid negative coordinates
		 */
		final Display display = control.getDisplay();
		final Shell shell = control.getShell();

		final Composite parent = control.getParent();
		final Point p2 = display.map(control, parent, x, y);
		final GC gc2 = new GC(parent);
		gc2.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
		gc2.drawRectangle(p2.x - 10, p2.y - 10, 21, 21);
		gc2.drawLine(p2.x - 10, p2.y, p2.x + 10, p2.y);
		gc2.drawLine(p2.x, p2.y - 10, p2.x, p2.y + 10);
		gc2.dispose();
		sleep(1003);
		for (int dx = -5; dx <= 5; dx++) {
			for (int dy = -5; dy <= 5; dy++) {
				final Point p = display.map(control, shell, new Point(x + dx, y + dx));

				final GC gc = new GC(shell);
				final Image image = new Image(display, 1, 1);
				gc.copyArea(image, p.x, p.y);
				gc.dispose();

				final ImageData imageData = image.getImageData();
				final int actualPixel = imageData.getPixel(0, 0);

				final RGB actualRGB = imageData.palette.getRGB(actualPixel);
				System.out.println("(" + dx + ";" + dy + "): " + actualRGB);
				image.dispose();
			}
		}
		System.out.println("ss");
		// assertEquals(expectedRGB, actualRGB);
	}
}
