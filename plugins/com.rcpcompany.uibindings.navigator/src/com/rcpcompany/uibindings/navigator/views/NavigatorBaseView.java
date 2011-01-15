/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.SpecialBinding;
import com.rcpcompany.uibindings.navigator.IEditorPartView;
import com.rcpcompany.uibindings.navigator.INavigatorDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.internal.Activator;
import com.rcpcompany.uibindings.navigator.internal.NavigatorConstants;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IDnDSupport;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * The common base class for the navigation viewer.
 * 
 * TODO: add follow selection
 * 
 * TODO: replace FilterTree, to only add ViewerFilter to viewer when needed - otherwise problems
 * with move item
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

	/**
	 * Whether this the filter text is shown for this navigator...
	 */
	private boolean myShowFilterText = true;

	public boolean isShowFilterText() {
		return myShowFilterText;
	}

	public void setShowFilterText(boolean showFilterText) {
		myShowFilterText = showFilterText;

		if (myFilteredTree != null) {
			myFilteredTree.showFilterText(myShowFilterText);
		}
	}

	private MyFilteredTree myFilteredTree;

	private IMemento myMemento;

	@Override
	public void init(IViewSite site, IMemento memento) throws PartInitException {
		myMemento = memento;
		super.init(site, memento);
	}

	@Override
	public void saveState(IMemento memento) {
		super.saveState(memento);

		memento.putBoolean("IsLinkedWithEditors", isLinkedWithEditors());
		memento.putBoolean("ShowFilterText", isShowFilterText());
	}

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
		try {
			myAdvisor.setSite(getViewSite());
		} catch (final Exception ex) {
			LogUtils.error(myAdvisor, ex);
		}
		if (myMemento != null) {
			Boolean b;
			b = myMemento.getBoolean("LinkedWithEditors");
			if (b != null) {
				setLinkedWithEditors(b);
			}
			b = myMemento.getBoolean("ShowFilterText");
			if (b != null) {
				setShowFilterText(b);
			}
		} else {
			/*
			 * TODO Defaults from the advisor
			 */
		}
		myContext = IBindingContext.Factory.createContext(parent);

		final PatternFilter patternFilter = new TreePatternFilter();
		myFilteredTree = new MyFilteredTree(parent, SWT.FULL_SELECTION | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.BORDER, patternFilter, true);
		myTreeViewer = myFilteredTree.getViewer();
		myFilteredTree.showFilterText(isShowFilterText());
		myTree = myTreeViewer.getTree();
		myTree.setHeaderVisible(false);
		final TreeColumn column = new TreeColumn(myTree, SWT.LEAD);
		column.setWidth(300);

		IObservableList list = null;
		try {
			list = myAdvisor.getRootElements();
		} catch (final Exception ex) {
			LogUtils.error(myAdvisor, ex);
		}
		myTreeBinding = myContext.addViewer().viewer(myTreeViewer).model(list)
				.arg(Constants.ARG_DOUBLE_CLICK_COMMAND, Constants.DEFAULT_OPEN_COMMAND)
				.arg(Constants.ARG_TREE_ID, myAdvisor.getTreeID());
		myTreeColumnBinding = myTreeBinding.addColumn().column(column).model(SpecialBinding.TREE_ITEM)
				.arg(Constants.ARG_LABEL_DECORATOR, true).arg(Constants.ARG_SHOW_IMAGE, true);

		myContext.finish();

		IBindingContextSelectionProvider.Factory.adapt(myContext, getSite());
		IDnDSupport.Factory.installOn(myContext);

		addToolbarItems();
		listenToSelection();
	}

	@Override
	public void dispose() {
		super.dispose();

		try {
			myAdvisor.dispose();
		} catch (final Exception ex) {
			LogUtils.error(myAdvisor, ex);
		}
	}

	/**
	 * Adds view local toolbar items
	 */
	private void addToolbarItems() {
		final IToolBarManager toolbar = getViewSite().getActionBars().getToolBarManager();

		toolbar.add(new LinkWithEditorContributionItem());
		toolbar.add(new ShowFilterTextContributionItem());
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

		/*
		 * The advisor can come from either the advisor attribute of the view element or from the
		 * editors extension point...
		 */
		if (ce.getAttribute(NavigatorConstants.ADVISOR_TAG) != null) {
			try {
				myAdvisor = (INavigatorBaseViewAdvisor) ce.createExecutableExtension(NavigatorConstants.ADVISOR_TAG);
			} catch (final CoreException ex) {
				LogUtils.error(this, ex);
			}
		} else {
			final String id = ce.getAttribute(NavigatorConstants.ID_TAG);
			for (final INavigatorDescriptor n : INavigatorManager.Factory.getManager().getNavigators()) {
				if (n.getId().equals(id)) {
					myAdvisor = n.getAdvisor().getObject();
					break;
				}
			}
			if (myAdvisor == null) {
				LogUtils.error(this, "No advisor found for view ID: " + id);
			}
		}

		if (myAdvisor == null) {
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
			if (imageRegistry.getDescriptor("LINKED") == null) {
				imageRegistry.put("LINKED",
						AbstractUIPlugin.imageDescriptorFromPlugin(Activator.ID, "images/synced.gif"));
			}
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
	 * {@link IContributionItem} for "ShowFilterText".
	 */
	public class ShowFilterTextContributionItem extends ContributionItem {
		private ToolItem myItem;

		@Override
		public void fill(ToolBar parent, int index) {
			myItem = new ToolItem(parent, SWT.CHECK, index);
			final ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
			// images from IWorkbenchGraphicConstants
			final ImageRegistry imageRegistry = Activator.getDefault().getImageRegistry();
			if (imageRegistry.getDescriptor("ShowFilterText") == null) {
				imageRegistry.put("ShowFilterText",
						AbstractUIPlugin.imageDescriptorFromPlugin(Activator.ID, "images/filter_16x16.gif"));
			}
			myItem.setImage(imageRegistry.get("ShowFilterText"));

			myItem.setToolTipText("Show the tree filter");

			myItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					setShowFilterText(!isShowFilterText());
					update();
				}
			});
		}

		@Override
		public void update() {
			myItem.setSelection(isShowFilterText());
		}
	}

	/**
	 * Version of {@link FilteredTree} that allows the filter text to be shown/hidden
	 */
	public class MyFilteredTree extends FilteredTree {
		/**
		 * Constructs and returns a new filtered tree...
		 * 
		 * @param parent
		 * @param treeStyle
		 * @param filter
		 * @param useNewLook
		 */
		public MyFilteredTree(Composite parent, int treeStyle, PatternFilter filter, boolean useNewLook) {
			super(parent, treeStyle, filter, useNewLook);
		}

		/**
		 * Whether to show the filter text of not.
		 * 
		 * @param show <code>true</code> if the filter text should be shown - <code>false</code>
		 *            otherwise
		 */
		public void showFilterText(boolean show) {
			if (!showFilterControls) return;

			if (show == filterComposite.getVisible()) return;

			/*
			 * This is NOT pretty... but for now it works
			 */
			clearText();
			filterComposite.setVisible(show);
			((GridData) filterComposite.getLayoutData()).exclude = !show;
			layout(true);
		}
	}

	/**
	 * Pattern filter used for the navigator tree
	 */
	public class TreePatternFilter extends PatternFilter {

	}
}
