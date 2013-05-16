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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ui.forms.IMessage;

/**
 * <!-- begin-user-doc --> This interface encapsulates a single message that can be shown for a
 * binding and/or in a form/wizard/whatever.
 * <p>
 * Messages exists in one or two states:
 * <p>
 * A message is said to be <em>bound</em> if {@link #getBinding()} returns non-<code>null</code>,
 * and <em>unbound</em> otherwise. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IBindingMessage#getBinding <em>Binding</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingMessage#getMessage <em>Message</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingMessage#getSeverity <em>Severity</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingMessage#getMessageType <em>Message Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingMessage#getPrefix <em>Prefix</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingMessage#getTargets <em>Targets</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingMessage#getData <em>Data</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingMessage#getSource <em>Source</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingMessage#getCode <em>Code</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingMessage#getDetails <em>Details</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingMessage()
 * @generated
 */
public interface IBindingMessage extends EObject, IMessage {
	/**
	 * Returns whether this message supersedes the specified "other" message.
	 * <p>
	 * This is used to let some messages - e.g. those that comes from the data binding - overrule
	 * other messages - e.g. those that comes from the validation.
	 * 
	 * @param otherMessage the other messages
	 * @return <code>true</code> if this message supersedes the other message, false otherwise
	 */
	boolean supersedes(IBindingMessage otherMessage);

	/**
	 * The possible matching algorithms used in
	 * {@link IBindingMessage#matches(EObject, EStructuralFeature, Object, boolean)}.
	 */
	public enum FeatureMatchingAlgorithm {
		/**
		 * Any message for the object is matches irrespectively of whether it has a feature or not -
		 * e.g. the feature is ignored.
		 */
		IGNORE,
		/**
		 * A message only matches if both the object and the feature match.
		 */
		EXACT,
		/**
		 * A message matches if the feature match or it is an object message - e.g. the feature is
		 * <code>null</code>.
		 */
		EXACT_OR_NULL
	}

	/**
	 * Matches this message against the specified object and feature returns whether a match is
	 * found.
	 * <p>
	 * The algorithm depends on the matching mode
	 * 
	 * @param obj the object to match against
	 * @param feature the feature to match against or <code>null</code>
	 * @param key TODO
	 * @param algorithm the feature matching algorithm
	 * @return <code>true</code> if this message matches the object and feature
	 */
	boolean matches(EObject obj, EStructuralFeature feature, Object key, FeatureMatchingAlgorithm algorithm);

	/**
	 * Returns the value of the '<em><b>Binding</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * Can be <code>null</code> if the message is not associated with a specific binding.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Binding</em>' reference.
	 * @see #setBinding(IValueBinding)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingMessage_Binding()
	 * @generated
	 */
	IValueBinding getBinding();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IBindingMessage#getBinding
	 * <em>Binding</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Binding</em>' reference.
	 * @see #getBinding()
	 * @generated
	 */
	void setBinding(IValueBinding value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * This is the text of the message.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingMessage_Message()
	 * @generated
	 */
	@Override
	String getMessage();

	/**
	 * Returns the value of the '<em><b>Message Type</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * This is found from the severity for backward compability with {@link IMessage}.
	 * <p>
	 * Not to be overriden...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Message Type</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingMessage_MessageType()
	 * @generated
	 */
	@Override
	int getMessageType();

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute. The literals are from the
	 * enumeration {@link com.rcpcompany.uibindings.BindingMessageSeverity}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see com.rcpcompany.uibindings.BindingMessageSeverity
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingMessage_Severity()
	 * @generated
	 */
	BindingMessageSeverity getSeverity();

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The prefix is prepended to the {@link #getMessage() message string} in global context.
	 * <p>
	 * Always ends with ": ". Never <code>null</code>.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingMessage_Prefix()
	 * @generated
	 */
	@Override
	String getPrefix();

	/**
	 * Returns the value of the '<em><b>Targets</b></em>' reference list. The list contents are of
	 * type {@link com.rcpcompany.uibindings.IBindingMessageTarget}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targets</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Targets</em>' reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingMessage_Targets()
	 * @generated
	 */
	EList<IBindingMessageTarget> getTargets();

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * Can be <code>null</code> if the message is not associated with specific source data.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingMessage_Data()
	 * @generated
	 */
	@Override
	Object getData();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * Often the URI for the sub-system that "issued" the message.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingMessage_Source()
	 * @generated
	 */
	String getSource();

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The code identifies this message within the source. Used when quick fixes are found.
	 * <p>
	 * {@link Integer#MIN_VALUE} means no code is available.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingMessage_Code()
	 * @generated
	 */
	int getCode();

	/**
	 * Returns the value of the '<em><b>Details</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Details</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Details</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingMessage_Details()
	 * @generated
	 */
	String getDetails();

} // IBindingMessage
