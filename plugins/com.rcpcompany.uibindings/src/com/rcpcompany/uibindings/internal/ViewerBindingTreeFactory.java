package com.rcpcompany.uibindings.internal;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Tree;

import com.rcpcompany.uibindings.IConstantTreeItem;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.ITreeItemDescriptor;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.utils.basic.ClassUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Tree factory for use in a {@link IViewerBinding viewer binding} when used with a {@link Tree}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerBindingTreeFactory implements IObservableFactory {
	/**
	 * Shortcut to the manager...
	 */
	protected static final IManager manager = IManager.Factory.getManager();
	private final IViewerBinding myViewer;

	/**
	 * Constructs and returns a new tree factory for the specified viewer
	 * 
	 * @param viewer the viewer with the tree
	 */
	public ViewerBindingTreeFactory(IViewerBinding viewer) {
		myViewer = viewer;
	}

	@Override
	public IObservable createObservable(Object target) {
		if (Activator.getDefault().TRACE_TREE) {
			LogUtils.debug(this, "object [" + ClassUtils.getLastClassName(target) + "]: " + target); //$NON-NLS-1$ //$NON-NLS-2$
		}
		/*
		 * The root items
		 */
		if (target == myViewer.getList()) {
			return myViewer.getList();
		}

		final EObject etarget;
		final ITreeItemDescriptor descriptor;

		/*
		 * Find the target and the descriptor for the target
		 */
		if (target instanceof IConstantTreeItem) {
			final IConstantTreeItem item = (IConstantTreeItem) target;
			etarget = item.getTarget();
			descriptor = item.getDescriptor();
		} else if (target instanceof EObject) {
			etarget = (EObject) target;
			descriptor = manager.getTreeItem(etarget);
		} else {
			LogUtils.error(this,
					"Target is not an EObject, but an " + ClassUtils.getLastClassName(target) + ": " + target); //$NON-NLS-1$
			return null;
		}

		/*
		 * If we don´t have a descriptor, then we don't have any children!
		 */
		if (descriptor == null) {
			if (Activator.getDefault().TRACE_TREE) {
				// LogUtils.debug(this,
				//						"Cannot find the descriptor for " + ClassUtils.getLastClassName(target) + ": " + target); //$NON-NLS-1$
			}
			return null;
		}

		final ViewerBindingTreeFactoryList l = new ViewerBindingTreeFactoryList();
		l.addChildren(etarget, descriptor);
		if (Activator.getDefault().TRACE_TREE) {
			LogUtils.debug(this, "--> " + l); //$NON-NLS-1$
		}

		return l;
	}
}
