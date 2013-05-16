/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.scripting.internal.bindings;

import java.util.Collection;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.scripting.IFeatureScript;
import com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor;
import com.rcpcompany.uibindings.scripting.IScriptManager;
import com.rcpcompany.uibindings.scripting.internal.Activator;
import com.rcpcompany.uibindings.scripting.util.ScriptingUtils;
import com.rcpcompany.uibindings.utils.IFormChooser;
import com.rcpcompany.uibindings.utils.IFormChooserCreator;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * The editor dialog itself...
 */
public class FeatureScriptDialog extends TitleAreaDialog {
	/**
	 * The button ID for the 'use value' button
	 */
	public static final int USE_VALUE = 10;

	/**
	 * The manager...
	 */
	protected final IScriptManager myManager = IScriptManager.Factory.getManager();

	/**
	 * The feature script that is the subject of this editor
	 */
	protected final IFeatureScript myFS;

	/**
	 * The form
	 */
	protected IFormCreator myForm;
	/**
	 * The binding for the script itself
	 */
	protected IValueBinding myScriptBinding;
	/**
	 * The {@link StyledText} widget for the script
	 */
	protected StyledText myText;

	/**
	 * The result text
	 */
	protected IObservableValue myResultText = WritableValue.withValueType(EcorePackage.Literals.ESTRING);

	/**
	 * The result color
	 */
	protected IObservableValue myResultColor = WritableValue.withValueType(Color.class);

	private IValueBinding myResultBinding;

	private final String myOldLanguage;
	private final String myOldScript;
	private final IValueBinding myBinding;

	/**
	 * Returns the styled text widget that is used for the text of the feature script
	 * 
	 * @return the text widget
	 */
	public StyledText getText() {
		return myText;
	}

	/**
	 * Constructs and returns a new editor dialog for a feature script.
	 * 
	 * @param shell the parent shell
	 * @param script the script to edit
	 */
	public FeatureScriptDialog(Shell shell, IValueBinding vb) {
		super(shell);
		myBinding = vb;

		final IMOAO obj = (IMOAO) vb.getModelObject();
		final EStructuralFeature feature = vb.getModelFeature();

		myFS = ScriptingUtils.getFeatureScript(obj, feature, true);
		myOldLanguage = myFS.getLanguage();
		myOldScript = myFS.getScript();

		// super(shell, SWT.ON_TOP | SWT.RESIZE, true, true, false, false, false, null,
		// "Press 'Return' or 'Escape' to continue");
	}

	@Override
	public int open() {
		final int result = super.open();
		switch (result) {
		case Window.OK:
			break;
		case Window.CANCEL:
			if (myOldScript == null || myOldScript.equals("")) {
				myFS.dispose();
			} else {
				myFS.setLanguage(myOldLanguage);
				myFS.setScript(myOldScript);
			}
			break;
		case FeatureScriptDialog.USE_VALUE:
			// The value has already been set, so we just need to delete the script...
			myFS.dispose();
			break;
		}

		myBinding.updateBinding();

		return result;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite top = (Composite) super.createDialogArea(parent);

		final Collection<IScriptEngineDescriptor> engines = IScriptManager.Factory.getManager().getEngines().values();

		final IBindingContext context = IBindingContext.Factory.createContext(this);

		setTitle("Editing script...");
		setMessage("Press 'OK' to set script, 'Cancel' to reject change and 'Use Value' to use the current value");

		myForm = IFormCreator.Factory.createForm(context, myFS, null, top);

		myForm.addField("object").type(Constants.TYPE_QUALIFIED_NAME).readonly()
				.arg(Constants.ARG_PREFERRED_CONTROL, Text.class.getName());
		myForm.addField("feature").readonly();
		final IValueBinding languageBinding = myForm.addField("language");

		final IFormChooser languageChooser = myForm.addFormChooser(languageBinding);

		for (final IScriptEngineDescriptor l : engines) {
			languageChooser.addFormValue(l.getLanguage(), new IFormChooserCreator() {
				@Override
				public void createForm(IBindingContext context, IObservableValue discriminant, Composite parent) {
					final IFormCreator subForm = myForm.subForm(parent);
					myScriptBinding = subForm.addField("script").type("script-" + l.getLanguage());
					myForm.finish();
					myForm.getTop().layout();
					myScriptBinding.setFocus();
				}
			});
		}

		myForm.addSeparator();
		myResultBinding = myForm.addField("expression.currentValue").readonly();
		myForm.addField("expression.errorMessage").readonly();

		myForm.finish();

		context.addBinding().ui(myResultBinding.getControl(), Constants.ATTR_FOREGROUND).model(myResultColor);
		context.finish();

		applyDialogFont(top);

		if (myFS.getLanguage() == null) {
			languageBinding.setFocus();
		}

		return top;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Edit Script");
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);

		Button button;
		button = createButton(parent, USE_VALUE, "&Use value", false);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setReturnCode(USE_VALUE);
				close();
			}
		});
	}

	/**
	 * ID for this dialog.
	 */
	public final String ID = FeatureScriptDialog.class.getName();

	@Override
	protected IDialogSettings getDialogBoundsSettings() {
		final IDialogSettings settings = Activator.getDefault().getDialogSettings();
		IDialogSettings result = settings.getSection(ID);
		if (result == null) {
			result = settings.addNewSection(ID);
		}
		return result;
	}
}
