/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.moao.internal;

import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.moao.INamedObject;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.moao.internal.NamedObjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.moao.internal.NamedObjectImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.moao.internal.NamedObjectImpl#getUuid <em>Uuid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamedObjectImpl extends MOAOImpl implements INamedObject {
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUuid()
   * @generated
   * @ordered
   */
  protected static final String UUID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUuid()
   * @generated
   * @ordered
   */
  protected String uuid = UUID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NamedObjectImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return IMOAOPackage.Literals.NAMED_OBJECT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IMOAOPackage.NAMED_OBJECT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription() {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription) {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IMOAOPackage.NAMED_OBJECT__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUuid(String newUuid) {
    String oldUuid = uuid;
    uuid = newUuid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IMOAOPackage.NAMED_OBJECT__UUID, oldUuid, uuid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case IMOAOPackage.NAMED_OBJECT__NAME:
        return getName();
      case IMOAOPackage.NAMED_OBJECT__DESCRIPTION:
        return getDescription();
      case IMOAOPackage.NAMED_OBJECT__UUID:
        return getUuid();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case IMOAOPackage.NAMED_OBJECT__NAME:
        setName((String)newValue);
        return;
      case IMOAOPackage.NAMED_OBJECT__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case IMOAOPackage.NAMED_OBJECT__UUID:
        setUuid((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case IMOAOPackage.NAMED_OBJECT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case IMOAOPackage.NAMED_OBJECT__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case IMOAOPackage.NAMED_OBJECT__UUID:
        setUuid(UUID_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case IMOAOPackage.NAMED_OBJECT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case IMOAOPackage.NAMED_OBJECT__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case IMOAOPackage.NAMED_OBJECT__UUID:
        return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", description: ");
    result.append(description);
    result.append(", uuid: ");
    result.append(uuid);
    result.append(')');
    return result.toString();
  }

} //NamedObjectImpl
