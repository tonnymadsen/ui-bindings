package com.rcpcompany.uibindings.navigator;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;

/**
 * The context for {@link IEditorPartFactory#createEditorPart(IEditorPartContext)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IEditorPartContext {
	/**
	 * Returns the editor part descriptor for this editor part.
	 * 
	 * @return the descriptor
	 */
	IEditorPartDescriptor getDescriptor();

	/**
	 * Returns the parent composite for this editor part.
	 * <p>
	 * The composite has a {@link FillLayout}.
	 * 
	 * @return the parent
	 */
	Composite getParent();

	/**
	 * Returns the part for the editor.
	 * 
	 * @return the part
	 */
	IWorkbenchPart getWorkbenchPart();

	/**
	 * Returns the {@link IObservableValue} with the current value.
	 * <p>
	 * The editor part must monitor this for changes in the base object for the editor part.
	 * <p>
	 * The {@link IObservableValue#getValueType() value type} corresponds to the model type of the
	 * editors extension point for this editor part factory.
	 * 
	 * @return an observable value with the current base object
	 */
	IObservableValue getCurrentValue();
}
