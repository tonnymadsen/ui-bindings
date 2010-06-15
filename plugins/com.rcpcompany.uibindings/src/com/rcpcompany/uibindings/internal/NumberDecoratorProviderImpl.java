/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.rcpcompany.uibindings.INumberDecoratorProvider;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.internal.decorators.NumberBindingDecorator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Number Decorator Provider</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.NumberDecoratorProviderImpl#getFormat <em>Format
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class NumberDecoratorProviderImpl extends DecoratorProviderImpl implements INumberDecoratorProvider {
	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected String format = FORMAT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NumberDecoratorProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.NUMBER_DECORATOR_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFormat(String newFormat) {
		final String oldFormat = format;
		format = newFormat;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.NUMBER_DECORATOR_PROVIDER__FORMAT,
					oldFormat, format));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IUIBindingsPackage.NUMBER_DECORATOR_PROVIDER__FORMAT:
			return getFormat();
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
		case IUIBindingsPackage.NUMBER_DECORATOR_PROVIDER__FORMAT:
			setFormat((String) newValue);
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
		case IUIBindingsPackage.NUMBER_DECORATOR_PROVIDER__FORMAT:
			setFormat(FORMAT_EDEFAULT);
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
		case IUIBindingsPackage.NUMBER_DECORATOR_PROVIDER__FORMAT:
			return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals(format);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (format: "); //$NON-NLS-1$
		result.append(format);
		result.append(')');
		return result.toString();
	}

	@Override
	public void providerReader(String id, IConfigurationElement providerCE, IConfigurationElement childCE) {
		String attr;
		attr = childCE.getAttribute("format"); //$NON-NLS-1$
		setFormat(attr);

		super.providerReader(id, providerCE, childCE);
	}

	@Override
	public IUIBindingDecorator getDecorator() {
		return new NumberBindingDecorator(this);
	}
} // NumberDecoratorProviderImpl
