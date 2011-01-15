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
package com.rcpcompany.uibindings.tests.views;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.progress.IWorkbenchSiteProgressService;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;

public class TestView extends ViewPart {

	private Composite myBody;
	private TestObject myObject;
	private Text myText;

	/**
	 * Constructs and returns a new view.
	 */
	public TestView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		final Composite body = new Composite(parent, SWT.NONE);
		body.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		body.setLayout(new GridLayout(2, false));

		final Label label = new Label(body, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label.setText("Field:");

		final TestObject myTestObject = TestModelFactory.eINSTANCE.getTestContainer().getChildren().get(0);
		final Text text = new Text(body, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text.setText("");

		myTestObject.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				super.notifyChanged(msg);
				if (msg.getFeature() == TestModelPackage.Literals.TEST_OBJECT__TEXT) {
					text.setText(myTestObject.getText());
				}
			}
		});
		text.setText(myTestObject.getText());

		text.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				myTestObject.setText(text.getText());
			}
		});
	}

	public void createPartControl2(Composite parent) {
		myBody = new Composite(parent, SWT.NONE);

		final IWorkbenchSiteProgressService service = (IWorkbenchSiteProgressService) getSite().getService(
				IWorkbenchSiteProgressService.class);
		service.schedule(new Job("Fetch data for " + getTitle()) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				fetchData();
				myBody.getDisplay().asyncExec(new Runnable() {
					@Override
					public void run() {
						bindUI();
					}
				});
				return Status.OK_STATUS;
			}
		});
		myBody.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		myBody.setLayout(new GridLayout(2, false));

		final Label label = new Label(myBody, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label.setText("Field:");

		myObject = TestModelFactory.eINSTANCE.getTestContainer().getChildren().get(0);
		myText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		myText.setText("");
	}

	protected void fetchData() {
		// ...
	}

	protected void bindUI() {
		final DataBindingContext c = new DataBindingContext();

		final UpdateValueStrategy modelToTarget = new EMFUpdateValueStrategy();
		final UpdateValueStrategy targetToModel = new EMFUpdateValueStrategy();

		c.bindValue(SWTObservables.observeText(myText, SWT.Modify),
				EMFObservables.observeValue(myObject, TestModelPackage.Literals.TEST_OBJECT__TEXT), targetToModel,
				modelToTarget);
	}

	@Override
	public void showBusy(boolean busy) {
		myBody.setEnabled(!busy);
		super.showBusy(busy);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	private void initializeToolBar() {
		final IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();
	}
}
