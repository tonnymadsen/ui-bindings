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
package com.rcpcompany.uibindings.extests.wizards;

import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.IFormCreatorChooser;
import com.rcpcompany.uibindings.utils.IFormCreatorChooserCreator;

/**
 * Tests the use of {@link IFormChooser} in {@link IWizardPage}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FormChooserWizardTest {

	public static FormChooserPage myPage;
	public Throwable myException;

	@Test
	public void testWizard() throws Throwable {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final int shells = workbench.getDisplay().getShells().length;

		final ICommandService cs = (ICommandService) workbench.getService(ICommandService.class);
		final IHandlerService hs = (IHandlerService) workbench.getService(IHandlerService.class);

		try {
			final ParameterizedCommand command = cs
					.deserialize("org.eclipse.ui.newWizard(newWizardId=com.rcpcompany.uibindings.extests.wizards.FormChooserWizardTest.TestFormChooserWizard)");

			workbench.getDisplay().timerExec(2000, new Runnable() {

				@Override
				public void run() {
					try {
						assertNotNull(myPage);
						final Composite top = myPage.myForm.getTop();
						assertNotNull(top);

						/*
						 * Should be test1 chooser
						 */
						assertEquals("test2", myPage.myState);

						Control[] children;
						Label l;

						children = top.getChildren();
						assertEquals(2, children.length);
						assertTrue(children[1] instanceof Composite);

						children = ((Composite) children[1]).getChildren();
						assertEquals(1, children.length);
						assertTrue(children[0] instanceof Composite);

						children = ((Composite) children[0]).getChildren();
						assertEquals(1, children.length);
						assertTrue(children[0] instanceof Label);

						l = (Label) children[0];
						assertEquals("false", l.getText());
						assertTrue(l.getSize().x > 0);

						/*
						 * Change to test2 chooser
						 */
						myPage.myObject.setB(true);
						yield();
						assertEquals("test1", myPage.myState);

						children = top.getChildren();
						assertEquals(2, children.length);
						assertTrue(children[1] instanceof Composite);

						children = ((Composite) children[1]).getChildren();
						assertEquals(1, children.length);
						assertTrue(children[0] instanceof Composite);

						children = ((Composite) children[0]).getChildren();
						assertEquals(1, children.length);
						assertTrue(children[0] instanceof Label);

						l = (Label) children[0];
						assertEquals("true", l.getText());
						assertTrue(l.getSize().x > 0);

						/*
						 * Close the wizard
						 */
						postKeyStroke(top, "ESCAPE");

					} catch (final Throwable ex) {
						/*
						 * To propagate the exception..
						 */
						myException = ex;
					}
				}
			});

			workbench.getDisplay().timerExec(5000, new Runnable() {
				@Override
				public void run() {
					if (myPage != null) {
						postKeyStroke(myPage.myForm.getTop(), "ESCAPE");
					}
				}
			});

			/*
			 * Open the wizard dialog with the test wizard
			 */
			hs.executeCommand(command, null);

			if (myException != null) throw myException;
			/*
			 * The wizard should now be closed
			 */
			assertEquals(null, myPage);
			assertEquals(shells, workbench.getDisplay().getShells().length);
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
	}

	public static class TestFormChooserWizard extends Wizard implements INewWizard {
		public TestFormChooserWizard() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void addPages() {
			addPage(new FormChooserPage());
		}

		@Override
		public boolean performFinish() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void init(IWorkbench workbench, IStructuredSelection selection) {
		}
	}

	public static class FormChooserPage extends WizardPage implements IWizardPage {

		public TestObject myObject;
		public IFormCreator myForm;
		public IValueBinding myBinding;
		public String myState;

		protected FormChooserPage() {
			super("TestPage");

			myPage = this;
		}

		@Override
		public void dispose() {
			super.dispose();

			myPage = null;
		}

		@Override
		public void createControl(Composite parent) {
			myObject = TestModelFactory.eINSTANCE.createTestObject();
			myForm = IFormCreator.Factory.createWizardPage(myObject, this, parent);

			myBinding = myForm.addField("b(w=200)");

			final IFormCreatorChooser chooser = IFormCreatorChooser.Factory.create(myForm,
					myBinding.getModelObservableValue());
			chooser.addFormValue(true, test1());
			chooser.addFormValue(false, test2());

			myForm.finish();

			setControl(myForm.getTop());
		}

		private IFormCreatorChooserCreator test1() {
			return new IFormCreatorChooserCreator() {
				@Override
				public void createForm(IObservableValue discriminant, IFormCreator form) {
					form.addLabel("true");
					myState = "test1";
				}
			};
		}

		private IFormCreatorChooserCreator test2() {
			return new IFormCreatorChooserCreator() {
				@Override
				public void createForm(IObservableValue discriminant, IFormCreator form) {
					form.addLabel("false");
					myState = "test2";
				}
			};
		}
	}
}
