/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.compositeform;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.internal.compositeform.CompositeFormManagerImpl;
import com.rcpcompany.uibindings.utils.IFormCreator;

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

		public static ICompositeFormManager getManager() {
			return CompositeFormManagerImpl.getManager();
		}

		/**
		 * Creates the composite form for the specified ID.
		 * 
		 * @param form the form that will contain the composite form
		 * @param id the ID of the composite form
		 * @return the sub form
		 */
		public static ICompositeForm createForm(IFormCreator form, String id) {
			return CompositeFormManagerImpl.createForm(form, id);
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
