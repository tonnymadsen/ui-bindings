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
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.list.ObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
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
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.observables.EListKeyedElementObservableValue;
import com.rcpcompany.uibindings.utils.IBindingSpec;
import com.rcpcompany.uibindings.utils.IBindingSpec.SpecContext;
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
		 * @param sibling TODO
		 * @see ViewerBindingTreeFactoryList#getPossibleChildObjects()
		 */
		void getPossibleChildObjects(List<IChildCreationSpecification> l, EObject sibling);
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
		public void getPossibleChildObjects(List<IChildCreationSpecification> l, EObject sibling) {
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
				if (treeID.length() > 0) {
					if (!rel.getTreeIDs().contains(treeID)) {
						continue;
					}
				} else {
					/*
					 * There are two cases if there are no tree id:
					 * 
					 * - if the relation has no associated tree ids, then use the relation
					 * 
					 * - if the relation has a tree id list, then only use the relation iff "" is a
					 * member of the list
					 * 
					 * [The first part of this condition is for optimizations as most relation will
					 * probably not have an associated tree id list...]
					 */
					if (rel.eIsSet(IUIBindingsPackage.Literals.TREE_ITEM_RELATION__TREE_IDS)
							&& rel.getTreeIDs().size() > 0 && !rel.getTreeIDs().contains("")) {
						continue;
					}
				}
				if (rel.getFactory() != null) {
					final IObservableFactory factory = rel.getFactory().getObject();
					if (factory == null) {
						continue;
					}
					try {
						final IObservable res = factory.createObservable(target);
						if (res == null) {
							LogUtils.error(rel.getFactory().getConfigurationElement(), "Factory returns null. Ignored");
							continue;
						}
						addRelation(rel, res, null, null);
					} catch (final Exception ex) {
						LogUtils.error(rel.getFactory().getConfigurationElement(), ex);
					}
				} else if (rel.getFeatureName() != null) {
					final String sfName = rel.getFeatureName();

					final List<IBindingSpec> specList = IBindingSpec.Factory.parseSingleSpec(target.eClass(), sfName,
							SpecContext.OBSERVABLE);
					if (specList == null) {
						continue;
					}

					IObservableValue parentValue = WritableValue.withValueType(target.eClass());
					parentValue.setValue(target);
					IObservable nextValue = null;
					EStructuralFeature lastFeature = null;
					for (final IBindingSpec s : specList) {
						if (nextValue != null) {
							parentValue = (IObservableValue) nextValue;
						}
						final EStructuralFeature feature = s.getFeature();
						lastFeature = s.getResultFeature();
						switch (s.getType()) {
						default:
							break;
						case FEATURE:
							if (feature.isMany()) {
								if (!s.isLast()) {
									LogUtils.error(feature, "Only last feature can be to-many");
								}
								nextValue = UIBindingsEMFObservables.observeDetailList(parentValue, feature);
							} else {
								nextValue = UIBindingsEMFObservables.observeDetailValue(parentValue, feature);
							}
							break;
						case KEY_VALUE:
							if (feature.isMany()) {
								LogUtils.error(feature, "Key/Value spec must be to-one");
							} else {
								nextValue = new EListKeyedElementObservableValue<EObject>(null, parentValue,
										(EReference) feature, s.getKeyFeature(), s.getKeyValue(), s.getValueFeature());
							}
							break;
						}

					}

					/*
					 * At this point we have
					 * 
					 * parentValue - non-null - the parent of the last node
					 * 
					 * nextValue - non-null - the current values for this relation
					 */
					addRelation(rel, nextValue, null, lastFeature);
				} else {
					final IConstantTreeItem item = IUIBindingsFactory.eINSTANCE.createConstantTreeItem();
					item.setDescriptor(rel.getDescriptor());
					item.setTarget(target);
					addRelation(rel, Observables.constantObservableValue(item), rel.getDescriptor(), null);
				}
			}

			recalculateList();
		}

		private void addRelation(final ITreeItemRelation rel, IObservable observable,
				ITreeItemDescriptor childDescriptor, EStructuralFeature feature) {
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
			myRelations.add(new Relation(rel, observable, childDescriptor, feature));
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
			private final EStructuralFeature myFeature;

			/**
			 * Constructs and returns new base element.
			 * 
			 * @param relation
			 * @param observable
			 * @param childDescriptor TODO
			 * @param feature TODO
			 */
			private Relation(ITreeItemRelation relation, IObservable observable, ITreeItemDescriptor childDescriptor,
					EStructuralFeature feature) {
				myRelation = relation;
				myObservable = observable;
				myChildDescriptor = childDescriptor;
				myFeature = feature;

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
				EObject parent = null;
				if (myObservable instanceof IObservableValue) {
					final IObservableValue ov = (IObservableValue) myObservable;
					final EObject value = (EObject) ov.getValue();
					if (value != element) return null;
					if (ov instanceof IObserving) {
						parent = (EObject) ((IObserving) ov).getObserved();
					}
					type = ov.getValueType();
				}
				if (myObservable instanceof IObservableList) {
					final IObservableList ol = (IObservableList) myObservable;
					if (!ol.contains(element)) return null;
					if (ol instanceof IObserving) {
						parent = (EObject) ((IObserving) ol).getObserved();
					}
					type = ol.getElementType();
				}
				if (!(type instanceof EReference)) return null;
				final EReference ref = (EReference) type;
				final EObject target = parent;

				return new IElementParentage() {
					@Override
					public EReference getReference() {
						return ref;
					}

					@Override
					public EObject getParent() {
						return target;
					}

					@Override
					public EObject getElement() {
						return element;
					}
				};
			}

			public void getPossibleChildObjects(List<IChildCreationSpecification> l, EObject sibling) {
				if (myRelation.getFactory() != null) {
					/*
					 * Cannot handle processors...
					 */
				} else if (myRelation.getFeatureName() != null) {
					final EReference ref = (EReference) myFeature;
					int index = -1;
					if (myFeature.isMany()) {
						/*
						 * If we seek a sibling, then look for it in the existing list
						 */
						if (sibling != null) {
							final IObservableList ol = (IObservableList) myObservable;
							index = ol.indexOf(sibling);
							if (index == -1) return;
						}
					} else {
						/*
						 * to-one reference: can only be added if not already present
						 */
						final IObservableValue value = (IObservableValue) myObservable;
						if (value.getValue() != null) return;
					}
					final EObject target = (EObject) ((IObserving) myObservable).getObserved();
					if (target == null) return;
					IViewerBinding.Factory.addToChildCreationSpecification(l, target, ref, ref.getEReferenceType(),
							index);
				} else {
					final IConstantTreeItem item = IUIBindingsFactory.eINSTANCE.createConstantTreeItem();
					item.setDescriptor(myRelation.getDescriptor());
					item.setTarget(getTarget());
					final ViewerBindingTreeFactoryList list = (ViewerBindingTreeFactoryList) myFactory
							.createObservable(item);
					l.addAll(list.getPossibleChildObjects(sibling));
				}
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
		public void getPossibleChildObjects(List<IChildCreationSpecification> l, EObject sibling) {
			if (myRelations == null) return;
			for (final Relation rel : myRelations) {
				rel.getPossibleChildObjects(l, sibling);
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
	 * @param sibling the wanted sibling or <code>null</code>
	 * @return a list of possible children
	 */
	public List<IChildCreationSpecification> getPossibleChildObjects(EObject sibling) {
		final List<IChildCreationSpecification> l = new ArrayList<IChildCreationSpecification>();
		for (final IElement be : myElements) {
			be.getPossibleChildObjects(l, sibling);
		}

		return l;
	}
}
