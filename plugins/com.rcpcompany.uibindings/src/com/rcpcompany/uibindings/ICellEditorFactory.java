package com.rcpcompany.uibindings;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Control;

/**
 * This factory interface is used to create preferred {@link Control Controls} for
 * {@link IValueBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface ICellEditorFactory {
	/**
	 * Creates and returns a new {@link CellEditor cell editor}.
	 * 
	 * @param context the context for the creation.
	 * 
	 * @return the created editor
	 */
	public CellEditor create(ICellEditorFactoryContext context);
}
