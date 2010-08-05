package com.rcpcompany.uibindings.navigator.views;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.SpecialBinding;
import com.rcpcompany.uibindings.navigator.IEditorPartView;
import com.rcpcompany.uibindings.navigator.internal.Activator;
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

	private IBindingContext myContext;
	private IViewerBinding myTreeBinding;
	private IColumnBinding myTreeColumnBinding;
	private TreeViewer myTreeViewer;

	/**
	 * Whether this navigator is linked to the editors or not...
	 */
	private boolean myIsLinkedWithEditors = false;

	private FilteredTree myFilteredTree;

	/**
	 * Sets whether this navigator is linked to the editors or not...
	 * 
	 * @param isLinked <code>true</code> if linked
	 */
	public void setLinkedWithEditors(boolean isLinked) {
		myIsLinkedWithEditors = isLinked;
	}

	/**
	 * Returns whether this navigator is linked to the editors or not...
	 * 
	 * @return <code>true</code> if linked
	 */
	public boolean isLinkedWithEditors() {
		return myIsLinkedWithEditors;
	}

	@Override
	public void createPartControl(Composite parent) {
		myContext = IBindingContext.Factory.createContext(parent);

		// TODO add filter

		final PatternFilter patternFilter = new TreePatternFilter();
		myFilteredTree = new FilteredTree(parent, SWT.FULL_SELECTION | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.BORDER, patternFilter, true);
		myTreeViewer = myFilteredTree.getViewer();
		myTree = myTreeViewer.getTree();
		myTree.setHeaderVisible(false);
		final TreeColumn column = new TreeColumn(myTree, SWT.LEAD);
		column.setWidth(300);
		// TODO: use layout to make this column 100%

		final IObservableList list = myAdvisor.getRootElements();
		myTreeBinding = myContext.addViewer().viewer(myTreeViewer).model(list);
		myTreeColumnBinding = myTreeBinding.addColumn().column(column).model(SpecialBinding.TREE_ITEM);

		myContext.finish();

		IBindingContextSelectionProvider.Factory.adapt(myContext, getSite());

		addToolbarItems();
		listenToSelection();
	}

	/**
	 * Adds view local toolbar items
	 */
	private void addToolbarItems() {
		final IToolBarManager toolbar = getViewSite().getActionBars().getToolBarManager();

		toolbar.add(new LinkWithEditorContributionItem());
	}

	/**
	 * Selection listener.
	 * <p>
	 * The functionality depends on {@link #isLinkedWithEditors()}.
	 */
	private final ISelectionListener listener = new ISelectionListener() {
		@Override
		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			if (isLinkedWithEditors() && part instanceof IEditorPartView) {
				final IEditorPartView view = (IEditorPartView) part;
				final EObject obj = view.getCurrentObject();
				if (obj != null) {
					selectReveal(new StructuredSelection(obj));
					return;
				}
			}
			selectReveal(selection);
		}
	};

	/**
	 * Sets up a listener for the current selection
	 */
	private void listenToSelection() {
		final ISelectionService ss = getSite().getWorkbenchWindow().getSelectionService();
		ss.addPostSelectionListener(listener);
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
		if (selection == null) return;
		if (selection.isEmpty()) return;
		if (selection.equals(myTreeViewer.getSelection())) return;
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

	/**
	 * {@link IContributionItem} for "Link with Editor".
	 */
	public class LinkWithEditorContributionItem extends ContributionItem {
		private ToolItem myItem;

		@Override
		public void fill(ToolBar parent, int index) {
			myItem = new ToolItem(parent, SWT.CHECK, index);
			final ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
			// images from IWorkbenchGraphicConstants
			final ImageRegistry imageRegistry = Activator.getDefault().getImageRegistry();
			imageRegistry.put("LINKED", AbstractUIPlugin.imageDescriptorFromPlugin(Activator.ID, "images/synced.gif"));
			myItem.setImage(imageRegistry.get("LINKED"));

			myItem.setToolTipText("Link navigator with editors");

			myItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					setLinkedWithEditors(!isLinkedWithEditors());
					update();
				}
			});
		}

		@Override
		public void update() {
			myItem.setSelection(isLinkedWithEditors());
		}
	}

	/**
	 * Pattern filter used for the navigator tree
	 */
	public class TreePatternFilter extends PatternFilter {

	}
}
