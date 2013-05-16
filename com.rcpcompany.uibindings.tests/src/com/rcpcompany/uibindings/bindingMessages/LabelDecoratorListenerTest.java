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
package com.rcpcompany.uibindings.bindingMessages;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.junit.Test;

/**
 * Test of {@link ValidationLabelDecorator} listener interface.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class LabelDecoratorListenerTest {
	@Test
	public void listenerAbbRemoveTest() {
		final ValidationLabelDecorator decorator = new ValidationLabelDecorator();
		final List<ILabelProviderListener> listeners = decorator.myListeners;
		assertEquals(0, listeners.size());

		final ILabelProviderListener l = new ILabelProviderListener() {
			@Override
			public void labelProviderChanged(LabelProviderChangedEvent event) {
			}
		};

		decorator.addListener(l);
		assertEquals(1, listeners.size());

		decorator.removeListener(l);
		assertEquals(0, listeners.size());
	}
}
