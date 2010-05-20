package com.rcpcompany.uibindings;

import org.eclipse.swt.widgets.Composite;

/**
 * Context interface for {@link IControlFactory#create(IControlFactoryContext)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IControlFactoryContext {

	/**
	 * Returns the binding for wehich the control must be created
	 * 
	 * @return the binding
	 */
	public IValueBinding getBinding();

	/**
	 * Returns the parent composite of the new control.
	 * 
	 * @return the parent composite
	 */
	public Composite getParent();

	/**
	 * Returns the SWT style arguments for the new control
	 * 
	 * @return the style
	 */
	public int getStyle();
}
