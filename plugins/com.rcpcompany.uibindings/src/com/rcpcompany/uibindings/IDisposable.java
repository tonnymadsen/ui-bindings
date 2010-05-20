package com.rcpcompany.uibindings;

/**
 * Interface supported by all objects that must be disposed.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public interface IDisposable {

	/**
	 * Disposes of this object.
	 * <p>
	 * All resources must be freed. All listeners must be detached. Dispose will only be called once during the life
	 * cycle of an object.
	 */
	public void dispose();

}
