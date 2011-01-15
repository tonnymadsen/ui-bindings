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
package com.rcpcompany.uibindings.units;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Abstract {@link IUnitManager} used to isolate unit managers from smaller changes in the interface.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractUnitManager implements IUnitManager {
	@Override
	public IUnitDimension getDimension(String name) {
		for (final IUnitDimension ud : getDimensions()) {
			if (ud.getName().equals(name)) {
				return ud;
			}
		}
		return null;
	}

	@Override
	public IUnit getUnit(String name) {
		for (final IUnitDimension ud : getDimensions()) {
			final IUnit unit = ud.getUnit(name);
			if (unit != null) {
				return unit;
			}
		}
		return null;
	}

	/**
	 * The defined dimensions for this unit manager.
	 */
	protected final Collection<IUnitDimension> myDimensions = new ArrayList<IUnitDimension>();
	private final Collection<IUnitDimension> myDimensionsRO = Collections.unmodifiableCollection(myDimensions);

	/**
	 * Adds the specified dimension to the collection of dimension of this manager.
	 * 
	 * @param dimension the new dimension
	 */
	protected void addDimension(IUnitDimension dimension) {
		myDimensions.add(dimension);
	}

	@Override
	public Collection<IUnitDimension> getDimensions() {
		return myDimensionsRO;
	}
}
