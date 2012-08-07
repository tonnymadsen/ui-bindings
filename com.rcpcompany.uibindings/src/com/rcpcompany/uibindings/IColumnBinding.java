/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings;

import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TreeColumn;

/**
 * <!-- begin-user-doc -->
 * <p>
 * The binding of JFace {@link ViewerColumn viewer column} to a EMF feature.
 * <p>
 * The column will be "decorated" as follows:
 * <ul>
 * <li>If not already set, the heading for the column will be set to a capitalized version of the
 * feature name.</li>
 * <li>A column in a {@link StructuredViewer}</li>
 * <li>A {@link List} with a single value - TODO: decide!!</li>
 * </ul>
 * <p>
 * A binding connects a model attribute or reference with a widget in the UI.
 * <p>
 * Constructed via {@link IBindingContext#addBinding()} and friends.
 * </p>
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IColumnBinding#getViewerBinding <em>Viewer Binding</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBinding#getViewerColumn <em>Viewer Column</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBinding#getColumnAdapter <em>Column Adapter</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBinding#getBaseColumn <em>Base Column</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBinding#getSubColumns <em>Sub Columns</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBinding#getCells <em>Cells</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBinding#getSpecialBindingType <em>Special Binding
 * Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBinding#getFactory <em>Factory</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBinding#getCursor <em>Cursor</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBinding#getColumnVisibility <em>Column Visibility
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBinding()
 * @generated
 */
public interface IColumnBinding extends IBinding {
	/**
	 * Constructs and returns a new column binding to this viewer.
	 * <p>
	 * Shortcut for <code>addColumn().column(column).emf(feature)</code>.
	 * 
	 * @param column the widget to bind
	 * @param feature the feature of the column
	 * 
	 * @return the new column binding
	 */
	IColumnBinding addColumn(ViewerColumn column, EStructuralFeature feature);

	/**
	 * Constructs and returns a new column binding to this viewer.
	 * <p>
	 * Shortcut for <code>addColumn().column(column).emf(feature)</code>.
	 * 
	 * @param column the widget to bind
	 * @param feature the feature of the column
	 * 
	 * @return the new column binding
	 */
	IColumnBinding addColumn(TableColumn column, EStructuralFeature feature);

	/**
	 * Constructs and returns a new column binding to this viewer.
	 * <p>
	 * Shortcut for <code>addColumn().column(column).emf(feature)</code>.
	 * 
	 * @param column the widget to bind
	 * @param feature the feature of the column
	 * 
	 * @return the new column binding
	 */
	IColumnBinding addColumn(TreeColumn column, EStructuralFeature feature);

	/**
	 * Binds this binding to the value of the specified JFace column.
	 * 
	 * @param column the column to bind
	 * @return <code>this</code>
	 */
	IColumnBinding column(ViewerColumn column);

	/**
	 * Binds this binding to the value of the specified {@link TableColumn SWT table column}.
	 * 
	 * @param column the column to bind
	 * @return <code>this</code>
	 */
	IColumnBinding column(TableColumn column);

	/**
	 * Binds this binding to the value of the specified {@link TreeColumn SWT tree column}.
	 * 
	 * @param column the column to bind
	 * @return <code>this</code>
	 */
	IColumnBinding column(TreeColumn column);

	/**
	 * Binds this binding to the specified EMF feature.
	 * 
	 * @param feature the structural feature
	 * 
	 * @return <code>this</code>
	 */
	IColumnBinding model(EStructuralFeature feature);

	/**
	 * Binds this binding to a special value.
	 * 
	 * @param specialValue the special value
	 * 
	 * @return <code>this</code>
	 */
	IColumnBinding model(SpecialBinding specialValue);

	/**
	 * Binds this binding via a observable value factory.
	 * 
	 * @param factory the factory
	 * @param type the result type of the factory - e.g.
	 *            <code>factory.createObservable(...).getValueType()</code>
	 * 
	 * @return <code>this</code>
	 */
	IColumnBinding model(IObservableFactory factory, EClassifier type);

	/**
	 * Binds this binding via a observable value factory.
	 * 
	 * @param factory the factory
	 * @param feature the result type of the factory - e.g.
	 *            <code>factory.createObservable(...).getValueType()</code>
	 * 
	 * @return <code>this</code>
	 */
	IColumnBinding model(IObservableFactory factory, EStructuralFeature feature);

	/**
	 * Binds this binding to the specified EMF features based on the result of another column.
	 * <p>
	 * The first column must of cause map to an {@link EObject object} that allows for the extra
	 * feature.
	 * 
	 * @param baseColumn base column
	 * @param feature the second structural feature
	 * 
	 * @return <code>this</code>
	 */
	IColumnBinding model(IColumnBinding baseColumn, EStructuralFeature feature);

	/**
	 * Binds this binding via a observable value factory based on the result of another column.
	 * 
	 * @param baseColumn base column
	 * @param factory the factory
	 * @param feature the result type of the factory - e.g.
	 *            <code>factory.createObservable(...).getValueType()</code>
	 * 
	 * @return <code>this</code>
	 */
	IColumnBinding model(IColumnBinding baseColumn, IObservableFactory factory, EStructuralFeature feature);

	/**
	 * Sets the type of the binding. Defaults to "<code>basic</code>".
	 * 
	 * @param type the type name
	 * 
	 * @return <code>this</code>
	 */
	@Override
	IColumnBinding type(String type);

	/**
	 * Sets an argument for the binding. Some arguments are deduced from the EMF binding.
	 * 
	 * @param name the argument name
	 * @param value the argument value
	 * 
	 * @return <code>this</code>
	 */
	@Override
	IColumnBinding arg(String name, Object value);

	/**
	 * Sets a complete set of arguments for the binding.
	 * 
	 * @param arguments the arguments to set
	 * @return <code>this</code>
	 */
	@Override
	IColumnBinding args(Map<String, Object> arguments);

	/**
	 * Short for <code>arg(IBinding.ARG_READONLY, true)</code>.
	 * 
	 * @return <code>this</code>
	 */
	@Override
	IColumnBinding readonly();

	/**
	 * Short for <code>arg({@link IBinding#ARG_DYNAMIC}, true)</code>.
	 * 
	 * @return <code>this</code>
	 */
	@Override
	IColumnBinding dynamic();

	/**
	 * Short for <code>getId(id)</code>.
	 * 
	 * @param id the new id
	 * @return <code>this</code>
	 */
	@Override
	IColumnBinding id(String id);

	/**
	 * Short for <code>arg({@link IBinding#ARG_LABEL}, label)</code>.
	 * 
	 * @param label the label to add
	 * @return <code>this</code>
	 */
	@Override
	IColumnBinding label(String label);

	/**
	 * Short for <code>arg(IBinding.ARG_VALID_VALUES, list)</code>.
	 * 
	 * @param list the list of valid values
	 * 
	 * @return <code>this</code>
	 */
	@Override
	IColumnBinding validValues(IObservableList list);

	/**
	 * Short for <code>arg(IBinding.ARG_VALID_VALUES, list)</code>.
	 * 
	 * @param list the list of valid values
	 * 
	 * @return <code>this</code>
	 */
	@Override
	IColumnBinding validValues(EObject obj, EReference reference);

	/**
	 * Returns the value of the '<em><b>Viewer Binding</b></em>' reference. It is bidirectional and
	 * its opposite is '{@link com.rcpcompany.uibindings.IViewerBinding#getColumns <em>Columns</em>}
	 * '. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewer Binding</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Viewer Binding</em>' reference.
	 * @see #setViewerBinding(IViewerBinding)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBinding_ViewerBinding()
	 * @see com.rcpcompany.uibindings.IViewerBinding#getColumns
	 * @generated
	 */
	IViewerBinding getViewerBinding();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IColumnBinding#getViewerBinding
	 * <em>Viewer Binding</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Viewer Binding</em>' reference.
	 * @see #getViewerBinding()
	 * @generated
	 */
	void setViewerBinding(IViewerBinding value);

	/**
	 * Returns the value of the '<em><b>Viewer Column</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewer Column</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Viewer Column</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBinding_ViewerColumn()
	 * @generated
	 */
	ViewerColumn getViewerColumn();

	/**
	 * Returns the value of the '<em><b>Column Adapter</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column Adapter</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Column Adapter</em>' reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBinding_ColumnAdapter()
	 * @generated
	 */
	IColumnAdapter getColumnAdapter();

	/**
	 * Returns the value of the '<em><b>Base Column</b></em>' reference. It is bidirectional and its
	 * opposite is '{@link com.rcpcompany.uibindings.IColumnBinding#getSubColumns
	 * <em>Sub Columns</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Column</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Column</em>' reference.
	 * @see #setBaseColumn(IColumnBinding)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBinding_BaseColumn()
	 * @see com.rcpcompany.uibindings.IColumnBinding#getSubColumns
	 * @generated
	 */
	IColumnBinding getBaseColumn();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IColumnBinding#getBaseColumn
	 * <em>Base Column</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Base Column</em>' reference.
	 * @see #getBaseColumn()
	 * @generated
	 */
	void setBaseColumn(IColumnBinding value);

	/**
	 * Returns the value of the '<em><b>Sub Columns</b></em>' reference list. The list contents are
	 * of type {@link com.rcpcompany.uibindings.IColumnBinding}. It is bidirectional and its
	 * opposite is '{@link com.rcpcompany.uibindings.IColumnBinding#getBaseColumn
	 * <em>Base Column</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Columns</em>' reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sub Columns</em>' reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBinding_SubColumns()
	 * @see com.rcpcompany.uibindings.IColumnBinding#getBaseColumn
	 * @generated
	 */
	EList<IColumnBinding> getSubColumns();

	/**
	 * Returns the value of the '<em><b>Cells</b></em>' map. The key is of type
	 * {@link org.eclipse.emf.ecore.EObject}, and the value is of type
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation}, <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cells</em>' map isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Cells</em>' map.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBinding_Cells()
	 * @generated
	 */
	EMap<EObject, IColumnBindingCellInformation> getCells();

	/**
	 * Returns the value of the '<em><b>Special Binding Type</b></em>' attribute. The literals are
	 * from the enumeration {@link com.rcpcompany.uibindings.SpecialBinding}. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Special Binding Type</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Special Binding Type</em>' attribute.
	 * @see com.rcpcompany.uibindings.SpecialBinding
	 * @see #setSpecialBindingType(SpecialBinding)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBinding_SpecialBindingType()
	 * @generated
	 */
	SpecialBinding getSpecialBindingType();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IColumnBinding#getSpecialBindingType
	 * <em>Special Binding Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Special Binding Type</em>' attribute.
	 * @see com.rcpcompany.uibindings.SpecialBinding
	 * @see #getSpecialBindingType()
	 * @generated
	 */
	void setSpecialBindingType(SpecialBinding value);

	/**
	 * Returns the value of the '<em><b>Factory</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factory</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Factory</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBinding_Factory()
	 * @generated
	 */
	IObservableFactory getFactory();

	/**
	 * Returns the value of the '<em><b>Cursor</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cursor</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Cursor</em>' attribute.
	 * @see #setCursor(Cursor)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBinding_Cursor()
	 * @generated
	 */
	Cursor getCursor();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IColumnBinding#getCursor
	 * <em>Cursor</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Cursor</em>' attribute.
	 * @see #getCursor()
	 * @generated
	 */
	void setCursor(Cursor value);

	/**
	 * Returns the value of the '<em><b>Column Visibility</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * Return a observable value (value type {@link Boolean}) that controls the visibility of the
	 * column in the viewer.
	 * <p>
	 * It is important that the {@link TableColumn} or {@link TreeColumn} is not modified directly
	 * after this observable has been created.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Column Visibility</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBinding_ColumnVisibility()
	 * @generated
	 */
	IObservableValue getColumnVisibility();

	/**
	 * Returns the cell information object for this column and the specified element.
	 * 
	 * @param element the row element
	 * @return the cell information
	 */
	IColumnBindingCellInformation getCellInformation(Object element);

	/**
	 * Returns the cell information object for this column and the specified element.
	 * <p>
	 * Will optionally create the cell information object if not present
	 * 
	 * @param element the row element
	 * @param create <code>true</code> if the object should be created
	 * @return the cell information
	 */
	IColumnBindingCellInformation getCellInformation(Object element, boolean create);

	/**
	 * Returns the value shown in the cell in this column for the specified element.
	 * 
	 * @param element the specified row element
	 * @return the current display value
	 */
	String getDisplayText(Object element);

	/**
	 * Returns an observable value for the value for this specified column.
	 * <p>
	 * This method is based on the fact that the row is fixed.
	 * 
	 * @param element the row of this column in this calculation
	 * 
	 * @return the value
	 */
	IObservableValue getValue(Object element);

	/**
	 * Request a label provider update with the specified elements.
	 * 
	 * @param elements the elements to updae
	 */
	void fireLabelChanged(Object[] elements);

	/**
	 * Returns the index of this column in the parent viewer. Top column is <code>0</code>.
	 * <p>
	 * 
	 * @param visualModel <code>true</code> if the visual model should be used rather than the
	 *            creation model
	 * 
	 * @return the index or <code>-1</code> if the column cannot be found
	 */
	int getIndex(boolean visualModel);
} // IColumnBinding
