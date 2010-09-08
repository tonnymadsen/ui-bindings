package com.rcpcompany.uibindings.units;

/**
 * Abstract {@link IUnit} used to isolate units from smaller changes in the interface.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractUnit implements IUnit {
	@Override
	public abstract IUnitDimension getDimension();

	@Override
	public abstract String getName();

	@Override
	public abstract boolean isName(String name);
}
