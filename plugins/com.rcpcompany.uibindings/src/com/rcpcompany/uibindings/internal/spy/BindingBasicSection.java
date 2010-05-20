package com.rcpcompany.uibindings.internal.spy;

import org.eclipse.core.commands.ExecutionEvent;

import com.rcpcompany.uibindings.IBindingSpySection;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Basic section for {@link IValueBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingBasicSection implements IBindingSpySection {
	@Override
	public void build(IFormCreator creator, ExecutionEvent event) {
		final IFormCreator subform = creator.addSection("Basic Binding Information");

		subform.addField("state");
		subform.addField("type");
		subform.addSeparator();
		subform.addField("label");
		subform.addField("widget(label='Widget Class')").type("className");
		subform.addSeparator();
		subform.addField("changeable");
		subform.addField("dataType").type("className");
		subform.addField("modelEType");
		subform.addField("modelType").type("className");
		subform.addField("uiType").type("className");
	}
}
