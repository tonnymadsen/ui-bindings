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
