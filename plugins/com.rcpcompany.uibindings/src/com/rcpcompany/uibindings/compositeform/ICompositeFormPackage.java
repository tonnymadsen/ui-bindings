/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.compositeform;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormFactory
 * @generated
 */
public interface ICompositeFormPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "uibindings";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://rcp-company.com/schemas/uibindings/compositeForm.ecore";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "compositeForm";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ICompositeFormPackage eINSTANCE = com.rcpcompany.uibindings.internal.compositeform.CompositeFormPackageImpl.init();

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormManagerImpl
	 * <em>Manager</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormManagerImpl
	 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPackageImpl#getCompositeFormManager()
	 * @generated
	 */
	int COMPOSITE_FORM_MANAGER = 0;

	/**
	 * The feature id for the '<em><b>Forms</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_MANAGER__FORMS = 0;

	/**
	 * The number of structural features of the '<em>Manager</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_MANAGER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormDescriptorImpl
	 * <em>Descriptor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormDescriptorImpl
	 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPackageImpl#getCompositeFormDescriptor()
	 * @generated
	 */
	int COMPOSITE_FORM_DESCRIPTOR = 1;

	/**
	 * The feature id for the '<em><b>Manager</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_DESCRIPTOR__MANAGER = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_DESCRIPTOR__ID = 1;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_DESCRIPTOR__PARTS = 2;

	/**
	 * The number of structural features of the '<em>Descriptor</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_DESCRIPTOR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormImpl
	 * <em>Composite Form</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormImpl
	 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPackageImpl#getCompositeForm()
	 * @generated
	 */
	int COMPOSITE_FORM = 3;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartDescriptorImpl
	 * <em>Part Descriptor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartDescriptorImpl
	 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPackageImpl#getCompositeFormPartDescriptor()
	 * @generated
	 */
	int COMPOSITE_FORM_PART_DESCRIPTOR = 2;

	/**
	 * The feature id for the '<em><b>Form</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_PART_DESCRIPTOR__FORM = 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_PART_DESCRIPTOR__PRIORITY = 1;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_PART_DESCRIPTOR__TITLE = 2;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_PART_DESCRIPTOR__IMAGE = 3;

	/**
	 * The feature id for the '<em><b>Factory</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_PART_DESCRIPTOR__FACTORY = 4;

	/**
	 * The number of structural features of the '<em>Part Descriptor</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_PART_DESCRIPTOR_FEATURE_COUNT = 5;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM__DESCRIPTOR = 0;

	/**
	 * The feature id for the '<em><b>Form Creator</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM__FORM_CREATOR = 1;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM__PARTS = 2;

	/**
	 * The number of structural features of the '<em>Composite Form</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartImpl <em>Part</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartImpl
	 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPackageImpl#getCompositeFormPart()
	 * @generated
	 */
	int COMPOSITE_FORM_PART = 4;

	/**
	 * The feature id for the '<em><b>Form</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_PART__FORM = 0;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_PART__DESCRIPTOR = 1;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_PART__TITLE = 2;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_PART__IMAGE = 3;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_PART__ENABLED = 4;

	/**
	 * The feature id for the '<em><b>Open</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_PART__OPEN = 5;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_PART__OPERATIONS = 6;

	/**
	 * The feature id for the '<em><b>Form Creator</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_PART__FORM_CREATOR = 7;

	/**
	 * The number of structural features of the '<em>Part</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FORM_PART_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '<em>IComposite Form Part Factory</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPartFactory
	 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPackageImpl#getICompositeFormPartFactory()
	 * @generated
	 */
	int ICOMPOSITE_FORM_PART_FACTORY = 5;

	/**
	 * The meta object id for the '<em>IComposite Form Part Operations</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPartOperations
	 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPackageImpl#getICompositeFormPartOperations()
	 * @generated
	 */
	int ICOMPOSITE_FORM_PART_OPERATIONS = 6;

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormManager <em>Manager</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Manager</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormManager
	 * @generated
	 */
	EClass getCompositeFormManager();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormManager#getForms <em>Forms</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Forms</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormManager#getForms()
	 * @see #getCompositeFormManager()
	 * @generated
	 */
	EReference getCompositeFormManager_Forms();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor <em>Descriptor</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Descriptor</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor
	 * @generated
	 */
	EClass getCompositeFormDescriptor();

	/**
	 * Returns the meta object for the container reference '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor#getManager
	 * <em>Manager</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Manager</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor#getManager()
	 * @see #getCompositeFormDescriptor()
	 * @generated
	 */
	EReference getCompositeFormDescriptor_Manager();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor#getId <em>Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor#getId()
	 * @see #getCompositeFormDescriptor()
	 * @generated
	 */
	EAttribute getCompositeFormDescriptor_Id();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor#getParts
	 * <em>Parts</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor#getParts()
	 * @see #getCompositeFormDescriptor()
	 * @generated
	 */
	EReference getCompositeFormDescriptor_Parts();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeForm <em>Composite Form</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Composite Form</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeForm
	 * @generated
	 */
	EClass getCompositeForm();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeForm#getDescriptor
	 * <em>Descriptor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Descriptor</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeForm#getDescriptor()
	 * @see #getCompositeForm()
	 * @generated
	 */
	EReference getCompositeForm_Descriptor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeForm#getFormCreator
	 * <em>Form Creator</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Form Creator</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeForm#getFormCreator()
	 * @see #getCompositeForm()
	 * @generated
	 */
	EAttribute getCompositeForm_FormCreator();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeForm#getParts <em>Parts</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeForm#getParts()
	 * @see #getCompositeForm()
	 * @generated
	 */
	EReference getCompositeForm_Parts();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor
	 * <em>Part Descriptor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Part Descriptor</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor
	 * @generated
	 */
	EClass getCompositeFormPartDescriptor();

	/**
	 * Returns the meta object for the container reference '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getForm
	 * <em>Form</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Form</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getForm()
	 * @see #getCompositeFormPartDescriptor()
	 * @generated
	 */
	EReference getCompositeFormPartDescriptor_Form();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getPriority
	 * <em>Priority</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getPriority()
	 * @see #getCompositeFormPartDescriptor()
	 * @generated
	 */
	EAttribute getCompositeFormPartDescriptor_Priority();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getFactory
	 * <em>Factory</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Factory</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getFactory()
	 * @see #getCompositeFormPartDescriptor()
	 * @generated
	 */
	EAttribute getCompositeFormPartDescriptor_Factory();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getTitle
	 * <em>Title</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getTitle()
	 * @see #getCompositeFormPartDescriptor()
	 * @generated
	 */
	EAttribute getCompositeFormPartDescriptor_Title();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getImage
	 * <em>Image</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getImage()
	 * @see #getCompositeFormPartDescriptor()
	 * @generated
	 */
	EAttribute getCompositeFormPartDescriptor_Image();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart <em>Part</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Part</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPart
	 * @generated
	 */
	EClass getCompositeFormPart();

	/**
	 * Returns the meta object for the container reference '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getForm <em>Form</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Form</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getForm()
	 * @see #getCompositeFormPart()
	 * @generated
	 */
	EReference getCompositeFormPart_Form();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getDescriptor
	 * <em>Descriptor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Descriptor</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getDescriptor()
	 * @see #getCompositeFormPart()
	 * @generated
	 */
	EReference getCompositeFormPart_Descriptor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getTitle()
	 * @see #getCompositeFormPart()
	 * @generated
	 */
	EAttribute getCompositeFormPart_Title();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getImage()
	 * @see #getCompositeFormPart()
	 * @generated
	 */
	EAttribute getCompositeFormPart_Image();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#isEnabled <em>Enabled</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPart#isEnabled()
	 * @see #getCompositeFormPart()
	 * @generated
	 */
	EAttribute getCompositeFormPart_Enabled();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#isOpen <em>Open</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Open</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPart#isOpen()
	 * @see #getCompositeFormPart()
	 * @generated
	 */
	EAttribute getCompositeFormPart_Open();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getOperations
	 * <em>Operations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Operations</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getOperations()
	 * @see #getCompositeFormPart()
	 * @generated
	 */
	EAttribute getCompositeFormPart_Operations();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getFormCreator
	 * <em>Form Creator</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Form Creator</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getFormCreator()
	 * @see #getCompositeFormPart()
	 * @generated
	 */
	EAttribute getCompositeFormPart_FormCreator();

	/**
	 * Returns the meta object for data type '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartFactory
	 * <em>IComposite Form Part Factory</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>IComposite Form Part Factory</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPartFactory
	 * @generated
	 */
	EDataType getICompositeFormPartFactory();

	/**
	 * Returns the meta object for data type '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartOperations
	 * <em>IComposite Form Part Operations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>IComposite Form Part Operations</em>'.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPartOperations
	 * @generated
	 */
	EDataType getICompositeFormPartOperations();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ICompositeFormFactory getCompositeFormFactory();

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
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormManagerImpl
		 * <em>Manager</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormManagerImpl
		 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPackageImpl#getCompositeFormManager()
		 * @generated
		 */
		EClass COMPOSITE_FORM_MANAGER = eINSTANCE.getCompositeFormManager();

		/**
		 * The meta object literal for the '<em><b>Forms</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPOSITE_FORM_MANAGER__FORMS = eINSTANCE.getCompositeFormManager_Forms();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormDescriptorImpl
		 * <em>Descriptor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormDescriptorImpl
		 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPackageImpl#getCompositeFormDescriptor()
		 * @generated
		 */
		EClass COMPOSITE_FORM_DESCRIPTOR = eINSTANCE.getCompositeFormDescriptor();

		/**
		 * The meta object literal for the '<em><b>Manager</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPOSITE_FORM_DESCRIPTOR__MANAGER = eINSTANCE.getCompositeFormDescriptor_Manager();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMPOSITE_FORM_DESCRIPTOR__ID = eINSTANCE.getCompositeFormDescriptor_Id();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPOSITE_FORM_DESCRIPTOR__PARTS = eINSTANCE.getCompositeFormDescriptor_Parts();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormImpl
		 * <em>Composite Form</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormImpl
		 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPackageImpl#getCompositeForm()
		 * @generated
		 */
		EClass COMPOSITE_FORM = eINSTANCE.getCompositeForm();

		/**
		 * The meta object literal for the '<em><b>Descriptor</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPOSITE_FORM__DESCRIPTOR = eINSTANCE.getCompositeForm_Descriptor();

		/**
		 * The meta object literal for the '<em><b>Form Creator</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMPOSITE_FORM__FORM_CREATOR = eINSTANCE.getCompositeForm_FormCreator();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPOSITE_FORM__PARTS = eINSTANCE.getCompositeForm_Parts();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartDescriptorImpl
		 * <em>Part Descriptor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartDescriptorImpl
		 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPackageImpl#getCompositeFormPartDescriptor()
		 * @generated
		 */
		EClass COMPOSITE_FORM_PART_DESCRIPTOR = eINSTANCE.getCompositeFormPartDescriptor();

		/**
		 * The meta object literal for the '<em><b>Form</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPOSITE_FORM_PART_DESCRIPTOR__FORM = eINSTANCE.getCompositeFormPartDescriptor_Form();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMPOSITE_FORM_PART_DESCRIPTOR__PRIORITY = eINSTANCE.getCompositeFormPartDescriptor_Priority();

		/**
		 * The meta object literal for the '<em><b>Factory</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMPOSITE_FORM_PART_DESCRIPTOR__FACTORY = eINSTANCE.getCompositeFormPartDescriptor_Factory();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMPOSITE_FORM_PART_DESCRIPTOR__TITLE = eINSTANCE.getCompositeFormPartDescriptor_Title();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMPOSITE_FORM_PART_DESCRIPTOR__IMAGE = eINSTANCE.getCompositeFormPartDescriptor_Image();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartImpl
		 * <em>Part</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartImpl
		 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPackageImpl#getCompositeFormPart()
		 * @generated
		 */
		EClass COMPOSITE_FORM_PART = eINSTANCE.getCompositeFormPart();

		/**
		 * The meta object literal for the '<em><b>Form</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPOSITE_FORM_PART__FORM = eINSTANCE.getCompositeFormPart_Form();

		/**
		 * The meta object literal for the '<em><b>Descriptor</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPOSITE_FORM_PART__DESCRIPTOR = eINSTANCE.getCompositeFormPart_Descriptor();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMPOSITE_FORM_PART__TITLE = eINSTANCE.getCompositeFormPart_Title();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMPOSITE_FORM_PART__IMAGE = eINSTANCE.getCompositeFormPart_Image();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMPOSITE_FORM_PART__ENABLED = eINSTANCE.getCompositeFormPart_Enabled();

		/**
		 * The meta object literal for the '<em><b>Open</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMPOSITE_FORM_PART__OPEN = eINSTANCE.getCompositeFormPart_Open();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMPOSITE_FORM_PART__OPERATIONS = eINSTANCE.getCompositeFormPart_Operations();

		/**
		 * The meta object literal for the '<em><b>Form Creator</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMPOSITE_FORM_PART__FORM_CREATOR = eINSTANCE.getCompositeFormPart_FormCreator();

		/**
		 * The meta object literal for the '<em>IComposite Form Part Factory</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPartFactory
		 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPackageImpl#getICompositeFormPartFactory()
		 * @generated
		 */
		EDataType ICOMPOSITE_FORM_PART_FACTORY = eINSTANCE.getICompositeFormPartFactory();

		/**
		 * The meta object literal for the '<em>IComposite Form Part Operations</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPartOperations
		 * @see com.rcpcompany.uibindings.internal.compositeform.CompositeFormPackageImpl#getICompositeFormPartOperations()
		 * @generated
		 */
		EDataType ICOMPOSITE_FORM_PART_OPERATIONS = eINSTANCE.getICompositeFormPartOperations();

	}

} // ICompositeFormPackage
