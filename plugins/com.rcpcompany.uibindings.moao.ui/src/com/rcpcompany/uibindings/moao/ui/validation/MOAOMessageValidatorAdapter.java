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
package com.rcpcompany.uibindings.moao.ui.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.bindingMessages.AbstractBindingMessage;
import com.rcpcompany.uibindings.moao.IMOAOMessage;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.validators.AbstractValidatorAdapter;

/**
 * This validation adaptor will handle {@link IMOAOMessage} objects.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class MOAOMessageValidatorAdapter extends AbstractValidatorAdapter {

	@SuppressWarnings("unchecked")
	@Override
	public void validateObjectTree(EObject root, IObservableList messages) {
		final List<IMOAOMessage> foundStatus = new ArrayList<IMOAOMessage>();

		collectObjects(root, foundStatus);

		final List<Message> toRemoveList = new ArrayList<Message>(messages);
		final List<Message> toAddList = new ArrayList<Message>();

		for (final IMOAOMessage s : foundStatus) {
			boolean old = false;
			for (final Object o : messages) {
				final Message f = (Message) o;
				if (f.getStatus().equals(s)) {
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
	 * Collects all status objects from the root down.
	 * 
	 * @param root the root of the tree
	 * @param foundObjects the list to be updated
	 */
	private void collectObjects(EObject root, List<IMOAOMessage> foundObjects) {
		final TreeIterator<Object> allContents = EcoreUtil.getAllContents(root, false);

		while (allContents.hasNext()) {
			final Object c = allContents.next();
			if (!(c instanceof IMOAOMessage)) {
				continue;
			}
			foundObjects.add((IMOAOMessage) c);
		}
	}

	/**
	 * Adaption from {@link IMOAOMessage} to {@link IBindingMessage}.
	 */
	private static class Message extends AbstractBindingMessage {

		private final IMOAOMessage myStatus;

		public Message(IMOAOMessage diagnostic) {
			super(null);
			myStatus = diagnostic;

			addTarget(myStatus.getObject(), myStatus.getFeature());
		}

		@Override
		public String getSource() {
			return IMOAOPackage.eNS_URI;
		}

		@Override
		public int getCode() {
			return 0;
		}

		@Override
		public Object getData() {
			return myStatus;
		}

		@Override
		public String getMessage() {
			return myStatus.getDescription();
		}

		@Override
		public BindingMessageSeverity getSeverity() {
			switch (myStatus.getSeverity()) {
			case COMMENT:
			case INFO:
				return BindingMessageSeverity.INFORMATION;
			case WARNING:
				return BindingMessageSeverity.WARNING;
			case ERROR:
				return BindingMessageSeverity.ERROR;
			}
			return BindingMessageSeverity.NONE;
		}

		public IMOAOMessage getStatus() {
			return myStatus;
		}
	}
}
