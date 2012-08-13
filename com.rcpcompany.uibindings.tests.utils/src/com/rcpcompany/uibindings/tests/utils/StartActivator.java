package com.rcpcompany.uibindings.tests.utils;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
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

		PlatformUI.getWorkbench().addWorkbenchListener(
				new IWorkbenchListener() {

					@Override
					public boolean preShutdown(IWorkbench workbench,
							boolean forced) {
						/*
						 * List all leftover TestViews
						 */
						final IWorkbenchPage page = workbench
								.getActiveWorkbenchWindow().getActivePage();
						for (final IViewReference vref : page
								.getViewReferences()) {
							if (!vref
									.getId()
									.equals("com.rcpcompany.uibindings.extests.views.TestView")) {
								continue;
							}
							System.out.println("Leftover view: "
									+ vref.getTitle());
						}
						return true;
					}

					@Override
					public void postShutdown(IWorkbench workbench) {
					}
				});
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}
}
