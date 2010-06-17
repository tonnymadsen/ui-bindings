package com.rcpcompany.uibindings.units;

import java.util.Collection;

/**
 * The interface for a Unit provider.
 * <p>
 * The unit framework of UI Bindings is built on the same concepts as used in JSR 275.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IUnitManager {
	/**
	 * Returns a collection with all the dimensions managed by this unit manager.
	 * 
	 * @return the collection of unit dimensions
	 */
	Collection<IUnitDimension> getDimensions();

	/**
	 * Returns the unit dimension with the given name.
	 * <p>
	 * See {@link IUnitDimension} for a description of the used names.
	 * 
	 * @param name the canonical name for the dimension
	 * @return the dimension or <code>null</code>
	 */
	IUnitDimension getDimension(String name);

	/**
	 * Returns the unit with the given name.
	 * <p>
	 * Unit names can be "".
	 * 
	 * @param name the name of the unit
	 * @return the unit or <code>null</code>
	 */
	IUnit getUnit(String name);
}
