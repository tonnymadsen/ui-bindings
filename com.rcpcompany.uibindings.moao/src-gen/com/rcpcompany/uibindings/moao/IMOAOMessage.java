/**
 */
package com.rcpcompany.uibindings.moao;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Message</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getOwner <em>Owner</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getFeature <em>Feature</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getDescription <em>Description</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getSeverity <em>Severity</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getDetails <em>Details</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOMessage()
 * @generated
 */
public interface IMOAOMessage extends IMOAOFacet {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> *
	 * <p>
	 * The owner of the message. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Owner</em>' attribute.
	 * @see #setOwner(String)
	 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOMessage_Owner()
	 * @generated
	 */
	String getOwner();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getOwner
	 * <em>Owner</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Owner</em>' attribute.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(String value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> *
	 * <p>
	 * The feature of the message. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(EStructuralFeature)
	 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOMessage_Feature()
	 * @generated
	 */
	EStructuralFeature getFeature();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getFeature
	 * <em>Feature</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> *
	 * <p>
	 * The description of the message. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOMessage_Description()
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getDescription
	 * <em>Description</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute. The literals are from the
	 * enumeration {@link com.rcpcompany.uibindings.moao.Severity}. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> *
	 * <p>
	 * The severity of the message. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see com.rcpcompany.uibindings.moao.Severity
	 * @see #setSeverity(Severity)
	 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOMessage_Severity()
	 * @generated
	 */
	Severity getSeverity();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getSeverity
	 * <em>Severity</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see com.rcpcompany.uibindings.moao.Severity
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(Severity value);

	/**
	 * Returns the value of the '<em><b>Details</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> *
	 * <p>
	 * Any details of the message.
	 * <p>
	 * Can be stack trace or similar. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Details</em>' attribute.
	 * @see #setDetails(String)
	 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOMessage_Details()
	 * @generated
	 */
	String getDetails();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getDetails
	 * <em>Details</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Details</em>' attribute.
	 * @see #getDetails()
	 * @generated
	 */
	void setDetails(String value);

} // IMOAOMessage
