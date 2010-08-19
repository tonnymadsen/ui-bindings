package com.rcpcompany.uibindings.utils;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import com.rcpcompany.uibindings.IBindingContext;

/**
 * This interface is used by {@link IFormChooser} to create new forms.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IFormChooserCreator {
	/**
	 * Creates a new form with the specified parent.
	 * 
	 * @param context the binding context
	 * @param discriminant the discriminant
	 * @param parent the parent composite - with a {@link FillLayout}
	 */
	void createForm(IBindingContext context, IObservableValue discriminant, Composite parent);
}
