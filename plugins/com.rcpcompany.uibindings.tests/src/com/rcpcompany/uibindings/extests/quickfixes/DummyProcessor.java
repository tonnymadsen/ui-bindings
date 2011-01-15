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
package com.rcpcompany.uibindings.extests.quickfixes;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;

import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IQuickfixProposal;
import com.rcpcompany.uibindings.IQuickfixProposalProcessor;
import com.rcpcompany.uibindings.IQuickfixProposalProcessorContext;
import com.rcpcompany.uibindings.quixkfixes.AbstractQuickfixProposal;
import com.rcpcompany.uibindings.quixkfixes.AbstractQuickfixProposal.Type;
import com.rcpcompany.uibindings.quixkfixes.AbstractQuickfixProposalProcessor;

public class DummyProcessor extends AbstractQuickfixProposalProcessor implements IQuickfixProposalProcessor,
		IExecutableExtension {
	private Object myData;

	@Override
	public void getProposals(IQuickfixProposalProcessorContext context, IBindingMessage message) {
		context.addProposal(new AbstractQuickfixProposal("dummy processor: " + myData, Type.CHANGE,
				IQuickfixProposal.DEFAULT_RELEVANCE) {
			@Override
			public void apply() {
			}
		});
	}

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		myData = data;
	}
}
