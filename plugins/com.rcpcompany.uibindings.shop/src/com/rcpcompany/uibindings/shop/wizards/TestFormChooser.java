package com.rcpcompany.uibindings.shop.wizards;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.IFormCreatorChooser;
import com.rcpcompany.uibindings.utils.IFormCreatorChooserCreator;

public class TestFormChooser extends Wizard implements INewWizard {

	public TestFormChooser() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
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

	public class FormChooserPage extends WizardPage implements IWizardPage {

		private TestObject myObject;
		private IFormCreator myForm;
		private IValueBinding myBinding;

		protected FormChooserPage() {
			super("TestPage");
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
				}
			};
		}

		private IFormCreatorChooserCreator test2() {
			return new IFormCreatorChooserCreator() {
				@Override
				public void createForm(IObservableValue discriminant, IFormCreator form) {
					form.addLabel("false");
				}
			};
		}
	}
}
