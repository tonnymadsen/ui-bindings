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
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.ITreeItemDescriptor;
import com.rcpcompany.uibindings.ITreeItemRelation;
import com.rcpcompany.uibindings.IUIBindingsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Tree Item Descriptor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.TreeItemDescriptorImpl#getDeclaredArguments <em>
 * Declared Arguments </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.TreeItemDescriptorImpl#getId <em>Id</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.TreeItemDescriptorImpl#getChildren <em>Children
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.TreeItemDescriptorImpl#getCe <em>Ce</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.TreeItemDescriptorImpl#getModelTypes <em>Model
 * Types</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.TreeItemDescriptorImpl#getNewWizardID <em>New
 * Wizard ID</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TreeItemDescriptorImpl extends EObjectImpl implements ITreeItemDescriptor {
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
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<ITreeItemRelation> children;

	/**
	 * The default value of the '{@link #getCe() <em>Ce</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCe()
	 * @generated
	 * @ordered
	 */
	protected static final IConfigurationElement CE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCe() <em>Ce</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCe()
	 * @generated
	 * @ordered
	 */
	protected IConfigurationElement ce = CE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModelTypes() <em>Model Types</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> modelTypes;

	/**
	 * The default value of the '{@link #getNewWizardID() <em>New Wizard ID</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNewWizardID()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_WIZARD_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewWizardID() <em>New Wizard ID</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNewWizardID()
	 * @generated
	 * @ordered
	 */
	protected String newWizardID = NEW_WIZARD_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TreeItemDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.TREE_ITEM_DESCRIPTOR;
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
					StringToObjectMapEntryImpl.class, this, IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__DECLARED_ARGUMENTS);
		}
		return declaredArguments;
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
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__ID, oldId,
					id));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<ITreeItemRelation> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseEList<ITreeItemRelation>(ITreeItemRelation.class, this,
					IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__CHILDREN, IUIBindingsPackage.TREE_ITEM_RELATION__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IConfigurationElement getCe() {
		return ce;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setCe(IConfigurationElement newCe) {
		final IConfigurationElement oldCe = ce;
		ce = newCe;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__CE, oldCe,
					ce));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<String> getModelTypes() {
		if (modelTypes == null) {
			modelTypes = new EDataTypeUniqueEList<String>(String.class, this,
					IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__MODEL_TYPES);
		}
		return modelTypes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getNewWizardID() {
		return newWizardID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setNewWizardID(String newNewWizardID) {
		final String oldNewWizardID = newWizardID;
		newWizardID = newNewWizardID;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__NEW_WIZARD_ID, oldNewWizardID, newWizardID));
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
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__CHILDREN:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getChildren()).basicAdd(otherEnd, msgs);
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
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__DECLARED_ARGUMENTS:
			return ((InternalEList<?>) getDeclaredArguments()).basicRemove(otherEnd, msgs);
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__CHILDREN:
			return ((InternalEList<?>) getChildren()).basicRemove(otherEnd, msgs);
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
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__DECLARED_ARGUMENTS:
			if (coreType)
				return getDeclaredArguments();
			else
				return getDeclaredArguments().map();
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__ID:
			return getId();
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__CHILDREN:
			return getChildren();
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__CE:
			return getCe();
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__MODEL_TYPES:
			return getModelTypes();
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__NEW_WIZARD_ID:
			return getNewWizardID();
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
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__DECLARED_ARGUMENTS:
			((EStructuralFeature.Setting) getDeclaredArguments()).set(newValue);
			return;
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__ID:
			setId((String) newValue);
			return;
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__CHILDREN:
			getChildren().clear();
			getChildren().addAll((Collection<? extends ITreeItemRelation>) newValue);
			return;
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__CE:
			setCe((IConfigurationElement) newValue);
			return;
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__MODEL_TYPES:
			getModelTypes().clear();
			getModelTypes().addAll((Collection<? extends String>) newValue);
			return;
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__NEW_WIZARD_ID:
			setNewWizardID((String) newValue);
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
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__DECLARED_ARGUMENTS:
			getDeclaredArguments().clear();
			return;
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__ID:
			setId(ID_EDEFAULT);
			return;
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__CHILDREN:
			getChildren().clear();
			return;
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__CE:
			setCe(CE_EDEFAULT);
			return;
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__MODEL_TYPES:
			getModelTypes().clear();
			return;
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__NEW_WIZARD_ID:
			setNewWizardID(NEW_WIZARD_ID_EDEFAULT);
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
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__DECLARED_ARGUMENTS:
			return declaredArguments != null && !declaredArguments.isEmpty();
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__CHILDREN:
			return children != null && !children.isEmpty();
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__CE:
			return CE_EDEFAULT == null ? ce != null : !CE_EDEFAULT.equals(ce);
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__MODEL_TYPES:
			return modelTypes != null && !modelTypes.isEmpty();
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR__NEW_WIZARD_ID:
			return NEW_WIZARD_ID_EDEFAULT == null ? newWizardID != null : !NEW_WIZARD_ID_EDEFAULT.equals(newWizardID);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return "Description[" + getId() + "]"; //$NON-NLS-1$ //$NON-NLS-2$
	}

} // TreeItemDescriptorImpl
