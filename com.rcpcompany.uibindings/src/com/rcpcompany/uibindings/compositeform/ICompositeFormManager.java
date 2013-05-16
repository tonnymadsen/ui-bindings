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
package com.rcpcompany.uibindings.compositeform;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.internal.compositeform.CompositeFormManagerImpl;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Sub Form Manager</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormManager#getForms <em>Forms</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormManager()
 * @generated
 */
public interface ICompositeFormManager extends EObject {
	/**
	 * Factory methods for {@link ICompositeFormManager}.
	 */
	public final class Factory {
		private Factory() {
		}

		/**
		 * Returns the singleton manager.
		 * 
		 * @return the manager
		 */
		public static ICompositeFormManager getManager() {
			return CompositeFormManagerImpl.getManager();
		}
	}

	/**
	 * Returns the value of the '<em><b>Forms</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor}
	 * . It is bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor#getManager
	 * <em>Manager</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forms</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Forms</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormManager_Forms()
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor#getManager
	 * @generated
	 */
	EList<ICompositeFormDescriptor> getForms();

} // ISubFormManager
