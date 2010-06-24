package com.rcpcompany.uibindings.tests.application.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IPlaceholderFolderLayout;

/**
 * Perspective for the navigator.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NavigatorPerspective implements IPerspectiveFactory {
	private static final String PERSPECTIVE_ID = "com.rcpcompany.uibindings.example.application.perspectives.Navigator";

	private static final String NAVIGATOR_FOLDER = PERSPECTIVE_ID + ".navigatorFolder";
	private static final String APPLICATION_FOLDER = PERSPECTIVE_ID + ".applFolder";
	private static final String EDITORS_FOLDER = PERSPECTIVE_ID + ".editorsFolder";

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);

		IFolderLayout folder = layout.createFolder(APPLICATION_FOLDER, IPageLayout.LEFT, 1.0f, layout.getEditorArea());
		folder.addView("com.rcpcompany.uibindings.views.ValidationView");
		final IPlaceholderFolderLayout pfolder = layout.createPlaceholderFolder(EDITORS_FOLDER, IPageLayout.RIGHT,
				0.3f, APPLICATION_FOLDER);
		pfolder.addPlaceholder("com.rcpcompany.uibindings.navigator.views.BaseEditorView");

		folder = layout.createFolder(NAVIGATOR_FOLDER, IPageLayout.TOP, 0.65f, APPLICATION_FOLDER);
		folder.addView("com.rcpcompany.uibindings.shop.views.ShopNavigationView");
	}
}
