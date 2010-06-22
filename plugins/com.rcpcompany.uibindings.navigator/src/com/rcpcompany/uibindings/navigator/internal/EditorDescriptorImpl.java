/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.navigator.internal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.navigator.IEditorDescriptor;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.navigator.INavigatorModelPackage;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;
import com.rcpcompany.utils.extensionpoints.CEResourceHolder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Editor Descriptor</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.navigator.internal.EditorDescriptorImpl#getId <em>Id</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.navigator.internal.EditorDescriptorImpl#getName <em>Name
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.navigator.internal.EditorDescriptorImpl#getPriority <em>
 * Priority</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.navigator.internal.EditorDescriptorImpl#getFactory <em>
 * Factory</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.navigator.internal.EditorDescriptorImpl#getImage <em>Image
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EditorDescriptorImpl extends EObjectImpl implements IEditorDescriptor {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	protected CEObjectHolder<IEditorPartFactory> factory;

	/**
	 * The default value of the '{@link #getImage() <em>Image</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected static final CEResourceHolder IMAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected CEResourceHolder image = IMAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EditorDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return INavigatorModelPackage.Literals.EDITOR_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		final String oldId = id;
		id = newId;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, INavigatorModelPackage.EDITOR_DESCRIPTOR__ID, oldId,
					id));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		final String oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, INavigatorModelPackage.EDITOR_DESCRIPTOR__NAME,
					oldName, name));
		}
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
			eNotify(new ENotificationImpl(this, Notification.SET, INavigatorModelPackage.EDITOR_DESCRIPTOR__PRIORITY,
					oldPriority, priority));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CEObjectHolder<IEditorPartFactory> getFactory() {
		return factory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFactory(CEObjectHolder<IEditorPartFactory> newFactory) {
		final CEObjectHolder<IEditorPartFactory> oldFactory = factory;
		factory = newFactory;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, INavigatorModelPackage.EDITOR_DESCRIPTOR__FACTORY,
					oldFactory, factory));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CEResourceHolder getImage() {
		return image;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setImage(CEResourceHolder newImage) {
		final CEResourceHolder oldImage = image;
		image = newImage;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, INavigatorModelPackage.EDITOR_DESCRIPTOR__IMAGE,
					oldImage, image));
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
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__ID:
			return getId();
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__NAME:
			return getName();
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__PRIORITY:
			return getPriority();
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__FACTORY:
			return getFactory();
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__IMAGE:
			return getImage();
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
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__ID:
			setId((String) newValue);
			return;
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__NAME:
			setName((String) newValue);
			return;
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__PRIORITY:
			setPriority((Integer) newValue);
			return;
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__FACTORY:
			setFactory((CEObjectHolder<IEditorPartFactory>) newValue);
			return;
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__IMAGE:
			setImage((CEResourceHolder) newValue);
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
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__ID:
			setId(ID_EDEFAULT);
			return;
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__NAME:
			setName(NAME_EDEFAULT);
			return;
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__PRIORITY:
			setPriority(PRIORITY_EDEFAULT);
			return;
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__FACTORY:
			setFactory((CEObjectHolder<IEditorPartFactory>) null);
			return;
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__IMAGE:
			setImage(IMAGE_EDEFAULT);
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
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__PRIORITY:
			return priority != PRIORITY_EDEFAULT;
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__FACTORY:
			return factory != null;
		case INavigatorModelPackage.EDITOR_DESCRIPTOR__IMAGE:
			return IMAGE_EDEFAULT == null ? image != null : !IMAGE_EDEFAULT.equals(image);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", priority: ");
		result.append(priority);
		result.append(", factory: ");
		result.append(factory);
		result.append(", image: ");
		result.append(image);
		result.append(')');
		return result.toString();
	}

} // EditorDescriptorImpl
