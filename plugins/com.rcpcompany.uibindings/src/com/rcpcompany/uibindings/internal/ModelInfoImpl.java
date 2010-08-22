/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.IModelInfo;
import com.rcpcompany.uibindings.IUIBindingsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model Info</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class ModelInfoImpl extends EObjectImpl implements IModelInfo {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.MODEL_INFO;
	}

	private Map<String, Object> myDeclaredArguments = null;

	@Override
	public Map<String, Object> getDeclaredArguments() {
		if (myDeclaredArguments == null) {
			myDeclaredArguments = new HashMap<String, Object>();
		}
		return myDeclaredArguments;
	}

	@Override
	public boolean hasDeclaredArguments() {
		return myDeclaredArguments != null;
	}

} // ModelInfoImpl
