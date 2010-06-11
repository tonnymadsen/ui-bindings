package com.rcpcompany.uibindings.extests.bindings;

import org.eclipse.core.databinding.observable.list.IObservableList;

import com.rcpcompany.uibinding.tests.model.TestContainer;
import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibindings.IObservableListFactory;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;

/**
 * Test {@link IObservableListFactory} for {@link ArgumentsTypeTest}.
 */
public class TestObjectObservableListFactory implements IObservableListFactory {
	@Override
	public IObservableList createList(IValueBinding binding) {
		final TestContainer model = TestModelFactory.eINSTANCE.getTestContainer();
		return UIBindingsEMFObservables.observeList(binding.getEditingDomain(), model,
				TestModelPackage.Literals.TEST_CONTAINER__CHILDREN);
	}
}
