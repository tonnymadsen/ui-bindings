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
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.ListObservableList;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

public class ListUIAttributeFactory implements IUIAttributeFactory {

	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new ListUIAttribute(widget, attribute);
	}

	class ListUIAttribute extends SimpleUIAttribute {
		private final IObservableList myList;

		ListUIAttribute(Widget widget, String attribute) {
			super(widget, attribute, SWTObservables.observeSelection((Control) widget), true);

			myList = new ListObservableList((List) widget);
			addObservable(myList);
		}

		@Override
		public IObservableList getPossibleValuesList() {
			return myList;
		}
	}
}
