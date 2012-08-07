/*******************************************************************************
 * Copyright (c) 2007, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.grid;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Event;

import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.uiAttributes.UIAttributePainter;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Binding Cell Information</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getColumn <em>Column</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getRow <em>Row</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getDataType <em>Data Type
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getLabelBinding <em>Label
 * Binding</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getLabelUIAttribute <em>
 * Label UI Attribute</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getObjectValue <em>Object
 * Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#isChangeable <em>Changeable
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getDisplayText <em>Display
 * Text</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getValueType <em>Value Type
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getPasteUIAttribute <em>
 * Paste UI Attribute</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#isEnabled <em>Enabled</em>}
 * </li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getPainter <em>Painter
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellInformation()
 * @generated
 */
public interface IGridBindingCellInformation extends EObject, IDisposable, IValueBindingCell {
	/**
	 * Returns the value of the '<em><b>Column</b></em>' reference. It is bidirectional and its
	 * opposite is '{@link com.rcpcompany.uibindings.grid.IGridBindingColumnInformation#getRowCells
	 * <em>Row Cells</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Column</em>' reference.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellInformation_Column()
	 * @see com.rcpcompany.uibindings.grid.IGridBindingColumnInformation#getRowCells
	 * @generated
	 */
	IGridBindingColumnInformation getColumn();

	/**
	 * Returns the value of the '<em><b>Row</b></em>' reference. It is bidirectional and its
	 * opposite is '{@link com.rcpcompany.uibindings.grid.IGridBindingRowInformation#getColumnCells
	 * <em>Column Cells</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Row</em>' reference.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellInformation_Row()
	 * @see com.rcpcompany.uibindings.grid.IGridBindingRowInformation#getColumnCells
	 * @generated
	 */
	IGridBindingRowInformation getRow();

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Data Type</em>' reference.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellInformation_DataType()
	 * @generated
	 */
	IBindingDataType getDataType();

	/**
	 * Returns the value of the '<em><b>Label Binding</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Binding</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Label Binding</em>' reference.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellInformation_LabelBinding()
	 * @generated
	 */
	@Override
	IValueBinding getLabelBinding();

	/**
	 * Returns the value of the '<em><b>Label UI Attribute</b></em>' reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Label UI Attribute</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Label UI Attribute</em>' reference.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellInformation_LabelUIAttribute()
	 * @generated
	 */
	IUIAttribute getLabelUIAttribute();

	/**
	 * Returns the value of the '<em><b>Object Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Value</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Object Value</em>' attribute.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellInformation_ObjectValue()
	 * @generated
	 */
	@Override
	IObservableValue getObjectValue();

	/**
	 * Returns the value of the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changeable</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Changeable</em>' attribute.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellInformation_Changeable()
	 * @generated
	 */
	@Override
	boolean isChangeable();

	/**
	 * Returns the value of the '<em><b>Display Text</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Text</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Display Text</em>' attribute.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellInformation_DisplayText()
	 * @generated
	 */
	@Override
	String getDisplayText();

	/**
	 * Returns the value of the '<em><b>Value Type</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Type</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Value Type</em>' attribute.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellInformation_ValueType()
	 * @generated
	 */
	Class<?> getValueType();

	/**
	 * Returns the value of the '<em><b>Paste UI Attribute</b></em>' reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Paste UI Attribute</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Paste UI Attribute</em>' reference.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellInformation_PasteUIAttribute()
	 * @generated
	 */
	IUIAttribute getPasteUIAttribute();

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute. The default value is
	 * <code>"true"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellInformation_Enabled()
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#isEnabled <em>Enabled</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Painter</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Painter</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Painter</em>' attribute.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellInformation_Painter()
	 * @generated
	 */
	UIAttributePainter getPainter();

	/**
	 * Forwards the specified event to the specified cell.
	 * 
	 * @param event the event to handle for the cell
	 */
	void handleEvent(Event event);

} // IGridBindingCellInformation
