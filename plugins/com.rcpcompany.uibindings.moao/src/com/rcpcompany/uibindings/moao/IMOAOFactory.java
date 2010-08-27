/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.moao;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.rcpcompany.uibindings.moao.IMOAOPackage
 * @generated
 */
public interface IMOAOFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  IMOAOFactory eINSTANCE = com.rcpcompany.uibindings.moao.internal.MOAOFactoryImpl.init();

  /**
   * Returns a new object of class '<em>MOAO</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MOAO</em>'.
   * @generated
   */
  IMOAO createMOAO();

  /**
   * Returns a new object of class '<em>Named Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Object</em>'.
   * @generated
   */
  INamedObject createNamedObject();

  /**
   * Returns a new object of class '<em>Message</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message</em>'.
   * @generated
   */
  IMOAOMessage createMOAOMessage();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  IMOAOPackage getMOAOPackage();

} //IMOAOFactory
