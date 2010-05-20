package com.rcpcompany.uibindings.utils;

import org.eclipse.core.commands.SerializationException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ISetSelectionTarget;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.utils.GlobalNavigationManager;
import com.rcpcompany.uibindings.internal.utils.MouseDownConverter;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * The global navigation manager.
 * <p>
 * Keeps track of a global stack of navigation locations on a per workbench window basis. Methods exists to add new
 * locations to the stack and to navigate backward and forward in the stack.
 * <p>
 * The navigation history is only kept if {@link Factory#createManager(IWorkbenchWindow)} is called.
 * <p>
 * To navigate in the stack use either the {@link #backwardHistory()} and {@link #forwardHistory()} methods or the
 * corresponding handlers {@link BackwardHistoryHandler} and {@link ForwardHistoryHandler}.
 * 
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IGlobalNavigationManager extends IDisposable {
	/**
	 * The factory methods for {@link IFormCreator}.
	 */
	public static final class Factory {
		/**
		 * Creates and installs a new navigation manager.
		 * 
		 * @param window the workbench window for the manager
		 * 
		 * @return the created manager
		 */
		public static IGlobalNavigationManager createManager(IWorkbenchWindow window) {
			return GlobalNavigationManager.getManager(window, true);
		}

		/**
		 * Returns the navigation manager if created - other <code>null</code>.
		 * 
		 * @param window the workbench window for the manager
		 * 
		 * @return the created manager or <code>null</code>
		 */
		public static IGlobalNavigationManager getManager(IWorkbenchWindow window) {
			return GlobalNavigationManager.getManager(window, false);
		}

		/**
		 * Adds a new new location to the stack of locations managed by the navigation manager.
		 * <p>
		 * Effectively an NOP if the navigation manager has not been created.
		 */
		public static void addLocation() {
			final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			final IGlobalNavigationManager manager = getManager(window);
			if (manager == null) {
				return;
			}
			manager.addLocation();
		}

		/**
		 * Installs a SWT listener that will convert Mouse 4 and 5 to specific commands
		 * 
		 * @param backwardCommand the serialized backward command
		 * @param forwardCommand the serialized forward command
		 * @throws SerializationException
		 * @throws NotDefinedException
		 */
		public static void installMouseHandling(String backwardCommand, String forwardCommand)
				throws NotDefinedException, SerializationException {
			new MouseDownConverter(4, SWT.NONE, backwardCommand);
			new MouseDownConverter(5, SWT.NONE, forwardCommand);
		}

		/**
		 * Installs a SWT listener that will convert Mouse 4 and 5 to the usual backward and forward history commands
		 */
		public static void installMouseHandling() {
			try {
				IGlobalNavigationManager.Factory.installMouseHandling("org.eclipse.ui.navigate.backwardHistory",
						"org.eclipse.ui.navigate.forwardHistory");
			} catch (final Exception ex) {
				LogUtils.error(Activator.ID, ex);
			}
		}
	}

	/**
	 * Interface used by views that want to notified on history changes using {@link ISetSelectionTarget}.
	 * <p>
	 * If a view implements this interface, the navigator will query the view for its current view selection and save
	 * the location in the location record. When the location record is later shown the save selection is reset using
	 * {@link ISetSelectionTarget#selectReveal(ISelection)}.
	 */
	public interface IGetSelectionTarget {
		/**
		 * Returns the current selection for the view.
		 * 
		 * @return the selection
		 */
		public ISelection getCurrentSelection();
	}

	/**
	 * The forwardHistory handler
	 */
	public class ForwardHistoryHandler extends GlobalNavigationManager.ForwardHandler {

	};

	/**
	 * The backwardHistory handler
	 */
	public static class BackwardHistoryHandler extends GlobalNavigationManager.BackwardHandler {

	};

	/**
	 * Menu item contributor for the backward history menu.
	 */
	public static class BackwardHistoryMenuContributor extends GlobalNavigationManager.BackwardHistoryMenuContributor {

	};

	/**
	 * Menu item contributor for the forward history menu.
	 */
	public static class ForwardHistoryMenuContributor extends GlobalNavigationManager.ForwardHistoryMenuContributor {

	};

	/**
	 * Adds a new location to the current position of the location stack.
	 * <p>
	 * Any following locations are removed from the stack.
	 */
	public void addLocation();

	/**
	 * Moves forward in the history if possible.
	 */
	public void forwardHistory();

	/**
	 * Moves backward in the history if possible.
	 */
	public void backwardHistory();

	/**
	 * Returns the number of kept locations in the navigation manager
	 * 
	 * @return the number of locations
	 */
	int getNoKeptLocations();

	/**
	 * Sets the number of kept locations in the navigation manager
	 * 
	 * @param noKeptLocations the number of locations
	 */
	void setNoKeptLocations(int noKeptLocations);

	/**
	 * Updates the current position based on the last reported binding
	 */
	void updateLocation();
}
