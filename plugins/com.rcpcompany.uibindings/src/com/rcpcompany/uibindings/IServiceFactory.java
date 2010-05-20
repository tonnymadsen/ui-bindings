package com.rcpcompany.uibindings;

/**
 * Factory that creates a service for the specified service target.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public interface IServiceFactory {
	/**
	 * Creates the service for the specified target.
	 * 
	 * @param target
	 */
	public void create(IServiceTarget target);
}
