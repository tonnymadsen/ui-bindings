package com.rcpcompany.uibindings.extests.bindingMessages;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;

public class ValueBindingMessageImageDecoratorImageTest {
	@Test
	public void imageTests() {
		assertNotNull(ValueBindingMessageImageDecorator.theContentProposalFieldDecoration);
		assertNotNull(ValueBindingMessageImageDecorator.theInformationFieldDecoration);
		assertNotNull(ValueBindingMessageImageDecorator.theWarningFieldDecoration);
		assertNotNull(ValueBindingMessageImageDecorator.theErrorFieldDecoration);
		assertNotNull(ValueBindingMessageImageDecorator.theQuickfixFieldDecoration);
		assertNotNull(ValueBindingMessageImageDecorator.theRequiredFieldDecoration);
	}
}
