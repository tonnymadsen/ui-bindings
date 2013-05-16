/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
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
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>UI Attribute Image Decoration</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IUIAttributeImageDecoration#isOutside <em>Outside</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttributeImageDecoration#getImageValue <em>Image Value
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttributeImageDecoration#getTooltipValue <em>Tooltip
 * Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttributeImageDecoration#getPosition <em>Position</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttributeImageDecoration#getAttribute <em>Attribute</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttributeImageDecoration()
 * @generated
 */
public interface IUIAttributeImageDecoration extends EObject, IDisposable {
	/**
	 * Returns the value of the '<em><b>Outside</b></em>' attribute. The default value is
	 * <code>"false"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outside</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Outside</em>' attribute.
	 * @see #setOutside(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttributeImageDecoration_Outside()
	 * @generated
	 */
	boolean isOutside();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IUIAttributeImageDecoration#isOutside <em>Outside</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Outside</em>' attribute.
	 * @see #isOutside()
	 * @generated
	 */
	void setOutside(boolean value);

	/**
	 * Returns the value of the '<em><b>Image Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Value</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Image Value</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttributeImageDecoration_ImageValue()
	 * @generated
	 */
	IObservableValue getImageValue();

	/**
	 * Returns the value of the '<em><b>Tooltip Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tooltip Value</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Tooltip Value</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttributeImageDecoration_TooltipValue()
	 * @generated
	 */
	IObservableValue getTooltipValue();

	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute. The literals are from the
	 * enumeration {@link com.rcpcompany.uibindings.DecorationPosition}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see com.rcpcompany.uibindings.DecorationPosition
	 * @see #setPosition(DecorationPosition)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttributeImageDecoration_Position()
	 * @generated
	 */
	DecorationPosition getPosition();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IUIAttributeImageDecoration#getPosition <em>Position</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see com.rcpcompany.uibindings.DecorationPosition
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(DecorationPosition value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' container reference. It is bidirectional
	 * and its opposite is '{@link com.rcpcompany.uibindings.IUIAttribute#getImageDecorations
	 * <em>Image Decorations</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' container reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attribute</em>' container reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttributeImageDecoration_Attribute()
	 * @see com.rcpcompany.uibindings.IUIAttribute#getImageDecorations
	 * @generated
	 */
	IUIAttribute getAttribute();

	/**
	 * Updates this decoration for use in the specified control and bounds.
	 * 
	 * @see IUIAttribute#updateImageDecorations(Control, Rectangle, Rectangle)
	 * @param control the control of the attribute
	 * @param innerBounds the bounds of the control
	 * @param outerBounds TODO
	 */
	void updateImageDecorations(Control control, Rectangle innerBounds, Rectangle outerBounds);

	/**
	 * The margin for outer decorations.
	 */
	int OUTER_MARGIN_WIDTH = 1;
} // IUIAttributeImageDecoration
