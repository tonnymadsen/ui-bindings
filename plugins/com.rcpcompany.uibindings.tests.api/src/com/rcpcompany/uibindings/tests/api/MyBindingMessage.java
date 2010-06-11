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
		return getBinding();
	}

	@Override
	public void setBinding(IValueBinding value) {
	}

	@Override
	public String getMessage() {
		return getMessage();
	}

	@Override
	public BindingMessageSeverity getSeverity() {
		return getSeverity();
	}

	@Override
	public Object getData() {
		return getData();
	}

	@Override
	public int getCode() {
		return getCode();
	}

	@Override
	public String getDetails() {
		return getDetails();
	}

	@Override
	public EList<IBindingMessageTarget> getTargets() {
		return super.getTargets();
	}
}
