package com.rcpcompany.uibindings.navigator.views;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.SpecialBinding;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * The common base class for the navigation viewer.
 * 
 * TODO: add follow selection
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NavigatorBaseView extends ViewPart implements IExecutableExtension, ISetSelectionTarget {
	/**
	 * The advisor used for this view
	 */
	protected INavigatorBaseViewAdvisor myAdvisor = null;

	private Tree myTree;
	private TreeColumn myTreeColumn;

	private IBindingContext myContext;
	private IViewerBinding myTreeBinding;
	private IColumnBinding myTreeColumnBinding;
	private TreeViewer myTreeViewer;

	@Override
	public void createPartControl(Composite parent) {
		myContext = IBindingContext.Factory.createContext(parent);

		// TODO add filter

		myTree = new Tree(parent, SWT.SINGLE | SWT.FULL_SELECTION);
		myTree.setHeaderVisible(false);
		myTreeColumn = new TreeColumn(myTree, SWT.LEAD);
		myTreeColumn.setWidth(300);
		// TODO: use listener to make this column 100%

		final IObservableList list = myAdvisor.getRootElements();
		myTreeBinding = myContext.addViewer().viewer(myTree).model(list);
		myTreeViewer = (TreeViewer) myTreeBinding.getViewer();
		myTreeColumnBinding = myTreeBinding.addColumn().column(myTreeColumn).model(SpecialBinding.TREE_ITEM);

		myContext.finish();

		IBindingContextSelectionProvider.Factory.adapt(myContext, getSite());
	}

	@Override
	public void setFocus() {
		myTree.setFocus();
	}

	/**
	 * Collapses the tree completely
	 */
	public void collapseAll() {
		myTreeViewer.collapseAll();
	}

	@Override
	public void selectReveal(ISelection selection) {
		myTreeViewer.setSelection(selection, true);
	}

	@Override
	public void setInitializationData(IConfigurationElement ce, String propertyName, Object data) {
		super.setInitializationData(ce, propertyName, data);

		try {
			myAdvisor = (INavigatorBaseViewAdvisor) ce.createExecutableExtension("advisor");
		} catch (final CoreException ex) {
			LogUtils.error(this, ex);
			myAdvisor = new DummyAdvisor();
		}
	}

	/**
	 * Advisor used if/when the real advisor cannot be created
	 */
	public class DummyAdvisor extends AbstractNavigatorBaseViewAdvisor {
		@Override
		public IObservableList getRootElements() {
			return WritableList.withElementType(EObject.class);
		}
	}
}
