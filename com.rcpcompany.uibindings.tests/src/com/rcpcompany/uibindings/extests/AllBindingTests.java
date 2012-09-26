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
package com.rcpcompany.uibindings.extests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.rcpcompany.uibindings.bindingMessages.LabelDecoratorListenerTest;
import com.rcpcompany.uibindings.extests.bindingDataTypes.BindingDataTypeFactoryTest;
import com.rcpcompany.uibindings.extests.bindingMessages.LabelDecoratorTest;
import com.rcpcompany.uibindings.extests.bindingMessages.ScrolledFormAdapterTest;
import com.rcpcompany.uibindings.extests.bindingMessages.ValidationAdapterManagerMasterDetailTest;
import com.rcpcompany.uibindings.extests.bindingMessages.ValueBindingMessageImageDecoratorImageTest;
import com.rcpcompany.uibindings.extests.bindings.ArgumentsSequenceTest;
import com.rcpcompany.uibindings.extests.bindings.ArgumentsTypeTest;
import com.rcpcompany.uibindings.extests.bindings.BindingContextFinalizerTest;
import com.rcpcompany.uibindings.extests.bindings.BindingControlDisposeTest;
import com.rcpcompany.uibindings.extests.bindings.BindingDisposeTest;
import com.rcpcompany.uibindings.extests.bindings.BindingFormatTest;
import com.rcpcompany.uibindings.extests.bindings.BindingSetFocusTest;
import com.rcpcompany.uibindings.extests.bindings.ContextEditingDomainCommitTest;
import com.rcpcompany.uibindings.extests.bindings.ContextEditingDomainTest;
import com.rcpcompany.uibindings.extests.bindings.ContextNoCommitTest;
import com.rcpcompany.uibindings.extests.bindings.CreationPointTest;
import com.rcpcompany.uibindings.extests.bindings.PreferredCellEditorFactoryTest;
import com.rcpcompany.uibindings.extests.bindings.ReadonlyTest;
import com.rcpcompany.uibindings.extests.bindings.SimplePreferredCellEditorTest;
import com.rcpcompany.uibindings.extests.bindings.extenders.EnumImageExtenderTest;
import com.rcpcompany.uibindings.extests.compositeForms.CompositeFormBasicTest;
import com.rcpcompany.uibindings.extests.compositeForms.CompositeFormCreateTest;
import com.rcpcompany.uibindings.extests.contexts.ContextActivationTest;
import com.rcpcompany.uibindings.extests.cutCopyPaste.CopyPasteInViewerTest;
import com.rcpcompany.uibindings.extests.cutCopyPaste.SuperCreateTest;
import com.rcpcompany.uibindings.extests.cutCopyPaste.SuperPasteTest;
import com.rcpcompany.uibindings.extests.decoratorProviders.DecoratorProviderTest;
import com.rcpcompany.uibindings.extests.decoratorProviders.EObjectCreatorDecoratorProviderTest;
import com.rcpcompany.uibindings.extests.decoratorProviders.EnumDecoratorProviderTest;
import com.rcpcompany.uibindings.extests.decoratorProviders.NumberDecoratorProviderRangeTest;
import com.rcpcompany.uibindings.extests.decoratorProviders.NumberDecoratorProviderSpecialFPTest;
import com.rcpcompany.uibindings.extests.decoratorProviders.NumberDecoratorProviderTest;
import com.rcpcompany.uibindings.extests.decoratorProviders.NumberDecoratorProviderUnitTest;
import com.rcpcompany.uibindings.extests.decoratorProviders.SpecialDecoratorProviderTest;
import com.rcpcompany.uibindings.extests.issues.SIMA621ProblemsIncreases;
import com.rcpcompany.uibindings.extests.issues.SIMO182BugInUIBindingForTableCellEditor;
import com.rcpcompany.uibindings.extests.leaks.SIMO302EObjectObservableValueLeakTest;
import com.rcpcompany.uibindings.extests.leaks.ViewerEditorLeakTest;
import com.rcpcompany.uibindings.extests.manager.AlternatingRowColorsTest;
import com.rcpcompany.uibindings.extests.manager.ConstantDefinitionsTest;
import com.rcpcompany.uibindings.extests.manager.ManagerAlternatingRowColors;
import com.rcpcompany.uibindings.extests.manager.ManagerAlternativeDecorationPositionTest;
import com.rcpcompany.uibindings.extests.manager.ManagerArgumentInformationTest;
import com.rcpcompany.uibindings.extests.manager.ManagerAssistVBIDShown;
import com.rcpcompany.uibindings.extests.manager.ManagerAutoApplyQuickfixTest;
import com.rcpcompany.uibindings.extests.manager.ManagerBasicFunctionalityTest;
import com.rcpcompany.uibindings.extests.manager.ManagerDecoratorExtendersSortTest;
import com.rcpcompany.uibindings.extests.manager.ManagerDecoratorExtendersTest;
import com.rcpcompany.uibindings.extests.manager.ManagerDecoratorProvidersTest;
import com.rcpcompany.uibindings.extests.manager.ManagerDeleteHandlerCheckEnabledTest;
import com.rcpcompany.uibindings.extests.manager.ManagerEditCellAnyKeyTest;
import com.rcpcompany.uibindings.extests.manager.ManagerEditCellSingleClickTest;
import com.rcpcompany.uibindings.extests.manager.ManagerFormatterProviderTest;
import com.rcpcompany.uibindings.extests.manager.ManagerMessageDecorationMinimumSeverityTest;
import com.rcpcompany.uibindings.extests.manager.ManagerMessageDecorationPositionTest;
import com.rcpcompany.uibindings.extests.manager.ManagerQuickfixVBIDShown;
import com.rcpcompany.uibindings.extests.manager.ManagerRequiredVBIDShown;
import com.rcpcompany.uibindings.extests.manager.ManagerTextCommitStrategyDelayTest;
import com.rcpcompany.uibindings.extests.manager.ManagerTextCommitStrategyTest;
import com.rcpcompany.uibindings.extests.manager.ManagerTreeFunctionalityTest;
import com.rcpcompany.uibindings.extests.manager.ManagerValidationDelayTest;
import com.rcpcompany.uibindings.extests.manager.ManagerValidationDelayWindowTest;
import com.rcpcompany.uibindings.extests.manager.ManagerValidationErrorsAreFatal;
import com.rcpcompany.uibindings.extests.manager.ManagerViewNavigationRecorded;
import com.rcpcompany.uibindings.extests.manager.NoErrorsDuringInitializationTest;
import com.rcpcompany.uibindings.extests.manager.ValidationErrorsAreFatalTest;
import com.rcpcompany.uibindings.extests.observables.CountObservableValueTest;
import com.rcpcompany.uibindings.extests.observables.EListElementObservableValueTest;
import com.rcpcompany.uibindings.extests.observables.EListKeyedElementObservableValueTest;
import com.rcpcompany.uibindings.extests.observables.FilteredObservableListTest;
import com.rcpcompany.uibindings.extests.observables.GuardObservableValueTest;
import com.rcpcompany.uibindings.extests.observables.IndexObservableListTest;
import com.rcpcompany.uibindings.extests.observables.Issue44ComboTest;
import com.rcpcompany.uibindings.extests.observables.ListIndexObservableValueTest;
import com.rcpcompany.uibindings.extests.observables.MapperObservableValueTest;
import com.rcpcompany.uibindings.extests.observables.MessageFormatObservableValueTest;
import com.rcpcompany.uibindings.extests.observables.TextObservableValueDisposeTest;
import com.rcpcompany.uibindings.extests.observables.TextObservableValueTest;
import com.rcpcompany.uibindings.extests.observables.ViewerBindingTreeFactoryPerformanceTest;
import com.rcpcompany.uibindings.extests.observables.ViewerBindingTreeFactoryTest;
import com.rcpcompany.uibindings.extests.observables.getset.BasicSetTestValue;
import com.rcpcompany.uibindings.extests.observables.getset.BasicSetTestViewer;
import com.rcpcompany.uibindings.extests.participants.ManagerAssignmentParticipantsManagerTest;
import com.rcpcompany.uibindings.extests.preferences.PreferencePageDialogTest;
import com.rcpcompany.uibindings.extests.preferences.UIBindingPreferencesTest;
import com.rcpcompany.uibindings.extests.propertyTesters.EStructuralFeaturePropertyTesterTest;
import com.rcpcompany.uibindings.extests.quickfixes.BasicQuickfixTest;
import com.rcpcompany.uibindings.extests.quickfixes.DirectoryNameQuickfixTest;
import com.rcpcompany.uibindings.extests.quickfixes.NamingQuickfixTest;
import com.rcpcompany.uibindings.extests.quickfixes.QuickfixMatchingTest;
import com.rcpcompany.uibindings.extests.scripting.AllScriptEngineTest;
import com.rcpcompany.uibindings.extests.services.BasicServiceTest;
import com.rcpcompany.uibindings.extests.sourceProviders.BindingSourceProviderTest;
import com.rcpcompany.uibindings.extests.sourceProviders.CommonSourceProviderTest;
import com.rcpcompany.uibindings.extests.sourceProviders.ManagerSourceProviderTest;
import com.rcpcompany.uibindings.extests.spy.SpyDialogTest;
import com.rcpcompany.uibindings.extests.trees.TreeContentTest;
import com.rcpcompany.uibindings.extests.trees.TreePerformanceTest;
import com.rcpcompany.uibindings.extests.uiAttributeFactories.contentAdapters.ContentAdapterTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeCComboFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeCheckButtonFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeComboFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeFactoryTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeFileNameControlFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeFormFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeHyperlinkFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeImageDecorationTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeLabelFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeLinkFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeListFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributePushButtonFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeRadioGroupFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeRadioGroupTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeScaleFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeScrolledFormFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeSectionFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeShellFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeSliderFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeSpinnerFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeStyledTextFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.uiAttributes.UIAttributeTextFactoryPropertiesTest;
import com.rcpcompany.uibindings.extests.utils.BindingEnablerTest;
import com.rcpcompany.uibindings.extests.utils.BindingObjectInformationTest;
import com.rcpcompany.uibindings.extests.utils.BindingSpecTest;
import com.rcpcompany.uibindings.extests.utils.ClipboardConverterManagerTest;
import com.rcpcompany.uibindings.extests.utils.ControlDecorationTest;
import com.rcpcompany.uibindings.extests.utils.DeleteParticipantTest;
import com.rcpcompany.uibindings.extests.utils.DoubleClickAdapterTest;
import com.rcpcompany.uibindings.extests.utils.EcoreExtUtilsSubclassesTest;
import com.rcpcompany.uibindings.extests.utils.EcoreExtUtilsSyncTest;
import com.rcpcompany.uibindings.extests.utils.ExtendedCommandStackTest;
import com.rcpcompany.uibindings.extests.utils.FeatureListMonitorTest;
import com.rcpcompany.uibindings.extests.utils.FilterTest;
import com.rcpcompany.uibindings.extests.utils.FormChooserTest;
import com.rcpcompany.uibindings.extests.utils.FormCreatorAlignmentTest;
import com.rcpcompany.uibindings.extests.utils.FormCreatorObjectMessageCollectionTest;
import com.rcpcompany.uibindings.extests.utils.FormCreatorTest;
import com.rcpcompany.uibindings.extests.utils.IPathMatcherTest;
import com.rcpcompany.uibindings.extests.utils.ManagerRunnableManagerTest;
import com.rcpcompany.uibindings.extests.utils.MouseDownConverterTest;
import com.rcpcompany.uibindings.extests.utils.OpenCommandTextWidgetEnablementTest;
import com.rcpcompany.uibindings.extests.utils.OpenCommandViewerEnablementTest;
import com.rcpcompany.uibindings.extests.utils.ShowViewSelectionTest;
import com.rcpcompany.uibindings.extests.utils.SortingTest;
import com.rcpcompany.uibindings.extests.utils.StringListTest;
import com.rcpcompany.uibindings.extests.utils.TableCreatorTest;
import com.rcpcompany.uibindings.extests.utils.UIBindingsUtilsMapperTest;
import com.rcpcompany.uibindings.extests.utils.UIBindingsUtilsTest;
import com.rcpcompany.uibindings.extests.valueBindings.BasicValueBindingArgumentsTest;
import com.rcpcompany.uibindings.extests.valueBindings.BasicValueBindingTest;
import com.rcpcompany.uibindings.extests.valueBindings.SIMA1070FormattingOfValues;
import com.rcpcompany.uibindings.extests.valueBindings.SIMA623FocusOutTest;
import com.rcpcompany.uibindings.extests.valueBindings.ValueBindingFocusOutTest;
import com.rcpcompany.uibindings.extests.valueBindings.ValueBindingPreferredControlTest;
import com.rcpcompany.uibindings.extests.valueBindings.ValueEditCellStrategiesTest;
import com.rcpcompany.uibindings.extests.valueBindings.ValueUnsettableTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ChildCreationSpecificationTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ColumnIndexTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ColumnVisibilityTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ControlCellEditorTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ElementParentageTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerCellNavigationStrategyTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerCellValuesTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerColumnHeaderAlignment;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerDisposeTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerEditCellCommitStrategiesTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerEditCellStrategiesTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerEditCheckboxTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerItemMoveEnabledTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerItemMoveTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerReflowTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerSingleSelectionTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerTableDeleteElementTest;
import com.rcpcompany.uibindings.extests.widgets.FileNameControlTest;
import com.rcpcompany.uibindings.extests.wizards.FormChooserWizardTest;
import com.rcpcompany.uibindings.internal.ManagerSizesTest;
import com.rcpcompany.uibindings.internal.decorators.extenders.ExtenderTest;
import com.rcpcompany.uibindings.internal.decorators.extenders.OpenCommandSupportLowLevelTest;
import com.rcpcompany.uibindings.internal.utils.BindingContextSelectionProviderTest;
import com.rcpcompany.uibindings.internal.utils.CommandToStringTest;
import com.rcpcompany.uibindings.internal.utils.GlobalNavigationManagerTest;
import com.rcpcompany.uibindings.internal.utils.ViewerToolBarBaseTest;
import com.rcpcompany.uibindings.internal.utils.ViewerToolBarFunctionTest;
import com.rcpcompany.uibindings.internal.utils.ViewerToolBarItemPresentTest;
import com.rcpcompany.uibindings.internal.validators.BasicMessageCollectionTest;
import com.rcpcompany.uibindings.internal.validators.BindingMessageCollectionTest;
import com.rcpcompany.uibindings.internal.validators.BindingObjectMessageCollectionTest;
import com.rcpcompany.uibindings.internal.validators.ConstraintValidationAdapterCollectionTest;
import com.rcpcompany.uibindings.internal.validators.ContextAdapterCollectionTest;
import com.rcpcompany.uibindings.internal.validators.DiagnosticChainTest;
import com.rcpcompany.uibindings.internal.validators.MessageDecorationMinimumSeverityTest;
import com.rcpcompany.uibindings.internal.validators.ValidationAdapterManagerTest;
import com.rcpcompany.uibindings.quixkfixes.AbstractQuickfixProposalTest;
import com.rcpcompany.uibindings.views.ValidationViewTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({

/*
 * Initial state: no errors during initialization
 */
NoErrorsDuringInitializationTest.class,

/*
 * Basic internal tests.
 */
PluginConfTest.class, PluginSpecificationTest.class, FragmentTest.class, ECoreModelInformationTest.class,

/*
 * Various constants
 */
ConstantTest.class, ColorsAndFontsTest.class, ManagerSizesTest.class,

UsedPropertyNamesTest.class,

/*
 * The manager and its very basic interfaces (no bindings yet...)
 */
ManagerBasicFunctionalityTest.class, ManagerDecoratorProvidersTest.class, ManagerTextCommitStrategyTest.class,
		ManagerTextCommitStrategyDelayTest.class, ManagerEditCellAnyKeyTest.class,
		ManagerEditCellSingleClickTest.class, ManagerMessageDecorationPositionTest.class,
		ManagerMessageDecorationMinimumSeverityTest.class, ManagerAlternativeDecorationPositionTest.class,
		ManagerAutoApplyQuickfixTest.class, ManagerAlternatingRowColors.class, AlternatingRowColorsTest.class,
		ManagerValidationDelayTest.class, ManagerValidationDelayWindowTest.class, ManagerTreeFunctionalityTest.class,
		ManagerValidationErrorsAreFatal.class, ManagerRequiredVBIDShown.class, ManagerAssistVBIDShown.class,
		ManagerQuickfixVBIDShown.class, ManagerViewNavigationRecorded.class, ManagerFormatterProviderTest.class,
		ManagerDeleteHandlerCheckEnabledTest.class, ManagerArgumentInformationTest.class,

		ManagerAssignmentParticipantsManagerTest.class,

		ConstantDefinitionsTest.class,

		/*
		 * Services and arguments
		 */
		BasicServiceTest.class, ArgumentsSequenceTest.class, ArgumentsTypeTest.class, BindingFormatTest.class,

		BindingDataTypeFactoryTest.class,

		/*
		 * More advanced but still basic tests...
		 */
		ValidationErrorsAreFatalTest.class, SimplePreferredCellEditorTest.class, PreferredCellEditorFactoryTest.class,

		ManagerDecoratorExtendersTest.class, ManagerDecoratorExtendersSortTest.class,

		/*
		 * Some utility functions
		 */
		UIBindingsUtilsTest.class, UIBindingsUtilsMapperTest.class, ControlDecorationTest.class,

		/*
		 * Utilities
		 */
		BindingSpecTest.class, IPathMatcherTest.class, EcoreExtUtilsSyncTest.class, EcoreExtUtilsSubclassesTest.class,
		ViewerToolBarBaseTest.class, ViewerToolBarFunctionTest.class, ViewerToolBarItemPresentTest.class,

		DeleteParticipantTest.class,

		/*
		 * Source Providers
		 */
		CommonSourceProviderTest.class, BindingSourceProviderTest.class, ManagerSourceProviderTest.class,

		/*
		 * Extenders
		 * 
		 * TODO
		 */
		ExtenderTest.class, EnumImageExtenderTest.class,

		/*
		 * PropertyTesters
		 * 
		 * TODO
		 */
		EStructuralFeaturePropertyTesterTest.class,

		/*
		 * Specific observables
		 * 
		 * TODO: all for home grown
		 */
		TextObservableValueDisposeTest.class, TextObservableValueTest.class, CountObservableValueTest.class,
		MessageFormatObservableValueTest.class, GuardObservableValueTest.class, MapperObservableValueTest.class,
		EListElementObservableValueTest.class, EListKeyedElementObservableValueTest.class,
		ViewerBindingTreeFactoryTest.class, ViewerBindingTreeFactoryPerformanceTest.class,
		IndexObservableListTest.class, FilteredObservableListTest.class, ListIndexObservableValueTest.class,

		/*
		 * UI Attributes
		 */
		UIAttributeFactoryTest.class, UIAttributeLabelFactoryPropertiesTest.class,
		UIAttributeTextFactoryPropertiesTest.class, UIAttributeStyledTextFactoryPropertiesTest.class,
		UIAttributeComboFactoryPropertiesTest.class, UIAttributeCComboFactoryPropertiesTest.class,
		UIAttributePushButtonFactoryPropertiesTest.class, UIAttributeCheckButtonFactoryPropertiesTest.class,
		UIAttributeFormFactoryPropertiesTest.class, UIAttributeScrolledFormFactoryPropertiesTest.class,
		UIAttributeSectionFactoryPropertiesTest.class, UIAttributeHyperlinkFactoryPropertiesTest.class,
		UIAttributeLinkFactoryPropertiesTest.class, UIAttributeListFactoryPropertiesTest.class,
		UIAttributeScaleFactoryPropertiesTest.class, UIAttributeSpinnerFactoryPropertiesTest.class,
		UIAttributeSliderFactoryPropertiesTest.class, UIAttributeShellFactoryPropertiesTest.class,
		UIAttributeRadioGroupFactoryPropertiesTest.class, UIAttributeRadioGroupTest.class,
		UIAttributeFileNameControlFactoryPropertiesTest.class, UIAttributeImageDecorationTest.class,

		/*
		 * Basic use of bindings
		 */
		ContextActivationTest.class,

		BasicValueBindingTest.class, BasicValueBindingArgumentsTest.class, BasicSetTestValue.class,
		BasicSetTestViewer.class, ReadonlyTest.class, CreationPointTest.class, ValueEditCellStrategiesTest.class,
		ValueUnsettableTest.class, ValueBindingPreferredControlTest.class, ValueBindingFocusOutTest.class,
		BindingDisposeTest.class, BindingControlDisposeTest.class, SIMA1070FormattingOfValues.class,

		ContextNoCommitTest.class, ContextEditingDomainTest.class, ContextEditingDomainCommitTest.class,

		BindingContextFinalizerTest.class, BindingSetFocusTest.class,

		/*
		 * Viewer bindings
		 */
		ViewerCellValuesTest.class, ViewerCellNavigationStrategyTest.class, ViewerReflowTest.class,
		ViewerDisposeTest.class, ViewerEditCellStrategiesTest.class, ViewerEditCheckboxTest.class,
		ViewerTableDeleteElementTest.class, ViewerItemMoveEnabledTest.class, ViewerItemMoveTest.class,
		ViewerSingleSelectionTest.class, ViewerEditCellCommitStrategiesTest.class, ColumnVisibilityTest.class,
		ColumnIndexTest.class, ViewerColumnHeaderAlignment.class, ElementParentageTest.class,
		ChildCreationSpecificationTest.class, ControlCellEditorTest.class,

		/*
		 * Trees
		 */
		ManagerTreeFunctionalityTest.class, TreeContentTest.class, TreePerformanceTest.class,

		/*
		 * Widgets
		 */
		FileNameControlTest.class,

		/*
		 * Decorators
		 */
		DecoratorProviderTest.class, SpecialDecoratorProviderTest.class, EnumDecoratorProviderTest.class,
		NumberDecoratorProviderRangeTest.class, NumberDecoratorProviderTest.class,
		NumberDecoratorProviderSpecialFPTest.class, EObjectCreatorDecoratorProviderTest.class,
		NumberDecoratorProviderUnitTest.class,

		ValueBindingMessageImageDecoratorImageTest.class,

		/*
		 * The content adapters
		 */
		ContentAdapterTest.class,

		/*
		 * Validation
		 */
		ValidationAdapterManagerTest.class, BasicMessageCollectionTest.class,
		MessageDecorationMinimumSeverityTest.class, DiagnosticChainTest.class, BindingMessageCollectionTest.class,
		BindingObjectMessageCollectionTest.class, ValidationAdapterManagerMasterDetailTest.class,
		LabelDecoratorTest.class, LabelDecoratorListenerTest.class, ConstraintValidationAdapterCollectionTest.class,

		/*
		 * Forms.
		 */
		ScrolledFormAdapterTest.class, ContextAdapterCollectionTest.class,

		/*
		 * Quickfixes
		 */
		BasicQuickfixTest.class, QuickfixMatchingTest.class, AbstractQuickfixProposalTest.class,
		NamingQuickfixTest.class, DirectoryNameQuickfixTest.class,

		/*
		 * Leaks and other specific issues
		 */
		ViewerEditorLeakTest.class, SIMO302EObjectObservableValueLeakTest.class, Issue44ComboTest.class,
		SIMO182BugInUIBindingForTableCellEditor.class, SIMA621ProblemsIncreases.class, SIMA623FocusOutTest.class,

		/*
		 * Filters, sorters, creators, etc
		 */
		FilterTest.class, SortingTest.class, FormChooserTest.class, FormCreatorTest.class,
		FormCreatorAlignmentTest.class, FormCreatorObjectMessageCollectionTest.class, TableCreatorTest.class,
		DoubleClickAdapterTest.class, GlobalNavigationManagerTest.class, MouseDownConverterTest.class,
		BindingObjectInformationTest.class, BindingContextSelectionProviderTest.class,

		FormChooserWizardTest.class, BindingEnablerTest.class, StringListTest.class,

		ManagerRunnableManagerTest.class, ClipboardConverterManagerTest.class,

		ExtendedCommandStackTest.class, FeatureListMonitorTest.class,

		/*
		 * Composite Forms
		 */
		CompositeFormBasicTest.class, CompositeFormCreateTest.class,

		/*
		 * Cut, copy and paste
		 */
		CopyPasteInViewerTest.class, SuperPasteTest.class, SuperCreateTest.class,

		/*
		 * Show View, Open Command
		 */
		ShowViewSelectionTest.class, OpenCommandSupportLowLevelTest.class, OpenCommandTextWidgetEnablementTest.class,
		OpenCommandViewerEnablementTest.class,

		/*
		 * Dialogs, Views
		 */
		PreferencePageDialogTest.class, UIBindingPreferencesTest.class,

		SpyDialogTest.class, ValidationViewTest.class, CommandToStringTest.class,

		/*
		 * Script Engine
		 */
		AllScriptEngineTest.class

})
public class AllBindingTests {
}
