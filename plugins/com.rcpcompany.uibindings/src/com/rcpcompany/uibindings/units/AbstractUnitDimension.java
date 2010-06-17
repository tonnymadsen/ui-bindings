package com.rcpcompany.uibindings.units;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Abstract {@link IUnitDimension} used to isolate unit dimensions from smaller changes in the
 * interface.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractUnitDimension implements IUnitDimension {
	@Override
	public abstract String getName();

	@Override
	public IUnit getUnit(String name) {
		for (final IUnit u : getUnits()) {
			if (u.isName(name)) {
				return u;
			}
		}
		return null;
	}

	/**
	 * The defined units for this unit manager.
	 */
	protected final Collection<IUnit> myUnits = new ArrayList<IUnit>();
	private final Collection<IUnit> myUnitsRO = Collections.unmodifiableCollection(myUnits);

	/**
	 * Adds the specified unit to the collection of unit for this dimension.
	 * 
	 * @param unit the new unit
	 */
	protected void addUnit(IUnit unit) {
		myUnits.add(unit);
	}

	@Override
	public Collection<IUnit> getUnits() {
		return myUnitsRO;
	}

}
