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
package com.rcpcompany.uibindings.scripting;

import org.eclipse.core.databinding.observable.list.IObservableList;

import com.rcpcompany.uibindings.IObservableListFactory;
import com.rcpcompany.uibindings.IValueBinding;

/**
 * {@link IObservableListFactory} for {@link IScriptManager#getLanguageList()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class LanguageListFactory implements IObservableListFactory {
	@Override
	public IObservableList createList(IValueBinding binding) {
		return IScriptManager.Factory.getManager().getLanguageList();
	}
}
