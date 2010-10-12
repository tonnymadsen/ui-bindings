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

import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.internal.bindingDataTypes.BindingDataTypeFactory;

/**
 * <!-- begin-user-doc -->
 * <p>
 * This interface is used to adapt between the actual EMF data type of a binding and the needed
 * information in the UI Bindings framework.
 * <p>
 * Adapters exists for
 * <ul>
 * <li>{@link EStructuralFeature}</li>
 * <li>{@link EClassifier}</li>
 * </ul>
 * The actual adapters are constructed in {@link BindingDataTypeFactory}.
 * </p>
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IBindingDataType#getName <em>Name</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingDataType#getValueType <em>Value Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingDataType#getEType <em>EType</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingDataType#getDataType <em>Data Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingDataType#getEAnnotation <em>EAnnotation</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingDataType#getParentDataType <em>Parent Data Type
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingDataType#isRequired <em>Required</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingDataType#isChangeable <em>Changeable</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingDataType#isUnsettable <em>Unsettable</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingDataType()
 * @generated
 */
public interface IBindingDataType extends EObject {
	/**
	 * The factory methods for {@link IBindingDataType}.
	 */
	final class Factory {
		private Factory() {
		}

		/**
		 * Creates and returns a new {@link IBindingDataType binding data type} appropriate for the
		 * specified element.
		 * <p>
		 * The result is cached and reused.
		 * <p>
		 * The context is used to get a more accurate result when the element is a structural
		 * feature - or something that evaluates to that.
		 * 
		 * @param context the context for the element - possibly <code>null</code>
		 * @param element the element to return a data type for
		 * 
		 * @return the data type object or <code>null</code>
		 */
		public static IBindingDataType create(Object context, Object element) {
			return BindingDataTypeFactory.create(context, element);
		}

		/**
		 * Creates and returns a new {@link IBindingDataType binding data type} appropriate for the
		 * specified observable list.
		 * 
		 * @param list the list
		 * @return the data type object or <code>null</code>
		 */
		public static IBindingDataType create(IObservableList list) {
			if (list instanceof IObserving) return create(((IObserving) list).getObserved(), list.getElementType());
			return create(null, list.getElementType());
		}

		/**
		 * Creates and returns a new {@link IBindingDataType binding data type} appropriate for the
		 * specified observable value.
		 * 
		 * @param value the value
		 * @return the data type object or <code>null</code>
		 */
		public static IBindingDataType create(IObservableValue value) {
			if (value instanceof IObserving) return create(((IObserving) value).getObserved(), value.getValueType());
			return create(null, value.getValueType());
		}

		/**
		 * Returns a list of the {@link IBindingDataType} objects that defines all the super types
		 * of the specified data type.
		 * <p>
		 * If not already calculated, then do that by creating an array with
		 * <ul>
		 * <li>IBDTs for all super types (ECore classes)</li>
		 * <li>IBDTs for all super classes (Java classes) not already added from their Ecore
		 * counterparts</li>
		 * </ul>
		 * 
		 * @param dt the data type to test
		 * @return the super types
		 */
		public static IBindingDataType[] getSuperTypes(IBindingDataType dt) {
			return BindingDataTypeFactory.getSuperTypes(dt);
		}

		/**
		 * Tries to convert a Java class to the corresponding {@link EClassifier}.
		 * <p>
		 * All registered EMF packages are searched.
		 * 
		 * @param cls the class to convert
		 * @return the corresponding classifier or <code>null</code> if not found
		 */
		public static EClassifier convertToClassifier(Class<?> cls) {
			return BindingDataTypeFactory.convertToClassifier(cls);
		}
	}

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * Returns the logical name for a binding based on this data type.
	 * <p>
	 * For a feature-based data type this is the name of the feature, for classifiers this is the
	 * name of the classifier.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingDataType_Name()
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Value Type</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * Returns the value type used for values returned by the factory.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Value Type</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingDataType_ValueType()
	 * @generated
	 */
	Object getValueType();

	/**
	 * Returns the value of the '<em><b>EType</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * This is the EMF type of the data type.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>EType</em>' reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingDataType_EType()
	 * @generated
	 */
	EClassifier getEType();

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * This is the specific class for this data type
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Data Type</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingDataType_DataType()
	 * @generated
	 */
	Class<?> getDataType();

	/**
	 * Returns the value of the '<em><b>EAnnotation</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * Provides the EMF annotations of this data type.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>EAnnotation</em>' reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingDataType_EAnnotation()
	 * @generated
	 */
	EAnnotation getEAnnotation();

	/**
	 * Returns the value of the '<em><b>Parent Data Type</b></em>' reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * Returns the parent data type of this data type if applicable.
	 * <p>
	 * E.g,. for a structural feature, the parent data type is the data type of the
	 * {@link EStructuralFeature#getEType() typed element} of the feature.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent Data Type</em>' reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingDataType_ParentDataType()
	 * @generated
	 */
	IBindingDataType getParentDataType();

	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * <code>true</code> if a value is required for a variable with this data type. Note important
	 * for structural features.
	 * <p>
	 * The EMF <code>required</code> property.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingDataType_Required()
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Returns the value of the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * <code>true</code> if the value of this data type can be changed.
	 * <p>
	 * The EMF <code>changeable</code> property.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Changeable</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingDataType_Changeable()
	 * @generated
	 */
	boolean isChangeable();

	/**
	 * Returns the value of the '<em><b>Unsettable</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * <code>true</code> if this data type supports a special <em>unset</em> value as specified by
	 * {@link EObject#eIsSet(EStructuralFeature)}.
	 * <p>
	 * The EMF <code>unsettable</code> property.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unsettable</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingDataType_Unsettable()
	 * @generated
	 */
	boolean isUnsettable();

	/**
	 * Returns an {@link IArgumentProvider argument provider} with all arguments for this data type
	 * and the specified binding type.
	 * 
	 * @param type the type of the binding
	 * @return the argument provider
	 */
	IArgumentProvider getArgumentProvider(String type);

	/**
	 * Handles any additions of arguments from this data type.
	 * 
	 * @param <ArgumentType> the argument type
	 * @param context the argument context
	 */
	<ArgumentType> void addArguments(IArgumentContext<ArgumentType> context);

	/**
	 * Handles any additions of arguments from the parents of this data type.
	 * 
	 * @param <ArgumentType> the argument type
	 * @param context the argument context
	 * @param visitedDataTypes collection of all visited data types
	 */
	<ArgumentType> void addParentDataTypeArguments(IArgumentContext<ArgumentType> context,
			Collection<IBindingDataType> visitedDataTypes);

	/**
	 * Handles any additions of arguments from the Super Types of this data type.
	 * 
	 * @param <ArgumentType> the argument type
	 * @param context the argument context
	 * @param visitedDataTypes collection of all visited data types
	 */
	<ArgumentType> void addSuperDataTypeArguments(IArgumentContext<ArgumentType> context,
			Collection<IBindingDataType> visitedDataTypes);

	/**
	 * Returns the named argument or <code>null</code> if not set.
	 * <p>
	 * Will look for the argument among the arguments of the binding first and then among the
	 * annotations (declared arguments) of the data type.
	 * 
	 * @param <ArgumentType> the wanted argument type. Currently {@link String}, {@link Boolean} and
	 *            {@link Integer} is supported.
	 * 
	 * @param name the name of the argument
	 * @param type the binding type
	 * @param argumentType the argument type of the wanted argument. Class value of
	 *            &lt;ArgumentType&gt;
	 * @param defaultValue the default value
	 * @return the value or <code>null</code> if not set.
	 */
	<ArgumentType> ArgumentType getArgument(String name, String type, Class<? extends ArgumentType> argumentType,
			ArgumentType defaultValue);

	/**
	 * Returns the named argument or <code>null</code> if not set.
	 * <p>
	 * Will look for the argument in the following places:
	 * <nl>
	 * <li>this data type - this leads to model and feature arguments as well as annotations from
	 * the Ecore model</li>
	 * <li>the Java super types of the current dynamic data type</li>
	 * </nl>
	 * 
	 * @param <ArgumentType> the wanted argument type
	 * 
	 * @param name the name of the argument
	 * @param argumentType the argument type of the wanted argument. Class value of
	 *            &lt;ArgumentType&gt;
	 * @param firstOnly if <code>true</code> only return the first found value, otherwise return all
	 *            found values
	 * @return the value or <code>null</code> if not set.
	 */

	<ArgumentType> List<IArgumentValue<ArgumentType>> getArguments(String name, String type,
			Class<? extends ArgumentType> argumentType, boolean firstOnly);
} // IBindingDataType
