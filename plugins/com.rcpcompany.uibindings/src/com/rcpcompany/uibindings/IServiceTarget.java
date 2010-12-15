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
package com.rcpcompany.uibindings;

/**
 * The target of a service.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IServiceTarget {
	/**
	 * Enables/disables a specific service policy for this target.
	 * 
	 * @param id the ID of the service policy
	 * @param enabled the new state
	 */
	void setServicePolicyEnablement(String id, boolean enabled);

	/**
	 * Resets any target local enablement of the specified service.
	 * 
	 * @param id the ID of the service policy
	 */
	void resetServicePolicyEnablement(String id);

	/**
	 * Returns whether a specific service policy is enabled for this target.
	 * <p>
	 * Result is on both the local settings - see
	 * {@link #setServicePolicyEnablement(String, boolean)} and any global settings.
	 * 
	 * @param id the ID of the service policy
	 * @return whether the service is enabled
	 */
	boolean isServicePolicyEnabled(String id);

	/**
	 * Returns whether a specific service policy is changed specifically for this target.
	 * 
	 * @param id the ID of the service policy
	 * @returns whether the service is set specifically
	 */
	boolean isServicePolicyEnablement(String id);
}
