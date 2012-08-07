package com.rcpcompany.uibindings.extests;

import static org.junit.Assert.*;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.rcpcompany.uibindings.extests.views.UIBTestView;

public class UIBindingsTestUtils {
	/**
	 * Opens and returns a new test view.
	 * 
	 * @param creatingObject the object of the caller - used to name the new view
	 * 
	 * @return the new view
	 */
	public static UIBTestView createUIBTestView(Object creatingObject) {
		UIBTestView view = null;
		try {
			final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			view = (UIBTestView) page.showView("com.rcpcompany.uibindings.extests.views.TestView", "" + (testViewSeq++),
					IWorkbenchPage.VIEW_ACTIVATE);
			assertNotNull(view);
			view.setPartName("Test View: " + creatingObject.getClass().getSimpleName());
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
		view.getSite().getPage().activate(view);
		return view;
	}

	static int testViewSeq = 0;
}
