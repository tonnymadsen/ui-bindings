/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;

import com.rcpcompany.uibindings.IJavaDecoratorProvider;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Java Decorator Provider</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class JavaDecoratorProviderImpl extends DecoratorProviderImpl implements IJavaDecoratorProvider {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JavaDecoratorProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.JAVA_DECORATOR_PROVIDER;
	}

	@Override
	public IUIBindingDecorator getDecorator() {
		try {
			return (IUIBindingDecorator) getChildCE().createExecutableExtension(InternalConstants.CLASS_TAG);
		} catch (final CoreException ex) {
			LogUtils.error(getChildCE(), ex);
		}
		return null;
	}
} // JavaDecoratorProviderImpl
