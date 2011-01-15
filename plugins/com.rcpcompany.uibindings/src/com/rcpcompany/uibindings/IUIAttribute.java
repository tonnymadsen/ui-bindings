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

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;

/**
 * <!-- begin-user-doc -->
 * <p>
 * This interface describes how a specific attribute of an SWT widget - e.g. a {@link Text} or a
 * {@link Combo} - can be handled.
 * <p>
 * The interface describes the following aspects of a specific attribute:
 * <ul>
 * <li>The {@link Widget} itself</li>
 * <li>The attribute of the widget. Can be the empty string for the default attribute and
 * <code>null</code> if no attribute is known</li>
 * <li>{@link IObservableValue} used to access the attribute.</li>
 * <li>whether the value can be changed in the widget. E.g. the text attribute of a {@link Text}
 * widget can be changed, whereas the same attribute of the {@link Label} cannot.</li>
 * <li>an optional {@link IObservableList} that can be used to set the possible values of the widget
 * - e.g. a {@link Combo} or {@link List}. If the possible values cannot be set - e.g. for a
 * {@link Text} or {@link Button} - <code>null</code> is returned.</li>
 * <li>optional min and max {@link IObservableValue} that designate the min and max value of the
 * widget if set</li>
 * <li>optional tool-tip {@link IObservableValue} that designate the tool tip of the widget if set</li>
 * <li>optional foreground and background color {@link IObservableValue} that designate these colors
 * of the widget if set</li>
 * <li>optional font {@link IObservableValue} that designate the font of the widget if set</li>
 * <li>optional image {@link IObservableValue} that designate the image of the widget if set</li>
 * <li>optional enabled {@link IObservableValue} that designate the enabled state of the widget if
 * set</li>
 * <li>optional tool-tip {@link IObservableValue} that designate the tool tip of the widget if set</li>
 * <li>an optional {@link IControlContentAdapter} that is used to install field assist in the
 * widget.</li>
 * </ul>
 * <p>
 * A new <code>IUIAttribute</code> object is created for each widget that is accessed in an
 * {@link IBindingContext}.
 * <p>
 * Implementations of <code>IUIAttribute</code> is normally specified via the
 * <code>com.rcpcompany.uibindings.uiBindings</code> extension point with the element
 * <code>uiAttribute</code>.
 * <p>
 * Private implementations are also possible.
 * </p>
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getWidget <em>Widget</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getAttribute <em>Attribute</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getCurrentValue <em>Current Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getPossibleValuesList <em>Possible Values List
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getMinValue <em>Min Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getMaxValue <em>Max Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getTooltipValue <em>Tooltip Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getFontValue <em>Font Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getImageValue <em>Image Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getForegroundValue <em>Foreground Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getBackgroundValue <em>Background Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getEnabledValue <em>Enabled Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getCursorValue <em>Cursor Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getStyleRangeList <em>Style Range List</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#isChangeable <em>Changeable</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getFieldAssistAdapter <em>Field Assist Adapter
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getFieldAssistControl <em>Field Assist Control
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttribute#getImageDecorations <em>Image Decorations</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute()
 * @generated
 */
public interface IUIAttribute extends EObject, IDisposable {
	/**
	 * Returns the value of the '<em><b>Widget</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Widget</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_Widget()
	 * @generated
	 */
	Widget getWidget();

	/**
	 * Returns whether this attribute has been disposed.
	 * 
	 * @return <code>true</code> if disposed
	 */
	boolean isDisposed();

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' attribute. The default value is
	 * <code>""</code>. <!-- begin-user-doc -->
	 * <p>
	 * Can be the empty string for the default attribute and <code>null</code> if no attribute is
	 * known.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attribute</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_Attribute()
	 * @generated
	 */
	String getAttribute();

	/**
	 * Returns the value of the '<em><b>Current Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * Returns the observable value that is used to access the current value as designed by the
	 * attribute
	 * <p>
	 * This method is only called once in the life time this attribute, so the return value need not
	 * be cached.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Current Value</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_CurrentValue()
	 * @generated
	 */
	IObservableValue getCurrentValue();

	/**
	 * Returns the value of the '<em><b>Possible Values List</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * Returns an optional {@link IObservableList} that designates the possible values of the widget
	 * if set.
	 * <p>
	 * It can be used to set the possible values of the widget - e.g. a {@link Combo} or
	 * {@link List}. If the possible values cannot be set - e.g. for a {@link Text} or
	 * {@link Button} - <code>null</code> is returned.
	 * <p>
	 * This method is only called once in the life time this attribute, so the return value need not
	 * be cached.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Possible Values List</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_PossibleValuesList()
	 * @generated
	 */
	IObservableList getPossibleValuesList();

	/**
	 * Returns the value of the '<em><b>Min Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * Returns an optional observable value that designates the minimum value of the widget if set.
	 * <p>
	 * This method is only called once in the life time this attribute, so the return value need not
	 * be cached.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Min Value</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_MinValue()
	 * @generated
	 */
	IObservableValue getMinValue();

	/**
	 * Returns the value of the '<em><b>Max Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * Returns an optional observable value that designates the minimum value of the widget if set.
	 * <p>
	 * This method is only called once in the life time this attribute, so the return value need not
	 * be cached.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Max Value</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_MaxValue()
	 * @generated
	 */
	IObservableValue getMaxValue();

	/**
	 * Returns the value of the '<em><b>Tooltip Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * Returns an optional observable value that designates the tool tip of the widget if set.
	 * <p>
	 * This method is only called once in the life time this attribute, so the return value need not
	 * be cached.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Tooltip Value</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_TooltipValue()
	 * @generated
	 */
	IObservableValue getTooltipValue();

	/**
	 * Returns the current value of {@link #getTooltipValue()} if set.
	 * 
	 * @return the string or <code>null</code>
	 */
	String getTooltip();

	/**
	 * Returns the value of the '<em><b>Font Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * Returns an optional observable value that designates the font of the widget if set.
	 * <p>
	 * This method is only called once in the life time this attribute, so the return value need not
	 * be cached.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Font Value</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_FontValue()
	 * @generated
	 */
	IObservableValue getFontValue();

	/**
	 * Returns the current value of {@link #getFontValue()} if set.
	 * 
	 * @return the font or <code>null</code>
	 */
	Font getFont();

	/**
	 * Returns the value of the '<em><b>Image Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * Returns an optional observable value that designates the image of the widget if set.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Image Value</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_ImageValue()
	 * @generated
	 */
	IObservableValue getImageValue();

	/**
	 * Returns the current value of {@link #getImageValue()} if set.
	 * 
	 * @return the image or <code>null</code>
	 */
	Image getImage();

	/**
	 * Returns the value of the '<em><b>Foreground Value</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * Returns an optional observable value that designates the foreground color of the widget if
	 * set.
	 * <p>
	 * This method is only called once in the life time this attribute, so the return value need not
	 * be cached.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Foreground Value</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_ForegroundValue()
	 * @generated
	 */
	IObservableValue getForegroundValue();

	/**
	 * Returns the current value of {@link #getForegroundValue()} if set.
	 * 
	 * @return the color or <code>null</code>
	 */
	Color getForeground();

	/**
	 * Returns the value of the '<em><b>Background Value</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * Returns an optional observable value that designates the background color of the widget if
	 * set.
	 * <p>
	 * This method is only called once in the life time this attribute, so the return value need not
	 * be cached.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Background Value</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_BackgroundValue()
	 * @generated
	 */
	IObservableValue getBackgroundValue();

	/**
	 * Returns the current value of {@link #getBackgroundValue()} if set.
	 * 
	 * @return the color or <code>null</code>
	 */
	Color getBackground();

	/**
	 * Returns the value of the '<em><b>Enabled Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * Returns an optional observable value that designates the enabled of the widget if set.
	 * <p>
	 * This method is only called once in the life time this attribute, so the return value need not
	 * be cached.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Enabled Value</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_EnabledValue()
	 * @generated
	 */
	IObservableValue getEnabledValue();

	/**
	 * Returns the current value of {@link #getEnabledValue()} if set.
	 * 
	 * @return the Boolean value or <code>null</code>
	 */
	Boolean isEnabled();

	/**
	 * Returns the value of the '<em><b>Cursor Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * Returns an optional observable value that designates the cursor of the widget if set.
	 * <p>
	 * This method is only called once in the life time this attribute, so the return value need not
	 * be cached.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Cursor Value</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_CursorValue()
	 * @generated
	 */
	IObservableValue getCursorValue();

	/**
	 * Returns the current value of {@link #getCursorValue()} if set.
	 * 
	 * @return the cursor or <code>null</code>
	 */
	Cursor getCursor();

	/**
	 * Returns the value of the '<em><b>Style Range List</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * Returns an optional observable list that designates the style ranges of the widget if set and
	 * supported by the widget.
	 * <p>
	 * This method is only called once in the life time this attribute, so the return value need not
	 * be cached.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Style Range List</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_StyleRangeList()
	 * @generated
	 */
	IObservableList getStyleRangeList();

	/**
	 * Returns the current value of {@link #getStyleRangeList()} if set.
	 * 
	 * @return the list or <code>null</code>
	 */
	List<StyleRange> getStyleRanges();

	/**
	 * Returns the value of the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * Returns whether the value can be changed in the widget. E.g. the text attribute of a
	 * {@link Text} widget can be changed, whereas the same attribute of the {@link Label} cannot.
	 * <p>
	 * This method is only called once in the life time this attribute, so the return value need not
	 * be cached.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Changeable</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_Changeable()
	 * @generated
	 */
	boolean isChangeable();

	/**
	 * Returns the value of the '<em><b>Field Assist Adapter</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * Returns an optional adapter that is used to install field assist in the widget.
	 * <p>
	 * This method is only called once in the life time this attribute, so the return value need not
	 * be cached.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Field Assist Adapter</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_FieldAssistAdapter()
	 * @generated
	 */
	IControlContentAdapter getFieldAssistAdapter();

	/**
	 * Returns the value of the '<em><b>Field Assist Control</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * The field assist control for an UI attribute is the control on which the
	 * {@link #getFieldAssistAdapter()} should be installed. It defaults to the widget itself, if
	 * this is a {@link Control}.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Field Assist Control</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_FieldAssistControl()
	 * @generated
	 */
	Control getFieldAssistControl();

	/**
	 * Returns the value of the '<em><b>Image Decorations</b></em>' containment reference list. The
	 * list contents are of type {@link com.rcpcompany.uibindings.IUIAttributeImageDecoration}. It
	 * is bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.IUIAttributeImageDecoration#getAttribute <em>Attribute</em>}
	 * '. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Decorations</em>' reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Image Decorations</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttribute_ImageDecorations()
	 * @see com.rcpcompany.uibindings.IUIAttributeImageDecoration#getAttribute
	 * @generated
	 */
	EList<IUIAttributeImageDecoration> getImageDecorations();

	/**
	 * Returns the image decoration for the specific position of the control of this attribute.
	 * 
	 * @param position the position
	 * @param outside if the decoration is outside the bounds of the control
	 * @return the recoration or <code>null</code> if the widget of the attribute is not a
	 *         {@link Control}.
	 */
	IUIAttributeImageDecoration getImageDecoration(DecorationPosition position, boolean outside);

	/**
	 * Updates all current image decorations with the specified control and inner and outer bounds.
	 * <p>
	 * The control is the owner of the attribute and the bounds the area inside the control that are
	 * used for the attribute. The bounds are relative to the location of the control.
	 * <p>
	 * Both inner and outer bounds are provided: the inner bounds specify the area in the control
	 * that house the content of the control - it excludes the borders, combo box arrows, etc. The
	 * outer bounds are the area outside the control.
	 * <p>
	 * For an ordinary control like a {@link Text} or {@link Combo}, the bounds are the inside
	 * bounds of the control; for {@link Table}, {@link Tree} or Grid, it is the area of the
	 * specific cell in the control.
	 * 
	 * @param control the control of the attribute
	 * @param innerBounds the inner bounds of the control
	 * @param outerBounds the outer bounds of the control
	 */
	void updateImageDecorations(Control control, Rectangle innerBounds, Rectangle outerBounds);
} // IUIAttribute
