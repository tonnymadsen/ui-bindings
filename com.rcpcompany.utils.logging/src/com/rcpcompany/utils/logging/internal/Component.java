package com.rcpcompany.utils.logging.internal;

import org.eclipse.equinox.log.ExtendedLogService;
import org.osgi.service.log.LogService;

/**
 * OSGi DS Component Interface...
 * <p>
 * All real work happens in {@link LogUtilsImpl}.
 * 
 * @author Tonny Madsen, tma@bording.dk
 */
public class Component {
	/**
	 * OSGi DS Interface.
	 * 
	 * @param servive
	 *            the new service to bind to
	 */
	public void bindLogService(LogService servive) {
		LogUtilsImpl.getInstance().bindLogService(servive);
	}

	/**
	 * OSGi DS Interface.
	 * 
	 * @param service
	 *            the new service to bind to
	 */
	public void bindExtendedLogService(ExtendedLogService service) {
		LogUtilsImpl.getInstance().bindExtendedLogService(service);
	}
}
