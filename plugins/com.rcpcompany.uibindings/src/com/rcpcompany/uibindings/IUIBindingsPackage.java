/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see com.rcpcompany.uibindings.IUIBindingsFactory
 * @generated
 */
public interface IUIBindingsPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "uibindings"; //$NON-NLS-1$

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://rcp-company.com/schemas/uibindings/model.ecore"; //$NON-NLS-1$

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "uibindings"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	IUIBindingsPackage eINSTANCE = com.rcpcompany.uibindings.internal.UIBindingsPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.IServiceRegistry
	 * <em>Service Registry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.IServiceRegistry
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getServiceRegistry()
	 * @generated
	 */
	int SERVICE_REGISTRY = 36;

	/**
	 * The feature id for the '<em><b>Services</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE_REGISTRY__SERVICES = 0;

	/**
	 * The number of structural features of the '<em>Service Registry</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE_REGISTRY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.BaseObjectImpl
	 * <em>Base Object</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.BaseObjectImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getBaseObject()
	 * @generated
	 */
	int BASE_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Services</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASE_OBJECT__SERVICES = SERVICE_REGISTRY__SERVICES;

	/**
	 * The number of structural features of the '<em>Base Object</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASE_OBJECT_FEATURE_COUNT = SERVICE_REGISTRY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.ManagerImpl
	 * <em>Manager</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.ManagerImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getManager()
	 * @generated
	 */
	int MANAGER = 1;

	/**
	 * The feature id for the '<em><b>Services</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__SERVICES = BASE_OBJECT__SERVICES;

	/**
	 * The feature id for the '<em><b>Editing Domain</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__EDITING_DOMAIN = BASE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Form Toolkit</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__FORM_TOOLKIT = BASE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Providers</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__PROVIDERS = BASE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ui Attribute Factories</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__UI_ATTRIBUTE_FACTORIES = BASE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Decorator Extenders</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__DECORATOR_EXTENDERS = BASE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Model Argument Mediators</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__MODEL_ARGUMENT_MEDIATORS = BASE_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Model Argument Mediator Classes</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__MODEL_ARGUMENT_MEDIATOR_CLASSES = BASE_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Text Commit Strategy</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__TEXT_COMMIT_STRATEGY = BASE_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Text Commit Strategy Delay</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__TEXT_COMMIT_STRATEGY_DELAY = BASE_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Edit Cell Any Key</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__EDIT_CELL_ANY_KEY = BASE_OBJECT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Edit Cell Single Click</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__EDIT_CELL_SINGLE_CLICK = BASE_OBJECT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Message Decoration Position</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__MESSAGE_DECORATION_POSITION = BASE_OBJECT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Message Decoration Minimum Severity</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__MESSAGE_DECORATION_MINIMUM_SEVERITY = BASE_OBJECT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Alternative Decoration Position</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__ALTERNATIVE_DECORATION_POSITION = BASE_OBJECT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Auto Apply Single Quickfix</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__AUTO_APPLY_SINGLE_QUICKFIX = BASE_OBJECT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Alternate Row Colors</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__ALTERNATE_ROW_COLORS = BASE_OBJECT_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Validation Errors Are Fatal</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__VALIDATION_ERRORS_ARE_FATAL = BASE_OBJECT_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Validation Delay</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__VALIDATION_DELAY = BASE_OBJECT_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Validation Delay Window</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__VALIDATION_DELAY_WINDOW = BASE_OBJECT_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Required VB Image Decoration Shown</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__REQUIRED_VB_IMAGE_DECORATION_SHOWN = BASE_OBJECT_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Assist VB Image Decoration Shown</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__ASSIST_VB_IMAGE_DECORATION_SHOWN = BASE_OBJECT_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Quickfix VB Image Decoration Shown</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__QUICKFIX_VB_IMAGE_DECORATION_SHOWN = BASE_OBJECT_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>View Navigation Recorded</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__VIEW_NAVIGATION_RECORDED = BASE_OBJECT_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Model Info</b></em>' map. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__MODEL_INFO = BASE_OBJECT_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Tree Items</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__TREE_ITEMS = BASE_OBJECT_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Clipboard</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__CLIPBOARD = BASE_OBJECT_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Observable Factories</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__OBSERVABLE_FACTORIES = BASE_OBJECT_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Quickfix Proposal Processors</b></em>' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__QUICKFIX_PROPOSAL_PROCESSORS = BASE_OBJECT_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__CONTEXTS = BASE_OBJECT_FEATURE_COUNT + 28;

	/**
	 * The feature id for the '<em><b>Formatter Provider</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER__FORMATTER_PROVIDER = BASE_OBJECT_FEATURE_COUNT + 29;

	/**
	 * The number of structural features of the '<em>Manager</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MANAGER_FEATURE_COUNT = BASE_OBJECT_FEATURE_COUNT + 30;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.BindingContextImpl
	 * <em>Binding Context</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.BindingContextImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getBindingContext()
	 * @generated
	 */
	int BINDING_CONTEXT = 2;

	/**
	 * The feature id for the '<em><b>Services</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_CONTEXT__SERVICES = BASE_OBJECT__SERVICES;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_CONTEXT__BINDINGS = BASE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ok Bindings</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_CONTEXT__OK_BINDINGS = BASE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Top</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_CONTEXT__TOP = BASE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Db Context</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_CONTEXT__DB_CONTEXT = BASE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Service Locator</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_CONTEXT__SERVICE_LOCATOR = BASE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_CONTEXT__STATE = BASE_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Text Commit Strategy</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_CONTEXT__TEXT_COMMIT_STRATEGY = BASE_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Text Commit Strategy Calculated</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_CONTEXT__TEXT_COMMIT_STRATEGY_CALCULATED = BASE_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Editing Domain</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_CONTEXT__EDITING_DOMAIN = BASE_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Finalizers</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_CONTEXT__FINALIZERS = BASE_OBJECT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Binding Context</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_CONTEXT_FEATURE_COUNT = BASE_OBJECT_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.BindingImpl
	 * <em>Binding</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.BindingImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getBinding()
	 * @generated
	 */
	int BINDING = 3;

	/**
	 * The feature id for the '<em><b>Services</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__SERVICES = BASE_OBJECT__SERVICES;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__CONTEXT = BASE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__STATE = BASE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__CHANGEABLE = BASE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Creation Point</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__CREATION_POINT = BASE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__ID = BASE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__TYPE = BASE_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__LABEL = BASE_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Static Data Type</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__STATIC_DATA_TYPE = BASE_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__DATA_TYPE = BASE_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Model EType</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__MODEL_ETYPE = BASE_OBJECT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Model Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__MODEL_TYPE = BASE_OBJECT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>UI Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__UI_TYPE = BASE_OBJECT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>DB Bindings</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__DB_BINDINGS = BASE_OBJECT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Monitored DB Bindings</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__MONITORED_DB_BINDINGS = BASE_OBJECT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Error Conditions</b></em>' attribute list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__ERROR_CONDITIONS = BASE_OBJECT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__WIDGET = BASE_OBJECT_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Control</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__CONTROL = BASE_OBJECT_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Extra Argument Providers</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__EXTRA_ARGUMENT_PROVIDERS = BASE_OBJECT_FEATURE_COUNT + 17;

	/**
	 * The number of structural features of the '<em>Binding</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_FEATURE_COUNT = BASE_OBJECT_FEATURE_COUNT + 18;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.ValueBindingImpl
	 * <em>Value Binding</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.ValueBindingImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getValueBinding()
	 * @generated
	 */
	int VALUE_BINDING = 4;

	/**
	 * The feature id for the '<em><b>Services</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__SERVICES = BINDING__SERVICES;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__CONTEXT = BINDING__CONTEXT;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__STATE = BINDING__STATE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__CHANGEABLE = BINDING__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Creation Point</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__CREATION_POINT = BINDING__CREATION_POINT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__ID = BINDING__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__TYPE = BINDING__TYPE;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__LABEL = BINDING__LABEL;

	/**
	 * The feature id for the '<em><b>Static Data Type</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__STATIC_DATA_TYPE = BINDING__STATIC_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__DATA_TYPE = BINDING__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Model EType</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__MODEL_ETYPE = BINDING__MODEL_ETYPE;

	/**
	 * The feature id for the '<em><b>Model Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__MODEL_TYPE = BINDING__MODEL_TYPE;

	/**
	 * The feature id for the '<em><b>UI Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__UI_TYPE = BINDING__UI_TYPE;

	/**
	 * The feature id for the '<em><b>DB Bindings</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__DB_BINDINGS = BINDING__DB_BINDINGS;

	/**
	 * The feature id for the '<em><b>Monitored DB Bindings</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__MONITORED_DB_BINDINGS = BINDING__MONITORED_DB_BINDINGS;

	/**
	 * The feature id for the '<em><b>Error Conditions</b></em>' attribute list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__ERROR_CONDITIONS = BINDING__ERROR_CONDITIONS;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__WIDGET = BINDING__WIDGET;

	/**
	 * The feature id for the '<em><b>Control</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__CONTROL = BINDING__CONTROL;

	/**
	 * The feature id for the '<em><b>Extra Argument Providers</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__EXTRA_ARGUMENT_PROVIDERS = BINDING__EXTRA_ARGUMENT_PROVIDERS;

	/**
	 * The feature id for the '<em><b>Model Observable</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__MODEL_OBSERVABLE = BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model Observable Value</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__MODEL_OBSERVABLE_VALUE = BINDING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model Object</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__MODEL_OBJECT = BINDING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Model Feature</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__MODEL_FEATURE = BINDING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Message Prefix</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__MESSAGE_PREFIX = BINDING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Decorator Provider</b></em>' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__DECORATOR_PROVIDER = BINDING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__DECORATOR = BINDING_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>UI Attribute</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__UI_ATTRIBUTE = BINDING_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>UI Observable</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__UI_OBSERVABLE = BINDING_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Cell</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING__CELL = BINDING_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Value Binding</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING_FEATURE_COUNT = BINDING_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.IValueBindingCell
	 * <em>Value Binding Cell</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.IValueBindingCell
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getValueBindingCell()
	 * @generated
	 */
	int VALUE_BINDING_CELL = 5;

	/**
	 * The number of structural features of the '<em>Value Binding Cell</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_BINDING_CELL_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.ColumnBindingImpl
	 * <em>Column Binding</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.ColumnBindingImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getColumnBinding()
	 * @generated
	 */
	int COLUMN_BINDING = 6;

	/**
	 * The feature id for the '<em><b>Services</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__SERVICES = BINDING__SERVICES;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__CONTEXT = BINDING__CONTEXT;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__STATE = BINDING__STATE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__CHANGEABLE = BINDING__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Creation Point</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__CREATION_POINT = BINDING__CREATION_POINT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__ID = BINDING__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__TYPE = BINDING__TYPE;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__LABEL = BINDING__LABEL;

	/**
	 * The feature id for the '<em><b>Static Data Type</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__STATIC_DATA_TYPE = BINDING__STATIC_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__DATA_TYPE = BINDING__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Model EType</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__MODEL_ETYPE = BINDING__MODEL_ETYPE;

	/**
	 * The feature id for the '<em><b>Model Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__MODEL_TYPE = BINDING__MODEL_TYPE;

	/**
	 * The feature id for the '<em><b>UI Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__UI_TYPE = BINDING__UI_TYPE;

	/**
	 * The feature id for the '<em><b>DB Bindings</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__DB_BINDINGS = BINDING__DB_BINDINGS;

	/**
	 * The feature id for the '<em><b>Monitored DB Bindings</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__MONITORED_DB_BINDINGS = BINDING__MONITORED_DB_BINDINGS;

	/**
	 * The feature id for the '<em><b>Error Conditions</b></em>' attribute list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__ERROR_CONDITIONS = BINDING__ERROR_CONDITIONS;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__WIDGET = BINDING__WIDGET;

	/**
	 * The feature id for the '<em><b>Control</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__CONTROL = BINDING__CONTROL;

	/**
	 * The feature id for the '<em><b>Extra Argument Providers</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__EXTRA_ARGUMENT_PROVIDERS = BINDING__EXTRA_ARGUMENT_PROVIDERS;

	/**
	 * The feature id for the '<em><b>Viewer Binding</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__VIEWER_BINDING = BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Viewer Column</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__VIEWER_COLUMN = BINDING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Column Adapter</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__COLUMN_ADAPTER = BINDING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Column</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__BASE_COLUMN = BINDING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sub Columns</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__SUB_COLUMNS = BINDING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Cells</b></em>' map. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__CELLS = BINDING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Special Binding Type</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__SPECIAL_BINDING_TYPE = BINDING_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Factory</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__FACTORY = BINDING_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Cursor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__CURSOR = BINDING_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Column Visibility</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING__COLUMN_VISIBILITY = BINDING_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Column Binding</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING_FEATURE_COUNT = BINDING_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.ViewerBindingImpl
	 * <em>Viewer Binding</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.ViewerBindingImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getViewerBinding()
	 * @generated
	 */
	int VIEWER_BINDING = 9;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.DecoratorProviderImpl
	 * <em>Decorator Provider</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.DecoratorProviderImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getDecoratorProvider()
	 * @generated
	 */
	int DECORATOR_PROVIDER = 10;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.JavaDecoratorProviderImpl
	 * <em>Java Decorator Provider</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.JavaDecoratorProviderImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getJavaDecoratorProvider()
	 * @generated
	 */
	int JAVA_DECORATOR_PROVIDER = 11;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.EnumDecoratorProviderImpl
	 * <em>Enum Decorator Provider</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.EnumDecoratorProviderImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getEnumDecoratorProvider()
	 * @generated
	 */
	int ENUM_DECORATOR_PROVIDER = 12;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.NumberDecoratorProviderImpl
	 * <em>Number Decorator Provider</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.NumberDecoratorProviderImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getNumberDecoratorProvider()
	 * @generated
	 */
	int NUMBER_DECORATOR_PROVIDER = 14;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.BindingDataTypeImpl
	 * <em>Binding Data Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.BindingDataTypeImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getBindingDataType()
	 * @generated
	 */
	int BINDING_DATA_TYPE = 15;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.ColumnAdapterImpl
	 * <em>Column Adapter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.ColumnAdapterImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getColumnAdapter()
	 * @generated
	 */
	int COLUMN_ADAPTER = 16;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.ModelInfoImpl
	 * <em>Model Info</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.ModelInfoImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getModelInfo()
	 * @generated
	 */
	int MODEL_INFO = 17;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.ModelClassInfoImpl
	 * <em>Model Class Info</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.ModelClassInfoImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getModelClassInfo()
	 * @generated
	 */
	int MODEL_CLASS_INFO = 18;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.ModelFeatureInfoImpl
	 * <em>Model Feature Info</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.ModelFeatureInfoImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getModelFeatureInfo()
	 * @generated
	 */
	int MODEL_FEATURE_INFO = 19;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.UIBindingDecoratorImpl
	 * <em>UI Binding Decorator</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.UIBindingDecoratorImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUIBindingDecorator()
	 * @generated
	 */
	int UI_BINDING_DECORATOR = 20;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.IDisposable
	 * <em>IDisposable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.IDisposable
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIDisposable()
	 * @generated
	 */
	int IDISPOSABLE = 24;

	/**
	 * The number of structural features of the '<em>IDisposable</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IDISPOSABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.ColumnBindingCellInformationImpl
	 * <em>Column Binding Cell Information</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.ColumnBindingCellInformationImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getColumnBindingCellInformation()
	 * @generated
	 */
	int COLUMN_BINDING_CELL_INFORMATION = 7;

	/**
	 * The feature id for the '<em><b>Column</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING_CELL_INFORMATION__COLUMN = IDISPOSABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING_CELL_INFORMATION__ELEMENT = IDISPOSABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Label Binding</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING_CELL_INFORMATION__LABEL_BINDING = IDISPOSABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Label UI Attribute</b></em>' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE = IDISPOSABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Label Painter</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING_CELL_INFORMATION__LABEL_PAINTER = IDISPOSABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Object Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING_CELL_INFORMATION__OBJECT_VALUE = IDISPOSABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Source Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING_CELL_INFORMATION__SOURCE_VALUE = IDISPOSABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING_CELL_INFORMATION__CHANGEABLE = IDISPOSABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Display Text</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING_CELL_INFORMATION__DISPLAY_TEXT = IDISPOSABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING_CELL_INFORMATION__VALUE_TYPE = IDISPOSABLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Tool Tip Text</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING_CELL_INFORMATION__TOOL_TIP_TEXT = IDISPOSABLE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING_CELL_INFORMATION__ENABLED = IDISPOSABLE_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Column Binding Cell Information</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_BINDING_CELL_INFORMATION_FEATURE_COUNT = IDISPOSABLE_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.ContainerBindingImpl
	 * <em>Container Binding</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.ContainerBindingImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getContainerBinding()
	 * @generated
	 */
	int CONTAINER_BINDING = 8;

	/**
	 * The feature id for the '<em><b>Services</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__SERVICES = BINDING__SERVICES;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__CONTEXT = BINDING__CONTEXT;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__STATE = BINDING__STATE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__CHANGEABLE = BINDING__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Creation Point</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__CREATION_POINT = BINDING__CREATION_POINT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__ID = BINDING__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__TYPE = BINDING__TYPE;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__LABEL = BINDING__LABEL;

	/**
	 * The feature id for the '<em><b>Static Data Type</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__STATIC_DATA_TYPE = BINDING__STATIC_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__DATA_TYPE = BINDING__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Model EType</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__MODEL_ETYPE = BINDING__MODEL_ETYPE;

	/**
	 * The feature id for the '<em><b>Model Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__MODEL_TYPE = BINDING__MODEL_TYPE;

	/**
	 * The feature id for the '<em><b>UI Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__UI_TYPE = BINDING__UI_TYPE;

	/**
	 * The feature id for the '<em><b>DB Bindings</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__DB_BINDINGS = BINDING__DB_BINDINGS;

	/**
	 * The feature id for the '<em><b>Monitored DB Bindings</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__MONITORED_DB_BINDINGS = BINDING__MONITORED_DB_BINDINGS;

	/**
	 * The feature id for the '<em><b>Error Conditions</b></em>' attribute list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__ERROR_CONDITIONS = BINDING__ERROR_CONDITIONS;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__WIDGET = BINDING__WIDGET;

	/**
	 * The feature id for the '<em><b>Control</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__CONTROL = BINDING__CONTROL;

	/**
	 * The feature id for the '<em><b>Extra Argument Providers</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING__EXTRA_ARGUMENT_PROVIDERS = BINDING__EXTRA_ARGUMENT_PROVIDERS;

	/**
	 * The number of structural features of the '<em>Container Binding</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_BINDING_FEATURE_COUNT = BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Services</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__SERVICES = CONTAINER_BINDING__SERVICES;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__CONTEXT = CONTAINER_BINDING__CONTEXT;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__STATE = CONTAINER_BINDING__STATE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__CHANGEABLE = CONTAINER_BINDING__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Creation Point</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__CREATION_POINT = CONTAINER_BINDING__CREATION_POINT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__ID = CONTAINER_BINDING__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__TYPE = CONTAINER_BINDING__TYPE;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__LABEL = CONTAINER_BINDING__LABEL;

	/**
	 * The feature id for the '<em><b>Static Data Type</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__STATIC_DATA_TYPE = CONTAINER_BINDING__STATIC_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__DATA_TYPE = CONTAINER_BINDING__DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Model EType</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__MODEL_ETYPE = CONTAINER_BINDING__MODEL_ETYPE;

	/**
	 * The feature id for the '<em><b>Model Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__MODEL_TYPE = CONTAINER_BINDING__MODEL_TYPE;

	/**
	 * The feature id for the '<em><b>UI Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__UI_TYPE = CONTAINER_BINDING__UI_TYPE;

	/**
	 * The feature id for the '<em><b>DB Bindings</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__DB_BINDINGS = CONTAINER_BINDING__DB_BINDINGS;

	/**
	 * The feature id for the '<em><b>Monitored DB Bindings</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__MONITORED_DB_BINDINGS = CONTAINER_BINDING__MONITORED_DB_BINDINGS;

	/**
	 * The feature id for the '<em><b>Error Conditions</b></em>' attribute list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__ERROR_CONDITIONS = CONTAINER_BINDING__ERROR_CONDITIONS;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__WIDGET = CONTAINER_BINDING__WIDGET;

	/**
	 * The feature id for the '<em><b>Control</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__CONTROL = CONTAINER_BINDING__CONTROL;

	/**
	 * The feature id for the '<em><b>Extra Argument Providers</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__EXTRA_ARGUMENT_PROVIDERS = CONTAINER_BINDING__EXTRA_ARGUMENT_PROVIDERS;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__COLUMNS = CONTAINER_BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>List</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__LIST = CONTAINER_BINDING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__ELEMENTS = CONTAINER_BINDING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Single Selection</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__SINGLE_SELECTION = CONTAINER_BINDING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Multiple Selection</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__MULTIPLE_SELECTION = CONTAINER_BINDING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Viewer</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__VIEWER = CONTAINER_BINDING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>First Table Column Offset</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING__FIRST_TABLE_COLUMN_OFFSET = CONTAINER_BINDING_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Viewer Binding</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEWER_BINDING_FEATURE_COUNT = CONTAINER_BINDING_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.IArgumentProvider
	 * <em>IArgument Provider</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.IArgumentProvider
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIArgumentProvider()
	 * @generated
	 */
	int IARGUMENT_PROVIDER = 23;

	/**
	 * The number of structural features of the '<em>IArgument Provider</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IARGUMENT_PROVIDER_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Manager</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DECORATOR_PROVIDER__MANAGER = IARGUMENT_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DECORATOR_PROVIDER__ID = IARGUMENT_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DECORATOR_PROVIDER__TYPE = IARGUMENT_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Model Types</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DECORATOR_PROVIDER__MODEL_TYPES = IARGUMENT_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Ui Types</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DECORATOR_PROVIDER__UI_TYPES = IARGUMENT_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Provider CE</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DECORATOR_PROVIDER__PROVIDER_CE = IARGUMENT_PROVIDER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Child CE</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DECORATOR_PROVIDER__CHILD_CE = IARGUMENT_PROVIDER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DECORATOR_PROVIDER__DECORATOR = IARGUMENT_PROVIDER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Exact Model Type Match</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DECORATOR_PROVIDER__EXACT_MODEL_TYPE_MATCH = IARGUMENT_PROVIDER_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Decorator Provider</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DECORATOR_PROVIDER_FEATURE_COUNT = IARGUMENT_PROVIDER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Manager</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_DECORATOR_PROVIDER__MANAGER = DECORATOR_PROVIDER__MANAGER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_DECORATOR_PROVIDER__ID = DECORATOR_PROVIDER__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_DECORATOR_PROVIDER__TYPE = DECORATOR_PROVIDER__TYPE;

	/**
	 * The feature id for the '<em><b>Model Types</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_DECORATOR_PROVIDER__MODEL_TYPES = DECORATOR_PROVIDER__MODEL_TYPES;

	/**
	 * The feature id for the '<em><b>Ui Types</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_DECORATOR_PROVIDER__UI_TYPES = DECORATOR_PROVIDER__UI_TYPES;

	/**
	 * The feature id for the '<em><b>Provider CE</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_DECORATOR_PROVIDER__PROVIDER_CE = DECORATOR_PROVIDER__PROVIDER_CE;

	/**
	 * The feature id for the '<em><b>Child CE</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_DECORATOR_PROVIDER__CHILD_CE = DECORATOR_PROVIDER__CHILD_CE;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_DECORATOR_PROVIDER__DECORATOR = DECORATOR_PROVIDER__DECORATOR;

	/**
	 * The feature id for the '<em><b>Exact Model Type Match</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_DECORATOR_PROVIDER__EXACT_MODEL_TYPE_MATCH = DECORATOR_PROVIDER__EXACT_MODEL_TYPE_MATCH;

	/**
	 * The number of structural features of the '<em>Java Decorator Provider</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int JAVA_DECORATOR_PROVIDER_FEATURE_COUNT = DECORATOR_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Manager</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_DECORATOR_PROVIDER__MANAGER = DECORATOR_PROVIDER__MANAGER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_DECORATOR_PROVIDER__ID = DECORATOR_PROVIDER__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_DECORATOR_PROVIDER__TYPE = DECORATOR_PROVIDER__TYPE;

	/**
	 * The feature id for the '<em><b>Model Types</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_DECORATOR_PROVIDER__MODEL_TYPES = DECORATOR_PROVIDER__MODEL_TYPES;

	/**
	 * The feature id for the '<em><b>Ui Types</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_DECORATOR_PROVIDER__UI_TYPES = DECORATOR_PROVIDER__UI_TYPES;

	/**
	 * The feature id for the '<em><b>Provider CE</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_DECORATOR_PROVIDER__PROVIDER_CE = DECORATOR_PROVIDER__PROVIDER_CE;

	/**
	 * The feature id for the '<em><b>Child CE</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_DECORATOR_PROVIDER__CHILD_CE = DECORATOR_PROVIDER__CHILD_CE;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_DECORATOR_PROVIDER__DECORATOR = DECORATOR_PROVIDER__DECORATOR;

	/**
	 * The feature id for the '<em><b>Exact Model Type Match</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_DECORATOR_PROVIDER__EXACT_MODEL_TYPE_MATCH = DECORATOR_PROVIDER__EXACT_MODEL_TYPE_MATCH;

	/**
	 * The feature id for the '<em><b>Adding Default Mappings</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_DECORATOR_PROVIDER__ADDING_DEFAULT_MAPPINGS = DECORATOR_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Mappings</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_DECORATOR_PROVIDER__BASE_MAPPINGS = DECORATOR_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enum Decorator Provider</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_DECORATOR_PROVIDER_FEATURE_COUNT = DECORATOR_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.EnumDecoratorProviderEntryImpl
	 * <em>Enum Decorator Provider Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.EnumDecoratorProviderEntryImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getEnumDecoratorProviderEntry()
	 * @generated
	 */
	int ENUM_DECORATOR_PROVIDER_ENTRY = 13;

	/**
	 * The feature id for the '<em><b>Model</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_DECORATOR_PROVIDER_ENTRY__MODEL = 0;

	/**
	 * The feature id for the '<em><b>Ui</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_DECORATOR_PROVIDER_ENTRY__UI = 1;

	/**
	 * The number of structural features of the '<em>Enum Decorator Provider Entry</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_DECORATOR_PROVIDER_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Manager</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMBER_DECORATOR_PROVIDER__MANAGER = DECORATOR_PROVIDER__MANAGER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMBER_DECORATOR_PROVIDER__ID = DECORATOR_PROVIDER__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMBER_DECORATOR_PROVIDER__TYPE = DECORATOR_PROVIDER__TYPE;

	/**
	 * The feature id for the '<em><b>Model Types</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMBER_DECORATOR_PROVIDER__MODEL_TYPES = DECORATOR_PROVIDER__MODEL_TYPES;

	/**
	 * The feature id for the '<em><b>Ui Types</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMBER_DECORATOR_PROVIDER__UI_TYPES = DECORATOR_PROVIDER__UI_TYPES;

	/**
	 * The feature id for the '<em><b>Provider CE</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMBER_DECORATOR_PROVIDER__PROVIDER_CE = DECORATOR_PROVIDER__PROVIDER_CE;

	/**
	 * The feature id for the '<em><b>Child CE</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMBER_DECORATOR_PROVIDER__CHILD_CE = DECORATOR_PROVIDER__CHILD_CE;

	/**
	 * The feature id for the '<em><b>Decorator</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMBER_DECORATOR_PROVIDER__DECORATOR = DECORATOR_PROVIDER__DECORATOR;

	/**
	 * The feature id for the '<em><b>Exact Model Type Match</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMBER_DECORATOR_PROVIDER__EXACT_MODEL_TYPE_MATCH = DECORATOR_PROVIDER__EXACT_MODEL_TYPE_MATCH;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMBER_DECORATOR_PROVIDER__FORMAT = DECORATOR_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Number Decorator Provider</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMBER_DECORATOR_PROVIDER_FEATURE_COUNT = DECORATOR_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_DATA_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_DATA_TYPE__VALUE_TYPE = 1;

	/**
	 * The feature id for the '<em><b>EType</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_DATA_TYPE__ETYPE = 2;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_DATA_TYPE__DATA_TYPE = 3;

	/**
	 * The feature id for the '<em><b>EAnnotation</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_DATA_TYPE__EANNOTATION = 4;

	/**
	 * The feature id for the '<em><b>Parent Data Type</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_DATA_TYPE__PARENT_DATA_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_DATA_TYPE__REQUIRED = 6;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_DATA_TYPE__CHANGEABLE = 7;

	/**
	 * The feature id for the '<em><b>Unsettable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_DATA_TYPE__UNSETTABLE = 8;

	/**
	 * The number of structural features of the '<em>Binding Data Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_DATA_TYPE_FEATURE_COUNT = 9;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_ADAPTER__WIDGET = 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_ADAPTER__TEXT = 1;

	/**
	 * The feature id for the '<em><b>Alignment</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_ADAPTER__ALIGNMENT = 2;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_ADAPTER__IMAGE = 3;

	/**
	 * The feature id for the '<em><b>Moveable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_ADAPTER__MOVEABLE = 4;

	/**
	 * The feature id for the '<em><b>Resizable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_ADAPTER__RESIZABLE = 5;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_ADAPTER__WIDTH = 6;

	/**
	 * The feature id for the '<em><b>Tool Tip Text</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_ADAPTER__TOOL_TIP_TEXT = 7;

	/**
	 * The number of structural features of the '<em>Column Adapter</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_ADAPTER_FEATURE_COUNT = 8;

	/**
	 * The number of structural features of the '<em>Model Info</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_INFO_FEATURE_COUNT = IARGUMENT_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_CLASS_INFO__CLASS_NAME = MODEL_INFO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Features</b></em>' map. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_CLASS_INFO__FEATURES = MODEL_INFO_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Types</b></em>' map. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_CLASS_INFO__TYPES = MODEL_INFO_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Model Class Info</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_CLASS_INFO_FEATURE_COUNT = MODEL_INFO_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_INFO__FEATURE_NAME = MODEL_INFO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_INFO__CLASS = MODEL_INFO_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model Feature Info</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_INFO_FEATURE_COUNT = MODEL_INFO_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_BINDING_DECORATOR__BINDING = IDISPOSABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_BINDING_DECORATOR__CHANGEABLE = IDISPOSABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model To UI Converter</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_BINDING_DECORATOR__MODEL_TO_UI_CONVERTER = IDISPOSABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>UI To Model Converter</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_BINDING_DECORATOR__UI_TO_MODEL_CONVERTER = IDISPOSABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>UI To Model After Convert Validator</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_BINDING_DECORATOR__UI_TO_MODEL_AFTER_CONVERT_VALIDATOR = IDISPOSABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Valid UI List</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_BINDING_DECORATOR__VALID_UI_LIST = IDISPOSABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>UI Binding Decorator</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_BINDING_DECORATOR_FEATURE_COUNT = IDISPOSABLE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.UIBindingDecoratorExtenderImpl
	 * <em>UI Binding Decorator Extender</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.UIBindingDecoratorExtenderImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUIBindingDecoratorExtender()
	 * @generated
	 */
	int UI_BINDING_DECORATOR_EXTENDER = 21;

	/**
	 * The number of structural features of the '<em>UI Binding Decorator Extender</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_BINDING_DECORATOR_EXTENDER_FEATURE_COUNT = IDISPOSABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.UIBindingDecoratorExtenderDescriptorImpl
	 * <em>UI Binding Decorator Extender Descriptor</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.UIBindingDecoratorExtenderDescriptorImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUIBindingDecoratorExtenderDescriptor()
	 * @generated
	 */
	int UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR = 22;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__PRIORITY = IARGUMENT_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Factory</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__FACTORY = IARGUMENT_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>UI Binding Decorator Extender Descriptor</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR_FEATURE_COUNT = IARGUMENT_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.IModelArgumentMediator
	 * <em>IModel Argument Mediator</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.IModelArgumentMediator
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIModelArgumentMediator()
	 * @generated
	 */
	int IMODEL_ARGUMENT_MEDIATOR = 25;

	/**
	 * The number of structural features of the '<em>IModel Argument Mediator</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMODEL_ARGUMENT_MEDIATOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.IPersistentPartyImpl
	 * <em>IPersistent Party</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.IPersistentPartyImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIPersistentParty()
	 * @generated
	 */
	int IPERSISTENT_PARTY = 26;

	/**
	 * The number of structural features of the '<em>IPersistent Party</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IPERSISTENT_PARTY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.Constants <em>Constants</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.Constants
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getConstants()
	 * @generated
	 */
	int CONSTANTS = 27;

	/**
	 * The number of structural features of the '<em>Constants</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTANTS_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.StringToModelClassInfoMapEntryImpl
	 * <em>String To Model Class Info Map Entry</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.StringToModelClassInfoMapEntryImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getStringToModelClassInfoMapEntry()
	 * @generated
	 */
	int STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY = 28;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Model Class Info Map Entry</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.StringToModelFeatureInfoMapEntryImpl
	 * <em>String To Model Feature Info Map Entry</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.StringToModelFeatureInfoMapEntryImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getStringToModelFeatureInfoMapEntry()
	 * @generated
	 */
	int STRING_TO_MODEL_FEATURE_INFO_MAP_ENTRY = 29;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_MODEL_FEATURE_INFO_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_MODEL_FEATURE_INFO_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Model Feature Info Map Entry</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_MODEL_FEATURE_INFO_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.StringToStringMapEntryImpl
	 * <em>String To String Map Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.StringToStringMapEntryImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getStringToStringMapEntry()
	 * @generated
	 */
	int STRING_TO_STRING_MAP_ENTRY = 30;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STRING_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STRING_MAP_ENTRY__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' map. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STRING_MAP_ENTRY__ARGUMENTS = 2;

	/**
	 * The number of structural features of the '<em>String To String Map Entry</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STRING_MAP_ENTRY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.StringToObjectMapEntryImpl
	 * <em>String To Object Map Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.StringToObjectMapEntryImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getStringToObjectMapEntry()
	 * @generated
	 */
	int STRING_TO_OBJECT_MAP_ENTRY = 31;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_OBJECT_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_OBJECT_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Object Map Entry</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_OBJECT_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.StringToImageDescriptorMapEntryImpl
	 * <em>String To Image Descriptor Map Entry</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.StringToImageDescriptorMapEntryImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getStringToImageDescriptorMapEntry()
	 * @generated
	 */
	int STRING_TO_IMAGE_DESCRIPTOR_MAP_ENTRY = 32;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_IMAGE_DESCRIPTOR_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_IMAGE_DESCRIPTOR_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Image Descriptor Map Entry</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_IMAGE_DESCRIPTOR_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.StringToIConfigurationElementMapEntryImpl
	 * <em>String To IConfiguration Element Map Entry</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.StringToIConfigurationElementMapEntryImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getStringToIConfigurationElementMapEntry()
	 * @generated
	 */
	int STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY = 33;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To IConfiguration Element Map Entry</em>
	 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.StringToBooleanMapEntryImpl
	 * <em>String To Boolean Map Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.StringToBooleanMapEntryImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getStringToBooleanMapEntry()
	 * @generated
	 */
	int STRING_TO_BOOLEAN_MAP_ENTRY = 34;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_BOOLEAN_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_BOOLEAN_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Boolean Map Entry</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TO_BOOLEAN_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.ObjectToCIMapEntryImpl
	 * <em>Object To CI Map Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.ObjectToCIMapEntryImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getObjectToCIMapEntry()
	 * @generated
	 */
	int OBJECT_TO_CI_MAP_ENTRY = 35;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TO_CI_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TO_CI_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Object To CI Map Entry</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TO_CI_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.jface.fieldassist.IContentProposal
	 * <em>IContent Proposal</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.jface.fieldassist.IContentProposal
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIContentProposal()
	 * @generated
	 */
	int ICONTENT_PROPOSAL = 52;

	/**
	 * The number of structural features of the '<em>IContent Proposal</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ICONTENT_PROPOSAL_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.QuickfixProposalImpl
	 * <em>Quickfix Proposal</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.QuickfixProposalImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getQuickfixProposal()
	 * @generated
	 */
	int QUICKFIX_PROPOSAL = 37;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL__LABEL = ICONTENT_PROPOSAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL__DESCRIPTION = ICONTENT_PROPOSAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL__IMAGE = ICONTENT_PROPOSAL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Relevance</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL__RELEVANCE = ICONTENT_PROPOSAL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Quickfix Proposal</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL_FEATURE_COUNT = ICONTENT_PROPOSAL_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.QuickfixProposalProcessorImpl
	 * <em>Quickfix Proposal Processor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.QuickfixProposalProcessorImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getQuickfixProposalProcessor()
	 * @generated
	 */
	int QUICKFIX_PROPOSAL_PROCESSOR = 38;

	/**
	 * The number of structural features of the '<em>Quickfix Proposal Processor</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL_PROCESSOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.QuickfixProposalProcessorContextImpl
	 * <em>Quickfix Proposal Processor Context</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.QuickfixProposalProcessorContextImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getQuickfixProposalProcessorContext()
	 * @generated
	 */
	int QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT = 39;

	/**
	 * The feature id for the '<em><b>Message</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT__MESSAGE = 0;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT__BINDING = 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT__TEXT = 2;

	/**
	 * The number of structural features of the '<em>Quickfix Proposal Processor Context</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.QuickfixProposalProcessorDescriptorImpl
	 * <em>Quickfix Proposal Processor Descriptor</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.QuickfixProposalProcessorDescriptorImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getQuickfixProposalProcessorDescriptor()
	 * @generated
	 */
	int QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR = 40;

	/**
	 * The feature id for the '<em><b>Model Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__MODEL_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__SOURCE = 2;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__CODE = 3;

	/**
	 * The feature id for the '<em><b>Message Pattern</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__MESSAGE_PATTERN = 4;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__PROCESSOR = 5;

	/**
	 * The number of structural features of the '<em>Quickfix Proposal Processor Descriptor</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.TreeItemRelationImpl
	 * <em>Tree Item Relation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.TreeItemRelationImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getTreeItemRelation()
	 * @generated
	 */
	int TREE_ITEM_RELATION = 41;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_RELATION__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_RELATION__DESCRIPTOR = 1;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_RELATION__PROCESSOR = 2;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_RELATION__FEATURE_NAME = 3;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_RELATION__PRIORITY = 4;

	/**
	 * The feature id for the '<em><b>Tree IDs</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_RELATION__TREE_IDS = 5;

	/**
	 * The number of structural features of the '<em>Tree Item Relation</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_RELATION_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.TreeItemDescriptorImpl
	 * <em>Tree Item Descriptor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.TreeItemDescriptorImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getTreeItemDescriptor()
	 * @generated
	 */
	int TREE_ITEM_DESCRIPTOR = 42;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_DESCRIPTOR__ID = IARGUMENT_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Child Relations</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_DESCRIPTOR__CHILD_RELATIONS = IARGUMENT_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ce</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_DESCRIPTOR__CE = IARGUMENT_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Model Types</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_DESCRIPTOR__MODEL_TYPES = IARGUMENT_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>New Wizard ID</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_DESCRIPTOR__NEW_WIZARD_ID = IARGUMENT_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Parent Relations</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_DESCRIPTOR__PARENT_RELATIONS = IARGUMENT_PROVIDER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Primary Parent</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_DESCRIPTOR__PRIMARY_PARENT = IARGUMENT_PROVIDER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Empty Folder Hidden</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_DESCRIPTOR__EMPTY_FOLDER_HIDDEN = IARGUMENT_PROVIDER_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Tree Item Descriptor</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_DESCRIPTOR_FEATURE_COUNT = IARGUMENT_PROVIDER_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.ConstantTreeItemImpl
	 * <em>Constant Tree Item</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.ConstantTreeItemImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getConstantTreeItem()
	 * @generated
	 */
	int CONSTANT_TREE_ITEM = 43;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTANT_TREE_ITEM__DESCRIPTOR = IARGUMENT_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTANT_TREE_ITEM__TARGET = IARGUMENT_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Constant Tree Item</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTANT_TREE_ITEM_FEATURE_COUNT = IARGUMENT_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ui.forms.IMessage <em>IMessage</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.ui.forms.IMessage
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIMessage()
	 * @generated
	 */
	int IMESSAGE = 51;

	/**
	 * The number of structural features of the '<em>IMessage</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMESSAGE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.BindingMessageImpl
	 * <em>Binding Message</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.BindingMessageImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getBindingMessage()
	 * @generated
	 */
	int BINDING_MESSAGE = 44;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_MESSAGE__BINDING = IMESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_MESSAGE__MESSAGE = IMESSAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_MESSAGE__SEVERITY = IMESSAGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Message Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_MESSAGE__MESSAGE_TYPE = IMESSAGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_MESSAGE__PREFIX = IMESSAGE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_MESSAGE__TARGETS = IMESSAGE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_MESSAGE__DATA = IMESSAGE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_MESSAGE__SOURCE = IMESSAGE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_MESSAGE__CODE = IMESSAGE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Details</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_MESSAGE__DETAILS = IMESSAGE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Binding Message</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_MESSAGE_FEATURE_COUNT = IMESSAGE_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.BindingMessageTargetImpl
	 * <em>Binding Message Target</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.BindingMessageTargetImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getBindingMessageTarget()
	 * @generated
	 */
	int BINDING_MESSAGE_TARGET = 45;

	/**
	 * The feature id for the '<em><b>Model Object</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_MESSAGE_TARGET__MODEL_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Model Feature</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_MESSAGE_TARGET__MODEL_FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Model Key</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_MESSAGE_TARGET__MODEL_KEY = 2;

	/**
	 * The number of structural features of the '<em>Binding Message Target</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_MESSAGE_TARGET_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.internal.UIAttributeImpl
	 * <em>UI Attribute</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.UIAttributeImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUIAttribute()
	 * @generated
	 */
	int UI_ATTRIBUTE = 46;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__WIDGET = IDISPOSABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__ATTRIBUTE = IDISPOSABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Current Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__CURRENT_VALUE = IDISPOSABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Possible Values List</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__POSSIBLE_VALUES_LIST = IDISPOSABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Min Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__MIN_VALUE = IDISPOSABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Max Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__MAX_VALUE = IDISPOSABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Tooltip Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__TOOLTIP_VALUE = IDISPOSABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Font Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__FONT_VALUE = IDISPOSABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Image Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__IMAGE_VALUE = IDISPOSABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Foreground Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__FOREGROUND_VALUE = IDISPOSABLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Background Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__BACKGROUND_VALUE = IDISPOSABLE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Enabled Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__ENABLED_VALUE = IDISPOSABLE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Cursor Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__CURSOR_VALUE = IDISPOSABLE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Style Range List</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__STYLE_RANGE_LIST = IDISPOSABLE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__CHANGEABLE = IDISPOSABLE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Field Assist Adapter</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__FIELD_ASSIST_ADAPTER = IDISPOSABLE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Field Assist Control</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__FIELD_ASSIST_CONTROL = IDISPOSABLE_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Image Decorations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE__IMAGE_DECORATIONS = IDISPOSABLE_FEATURE_COUNT + 17;

	/**
	 * The number of structural features of the '<em>UI Attribute</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE_FEATURE_COUNT = IDISPOSABLE_FEATURE_COUNT + 18;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.UIAttributeImageDecorationImpl
	 * <em>UI Attribute Image Decoration</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.UIAttributeImageDecorationImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUIAttributeImageDecoration()
	 * @generated
	 */
	int UI_ATTRIBUTE_IMAGE_DECORATION = 47;

	/**
	 * The feature id for the '<em><b>Outside</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE_IMAGE_DECORATION__OUTSIDE = IDISPOSABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Image Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE_IMAGE_DECORATION__IMAGE_VALUE = IDISPOSABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tooltip Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE_IMAGE_DECORATION__TOOLTIP_VALUE = IDISPOSABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE_IMAGE_DECORATION__POSITION = IDISPOSABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE_IMAGE_DECORATION__ATTRIBUTE = IDISPOSABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>UI Attribute Image Decoration</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE_IMAGE_DECORATION_FEATURE_COUNT = IDISPOSABLE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.IUIAttributeFactory
	 * <em>UI Attribute Factory</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.IUIAttributeFactory
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUIAttributeFactory()
	 * @generated
	 */
	int UI_ATTRIBUTE_FACTORY = 48;

	/**
	 * The number of structural features of the '<em>UI Attribute Factory</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE_FACTORY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.UIAttributeFactoryDescriptorImpl
	 * <em>UI Attribute Factory Descriptor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.UIAttributeFactoryDescriptorImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUIAttributeFactoryDescriptor()
	 * @generated
	 */
	int UI_ATTRIBUTE_FACTORY_DESCRIPTOR = 49;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE_FACTORY_DESCRIPTOR__TYPE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE_FACTORY_DESCRIPTOR__ATTRIBUTE = 1;

	/**
	 * The feature id for the '<em><b>Factory</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE_FACTORY_DESCRIPTOR__FACTORY = 2;

	/**
	 * The number of structural features of the '<em>UI Attribute Factory Descriptor</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UI_ATTRIBUTE_FACTORY_DESCRIPTOR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.internal.EMFObservableFactoryDescriptorImpl
	 * <em>EMF Observable Factory Descriptor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see com.rcpcompany.uibindings.internal.EMFObservableFactoryDescriptorImpl
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getEMFObservableFactoryDescriptor()
	 * @generated
	 */
	int EMF_OBSERVABLE_FACTORY_DESCRIPTOR = 50;

	/**
	 * The feature id for the '<em><b>Package Prefix</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMF_OBSERVABLE_FACTORY_DESCRIPTOR__PACKAGE_PREFIX = 0;

	/**
	 * The feature id for the '<em><b>Factory</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMF_OBSERVABLE_FACTORY_DESCRIPTOR__FACTORY = 1;

	/**
	 * The number of structural features of the '<em>EMF Observable Factory Descriptor</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMF_OBSERVABLE_FACTORY_DESCRIPTOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.BindingState
	 * <em>Binding State</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.BindingState
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getBindingState()
	 * @generated
	 */
	int BINDING_STATE = 53;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.DecorationPosition
	 * <em>Decoration Position</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.DecorationPosition
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getDecorationPosition()
	 * @generated
	 */
	int DECORATION_POSITION = 54;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.TextCommitStrategy
	 * <em>Text Commit Strategy</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.TextCommitStrategy
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getTextCommitStrategy()
	 * @generated
	 */
	int TEXT_COMMIT_STRATEGY = 55;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.SpecialBinding
	 * <em>Special Binding</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.SpecialBinding
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getSpecialBinding()
	 * @generated
	 */
	int SPECIAL_BINDING = 56;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.BindingMessageSeverity
	 * <em>Binding Message Severity</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.BindingMessageSeverity
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getBindingMessageSeverity()
	 * @generated
	 */
	int BINDING_MESSAGE_SEVERITY = 57;

	/**
	 * The meta object id for the '<em>IBinding Context Finalizer</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.IBindingContextFinalizer
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIBindingContextFinalizer()
	 * @generated
	 */
	int IBINDING_CONTEXT_FINALIZER = 58;

	/**
	 * The meta object id for the '<em>UI Attribute Painter</em>' data type. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.uiAttributes.UIAttributePainter
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUIAttributePainter()
	 * @generated
	 */
	int UI_ATTRIBUTE_PAINTER = 59;

	/**
	 * The meta object id for the '<em>IEMF Observable Factory</em>' data type. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.IEMFObservableFactory
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIEMFObservableFactory()
	 * @generated
	 */
	int IEMF_OBSERVABLE_FACTORY = 60;

	/**
	 * The meta object id for the '<em>CE Object Holder</em>' data type. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.utils.extensionpoints.CEObjectHolder
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getCEObjectHolder()
	 * @generated
	 */
	int CE_OBJECT_HOLDER = 61;

	/**
	 * The meta object id for the '<em>CE Resource Holder</em>' data type. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.utils.extensionpoints.CEResourceHolder
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getCEResourceHolder()
	 * @generated
	 */
	int CE_RESOURCE_HOLDER = 62;

	/**
	 * The meta object id for the '<em>IFormatter Provider</em>' data type. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.IFormatterProvider
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIFormatterProvider()
	 * @generated
	 */
	int IFORMATTER_PROVIDER = 63;

	/**
	 * The meta object id for the '<em>DB Context</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.core.databinding.DataBindingContext
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getDBContext()
	 * @generated
	 */
	int DB_CONTEXT = 64;

	/**
	 * The meta object id for the '<em>DB Binding</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.core.databinding.Binding
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getDBBinding()
	 * @generated
	 */
	int DB_BINDING = 65;

	/**
	 * The meta object id for the '<em>Column Viewer</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.jface.viewers.ColumnViewer
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getColumnViewer()
	 * @generated
	 */
	int COLUMN_VIEWER = 66;

	/**
	 * The meta object id for the '<em>Viewer Column</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.jface.viewers.ViewerColumn
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getViewerColumn()
	 * @generated
	 */
	int VIEWER_COLUMN = 67;

	/**
	 * The meta object id for the '<em>Image Descriptor</em>' data type. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.jface.resource.ImageDescriptor
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getImageDescriptor()
	 * @generated
	 */
	int IMAGE_DESCRIPTOR = 68;

	/**
	 * The meta object id for the '<em>IControl Content Adapter</em>' data type. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.jface.fieldassist.IControlContentAdapter
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIControlContentAdapter()
	 * @generated
	 */
	int ICONTROL_CONTENT_ADAPTER = 69;

	/**
	 * The meta object id for the '<em>IService Locator</em>' data type. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.ui.services.IServiceLocator
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIServiceLocator()
	 * @generated
	 */
	int ISERVICE_LOCATOR = 70;

	/**
	 * The meta object id for the '<em>IConfiguration Element</em>' data type. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.core.runtime.IConfigurationElement
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIConfigurationElement()
	 * @generated
	 */
	int ICONFIGURATION_ELEMENT = 71;

	/**
	 * The meta object id for the '<em>Pattern</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see java.util.regex.Pattern
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 72;

	/**
	 * The meta object id for the '<em>Throwable</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see java.lang.Throwable
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getThrowable()
	 * @generated
	 */
	int THROWABLE = 73;

	/**
	 * The meta object id for the '<em>IObservable</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.core.databinding.observable.IObservable
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIObservable()
	 * @generated
	 */
	int IOBSERVABLE = 74;

	/**
	 * The meta object id for the '<em>IObservable Value</em>' data type. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.core.databinding.observable.value.IObservableValue
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIObservableValue()
	 * @generated
	 */
	int IOBSERVABLE_VALUE = 75;

	/**
	 * The meta object id for the '<em>IObservable List</em>' data type. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.core.databinding.observable.list.IObservableList
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIObservableList()
	 * @generated
	 */
	int IOBSERVABLE_LIST = 76;

	/**
	 * The meta object id for the '<em>IObservable Set</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.core.databinding.observable.set.IObservableSet
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIObservableSet()
	 * @generated
	 */
	int IOBSERVABLE_SET = 77;

	/**
	 * The meta object id for the '<em>IObservable Factory</em>' data type. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.core.databinding.observable.masterdetail.IObservableFactory
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIObservableFactory()
	 * @generated
	 */
	int IOBSERVABLE_FACTORY = 78;

	/**
	 * The meta object id for the '<em>ISWT Observable Value</em>' data type. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.jface.databinding.swt.ISWTObservableValue
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getISWTObservableValue()
	 * @generated
	 */
	int ISWT_OBSERVABLE_VALUE = 79;

	/**
	 * The meta object id for the '<em>IConverter</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIConverter()
	 * @generated
	 */
	int ICONVERTER = 80;

	/**
	 * The meta object id for the '<em>IValidator</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.core.databinding.validation.IValidator
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIValidator()
	 * @generated
	 */
	int IVALIDATOR = 81;

	/**
	 * The meta object id for the '<em>Editing Domain</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.emf.edit.domain.EditingDomain
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getEditingDomain()
	 * @generated
	 */
	int EDITING_DOMAIN = 82;

	/**
	 * The meta object id for the '<em>Widget</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.swt.widgets.Widget
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getWidget()
	 * @generated
	 */
	int WIDGET = 83;

	/**
	 * The meta object id for the '<em>Form Toolkit</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.ui.forms.widgets.FormToolkit
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getFormToolkit()
	 * @generated
	 */
	int FORM_TOOLKIT = 84;

	/**
	 * The meta object id for the '<em>Control</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.swt.widgets.Control
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getControl()
	 * @generated
	 */
	int CONTROL = 85;

	/**
	 * The meta object id for the '<em>Composite</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.swt.widgets.Composite
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getComposite()
	 * @generated
	 */
	int COMPOSITE = 86;

	/**
	 * The meta object id for the '<em>Table</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.swt.widgets.Table
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 87;

	/**
	 * The meta object id for the '<em>Table Column</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.swt.widgets.TableColumn
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getTableColumn()
	 * @generated
	 */
	int TABLE_COLUMN = 88;

	/**
	 * The meta object id for the '<em>Tree</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.swt.widgets.Tree
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getTree()
	 * @generated
	 */
	int TREE = 89;

	/**
	 * The meta object id for the '<em>Tree Column</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.swt.widgets.TreeColumn
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getTreeColumn()
	 * @generated
	 */
	int TREE_COLUMN = 90;

	/**
	 * The meta object id for the '<em>Clipboard</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.swt.dnd.Clipboard
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getClipboard()
	 * @generated
	 */
	int CLIPBOARD = 91;

	/**
	 * The meta object id for the '<em>Image</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.swt.graphics.Image
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 92;

	/**
	 * The meta object id for the '<em>Color</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.swt.graphics.Color
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getColor()
	 * @generated
	 */
	int COLOR = 93;

	/**
	 * The meta object id for the '<em>Cursor</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.swt.graphics.Cursor
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getCursor()
	 * @generated
	 */
	int CURSOR = 94;

	/**
	 * The meta object id for the '<em>Selection Listener</em>' data type. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.swt.events.SelectionListener
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getSelectionListener()
	 * @generated
	 */
	int SELECTION_LISTENER = 95;

	/**
	 * The meta object id for the '<em>Update Value Strategy</em>' data type. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.core.databinding.UpdateValueStrategy
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUpdateValueStrategy()
	 * @generated
	 */
	int UPDATE_VALUE_STRATEGY = 96;

	/**
	 * The meta object id for the '<em>Update List Strategy</em>' data type. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.core.databinding.UpdateListStrategy
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUpdateListStrategy()
	 * @generated
	 */
	int UPDATE_LIST_STRATEGY = 97;

	/**
	 * The meta object id for the '<em>Update Set Strategy</em>' data type. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.core.databinding.UpdateSetStrategy
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUpdateSetStrategy()
	 * @generated
	 */
	int UPDATE_SET_STRATEGY = 98;

	/**
	 * The meta object id for the '<em>Number Format</em>' data type. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see com.ibm.icu.text.NumberFormat
	 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getNumberFormat()
	 * @generated
	 */
	int NUMBER_FORMAT = 99;

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IBaseObject
	 * <em>Base Object</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Base Object</em>'.
	 * @see com.rcpcompany.uibindings.IBaseObject
	 * @generated
	 */
	EClass getBaseObject();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IManager
	 * <em>Manager</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Manager</em>'.
	 * @see com.rcpcompany.uibindings.IManager
	 * @generated
	 */
	EClass getManager();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.IManager#getProviders <em>Providers</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Providers</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getProviders()
	 * @see #getManager()
	 * @generated
	 */
	EReference getManager_Providers();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.IManager#getUiAttributeFactories
	 * <em>Ui Attribute Factories</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Ui Attribute Factories</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getUiAttributeFactories()
	 * @see #getManager()
	 * @generated
	 */
	EReference getManager_UiAttributeFactories();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.IManager#getDecoratorExtenders <em>Decorator Extenders</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Decorator Extenders</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getDecoratorExtenders()
	 * @see #getManager()
	 * @generated
	 */
	EReference getManager_DecoratorExtenders();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link com.rcpcompany.uibindings.IManager#getModelArgumentMediators
	 * <em>Model Argument Mediators</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Model Argument Mediators</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getModelArgumentMediators()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_ModelArgumentMediators();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#getModelArgumentMediatorClasses
	 * <em>Model Argument Mediator Classes</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Model Argument Mediator Classes</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getModelArgumentMediatorClasses()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_ModelArgumentMediatorClasses();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#getTextCommitStrategy
	 * <em>Text Commit Strategy</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Text Commit Strategy</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getTextCommitStrategy()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_TextCommitStrategy();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#getTextCommitStrategyDelay
	 * <em>Text Commit Strategy Delay</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Text Commit Strategy Delay</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getTextCommitStrategyDelay()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_TextCommitStrategyDelay();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#isEditCellAnyKey <em>Edit Cell Any Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Edit Cell Any Key</em>'.
	 * @see com.rcpcompany.uibindings.IManager#isEditCellAnyKey()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_EditCellAnyKey();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#isEditCellSingleClick
	 * <em>Edit Cell Single Click</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Edit Cell Single Click</em>'.
	 * @see com.rcpcompany.uibindings.IManager#isEditCellSingleClick()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_EditCellSingleClick();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#getMessageDecorationPosition
	 * <em>Message Decoration Position</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Message Decoration Position</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getMessageDecorationPosition()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_MessageDecorationPosition();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#getMessageDecorationMinimumSeverity
	 * <em>Message Decoration Minimum Severity</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Message Decoration Minimum Severity</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getMessageDecorationMinimumSeverity()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_MessageDecorationMinimumSeverity();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#getAlternativeDecorationPosition
	 * <em>Alternative Decoration Position</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Alternative Decoration Position</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getAlternativeDecorationPosition()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_AlternativeDecorationPosition();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#isAutoApplySingleQuickfix
	 * <em>Auto Apply Single Quickfix</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Auto Apply Single Quickfix</em>'.
	 * @see com.rcpcompany.uibindings.IManager#isAutoApplySingleQuickfix()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_AutoApplySingleQuickfix();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#isAlternateRowColors <em>Alternate Row Colors</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Alternate Row Colors</em>'.
	 * @see com.rcpcompany.uibindings.IManager#isAlternateRowColors()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_AlternateRowColors();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#isValidationErrorsAreFatal
	 * <em>Validation Errors Are Fatal</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Validation Errors Are Fatal</em>'.
	 * @see com.rcpcompany.uibindings.IManager#isValidationErrorsAreFatal()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_ValidationErrorsAreFatal();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#getValidationDelay <em>Validation Delay</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Validation Delay</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getValidationDelay()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_ValidationDelay();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#getValidationDelayWindow
	 * <em>Validation Delay Window</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Validation Delay Window</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getValidationDelayWindow()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_ValidationDelayWindow();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#isRequiredVBImageDecorationShown
	 * <em>Required VB Image Decoration Shown</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Required VB Image Decoration Shown</em>'.
	 * @see com.rcpcompany.uibindings.IManager#isRequiredVBImageDecorationShown()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_RequiredVBImageDecorationShown();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#isAssistVBImageDecorationShown
	 * <em>Assist VB Image Decoration Shown</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Assist VB Image Decoration Shown</em>'.
	 * @see com.rcpcompany.uibindings.IManager#isAssistVBImageDecorationShown()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_AssistVBImageDecorationShown();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#isQuickfixVBImageDecorationShown
	 * <em>Quickfix VB Image Decoration Shown</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Quickfix VB Image Decoration Shown</em>'.
	 * @see com.rcpcompany.uibindings.IManager#isQuickfixVBImageDecorationShown()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_QuickfixVBImageDecorationShown();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#isViewNavigationRecorded
	 * <em>View Navigation Recorded</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>View Navigation Recorded</em>'.
	 * @see com.rcpcompany.uibindings.IManager#isViewNavigationRecorded()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_ViewNavigationRecorded();

	/**
	 * Returns the meta object for the map '{@link com.rcpcompany.uibindings.IManager#getModelInfo
	 * <em>Model Info</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the map '<em>Model Info</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getModelInfo()
	 * @see #getManager()
	 * @generated
	 */
	EReference getManager_ModelInfo();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.IManager#getTreeItems <em>Tree Items</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Tree Items</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getTreeItems()
	 * @see #getManager()
	 * @generated
	 */
	EReference getManager_TreeItems();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#getClipboard <em>Clipboard</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Clipboard</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getClipboard()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_Clipboard();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.IManager#getObservableFactories
	 * <em>Observable Factories</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Observable Factories</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getObservableFactories()
	 * @see #getManager()
	 * @generated
	 */
	EReference getManager_ObservableFactories();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.IManager#getQuickfixProposalProcessors
	 * <em>Quickfix Proposal Processors</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Quickfix Proposal Processors</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getQuickfixProposalProcessors()
	 * @see #getManager()
	 * @generated
	 */
	EReference getManager_QuickfixProposalProcessors();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.IManager#getContexts <em>Contexts</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Contexts</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getContexts()
	 * @see #getManager()
	 * @generated
	 */
	EReference getManager_Contexts();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#getFormatterProvider <em>Formatter Provider</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Formatter Provider</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getFormatterProvider()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_FormatterProvider();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#getEditingDomain <em>Editing Domain</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Editing Domain</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getEditingDomain()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_EditingDomain();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IManager#getFormToolkit <em>Form Toolkit</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Form Toolkit</em>'.
	 * @see com.rcpcompany.uibindings.IManager#getFormToolkit()
	 * @see #getManager()
	 * @generated
	 */
	EAttribute getManager_FormToolkit();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IBindingContext
	 * <em>Binding Context</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Binding Context</em>'.
	 * @see com.rcpcompany.uibindings.IBindingContext
	 * @generated
	 */
	EClass getBindingContext();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.IBindingContext#getBindings <em>Bindings</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see com.rcpcompany.uibindings.IBindingContext#getBindings()
	 * @see #getBindingContext()
	 * @generated
	 */
	EReference getBindingContext_Bindings();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.IBindingContext#getOkBindings <em>Ok Bindings</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Ok Bindings</em>'.
	 * @see com.rcpcompany.uibindings.IBindingContext#getOkBindings()
	 * @see #getBindingContext()
	 * @generated
	 */
	EReference getBindingContext_OkBindings();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingContext#getTop <em>Top</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Top</em>'.
	 * @see com.rcpcompany.uibindings.IBindingContext#getTop()
	 * @see #getBindingContext()
	 * @generated
	 */
	EAttribute getBindingContext_Top();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingContext#getDbContext <em>Db Context</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Db Context</em>'.
	 * @see com.rcpcompany.uibindings.IBindingContext#getDbContext()
	 * @see #getBindingContext()
	 * @generated
	 */
	EAttribute getBindingContext_DbContext();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingContext#getServiceLocator <em>Service Locator</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Service Locator</em>'.
	 * @see com.rcpcompany.uibindings.IBindingContext#getServiceLocator()
	 * @see #getBindingContext()
	 * @generated
	 */
	EAttribute getBindingContext_ServiceLocator();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingContext#getState <em>State</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see com.rcpcompany.uibindings.IBindingContext#getState()
	 * @see #getBindingContext()
	 * @generated
	 */
	EAttribute getBindingContext_State();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingContext#getTextCommitStrategy
	 * <em>Text Commit Strategy</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Text Commit Strategy</em>'.
	 * @see com.rcpcompany.uibindings.IBindingContext#getTextCommitStrategy()
	 * @see #getBindingContext()
	 * @generated
	 */
	EAttribute getBindingContext_TextCommitStrategy();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingContext#getTextCommitStrategyCalculated
	 * <em>Text Commit Strategy Calculated</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Text Commit Strategy Calculated</em>'.
	 * @see com.rcpcompany.uibindings.IBindingContext#getTextCommitStrategyCalculated()
	 * @see #getBindingContext()
	 * @generated
	 */
	EAttribute getBindingContext_TextCommitStrategyCalculated();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingContext#getEditingDomain <em>Editing Domain</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Editing Domain</em>'.
	 * @see com.rcpcompany.uibindings.IBindingContext#getEditingDomain()
	 * @see #getBindingContext()
	 * @generated
	 */
	EAttribute getBindingContext_EditingDomain();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link com.rcpcompany.uibindings.IBindingContext#getFinalizers <em>Finalizers</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Finalizers</em>'.
	 * @see com.rcpcompany.uibindings.IBindingContext#getFinalizers()
	 * @see #getBindingContext()
	 * @generated
	 */
	EAttribute getBindingContext_Finalizers();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IBinding
	 * <em>Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see com.rcpcompany.uibindings.IBinding
	 * @generated
	 */
	EClass getBinding();

	/**
	 * Returns the meta object for the container reference '
	 * {@link com.rcpcompany.uibindings.IBinding#getContext <em>Context</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Context</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getContext()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_Context();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBinding#getState <em>State</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getState()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_State();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBinding#isChangeable <em>Changeable</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Changeable</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#isChangeable()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_Changeable();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBinding#getCreationPoint <em>Creation Point</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Creation Point</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getCreationPoint()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_CreationPoint();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibindings.IBinding#getId
	 * <em>Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getId()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.rcpcompany.uibindings.IBinding#getType
	 * <em>Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getType()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_Type();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBinding#getLabel <em>Label</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getLabel()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_Label();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IBinding#getStaticDataType <em>Static Data Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Static Data Type</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getStaticDataType()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_StaticDataType();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IBinding#getDataType <em>Data Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Data Type</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getDataType()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_DataType();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IBinding#getModelEType <em>Model EType</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Model EType</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getModelEType()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_ModelEType();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBinding#getModelType <em>Model Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Model Type</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getModelType()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_ModelType();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBinding#getUIType <em>UI Type</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>UI Type</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getUIType()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_UIType();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link com.rcpcompany.uibindings.IBinding#getDBBindings <em>DB Bindings</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>DB Bindings</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getDBBindings()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_DBBindings();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link com.rcpcompany.uibindings.IBinding#getMonitoredDBBindings
	 * <em>Monitored DB Bindings</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Monitored DB Bindings</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getMonitoredDBBindings()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_MonitoredDBBindings();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link com.rcpcompany.uibindings.IBinding#getErrorConditions <em>Error Conditions</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Error Conditions</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getErrorConditions()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_ErrorConditions();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBinding#getWidget <em>Widget</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Widget</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getWidget()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_Widget();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBinding#getControl <em>Control</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Control</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getControl()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_Control();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.IBinding#getExtraArgumentProviders
	 * <em>Extra Argument Providers</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Extra Argument Providers</em>'.
	 * @see com.rcpcompany.uibindings.IBinding#getExtraArgumentProviders()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_ExtraArgumentProviders();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IValueBinding
	 * <em>Value Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Value Binding</em>'.
	 * @see com.rcpcompany.uibindings.IValueBinding
	 * @generated
	 */
	EClass getValueBinding();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IValueBinding#getModelObservable <em>Model Observable</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Model Observable</em>'.
	 * @see com.rcpcompany.uibindings.IValueBinding#getModelObservable()
	 * @see #getValueBinding()
	 * @generated
	 */
	EAttribute getValueBinding_ModelObservable();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IValueBinding#getModelObservableValue
	 * <em>Model Observable Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Model Observable Value</em>'.
	 * @see com.rcpcompany.uibindings.IValueBinding#getModelObservableValue()
	 * @see #getValueBinding()
	 * @generated
	 */
	EAttribute getValueBinding_ModelObservableValue();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IValueBinding#getModelObject <em>Model Object</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Model Object</em>'.
	 * @see com.rcpcompany.uibindings.IValueBinding#getModelObject()
	 * @see #getValueBinding()
	 * @generated
	 */
	EReference getValueBinding_ModelObject();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IValueBinding#getModelFeature <em>Model Feature</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Model Feature</em>'.
	 * @see com.rcpcompany.uibindings.IValueBinding#getModelFeature()
	 * @see #getValueBinding()
	 * @generated
	 */
	EReference getValueBinding_ModelFeature();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IValueBinding#getMessagePrefix <em>Message Prefix</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Message Prefix</em>'.
	 * @see com.rcpcompany.uibindings.IValueBinding#getMessagePrefix()
	 * @see #getValueBinding()
	 * @generated
	 */
	EAttribute getValueBinding_MessagePrefix();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IValueBinding#getDecoratorProvider
	 * <em>Decorator Provider</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Decorator Provider</em>'.
	 * @see com.rcpcompany.uibindings.IValueBinding#getDecoratorProvider()
	 * @see #getValueBinding()
	 * @generated
	 */
	EReference getValueBinding_DecoratorProvider();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IValueBinding#getDecorator <em>Decorator</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Decorator</em>'.
	 * @see com.rcpcompany.uibindings.IValueBinding#getDecorator()
	 * @see #getValueBinding()
	 * @generated
	 */
	EReference getValueBinding_Decorator();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IValueBinding#getUIAttribute <em>UI Attribute</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>UI Attribute</em>'.
	 * @see com.rcpcompany.uibindings.IValueBinding#getUIAttribute()
	 * @see #getValueBinding()
	 * @generated
	 */
	EReference getValueBinding_UIAttribute();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IValueBinding#getUIObservable <em>UI Observable</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>UI Observable</em>'.
	 * @see com.rcpcompany.uibindings.IValueBinding#getUIObservable()
	 * @see #getValueBinding()
	 * @generated
	 */
	EAttribute getValueBinding_UIObservable();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IValueBinding#getCell <em>Cell</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Cell</em>'.
	 * @see com.rcpcompany.uibindings.IValueBinding#getCell()
	 * @see #getValueBinding()
	 * @generated
	 */
	EReference getValueBinding_Cell();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IValueBindingCell
	 * <em>Value Binding Cell</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Value Binding Cell</em>'.
	 * @see com.rcpcompany.uibindings.IValueBindingCell
	 * @generated
	 */
	EClass getValueBindingCell();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IColumnBinding
	 * <em>Column Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Column Binding</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBinding
	 * @generated
	 */
	EClass getColumnBinding();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IColumnBinding#getViewerBinding <em>Viewer Binding</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Viewer Binding</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBinding#getViewerBinding()
	 * @see #getColumnBinding()
	 * @generated
	 */
	EReference getColumnBinding_ViewerBinding();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnBinding#getViewerColumn <em>Viewer Column</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Viewer Column</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBinding#getViewerColumn()
	 * @see #getColumnBinding()
	 * @generated
	 */
	EAttribute getColumnBinding_ViewerColumn();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IColumnBinding#getColumnAdapter <em>Column Adapter</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Column Adapter</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBinding#getColumnAdapter()
	 * @see #getColumnBinding()
	 * @generated
	 */
	EReference getColumnBinding_ColumnAdapter();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IColumnBinding#getBaseColumn <em>Base Column</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Column</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBinding#getBaseColumn()
	 * @see #getColumnBinding()
	 * @generated
	 */
	EReference getColumnBinding_BaseColumn();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.IColumnBinding#getSubColumns <em>Sub Columns</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Sub Columns</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBinding#getSubColumns()
	 * @see #getColumnBinding()
	 * @generated
	 */
	EReference getColumnBinding_SubColumns();

	/**
	 * Returns the meta object for the map '
	 * {@link com.rcpcompany.uibindings.IColumnBinding#getCells <em>Cells</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the map '<em>Cells</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBinding#getCells()
	 * @see #getColumnBinding()
	 * @generated
	 */
	EReference getColumnBinding_Cells();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnBinding#getSpecialBindingType
	 * <em>Special Binding Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Special Binding Type</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBinding#getSpecialBindingType()
	 * @see #getColumnBinding()
	 * @generated
	 */
	EAttribute getColumnBinding_SpecialBindingType();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnBinding#getFactory <em>Factory</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Factory</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBinding#getFactory()
	 * @see #getColumnBinding()
	 * @generated
	 */
	EAttribute getColumnBinding_Factory();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnBinding#getCursor <em>Cursor</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Cursor</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBinding#getCursor()
	 * @see #getColumnBinding()
	 * @generated
	 */
	EAttribute getColumnBinding_Cursor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnBinding#getColumnVisibility
	 * <em>Column Visibility</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Column Visibility</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBinding#getColumnVisibility()
	 * @see #getColumnBinding()
	 * @generated
	 */
	EAttribute getColumnBinding_ColumnVisibility();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation
	 * <em>Column Binding Cell Information</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Column Binding Cell Information</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBindingCellInformation
	 * @generated
	 */
	EClass getColumnBindingCellInformation();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Column</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBindingCellInformation#getColumn()
	 * @see #getColumnBindingCellInformation()
	 * @generated
	 */
	EReference getColumnBindingCellInformation_Column();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBindingCellInformation#getElement()
	 * @see #getColumnBindingCellInformation()
	 * @generated
	 */
	EReference getColumnBindingCellInformation_Element();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getLabelBinding
	 * <em>Label Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Label Binding</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBindingCellInformation#getLabelBinding()
	 * @see #getColumnBindingCellInformation()
	 * @generated
	 */
	EReference getColumnBindingCellInformation_LabelBinding();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getLabelUIAttribute
	 * <em>Label UI Attribute</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Label UI Attribute</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBindingCellInformation#getLabelUIAttribute()
	 * @see #getColumnBindingCellInformation()
	 * @generated
	 */
	EReference getColumnBindingCellInformation_LabelUIAttribute();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getLabelPainter
	 * <em>Label Painter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Label Painter</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBindingCellInformation#getLabelPainter()
	 * @see #getColumnBindingCellInformation()
	 * @generated
	 */
	EAttribute getColumnBindingCellInformation_LabelPainter();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getObjectValue
	 * <em>Object Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Object Value</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBindingCellInformation#getObjectValue()
	 * @see #getColumnBindingCellInformation()
	 * @generated
	 */
	EAttribute getColumnBindingCellInformation_ObjectValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getSourceValue
	 * <em>Source Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Source Value</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBindingCellInformation#getSourceValue()
	 * @see #getColumnBindingCellInformation()
	 * @generated
	 */
	EAttribute getColumnBindingCellInformation_SourceValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation#isChangeable
	 * <em>Changeable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Changeable</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBindingCellInformation#isChangeable()
	 * @see #getColumnBindingCellInformation()
	 * @generated
	 */
	EAttribute getColumnBindingCellInformation_Changeable();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getDisplayText
	 * <em>Display Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Display Text</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBindingCellInformation#getDisplayText()
	 * @see #getColumnBindingCellInformation()
	 * @generated
	 */
	EAttribute getColumnBindingCellInformation_DisplayText();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getValueType
	 * <em>Value Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value Type</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBindingCellInformation#getValueType()
	 * @see #getColumnBindingCellInformation()
	 * @generated
	 */
	EAttribute getColumnBindingCellInformation_ValueType();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation#getToolTipText
	 * <em>Tool Tip Text</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Tool Tip Text</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBindingCellInformation#getToolTipText()
	 * @see #getColumnBindingCellInformation()
	 * @generated
	 */
	EAttribute getColumnBindingCellInformation_ToolTipText();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnBindingCellInformation#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see com.rcpcompany.uibindings.IColumnBindingCellInformation#isEnabled()
	 * @see #getColumnBindingCellInformation()
	 * @generated
	 */
	EAttribute getColumnBindingCellInformation_Enabled();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IContainerBinding
	 * <em>Container Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Container Binding</em>'.
	 * @see com.rcpcompany.uibindings.IContainerBinding
	 * @generated
	 */
	EClass getContainerBinding();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IViewerBinding
	 * <em>Viewer Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Viewer Binding</em>'.
	 * @see com.rcpcompany.uibindings.IViewerBinding
	 * @generated
	 */
	EClass getViewerBinding();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.IViewerBinding#getColumns <em>Columns</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Columns</em>'.
	 * @see com.rcpcompany.uibindings.IViewerBinding#getColumns()
	 * @see #getViewerBinding()
	 * @generated
	 */
	EReference getViewerBinding_Columns();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IViewerBinding#getList <em>List</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>List</em>'.
	 * @see com.rcpcompany.uibindings.IViewerBinding#getList()
	 * @see #getViewerBinding()
	 * @generated
	 */
	EAttribute getViewerBinding_List();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IViewerBinding#getElements <em>Elements</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Elements</em>'.
	 * @see com.rcpcompany.uibindings.IViewerBinding#getElements()
	 * @see #getViewerBinding()
	 * @generated
	 */
	EAttribute getViewerBinding_Elements();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IViewerBinding#getSingleSelection <em>Single Selection</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Single Selection</em>'.
	 * @see com.rcpcompany.uibindings.IViewerBinding#getSingleSelection()
	 * @see #getViewerBinding()
	 * @generated
	 */
	EAttribute getViewerBinding_SingleSelection();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IViewerBinding#getMultipleSelection
	 * <em>Multiple Selection</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Multiple Selection</em>'.
	 * @see com.rcpcompany.uibindings.IViewerBinding#getMultipleSelection()
	 * @see #getViewerBinding()
	 * @generated
	 */
	EAttribute getViewerBinding_MultipleSelection();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IViewerBinding#getViewer <em>Viewer</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Viewer</em>'.
	 * @see com.rcpcompany.uibindings.IViewerBinding#getViewer()
	 * @see #getViewerBinding()
	 * @generated
	 */
	EAttribute getViewerBinding_Viewer();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IViewerBinding#getFirstTableColumnOffset
	 * <em>First Table Column Offset</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>First Table Column Offset</em>'.
	 * @see com.rcpcompany.uibindings.IViewerBinding#getFirstTableColumnOffset()
	 * @see #getViewerBinding()
	 * @generated
	 */
	EAttribute getViewerBinding_FirstTableColumnOffset();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IDecoratorProvider
	 * <em>Decorator Provider</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Decorator Provider</em>'.
	 * @see com.rcpcompany.uibindings.IDecoratorProvider
	 * @generated
	 */
	EClass getDecoratorProvider();

	/**
	 * Returns the meta object for the container reference '
	 * {@link com.rcpcompany.uibindings.IDecoratorProvider#getManager <em>Manager</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Manager</em>'.
	 * @see com.rcpcompany.uibindings.IDecoratorProvider#getManager()
	 * @see #getDecoratorProvider()
	 * @generated
	 */
	EReference getDecoratorProvider_Manager();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IDecoratorProvider#getId <em>Id</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.rcpcompany.uibindings.IDecoratorProvider#getId()
	 * @see #getDecoratorProvider()
	 * @generated
	 */
	EAttribute getDecoratorProvider_Id();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IDecoratorProvider#getType <em>Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.rcpcompany.uibindings.IDecoratorProvider#getType()
	 * @see #getDecoratorProvider()
	 * @generated
	 */
	EAttribute getDecoratorProvider_Type();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link com.rcpcompany.uibindings.IDecoratorProvider#getModelTypes <em>Model Types</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Model Types</em>'.
	 * @see com.rcpcompany.uibindings.IDecoratorProvider#getModelTypes()
	 * @see #getDecoratorProvider()
	 * @generated
	 */
	EAttribute getDecoratorProvider_ModelTypes();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link com.rcpcompany.uibindings.IDecoratorProvider#getUiTypes <em>Ui Types</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Ui Types</em>'.
	 * @see com.rcpcompany.uibindings.IDecoratorProvider#getUiTypes()
	 * @see #getDecoratorProvider()
	 * @generated
	 */
	EAttribute getDecoratorProvider_UiTypes();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IDecoratorProvider#getProviderCE <em>Provider CE</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Provider CE</em>'.
	 * @see com.rcpcompany.uibindings.IDecoratorProvider#getProviderCE()
	 * @see #getDecoratorProvider()
	 * @generated
	 */
	EAttribute getDecoratorProvider_ProviderCE();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IDecoratorProvider#getChildCE <em>Child CE</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Child CE</em>'.
	 * @see com.rcpcompany.uibindings.IDecoratorProvider#getChildCE()
	 * @see #getDecoratorProvider()
	 * @generated
	 */
	EAttribute getDecoratorProvider_ChildCE();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IDecoratorProvider#getDecorator <em>Decorator</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Decorator</em>'.
	 * @see com.rcpcompany.uibindings.IDecoratorProvider#getDecorator()
	 * @see #getDecoratorProvider()
	 * @generated
	 */
	EReference getDecoratorProvider_Decorator();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IDecoratorProvider#isExactModelTypeMatch
	 * <em>Exact Model Type Match</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Exact Model Type Match</em>'.
	 * @see com.rcpcompany.uibindings.IDecoratorProvider#isExactModelTypeMatch()
	 * @see #getDecoratorProvider()
	 * @generated
	 */
	EAttribute getDecoratorProvider_ExactModelTypeMatch();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IJavaDecoratorProvider
	 * <em>Java Decorator Provider</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Java Decorator Provider</em>'.
	 * @see com.rcpcompany.uibindings.IJavaDecoratorProvider
	 * @generated
	 */
	EClass getJavaDecoratorProvider();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IEnumDecoratorProvider
	 * <em>Enum Decorator Provider</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Enum Decorator Provider</em>'.
	 * @see com.rcpcompany.uibindings.IEnumDecoratorProvider
	 * @generated
	 */
	EClass getEnumDecoratorProvider();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IEnumDecoratorProvider#isAddingDefaultMappings
	 * <em>Adding Default Mappings</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Adding Default Mappings</em>'.
	 * @see com.rcpcompany.uibindings.IEnumDecoratorProvider#isAddingDefaultMappings()
	 * @see #getEnumDecoratorProvider()
	 * @generated
	 */
	EAttribute getEnumDecoratorProvider_AddingDefaultMappings();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.IEnumDecoratorProvider#getBaseMappings
	 * <em>Base Mappings</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Base Mappings</em>'.
	 * @see com.rcpcompany.uibindings.IEnumDecoratorProvider#getBaseMappings()
	 * @see #getEnumDecoratorProvider()
	 * @generated
	 */
	EReference getEnumDecoratorProvider_BaseMappings();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.IEnumDecoratorProviderEntry
	 * <em>Enum Decorator Provider Entry</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Enum Decorator Provider Entry</em>'.
	 * @see com.rcpcompany.uibindings.IEnumDecoratorProviderEntry
	 * @generated
	 */
	EClass getEnumDecoratorProviderEntry();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IEnumDecoratorProviderEntry#getModel <em>Model</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Model</em>'.
	 * @see com.rcpcompany.uibindings.IEnumDecoratorProviderEntry#getModel()
	 * @see #getEnumDecoratorProviderEntry()
	 * @generated
	 */
	EAttribute getEnumDecoratorProviderEntry_Model();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IEnumDecoratorProviderEntry#getUi <em>Ui</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Ui</em>'.
	 * @see com.rcpcompany.uibindings.IEnumDecoratorProviderEntry#getUi()
	 * @see #getEnumDecoratorProviderEntry()
	 * @generated
	 */
	EAttribute getEnumDecoratorProviderEntry_Ui();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.INumberDecoratorProvider
	 * <em>Number Decorator Provider</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Number Decorator Provider</em>'.
	 * @see com.rcpcompany.uibindings.INumberDecoratorProvider
	 * @generated
	 */
	EClass getNumberDecoratorProvider();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.INumberDecoratorProvider#getFormat <em>Format</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see com.rcpcompany.uibindings.INumberDecoratorProvider#getFormat()
	 * @see #getNumberDecoratorProvider()
	 * @generated
	 */
	EAttribute getNumberDecoratorProvider_Format();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IBindingDataType
	 * <em>Binding Data Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Binding Data Type</em>'.
	 * @see com.rcpcompany.uibindings.IBindingDataType
	 * @generated
	 */
	EClass getBindingDataType();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingDataType#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.rcpcompany.uibindings.IBindingDataType#getName()
	 * @see #getBindingDataType()
	 * @generated
	 */
	EAttribute getBindingDataType_Name();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingDataType#getValueType <em>Value Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value Type</em>'.
	 * @see com.rcpcompany.uibindings.IBindingDataType#getValueType()
	 * @see #getBindingDataType()
	 * @generated
	 */
	EAttribute getBindingDataType_ValueType();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IBindingDataType#getEType <em>EType</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>EType</em>'.
	 * @see com.rcpcompany.uibindings.IBindingDataType#getEType()
	 * @see #getBindingDataType()
	 * @generated
	 */
	EReference getBindingDataType_EType();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingDataType#getDataType <em>Data Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see com.rcpcompany.uibindings.IBindingDataType#getDataType()
	 * @see #getBindingDataType()
	 * @generated
	 */
	EAttribute getBindingDataType_DataType();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IBindingDataType#getEAnnotation <em>EAnnotation</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>EAnnotation</em>'.
	 * @see com.rcpcompany.uibindings.IBindingDataType#getEAnnotation()
	 * @see #getBindingDataType()
	 * @generated
	 */
	EReference getBindingDataType_EAnnotation();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IBindingDataType#getParentDataType
	 * <em>Parent Data Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Parent Data Type</em>'.
	 * @see com.rcpcompany.uibindings.IBindingDataType#getParentDataType()
	 * @see #getBindingDataType()
	 * @generated
	 */
	EReference getBindingDataType_ParentDataType();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingDataType#isRequired <em>Required</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see com.rcpcompany.uibindings.IBindingDataType#isRequired()
	 * @see #getBindingDataType()
	 * @generated
	 */
	EAttribute getBindingDataType_Required();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingDataType#isChangeable <em>Changeable</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Changeable</em>'.
	 * @see com.rcpcompany.uibindings.IBindingDataType#isChangeable()
	 * @see #getBindingDataType()
	 * @generated
	 */
	EAttribute getBindingDataType_Changeable();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingDataType#isUnsettable <em>Unsettable</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Unsettable</em>'.
	 * @see com.rcpcompany.uibindings.IBindingDataType#isUnsettable()
	 * @see #getBindingDataType()
	 * @generated
	 */
	EAttribute getBindingDataType_Unsettable();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IColumnAdapter
	 * <em>Column Adapter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Column Adapter</em>'.
	 * @see com.rcpcompany.uibindings.IColumnAdapter
	 * @generated
	 */
	EClass getColumnAdapter();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnAdapter#getWidget <em>Widget</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Widget</em>'.
	 * @see com.rcpcompany.uibindings.IColumnAdapter#getWidget()
	 * @see #getColumnAdapter()
	 * @generated
	 */
	EAttribute getColumnAdapter_Widget();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnAdapter#getText <em>Text</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see com.rcpcompany.uibindings.IColumnAdapter#getText()
	 * @see #getColumnAdapter()
	 * @generated
	 */
	EAttribute getColumnAdapter_Text();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnAdapter#getAlignment <em>Alignment</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Alignment</em>'.
	 * @see com.rcpcompany.uibindings.IColumnAdapter#getAlignment()
	 * @see #getColumnAdapter()
	 * @generated
	 */
	EAttribute getColumnAdapter_Alignment();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnAdapter#getImage <em>Image</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see com.rcpcompany.uibindings.IColumnAdapter#getImage()
	 * @see #getColumnAdapter()
	 * @generated
	 */
	EAttribute getColumnAdapter_Image();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnAdapter#isMoveable <em>Moveable</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Moveable</em>'.
	 * @see com.rcpcompany.uibindings.IColumnAdapter#isMoveable()
	 * @see #getColumnAdapter()
	 * @generated
	 */
	EAttribute getColumnAdapter_Moveable();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnAdapter#isResizable <em>Resizable</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Resizable</em>'.
	 * @see com.rcpcompany.uibindings.IColumnAdapter#isResizable()
	 * @see #getColumnAdapter()
	 * @generated
	 */
	EAttribute getColumnAdapter_Resizable();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnAdapter#getWidth <em>Width</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see com.rcpcompany.uibindings.IColumnAdapter#getWidth()
	 * @see #getColumnAdapter()
	 * @generated
	 */
	EAttribute getColumnAdapter_Width();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IColumnAdapter#getToolTipText <em>Tool Tip Text</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Tool Tip Text</em>'.
	 * @see com.rcpcompany.uibindings.IColumnAdapter#getToolTipText()
	 * @see #getColumnAdapter()
	 * @generated
	 */
	EAttribute getColumnAdapter_ToolTipText();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IModelInfo
	 * <em>Model Info</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Model Info</em>'.
	 * @see com.rcpcompany.uibindings.IModelInfo
	 * @generated
	 */
	EClass getModelInfo();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IModelClassInfo
	 * <em>Model Class Info</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Model Class Info</em>'.
	 * @see com.rcpcompany.uibindings.IModelClassInfo
	 * @generated
	 */
	EClass getModelClassInfo();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IModelClassInfo#getClassName <em>Class Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see com.rcpcompany.uibindings.IModelClassInfo#getClassName()
	 * @see #getModelClassInfo()
	 * @generated
	 */
	EAttribute getModelClassInfo_ClassName();

	/**
	 * Returns the meta object for the map '
	 * {@link com.rcpcompany.uibindings.IModelClassInfo#getFeatures <em>Features</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the map '<em>Features</em>'.
	 * @see com.rcpcompany.uibindings.IModelClassInfo#getFeatures()
	 * @see #getModelClassInfo()
	 * @generated
	 */
	EReference getModelClassInfo_Features();

	/**
	 * Returns the meta object for the map '
	 * {@link com.rcpcompany.uibindings.IModelClassInfo#getTypes <em>Types</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the map '<em>Types</em>'.
	 * @see com.rcpcompany.uibindings.IModelClassInfo#getTypes()
	 * @see #getModelClassInfo()
	 * @generated
	 */
	EReference getModelClassInfo_Types();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IModelFeatureInfo
	 * <em>Model Feature Info</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Model Feature Info</em>'.
	 * @see com.rcpcompany.uibindings.IModelFeatureInfo
	 * @generated
	 */
	EClass getModelFeatureInfo();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IModelFeatureInfo#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see com.rcpcompany.uibindings.IModelFeatureInfo#getFeatureName()
	 * @see #getModelFeatureInfo()
	 * @generated
	 */
	EAttribute getModelFeatureInfo_FeatureName();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IModelFeatureInfo#getClass_ <em>Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see com.rcpcompany.uibindings.IModelFeatureInfo#getClass_()
	 * @see #getModelFeatureInfo()
	 * @generated
	 */
	EReference getModelFeatureInfo_Class();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IUIBindingDecorator
	 * <em>UI Binding Decorator</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>UI Binding Decorator</em>'.
	 * @see com.rcpcompany.uibindings.IUIBindingDecorator
	 * @generated
	 */
	EClass getUIBindingDecorator();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IUIBindingDecorator#getBinding <em>Binding</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Binding</em>'.
	 * @see com.rcpcompany.uibindings.IUIBindingDecorator#getBinding()
	 * @see #getUIBindingDecorator()
	 * @generated
	 */
	EReference getUIBindingDecorator_Binding();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIBindingDecorator#isChangeable <em>Changeable</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Changeable</em>'.
	 * @see com.rcpcompany.uibindings.IUIBindingDecorator#isChangeable()
	 * @see #getUIBindingDecorator()
	 * @generated
	 */
	EAttribute getUIBindingDecorator_Changeable();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIBindingDecorator#getModelToUIConverter
	 * <em>Model To UI Converter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Model To UI Converter</em>'.
	 * @see com.rcpcompany.uibindings.IUIBindingDecorator#getModelToUIConverter()
	 * @see #getUIBindingDecorator()
	 * @generated
	 */
	EAttribute getUIBindingDecorator_ModelToUIConverter();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIBindingDecorator#getUIToModelConverter
	 * <em>UI To Model Converter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>UI To Model Converter</em>'.
	 * @see com.rcpcompany.uibindings.IUIBindingDecorator#getUIToModelConverter()
	 * @see #getUIBindingDecorator()
	 * @generated
	 */
	EAttribute getUIBindingDecorator_UIToModelConverter();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIBindingDecorator#getUIToModelAfterConvertValidator
	 * <em>UI To Model After Convert Validator</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>UI To Model After Convert Validator</em>'.
	 * @see com.rcpcompany.uibindings.IUIBindingDecorator#getUIToModelAfterConvertValidator()
	 * @see #getUIBindingDecorator()
	 * @generated
	 */
	EAttribute getUIBindingDecorator_UIToModelAfterConvertValidator();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIBindingDecorator#getValidUIList <em>Valid UI List</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Valid UI List</em>'.
	 * @see com.rcpcompany.uibindings.IUIBindingDecorator#getValidUIList()
	 * @see #getUIBindingDecorator()
	 * @generated
	 */
	EAttribute getUIBindingDecorator_ValidUIList();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.IUIBindingDecoratorExtender
	 * <em>UI Binding Decorator Extender</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>UI Binding Decorator Extender</em>'.
	 * @see com.rcpcompany.uibindings.IUIBindingDecoratorExtender
	 * @generated
	 */
	EClass getUIBindingDecoratorExtender();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor
	 * <em>UI Binding Decorator Extender Descriptor</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>UI Binding Decorator Extender Descriptor</em>'.
	 * @see com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor
	 * @generated
	 */
	EClass getUIBindingDecoratorExtenderDescriptor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor#getPriority
	 * <em>Priority</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor#getPriority()
	 * @see #getUIBindingDecoratorExtenderDescriptor()
	 * @generated
	 */
	EAttribute getUIBindingDecoratorExtenderDescriptor_Priority();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor#getFactory
	 * <em>Factory</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Factory</em>'.
	 * @see com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor#getFactory()
	 * @see #getUIBindingDecoratorExtenderDescriptor()
	 * @generated
	 */
	EAttribute getUIBindingDecoratorExtenderDescriptor_Factory();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IArgumentProvider
	 * <em>IArgument Provider</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IArgument Provider</em>'.
	 * @see com.rcpcompany.uibindings.IArgumentProvider
	 * @generated
	 */
	EClass getIArgumentProvider();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IDisposable
	 * <em>IDisposable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IDisposable</em>'.
	 * @see com.rcpcompany.uibindings.IDisposable
	 * @generated
	 */
	EClass getIDisposable();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IModelArgumentMediator
	 * <em>IModel Argument Mediator</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IModel Argument Mediator</em>'.
	 * @see com.rcpcompany.uibindings.IModelArgumentMediator
	 * @generated
	 */
	EClass getIModelArgumentMediator();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.utils.IPersistentParty
	 * <em>IPersistent Party</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IPersistent Party</em>'.
	 * @see com.rcpcompany.uibindings.utils.IPersistentParty
	 * @generated
	 */
	EClass getIPersistentParty();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.Constants
	 * <em>Constants</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Constants</em>'.
	 * @see com.rcpcompany.uibindings.Constants
	 * @generated
	 */
	EClass getConstants();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry
	 * <em>String To Model Class Info Map Entry</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>String To Model Class Info Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	EClass getStringToModelClassInfoMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToModelClassInfoMapEntry()
	 * @generated
	 */
	EAttribute getStringToModelClassInfoMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToModelClassInfoMapEntry()
	 * @generated
	 */
	EReference getStringToModelClassInfoMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry
	 * <em>String To Model Feature Info Map Entry</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>String To Model Feature Info Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	EClass getStringToModelFeatureInfoMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToModelFeatureInfoMapEntry()
	 * @generated
	 */
	EAttribute getStringToModelFeatureInfoMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToModelFeatureInfoMapEntry()
	 * @generated
	 */
	EReference getStringToModelFeatureInfoMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry
	 * <em>String To String Map Entry</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>String To String Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	EClass getStringToStringMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToStringMapEntry()
	 * @generated
	 */
	EAttribute getStringToStringMapEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToStringMapEntry()
	 * @generated
	 */
	EAttribute getStringToStringMapEntry_Value();

	/**
	 * Returns the meta object for the map '{@link java.util.Map.Entry <em>Arguments</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the map '<em>Arguments</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToStringMapEntry()
	 * @generated
	 */
	EReference getStringToStringMapEntry_Arguments();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry
	 * <em>String To Object Map Entry</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>String To Object Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	EClass getStringToObjectMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToObjectMapEntry()
	 * @generated
	 */
	EAttribute getStringToObjectMapEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToObjectMapEntry()
	 * @generated
	 */
	EAttribute getStringToObjectMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry
	 * <em>String To Image Descriptor Map Entry</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>String To Image Descriptor Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	EClass getStringToImageDescriptorMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToImageDescriptorMapEntry()
	 * @generated
	 */
	EAttribute getStringToImageDescriptorMapEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToImageDescriptorMapEntry()
	 * @generated
	 */
	EAttribute getStringToImageDescriptorMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry
	 * <em>String To IConfiguration Element Map Entry</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>String To IConfiguration Element Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	EClass getStringToIConfigurationElementMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToIConfigurationElementMapEntry()
	 * @generated
	 */
	EAttribute getStringToIConfigurationElementMapEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToIConfigurationElementMapEntry()
	 * @generated
	 */
	EAttribute getStringToIConfigurationElementMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry
	 * <em>String To Boolean Map Entry</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>String To Boolean Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	EClass getStringToBooleanMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToBooleanMapEntry()
	 * @generated
	 */
	EAttribute getStringToBooleanMapEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToBooleanMapEntry()
	 * @generated
	 */
	EAttribute getStringToBooleanMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry
	 * <em>Object To CI Map Entry</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Object To CI Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	EClass getObjectToCIMapEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getObjectToCIMapEntry()
	 * @generated
	 */
	EReference getObjectToCIMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getObjectToCIMapEntry()
	 * @generated
	 */
	EReference getObjectToCIMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IServiceRegistry
	 * <em>Service Registry</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Service Registry</em>'.
	 * @see com.rcpcompany.uibindings.IServiceRegistry
	 * @generated
	 */
	EClass getServiceRegistry();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link com.rcpcompany.uibindings.IServiceRegistry#getServices <em>Services</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Services</em>'.
	 * @see com.rcpcompany.uibindings.IServiceRegistry#getServices()
	 * @see #getServiceRegistry()
	 * @generated
	 */
	EAttribute getServiceRegistry_Services();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IQuickfixProposal
	 * <em>Quickfix Proposal</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Quickfix Proposal</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposal
	 * @generated
	 */
	EClass getQuickfixProposal();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposal#getLabel <em>Label</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposal#getLabel()
	 * @see #getQuickfixProposal()
	 * @generated
	 */
	EAttribute getQuickfixProposal_Label();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposal#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposal#getDescription()
	 * @see #getQuickfixProposal()
	 * @generated
	 */
	EAttribute getQuickfixProposal_Description();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposal#getImage <em>Image</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposal#getImage()
	 * @see #getQuickfixProposal()
	 * @generated
	 */
	EAttribute getQuickfixProposal_Image();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposal#getRelevance <em>Relevance</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Relevance</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposal#getRelevance()
	 * @see #getQuickfixProposal()
	 * @generated
	 */
	EAttribute getQuickfixProposal_Relevance();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessor
	 * <em>Quickfix Proposal Processor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Quickfix Proposal Processor</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposalProcessor
	 * @generated
	 */
	EClass getQuickfixProposalProcessor();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorContext
	 * <em>Quickfix Proposal Processor Context</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Quickfix Proposal Processor Context</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposalProcessorContext
	 * @generated
	 */
	EClass getQuickfixProposalProcessorContext();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorContext#getMessage
	 * <em>Message</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Message</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposalProcessorContext#getMessage()
	 * @see #getQuickfixProposalProcessorContext()
	 * @generated
	 */
	EReference getQuickfixProposalProcessorContext_Message();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorContext#getBinding
	 * <em>Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Binding</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposalProcessorContext#getBinding()
	 * @see #getQuickfixProposalProcessorContext()
	 * @generated
	 */
	EReference getQuickfixProposalProcessorContext_Binding();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorContext#getText <em>Text</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposalProcessorContext#getText()
	 * @see #getQuickfixProposalProcessorContext()
	 * @generated
	 */
	EAttribute getQuickfixProposalProcessorContext_Text();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor
	 * <em>Quickfix Proposal Processor Descriptor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Quickfix Proposal Processor Descriptor</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor
	 * @generated
	 */
	EClass getQuickfixProposalProcessorDescriptor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getModelType
	 * <em>Model Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Model Type</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getModelType()
	 * @see #getQuickfixProposalProcessorDescriptor()
	 * @generated
	 */
	EAttribute getQuickfixProposalProcessorDescriptor_ModelType();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getFeature
	 * <em>Feature</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Feature</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getFeature()
	 * @see #getQuickfixProposalProcessorDescriptor()
	 * @generated
	 */
	EAttribute getQuickfixProposalProcessorDescriptor_Feature();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getSource
	 * <em>Source</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getSource()
	 * @see #getQuickfixProposalProcessorDescriptor()
	 * @generated
	 */
	EAttribute getQuickfixProposalProcessorDescriptor_Source();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getCode <em>Code</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getCode()
	 * @see #getQuickfixProposalProcessorDescriptor()
	 * @generated
	 */
	EAttribute getQuickfixProposalProcessorDescriptor_Code();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getMessagePattern
	 * <em>Message Pattern</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Message Pattern</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getMessagePattern()
	 * @see #getQuickfixProposalProcessorDescriptor()
	 * @generated
	 */
	EAttribute getQuickfixProposalProcessorDescriptor_MessagePattern();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getProcessor
	 * <em>Processor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Processor</em>'.
	 * @see com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getProcessor()
	 * @see #getQuickfixProposalProcessorDescriptor()
	 * @generated
	 */
	EAttribute getQuickfixProposalProcessorDescriptor_Processor();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.ITreeItemRelation
	 * <em>Tree Item Relation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Tree Item Relation</em>'.
	 * @see com.rcpcompany.uibindings.ITreeItemRelation
	 * @generated
	 */
	EClass getTreeItemRelation();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.ITreeItemRelation#getParent <em>Parent</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see com.rcpcompany.uibindings.ITreeItemRelation#getParent()
	 * @see #getTreeItemRelation()
	 * @generated
	 */
	EReference getTreeItemRelation_Parent();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.ITreeItemRelation#getDescriptor <em>Descriptor</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Descriptor</em>'.
	 * @see com.rcpcompany.uibindings.ITreeItemRelation#getDescriptor()
	 * @see #getTreeItemRelation()
	 * @generated
	 */
	EReference getTreeItemRelation_Descriptor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.ITreeItemRelation#getProcessor <em>Processor</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Processor</em>'.
	 * @see com.rcpcompany.uibindings.ITreeItemRelation#getProcessor()
	 * @see #getTreeItemRelation()
	 * @generated
	 */
	EAttribute getTreeItemRelation_Processor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.ITreeItemRelation#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see com.rcpcompany.uibindings.ITreeItemRelation#getFeatureName()
	 * @see #getTreeItemRelation()
	 * @generated
	 */
	EAttribute getTreeItemRelation_FeatureName();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.ITreeItemRelation#getPriority <em>Priority</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see com.rcpcompany.uibindings.ITreeItemRelation#getPriority()
	 * @see #getTreeItemRelation()
	 * @generated
	 */
	EAttribute getTreeItemRelation_Priority();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link com.rcpcompany.uibindings.ITreeItemRelation#getTreeIDs <em>Tree IDs</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Tree IDs</em>'.
	 * @see com.rcpcompany.uibindings.ITreeItemRelation#getTreeIDs()
	 * @see #getTreeItemRelation()
	 * @generated
	 */
	EAttribute getTreeItemRelation_TreeIDs();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.ITreeItemDescriptor
	 * <em>Tree Item Descriptor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Tree Item Descriptor</em>'.
	 * @see com.rcpcompany.uibindings.ITreeItemDescriptor
	 * @generated
	 */
	EClass getTreeItemDescriptor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.ITreeItemDescriptor#getId <em>Id</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.rcpcompany.uibindings.ITreeItemDescriptor#getId()
	 * @see #getTreeItemDescriptor()
	 * @generated
	 */
	EAttribute getTreeItemDescriptor_Id();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.ITreeItemDescriptor#getChildRelations
	 * <em>Child Relations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Child Relations</em>'.
	 * @see com.rcpcompany.uibindings.ITreeItemDescriptor#getChildRelations()
	 * @see #getTreeItemDescriptor()
	 * @generated
	 */
	EReference getTreeItemDescriptor_ChildRelations();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.ITreeItemDescriptor#getCe <em>Ce</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Ce</em>'.
	 * @see com.rcpcompany.uibindings.ITreeItemDescriptor#getCe()
	 * @see #getTreeItemDescriptor()
	 * @generated
	 */
	EAttribute getTreeItemDescriptor_Ce();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link com.rcpcompany.uibindings.ITreeItemDescriptor#getModelTypes <em>Model Types</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Model Types</em>'.
	 * @see com.rcpcompany.uibindings.ITreeItemDescriptor#getModelTypes()
	 * @see #getTreeItemDescriptor()
	 * @generated
	 */
	EAttribute getTreeItemDescriptor_ModelTypes();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.ITreeItemDescriptor#getNewWizardID <em>New Wizard ID</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>New Wizard ID</em>'.
	 * @see com.rcpcompany.uibindings.ITreeItemDescriptor#getNewWizardID()
	 * @see #getTreeItemDescriptor()
	 * @generated
	 */
	EAttribute getTreeItemDescriptor_NewWizardID();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.ITreeItemDescriptor#getParentRelations
	 * <em>Parent Relations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Parent Relations</em>'.
	 * @see com.rcpcompany.uibindings.ITreeItemDescriptor#getParentRelations()
	 * @see #getTreeItemDescriptor()
	 * @generated
	 */
	EReference getTreeItemDescriptor_ParentRelations();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.ITreeItemDescriptor#getPrimaryParent
	 * <em>Primary Parent</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Primary Parent</em>'.
	 * @see com.rcpcompany.uibindings.ITreeItemDescriptor#getPrimaryParent()
	 * @see #getTreeItemDescriptor()
	 * @generated
	 */
	EReference getTreeItemDescriptor_PrimaryParent();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.ITreeItemDescriptor#isEmptyFolderHidden
	 * <em>Empty Folder Hidden</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Empty Folder Hidden</em>'.
	 * @see com.rcpcompany.uibindings.ITreeItemDescriptor#isEmptyFolderHidden()
	 * @see #getTreeItemDescriptor()
	 * @generated
	 */
	EAttribute getTreeItemDescriptor_EmptyFolderHidden();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IConstantTreeItem
	 * <em>Constant Tree Item</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Constant Tree Item</em>'.
	 * @see com.rcpcompany.uibindings.IConstantTreeItem
	 * @generated
	 */
	EClass getConstantTreeItem();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IConstantTreeItem#getDescriptor <em>Descriptor</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Descriptor</em>'.
	 * @see com.rcpcompany.uibindings.IConstantTreeItem#getDescriptor()
	 * @see #getConstantTreeItem()
	 * @generated
	 */
	EReference getConstantTreeItem_Descriptor();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IConstantTreeItem#getTarget <em>Target</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.rcpcompany.uibindings.IConstantTreeItem#getTarget()
	 * @see #getConstantTreeItem()
	 * @generated
	 */
	EReference getConstantTreeItem_Target();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IBindingMessage
	 * <em>Binding Message</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Binding Message</em>'.
	 * @see com.rcpcompany.uibindings.IBindingMessage
	 * @generated
	 */
	EClass getBindingMessage();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IBindingMessage#getBinding <em>Binding</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Binding</em>'.
	 * @see com.rcpcompany.uibindings.IBindingMessage#getBinding()
	 * @see #getBindingMessage()
	 * @generated
	 */
	EReference getBindingMessage_Binding();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingMessage#getMessage <em>Message</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see com.rcpcompany.uibindings.IBindingMessage#getMessage()
	 * @see #getBindingMessage()
	 * @generated
	 */
	EAttribute getBindingMessage_Message();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingMessage#getMessageType <em>Message Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Message Type</em>'.
	 * @see com.rcpcompany.uibindings.IBindingMessage#getMessageType()
	 * @see #getBindingMessage()
	 * @generated
	 */
	EAttribute getBindingMessage_MessageType();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingMessage#getSeverity <em>Severity</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see com.rcpcompany.uibindings.IBindingMessage#getSeverity()
	 * @see #getBindingMessage()
	 * @generated
	 */
	EAttribute getBindingMessage_Severity();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingMessage#getPrefix <em>Prefix</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see com.rcpcompany.uibindings.IBindingMessage#getPrefix()
	 * @see #getBindingMessage()
	 * @generated
	 */
	EAttribute getBindingMessage_Prefix();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.IBindingMessage#getTargets <em>Targets</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Targets</em>'.
	 * @see com.rcpcompany.uibindings.IBindingMessage#getTargets()
	 * @see #getBindingMessage()
	 * @generated
	 */
	EReference getBindingMessage_Targets();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingMessage#getData <em>Data</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see com.rcpcompany.uibindings.IBindingMessage#getData()
	 * @see #getBindingMessage()
	 * @generated
	 */
	EAttribute getBindingMessage_Data();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingMessage#getSource <em>Source</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see com.rcpcompany.uibindings.IBindingMessage#getSource()
	 * @see #getBindingMessage()
	 * @generated
	 */
	EAttribute getBindingMessage_Source();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingMessage#getCode <em>Code</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see com.rcpcompany.uibindings.IBindingMessage#getCode()
	 * @see #getBindingMessage()
	 * @generated
	 */
	EAttribute getBindingMessage_Code();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingMessage#getDetails <em>Details</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Details</em>'.
	 * @see com.rcpcompany.uibindings.IBindingMessage#getDetails()
	 * @see #getBindingMessage()
	 * @generated
	 */
	EAttribute getBindingMessage_Details();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IBindingMessageTarget
	 * <em>Binding Message Target</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Binding Message Target</em>'.
	 * @see com.rcpcompany.uibindings.IBindingMessageTarget
	 * @generated
	 */
	EClass getBindingMessageTarget();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IBindingMessageTarget#getModelObject <em>Model Object</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Model Object</em>'.
	 * @see com.rcpcompany.uibindings.IBindingMessageTarget#getModelObject()
	 * @see #getBindingMessageTarget()
	 * @generated
	 */
	EReference getBindingMessageTarget_ModelObject();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.IBindingMessageTarget#getModelFeature
	 * <em>Model Feature</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Model Feature</em>'.
	 * @see com.rcpcompany.uibindings.IBindingMessageTarget#getModelFeature()
	 * @see #getBindingMessageTarget()
	 * @generated
	 */
	EReference getBindingMessageTarget_ModelFeature();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IBindingMessageTarget#getModelKey <em>Model Key</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Model Key</em>'.
	 * @see com.rcpcompany.uibindings.IBindingMessageTarget#getModelKey()
	 * @see #getBindingMessageTarget()
	 * @generated
	 */
	EAttribute getBindingMessageTarget_ModelKey();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IUIAttribute
	 * <em>UI Attribute</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>UI Attribute</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute
	 * @generated
	 */
	EClass getUIAttribute();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getWidget <em>Widget</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Widget</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getWidget()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_Widget();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getAttribute <em>Attribute</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Attribute</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getAttribute()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_Attribute();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getCurrentValue <em>Current Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Current Value</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getCurrentValue()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_CurrentValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getPossibleValuesList
	 * <em>Possible Values List</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Possible Values List</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getPossibleValuesList()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_PossibleValuesList();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getMinValue <em>Min Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Min Value</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getMinValue()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_MinValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getMaxValue <em>Max Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Max Value</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getMaxValue()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_MaxValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getTooltipValue <em>Tooltip Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Tooltip Value</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getTooltipValue()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_TooltipValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getFontValue <em>Font Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Font Value</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getFontValue()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_FontValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getImageValue <em>Image Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Image Value</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getImageValue()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_ImageValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getForegroundValue <em>Foreground Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Foreground Value</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getForegroundValue()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_ForegroundValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getBackgroundValue <em>Background Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Background Value</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getBackgroundValue()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_BackgroundValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getEnabledValue <em>Enabled Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Enabled Value</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getEnabledValue()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_EnabledValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getCursorValue <em>Cursor Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Cursor Value</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getCursorValue()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_CursorValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getStyleRangeList <em>Style Range List</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Style Range List</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getStyleRangeList()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_StyleRangeList();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#isChangeable <em>Changeable</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Changeable</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#isChangeable()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_Changeable();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getFieldAssistAdapter
	 * <em>Field Assist Adapter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Field Assist Adapter</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getFieldAssistAdapter()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_FieldAssistAdapter();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getFieldAssistControl
	 * <em>Field Assist Control</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Field Assist Control</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getFieldAssistControl()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EAttribute getUIAttribute_FieldAssistControl();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.IUIAttribute#getImageDecorations <em>Image Decorations</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Image Decorations</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttribute#getImageDecorations()
	 * @see #getUIAttribute()
	 * @generated
	 */
	EReference getUIAttribute_ImageDecorations();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.IUIAttributeImageDecoration
	 * <em>UI Attribute Image Decoration</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>UI Attribute Image Decoration</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttributeImageDecoration
	 * @generated
	 */
	EClass getUIAttributeImageDecoration();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttributeImageDecoration#isOutside <em>Outside</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Outside</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttributeImageDecoration#isOutside()
	 * @see #getUIAttributeImageDecoration()
	 * @generated
	 */
	EAttribute getUIAttributeImageDecoration_Outside();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttributeImageDecoration#getImageValue
	 * <em>Image Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Image Value</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttributeImageDecoration#getImageValue()
	 * @see #getUIAttributeImageDecoration()
	 * @generated
	 */
	EAttribute getUIAttributeImageDecoration_ImageValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttributeImageDecoration#getTooltipValue
	 * <em>Tooltip Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Tooltip Value</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttributeImageDecoration#getTooltipValue()
	 * @see #getUIAttributeImageDecoration()
	 * @generated
	 */
	EAttribute getUIAttributeImageDecoration_TooltipValue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttributeImageDecoration#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttributeImageDecoration#getPosition()
	 * @see #getUIAttributeImageDecoration()
	 * @generated
	 */
	EAttribute getUIAttributeImageDecoration_Position();

	/**
	 * Returns the meta object for the container reference '
	 * {@link com.rcpcompany.uibindings.IUIAttributeImageDecoration#getAttribute <em>Attribute</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Attribute</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttributeImageDecoration#getAttribute()
	 * @see #getUIAttributeImageDecoration()
	 * @generated
	 */
	EReference getUIAttributeImageDecoration_Attribute();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.IUIAttributeFactory
	 * <em>UI Attribute Factory</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>UI Attribute Factory</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttributeFactory
	 * @generated
	 */
	EClass getUIAttributeFactory();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor
	 * <em>UI Attribute Factory Descriptor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>UI Attribute Factory Descriptor</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor
	 * @generated
	 */
	EClass getUIAttributeFactoryDescriptor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor#getTypeName
	 * <em>Type Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor#getTypeName()
	 * @see #getUIAttributeFactoryDescriptor()
	 * @generated
	 */
	EAttribute getUIAttributeFactoryDescriptor_TypeName();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor#getAttribute
	 * <em>Attribute</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Attribute</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor#getAttribute()
	 * @see #getUIAttributeFactoryDescriptor()
	 * @generated
	 */
	EAttribute getUIAttributeFactoryDescriptor_Attribute();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor#getFactory <em>Factory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Factory</em>'.
	 * @see com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor#getFactory()
	 * @see #getUIAttributeFactoryDescriptor()
	 * @generated
	 */
	EAttribute getUIAttributeFactoryDescriptor_Factory();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.IEMFObservableFactoryDescriptor
	 * <em>EMF Observable Factory Descriptor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EMF Observable Factory Descriptor</em>'.
	 * @see com.rcpcompany.uibindings.IEMFObservableFactoryDescriptor
	 * @generated
	 */
	EClass getEMFObservableFactoryDescriptor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IEMFObservableFactoryDescriptor#getPackagePrefix
	 * <em>Package Prefix</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Package Prefix</em>'.
	 * @see com.rcpcompany.uibindings.IEMFObservableFactoryDescriptor#getPackagePrefix()
	 * @see #getEMFObservableFactoryDescriptor()
	 * @generated
	 */
	EAttribute getEMFObservableFactoryDescriptor_PackagePrefix();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.IEMFObservableFactoryDescriptor#getFactory <em>Factory</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Factory</em>'.
	 * @see com.rcpcompany.uibindings.IEMFObservableFactoryDescriptor#getFactory()
	 * @see #getEMFObservableFactoryDescriptor()
	 * @generated
	 */
	EAttribute getEMFObservableFactoryDescriptor_Factory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ui.forms.IMessage <em>IMessage</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IMessage</em>'.
	 * @see org.eclipse.ui.forms.IMessage
	 * @generated
	 */
	EClass getIMessage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.jface.fieldassist.IContentProposal
	 * <em>IContent Proposal</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>IContent Proposal</em>'.
	 * @see org.eclipse.jface.fieldassist.IContentProposal
	 * @generated
	 */
	EClass getIContentProposal();

	/**
	 * Returns the meta object for enum '{@link com.rcpcompany.uibindings.BindingState
	 * <em>Binding State</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Binding State</em>'.
	 * @see com.rcpcompany.uibindings.BindingState
	 * @generated
	 */
	EEnum getBindingState();

	/**
	 * Returns the meta object for enum '{@link com.rcpcompany.uibindings.DecorationPosition
	 * <em>Decoration Position</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Decoration Position</em>'.
	 * @see com.rcpcompany.uibindings.DecorationPosition
	 * @generated
	 */
	EEnum getDecorationPosition();

	/**
	 * Returns the meta object for enum '{@link com.rcpcompany.uibindings.TextCommitStrategy
	 * <em>Text Commit Strategy</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Text Commit Strategy</em>'.
	 * @see com.rcpcompany.uibindings.TextCommitStrategy
	 * @generated
	 */
	EEnum getTextCommitStrategy();

	/**
	 * Returns the meta object for enum '{@link com.rcpcompany.uibindings.SpecialBinding
	 * <em>Special Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Special Binding</em>'.
	 * @see com.rcpcompany.uibindings.SpecialBinding
	 * @generated
	 */
	EEnum getSpecialBinding();

	/**
	 * Returns the meta object for enum '{@link com.rcpcompany.uibindings.BindingMessageSeverity
	 * <em>Binding Message Severity</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Binding Message Severity</em>'.
	 * @see com.rcpcompany.uibindings.BindingMessageSeverity
	 * @generated
	 */
	EEnum getBindingMessageSeverity();

	/**
	 * Returns the meta object for data type '
	 * {@link com.rcpcompany.uibindings.IBindingContextFinalizer
	 * <em>IBinding Context Finalizer</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>IBinding Context Finalizer</em>'.
	 * @see com.rcpcompany.uibindings.IBindingContextFinalizer
	 * @generated
	 */
	EDataType getIBindingContextFinalizer();

	/**
	 * Returns the meta object for data type '
	 * {@link com.rcpcompany.uibindings.uiAttributes.UIAttributePainter
	 * <em>UI Attribute Painter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>UI Attribute Painter</em>'.
	 * @see com.rcpcompany.uibindings.uiAttributes.UIAttributePainter
	 * @generated
	 */
	EDataType getUIAttributePainter();

	/**
	 * Returns the meta object for data type '
	 * {@link com.rcpcompany.uibindings.IEMFObservableFactory <em>IEMF Observable Factory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>IEMF Observable Factory</em>'.
	 * @see com.rcpcompany.uibindings.IEMFObservableFactory
	 * @generated
	 */
	EDataType getIEMFObservableFactory();

	/**
	 * Returns the meta object for data type '
	 * {@link com.rcpcompany.utils.extensionpoints.CEObjectHolder <em>CE Object Holder</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>CE Object Holder</em>'.
	 * @see com.rcpcompany.utils.extensionpoints.CEObjectHolder
	 * @generated
	 */
	EDataType getCEObjectHolder();

	/**
	 * Returns the meta object for data type '
	 * {@link com.rcpcompany.utils.extensionpoints.CEResourceHolder <em>CE Resource Holder</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>CE Resource Holder</em>'.
	 * @see com.rcpcompany.utils.extensionpoints.CEResourceHolder
	 * @generated
	 */
	EDataType getCEResourceHolder();

	/**
	 * Returns the meta object for data type '{@link com.rcpcompany.uibindings.IFormatterProvider
	 * <em>IFormatter Provider</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>IFormatter Provider</em>'.
	 * @see com.rcpcompany.uibindings.IFormatterProvider
	 * @generated
	 */
	EDataType getIFormatterProvider();

	/**
	 * Returns the meta object for data type '
	 * {@link org.eclipse.core.databinding.DataBindingContext <em>DB Context</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>DB Context</em>'.
	 * @see org.eclipse.core.databinding.DataBindingContext
	 * @generated
	 */
	EDataType getDBContext();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.databinding.Binding
	 * <em>DB Binding</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>DB Binding</em>'.
	 * @see org.eclipse.core.databinding.Binding
	 * @generated
	 */
	EDataType getDBBinding();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.jface.viewers.ColumnViewer
	 * <em>Column Viewer</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Column Viewer</em>'.
	 * @see org.eclipse.jface.viewers.ColumnViewer
	 * @generated
	 */
	EDataType getColumnViewer();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.jface.viewers.ViewerColumn
	 * <em>Viewer Column</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Viewer Column</em>'.
	 * @see org.eclipse.jface.viewers.ViewerColumn
	 * @generated
	 */
	EDataType getViewerColumn();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.jface.resource.ImageDescriptor
	 * <em>Image Descriptor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Image Descriptor</em>'.
	 * @see org.eclipse.jface.resource.ImageDescriptor
	 * @generated
	 */
	EDataType getImageDescriptor();

	/**
	 * Returns the meta object for data type '
	 * {@link org.eclipse.jface.fieldassist.IControlContentAdapter
	 * <em>IControl Content Adapter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>IControl Content Adapter</em>'.
	 * @see org.eclipse.jface.fieldassist.IControlContentAdapter
	 * @generated
	 */
	EDataType getIControlContentAdapter();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ui.services.IServiceLocator
	 * <em>IService Locator</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>IService Locator</em>'.
	 * @see org.eclipse.ui.services.IServiceLocator
	 * @generated
	 */
	EDataType getIServiceLocator();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.runtime.IConfigurationElement
	 * <em>IConfiguration Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>IConfiguration Element</em>'.
	 * @see org.eclipse.core.runtime.IConfigurationElement
	 * @generated
	 */
	EDataType getIConfigurationElement();

	/**
	 * Returns the meta object for data type '{@link java.util.regex.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Pattern</em>'.
	 * @see java.util.regex.Pattern
	 * @generated
	 */
	EDataType getPattern();

	/**
	 * Returns the meta object for data type '{@link java.lang.Throwable <em>Throwable</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Throwable</em>'.
	 * @see java.lang.Throwable
	 * @generated
	 */
	EDataType getThrowable();

	/**
	 * Returns the meta object for data type '
	 * {@link org.eclipse.core.databinding.observable.IObservable <em>IObservable</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>IObservable</em>'.
	 * @see org.eclipse.core.databinding.observable.IObservable
	 * @generated
	 */
	EDataType getIObservable();

	/**
	 * Returns the meta object for data type '
	 * {@link org.eclipse.core.databinding.observable.value.IObservableValue
	 * <em>IObservable Value</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>IObservable Value</em>'.
	 * @see org.eclipse.core.databinding.observable.value.IObservableValue
	 * @generated
	 */
	EDataType getIObservableValue();

	/**
	 * Returns the meta object for data type '
	 * {@link org.eclipse.core.databinding.observable.list.IObservableList
	 * <em>IObservable List</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>IObservable List</em>'.
	 * @see org.eclipse.core.databinding.observable.list.IObservableList
	 * @generated
	 */
	EDataType getIObservableList();

	/**
	 * Returns the meta object for data type '
	 * {@link org.eclipse.core.databinding.observable.set.IObservableSet <em>IObservable Set</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>IObservable Set</em>'.
	 * @see org.eclipse.core.databinding.observable.set.IObservableSet
	 * @generated
	 */
	EDataType getIObservableSet();

	/**
	 * Returns the meta object for data type '
	 * {@link org.eclipse.core.databinding.observable.masterdetail.IObservableFactory
	 * <em>IObservable Factory</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>IObservable Factory</em>'.
	 * @see org.eclipse.core.databinding.observable.masterdetail.IObservableFactory
	 * @generated
	 */
	EDataType getIObservableFactory();

	/**
	 * Returns the meta object for data type '
	 * {@link org.eclipse.jface.databinding.swt.ISWTObservableValue <em>ISWT Observable Value</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>ISWT Observable Value</em>'.
	 * @see org.eclipse.jface.databinding.swt.ISWTObservableValue
	 * @generated
	 */
	EDataType getISWTObservableValue();

	/**
	 * Returns the meta object for data type '
	 * {@link org.eclipse.core.databinding.conversion.IConverter <em>IConverter</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>IConverter</em>'.
	 * @see org.eclipse.core.databinding.conversion.IConverter
	 * @generated
	 */
	EDataType getIConverter();

	/**
	 * Returns the meta object for data type '
	 * {@link org.eclipse.core.databinding.validation.IValidator <em>IValidator</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>IValidator</em>'.
	 * @see org.eclipse.core.databinding.validation.IValidator
	 * @generated
	 */
	EDataType getIValidator();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.edit.domain.EditingDomain
	 * <em>Editing Domain</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Editing Domain</em>'.
	 * @see org.eclipse.emf.edit.domain.EditingDomain
	 * @generated
	 */
	EDataType getEditingDomain();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.widgets.Widget <em>Widget</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Widget</em>'.
	 * @see org.eclipse.swt.widgets.Widget
	 * @generated
	 */
	EDataType getWidget();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.ui.forms.widgets.FormToolkit
	 * <em>Form Toolkit</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Form Toolkit</em>'.
	 * @see org.eclipse.ui.forms.widgets.FormToolkit
	 * @generated
	 */
	EDataType getFormToolkit();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.widgets.Control
	 * <em>Control</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Control</em>'.
	 * @see org.eclipse.swt.widgets.Control
	 * @generated
	 */
	EDataType getControl();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.widgets.Composite
	 * <em>Composite</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Composite</em>'.
	 * @see org.eclipse.swt.widgets.Composite
	 * @generated
	 */
	EDataType getComposite();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.widgets.Table <em>Table</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Table</em>'.
	 * @see org.eclipse.swt.widgets.Table
	 * @generated
	 */
	EDataType getTable();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.widgets.TableColumn
	 * <em>Table Column</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Table Column</em>'.
	 * @see org.eclipse.swt.widgets.TableColumn
	 * @generated
	 */
	EDataType getTableColumn();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.widgets.Tree <em>Tree</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Tree</em>'.
	 * @see org.eclipse.swt.widgets.Tree
	 * @generated
	 */
	EDataType getTree();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.widgets.TreeColumn
	 * <em>Tree Column</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Tree Column</em>'.
	 * @see org.eclipse.swt.widgets.TreeColumn
	 * @generated
	 */
	EDataType getTreeColumn();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.dnd.Clipboard
	 * <em>Clipboard</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Clipboard</em>'.
	 * @see org.eclipse.swt.dnd.Clipboard
	 * @generated
	 */
	EDataType getClipboard();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.graphics.Image <em>Image</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Image</em>'.
	 * @see org.eclipse.swt.graphics.Image
	 * @generated
	 */
	EDataType getImage();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.graphics.Color <em>Color</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Color</em>'.
	 * @see org.eclipse.swt.graphics.Color
	 * @generated
	 */
	EDataType getColor();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.graphics.Cursor
	 * <em>Cursor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Cursor</em>'.
	 * @see org.eclipse.swt.graphics.Cursor
	 * @generated
	 */
	EDataType getCursor();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.events.SelectionListener
	 * <em>Selection Listener</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Selection Listener</em>'.
	 * @see org.eclipse.swt.events.SelectionListener
	 * @generated
	 */
	EDataType getSelectionListener();

	/**
	 * Returns the meta object for data type '
	 * {@link org.eclipse.core.databinding.UpdateValueStrategy <em>Update Value Strategy</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Update Value Strategy</em>'.
	 * @see org.eclipse.core.databinding.UpdateValueStrategy
	 * @generated
	 */
	EDataType getUpdateValueStrategy();

	/**
	 * Returns the meta object for data type '
	 * {@link org.eclipse.core.databinding.UpdateListStrategy <em>Update List Strategy</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Update List Strategy</em>'.
	 * @see org.eclipse.core.databinding.UpdateListStrategy
	 * @generated
	 */
	EDataType getUpdateListStrategy();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.databinding.UpdateSetStrategy
	 * <em>Update Set Strategy</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Update Set Strategy</em>'.
	 * @see org.eclipse.core.databinding.UpdateSetStrategy
	 * @generated
	 */
	EDataType getUpdateSetStrategy();

	/**
	 * Returns the meta object for data type '{@link com.ibm.icu.text.NumberFormat
	 * <em>Number Format</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Number Format</em>'.
	 * @see com.ibm.icu.text.NumberFormat
	 * @generated
	 */
	EDataType getNumberFormat();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IUIBindingsFactory getUIBindingsFactory();

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
		 * {@link com.rcpcompany.uibindings.internal.BaseObjectImpl <em>Base Object</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.BaseObjectImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getBaseObject()
		 * @generated
		 */
		EClass BASE_OBJECT = eINSTANCE.getBaseObject();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.internal.ManagerImpl
		 * <em>Manager</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.ManagerImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getManager()
		 * @generated
		 */
		EClass MANAGER = eINSTANCE.getManager();

		/**
		 * The meta object literal for the '<em><b>Providers</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MANAGER__PROVIDERS = eINSTANCE.getManager_Providers();

		/**
		 * The meta object literal for the '<em><b>Ui Attribute Factories</b></em>' reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MANAGER__UI_ATTRIBUTE_FACTORIES = eINSTANCE.getManager_UiAttributeFactories();

		/**
		 * The meta object literal for the '<em><b>Decorator Extenders</b></em>' reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MANAGER__DECORATOR_EXTENDERS = eINSTANCE.getManager_DecoratorExtenders();

		/**
		 * The meta object literal for the '<em><b>Model Argument Mediators</b></em>' attribute list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__MODEL_ARGUMENT_MEDIATORS = eINSTANCE.getManager_ModelArgumentMediators();

		/**
		 * The meta object literal for the '<em><b>Model Argument Mediator Classes</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__MODEL_ARGUMENT_MEDIATOR_CLASSES = eINSTANCE.getManager_ModelArgumentMediatorClasses();

		/**
		 * The meta object literal for the '<em><b>Text Commit Strategy</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__TEXT_COMMIT_STRATEGY = eINSTANCE.getManager_TextCommitStrategy();

		/**
		 * The meta object literal for the '<em><b>Text Commit Strategy Delay</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__TEXT_COMMIT_STRATEGY_DELAY = eINSTANCE.getManager_TextCommitStrategyDelay();

		/**
		 * The meta object literal for the '<em><b>Edit Cell Any Key</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__EDIT_CELL_ANY_KEY = eINSTANCE.getManager_EditCellAnyKey();

		/**
		 * The meta object literal for the '<em><b>Edit Cell Single Click</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__EDIT_CELL_SINGLE_CLICK = eINSTANCE.getManager_EditCellSingleClick();

		/**
		 * The meta object literal for the '<em><b>Message Decoration Position</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__MESSAGE_DECORATION_POSITION = eINSTANCE.getManager_MessageDecorationPosition();

		/**
		 * The meta object literal for the '<em><b>Message Decoration Minimum Severity</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__MESSAGE_DECORATION_MINIMUM_SEVERITY = eINSTANCE
				.getManager_MessageDecorationMinimumSeverity();

		/**
		 * The meta object literal for the '<em><b>Alternative Decoration Position</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__ALTERNATIVE_DECORATION_POSITION = eINSTANCE.getManager_AlternativeDecorationPosition();

		/**
		 * The meta object literal for the '<em><b>Auto Apply Single Quickfix</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__AUTO_APPLY_SINGLE_QUICKFIX = eINSTANCE.getManager_AutoApplySingleQuickfix();

		/**
		 * The meta object literal for the '<em><b>Alternate Row Colors</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__ALTERNATE_ROW_COLORS = eINSTANCE.getManager_AlternateRowColors();

		/**
		 * The meta object literal for the '<em><b>Validation Errors Are Fatal</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__VALIDATION_ERRORS_ARE_FATAL = eINSTANCE.getManager_ValidationErrorsAreFatal();

		/**
		 * The meta object literal for the '<em><b>Validation Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__VALIDATION_DELAY = eINSTANCE.getManager_ValidationDelay();

		/**
		 * The meta object literal for the '<em><b>Validation Delay Window</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__VALIDATION_DELAY_WINDOW = eINSTANCE.getManager_ValidationDelayWindow();

		/**
		 * The meta object literal for the '<em><b>Required VB Image Decoration Shown</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__REQUIRED_VB_IMAGE_DECORATION_SHOWN = eINSTANCE.getManager_RequiredVBImageDecorationShown();

		/**
		 * The meta object literal for the '<em><b>Assist VB Image Decoration Shown</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__ASSIST_VB_IMAGE_DECORATION_SHOWN = eINSTANCE.getManager_AssistVBImageDecorationShown();

		/**
		 * The meta object literal for the '<em><b>Quickfix VB Image Decoration Shown</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__QUICKFIX_VB_IMAGE_DECORATION_SHOWN = eINSTANCE.getManager_QuickfixVBImageDecorationShown();

		/**
		 * The meta object literal for the '<em><b>View Navigation Recorded</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__VIEW_NAVIGATION_RECORDED = eINSTANCE.getManager_ViewNavigationRecorded();

		/**
		 * The meta object literal for the '<em><b>Model Info</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MANAGER__MODEL_INFO = eINSTANCE.getManager_ModelInfo();

		/**
		 * The meta object literal for the '<em><b>Tree Items</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MANAGER__TREE_ITEMS = eINSTANCE.getManager_TreeItems();

		/**
		 * The meta object literal for the '<em><b>Clipboard</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__CLIPBOARD = eINSTANCE.getManager_Clipboard();

		/**
		 * The meta object literal for the '<em><b>Observable Factories</b></em>' containment
		 * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MANAGER__OBSERVABLE_FACTORIES = eINSTANCE.getManager_ObservableFactories();

		/**
		 * The meta object literal for the '<em><b>Quickfix Proposal Processors</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MANAGER__QUICKFIX_PROPOSAL_PROCESSORS = eINSTANCE.getManager_QuickfixProposalProcessors();

		/**
		 * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MANAGER__CONTEXTS = eINSTANCE.getManager_Contexts();

		/**
		 * The meta object literal for the '<em><b>Formatter Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__FORMATTER_PROVIDER = eINSTANCE.getManager_FormatterProvider();

		/**
		 * The meta object literal for the '<em><b>Editing Domain</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__EDITING_DOMAIN = eINSTANCE.getManager_EditingDomain();

		/**
		 * The meta object literal for the '<em><b>Form Toolkit</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MANAGER__FORM_TOOLKIT = eINSTANCE.getManager_FormToolkit();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.BindingContextImpl <em>Binding Context</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.BindingContextImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getBindingContext()
		 * @generated
		 */
		EClass BINDING_CONTEXT = eINSTANCE.getBindingContext();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING_CONTEXT__BINDINGS = eINSTANCE.getBindingContext_Bindings();

		/**
		 * The meta object literal for the '<em><b>Ok Bindings</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING_CONTEXT__OK_BINDINGS = eINSTANCE.getBindingContext_OkBindings();

		/**
		 * The meta object literal for the '<em><b>Top</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_CONTEXT__TOP = eINSTANCE.getBindingContext_Top();

		/**
		 * The meta object literal for the '<em><b>Db Context</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_CONTEXT__DB_CONTEXT = eINSTANCE.getBindingContext_DbContext();

		/**
		 * The meta object literal for the '<em><b>Service Locator</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_CONTEXT__SERVICE_LOCATOR = eINSTANCE.getBindingContext_ServiceLocator();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_CONTEXT__STATE = eINSTANCE.getBindingContext_State();

		/**
		 * The meta object literal for the '<em><b>Text Commit Strategy</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_CONTEXT__TEXT_COMMIT_STRATEGY = eINSTANCE.getBindingContext_TextCommitStrategy();

		/**
		 * The meta object literal for the '<em><b>Text Commit Strategy Calculated</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_CONTEXT__TEXT_COMMIT_STRATEGY_CALCULATED = eINSTANCE
				.getBindingContext_TextCommitStrategyCalculated();

		/**
		 * The meta object literal for the '<em><b>Editing Domain</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_CONTEXT__EDITING_DOMAIN = eINSTANCE.getBindingContext_EditingDomain();

		/**
		 * The meta object literal for the '<em><b>Finalizers</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_CONTEXT__FINALIZERS = eINSTANCE.getBindingContext_Finalizers();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.internal.BindingImpl
		 * <em>Binding</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.BindingImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getBinding()
		 * @generated
		 */
		EClass BINDING = eINSTANCE.getBinding();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING__CONTEXT = eINSTANCE.getBinding_Context();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING__STATE = eINSTANCE.getBinding_State();

		/**
		 * The meta object literal for the '<em><b>Changeable</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING__CHANGEABLE = eINSTANCE.getBinding_Changeable();

		/**
		 * The meta object literal for the '<em><b>Creation Point</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING__CREATION_POINT = eINSTANCE.getBinding_CreationPoint();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING__ID = eINSTANCE.getBinding_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING__TYPE = eINSTANCE.getBinding_Type();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING__LABEL = eINSTANCE.getBinding_Label();

		/**
		 * The meta object literal for the '<em><b>Static Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING__STATIC_DATA_TYPE = eINSTANCE.getBinding_StaticDataType();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING__DATA_TYPE = eINSTANCE.getBinding_DataType();

		/**
		 * The meta object literal for the '<em><b>Model EType</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING__MODEL_ETYPE = eINSTANCE.getBinding_ModelEType();

		/**
		 * The meta object literal for the '<em><b>Model Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING__MODEL_TYPE = eINSTANCE.getBinding_ModelType();

		/**
		 * The meta object literal for the '<em><b>UI Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING__UI_TYPE = eINSTANCE.getBinding_UIType();

		/**
		 * The meta object literal for the '<em><b>DB Bindings</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING__DB_BINDINGS = eINSTANCE.getBinding_DBBindings();

		/**
		 * The meta object literal for the '<em><b>Monitored DB Bindings</b></em>' attribute list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING__MONITORED_DB_BINDINGS = eINSTANCE.getBinding_MonitoredDBBindings();

		/**
		 * The meta object literal for the '<em><b>Error Conditions</b></em>' attribute list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING__ERROR_CONDITIONS = eINSTANCE.getBinding_ErrorConditions();

		/**
		 * The meta object literal for the '<em><b>Widget</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING__WIDGET = eINSTANCE.getBinding_Widget();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING__CONTROL = eINSTANCE.getBinding_Control();

		/**
		 * The meta object literal for the '<em><b>Extra Argument Providers</b></em>' reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING__EXTRA_ARGUMENT_PROVIDERS = eINSTANCE.getBinding_ExtraArgumentProviders();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.ValueBindingImpl <em>Value Binding</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.ValueBindingImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getValueBinding()
		 * @generated
		 */
		EClass VALUE_BINDING = eINSTANCE.getValueBinding();

		/**
		 * The meta object literal for the '<em><b>Model Observable</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VALUE_BINDING__MODEL_OBSERVABLE = eINSTANCE.getValueBinding_ModelObservable();

		/**
		 * The meta object literal for the '<em><b>Model Observable Value</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VALUE_BINDING__MODEL_OBSERVABLE_VALUE = eINSTANCE.getValueBinding_ModelObservableValue();

		/**
		 * The meta object literal for the '<em><b>Model Object</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VALUE_BINDING__MODEL_OBJECT = eINSTANCE.getValueBinding_ModelObject();

		/**
		 * The meta object literal for the '<em><b>Model Feature</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VALUE_BINDING__MODEL_FEATURE = eINSTANCE.getValueBinding_ModelFeature();

		/**
		 * The meta object literal for the '<em><b>Message Prefix</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VALUE_BINDING__MESSAGE_PREFIX = eINSTANCE.getValueBinding_MessagePrefix();

		/**
		 * The meta object literal for the '<em><b>Decorator Provider</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VALUE_BINDING__DECORATOR_PROVIDER = eINSTANCE.getValueBinding_DecoratorProvider();

		/**
		 * The meta object literal for the '<em><b>Decorator</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VALUE_BINDING__DECORATOR = eINSTANCE.getValueBinding_Decorator();

		/**
		 * The meta object literal for the '<em><b>UI Attribute</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VALUE_BINDING__UI_ATTRIBUTE = eINSTANCE.getValueBinding_UIAttribute();

		/**
		 * The meta object literal for the '<em><b>UI Observable</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VALUE_BINDING__UI_OBSERVABLE = eINSTANCE.getValueBinding_UIObservable();

		/**
		 * The meta object literal for the '<em><b>Cell</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VALUE_BINDING__CELL = eINSTANCE.getValueBinding_Cell();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.IValueBindingCell
		 * <em>Value Binding Cell</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.IValueBindingCell
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getValueBindingCell()
		 * @generated
		 */
		EClass VALUE_BINDING_CELL = eINSTANCE.getValueBindingCell();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.ColumnBindingImpl <em>Column Binding</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.ColumnBindingImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getColumnBinding()
		 * @generated
		 */
		EClass COLUMN_BINDING = eINSTANCE.getColumnBinding();

		/**
		 * The meta object literal for the '<em><b>Viewer Binding</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLUMN_BINDING__VIEWER_BINDING = eINSTANCE.getColumnBinding_ViewerBinding();

		/**
		 * The meta object literal for the '<em><b>Viewer Column</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_BINDING__VIEWER_COLUMN = eINSTANCE.getColumnBinding_ViewerColumn();

		/**
		 * The meta object literal for the '<em><b>Column Adapter</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLUMN_BINDING__COLUMN_ADAPTER = eINSTANCE.getColumnBinding_ColumnAdapter();

		/**
		 * The meta object literal for the '<em><b>Base Column</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLUMN_BINDING__BASE_COLUMN = eINSTANCE.getColumnBinding_BaseColumn();

		/**
		 * The meta object literal for the '<em><b>Sub Columns</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLUMN_BINDING__SUB_COLUMNS = eINSTANCE.getColumnBinding_SubColumns();

		/**
		 * The meta object literal for the '<em><b>Cells</b></em>' map feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLUMN_BINDING__CELLS = eINSTANCE.getColumnBinding_Cells();

		/**
		 * The meta object literal for the '<em><b>Special Binding Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_BINDING__SPECIAL_BINDING_TYPE = eINSTANCE.getColumnBinding_SpecialBindingType();

		/**
		 * The meta object literal for the '<em><b>Factory</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_BINDING__FACTORY = eINSTANCE.getColumnBinding_Factory();

		/**
		 * The meta object literal for the '<em><b>Cursor</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_BINDING__CURSOR = eINSTANCE.getColumnBinding_Cursor();

		/**
		 * The meta object literal for the '<em><b>Column Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_BINDING__COLUMN_VISIBILITY = eINSTANCE.getColumnBinding_ColumnVisibility();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.ColumnBindingCellInformationImpl
		 * <em>Column Binding Cell Information</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.ColumnBindingCellInformationImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getColumnBindingCellInformation()
		 * @generated
		 */
		EClass COLUMN_BINDING_CELL_INFORMATION = eINSTANCE.getColumnBindingCellInformation();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLUMN_BINDING_CELL_INFORMATION__COLUMN = eINSTANCE.getColumnBindingCellInformation_Column();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLUMN_BINDING_CELL_INFORMATION__ELEMENT = eINSTANCE.getColumnBindingCellInformation_Element();

		/**
		 * The meta object literal for the '<em><b>Label Binding</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLUMN_BINDING_CELL_INFORMATION__LABEL_BINDING = eINSTANCE
				.getColumnBindingCellInformation_LabelBinding();

		/**
		 * The meta object literal for the '<em><b>Label UI Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLUMN_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE = eINSTANCE
				.getColumnBindingCellInformation_LabelUIAttribute();

		/**
		 * The meta object literal for the '<em><b>Label Painter</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_BINDING_CELL_INFORMATION__LABEL_PAINTER = eINSTANCE
				.getColumnBindingCellInformation_LabelPainter();

		/**
		 * The meta object literal for the '<em><b>Object Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_BINDING_CELL_INFORMATION__OBJECT_VALUE = eINSTANCE
				.getColumnBindingCellInformation_ObjectValue();

		/**
		 * The meta object literal for the '<em><b>Source Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_BINDING_CELL_INFORMATION__SOURCE_VALUE = eINSTANCE
				.getColumnBindingCellInformation_SourceValue();

		/**
		 * The meta object literal for the '<em><b>Changeable</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_BINDING_CELL_INFORMATION__CHANGEABLE = eINSTANCE.getColumnBindingCellInformation_Changeable();

		/**
		 * The meta object literal for the '<em><b>Display Text</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_BINDING_CELL_INFORMATION__DISPLAY_TEXT = eINSTANCE
				.getColumnBindingCellInformation_DisplayText();

		/**
		 * The meta object literal for the '<em><b>Value Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_BINDING_CELL_INFORMATION__VALUE_TYPE = eINSTANCE.getColumnBindingCellInformation_ValueType();

		/**
		 * The meta object literal for the '<em><b>Tool Tip Text</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_BINDING_CELL_INFORMATION__TOOL_TIP_TEXT = eINSTANCE
				.getColumnBindingCellInformation_ToolTipText();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_BINDING_CELL_INFORMATION__ENABLED = eINSTANCE.getColumnBindingCellInformation_Enabled();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.ContainerBindingImpl
		 * <em>Container Binding</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.ContainerBindingImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getContainerBinding()
		 * @generated
		 */
		EClass CONTAINER_BINDING = eINSTANCE.getContainerBinding();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.ViewerBindingImpl <em>Viewer Binding</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.ViewerBindingImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getViewerBinding()
		 * @generated
		 */
		EClass VIEWER_BINDING = eINSTANCE.getViewerBinding();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VIEWER_BINDING__COLUMNS = eINSTANCE.getViewerBinding_Columns();

		/**
		 * The meta object literal for the '<em><b>List</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VIEWER_BINDING__LIST = eINSTANCE.getViewerBinding_List();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VIEWER_BINDING__ELEMENTS = eINSTANCE.getViewerBinding_Elements();

		/**
		 * The meta object literal for the '<em><b>Single Selection</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VIEWER_BINDING__SINGLE_SELECTION = eINSTANCE.getViewerBinding_SingleSelection();

		/**
		 * The meta object literal for the '<em><b>Multiple Selection</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VIEWER_BINDING__MULTIPLE_SELECTION = eINSTANCE.getViewerBinding_MultipleSelection();

		/**
		 * The meta object literal for the '<em><b>Viewer</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VIEWER_BINDING__VIEWER = eINSTANCE.getViewerBinding_Viewer();

		/**
		 * The meta object literal for the '<em><b>First Table Column Offset</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VIEWER_BINDING__FIRST_TABLE_COLUMN_OFFSET = eINSTANCE.getViewerBinding_FirstTableColumnOffset();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.DecoratorProviderImpl
		 * <em>Decorator Provider</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.DecoratorProviderImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getDecoratorProvider()
		 * @generated
		 */
		EClass DECORATOR_PROVIDER = eINSTANCE.getDecoratorProvider();

		/**
		 * The meta object literal for the '<em><b>Manager</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DECORATOR_PROVIDER__MANAGER = eINSTANCE.getDecoratorProvider_Manager();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DECORATOR_PROVIDER__ID = eINSTANCE.getDecoratorProvider_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DECORATOR_PROVIDER__TYPE = eINSTANCE.getDecoratorProvider_Type();

		/**
		 * The meta object literal for the '<em><b>Model Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DECORATOR_PROVIDER__MODEL_TYPES = eINSTANCE.getDecoratorProvider_ModelTypes();

		/**
		 * The meta object literal for the '<em><b>Ui Types</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DECORATOR_PROVIDER__UI_TYPES = eINSTANCE.getDecoratorProvider_UiTypes();

		/**
		 * The meta object literal for the '<em><b>Provider CE</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DECORATOR_PROVIDER__PROVIDER_CE = eINSTANCE.getDecoratorProvider_ProviderCE();

		/**
		 * The meta object literal for the '<em><b>Child CE</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DECORATOR_PROVIDER__CHILD_CE = eINSTANCE.getDecoratorProvider_ChildCE();

		/**
		 * The meta object literal for the '<em><b>Decorator</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DECORATOR_PROVIDER__DECORATOR = eINSTANCE.getDecoratorProvider_Decorator();

		/**
		 * The meta object literal for the '<em><b>Exact Model Type Match</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DECORATOR_PROVIDER__EXACT_MODEL_TYPE_MATCH = eINSTANCE.getDecoratorProvider_ExactModelTypeMatch();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.JavaDecoratorProviderImpl
		 * <em>Java Decorator Provider</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.JavaDecoratorProviderImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getJavaDecoratorProvider()
		 * @generated
		 */
		EClass JAVA_DECORATOR_PROVIDER = eINSTANCE.getJavaDecoratorProvider();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.EnumDecoratorProviderImpl
		 * <em>Enum Decorator Provider</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.EnumDecoratorProviderImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getEnumDecoratorProvider()
		 * @generated
		 */
		EClass ENUM_DECORATOR_PROVIDER = eINSTANCE.getEnumDecoratorProvider();

		/**
		 * The meta object literal for the '<em><b>Adding Default Mappings</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENUM_DECORATOR_PROVIDER__ADDING_DEFAULT_MAPPINGS = eINSTANCE
				.getEnumDecoratorProvider_AddingDefaultMappings();

		/**
		 * The meta object literal for the '<em><b>Base Mappings</b></em>' containment reference
		 * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENUM_DECORATOR_PROVIDER__BASE_MAPPINGS = eINSTANCE.getEnumDecoratorProvider_BaseMappings();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.EnumDecoratorProviderEntryImpl
		 * <em>Enum Decorator Provider Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.EnumDecoratorProviderEntryImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getEnumDecoratorProviderEntry()
		 * @generated
		 */
		EClass ENUM_DECORATOR_PROVIDER_ENTRY = eINSTANCE.getEnumDecoratorProviderEntry();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENUM_DECORATOR_PROVIDER_ENTRY__MODEL = eINSTANCE.getEnumDecoratorProviderEntry_Model();

		/**
		 * The meta object literal for the '<em><b>Ui</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENUM_DECORATOR_PROVIDER_ENTRY__UI = eINSTANCE.getEnumDecoratorProviderEntry_Ui();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.NumberDecoratorProviderImpl
		 * <em>Number Decorator Provider</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.NumberDecoratorProviderImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getNumberDecoratorProvider()
		 * @generated
		 */
		EClass NUMBER_DECORATOR_PROVIDER = eINSTANCE.getNumberDecoratorProvider();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NUMBER_DECORATOR_PROVIDER__FORMAT = eINSTANCE.getNumberDecoratorProvider_Format();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.BindingDataTypeImpl <em>Binding Data Type</em>}
		 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.BindingDataTypeImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getBindingDataType()
		 * @generated
		 */
		EClass BINDING_DATA_TYPE = eINSTANCE.getBindingDataType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_DATA_TYPE__NAME = eINSTANCE.getBindingDataType_Name();

		/**
		 * The meta object literal for the '<em><b>Value Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_DATA_TYPE__VALUE_TYPE = eINSTANCE.getBindingDataType_ValueType();

		/**
		 * The meta object literal for the '<em><b>EType</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING_DATA_TYPE__ETYPE = eINSTANCE.getBindingDataType_EType();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_DATA_TYPE__DATA_TYPE = eINSTANCE.getBindingDataType_DataType();

		/**
		 * The meta object literal for the '<em><b>EAnnotation</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING_DATA_TYPE__EANNOTATION = eINSTANCE.getBindingDataType_EAnnotation();

		/**
		 * The meta object literal for the '<em><b>Parent Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING_DATA_TYPE__PARENT_DATA_TYPE = eINSTANCE.getBindingDataType_ParentDataType();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_DATA_TYPE__REQUIRED = eINSTANCE.getBindingDataType_Required();

		/**
		 * The meta object literal for the '<em><b>Changeable</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_DATA_TYPE__CHANGEABLE = eINSTANCE.getBindingDataType_Changeable();

		/**
		 * The meta object literal for the '<em><b>Unsettable</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_DATA_TYPE__UNSETTABLE = eINSTANCE.getBindingDataType_Unsettable();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.ColumnAdapterImpl <em>Column Adapter</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.ColumnAdapterImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getColumnAdapter()
		 * @generated
		 */
		EClass COLUMN_ADAPTER = eINSTANCE.getColumnAdapter();

		/**
		 * The meta object literal for the '<em><b>Widget</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_ADAPTER__WIDGET = eINSTANCE.getColumnAdapter_Widget();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_ADAPTER__TEXT = eINSTANCE.getColumnAdapter_Text();

		/**
		 * The meta object literal for the '<em><b>Alignment</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_ADAPTER__ALIGNMENT = eINSTANCE.getColumnAdapter_Alignment();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_ADAPTER__IMAGE = eINSTANCE.getColumnAdapter_Image();

		/**
		 * The meta object literal for the '<em><b>Moveable</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_ADAPTER__MOVEABLE = eINSTANCE.getColumnAdapter_Moveable();

		/**
		 * The meta object literal for the '<em><b>Resizable</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_ADAPTER__RESIZABLE = eINSTANCE.getColumnAdapter_Resizable();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_ADAPTER__WIDTH = eINSTANCE.getColumnAdapter_Width();

		/**
		 * The meta object literal for the '<em><b>Tool Tip Text</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN_ADAPTER__TOOL_TIP_TEXT = eINSTANCE.getColumnAdapter_ToolTipText();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.internal.ModelInfoImpl
		 * <em>Model Info</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.ModelInfoImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getModelInfo()
		 * @generated
		 */
		EClass MODEL_INFO = eINSTANCE.getModelInfo();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.ModelClassInfoImpl <em>Model Class Info</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.ModelClassInfoImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getModelClassInfo()
		 * @generated
		 */
		EClass MODEL_CLASS_INFO = eINSTANCE.getModelClassInfo();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MODEL_CLASS_INFO__CLASS_NAME = eINSTANCE.getModelClassInfo_ClassName();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MODEL_CLASS_INFO__FEATURES = eINSTANCE.getModelClassInfo_Features();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' map feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MODEL_CLASS_INFO__TYPES = eINSTANCE.getModelClassInfo_Types();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.ModelFeatureInfoImpl
		 * <em>Model Feature Info</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.ModelFeatureInfoImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getModelFeatureInfo()
		 * @generated
		 */
		EClass MODEL_FEATURE_INFO = eINSTANCE.getModelFeatureInfo();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MODEL_FEATURE_INFO__FEATURE_NAME = eINSTANCE.getModelFeatureInfo_FeatureName();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MODEL_FEATURE_INFO__CLASS = eINSTANCE.getModelFeatureInfo_Class();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.UIBindingDecoratorImpl
		 * <em>UI Binding Decorator</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.UIBindingDecoratorImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUIBindingDecorator()
		 * @generated
		 */
		EClass UI_BINDING_DECORATOR = eINSTANCE.getUIBindingDecorator();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference UI_BINDING_DECORATOR__BINDING = eINSTANCE.getUIBindingDecorator_Binding();

		/**
		 * The meta object literal for the '<em><b>Changeable</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_BINDING_DECORATOR__CHANGEABLE = eINSTANCE.getUIBindingDecorator_Changeable();

		/**
		 * The meta object literal for the '<em><b>Model To UI Converter</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_BINDING_DECORATOR__MODEL_TO_UI_CONVERTER = eINSTANCE.getUIBindingDecorator_ModelToUIConverter();

		/**
		 * The meta object literal for the '<em><b>UI To Model Converter</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_BINDING_DECORATOR__UI_TO_MODEL_CONVERTER = eINSTANCE.getUIBindingDecorator_UIToModelConverter();

		/**
		 * The meta object literal for the '<em><b>UI To Model After Convert Validator</b></em>'
		 * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_BINDING_DECORATOR__UI_TO_MODEL_AFTER_CONVERT_VALIDATOR = eINSTANCE
				.getUIBindingDecorator_UIToModelAfterConvertValidator();

		/**
		 * The meta object literal for the '<em><b>Valid UI List</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_BINDING_DECORATOR__VALID_UI_LIST = eINSTANCE.getUIBindingDecorator_ValidUIList();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.UIBindingDecoratorExtenderImpl
		 * <em>UI Binding Decorator Extender</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.UIBindingDecoratorExtenderImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUIBindingDecoratorExtender()
		 * @generated
		 */
		EClass UI_BINDING_DECORATOR_EXTENDER = eINSTANCE.getUIBindingDecoratorExtender();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.UIBindingDecoratorExtenderDescriptorImpl
		 * <em>UI Binding Decorator Extender Descriptor</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.UIBindingDecoratorExtenderDescriptorImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUIBindingDecoratorExtenderDescriptor()
		 * @generated
		 */
		EClass UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR = eINSTANCE.getUIBindingDecoratorExtenderDescriptor();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__PRIORITY = eINSTANCE
				.getUIBindingDecoratorExtenderDescriptor_Priority();

		/**
		 * The meta object literal for the '<em><b>Factory</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__FACTORY = eINSTANCE
				.getUIBindingDecoratorExtenderDescriptor_Factory();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.IArgumentProvider
		 * <em>IArgument Provider</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.IArgumentProvider
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIArgumentProvider()
		 * @generated
		 */
		EClass IARGUMENT_PROVIDER = eINSTANCE.getIArgumentProvider();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.IDisposable
		 * <em>IDisposable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.IDisposable
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIDisposable()
		 * @generated
		 */
		EClass IDISPOSABLE = eINSTANCE.getIDisposable();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.IModelArgumentMediator
		 * <em>IModel Argument Mediator</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.IModelArgumentMediator
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIModelArgumentMediator()
		 * @generated
		 */
		EClass IMODEL_ARGUMENT_MEDIATOR = eINSTANCE.getIModelArgumentMediator();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.IPersistentPartyImpl
		 * <em>IPersistent Party</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.IPersistentPartyImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIPersistentParty()
		 * @generated
		 */
		EClass IPERSISTENT_PARTY = eINSTANCE.getIPersistentParty();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.Constants
		 * <em>Constants</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.Constants
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getConstants()
		 * @generated
		 */
		EClass CONSTANTS = eINSTANCE.getConstants();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.StringToModelClassInfoMapEntryImpl
		 * <em>String To Model Class Info Map Entry</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.StringToModelClassInfoMapEntryImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getStringToModelClassInfoMapEntry()
		 * @generated
		 */
		EClass STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY = eINSTANCE.getStringToModelClassInfoMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY__KEY = eINSTANCE.getStringToModelClassInfoMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY__VALUE = eINSTANCE.getStringToModelClassInfoMapEntry_Value();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.StringToModelFeatureInfoMapEntryImpl
		 * <em>String To Model Feature Info Map Entry</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.StringToModelFeatureInfoMapEntryImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getStringToModelFeatureInfoMapEntry()
		 * @generated
		 */
		EClass STRING_TO_MODEL_FEATURE_INFO_MAP_ENTRY = eINSTANCE.getStringToModelFeatureInfoMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_MODEL_FEATURE_INFO_MAP_ENTRY__KEY = eINSTANCE.getStringToModelFeatureInfoMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STRING_TO_MODEL_FEATURE_INFO_MAP_ENTRY__VALUE = eINSTANCE
				.getStringToModelFeatureInfoMapEntry_Value();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.StringToStringMapEntryImpl
		 * <em>String To String Map Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.StringToStringMapEntryImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getStringToStringMapEntry()
		 * @generated
		 */
		EClass STRING_TO_STRING_MAP_ENTRY = eINSTANCE.getStringToStringMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_STRING_MAP_ENTRY__KEY = eINSTANCE.getStringToStringMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_STRING_MAP_ENTRY__VALUE = eINSTANCE.getStringToStringMapEntry_Value();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STRING_TO_STRING_MAP_ENTRY__ARGUMENTS = eINSTANCE.getStringToStringMapEntry_Arguments();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.StringToObjectMapEntryImpl
		 * <em>String To Object Map Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.StringToObjectMapEntryImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getStringToObjectMapEntry()
		 * @generated
		 */
		EClass STRING_TO_OBJECT_MAP_ENTRY = eINSTANCE.getStringToObjectMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_OBJECT_MAP_ENTRY__KEY = eINSTANCE.getStringToObjectMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_OBJECT_MAP_ENTRY__VALUE = eINSTANCE.getStringToObjectMapEntry_Value();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.StringToImageDescriptorMapEntryImpl
		 * <em>String To Image Descriptor Map Entry</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.StringToImageDescriptorMapEntryImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getStringToImageDescriptorMapEntry()
		 * @generated
		 */
		EClass STRING_TO_IMAGE_DESCRIPTOR_MAP_ENTRY = eINSTANCE.getStringToImageDescriptorMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_IMAGE_DESCRIPTOR_MAP_ENTRY__KEY = eINSTANCE.getStringToImageDescriptorMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_IMAGE_DESCRIPTOR_MAP_ENTRY__VALUE = eINSTANCE.getStringToImageDescriptorMapEntry_Value();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.StringToIConfigurationElementMapEntryImpl
		 * <em>String To IConfiguration Element Map Entry</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.StringToIConfigurationElementMapEntryImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getStringToIConfigurationElementMapEntry()
		 * @generated
		 */
		EClass STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY = eINSTANCE.getStringToIConfigurationElementMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY__KEY = eINSTANCE
				.getStringToIConfigurationElementMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY__VALUE = eINSTANCE
				.getStringToIConfigurationElementMapEntry_Value();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.StringToBooleanMapEntryImpl
		 * <em>String To Boolean Map Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.StringToBooleanMapEntryImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getStringToBooleanMapEntry()
		 * @generated
		 */
		EClass STRING_TO_BOOLEAN_MAP_ENTRY = eINSTANCE.getStringToBooleanMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_BOOLEAN_MAP_ENTRY__KEY = eINSTANCE.getStringToBooleanMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_TO_BOOLEAN_MAP_ENTRY__VALUE = eINSTANCE.getStringToBooleanMapEntry_Value();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.ObjectToCIMapEntryImpl
		 * <em>Object To CI Map Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.ObjectToCIMapEntryImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getObjectToCIMapEntry()
		 * @generated
		 */
		EClass OBJECT_TO_CI_MAP_ENTRY = eINSTANCE.getObjectToCIMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OBJECT_TO_CI_MAP_ENTRY__KEY = eINSTANCE.getObjectToCIMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OBJECT_TO_CI_MAP_ENTRY__VALUE = eINSTANCE.getObjectToCIMapEntry_Value();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.IServiceRegistry
		 * <em>Service Registry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.IServiceRegistry
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getServiceRegistry()
		 * @generated
		 */
		EClass SERVICE_REGISTRY = eINSTANCE.getServiceRegistry();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SERVICE_REGISTRY__SERVICES = eINSTANCE.getServiceRegistry_Services();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.QuickfixProposalImpl
		 * <em>Quickfix Proposal</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.QuickfixProposalImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getQuickfixProposal()
		 * @generated
		 */
		EClass QUICKFIX_PROPOSAL = eINSTANCE.getQuickfixProposal();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute QUICKFIX_PROPOSAL__LABEL = eINSTANCE.getQuickfixProposal_Label();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute QUICKFIX_PROPOSAL__DESCRIPTION = eINSTANCE.getQuickfixProposal_Description();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute QUICKFIX_PROPOSAL__IMAGE = eINSTANCE.getQuickfixProposal_Image();

		/**
		 * The meta object literal for the '<em><b>Relevance</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute QUICKFIX_PROPOSAL__RELEVANCE = eINSTANCE.getQuickfixProposal_Relevance();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.QuickfixProposalProcessorImpl
		 * <em>Quickfix Proposal Processor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.QuickfixProposalProcessorImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getQuickfixProposalProcessor()
		 * @generated
		 */
		EClass QUICKFIX_PROPOSAL_PROCESSOR = eINSTANCE.getQuickfixProposalProcessor();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.QuickfixProposalProcessorContextImpl
		 * <em>Quickfix Proposal Processor Context</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.QuickfixProposalProcessorContextImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getQuickfixProposalProcessorContext()
		 * @generated
		 */
		EClass QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT = eINSTANCE.getQuickfixProposalProcessorContext();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT__MESSAGE = eINSTANCE
				.getQuickfixProposalProcessorContext_Message();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT__BINDING = eINSTANCE
				.getQuickfixProposalProcessorContext_Binding();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT__TEXT = eINSTANCE.getQuickfixProposalProcessorContext_Text();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.QuickfixProposalProcessorDescriptorImpl
		 * <em>Quickfix Proposal Processor Descriptor</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.QuickfixProposalProcessorDescriptorImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getQuickfixProposalProcessorDescriptor()
		 * @generated
		 */
		EClass QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR = eINSTANCE.getQuickfixProposalProcessorDescriptor();

		/**
		 * The meta object literal for the '<em><b>Model Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__MODEL_TYPE = eINSTANCE
				.getQuickfixProposalProcessorDescriptor_ModelType();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__FEATURE = eINSTANCE
				.getQuickfixProposalProcessorDescriptor_Feature();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__SOURCE = eINSTANCE
				.getQuickfixProposalProcessorDescriptor_Source();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__CODE = eINSTANCE
				.getQuickfixProposalProcessorDescriptor_Code();

		/**
		 * The meta object literal for the '<em><b>Message Pattern</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__MESSAGE_PATTERN = eINSTANCE
				.getQuickfixProposalProcessorDescriptor_MessagePattern();

		/**
		 * The meta object literal for the '<em><b>Processor</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__PROCESSOR = eINSTANCE
				.getQuickfixProposalProcessorDescriptor_Processor();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.TreeItemRelationImpl
		 * <em>Tree Item Relation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.TreeItemRelationImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getTreeItemRelation()
		 * @generated
		 */
		EClass TREE_ITEM_RELATION = eINSTANCE.getTreeItemRelation();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TREE_ITEM_RELATION__PARENT = eINSTANCE.getTreeItemRelation_Parent();

		/**
		 * The meta object literal for the '<em><b>Descriptor</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TREE_ITEM_RELATION__DESCRIPTOR = eINSTANCE.getTreeItemRelation_Descriptor();

		/**
		 * The meta object literal for the '<em><b>Processor</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TREE_ITEM_RELATION__PROCESSOR = eINSTANCE.getTreeItemRelation_Processor();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TREE_ITEM_RELATION__FEATURE_NAME = eINSTANCE.getTreeItemRelation_FeatureName();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TREE_ITEM_RELATION__PRIORITY = eINSTANCE.getTreeItemRelation_Priority();

		/**
		 * The meta object literal for the '<em><b>Tree IDs</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TREE_ITEM_RELATION__TREE_IDS = eINSTANCE.getTreeItemRelation_TreeIDs();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.TreeItemDescriptorImpl
		 * <em>Tree Item Descriptor</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.TreeItemDescriptorImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getTreeItemDescriptor()
		 * @generated
		 */
		EClass TREE_ITEM_DESCRIPTOR = eINSTANCE.getTreeItemDescriptor();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TREE_ITEM_DESCRIPTOR__ID = eINSTANCE.getTreeItemDescriptor_Id();

		/**
		 * The meta object literal for the '<em><b>Child Relations</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TREE_ITEM_DESCRIPTOR__CHILD_RELATIONS = eINSTANCE.getTreeItemDescriptor_ChildRelations();

		/**
		 * The meta object literal for the '<em><b>Ce</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TREE_ITEM_DESCRIPTOR__CE = eINSTANCE.getTreeItemDescriptor_Ce();

		/**
		 * The meta object literal for the '<em><b>Model Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TREE_ITEM_DESCRIPTOR__MODEL_TYPES = eINSTANCE.getTreeItemDescriptor_ModelTypes();

		/**
		 * The meta object literal for the '<em><b>New Wizard ID</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TREE_ITEM_DESCRIPTOR__NEW_WIZARD_ID = eINSTANCE.getTreeItemDescriptor_NewWizardID();

		/**
		 * The meta object literal for the '<em><b>Parent Relations</b></em>' reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TREE_ITEM_DESCRIPTOR__PARENT_RELATIONS = eINSTANCE.getTreeItemDescriptor_ParentRelations();

		/**
		 * The meta object literal for the '<em><b>Primary Parent</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TREE_ITEM_DESCRIPTOR__PRIMARY_PARENT = eINSTANCE.getTreeItemDescriptor_PrimaryParent();

		/**
		 * The meta object literal for the '<em><b>Empty Folder Hidden</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TREE_ITEM_DESCRIPTOR__EMPTY_FOLDER_HIDDEN = eINSTANCE.getTreeItemDescriptor_EmptyFolderHidden();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.ConstantTreeItemImpl
		 * <em>Constant Tree Item</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.ConstantTreeItemImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getConstantTreeItem()
		 * @generated
		 */
		EClass CONSTANT_TREE_ITEM = eINSTANCE.getConstantTreeItem();

		/**
		 * The meta object literal for the '<em><b>Descriptor</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTANT_TREE_ITEM__DESCRIPTOR = eINSTANCE.getConstantTreeItem_Descriptor();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTANT_TREE_ITEM__TARGET = eINSTANCE.getConstantTreeItem_Target();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.BindingMessageImpl <em>Binding Message</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.BindingMessageImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getBindingMessage()
		 * @generated
		 */
		EClass BINDING_MESSAGE = eINSTANCE.getBindingMessage();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING_MESSAGE__BINDING = eINSTANCE.getBindingMessage_Binding();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_MESSAGE__MESSAGE = eINSTANCE.getBindingMessage_Message();

		/**
		 * The meta object literal for the '<em><b>Message Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_MESSAGE__MESSAGE_TYPE = eINSTANCE.getBindingMessage_MessageType();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_MESSAGE__SEVERITY = eINSTANCE.getBindingMessage_Severity();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_MESSAGE__PREFIX = eINSTANCE.getBindingMessage_Prefix();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING_MESSAGE__TARGETS = eINSTANCE.getBindingMessage_Targets();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_MESSAGE__DATA = eINSTANCE.getBindingMessage_Data();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_MESSAGE__SOURCE = eINSTANCE.getBindingMessage_Source();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_MESSAGE__CODE = eINSTANCE.getBindingMessage_Code();

		/**
		 * The meta object literal for the '<em><b>Details</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_MESSAGE__DETAILS = eINSTANCE.getBindingMessage_Details();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.BindingMessageTargetImpl
		 * <em>Binding Message Target</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.BindingMessageTargetImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getBindingMessageTarget()
		 * @generated
		 */
		EClass BINDING_MESSAGE_TARGET = eINSTANCE.getBindingMessageTarget();

		/**
		 * The meta object literal for the '<em><b>Model Object</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING_MESSAGE_TARGET__MODEL_OBJECT = eINSTANCE.getBindingMessageTarget_ModelObject();

		/**
		 * The meta object literal for the '<em><b>Model Feature</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING_MESSAGE_TARGET__MODEL_FEATURE = eINSTANCE.getBindingMessageTarget_ModelFeature();

		/**
		 * The meta object literal for the '<em><b>Model Key</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING_MESSAGE_TARGET__MODEL_KEY = eINSTANCE.getBindingMessageTarget_ModelKey();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.UIAttributeImpl <em>UI Attribute</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.UIAttributeImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUIAttribute()
		 * @generated
		 */
		EClass UI_ATTRIBUTE = eINSTANCE.getUIAttribute();

		/**
		 * The meta object literal for the '<em><b>Widget</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__WIDGET = eINSTANCE.getUIAttribute_Widget();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__ATTRIBUTE = eINSTANCE.getUIAttribute_Attribute();

		/**
		 * The meta object literal for the '<em><b>Current Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__CURRENT_VALUE = eINSTANCE.getUIAttribute_CurrentValue();

		/**
		 * The meta object literal for the '<em><b>Possible Values List</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__POSSIBLE_VALUES_LIST = eINSTANCE.getUIAttribute_PossibleValuesList();

		/**
		 * The meta object literal for the '<em><b>Min Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__MIN_VALUE = eINSTANCE.getUIAttribute_MinValue();

		/**
		 * The meta object literal for the '<em><b>Max Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__MAX_VALUE = eINSTANCE.getUIAttribute_MaxValue();

		/**
		 * The meta object literal for the '<em><b>Tooltip Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__TOOLTIP_VALUE = eINSTANCE.getUIAttribute_TooltipValue();

		/**
		 * The meta object literal for the '<em><b>Font Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__FONT_VALUE = eINSTANCE.getUIAttribute_FontValue();

		/**
		 * The meta object literal for the '<em><b>Image Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__IMAGE_VALUE = eINSTANCE.getUIAttribute_ImageValue();

		/**
		 * The meta object literal for the '<em><b>Foreground Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__FOREGROUND_VALUE = eINSTANCE.getUIAttribute_ForegroundValue();

		/**
		 * The meta object literal for the '<em><b>Background Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__BACKGROUND_VALUE = eINSTANCE.getUIAttribute_BackgroundValue();

		/**
		 * The meta object literal for the '<em><b>Enabled Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__ENABLED_VALUE = eINSTANCE.getUIAttribute_EnabledValue();

		/**
		 * The meta object literal for the '<em><b>Cursor Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__CURSOR_VALUE = eINSTANCE.getUIAttribute_CursorValue();

		/**
		 * The meta object literal for the '<em><b>Style Range List</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__STYLE_RANGE_LIST = eINSTANCE.getUIAttribute_StyleRangeList();

		/**
		 * The meta object literal for the '<em><b>Changeable</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__CHANGEABLE = eINSTANCE.getUIAttribute_Changeable();

		/**
		 * The meta object literal for the '<em><b>Field Assist Adapter</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__FIELD_ASSIST_ADAPTER = eINSTANCE.getUIAttribute_FieldAssistAdapter();

		/**
		 * The meta object literal for the '<em><b>Field Assist Control</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE__FIELD_ASSIST_CONTROL = eINSTANCE.getUIAttribute_FieldAssistControl();

		/**
		 * The meta object literal for the '<em><b>Image Decorations</b></em>' containment reference
		 * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference UI_ATTRIBUTE__IMAGE_DECORATIONS = eINSTANCE.getUIAttribute_ImageDecorations();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.UIAttributeImageDecorationImpl
		 * <em>UI Attribute Image Decoration</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.UIAttributeImageDecorationImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUIAttributeImageDecoration()
		 * @generated
		 */
		EClass UI_ATTRIBUTE_IMAGE_DECORATION = eINSTANCE.getUIAttributeImageDecoration();

		/**
		 * The meta object literal for the '<em><b>Outside</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE_IMAGE_DECORATION__OUTSIDE = eINSTANCE.getUIAttributeImageDecoration_Outside();

		/**
		 * The meta object literal for the '<em><b>Image Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE_IMAGE_DECORATION__IMAGE_VALUE = eINSTANCE.getUIAttributeImageDecoration_ImageValue();

		/**
		 * The meta object literal for the '<em><b>Tooltip Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE_IMAGE_DECORATION__TOOLTIP_VALUE = eINSTANCE
				.getUIAttributeImageDecoration_TooltipValue();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE_IMAGE_DECORATION__POSITION = eINSTANCE.getUIAttributeImageDecoration_Position();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference UI_ATTRIBUTE_IMAGE_DECORATION__ATTRIBUTE = eINSTANCE.getUIAttributeImageDecoration_Attribute();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.IUIAttributeFactory
		 * <em>UI Attribute Factory</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.IUIAttributeFactory
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUIAttributeFactory()
		 * @generated
		 */
		EClass UI_ATTRIBUTE_FACTORY = eINSTANCE.getUIAttributeFactory();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.UIAttributeFactoryDescriptorImpl
		 * <em>UI Attribute Factory Descriptor</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.UIAttributeFactoryDescriptorImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUIAttributeFactoryDescriptor()
		 * @generated
		 */
		EClass UI_ATTRIBUTE_FACTORY_DESCRIPTOR = eINSTANCE.getUIAttributeFactoryDescriptor();

		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE_FACTORY_DESCRIPTOR__TYPE_NAME = eINSTANCE.getUIAttributeFactoryDescriptor_TypeName();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE_FACTORY_DESCRIPTOR__ATTRIBUTE = eINSTANCE.getUIAttributeFactoryDescriptor_Attribute();

		/**
		 * The meta object literal for the '<em><b>Factory</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UI_ATTRIBUTE_FACTORY_DESCRIPTOR__FACTORY = eINSTANCE.getUIAttributeFactoryDescriptor_Factory();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.internal.EMFObservableFactoryDescriptorImpl
		 * <em>EMF Observable Factory Descriptor</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.internal.EMFObservableFactoryDescriptorImpl
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getEMFObservableFactoryDescriptor()
		 * @generated
		 */
		EClass EMF_OBSERVABLE_FACTORY_DESCRIPTOR = eINSTANCE.getEMFObservableFactoryDescriptor();

		/**
		 * The meta object literal for the '<em><b>Package Prefix</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EMF_OBSERVABLE_FACTORY_DESCRIPTOR__PACKAGE_PREFIX = eINSTANCE
				.getEMFObservableFactoryDescriptor_PackagePrefix();

		/**
		 * The meta object literal for the '<em><b>Factory</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EMF_OBSERVABLE_FACTORY_DESCRIPTOR__FACTORY = eINSTANCE.getEMFObservableFactoryDescriptor_Factory();

		/**
		 * The meta object literal for the '{@link org.eclipse.ui.forms.IMessage <em>IMessage</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.ui.forms.IMessage
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIMessage()
		 * @generated
		 */
		EClass IMESSAGE = eINSTANCE.getIMessage();

		/**
		 * The meta object literal for the '{@link org.eclipse.jface.fieldassist.IContentProposal
		 * <em>IContent Proposal</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.jface.fieldassist.IContentProposal
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIContentProposal()
		 * @generated
		 */
		EClass ICONTENT_PROPOSAL = eINSTANCE.getIContentProposal();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.BindingState
		 * <em>Binding State</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.BindingState
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getBindingState()
		 * @generated
		 */
		EEnum BINDING_STATE = eINSTANCE.getBindingState();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.DecorationPosition
		 * <em>Decoration Position</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.DecorationPosition
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getDecorationPosition()
		 * @generated
		 */
		EEnum DECORATION_POSITION = eINSTANCE.getDecorationPosition();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.TextCommitStrategy
		 * <em>Text Commit Strategy</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.TextCommitStrategy
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getTextCommitStrategy()
		 * @generated
		 */
		EEnum TEXT_COMMIT_STRATEGY = eINSTANCE.getTextCommitStrategy();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.SpecialBinding
		 * <em>Special Binding</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.SpecialBinding
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getSpecialBinding()
		 * @generated
		 */
		EEnum SPECIAL_BINDING = eINSTANCE.getSpecialBinding();

		/**
		 * The meta object literal for the '{@link com.rcpcompany.uibindings.BindingMessageSeverity
		 * <em>Binding Message Severity</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.BindingMessageSeverity
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getBindingMessageSeverity()
		 * @generated
		 */
		EEnum BINDING_MESSAGE_SEVERITY = eINSTANCE.getBindingMessageSeverity();

		/**
		 * The meta object literal for the '<em>IBinding Context Finalizer</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.IBindingContextFinalizer
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIBindingContextFinalizer()
		 * @generated
		 */
		EDataType IBINDING_CONTEXT_FINALIZER = eINSTANCE.getIBindingContextFinalizer();

		/**
		 * The meta object literal for the '<em>UI Attribute Painter</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.uiAttributes.UIAttributePainter
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUIAttributePainter()
		 * @generated
		 */
		EDataType UI_ATTRIBUTE_PAINTER = eINSTANCE.getUIAttributePainter();

		/**
		 * The meta object literal for the '<em>IEMF Observable Factory</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.IEMFObservableFactory
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIEMFObservableFactory()
		 * @generated
		 */
		EDataType IEMF_OBSERVABLE_FACTORY = eINSTANCE.getIEMFObservableFactory();

		/**
		 * The meta object literal for the '<em>CE Object Holder</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.utils.extensionpoints.CEObjectHolder
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getCEObjectHolder()
		 * @generated
		 */
		EDataType CE_OBJECT_HOLDER = eINSTANCE.getCEObjectHolder();

		/**
		 * The meta object literal for the '<em>CE Resource Holder</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.utils.extensionpoints.CEResourceHolder
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getCEResourceHolder()
		 * @generated
		 */
		EDataType CE_RESOURCE_HOLDER = eINSTANCE.getCEResourceHolder();

		/**
		 * The meta object literal for the '<em>IFormatter Provider</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.IFormatterProvider
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIFormatterProvider()
		 * @generated
		 */
		EDataType IFORMATTER_PROVIDER = eINSTANCE.getIFormatterProvider();

		/**
		 * The meta object literal for the '<em>DB Context</em>' data type. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.core.databinding.DataBindingContext
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getDBContext()
		 * @generated
		 */
		EDataType DB_CONTEXT = eINSTANCE.getDBContext();

		/**
		 * The meta object literal for the '<em>DB Binding</em>' data type. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.core.databinding.Binding
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getDBBinding()
		 * @generated
		 */
		EDataType DB_BINDING = eINSTANCE.getDBBinding();

		/**
		 * The meta object literal for the '<em>Column Viewer</em>' data type. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.jface.viewers.ColumnViewer
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getColumnViewer()
		 * @generated
		 */
		EDataType COLUMN_VIEWER = eINSTANCE.getColumnViewer();

		/**
		 * The meta object literal for the '<em>Viewer Column</em>' data type. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.jface.viewers.ViewerColumn
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getViewerColumn()
		 * @generated
		 */
		EDataType VIEWER_COLUMN = eINSTANCE.getViewerColumn();

		/**
		 * The meta object literal for the '<em>Image Descriptor</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.jface.resource.ImageDescriptor
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getImageDescriptor()
		 * @generated
		 */
		EDataType IMAGE_DESCRIPTOR = eINSTANCE.getImageDescriptor();

		/**
		 * The meta object literal for the '<em>IControl Content Adapter</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.jface.fieldassist.IControlContentAdapter
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIControlContentAdapter()
		 * @generated
		 */
		EDataType ICONTROL_CONTENT_ADAPTER = eINSTANCE.getIControlContentAdapter();

		/**
		 * The meta object literal for the '<em>IService Locator</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.ui.services.IServiceLocator
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIServiceLocator()
		 * @generated
		 */
		EDataType ISERVICE_LOCATOR = eINSTANCE.getIServiceLocator();

		/**
		 * The meta object literal for the '<em>IConfiguration Element</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.core.runtime.IConfigurationElement
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIConfigurationElement()
		 * @generated
		 */
		EDataType ICONFIGURATION_ELEMENT = eINSTANCE.getIConfigurationElement();

		/**
		 * The meta object literal for the '<em>Pattern</em>' data type. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see java.util.regex.Pattern
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getPattern()
		 * @generated
		 */
		EDataType PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em>Throwable</em>' data type. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see java.lang.Throwable
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getThrowable()
		 * @generated
		 */
		EDataType THROWABLE = eINSTANCE.getThrowable();

		/**
		 * The meta object literal for the '<em>IObservable</em>' data type. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.core.databinding.observable.IObservable
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIObservable()
		 * @generated
		 */
		EDataType IOBSERVABLE = eINSTANCE.getIObservable();

		/**
		 * The meta object literal for the '<em>IObservable Value</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.core.databinding.observable.value.IObservableValue
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIObservableValue()
		 * @generated
		 */
		EDataType IOBSERVABLE_VALUE = eINSTANCE.getIObservableValue();

		/**
		 * The meta object literal for the '<em>IObservable List</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.core.databinding.observable.list.IObservableList
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIObservableList()
		 * @generated
		 */
		EDataType IOBSERVABLE_LIST = eINSTANCE.getIObservableList();

		/**
		 * The meta object literal for the '<em>IObservable Set</em>' data type. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.core.databinding.observable.set.IObservableSet
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIObservableSet()
		 * @generated
		 */
		EDataType IOBSERVABLE_SET = eINSTANCE.getIObservableSet();

		/**
		 * The meta object literal for the '<em>IObservable Factory</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.core.databinding.observable.masterdetail.IObservableFactory
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIObservableFactory()
		 * @generated
		 */
		EDataType IOBSERVABLE_FACTORY = eINSTANCE.getIObservableFactory();

		/**
		 * The meta object literal for the '<em>ISWT Observable Value</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.jface.databinding.swt.ISWTObservableValue
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getISWTObservableValue()
		 * @generated
		 */
		EDataType ISWT_OBSERVABLE_VALUE = eINSTANCE.getISWTObservableValue();

		/**
		 * The meta object literal for the '<em>IConverter</em>' data type. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.core.databinding.conversion.IConverter
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIConverter()
		 * @generated
		 */
		EDataType ICONVERTER = eINSTANCE.getIConverter();

		/**
		 * The meta object literal for the '<em>IValidator</em>' data type. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.core.databinding.validation.IValidator
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getIValidator()
		 * @generated
		 */
		EDataType IVALIDATOR = eINSTANCE.getIValidator();

		/**
		 * The meta object literal for the '<em>Editing Domain</em>' data type. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.edit.domain.EditingDomain
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getEditingDomain()
		 * @generated
		 */
		EDataType EDITING_DOMAIN = eINSTANCE.getEditingDomain();

		/**
		 * The meta object literal for the '<em>Widget</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.swt.widgets.Widget
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getWidget()
		 * @generated
		 */
		EDataType WIDGET = eINSTANCE.getWidget();

		/**
		 * The meta object literal for the '<em>Form Toolkit</em>' data type. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.ui.forms.widgets.FormToolkit
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getFormToolkit()
		 * @generated
		 */
		EDataType FORM_TOOLKIT = eINSTANCE.getFormToolkit();

		/**
		 * The meta object literal for the '<em>Control</em>' data type. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.swt.widgets.Control
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getControl()
		 * @generated
		 */
		EDataType CONTROL = eINSTANCE.getControl();

		/**
		 * The meta object literal for the '<em>Composite</em>' data type. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.swt.widgets.Composite
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getComposite()
		 * @generated
		 */
		EDataType COMPOSITE = eINSTANCE.getComposite();

		/**
		 * The meta object literal for the '<em>Table</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.swt.widgets.Table
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getTable()
		 * @generated
		 */
		EDataType TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em>Table Column</em>' data type. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.swt.widgets.TableColumn
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getTableColumn()
		 * @generated
		 */
		EDataType TABLE_COLUMN = eINSTANCE.getTableColumn();

		/**
		 * The meta object literal for the '<em>Tree</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.swt.widgets.Tree
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getTree()
		 * @generated
		 */
		EDataType TREE = eINSTANCE.getTree();

		/**
		 * The meta object literal for the '<em>Tree Column</em>' data type. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.swt.widgets.TreeColumn
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getTreeColumn()
		 * @generated
		 */
		EDataType TREE_COLUMN = eINSTANCE.getTreeColumn();

		/**
		 * The meta object literal for the '<em>Clipboard</em>' data type. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.swt.dnd.Clipboard
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getClipboard()
		 * @generated
		 */
		EDataType CLIPBOARD = eINSTANCE.getClipboard();

		/**
		 * The meta object literal for the '<em>Image</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.swt.graphics.Image
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getImage()
		 * @generated
		 */
		EDataType IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '<em>Color</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.swt.graphics.Color
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getColor()
		 * @generated
		 */
		EDataType COLOR = eINSTANCE.getColor();

		/**
		 * The meta object literal for the '<em>Cursor</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.swt.graphics.Cursor
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getCursor()
		 * @generated
		 */
		EDataType CURSOR = eINSTANCE.getCursor();

		/**
		 * The meta object literal for the '<em>Selection Listener</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.swt.events.SelectionListener
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getSelectionListener()
		 * @generated
		 */
		EDataType SELECTION_LISTENER = eINSTANCE.getSelectionListener();

		/**
		 * The meta object literal for the '<em>Update Value Strategy</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.core.databinding.UpdateValueStrategy
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUpdateValueStrategy()
		 * @generated
		 */
		EDataType UPDATE_VALUE_STRATEGY = eINSTANCE.getUpdateValueStrategy();

		/**
		 * The meta object literal for the '<em>Update List Strategy</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.core.databinding.UpdateListStrategy
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUpdateListStrategy()
		 * @generated
		 */
		EDataType UPDATE_LIST_STRATEGY = eINSTANCE.getUpdateListStrategy();

		/**
		 * The meta object literal for the '<em>Update Set Strategy</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.core.databinding.UpdateSetStrategy
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getUpdateSetStrategy()
		 * @generated
		 */
		EDataType UPDATE_SET_STRATEGY = eINSTANCE.getUpdateSetStrategy();

		/**
		 * The meta object literal for the '<em>Number Format</em>' data type. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.icu.text.NumberFormat
		 * @see com.rcpcompany.uibindings.internal.UIBindingsPackageImpl#getNumberFormat()
		 * @generated
		 */
		EDataType NUMBER_FORMAT = eINSTANCE.getNumberFormat();

	}

} // IUIBindingsPackage
