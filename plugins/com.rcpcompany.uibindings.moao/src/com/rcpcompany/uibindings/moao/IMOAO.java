/**
 * <copyright> </copyright> $Id$
 */
package com.rcpcompany.uibindings.moao;

import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>MOAO</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.moao.IMOAO#getMessages <em>Messages</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAO()
 * @generated
 */
public interface IMOAO extends EObject, IAdaptable {
	/**
	 * Returns the value of the '<em><b>Messages</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.moao.IMOAOMessage}. It is bidirectional
	 * and its opposite is '{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getObject
	 * <em>Object</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Messages</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAO_Messages()
	 * @see com.rcpcompany.uibindings.moao.IMOAOMessage#getObject
	 * @generated
	 */
	EList<IMOAOMessage> getMessages();

	/**
	 * Removes all messages from this object and all contained objects (using reflection) given by
	 * the specified owner.
	 * 
	 * @param owner the owner
	 */
	void removeMessagesByOwner(String owner);

	/**
	 * Checks that this object has a valid state and returns any result in the specified
	 * {@link DiagnosticChain}.
	 * 
	 * @param diagnostic the retun chain
	 * @param context context - not used
	 * @return <code>true</code> if valid, <code>false</code> otherwise
	 */
	boolean isValid(DiagnosticChain diagnostic, Map<Object, Object> context);
} // IMOAO
