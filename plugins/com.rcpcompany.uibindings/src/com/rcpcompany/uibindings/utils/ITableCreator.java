package com.rcpcompany.uibindings.utils;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.SpecialBinding;
import com.rcpcompany.uibindings.internal.utils.TableCreator;

/**
 * This helper class is used to ease the creating of tables in applications.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public interface ITableCreator extends IDisposable {
	/**
	 * Factory methods for {@link ITableCreator}.
	 */
	public static final class Factory {
		private Factory() {

		}

		/**
		 * Constructs and returns a new table creator
		 * 
		 * @param context the context
		 * @param parent the parent composite of the new table with a {@link GridLayout}
		 * @param style the style for the new table
		 * @return the returned table creator
		 * 
		 * @deprecated use one of the other create methods
		 */
		@Deprecated
		public static ITableCreator create(IBindingContext context, Composite parent, int style) {
			return new TableCreator(context, parent, style);
		}

		/**
		 * Constructs and returns a new table creator and sets the content of the table to the
		 * specified list of items
		 * 
		 * @param context the context
		 * @param parent the parent composite of the new table with a {@link GridLayout}
		 * @param style the style for the new table
		 * @param object the object
		 * @param reference the reference of the object
		 * 
		 * @return the returned table creator
		 */
		public static ITableCreator create(IBindingContext context, Composite parent, int style, EObject object,
				EReference reference) {
			final ITableCreator creator = create(context, parent, style);
			creator.setContent(object, reference);

			return creator;
		}

		/**
		 * Constructs and returns a new table creator and sets the content of the table to the
		 * specified list of items
		 * 
		 * @param context the context
		 * @param parent the parent composite of the new table with a {@link GridLayout}
		 * @param style the style for the new table
		 * @param list the list of items
		 * 
		 * @return the returned table creator
		 */
		public static ITableCreator create(IBindingContext context, Composite parent, int style, IObservableList list) {
			final ITableCreator creator = create(context, parent, style);
			creator.setContent(list);

			return creator;
		}

		/**
		 * Constructs and returns a new table creator and sets the content of the table to the
		 * specified list of items
		 * 
		 * @param context the context
		 * @param parent the parent composite of the new table with a {@link GridLayout}
		 * @param style the style for the new table
		 * @param object the object
		 * @param reference the reference of the object
		 * 
		 * @return the returned table creator
		 */
		public static ITableCreator create(IBindingContext context, Composite parent, int style,
				IObservableValue object, EReference reference) {
			final ITableCreator creator = create(context, parent, style);
			creator.setContent(object, reference);

			return creator;
		}
	}

	/**
	 * Style for the filter box.
	 */
	int FILTER = SWT.SEARCH;
	/**
	 * Style for a table that automatically resizes columns to match current table size.
	 */
	int RESIZE = 0x800;

	/**
	 * Returns the viewer binding for the table.
	 * 
	 * @return the binding
	 */
	IViewerBinding getBinding();

	/**
	 * Returns the table of this table creator.
	 * 
	 * @return the table
	 */
	Table getTable();

	/**
	 * Sets the content of the table to the specified list of items.
	 * 
	 * @param list the items
	 * @return the binding
	 */
	IViewerBinding setContent(IObservableList list);

	/**
	 * Sets the content of the table to the specified list of items.
	 * 
	 * @param object the object
	 * @param reference the reference of the object
	 * 
	 * @return the binding
	 */
	IViewerBinding setContent(EObject object, EReference reference);

	/**
	 * Sets the content of the table to the specified list of items.
	 * 
	 * @param object the object
	 * @param reference the reference of the object
	 * 
	 * @return the binding
	 */
	IViewerBinding setContent(IObservableValue object, EReference reference);

	/**
	 * Sets the focus to the table or the filter if one exists.
	 */
	void setFocus();

	/**
	 * Constructs a new column and binds to this.
	 * 
	 * @param feature the feature of the column
	 * @param width the wanted width
	 * @return the column binding
	 */
	IColumnBinding addColumn(EStructuralFeature feature, int width);

	/**
	 * Constructs a new special column and binds to this.
	 * 
	 * @param columnType the type of the wanted column
	 * @param width the wanted width
	 * @return the column binding
	 */
	IColumnBinding addColumn(SpecialBinding columnType, int width);

	/**
	 * Constructs a new column and binds to this.
	 * 
	 * @param spec the specification of the new row TODO
	 * @return the column binding
	 */
	IColumnBinding addColumn(String spec);

	/**
	 * Constructs a new sub-column and binds to this.
	 * 
	 * @param baseColumn the base column
	 * @param feature the feature of the column
	 * @param width the wanted width
	 * @return the column binding
	 */
	IColumnBinding addColumn(IColumnBinding baseColumn, EStructuralFeature feature, int width);
}
