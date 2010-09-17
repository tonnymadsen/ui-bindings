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
package com.rcpcompany.uibindings.units.internals;

import com.rcpcompany.uibindings.units.AbstractUnitDimension;
import com.rcpcompany.uibindings.units.AbstractUnitManager;
import com.rcpcompany.uibindings.units.IUnitManager;

/**
 * {@link IUnitManager} for the screen units used to specify sizes of controls.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ScreenUnitManager extends AbstractUnitManager {
	public ScreenUnitManager() {
		addDimension(new ScreenDimension());
	}

	/**
	 * The dimension for screen units.
	 */
	public class ScreenDimension extends AbstractUnitDimension {

		@Override
		public String getName() {
			return "screen";
		}
	}

}
