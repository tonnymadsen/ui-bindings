package com.rcpcompany.uibindings.extests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.rcpcompany.uibindings.bindingMessages.LabelDecoratorListenerTest;
import com.rcpcompany.uibindings.extests.bindingDataTypes.BindingDataTypeFactoryTest;
import com.rcpcompany.uibindings.extests.bindingMessages.LabelDecoratorTest;
import com.rcpcompany.uibindings.extests.bindingMessages.ScrolledFormAdapterTest;
import com.rcpcompany.uibindings.extests.bindingMessages.ValidationAdapterManagerMasterDetailTest;
import com.rcpcompany.uibindings.extests.bindingMessages.ValueBindingMessageImageDecoratorImageTest;
import com.rcpcompany.uibindings.extests.bindings.ArgumentsScopeTest;
import com.rcpcompany.uibindings.extests.bindings.ArgumentsTypeTest;
import com.rcpcompany.uibindings.extests.bindings.BindingDisposeTest;
import com.rcpcompany.uibindings.extests.bindings.BindingFormatTest;
import com.rcpcompany.uibindings.extests.bindings.ContextEditingDomainCommitTest;
import com.rcpcompany.uibindings.extests.bindings.ContextEditingDomainTest;
import com.rcpcompany.uibindings.extests.bindings.ContextNoCommitTest;
import com.rcpcompany.uibindings.extests.bindings.CreationPointTest;
import com.rcpcompany.uibindings.extests.bindings.PreferredCellEditorFactoryTest;
import com.rcpcompany.uibindings.extests.bindings.ReadonlyTest;
import com.rcpcompany.uibindings.extests.bindings.SimplePreferredCellEditorTest;
import com.rcpcompany.uibindings.extests.bindings.extenders.EnumImageExtenderTest;
import com.rcpcompany.uibindings.extests.contexts.ContextActivationTest;
import com.rcpcompany.uibindings.extests.cutCopyPaste.CopyPasteInViewerTest;
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
import com.rcpcompany.uibindings.extests.manager.ManagerAlternatingRowColors;
import com.rcpcompany.uibindings.extests.manager.ManagerAlternativeDecorationPositionTest;
import com.rcpcompany.uibindings.extests.manager.ManagerAssistVBIDShown;
import com.rcpcompany.uibindings.extests.manager.ManagerAutoApplyQuickfixTest;
import com.rcpcompany.uibindings.extests.manager.ManagerBasicFunctionalityTest;
import com.rcpcompany.uibindings.extests.manager.ManagerDecoratorExtendersSortTest;
import com.rcpcompany.uibindings.extests.manager.ManagerDecoratorExtendersTest;
import com.rcpcompany.uibindings.extests.manager.ManagerDecoratorProvidersTest;
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
import com.rcpcompany.uibindings.extests.manager.ManagerValidationErrorsAreFatal;
import com.rcpcompany.uibindings.extests.manager.ManagerViewNavigationRecorded;
import com.rcpcompany.uibindings.extests.manager.NoErrorsDuringInitializationTest;
import com.rcpcompany.uibindings.extests.manager.ValidationErrorsAreFatalTest;
import com.rcpcompany.uibindings.extests.observables.CountObservableValueTest;
import com.rcpcompany.uibindings.extests.observables.EListKeyedElementObservableValueTest;
import com.rcpcompany.uibindings.extests.observables.GuardObservableValueTest;
import com.rcpcompany.uibindings.extests.observables.Issue44ComboTest;
import com.rcpcompany.uibindings.extests.observables.MapperObservableValueTest;
import com.rcpcompany.uibindings.extests.observables.MessageFormatObservableValueTest;
import com.rcpcompany.uibindings.extests.observables.TextObservableValueDisposeTest;
import com.rcpcompany.uibindings.extests.observables.TextObservableValueTest;
import com.rcpcompany.uibindings.extests.observables.ViewerBindingTreeFactoryPerformanceTest;
import com.rcpcompany.uibindings.extests.observables.ViewerBindingTreeFactoryTest;
import com.rcpcompany.uibindings.extests.observables.getset.BasicSetTestValue;
import com.rcpcompany.uibindings.extests.observables.getset.BasicSetTestViewer;
import com.rcpcompany.uibindings.extests.preferences.PreferencePageDialogTest;
import com.rcpcompany.uibindings.extests.quickfixes.BasicQuickfixTest;
import com.rcpcompany.uibindings.extests.quickfixes.NamingQuickfixTest;
import com.rcpcompany.uibindings.extests.quickfixes.QuickfixMatchingTest;
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
import com.rcpcompany.uibindings.extests.utils.BindingObjectLongNameTest;
import com.rcpcompany.uibindings.extests.utils.BindingSpecTest;
import com.rcpcompany.uibindings.extests.utils.ControlDecorationTest;
import com.rcpcompany.uibindings.extests.utils.DoubleClickAdapterTest;
import com.rcpcompany.uibindings.extests.utils.EcoreExtUtilsSyncTest;
import com.rcpcompany.uibindings.extests.utils.FilterTest;
import com.rcpcompany.uibindings.extests.utils.FormChooserTest;
import com.rcpcompany.uibindings.extests.utils.FormCreatorTest;
import com.rcpcompany.uibindings.extests.utils.IPathMatcherTests;
import com.rcpcompany.uibindings.extests.utils.MouseDownConverterTest;
import com.rcpcompany.uibindings.extests.utils.OpenCommandTextWidgetEnablementTest;
import com.rcpcompany.uibindings.extests.utils.OpenCommandViewerEnablementTest;
import com.rcpcompany.uibindings.extests.utils.ShowViewSelectionTest;
import com.rcpcompany.uibindings.extests.utils.SortingTest;
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
import com.rcpcompany.uibindings.extests.viewerBindings.ColumnVisibilityTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerCellValuesTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerColumnHeaderAlignment;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerDisposeTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerEditCellCommitStrategiesTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerEditCellStrategiesTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerEditCheckboxTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerItemDeletorTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerItemMoveTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerReflowTest;
import com.rcpcompany.uibindings.extests.viewerBindings.ViewerSingleSelectionTest;
import com.rcpcompany.uibindings.extests.widgets.FileNameControlTest;
import com.rcpcompany.uibindings.internal.ManagerSizesTest;
import com.rcpcompany.uibindings.internal.decorators.extenders.OpenCommandSupportLowLevelTest;
import com.rcpcompany.uibindings.internal.utils.GlobalNavigationManagerTest;
import com.rcpcompany.uibindings.internal.utils.ViewerToolBarBaseTests;
import com.rcpcompany.uibindings.internal.utils.ViewerToolBarFunctionTests;
import com.rcpcompany.uibindings.internal.utils.ViewerToolBarItemPresentTests;
import com.rcpcompany.uibindings.internal.validators.BasicMessageCollectionTest;
import com.rcpcompany.uibindings.internal.validators.BindingMessageCollectionTest;
import com.rcpcompany.uibindings.internal.validators.BindingObjectMessageCollectionTest;
import com.rcpcompany.uibindings.internal.validators.ContextAdapterCollectionTest;
import com.rcpcompany.uibindings.internal.validators.DiagnosticChainTest;
import com.rcpcompany.uibindings.internal.validators.MessageDecorationMinimumSeverityTest;
import com.rcpcompany.uibindings.internal.validators.ValidationAdapterManagerTest;
import com.rcpcompany.uibindings.quixkfixes.AbstractQuickfixProposalTest;
import com.rcpcompany.uibindings.tests.PluginTest;
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
PluginTest.class, PluginConfTest.class,

/*
 * Various constants
 */
ConstantTests.class, ColorsAndFontsTests.class, ManagerSizesTest.class,

/*
 * The manager and its interfaces
 */
ManagerBasicFunctionalityTest.class, ManagerDecoratorProvidersTest.class, ManagerTextCommitStrategyTest.class,
		ManagerTextCommitStrategyDelayTest.class, ManagerEditCellAnyKeyTest.class,
		ManagerEditCellSingleClickTest.class, ManagerMessageDecorationPositionTest.class,
		ManagerMessageDecorationMinimumSeverityTest.class, ManagerAlternativeDecorationPositionTest.class,
		ManagerAutoApplyQuickfixTest.class, ManagerAlternatingRowColors.class, AlternatingRowColorsTest.class,
		ManagerValidationDelayTest.class, ManagerTreeFunctionalityTest.class, ManagerValidationErrorsAreFatal.class,
		ValidationErrorsAreFatalTest.class, ManagerRequiredVBIDShown.class, ManagerAssistVBIDShown.class,
		ManagerQuickfixVBIDShown.class, ManagerViewNavigationRecorded.class, ManagerFormatterProviderTest.class,

		SimplePreferredCellEditorTest.class, PreferredCellEditorFactoryTest.class,

		ManagerDecoratorExtendersTest.class, ManagerDecoratorExtendersSortTest.class,

		/*
		 * Some utility functions
		 */
		UIBindingsUtilsTest.class, UIBindingsUtilsMapperTest.class, ControlDecorationTest.class,

		/*
		 * Services and arguments
		 */
		BasicServiceTest.class, ArgumentsScopeTest.class, ArgumentsTypeTest.class, BindingFormatTest.class,

		BindingDataTypeFactoryTest.class,

		/*
		 * Utilities
		 */
		BindingSpecTest.class, IPathMatcherTests.class, EcoreExtUtilsSyncTest.class, ViewerToolBarBaseTests.class,
		ViewerToolBarFunctionTests.class, ViewerToolBarItemPresentTests.class,

		/*
		 * Source Providers
		 */
		CommonSourceProviderTest.class, BindingSourceProviderTest.class, ManagerSourceProviderTest.class,

		/*
		 * Extenders
		 * 
		 * TODO
		 */
		EnumImageExtenderTest.class,

		/*
		 * Specific observables
		 * 
		 * TODO: all for home grown
		 */
		TextObservableValueDisposeTest.class, TextObservableValueTest.class, CountObservableValueTest.class,
		MessageFormatObservableValueTest.class, GuardObservableValueTest.class, MapperObservableValueTest.class,
		EListKeyedElementObservableValueTest.class, ViewerBindingTreeFactoryTest.class,
		ViewerBindingTreeFactoryPerformanceTest.class,

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
		BindingDisposeTest.class, SIMA1070FormattingOfValues.class,

		ContextNoCommitTest.class, ContextEditingDomainTest.class, ContextEditingDomainCommitTest.class,

		/*
		 * Viewer bindings
		 */
		ViewerCellValuesTest.class, ViewerReflowTest.class, ViewerDisposeTest.class,
		ViewerEditCellStrategiesTest.class, ViewerEditCheckboxTest.class, ViewerItemDeletorTest.class,
		ViewerItemMoveTest.class, ViewerSingleSelectionTest.class, ViewerEditCellCommitStrategiesTest.class,
		ColumnVisibilityTest.class, ViewerEditCellStrategiesTest.class, ViewerColumnHeaderAlignment.class,

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
		LabelDecoratorTest.class, LabelDecoratorListenerTest.class,

		/*
		 * Forms.
		 */
		ScrolledFormAdapterTest.class, ContextAdapterCollectionTest.class,

		/*
		 * Quickfixes
		 */
		BasicQuickfixTest.class, QuickfixMatchingTest.class, AbstractQuickfixProposalTest.class,
		NamingQuickfixTest.class,

		/*
		 * Leaks and other specific issues
		 */
		ViewerEditorLeakTest.class, SIMO302EObjectObservableValueLeakTest.class, Issue44ComboTest.class,
		SIMO182BugInUIBindingForTableCellEditor.class, SIMA621ProblemsIncreases.class, SIMA623FocusOutTest.class,

		/*
		 * Filters, sorters, creators, etc
		 */
		FilterTest.class, SortingTest.class, FormChooserTest.class, FormCreatorTest.class, TableCreatorTest.class,
		DoubleClickAdapterTest.class, GlobalNavigationManagerTest.class, MouseDownConverterTest.class,
		BindingObjectLongNameTest.class,

		/*
		 * Cut, copy and paste
		 */
		CopyPasteInViewerTest.class,

		/*
		 * Show View, Open Command
		 */
		ShowViewSelectionTest.class, OpenCommandSupportLowLevelTest.class, OpenCommandTextWidgetEnablementTest.class,
		OpenCommandViewerEnablementTest.class,

		/*
		 * Dialogs, Views
		 */
		PreferencePageDialogTest.class, SpyDialogTest.class, ValidationViewTest.class

})
public class AllBindingTests {
}
