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
