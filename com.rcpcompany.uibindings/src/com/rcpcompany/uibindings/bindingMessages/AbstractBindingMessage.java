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
package com.rcpcompany.uibindings.bindingMessages;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Control;

import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IBindingMessageTarget;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.internal.BindingMessageImpl;
import com.rcpcompany.uibindings.internal.BindingMessageTargetImpl;

/**
 * Abstract base class for all decorator messages.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractBindingMessage extends BindingMessageImpl {

	/**
	 * Constructs and returns a new message for the specified binding.
	 * 
	 * @param binding the binding
	 */
	protected AbstractBindingMessage(IValueBinding binding) {
		setBinding(binding);
	}

	/**
	 * Constructs and returns a new message for the specified binding.
	 * 
	 * @param binding the binding
	 * @param obj the object
	 * @param feature the feature, possibly <code>null</code>
	 */
	protected AbstractBindingMessage(IValueBinding binding, EObject obj, EStructuralFeature feature) {
		this(binding, obj, feature, null);
	}

	/**
	 * Constructs and returns a new message for the specified binding.
	 * 
	 * @param binding the binding
	 * @param obj the object
	 * @param feature the feature, possibly <code>null</code>
	 * @param key the key, possibly <code>null</code>
	 */
	protected AbstractBindingMessage(IValueBinding binding, EObject obj, EStructuralFeature feature, Object key) {
		this(binding);
		addTarget(obj, feature, key);
	}

	@Override
	public String getPrefix() {
		if (getBinding() == null) return "";
		return getBinding().getMessagePrefix();
	}

	@Override
	public Control getControl() {
		if (getBinding() == null) return null;
		return getBinding().getControl();
	}

	@Override
	public Object getKey() {
		return null;
	}

	@Override
	public String getSource() {
		return null;
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
	public EList<IBindingMessageTarget> getTargets() {
		return super.getTargets();
	}

	/**
	 * Returns the full message text for this message.
	 * <p>
	 * The prefix prepended to the message text - unless the message text already starts with the
	 * prefix.
	 * 
	 * @return the full message text
	 */
	public static String getFullMessage(IBindingMessage message) {
		final String prefix = message.getPrefix();
		final String text = message.getMessage();
		if (prefix == null) return text;
		if (text.startsWith(prefix)) return text;
		return prefix + text;
	}

	/**
	 * Adds a new target to the list of targets of this message.
	 * 
	 * @param obj the object
	 * @param feature the feature, possibly <code>null</code>
	 */
	public void addTarget(EObject obj, EStructuralFeature feature) {
		addTarget(obj, feature, null);
	}

	/**
	 * Adds a new target to the list of targets of this message.
	 * 
	 * @param obj the object
	 * @param feature the feature, possibly <code>null</code>
	 * @param key the key, possibly <code>null</code>
	 */
	public void addTarget(EObject obj, EStructuralFeature feature, Object key) {
		// Assert.isNotNull(obj);
		final BindingMessageTargetImpl target = new BindingMessageTargetImpl();
		target.setModelObject(obj);
		target.setModelFeature(feature);
		target.setModelKey(key);
		getTargets().add(target);
	}
}
