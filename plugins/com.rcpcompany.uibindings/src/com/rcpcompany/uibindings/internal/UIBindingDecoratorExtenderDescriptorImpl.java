/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>UI Binding Decorator Extender Descriptor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.UIBindingDecoratorExtenderDescriptorImpl#getDeclaredArguments
 * <em> Declared Arguments</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.UIBindingDecoratorExtenderDescriptorImpl#getPriority
 * <em>Priority</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.UIBindingDecoratorExtenderDescriptorImpl#getFactory
 * <em>Factory</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UIBindingDecoratorExtenderDescriptorImpl extends EObjectImpl implements
		IUIBindingDecoratorExtenderDescriptor {
	/**
	 * The cached value of the '{@link #getDeclaredArguments() <em>Declared Arguments</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDeclaredArguments()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Object> declaredArguments;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFactory() <em>Factory</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFactory()
	 * @generated
	 * @ordered
	 */
	protected CEObjectHolder<IUIBindingDecoratorExtender> factory;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UIBindingDecoratorExtenderDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EMap<String, Object> getDeclaredArguments() {
		if (declaredArguments == null) {
			declaredArguments = new EcoreEMap<String, Object>(IUIBindingsPackage.Literals.STRING_TO_OBJECT_MAP_ENTRY,
					StringToObjectMapEntryImpl.class, this,
					IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__DECLARED_ARGUMENTS);
		}
		return declaredArguments;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setPriority(int newPriority) {
		final int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__PRIORITY, oldPriority, priority));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CEObjectHolder<IUIBindingDecoratorExtender> getFactory() {
		return factory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFactory(CEObjectHolder<IUIBindingDecoratorExtender> newFactory) {
		final CEObjectHolder<IUIBindingDecoratorExtender> oldFactory = factory;
		factory = newFactory;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__FACTORY, oldFactory, factory));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__DECLARED_ARGUMENTS:
			return ((InternalEList<?>) getDeclaredArguments()).basicRemove(otherEnd, msgs);
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
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__DECLARED_ARGUMENTS:
			if (coreType)
				return getDeclaredArguments();
			else
				return getDeclaredArguments().map();
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__PRIORITY:
			return getPriority();
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__FACTORY:
			return getFactory();
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
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__DECLARED_ARGUMENTS:
			((EStructuralFeature.Setting) getDeclaredArguments()).set(newValue);
			return;
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__PRIORITY:
			setPriority((Integer) newValue);
			return;
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__FACTORY:
			setFactory((CEObjectHolder<IUIBindingDecoratorExtender>) newValue);
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
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__DECLARED_ARGUMENTS:
			getDeclaredArguments().clear();
			return;
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__PRIORITY:
			setPriority(PRIORITY_EDEFAULT);
			return;
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__FACTORY:
			setFactory((CEObjectHolder<IUIBindingDecoratorExtender>) null);
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
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__DECLARED_ARGUMENTS:
			return declaredArguments != null && !declaredArguments.isEmpty();
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__PRIORITY:
			return priority != PRIORITY_EDEFAULT;
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__FACTORY:
			return factory != null;
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
		result.append(" (priority: "); //$NON-NLS-1$
		result.append(priority);
		result.append(", factory: "); //$NON-NLS-1$
		result.append(factory);
		result.append(')');
		return result.toString();
	}

} // UIBindingDecoratorExtenderDescriptorImpl
