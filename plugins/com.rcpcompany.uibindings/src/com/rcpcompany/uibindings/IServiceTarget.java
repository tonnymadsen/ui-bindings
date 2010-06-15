package com.rcpcompany.uibindings;

/**
 * The target of a service.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public interface IServiceTarget {
	/**
	 * Enables/disables a specific service policy for this target.
	 * 
	 * @param id the ID of the service policy
	 * @param enabled the new state
	 */
	public void setServicePolicyEnablement(String id, boolean enabled);

	/**
	 * Resets any target local enablement of the specified service.
	 * 
	 * @param id the ID of the service policy
	 */
	public void resetServicePolicyEnablement(String id);

	/**
	 * Returns whether a specific service policy is enabled for this target.
	 * <p>
	 * Result is on both the local settings - see
	 * {@link #setServicePolicyEnablement(String, boolean)} and any global settings.
	 * 
	 * @param id the ID of the service policy
	 * @return whether the service is enabled
	 */
	public boolean isServicePolicyEnabled(String id);

	/**
	 * Returns whether a specific service policy is changed specifically for this target.
	 * 
	 * @param id the ID of the service policy
	 * @returns whether the service is set specifically
	 */
	public void isServicePolicyEnablement(String id);
}
