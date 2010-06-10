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
public class InternalConstants {

	/**
	 * The widget data key used for all widgets to mark their association with a specific binding.
	 * 
	 * @see IBinding#registerWidget(org.eclipse.swt.widgets.Widget)
	 */
	public static final String WIDGET_KEY = Activator.ID + ".widgetKey"; //$NON-NLS-1$

	/**
	 * The uibindings extension point.
	 * 
	 * @see Manager#extensionReader()
	 */
	public static final String UIBINDINGS_EXTENSION_POINT = Activator.ID + ".uiBindings"; //$NON-NLS-1$

	public static final String BINDING_DECORATOR_TAG = "bindingDecorator"; //$NON-NLS-1$
	public static final String DECORATOR_EXTENDER_TAG = "decoratorExtender"; //$NON-NLS-1$
	public static final String ARGUMENT_TAG = "argument"; //$NON-NLS-1$
	public static final String ATTRIBUTE_TAG = "attribute"; //$NON-NLS-1$
	public static final String VALUE_TAG = "value"; //$NON-NLS-1$
	public static final String EXACT_MODEL_TYPE_MATCH_TAG = "exactModelTypeMatch"; //$NON-NLS-1$
	public static final String ID_TAG = "id"; //$NON-NLS-1$
	public static final String JAVA_TAG = "java"; //$NON-NLS-1$
	public static final String FEATURE_TAG = "feature"; //$NON-NLS-1$
	public static final String FEATURE_NAME_TAG = "featureName"; //$NON-NLS-1$
	public static final String CLASS_TAG = "class"; //$NON-NLS-1$
	public static final String DATATYPE_TAG = "datatype"; //$NON-NLS-1$
	public static final String CODE_TAG = "code"; //$NON-NLS-1$
	public static final String ENUM_TAG = "enum"; //$NON-NLS-1$
	public static final String NUMBER_TAG = "number"; //$NON-NLS-1$
	public static final String PRIORITY_TAG = "priority"; //$NON-NLS-1$
	public static final String JAVA_DECORATOR_TAG = "javaDecorator"; //$NON-NLS-1$
	public static final String PARENT_TAG = "parent"; //$NON-NLS-1$
	public static final String TREE_ITEM_RELATION_TAG = "treeItemRelation"; //$NON-NLS-1$
	public static final String TREE_ITEM_TAG = "treeItem"; //$NON-NLS-1$
	public static final String NAME_TAG = "name"; //$NON-NLS-1$
	public static final String MODEL_TAG = "model"; //$NON-NLS-1$
	public static final String PACKAGE_TAG = "package"; //$NON-NLS-1$
	public static final String OBSERVABLES_FACTORY_TAG = "observablesFactory"; //$NON-NLS-1$
	public static final String PROCESSOR_TAG = "processor"; //$NON-NLS-1$
	public static final String MESSAGE_PATTERN_TAG = "messagePattern"; //$NON-NLS-1$
	public static final String QUICKFIX_PROCESSOR_TAG = "quickfixProcessor"; //$NON-NLS-1$
	public static final String WIDGET_TYPE_TAG = "widgetType"; //$NON-NLS-1$
	public static final String UI_ATTRIBUTE_FACTORY_TAG = "uiAttributeFactory"; //$NON-NLS-1$
	public static final String SOURCE_TAG = "source"; //$NON-NLS-1$
	public static final String MODEL_TYPE_TAG = "modelType"; //$NON-NLS-1$
	public static final String UI_TAG = "ui"; //$NON-NLS-1$
	public static final String UI_TYPE_TAG = "uiType"; //$NON-NLS-1$
	public static final String IMAGE_TAG = "image"; //$NON-NLS-1$
	public static final String TYPE_TAG = "type"; //$NON-NLS-1$
	public static final String TARGET_TYPE_TAG = "targetType"; //$NON-NLS-1$
	public static final String DEFAULT_MAPPINGS_TAG = "defaultMappings"; //$NON-NLS-1$
	public static final String MAPPING_TAG = "mapping"; //$NON-NLS-1$
	public static final String ALSO_PRIMITIVE_TAG = "alsoPrimitive"; //$NON-NLS-1$
	public static final String MODEL_ARGUMENT_MEDIATOR_TAG = "modelArgumentMediator"; //$NON-NLS-1$

	/**
	 * Cell Editor Type: Text
	 */
	public static final String CELL_EDITOR_TYPE_TEXT = Text.class.getName();

	/**
	 * Cell Editor Type: StyledText
	 */
	public static final String CELL_EDITOR_TYPE_STYLED_TEXT = StyledText.class.getName();

	/**
	 * Cell Editor Type: Button (really checkbox)
	 */
	public static final String CELL_EDITOR_TYPE_BUTTON = Button.class.getName();

	/**
	 * Cell Editor Type: Combo
	 */
	public static final String CELL_EDITOR_TYPE_COMBO = Combo.class.getName();

	/**
	 * Cell Editor Type: CCombo
	 */
	public static final String CELL_EDITOR_TYPE_CCOMBO = CCombo.class.getName();

	/**
	 * The resource name for the image in {@link FileNameControl} to designate the open dialog button.
	 */
	public static final String IMG_OPEN_DIALOG = "open-dialog";
}
