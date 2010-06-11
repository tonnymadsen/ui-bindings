package com.rcpcompany.uibindings.extests.quickfixes;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;

import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IQuickfixProposal;
import com.rcpcompany.uibindings.IQuickfixProposalProcessor;
import com.rcpcompany.uibindings.IQuickfixProposalProcessorContext;
import com.rcpcompany.uibindings.quixkfixes.AbstractQuickfixProposal;
import com.rcpcompany.uibindings.quixkfixes.AbstractQuickfixProposalProcessor;
import com.rcpcompany.uibindings.quixkfixes.AbstractQuickfixProposal.Type;

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
