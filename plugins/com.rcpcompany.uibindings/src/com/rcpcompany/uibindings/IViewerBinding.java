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
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

/**
 * <!-- begin-user-doc -->
 * <p>
 * The binding of the input of a structural viewer to a specific list.
 * <p>
 * Constructed via {@link IBindingContext#addViewer(ColumnViewer, IObservableList)} and friends.
 * </p>
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IViewerBinding#getColumns <em>Columns</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IViewerBinding#getList <em>List</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IViewerBinding#getElements <em>Elements</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IViewerBinding#getMultipleSelection <em>Multiple Selection
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IViewerBinding#getViewer <em>Viewer</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IViewerBinding#getFirstTableColumnOffset <em>First Table
 * Column Offset</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getViewerBinding()
 * @generated
 */
public interface IViewerBinding extends IContainerBinding {
	/**
	 * Factory methods for {@link IViewerBinding}.
	 */
	static final class Factory {
		private Factory() {

		}

		/**
		 * Adds to the specified list of {@link IChildCreationSpecification} with the specified
		 * information.
		 * <p>
		 * Also adds any sub-class of child type.
		 * 
		 * @param specs the list of specifications to add to
		 * @param parent the parent object
		 * @param ref the reference
		 * @param childType the child type
		 * @param index the index for a new child - <code>-1</code> if not known
		 */
		public static void addToChildCreationSpecification(final List<IChildCreationSpecification> specs,
				EObject parent, EReference ref, final EClass childType, int index) {
			UIBindingsUtils.addToChildCreationSpecification(specs, parent, ref, childType, index);
		}
	}

	/**
	 * Binds the target (UI) side of this binding to the specified viewer.
	 * 
	 * @param viewer the viewer to bind to
	 * @return <code>this</code>
	 * 
	 * @deprecated will disappear
	 */
	@Deprecated
	IViewerBinding viewer(ColumnViewer viewer);

	/**
	 * Binds the target (UI) side of this binding to the specified {@link Table SWT Table}.
	 * 
	 * @param viewer the viewer to bind to
	 * @return <code>this</code>
	 */
	IViewerBinding viewer(Table viewer);

	/**
	 * Binds the target (UI) side of this binding to the specified {@link Tree SWT Tree}.
	 * 
	 * @param viewer the viewer to bind to
	 * @return <code>this</code>
	 */
	IViewerBinding viewer(Tree viewer);

	/**
	 * Binds this binding to the specified observable list.
	 * <p>
	 * The specified list is disposed by the framework.
	 * 
	 * @param list the list to bind to - disposed by the framework
	 * 
	 * @return <code>this</code>
	 */
	IViewerBinding model(IObservableList list);

	/**
	 * Binds this binding to the specified reference of the object.
	 * 
	 * @param object the EMF object
	 * @param reference the reference of the object
	 * 
	 * @return <code>this</code>
	 */
	IViewerBinding model(EObject object, EReference reference);

	/**
	 * Binds this binding to the specified reference of the object.
	 * 
	 * @param object the observable
	 * @param reference the reference of the object
	 * 
	 * @return <code>this</code>
	 */
	IViewerBinding model(IObservableValue object, EReference reference);

	/**
	 * Sets the type of the binding. Defaults to "<code>basic</code>".
	 * 
	 * @param type the type name
	 * 
	 * @return <code>this</code>
	 */
	@Override
	IViewerBinding type(String type);

	/**
	 * Sets an argument for the binding. Some arguments are deduced from the EMF binding.
	 * 
	 * @param name the argument name
	 * @param value the argument value
	 * 
	 * @return <code>this</code>
	 */
	@Override
	IViewerBinding arg(String name, Object value);

	/**
	 * Sets a complete set of arguments for the binding.
	 * 
	 * @param arguments the arguments to set
	 * @return <code>this</code>
	 */
	@Override
	IViewerBinding args(Map<String, Object> arguments);

	/**
	 * Short for <code>arg(IBinding.ARG_READONLY, true)</code>.
	 * 
	 * @return <code>this</code>
	 */
	@Override
	IViewerBinding readonly();

	/**
	 * Short for <code>getId(id)</code>.
	 * 
	 * @param id the new id
	 * @return <code>this</code>
	 */
	@Override
	IViewerBinding id(String id);

	/**
	 * Constructs and returns a new column binding to this viewer.
	 * 
	 * @return the new column binding
	 */
	IColumnBinding addColumn();

	/**
	 * Constructs and returns a new column binding to this viewer.
	 * <p>
	 * Shortcut for <code>addColumn().column(column).emf(feature)</code>.
	 * 
	 * @param column the widget to bind
	 * @param feature the feature of the column
	 * 
	 * @return the new column binding
	 * 
	 * @deprecated will disappear
	 */
	@Deprecated
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
	 * Returns the value of the '<em><b>Columns</b></em>' reference list. The list contents are of
	 * type {@link com.rcpcompany.uibindings.IColumnBinding}. It is bidirectional and its opposite
	 * is '{@link com.rcpcompany.uibindings.IColumnBinding#getViewerBinding <em>Viewer Binding</em>}
	 * '. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Columns</em>' reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getViewerBinding_Columns()
	 * @see com.rcpcompany.uibindings.IColumnBinding#getViewerBinding
	 * @generated
	 */
	EList<IColumnBinding> getColumns();

	/**
	 * Returns the value of the '<em><b>List</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>List</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getViewerBinding_List()
	 * @generated
	 */
	IObservableList getList();

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Elements</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getViewerBinding_Elements()
	 * @generated
	 */
	IObservableSet getElements();

	/**
	 * Returns the value of the '<em><b>Multiple Selection</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Multiple Selection</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Multiple Selection</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getViewerBinding_MultipleSelection()
	 * @generated
	 */
	IObservableList getMultipleSelection();

	/**
	 * Returns the value of the '<em><b>Viewer</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Viewer</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Viewer</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getViewerBinding_Viewer()
	 * @generated
	 */
	@Deprecated
	ColumnViewer getViewer();

	/**
	 * Returns the value of the '<em><b>First Table Column Offset</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * The offset of the first binding column of the columns of the table or tree.
	 * <p>
	 * In tables, this is 1 to allow for an artificial first column. Used to be able to control the
	 * align of the first column.
	 * <p>
	 * In trees, this is 0 as the first column must be the tree column.
	 * 
	 * @see TableColumn#setAlignment(int) </p>
	 *      <!-- end-user-doc -->
	 * @return the value of the '<em>First Table Column Offset</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getViewerBinding_FirstTableColumnOffset()
	 * @generated
	 */
	int getFirstTableColumnOffset();

	/**
	 * Returns the parentage for the element in this viewer.
	 * <p>
	 * The parentage for an element depends on the type of the viewer. For a {@link Table} based
	 * viewer, it is pretty simple. For TODO
	 * 
	 * @param element the element in question
	 * @return an object that describes the parentage or <code>null</code> if the parentage is not
	 *         known
	 */
	IElementParentage getElementParentage(EObject element);

	/**
	 * Returns a list of the possible objects that can be created as sub-elements of the specified
	 * parent.
	 * <p>
	 * If the parent is <code>null</code> top-level objects are created.
	 * <p>
	 * If a sibling is non-<code>null</code>, the children should be as close to immediately
	 * following that sibling as possible.
	 * <p>
	 * For {@link Table tables} the element is ignored.
	 * 
	 * @param parent the view element that should be the parent of the child
	 * @param sibling if non-<code>null</code> the wanted sibling
	 * @return a list of possible children or <code>null</code> if no children a found
	 */
	List<IChildCreationSpecification> getPossibleChildObjects(EObject parent, EObject sibling);

	/**
	 * Focus on the cell identified by the element and column number if possible.
	 * 
	 * @param column the column number
	 * @param element the element
	 */
	void setFocus(int column, EObject element);

	/**
	 * Returns the cell for the specified column and element.
	 * 
	 * @param columnNo the column number
	 * @param element the element
	 * @return the cell
	 */
	IColumnBindingCellInformation getCell(int columnNo, Object element);

} // IViewerBinding
