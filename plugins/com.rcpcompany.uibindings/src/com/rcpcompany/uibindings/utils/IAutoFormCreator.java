package com.rcpcompany.uibindings.utils;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewPart;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.internal.utils.AutoFormCreator;

/**
 * This utility class is used to create complete forms based on the structure of data.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IAutoFormCreator extends IDisposable {
	/**
	 * The factory methods for {@link IAutoFormCreator}.
	 */
	public static final class Factory {
		private Factory() {
		}

		/**
		 * Creates a new super form with the specified parent.
		 * 
		 * @param context the binding context to use
		 * @param obj the current object
		 * @param toolkit the {@link FormToolkit} to use
		 * @param parent the parent composite of the new form
		 * @return the created form creator
		 */
		// public static IAutoFormCreator createForm(IBindingContext context, EObject obj,
		// FormToolkit toolkit,
		// Composite parent) {
		// return new AutoFormCreator(context, obj, toolkit, parent, null);
		// }

		/**
		 * Creates a new form with the specified parent.
		 * 
		 * @param parent
		 * 
		 * @return the created form creator
		 */
		public static IAutoFormCreator createForm(IObservableValue value, String title, Composite parent, IViewPart part) {
			return new AutoFormCreator(value, title, parent, part);
		}

		/**
		 * Creates a new form with the specified parent.
		 * 
		 * @param parent the parent composite of the new form
		 * @return the created form creator
		 */
		// public static ISuperFormCreator createForm(EObject obj, IWizardPage page) {
		// }
	}

	/**
	 * The form creator used for the creation of the underlying form.
	 * 
	 * @return form creator
	 */
	public IFormCreator getForm();
}
