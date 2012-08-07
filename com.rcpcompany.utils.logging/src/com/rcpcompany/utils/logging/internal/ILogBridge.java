package com.rcpcompany.utils.logging.internal;

/**
 * Bridge used to gate log messages from alternative log systems into LogUtils...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface ILogBridge {
	/**
	 * Initializes the bridge.
	 */
	void init();

	/**
	 * Disposes the bridge.
	 */
	void dispose();
}
