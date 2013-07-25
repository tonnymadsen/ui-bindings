package com.rcpcompany.test.utils.tests.fragment;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.LogService;

@Component
public class DSFragment {
	@Reference(unbind = "-")
	public void setLog(LogService ls) {

	}
}
