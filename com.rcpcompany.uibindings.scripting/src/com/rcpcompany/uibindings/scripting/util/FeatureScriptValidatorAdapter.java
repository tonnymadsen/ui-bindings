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
package com.rcpcompany.uibindings.scripting.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.bindingMessages.AbstractBindingMessage;
import com.rcpcompany.uibindings.scripting.IFeatureScript;
import com.rcpcompany.uibindings.scripting.IScriptExpression;
import com.rcpcompany.uibindings.scripting.IScriptingPackage;
import com.rcpcompany.uibindings.validators.AbstractValidatorAdapter;

/**
 * This validation adaptor will handle {@link IFeatureScript} objects.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FeatureScriptValidatorAdapter extends AbstractValidatorAdapter {

	@SuppressWarnings("unchecked")
	@Override
	public void validateObjectTree(EObject root, IObservableList messages) {
		final List<IFeatureScript> foundStatus = new ArrayList<IFeatureScript>();

		collectObjects(root, foundStatus);

		final List<Message> toRemoveList = new ArrayList<Message>(messages);
		final List<Message> toAddList = new ArrayList<Message>();

		for (final IFeatureScript s : foundStatus) {
			boolean old = false;
			for (final Object o : messages) {
				final Message f = (Message) o;
				if (f.getFS().equals(s)) {
					old = true;
					toRemoveList.remove(f);
				}
			}
			if (old) {
				continue;
			}
			toAddList.add(new Message(s));
		}

		messages.removeAll(toRemoveList);
		messages.addAll(toAddList);
	}

	/**
	 * Collects all feature script objects from the root down.
	 * 
	 * @param root the root of the tree
	 * @param foundObjects the list to be updated
	 */
	private void collectObjects(EObject root, List<IFeatureScript> foundObjects) {
		final TreeIterator<Object> allContents = EcoreUtil.getAllContents(root, false);

		while (allContents.hasNext()) {
			final Object c = allContents.next();
			if (!(c instanceof IFeatureScript)) {
				continue;
			}
			final IFeatureScript fs = (IFeatureScript) c;
			final IScriptExpression e = fs.getExpression();
			if (e == null || e.getErrorMessage() == null || e.getErrorMessage().length() == 0) {
				continue;
			}
			foundObjects.add(fs);
		}
	}

	/**
	 * Adaption from {@link IFeatureScript} to {@link IBindingMessage}.
	 */
	private static class Message extends AbstractBindingMessage {

		private final IFeatureScript myFS;

		public Message(IFeatureScript fs) {
			super(null);
			myFS = fs;

			addTarget(myFS.getObject(), myFS.getFeature());
		}

		@Override
		public String getSource() {
			return IScriptingPackage.eNS_URI;
		}

		@Override
		public int getCode() {
			return 0;
		}

		@Override
		public Object getData() {
			return myFS;
		}

		@Override
		public String getMessage() {
			return myFS.getExpression().getErrorMessage();
		}

		@Override
		public BindingMessageSeverity getSeverity() {
			return BindingMessageSeverity.ERROR;
		}

		public IFeatureScript getFS() {
			return myFS;
		}
	}
}
