/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings;

import java.text.MessageFormat;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.ExpressionInfo;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.ISources;

import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.decorators.NumberBindingDecorator;
import com.rcpcompany.uibindings.internal.handlers.DeleteHandler;
import com.rcpcompany.uibindings.internal.propertyTesters.EObjectPropertyTester;
import com.rcpcompany.uibindings.internal.propertyTesters.EStructuralFeaturePropertyTester;
import com.rcpcompany.uibindings.internal.propertyTesters.IViewerBindingPropertyTester;
import com.rcpcompany.uibindings.internal.propertyTesters.ManagerPropertyTester;
import com.rcpcompany.uibindings.units.IUnitBindingSupport;
import com.rcpcompany.uibindings.utils.IBindingHighlightContext;
import com.rcpcompany.uibindings.utils.IGlobalNavigationManager;
import com.rcpcompany.uibindings.validators.ConstraintValidatorAdapter;

/**
 * Various constants that does not belong anywhere else.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface Constants {

	/**
	 * The EMF annotation source name for annotations on EMF objects that are used by the UI
	 * Bindings framework.
	 */
	String EMF_ANNOTATION_SOURCE = "http://rcp-company.com/schemas/uibindings"; //$NON-NLS-1$

	/**
	 * Argument name for the message format of a value.
	 * <p>
	 * The argument value is {@link String}. In most cases, this effectively makes the binding
	 * read-only. Not all decorators supports this argument. The format is described in
	 * {@link MessageFormat}.
	 */
	String ARG_MESSAGE_FORMAT = "format"; //$NON-NLS-1$

	/**
	 * Argument name for the label of a structural feature or a class when it cannot be deduced
	 * correctly automatically.
	 * <p>
	 * The argument value is {@link String}. The default is found automatically based on the name of
	 * the structural feature or class.
	 */
	String ARG_LABEL = "label"; //$NON-NLS-1$

	/**
	 * Argument name for the constant text to use for a binding.
	 * <p>
	 * Primary used for constant cells in trees
	 * <p>
	 * The argument value is {@link String}.
	 */
	String ARG_TEXT = "text"; //$NON-NLS-1$

	/**
	 * Argument name for the label used instead of the empty string for <code>null</code> values.
	 * <p>
	 * The argument value is {@link String}. The default is the empty string.
	 */
	String ARG_NULL_LABEL = "nullLabel"; //$NON-NLS-1$

	/**
	 * Argument name for the width of the binding.
	 * <p>
	 * The argument value is {@link Integer}.
	 */
	String ARG_WIDTH = "width"; //$NON-NLS-1$

	/**
	 * Argument name for whether to validate a feature in {@link ConstraintValidatorAdapter}.
	 * <p>
	 * The argument value is {@link Boolean} and defaults to <code>true</code>.
	 */
	String ARG_CONSTRAINTS_VALIDATE = ConstraintValidatorAdapter.class.getSimpleName();

	/**
	 * Argument name for the height of the binding.
	 * <p>
	 * The argument value is {@link Integer}.
	 */
	String ARG_HEIGHT = "height"; //$NON-NLS-1$

	/**
	 * Argument name for dynamic bindings.
	 * <p>
	 * The argument value is {@link Boolean}. The default is <code>false</code>.
	 */
	String ARG_DYNAMIC = "dynamic"; //$NON-NLS-1$

	/**
	 * Argument name for columns that should have "label decoration". Only relevant for
	 * {@link IColumnBinding}.
	 * <p>
	 * The argument value is {@link Boolean}. The default is <code>false</code>.
	 */
	String ARG_LABEL_DECORATOR = "labelDecorator"; //$NON-NLS-1$

	/**
	 * Argument name for the image to show with the value.
	 * <p>
	 * The argument value is {@link ImageDescriptor}. The default is no image.
	 * <p>
	 * When used with the <code>uiBindings</code> extension point, this is expected to be a plug-in
	 * local image.
	 */
	String ARG_IMAGE = "image"; //$NON-NLS-1$

	/**
	 * Argument name for whether to show an image for a binding with an parent binding.
	 * <p>
	 * E.g. for cells in viewers and grids.
	 * <p>
	 * The argument value is {@link Boolean}. The default is <code>false</code>.
	 */
	String ARG_SHOW_IMAGE = "showImage";

	/**
	 * Argument name for when a "new" value is allowed. Depends on the actual type of the value.
	 * <ul>
	 * <li>for an entity, whether new objects can be created</li>
	 * <li>for a reference, whether new values are allowed apart from the current set</li>
	 * <li>for file and directory names, whether a file may not exist</li>
	 * </ul>
	 * The argument value is either {@link Boolean#TRUE} or {@link Boolean#FALSE}. The default is
	 * <code>true</code> .
	 */
	String ARG_NEW_ALLOWED = "newAllowed"; //$NON-NLS-1$

	/**
	 * Argument name for when all (error and warning) messages for the model object or objects of
	 * the binding should be added to the context automatically.
	 * <p>
	 * The meaning of the argument differs slightly for different bindings:
	 * <ul>
	 * <li>For a {@link IValueBinding value binding}, this means all messages associated with the
	 * model object will be decorated in the binding.</li>
	 * <li>For a {@link IViewerBinding viewer binding}, this means all messages associated with any
	 * of the row elements will be associated with the viewer. The messages will not be decorated in
	 * the viewer and thus it is normally better to use the argument for a specific column in the
	 * viewer.</li>
	 * <li>For a {@link IColumnBinding column binding}, this means all messages associated with the
	 * model object of the specific column and row will be decorated in the column.</li>
	 * </ul>
	 * <p>
	 * The argument value is either {@link Boolean#TRUE} or {@link Boolean#FALSE}. The default is
	 * <code>false</code>.
	 */
	String ARG_MODEL_OBJECT_MESSAGES = "modelObjectMessages"; //$NON-NLS-1$

	/**
	 * Argument name for when all (error and warning) messages for the value object or objects of
	 * the binding should be added to the context automatically.
	 * <p>
	 * This is of particular interest when a binding is for a reference and not an attribute.
	 * <p>
	 * The argument value is either {@link Boolean#TRUE} or {@link Boolean#FALSE}. The default is
	 * <code>false</code>.
	 */
	String ARG_VALUE_OBJECT_MESSAGES = "valueObjectMessages"; //$NON-NLS-1$

	/**
	 * Argument name for when one field is filtered by another field.
	 * <p>
	 * The argument value is an {@link IObservableValue observable value}, but the exact meaning
	 * depends on the context.
	 */
	String ARG_FILTER = "filter"; //$NON-NLS-1$

	/**
	 * Argument name for when an {@link IObservableList observable list} is used to supply all valid
	 * values.
	 * <p>
	 * The argument value is an {@link IObservableList observable list}, but the exact meaning
	 * depends on the context.
	 */
	String ARG_VALID_VALUES = "validValues"; //$NON-NLS-1$

	/**
	 * Argument name for the tree ID of a {@link IViewerBinding} with a {@link Tree}.
	 * <p>
	 * Used to control the items that are available in the navigator. See the
	 * <code>com.rcpcompany.uibindings.uiBindings</code> extension point.
	 * <p>
	 * The argument value is an {@link String} with the ID.
	 */
	String ARG_TREE_ID = "treeID";

	/**
	 * Argument name for a binding should be read/only.
	 * <p>
	 * The argument value is either {@link Boolean#TRUE} or {@link Boolean#FALSE}. The default is
	 * <code>false</code>.
	 */
	String ARG_READONLY = "readonly"; //$NON-NLS-1$

	/**
	 * Argument name for a binding should bahave like a password field.
	 * <p>
	 * The argument value is either {@link Boolean#TRUE} or {@link Boolean#FALSE}. The default is
	 * <code>false</code>.
	 */
	String ARG_PASSWORD = "password";

	/**
	 * Argument name for the tool tip text of a control.
	 * <p>
	 * The argument value is a {@link String}.
	 */
	String ARG_TOOL_TIP_TEXT = "toolTipText"; //$NON-NLS-1$

	/**
	 * Argument name for the help ID of a control.
	 * <p>
	 * The argument value is a {@link String}.
	 */
	String ARG_HELP_ID = "helpID"; //$NON-NLS-1$

	/**
	 * Argument name for the minimum value of a widget.
	 * <p>
	 * The argument value is a {@link Number}.
	 */
	String ARG_MIN = "min"; //$NON-NLS-1$

	/**
	 * Argument name for the maximum value of a widget.
	 * <p>
	 * The argument value is a {@link Number}.
	 */
	String ARG_MAX = "max"; //$NON-NLS-1$

	/**
	 * Argument name for the legal range of a {@link NumberBindingDecorator}.
	 * <p>
	 * The argument value is an interval on the form "[&lt;start&gt;;&lt;end&gt;]". "&lt;start&gt;"
	 * and "&lt;end&gt;" can each be missing meaning the natural limit for the basic decorator type
	 * - e.g. -128 for a byte.
	 * <p>
	 * The intervals are started and ended with a combination of "[" and "]":
	 * <ul>
	 * <li>"[]" - min and max inclusive</li>
	 * <li>"[[" - min inclusive and max exclusive</li>
	 * <li>"]]" - min exclusive and max inclusive</li>
	 * <li>"][" - min and max exclusive</li>
	 * </ul>
	 * <p>
	 * Examples
	 * <ul>
	 * <li>"[1;2]" - 1 &lt;= x &lt;= 2</li>
	 * <li>"[1;2[" - 1 &lt;= x &lt; 2</li>
	 * <li>"[0;1[,[2;3[" - 0 &lt;= x &lt; 1 or 2 &lt;= x &lt; 3</li>
	 * </ul>
	 * <p>
	 * <strong>NOTE:</strong> <em>currently only one interval is supported. In some future a list of
	 * comma separated intervals may be specified.</em>
	 * <p>
	 */
	String ARG_RANGE = "range"; //$NON-NLS-1$

	/**
	 * Argument name for the feature name used to decorate a specific reference.
	 * <p>
	 * The argument value is a {@link String} with The value is a <code>String</code> on the format
	 * "(&lt;reference&gt; '.')* &lt;attribute&gt;".
	 */
	String ARG_FEATURE_NAME = "featureName"; //$NON-NLS-1$

	/**
	 * Argument name for the allowed extensions of file name.
	 * <p>
	 * On the form "extension-group("///"extension-group)*", where each extension group is on the
	 * form "[label:]filter(";"filter)*" and each filter is on the glob form - e.g. "*.xxx".
	 * <p>
	 * See <a href="http://java.sun.com/docs/books/tutorial/essential/io/fileOps.html#glob">What Is
	 * a Glob?</a>.
	 * <p>
	 * If any of the groups have a label, all must have one.
	 * <p>
	 * Examples:
	 * <ul>
	 * <li>"*.*" - accepts all files</li>
	 * <li>"*.gif;*.png" - extension filter for image files</li>
	 * <li>"Image:*.gif;*.png///Splash:splash.bmp///Icon:*.bmp///Other:*.*" - extension filter for
	 * image and icons files with labels</li>
	 * <li>"/tmp/**" - extension filter all files in /tmp or sub-directories</li>
	 * </ul>
	 * <p>
	 * The argument value is a {@link String String array} with the extensions
	 */
	String ARG_EXTENSIONS = "extensions"; //$NON-NLS-1$

	/**
	 * Argument name for whether a value for this binding is required.
	 * <p>
	 * The argument value is either {@link Boolean#TRUE} or {@link Boolean#FALSE}. The default is
	 * false.
	 */
	String ARG_REQUIRED = "required"; //$NON-NLS-1$

	/**
	 * Argument name for the command to execute to open an item - either via CTRL-click or via a
	 * menu item.
	 * <p>
	 * The argument value is a {@link String} formatted as specified in
	 * {@link ParameterizedCommand#serialize()}.
	 */
	String ARG_OPEN_COMMAND = "openCommand"; //$NON-NLS-1$

	/**
	 * Argument name for the alignment of a binding widget.
	 * <p>
	 * The argument value is one of "left", "center" or "right".
	 */
	String ARG_ALIGNMENT = "alignment"; //$NON-NLS-1$

	/**
	 * Argument name for the command to execute to double-click an item.
	 * <p>
	 * The argument value is a {@link String} formatted as specified in
	 * {@link ParameterizedCommand#serialize()}.
	 */
	String ARG_DOUBLE_CLICK_COMMAND = "doubleClickCommand"; //$NON-NLS-1$

	/**
	 * Argument name for the text commit strategy.
	 * <p>
	 * The argument value is one of {@link TextCommitStrategy}.
	 */
	String ARG_TEXT_COMMIT_STRATEGY = "textCommitStrategy"; //$NON-NLS-1$

	/**
	 * Argument name for the preferred Control for the binding.
	 * <p>
	 * The argument value is the name of a class that
	 * <ul>
	 * <li>Inherits from {@link Control} - directly or indirectly</li>
	 * <li>Supports a constructor {@code (Composite, int)}</li>
	 * </ul>
	 */
	String ARG_PREFERRED_CONTROL = "preferredControl"; //$NON-NLS-1$

	/**
	 * Argument name for the preferred {@link Control} factory for the binding.
	 * <p>
	 * The argument value is {@link IControlFactory}.
	 */
	String ARG_PREFERRED_CONTROL_FACTORY = "preferredControlFactory"; //$NON-NLS-1$

	/**
	 * Argument name for the preferred Control for cell editing for the binding.
	 * <p>
	 * The argument value is one of {@code org.eclipse.swt.widgets.Text},
	 * {@code org.eclipse.swt.widgets.Button}, {@code org.eclipse.swt.widgets.Combo}, or
	 * {@code org.eclipse.swt.custom.CCombo}.
	 */
	String ARG_PREFERRED_CELL_EDITOR = "preferredCellEditor"; //$NON-NLS-1$

	/**
	 * Argument name for the preferred cell editor factory for cell editing for the binding.
	 * <p>
	 * The argument value is {@link ICellEditorFactory}.
	 */
	String ARG_PREFERRED_CELL_EDITOR_FACTORY = "preferredCellEditorFactory"; //$NON-NLS-1$

	/**
	 * Argument name for an initialization participant object for an object of structural feature.
	 * <p>
	 * The argument does not make sense directly in bindings.
	 * <p>
	 * The argument value is {@link IInitializationParticipant}.
	 */
	String ARG_INITIALIZER = "initializer"; //$NON-NLS-1$

	/**
	 * Argument name for a delete participant for a delete operation.
	 * <p>
	 * The argument does not make sense directly in bindings.
	 * <p>
	 * The argument value is {@link IDeleteParticipant}.
	 */
	String ARG_DELETE_PARTICIPANT = "deleteParticipant";

	/**
	 * Argument name for the type of a binding if not specified directly with <code>type(...)</code>
	 * .
	 */
	String ARG_TYPE = "type"; //$NON-NLS-1$

	/**
	 * Argument name for the type of a cell editor binding.
	 */
	String ARG_CELL_EDITOR_TYPE = "cellEditorType"; //$NON-NLS-1$

	/**
	 * Argument name for the unit of a binding.
	 * <p>
	 * The argument is a text string with the base unit type of the binding. E.g. "M". The exact
	 * formaty of the string depends on the current {@link #ARG_UNIT_SUPPORT}.
	 */
	String ARG_UNIT = "unit"; //$NON-NLS-1$

	/**
	 * Argument name for the unit support for a binding.
	 * <p>
	 * The argument value is an {@link IUnitBindingSupport unit binding support object}.
	 */
	String ARG_UNIT_SUPPORT = "unitSupport";

	/**
	 * The arguments that can be used directly as attribute names in the uibindings extension point
	 * for {@link IArgumentProvider argument providers}.
	 */
	String[] EXT_POINT_ATTRIBUTE_NAMES = { ARG_ALIGNMENT, ARG_CELL_EDITOR_TYPE, ARG_DYNAMIC, ARG_EXTENSIONS,
			ARG_FEATURE_NAME, ARG_HEIGHT, ARG_HELP_ID, ARG_IMAGE, ARG_INITIALIZER, ARG_LABEL, ARG_LABEL_DECORATOR,
			ARG_MODEL_OBJECT_MESSAGES, ARG_NEW_ALLOWED, ARG_NULL_LABEL, ARG_OPEN_COMMAND, ARG_PREFERRED_CELL_EDITOR,
			ARG_PREFERRED_CELL_EDITOR_FACTORY, ARG_PREFERRED_CONTROL, ARG_PREFERRED_CONTROL_FACTORY, ARG_RANGE,
			ARG_READONLY, ARG_REQUIRED, ARG_TEXT, ARG_TEXT_COMMIT_STRATEGY, ARG_TOOL_TIP_TEXT, ARG_TYPE, ARG_UNIT,
			ARG_VALUE_OBJECT_MESSAGES, ARG_VALID_VALUES, ARG_WIDTH };

	/**
	 * Property name used in {@link EObjectPropertyTester}.
	 */
	String PROPERTY_CAN_DELETE = "canDelete"; //$NON-NLS-1$

	/**
	 * Property name used in {@link EStructuralFeaturePropertyTester}.
	 */
	String PROPERTY_HAS_DEFAULT_VALUE = "hasDefaultValue"; //$NON-NLS-1$

	/**
	 * Property name used in {@link IViewerBindingPropertyTester}.
	 */
	String PROPERTY_CAN_DELETE_SELECTED_OBJECTS = "canDeleteSelectedObjects"; //$NON-NLS-1$

	/**
	 * Property name used in {@link ManagerPropertyTester}.
	 */
	String PROPERTY_CAN_REDO = "canRedo"; //$NON-NLS-1$

	/**
	 * Property name used in {@link ManagerPropertyTester}.
	 */
	String PROPERTY_CAN_UNDO = "canUndo"; //$NON-NLS-1$

	/**
	 * Prefix for all IDs.
	 */
	String PREFIX = Activator.ID + "."; //$NON-NLS-1$

	/**
	 * The common context ID.
	 */
	String COMMON_CONTEXT_ID = PREFIX + "contexts.baseContext"; //$NON-NLS-1$

	/**
	 * The context ID for the widgets.
	 */
	String WIDGET_CONTEXT_ID = PREFIX + "contexts.widgetContext"; //$NON-NLS-1$

	/**
	 * The context ID for the containers (viewers and grids).
	 */
	String CONTAINER_CONTEXT_ID = PREFIX + "contexts.containerContext"; //$NON-NLS-1$

	/**
	 * The prefix for all sources.
	 */
	String SOURCES = PREFIX + "sourceProviders."; //$NON-NLS-1$

	/**
	 * Source provider name for the manager itself.
	 * <p>
	 * The type of the value is {@link IManager}.
	 */
	String SOURCES_THE_MANAGER = SOURCES + "theManager"; //$NON-NLS-1$

	/**
	 * Source provider name for the {@link Platform} itself.
	 * <p>
	 * The type of the value is {@link Platform}.
	 */
	String SOURCES_PLATFORM = SOURCES + "platform"; //$NON-NLS-1$

	/**
	 * Source provider name for the active binding context.
	 * <p>
	 * The type of the value is {@link IBindingContext}.
	 */
	String SOURCES_ACTIVE_CONTEXT = SOURCES + "activeContext"; //$NON-NLS-1$

	/**
	 * Source provider name for the active binding.
	 * <p>
	 * The type of the value is {@link IBinding}.
	 */
	String SOURCES_ACTIVE_BINDING = SOURCES + "activeBinding"; //$NON-NLS-1$

	/**
	 * Source provider name for the structural feature of current binding value.
	 * <p>
	 * The type of the value is {@link EStructuralFeature}.
	 */
	String SOURCES_ACTIVE_BINDING_FEATURE = SOURCES_ACTIVE_BINDING + "#feature"; //$NON-NLS-1$

	/**
	 * Source provider name for whether the active binding is unsettable.
	 * <p>
	 * The type of the value is {@link Boolean}.
	 */
	String SOURCES_ACTIVE_BINDING_UNSETTABLE = SOURCES_ACTIVE_BINDING + "#unsettable"; //$NON-NLS-1$

	/**
	 * Source provider name for the "open command" of the current binding if any is defined.
	 * <p>
	 * The type of the value is {@link ParameterizedCommand}.
	 */
	String SOURCES_ACTIVE_BINDING_OPEN_COMMAND = SOURCES_ACTIVE_BINDING + "#openCommand"; //$NON-NLS-1$

	/**
	 * Source provider name for the binding type of the active binding or <code>null</code>.
	 * <p>
	 * The type of the value is {@link String}.
	 */
	String SOURCES_ACTIVE_BINDING_TYPE = SOURCES_ACTIVE_BINDING + "#type"; //$NON-NLS-1$

	/**
	 * Source provider name for the model object of the active binding or <code>null</code>.
	 * <p>
	 * The type of the value is {@link Object}.
	 */
	String SOURCES_ACTIVE_BINDING_MODEL_OBJECT = SOURCES_ACTIVE_BINDING + "#modelobject"; //$NON-NLS-1$

	/**
	 * Source provider name for the read-only status of the active binding in the table.
	 * <p>
	 * The type of the value is {@link Boolean}.
	 */
	String SOURCES_ACTIVE_BINDING_RO = SOURCES_ACTIVE_BINDING + "#ro"; //$NON-NLS-1$

	/**
	 * Source provider name for the active binding value. This is defined if
	 * {@link #SOURCES_ACTIVE_BINDING} is non- <code>null</code>.
	 */
	String SOURCES_ACTIVE_BINDING_VALUE = SOURCES_ACTIVE_BINDING + "Value"; //$NON-NLS-1$

	/**
	 * Source provider name for the display value of current binding value.
	 * <p>
	 * The type of the value is {@link String}.
	 */
	String SOURCES_ACTIVE_BINDING_VALUE_DISPLAY = SOURCES_ACTIVE_BINDING_VALUE + "#display"; //$NON-NLS-1$

	/**
	 * Source provider name for the active container binding if any.
	 * <p>
	 * A container binding is a binding that contains the current {@link #SOURCES_ACTIVE_BINDING
	 * active binding} - e.g. a viewer binding or a grid binding
	 * <p>
	 * The type of the value is the container binding.
	 */
	String SOURCES_ACTIVE_CONTAINER_BINDING = SOURCES + "activeContainerBinding"; //$NON-NLS-1$

	/**
	 * Source provider name for the active container binding property "noComparatorOrFilter".
	 * <p>
	 * The type of the value is <code>true</code> if the active container doesn't have a comparator
	 * or filter otherwise <code>false</code>.
	 */
	String SOURCES_ACTIVE_CONTAINER_BINDING_NO_CAF = SOURCES_ACTIVE_CONTAINER_BINDING + "#noComparatorOrFilter"; //$NON-NLS-1$

	/**
	 * Source provider name for the active row element in the table or <code>null</code>.
	 */
	String SOURCES_ACTIVE_VIEWER_ELEMENT = SOURCES + "activeViewerElement"; //$NON-NLS-1$

	/**
	 * Source provider name for the type of row elements in the table or <code>null</code>.
	 */
	String SOURCES_ACTIVE_VIEWER_ELEMENT_TYPE = SOURCES_ACTIVE_VIEWER_ELEMENT + "#type"; //$NON-NLS-1$

	/**
	 * Source provider name for the property that the active row element can be moved up.
	 */
	String SOURCES_ACTIVE_VIEWER_ELEMENT_MOVE_UP = SOURCES_ACTIVE_VIEWER_ELEMENT + "#moveUp"; //$NON-NLS-1$

	/**
	 * Source provider name for the property that the active row element can be moved down.
	 */
	String SOURCES_ACTIVE_VIEWER_ELEMENT_MOVE_DOWN = SOURCES_ACTIVE_VIEWER_ELEMENT + "#moveDown"; //$NON-NLS-1$

	/**
	 * Source provider name for whether undo is possible.
	 * <p>
	 * The type of the value is {@link boolean}.
	 */
	String SOURCES_CAN_UNDO = SOURCES + PROPERTY_CAN_UNDO;

	/**
	 * Source provider name for whether redo is possible.
	 * <p>
	 * The type of the value is {@link boolean}.
	 */
	String SOURCES_CAN_REDO = SOURCES + PROPERTY_CAN_REDO;

	/**
	 * The ID of the default "Open" command used when no specific open command is associated with
	 * the specific classifier or feature.
	 */
	String DEFAULT_OPEN_COMMAND = PREFIX + "commands.openBinding"; //$NON-NLS-1$

	/**
	 * The ID of the "Use Defaults" command.
	 */
	String USE_DEFAULT_TOGGLE_COMMAND = PREFIX + "commands.UseDefaultValue"; //$NON-NLS-1$

	String ATTR_TEXT = "text"; //$NON-NLS-1$

	String ATTR_IMAGE = "image"; //$NON-NLS-1$

	String ATTR_WIDTH = "width"; //$NON-NLS-1$

	String ATTR_ALIGNMENT = "alignment"; //$NON-NLS-1$

	String ATTR_TOOLTIP = "tooltip"; //$NON-NLS-1$

	String ATTR_VISIBLE = "visible"; //$NON-NLS-1$

	String ATTR_ENABLED = "enabled"; //$NON-NLS-1$

	String ATTR_FONT = "font"; //$NON-NLS-1$

	String ATTR_FOREGROUND = "foreground"; //$NON-NLS-1$

	String ATTR_BACKGROUND = "background"; //$NON-NLS-1$

	String ATTR_MAX = "max"; //$NON-NLS-1$

	String ATTR_MIN = "min"; //$NON-NLS-1$

	String ATTR_SELECTION = "selection"; //$NON-NLS-1$

	String ATTR_CURSOR = "cursor"; //$NON-NLS-1$

	/**
	 * The default {@link IBinding} type.
	 */
	String TYPE_DEFAULT = ""; //$NON-NLS-1$

	/**
	 * The {@link IBinding} type used for fields that should have a long human readable name.
	 */
	String TYPE_LONG_NAME = "longName"; //$NON-NLS-1$

	/**
	 * The {@link IBinding} type used for fields that should have a qualified and human readable
	 * name with both the type of the object as well as the long name for the object.
	 */
	String TYPE_QUALIFIED_NAME = "qualifiedName"; //$NON-NLS-1$

	/**
	 * The {@link IBinding} type used for fields that contains a file name.
	 */
	String TYPE_FILE_NAME = "fileName";

	/**
	 * The {@link IBinding} type used for fields that contains a directory name.
	 */
	String TYPE_DIRECTORY_NAME = "directoryName";

	/**
	 * This expression evaluates to <code>true</code> and has a very high source priority.
	 * <p>
	 * This expression is used to provoke that a local undo handler takes priority over global
	 * handlers.
	 */
	Expression TRUE_EXPRESSION = new Expression() {
		@Override
		public void collectExpressionInfo(ExpressionInfo info) {
			super.collectExpressionInfo(info);
			info.addVariableNameAccess(ISources.ACTIVE_CURRENT_SELECTION_NAME);
		}

		@Override
		public EvaluationResult evaluate(IEvaluationContext context) {
			return EvaluationResult.TRUE;
		}
	};

	/**
	 * The color definition used for even rows.
	 * 
	 * @see IManager#isAlternateRowColors()
	 */
	String COLOR_DEFINITIONS_EVEN_ROW_BACKGROUND = PREFIX + "colorDefinitions.EvenRowBackground"; //$NON-NLS-1$

	/**
	 * The color definition used for cells that have focus when the control have focus.
	 */
	String COLOR_DEFINITIONS_SELECTION_FOCUS_BACKGROUND = PREFIX + "colorDefinitions.SelectionFocusBackground"; //$NON-NLS-1$

	/**
	 * The color definition used for cells that have focus when the control does not have focus.
	 */
	String COLOR_DEFINITIONS_SELECTION_NO_FOCUS_BACKGROUND = PREFIX + "colorDefinitions.SelectionNoFocusBackground"; //$NON-NLS-1$

	/**
	 * The color definition used for the background color of controls with the
	 * {@link IBindingHighlightContext}.
	 */
	String COLOR_DEFINITIONS_DEFAULT_HIGHLIGHT_BACKGROUND = PREFIX + "colorDefinitions.DefaultHighlightBackground"; //$NON-NLS-1$

	/**
	 * The default priority for tree item relations.
	 */
	int DEFAULT_TREE_ITEM_RELATION_PRIORITY = 1000;

	/**
	 * The default priority for decorator extenders.
	 */
	int DEFAULT_DECORATOR_EXTENDER_PRIORITY = 100;

	/**
	 * The preference name to specify whether cell editing is automatically started when any
	 * character is typed in a cell.
	 * <p>
	 * <code>true</code> means any character will start cell editing; <code>false</code> means only
	 * <code>F2</code> and <code>Return</code> will start cell editing.
	 */
	String PREF_EDIT_CELL_ANY_KEY = "EditCellAnyKey"; //$NON-NLS-1$

	/**
	 * The preference name to specify whether cell editing is automatically started when any
	 * character is typed in a cell.
	 * <p>
	 * <code>true</code> means any character will start cell editing; <code>false</code> means only
	 * <code>F2</code> and <code>Return</code> will start cell editing.
	 */
	String PREF_EDIT_CELL_SINGLE_CLICK = "EditCellSingleClick"; //$NON-NLS-1$

	/**
	 * The preference name for the text commit strategy.
	 * <p>
	 * Can have the value specified via the {@link TextCommitStrategy} enumeration.
	 */
	String PREF_TEXT_COMMIT_STRATEGY = "TextCommitStrategy"; //$NON-NLS-1$

	/**
	 * The preference name for the delay used for {@link TextCommitStrategy#ON_MODIFY_DELAY}.
	 * <p>
	 * In milliseconds.
	 */
	String PREF_TEXT_COMMIT_STRATEGY_DELAY = "TextCommitStrategyDelay"; //$NON-NLS-1$

	/**
	 * The preference name to specify whether a single quick fix is applied automatically.
	 * <p>
	 * <code>true</code> means a single quick fix should be applied automatically;
	 * <code>false</code> means even a single quick fix should be presented in a popup menu.
	 */
	String PREF_AUTO_APPLY_QUICKFIX = "AutoApplyQuickfix"; //$NON-NLS-1$

	/**
	 * The preference name to specify whether rows in tables should have alternating row background
	 * colors.
	 * <p>
	 * <code>true</code> means every other row have another background color; <code>false</code>
	 * means all rows have the same background color.
	 */
	String PREF_ALTERNATE_ROW_COLORS = "AlternateRowColors"; //$NON-NLS-1$

	/**
	 * The preference name to specify whether basic validation errors are fatal in the bindings.
	 * <p>
	 * When validation errors are <em>not</em> fatal, it means that numeric values outside their
	 * ranges can be committed anyway.
	 * <p>
	 * <code>true</code> means every validation errors are fatal.
	 */
	String PREF_VALIDATION_ERRORS_ARE_FATAL = "ValidationErrorsAreFatal"; //$NON-NLS-1$

	/**
	 * The preference name to specify whether the "required" image decoration is shown.
	 * <p>
	 * <code>true</code> means the decoration is shown.
	 */
	String PREF_REQUIRED_VBID_SHOWN = "RequiredVBIDShown"; //$NON-NLS-1$

	/**
	 * The preference name to specify whether the "required" image decoration is shown.
	 * <p>
	 * <code>true</code> means the decoration is shown.
	 */
	String PREF_QUICKFIX_VBID_SHOWN = "QuickfixVBIDShown"; //$NON-NLS-1$

	/**
	 * The preference name to specify whether the "required" image decoration is shown.
	 * <p>
	 * <code>true</code> means the decoration is shown.
	 */
	String PREF_ASSIST_VBID_SHOWN = "AssistVBIDShown"; //$NON-NLS-1$

	/**
	 * The preference name to specify that changes in the view are recorded by
	 * {@link IGlobalNavigationManager}.
	 * <p>
	 * <code>true</code> means the changes are recorded.
	 */
	String PREF_VIEW_NAVIGATION_RECORDED = "ViewNavigationRecorded"; //$NON-NLS-1$

	/**
	 * The preference name to specify where on a widget a message decoration is placed.
	 * <p>
	 * One of the literal values of {@link DecorationPosition}.
	 */
	String PREF_MESSAGE_DECORATION_POSITION = "MessageDecorationPosition"; //$NON-NLS-1$

	/**
	 * The preference name to specify the minimum severity showed in a message decoration.
	 * <p>
	 * One of the literal values of {@link BindingMessageSeverity}.
	 */
	String PREF_MESSAGE_DECORATION_MINIMUM_SEVERITY = "MessageDecorationMinimumSeverity"; //$NON-NLS-1$

	/**
	 * The preference name to specify where on a widget an alternative decoration is placed.
	 * <p>
	 * One of the literal values of {@link DecorationPosition}.
	 */
	String PREF_ALTERNATIVE_DECORATION_POSITION = "AlternativeDecorationPosition"; //$NON-NLS-1$

	/**
	 * The preference name for the delay used between a change is detected in the model and a
	 * validator is kicked off.
	 * <p>
	 * In milliseconds.
	 */
	String PREF_VALIDATION_DELAY = "ValidationDelay"; //$NON-NLS-1$

	/**
	 * The preference name for the the size of the window after a validator is kicked off where no
	 * new validation will be started.
	 * <p>
	 * In milliseconds.
	 */
	String PREF_VALIDATION_DELAY_WINDOW = "ValidationDelayWindow"; //$NON-NLS-1$

	/**
	 * The preference name to specify whether {@link DeleteHandler} should change enabled state
	 * based on whether the operation can actually be executed.
	 * <p>
	 * <code>true</code> means the enabled state is calculated.
	 */
	String PREF_DELETE_HANDLER_CHECK_ENABLED = "DeleteHandlerCheckEnabled";

	/**
	 * The preference name for the default fade in time for {@link IBindingHighlightContext}.
	 * <p>
	 * In milliseconds.
	 */
	String PREF_HIGHLIGHT_FADE_IN_TIME = "HighlightFadeInTime";

	/**
	 * The preference name for the default fade out time for {@link IBindingHighlightContext}.
	 * <p>
	 * In milliseconds.
	 */
	String PREF_HIGHLIGHT_FADE_OUT_TIME = "HighlightFadeOutTime";

	/**
	 * The preference name for the default active time for {@link IBindingHighlightContext}.
	 * <p>
	 * In milliseconds.
	 */
	String PREF_HIGHLIGHT_ACTIVE_TIME = "HighlightActiveTime";

	/**
	 * The data string to use to create the basic top-level preference page.
	 * <p>
	 * Use by setting class to
	 * <code>com.rcpcompany.uibindings.UIBindingPreferences:basicPreferencePage</code>.
	 */
	String TOP_PREF_PAGE = "basicPreferencePage"; //$NON-NLS-1$

	/**
	 * The data string to use to create the basic validation preference page.
	 * <p>
	 * Use by setting class to
	 * <code>com.rcpcompany.uibindings.UIBindingPreferences:validationPreferencePage</code>.
	 */
	String VALIDATION_PREF_PAGE = "validationPreferencePage"; //$NON-NLS-1$

	/**
	 * The data string to use to create the basic highlight preference page.
	 * <p>
	 * Use by setting class to
	 * <code>com.rcpcompany.uibindings.UIBindingPreferences:highlightPreferencePage</code>.
	 */
	String HIGHLIGHT_PREF_PAGE = "highlightPreferencePage"; //$NON-NLS-1$

}
