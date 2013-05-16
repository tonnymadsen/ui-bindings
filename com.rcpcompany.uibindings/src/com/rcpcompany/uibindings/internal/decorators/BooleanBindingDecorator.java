/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.decorators;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;

import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.decorators.SimpleUIBindingDecorator;

/**
 * Decorator for boolean values.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BooleanBindingDecorator extends SimpleUIBindingDecorator implements IUIBindingDecorator {
	/**
	 * The mapping of model values to UI values.
	 */
	protected static final Map<Boolean, String> MODEL_TO_UI_MAP = new HashMap<Boolean, String>();
	/**
	 * The mapping of UI values to model values.
	 */
	protected static final Map<String, Boolean> UI_TO_MODEL_MAP = new HashMap<String, Boolean>();
	protected static final IObservableList VALID_UI_LIST;

	static {
		MODEL_TO_UI_MAP.put(Boolean.TRUE, "true");
		UI_TO_MODEL_MAP.put("true", Boolean.TRUE);
		UI_TO_MODEL_MAP.put("1", Boolean.TRUE);
		UI_TO_MODEL_MAP.put("+", Boolean.TRUE);
		UI_TO_MODEL_MAP.put("yes", Boolean.TRUE);

		MODEL_TO_UI_MAP.put(Boolean.FALSE, "false");
		UI_TO_MODEL_MAP.put("false", Boolean.FALSE);
		UI_TO_MODEL_MAP.put("0", Boolean.FALSE);
		UI_TO_MODEL_MAP.put("-", Boolean.FALSE);
		UI_TO_MODEL_MAP.put("no", Boolean.FALSE);

		// Otherwise use a list with the currently defined target to model key - properly sorted
		final List<String> bl = new ArrayList<String>();
		bl.addAll(UI_TO_MODEL_MAP.keySet());
		Collections.sort(bl);

		VALID_UI_LIST = Observables.staticObservableList(bl, String.class);
	}

	@Override
	public IObservableList getValidUIList() {
		return VALID_UI_LIST;
	}

	@Override
	protected Object convertModelToUI(Object fromObject) {
		return MODEL_TO_UI_MAP.get(fromObject);
	}

	@Override
	protected Object convertUIToModel(Object fromObject) {
		fromObject = ("" + fromObject).toLowerCase();
		if (!UI_TO_MODEL_MAP.containsKey(fromObject))
			throw new IllegalArgumentException(MessageFormat.format("Illegal value ''{0}''", fromObject));
		return UI_TO_MODEL_MAP.get(fromObject);
	}

}
