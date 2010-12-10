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

import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.swt.ISWTObservable;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.internal.bindingMessages.IContextMessageProvider;

/**
 * <!-- begin-user-doc -->
 * <p>
 * The binding of a single UI value in the context.
 * <p>
 * Here a "single UI value" is a widget that holds a single value, such as a {@link Label}, a
 * {@link Text}, a {@link Combo} or similar.
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
 * <li>{@link com.rcpcompany.uibindings.IValueBinding#getModelObservable <em>Model Observable</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IValueBinding#getModelObservableValue <em>Model Observable
 * Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IValueBinding#getModelObject <em>Model Object</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IValueBinding#getModelFeature <em>Model Feature</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IValueBinding#getDecoratorProvider <em>Decorator Provider
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IValueBinding#getDecorator <em>Decorator</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IValueBinding#getUIAttribute <em>UI Attribute</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IValueBinding#getUIObservable <em>UI Observable</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IValueBinding#getCell <em>Cell</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IValueBinding#getMessagePrefix <em>Message Prefix</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IValueBinding#isDynamic <em>Dynamic</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getValueBinding()
 * @generated
 */
public interface IValueBinding extends IBinding, IArgumentProvider {
	/**
	 * Binds the target (UI) side of this binding to the specific attribute of the specified SWT
	 * widget.
	 * <p>
	 * The exact set of attributes supported by a specific widget is controlled via the
	 * <code>com.rcpcompany.uiBindings.uiBindings/uiAttribute</code> extension point.
	 * 
	 * @param widget the widget to bind to
	 * @param attribute the attribute of the widget to bind to
	 * @return <code>this</code>
	 */
	IValueBinding ui(Widget widget, String attribute);

	/**
	 * Binds the target (UI) side of this binding to the principle attribute of the specified SWT
	 * widget.
	 * <p>
	 * Short for <code>widget(widget, "")</code>.
	 * 
	 * @param widget the widget to bind to
	 * @return <code>this</code>
	 */
	IValueBinding ui(Widget widget);

	/**
	 * Binds the target (UI) side of this binding to the specified {@link ISWTObservable SWT
	 * Observable}.
	 * 
	 * @param observable the observable to bind to
	 * @return <code>this</code>
	 */
	IValueBinding ui(ISWTObservableValue observable);

	/**
	 * Binds the target (UI) side of this binding to the specified {@link IUIAttribute UI attribute}
	 * .
	 * <p>
	 * Please note that the ownership of the UI attribute is passed to the binding and it will be
	 * disposed with the binding.
	 * 
	 * @param attribute the attribute
	 * @return <code>this</code>
	 */
	IValueBinding ui(IUIAttribute attribute);

	/**
	 * The control of the UI value, if any.
	 * 
	 * @return the control or <code>null</code>
	 */
	@Override
	Control getControl();

	/**
	 * Binds this binding to the specified EMF feature.
	 * 
	 * @param modelObject the EMF object
	 * @param feature the structural feature
	 * 
	 * @return <code>this</code>
	 */
	IValueBinding model(EObject modelObject, EStructuralFeature feature);

	/**
	 * Binds this binding to the specified EMF feature.
	 * 
	 * @param modelObject an observable value with the EMF object
	 * @param feature the structural feature
	 * 
	 * @return <code>this</code>
	 */
	IValueBinding model(IObservableValue modelObject, EStructuralFeature feature);

	/**
	 * Binds this binding directly to the specified observable.
	 * 
	 * @param observable the observable to bind to
	 * @return <code>this</code>
	 */
	IValueBinding model(IObservableValue observable);

	/**
	 * Sets the type of the binding. Defaults to "<code>basic</code>".
	 * 
	 * @param type the type name
	 * 
	 * @return <code>this</code>
	 */
	@Override
	IValueBinding type(String type);

	/**
	 * Sets an argument for the binding. Some arguments are deduced from the EMF binding.
	 * 
	 * @param name the argument name
	 * @param value the argument value
	 * 
	 * @return <code>this</code>
	 */
	@Override
	IValueBinding arg(String name, Object value);

	/**
	 * Sets a complete set of arguments for the binding.
	 * 
	 * @param arguments the arguments to set
	 * @return <code>this</code>
	 */
	@Override
	IValueBinding args(Map<String, Object> arguments);

	/**
	 * Short for <code>arg({@link IBinding#ARG_READONLY}, true)</code>.
	 * 
	 * @return <code>this</code>
	 */
	@Override
	IValueBinding readonly();

	/**
	 * Short for <code>arg({@link IBinding#ARG_DYNAMIC}, true)</code>.
	 * 
	 * @return <code>this</code>
	 */
	@Override
	IValueBinding dynamic();

	/**
	 * Short for <code>arg({@link IBinding#ARG_LABEL}, label)</code>.
	 * 
	 * @param label the label to add
	 * @return <code>this</code>
	 */
	@Override
	IValueBinding label(String label);

	/**
	 * Short for <code>getId(id)</code>.
	 * 
	 * @param id the new id
	 * @return <code>this</code>
	 */
	@Override
	IValueBinding id(String id);

	/**
	 * Short for <code>arg({@link IBinding#ARG_VALID_VALUES}, list)</code>.
	 * 
	 * @param list the list of valid values
	 * 
	 * @return <code>this</code>
	 */
	@Override
	IValueBinding validValues(IObservableList list);

	/**
	 * Short for <code>arg({@link IBinding#ARG_VALID_VALUES}, list)</code>.
	 * 
	 * @param list the list of valid values
	 * @param type the type of the elements
	 * 
	 * @return <code>this</code>
	 */
	IValueBinding validValues(List<?> list, Object type);

	/**
	 * Short for <code>arg({@link IBinding#ARG_VALID_VALUES}, list)</code>.
	 * 
	 * @param obj the object of the list
	 * @param ref reference with the list
	 * 
	 * @return <code>this</code>
	 */
	@Override
	IValueBinding validValues(EObject obj, EReference ref);

	/**
	 * Sets the focus on the control or cell of this binding if possible.
	 * <p>
	 * Also all TabFolder, CTabFolder, Section, and ExpandableComposite between the widget and the
	 * Composite of the {@link IBindingContext} is configured to show the correct child.
	 */
	void setFocus();

	/**
	 * Forces an immediate update of the UI side of the binding.
	 */
	void updateUI();

	/**
	 * Creates a usable control for this binding based on {@link IBinding#ARG_PREFERRED_CONTROL}
	 * and/or {@link Constants#ARG_PREFERRED_CELL_EDITOR}.
	 * 
	 * <p>
	 * The control is <em>not</em> set as the UI control for the binding automatically!
	 * <p>
	 * If consult {@link Constants#ARG_PREFERRED_CELL_EDITOR} first if creating a cell editor.
	 * 
	 * @param parent the parent composite of the new control
	 * @param style the style
	 * @param cellEditor <code>true</code> if for a cell editor, <code>false</code> if not
	 * @return the new control
	 */
	Control createPreferredControl(Composite parent, int style, boolean cellEditor);

	/**
	 * Returns the value of the '<em><b>Model Observable</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Model Observable</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Observable</em>' attribute.
	 * @see #setModelObservable(IObservable)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getValueBinding_ModelObservable()
	 * @generated
	 */
	IObservable getModelObservable();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IValueBinding#getModelObservable
	 * <em>Model Observable</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Model Observable</em>' attribute.
	 * @see #getModelObservable()
	 * @generated
	 */
	void setModelObservable(IObservable value);

	/**
	 * Returns the value of the '<em><b>Model Observable Value</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Observable Value</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Observable Value</em>' attribute.
	 * @see #setModelObservableValue(IObservableValue)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getValueBinding_ModelObservableValue()
	 * @generated
	 */
	IObservableValue getModelObservableValue();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IValueBinding#getModelObservableValue
	 * <em>Model Observable Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Model Observable Value</em>' attribute.
	 * @see #getModelObservableValue()
	 * @generated
	 */
	void setModelObservableValue(IObservableValue value);

	/**
	 * Returns the value of the '<em><b>Model Object</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * The is normally the object that contains the feature that is shown in the binding.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Object</em>' reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getValueBinding_ModelObject()
	 * @generated
	 */
	EObject getModelObject();

	/**
	 * Returns the value of the '<em><b>Model Feature</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Feature</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Feature</em>' reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getValueBinding_ModelFeature()
	 * @generated
	 */
	EStructuralFeature getModelFeature();

	/**
	 * Returns the value of the '<em><b>Decorator Provider</b></em>' reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Decorator Provider</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Decorator Provider</em>' reference.
	 * @see #setDecoratorProvider(IDecoratorProvider)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getValueBinding_DecoratorProvider()
	 * @generated
	 */
	IDecoratorProvider getDecoratorProvider();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IValueBinding#getDecoratorProvider
	 * <em>Decorator Provider</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Decorator Provider</em>' reference.
	 * @see #getDecoratorProvider()
	 * @generated
	 */
	void setDecoratorProvider(IDecoratorProvider value);

	/**
	 * Returns the value of the '<em><b>Decorator</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decorator</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Decorator</em>' reference.
	 * @see #setDecorator(IUIBindingDecorator)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getValueBinding_Decorator()
	 * @generated
	 */
	IUIBindingDecorator getDecorator();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IValueBinding#getDecorator
	 * <em>Decorator</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Decorator</em>' reference.
	 * @see #getDecorator()
	 * @generated
	 */
	void setDecorator(IUIBindingDecorator value);

	/**
	 * Returns the value of the '<em><b>UI Attribute</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UI Attribute</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>UI Attribute</em>' reference.
	 * @see #setUIAttribute(IUIAttribute)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getValueBinding_UIAttribute()
	 * @generated
	 */
	IUIAttribute getUIAttribute();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IValueBinding#getUIAttribute
	 * <em>UI Attribute</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>UI Attribute</em>' reference.
	 * @see #getUIAttribute()
	 * @generated
	 */
	void setUIAttribute(IUIAttribute value);

	/**
	 * Returns the value of the '<em><b>UI Observable</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * This observable value is the current value of the UI Attribute of the binding.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>UI Observable</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getValueBinding_UIObservable()
	 * @generated
	 */
	IObservableValue getUIObservable();

	/**
	 * Returns the value of the '<em><b>Cell</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Cell</em>' reference.
	 * @see #setCell(IValueBindingCell)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getValueBinding_Cell()
	 * @generated
	 */
	IValueBindingCell getCell();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IValueBinding#getCell <em>Cell</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Cell</em>' reference.
	 * @see #getCell()
	 * @generated
	 */
	void setCell(IValueBindingCell value);

	/**
	 * Returns the value of the '<em><b>Message Prefix</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The message prefix is uses for all messages related to this binding.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Message Prefix</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getValueBinding_MessagePrefix()
	 * @generated
	 */
	String getMessagePrefix();

	/**
	 * Returns the value of the '<em><b>Dynamic</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * Returns whether this is a dynamic binding or not.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Dynamic</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getValueBinding_Dynamic()
	 * @generated
	 */
	boolean isDynamic();

	/**
	 * Returns whether the current model object of this binding is for the specified class and
	 * feature.
	 * 
	 * @param objClass the expected class of the model object - can be <code>null</code>
	 * @param sf the expected structural feature
	 * @return <code>true</code> if the model object is for the specified object (if non-
	 *         <code>null</code>) and feature
	 */
	boolean isEClassFeature(Class<? extends EObject> objClass, EStructuralFeature sf);

	/**
	 * Returns a list of all known errors for this binding.
	 * <p>
	 * If a {@link IContextMessageProvider} service is found for this binding, the messages from
	 * this is used. Otherwise the data binding validation status is used.
	 * 
	 * @return a list of the current errors for this binding
	 */
	List<String> getErrors();
} // IValueBinding
