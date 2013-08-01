/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.moao;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibindings.moao.IMOAOFactory
 * @generated
 */
public interface IMOAOPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "moao";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://rcp-company.com/schemas/uibindings/moao.ecore";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "moao";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	IMOAOPackage eINSTANCE = com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.core.runtime.IAdaptable <em>IAdaptable</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable
	 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getIAdaptable()
	 * @generated
	 */
	int IADAPTABLE = 0;

	/**
	 * The number of structural features of the '<em>IAdaptable</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IADAPTABLE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IAdaptable</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IADAPTABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecore.EStructuralFeature
	 * <em>EStructural Feature</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EStructuralFeature
	 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getEStructuralFeature()
	 * @generated
	 */
	int ESTRUCTURAL_FEATURE = 1;

	/**
	 * The number of structural features of the '<em>EStructural Feature</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ESTRUCTURAL_FEATURE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>EStructural Feature</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ESTRUCTURAL_FEATURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.moao.internal.MOAOImpl
	 * <em>MOAO</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.moao.internal.MOAOImpl
	 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getMOAO()
	 * @generated
	 */
	int MOAO = 2;

	/**
	 * The feature id for the '<em><b>Facets</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO__FACETS = IADAPTABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MOAO</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_FEATURE_COUNT = IADAPTABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Valid</em>' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO___IS_VALID__DIAGNOSTICCHAIN_MAP = IADAPTABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Remove Messages By Owner</em>' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO___REMOVE_MESSAGES_BY_OWNER__STRING = IADAPTABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Remove Messages By Owner</em>' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO___REMOVE_MESSAGES_BY_OWNER__ESTRUCTURALFEATURE_STRING = IADAPTABLE_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>MOAO</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_OPERATION_COUNT = IADAPTABLE_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.moao.internal.MOAOFacetImpl
	 * <em>Facet</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.moao.internal.MOAOFacetImpl
	 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getMOAOFacet()
	 * @generated
	 */
	int MOAO_FACET = 3;

	/**
	 * The feature id for the '<em><b>Facets</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_FACET__FACETS = MOAO__FACETS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_FACET__OBJECT = MOAO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Facet</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_FACET_FEATURE_COUNT = MOAO_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Valid</em>' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_FACET___IS_VALID__DIAGNOSTICCHAIN_MAP = MOAO___IS_VALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Remove Messages By Owner</em>' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_FACET___REMOVE_MESSAGES_BY_OWNER__STRING = MOAO___REMOVE_MESSAGES_BY_OWNER__STRING;

	/**
	 * The operation id for the '<em>Remove Messages By Owner</em>' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_FACET___REMOVE_MESSAGES_BY_OWNER__ESTRUCTURALFEATURE_STRING = MOAO___REMOVE_MESSAGES_BY_OWNER__ESTRUCTURALFEATURE_STRING;

	/**
	 * The number of operations of the '<em>Facet</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_FACET_OPERATION_COUNT = MOAO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.moao.internal.NamedObjectImpl
	 * <em>Named Object</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.moao.internal.NamedObjectImpl
	 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getNamedObject()
	 * @generated
	 */
	int NAMED_OBJECT = 4;

	/**
	 * The feature id for the '<em><b>Facets</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJECT__FACETS = MOAO__FACETS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJECT__NAME = MOAO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJECT__DESCRIPTION = MOAO_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJECT__UUID = MOAO_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Named Object</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJECT_FEATURE_COUNT = MOAO_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Valid</em>' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJECT___IS_VALID__DIAGNOSTICCHAIN_MAP = MOAO___IS_VALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Remove Messages By Owner</em>' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJECT___REMOVE_MESSAGES_BY_OWNER__STRING = MOAO___REMOVE_MESSAGES_BY_OWNER__STRING;

	/**
	 * The operation id for the '<em>Remove Messages By Owner</em>' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJECT___REMOVE_MESSAGES_BY_OWNER__ESTRUCTURALFEATURE_STRING = MOAO___REMOVE_MESSAGES_BY_OWNER__ESTRUCTURALFEATURE_STRING;

	/**
	 * The number of operations of the '<em>Named Object</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_OBJECT_OPERATION_COUNT = MOAO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.moao.internal.MOAOMessageImpl
	 * <em>Message</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.moao.internal.MOAOMessageImpl
	 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getMOAOMessage()
	 * @generated
	 */
	int MOAO_MESSAGE = 5;

	/**
	 * The feature id for the '<em><b>Facets</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_MESSAGE__FACETS = MOAO_FACET__FACETS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_MESSAGE__OBJECT = MOAO_FACET__OBJECT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_MESSAGE__OWNER = MOAO_FACET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_MESSAGE__FEATURE = MOAO_FACET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_MESSAGE__DESCRIPTION = MOAO_FACET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_MESSAGE__SEVERITY = MOAO_FACET_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Details</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_MESSAGE__DETAILS = MOAO_FACET_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Message</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_MESSAGE_FEATURE_COUNT = MOAO_FACET_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Valid</em>' operation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_MESSAGE___IS_VALID__DIAGNOSTICCHAIN_MAP = MOAO_FACET___IS_VALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Remove Messages By Owner</em>' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_MESSAGE___REMOVE_MESSAGES_BY_OWNER__STRING = MOAO_FACET___REMOVE_MESSAGES_BY_OWNER__STRING;

	/**
	 * The operation id for the '<em>Remove Messages By Owner</em>' operation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_MESSAGE___REMOVE_MESSAGES_BY_OWNER__ESTRUCTURALFEATURE_STRING = MOAO_FACET___REMOVE_MESSAGES_BY_OWNER__ESTRUCTURALFEATURE_STRING;

	/**
	 * The number of operations of the '<em>Message</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOAO_MESSAGE_OPERATION_COUNT = MOAO_FACET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.moao.Severity <em>Severity</em>}
	 * ' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.moao.Severity
	 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getSeverity()
	 * @generated
	 */
	int SEVERITY = 6;

	/**
	 * The meta object id for the '<em>EDiagnostic Chain</em>' data type. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.common.util.DiagnosticChain
	 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getEDiagnosticChain()
	 * @generated
	 */
	int EDIAGNOSTIC_CHAIN = 7;

	/**
	 * The meta object id for the '<em>EMap</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see java.util.Map
	 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getEMap()
	 * @generated
	 */
	int EMAP = 8;

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.moao.IMOAO <em>MOAO</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>MOAO</em>'.
	 * @see com.rcpcompany.uibindings.moao.IMOAO
	 * @generated
	 */
	EClass getMOAO();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.moao.IMOAO#getFacets <em>Facets</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Facets</em>'.
	 * @see com.rcpcompany.uibindings.moao.IMOAO#getFacets()
	 * @see #getMOAO()
	 * @generated
	 */
	EReference getMOAO_Facets();

	/**
	 * Returns the meta object for the '
	 * {@link com.rcpcompany.uibindings.moao.IMOAO#isValid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * <em>Is Valid</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Is Valid</em>' operation.
	 * @see com.rcpcompany.uibindings.moao.IMOAO#isValid(org.eclipse.emf.common.util.DiagnosticChain,
	 *      java.util.Map)
	 * @generated
	 */
	EOperation getMOAO__IsValid__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '
	 * {@link com.rcpcompany.uibindings.moao.IMOAO#removeMessagesByOwner(java.lang.String)
	 * <em>Remove Messages By Owner</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Remove Messages By Owner</em>' operation.
	 * @see com.rcpcompany.uibindings.moao.IMOAO#removeMessagesByOwner(java.lang.String)
	 * @generated
	 */
	EOperation getMOAO__RemoveMessagesByOwner__String();

	/**
	 * Returns the meta object for the '
	 * {@link com.rcpcompany.uibindings.moao.IMOAO#removeMessagesByOwner(org.eclipse.emf.ecore.EStructuralFeature, java.lang.String)
	 * <em>Remove Messages By Owner</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Remove Messages By Owner</em>' operation.
	 * @see com.rcpcompany.uibindings.moao.IMOAO#removeMessagesByOwner(org.eclipse.emf.ecore.EStructuralFeature,
	 *      java.lang.String)
	 * @generated
	 */
	EOperation getMOAO__RemoveMessagesByOwner__EStructuralFeature_String();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.moao.IMOAOFacet
	 * <em>Facet</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Facet</em>'.
	 * @see com.rcpcompany.uibindings.moao.IMOAOFacet
	 * @generated
	 */
	EClass getMOAOFacet();

	/**
	 * Returns the meta object for the container reference '
	 * {@link com.rcpcompany.uibindings.moao.IMOAOFacet#getObject <em>Object</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Object</em>'.
	 * @see com.rcpcompany.uibindings.moao.IMOAOFacet#getObject()
	 * @see #getMOAOFacet()
	 * @generated
	 */
	EReference getMOAOFacet_Object();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.moao.INamedObject
	 * <em>Named Object</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Named Object</em>'.
	 * @see com.rcpcompany.uibindings.moao.INamedObject
	 * @generated
	 */
	EClass getNamedObject();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.moao.INamedObject#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.rcpcompany.uibindings.moao.INamedObject#getName()
	 * @see #getNamedObject()
	 * @generated
	 */
	EAttribute getNamedObject_Name();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.moao.INamedObject#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.rcpcompany.uibindings.moao.INamedObject#getDescription()
	 * @see #getNamedObject()
	 * @generated
	 */
	EAttribute getNamedObject_Description();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.moao.INamedObject#getUuid <em>Uuid</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Uuid</em>'.
	 * @see com.rcpcompany.uibindings.moao.INamedObject#getUuid()
	 * @see #getNamedObject()
	 * @generated
	 */
	EAttribute getNamedObject_Uuid();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.moao.IMOAOMessage
	 * <em>Message</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Message</em>'.
	 * @see com.rcpcompany.uibindings.moao.IMOAOMessage
	 * @generated
	 */
	EClass getMOAOMessage();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.moao.IMOAOMessage#getOwner <em>Owner</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see com.rcpcompany.uibindings.moao.IMOAOMessage#getOwner()
	 * @see #getMOAOMessage()
	 * @generated
	 */
	EAttribute getMOAOMessage_Owner();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.moao.IMOAOMessage#getFeature <em>Feature</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see com.rcpcompany.uibindings.moao.IMOAOMessage#getFeature()
	 * @see #getMOAOMessage()
	 * @generated
	 */
	EReference getMOAOMessage_Feature();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.moao.IMOAOMessage#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.rcpcompany.uibindings.moao.IMOAOMessage#getDescription()
	 * @see #getMOAOMessage()
	 * @generated
	 */
	EAttribute getMOAOMessage_Description();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.moao.IMOAOMessage#getSeverity <em>Severity</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see com.rcpcompany.uibindings.moao.IMOAOMessage#getSeverity()
	 * @see #getMOAOMessage()
	 * @generated
	 */
	EAttribute getMOAOMessage_Severity();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.moao.IMOAOMessage#getDetails <em>Details</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Details</em>'.
	 * @see com.rcpcompany.uibindings.moao.IMOAOMessage#getDetails()
	 * @see #getMOAOMessage()
	 * @generated
	 */
	EAttribute getMOAOMessage_Details();

	/**
	 * Returns the meta object for enum '{@link com.rcpcompany.uibindings.moao.Severity
	 * <em>Severity</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Severity</em>'.
	 * @see com.rcpcompany.uibindings.moao.Severity
	 * @generated
	 */
	EEnum getSeverity();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.DiagnosticChain
	 * <em>EDiagnostic Chain</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>EDiagnostic Chain</em>'.
	 * @see org.eclipse.emf.common.util.DiagnosticChain
	 * @generated
	 */
	EDataType getEDiagnosticChain();

	/**
	 * Returns the meta object for data type '{@link java.util.Map <em>EMap</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>EMap</em>'.
	 * @see java.util.Map
	 * @generated
	 */
	EDataType getEMap();

	/**
	 * Returns the meta object for class '{@link org.eclipse.core.runtime.IAdaptable
	 * <em>IAdaptable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IAdaptable</em>'.
	 * @see org.eclipse.core.runtime.IAdaptable
	 * @generated
	 */
	EClass getIAdaptable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecore.EStructuralFeature
	 * <em>EStructural Feature</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EStructural Feature</em>'.
	 * @see org.eclipse.emf.ecore.EStructuralFeature
	 * @generated
	 */
	EClass getEStructuralFeature();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IMOAOFactory getMOAOFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.moao.internal.MOAOImpl
		 * <em>MOAO</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.moao.internal.MOAOImpl
		 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getMOAO()
		 * @generated
		 */
		EClass MOAO = eINSTANCE.getMOAO();

		/**
		 * The meta object literal for the '<em><b>Facets</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MOAO__FACETS = eINSTANCE.getMOAO_Facets();

		/**
		 * The meta object literal for the '<em><b>Is Valid</b></em>' operation. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation MOAO___IS_VALID__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMOAO__IsValid__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Remove Messages By Owner</b></em>' operation.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation MOAO___REMOVE_MESSAGES_BY_OWNER__STRING = eINSTANCE.getMOAO__RemoveMessagesByOwner__String();

		/**
		 * The meta object literal for the '<em><b>Remove Messages By Owner</b></em>' operation.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation MOAO___REMOVE_MESSAGES_BY_OWNER__ESTRUCTURALFEATURE_STRING = eINSTANCE
				.getMOAO__RemoveMessagesByOwner__EStructuralFeature_String();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.moao.internal.MOAOFacetImpl <em>Facet</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.moao.internal.MOAOFacetImpl
		 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getMOAOFacet()
		 * @generated
		 */
		EClass MOAO_FACET = eINSTANCE.getMOAOFacet();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MOAO_FACET__OBJECT = eINSTANCE.getMOAOFacet_Object();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.moao.internal.NamedObjectImpl <em>Named Object</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.moao.internal.NamedObjectImpl
		 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getNamedObject()
		 * @generated
		 */
		EClass NAMED_OBJECT = eINSTANCE.getNamedObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NAMED_OBJECT__NAME = eINSTANCE.getNamedObject_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NAMED_OBJECT__DESCRIPTION = eINSTANCE.getNamedObject_Description();

		/**
		 * The meta object literal for the '<em><b>Uuid</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NAMED_OBJECT__UUID = eINSTANCE.getNamedObject_Uuid();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.moao.internal.MOAOMessageImpl <em>Message</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.moao.internal.MOAOMessageImpl
		 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getMOAOMessage()
		 * @generated
		 */
		EClass MOAO_MESSAGE = eINSTANCE.getMOAOMessage();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MOAO_MESSAGE__OWNER = eINSTANCE.getMOAOMessage_Owner();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MOAO_MESSAGE__FEATURE = eINSTANCE.getMOAOMessage_Feature();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MOAO_MESSAGE__DESCRIPTION = eINSTANCE.getMOAOMessage_Description();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MOAO_MESSAGE__SEVERITY = eINSTANCE.getMOAOMessage_Severity();

		/**
		 * The meta object literal for the '<em><b>Details</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MOAO_MESSAGE__DETAILS = eINSTANCE.getMOAOMessage_Details();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.moao.Severity
		 * <em>Severity</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.moao.Severity
		 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getSeverity()
		 * @generated
		 */
		EEnum SEVERITY = eINSTANCE.getSeverity();

		/**
		 * The meta object literal for the '<em>EDiagnostic Chain</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.common.util.DiagnosticChain
		 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getEDiagnosticChain()
		 * @generated
		 */
		EDataType EDIAGNOSTIC_CHAIN = eINSTANCE.getEDiagnosticChain();

		/**
		 * The meta object literal for the '<em>EMap</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see java.util.Map
		 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getEMap()
		 * @generated
		 */
		EDataType EMAP = eINSTANCE.getEMap();

		/**
		 * The meta object literal for the '{@link org.eclipse.core.runtime.IAdaptable
		 * <em>IAdaptable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.core.runtime.IAdaptable
		 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getIAdaptable()
		 * @generated
		 */
		EClass IADAPTABLE = eINSTANCE.getIAdaptable();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecore.EStructuralFeature
		 * <em>EStructural Feature</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.ecore.EStructuralFeature
		 * @see com.rcpcompany.uibindings.moao.internal.MOAOPackageImpl#getEStructuralFeature()
		 * @generated
		 */
		EClass ESTRUCTURAL_FEATURE = eINSTANCE.getEStructuralFeature();

	}

} // IMOAOPackage
