/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.moao.internal;

import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.moao.IMOAOFacet;
import com.rcpcompany.uibindings.moao.IMOAOFactory;
import com.rcpcompany.uibindings.moao.IMOAOMessage;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.moao.INamedObject;
import com.rcpcompany.uibindings.moao.Severity;
import com.rcpcompany.uibindings.moao.util.MOAOValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class MOAOPackageImpl extends EPackageImpl implements IMOAOPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass moaoEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass moaoFacetEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass namedObjectEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass moaoMessageEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum severityEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType eDiagnosticChainEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType eMapEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iAdaptableEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass eStructuralFeatureEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
	 * value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init
	 * init()}, which also performs initialization of the package, or returns the registered
	 * package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MOAOPackageImpl() {
		super(eNS_URI, IMOAOFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
	 * upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link IMOAOPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to
	 * obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IMOAOPackage init() {
		if (isInited) return (IMOAOPackage) EPackage.Registry.INSTANCE.getEPackage(IMOAOPackage.eNS_URI);

		// Obtain or create and register package
		final MOAOPackageImpl theMOAOPackage = (MOAOPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MOAOPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new MOAOPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theMOAOPackage.createPackageContents();

		// Initialize created meta-data
		theMOAOPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put(theMOAOPackage, new EValidator.Descriptor() {
			@Override
			public EValidator getEValidator() {
				return MOAOValidator.INSTANCE;
			}
		});

		// Mark meta-data to indicate it can't be changed
		theMOAOPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IMOAOPackage.eNS_URI, theMOAOPackage);
		return theMOAOPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getMOAO() {
		return moaoEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getMOAO_Facets() {
		return (EReference) moaoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EOperation getMOAO__IsValid__DiagnosticChain_Map() {
		return moaoEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EOperation getMOAO__RemoveMessagesByOwner__String() {
		return moaoEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EOperation getMOAO__RemoveMessagesByOwner__EStructuralFeature_String() {
		return moaoEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getMOAOFacet() {
		return moaoFacetEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getMOAOFacet_Object() {
		return (EReference) moaoFacetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getNamedObject() {
		return namedObjectEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getNamedObject_Name() {
		return (EAttribute) namedObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getNamedObject_Description() {
		return (EAttribute) namedObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getNamedObject_Uuid() {
		return (EAttribute) namedObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getMOAOMessage() {
		return moaoMessageEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getMOAOMessage_Owner() {
		return (EAttribute) moaoMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getMOAOMessage_Feature() {
		return (EReference) moaoMessageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getMOAOMessage_Description() {
		return (EAttribute) moaoMessageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getMOAOMessage_Severity() {
		return (EAttribute) moaoMessageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getMOAOMessage_Details() {
		return (EAttribute) moaoMessageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EEnum getSeverity() {
		return severityEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getEDiagnosticChain() {
		return eDiagnosticChainEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getEMap() {
		return eMapEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getIAdaptable() {
		return iAdaptableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getEStructuralFeature() {
		return eStructuralFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IMOAOFactory getMOAOFactory() {
		return (IMOAOFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to have no affect on
	 * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		iAdaptableEClass = createEClass(IADAPTABLE);

		eStructuralFeatureEClass = createEClass(ESTRUCTURAL_FEATURE);

		moaoEClass = createEClass(MOAO);
		createEReference(moaoEClass, MOAO__FACETS);
		createEOperation(moaoEClass, MOAO___IS_VALID__DIAGNOSTICCHAIN_MAP);
		createEOperation(moaoEClass, MOAO___REMOVE_MESSAGES_BY_OWNER__STRING);
		createEOperation(moaoEClass, MOAO___REMOVE_MESSAGES_BY_OWNER__ESTRUCTURALFEATURE_STRING);

		moaoFacetEClass = createEClass(MOAO_FACET);
		createEReference(moaoFacetEClass, MOAO_FACET__OBJECT);

		namedObjectEClass = createEClass(NAMED_OBJECT);
		createEAttribute(namedObjectEClass, NAMED_OBJECT__NAME);
		createEAttribute(namedObjectEClass, NAMED_OBJECT__DESCRIPTION);
		createEAttribute(namedObjectEClass, NAMED_OBJECT__UUID);

		moaoMessageEClass = createEClass(MOAO_MESSAGE);
		createEAttribute(moaoMessageEClass, MOAO_MESSAGE__OWNER);
		createEReference(moaoMessageEClass, MOAO_MESSAGE__FEATURE);
		createEAttribute(moaoMessageEClass, MOAO_MESSAGE__DESCRIPTION);
		createEAttribute(moaoMessageEClass, MOAO_MESSAGE__SEVERITY);
		createEAttribute(moaoMessageEClass, MOAO_MESSAGE__DETAILS);

		// Create enums
		severityEEnum = createEEnum(SEVERITY);

		// Create data types
		eDiagnosticChainEDataType = createEDataType(EDIAGNOSTIC_CHAIN);
		eMapEDataType = createEDataType(EMAP);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is guarded to have
	 * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		final EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters
		addETypeParameter(eMapEDataType, "K"); //$NON-NLS-1$
		addETypeParameter(eMapEDataType, "V"); //$NON-NLS-1$

		// Set bounds for type parameters

		// Add supertypes to classes
		moaoEClass.getESuperTypes().add(this.getIAdaptable());
		moaoFacetEClass.getESuperTypes().add(this.getMOAO());
		namedObjectEClass.getESuperTypes().add(this.getMOAO());
		moaoMessageEClass.getESuperTypes().add(this.getMOAOFacet());

		// Initialize classes, features, and operations; add parameters
		initEClass(iAdaptableEClass, IAdaptable.class,
				"IAdaptable", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(eStructuralFeatureEClass, EStructuralFeature.class,
				"EStructuralFeature", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(moaoEClass, IMOAO.class, "MOAO", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getMOAO_Facets(),
				this.getMOAOFacet(),
				this.getMOAOFacet_Object(),
				"facets", null, 0, -1, IMOAO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		EOperation op = initEOperation(getMOAO__IsValid__DiagnosticChain_Map(), theEcorePackage.getEBoolean(),
				"isValid", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getEDiagnosticChain(), "diagnostics", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		final EGenericType g1 = createEGenericType(this.getEMap());
		EGenericType g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getMOAO__RemoveMessagesByOwner__String(), null,
				"removeMessagesByOwner", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEString(), "owner", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getMOAO__RemoveMessagesByOwner__EStructuralFeature_String(), null,
				"removeMessagesByOwner", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getEStructuralFeature(), "feature", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, theEcorePackage.getEString(), "owner", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(moaoFacetEClass, IMOAOFacet.class,
				"MOAOFacet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getMOAOFacet_Object(),
				this.getMOAO(),
				this.getMOAO_Facets(),
				"object", null, 0, 1, IMOAOFacet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(namedObjectEClass, INamedObject.class,
				"NamedObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getNamedObject_Name(),
				theEcorePackage.getEString(),
				"name", null, 1, 1, INamedObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getNamedObject_Description(),
				theEcorePackage.getEString(),
				"description", null, 0, 1, INamedObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getNamedObject_Uuid(),
				theEcorePackage.getEString(),
				"uuid", null, 1, 1, INamedObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(moaoMessageEClass, IMOAOMessage.class,
				"MOAOMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getMOAOMessage_Owner(),
				theEcorePackage.getEString(),
				"owner", null, 0, 1, IMOAOMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getMOAOMessage_Feature(),
				this.getEStructuralFeature(),
				null,
				"feature", null, 0, 1, IMOAOMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getMOAOMessage_Description(),
				theEcorePackage.getEString(),
				"description", null, 0, 1, IMOAOMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getMOAOMessage_Severity(),
				this.getSeverity(),
				"severity", null, 0, 1, IMOAOMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getMOAOMessage_Details(),
				theEcorePackage.getEString(),
				"details", null, 0, 1, IMOAOMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(severityEEnum, Severity.class, "Severity"); //$NON-NLS-1$
		addEEnumLiteral(severityEEnum, Severity.WARNING);
		addEEnumLiteral(severityEEnum, Severity.ERROR);
		addEEnumLiteral(severityEEnum, Severity.INFO);
		addEEnumLiteral(severityEEnum, Severity.COMMENT);

		// Initialize data types
		initEDataType(eDiagnosticChainEDataType, DiagnosticChain.class,
				"EDiagnosticChain", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(eMapEDataType, Map.class, "EMap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		final String source = "http://www.eclipse.org/emf/2002/GenModel"; //$NON-NLS-1$		
		addAnnotation(this, source, new String[] { "nonNLSMarkers", "true", //$NON-NLS-1$ //$NON-NLS-2$
				"classPackageSuffix", "internal", //$NON-NLS-1$ //$NON-NLS-2$
				"adapterFactory", "false", //$NON-NLS-1$ //$NON-NLS-2$
				"classNamePattern", "{0}Impl", //$NON-NLS-1$ //$NON-NLS-2$
				"interfaceNamePattern", "I{0}", //$NON-NLS-1$ //$NON-NLS-2$
				"suppressEMFModelTags", "true", //$NON-NLS-1$ //$NON-NLS-2$
				"fileExtensions", "moao", //$NON-NLS-1$ //$NON-NLS-2$
				"suppressGenModelAnnotations", "false", //$NON-NLS-1$ //$NON-NLS-2$
				"language", "", //$NON-NLS-1$ //$NON-NLS-2$
				"prefix", "MOAO", //$NON-NLS-1$ //$NON-NLS-2$
				"modelName", "MOAO", //$NON-NLS-1$ //$NON-NLS-2$
				"codeFormatting", "true", //$NON-NLS-1$ //$NON-NLS-2$
				"redirection", "", //$NON-NLS-1$ //$NON-NLS-2$
				"updateClasspath", "false", //$NON-NLS-1$ //$NON-NLS-2$
				"containmentProxies", "false", //$NON-NLS-1$ //$NON-NLS-2$
				"basePackage", "com.rcpcompany.uibindings" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(iAdaptableEClass, source, new String[] {
				"documentation", "*\n<p>\nIAdapable is used as an interface for MOAO." //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(eStructuralFeatureEClass, source, new String[] {
				"documentation", "*\n<p>\nStructural Feature from ECore" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(moaoEClass, source, new String[] {
				"documentation", "*\n<p>\nTop-level \"Mother of all Objects\"." //$NON-NLS-1$ //$NON-NLS-2$ 
		});
		addAnnotation(getMOAO__IsValid__DiagnosticChain_Map(), source, new String[] {
				"documentation", "*\n<p>\nValidation of this object.\n<p>\nExtend in your own class.", //$NON-NLS-1$ //$NON-NLS-2$
				"body", "return true;" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(
				getMOAO__RemoveMessagesByOwner__String(),
				source,
				new String[] {
						"documentation", "*\n<p>\nRemoves all messages from this object and all contained objects (using reflection) given by\nthe specified owner.\n\n@param owner the owner", //$NON-NLS-1$ //$NON-NLS-2$
						"body", "<%com.rcpcompany.uibindings.moao.IMOAO%> _this = this;\n_this.removeMessagesByOwner(null, owner);\n<%com.rcpcompany.uibindings.moao.IMOAO%> _this_1 = this;\nfinal <%org.eclipse.emf.common.util.TreeIterator%><<%org.eclipse.emf.ecore.EObject%>> allContents = _this_1.eAllContents();\nboolean _hasNext = allContents.hasNext();\nboolean _while = _hasNext;\nwhile (_while)\n{\n\t{\n\t\tfinal <%org.eclipse.emf.ecore.EObject%> next = allContents.next();\n\t\tboolean _matched = false;\n\t\tif (!_matched)\n\t\t{\n\t\t\tif (next instanceof <%com.rcpcompany.uibindings.moao.IMOAO%>)\n\t\t\t{\n\t\t\t\tfinal <%com.rcpcompany.uibindings.moao.IMOAO%> _iMOAO = (<%com.rcpcompany.uibindings.moao.IMOAO%>)next;\n\t\t\t\t_matched=true;\n\t\t\t\t((<%com.rcpcompany.uibindings.moao.IMOAO%>) _iMOAO).removeMessagesByOwner(null, owner);\n\t\t\t}\n\t\t}\n\t}\n\tboolean _hasNext_1 = allContents.hasNext();\n\t_while = _hasNext_1;\n}" //$NON-NLS-1$ //$NON-NLS-2$
				});
		addAnnotation(
				getMOAO__RemoveMessagesByOwner__EStructuralFeature_String(),
				source,
				new String[] {
						"documentation", "*\n<p>\nRemoves all messages from this object given by the specified feature and owner.\n\n@param feature the feature of the messages or <code>null</code> if the feature should be\n           ignored\n@param owner the owner of the messages", //$NON-NLS-1$ //$NON-NLS-2$
						"body", "<%com.rcpcompany.uibindings.moao.IMOAO%> _this = this;\nboolean _eIsSet = _this.eIsSet(<%com.rcpcompany.uibindings.moao.IMOAOPackage.Literals%>.MOAO__FACETS);\nboolean _not = (!_eIsSet);\nif (_not)\n{\n\treturn;\n}\n<%com.rcpcompany.uibindings.moao.IMOAO%> _this_1 = this;\n<%org.eclipse.emf.common.util.EList%><<%com.rcpcompany.uibindings.moao.IMOAOFacet%>> _facets = _this_1.getFacets();\nfinal <%java.util.Iterator%><<%com.rcpcompany.uibindings.moao.IMOAOFacet%>> iterator = _facets.iterator();\nboolean _hasNext = iterator.hasNext();\nboolean _while = _hasNext;\nwhile (_while)\n{\n\t{\n\t\tfinal <%com.rcpcompany.uibindings.moao.IMOAOFacet%> next = iterator.next();\n\t\tboolean _matched = false;\n\t\tif (!_matched)\n\t\t{\n\t\t\tif (next instanceof <%com.rcpcompany.uibindings.moao.IMOAOMessage%>)\n\t\t\t{\n\t\t\t\tfinal <%com.rcpcompany.uibindings.moao.IMOAOMessage%> _iMOAOMessage = (<%com.rcpcompany.uibindings.moao.IMOAOMessage%>)next;\n\t\t\t\t_matched=true;\n\t\t\t\tfinal <%com.rcpcompany.uibindings.moao.IMOAOMessage%> m = ((<%com.rcpcompany.uibindings.moao.IMOAOMessage%>) _iMOAOMessage);\n\t\t\t\tboolean _and = false;\n\t\t\t\tboolean _and_1 = false;\n\t\t\t\tboolean _notEquals = <%org.eclipse.xtext.xbase.lib.ObjectExtensions%>.operator_notEquals(feature, null);\n\t\t\t\tif (!_notEquals)\n\t\t\t\t{\n\t\t\t\t\t_and_1 = false;\n\t\t\t\t} else\n\t\t\t\t{\n\t\t\t\t\t<%org.eclipse.emf.ecore.EStructuralFeature%> _feature = m.getFeature();\n\t\t\t\t\tboolean _equals = <%org.eclipse.xtext.xbase.lib.ObjectExtensions%>.operator_equals(feature, _feature);\n\t\t\t\t\t_and_1 = (_notEquals && _equals);\n\t\t\t\t}\n\t\t\t\tif (!_and_1)\n\t\t\t\t{\n\t\t\t\t\t_and = false;\n\t\t\t\t} else\n\t\t\t\t{\n\t\t\t\t\t<%java.lang.String%> _owner = m.getOwner();\n\t\t\t\t\tboolean _equals_1 = <%org.eclipse.xtext.xbase.lib.ObjectExtensions%>.operator_equals(owner, _owner);\n\t\t\t\t\t_and = (_and_1 && _equals_1);\n\t\t\t\t}\n\t\t\t\tif (_and)\n\t\t\t\t{\n\t\t\t\t\titerator.remove();\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\tboolean _hasNext_1 = iterator.hasNext();\n\t_while = _hasNext_1;\n}" //$NON-NLS-1$ //$NON-NLS-2$
				});
		addAnnotation(getMOAO_Facets(), source, new String[] { "documentation", "*\n<p>\nAll facets of this object." //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(moaoFacetEClass, source, new String[] {
				"documentation", "*\n<p>\nA facet of an MOAO.\n<p>\nShould be extended in sub-classes." //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getMOAOFacet_Object(), source, new String[] {
				"documentation", "*\n<p>\nThe parent object of this facet." //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(namedObjectEClass, source, new String[] {
				"documentation", "*\n<p>\nMOAO with a name and description." //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getNamedObject_Name(), source, new String[] { "documentation", "*\n<p>\nThe name of the object." //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getNamedObject_Description(), source, new String[] {
				"documentation", "*\n<p>\nThe description of the object." //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(
				getNamedObject_Uuid(),
				source,
				new String[] {
						"documentation", "*\n<p>\nThe UUID of the object.\n<p>\nInitialized as <code>EcoreUtil.generateUUID()</code>", //$NON-NLS-1$ //$NON-NLS-2$
						"suppressedSetVisibility", "true", //$NON-NLS-1$ //$NON-NLS-2$
						"suppressedUnsetVisibility", "true" //$NON-NLS-1$ //$NON-NLS-2$
				});
		addAnnotation(getMOAOMessage_Owner(), source, new String[] {
				"documentation", "*\n<p>\nThe owner of the message." //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getMOAOMessage_Feature(), source, new String[] {
				"documentation", "*\n<p>\nThe feature of the message." //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getMOAOMessage_Description(), source, new String[] {
				"documentation", "*\n<p>\nThe description of the message." //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getMOAOMessage_Severity(), source, new String[] {
				"documentation", "*\n<p>\nThe severity of the message." //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getMOAOMessage_Details(), source, new String[] {
				"documentation", "*\n<p>\nAny details of the message.\n<p>\nCan be stack trace or similar." //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(severityEEnum.getELiterals().get(0), source, new String[] {
				"documentation", "*\n<p>\nWarning message." //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(severityEEnum.getELiterals().get(1), source, new String[] {
				"documentation", "*\n<p>\nError message." //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(severityEEnum.getELiterals().get(2), source, new String[] {
				"documentation", "*\n<p>\nInformational message." //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(severityEEnum.getELiterals().get(3), source, new String[] { "documentation", "*\n<p>\nComment." //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

} // MOAOPackageImpl
