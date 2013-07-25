package com.rcpcompany.test.utils.tests;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.LogService;

@Component
public class DSHost {
	@Reference(unbind = "-")
	public void set(LogService ls) {
	}
}
