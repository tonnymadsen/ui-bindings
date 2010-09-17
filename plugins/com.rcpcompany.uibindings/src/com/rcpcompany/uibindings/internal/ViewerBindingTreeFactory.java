/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Tree;

import com.rcpcompany.uibindings.IConstantTreeItem;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.ITreeItemDescriptor;
import com.rcpcompany.uibindings.ITreeItemRelation;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.utils.basic.ClassUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Tree factory for use in a {@link IViewerBinding viewer binding} when used with a {@link Tree}.
 * <p>
 * Note that this list also acts as a {@link TreeStructureAdvisor} - see
 * {@link ObservableListTreeContentProvider} for details.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerBindingTreeFactory extends TreeStructureAdvisor implements IObservableFactory {
	/**
	 * Shortcut to the manager...
	 */
	protected static final IManager MANAGER = IManager.Factory.getManager();

	/**
	 * The root element as specified for {@link TreeViewer#setInput(Object)}.
	 */
	public static final Object ROOT_ELEMENT = new Object() {
		@Override
		public String toString() {
			return "ROOT";
		};
	};

	/**
	 * Map with all results returned by this factory.
	 */
	private final Map<Object, IObservableList> myResults = new HashMap<Object, IObservableList>();

	/**
	 * The root elements of the tree.
	 */
	private final IObservableList myRootList;

	/**
	 * The ID of the tree.
	 */
	private final String myTreeID;

	/**
	 * Returns the ID of the tree.
	 * 
	 * @return the tree ID
	 */
	public String getTreeID() {
		return myTreeID;
	}

	/**
	 * Constructs and returns a new tree factory for the specified viewer.
	 * 
	 * @param rootList the root element
	 * @param treeID the ID of the tree
	 */
	public ViewerBindingTreeFactory(IObservableList rootList, String treeID) {
		myRootList = rootList;
		myTreeID = treeID;
	}

	@Override
	public IObservable createObservable(Object target) {
		if (target == null) return null;
		if (Activator.getDefault().TRACE_TREE) {
			LogUtils.debug(this, "object [" + ClassUtils.getLastClassName(target) + "]: " + target); //$NON-NLS-1$ //$NON-NLS-2$
		}
		/*
		 * The root items
		 */
		if (target == ROOT_ELEMENT) return myRootList;

		/*
		 * Look for any cached results
		 */
		final IObservableList list = myResults.get(target);
		if (list != null) return list;

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
			descriptor = MANAGER.getTreeItem(etarget);
		} else {
			LogUtils.error(this,
					"Target is not an EObject, but an " + ClassUtils.getLastClassName(target) + ": " + target); //$NON-NLS-1$
			return null;
		}

		/*
		 * If we don�t have a descriptor, then we don't have any children!
		 */
		if (descriptor == null) // if (Activator.getDefault().TRACE_TREE) {
			// LogUtils.debug(this,
			//						"Cannot find the descriptor for " + ClassUtils.getLastClassName(target) + ": " + target); //$NON-NLS-1$
			// }
			return null;

		final ViewerBindingTreeFactoryList l = new ViewerBindingTreeFactoryList(this);
		IObservableList result = l;
		l.addChildren(etarget, descriptor);
		/*
		 * If the result is a constant list, then we replace it with a better performing version.
		 */
		if (l.isConstant()) {
			result = Observables.staticObservableList(new ArrayList<Object>(l), l.getElementType());
			l.dispose();
		}
		if (Activator.getDefault().TRACE_TREE) {
			LogUtils.debug(this, "--> " + result); //$NON-NLS-1$
		}

		myResults.put(target, result);
		return result;
	}

	@Override
	public Boolean hasChildren(Object element) {
		final IObservableList list = (IObservableList) createObservable(element);
		if (list == null) return false;
		return !list.isEmpty();
	}

	@Override
	public Object getParent(Object child) {
		/*
		 * The root elements from the tree
		 */
		if (child == myRootList) return null;
		if (child == ROOT_ELEMENT) return null;

		final EObject echild;
		final ITreeItemDescriptor childDescriptor;

		/*
		 * Find the target and the descriptor for the child
		 */
		if (child instanceof IConstantTreeItem) {
			final IConstantTreeItem item = (IConstantTreeItem) child;
			echild = item.getTarget();
			childDescriptor = item.getDescriptor();
		} else if (child instanceof EObject) {
			echild = (EObject) child;
			childDescriptor = MANAGER.getTreeItem(echild);
		} else {
			LogUtils.error(this, "Child is not an EObject, but an " + ClassUtils.getLastClassName(child) + ": " + child); //$NON-NLS-1$
			return null;
		}

		/*
		 * Look at the parents TODO
		 */
//		final ITreeItemDescriptor parentDesc = childDescriptor.getPrimaryParent();
//		EObject parent = null;
//		if (parentDesc != null) {
//			parent = findParent(echild, childDescriptor, parentDesc, null);
//			if (parent != null) return parent;
//
//			LogUtils.error(parentDesc, "Parent Descriptor is not a parent of " + echild);
//		}
//
//		for (final ITreeItemRelation parentRel : childDescriptor.getParentRelations()) {
//			parent = findParent(echild, childDescriptor, parentRel.getParent(), parentRel);
//			if (parent != null) return parent;
//		}

		return null;
	}

	/**
	 * Tests whether the specified parent descriptor can be an immediate parent of the specified
	 * child.
	 * 
	 * @param echild the child object
	 * @param childDescriptor the child descriptor
	 * @param parentDesc the parent descriptor to test
	 * @param parentRelation possible parent relation to test
	 * @return the parent object of found; otherwise <code>null</code>
	 */
	private EObject findParent(EObject echild, ITreeItemDescriptor childDescriptor, ITreeItemDescriptor parentDesc,
			ITreeItemRelation parentRelation) {
		for (final ITreeItemRelation relation : parentDesc.getChildRelations()) {

		}
		return null;
	}
}
