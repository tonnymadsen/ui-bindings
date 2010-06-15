/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>UI Binding Decorator</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IUIBindingDecorator#getBinding <em>Binding</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIBindingDecorator#isChangeable <em>Changeable</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIBindingDecorator#getModelToUIConverter <em>Model To UI
 * Converter</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIBindingDecorator#getUIToModelConverter <em>UI To Model
 * Converter</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIBindingDecorator#getUIToModelAfterConvertValidator <em>UI
 * To Model After Convert Validator</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIBindingDecorator#getValidUIList <em>Valid UI List</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIBindingDecorator()
 * @generated
 */
public interface IUIBindingDecorator extends EObject, IDisposable {
	/**
	 * Initializes a decorator with the specific bound binding.
	 * 
	 * @param binding the base binding
	 */
	public void init(IValueBinding binding);

	/**
	 * Updates the visuals of this binding.
	 */
	public void update();

	/**
	 * Sets up all needed data bindings for this decorator.
	 */
	public void decorate();

	/**
	 * Returns an {@link IObservableValue observable value} that can be used to monitor changes to
	 * the data that is used to show the binding in the UI attribute.
	 * <p>
	 * E.g. a decorator that can show a specific {@link EObject}, will probably use one or more
	 * specific features of the object to identify the object. The returned observable value can
	 * then be used to monitor changes to these features.
	 * <p>
	 * The value itself of the returned observable value is <em>not</em> used.
	 * 
	 * @param value the observable value of the specific binding
	 * 
	 * @return the observable value for the display
	 */
	public IObservableValue getDisplayObservableValue(IObservableValue value);

	/**
	 * Returns the value of the '<em><b>Binding</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Binding</em>' reference.
	 * @see #setBinding(IValueBinding)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIBindingDecorator_Binding()
	 * @generated
	 */
	IValueBinding getBinding();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IUIBindingDecorator#getBinding
	 * <em>Binding</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Binding</em>' reference.
	 * @see #getBinding()
	 * @generated
	 */
	void setBinding(IValueBinding value);

	/**
	 * Returns the value of the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changeable</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Changeable</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIBindingDecorator_Changeable()
	 * @generated
	 */
	boolean isChangeable();

	/**
	 * Returns the value of the '<em><b>Model To UI Converter</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model To UI Converter</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model To UI Converter</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIBindingDecorator_ModelToUIConverter()
	 * @generated
	 */
	IConverter getModelToUIConverter();

	/**
	 * Returns the value of the '<em><b>UI To Model Converter</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UI To Model Converter</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>UI To Model Converter</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIBindingDecorator_UIToModelConverter()
	 * @generated
	 */
	IConverter getUIToModelConverter();

	/**
	 * Returns the value of the '<em><b>UI To Model After Convert Validator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UI To Model After Convert Validator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>UI To Model After Convert Validator</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIBindingDecorator_UIToModelAfterConvertValidator()
	 * @generated
	 */
	IValidator getUIToModelAfterConvertValidator();

	/**
	 * Returns the value of the '<em><b>Valid UI List</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If non-<code>null</code>, this list contains all the valid string values in the UI for use in
	 * context assist and combo boxes.
	 * <p>
	 * The method can be called multiple times, and must return the same object every time.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Valid UI List</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIBindingDecorator_ValidUIList()
	 * @generated
	 */
	IObservableList getValidUIList();

} // IUIBindingDecorator
