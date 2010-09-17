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
package com.rcpcompany.uibindings.moao.internal;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.moao.IMOAOMessage;
import com.rcpcompany.uibindings.moao.IMOAOPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>MOAO</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.moao.internal.MOAOImpl#getMessages <em>Messages</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MOAOImpl extends EObjectImpl implements IMOAO {
	/**
	 * The cached value of the '{@link #getMessages() <em>Messages</em>}' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMessages()
	 * @generated
	 * @ordered
	 */
	protected EList<IMOAOMessage> messages;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MOAOImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IMOAOPackage.Literals.MOAO;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IMOAOMessage> getMessages() {
		if (messages == null) {
			messages = new EObjectContainmentWithInverseEList<IMOAOMessage>(IMOAOMessage.class, this,
					IMOAOPackage.MOAO__MESSAGES, IMOAOPackage.MOAO_MESSAGE__OBJECT);
		}
		return messages;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case IMOAOPackage.MOAO__MESSAGES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getMessages()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case IMOAOPackage.MOAO__MESSAGES:
			return ((InternalEList<?>) getMessages()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IMOAOPackage.MOAO__MESSAGES:
			return getMessages();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case IMOAOPackage.MOAO__MESSAGES:
			getMessages().clear();
			getMessages().addAll((Collection<? extends IMOAOMessage>) newValue);
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
		case IMOAOPackage.MOAO__MESSAGES:
			getMessages().clear();
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
		case IMOAOPackage.MOAO__MESSAGES:
			return messages != null && !messages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object getAdapter(Class adapter) {
		return Platform.getAdapterManager().getAdapter(this, adapter);
	}

	@Override
	public boolean isValid(DiagnosticChain diagnostic, Map<Object, Object> context) {
		return true;
	}

	@Override
	public void removeMessagesByOwner(String owner) {
		final TreeIterator<EObject> allContents = eAllContents();
		while (allContents.hasNext()) {
			final EObject next = allContents.next();
			if (!(next instanceof IMOAO)) {
				continue;
			}

			final IMOAO mo = (IMOAO) next;
			if (!mo.eIsSet(IMOAOPackage.Literals.MOAO__MESSAGES)) {
				continue;
			}

			for (final IMOAOMessage m : mo.getMessages().toArray(new IMOAOMessage[mo.getMessages().size()])) {
				if (owner.equals(m.getOwner())) {
					mo.getMessages().remove(m);
				}
			}
		}
	}

} // MOAOImpl
