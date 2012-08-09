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
package com.rcpcompany.uibindings.extests.utils;

import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Tests of {@link StringList}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class StringListTest {
	@Test
	public void testABC() {
		final Contact contact = ShopFactory.eINSTANCE.createContact();
		final UIBTestView testView = UIBindingsTestUtils.createUIBTestView(this);
		final IFormCreator form = testView.createFormCreator(contact);

		final IValueBinding binding = form.addField("address");

		form.finish();

		final IObservableList list = binding.getArgument(Constants.ARG_VALID_VALUES, IObservableList.class, null);

		assertNotNull(list);

		assertEquals(3, list.size());

		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("c", list.get(2));
	}
}
