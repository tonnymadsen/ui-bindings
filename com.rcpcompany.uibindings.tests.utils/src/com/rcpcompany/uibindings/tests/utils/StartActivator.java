package com.rcpcompany.uibindings.tests.utils;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class StartActivator extends Plugin {
	public static int noMessages = 0;
	public ILogListener myLogListener = new ILogListener() {
		@Override
		public void logging(IStatus status, String plugin) {
			noMessages++;
		}
	};

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);

		Platform.addLogListener(myLogListener);
	}
}
