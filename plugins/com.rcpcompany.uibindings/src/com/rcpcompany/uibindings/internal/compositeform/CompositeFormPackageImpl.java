/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.internal.compositeform;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.compositeform.ICompositeForm;
import com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor;
import com.rcpcompany.uibindings.compositeform.ICompositeFormFactory;
import com.rcpcompany.uibindings.compositeform.ICompositeFormManager;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPackage;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPart;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartFactory;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class CompositeFormPackageImpl extends EPackageImpl implements ICompositeFormPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass compositeFormManagerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass compositeFormDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass compositeFormEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass compositeFormPartDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass compositeFormPartEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iCompositeFormPartFactoryEDataType = null;

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
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CompositeFormPackageImpl() {
		super(eNS_URI, ICompositeFormFactory.eINSTANCE);
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
	 * This method is used to initialize {@link ICompositeFormPackage#eINSTANCE} when that field is
	 * accessed. Clients should not invoke it directly. Instead, they should simply access that
	 * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ICompositeFormPackage init() {
		if (isInited)
			return (ICompositeFormPackage) EPackage.Registry.INSTANCE.getEPackage(ICompositeFormPackage.eNS_URI);

		// Obtain or create and register package
		final CompositeFormPackageImpl theCompositeFormPackage = (CompositeFormPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof CompositeFormPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
				: new CompositeFormPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IUIBindingsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCompositeFormPackage.createPackageContents();

		// Initialize created meta-data
		theCompositeFormPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCompositeFormPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ICompositeFormPackage.eNS_URI, theCompositeFormPackage);
		return theCompositeFormPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getCompositeFormManager() {
		return compositeFormManagerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getCompositeFormManager_Forms() {
		return (EReference) compositeFormManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getCompositeFormDescriptor() {
		return compositeFormDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getCompositeFormDescriptor_Manager() {
		return (EReference) compositeFormDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getCompositeFormDescriptor_Id() {
		return (EAttribute) compositeFormDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getCompositeFormDescriptor_Parts() {
		return (EReference) compositeFormDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getCompositeForm() {
		return compositeFormEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getCompositeForm_Descriptor() {
		return (EReference) compositeFormEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getCompositeForm_Form() {
		return (EAttribute) compositeFormEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getCompositeForm_Parts() {
		return (EReference) compositeFormEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getCompositeFormPartDescriptor() {
		return compositeFormPartDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getCompositeFormPartDescriptor_Form() {
		return (EReference) compositeFormPartDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getCompositeFormPartDescriptor_Priority() {
		return (EAttribute) compositeFormPartDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getCompositeFormPartDescriptor_Factory() {
		return (EAttribute) compositeFormPartDescriptorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getCompositeFormPartDescriptor_Title() {
		return (EAttribute) compositeFormPartDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getCompositeFormPartDescriptor_Image() {
		return (EAttribute) compositeFormPartDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getCompositeFormPart() {
		return compositeFormPartEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getCompositeFormPart_Form() {
		return (EReference) compositeFormPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getCompositeFormPart_Descriptor() {
		return (EReference) compositeFormPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getCompositeFormPart_Enabled() {
		return (EAttribute) compositeFormPartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getICompositeFormPartFactory() {
		return iCompositeFormPartFactoryEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ICompositeFormFactory getCompositeFormFactory() {
		return (ICompositeFormFactory) getEFactoryInstance();
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
		compositeFormManagerEClass = createEClass(COMPOSITE_FORM_MANAGER);
		createEReference(compositeFormManagerEClass, COMPOSITE_FORM_MANAGER__FORMS);

		compositeFormDescriptorEClass = createEClass(COMPOSITE_FORM_DESCRIPTOR);
		createEReference(compositeFormDescriptorEClass, COMPOSITE_FORM_DESCRIPTOR__MANAGER);
		createEAttribute(compositeFormDescriptorEClass, COMPOSITE_FORM_DESCRIPTOR__ID);
		createEReference(compositeFormDescriptorEClass, COMPOSITE_FORM_DESCRIPTOR__PARTS);

		compositeFormEClass = createEClass(COMPOSITE_FORM);
		createEReference(compositeFormEClass, COMPOSITE_FORM__DESCRIPTOR);
		createEAttribute(compositeFormEClass, COMPOSITE_FORM__FORM);
		createEReference(compositeFormEClass, COMPOSITE_FORM__PARTS);

		compositeFormPartDescriptorEClass = createEClass(COMPOSITE_FORM_PART_DESCRIPTOR);
		createEReference(compositeFormPartDescriptorEClass, COMPOSITE_FORM_PART_DESCRIPTOR__FORM);
		createEAttribute(compositeFormPartDescriptorEClass, COMPOSITE_FORM_PART_DESCRIPTOR__PRIORITY);
		createEAttribute(compositeFormPartDescriptorEClass, COMPOSITE_FORM_PART_DESCRIPTOR__TITLE);
		createEAttribute(compositeFormPartDescriptorEClass, COMPOSITE_FORM_PART_DESCRIPTOR__IMAGE);
		createEAttribute(compositeFormPartDescriptorEClass, COMPOSITE_FORM_PART_DESCRIPTOR__FACTORY);

		compositeFormPartEClass = createEClass(COMPOSITE_FORM_PART);
		createEReference(compositeFormPartEClass, COMPOSITE_FORM_PART__FORM);
		createEReference(compositeFormPartEClass, COMPOSITE_FORM_PART__DESCRIPTOR);
		createEAttribute(compositeFormPartEClass, COMPOSITE_FORM_PART__ENABLED);

		// Create data types
		iCompositeFormPartFactoryEDataType = createEDataType(ICOMPOSITE_FORM_PART_FACTORY);
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
		final IUIBindingsPackage theUIBindingsPackage = (IUIBindingsPackage) EPackage.Registry.INSTANCE
				.getEPackage(IUIBindingsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(compositeFormManagerEClass, ICompositeFormManager.class, "CompositeFormManager", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeFormManager_Forms(), this.getCompositeFormDescriptor(),
				this.getCompositeFormDescriptor_Manager(), "forms", null, 0, -1, ICompositeFormManager.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeFormDescriptorEClass, ICompositeFormDescriptor.class, "CompositeFormDescriptor",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeFormDescriptor_Manager(), this.getCompositeFormManager(),
				this.getCompositeFormManager_Forms(), "manager", null, 1, 1, ICompositeFormDescriptor.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeFormDescriptor_Id(), ecorePackage.getEString(), "id", null, 1, 1,
				ICompositeFormDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeFormDescriptor_Parts(), this.getCompositeFormPartDescriptor(),
				this.getCompositeFormPartDescriptor_Form(), "parts", null, 0, -1, ICompositeFormDescriptor.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeFormEClass, ICompositeForm.class, "CompositeForm", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeForm_Descriptor(), this.getCompositeFormDescriptor(), null, "descriptor", null, 1,
				1, ICompositeForm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeForm_Form(), theUIBindingsPackage.getFormCreator(), "form", null, 0, 1,
				ICompositeForm.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeForm_Parts(), this.getCompositeFormPart(), this.getCompositeFormPart_Form(),
				"parts", null, 0, -1, ICompositeForm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeFormPartDescriptorEClass, ICompositeFormPartDescriptor.class,
				"CompositeFormPartDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeFormPartDescriptor_Form(), this.getCompositeFormDescriptor(),
				this.getCompositeFormDescriptor_Parts(), "form", null, 1, 1, ICompositeFormPartDescriptor.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeFormPartDescriptor_Priority(), ecorePackage.getEInt(), "priority", null, 1, 1,
				ICompositeFormPartDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeFormPartDescriptor_Title(), ecorePackage.getEString(), "title", null, 1, 1,
				ICompositeFormPartDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeFormPartDescriptor_Image(), theUIBindingsPackage.getCEResourceHolder(), "image",
				null, 1, 1, ICompositeFormPartDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		final EGenericType g1 = createEGenericType(theUIBindingsPackage.getCEObjectHolder());
		final EGenericType g2 = createEGenericType(this.getICompositeFormPartFactory());
		g1.getETypeArguments().add(g2);
		initEAttribute(getCompositeFormPartDescriptor_Factory(), g1, "factory", null, 1, 1,
				ICompositeFormPartDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeFormPartEClass, ICompositeFormPart.class, "CompositeFormPart", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeFormPart_Form(), this.getCompositeForm(), this.getCompositeForm_Parts(), "form",
				null, 1, 1, ICompositeFormPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeFormPart_Descriptor(), this.getCompositeFormPartDescriptor(), null, "descriptor",
				null, 1, 1, ICompositeFormPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeFormPart_Enabled(), ecorePackage.getEBoolean(), "enabled", null, 1, 1,
				ICompositeFormPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(iCompositeFormPartFactoryEDataType, ICompositeFormPartFactory.class, "ICompositeFormPartFactory",
				!IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} // CompositeFormPackageImpl
