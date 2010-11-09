// $codepro.audit.disable instanceFieldNamingConvention
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
package com.rcpcompany.uibindings.internal;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.DecorationPosition;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IColumnBindingCellInformation;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.UIBindingPreferences;
import com.rcpcompany.uibindings.bindingMessages.ValidationLabelDecorator;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
import com.rcpcompany.uibindings.internal.bindingMessages.ViewerBindingMessageDecorator;
import com.rcpcompany.uibindings.internal.utils.ControlDecorationManager;
import com.rcpcompany.uibindings.utils.IControlDecoration;
import com.rcpcompany.uibindings.utils.ISortableTableAdapter;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID.
	 */
	public static final String ID = "com.rcpcompany.uibindings"; //$NON-NLS-1$

	// The shared instance
	private static Activator PLUGIN;

	/**
	 * The constructor.
	 */
	public Activator() {
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);
		reg.put(InternalConstants.IMG_OPEN_DIALOG, imageDescriptorFromPlugin(ID, "images/open-dialog.gif"));
	}

	private IPropertyChangeListener myListener = null;

	/**
	 * Number of levels in the {@link IBinding#getCreationPoint() creation point} stack traces.
	 * <p>
	 * <code>0</code> means disabled.
	 */
	public int CREATION_POINT_STACK_LEVELS = 0;

	/**
	 * <code>true</code> if tracing the built-in source providers.
	 */
	public boolean TRACE_SOURCE_PROVIDER = false;

	/**
	 * <code>true</code> if verbose tracing the built-in source providers.
	 */
	public boolean TRACE_SOURCE_PROVIDER_VERBOSE = false;

	/**
	 * <code>true</code> if tracing navigation in viewers.
	 */
	public boolean TRACE_NAVIGATION_VIEWER = false;

	/**
	 * <code>true</code> if tracing global navigation.
	 */
	public boolean TRACE_NAVIGATION_GLOBAL = false;

	/**
	 * <code>true</code> if tracing {@link IBinding#getArgument(String, Class, Object)}.
	 */
	public boolean TRACE_ARGUMENT = false;

	/**
	 * If non-empty, a list of the traced types in
	 * {@link IBinding#getArgument(String, Class, Object)} and
	 * {@link IBinding#getArguments(String, Class, boolean)}.
	 */
	public List<String> TRACE_ARGUMENT_TYPES = null;

	/**
	 * If non-empty, a list of the traced bindings (base-type) in
	 * {@link IBinding#getArgument(String, Class, Object)} and
	 * {@link IBinding#getArguments(String, Class, boolean)}.
	 */
	public List<String> TRACE_ARGUMENT_BINDINGS = null;

	/**
	 * <code>true</code> if tracing {@link IBinding#getArguments(String, Class, boolean)}.
	 */
	public boolean TRACE_ARGUMENTS = false;

	/**
	 * <code>true</code> if tracing "open" command.
	 */
	public boolean TRACE_OPEN_COMMAND = false;

	/**
	 * <code>true</code> if tracing execution of handlers.
	 */
	public boolean TRACE_HANDLERS = false;

	/**
	 * <code>true</code> if tracing execution of property testers.
	 */
	public boolean TRACE_PROPERTY_TESTERS = false;

	/**
	 * <code>true</code> if tracing activations of contexts.
	 */
	public boolean TRACE_CONTEXTS = false;

	/**
	 * <code>true</code> if tracing selection of decorators.
	 */
	public boolean TRACE_DECORATORS = false;

	/**
	 * <code>true</code> if tracing drag 'n drop.
	 */
	public boolean TRACE_DND = false;

	/**
	 * <code>true</code> if tracing attribute images.
	 */
	public boolean TRACE_ATTRIBUTE_IMAGE_DECORATORS = false;

	/**
	 * <code>true</code> if tracing sorting in {@link ISortableTableAdapter}.
	 */
	public boolean TRACE_SORTING = false;

	/**
	 * <code>true</code> if tracing of the tree algorithms in {@link ViewerBindingImpl} and
	 * {@link ViewerBindingTreeFactory}.
	 */
	public boolean TRACE_TREE = false;

	/**
	 * <code>true</code> if tracing control decorations in {@link IControlDecoration} and
	 * {@link ControlDecorationManager}.
	 */
	public boolean TRACE_CONTROL_DECORATIONS = false;

	/**
	 * <code>true</code> if verbose tracing control decorations in {@link IControlDecoration} and
	 * {@link ControlDecorationManager}.
	 */
	public boolean TRACE_CONTROL_DECORATIONS_VERBOSE = false;

	/**
	 * <code>true</code> if tracing the life-cycle of bindings.
	 */
	public boolean TRACE_LIFECYCLE_BINDINGS = false;

	/**
	 * <code>true</code> if tracing the life-cycle of column editors.
	 */
	public boolean TRACE_LIFECYCLE_COLUMN_EDITORS = false;

	/**
	 * <code>true</code> if tracing the life-cycle of {@link IColumnBindingCellInformation}.
	 */
	public boolean TRACE_LIFECYCLE_CI = false;

	/**
	 * <code>true</code> if tracing SWT events.
	 */
	public boolean TRACE_EVENTS_SWT = false;

	/**
	 * <code>true</code> if tracing the events from label providers.
	 */
	public boolean TRACE_EVENTS_LABELPROVIDERS = false;

	/**
	 * <code>true</code> if tracing the events cell editor activation.
	 */
	public boolean TRACE_EVENTS_CELL_EDITOR_ACTIVATION = false;

	/**
	 * <code>true</code> if tracing changes in validation status.
	 */
	public boolean TRACE_MESSAGE_DECORATION_VALIDATION_STATUS = false;

	/**
	 * <code>true</code> if tracing the life-cycle of {@link ValueBindingMessageImageDecorator}.
	 */
	public boolean TRACE_LIFECYCLE_VALUE_BINDING_MESSAGE_DECORATOR = false;

	/**
	 * <code>true</code> if tracing the life-cycle of {@link ViewerBindingMessageDecorator}.
	 */
	public boolean TRACE_LIFECYCLE_VIEWER_BINDING_MESSAGE_DECORATOR = false;

	/**
	 * <code>true</code> if tracing the {@link ValidationLabelDecorator}.
	 */
	public boolean TRACE_LABEL_DECORATOR = false;

	/**
	 * <code>true</code> if tracing quick fixes.
	 */
	public boolean TRACE_QUICK_FIXES = false;

	/**
	 * <code>true</code> if tracing the results of validation.
	 */
	public boolean TRACE_VALIDATION_RESULT = false;

	/**
	 * The bundle context for the UI Bindings plug-in.
	 */
	private BundleContext myContext;

	/**
	 * Returns the bundle context for the UI Bindings plug-in.
	 * 
	 * @return the context
	 */
	public BundleContext getContext() {
		return myContext;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		myContext = context;
		PLUGIN = this;

		final IPreferenceStore preferenceStore = getPreferenceStore();

		myListener = new IPropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				updateManagerProperties();
			}
		};
		preferenceStore.addPropertyChangeListener(myListener);
		myListener.propertyChange(null);

		initTrace();
	}

	/**
	 * Initializes traces
	 */
	private void initTrace() {
		if (isDebugging()) {
			CREATION_POINT_STACK_LEVELS = Integer.parseInt(Platform.getDebugOption(ID
					+ "/conf/CreationPoint/StackLevels")); //$NON-NLS-1$
			TRACE_SOURCE_PROVIDER = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/SourceProvider")); //$NON-NLS-1$
			TRACE_SOURCE_PROVIDER_VERBOSE = Boolean.parseBoolean(Platform.getDebugOption(ID
					+ "/trace/SourceProvider/Verbose")); //$NON-NLS-1$
			TRACE_NAVIGATION_VIEWER = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/Navigation/viewer")); //$NON-NLS-1$
			TRACE_NAVIGATION_GLOBAL = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/Navigation/global")); //$NON-NLS-1$
			TRACE_ARGUMENT = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/Argument")); //$NON-NLS-1$
			TRACE_ARGUMENTS = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/Arguments")); //$NON-NLS-1$
			String s = Platform.getDebugOption(ID + "/trace/Argument/Types");
			if (s != null && s.length() != 0) {
				TRACE_ARGUMENT_TYPES = Arrays.asList(s.split(","));
			}
			s = Platform.getDebugOption(ID + "/trace/Argument/Bindings");
			if (s != null && s.length() != 0) {
				TRACE_ARGUMENT_BINDINGS = Arrays.asList(s.split(","));
			}
			TRACE_OPEN_COMMAND = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/OpenCommand")); //$NON-NLS-1$
			TRACE_CONTEXTS = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/Contexts")); //$NON-NLS-1$
			TRACE_HANDLERS = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/Handlers")); //$NON-NLS-1$
			TRACE_PROPERTY_TESTERS = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/PropertyTesters")); //$NON-NLS-1$
			TRACE_DECORATORS = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/Decorators")); //$NON-NLS-1$
			TRACE_DND = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/DnD")); //$NON-NLS-1$
			TRACE_ATTRIBUTE_IMAGE_DECORATORS = Boolean.parseBoolean(Platform.getDebugOption(ID
					+ "/trace/Attributes/ImagesDecorators")); //$NON-NLS-1$
			TRACE_LIFECYCLE_BINDINGS = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/Lifecycle/Bindings")); //$NON-NLS-1$
			TRACE_LIFECYCLE_CI = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/Lifecycle/CI")); //$NON-NLS-1$
			TRACE_LIFECYCLE_VALUE_BINDING_MESSAGE_DECORATOR = Boolean.parseBoolean(Platform.getDebugOption(ID
					+ "/trace/Lifecycle/ValueBindingMessageImageDecorator")); //$NON-NLS-1$
			TRACE_LIFECYCLE_VIEWER_BINDING_MESSAGE_DECORATOR = Boolean.parseBoolean(Platform.getDebugOption(ID
					+ "/trace/Lifecycle/ViewerBindingMessageDecorator")); //$NON-NLS-1$
			TRACE_LIFECYCLE_COLUMN_EDITORS = Boolean.parseBoolean(Platform.getDebugOption(ID
					+ "/trace/Lifecycle/ColumnEditors")); //$NON-NLS-1$
			TRACE_LABEL_DECORATOR = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/LabelDecorator")); //$NON-NLS-1$
			TRACE_EVENTS_LABELPROVIDERS = Boolean.parseBoolean(Platform.getDebugOption(ID
					+ "/trace/Events/LabelProviders")); //$NON-NLS-1$
			TRACE_EVENTS_SWT = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/Events/SWT")); //$NON-NLS-1$
			TRACE_EVENTS_CELL_EDITOR_ACTIVATION = Boolean.parseBoolean(Platform.getDebugOption(ID
					+ "/trace/Events/CellEditorActivation")); //$NON-NLS-1$
			TRACE_MESSAGE_DECORATION_VALIDATION_STATUS = Boolean.parseBoolean(Platform.getDebugOption(ID
					+ "/trace/MDValidationStatus")); //$NON-NLS-1$
			TRACE_QUICK_FIXES = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/Quickfixes")); //$NON-NLS-1$
			TRACE_VALIDATION_RESULT = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/ValidationResults")); //$NON-NLS-1$
			TRACE_SORTING = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/Sorting")); //$NON-NLS-1$
			TRACE_TREE = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/Tree")); //$NON-NLS-1$
			TRACE_CONTROL_DECORATIONS = Boolean.parseBoolean(Platform.getDebugOption(ID + "/trace/ControlDecorations")); //$NON-NLS-1$
			TRACE_CONTROL_DECORATIONS_VERBOSE = Boolean.parseBoolean(Platform.getDebugOption(ID
					+ "/trace/ControlDecorations/Verbose")); //$NON-NLS-1$
		}
	}

	protected void updateManagerProperties() {
		final IManager manager = IManager.Factory.getManager();
		final IPreferenceStore preferenceStore = getPreferenceStore();

		Assert.isNotNull(manager);

		boolean b;
		int i;
		String s;

		s = preferenceStore.getString(UIBindingPreferences.PREF_TEXT_COMMIT_STRATEGY);
		try {
			final TextCommitStrategy cs = TextCommitStrategy.valueOf(s);
			if (manager.getTextCommitStrategy() != cs) {
				manager.setTextCommitStrategy(cs);
			}
		} catch (final IllegalArgumentException ex) {
			LogUtils.error(this, "Unknown text commit strategy: '" + s + "'"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		i = preferenceStore.getInt(UIBindingPreferences.PREF_TEXT_COMMIT_STRATEGY_DELAY);
		if (manager.getTextCommitStrategyDelay() != i) {
			manager.setTextCommitStrategyDelay(i);
		}

		b = preferenceStore.getBoolean(UIBindingPreferences.PREF_AUTO_APPLY_QUICKFIX);
		if (manager.isAutoApplySingleQuickfix() != b) {
			manager.setAutoApplySingleQuickfix(b);
		}

		b = preferenceStore.getBoolean(UIBindingPreferences.PREF_DELETE_HANDLER_CHECK_ENABLED);
		if (manager.isDeleteHandlerCheckEnabled() != b) {
			manager.setDeleteHandlerCheckEnabled(b);
		}

		b = preferenceStore.getBoolean(UIBindingPreferences.PREF_EDIT_CELL_ANY_KEY);
		if (manager.isEditCellAnyKey() != b) {
			manager.setEditCellAnyKey(b);
		}

		b = preferenceStore.getBoolean(UIBindingPreferences.PREF_EDIT_CELL_SINGLE_CLICK);
		if (manager.isEditCellSingleClick() != b) {
			manager.setEditCellSingleClick(b);
		}

		b = preferenceStore.getBoolean(UIBindingPreferences.PREF_ALTERNATE_ROW_COLORS);
		if (manager.isAlternateRowColors() != b) {
			manager.setAlternateRowColors(b);
		}

		b = preferenceStore.getBoolean(UIBindingPreferences.PREF_VALIDATION_ERRORS_ARE_FATAL);
		if (manager.isValidationErrorsAreFatal() != b) {
			manager.setValidationErrorsAreFatal(b);
		}

		s = preferenceStore.getString(UIBindingPreferences.PREF_MESSAGE_DECORATION_POSITION);
		final DecorationPosition mdp = DecorationPosition.get(s);
		if (mdp != null) {
			if (manager.getMessageDecorationPosition() != mdp) {
				manager.setMessageDecorationPosition(mdp);
			}
		} else {
			LogUtils.error(this, "Unknown message decoration position: '" + s + "'"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		s = preferenceStore.getString(UIBindingPreferences.PREF_MESSAGE_DECORATION_MINIMUM_SEVERITY);
		final BindingMessageSeverity ms = BindingMessageSeverity.get(s);
		if (ms != null) {
			if (manager.getMessageDecorationMinimumSeverity() != ms) {
				manager.setMessageDecorationMinimumSeverity(ms);
			}
		} else {
			LogUtils.error(this, "Unknown message decoration minimum severity: '" + s + "'"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		s = preferenceStore.getString(UIBindingPreferences.PREF_ALTERNATIVE_DECORATION_POSITION);
		final DecorationPosition adp = DecorationPosition.get(s);
		if (adp != null) {
			if (manager.getAlternativeDecorationPosition() != adp) {
				manager.setAlternativeDecorationPosition(adp);
			}
		} else {
			LogUtils.error(this, "Unknown alternative decoration position: '" + s + "'"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		i = preferenceStore.getInt(UIBindingPreferences.PREF_VALIDATION_DELAY);
		if (manager.getValidationDelay() != i) {
			manager.setValidationDelay(i);
		}

		i = preferenceStore.getInt(UIBindingPreferences.PREF_VALIDATION_DELAY_WINDOW);
		if (manager.getValidationDelayWindow() != i) {
			manager.setValidationDelayWindow(i);
		}

		b = preferenceStore.getBoolean(UIBindingPreferences.PREF_REQUIRED_VBID_SHOWN);
		if (manager.isRequiredVBImageDecorationShown() != b) {
			manager.setRequiredVBImageDecorationShown(b);
		}

		b = preferenceStore.getBoolean(UIBindingPreferences.PREF_QUICKFIX_VBID_SHOWN);
		if (manager.isQuickfixVBImageDecorationShown() != b) {
			manager.setQuickfixVBImageDecorationShown(b);
		}

		b = preferenceStore.getBoolean(UIBindingPreferences.PREF_ASSIST_VBID_SHOWN);
		if (manager.isAssistVBImageDecorationShown() != b) {
			manager.setAssistVBImageDecorationShown(b);
		}

		b = preferenceStore.getBoolean(UIBindingPreferences.PREF_VIEW_NAVIGATION_RECORDED);
		if (manager.isViewNavigationRecorded() != b) {
			manager.setViewNavigationRecorded(b);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		getPreferenceStore().removePropertyChangeListener(myListener);
		if (myResources != null) {
			myResources.dispose();
			myResources = null;
		}
		PLUGIN = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return PLUGIN;
	}

	private ResourceManager myResources;

	/**
	 * Returns a local resource manager for use in this plug-in.
	 * 
	 * @return the manager
	 */
	public ResourceManager getResourceManager() {
		if (myResources == null) {
			myResources = new LocalResourceManager(JFaceResources.getResources());
		}
		return myResources;
	}
}
