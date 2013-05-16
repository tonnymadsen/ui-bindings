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
package com.rcpcompany.uibindings.tests.api;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Control;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IBindingMessageTarget;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.bindingMessages.AbstractBindingMessage;

/**
 * Test of {@link AbstractBindingMessage}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class MyBindingMessage extends AbstractBindingMessage implements IBindingMessage {

	/**
	 * Tests that all methods are without restrictions.
	 */
	public static void test() {
		final IBindingMessage m = new MyBindingMessage(null);
		m.getBinding();
		m.getCode();
		m.getControl();
		m.getData();
		m.getDetails();
		m.getMessageType();
		m.getPrefix();
		m.getSeverity();
		m.getSource();
	}

	/**
	 * Constructs and returns a new message
	 * 
	 * @param binding the binding of the message
	 */
	public MyBindingMessage(IValueBinding binding) {
		super(binding);
	}

	@Override
	public Control getControl() {
		return super.getControl();
	}

	@Override
	public Object getKey() {
		return super.getKey();
	}

	@Override
	public String getPrefix() {
		return super.getPrefix();
	}

	@Override
	public String getSource() {
		return super.getSource();
	}

	@Override
	public boolean supersedes(IBindingMessage otherMessage) {
		return super.supersedes(otherMessage);
	}

	@Override
	public boolean matches(EObject obj, EStructuralFeature feature, Object key, FeatureMatchingAlgorithm algorithm) {
		return super.matches(obj, feature, key, algorithm);
	}

	@Override
	public IValueBinding getBinding() {
		return super.getBinding();
	}

	@Override
	public void setBinding(IValueBinding value) {
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	@Override
	public BindingMessageSeverity getSeverity() {
		return super.getSeverity();
	}

	@Override
	public Object getData() {
		return super.getData();
	}

	@Override
	public int getCode() {
		return super.getCode();
	}

	@Override
	public String getDetails() {
		return super.getDetails();
	}

	@Override
	public EList<IBindingMessageTarget> getTargets() {
		return super.getTargets();
	}
}
