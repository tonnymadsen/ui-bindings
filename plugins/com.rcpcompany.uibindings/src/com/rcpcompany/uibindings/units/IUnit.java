package com.rcpcompany.uibindings.units;

/**
 * A specific unit.
 * <p>
 * Instances of this class are immutable.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IUnit {
	/**
	 * Returns the dimension of this unit
	 * 
	 * @return the dimension
	 */
	IUnitDimension getDimension();

	/**
	 * Returns the canonical name for this unit.
	 * <p>
	 * <code>u.isName(u.getName()) == true</code>
	 * 
	 * @return the canonical name
	 */
	String getName();

	/**
	 * Returns whether this unit answers to the given name.
	 * <p>
	 * E.g. the unit for meters (the SI length base unit), likely answers to the names "m", "meter"
	 * and "meters".
	 * 
	 * @param name the possible name of this unit
	 * @return <code>true</code> if the name is a name for this unit
	 */
	boolean isName(String name);
}
