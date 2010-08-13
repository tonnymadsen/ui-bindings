package com.rcpcompany.uibindings.internal;

import javax.xml.soap.Text;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.widgets.FileNameControl;

/**
 * Various <em>internal</em> constants that does not belong anywhere else.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface InternalConstants {
	/**
	 * The widget data key used for all widgets to mark their association with a specific binding.
	 * 
	 * @see IBinding#registerWidget(org.eclipse.swt.widgets.Widget)
	 */
	String WIDGET_KEY = Activator.ID + ".widgetKey"; //$NON-NLS-1$

	/**
	 * The uibindings extension point.
	 * 
	 * @see ManagerImpl#extensionReader()
	 */
	String UIBINDINGS_EXTENSION_POINT = Activator.ID + ".uiBindings"; //$NON-NLS-1$

	String BINDING_DECORATOR_TAG = "bindingDecorator"; //$NON-NLS-1$
	String DECORATOR_EXTENDER_TAG = "decoratorExtender"; //$NON-NLS-1$
	String ARGUMENT_TAG = "argument"; //$NON-NLS-1$
	String STANDARD_ARGUMENTS_TAG = "standardArguments"; //$NON-NLS-1$
	String ATTRIBUTE_TAG = "attribute"; //$NON-NLS-1$
	String VALUE_TAG = "value"; //$NON-NLS-1$
	String EXACT_MODEL_TYPE_MATCH_TAG = "exactModelTypeMatch"; //$NON-NLS-1$
	String ID_TAG = "id"; //$NON-NLS-1$
	String JAVA_TAG = "java"; //$NON-NLS-1$
	String FEATURE_TAG = "feature"; //$NON-NLS-1$
	String FEATURE_NAME_TAG = "featureName"; //$NON-NLS-1$
	String CLASS_TAG = "class"; //$NON-NLS-1$
	String DATATYPE_TAG = "datatype"; //$NON-NLS-1$
	String CODE_TAG = "code"; //$NON-NLS-1$
	String ENUM_TAG = "enum"; //$NON-NLS-1$
	String NUMBER_TAG = "number"; //$NON-NLS-1$
	String PRIORITY_TAG = "priority"; //$NON-NLS-1$
	String JAVA_DECORATOR_TAG = "javaDecorator"; //$NON-NLS-1$
	String PARENT_TAG = "parent"; //$NON-NLS-1$
	String PRIMARY_PARENT_TAG = "primaryParent"; //$NON-NLS-1$
	String TREE_ITEM_RELATION_TAG = "treeItemRelation"; //$NON-NLS-1$
	String TREE_ITEM_TAG = "treeItem"; //$NON-NLS-1$
	String NAME_TAG = "name"; //$NON-NLS-1$
	String MODEL_TAG = "model"; //$NON-NLS-1$
	String PACKAGE_TAG = "package"; //$NON-NLS-1$
	String OBSERVABLES_FACTORY_TAG = "observablesFactory"; //$NON-NLS-1$
	String PROCESSOR_TAG = "processor"; //$NON-NLS-1$
	String MESSAGE_PATTERN_TAG = "messagePattern"; //$NON-NLS-1$
	String QUICKFIX_PROCESSOR_TAG = "quickfixProcessor"; //$NON-NLS-1$
	String WIDGET_TYPE_TAG = "widgetType"; //$NON-NLS-1$
	String UI_ATTRIBUTE_FACTORY_TAG = "uiAttributeFactory"; //$NON-NLS-1$
	String SOURCE_TAG = "source"; //$NON-NLS-1$
	String MODEL_TYPE_TAG = "modelType"; //$NON-NLS-1$
	String UI_TAG = "ui"; //$NON-NLS-1$
	String UI_TYPE_TAG = "uiType"; //$NON-NLS-1$
	String IMAGE_TAG = "image"; //$NON-NLS-1$
	String TYPE_TAG = "type"; //$NON-NLS-1$
	String TARGET_TYPE_TAG = "targetType"; //$NON-NLS-1$
	String DEFAULT_MAPPINGS_TAG = "defaultMappings"; //$NON-NLS-1$
	String MAPPING_TAG = "mapping"; //$NON-NLS-1$
	String ALSO_PRIMITIVE_TAG = "alsoPrimitive"; //$NON-NLS-1$
	String MODEL_ARGUMENT_MEDIATOR_TAG = "modelArgumentMediator"; //$NON-NLS-1$
	String EMPTY_FOLDER_HIDDEN_TAG = "emptyFolderHidden"; //$NON-NLS-1$

	/**
	 * Cell Editor Type: Text.
	 */
	String CELL_EDITOR_TYPE_TEXT = Text.class.getName();

	/**
	 * Cell Editor Type: StyledText.
	 */
	String CELL_EDITOR_TYPE_STYLED_TEXT = StyledText.class.getName();

	/**
	 * Cell Editor Type: Button (really checkbox).
	 */
	String CELL_EDITOR_TYPE_BUTTON = Button.class.getName();

	/**
	 * Cell Editor Type: Combo.
	 */
	String CELL_EDITOR_TYPE_COMBO = Combo.class.getName();

	/**
	 * Cell Editor Type: CCombo.
	 */
	String CELL_EDITOR_TYPE_CCOMBO = CCombo.class.getName();

	/**
	 * The resource name for the image in {@link FileNameControl} to designate the open dialog
	 * button.
	 */
	String IMG_OPEN_DIALOG = "open-dialog";
}
