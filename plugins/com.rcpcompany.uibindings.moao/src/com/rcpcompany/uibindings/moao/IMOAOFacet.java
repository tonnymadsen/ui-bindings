/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.moao;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Facet</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.moao.IMOAOFacet#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOFacet()
 * @generated
 */
public interface IMOAOFacet extends IMOAO {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' container reference. It is bidirectional
	 * and its opposite is '{@link com.rcpcompany.uibindings.moao.IMOAO#getFacets <em>Facets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' container reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Object</em>' container reference.
	 * @see #setObject(IMOAO)
	 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOFacet_Object()
	 * @see com.rcpcompany.uibindings.moao.IMOAO#getFacets
	 * @generated
	 */
	IMOAO getObject();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.moao.IMOAOFacet#getObject
	 * <em>Object</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Object</em>' container reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(IMOAO value);

} // IMOAOFacet
