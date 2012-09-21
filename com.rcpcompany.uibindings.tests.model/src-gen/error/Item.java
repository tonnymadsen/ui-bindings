/**
 */
package error;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link error.Item#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see error.ErrorPackage#getItem()
 * @model
 * @generated
 */
public interface Item extends NamedItem
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see error.ErrorPackage#getItem_Value()
   * @model unique="false"
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link error.Item#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // Item
