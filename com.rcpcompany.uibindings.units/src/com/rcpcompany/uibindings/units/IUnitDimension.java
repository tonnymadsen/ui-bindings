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
package com.rcpcompany.uibindings.units;

import java.util.Collection;

/**
 * A unit dimension represents a type of unit.
 * <p>
 * Examples of dimensions are "currency" as well as all the dimension of the SI system (L, W, ...).
 * <p>
 * Two units are equivalent and be converted from one to the other iff
 * <code>u1.getDimension().equals(u2.getDimension())</code>.
 * <p>
 * Instances of this class are immutable.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public interface IUnitDimension {
	/**
	 * Returns the canonical name of the dimension.
	 * 
	 * @return the name
	 */
	String getName();

	/**
	 * Returns the collection of all units managed by this.
	 * 
	 * @return the units
	 */
	Collection<IUnit> getUnits();

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
