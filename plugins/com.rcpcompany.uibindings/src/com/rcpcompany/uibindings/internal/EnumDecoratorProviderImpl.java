/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import java.util.Collection;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.IEnumDecoratorProvider;
import com.rcpcompany.uibindings.IEnumDecoratorProviderEntry;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IUIBindingsFactory;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.internal.decorators.EnumBindingDecorator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Enum Decorator Provider</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.EnumDecoratorProviderImpl#isAddingDefaultMappings
 * <em>Adding Default Mappings</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.EnumDecoratorProviderImpl#getBaseMappings <em>Base
 * Mappings</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EnumDecoratorProviderImpl extends DecoratorProviderImpl implements IEnumDecoratorProvider {
	/**
	 * The default value of the '{@link #isAddingDefaultMappings() <em>Adding Default Mappings</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isAddingDefaultMappings()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ADDING_DEFAULT_MAPPINGS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAddingDefaultMappings() <em>Adding Default Mappings</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isAddingDefaultMappings()
	 * @generated
	 * @ordered
	 */
	protected boolean addingDefaultMappings = ADDING_DEFAULT_MAPPINGS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBaseMappings() <em>Base Mappings</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBaseMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<IEnumDecoratorProviderEntry> baseMappings;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EnumDecoratorProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.ENUM_DECORATOR_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isAddingDefaultMappings() {
		return addingDefaultMappings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setAddingDefaultMappings(boolean newAddingDefaultMappings) {
		final boolean oldAddingDefaultMappings = addingDefaultMappings;
		addingDefaultMappings = newAddingDefaultMappings;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.ENUM_DECORATOR_PROVIDER__ADDING_DEFAULT_MAPPINGS, oldAddingDefaultMappings,
					addingDefaultMappings));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IEnumDecoratorProviderEntry> getBaseMappings() {
		if (baseMappings == null) {
			baseMappings = new EObjectContainmentEList<IEnumDecoratorProviderEntry>(IEnumDecoratorProviderEntry.class,
					this, IUIBindingsPackage.ENUM_DECORATOR_PROVIDER__BASE_MAPPINGS);
		}
		return baseMappings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER__BASE_MAPPINGS:
			return ((InternalEList<?>) getBaseMappings()).basicRemove(otherEnd, msgs);
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
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER__ADDING_DEFAULT_MAPPINGS:
			return isAddingDefaultMappings();
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER__BASE_MAPPINGS:
			return getBaseMappings();
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
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER__ADDING_DEFAULT_MAPPINGS:
			setAddingDefaultMappings((Boolean) newValue);
			return;
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER__BASE_MAPPINGS:
			getBaseMappings().clear();
			getBaseMappings().addAll((Collection<? extends IEnumDecoratorProviderEntry>) newValue);
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
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER__ADDING_DEFAULT_MAPPINGS:
			setAddingDefaultMappings(ADDING_DEFAULT_MAPPINGS_EDEFAULT);
			return;
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER__BASE_MAPPINGS:
			getBaseMappings().clear();
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
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER__ADDING_DEFAULT_MAPPINGS:
			return addingDefaultMappings != ADDING_DEFAULT_MAPPINGS_EDEFAULT;
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER__BASE_MAPPINGS:
			return baseMappings != null && !baseMappings.isEmpty();
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
		result.append(" (addingDefaultMappings: "); //$NON-NLS-1$
		result.append(addingDefaultMappings);
		result.append(')');
		return result.toString();
	}

	@Override
	public IUIBindingDecorator getDecorator() {
		return new EnumBindingDecorator(this);
	}

	@Override
	public void providerReader(String id, IConfigurationElement providerCE, IConfigurationElement childCE) {
		super.providerReader(id, providerCE, childCE);

		String attr;
		attr = childCE.getAttribute(InternalConstants.DEFAULT_MAPPINGS_TAG);
		if (attr != null) {
			setAddingDefaultMappings(Boolean.parseBoolean(attr));
		}

		MAPPINGS: for (final IConfigurationElement mapping : childCE.getChildren(InternalConstants.MAPPING_TAG)) {
			final String uiValue = mapping.getAttribute(InternalConstants.UI_TAG);
			if (uiValue == null || uiValue.length() == 0) {
				LogUtils.error(childCE, getId() + ": Required attribute name is empty. Ignored."); //$NON-NLS-1$
				break;
			}
			final String modelValue = mapping.getAttribute(InternalConstants.MODEL_TAG);
			if (modelValue == null || modelValue.length() == 0) {
				LogUtils.error(childCE, getId() + ": Required attribute value is empty. Ignored."); //$NON-NLS-1$
				break;
			}

			for (final IEnumDecoratorProviderEntry e : getBaseMappings()) {
				if (e.getUi().equals(uiValue)) {
					LogUtils.error(childCE, getId() + ": Duplicate name: '" + uiValue + "'. Ignored."); //$NON-NLS-1$ //$NON-NLS-2$
					continue MAPPINGS;
				}
			}

			final IEnumDecoratorProviderEntry entry = IUIBindingsFactory.eINSTANCE.createEnumDecoratorProviderEntry();
			entry.setModel(modelValue);
			entry.setUi(uiValue);

			getBaseMappings().add(entry);
		}
	}

} // EnumDecoratorProviderImpl
