package com.rcpcompany.utils.logging.internal;

import org.eclipse.equinox.log.ExtendedLogService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.LogService;

/**
 * OSGi DS Component Interface...
 * <p>
 * All real work happens in {@link LogUtilsImpl}.
 * 
 * @author Tonny Madsen, tma@bording.dk
 */
@Component
public class DSComponent {
	/**
	 * OSGi DS Interface.
	 * 
	 * @param servive
	 *            the new service to bind to
	 */
	@Reference(unbind = "-")
	public void bindLogService(LogService servive) {
		LogUtilsImpl.getInstance().bindLogService(servive);
	}

	/**
	 * OSGi DS Interface.
	 * 
	 * @param service
	 *            the new service to bind to
	 */
	@Reference(unbind = "-")
	public void bindExtendedLogService(ExtendedLogService service) {
		LogUtilsImpl.getInstance().bindExtendedLogService(service);
	}
}
