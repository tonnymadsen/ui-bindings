package com.rcpcompany.uibindings;

import org.eclipse.swt.widgets.Control;

/**
 * This factory interface is used to create preferred {@link Control Controls} for {@link IValueBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IControlFactory {
	/**
	 * Creates and returns a new Control.
	 * 
	 * @param context TODO
	 * 
	 * @return the created control
	 */
	public Control create(IControlFactoryContext context);
}
