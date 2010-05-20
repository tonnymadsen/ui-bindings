/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.DecorationPosition;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingMessageTarget;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IColumnBindingCellInformation;
import com.rcpcompany.uibindings.IConstantTreeItem;
import com.rcpcompany.uibindings.IEMFObservableFactoryDescriptor;
import com.rcpcompany.uibindings.IEnumDecoratorProvider;
import com.rcpcompany.uibindings.IEnumDecoratorProviderEntry;
import com.rcpcompany.uibindings.IJavaDecoratorProvider;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IModelClassInfo;
import com.rcpcompany.uibindings.IModelFeatureInfo;
import com.rcpcompany.uibindings.IModelInfo;
import com.rcpcompany.uibindings.INumberDecoratorProvider;
import com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor;
import com.rcpcompany.uibindings.ITreeItemDescriptor;
import com.rcpcompany.uibindings.ITreeItemRelation;
import com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor;
import com.rcpcompany.uibindings.IUIAttributeImageDecoration;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor;
import com.rcpcompany.uibindings.IUIBindingsFactory;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.SpecialBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class UIBindingsFactoryImpl extends EFactoryImpl implements IUIBindingsFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static IUIBindingsFactory init() {
		try {
			final IUIBindingsFactory theUIBindingsFactory = (IUIBindingsFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://rcp-company.com/schemas/uibindings/model.ecore"); //$NON-NLS-1$ 
			if (theUIBindingsFactory != null) {
				return theUIBindingsFactory;
			}
		} catch (final Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UIBindingsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UIBindingsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case IUIBindingsPackage.MANAGER:
			return createManager();
		case IUIBindingsPackage.BINDING_CONTEXT:
			return createBindingContext();
		case IUIBindingsPackage.VALUE_BINDING:
			return createValueBinding();
		case IUIBindingsPackage.COLUMN_BINDING:
			return createColumnBinding();
		case IUIBindingsPackage.COLUMN_BINDING_CELL_INFORMATION:
			return createColumnBindingCellInformation();
		case IUIBindingsPackage.VIEWER_BINDING:
			return createViewerBinding();
		case IUIBindingsPackage.JAVA_DECORATOR_PROVIDER:
			return createJavaDecoratorProvider();
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER:
			return createEnumDecoratorProvider();
		case IUIBindingsPackage.ENUM_DECORATOR_PROVIDER_ENTRY:
			return createEnumDecoratorProviderEntry();
		case IUIBindingsPackage.NUMBER_DECORATOR_PROVIDER:
			return createNumberDecoratorProvider();
		case IUIBindingsPackage.MODEL_INFO:
			return createModelInfo();
		case IUIBindingsPackage.MODEL_CLASS_INFO:
			return createModelClassInfo();
		case IUIBindingsPackage.MODEL_FEATURE_INFO:
			return createModelFeatureInfo();
		case IUIBindingsPackage.UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR:
			return createUIBindingDecoratorExtenderDescriptor();
		case IUIBindingsPackage.STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY:
			return (EObject) createStringToModelClassInfoMapEntry();
		case IUIBindingsPackage.STRING_TO_MODEL_FEATURE_INFO_MAP_ENTRY:
			return (EObject) createStringToModelFeatureInfoMapEntry();
		case IUIBindingsPackage.STRING_TO_STRING_MAP_ENTRY:
			return (EObject) createStringToStringMapEntry();
		case IUIBindingsPackage.STRING_TO_OBJECT_MAP_ENTRY:
			return (EObject) createStringToObjectMapEntry();
		case IUIBindingsPackage.STRING_TO_IMAGE_DESCRIPTOR_MAP_ENTRY:
			return (EObject) createStringToImageDescriptorMapEntry();
		case IUIBindingsPackage.STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY:
			return (EObject) createStringToIConfigurationElementMapEntry();
		case IUIBindingsPackage.STRING_TO_BOOLEAN_MAP_ENTRY:
			return (EObject) createStringToBooleanMapEntry();
		case IUIBindingsPackage.OBJECT_TO_CI_MAP_ENTRY:
			return (EObject) createObjectToCIMapEntry();
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR:
			return createQuickfixProposalProcessorDescriptor();
		case IUIBindingsPackage.TREE_ITEM_RELATION:
			return createTreeItemRelation();
		case IUIBindingsPackage.TREE_ITEM_DESCRIPTOR:
			return createTreeItemDescriptor();
		case IUIBindingsPackage.CONSTANT_TREE_ITEM:
			return createConstantTreeItem();
		case IUIBindingsPackage.BINDING_MESSAGE_TARGET:
			return createBindingMessageTarget();
		case IUIBindingsPackage.UI_ATTRIBUTE_IMAGE_DECORATION:
			return createUIAttributeImageDecoration();
		case IUIBindingsPackage.UI_ATTRIBUTE_FACTORY_DESCRIPTOR:
			return createUIAttributeFactoryDescriptor();
		case IUIBindingsPackage.EMF_OBSERVABLE_FACTORY_DESCRIPTOR:
			return createEMFObservableFactoryDescriptor();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case IUIBindingsPackage.BINDING_STATE:
			return createBindingStateFromString(eDataType, initialValue);
		case IUIBindingsPackage.DECORATION_POSITION:
			return createDecorationPositionFromString(eDataType, initialValue);
		case IUIBindingsPackage.TEXT_COMMIT_STRATEGY:
			return createTextCommitStrategyFromString(eDataType, initialValue);
		case IUIBindingsPackage.SPECIAL_BINDING:
			return createSpecialBindingFromString(eDataType, initialValue);
		case IUIBindingsPackage.BINDING_MESSAGE_SEVERITY:
			return createBindingMessageSeverityFromString(eDataType, initialValue);
		case IUIBindingsPackage.FORM_TOOLKIT:
			return createFormToolkitFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case IUIBindingsPackage.BINDING_STATE:
			return convertBindingStateToString(eDataType, instanceValue);
		case IUIBindingsPackage.DECORATION_POSITION:
			return convertDecorationPositionToString(eDataType, instanceValue);
		case IUIBindingsPackage.TEXT_COMMIT_STRATEGY:
			return convertTextCommitStrategyToString(eDataType, instanceValue);
		case IUIBindingsPackage.SPECIAL_BINDING:
			return convertSpecialBindingToString(eDataType, instanceValue);
		case IUIBindingsPackage.BINDING_MESSAGE_SEVERITY:
			return convertBindingMessageSeverityToString(eDataType, instanceValue);
		case IUIBindingsPackage.FORM_TOOLKIT:
			return convertFormToolkitToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IManager createManager() {
		final ManagerImpl manager = new ManagerImpl();
		return manager;
	}

	private IManager theManager = null;

	@Override
	public IManager getManager() {
		if (theManager == null) {
			theManager = createManager();
		}
		return theManager;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IBindingContext createBindingContext() {
		final BindingContextImpl bindingContext = new BindingContextImpl();
		return bindingContext;
	}

	@Override
	public IBindingContext createBindingContext(Composite top) {
		final BindingContextImpl context = new BindingContextImpl();
		context.setTop(top);
		return context;
	}

	@Override
	public IBindingContext createBindingContext(WizardPage top) {
		final BindingContextImpl context = new BindingContextImpl();
		context.setTop(top);
		return context;
	}

	@Override
	public IBindingContext createBindingContext(ScrolledForm top) {
		final BindingContextImpl context = new BindingContextImpl();
		context.setTop(top);
		return context;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IValueBinding createValueBinding() {
		final ValueBindingImpl valueBinding = new ValueBindingImpl();
		return valueBinding;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IColumnBinding createColumnBinding() {
		final ColumnBindingImpl columnBinding = new ColumnBindingImpl();
		return columnBinding;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IColumnBindingCellInformation createColumnBindingCellInformation() {
		final ColumnBindingCellInformationImpl columnBindingCellInformation = new ColumnBindingCellInformationImpl();
		return columnBindingCellInformation;
	}

	@Override
	public IColumnBindingCellInformation createColumnBindingCellInformation(IColumnBinding column, Object element) {
		final ColumnBindingCellInformationImpl ci = new ColumnBindingCellInformationImpl();
		ci.init(column, element);
		return ci;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IViewerBinding createViewerBinding() {
		final ViewerBindingImpl viewerBinding = new ViewerBindingImpl();
		return viewerBinding;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IJavaDecoratorProvider createJavaDecoratorProvider() {
		final JavaDecoratorProviderImpl javaDecoratorProvider = new JavaDecoratorProviderImpl();
		return javaDecoratorProvider;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IEnumDecoratorProvider createEnumDecoratorProvider() {
		final EnumDecoratorProviderImpl enumDecoratorProvider = new EnumDecoratorProviderImpl();
		return enumDecoratorProvider;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IEnumDecoratorProviderEntry createEnumDecoratorProviderEntry() {
		final EnumDecoratorProviderEntryImpl enumDecoratorProviderEntry = new EnumDecoratorProviderEntryImpl();
		return enumDecoratorProviderEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public INumberDecoratorProvider createNumberDecoratorProvider() {
		final NumberDecoratorProviderImpl numberDecoratorProvider = new NumberDecoratorProviderImpl();
		return numberDecoratorProvider;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IModelInfo createModelInfo() {
		final ModelInfoImpl modelInfo = new ModelInfoImpl();
		return modelInfo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IModelClassInfo createModelClassInfo() {
		final ModelClassInfoImpl modelClassInfo = new ModelClassInfoImpl();
		return modelClassInfo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IModelFeatureInfo createModelFeatureInfo() {
		final ModelFeatureInfoImpl modelFeatureInfo = new ModelFeatureInfoImpl();
		return modelFeatureInfo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IUIBindingDecoratorExtenderDescriptor createUIBindingDecoratorExtenderDescriptor() {
		final UIBindingDecoratorExtenderDescriptorImpl uiBindingDecoratorExtenderDescriptor = new UIBindingDecoratorExtenderDescriptorImpl();
		return uiBindingDecoratorExtenderDescriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map.Entry<String, IModelClassInfo> createStringToModelClassInfoMapEntry() {
		final StringToModelClassInfoMapEntryImpl stringToModelClassInfoMapEntry = new StringToModelClassInfoMapEntryImpl();
		return stringToModelClassInfoMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map.Entry<String, IModelFeatureInfo> createStringToModelFeatureInfoMapEntry() {
		final StringToModelFeatureInfoMapEntryImpl stringToModelFeatureInfoMapEntry = new StringToModelFeatureInfoMapEntryImpl();
		return stringToModelFeatureInfoMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map.Entry<String, String> createStringToStringMapEntry() {
		final StringToStringMapEntryImpl stringToStringMapEntry = new StringToStringMapEntryImpl();
		return stringToStringMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map.Entry<String, Object> createStringToObjectMapEntry() {
		final StringToObjectMapEntryImpl stringToObjectMapEntry = new StringToObjectMapEntryImpl();
		return stringToObjectMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map.Entry<String, ImageDescriptor> createStringToImageDescriptorMapEntry() {
		final StringToImageDescriptorMapEntryImpl stringToImageDescriptorMapEntry = new StringToImageDescriptorMapEntryImpl();
		return stringToImageDescriptorMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map.Entry<String, IConfigurationElement> createStringToIConfigurationElementMapEntry() {
		final StringToIConfigurationElementMapEntryImpl stringToIConfigurationElementMapEntry = new StringToIConfigurationElementMapEntryImpl();
		return stringToIConfigurationElementMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map.Entry<String, Boolean> createStringToBooleanMapEntry() {
		final StringToBooleanMapEntryImpl stringToBooleanMapEntry = new StringToBooleanMapEntryImpl();
		return stringToBooleanMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map.Entry<EObject, IColumnBindingCellInformation> createObjectToCIMapEntry() {
		final ObjectToCIMapEntryImpl objectToCIMapEntry = new ObjectToCIMapEntryImpl();
		return objectToCIMapEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IQuickfixProposalProcessorDescriptor createQuickfixProposalProcessorDescriptor() {
		final QuickfixProposalProcessorDescriptorImpl quickfixProposalProcessorDescriptor = new QuickfixProposalProcessorDescriptorImpl();
		return quickfixProposalProcessorDescriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ITreeItemRelation createTreeItemRelation() {
		final TreeItemRelationImpl treeItemRelation = new TreeItemRelationImpl();
		return treeItemRelation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ITreeItemDescriptor createTreeItemDescriptor() {
		final TreeItemDescriptorImpl treeItemDescriptor = new TreeItemDescriptorImpl();
		return treeItemDescriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IConstantTreeItem createConstantTreeItem() {
		final ConstantTreeItemImpl constantTreeItem = new ConstantTreeItemImpl();
		return constantTreeItem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IBindingMessageTarget createBindingMessageTarget() {
		final BindingMessageTargetImpl bindingMessageTarget = new BindingMessageTargetImpl();
		return bindingMessageTarget;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IUIAttributeImageDecoration createUIAttributeImageDecoration() {
		final UIAttributeImageDecorationImpl uiAttributeImageDecoration = new UIAttributeImageDecorationImpl();
		return uiAttributeImageDecoration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IUIAttributeFactoryDescriptor createUIAttributeFactoryDescriptor() {
		final UIAttributeFactoryDescriptorImpl uiAttributeFactoryDescriptor = new UIAttributeFactoryDescriptorImpl();
		return uiAttributeFactoryDescriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IEMFObservableFactoryDescriptor createEMFObservableFactoryDescriptor() {
		final EMFObservableFactoryDescriptorImpl emfObservableFactoryDescriptor = new EMFObservableFactoryDescriptorImpl();
		return emfObservableFactoryDescriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BindingState createBindingStateFromString(EDataType eDataType, String initialValue) {
		final BindingState result = BindingState.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertBindingStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DecorationPosition createDecorationPositionFromString(EDataType eDataType, String initialValue) {
		final DecorationPosition result = DecorationPosition.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertDecorationPositionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TextCommitStrategy createTextCommitStrategyFromString(EDataType eDataType, String initialValue) {
		final TextCommitStrategy result = TextCommitStrategy.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertTextCommitStrategyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SpecialBinding createSpecialBindingFromString(EDataType eDataType, String initialValue) {
		final SpecialBinding result = SpecialBinding.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertSpecialBindingToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BindingMessageSeverity createBindingMessageSeverityFromString(EDataType eDataType, String initialValue) {
		final BindingMessageSeverity result = BindingMessageSeverity.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertBindingMessageSeverityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FormToolkit createFormToolkitFromString(EDataType eDataType, String initialValue) {
		return (FormToolkit) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertFormToolkitToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IUIBindingsPackage getUIBindingsPackage() {
		return (IUIBindingsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IUIBindingsPackage getPackage() {
		return IUIBindingsPackage.eINSTANCE;
	}
} // UIBindingsFactoryImpl
