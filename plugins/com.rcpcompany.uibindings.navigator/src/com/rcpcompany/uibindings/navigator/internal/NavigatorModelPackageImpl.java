/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.navigator.internal;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.navigator.IEditorModelType;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPartView;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.INavigatorModelFactory;
import com.rcpcompany.uibindings.navigator.INavigatorModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class NavigatorModelPackageImpl extends EPackageImpl implements INavigatorModelPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigatorManagerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass editorModelTypeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass editorPartDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iEditorPartFactoryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iEditorPartViewEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringToModelTypeMapEntryEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NavigatorModelPackageImpl() {
		super(eNS_URI, INavigatorModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link INavigatorModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static INavigatorModelPackage init() {
		if (isInited) return (INavigatorModelPackage)EPackage.Registry.INSTANCE.getEPackage(INavigatorModelPackage.eNS_URI);

		// Obtain or create and register package
		NavigatorModelPackageImpl theNavigatorModelPackage = (NavigatorModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NavigatorModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NavigatorModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IUIBindingsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theNavigatorModelPackage.createPackageContents();

		// Initialize created meta-data
		theNavigatorModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNavigatorModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(INavigatorModelPackage.eNS_URI, theNavigatorModelPackage);
		return theNavigatorModelPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNavigatorManager() {
		return navigatorManagerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigatorManager_Descriptors() {
		return (EReference)navigatorManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigatorManager_ModelTypes() {
		return (EReference)navigatorManagerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNavigatorManager_UseGenericEditorPartFallback() {
		return (EAttribute)navigatorManagerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNavigatorManager_PinEditorByDefault() {
		return (EAttribute)navigatorManagerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNavigatorManager_OpenMustOpenNew() {
		return (EAttribute)navigatorManagerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNavigatorManager_PreferenceModelTypes() {
		return (EAttribute)navigatorManagerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEditorModelType() {
		return editorModelTypeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEditorModelType_Editors() {
		return (EReference)editorModelTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEditorModelType_PreferredEditor() {
		return (EReference)editorModelTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEditorModelType_ModelType() {
		return (EAttribute)editorModelTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEditorPartDescriptor() {
		return editorPartDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEditorPartDescriptor_Id() {
		return (EAttribute)editorPartDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEditorPartDescriptor_Name() {
		return (EAttribute)editorPartDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEditorPartDescriptor_ModelTypes() {
		return (EAttribute)editorPartDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEditorPartDescriptor_Priority() {
		return (EAttribute)editorPartDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEditorPartDescriptor_FallbackEditor() {
		return (EAttribute)editorPartDescriptorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEditorPartDescriptor_Factory() {
		return (EAttribute)editorPartDescriptorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEditorPartDescriptor_Image() {
		return (EAttribute)editorPartDescriptorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIEditorPartFactory() {
		return iEditorPartFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIEditorPartView() {
		return iEditorPartViewEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringToModelTypeMapEntry() {
		return stringToModelTypeMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringToModelTypeMapEntry_Key() {
		return (EAttribute)stringToModelTypeMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStringToModelTypeMapEntry_Value() {
		return (EReference)stringToModelTypeMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public INavigatorModelFactory getNavigatorModelFactory() {
		return (INavigatorModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		navigatorManagerEClass = createEClass(NAVIGATOR_MANAGER);
		createEReference(navigatorManagerEClass, NAVIGATOR_MANAGER__DESCRIPTORS);
		createEReference(navigatorManagerEClass, NAVIGATOR_MANAGER__MODEL_TYPES);
		createEAttribute(navigatorManagerEClass, NAVIGATOR_MANAGER__USE_GENERIC_EDITOR_PART_FALLBACK);
		createEAttribute(navigatorManagerEClass, NAVIGATOR_MANAGER__PIN_EDITOR_BY_DEFAULT);
		createEAttribute(navigatorManagerEClass, NAVIGATOR_MANAGER__OPEN_MUST_OPEN_NEW);
		createEAttribute(navigatorManagerEClass, NAVIGATOR_MANAGER__PREFERENCE_MODEL_TYPES);

		editorModelTypeEClass = createEClass(EDITOR_MODEL_TYPE);
		createEReference(editorModelTypeEClass, EDITOR_MODEL_TYPE__EDITORS);
		createEReference(editorModelTypeEClass, EDITOR_MODEL_TYPE__PREFERRED_EDITOR);
		createEAttribute(editorModelTypeEClass, EDITOR_MODEL_TYPE__MODEL_TYPE);

		editorPartDescriptorEClass = createEClass(EDITOR_PART_DESCRIPTOR);
		createEAttribute(editorPartDescriptorEClass, EDITOR_PART_DESCRIPTOR__ID);
		createEAttribute(editorPartDescriptorEClass, EDITOR_PART_DESCRIPTOR__NAME);
		createEAttribute(editorPartDescriptorEClass, EDITOR_PART_DESCRIPTOR__MODEL_TYPES);
		createEAttribute(editorPartDescriptorEClass, EDITOR_PART_DESCRIPTOR__PRIORITY);
		createEAttribute(editorPartDescriptorEClass, EDITOR_PART_DESCRIPTOR__FALLBACK_EDITOR);
		createEAttribute(editorPartDescriptorEClass, EDITOR_PART_DESCRIPTOR__FACTORY);
		createEAttribute(editorPartDescriptorEClass, EDITOR_PART_DESCRIPTOR__IMAGE);

		iEditorPartFactoryEClass = createEClass(IEDITOR_PART_FACTORY);

		iEditorPartViewEClass = createEClass(IEDITOR_PART_VIEW);

		stringToModelTypeMapEntryEClass = createEClass(STRING_TO_MODEL_TYPE_MAP_ENTRY);
		createEAttribute(stringToModelTypeMapEntryEClass, STRING_TO_MODEL_TYPE_MAP_ENTRY__KEY);
		createEReference(stringToModelTypeMapEntryEClass, STRING_TO_MODEL_TYPE_MAP_ENTRY__VALUE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		IUIBindingsPackage theUIBindingsPackage = (IUIBindingsPackage)EPackage.Registry.INSTANCE.getEPackage(IUIBindingsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(navigatorManagerEClass, INavigatorManager.class, "NavigatorManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNavigatorManager_Descriptors(), this.getEditorPartDescriptor(), null, "descriptors", null, 0, -1, INavigatorManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNavigatorManager_ModelTypes(), this.getEditorModelType(), null, "modelTypes", null, 0, -1, INavigatorManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNavigatorManager_UseGenericEditorPartFallback(), ecorePackage.getEBoolean(), "useGenericEditorPartFallback", "true", 1, 1, INavigatorManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNavigatorManager_PinEditorByDefault(), ecorePackage.getEBoolean(), "pinEditorByDefault", "false", 1, 1, INavigatorManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNavigatorManager_OpenMustOpenNew(), ecorePackage.getEBoolean(), "openMustOpenNew", "false", 1, 1, INavigatorManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(theUIBindingsPackage.getCEObjectHolder());
		EGenericType g2 = createEGenericType(ecorePackage.getEObject());
		g1.getETypeArguments().add(g2);
		initEAttribute(getNavigatorManager_PreferenceModelTypes(), g1, "preferenceModelTypes", null, 0, -1, INavigatorManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(editorModelTypeEClass, IEditorModelType.class, "EditorModelType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEditorModelType_Editors(), this.getEditorPartDescriptor(), null, "editors", null, 0, -1, IEditorModelType.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEditorModelType_PreferredEditor(), this.getEditorPartDescriptor(), null, "preferredEditor", null, 0, 1, IEditorModelType.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEditorModelType_ModelType(), ecorePackage.getEString(), "modelType", null, 1, 1, IEditorModelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(editorPartDescriptorEClass, IEditorPartDescriptor.class, "EditorPartDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEditorPartDescriptor_Id(), ecorePackage.getEString(), "id", null, 1, 1, IEditorPartDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEditorPartDescriptor_Name(), ecorePackage.getEString(), "name", null, 1, 1, IEditorPartDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEditorPartDescriptor_ModelTypes(), ecorePackage.getEString(), "modelTypes", null, 0, -1, IEditorPartDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEditorPartDescriptor_Priority(), ecorePackage.getEInt(), "priority", null, 1, 1, IEditorPartDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEditorPartDescriptor_FallbackEditor(), ecorePackage.getEBoolean(), "fallbackEditor", "false", 1, 1, IEditorPartDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theUIBindingsPackage.getCEObjectHolder());
		g2 = createEGenericType(this.getIEditorPartFactory());
		g1.getETypeArguments().add(g2);
		initEAttribute(getEditorPartDescriptor_Factory(), g1, "factory", null, 1, 1, IEditorPartDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEditorPartDescriptor_Image(), theUIBindingsPackage.getCEResourceHolder(), "image", null, 1, 1, IEditorPartDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iEditorPartFactoryEClass, IEditorPartFactory.class, "IEditorPartFactory", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(iEditorPartViewEClass, IEditorPartView.class, "IEditorPartView", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringToModelTypeMapEntryEClass, Map.Entry.class, "StringToModelTypeMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringToModelTypeMapEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStringToModelTypeMapEntry_Value(), this.getEditorModelType(), null, "value", null, 0, 1, Map.Entry.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // NavigatorModelPackageImpl
