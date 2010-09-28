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
import java.util.Collections;
import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.list.ObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.IChildCreationSpecification;
import com.rcpcompany.uibindings.IConstantTreeItem;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IElementParentage;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.ITreeItemDescriptor;
import com.rcpcompany.uibindings.ITreeItemRelation;
import com.rcpcompany.uibindings.IUIBindingsFactory;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Observable list special-made for {@link ViewerBindingTreeFactory}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerBindingTreeFactoryList extends ObservableList {
	/**
	 * Shortcut to the manager...
	 */
	protected static final IManager THE_MANAGER = IManager.Factory.getManager();

	/**
	 * The tree factory that created this list.
	 */
	private final ViewerBindingTreeFactory myFactory;

	/**
	 * Constructs and returns a new list.
	 * 
	 * @param factory the tree factory that created this list
	 */
	public ViewerBindingTreeFactoryList(ViewerBindingTreeFactory factory) {
		super(Collections.EMPTY_LIST, EObject.class);
		myFactory = factory;

		if (Activator.getDefault().TRACE_TREE) {
			addListChangeListener(new IListChangeListener() {
				@Override
				public void handleListChange(ListChangeEvent event) {
					event.diff.accept(new ListDiffVisitor() {
						@Override
						public void handleRemove(int index, Object element) {
							LogUtils.debug(ViewerBindingTreeFactoryList.this, "removed[" + index + "]: " + element);
						}

						@Override
						public void handleAdd(int index, Object element) {
							LogUtils.debug(ViewerBindingTreeFactoryList.this, "added[" + index + "]: " + element);
						}
					});
				}
			});
		}
	}

	@Override
	public synchronized void dispose() {
		for (final IElement be : myElements) {
			be.dispose();
		}
		super.dispose();
	}

	/**
	 * Adds the children of a new target element to the list.
	 * 
	 * @param target the target
	 * @param descriptor the descriptor used for the target
	 */
	public void addChildren(EObject target, ITreeItemDescriptor descriptor) {
		new RelationElement(target, descriptor);
	}

	/**
	 * Adds the specific target element to the list.
	 * 
	 * @param target the target
	 */
	public void addDirect(EObject target) {
		new DirectElement(target);
	}

	/**
	 * Returns whether the content of this list with the current children is constant.
	 * <p>
	 * A constant list can be optimized to a constant {@link IObservableList} by the caller.
	 * 
	 * @return <code>true</code> if constant
	 */
	public boolean isConstant() {
		for (final IElement be : myElements) {
			if (!be.isConstant()) return false;
		}

		return true;
	}

	/**
	 * Listener used to recalculate the list when any of the added elements change.
	 */
	private final IChangeListener myRelationChangeListener = new IChangeListener() {
		@Override
		public void handleChange(ChangeEvent event) {
			recalculateList();
		}
	};

	/**
	 * The base elements of this list.
	 */
	private final List<IElement> myElements = new ArrayList<IElement>();

	/**
	 * The basic interface for an element in the base list.
	 * <p>
	 * Each of the elements can add to the list of results
	 */
	protected interface IElement extends IDisposable {
		/**
		 * Returns the target (parent) for this element.
		 * 
		 * @return the target
		 */
		EObject getTarget();

		/**
		 * Add of the generated elements for this element to the specified list.
		 * 
		 * @param list the list to add the elements to
		 */
		void addToList(List<EObject> list);

		/**
		 * Returns whether the content of this element is constant.
		 * 
		 * @return <code>true</code> if constant
		 */
		boolean isConstant();

		/**
		 * @see ViewerBindingTreeFactoryList#getElementParentage(EObject)
		 */
		IElementParentage getElementParentage(final EObject element);

		/**
		 * @see ViewerBindingTreeFactoryList#getPossibleChildObjects()
		 */
		void getPossibleChildObjects(List<IChildCreationSpecification> l);
	}

	/**
	 * A direct element.
	 */
	protected class DirectElement implements IElement {

		private final EObject myTarget;

		@Override
		public EObject getTarget() {
			return myTarget;
		}

		/**
		 * Constructs and returns a new direct element.
		 * 
		 * @param target the target
		 */
		protected DirectElement(EObject target) {
			myTarget = target;
			myElements.add(this);
			recalculateList();
		}

		@Override
		public void dispose() {
		}

		@Override
		public void addToList(List<EObject> list) {
			list.add(myTarget);
		}

		@Override
		public boolean isConstant() {
			return true;
		}

		@Override
		public IElementParentage getElementParentage(EObject element) {
			return null;
		}

		@Override
		public void getPossibleChildObjects(List<IChildCreationSpecification> l) {
		}
	}

	/**
	 * Element that will add child elements based on the relations from the element itself.
	 */
	protected class RelationElement implements IElement {
		private final EObject myTarget;
		private final ITreeItemDescriptor myDescriptor;
		private List<Relation> myRelations = null;

		@Override
		public EObject getTarget() {
			return myTarget;
		}

		/**
		 * Constructs and returns new base element.
		 * 
		 * @param target the target
		 * @param descriptor the descriptor used for the target
		 */
		protected RelationElement(EObject target, ITreeItemDescriptor descriptor) {
			myTarget = target;
			myDescriptor = descriptor;
			myElements.add(this);

			/*
			 * List of observables - both IOV and IOL - that will be the children of this item.
			 * Ironed out later
			 * 
			 * We get them in the correct sequence as the list is already sorted by priority
			 */
			for (final ITreeItemRelation rel : descriptor.getChildRelations()) {
				final String treeID = myFactory.getTreeID();
				if (treeID != null && treeID.length() > 0) {
					if (!rel.getTreeIDs().contains(treeID)) {
						continue;
					}
				}
				if (rel.getProcessor() != null) {
					final IObservableFactory processor = rel.getProcessor().getObject();
					if (processor != null) {
						addRelation(rel, processor.createObservable(target), null);
					}
				} else if (rel.getFeatureName() != null) {
					final String sfName = rel.getFeatureName();
					final EStructuralFeature sf = target.eClass().getEStructuralFeature(sfName);
					if (sf == null) {
						LogUtils.error(target, target + " does not support feature " + sfName + ", ignored"); //$NON-NLS-1$
						continue;
					}
					if (!(sf instanceof EReference)) {
						LogUtils.error(target, sfName + " is not a reference, ignored"); //$NON-NLS-1$
						continue;
					}
					if (sf.isMany()) {
						addRelation(rel, UIBindingsEMFObservables.observeList(null, null, target, sf), null);
					} else {
						addRelation(rel, UIBindingsEMFObservables.observeValue(null, null, target, sf), null);
					}
				} else {
					final IConstantTreeItem item = IUIBindingsFactory.eINSTANCE.createConstantTreeItem();
					item.setDescriptor(rel.getDescriptor());
					item.setTarget(target);
					addRelation(rel, Observables.constantObservableValue(item), rel.getDescriptor());
				}
			}

			recalculateList();
		}

		private void addRelation(final ITreeItemRelation rel, IObservable observable,
				ITreeItemDescriptor childDescriptor) {
			if (Activator.getDefault().TRACE_TREE) {
				observable.addChangeListener(new IChangeListener() {
					@Override
					public void handleChange(ChangeEvent event) {
						LogUtils.debug(ViewerBindingTreeFactoryList.this, "rel changed: " + rel);
					}
				});
			}

			if (myRelations == null) {
				myRelations = new ArrayList<Relation>();
			}
			myRelations.add(new Relation(rel, observable, childDescriptor));
		}

		@Override
		public void dispose() {
			if (myRelations == null) return;
			for (final Relation rel : myRelations) {
				rel.dispose();
			}
		}

		/**
		 * Information about the relations elements that ends up on the list.
		 * <p>
		 * Each base element corresponds to one
		 */
		protected class Relation implements IDisposable {
			private final ITreeItemRelation myRelation;
			private final IObservable myObservable;
			private final ITreeItemDescriptor myChildDescriptor;

			/**
			 * Constructs and returns new base element.
			 * 
			 * @param relation
			 * @param observable
			 * @param childDescriptor TODO
			 */
			protected Relation(ITreeItemRelation relation, IObservable observable, ITreeItemDescriptor childDescriptor) {
				myRelation = relation;
				myObservable = observable;
				myChildDescriptor = childDescriptor;

				myObservable.addChangeListener(myRelationChangeListener);
			}

			@Override
			public void dispose() {
				myObservable.removeChangeListener(myRelationChangeListener);
			}

			public void addToList(List<EObject> newList) {
				if (myObservable instanceof IObservableValue) {
					final IObservableValue ov = (IObservableValue) myObservable;
					final EObject value = (EObject) ov.getValue();
					if (value == null) return;
					/*
					 * Test if we are to hide a child because it does not have any children itself.
					 */
					if (myChildDescriptor != null && myChildDescriptor.isEmptyFolderHidden()) {
						final IObservableList childList = (IObservableList) myFactory.createObservable(value);
						if (childList == null || childList.isEmpty()) return;
					}
					newList.add(value);
					return;
				}
				if (myObservable instanceof IObservableList) {
					final IObservableList ol = (IObservableList) myObservable;
					newList.addAll(ol);
					return;
				}
			}

			/**
			 * Returns whether the content of this specific relation is constant.
			 * 
			 * @return <code>true</code> if constant
			 */
			public boolean isConstant() {
				if (myObservable instanceof IObservableValue) {
					if (myChildDescriptor != null && !myChildDescriptor.isEmptyFolderHidden()) return true;
					return false;
				}
				if (myObservable instanceof IObservableList) return false;
				return false;
			}

			/**
			 * @see ViewerBindingTreeFactoryList#getElementParentage(EObject)
			 */
			public IElementParentage getElementParentage(final EObject element) {
				Object type = null;
				if (myObservable instanceof IObservableValue) {
					final IObservableValue ov = (IObservableValue) myObservable;
					final EObject value = (EObject) ov.getValue();
					if (value != element) return null;
					type = ov.getValueType();
				}
				if (myObservable instanceof IObservableList) {
					final IObservableList ol = (IObservableList) myObservable;
					if (!ol.contains(element)) return null;
					type = ol.getElementType();
				}
				if (!(type instanceof EReference)) return null;
				final EReference ref = (EReference) type;

				return new IElementParentage() {
					@Override
					public EReference getReference() {
						return ref;
					}

					@Override
					public EObject getParent() {
						return getTarget();
					}

					@Override
					public EObject getElement() {
						return element;
					}
				};
			}
		}

		@Override
		public void addToList(List<EObject> newList) {
			if (myRelations == null) return;
			for (final Relation rel : myRelations) {
				rel.addToList(newList);
			}
		}

		@Override
		public boolean isConstant() {
			if (myRelations == null) return true;
			for (final Relation rel : myRelations) {
				if (!rel.isConstant()) return false;
			}

			return true;
		}

		@Override
		public IElementParentage getElementParentage(EObject element) {
			if (myRelations == null) return null;
			for (final Relation rel : myRelations) {
				final IElementParentage p = rel.getElementParentage(element);
				if (p != null) return p;
			}

			return null;
		}

		@Override
		public void getPossibleChildObjects(List<IChildCreationSpecification> l) {
			for (final ITreeItemRelation rel : myDescriptor.getChildRelations()) {
				final String treeID = myFactory.getTreeID();
				if (treeID != null && treeID.length() > 0) {
					if (!rel.getTreeIDs().contains(treeID)) {
						continue;
					}
				}
				if (rel.getProcessor() != null) {
					/*
					 * Cannot handle processors...
					 */
				} else if (rel.getFeatureName() != null) {
					final String sfName = rel.getFeatureName();
					final EStructuralFeature sf = myTarget.eClass().getEStructuralFeature(sfName);
					if (sf == null || !(sf instanceof EReference) || !sf.isMany()) {
						continue;
					}
					final EReference ref = (EReference) sf;
					ViewerBindingImpl.addToChildCreationSpecification(l, myTarget, ref, ref.getEReferenceType());
				} else {
					final IConstantTreeItem item = IUIBindingsFactory.eINSTANCE.createConstantTreeItem();
					item.setDescriptor(rel.getDescriptor());
					item.setTarget(myTarget);
					final ViewerBindingTreeFactoryList list = (ViewerBindingTreeFactoryList) myFactory
							.createObservable(item);
					l.addAll(list.getPossibleChildObjects());
				}
			}
		}
	}

	/**
	 * Updates the list based on the added elements.
	 */
	public void recalculateList() {
		final List<EObject> newList = new ArrayList<EObject>();

		for (final IElement be : myElements) {
			be.addToList(newList);
		}

		updateWrappedList(newList);
	}

	@Override
	public String toString() {
		return super.toString() + "@" + hashCode();
	}

	/**
	 * Returns the parentage for the element in this list.
	 * 
	 * @param element the element in question
	 * @return an object that describes the parentage or <code>null</code> if the parentage is not
	 *         known
	 */
	public IElementParentage getElementParentage(final EObject element) {
		for (final IElement be : myElements) {
			final IElementParentage p = be.getElementParentage(element);
			if (p != null) return p;
		}

		return null;
	}

	/**
	 * Returns a list of the possible objects that can be created as sub-elements of this list.
	 * 
	 * @return a list of possible children
	 */
	public List<IChildCreationSpecification> getPossibleChildObjects() {
		final List<IChildCreationSpecification> l = new ArrayList<IChildCreationSpecification>();
		for (final IElement be : myElements) {
			be.getPossibleChildObjects(l);
		}

		return l;
	}
}
