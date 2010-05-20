/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.ITreeItemDescriptor;
import com.rcpcompany.uibindings.ITreeItemRelation;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Tree Item Relation</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.TreeItemRelationImpl#getId <em>Id</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.TreeItemRelationImpl#getProcessor <em>Processor</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.TreeItemRelationImpl#getFeatureName <em>Feature Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TreeItemRelationImpl extends EObjectImpl implements ITreeItemRelation {
	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected ITreeItemDescriptor parent;

	/**
	 * The cached value of the '{@link #getDescriptor() <em>Descriptor</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getDescriptor()
	 * @generated
	 * @ordered
	 */
	protected ITreeItemDescriptor descriptor;

	/**
	 * The cached value of the '{@link #getProcessor() <em>Processor</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getProcessor()
	 * @generated
	 * @ordered
	 */
	protected CEObjectHolder<IObservableFactory> processor;

	/**
	 * The default value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected String featureName = FEATURE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TreeItemRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.TREE_ITEM_RELATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ITreeItemDescriptor getParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParent(ITreeItemDescriptor newParent, NotificationChain msgs) {
		final ITreeItemDescriptor oldParent = parent;
		parent = newParent;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.TREE_ITEM_RELATION__PARENT, oldParent, newParent);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParent(ITreeItemDescriptor newParent) {
		if (newParent != parent) {
			NotificationChain msgs = null;
			if (parent != null) {
				msgs = ((InternalEObject) parent).eInverseRemove(this,
						IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__CHILDREN, ITreeItemDescriptor.class, msgs);
			}
			if (newParent != null) {
				msgs = ((InternalEObject) newParent).eInverseAdd(this,
						IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__CHILDREN, ITreeItemDescriptor.class, msgs);
			}
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.TREE_ITEM_RELATION__PARENT,
					newParent, newParent));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ITreeItemDescriptor getDescriptor() {
		return descriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDescriptor(ITreeItemDescriptor newDescriptor) {
		final ITreeItemDescriptor oldDescriptor = descriptor;
		descriptor = newDescriptor;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.TREE_ITEM_RELATION__DESCRIPTOR,
					oldDescriptor, descriptor));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CEObjectHolder<IObservableFactory> getProcessor() {
		return processor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProcessor(CEObjectHolder<IObservableFactory> newProcessor) {
		final CEObjectHolder<IObservableFactory> oldProcessor = processor;
		processor = newProcessor;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.TREE_ITEM_RELATION__PROCESSOR,
					oldProcessor, processor));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFeatureName(String newFeatureName) {
		final String oldFeatureName = featureName;
		featureName = newFeatureName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.TREE_ITEM_RELATION__FEATURE_NAME,
					oldFeatureName, featureName));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPriority(int newPriority) {
		final int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.TREE_ITEM_RELATION__PRIORITY,
					oldPriority, priority));
		}
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
		case IUIBindingsPackage.TREE_ITEM_RELATION__PARENT:
			if (parent != null) {
				msgs = ((InternalEObject) parent).eInverseRemove(this,
						IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__CHILDREN, ITreeItemDescriptor.class, msgs);
			}
			return basicSetParent((ITreeItemDescriptor) otherEnd, msgs);
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
		case IUIBindingsPackage.TREE_ITEM_RELATION__PARENT:
			return basicSetParent(null, msgs);
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
		case IUIBindingsPackage.TREE_ITEM_RELATION__PARENT:
			return getParent();
		case IUIBindingsPackage.TREE_ITEM_RELATION__DESCRIPTOR:
			return getDescriptor();
		case IUIBindingsPackage.TREE_ITEM_RELATION__PROCESSOR:
			return getProcessor();
		case IUIBindingsPackage.TREE_ITEM_RELATION__FEATURE_NAME:
			return getFeatureName();
		case IUIBindingsPackage.TREE_ITEM_RELATION__PRIORITY:
			return getPriority();
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
		case IUIBindingsPackage.TREE_ITEM_RELATION__PARENT:
			setParent((ITreeItemDescriptor) newValue);
			return;
		case IUIBindingsPackage.TREE_ITEM_RELATION__DESCRIPTOR:
			setDescriptor((ITreeItemDescriptor) newValue);
			return;
		case IUIBindingsPackage.TREE_ITEM_RELATION__PROCESSOR:
			setProcessor((CEObjectHolder<IObservableFactory>) newValue);
			return;
		case IUIBindingsPackage.TREE_ITEM_RELATION__FEATURE_NAME:
			setFeatureName((String) newValue);
			return;
		case IUIBindingsPackage.TREE_ITEM_RELATION__PRIORITY:
			setPriority((Integer) newValue);
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
		case IUIBindingsPackage.TREE_ITEM_RELATION__PARENT:
			setParent((ITreeItemDescriptor) null);
			return;
		case IUIBindingsPackage.TREE_ITEM_RELATION__DESCRIPTOR:
			setDescriptor((ITreeItemDescriptor) null);
			return;
		case IUIBindingsPackage.TREE_ITEM_RELATION__PROCESSOR:
			setProcessor((CEObjectHolder<IObservableFactory>) null);
			return;
		case IUIBindingsPackage.TREE_ITEM_RELATION__FEATURE_NAME:
			setFeatureName(FEATURE_NAME_EDEFAULT);
			return;
		case IUIBindingsPackage.TREE_ITEM_RELATION__PRIORITY:
			setPriority(PRIORITY_EDEFAULT);
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
		case IUIBindingsPackage.TREE_ITEM_RELATION__PARENT:
			return parent != null;
		case IUIBindingsPackage.TREE_ITEM_RELATION__DESCRIPTOR:
			return descriptor != null;
		case IUIBindingsPackage.TREE_ITEM_RELATION__PROCESSOR:
			return processor != null;
		case IUIBindingsPackage.TREE_ITEM_RELATION__FEATURE_NAME:
			return FEATURE_NAME_EDEFAULT == null ? featureName != null : !FEATURE_NAME_EDEFAULT.equals(featureName);
		case IUIBindingsPackage.TREE_ITEM_RELATION__PRIORITY:
			return priority != PRIORITY_EDEFAULT;
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
		if (eIsProxy()) {
			return super.toString();
		}

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (processor: "); //$NON-NLS-1$
		result.append(processor);
		result.append(", featureName: "); //$NON-NLS-1$
		result.append(featureName);
		result.append(", priority: "); //$NON-NLS-1$
		result.append(priority);
		result.append(')');
		return result.toString();
	}

} // TreeItemRelationImpl
