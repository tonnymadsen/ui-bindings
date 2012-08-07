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
package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.CComboObservableList;
import com.rcpcompany.uibindings.internal.observables.TextObservableValue;
import com.rcpcompany.uibindings.internal.uiAttributeFactories.contentAdapters.CComboContentAdapter;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

/**
 * {@link IUIAttributeFactory} for {@link CCombo}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CComboDefaultUIAttributeFactory implements IUIAttributeFactory {

	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new Attribute(widget, attribute);
	}

	private static class Attribute extends SimpleUIAttribute {
		private final IObservableList myList;
		private final IControlContentAdapter myAdapter;

		private Attribute(Widget widget, String attribute) {
			super(widget, attribute, new TextObservableValue((CCombo) widget), true);

			myList = new CComboObservableList((CCombo) widget);
			addObservable(myList);
			myAdapter = new CComboContentAdapter();
		}

		@Override
		public IObservableList getPossibleValuesList() {
			return myList;
		}

		@Override
		public IControlContentAdapter getFieldAssistAdapter() {
			return myAdapter;
		}
	}
}
