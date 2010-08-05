package com.rcpcompany.uibindings.navigator.internal.handlers;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

import com.rcpcompany.uibindings.navigator.IEditorModelType;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.utils.extensionpoints.CEResourceHolder;
import com.rcpcompany.utils.selection.SelectionUtils;

/**
 * Adds items to the "Open With" sub-menu based on the type of the current selection.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class OpenWithContributionFactory extends ExtensionContributionFactory {
	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		final ISelectionService ss = (ISelectionService) serviceLocator.getService(ISelectionService.class);

		final List<EObject> list = SelectionUtils.computeSelection(ss.getSelection(), EObject.class);

		/*
		 * Only know how to handle one item
		 */
		if (list.size() != 1) return;
		final EObject obj = list.get(0);

		final IEditorModelType mt = INavigatorManager.Factory.getManager().getModelType(obj.getClass());
		final EList<IEditorPartDescriptor> editors = mt.getEditors();

		/*
		 * Less than two editors... no need for an open with menu... Ignore.
		 */
		if (editors.size() < 2) return;

		/*
		 * Create contributions items for all the editors based on the name and image
		 */
		for (final IEditorPartDescriptor d : editors) {
			final IContributionItem item = new ContributionItem() {
				@Override
				public void fill(Menu menu, int index) {
					final MenuItem mi = new MenuItem(menu, SWT.NONE);
					mi.setText(d.getName());
					final CEResourceHolder image = d.getImage();
					if (image != null) {
						mi.setImage(image.getImage());
					}

					mi.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							mt.setPreferredEditor(d);
							INavigatorManager.Factory.getManager().openView(obj);
						}
					});
				}
			};
			additions.addContributionItem(item, null);
		}
	}
}
