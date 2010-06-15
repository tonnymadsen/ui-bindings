package com.rcpcompany.uibindings.tests.decorators;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibinding.tests.model.TestContainer;
import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.decorators.SimpleUIBindingDecorator;
import com.rcpcompany.utils.databinding.EMFListAttributeList;
import com.rcpcompany.utils.databinding.IObservableListMapper;

public class TestObjectDecorator extends SimpleUIBindingDecorator implements IUIBindingDecorator {

	protected final TestContainer myTestContainer;

	public TestObjectDecorator() {
		myTestContainer = TestModelFactory.eINSTANCE.getTestContainer();
	}

	private IObservableList myValidUIList = null;

	@Override
	public IObservableList getValidUIList() {
		if (!calculatedValidUIList) {
			myValidUIList = EMFObservables.observeList(myTestContainer,
					TestModelPackage.Literals.TEST_CONTAINER__CHILDREN);
			final IObservableListMapper mapper = new IObservableListMapper() {
				@Override
				public Object map(Object value) {
					Object v = ((EObject) value).eGet(TestModelPackage.Literals.TEST_OBJECT__TEXT);
					if (v == null) {
						v = "";
					}
					return v;
				}
			};

			final IObservableList toNameList = new EMFListAttributeList(myValidUIList, mapper,
					TestModelPackage.Literals.TEST_OBJECT__TEXT);
			calculatedValidUIList = true;
		}
		return myValidUIList;
	}

	@Override
	protected Object convertModelToUI(Object fromObject) {
		if (fromObject instanceof TestObject) {
			final TestObject no = (TestObject) fromObject;
			return no.getText();
		}
		return fromObject.toString();
	}

	@Override
	protected Object convertUIToModel(Object fromObject) {
		if (fromObject == null) return null;
		for (final TestObject to : myTestContainer.getChildren()) {
			if (fromObject.equals(to.getText())) return to;
		}
		throw new IllegalArgumentException("Unknown name");
	}
}
