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
package com.rcpcompany.uibindings.extests.observables;

import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.junit.Test;

import com.rcpcompany.uibindings.observables.MessageFormatObservableValue;

/**
 * Test of {@link MessageFormatObservableValue}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class MessageFormatObservableValueTest {

	protected int changeCount = 0;

	@Test
	public void testValue() {
		final IObservableValue decorated = WritableValue.withValueType(String.class);
		decorated.setValue("");
		final MessageFormatObservableValue v = new MessageFormatObservableValue(decorated, null);

		assertEquals(String.class, v.getValueType());
		assertEquals("", v.getValue());
		final IValueChangeListener listener = new IValueChangeListener() {
			@Override
			public void handleValueChange(ValueChangeEvent event) {
				changeCount++;
			}
		};
		v.addValueChangeListener(listener);
		assertEquals(0, changeCount);

		decorated.setValue("hello");
		assertEquals(1, changeCount);
		assertEquals("hello", v.getValue());

		decorated.setValue("hello 2");
		assertEquals(2, changeCount);
		assertEquals("hello 2", v.getValue());

		v.setValue("olleh");
		assertEquals(3, changeCount);
		assertEquals("olleh", v.getValue());
		assertEquals("olleh", decorated.getValue());

		v.setMessageFormat("2: {0}");
		assertEquals(4, changeCount);
		assertEquals("olleh", decorated.getValue());
		assertEquals("2: olleh", v.getValue());

		decorated.setValue("hello 3");
		assertEquals(5, changeCount);
		assertEquals("2: hello 3", v.getValue());

		try {
			v.setValue("hello 4");
			fail("Exception expected");
		} catch (final IllegalStateException ex) {
			// OK
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
		assertEquals(5, changeCount);
		assertEquals("hello 3", decorated.getValue());
		assertEquals("2: hello 3", v.getValue());

		v.setMessageFormat("disabled");
		assertEquals(6, changeCount);
		assertEquals("hello 3", decorated.getValue());
		assertEquals("disabled", v.getValue());

		v.removeValueChangeListener(listener);
	}
}
