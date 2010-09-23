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
package com.rcpcompany.uibindings.internal;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IColumnAdapter;
import com.rcpcompany.uibindings.IUIBindingsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Column Adapter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnAdapterImpl#getWidget <em>Widget</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnAdapterImpl#getText <em>Text</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnAdapterImpl#getAlignment <em>Alignment</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnAdapterImpl#getImage <em>Image</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnAdapterImpl#isMoveable <em>Moveable</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnAdapterImpl#isResizable <em>Resizable</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnAdapterImpl#getWidth <em>Width</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnAdapterImpl#getToolTipText <em>Tool Tip Text
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class ColumnAdapterImpl extends EObjectImpl implements IColumnAdapter {
	/**
	 * The default value of the '{@link #getWidget() <em>Widget</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWidget()
	 * @generated
	 * @ordered
	 */
	protected static final Widget WIDGET_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getAlignment() <em>Alignment</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAlignment()
	 * @generated
	 * @ordered
	 */
	protected static final int ALIGNMENT_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getImage() <em>Image</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected static final Image IMAGE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #isMoveable() <em>Moveable</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMoveable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MOVEABLE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isResizable() <em>Resizable</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isResizable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESIZABLE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int WIDTH_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getToolTipText() <em>Tool Tip Text</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getToolTipText()
	 * @generated
	 * @ordered
	 */
	protected static final String TOOL_TIP_TEXT_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ColumnAdapterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.COLUMN_ADAPTER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract Widget getWidget();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract String getText();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract void setText(String newText);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract int getAlignment();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract void setAlignment(int newAlignment);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract Image getImage();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract void setImage(Image newImage);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract boolean isMoveable();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract void setMoveable(boolean newMoveable);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract boolean isResizable();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract void setResizable(boolean newResizable);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract int getWidth();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract void setWidth(int newWidth);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract String getToolTipText();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract void setToolTipText(String newToolTipText);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IUIBindingsPackage.COLUMN_ADAPTER__WIDGET:
			return getWidget();
		case IUIBindingsPackage.COLUMN_ADAPTER__TEXT:
			return getText();
		case IUIBindingsPackage.COLUMN_ADAPTER__ALIGNMENT:
			return getAlignment();
		case IUIBindingsPackage.COLUMN_ADAPTER__IMAGE:
			return getImage();
		case IUIBindingsPackage.COLUMN_ADAPTER__MOVEABLE:
			return isMoveable();
		case IUIBindingsPackage.COLUMN_ADAPTER__RESIZABLE:
			return isResizable();
		case IUIBindingsPackage.COLUMN_ADAPTER__WIDTH:
			return getWidth();
		case IUIBindingsPackage.COLUMN_ADAPTER__TOOL_TIP_TEXT:
			return getToolTipText();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case IUIBindingsPackage.COLUMN_ADAPTER__TEXT:
			setText((String) newValue);
			return;
		case IUIBindingsPackage.COLUMN_ADAPTER__ALIGNMENT:
			setAlignment((Integer) newValue);
			return;
		case IUIBindingsPackage.COLUMN_ADAPTER__IMAGE:
			setImage((Image) newValue);
			return;
		case IUIBindingsPackage.COLUMN_ADAPTER__MOVEABLE:
			setMoveable((Boolean) newValue);
			return;
		case IUIBindingsPackage.COLUMN_ADAPTER__RESIZABLE:
			setResizable((Boolean) newValue);
			return;
		case IUIBindingsPackage.COLUMN_ADAPTER__WIDTH:
			setWidth((Integer) newValue);
			return;
		case IUIBindingsPackage.COLUMN_ADAPTER__TOOL_TIP_TEXT:
			setToolTipText((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case IUIBindingsPackage.COLUMN_ADAPTER__TEXT:
			setText(TEXT_EDEFAULT);
			return;
		case IUIBindingsPackage.COLUMN_ADAPTER__ALIGNMENT:
			setAlignment(ALIGNMENT_EDEFAULT);
			return;
		case IUIBindingsPackage.COLUMN_ADAPTER__IMAGE:
			setImage(IMAGE_EDEFAULT);
			return;
		case IUIBindingsPackage.COLUMN_ADAPTER__MOVEABLE:
			setMoveable(MOVEABLE_EDEFAULT);
			return;
		case IUIBindingsPackage.COLUMN_ADAPTER__RESIZABLE:
			setResizable(RESIZABLE_EDEFAULT);
			return;
		case IUIBindingsPackage.COLUMN_ADAPTER__WIDTH:
			setWidth(WIDTH_EDEFAULT);
			return;
		case IUIBindingsPackage.COLUMN_ADAPTER__TOOL_TIP_TEXT:
			setToolTipText(TOOL_TIP_TEXT_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case IUIBindingsPackage.COLUMN_ADAPTER__WIDGET:
			return WIDGET_EDEFAULT == null ? getWidget() != null : !WIDGET_EDEFAULT.equals(getWidget());
		case IUIBindingsPackage.COLUMN_ADAPTER__TEXT:
			return TEXT_EDEFAULT == null ? getText() != null : !TEXT_EDEFAULT.equals(getText());
		case IUIBindingsPackage.COLUMN_ADAPTER__ALIGNMENT:
			return getAlignment() != ALIGNMENT_EDEFAULT;
		case IUIBindingsPackage.COLUMN_ADAPTER__IMAGE:
			return IMAGE_EDEFAULT == null ? getImage() != null : !IMAGE_EDEFAULT.equals(getImage());
		case IUIBindingsPackage.COLUMN_ADAPTER__MOVEABLE:
			return isMoveable() != MOVEABLE_EDEFAULT;
		case IUIBindingsPackage.COLUMN_ADAPTER__RESIZABLE:
			return isResizable() != RESIZABLE_EDEFAULT;
		case IUIBindingsPackage.COLUMN_ADAPTER__WIDTH:
			return getWidth() != WIDTH_EDEFAULT;
		case IUIBindingsPackage.COLUMN_ADAPTER__TOOL_TIP_TEXT:
			return TOOL_TIP_TEXT_EDEFAULT == null ? getToolTipText() != null : !TOOL_TIP_TEXT_EDEFAULT
					.equals(getToolTipText());
		}
		return super.eIsSet(featureID);
	}

} // ColumnAdapterImpl
