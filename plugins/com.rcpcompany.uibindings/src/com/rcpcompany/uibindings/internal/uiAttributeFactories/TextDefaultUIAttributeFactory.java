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
package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.TextObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

/**
 * Default {@link IUIAttributeFactory} for {@link Text} widgets.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class TextDefaultUIAttributeFactory implements IUIAttributeFactory {

	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new Attribute(widget, attribute);
	}

	private static class Attribute extends SimpleUIAttribute {
		private final IControlContentAdapter myAdapter;

		public Attribute(Widget widget, String attribute) {
			super(widget, attribute, new TextObservableValue((Text) widget), true);

			myAdapter = new TextContentAdapter();
		}

		@Override
		public IControlContentAdapter getFieldAssistAdapter() {
			return myAdapter;
		}
	}
}
