package com.rcpcompany.uibindings.internal.decorators.extenders;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.SerializationException;
import org.eclipse.core.commands.common.CommandException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.ui.services.ISourceProviderService;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.ISourceProviderStateContext;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.decorators.extenders.OpenCommandSupport.ContextData;
import com.rcpcompany.uibindings.internal.decorators.extenders.OpenCommandSupport.Extender;
import com.rcpcompany.uibindings.internal.decorators.extenders.OpenCommandSupport.ManagerData;
import com.rcpcompany.uibindings.internal.decorators.extenders.OpenCommandSupport.OpenHandler;
import com.rcpcompany.uibindings.internal.sourceProviders.BindingSourceProvider;
import com.rcpcompany.utils.basic.ToStringUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * This support class provides the open command functionality. It is divided into a number of static
 * sub-classes:
 * <ul>
 * <li>{@link ManagerData} have the singleton functionality. E.g. it routes the events to the
 * appropriate <code>ContextData</code>.</li>
 * <li>{@link ContextData} deserializes the commands into {@link ParameterizedCommand}. The
 * <code>ContextData</code> part is kept aside from the <code>ManagerData</code> to allow for
 * separate {@link ICommandService} and {@link IHandlerService}.</li>
 * <li>{@link Extender} handles the specific extender functionality.</li>
 * <li>{@link OpenHandler} provides the handler implementation for the Open Command.</li>
 * </ul>
 * <p>
 * The support has been programmed to avoid too many listeners.
 * <p>
 * <em>NOTE:</em> Most methods and variables have default visibility for testing purposes.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class OpenCommandSupport {
	/**
	 * Data associated with the manager.
	 */
	protected static class ManagerData implements IDisposable {
		/**
		 * The singleton manager data.
		 */
		/* package */static ManagerData theData;

		/**
		 * Returns the singleton manager data.
		 * 
		 * @return the singleton
		 */
		public static ManagerData getData() {
			if (theData == null) {
				theData = new ManagerData();
			}
			return theData;
		}

		/**
		 * Constructs and registers a new support object.
		 */
		public ManagerData() {
			final IManager manager = IManager.Factory.getManager();
			manager.registerService(this);

			final ISourceProviderService sourceProviders = (ISourceProviderService) PlatformUI.getWorkbench()
					.getService(ISourceProviderService.class);
			theBindingSourceProvider = (BindingSourceProvider) sourceProviders
					.getSourceProvider(Constants.SOURCES_ACTIVE_BINDING);

			Display.getCurrent().addFilter(SWT.KeyDown, theStartListener);
			Display.getCurrent().addFilter(SWT.KeyUp, theStartListener);
			Display.getCurrent().addFilter(SWT.MouseEnter, theStartListener);
		}

		@Override
		public void dispose() {
			final IManager manager = IManager.Factory.getManager();
			manager.unregisterService(this);

			/*
			 * Remove all listeners
			 */
			handleStartEvent(null);
			Display.getCurrent().removeFilter(SWT.KeyDown, theStartListener);
			Display.getCurrent().removeFilter(SWT.KeyUp, theStartListener);
			Display.getCurrent().removeFilter(SWT.MouseEnter, theStartListener);
		}

		/**
		 * Listener used to start a new hover. Always registered.
		 * <p>
		 * {@link SWT#MouseEnter} is registered in case CTRL is pressed outside the application.
		 */
		private final Listener theStartListener = new Listener() {
			@Override
			public void handleEvent(Event event) {
				handleStartEvent(event);
			}
		};

		/* package */boolean isHoverListenerInstalled = false;

		/**
		 * Handles the start event.
		 * 
		 * @param event the event itself
		 */
		private void handleStartEvent(Event event) {
			boolean hoverWanted = false;
			if (event != null) {
				switch (event.type) {
				case SWT.MouseEnter:
					hoverWanted = event.stateMask == SWT.CTRL;
					break;
				case SWT.KeyDown:
					hoverWanted = (event.stateMask == SWT.NONE && event.keyCode == SWT.CTRL)
							|| event.stateMask == SWT.CTRL;
					break;
				case SWT.KeyUp:
					hoverWanted = event.stateMask == SWT.CTRL && event.keyCode != SWT.CTRL;
					break;
				default:
					LogUtils.error(this, "Unknown event ignored: " + ToStringUtils.toString(event));
					return;
				}
			}
			// LogUtils.debug(this, "hoverWanted=" + hoverWanted + "\n" +
			// ToStringUtils.toString(event));
			if (hoverWanted == isHoverListenerInstalled) return;
			isHoverListenerInstalled = hoverWanted;
			if (Activator.getDefault().TRACE_OPEN_COMMAND && Activator.getDefault().TRACE_EVENTS_SWT) {
				LogUtils.debug(this, ToStringUtils.toString(event));
			}

			final Display display = Display.getCurrent();
			if (hoverWanted) {
				display.addFilter(SWT.MouseDown, theHoverListener);
				display.addFilter(SWT.MouseMove, theHoverListener);
				display.addFilter(SWT.MouseHover, theHoverListener);
				display.addFilter(SWT.MouseExit, theHoverListener);

				/*
				 * To start the hovering immediately, we have to create am (artificial) event with
				 * the correct widget
				 */
				final Control cursorControl = display.getCursorControl();
				if (cursorControl != null) {
					final Point cursorLocation = cursorControl.toControl(display.getCursorLocation());

					final Event e = new Event();
					e.type = SWT.MouseMove;
					e.widget = cursorControl;
					e.x = cursorLocation.x;
					e.y = cursorLocation.y;
					e.stateMask = event.stateMask;
					handleHoverEvent(e);
				}
			} else {
				display.removeFilter(SWT.MouseDown, theHoverListener);
				display.removeFilter(SWT.MouseMove, theHoverListener);
				display.removeFilter(SWT.MouseHover, theHoverListener);
				display.removeFilter(SWT.MouseExit, theHoverListener);

				setOpenBinding(null, false);
			}
		}

		/**
		 * Listener used to color the binding and handle the click itself.
		 * <p>
		 * Only installed when CTRL is pressed.
		 */
		private final Listener theHoverListener = new Listener() {
			@Override
			public void handleEvent(Event event) {
				handleHoverEvent(event);
			}
		};

		/**
		 * Handles the hover event.
		 * 
		 * @param event the event itself
		 */
		protected void handleHoverEvent(Event event) {
			if (Activator.getDefault().TRACE_OPEN_COMMAND && Activator.getDefault().TRACE_EVENTS_SWT) {
				LogUtils.debug(this, ToStringUtils.toString(event));
			}
			final Map<String, Object> currentState = theBindingSourceProvider.getCurrentState(event);
			final ParameterizedCommand pc = getCommand(event, currentState);

			if (pc == null) {
				setOpenBinding(null, false);
				return;
			}
			final IValueBinding binding = (IValueBinding) currentState.get(Constants.SOURCES_ACTIVE_BINDING);

			setOpenBinding(binding, true);

			if (event.type == SWT.MouseDown && event.button == 1) {
				try {
					final ContextData cd = ContextData.getData(binding);
					cd.executeCommand(pc, event);
					event.doit = false;
				} catch (final CommandException ex) {
					LogUtils.error(this, ex);
				}
			}
		}

		/**
		 * The source provider - used to get the current state.
		 */
		private final BindingSourceProvider theBindingSourceProvider;

		/**
		 * Returns the "open" command for the specified event.
		 * <p>
		 * The returned command is in handled stated.
		 * 
		 * @param event the event
		 * @param currentState the current state or <code>null</code> if the source provider should
		 *            be consulted
		 * @return the corresponding parameterized command or <code>null</code>
		 */
		protected ParameterizedCommand getCommand(Event event, Map<String, Object> currentState) {
			if (Activator.getDefault().TRACE_OPEN_COMMAND && Activator.getDefault().TRACE_EVENTS_SWT) {
				LogUtils.debug(this, ToStringUtils.toString(event));
			}
			ParameterizedCommand pc = null;

			/*
			 * First see if there are an open command associated with the specific column
			 */
			final Object object = currentState.get(Constants.SOURCES_ACTIVE_BINDING);
			if (!(object instanceof IValueBinding)) return null;
			final IValueBinding binding = (IValueBinding) object;
			final Object value = currentState.get(Constants.SOURCES_ACTIVE_BINDING_VALUE);

			if (value == null) return null;

			final ContextData cd = ContextData.getData(binding);

			final String c = binding.getArgument(Constants.ARG_OPEN_COMMAND, String.class, null);
			if (c != null) {
				pc = cd.getCommand(c);
				if (pc != null && pc.getCommand().isHandled()) return pc;
			}

			/*
			 * when see if the default open command is handled
			 */
			if (pc == null) {
				pc = cd.getCommand(Constants.DEFAULT_OPEN_COMMAND);
				if (pc != null && pc.getCommand().isHandled()) return pc;
			}

			return null;
		}

		/**
		 * @see IUIBindingDecoratorExtender#updateSourceProviderState(IValueBinding,
		 *      ISourceProviderStateContext)
		 */
		protected void updateSourceProviderState(IValueBinding binding, ISourceProviderStateContext context) {
			if (Activator.getDefault().TRACE_OPEN_COMMAND) {
				LogUtils.debug(this, "binding=" + binding);
			}

			final Event event = context.getEvent();
			if (event == null) return;

			final ParameterizedCommand pc = getCommand(event, context.getState());
			if (pc == null) return;
			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_OPEN_COMMAND, pc);
		}

		/**
		 * The hand cursor shared by all instances.
		 */
		private final Cursor myHandCursor = Display.getDefault().getSystemCursor(SWT.CURSOR_HAND);

		/**
		 * The binding that is currently "open" or active.
		 */
		private IValueBinding myOpenBinding = null;

		/**
		 * Whether the open command associated with the {@link #myOpenBinding} should be
		 * "displayed".
		 */
		private boolean myShowOpenCommand = false;

		// @Override
		// public boolean isEnabled(IValueBinding binding) {
		// return binding == myOpenBinding;
		// }

		/**
		 * @see IUIBindingDecoratorExtender#extend(IUIBindingDecoratorExtenderContext)
		 */
		protected void extend(IUIBindingDecoratorExtenderContext context) {
			// LogUtils.debug(this, "binding=" + context.getBinding() + ": ext=" +
			// (context.getBinding() == myOpenBinding && myShowOpenCommand));
			if (context.getBinding() != myOpenBinding || !myShowOpenCommand) return;
			final Color color = JFaceColors.getActiveHyperlinkText(Display.getCurrent());
			context.setForegound(color);
			context.setCursor(myHandCursor);

			final Object value = context.getDecoratedValue().getValue();
			if (value instanceof String) {
				final StyleRange range = new StyleRange();
				range.start = 0;
				range.length = ((String) value).length();
				range.foreground = color;
				range.underline = true;
				context.addStyleRange(range);
			}
		}

		/**
		 * Sets the current active binding.
		 * 
		 * @param binding the new active binding or <code>null</code>
		 * @param show TODO
		 */
		protected void setOpenBinding(IValueBinding binding, boolean show) {
			/*
			 * No change ==> just ignore...
			 */
			if (myOpenBinding == binding && myShowOpenCommand == show) return;
			if (Activator.getDefault().TRACE_OPEN_COMMAND) {
				LogUtils.debug(this, "changed from\n(" + myOpenBinding + ", " + myShowOpenCommand + ") ->\n(" + binding
						+ ", " + show + ")");
			}

			/*
			 * Update if needed
			 */
			final IValueBinding oldBinding = myOpenBinding;
			final boolean oldShow = myShowOpenCommand;
			myOpenBinding = binding;
			myShowOpenCommand = show;

			if (oldBinding != null && oldShow) {
				oldBinding.updateBinding();
			}
			if (myOpenBinding != null && myShowOpenCommand) {
				myOpenBinding.updateBinding();
			}
		}
	}

	/**
	 * Context data for a single context.
	 * <p>
	 * Uses the {@link IBindingContext#getServiceLocator()} and therefore per context.
	 * <p>
	 * Basically updates myOpenBinding as needed.
	 */
	protected static class ContextData {
		/**
		 * Returns the context data associated with the context of the binding.
		 * 
		 * @param binding the binding
		 * @return the data for the binding
		 */
		public static ContextData getData(IValueBinding binding) {
			ContextData cd = binding.getContext().getService(ContextData.class);
			if (cd == null) {
				cd = new ContextData(binding.getContext());
			}
			return cd;
		}

		/**
		 * Constructs and returns a new open command adapter for the specified context.
		 * 
		 * @param context the context
		 */
		protected ContextData(IBindingContext context) {
			context.registerService(this);
			final IServiceLocator locator = context.getServiceLocator();
			myHandlerService = (IHandlerService) locator.getService(IHandlerService.class);
			myCommandServices = (ICommandService) locator.getService(ICommandService.class);
		}

		/**
		 * Executes the command using the {@link IHandlerService} of the context.
		 * 
		 * @param pc the command
		 * @param event the trigger event
		 * @throws ExecutionException
		 * @throws NotDefinedException
		 * @throws NotEnabledException
		 * @throws NotHandledException
		 */
		public void executeCommand(ParameterizedCommand pc, Event event) throws ExecutionException,
				NotDefinedException, NotEnabledException, NotHandledException {
			myHandlerService.executeCommand(pc, event);
		}

		/**
		 * The handler service.
		 * <p>
		 * Note that all context does not necessarily have the same service as they often are in
		 * different views and thus different service providers.
		 */
		private final IHandlerService myHandlerService;

		/**
		 * The command service
		 * <p>
		 * Note that all context does not necessarily have the same service as they often are in
		 * different views and thus different service providers.
		 */
		private final ICommandService myCommandServices;

		/**
		 * A map with all the known commands. Used to avoid de-serialization of the commands
		 * repeatably.
		 */
		private final Map<String, ParameterizedCommand> myCommands = new HashMap<String, ParameterizedCommand>();

		/**
		 * Deserializes the specified command and returns the corresponding parameterized command.
		 * <p>
		 * Caches the result.
		 * <p>
		 * Can return <code>null</code> if the command cannot be converted.
		 * 
		 * @param c the command in String form
		 * @return the parameterized command or <code>null</code>
		 */
		private ParameterizedCommand getCommand(String c) {
			ParameterizedCommand pc = myCommands.get(c);
			if (pc == null) {
				try {
					pc = myCommandServices.deserialize(c);
				} catch (final NotDefinedException ex) {
					LogUtils.error(this, ex);
				} catch (final SerializationException ex) {
					LogUtils.error(this, ex);
				}
				myCommands.put(c, pc);
			}
			return pc;
		}

	}

	/**
	 * Extender for OpenCommand.
	 */
	public static class Extender extends AbstractUIBindingDecoratorExtender implements IUIBindingDecoratorExtender {
		private final ManagerData myMD = ManagerData.getData();

		@Override
		public void extend(IUIBindingDecoratorExtenderContext context) {
			myMD.extend(context);
		}

		@Override
		public void updateSourceProviderState(IValueBinding binding, ISourceProviderStateContext context) {
			myMD.updateSourceProviderState(binding, context);
		}
	}

	/**
	 * Handler for OpenCommand.
	 */
	public static class OpenHandler extends AbstractHandler implements IHandler {
		private final ManagerData myService = ManagerData.getData();

		@Override
		public Object execute(ExecutionEvent event) throws ExecutionException {
			if (Activator.getDefault().TRACE_HANDLERS) {
				LogUtils.debug(this, "");
			}
			final Event triggerEvent = (Event) event.getTrigger();
			final IBindingContext context = (IBindingContext) HandlerUtil.getVariable(event,
					Constants.SOURCES_ACTIVE_CONTEXT);

			// final ContextMonitor monitor = context.getService(ContextMonitor.class);
			// if (monitor == null) {
			// return null;
			// }
			// final ParameterizedCommand pc = monitor.getCommand(triggerEvent, null);
			// if (pc == null) {
			// return null;
			// }

			final Object variable = HandlerUtil.getVariable(event, Constants.SOURCES_ACTIVE_BINDING_OPEN_COMMAND);
			if (!(variable instanceof ParameterizedCommand)) return null;

			final ParameterizedCommand pc = (ParameterizedCommand) variable;
			try {
				final IServiceLocator locator = context.getServiceLocator();
				final IHandlerService theHandlerService = (IHandlerService) locator.getService(IHandlerService.class);
				theHandlerService.executeCommand(pc, triggerEvent);
			} catch (final CommandException ex) {
				LogUtils.error(this, ex);
			}

			return null;
		}
	}
}
