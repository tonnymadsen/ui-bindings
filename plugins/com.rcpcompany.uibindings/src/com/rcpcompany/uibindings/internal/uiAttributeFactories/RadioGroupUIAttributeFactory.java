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

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.nebula.widgets.radiogroup.RadioGroup;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.RadioGroupObservableList;
import com.rcpcompany.uibindings.internal.observables.RadioGroupValueObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

/**
 * {@link IUIAttributeFactory} for {@link RadioGroup}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class RadioGroupUIAttributeFactory implements IUIAttributeFactory {

	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new Attribute(widget, attribute);
	}

	private static class Attribute extends SimpleUIAttribute {
		private final IObservableList myList;

		public Attribute(Widget widget, String attribute) {
			super(widget, attribute, new RadioGroupValueObservableValue((RadioGroup) widget), true);

			myList = new RadioGroupObservableList((RadioGroup) widget);
			addObservable(myList);
		}

		@Override
		public IObservableList getPossibleValuesList() {
			return myList;
		}
	}
}
