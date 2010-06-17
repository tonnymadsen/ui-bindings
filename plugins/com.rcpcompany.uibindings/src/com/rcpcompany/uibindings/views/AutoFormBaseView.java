package com.rcpcompany.uibindings.views;

import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.utils.IAutoFormCreator;
import com.rcpcompany.uibindings.utils.IGlobalNavigationManager.IGetSelectionTarget;
import com.rcpcompany.utils.selection.SelectionUtils;

/**
 * Creates and manages an {@link IAutoFormCreator}.
 * 
 * @author Tonny Madsen, The RCP Company
 * @param <T> the base type for the editor
 */
public class AutoFormBaseView<T extends EObject> extends ViewPart implements ISetSelectionTarget, IGetSelectionTarget {
	private final EClass myEClass;
	private final Class myClass;
	private final IObservableValue myCurrentValue;
	private IAutoFormCreator myForm;
	private final ISelectionListener mySelectionListener = new ISelectionListener() {

		@Override
		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			selectReveal(selection);
		}
	};
	private final String myTitle;

	/**
	 * Constructs and returns a new editor for the specified class and with the specified title.
	 * 
	 * @param eClass the class if the editor - must match T
	 * @param title the title for the editor
	 */
	public AutoFormBaseView(EClass eClass, String title) {
		myEClass = eClass;
		myTitle = title;
		myClass = myEClass.getInstanceClass();
		myCurrentValue = WritableValue.withValueType(eClass);
	}

	@Override
	public void createPartControl(Composite parent) {
		myForm = IAutoFormCreator.Factory.createForm(myCurrentValue, myTitle, parent, this);

		final ISelectionService ss = getSite().getWorkbenchWindow().getSelectionService();
		ss.addPostSelectionListener(mySelectionListener);
	}

	@Override
	public void dispose() {
		myForm.dispose();
		final ISelectionService ss = getSite().getWorkbenchWindow().getSelectionService();
		ss.removePostSelectionListener(mySelectionListener);
		super.dispose();
	}

	@Override
	public void setFocus() {
		myForm.getForm().setFocus();
	}

	@Override
	public void selectReveal(ISelection selection) {
		final List<T> list = SelectionUtils.computeSelection(selection, myClass);
		if (list.isEmpty()) return;

		myCurrentValue.setValue(list.get(0));
	}

	@Override
	public ISelection getCurrentSelection() {
		return new StructuredSelection(myCurrentValue.getValue());
	}
}
