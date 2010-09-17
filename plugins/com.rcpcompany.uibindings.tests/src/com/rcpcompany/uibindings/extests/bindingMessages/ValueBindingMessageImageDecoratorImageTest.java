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
package com.rcpcompany.uibindings.extests.bindingMessages;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;

public class ValueBindingMessageImageDecoratorImageTest {
	@Test
	public void imageTests() {
		assertNotNull(ValueBindingMessageImageDecorator.CONTENT_PROPOSAL_FIELD_DECORATOR);
		assertNotNull(ValueBindingMessageImageDecorator.INFORMATION_FIELD_DECORATOR);
		assertNotNull(ValueBindingMessageImageDecorator.WARNING_FIELD_DECORATOR);
		assertNotNull(ValueBindingMessageImageDecorator.ERROR_FIELD_DECORATOR);
		assertNotNull(ValueBindingMessageImageDecorator.QUICKFIX_FIELD_DECORATOR);
		assertNotNull(ValueBindingMessageImageDecorator.REQUIRED_FIELD_DECORATOR);
	}
}
