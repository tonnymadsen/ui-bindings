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
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.IConstantTreeItem;
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
	protected static final IManager theManager = IManager.Factory.getManager();

	public ViewerBindingTreeFactoryList() {
		super(Collections.EMPTY_LIST, EObject.class);

		addListChangeListener(new IListChangeListener() {
			@Override
			public void handleListChange(ListChangeEvent event) {
				event.diff.accept(new ListDiffVisitor() {

					@Override
					public void handleRemove(int index, Object element) {
						if (Activator.getDefault().TRACE_TREE) {
							LogUtils.debug(ViewerBindingTreeFactoryList.this, "removed[" + index + "]: " + element);
						}
					}

					@Override
					public void handleAdd(int index, Object element) {
						if (Activator.getDefault().TRACE_TREE) {
							LogUtils.debug(ViewerBindingTreeFactoryList.this, "added[" + index + "]: " + element);
						}
					}
				});
			}
		});
	}

	/**
	 * Adds the children of a new target element to the list
	 * 
	 * @param target the target
	 * @param descriptor the descriptor used for the target
	 */
	public void addChildren(EObject target, ITreeItemDescriptor descriptor) {
		new RelationElement(target, descriptor);
	}

	/**
	 * Adds the specific target element to the list
	 * 
	 * @param target the target
	 */
	public void addDirect(EObject target) {
		new DirectElement(target);
	}

	protected IChangeListener myRelationChangeListener = new IChangeListener() {
		@Override
		public void handleChange(ChangeEvent event) {
			recalculateList();
		}
	};

	/**
	 * The base elements of this list
	 */
	protected final List<IElement> myElements = new ArrayList<IElement>();

	/**
	 * The basic interface for an element in the base list.
	 * <p>
	 * Each of the elements can add to the list of results
	 */
	protected interface IElement {
		/**
		 * Add of the generated elements for this element to the specified list
		 * 
		 * @param list the list to add the elements to
		 */
		void addToList(List<EObject> list);
	}

	protected class DirectElement implements IElement {

		private final EObject myTarget;

		/**
		 * Constructs and returns a new direct element
		 * 
		 * @param target the target
		 */
		public DirectElement(EObject target) {
			myTarget = target;
			myElements.add(this);
			recalculateList();
		}

		@Override
		public void addToList(List<EObject> list) {
			list.add(myTarget);
		}
	}

	/**
	 * Element that will add child elements based on the relations from the element itself.
	 */
	protected class RelationElement implements IElement {
		private final EObject myTarget;
		private final ITreeItemDescriptor myDescriptor;
		private final List<Relation> myRelations = new ArrayList<Relation>();

		/**
		 * Constructs and returns new base element
		 * 
		 * @param target the target
		 * @param descriptor the descriptor used for the target
		 */
		public RelationElement(EObject target, ITreeItemDescriptor descriptor) {
			myTarget = target;
			myDescriptor = descriptor;

			myElements.add(this);

			/*
			 * List of observables - both IOV and IOL - that will be the children of this item. Ironed out later
			 */
			for (final ITreeItemRelation rel : descriptor.getChildren()) {
				if (rel.getProcessor() != null) {
					addRelation(rel, rel.getProcessor().getObject().createObservable(target));
				} else if (rel.getFeatureName() != null) {
					final String sfName = rel.getFeatureName();
					final EStructuralFeature sf = target.eClass().getEStructuralFeature(sfName);
					if (sf == null) {
						LogUtils.error(target, target + " does not support feature " + sfName + ", ignored"); //$NON-NLS-1$
						continue;
					}
					if (sf.isMany()) {
						addRelation(rel, UIBindingsEMFObservables.observeList(null, null, target, sf));
					} else {
						addRelation(rel, UIBindingsEMFObservables.observeValue(null, null, target, sf));
					}
				} else {
					final IConstantTreeItem item = IUIBindingsFactory.eINSTANCE.createConstantTreeItem();
					item.setDescriptor(rel.getDescriptor());
					item.setTarget(target);
					addRelation(rel, Observables.constantObservableValue(item));
				}
			}

			recalculateList();
		}

		private void addRelation(ITreeItemRelation rel, IObservable observable) {
			myRelations.add(new Relation(rel, observable));
		}

		/**
		 * Information about the relations elements that ends up on the list.
		 * <p>
		 * Each base element corresponds to one
		 */
		protected class Relation {
			private final ITreeItemRelation myRelation;
			private final IObservable myObservable;

			/**
			 * Constructs and returns new base element
			 * 
			 * @param relation
			 * @param observable
			 */
			public Relation(ITreeItemRelation relation, IObservable observable) {
				myRelation = relation;
				myObservable = observable;

				myObservable.addChangeListener(myRelationChangeListener);
			}

			public void addToList(List<EObject> newList) {
				if (myObservable instanceof IObservableValue) {
					final IObservableValue ov = (IObservableValue) myObservable;
					newList.add((EObject) ov.getValue());
					return;
				}
				if (myObservable instanceof IObservableList) {
					final IObservableList ol = (IObservableList) myObservable;
					for (final Object value : ol) {
						newList.add((EObject) value);
					}
					return;
				}
			}
		}

		@Override
		public void addToList(List<EObject> newList) {
			for (final Relation rel : myRelations) {
				rel.addToList(newList);
			}
		}
	}

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
}
