/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.navigator;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Navigator Manager</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.navigator.INavigatorManager#getModelTypes <em>Model Types
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.navigator.INavigatorManager#isUseGenericEditorPartFallback
 * <em>Use Generic Editor Part Fallback</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.navigator.INavigatorManager#isPinEditorByDefault <em>Pin
 * Editor By Default</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.navigator.INavigatorManager#isOpenMustOpenNew <em>Open Must
 * Open New</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getNavigatorManager()
 * @generated
 */
public interface INavigatorManager extends EObject {
	/**
	 * Factory information for {@link INavigatorManager}.
	 */
	public static final class Factory {
		/**
		 * Cannot be instantiated
		 */
		private Factory() {
		}

		/**
		 * Returns the manager.
		 * 
		 * @return the manager
		 */
		public static INavigatorManager getManager() {
			return INavigatorModelFactory.eINSTANCE.getManager();
		}
	}

	/**
	 * Returns the value of the '<em><b>Model Types</b></em>' reference list. The list contents are
	 * of type {@link com.rcpcompany.uibindings.navigator.IEditorModelType}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Types</em>' map isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Types</em>' reference list.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getNavigatorManager_ModelTypes()
	 * @generated
	 */
	EList<IEditorModelType> getModelTypes();

	/**
	 * Finds the {@link IEditorModelType} for the specified object if one exists already.
	 * 
	 * @param obj the object to look up
	 * @return the editor mode type or <code>null</code> if none exists
	 */
	IEditorModelType getModelType(EObject obj);

	/**
	 * Returns the value of the '<em><b>Use Generic Editor Part Fallback</b></em>' attribute. The
	 * default value is <code>"true"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Generic Editor Part Fallback</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Use Generic Editor Part Fallback</em>' attribute.
	 * @see #setUseGenericEditorPartFallback(boolean)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getNavigatorManager_UseGenericEditorPartFallback()
	 * @generated
	 */
	boolean isUseGenericEditorPartFallback();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.navigator.INavigatorManager#isUseGenericEditorPartFallback
	 * <em>Use Generic Editor Part Fallback</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Use Generic Editor Part Fallback</em>' attribute.
	 * @see #isUseGenericEditorPartFallback()
	 * @generated
	 */
	void setUseGenericEditorPartFallback(boolean value);

	/**
	 * Returns the value of the '<em><b>Pin Editor By Default</b></em>' attribute. The default value
	 * is <code>"false"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pin Editor By Default</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Pin Editor By Default</em>' attribute.
	 * @see #setPinEditorByDefault(boolean)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getNavigatorManager_PinEditorByDefault()
	 * @generated
	 */
	boolean isPinEditorByDefault();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.navigator.INavigatorManager#isPinEditorByDefault
	 * <em>Pin Editor By Default</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Pin Editor By Default</em>' attribute.
	 * @see #isPinEditorByDefault()
	 * @generated
	 */
	void setPinEditorByDefault(boolean value);

	/**
	 * Returns the value of the '<em><b>Open Must Open New</b></em>' attribute. The default value is
	 * <code>"false"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Open Must Open New</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Open Must Open New</em>' attribute.
	 * @see #setOpenMustOpenNew(boolean)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getNavigatorManager_OpenMustOpenNew()
	 * @generated
	 */
	boolean isOpenMustOpenNew();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.navigator.INavigatorManager#isOpenMustOpenNew
	 * <em>Open Must Open New</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Open Must Open New</em>' attribute.
	 * @see #isOpenMustOpenNew()
	 * @generated
	 */
	void setOpenMustOpenNew(boolean value);

	/**
	 * Finds and returns the best possible editor part descriptor for the specified object.
	 * <p>
	 * If the object is <code>null</code>, <code>null</code> is returned.
	 * 
	 * @param obj the object to find a descriptor for or <code>null</code>
	 * @return the descriptor or <code>null</code>
	 */
	IEditorPartDescriptor getEditorPartDescriptor(EObject obj);

	/**
	 * Opens and returns a view for the specified object.
	 * <p>
	 * And existing view for the specified object is automatically re-used.
	 * <p>
	 * Re-uses any old {@link IEditorPartView#isPinned() un-pinned} view instead of creating a new
	 * view.
	 * 
	 * @param obj the object of the new view
	 * @return the view
	 */
	IEditorPartView openView(EObject obj);

	/**
	 * Returns a collection of all existing views in the active {@link IWorkbenchWindow}.
	 * 
	 * @return the collection of views
	 */
	Collection<IEditorPartView> getAllViews();

	/**
	 * Closes all existing views (whether pinned or not).
	 */
	void closeAllViews();
} // INavigatorManager
