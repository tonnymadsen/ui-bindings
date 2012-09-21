/**
 */
package error;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link error.Container#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see error.ErrorPackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends EObject
{
  /**
   * Returns the value of the '<em><b>Items</b></em>' containment reference list.
   * The list contents are of type {@link error.Item}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Items</em>' containment reference list.
   * @see error.ErrorPackage#getContainer_Items()
   * @model containment="true" keys="value"
   * @generated
   */
  EList<Item> getItems();

} // Container
