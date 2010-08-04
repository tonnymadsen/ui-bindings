package com.rcpcompany.uibindings.bindingMessages;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
		final ArrayList<ILabelProviderListener> listeners = decorator.myListeners;
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
