/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.uiAttributes.UIAttributePainter;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Column Binding Cell Information</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getColumn <em>Column</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getElement <em>Element</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getLabelBinding <em>Label
 * Binding</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getLabelUIAttribute <em>Label
 * UI Attribute</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getLabelPainter <em>Label
 * Painter</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getObjectValue <em>Object
 * Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getSourceValue <em>Source
 * Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBindingCellInformation#isChangeable <em>Changeable
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getDisplayText <em>Display
 * Text</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getValueType <em>Value Type
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getToolTipText <em>Tool Tip
 * Text</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnBindingCellInformation#isEnabled <em>Enabled</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBindingCellInformation()
 * @generated
 */
public interface IColumnBindingCellInformation extends EObject, IDisposable, IValueBindingCell {
	/**
	 * Returns the value of the '<em><b>Column</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Column</em>' reference.
	 * @see #setColumn(IColumnBinding)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBindingCellInformation_Column()
	 * @generated
	 */
	IColumnBinding getColumn();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getColumn <em>Column</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Column</em>' reference.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(IColumnBinding value);

	/**
	 * Initializes this cell information object for the specified column and object.
	 * 
	 * @param column the column
	 * @param element the element
	 */
	void init(IColumnBinding column, Object element);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Element</em>' reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBindingCellInformation_Element()
	 * @generated
	 */
	EObject getElement();

	/**
	 * Returns the value of the '<em><b>Label Binding</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Binding</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Label Binding</em>' reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBindingCellInformation_LabelBinding()
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
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBindingCellInformation_LabelUIAttribute()
	 * @generated
	 */
	IUIAttribute getLabelUIAttribute();

	/**
	 * Returns the value of the '<em><b>Label Painter</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Painter</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Label Painter</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBindingCellInformation_LabelPainter()
	 * @generated
	 */
	UIAttributePainter getLabelPainter();

	/**
	 * Returns the value of the '<em><b>Object Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Value</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Object Value</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBindingCellInformation_ObjectValue()
	 * @generated
	 */
	@Override
	IObservableValue getObjectValue();

	/**
	 * Returns the value of the '<em><b>Source Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Value</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source Value</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBindingCellInformation_SourceValue()
	 * @generated
	 */
	IObservableValue getSourceValue();

	/**
	 * Returns the value of the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changeable</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Changeable</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBindingCellInformation_Changeable()
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
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBindingCellInformation_DisplayText()
	 * @generated
	 */
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
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBindingCellInformation_ValueType()
	 * @generated
	 */
	Class<?> getValueType();

	/**
	 * Returns the value of the '<em><b>Tool Tip Text</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tool Tip Text</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Tool Tip Text</em>' attribute.
	 * @see #setToolTipText(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBindingCellInformation_ToolTipText()
	 * @generated
	 */
	String getToolTipText();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getToolTipText
	 * <em>Tool Tip Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Tool Tip Text</em>' attribute.
	 * @see #getToolTipText()
	 * @generated
	 */
	void setToolTipText(String value);

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
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnBindingCellInformation_Enabled()
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation#isEnabled <em>Enabled</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

} // IColumnBindingCellInformation
