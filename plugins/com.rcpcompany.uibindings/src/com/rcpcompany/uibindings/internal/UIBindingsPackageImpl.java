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
package com.rcpcompany.uibindings.internal;

import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateListStrategy;
import org.eclipse.core.databinding.UpdateSetStrategy;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.IMessage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.services.IServiceLocator;

import com.ibm.icu.text.NumberFormat;
import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.ContainerCellType;
import com.rcpcompany.uibindings.DecorationPosition;
import com.rcpcompany.uibindings.IArgumentInformation;
import com.rcpcompany.uibindings.IArgumentProvider;
import com.rcpcompany.uibindings.IAssignmentParticipantDescriptor;
import com.rcpcompany.uibindings.IAssignmentParticipantsManager;
import com.rcpcompany.uibindings.IBaseObject;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingContextFinalizer;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IBindingMessageTarget;
import com.rcpcompany.uibindings.IColumnAdapter;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IColumnBindingCellInformation;
import com.rcpcompany.uibindings.IConstantTreeItem;
import com.rcpcompany.uibindings.IContainerBinding;
import com.rcpcompany.uibindings.IDecoratorProvider;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IEMFObservableFactory;
import com.rcpcompany.uibindings.IEMFObservableFactoryDescriptor;
import com.rcpcompany.uibindings.IEnumDecoratorProvider;
import com.rcpcompany.uibindings.IEnumDecoratorProviderEntry;
import com.rcpcompany.uibindings.IFormatterProvider;
import com.rcpcompany.uibindings.IJavaDecoratorProvider;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IModelArgumentMediator;
import com.rcpcompany.uibindings.IModelClassInfo;
import com.rcpcompany.uibindings.IModelFeatureInfo;
import com.rcpcompany.uibindings.IModelInfo;
import com.rcpcompany.uibindings.INumberDecoratorProvider;
import com.rcpcompany.uibindings.IQuickfixProposal;
import com.rcpcompany.uibindings.IQuickfixProposalProcessor;
import com.rcpcompany.uibindings.IQuickfixProposalProcessorContext;
import com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor;
import com.rcpcompany.uibindings.IServiceRegistry;
import com.rcpcompany.uibindings.ITreeItemDescriptor;
import com.rcpcompany.uibindings.ITreeItemRelation;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor;
import com.rcpcompany.uibindings.IUIAttributeImageDecoration;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor;
import com.rcpcompany.uibindings.IUIBindingsFactory;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.SpecialBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.participants.IAssignmentParticipant;
import com.rcpcompany.uibindings.uiAttributes.UIAttributePainter;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.IPersistentParty;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;
import com.rcpcompany.utils.extensionpoints.CEResourceHolder;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>.
 * 
 * $codepro.audit.disable <!-- end-user-doc -->
 * 
 * @generated
 */
public class UIBindingsPackageImpl extends EPackageImpl implements IUIBindingsPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass baseObjectEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass managerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass bindingContextEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass bindingEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass valueBindingEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass valueBindingCellEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass columnBindingEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass columnBindingCellInformationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass containerBindingEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass viewerBindingEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass argumentInformationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass decoratorProviderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass javaDecoratorProviderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass enumDecoratorProviderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass enumDecoratorProviderEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass numberDecoratorProviderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass bindingDataTypeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass columnAdapterEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass modelInfoEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass modelClassInfoEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass modelFeatureInfoEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass uiBindingDecoratorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass uiBindingDecoratorExtenderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass uiBindingDecoratorExtenderDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass assignmentParticipantsManagerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass assignmentParticipantDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iArgumentProviderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iDisposableEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iModelArgumentMediatorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iPersistentPartyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass constantsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stringToModelClassInfoMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stringToModelFeatureInfoMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stringToArgumentInformationMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stringToStringMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stringToObjectMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stringToImageDescriptorMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stringToIConfigurationElementMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stringToBooleanMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass objectToCIMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass serviceRegistryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass quickfixProposalEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass quickfixProposalProcessorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass quickfixProposalProcessorContextEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass quickfixProposalProcessorDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass treeItemRelationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass treeItemDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass constantTreeItemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass bindingMessageEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass bindingMessageTargetEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass uiAttributeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass uiAttributeImageDecorationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass uiAttributeFactoryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass uiAttributeFactoryDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass emfObservableFactoryDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iMessageEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iContentProposalEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum bindingStateEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum decorationPositionEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum textCommitStrategyEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum specialBindingEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum bindingMessageSeverityEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum containerCellTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iBindingContextFinalizerEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType uiAttributePainterEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iemfObservableFactoryEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iAssignmentParticipantEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType ceObjectHolderEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType ceResourceHolderEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iFormatterProviderEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType dbContextEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType dbBindingEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType columnViewerEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType viewerColumnEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType imageDescriptorEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iControlContentAdapterEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iServiceLocatorEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iConfigurationElementEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType patternEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType throwableEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iObservableEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iObservableValueEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iObservableListEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iObservableSetEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iObservableFactoryEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iswtObservableValueEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iConverterEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType iValidatorEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType editingDomainEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType widgetEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType formToolkitEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType formCreatorEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType controlEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType compositeEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType tableEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType tableColumnEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType treeEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType treeColumnEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType clipboardEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType imageEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType colorEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType cursorEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType selectionListenerEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType updateValueStrategyEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType updateListStrategyEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType updateSetStrategyEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType numberFormatEDataType = null;

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
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UIBindingsPackageImpl() {
		super(eNS_URI, IUIBindingsFactory.eINSTANCE);
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
	 * This method is used to initialize {@link IUIBindingsPackage#eINSTANCE} when that field is
	 * accessed. Clients should not invoke it directly. Instead, they should simply access that
	 * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IUIBindingsPackage init() {
		if (isInited) return (IUIBindingsPackage) EPackage.Registry.INSTANCE.getEPackage(IUIBindingsPackage.eNS_URI);

		// Obtain or create and register package
		final UIBindingsPackageImpl theUIBindingsPackage = (UIBindingsPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof UIBindingsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
				: new UIBindingsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUIBindingsPackage.createPackageContents();

		// Initialize created meta-data
		theUIBindingsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUIBindingsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IUIBindingsPackage.eNS_URI, theUIBindingsPackage);
		return theUIBindingsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getBaseObject() {
		return baseObjectEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getManager() {
		return managerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getManager_Providers() {
		return (EReference) managerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getManager_UiAttributeFactories() {
		return (EReference) managerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getManager_DecoratorExtenders() {
		return (EReference) managerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_ModelArgumentMediators() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_ModelArgumentMediatorClasses() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_TextCommitStrategy() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_TextCommitStrategyDelay() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_EditCellAnyKey() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_EditCellSingleClick() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_MessageDecorationPosition() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_MessageDecorationMinimumSeverity() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_AlternativeDecorationPosition() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_AutoApplySingleQuickfix() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_AlternateRowColors() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_ValidationErrorsAreFatal() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_ValidationDelay() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_ValidationDelayWindow() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_RequiredVBImageDecorationShown() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_AssistVBImageDecorationShown() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_QuickfixVBImageDecorationShown() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_ViewNavigationRecorded() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getManager_ModelInfo() {
		return (EReference) managerEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getManager_TreeItems() {
		return (EReference) managerEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_Clipboard() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getManager_ObservableFactories() {
		return (EReference) managerEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getManager_QuickfixProposalProcessors() {
		return (EReference) managerEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getManager_Contexts() {
		return (EReference) managerEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_FormatterProvider() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_DeleteHandlerCheckEnabled() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getManager_CommandIDs() {
		return (EReference) managerEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getManager_AssignmentParticiantsManager() {
		return (EReference) managerEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_EditingDomain() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getManager_FormToolkit() {
		return (EAttribute) managerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getManager_ArgumentInformation() {
		return (EReference) managerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getBindingContext() {
		return bindingContextEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getBindingContext_Bindings() {
		return (EReference) bindingContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getBindingContext_OkBindings() {
		return (EReference) bindingContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingContext_Top() {
		return (EAttribute) bindingContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingContext_DbContext() {
		return (EAttribute) bindingContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingContext_ServiceLocator() {
		return (EAttribute) bindingContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingContext_State() {
		return (EAttribute) bindingContextEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingContext_TextCommitStrategy() {
		return (EAttribute) bindingContextEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingContext_TextCommitStrategyCalculated() {
		return (EAttribute) bindingContextEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingContext_EditingDomain() {
		return (EAttribute) bindingContextEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingContext_Finalizers() {
		return (EAttribute) bindingContextEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getBinding() {
		return bindingEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getBinding_Context() {
		return (EReference) bindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBinding_State() {
		return (EAttribute) bindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBinding_Changeable() {
		return (EAttribute) bindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBinding_CreationPoint() {
		return (EAttribute) bindingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBinding_Id() {
		return (EAttribute) bindingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBinding_Type() {
		return (EAttribute) bindingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBinding_Label() {
		return (EAttribute) bindingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getBinding_StaticDataType() {
		return (EReference) bindingEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getBinding_DataType() {
		return (EReference) bindingEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getBinding_ModelEType() {
		return (EReference) bindingEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBinding_ModelType() {
		return (EAttribute) bindingEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBinding_UIType() {
		return (EAttribute) bindingEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBinding_DBBindings() {
		return (EAttribute) bindingEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBinding_MonitoredDBBindings() {
		return (EAttribute) bindingEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBinding_ErrorConditions() {
		return (EAttribute) bindingEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBinding_Widget() {
		return (EAttribute) bindingEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBinding_Control() {
		return (EAttribute) bindingEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getBinding_ExtraArgumentProviders() {
		return (EReference) bindingEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getValueBinding() {
		return valueBindingEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getValueBinding_ModelObservable() {
		return (EAttribute) valueBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getValueBinding_ModelObservableValue() {
		return (EAttribute) valueBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getValueBinding_ModelObject() {
		return (EReference) valueBindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getValueBinding_ModelFeature() {
		return (EReference) valueBindingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getValueBinding_DecoratorProvider() {
		return (EReference) valueBindingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getValueBinding_Decorator() {
		return (EReference) valueBindingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getValueBinding_UIAttribute() {
		return (EReference) valueBindingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getValueBinding_UIObservable() {
		return (EAttribute) valueBindingEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getValueBinding_Cell() {
		return (EReference) valueBindingEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getValueBinding_MessagePrefix() {
		return (EAttribute) valueBindingEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getValueBinding_Dynamic() {
		return (EAttribute) valueBindingEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getValueBindingCell() {
		return valueBindingCellEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getColumnBinding() {
		return columnBindingEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getColumnBinding_ViewerBinding() {
		return (EReference) columnBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnBinding_ViewerColumn() {
		return (EAttribute) columnBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getColumnBinding_ColumnAdapter() {
		return (EReference) columnBindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getColumnBinding_BaseColumn() {
		return (EReference) columnBindingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getColumnBinding_SubColumns() {
		return (EReference) columnBindingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getColumnBinding_Cells() {
		return (EReference) columnBindingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnBinding_SpecialBindingType() {
		return (EAttribute) columnBindingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnBinding_Factory() {
		return (EAttribute) columnBindingEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnBinding_Cursor() {
		return (EAttribute) columnBindingEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnBinding_ColumnVisibility() {
		return (EAttribute) columnBindingEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getColumnBindingCellInformation() {
		return columnBindingCellInformationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getColumnBindingCellInformation_Column() {
		return (EReference) columnBindingCellInformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getColumnBindingCellInformation_Element() {
		return (EReference) columnBindingCellInformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getColumnBindingCellInformation_LabelBinding() {
		return (EReference) columnBindingCellInformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getColumnBindingCellInformation_LabelUIAttribute() {
		return (EReference) columnBindingCellInformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnBindingCellInformation_LabelPainter() {
		return (EAttribute) columnBindingCellInformationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnBindingCellInformation_ObjectValue() {
		return (EAttribute) columnBindingCellInformationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnBindingCellInformation_SourceValue() {
		return (EAttribute) columnBindingCellInformationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnBindingCellInformation_Changeable() {
		return (EAttribute) columnBindingCellInformationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnBindingCellInformation_DisplayText() {
		return (EAttribute) columnBindingCellInformationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnBindingCellInformation_ValueType() {
		return (EAttribute) columnBindingCellInformationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnBindingCellInformation_ToolTipText() {
		return (EAttribute) columnBindingCellInformationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnBindingCellInformation_Enabled() {
		return (EAttribute) columnBindingCellInformationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getContainerBinding() {
		return containerBindingEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getContainerBinding_SingleSelection() {
		return (EAttribute) containerBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getViewerBinding() {
		return viewerBindingEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getViewerBinding_Columns() {
		return (EReference) viewerBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getViewerBinding_List() {
		return (EAttribute) viewerBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getViewerBinding_Elements() {
		return (EAttribute) viewerBindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getViewerBinding_MultipleSelection() {
		return (EAttribute) viewerBindingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getViewerBinding_Viewer() {
		return (EAttribute) viewerBindingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getViewerBinding_FirstTableColumnOffset() {
		return (EAttribute) viewerBindingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getArgumentInformation() {
		return argumentInformationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getArgumentInformation_Name() {
		return (EAttribute) argumentInformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getArgumentInformation_LookupParent() {
		return (EAttribute) argumentInformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getArgumentInformation_LookupAttributeTargetType() {
		return (EAttribute) argumentInformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getArgumentInformation_LookupAttributeContainingClass() {
		return (EAttribute) argumentInformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getArgumentInformation_LookupReferenceTargetType() {
		return (EAttribute) argumentInformationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getArgumentInformation_LookupReferenceContainingClass() {
		return (EAttribute) argumentInformationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getDecoratorProvider() {
		return decoratorProviderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getDecoratorProvider_Manager() {
		return (EReference) decoratorProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getDecoratorProvider_Id() {
		return (EAttribute) decoratorProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getDecoratorProvider_Type() {
		return (EAttribute) decoratorProviderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getDecoratorProvider_ModelTypes() {
		return (EAttribute) decoratorProviderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getDecoratorProvider_UiTypes() {
		return (EAttribute) decoratorProviderEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getDecoratorProvider_ProviderCE() {
		return (EAttribute) decoratorProviderEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getDecoratorProvider_ChildCE() {
		return (EAttribute) decoratorProviderEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getDecoratorProvider_Decorator() {
		return (EReference) decoratorProviderEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getDecoratorProvider_ExactModelTypeMatch() {
		return (EAttribute) decoratorProviderEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getJavaDecoratorProvider() {
		return javaDecoratorProviderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getEnumDecoratorProvider() {
		return enumDecoratorProviderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getEnumDecoratorProvider_AddingDefaultMappings() {
		return (EAttribute) enumDecoratorProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getEnumDecoratorProvider_BaseMappings() {
		return (EReference) enumDecoratorProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getEnumDecoratorProviderEntry() {
		return enumDecoratorProviderEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getEnumDecoratorProviderEntry_Model() {
		return (EAttribute) enumDecoratorProviderEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getEnumDecoratorProviderEntry_Ui() {
		return (EAttribute) enumDecoratorProviderEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getNumberDecoratorProvider() {
		return numberDecoratorProviderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getNumberDecoratorProvider_Format() {
		return (EAttribute) numberDecoratorProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getBindingDataType() {
		return bindingDataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingDataType_Name() {
		return (EAttribute) bindingDataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingDataType_ValueType() {
		return (EAttribute) bindingDataTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getBindingDataType_EType() {
		return (EReference) bindingDataTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingDataType_DataType() {
		return (EAttribute) bindingDataTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getBindingDataType_EAnnotation() {
		return (EReference) bindingDataTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getBindingDataType_ParentDataType() {
		return (EReference) bindingDataTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingDataType_Required() {
		return (EAttribute) bindingDataTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingDataType_Changeable() {
		return (EAttribute) bindingDataTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingDataType_Unsettable() {
		return (EAttribute) bindingDataTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingDataType_BaseType() {
		return (EAttribute) bindingDataTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getColumnAdapter() {
		return columnAdapterEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnAdapter_Widget() {
		return (EAttribute) columnAdapterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnAdapter_Text() {
		return (EAttribute) columnAdapterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnAdapter_Alignment() {
		return (EAttribute) columnAdapterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnAdapter_Image() {
		return (EAttribute) columnAdapterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnAdapter_Moveable() {
		return (EAttribute) columnAdapterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnAdapter_Resizable() {
		return (EAttribute) columnAdapterEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnAdapter_Width() {
		return (EAttribute) columnAdapterEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getColumnAdapter_ToolTipText() {
		return (EAttribute) columnAdapterEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getModelInfo() {
		return modelInfoEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getModelClassInfo() {
		return modelClassInfoEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getModelClassInfo_ClassName() {
		return (EAttribute) modelClassInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getModelClassInfo_Features() {
		return (EReference) modelClassInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getModelClassInfo_Types() {
		return (EReference) modelClassInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getModelFeatureInfo() {
		return modelFeatureInfoEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getModelFeatureInfo_FeatureName() {
		return (EAttribute) modelFeatureInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getModelFeatureInfo_Class() {
		return (EReference) modelFeatureInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getUIBindingDecorator() {
		return uiBindingDecoratorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getUIBindingDecorator_Binding() {
		return (EReference) uiBindingDecoratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIBindingDecorator_Changeable() {
		return (EAttribute) uiBindingDecoratorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIBindingDecorator_ModelToUIConverter() {
		return (EAttribute) uiBindingDecoratorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIBindingDecorator_UIToModelConverter() {
		return (EAttribute) uiBindingDecoratorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIBindingDecorator_UIToModelAfterConvertValidator() {
		return (EAttribute) uiBindingDecoratorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIBindingDecorator_ValidUIList() {
		return (EAttribute) uiBindingDecoratorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getUIBindingDecoratorExtender() {
		return uiBindingDecoratorExtenderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getUIBindingDecoratorExtenderDescriptor() {
		return uiBindingDecoratorExtenderDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIBindingDecoratorExtenderDescriptor_Priority() {
		return (EAttribute) uiBindingDecoratorExtenderDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIBindingDecoratorExtenderDescriptor_Factory() {
		return (EAttribute) uiBindingDecoratorExtenderDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getAssignmentParticipantsManager() {
		return assignmentParticipantsManagerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getAssignmentParticipantsManager_Participants() {
		return (EReference) assignmentParticipantsManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getAssignmentParticipantDescriptor() {
		return assignmentParticipantDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getAssignmentParticipantDescriptor_Manager() {
		return (EReference) assignmentParticipantDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getAssignmentParticipantDescriptor_Id() {
		return (EAttribute) assignmentParticipantDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getAssignmentParticipantDescriptor_SourceTypes() {
		return (EAttribute) assignmentParticipantDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getAssignmentParticipantDescriptor_DestinationTypes() {
		return (EAttribute) assignmentParticipantDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getAssignmentParticipantDescriptor_Participant() {
		return (EAttribute) assignmentParticipantDescriptorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getAssignmentParticipantDescriptor_ExactTypeMatch() {
		return (EAttribute) assignmentParticipantDescriptorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getIArgumentProvider() {
		return iArgumentProviderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getIDisposable() {
		return iDisposableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getIModelArgumentMediator() {
		return iModelArgumentMediatorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getIPersistentParty() {
		return iPersistentPartyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getConstants() {
		return constantsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getStringToModelClassInfoMapEntry() {
		return stringToModelClassInfoMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStringToModelClassInfoMapEntry_Key() {
		return (EAttribute) stringToModelClassInfoMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getStringToModelClassInfoMapEntry_Value() {
		return (EReference) stringToModelClassInfoMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getStringToModelFeatureInfoMapEntry() {
		return stringToModelFeatureInfoMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStringToModelFeatureInfoMapEntry_Key() {
		return (EAttribute) stringToModelFeatureInfoMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getStringToModelFeatureInfoMapEntry_Value() {
		return (EReference) stringToModelFeatureInfoMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getStringToArgumentInformationMapEntry() {
		return stringToArgumentInformationMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStringToArgumentInformationMapEntry_Key() {
		return (EAttribute) stringToArgumentInformationMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getStringToArgumentInformationMapEntry_Value() {
		return (EReference) stringToArgumentInformationMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getStringToStringMapEntry() {
		return stringToStringMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStringToStringMapEntry_Key() {
		return (EAttribute) stringToStringMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStringToStringMapEntry_Value() {
		return (EAttribute) stringToStringMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getStringToStringMapEntry_Arguments() {
		return (EReference) stringToStringMapEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getStringToObjectMapEntry() {
		return stringToObjectMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStringToObjectMapEntry_Key() {
		return (EAttribute) stringToObjectMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStringToObjectMapEntry_Value() {
		return (EAttribute) stringToObjectMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getStringToImageDescriptorMapEntry() {
		return stringToImageDescriptorMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStringToImageDescriptorMapEntry_Key() {
		return (EAttribute) stringToImageDescriptorMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStringToImageDescriptorMapEntry_Value() {
		return (EAttribute) stringToImageDescriptorMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getStringToIConfigurationElementMapEntry() {
		return stringToIConfigurationElementMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStringToIConfigurationElementMapEntry_Key() {
		return (EAttribute) stringToIConfigurationElementMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStringToIConfigurationElementMapEntry_Value() {
		return (EAttribute) stringToIConfigurationElementMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getStringToBooleanMapEntry() {
		return stringToBooleanMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStringToBooleanMapEntry_Key() {
		return (EAttribute) stringToBooleanMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getStringToBooleanMapEntry_Value() {
		return (EAttribute) stringToBooleanMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getObjectToCIMapEntry() {
		return objectToCIMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getObjectToCIMapEntry_Key() {
		return (EReference) objectToCIMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getObjectToCIMapEntry_Value() {
		return (EReference) objectToCIMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getServiceRegistry() {
		return serviceRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getServiceRegistry_Services() {
		return (EAttribute) serviceRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getQuickfixProposal() {
		return quickfixProposalEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getQuickfixProposal_Label() {
		return (EAttribute) quickfixProposalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getQuickfixProposal_Description() {
		return (EAttribute) quickfixProposalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getQuickfixProposal_Image() {
		return (EAttribute) quickfixProposalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getQuickfixProposal_Relevance() {
		return (EAttribute) quickfixProposalEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getQuickfixProposalProcessor() {
		return quickfixProposalProcessorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getQuickfixProposalProcessorContext() {
		return quickfixProposalProcessorContextEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getQuickfixProposalProcessorContext_Message() {
		return (EReference) quickfixProposalProcessorContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getQuickfixProposalProcessorContext_Binding() {
		return (EReference) quickfixProposalProcessorContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getQuickfixProposalProcessorContext_Text() {
		return (EAttribute) quickfixProposalProcessorContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getQuickfixProposalProcessorDescriptor() {
		return quickfixProposalProcessorDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getQuickfixProposalProcessorDescriptor_ModelType() {
		return (EAttribute) quickfixProposalProcessorDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getQuickfixProposalProcessorDescriptor_Feature() {
		return (EAttribute) quickfixProposalProcessorDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getQuickfixProposalProcessorDescriptor_Source() {
		return (EAttribute) quickfixProposalProcessorDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getQuickfixProposalProcessorDescriptor_Code() {
		return (EAttribute) quickfixProposalProcessorDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getQuickfixProposalProcessorDescriptor_MessagePattern() {
		return (EAttribute) quickfixProposalProcessorDescriptorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getQuickfixProposalProcessorDescriptor_Processor() {
		return (EAttribute) quickfixProposalProcessorDescriptorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getTreeItemRelation() {
		return treeItemRelationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getTreeItemRelation_Parent() {
		return (EReference) treeItemRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getTreeItemRelation_Descriptor() {
		return (EReference) treeItemRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTreeItemRelation_Factory() {
		return (EAttribute) treeItemRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTreeItemRelation_FeatureName() {
		return (EAttribute) treeItemRelationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTreeItemRelation_Priority() {
		return (EAttribute) treeItemRelationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTreeItemRelation_TreeIDs() {
		return (EAttribute) treeItemRelationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getTreeItemDescriptor() {
		return treeItemDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTreeItemDescriptor_Id() {
		return (EAttribute) treeItemDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getTreeItemDescriptor_ChildRelations() {
		return (EReference) treeItemDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTreeItemDescriptor_Ce() {
		return (EAttribute) treeItemDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTreeItemDescriptor_ModelTypes() {
		return (EAttribute) treeItemDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getTreeItemDescriptor_ParentRelations() {
		return (EReference) treeItemDescriptorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getTreeItemDescriptor_PrimaryParent() {
		return (EReference) treeItemDescriptorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getTreeItemDescriptor_EmptyFolderHidden() {
		return (EAttribute) treeItemDescriptorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getConstantTreeItem() {
		return constantTreeItemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getConstantTreeItem_Descriptor() {
		return (EReference) constantTreeItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getConstantTreeItem_Target() {
		return (EReference) constantTreeItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getBindingMessage() {
		return bindingMessageEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getBindingMessage_Binding() {
		return (EReference) bindingMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingMessage_Message() {
		return (EAttribute) bindingMessageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingMessage_MessageType() {
		return (EAttribute) bindingMessageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingMessage_Severity() {
		return (EAttribute) bindingMessageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingMessage_Prefix() {
		return (EAttribute) bindingMessageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getBindingMessage_Targets() {
		return (EReference) bindingMessageEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingMessage_Data() {
		return (EAttribute) bindingMessageEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingMessage_Source() {
		return (EAttribute) bindingMessageEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingMessage_Code() {
		return (EAttribute) bindingMessageEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingMessage_Details() {
		return (EAttribute) bindingMessageEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getBindingMessageTarget() {
		return bindingMessageTargetEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getBindingMessageTarget_ModelObject() {
		return (EReference) bindingMessageTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getBindingMessageTarget_ModelFeature() {
		return (EReference) bindingMessageTargetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getBindingMessageTarget_ModelKey() {
		return (EAttribute) bindingMessageTargetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getUIAttribute() {
		return uiAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_Widget() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_Attribute() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_CurrentValue() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_PossibleValuesList() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_MinValue() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_MaxValue() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_TooltipValue() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_FontValue() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_ImageValue() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_ForegroundValue() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_BackgroundValue() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_EnabledValue() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_CursorValue() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_StyleRangeList() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_Changeable() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_FieldAssistAdapter() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttribute_FieldAssistControl() {
		return (EAttribute) uiAttributeEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getUIAttribute_ImageDecorations() {
		return (EReference) uiAttributeEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getUIAttributeImageDecoration() {
		return uiAttributeImageDecorationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttributeImageDecoration_Outside() {
		return (EAttribute) uiAttributeImageDecorationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttributeImageDecoration_ImageValue() {
		return (EAttribute) uiAttributeImageDecorationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttributeImageDecoration_TooltipValue() {
		return (EAttribute) uiAttributeImageDecorationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttributeImageDecoration_Position() {
		return (EAttribute) uiAttributeImageDecorationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getUIAttributeImageDecoration_Attribute() {
		return (EReference) uiAttributeImageDecorationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getUIAttributeFactory() {
		return uiAttributeFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getUIAttributeFactoryDescriptor() {
		return uiAttributeFactoryDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttributeFactoryDescriptor_TypeName() {
		return (EAttribute) uiAttributeFactoryDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttributeFactoryDescriptor_Attribute() {
		return (EAttribute) uiAttributeFactoryDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getUIAttributeFactoryDescriptor_Factory() {
		return (EAttribute) uiAttributeFactoryDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getEMFObservableFactoryDescriptor() {
		return emfObservableFactoryDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getEMFObservableFactoryDescriptor_PackagePrefix() {
		return (EAttribute) emfObservableFactoryDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getEMFObservableFactoryDescriptor_Factory() {
		return (EAttribute) emfObservableFactoryDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getIMessage() {
		return iMessageEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getIContentProposal() {
		return iContentProposalEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EEnum getBindingState() {
		return bindingStateEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EEnum getDecorationPosition() {
		return decorationPositionEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EEnum getTextCommitStrategy() {
		return textCommitStrategyEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EEnum getSpecialBinding() {
		return specialBindingEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EEnum getBindingMessageSeverity() {
		return bindingMessageSeverityEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EEnum getContainerCellType() {
		return containerCellTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getIBindingContextFinalizer() {
		return iBindingContextFinalizerEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getUIAttributePainter() {
		return uiAttributePainterEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getIEMFObservableFactory() {
		return iemfObservableFactoryEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getIAssignmentParticipant() {
		return iAssignmentParticipantEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getCEObjectHolder() {
		return ceObjectHolderEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getCEResourceHolder() {
		return ceResourceHolderEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getIFormatterProvider() {
		return iFormatterProviderEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getDBContext() {
		return dbContextEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getDBBinding() {
		return dbBindingEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getColumnViewer() {
		return columnViewerEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getViewerColumn() {
		return viewerColumnEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getImageDescriptor() {
		return imageDescriptorEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getIControlContentAdapter() {
		return iControlContentAdapterEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getIServiceLocator() {
		return iServiceLocatorEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getIConfigurationElement() {
		return iConfigurationElementEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getPattern() {
		return patternEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getThrowable() {
		return throwableEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getIObservable() {
		return iObservableEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getIObservableValue() {
		return iObservableValueEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getIObservableList() {
		return iObservableListEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getIObservableSet() {
		return iObservableSetEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getIObservableFactory() {
		return iObservableFactoryEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getISWTObservableValue() {
		return iswtObservableValueEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getIConverter() {
		return iConverterEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getIValidator() {
		return iValidatorEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getEditingDomain() {
		return editingDomainEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getWidget() {
		return widgetEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getFormToolkit() {
		return formToolkitEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getFormCreator() {
		return formCreatorEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getControl() {
		return controlEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getComposite() {
		return compositeEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getTable() {
		return tableEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getTableColumn() {
		return tableColumnEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getTree() {
		return treeEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getTreeColumn() {
		return treeColumnEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getClipboard() {
		return clipboardEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getImage() {
		return imageEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getColor() {
		return colorEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getCursor() {
		return cursorEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getSelectionListener() {
		return selectionListenerEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getUpdateValueStrategy() {
		return updateValueStrategyEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getUpdateListStrategy() {
		return updateListStrategyEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getUpdateSetStrategy() {
		return updateSetStrategyEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getNumberFormat() {
		return numberFormatEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IUIBindingsFactory getUIBindingsFactory() {
		return (IUIBindingsFactory) getEFactoryInstance();
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
		baseObjectEClass = createEClass(BASE_OBJECT);

		managerEClass = createEClass(MANAGER);
		createEAttribute(managerEClass, MANAGER__EDITING_DOMAIN);
		createEAttribute(managerEClass, MANAGER__FORM_TOOLKIT);
		createEReference(managerEClass, MANAGER__ARGUMENT_INFORMATION);
		createEReference(managerEClass, MANAGER__PROVIDERS);
		createEReference(managerEClass, MANAGER__UI_ATTRIBUTE_FACTORIES);
		createEReference(managerEClass, MANAGER__DECORATOR_EXTENDERS);
		createEAttribute(managerEClass, MANAGER__MODEL_ARGUMENT_MEDIATORS);
		createEAttribute(managerEClass, MANAGER__MODEL_ARGUMENT_MEDIATOR_CLASSES);
		createEAttribute(managerEClass, MANAGER__TEXT_COMMIT_STRATEGY);
		createEAttribute(managerEClass, MANAGER__TEXT_COMMIT_STRATEGY_DELAY);
		createEAttribute(managerEClass, MANAGER__EDIT_CELL_ANY_KEY);
		createEAttribute(managerEClass, MANAGER__EDIT_CELL_SINGLE_CLICK);
		createEAttribute(managerEClass, MANAGER__MESSAGE_DECORATION_POSITION);
		createEAttribute(managerEClass, MANAGER__MESSAGE_DECORATION_MINIMUM_SEVERITY);
		createEAttribute(managerEClass, MANAGER__ALTERNATIVE_DECORATION_POSITION);
		createEAttribute(managerEClass, MANAGER__AUTO_APPLY_SINGLE_QUICKFIX);
		createEAttribute(managerEClass, MANAGER__ALTERNATE_ROW_COLORS);
		createEAttribute(managerEClass, MANAGER__VALIDATION_ERRORS_ARE_FATAL);
		createEAttribute(managerEClass, MANAGER__VALIDATION_DELAY);
		createEAttribute(managerEClass, MANAGER__VALIDATION_DELAY_WINDOW);
		createEAttribute(managerEClass, MANAGER__REQUIRED_VB_IMAGE_DECORATION_SHOWN);
		createEAttribute(managerEClass, MANAGER__ASSIST_VB_IMAGE_DECORATION_SHOWN);
		createEAttribute(managerEClass, MANAGER__QUICKFIX_VB_IMAGE_DECORATION_SHOWN);
		createEAttribute(managerEClass, MANAGER__VIEW_NAVIGATION_RECORDED);
		createEReference(managerEClass, MANAGER__MODEL_INFO);
		createEReference(managerEClass, MANAGER__TREE_ITEMS);
		createEAttribute(managerEClass, MANAGER__CLIPBOARD);
		createEReference(managerEClass, MANAGER__OBSERVABLE_FACTORIES);
		createEReference(managerEClass, MANAGER__QUICKFIX_PROPOSAL_PROCESSORS);
		createEReference(managerEClass, MANAGER__CONTEXTS);
		createEAttribute(managerEClass, MANAGER__FORMATTER_PROVIDER);
		createEAttribute(managerEClass, MANAGER__DELETE_HANDLER_CHECK_ENABLED);
		createEReference(managerEClass, MANAGER__COMMAND_IDS);
		createEReference(managerEClass, MANAGER__ASSIGNMENT_PARTICIANTS_MANAGER);

		bindingContextEClass = createEClass(BINDING_CONTEXT);
		createEReference(bindingContextEClass, BINDING_CONTEXT__BINDINGS);
		createEReference(bindingContextEClass, BINDING_CONTEXT__OK_BINDINGS);
		createEAttribute(bindingContextEClass, BINDING_CONTEXT__TOP);
		createEAttribute(bindingContextEClass, BINDING_CONTEXT__DB_CONTEXT);
		createEAttribute(bindingContextEClass, BINDING_CONTEXT__SERVICE_LOCATOR);
		createEAttribute(bindingContextEClass, BINDING_CONTEXT__STATE);
		createEAttribute(bindingContextEClass, BINDING_CONTEXT__TEXT_COMMIT_STRATEGY);
		createEAttribute(bindingContextEClass, BINDING_CONTEXT__TEXT_COMMIT_STRATEGY_CALCULATED);
		createEAttribute(bindingContextEClass, BINDING_CONTEXT__EDITING_DOMAIN);
		createEAttribute(bindingContextEClass, BINDING_CONTEXT__FINALIZERS);

		bindingEClass = createEClass(BINDING);
		createEReference(bindingEClass, BINDING__CONTEXT);
		createEAttribute(bindingEClass, BINDING__STATE);
		createEAttribute(bindingEClass, BINDING__CHANGEABLE);
		createEAttribute(bindingEClass, BINDING__CREATION_POINT);
		createEAttribute(bindingEClass, BINDING__ID);
		createEAttribute(bindingEClass, BINDING__TYPE);
		createEAttribute(bindingEClass, BINDING__LABEL);
		createEReference(bindingEClass, BINDING__STATIC_DATA_TYPE);
		createEReference(bindingEClass, BINDING__DATA_TYPE);
		createEReference(bindingEClass, BINDING__MODEL_ETYPE);
		createEAttribute(bindingEClass, BINDING__MODEL_TYPE);
		createEAttribute(bindingEClass, BINDING__UI_TYPE);
		createEAttribute(bindingEClass, BINDING__DB_BINDINGS);
		createEAttribute(bindingEClass, BINDING__MONITORED_DB_BINDINGS);
		createEAttribute(bindingEClass, BINDING__ERROR_CONDITIONS);
		createEAttribute(bindingEClass, BINDING__WIDGET);
		createEAttribute(bindingEClass, BINDING__CONTROL);
		createEReference(bindingEClass, BINDING__EXTRA_ARGUMENT_PROVIDERS);

		valueBindingEClass = createEClass(VALUE_BINDING);
		createEAttribute(valueBindingEClass, VALUE_BINDING__MODEL_OBSERVABLE);
		createEAttribute(valueBindingEClass, VALUE_BINDING__MODEL_OBSERVABLE_VALUE);
		createEReference(valueBindingEClass, VALUE_BINDING__MODEL_OBJECT);
		createEReference(valueBindingEClass, VALUE_BINDING__MODEL_FEATURE);
		createEReference(valueBindingEClass, VALUE_BINDING__DECORATOR_PROVIDER);
		createEReference(valueBindingEClass, VALUE_BINDING__DECORATOR);
		createEReference(valueBindingEClass, VALUE_BINDING__UI_ATTRIBUTE);
		createEAttribute(valueBindingEClass, VALUE_BINDING__UI_OBSERVABLE);
		createEReference(valueBindingEClass, VALUE_BINDING__CELL);
		createEAttribute(valueBindingEClass, VALUE_BINDING__MESSAGE_PREFIX);
		createEAttribute(valueBindingEClass, VALUE_BINDING__DYNAMIC);

		valueBindingCellEClass = createEClass(VALUE_BINDING_CELL);

		columnBindingEClass = createEClass(COLUMN_BINDING);
		createEReference(columnBindingEClass, COLUMN_BINDING__VIEWER_BINDING);
		createEAttribute(columnBindingEClass, COLUMN_BINDING__VIEWER_COLUMN);
		createEReference(columnBindingEClass, COLUMN_BINDING__COLUMN_ADAPTER);
		createEReference(columnBindingEClass, COLUMN_BINDING__BASE_COLUMN);
		createEReference(columnBindingEClass, COLUMN_BINDING__SUB_COLUMNS);
		createEReference(columnBindingEClass, COLUMN_BINDING__CELLS);
		createEAttribute(columnBindingEClass, COLUMN_BINDING__SPECIAL_BINDING_TYPE);
		createEAttribute(columnBindingEClass, COLUMN_BINDING__FACTORY);
		createEAttribute(columnBindingEClass, COLUMN_BINDING__CURSOR);
		createEAttribute(columnBindingEClass, COLUMN_BINDING__COLUMN_VISIBILITY);

		columnBindingCellInformationEClass = createEClass(COLUMN_BINDING_CELL_INFORMATION);
		createEReference(columnBindingCellInformationEClass, COLUMN_BINDING_CELL_INFORMATION__COLUMN);
		createEReference(columnBindingCellInformationEClass, COLUMN_BINDING_CELL_INFORMATION__ELEMENT);
		createEReference(columnBindingCellInformationEClass, COLUMN_BINDING_CELL_INFORMATION__LABEL_BINDING);
		createEReference(columnBindingCellInformationEClass, COLUMN_BINDING_CELL_INFORMATION__LABEL_UI_ATTRIBUTE);
		createEAttribute(columnBindingCellInformationEClass, COLUMN_BINDING_CELL_INFORMATION__LABEL_PAINTER);
		createEAttribute(columnBindingCellInformationEClass, COLUMN_BINDING_CELL_INFORMATION__OBJECT_VALUE);
		createEAttribute(columnBindingCellInformationEClass, COLUMN_BINDING_CELL_INFORMATION__SOURCE_VALUE);
		createEAttribute(columnBindingCellInformationEClass, COLUMN_BINDING_CELL_INFORMATION__CHANGEABLE);
		createEAttribute(columnBindingCellInformationEClass, COLUMN_BINDING_CELL_INFORMATION__DISPLAY_TEXT);
		createEAttribute(columnBindingCellInformationEClass, COLUMN_BINDING_CELL_INFORMATION__VALUE_TYPE);
		createEAttribute(columnBindingCellInformationEClass, COLUMN_BINDING_CELL_INFORMATION__TOOL_TIP_TEXT);
		createEAttribute(columnBindingCellInformationEClass, COLUMN_BINDING_CELL_INFORMATION__ENABLED);

		containerBindingEClass = createEClass(CONTAINER_BINDING);
		createEAttribute(containerBindingEClass, CONTAINER_BINDING__SINGLE_SELECTION);

		viewerBindingEClass = createEClass(VIEWER_BINDING);
		createEReference(viewerBindingEClass, VIEWER_BINDING__COLUMNS);
		createEAttribute(viewerBindingEClass, VIEWER_BINDING__LIST);
		createEAttribute(viewerBindingEClass, VIEWER_BINDING__ELEMENTS);
		createEAttribute(viewerBindingEClass, VIEWER_BINDING__MULTIPLE_SELECTION);
		createEAttribute(viewerBindingEClass, VIEWER_BINDING__VIEWER);
		createEAttribute(viewerBindingEClass, VIEWER_BINDING__FIRST_TABLE_COLUMN_OFFSET);

		argumentInformationEClass = createEClass(ARGUMENT_INFORMATION);
		createEAttribute(argumentInformationEClass, ARGUMENT_INFORMATION__NAME);
		createEAttribute(argumentInformationEClass, ARGUMENT_INFORMATION__LOOKUP_PARENT);
		createEAttribute(argumentInformationEClass, ARGUMENT_INFORMATION__LOOKUP_ATTRIBUTE_TARGET_TYPE);
		createEAttribute(argumentInformationEClass, ARGUMENT_INFORMATION__LOOKUP_ATTRIBUTE_CONTAINING_CLASS);
		createEAttribute(argumentInformationEClass, ARGUMENT_INFORMATION__LOOKUP_REFERENCE_TARGET_TYPE);
		createEAttribute(argumentInformationEClass, ARGUMENT_INFORMATION__LOOKUP_REFERENCE_CONTAINING_CLASS);

		decoratorProviderEClass = createEClass(DECORATOR_PROVIDER);
		createEReference(decoratorProviderEClass, DECORATOR_PROVIDER__MANAGER);
		createEAttribute(decoratorProviderEClass, DECORATOR_PROVIDER__ID);
		createEAttribute(decoratorProviderEClass, DECORATOR_PROVIDER__TYPE);
		createEAttribute(decoratorProviderEClass, DECORATOR_PROVIDER__MODEL_TYPES);
		createEAttribute(decoratorProviderEClass, DECORATOR_PROVIDER__UI_TYPES);
		createEAttribute(decoratorProviderEClass, DECORATOR_PROVIDER__PROVIDER_CE);
		createEAttribute(decoratorProviderEClass, DECORATOR_PROVIDER__CHILD_CE);
		createEReference(decoratorProviderEClass, DECORATOR_PROVIDER__DECORATOR);
		createEAttribute(decoratorProviderEClass, DECORATOR_PROVIDER__EXACT_MODEL_TYPE_MATCH);

		javaDecoratorProviderEClass = createEClass(JAVA_DECORATOR_PROVIDER);

		enumDecoratorProviderEClass = createEClass(ENUM_DECORATOR_PROVIDER);
		createEAttribute(enumDecoratorProviderEClass, ENUM_DECORATOR_PROVIDER__ADDING_DEFAULT_MAPPINGS);
		createEReference(enumDecoratorProviderEClass, ENUM_DECORATOR_PROVIDER__BASE_MAPPINGS);

		enumDecoratorProviderEntryEClass = createEClass(ENUM_DECORATOR_PROVIDER_ENTRY);
		createEAttribute(enumDecoratorProviderEntryEClass, ENUM_DECORATOR_PROVIDER_ENTRY__MODEL);
		createEAttribute(enumDecoratorProviderEntryEClass, ENUM_DECORATOR_PROVIDER_ENTRY__UI);

		numberDecoratorProviderEClass = createEClass(NUMBER_DECORATOR_PROVIDER);
		createEAttribute(numberDecoratorProviderEClass, NUMBER_DECORATOR_PROVIDER__FORMAT);

		bindingDataTypeEClass = createEClass(BINDING_DATA_TYPE);
		createEAttribute(bindingDataTypeEClass, BINDING_DATA_TYPE__NAME);
		createEAttribute(bindingDataTypeEClass, BINDING_DATA_TYPE__VALUE_TYPE);
		createEReference(bindingDataTypeEClass, BINDING_DATA_TYPE__ETYPE);
		createEAttribute(bindingDataTypeEClass, BINDING_DATA_TYPE__DATA_TYPE);
		createEReference(bindingDataTypeEClass, BINDING_DATA_TYPE__EANNOTATION);
		createEReference(bindingDataTypeEClass, BINDING_DATA_TYPE__PARENT_DATA_TYPE);
		createEAttribute(bindingDataTypeEClass, BINDING_DATA_TYPE__REQUIRED);
		createEAttribute(bindingDataTypeEClass, BINDING_DATA_TYPE__CHANGEABLE);
		createEAttribute(bindingDataTypeEClass, BINDING_DATA_TYPE__UNSETTABLE);
		createEAttribute(bindingDataTypeEClass, BINDING_DATA_TYPE__BASE_TYPE);

		columnAdapterEClass = createEClass(COLUMN_ADAPTER);
		createEAttribute(columnAdapterEClass, COLUMN_ADAPTER__WIDGET);
		createEAttribute(columnAdapterEClass, COLUMN_ADAPTER__TEXT);
		createEAttribute(columnAdapterEClass, COLUMN_ADAPTER__ALIGNMENT);
		createEAttribute(columnAdapterEClass, COLUMN_ADAPTER__IMAGE);
		createEAttribute(columnAdapterEClass, COLUMN_ADAPTER__MOVEABLE);
		createEAttribute(columnAdapterEClass, COLUMN_ADAPTER__RESIZABLE);
		createEAttribute(columnAdapterEClass, COLUMN_ADAPTER__WIDTH);
		createEAttribute(columnAdapterEClass, COLUMN_ADAPTER__TOOL_TIP_TEXT);

		modelInfoEClass = createEClass(MODEL_INFO);

		modelClassInfoEClass = createEClass(MODEL_CLASS_INFO);
		createEAttribute(modelClassInfoEClass, MODEL_CLASS_INFO__CLASS_NAME);
		createEReference(modelClassInfoEClass, MODEL_CLASS_INFO__FEATURES);
		createEReference(modelClassInfoEClass, MODEL_CLASS_INFO__TYPES);

		modelFeatureInfoEClass = createEClass(MODEL_FEATURE_INFO);
		createEAttribute(modelFeatureInfoEClass, MODEL_FEATURE_INFO__FEATURE_NAME);
		createEReference(modelFeatureInfoEClass, MODEL_FEATURE_INFO__CLASS);

		uiBindingDecoratorEClass = createEClass(UI_BINDING_DECORATOR);
		createEReference(uiBindingDecoratorEClass, UI_BINDING_DECORATOR__BINDING);
		createEAttribute(uiBindingDecoratorEClass, UI_BINDING_DECORATOR__CHANGEABLE);
		createEAttribute(uiBindingDecoratorEClass, UI_BINDING_DECORATOR__MODEL_TO_UI_CONVERTER);
		createEAttribute(uiBindingDecoratorEClass, UI_BINDING_DECORATOR__UI_TO_MODEL_CONVERTER);
		createEAttribute(uiBindingDecoratorEClass, UI_BINDING_DECORATOR__UI_TO_MODEL_AFTER_CONVERT_VALIDATOR);
		createEAttribute(uiBindingDecoratorEClass, UI_BINDING_DECORATOR__VALID_UI_LIST);

		uiBindingDecoratorExtenderEClass = createEClass(UI_BINDING_DECORATOR_EXTENDER);

		uiBindingDecoratorExtenderDescriptorEClass = createEClass(UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR);
		createEAttribute(uiBindingDecoratorExtenderDescriptorEClass, UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__PRIORITY);
		createEAttribute(uiBindingDecoratorExtenderDescriptorEClass, UI_BINDING_DECORATOR_EXTENDER_DESCRIPTOR__FACTORY);

		assignmentParticipantsManagerEClass = createEClass(ASSIGNMENT_PARTICIPANTS_MANAGER);
		createEReference(assignmentParticipantsManagerEClass, ASSIGNMENT_PARTICIPANTS_MANAGER__PARTICIPANTS);

		assignmentParticipantDescriptorEClass = createEClass(ASSIGNMENT_PARTICIPANT_DESCRIPTOR);
		createEReference(assignmentParticipantDescriptorEClass, ASSIGNMENT_PARTICIPANT_DESCRIPTOR__MANAGER);
		createEAttribute(assignmentParticipantDescriptorEClass, ASSIGNMENT_PARTICIPANT_DESCRIPTOR__ID);
		createEAttribute(assignmentParticipantDescriptorEClass, ASSIGNMENT_PARTICIPANT_DESCRIPTOR__SOURCE_TYPES);
		createEAttribute(assignmentParticipantDescriptorEClass, ASSIGNMENT_PARTICIPANT_DESCRIPTOR__DESTINATION_TYPES);
		createEAttribute(assignmentParticipantDescriptorEClass, ASSIGNMENT_PARTICIPANT_DESCRIPTOR__PARTICIPANT);
		createEAttribute(assignmentParticipantDescriptorEClass, ASSIGNMENT_PARTICIPANT_DESCRIPTOR__EXACT_TYPE_MATCH);

		iArgumentProviderEClass = createEClass(IARGUMENT_PROVIDER);

		iDisposableEClass = createEClass(IDISPOSABLE);

		iModelArgumentMediatorEClass = createEClass(IMODEL_ARGUMENT_MEDIATOR);

		iPersistentPartyEClass = createEClass(IPERSISTENT_PARTY);

		constantsEClass = createEClass(CONSTANTS);

		stringToModelClassInfoMapEntryEClass = createEClass(STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY);
		createEAttribute(stringToModelClassInfoMapEntryEClass, STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY__KEY);
		createEReference(stringToModelClassInfoMapEntryEClass, STRING_TO_MODEL_CLASS_INFO_MAP_ENTRY__VALUE);

		stringToModelFeatureInfoMapEntryEClass = createEClass(STRING_TO_MODEL_FEATURE_INFO_MAP_ENTRY);
		createEAttribute(stringToModelFeatureInfoMapEntryEClass, STRING_TO_MODEL_FEATURE_INFO_MAP_ENTRY__KEY);
		createEReference(stringToModelFeatureInfoMapEntryEClass, STRING_TO_MODEL_FEATURE_INFO_MAP_ENTRY__VALUE);

		stringToArgumentInformationMapEntryEClass = createEClass(STRING_TO_ARGUMENT_INFORMATION_MAP_ENTRY);
		createEAttribute(stringToArgumentInformationMapEntryEClass, STRING_TO_ARGUMENT_INFORMATION_MAP_ENTRY__KEY);
		createEReference(stringToArgumentInformationMapEntryEClass, STRING_TO_ARGUMENT_INFORMATION_MAP_ENTRY__VALUE);

		stringToStringMapEntryEClass = createEClass(STRING_TO_STRING_MAP_ENTRY);
		createEAttribute(stringToStringMapEntryEClass, STRING_TO_STRING_MAP_ENTRY__KEY);
		createEAttribute(stringToStringMapEntryEClass, STRING_TO_STRING_MAP_ENTRY__VALUE);
		createEReference(stringToStringMapEntryEClass, STRING_TO_STRING_MAP_ENTRY__ARGUMENTS);

		stringToObjectMapEntryEClass = createEClass(STRING_TO_OBJECT_MAP_ENTRY);
		createEAttribute(stringToObjectMapEntryEClass, STRING_TO_OBJECT_MAP_ENTRY__KEY);
		createEAttribute(stringToObjectMapEntryEClass, STRING_TO_OBJECT_MAP_ENTRY__VALUE);

		stringToImageDescriptorMapEntryEClass = createEClass(STRING_TO_IMAGE_DESCRIPTOR_MAP_ENTRY);
		createEAttribute(stringToImageDescriptorMapEntryEClass, STRING_TO_IMAGE_DESCRIPTOR_MAP_ENTRY__KEY);
		createEAttribute(stringToImageDescriptorMapEntryEClass, STRING_TO_IMAGE_DESCRIPTOR_MAP_ENTRY__VALUE);

		stringToIConfigurationElementMapEntryEClass = createEClass(STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY);
		createEAttribute(stringToIConfigurationElementMapEntryEClass, STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY__KEY);
		createEAttribute(stringToIConfigurationElementMapEntryEClass, STRING_TO_ICONFIGURATION_ELEMENT_MAP_ENTRY__VALUE);

		stringToBooleanMapEntryEClass = createEClass(STRING_TO_BOOLEAN_MAP_ENTRY);
		createEAttribute(stringToBooleanMapEntryEClass, STRING_TO_BOOLEAN_MAP_ENTRY__KEY);
		createEAttribute(stringToBooleanMapEntryEClass, STRING_TO_BOOLEAN_MAP_ENTRY__VALUE);

		objectToCIMapEntryEClass = createEClass(OBJECT_TO_CI_MAP_ENTRY);
		createEReference(objectToCIMapEntryEClass, OBJECT_TO_CI_MAP_ENTRY__KEY);
		createEReference(objectToCIMapEntryEClass, OBJECT_TO_CI_MAP_ENTRY__VALUE);

		serviceRegistryEClass = createEClass(SERVICE_REGISTRY);
		createEAttribute(serviceRegistryEClass, SERVICE_REGISTRY__SERVICES);

		quickfixProposalEClass = createEClass(QUICKFIX_PROPOSAL);
		createEAttribute(quickfixProposalEClass, QUICKFIX_PROPOSAL__LABEL);
		createEAttribute(quickfixProposalEClass, QUICKFIX_PROPOSAL__DESCRIPTION);
		createEAttribute(quickfixProposalEClass, QUICKFIX_PROPOSAL__IMAGE);
		createEAttribute(quickfixProposalEClass, QUICKFIX_PROPOSAL__RELEVANCE);

		quickfixProposalProcessorEClass = createEClass(QUICKFIX_PROPOSAL_PROCESSOR);

		quickfixProposalProcessorContextEClass = createEClass(QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT);
		createEReference(quickfixProposalProcessorContextEClass, QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT__MESSAGE);
		createEReference(quickfixProposalProcessorContextEClass, QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT__BINDING);
		createEAttribute(quickfixProposalProcessorContextEClass, QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT__TEXT);

		quickfixProposalProcessorDescriptorEClass = createEClass(QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR);
		createEAttribute(quickfixProposalProcessorDescriptorEClass, QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__MODEL_TYPE);
		createEAttribute(quickfixProposalProcessorDescriptorEClass, QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__FEATURE);
		createEAttribute(quickfixProposalProcessorDescriptorEClass, QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__SOURCE);
		createEAttribute(quickfixProposalProcessorDescriptorEClass, QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__CODE);
		createEAttribute(quickfixProposalProcessorDescriptorEClass,
				QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__MESSAGE_PATTERN);
		createEAttribute(quickfixProposalProcessorDescriptorEClass, QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__PROCESSOR);

		treeItemRelationEClass = createEClass(TREE_ITEM_RELATION);
		createEReference(treeItemRelationEClass, TREE_ITEM_RELATION__PARENT);
		createEReference(treeItemRelationEClass, TREE_ITEM_RELATION__DESCRIPTOR);
		createEAttribute(treeItemRelationEClass, TREE_ITEM_RELATION__FACTORY);
		createEAttribute(treeItemRelationEClass, TREE_ITEM_RELATION__FEATURE_NAME);
		createEAttribute(treeItemRelationEClass, TREE_ITEM_RELATION__PRIORITY);
		createEAttribute(treeItemRelationEClass, TREE_ITEM_RELATION__TREE_IDS);

		treeItemDescriptorEClass = createEClass(TREE_ITEM_DESCRIPTOR);
		createEAttribute(treeItemDescriptorEClass, TREE_ITEM_DESCRIPTOR__ID);
		createEReference(treeItemDescriptorEClass, TREE_ITEM_DESCRIPTOR__CHILD_RELATIONS);
		createEAttribute(treeItemDescriptorEClass, TREE_ITEM_DESCRIPTOR__CE);
		createEAttribute(treeItemDescriptorEClass, TREE_ITEM_DESCRIPTOR__MODEL_TYPES);
		createEReference(treeItemDescriptorEClass, TREE_ITEM_DESCRIPTOR__PARENT_RELATIONS);
		createEReference(treeItemDescriptorEClass, TREE_ITEM_DESCRIPTOR__PRIMARY_PARENT);
		createEAttribute(treeItemDescriptorEClass, TREE_ITEM_DESCRIPTOR__EMPTY_FOLDER_HIDDEN);

		constantTreeItemEClass = createEClass(CONSTANT_TREE_ITEM);
		createEReference(constantTreeItemEClass, CONSTANT_TREE_ITEM__DESCRIPTOR);
		createEReference(constantTreeItemEClass, CONSTANT_TREE_ITEM__TARGET);

		bindingMessageEClass = createEClass(BINDING_MESSAGE);
		createEReference(bindingMessageEClass, BINDING_MESSAGE__BINDING);
		createEAttribute(bindingMessageEClass, BINDING_MESSAGE__MESSAGE);
		createEAttribute(bindingMessageEClass, BINDING_MESSAGE__SEVERITY);
		createEAttribute(bindingMessageEClass, BINDING_MESSAGE__MESSAGE_TYPE);
		createEAttribute(bindingMessageEClass, BINDING_MESSAGE__PREFIX);
		createEReference(bindingMessageEClass, BINDING_MESSAGE__TARGETS);
		createEAttribute(bindingMessageEClass, BINDING_MESSAGE__DATA);
		createEAttribute(bindingMessageEClass, BINDING_MESSAGE__SOURCE);
		createEAttribute(bindingMessageEClass, BINDING_MESSAGE__CODE);
		createEAttribute(bindingMessageEClass, BINDING_MESSAGE__DETAILS);

		bindingMessageTargetEClass = createEClass(BINDING_MESSAGE_TARGET);
		createEReference(bindingMessageTargetEClass, BINDING_MESSAGE_TARGET__MODEL_OBJECT);
		createEReference(bindingMessageTargetEClass, BINDING_MESSAGE_TARGET__MODEL_FEATURE);
		createEAttribute(bindingMessageTargetEClass, BINDING_MESSAGE_TARGET__MODEL_KEY);

		uiAttributeEClass = createEClass(UI_ATTRIBUTE);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__WIDGET);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__ATTRIBUTE);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__CURRENT_VALUE);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__POSSIBLE_VALUES_LIST);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__MIN_VALUE);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__MAX_VALUE);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__TOOLTIP_VALUE);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__FONT_VALUE);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__IMAGE_VALUE);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__FOREGROUND_VALUE);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__BACKGROUND_VALUE);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__ENABLED_VALUE);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__CURSOR_VALUE);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__STYLE_RANGE_LIST);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__CHANGEABLE);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__FIELD_ASSIST_ADAPTER);
		createEAttribute(uiAttributeEClass, UI_ATTRIBUTE__FIELD_ASSIST_CONTROL);
		createEReference(uiAttributeEClass, UI_ATTRIBUTE__IMAGE_DECORATIONS);

		uiAttributeImageDecorationEClass = createEClass(UI_ATTRIBUTE_IMAGE_DECORATION);
		createEAttribute(uiAttributeImageDecorationEClass, UI_ATTRIBUTE_IMAGE_DECORATION__OUTSIDE);
		createEAttribute(uiAttributeImageDecorationEClass, UI_ATTRIBUTE_IMAGE_DECORATION__IMAGE_VALUE);
		createEAttribute(uiAttributeImageDecorationEClass, UI_ATTRIBUTE_IMAGE_DECORATION__TOOLTIP_VALUE);
		createEAttribute(uiAttributeImageDecorationEClass, UI_ATTRIBUTE_IMAGE_DECORATION__POSITION);
		createEReference(uiAttributeImageDecorationEClass, UI_ATTRIBUTE_IMAGE_DECORATION__ATTRIBUTE);

		uiAttributeFactoryEClass = createEClass(UI_ATTRIBUTE_FACTORY);

		uiAttributeFactoryDescriptorEClass = createEClass(UI_ATTRIBUTE_FACTORY_DESCRIPTOR);
		createEAttribute(uiAttributeFactoryDescriptorEClass, UI_ATTRIBUTE_FACTORY_DESCRIPTOR__TYPE_NAME);
		createEAttribute(uiAttributeFactoryDescriptorEClass, UI_ATTRIBUTE_FACTORY_DESCRIPTOR__ATTRIBUTE);
		createEAttribute(uiAttributeFactoryDescriptorEClass, UI_ATTRIBUTE_FACTORY_DESCRIPTOR__FACTORY);

		emfObservableFactoryDescriptorEClass = createEClass(EMF_OBSERVABLE_FACTORY_DESCRIPTOR);
		createEAttribute(emfObservableFactoryDescriptorEClass, EMF_OBSERVABLE_FACTORY_DESCRIPTOR__PACKAGE_PREFIX);
		createEAttribute(emfObservableFactoryDescriptorEClass, EMF_OBSERVABLE_FACTORY_DESCRIPTOR__FACTORY);

		iMessageEClass = createEClass(IMESSAGE);

		iContentProposalEClass = createEClass(ICONTENT_PROPOSAL);

		// Create enums
		bindingStateEEnum = createEEnum(BINDING_STATE);
		decorationPositionEEnum = createEEnum(DECORATION_POSITION);
		textCommitStrategyEEnum = createEEnum(TEXT_COMMIT_STRATEGY);
		specialBindingEEnum = createEEnum(SPECIAL_BINDING);
		bindingMessageSeverityEEnum = createEEnum(BINDING_MESSAGE_SEVERITY);
		containerCellTypeEEnum = createEEnum(CONTAINER_CELL_TYPE);

		// Create data types
		iBindingContextFinalizerEDataType = createEDataType(IBINDING_CONTEXT_FINALIZER);
		uiAttributePainterEDataType = createEDataType(UI_ATTRIBUTE_PAINTER);
		iemfObservableFactoryEDataType = createEDataType(IEMF_OBSERVABLE_FACTORY);
		iAssignmentParticipantEDataType = createEDataType(IASSIGNMENT_PARTICIPANT);
		ceObjectHolderEDataType = createEDataType(CE_OBJECT_HOLDER);
		ceResourceHolderEDataType = createEDataType(CE_RESOURCE_HOLDER);
		iFormatterProviderEDataType = createEDataType(IFORMATTER_PROVIDER);
		dbContextEDataType = createEDataType(DB_CONTEXT);
		dbBindingEDataType = createEDataType(DB_BINDING);
		columnViewerEDataType = createEDataType(COLUMN_VIEWER);
		viewerColumnEDataType = createEDataType(VIEWER_COLUMN);
		imageDescriptorEDataType = createEDataType(IMAGE_DESCRIPTOR);
		iControlContentAdapterEDataType = createEDataType(ICONTROL_CONTENT_ADAPTER);
		iServiceLocatorEDataType = createEDataType(ISERVICE_LOCATOR);
		iConfigurationElementEDataType = createEDataType(ICONFIGURATION_ELEMENT);
		patternEDataType = createEDataType(PATTERN);
		throwableEDataType = createEDataType(THROWABLE);
		iObservableEDataType = createEDataType(IOBSERVABLE);
		iObservableValueEDataType = createEDataType(IOBSERVABLE_VALUE);
		iObservableListEDataType = createEDataType(IOBSERVABLE_LIST);
		iObservableSetEDataType = createEDataType(IOBSERVABLE_SET);
		iObservableFactoryEDataType = createEDataType(IOBSERVABLE_FACTORY);
		iswtObservableValueEDataType = createEDataType(ISWT_OBSERVABLE_VALUE);
		iConverterEDataType = createEDataType(ICONVERTER);
		iValidatorEDataType = createEDataType(IVALIDATOR);
		editingDomainEDataType = createEDataType(EDITING_DOMAIN);
		widgetEDataType = createEDataType(WIDGET);
		formToolkitEDataType = createEDataType(FORM_TOOLKIT);
		formCreatorEDataType = createEDataType(FORM_CREATOR);
		controlEDataType = createEDataType(CONTROL);
		compositeEDataType = createEDataType(COMPOSITE);
		tableEDataType = createEDataType(TABLE);
		tableColumnEDataType = createEDataType(TABLE_COLUMN);
		treeEDataType = createEDataType(TREE);
		treeColumnEDataType = createEDataType(TREE_COLUMN);
		clipboardEDataType = createEDataType(CLIPBOARD);
		imageEDataType = createEDataType(IMAGE);
		colorEDataType = createEDataType(COLOR);
		cursorEDataType = createEDataType(CURSOR);
		selectionListenerEDataType = createEDataType(SELECTION_LISTENER);
		updateValueStrategyEDataType = createEDataType(UPDATE_VALUE_STRATEGY);
		updateListStrategyEDataType = createEDataType(UPDATE_LIST_STRATEGY);
		updateSetStrategyEDataType = createEDataType(UPDATE_SET_STRATEGY);
		numberFormatEDataType = createEDataType(NUMBER_FORMAT);
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

		// Create type parameters
		addETypeParameter(ceObjectHolderEDataType, "X"); //$NON-NLS-1$

		// Set bounds for type parameters

		// Add supertypes to classes
		baseObjectEClass.getESuperTypes().add(this.getServiceRegistry());
		managerEClass.getESuperTypes().add(this.getBaseObject());
		bindingContextEClass.getESuperTypes().add(this.getBaseObject());
		bindingContextEClass.getESuperTypes().add(this.getIDisposable());
		bindingEClass.getESuperTypes().add(this.getBaseObject());
		bindingEClass.getESuperTypes().add(this.getIArgumentProvider());
		bindingEClass.getESuperTypes().add(this.getIDisposable());
		bindingEClass.getESuperTypes().add(this.getConstants());
		valueBindingEClass.getESuperTypes().add(this.getBinding());
		valueBindingEClass.getESuperTypes().add(this.getIArgumentProvider());
		columnBindingEClass.getESuperTypes().add(this.getBinding());
		columnBindingCellInformationEClass.getESuperTypes().add(this.getIDisposable());
		columnBindingCellInformationEClass.getESuperTypes().add(this.getValueBindingCell());
		containerBindingEClass.getESuperTypes().add(this.getBinding());
		viewerBindingEClass.getESuperTypes().add(this.getContainerBinding());
		decoratorProviderEClass.getESuperTypes().add(this.getIArgumentProvider());
		javaDecoratorProviderEClass.getESuperTypes().add(this.getDecoratorProvider());
		enumDecoratorProviderEClass.getESuperTypes().add(this.getDecoratorProvider());
		numberDecoratorProviderEClass.getESuperTypes().add(this.getDecoratorProvider());
		modelInfoEClass.getESuperTypes().add(this.getIArgumentProvider());
		modelClassInfoEClass.getESuperTypes().add(this.getModelInfo());
		modelFeatureInfoEClass.getESuperTypes().add(this.getModelInfo());
		uiBindingDecoratorEClass.getESuperTypes().add(this.getIDisposable());
		uiBindingDecoratorExtenderEClass.getESuperTypes().add(this.getIDisposable());
		uiBindingDecoratorExtenderDescriptorEClass.getESuperTypes().add(this.getIArgumentProvider());
		assignmentParticipantsManagerEClass.getESuperTypes().add(this.getIDisposable());
		quickfixProposalEClass.getESuperTypes().add(this.getIContentProposal());
		treeItemDescriptorEClass.getESuperTypes().add(this.getIArgumentProvider());
		constantTreeItemEClass.getESuperTypes().add(this.getIArgumentProvider());
		bindingMessageEClass.getESuperTypes().add(this.getIMessage());
		uiAttributeEClass.getESuperTypes().add(this.getIDisposable());
		uiAttributeImageDecorationEClass.getESuperTypes().add(this.getIDisposable());

		// Initialize classes and features; add operations and parameters
		initEClass(baseObjectEClass, IBaseObject.class,
				"BaseObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(managerEClass, IManager.class, "Manager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getManager_EditingDomain(),
				this.getEditingDomain(),
				"editingDomain", null, 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getManager_FormToolkit(),
				this.getFormToolkit(),
				"formToolkit", null, 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getManager_ArgumentInformation(),
				this.getStringToArgumentInformationMapEntry(),
				null,
				"argumentInformation", null, 0, -1, IManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getManager_Providers(),
				this.getDecoratorProvider(),
				this.getDecoratorProvider_Manager(),
				"providers", null, 0, -1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getManager_UiAttributeFactories(),
				this.getUIAttributeFactoryDescriptor(),
				null,
				"uiAttributeFactories", null, 0, -1, IManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getManager_DecoratorExtenders(),
				this.getUIBindingDecoratorExtenderDescriptor(),
				null,
				"decoratorExtenders", null, 0, -1, IManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		EGenericType g1 = createEGenericType(this.getCEObjectHolder());
		EGenericType g2 = createEGenericType(this.getIModelArgumentMediator());
		g1.getETypeArguments().add(g2);
		initEAttribute(
				getManager_ModelArgumentMediators(),
				g1,
				"modelArgumentMediators", null, 0, -1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		initEAttribute(
				getManager_ModelArgumentMediatorClasses(),
				g1,
				"modelArgumentMediatorClasses", null, 0, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getManager_TextCommitStrategy(),
				this.getTextCommitStrategy(),
				"textCommitStrategy", "ON_MODIFY_DELAY", 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getManager_TextCommitStrategyDelay(),
				ecorePackage.getEInt(),
				"textCommitStrategyDelay", "400", 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getManager_EditCellAnyKey(),
				ecorePackage.getEBoolean(),
				"editCellAnyKey", "true", 1, 1, IManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getManager_EditCellSingleClick(),
				ecorePackage.getEBoolean(),
				"editCellSingleClick", "true", 1, 1, IManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getManager_MessageDecorationPosition(),
				this.getDecorationPosition(),
				"messageDecorationPosition", "BOTTOM_LEFT", 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getManager_MessageDecorationMinimumSeverity(),
				this.getBindingMessageSeverity(),
				"messageDecorationMinimumSeverity", "WARNING", 1, 1, IManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getManager_AlternativeDecorationPosition(),
				this.getDecorationPosition(),
				"alternativeDecorationPosition", "TOP_LEFT", 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getManager_AutoApplySingleQuickfix(),
				ecorePackage.getEBoolean(),
				"autoApplySingleQuickfix", "false", 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getManager_AlternateRowColors(),
				ecorePackage.getEBoolean(),
				"alternateRowColors", "true", 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getManager_ValidationErrorsAreFatal(),
				ecorePackage.getEBoolean(),
				"validationErrorsAreFatal", "false", 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getManager_ValidationDelay(),
				ecorePackage.getEInt(),
				"validationDelay", "200", 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getManager_ValidationDelayWindow(),
				ecorePackage.getEInt(),
				"validationDelayWindow", "25", 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getManager_RequiredVBImageDecorationShown(),
				ecorePackage.getEBoolean(),
				"requiredVBImageDecorationShown", "true", 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getManager_AssistVBImageDecorationShown(),
				ecorePackage.getEBoolean(),
				"assistVBImageDecorationShown", "true", 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getManager_QuickfixVBImageDecorationShown(),
				ecorePackage.getEBoolean(),
				"quickfixVBImageDecorationShown", "true", 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getManager_ViewNavigationRecorded(),
				ecorePackage.getEBoolean(),
				"viewNavigationRecorded", "true", 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(
				getManager_ModelInfo(),
				this.getStringToModelClassInfoMapEntry(),
				null,
				"modelInfo", null, 0, -1, IManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getManager_TreeItems(),
				this.getTreeItemDescriptor(),
				null,
				"treeItems", null, 0, -1, IManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getManager_Clipboard(),
				this.getClipboard(),
				"clipboard", null, 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getManager_ObservableFactories(),
				this.getEMFObservableFactoryDescriptor(),
				null,
				"observableFactories", null, 0, -1, IManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getManager_QuickfixProposalProcessors(),
				this.getQuickfixProposalProcessorDescriptor(),
				null,
				"quickfixProposalProcessors", null, 0, -1, IManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getManager_Contexts(),
				this.getBindingContext(),
				null,
				"contexts", null, 0, -1, IManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getManager_FormatterProvider(),
				this.getIFormatterProvider(),
				"formatterProvider", null, 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getManager_DeleteHandlerCheckEnabled(),
				ecorePackage.getEBoolean(),
				"deleteHandlerCheckEnabled", "false", 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(
				getManager_CommandIDs(),
				this.getStringToStringMapEntry(),
				null,
				"commandIDs", null, 0, -1, IManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getManager_AssignmentParticiantsManager(),
				this.getAssignmentParticipantsManager(),
				null,
				"assignmentParticiantsManager", null, 1, 1, IManager.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(bindingContextEClass, IBindingContext.class,
				"BindingContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getBindingContext_Bindings(),
				this.getBinding(),
				this.getBinding_Context(),
				"bindings", null, 0, -1, IBindingContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getBindingContext_OkBindings(),
				this.getBinding(),
				null,
				"okBindings", null, 0, -1, IBindingContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingContext_Top(),
				this.getComposite(),
				"top", null, 1, 1, IBindingContext.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingContext_DbContext(),
				this.getDBContext(),
				"dbContext", null, 1, 1, IBindingContext.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingContext_ServiceLocator(),
				this.getIServiceLocator(),
				"serviceLocator", null, 1, 1, IBindingContext.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingContext_State(),
				this.getBindingState(),
				"state", "INIT", 1, 1, IBindingContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getBindingContext_TextCommitStrategy(),
				this.getTextCommitStrategy(),
				"textCommitStrategy", "true", 1, 1, IBindingContext.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getBindingContext_TextCommitStrategyCalculated(),
				this.getTextCommitStrategy(),
				"textCommitStrategyCalculated", null, 1, 1, IBindingContext.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingContext_EditingDomain(),
				this.getEditingDomain(),
				"editingDomain", null, 1, 1, IBindingContext.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingContext_Finalizers(),
				this.getIBindingContextFinalizer(),
				"finalizers", null, 0, -1, IBindingContext.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(bindingEClass, IBinding.class, "Binding", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getBinding_Context(),
				this.getBindingContext(),
				this.getBindingContext_Bindings(),
				"context", null, 1, 1, IBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBinding_State(),
				this.getBindingState(),
				"state", "INIT", 1, 1, IBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getBinding_Changeable(),
				ecorePackage.getEBoolean(),
				"changeable", null, 1, 1, IBinding.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBinding_CreationPoint(),
				this.getThrowable(),
				"creationPoint", null, 1, 1, IBinding.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBinding_Id(),
				ecorePackage.getEString(),
				"id", null, 0, 1, IBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBinding_Type(),
				ecorePackage.getEString(),
				"type", null, 0, 1, IBinding.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBinding_Label(),
				ecorePackage.getEString(),
				"label", null, 0, 1, IBinding.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getBinding_StaticDataType(),
				this.getBindingDataType(),
				null,
				"staticDataType", null, 1, 1, IBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getBinding_DataType(),
				this.getBindingDataType(),
				null,
				"dataType", null, 1, 1, IBinding.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getBinding_ModelEType(),
				ecorePackage.getEClassifier(),
				null,
				"modelEType", null, 1, 1, IBinding.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(
				getBinding_ModelType(),
				g1,
				"modelType", null, 1, 1, IBinding.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(
				getBinding_UIType(),
				g1,
				"uIType", null, 1, 1, IBinding.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBinding_DBBindings(),
				this.getDBBinding(),
				"DBBindings", null, 0, -1, IBinding.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBinding_MonitoredDBBindings(),
				this.getDBBinding(),
				"MonitoredDBBindings", null, 0, -1, IBinding.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBinding_ErrorConditions(),
				ecorePackage.getEString(),
				"errorConditions", null, 0, -1, IBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBinding_Widget(),
				this.getWidget(),
				"widget", null, 0, 1, IBinding.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBinding_Control(),
				this.getControl(),
				"control", null, 0, 1, IBinding.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getBinding_ExtraArgumentProviders(),
				this.getIArgumentProvider(),
				null,
				"extraArgumentProviders", null, 0, -1, IBinding.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(valueBindingEClass, IValueBinding.class,
				"ValueBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getValueBinding_ModelObservable(),
				this.getIObservable(),
				"modelObservable", null, 0, 1, IValueBinding.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getValueBinding_ModelObservableValue(),
				this.getIObservableValue(),
				"modelObservableValue", null, 0, 1, IValueBinding.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getValueBinding_ModelObject(),
				ecorePackage.getEObject(),
				null,
				"modelObject", null, 0, 1, IValueBinding.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getValueBinding_ModelFeature(),
				ecorePackage.getEStructuralFeature(),
				null,
				"modelFeature", null, 0, 1, IValueBinding.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getValueBinding_DecoratorProvider(),
				this.getDecoratorProvider(),
				null,
				"decoratorProvider", null, 0, 1, IValueBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getValueBinding_Decorator(),
				this.getUIBindingDecorator(),
				null,
				"decorator", null, 0, 1, IValueBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getValueBinding_UIAttribute(),
				this.getUIAttribute(),
				null,
				"UIAttribute", null, 0, 1, IValueBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getValueBinding_UIObservable(),
				this.getIObservableValue(),
				"UIObservable", null, 0, 1, IValueBinding.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getValueBinding_Cell(),
				this.getValueBindingCell(),
				null,
				"cell", null, 0, 1, IValueBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getValueBinding_MessagePrefix(),
				ecorePackage.getEString(),
				"messagePrefix", null, 1, 1, IValueBinding.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getValueBinding_Dynamic(),
				ecorePackage.getEBoolean(),
				"dynamic", null, 1, 1, IValueBinding.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(valueBindingCellEClass, IValueBindingCell.class,
				"ValueBindingCell", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(columnBindingEClass, IColumnBinding.class,
				"ColumnBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getColumnBinding_ViewerBinding(),
				this.getViewerBinding(),
				this.getViewerBinding_Columns(),
				"viewerBinding", null, 1, 1, IColumnBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnBinding_ViewerColumn(),
				this.getViewerColumn(),
				"viewerColumn", null, 1, 1, IColumnBinding.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getColumnBinding_ColumnAdapter(),
				this.getColumnAdapter(),
				null,
				"columnAdapter", null, 1, 1, IColumnBinding.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getColumnBinding_BaseColumn(),
				this.getColumnBinding(),
				this.getColumnBinding_SubColumns(),
				"baseColumn", null, 0, 1, IColumnBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getColumnBinding_SubColumns(),
				this.getColumnBinding(),
				this.getColumnBinding_BaseColumn(),
				"subColumns", null, 0, -1, IColumnBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getColumnBinding_Cells(),
				this.getObjectToCIMapEntry(),
				null,
				"cells", null, 0, -1, IColumnBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnBinding_SpecialBindingType(),
				this.getSpecialBinding(),
				"specialBindingType", null, 1, 1, IColumnBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnBinding_Factory(),
				this.getIObservableFactory(),
				"factory", null, 1, 1, IColumnBinding.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnBinding_Cursor(),
				this.getCursor(),
				"cursor", null, 0, 1, IColumnBinding.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnBinding_ColumnVisibility(),
				this.getIObservableValue(),
				"columnVisibility", null, 1, 1, IColumnBinding.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(columnBindingCellInformationEClass, IColumnBindingCellInformation.class,
				"ColumnBindingCellInformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getColumnBindingCellInformation_Column(),
				this.getColumnBinding(),
				null,
				"column", null, 1, 1, IColumnBindingCellInformation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getColumnBindingCellInformation_Element(),
				ecorePackage.getEObject(),
				null,
				"element", null, 1, 1, IColumnBindingCellInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getColumnBindingCellInformation_LabelBinding(),
				this.getValueBinding(),
				null,
				"labelBinding", null, 1, 1, IColumnBindingCellInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getColumnBindingCellInformation_LabelUIAttribute(),
				this.getUIAttribute(),
				null,
				"labelUIAttribute", null, 1, 1, IColumnBindingCellInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnBindingCellInformation_LabelPainter(),
				this.getUIAttributePainter(),
				"labelPainter", null, 1, 1, IColumnBindingCellInformation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnBindingCellInformation_ObjectValue(),
				this.getIObservableValue(),
				"objectValue", null, 1, 1, IColumnBindingCellInformation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnBindingCellInformation_SourceValue(),
				this.getIObservableValue(),
				"sourceValue", null, 1, 1, IColumnBindingCellInformation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnBindingCellInformation_Changeable(),
				ecorePackage.getEBoolean(),
				"changeable", null, 1, 1, IColumnBindingCellInformation.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnBindingCellInformation_DisplayText(),
				ecorePackage.getEString(),
				"displayText", null, 1, 1, IColumnBindingCellInformation.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(
				getColumnBindingCellInformation_ValueType(),
				g1,
				"valueType", null, 1, 1, IColumnBindingCellInformation.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnBindingCellInformation_ToolTipText(),
				ecorePackage.getEString(),
				"toolTipText", null, 0, 1, IColumnBindingCellInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnBindingCellInformation_Enabled(),
				ecorePackage.getEBoolean(),
				"enabled", "true", 1, 1, IColumnBindingCellInformation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(containerBindingEClass, IContainerBinding.class,
				"ContainerBinding", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getContainerBinding_SingleSelection(),
				this.getIObservableValue(),
				"singleSelection", null, 1, 1, IContainerBinding.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(viewerBindingEClass, IViewerBinding.class,
				"ViewerBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getViewerBinding_Columns(),
				this.getColumnBinding(),
				this.getColumnBinding_ViewerBinding(),
				"columns", null, 0, -1, IViewerBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getViewerBinding_List(),
				this.getIObservableList(),
				"list", null, 1, 1, IViewerBinding.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getViewerBinding_Elements(),
				this.getIObservableSet(),
				"elements", null, 1, 1, IViewerBinding.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getViewerBinding_MultipleSelection(),
				this.getIObservableList(),
				"multipleSelection", null, 1, 1, IViewerBinding.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getViewerBinding_Viewer(),
				this.getColumnViewer(),
				"viewer", null, 1, 1, IViewerBinding.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getViewerBinding_FirstTableColumnOffset(),
				ecorePackage.getEInt(),
				"firstTableColumnOffset", null, 1, 1, IViewerBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(argumentInformationEClass, IArgumentInformation.class,
				"ArgumentInformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getArgumentInformation_Name(),
				ecorePackage.getEString(),
				"name", null, 1, 1, IArgumentInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getArgumentInformation_LookupParent(),
				ecorePackage.getEBoolean(),
				"lookupParent", "true", 1, 1, IArgumentInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getArgumentInformation_LookupAttributeTargetType(),
				ecorePackage.getEBoolean(),
				"lookupAttributeTargetType", "false", 1, 1, IArgumentInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getArgumentInformation_LookupAttributeContainingClass(),
				ecorePackage.getEBoolean(),
				"lookupAttributeContainingClass", "true", 1, 1, IArgumentInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getArgumentInformation_LookupReferenceTargetType(),
				ecorePackage.getEBoolean(),
				"lookupReferenceTargetType", "true", 1, 1, IArgumentInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getArgumentInformation_LookupReferenceContainingClass(),
				ecorePackage.getEBoolean(),
				"lookupReferenceContainingClass", "false", 1, 1, IArgumentInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(decoratorProviderEClass, IDecoratorProvider.class,
				"DecoratorProvider", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getDecoratorProvider_Manager(),
				this.getManager(),
				this.getManager_Providers(),
				"manager", null, 1, 1, IDecoratorProvider.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getDecoratorProvider_Id(),
				ecorePackage.getEString(),
				"id", null, 1, 1, IDecoratorProvider.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getDecoratorProvider_Type(),
				ecorePackage.getEString(),
				"type", null, 1, 1, IDecoratorProvider.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getDecoratorProvider_ModelTypes(),
				ecorePackage.getEString(),
				"modelTypes", null, 0, -1, IDecoratorProvider.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getDecoratorProvider_UiTypes(),
				ecorePackage.getEString(),
				"uiTypes", null, 0, -1, IDecoratorProvider.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getDecoratorProvider_ProviderCE(),
				this.getIConfigurationElement(),
				"providerCE", null, 1, 1, IDecoratorProvider.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getDecoratorProvider_ChildCE(),
				this.getIConfigurationElement(),
				"childCE", null, 1, 1, IDecoratorProvider.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getDecoratorProvider_Decorator(),
				this.getUIBindingDecorator(),
				null,
				"decorator", null, 1, 1, IDecoratorProvider.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getDecoratorProvider_ExactModelTypeMatch(),
				ecorePackage.getEBoolean(),
				"exactModelTypeMatch", null, 1, 1, IDecoratorProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(javaDecoratorProviderEClass, IJavaDecoratorProvider.class,
				"JavaDecoratorProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(enumDecoratorProviderEClass, IEnumDecoratorProvider.class,
				"EnumDecoratorProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getEnumDecoratorProvider_AddingDefaultMappings(),
				ecorePackage.getEBoolean(),
				"addingDefaultMappings", null, 1, 1, IEnumDecoratorProvider.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getEnumDecoratorProvider_BaseMappings(),
				this.getEnumDecoratorProviderEntry(),
				null,
				"baseMappings", null, 0, -1, IEnumDecoratorProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(enumDecoratorProviderEntryEClass, IEnumDecoratorProviderEntry.class,
				"EnumDecoratorProviderEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getEnumDecoratorProviderEntry_Model(),
				ecorePackage.getEString(),
				"model", null, 1, 1, IEnumDecoratorProviderEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getEnumDecoratorProviderEntry_Ui(),
				ecorePackage.getEString(),
				"ui", null, 1, 1, IEnumDecoratorProviderEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(numberDecoratorProviderEClass, INumberDecoratorProvider.class,
				"NumberDecoratorProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getNumberDecoratorProvider_Format(),
				ecorePackage.getEString(),
				"format", null, 1, 1, INumberDecoratorProvider.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(bindingDataTypeEClass, IBindingDataType.class,
				"BindingDataType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getBindingDataType_Name(),
				ecorePackage.getEString(),
				"name", null, 1, 1, IBindingDataType.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingDataType_ValueType(),
				ecorePackage.getEJavaObject(),
				"valueType", null, 1, 1, IBindingDataType.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getBindingDataType_EType(),
				ecorePackage.getEClassifier(),
				null,
				"eType", null, 1, 1, IBindingDataType.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(
				getBindingDataType_DataType(),
				g1,
				"dataType", null, 1, 1, IBindingDataType.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getBindingDataType_EAnnotation(),
				ecorePackage.getEAnnotation(),
				null,
				"eAnnotation", null, 1, 1, IBindingDataType.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getBindingDataType_ParentDataType(),
				this.getBindingDataType(),
				null,
				"parentDataType", null, 0, 1, IBindingDataType.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingDataType_Required(),
				ecorePackage.getEBoolean(),
				"required", null, 1, 1, IBindingDataType.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingDataType_Changeable(),
				ecorePackage.getEBoolean(),
				"changeable", null, 1, 1, IBindingDataType.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingDataType_Unsettable(),
				ecorePackage.getEBoolean(),
				"unsettable", null, 1, 1, IBindingDataType.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingDataType_BaseType(),
				ecorePackage.getEString(),
				"baseType", null, 1, 1, IBindingDataType.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(columnAdapterEClass, IColumnAdapter.class,
				"ColumnAdapter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getColumnAdapter_Widget(),
				this.getWidget(),
				"widget", null, 1, 1, IColumnAdapter.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnAdapter_Text(),
				ecorePackage.getEString(),
				"text", null, 1, 1, IColumnAdapter.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnAdapter_Alignment(),
				ecorePackage.getEInt(),
				"alignment", null, 1, 1, IColumnAdapter.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnAdapter_Image(),
				this.getImage(),
				"image", null, 1, 1, IColumnAdapter.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnAdapter_Moveable(),
				ecorePackage.getEBoolean(),
				"moveable", null, 1, 1, IColumnAdapter.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnAdapter_Resizable(),
				ecorePackage.getEBoolean(),
				"resizable", null, 1, 1, IColumnAdapter.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnAdapter_Width(),
				ecorePackage.getEInt(),
				"width", null, 1, 1, IColumnAdapter.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getColumnAdapter_ToolTipText(),
				ecorePackage.getEString(),
				"toolTipText", null, 1, 1, IColumnAdapter.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(modelInfoEClass, IModelInfo.class,
				"ModelInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(modelClassInfoEClass, IModelClassInfo.class,
				"ModelClassInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getModelClassInfo_ClassName(),
				ecorePackage.getEString(),
				"className", null, 1, 1, IModelClassInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getModelClassInfo_Features(),
				this.getStringToModelFeatureInfoMapEntry(),
				null,
				"features", null, 0, -1, IModelClassInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getModelClassInfo_Types(),
				this.getStringToModelClassInfoMapEntry(),
				null,
				"types", null, 0, -1, IModelClassInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(modelFeatureInfoEClass, IModelFeatureInfo.class,
				"ModelFeatureInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getModelFeatureInfo_FeatureName(),
				ecorePackage.getEString(),
				"featureName", null, 1, 1, IModelFeatureInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getModelFeatureInfo_Class(),
				this.getModelClassInfo(),
				null,
				"class", null, 1, 1, IModelFeatureInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(uiBindingDecoratorEClass, IUIBindingDecorator.class,
				"UIBindingDecorator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getUIBindingDecorator_Binding(),
				this.getValueBinding(),
				null,
				"binding", null, 1, 1, IUIBindingDecorator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIBindingDecorator_Changeable(),
				ecorePackage.getEBoolean(),
				"changeable", null, 1, 1, IUIBindingDecorator.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIBindingDecorator_ModelToUIConverter(),
				this.getIConverter(),
				"modelToUIConverter", null, 1, 1, IUIBindingDecorator.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIBindingDecorator_UIToModelConverter(),
				this.getIConverter(),
				"UIToModelConverter", null, 1, 1, IUIBindingDecorator.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIBindingDecorator_UIToModelAfterConvertValidator(),
				this.getIValidator(),
				"UIToModelAfterConvertValidator", null, 1, 1, IUIBindingDecorator.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIBindingDecorator_ValidUIList(),
				this.getIObservableList(),
				"validUIList", null, 1, 1, IUIBindingDecorator.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(uiBindingDecoratorExtenderEClass, IUIBindingDecoratorExtender.class,
				"UIBindingDecoratorExtender", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(uiBindingDecoratorExtenderDescriptorEClass, IUIBindingDecoratorExtenderDescriptor.class,
				"UIBindingDecoratorExtenderDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getUIBindingDecoratorExtenderDescriptor_Priority(),
				ecorePackage.getEInt(),
				"priority", null, 1, 1, IUIBindingDecoratorExtenderDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(this.getCEObjectHolder());
		g2 = createEGenericType(this.getUIBindingDecoratorExtender());
		g1.getETypeArguments().add(g2);
		initEAttribute(
				getUIBindingDecoratorExtenderDescriptor_Factory(),
				g1,
				"factory", null, 1, 1, IUIBindingDecoratorExtenderDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(assignmentParticipantsManagerEClass, IAssignmentParticipantsManager.class,
				"AssignmentParticipantsManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getAssignmentParticipantsManager_Participants(),
				this.getAssignmentParticipantDescriptor(),
				this.getAssignmentParticipantDescriptor_Manager(),
				"participants", null, 0, -1, IAssignmentParticipantsManager.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(assignmentParticipantDescriptorEClass, IAssignmentParticipantDescriptor.class,
				"AssignmentParticipantDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getAssignmentParticipantDescriptor_Manager(),
				this.getAssignmentParticipantsManager(),
				this.getAssignmentParticipantsManager_Participants(),
				"manager", null, 0, 1, IAssignmentParticipantDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAssignmentParticipantDescriptor_Id(),
				ecorePackage.getEString(),
				"id", null, 1, 1, IAssignmentParticipantDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAssignmentParticipantDescriptor_SourceTypes(),
				ecorePackage.getEString(),
				"sourceTypes", null, 0, -1, IAssignmentParticipantDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAssignmentParticipantDescriptor_DestinationTypes(),
				ecorePackage.getEString(),
				"destinationTypes", null, 0, -1, IAssignmentParticipantDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(this.getCEObjectHolder());
		g2 = createEGenericType(this.getIAssignmentParticipant());
		g1.getETypeArguments().add(g2);
		initEAttribute(
				getAssignmentParticipantDescriptor_Participant(),
				g1,
				"participant", null, 1, 1, IAssignmentParticipantDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getAssignmentParticipantDescriptor_ExactTypeMatch(),
				ecorePackage.getEBoolean(),
				"exactTypeMatch", null, 1, 1, IAssignmentParticipantDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(iArgumentProviderEClass, IArgumentProvider.class,
				"IArgumentProvider", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iDisposableEClass, IDisposable.class,
				"IDisposable", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iModelArgumentMediatorEClass, IModelArgumentMediator.class,
				"IModelArgumentMediator", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iPersistentPartyEClass, IPersistentParty.class,
				"IPersistentParty", IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(constantsEClass, Constants.class,
				"Constants", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(stringToModelClassInfoMapEntryEClass, Map.Entry.class,
				"StringToModelClassInfoMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getStringToModelClassInfoMapEntry_Key(),
				ecorePackage.getEString(),
				"key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getStringToModelClassInfoMapEntry_Value(),
				this.getModelClassInfo(),
				null,
				"value", null, 0, 1, Map.Entry.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stringToModelFeatureInfoMapEntryEClass, Map.Entry.class,
				"StringToModelFeatureInfoMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getStringToModelFeatureInfoMapEntry_Key(),
				ecorePackage.getEString(),
				"key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getStringToModelFeatureInfoMapEntry_Value(),
				this.getModelFeatureInfo(),
				null,
				"value", null, 0, 1, Map.Entry.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stringToArgumentInformationMapEntryEClass, Map.Entry.class,
				"StringToArgumentInformationMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getStringToArgumentInformationMapEntry_Key(),
				ecorePackage.getEString(),
				"key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getStringToArgumentInformationMapEntry_Value(),
				this.getArgumentInformation(),
				null,
				"value", null, 0, 1, Map.Entry.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stringToStringMapEntryEClass, Map.Entry.class,
				"StringToStringMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getStringToStringMapEntry_Key(),
				ecorePackage.getEString(),
				"key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getStringToStringMapEntry_Value(),
				ecorePackage.getEString(),
				"value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getStringToStringMapEntry_Arguments(),
				this.getStringToObjectMapEntry(),
				null,
				"arguments", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stringToObjectMapEntryEClass, Map.Entry.class,
				"StringToObjectMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getStringToObjectMapEntry_Key(),
				ecorePackage.getEString(),
				"key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getStringToObjectMapEntry_Value(),
				ecorePackage.getEJavaObject(),
				"value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stringToImageDescriptorMapEntryEClass, Map.Entry.class,
				"StringToImageDescriptorMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getStringToImageDescriptorMapEntry_Key(),
				ecorePackage.getEString(),
				"key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getStringToImageDescriptorMapEntry_Value(),
				this.getImageDescriptor(),
				"value", null, 0, 1, Map.Entry.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stringToIConfigurationElementMapEntryEClass, Map.Entry.class,
				"StringToIConfigurationElementMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getStringToIConfigurationElementMapEntry_Key(),
				ecorePackage.getEString(),
				"key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getStringToIConfigurationElementMapEntry_Value(),
				this.getIConfigurationElement(),
				"value", null, 0, 1, Map.Entry.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(stringToBooleanMapEntryEClass, Map.Entry.class,
				"StringToBooleanMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getStringToBooleanMapEntry_Key(),
				ecorePackage.getEString(),
				"key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getStringToBooleanMapEntry_Value(),
				ecorePackage.getEBoolean(),
				"value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(objectToCIMapEntryEClass, Map.Entry.class,
				"ObjectToCIMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getObjectToCIMapEntry_Key(),
				ecorePackage.getEObject(),
				null,
				"key", null, 1, 1, Map.Entry.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getObjectToCIMapEntry_Value(),
				this.getColumnBindingCellInformation(),
				null,
				"value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(serviceRegistryEClass, IServiceRegistry.class,
				"ServiceRegistry", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getServiceRegistry_Services(),
				ecorePackage.getEJavaObject(),
				"services", null, 0, -1, IServiceRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(quickfixProposalEClass, IQuickfixProposal.class,
				"QuickfixProposal", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getQuickfixProposal_Label(),
				ecorePackage.getEString(),
				"label", null, 1, 1, IQuickfixProposal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getQuickfixProposal_Description(),
				ecorePackage.getEString(),
				"description", null, 1, 1, IQuickfixProposal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getQuickfixProposal_Image(),
				this.getImageDescriptor(),
				"image", null, 1, 1, IQuickfixProposal.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getQuickfixProposal_Relevance(),
				ecorePackage.getEInt(),
				"relevance", null, 1, 1, IQuickfixProposal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(quickfixProposalProcessorEClass, IQuickfixProposalProcessor.class,
				"QuickfixProposalProcessor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(quickfixProposalProcessorContextEClass, IQuickfixProposalProcessorContext.class,
				"QuickfixProposalProcessorContext", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getQuickfixProposalProcessorContext_Message(),
				this.getBindingMessage(),
				null,
				"message", null, 1, 1, IQuickfixProposalProcessorContext.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getQuickfixProposalProcessorContext_Binding(),
				this.getValueBinding(),
				null,
				"binding", null, 1, 1, IQuickfixProposalProcessorContext.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getQuickfixProposalProcessorContext_Text(),
				ecorePackage.getEString(),
				"text", null, 1, 1, IQuickfixProposalProcessorContext.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(quickfixProposalProcessorDescriptorEClass, IQuickfixProposalProcessorDescriptor.class,
				"QuickfixProposalProcessorDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getQuickfixProposalProcessorDescriptor_ModelType(),
				ecorePackage.getEString(),
				"modelType", null, 1, 1, IQuickfixProposalProcessorDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getQuickfixProposalProcessorDescriptor_Feature(),
				ecorePackage.getEString(),
				"feature", null, 1, 1, IQuickfixProposalProcessorDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getQuickfixProposalProcessorDescriptor_Source(),
				ecorePackage.getEString(),
				"source", null, 1, 1, IQuickfixProposalProcessorDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getQuickfixProposalProcessorDescriptor_Code(),
				ecorePackage.getEInt(),
				"code", null, 1, 1, IQuickfixProposalProcessorDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getQuickfixProposalProcessorDescriptor_MessagePattern(),
				this.getPattern(),
				"messagePattern", null, 1, 1, IQuickfixProposalProcessorDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(this.getCEObjectHolder());
		g2 = createEGenericType(this.getQuickfixProposalProcessor());
		g1.getETypeArguments().add(g2);
		initEAttribute(
				getQuickfixProposalProcessorDescriptor_Processor(),
				g1,
				"processor", null, 1, 1, IQuickfixProposalProcessorDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(treeItemRelationEClass, ITreeItemRelation.class,
				"TreeItemRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getTreeItemRelation_Parent(),
				this.getTreeItemDescriptor(),
				this.getTreeItemDescriptor_ChildRelations(),
				"parent", null, 0, 1, ITreeItemRelation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getTreeItemRelation_Descriptor(),
				this.getTreeItemDescriptor(),
				this.getTreeItemDescriptor_ParentRelations(),
				"descriptor", null, 0, 1, ITreeItemRelation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(this.getCEObjectHolder());
		g2 = createEGenericType(this.getIObservableFactory());
		g1.getETypeArguments().add(g2);
		initEAttribute(
				getTreeItemRelation_Factory(),
				g1,
				"factory", null, 1, 1, ITreeItemRelation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTreeItemRelation_FeatureName(),
				ecorePackage.getEString(),
				"featureName", null, 1, 1, ITreeItemRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTreeItemRelation_Priority(),
				ecorePackage.getEInt(),
				"priority", null, 1, 1, ITreeItemRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTreeItemRelation_TreeIDs(),
				ecorePackage.getEString(),
				"treeIDs", null, 0, -1, ITreeItemRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(treeItemDescriptorEClass, ITreeItemDescriptor.class,
				"TreeItemDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getTreeItemDescriptor_Id(),
				ecorePackage.getEString(),
				"id", null, 1, 1, ITreeItemDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getTreeItemDescriptor_ChildRelations(),
				this.getTreeItemRelation(),
				this.getTreeItemRelation_Parent(),
				"childRelations", null, 0, -1, ITreeItemDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTreeItemDescriptor_Ce(),
				this.getIConfigurationElement(),
				"ce", null, 1, 1, ITreeItemDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTreeItemDescriptor_ModelTypes(),
				ecorePackage.getEString(),
				"modelTypes", null, 0, -1, ITreeItemDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getTreeItemDescriptor_ParentRelations(),
				this.getTreeItemRelation(),
				this.getTreeItemRelation_Descriptor(),
				"parentRelations", null, 0, -1, ITreeItemDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getTreeItemDescriptor_PrimaryParent(),
				this.getTreeItemDescriptor(),
				null,
				"primaryParent", null, 0, 1, ITreeItemDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getTreeItemDescriptor_EmptyFolderHidden(),
				ecorePackage.getEBoolean(),
				"emptyFolderHidden", "false", 1, 1, ITreeItemDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(constantTreeItemEClass, IConstantTreeItem.class,
				"ConstantTreeItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getConstantTreeItem_Descriptor(),
				this.getTreeItemDescriptor(),
				null,
				"descriptor", null, 1, 1, IConstantTreeItem.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getConstantTreeItem_Target(),
				ecorePackage.getEObject(),
				null,
				"target", null, 1, 1, IConstantTreeItem.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(bindingMessageEClass, IBindingMessage.class,
				"BindingMessage", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getBindingMessage_Binding(),
				this.getValueBinding(),
				null,
				"binding", null, 0, 1, IBindingMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingMessage_Message(),
				ecorePackage.getEString(),
				"message", null, 1, 1, IBindingMessage.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingMessage_Severity(),
				this.getBindingMessageSeverity(),
				"severity", null, 1, 1, IBindingMessage.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingMessage_MessageType(),
				ecorePackage.getEInt(),
				"messageType", null, 1, 1, IBindingMessage.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingMessage_Prefix(),
				ecorePackage.getEString(),
				"prefix", null, 1, 1, IBindingMessage.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getBindingMessage_Targets(),
				this.getBindingMessageTarget(),
				null,
				"targets", null, 0, -1, IBindingMessage.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingMessage_Data(),
				ecorePackage.getEJavaObject(),
				"data", null, 0, 1, IBindingMessage.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingMessage_Source(),
				ecorePackage.getEString(),
				"source", null, 1, 1, IBindingMessage.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingMessage_Code(),
				ecorePackage.getEInt(),
				"code", null, 1, 1, IBindingMessage.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingMessage_Details(),
				ecorePackage.getEString(),
				"details", null, 0, 1, IBindingMessage.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(bindingMessageTargetEClass, IBindingMessageTarget.class,
				"BindingMessageTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getBindingMessageTarget_ModelObject(),
				ecorePackage.getEObject(),
				null,
				"modelObject", null, 1, 1, IBindingMessageTarget.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getBindingMessageTarget_ModelFeature(),
				ecorePackage.getEStructuralFeature(),
				null,
				"modelFeature", null, 0, 1, IBindingMessageTarget.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getBindingMessageTarget_ModelKey(),
				ecorePackage.getEJavaObject(),
				"modelKey", null, 0, 1, IBindingMessageTarget.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(uiAttributeEClass, IUIAttribute.class,
				"UIAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getUIAttribute_Widget(),
				this.getWidget(),
				"widget", null, 1, 1, IUIAttribute.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttribute_Attribute(),
				ecorePackage.getEString(),
				"attribute", "", 1, 1, IUIAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getUIAttribute_CurrentValue(),
				this.getIObservableValue(),
				"currentValue", null, 1, 1, IUIAttribute.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttribute_PossibleValuesList(),
				this.getIObservableList(),
				"possibleValuesList", null, 0, 1, IUIAttribute.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttribute_MinValue(),
				this.getIObservableValue(),
				"minValue", null, 0, 1, IUIAttribute.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttribute_MaxValue(),
				this.getIObservableValue(),
				"maxValue", null, 0, 1, IUIAttribute.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttribute_TooltipValue(),
				this.getIObservableValue(),
				"tooltipValue", null, 0, 1, IUIAttribute.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttribute_FontValue(),
				this.getIObservableValue(),
				"fontValue", null, 0, 1, IUIAttribute.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttribute_ImageValue(),
				this.getIObservableValue(),
				"imageValue", null, 0, 1, IUIAttribute.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttribute_ForegroundValue(),
				this.getIObservableValue(),
				"foregroundValue", null, 0, 1, IUIAttribute.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttribute_BackgroundValue(),
				this.getIObservableValue(),
				"backgroundValue", null, 0, 1, IUIAttribute.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttribute_EnabledValue(),
				this.getIObservableValue(),
				"enabledValue", null, 0, 1, IUIAttribute.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttribute_CursorValue(),
				this.getIObservableValue(),
				"cursorValue", null, 0, 1, IUIAttribute.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttribute_StyleRangeList(),
				this.getIObservableList(),
				"styleRangeList", null, 0, 1, IUIAttribute.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttribute_Changeable(),
				ecorePackage.getEBoolean(),
				"changeable", null, 1, 1, IUIAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttribute_FieldAssistAdapter(),
				this.getIControlContentAdapter(),
				"fieldAssistAdapter", null, 0, 1, IUIAttribute.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttribute_FieldAssistControl(),
				this.getControl(),
				"fieldAssistControl", null, 0, 1, IUIAttribute.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getUIAttribute_ImageDecorations(),
				this.getUIAttributeImageDecoration(),
				this.getUIAttributeImageDecoration_Attribute(),
				"imageDecorations", null, 0, -1, IUIAttribute.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(uiAttributeImageDecorationEClass, IUIAttributeImageDecoration.class,
				"UIAttributeImageDecoration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getUIAttributeImageDecoration_Outside(),
				ecorePackage.getEBoolean(),
				"outside", "false", 1, 1, IUIAttributeImageDecoration.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getUIAttributeImageDecoration_ImageValue(),
				this.getIObservableValue(),
				"imageValue", null, 1, 1, IUIAttributeImageDecoration.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttributeImageDecoration_TooltipValue(),
				this.getIObservableValue(),
				"tooltipValue", null, 1, 1, IUIAttributeImageDecoration.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttributeImageDecoration_Position(),
				this.getDecorationPosition(),
				"position", null, 1, 1, IUIAttributeImageDecoration.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getUIAttributeImageDecoration_Attribute(),
				this.getUIAttribute(),
				this.getUIAttribute_ImageDecorations(),
				"attribute", null, 1, 1, IUIAttributeImageDecoration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(uiAttributeFactoryEClass, IUIAttributeFactory.class,
				"UIAttributeFactory", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(uiAttributeFactoryDescriptorEClass, IUIAttributeFactoryDescriptor.class,
				"UIAttributeFactoryDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getUIAttributeFactoryDescriptor_TypeName(),
				ecorePackage.getEString(),
				"typeName", null, 1, 1, IUIAttributeFactoryDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getUIAttributeFactoryDescriptor_Attribute(),
				ecorePackage.getEString(),
				"attribute", null, 1, 1, IUIAttributeFactoryDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(this.getCEObjectHolder());
		g2 = createEGenericType(this.getUIAttributeFactory());
		g1.getETypeArguments().add(g2);
		initEAttribute(
				getUIAttributeFactoryDescriptor_Factory(),
				g1,
				"factory", null, 1, 1, IUIAttributeFactoryDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(emfObservableFactoryDescriptorEClass, IEMFObservableFactoryDescriptor.class,
				"EMFObservableFactoryDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getEMFObservableFactoryDescriptor_PackagePrefix(),
				ecorePackage.getEString(),
				"packagePrefix", null, 1, 1, IEMFObservableFactoryDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(this.getCEObjectHolder());
		g2 = createEGenericType(this.getIEMFObservableFactory());
		g1.getETypeArguments().add(g2);
		initEAttribute(
				getEMFObservableFactoryDescriptor_Factory(),
				g1,
				"factory", null, 1, 1, IEMFObservableFactoryDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(iMessageEClass, IMessage.class, "IMessage", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(iContentProposalEClass, IContentProposal.class,
				"IContentProposal", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(bindingStateEEnum, BindingState.class, "BindingState"); //$NON-NLS-1$
		addEEnumLiteral(bindingStateEEnum, BindingState.INIT);
		addEEnumLiteral(bindingStateEEnum, BindingState.PHASE1);
		addEEnumLiteral(bindingStateEEnum, BindingState.PHASE2);
		addEEnumLiteral(bindingStateEEnum, BindingState.PHASE3);
		addEEnumLiteral(bindingStateEEnum, BindingState.OK);
		addEEnumLiteral(bindingStateEEnum, BindingState.DISPOSED);
		addEEnumLiteral(bindingStateEEnum, BindingState.DISPOSE_PENDING);

		initEEnum(decorationPositionEEnum, DecorationPosition.class, "DecorationPosition"); //$NON-NLS-1$
		addEEnumLiteral(decorationPositionEEnum, DecorationPosition.TOP_LEFT);
		addEEnumLiteral(decorationPositionEEnum, DecorationPosition.CENTER_LEFT);
		addEEnumLiteral(decorationPositionEEnum, DecorationPosition.BOTTOM_LEFT);
		addEEnumLiteral(decorationPositionEEnum, DecorationPosition.TOP_RIGHT);
		addEEnumLiteral(decorationPositionEEnum, DecorationPosition.CENTER_RIGHT);
		addEEnumLiteral(decorationPositionEEnum, DecorationPosition.BOTTOM_RIGHT);

		initEEnum(textCommitStrategyEEnum, TextCommitStrategy.class, "TextCommitStrategy"); //$NON-NLS-1$
		addEEnumLiteral(textCommitStrategyEEnum, TextCommitStrategy.ON_MODIFY);
		addEEnumLiteral(textCommitStrategyEEnum, TextCommitStrategy.ON_FOCUS_OUT);
		addEEnumLiteral(textCommitStrategyEEnum, TextCommitStrategy.ON_MODIFY_DELAY);

		initEEnum(specialBindingEEnum, SpecialBinding.class, "SpecialBinding"); //$NON-NLS-1$
		addEEnumLiteral(specialBindingEEnum, SpecialBinding.ROW_NO);
		addEEnumLiteral(specialBindingEEnum, SpecialBinding.TREE_ITEM);
		addEEnumLiteral(specialBindingEEnum, SpecialBinding.ROW_ELEMENT);

		initEEnum(bindingMessageSeverityEEnum, BindingMessageSeverity.class, "BindingMessageSeverity"); //$NON-NLS-1$
		addEEnumLiteral(bindingMessageSeverityEEnum, BindingMessageSeverity.NONE);
		addEEnumLiteral(bindingMessageSeverityEEnum, BindingMessageSeverity.INFORMATION);
		addEEnumLiteral(bindingMessageSeverityEEnum, BindingMessageSeverity.WARNING);
		addEEnumLiteral(bindingMessageSeverityEEnum, BindingMessageSeverity.ERROR);

		initEEnum(containerCellTypeEEnum, ContainerCellType.class, "ContainerCellType"); //$NON-NLS-1$
		addEEnumLiteral(containerCellTypeEEnum, ContainerCellType.TOP_LEFT);
		addEEnumLiteral(containerCellTypeEEnum, ContainerCellType.TOP_RIGHT);
		addEEnumLiteral(containerCellTypeEEnum, ContainerCellType.COLUMN_HEADER);
		addEEnumLiteral(containerCellTypeEEnum, ContainerCellType.ROW_HEADER);
		addEEnumLiteral(containerCellTypeEEnum, ContainerCellType.DATA);
		addEEnumLiteral(containerCellTypeEEnum, ContainerCellType.BOTTOM_LEFT);
		addEEnumLiteral(containerCellTypeEEnum, ContainerCellType.BOTTOM_RIGHT);
		addEEnumLiteral(containerCellTypeEEnum, ContainerCellType.COLUMN_TRAILER);
		addEEnumLiteral(containerCellTypeEEnum, ContainerCellType.ROW_TRAILER);

		// Initialize data types
		initEDataType(iBindingContextFinalizerEDataType, IBindingContextFinalizer.class,
				"IBindingContextFinalizer", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(uiAttributePainterEDataType, UIAttributePainter.class,
				"UIAttributePainter", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iemfObservableFactoryEDataType, IEMFObservableFactory.class,
				"IEMFObservableFactory", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iAssignmentParticipantEDataType, IAssignmentParticipant.class,
				"IAssignmentParticipant", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(ceObjectHolderEDataType, CEObjectHolder.class,
				"CEObjectHolder", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(ceResourceHolderEDataType, CEResourceHolder.class,
				"CEResourceHolder", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iFormatterProviderEDataType, IFormatterProvider.class,
				"IFormatterProvider", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(dbContextEDataType, DataBindingContext.class,
				"DBContext", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(dbBindingEDataType, Binding.class, "DBBinding", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(columnViewerEDataType, ColumnViewer.class,
				"ColumnViewer", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(viewerColumnEDataType, ViewerColumn.class,
				"ViewerColumn", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(imageDescriptorEDataType, ImageDescriptor.class,
				"ImageDescriptor", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iControlContentAdapterEDataType, IControlContentAdapter.class,
				"IControlContentAdapter", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iServiceLocatorEDataType, IServiceLocator.class,
				"IServiceLocator", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iConfigurationElementEDataType, IConfigurationElement.class,
				"IConfigurationElement", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(patternEDataType, Pattern.class, "Pattern", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(throwableEDataType, Throwable.class, "Throwable", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iObservableEDataType, IObservable.class,
				"IObservable", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iObservableValueEDataType, IObservableValue.class,
				"IObservableValue", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iObservableListEDataType, IObservableList.class,
				"IObservableList", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iObservableSetEDataType, IObservableSet.class,
				"IObservableSet", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iObservableFactoryEDataType, IObservableFactory.class,
				"IObservableFactory", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iswtObservableValueEDataType, ISWTObservableValue.class,
				"ISWTObservableValue", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iConverterEDataType, IConverter.class,
				"IConverter", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(iValidatorEDataType, IValidator.class,
				"IValidator", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(editingDomainEDataType, EditingDomain.class,
				"EditingDomain", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(widgetEDataType, Widget.class, "Widget", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(formToolkitEDataType, FormToolkit.class,
				"FormToolkit", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(formCreatorEDataType, IFormCreator.class,
				"FormCreator", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(controlEDataType, Control.class, "Control", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(compositeEDataType, Composite.class, "Composite", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(tableEDataType, Table.class, "Table", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(tableColumnEDataType, TableColumn.class,
				"TableColumn", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(treeEDataType, Tree.class, "Tree", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(treeColumnEDataType, TreeColumn.class,
				"TreeColumn", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(clipboardEDataType, Clipboard.class, "Clipboard", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(imageEDataType, Image.class, "Image", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(colorEDataType, Color.class, "Color", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(cursorEDataType, Cursor.class, "Cursor", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(selectionListenerEDataType, SelectionListener.class,
				"SelectionListener", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(updateValueStrategyEDataType, UpdateValueStrategy.class,
				"UpdateValueStrategy", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(updateListStrategyEDataType, UpdateListStrategy.class,
				"UpdateListStrategy", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(updateSetStrategyEDataType, UpdateSetStrategy.class,
				"UpdateSetStrategy", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(numberFormatEDataType, NumberFormat.class,
				"NumberFormat", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} // UIBindingsPackageImpl
