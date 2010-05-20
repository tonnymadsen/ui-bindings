package com.rcpcompany.uibindings.internal.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.SerializationException;
import org.eclipse.core.commands.common.CommandException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.ui.services.ISourceProviderService;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.sourceProviders.BindingSourceProvider;
import com.rcpcompany.utils.logging.LogUtils;

public class DoubleClickAdapter implements Listener, IDisposable {
	/**
	 * The viewer of this adapter
	 */
	protected final IViewerBinding myViewer;

	/**
	 * Creates a new adapter for the specified viewer
	 * 
	 * @param viewer the viewer
	 */
	public static void adapt(IViewerBinding viewer) {
		if (viewer.getService(DoubleClickAdapter.class) != null) {
			return;
		}
		new DoubleClickAdapter(viewer);
	}

	public DoubleClickAdapter(IViewerBinding viewer) {
		myViewer = viewer;
		myViewer.registerService(this);

		myViewer.getControl().addListener(SWT.MouseDoubleClick, this);
	}

	@Override
	public void dispose() {
		myViewer.deregisterService(this);
		myViewer.getControl().removeListener(SWT.MouseDoubleClick, this);
	}

	/**
	 * A map with all the known commands. Used to avoid de-serialization of the commands repeatably.
	 */
	protected Map<String, ParameterizedCommand> knownCommands = null;

	@Override
	public void handleEvent(Event event) {
		final IServiceLocator locator = myViewer.getContext().getServiceLocator();
		final IHandlerService hs = (IHandlerService) locator.getService(IHandlerService.class);

		final ISourceProviderService sourceProviders = (ISourceProviderService) locator
				.getService(ISourceProviderService.class);
		final BindingSourceProvider theBindingSourceProvider = (BindingSourceProvider) sourceProviders
				.getSourceProvider(Constants.SOURCES_ACTIVE_BINDING);

		/*
		 * First see if there are an open command associated with the specific column.
		 * 
		 * Can change the global state...
		 */
		final Map<String, Object> currentState = theBindingSourceProvider.reportSourceChanges(event);

		final Object b = currentState.get(Constants.SOURCES_ACTIVE_BINDING);
		if (!(b instanceof IValueBinding)) {
			return;
		}

		final IValueBinding binding = (IValueBinding) b;

		try {
			/*
			 * Get the command from the binding if present - otherwise from the viewer itself
			 */
			String cmd = binding.getArgument(Constants.ARG_DOUBLE_CLICK_COMMAND, String.class, null);
			if (cmd == null) {
				cmd = myViewer.getArgument(Constants.ARG_DOUBLE_CLICK_COMMAND, String.class, null);
			}
			if (cmd == null) {
				return;
			}

			/*
			 * Construct the pc...
			 */
			final ParameterizedCommand pc = getCommand(cmd);
			if (pc == null) {
				return;
			}

			/*
			 * Execute it... If sucessful, then mark the event.
			 */
			hs.executeCommand(pc, event);
			event.doit = false;
		} catch (final CommandException ex) {
			LogUtils.error(this, ex);
		}
	}

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
	protected ParameterizedCommand getCommand(String c) {
		if (knownCommands == null) {
			knownCommands = new HashMap<String, ParameterizedCommand>();
		}
		ParameterizedCommand pc = knownCommands.get(c);
		final IServiceLocator locator = myViewer.getContext().getServiceLocator();
		final ICommandService cs = (ICommandService) locator.getService(ICommandService.class);
		if (pc == null) {
			try {
				pc = cs.deserialize(c);
			} catch (final NotDefinedException ex) {
				LogUtils.error(this, ex);
			} catch (final SerializationException ex) {
				LogUtils.error(this, ex);
			}
			knownCommands.put(c, pc);
		}
		return pc;
	}
};
