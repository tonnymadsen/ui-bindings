package com.rcpcompany.uibindings.debug.internals.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.utils.IBindingSpec.BaseType;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

public class CurrentSelectionView extends ViewPart {

	private final IObservableValue myViewValue = WritableValue.withValueType(EcorePackage.Literals.EJAVA_OBJECT);

	private final IObservableValue myCurrentPartValue = WritableValue.withValueType(EcorePackage.Literals.ESTRING);

	/**
	 * List with the {@link EObject} of the current selection.
	 */
	private final IObservableList myEObjectList = WritableList.withElementType(EcorePackage.Literals.EOBJECT);

	/**
	 * List with the {@link Object} of the current selection.
	 */
	private final List<Object> myObjectList = new ArrayList<Object>();

	private IFormCreator myForm;
	private IFormCreator myEObjectSection;
	private ITableCreator myEObjectTable;

	private IFormCreator myObjectSection;

	private TableViewer myObjectViewer;
	private TableViewerColumn myObjectViewerColumn;

	@Override
	public void createPartControl(Composite parent) {
		myForm = IFormCreator.Factory.createScrolledForm(myViewValue, parent, "Selected Objects");
		myForm.setReadOnly(true);

		myForm.addField(myCurrentPartValue, SWT.READ_ONLY).label("Current Part");

		myEObjectSection = myForm.addSection("EObjects");
		myEObjectTable = ITableCreator.Factory.create(myForm.getContext(), myEObjectSection.addComposite(), SWT.BORDER,
				myEObjectList);
		myEObjectTable.addColumn(BaseType.ROW_NO + "(w=100)");
		myEObjectTable.addColumn(BaseType.ROW_ELEMENT + "(w=300)").dynamic();

		myObjectSection = myForm.addSection("Other Objects");
		myObjectViewer = new TableViewer(myObjectSection.addComposite(), SWT.FULL_SELECTION | SWT.READ_ONLY);
		myObjectViewerColumn = new TableViewerColumn(myObjectViewer, SWT.NONE);
		myObjectViewerColumn.getColumn().setText("toString(");
		myObjectViewerColumn.getColumn().setWidth(400);
		myObjectViewer.setContentProvider(ArrayContentProvider.getInstance());
		myObjectViewer.setInput(myObjectList);

		final ISelectionService ss = getSite().getWorkbenchWindow().getSelectionService();
		ss.addPostSelectionListener(mySelectionListener);
		mySelectionListener.selectionChanged(this, ss.getSelection());
	}

	@Override
	public void dispose() {
		final ISelectionService ss = getSite().getWorkbenchWindow().getSelectionService();
		ss.removePostSelectionListener(mySelectionListener);

		super.dispose();
	}

	private final ISelectionListener mySelectionListener = new ISelectionListener() {
		@Override
		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			updateSelection(part, selection);
		}
	};

	@Override
	public void setFocus() {
	}

	protected void updateSelection(IWorkbenchPart part, ISelection selection) {
		myCurrentPartValue.setValue(part.toString());

		try {
			myEObjectList.clear();
			myObjectList.clear();

			if (!(selection instanceof IStructuredSelection)) return;

			final IStructuredSelection ss = (IStructuredSelection) selection;
			for (final Object o : ss.toArray()) {
				if (o instanceof EObject) {
					myEObjectList.add(o);
				} else {
					myObjectList.add(o);
				}
			}
		} finally {
			myObjectViewer.refresh();
		}
	}
}
