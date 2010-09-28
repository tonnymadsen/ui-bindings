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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.databinding.observable.DisposeEvent;
import org.eclipse.core.databinding.observable.IDisposeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Tree;

import com.rcpcompany.uibindings.IChildCreationSpecification;
import com.rcpcompany.uibindings.IConstantTreeItem;
import com.rcpcompany.uibindings.IElementParentage;
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
 * <p>
 * This class operates with two types of parent objects: parents in the object model (called
 * <em>model parents</em>) and parents in the view model (called <em>view parents</em>).
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
	 * <p>
	 * Maps view parents to the list with the children in the parent.
	 */
	private final Map<EObject, ViewerBindingTreeFactoryList> myResults = new HashMap<EObject, ViewerBindingTreeFactoryList>();

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
		l.addChildren(etarget, descriptor);
		/*
		 * If the result is a constant list, then we replace it with a better performing version.
		 * 
		 * We do not replace with a constant list as this makes in impossible to find the possible
		 * child objects.
		 */
		// if (l.isConstant()) {
		// result = Observables.staticObservableList(new ArrayList<Object>(l), l.getElementType());
		// l.dispose();
		// }
		if (Activator.getDefault().TRACE_TREE) {
			LogUtils.debug(this, "--> " + l); //$NON-NLS-1$
		}

		l.addDisposeListener(myDisposeListener);
		myResults.put((EObject) target, l);
		return l;
	}

	/**
	 * Dispose listener used to remove mappings when the lists are disposed...
	 */
	private final IDisposeListener myDisposeListener = new IDisposeListener() {
		@Override
		public void handleDispose(DisposeEvent event) {
			final ViewerBindingTreeFactoryList l = (ViewerBindingTreeFactoryList) event.getObservable();
			for (final Iterator<Entry<EObject, ViewerBindingTreeFactoryList>> i = myResults.entrySet().iterator(); i
					.hasNext();) {
				if (i.next().getValue() == l) {
					i.remove();
					return;
				}
			}
		}
	};

	/**
	 * Returns the view parent object from {@link #myResults} that contains the specified child
	 * element.
	 * 
	 * @param element the element to find
	 * @return the parent or <code>null</code> if not found
	 */
	private EObject findViewParent(EObject element) {
		for (final Entry<EObject, ViewerBindingTreeFactoryList> e : myResults.entrySet()) {
			if (e.getValue().contains(element)) return e.getKey();
		}

		return null;
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

	/**
	 * Returns the model parentage for the element in this tree factory.
	 * 
	 * @param element the element in question
	 * @return an object that describes the model parentage or <code>null</code> if the parentage is
	 *         not known
	 */
	public IElementParentage getElementParentage(final EObject element) {
		/*
		 * Find the parent (if any) for the list with the element...
		 */
		final EObject parent = findViewParent(element);
		if (parent == null) return null;

		final ViewerBindingTreeFactoryList list = myResults.get(parent);
		return list.getElementParentage(element);
	}

	/**
	 * Returns a list of the possible objects that can be created at the specified parent as
	 * sub-elements.
	 * 
	 * @param parent the view element that should be the parent of the child
	 * @return a list of possible children
	 */
	public List<IChildCreationSpecification> getPossibleChildObjects(EObject parent) {
		final ViewerBindingTreeFactoryList list = myResults.get(parent);
		if (list == null) return null;

		return list.getPossibleChildObjects();
	}
}
