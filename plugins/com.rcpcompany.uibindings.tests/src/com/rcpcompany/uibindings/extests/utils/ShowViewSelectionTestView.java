package com.rcpcompany.uibindings.extests.utils;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.part.ViewPart;

/**
 * View used by {@link ShowViewSelectionTest}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ShowViewSelectionTestView extends ViewPart implements ISetSelectionTarget {

	@Override
	public void createPartControl(Composite parent) {
		theView = this;
	}

	@Override
	public void dispose() {
		theView = null;
		super.dispose();
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void selectReveal(ISelection selection) {
		setTheSelection(selection);
	}

	private static ISelection theSelection;

	public static void setTheSelection(ISelection selection) {
		theSelection = selection;
	}

	public static ISelection getTheSelection() {
		return theSelection;
	}

	private static ShowViewSelectionTestView theView = null;

	public static ShowViewSelectionTestView getTheView() {
		return theView;
	}
}
