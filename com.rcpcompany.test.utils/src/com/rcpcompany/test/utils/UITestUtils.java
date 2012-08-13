package com.rcpcompany.test.utils;

/*******************************************************************************
 * Copyright (c) 2006-2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/

import static org.junit.Assert.*;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IExecutionListener;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.NotHandledException;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.services.IServiceLocator;

import com.rcpcompany.utils.basic.ToStringUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Base class for all tests.
 * <p>
 * Provides a number of convenience methods...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UITestUtils {
	private UITestUtils() {
	}

	/**
	 * Resets the complete test environment.
	 */
	public static void resetUI() {
		final Shell shell = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell();
		Event e = new Event();
		e.type = SWT.KeyUp;
		e.keyCode = SWT.SHIFT;
		e.stateMask = 0;
		e.widget = shell;

		shell.getDisplay().post(e);

		e = new Event();
		e.type = SWT.KeyUp;
		e.keyCode = SWT.CTRL;
		e.stateMask = 0;
		e.widget = shell;

		shell.getDisplay().post(e);

		e = new Event();
		e.type = SWT.KeyUp;
		e.keyCode = SWT.ALT;
		e.stateMask = 0;
		e.widget = shell;

		shell.getDisplay().post(e);
	}

	private static int testViewSeq = 0;

	/**
	 * Opens and returns a new test view.
	 * 
	 * @param creatingObject
	 *            the object of the caller - used to name the new view
	 * 
	 * @return the new view
	 */
	public static TestView createTestView(Object creatingObject) {
		TestView view = null;
		try {
			final IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
			view = (TestView) page.showView(
					"com.agetor.wb.tests.utils.TestView", "" + (testViewSeq++),
					IWorkbenchPage.VIEW_ACTIVATE);
			assertNotNull(view);
			view.setPartName("Test View: "
					+ creatingObject.getClass().getSimpleName());
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
		view.getSite().getPage().activate(view);
		return view;
	}

	/**
	 * Opens and returns the view with the specified ID
	 * 
	 * @param viewID
	 *            the view id
	 * 
	 * @return the new view
	 */
	public static IViewPart showView(String viewID) {
		IViewPart view = null;
		try {
			final IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
			view = page.showView(viewID, null, IWorkbenchPage.VIEW_ACTIVATE);
			assertNotNull(view);
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
		view.getSite().getPage().activate(view);
		return view;
	}

	/**
	 * Sleeps for the specified number of msec.
	 * 
	 * @param msec
	 *            the length
	 */
	public static void sleep(int msec) {
		cont = false;
		DISPLAY.timerExec(msec, new Runnable() {
			@Override
			public void run() {
				cont = true;
			}
		});
		while (!cont) {
			if (!DISPLAY.readAndDispatch()) {
				DISPLAY.sleep();
			}
		}
	}

	public static void yield() {
		while (DISPLAY.readAndDispatch()) {
			// Do nothing
		}
	}

	/**
	 * Posts the characters of the string one by one to the specified control.
	 * 
	 * @param c
	 *            the control
	 * @param s
	 *            the string
	 */
	public static void postString(Control c, String s) {
		for (int i = 0; i < s.length(); i++) {
			postKeyStroke(c, s.substring(i, i + 1));
		}
	}

	/**
	 * Posts the specified keystroke to the specified control which will get
	 * focus.
	 * 
	 * @param c
	 *            the control
	 * @param stroke
	 *            the text representation of the key-stroke
	 */
	public static void postKeyStroke(Control c, String stroke) {
		assertNotNull(c);
		assertFalse(c.isDisposed());

		KeyStroke keyStroke = null;
		try {
			keyStroke = KeyStroke.getInstance(stroke);
		} catch (final ParseException ex) {
			fail(stroke + ": " + ex.getMessage());
			return;
		}
		assertTrue(stroke + ": not complete", keyStroke.isComplete());
		// LogUtils.debug(c, stroke + " --> " + keyStroke);

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

		assertTrue(stroke + ": post KeyDown", c.getDisplay().post(event));

		event = new Event();
		event.type = SWT.KeyUp;
		event.stateMask = keyStroke.getModifierKeys();
		event.keyCode = keyStroke.getNaturalKey();
		event.character = (char) event.keyCode;
		event.widget = c;

		// System.out.println("e:: " + ToStringUtils.toString(event));

		assertTrue(stroke + ": post KeyUp", c.getDisplay().post(event));

		postModifierKeys(c, keyStroke, false);

		yield();
	}

	/**
	 * Posts a set of modifiers (shift, control, etc) to the specified control.
	 * 
	 * @param c
	 *            the {@link Control}
	 * @param keyStroke
	 *            the key stroke
	 * @param down
	 *            <code>true</code> for keyDown and <code>false</code> for keyUp
	 */
	public static void postModifierKeys(Control c, KeyStroke keyStroke,
			boolean down) {
		if ((keyStroke.getModifierKeys() & SWT.COMMAND) == SWT.COMMAND) {
			final Event event = new Event();
			event.type = down ? SWT.KeyDown : SWT.KeyUp;
			event.stateMask = 0;
			event.keyCode = SWT.COMMAND;
			event.widget = c;

			assertTrue(c.getDisplay().post(event));
		}
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
	 * Posts the specified keystroke to the specified control which will get
	 * focus.
	 * 
	 * @param c
	 *            the control
	 * @param stroke
	 *            the text representation of the key-stroke
	 * @param locator
	 *            service locator used to find all relevant services
	 * @param handlerClass
	 *            the expected handler class
	 */
	public static void postKeyStroke(Control c, final String stroke,
			IServiceLocator locator,
			final Class<? extends IHandler> handlerClass) {
		final ICommandService cs = (ICommandService) locator
				.getService(ICommandService.class);
		final boolean[] executed = new boolean[]{false};
		final IExecutionListener listener = new IExecutionListener() {
			@Override
			public void preExecute(String commandId, ExecutionEvent event) {
				final IHandler handler = event.getCommand().getHandler();
				assertNotNull("No handler active for "
						+ event.getCommand().getId(), handler);
				String hName = handler.toString();
				if (hName.indexOf('@') >= 0) {
					hName = hName.substring(0, hName.indexOf('@'));
				}
				// Class<? extends IHandler> hc = handler.getClass();
				// if (hc == HandlerProxy.class) {
				// hc = ((HandlerProxy) handler).getClass();
				// }
				assertEquals("Stroke '" + stroke + "' command '" + commandId
						+ "'", handlerClass.getName(), hName);
				executed[0] = true;
			}

			@Override
			public void postExecuteSuccess(String commandId, Object returnValue) {
				// Nothing...
			}

			@Override
			public void postExecuteFailure(String commandId,
					ExecutionException exception) {
				fail(exception.getMessage());
			}

			@Override
			public void notHandled(String commandId,
					NotHandledException exception) {
				fail(exception.getMessage());
			}
		};
		cs.addExecutionListener(listener);
		postKeyStroke(c, stroke);
		cs.removeExecutionListener(listener);
		assertTrue("Stroke '" + stroke + "' has not been executed", executed[0]);
	}

	/**
	 * Posts a mouse event for the specified control and point.
	 * 
	 * @param c
	 *            the control
	 * @param p
	 *            the point
	 */
	public static void postMouse(Control c, Point p) {
		postMouse(c, p, 1);
	}

	/**
	 * Posts a mouse event for the specified control and point.
	 * 
	 * @param c
	 *            the control
	 */
	public static void postMouse(Control c) {
		final Rectangle bounds = c.getBounds();
		bounds.x = 0;
		bounds.y = 0;
		postMouse(c, bounds, 1);
	}

	/**
	 * Posts a mouse event for the specified control and point.
	 * 
	 * @param c
	 *            the control
	 * @param p
	 *            the point
	 * @param noClicks
	 *            the number of clicks
	 */
	public static void postMouse(Control c, Point p, int noClicks) {
		postMouse(null, c, p, noClicks);
	}

	private static long lastMouseOperationExpireTime = 0;

	/**
	 * Posts a mouse move event for the specified control and point.
	 * 
	 * @param c
	 *            the control
	 * @param p
	 *            the point in the control
	 */
	public static void postMouseMove(Control c, Point p) {
		final Point pt = c.getDisplay().map(c, null, p);

		final long now = System.currentTimeMillis();

		if (lastMouseOperationExpireTime > now) {
			sleep((int) (lastMouseOperationExpireTime - now));
		}

		final Event e = new Event();
		e.type = SWT.MouseMove;
		e.x = pt.x;
		e.y = pt.y;
		assertTrue(c.getDisplay().post(e));
		yield();

		lastMouseOperationExpireTime = now
				+ c.getDisplay().getDoubleClickTime() + 50;
	}

	/**
	 * Posts a mouse event for the specified control and point.
	 * 
	 * @param modifiers
	 *            a key stroke specification - only the modifier part is used
	 * @param button
	 *            the pressed button
	 * @param c
	 *            the control
	 * @param noClicks
	 *            the number of clicks
	 * @param p
	 *            the point
	 */
	public static void postMouseDown(String modifiers, int button,
			final Control c, int noClicks) {
		final long now = System.currentTimeMillis();

		if (lastMouseOperationExpireTime > now) {
			sleep((int) (lastMouseOperationExpireTime - now));
		}

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
			assertTrue(c.getDisplay().post(e));
			// yield();

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

		lastMouseOperationExpireTime = now
				+ c.getDisplay().getDoubleClickTime() + 50;
	}

	/**
	 * Posts a mouse event for the specified control and point.
	 * 
	 * @param modifiers
	 *            a key stroke specification - only the modifier part is used
	 * @param c
	 *            the control
	 * @param p
	 *            the point
	 * @param noClicks
	 *            the number of clicks
	 */
	public static void postMouse(String modifiers, Control c, Point p,
			int noClicks) {
		postMouseMove(c, p);
		postMouseDown(modifiers, 1, c, noClicks);
	}

	/**
	 * Posts a mouse event for the specified control and point.
	 * 
	 * @param c
	 *            the control
	 * @param bounds
	 *            the bound of the area to click
	 */
	public static void postMouse(Control c, Rectangle bounds) {
		postMouse(c, bounds, 1);
	}

	/**
	 * Posts a mouse event for the specified control and point
	 * 
	 * @param c
	 *            the control
	 * @param bounds
	 *            the bound of the area to click
	 */
	public static void postMouseMove(Control c, Rectangle bounds) {
		postMouseMove(c, new Point(bounds.x + bounds.width / 2, bounds.y
				+ bounds.height / 2));
	}

	/**
	 * Posts a mouse event for the specified table cell.
	 * 
	 * @param t
	 *            the table
	 * @param column
	 *            the column number
	 * @param row
	 *            the row number
	 */
	public static void postMouse(Table t, int column, int row) {
		postMouse(t, t.getItem(row).getBounds(column), 1);
	}

	/**
	 * Posts a mouse event for the specified control and point.
	 * 
	 * @param t
	 *            the table
	 * @param column
	 *            the column number
	 * @param row
	 *            the row number
	 */
	public static void postMouseMove(Table t, int column, int row) {
		postMouseMove(t, t.getItem(row).getBounds(column));
	}

	/**
	 * Posts a mouse event for the specified control and point
	 * 
	 * @param t
	 *            the table
	 * @param column
	 *            the column number
	 * @param row
	 *            the row number
	 * @param noClicks
	 *            the number of clicks
	 */
	public static void postMouse(Table t, int column, int row, int noClicks) {
		postMouse(t, t.getItem(row).getBounds(column), noClicks);
	}

	/**
	 * Posts a mouse event for the specified control and point.
	 * 
	 * @param t
	 *            the table
	 * @param column
	 *            the column number
	 * @param row
	 *            the row number
	 * @param noClicks
	 *            the number of clicks
	 */
	public static void postMouse(String modifiers, Table t, int column,
			int row, int noClicks) {
		postMouse(modifiers, t, t.getItem(row).getBounds(column), noClicks);
	}

	/**
	 * Posts a mouse event for the specified control and point.
	 * 
	 * @param c
	 *            the control
	 * @param bounds
	 *            the bound of the area to click
	 * @param noClicks
	 *            the number of clicks
	 */
	public static void postMouse(Control c, Rectangle bounds, int noClicks) {
		postMouse(null, c, new Point(bounds.x + bounds.width / 2, bounds.y
				+ bounds.height / 2), noClicks);
	}

	/**
	 * Posts a mouse event for the specified control and point.
	 * 
	 * @param c
	 *            the control
	 * @param bounds
	 *            the bound of the area to click
	 * @param noClicks
	 *            the number of clicks
	 */
	public static void postMouse(String modifiers, Control c, Rectangle bounds,
			int noClicks) {
		postMouse(modifiers, c, new Point(bounds.x + bounds.width / 2, bounds.y
				+ bounds.height / 2), noClicks);
	}

	protected static boolean cont = false;
	private static final Display DISPLAY = Display.getDefault();

	public final static Listener SWT_EVENT_LISTENER = new Listener() {
		@Override
		public void handleEvent(Event event) {
			LogUtils.debug(this, ToStringUtils.toString(event));
		}
	};

	/**
	 * Runs the specified {@link Runnable} while debugging the SWT events.
	 * 
	 * @param runnable
	 *            the {@link Runnable} to run
	 */
	public static void swtListen(Runnable runnable) {
		for (int i = SWT.None; i < SWT.ImeComposition; i++) {
			Display.getCurrent().addFilter(i, SWT_EVENT_LISTENER);
		}
		BaseTestUtils.assertNoLog(runnable);
		for (int i = SWT.None; i < SWT.ImeComposition; i++) {
			Display.getCurrent().removeFilter(i, SWT_EVENT_LISTENER);
		}
	}

	/**
	 * Tests that the pixel of the specified control have the specified RGB
	 * value.
	 * 
	 * @param control
	 *            the control
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param expectedRGB
	 *            the expected color
	 */
	public static void assertPixelColor(String what, Control control, int x,
			int y, RGB expectedRGB) {
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
			dumpPixels(control, x, y, 3, 3, expectedRGB);
		}
		assertEquals(what, expectedRGB, actualRGB);
	}

	public static void dumpPixels(Control control, final int x, final int y,
			final int width, final int height, RGB expectedRGB) {
		/*
		 * Map to the shell to avoid negative coordinates
		 */
		final Display display = control.getDisplay();
		final Shell shell = control.getShell();
		final StringBuilder sb = new StringBuilder(400);

		if (expectedRGB != null) {
			sb.append("Expected " + expectedRGB);
		}

		final Point p = display.map(control, shell, new Point(x - width, y
				- height));
		final GC gc = new GC(shell);
		final Image image = new Image(display, width * 2 + 1, height * 2 + 1);
		gc.copyArea(image, p.x - width, p.y - height);

		final ImageData imageData = image.getImageData();

		for (int dx = -width; dx < width; dx++) {
			for (int dy = -height; dy < height; dy++) {
				final int actualPixel = imageData.getPixel(dx + width, dy
						+ height);
				final RGB actualRGB = imageData.palette.getRGB(actualPixel);
				sb.append("\n(" + dx + ";" + dy + "): " + actualRGB);
			}
		}
		image.dispose();
		gc.dispose();

		// IPaintDecoration.Factory.paintRectangle(control, new Rectangle(x -
		// width, y - height,
		// width * 2, height * 2),
		// display.getSystemColor(SWT.COLOR_RED));

		yield();
		LogUtils.debug(sb, sb.toString());
		sleep(500);
	}

	public static void assertPixelColorVerbose(Control control, int x, int y,
			RGB expectedRGB) {
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
				final Point p = display.map(control, shell, new Point(x + dx, y
						+ dx));

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
		// assertEquals(expectedRGB, actualRGB);
	}

	/**
	 * Waits until the Workbench have been fully loaded and a workbench window
	 * is active.
	 */
	public static void waitForWorkbench() {
		final IWorkbench workbench = PlatformUI.getWorkbench();

		while (workbench.getActiveWorkbenchWindow() == null) {
			sleep(100);
		}
	}
}
