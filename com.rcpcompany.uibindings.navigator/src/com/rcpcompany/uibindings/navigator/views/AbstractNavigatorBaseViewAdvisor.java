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
package com.rcpcompany.uibindings.navigator.views;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.ui.IViewSite;

/**
 * Abstract base class for {@link INavigatorBaseViewAdvisor}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractNavigatorBaseViewAdvisor implements INavigatorBaseViewAdvisor {

	@Override
	public abstract IObservableList getRootElements();

	@Override
	public void dispose() {
	}

	@Override
	public void setSite(IViewSite site) {
	}

	@Override
	public String getTreeID() {
		return "";
	}

	@Override
	public boolean isTreeReadonly() {
		return false;
	}

	@Override
	public boolean useTreeFilter() {
		return true;
	}

	@Override
	public boolean useLabelDecoration() {
		return true;
	}
}
