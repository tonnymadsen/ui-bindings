package com.rcpcompany.uibindings;

import org.eclipse.swt.widgets.Composite;

/**
 * This context used when a {@link ICellEditorFactory} create a new cell editor.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface ICellEditorFactoryContext {
	/**
	 * Returns the cell information for the cell
	 * 
	 * @return the CI
	 */
	public IValueBindingCell getCell();

	/**
	 * Returns the {@link Composite} parent for the cell editor
	 * 
	 * @return the parent
	 */
	public Composite getParent();
}
