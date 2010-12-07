/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.scripting.internal;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.scripting.IFeatureScript;
import com.rcpcompany.uibindings.scripting.IScriptEnginePackage;
import com.rcpcompany.uibindings.scripting.IScriptingFactory;
import com.rcpcompany.uibindings.scripting.IScriptingPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ScriptingPackageImpl extends EPackageImpl implements IScriptingPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass featureScriptEClass = null;

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
	 * @see com.rcpcompany.uibindings.scripting.IScriptingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ScriptingPackageImpl() {
		super(eNS_URI, IScriptingFactory.eINSTANCE);
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
	 * This method is used to initialize {@link IScriptingPackage#eINSTANCE} when that field is
	 * accessed. Clients should not invoke it directly. Instead, they should simply access that
	 * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IScriptingPackage init() {
		if (isInited) return (IScriptingPackage) EPackage.Registry.INSTANCE.getEPackage(IScriptingPackage.eNS_URI);

		// Obtain or create and register package
		final ScriptingPackageImpl theScriptingPackage = (ScriptingPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof ScriptingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
				: new ScriptingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IMOAOPackage.eINSTANCE.eClass();
		IScriptEnginePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theScriptingPackage.createPackageContents();

		// Initialize created meta-data
		theScriptingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theScriptingPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IScriptingPackage.eNS_URI, theScriptingPackage);
		return theScriptingPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getFeatureScript() {
		return featureScriptEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getFeatureScript_Feature() {
		return (EReference) featureScriptEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getFeatureScript_Language() {
		return (EAttribute) featureScriptEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getFeatureScript_Script() {
		return (EAttribute) featureScriptEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getFeatureScript_Expression() {
		return (EReference) featureScriptEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IScriptingFactory getScriptingFactory() {
		return (IScriptingFactory) getEFactoryInstance();
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
		featureScriptEClass = createEClass(FEATURE_SCRIPT);
		createEReference(featureScriptEClass, FEATURE_SCRIPT__FEATURE);
		createEAttribute(featureScriptEClass, FEATURE_SCRIPT__LANGUAGE);
		createEAttribute(featureScriptEClass, FEATURE_SCRIPT__SCRIPT);
		createEReference(featureScriptEClass, FEATURE_SCRIPT__EXPRESSION);
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
		final IMOAOPackage theMOAOPackage = (IMOAOPackage) EPackage.Registry.INSTANCE.getEPackage(IMOAOPackage.eNS_URI);
		final IUIBindingsPackage theUIBindingsPackage = (IUIBindingsPackage) EPackage.Registry.INSTANCE
				.getEPackage(IUIBindingsPackage.eNS_URI);
		final EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);
		final IScriptEnginePackage theScriptEnginePackage = (IScriptEnginePackage) EPackage.Registry.INSTANCE
				.getEPackage(IScriptEnginePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		featureScriptEClass.getESuperTypes().add(theMOAOPackage.getMOAOFacet());
		featureScriptEClass.getESuperTypes().add(theUIBindingsPackage.getIDisposable());

		// Initialize classes and features; add operations and parameters
		initEClass(featureScriptEClass, IFeatureScript.class, "FeatureScript", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureScript_Feature(), theEcorePackage.getEStructuralFeature(), null, "feature", null, 1,
				1, IFeatureScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureScript_Language(), theEcorePackage.getEString(), "language", null, 0, 1,
				IFeatureScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureScript_Script(), ecorePackage.getEString(), "script", null, 1, 1,
				IFeatureScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureScript_Expression(), theScriptEnginePackage.getScriptExpression(), null, "expression",
				null, 0, 1, IFeatureScript.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // ScriptingPackageImpl
