package com.rcpcompany.uibindings.utils;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPartSite;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.internal.utils.BindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider.Factory;

/**
 * Selection provider for a binding context.
 * <p>
 * Added to the context with {@link Factory#adapt(IBindingContext, IWorkbenchPartSite)
 * IBindingContextSelectionProvider.Factory.adapt(IBindingContext, IWorkbenchPartSite)}. Additional
 * controls and viewers can be added with the different <code>add...(...)</code> methods in this
 * interface.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 *         TODO TEST
 */
public interface IBindingContextSelectionProvider extends IDisposable {
	/**
	 * Factory...
	 */
	public static final class Factory {
		private Factory() {
		}

		/**
		 * Adds menu along with the corresponding selection provider for the specified context.
		 * 
		 * @param context the context
		 * @param site the site
		 * @return the new selection provider
		 */
		public static IBindingContextSelectionProvider adapt(IBindingContext context, IWorkbenchPartSite site) {
			return BindingContextSelectionProvider.adapt(context, site);
		}
	}

	/**
	 * Adds the specified control with the specified selection provider.
	 * 
	 * @param control the control to add
	 * @param provider the selection provider used when the control has focus
	 */
	public void addControl(Control control, ISelectionProvider provider);

	/**
	 * Adds the specified control with the specified "constant" selection value
	 * 
	 * @param control the control to add
	 * @param selection the "constant" selection value to use
	 */
	public void addControl(Control control, IObservableValue selection);

	/**
	 * Removes the control from the list of controls managed by this manager
	 * 
	 * @param control the control to remove
	 */
	public void removeControl(Control control);

	/**
	 * Adds the specified viewer with its "natural" selection provider
	 * 
	 * @param viewer the viewer to add
	 */
	public void addViewer(Viewer viewer);
}
