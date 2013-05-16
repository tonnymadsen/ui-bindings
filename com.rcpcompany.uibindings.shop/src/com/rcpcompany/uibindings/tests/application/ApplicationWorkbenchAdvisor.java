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
package com.rcpcompany.uibindings.tests.application;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.moao.ui.validation.MOAOMessageValidatorAdapter;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.scripting.IScriptEvaluationContext;
import com.rcpcompany.uibindings.scripting.IScriptManager;
import com.rcpcompany.uibindings.scripting.util.FeatureScriptValidatorAdapter;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;
import com.rcpcompany.uibindings.utils.IGlobalNavigationManager;
import com.rcpcompany.uibindings.validators.ConstraintValidatorAdapter;
import com.rcpcompany.uibindings.validators.EValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * The workbench advisor.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "com.rcpcompany.uibindings.example.application.perspectives.Shop";
	private Shop theShop;
	private IScriptEvaluationContext myGlobalScriptingContext;

	@Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}

	@Override
	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}

	@Override
	public void preStartup() {
		super.preStartup();

		getWorkbenchConfigurer().setSaveAndRestore(true);
	}

	@Override
	public void postStartup() {
		super.postStartup();

		myGlobalScriptingContext = IScriptManager.Factory.getManager().getGlobalEvaluationContext();
		theShop = ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain());

		final IValidatorAdapterManager vam = IValidatorAdapterManager.Factory.getManager();
		vam.addRoot(theShop, new EValidatorAdapter());
		vam.addRoot(theShop, new ConstraintValidatorAdapter());
		vam.addRoot(theShop, new MOAOMessageValidatorAdapter());
		vam.addRoot(theShop, new FeatureScriptValidatorAdapter());

		IGlobalNavigationManager.Factory.installMouseHandling();

		INavigatorManager.Factory.getManager().setUseGenericEditorPartFallback(false);

		// TODO create a shortcut method
		theShop.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.isTouch()) return;

				if (msg.getFeature() == IMOAOPackage.Literals.NAMED_OBJECT__NAME) {
					updateScriptingVariables();
				}
			}
		});
		updateScriptingVariables();

		for (int i = SWT.None; i < SWT.ImeComposition; i++) {
			Display.getCurrent().addFilter(i, SWT_EVENT_LISTENER);
		}
	}

	public final static Listener SWT_EVENT_LISTENER = new Listener() {
		@Override
		public void handleEvent(Event event) {
			// LogUtils.debug(this, ToStringUtils.toString(event));
		}
	};

	protected void updateScriptingVariables() {
		myGlobalScriptingContext.getVariables().put("shop", theShop);
		myGlobalScriptingContext.getVariables().put("shopName", theShop.getName());
	}

	@Override
	public boolean preShutdown() {
		final IManager manager = IManager.Factory.getManager();
		final EditingDomain editingDomain = manager.getEditingDomain();
		int res = 1; // == NO
		if (editingDomain.getCommandStack().canUndo()) {
			final IWorkbenchWindow window = getWorkbenchConfigurer().getWorkbench().getActiveWorkbenchWindow();
			final MessageDialog dialog = new MessageDialog(window.getShell(), "Save Shop?", null,
					"Changes has been made to the shop. Save these?", MessageDialog.QUESTION, new String[] {
							IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL, IDialogConstants.CANCEL_LABEL }, 0);
			res = dialog.open();
			if (res == 0) {
				final ICommandService cs = (ICommandService) window.getService(ICommandService.class);
				final IHandlerService hs = (IHandlerService) window.getService(IHandlerService.class);

				try {
					final String c = manager.getCommandIDs().get(IWorkbenchCommandConstants.FILE_SAVE);
					final ParameterizedCommand command = cs.deserialize(c);
					hs.executeCommand(command, null);
				} catch (final Exception ex) {
					LogUtils.error(this, ex);
				}
			}
		}
		return res != 2;
	}
}
