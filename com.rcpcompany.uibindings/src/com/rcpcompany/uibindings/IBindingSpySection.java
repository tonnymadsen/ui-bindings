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
package com.rcpcompany.uibindings;

import org.eclipse.core.commands.ExecutionEvent;

import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * A section in the "Binding Spy Dialog".
 * <p>
 * For each section {@link #build(IFormCreator, ExecutionEvent)} is called once and can add the
 * specified {@link IFormCreator form}. The current binding is found as
 * <code>form.getObject()</code>.
 * <p>
 * The {@link #build(IFormCreator, ExecutionEvent)} can add to the form conditionally...
 * 
 * <pre>
 * public class BindingBasicSection implements IBindingSpySection {
 * 	&#064;Override
 * 	public void build(IFormCreator creator) {
 * 		final IBinding b = (IBinding) creator.getObject();
 * 		final IFormCreator subform = creator.addSection(&quot;Basic Binding Information&quot;);
 * 		subform.addField(null, IUIBindingsPackage.Literals.BINDING__STATE).readonly();
 * 		subform.addField(null, IUIBindingsPackage.Literals.BINDING__LABEL).readonly();
 * 		subform.addField(null, IUIBindingsPackage.Literals.BINDING__TYPE).readonly();
 * 		subform.addField(null, IUIBindingsPackage.Literals.BINDING__WIDGET).type(&quot;className&quot;).readonly();
 * 		subform.addField(null, IUIBindingsPackage.Literals.BINDING__DATA_TYPE).type(&quot;className&quot;).readonly();
 * 		subform.addField(null, IUIBindingsPackage.Literals.BINDING__MODEL_ETYPE).readonly();
 * 		subform.addField(null, IUIBindingsPackage.Literals.BINDING__MODEL_TYPE).type(&quot;className&quot;).readonly();
 * 		subform.addField(null, IUIBindingsPackage.Literals.BINDING__UI_TYPE).type(&quot;className&quot;).readonly();
 * 	}
 * }
 * </pre>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IBindingSpySection {
	/**
	 * Builds the section if relevant for the current object.
	 * 
	 * @param form the form to add to
	 * @param event TODO
	 */
	void build(IFormCreator form, ExecutionEvent event);
}
