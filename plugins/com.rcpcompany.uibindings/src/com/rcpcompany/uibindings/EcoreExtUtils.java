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
package com.rcpcompany.uibindings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.utils.IBindingObjectInformation;

/**
 * Various Ecore oriented utility methods.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public final class EcoreExtUtils {
	private EcoreExtUtils() {

	}

	public static final EditingDomain THE_EDITING_DOMAIN = UIBindingsUtils.createEditingDomain();

	/**
	 * Synchronizes the information from the <code>source</code> object into the <code>target</code>
	 * object.
	 * <p>
	 * The sync is potentially destructive for the <code>source</code> object.
	 * 
	 * @param target the object synchronized into
	 * @param source the object synchronized from
	 */
	public static <T extends EObject> SyncController sync(T target, T source) {
		Assert.isTrue(source.getClass() == target.getClass(), "target and source must have exactly the same types");
		final SyncController controller = new SyncController();
		controller.setEditingDomain(THE_EDITING_DOMAIN);
		controller.sync(target, source);
		controller.commit();

		return controller;
	}

	/**
	 * Synchronizes the information from the <code>source</code> object into the <code>target</code>
	 * object.
	 * <p>
	 * The sync is potentially destructive for the <code>source</code> list.
	 * 
	 * @param target the object synchronized into
	 * @param source the object synchronized from
	 */
	public static <T extends EObject> SyncController sync(EList<T> target, EList<T> source) {
		final SyncController controller = new SyncController();
		controller.setEditingDomain(THE_EDITING_DOMAIN);
		controller.sync(target, source);
		controller.commit();

		return controller;
	}

	/**
	 * This class is used to control a synchronize operation in
	 * {@link EcoreExtUtils#sync(EObject, EObject)} and {@link EcoreExtUtils#sync(EList, EList)}.
	 */
	public static class SyncController {
		private EditingDomain myEditingDomain;
		/**
		 * A compound command that collects all the created commands.
		 */
		private CompoundCommand myCompoundCommand;

		/**
		 * A list of objects that have been removed in the synchronization from the target.
		 */
		private List<EObject> myRemovedObjects = null;

		/**
		 * Synchronizes the information from the <code>source</code> object into the
		 * <code>target</code> object.
		 * <p>
		 * The class of <code>target</code> and <code>source</code> must be the same, e.g.
		 * <code>source.getClass() == target.getClass()</code>.
		 * 
		 * @param <T> the type of the involved objects
		 * @param target the object synchronized into
		 * @param source the object synchronized from
		 */
		public <T extends EObject> void sync(T target, T source) {
			Assert.isNotNull(source);
			Assert.isNotNull(target);
			for (final EStructuralFeature sf : source.eClass().getEAllStructuralFeatures()) {
				if (!sf.isChangeable() || sf.isDerived()) {
					continue;
				}
				if (skipStructuralFeature(sf)) {
					continue;
				}
				if (sf instanceof EAttribute) {
					syncNonContainment(sf, target, source);
					continue;
				}
				final EReference ref = (EReference) sf;
				if (ref.isContainer()) {
					continue;
				}
				if (!ref.isContainment()) {
					syncNonContainment(ref, target, source);
					continue;
				}
				if (ref.isMany()) {
					syncContainmentList(ref, target, (EList<T>) source.eGet(ref));
				} else {
					syncContainmentValue(ref, target, source);
				}
			}
		}

		/**
		 * Returns whether a specific structural feature should be skipped in the sync process.
		 * 
		 * @param sf the structural feature to test
		 * 
		 * @return <code>true</code> if the feature should be skipped
		 */
		protected boolean skipStructuralFeature(EStructuralFeature sf) {
			return false;
		}

		/**
		 * Commits the commands in the compound command if not empty.
		 */
		public void commit() {
			if (myCompoundCommand == null) return;

			myCompoundCommand.execute();
		}

		/**
		 * Synchronizes the specified non-containment structural feature from the
		 * <code>source</code> object into the <code>target</code> object.
		 * 
		 * @param <T> the type of the involved objects
		 * @param sf the structural feature to synchronize
		 * @param target the object synchronized into
		 * @param source the object synchronized from
		 */
		private <T extends EObject> void syncNonContainment(EStructuralFeature sf, T target, T source) {
			final Object targetValue = target.eGet(sf);
			final Object sourceValue = source.eGet(sf);

			if (UIBindingsUtils.equals(targetValue, sourceValue)) return;
			if (!sf.isMany()) {
				/*
				 * Simple attribute
				 */
				addCommand(SetCommand.create(getEditingDomain(), target, sf, sourceValue));
				return;
			}

			/*
			 * To-many attribute
			 */
			final EList<Object> targetList = new BasicEList<Object>((List<?>) targetValue);
			final EList<?> sourceList = (EList<?>) sourceValue;
			for (int index = 0; index < sourceList.size(); index++) {
				final Object sourceObject = sourceList.get(index);
				/*
				 * Is targetList long enougth
				 */
				if (index >= targetList.size()) {
					addCommand(AddCommand.create(getEditingDomain(), target, sf, sourceObject));
					targetList.add(sourceObject);
					continue;
				}

				boolean done;
				do {
					done = true;
					/*
					 * Does the right element already exist
					 */
					final Object targetObject = targetList.get(index);
					if (UIBindingsUtils.equals(targetObject, sourceObject)) {
						continue;
					}

					final int oldTargetIndex = ECollections.indexOf(targetList, sourceObject, index);
					int targetIndex = ECollections.indexOf(sourceList, targetObject, index);
					if (oldTargetIndex == -1) {
						/*
						 * The object does not exist in the target list already, so we have to add
						 * it or replace the exiting object if it is not needed
						 */
						if (targetIndex == -1) {
							addCommand(SetCommand.create(getEditingDomain(), target, sf, sourceObject, index));
							targetList.set(index, sourceObject);
						} else {
							addCommand(AddCommand.create(getEditingDomain(), target, sf, sourceObject, index));
							targetList.add(index, sourceObject);
						}
						continue;
					}

					if (targetIndex == -1) {
						addCommand(RemoveCommand.create(getEditingDomain(), target, sf, targetObject));
						targetList.remove(index);
						done = false;
						continue;
					}
					if (targetIndex > oldTargetIndex) {
						if (targetList.size() <= targetIndex) {
							targetIndex = targetList.size() - 1;
						}
						addCommand(MoveCommand.create(getEditingDomain(), target, sf, sourceObject, targetIndex));
						targetList.move(targetIndex, index);
						done = false;
						continue;
					}
					addCommand(MoveCommand.create(getEditingDomain(), target, sf, sourceObject, index));
					targetList.move(targetIndex, index);
				} while (!done);
			}
			/*
			 * Remove any excess elements
			 */
			for (int i = targetList.size() - 1; i >= sourceList.size(); i--) {
				final Object obj = targetList.get(i);
				addCommand(RemoveCommand.create(getEditingDomain(), target, sf, obj));
			}
		}

		/**
		 * Synchronizes the specified containment list from the <code>source</code> object into the
		 * <code>target</code> object.
		 * 
		 * @param <T> the type of the involved objects
		 * @param ref the structural feature to synchronize
		 * @param target the object synchronized into
		 * @param sourceList the list synchronized from
		 */
		private <T extends EObject> void syncContainmentList(EReference ref, T target, List<T> sourceList) {
			if (!target.eIsSet(ref) && (sourceList == null || sourceList.isEmpty())) return;
			final EList<EObject> targetList = new BasicEList<EObject>((EList<EObject>) target.eGet(ref));

			int sourceListSize = 0;
			if (sourceList != null) {
				sourceListSize = sourceList.size();
			}

			final EAttribute key = findKeyAttribute(ref);

			for (int sourceIndex = 0; sourceIndex < sourceListSize; sourceIndex++) {
				final EObject sourceObject = sourceList.get(sourceIndex);
				/*
				 * Is targetList long enougth
				 */
				if (sourceIndex >= targetList.size()) {
					addCommand(AddCommand.create(getEditingDomain(), target, ref, sourceObject));
					targetList.add(sourceObject);
					continue;
				}

				boolean done;
				do {
					done = true;
					/*
					 * Does the right element already exist
					 */
					final EObject targetObject = targetList.get(sourceIndex);
					if (targetObject == sourceObject) {
						continue;
					}

					/*
					 * An object with the correct key already exist in the correct place. Sync these
					 * then.
					 */
					if (key != null && UIBindingsUtils.equals(targetObject, sourceObject, key)) {
						sync(targetObject, sourceObject);
						continue;
					}

					/*
					 * See if the source already exists somewhere in the target list.
					 * 
					 * Also see if the target object at the wanted index is found anywhere in the
					 * source list.
					 */
					final int existingTargetIndex = indexOf(targetList, key, sourceObject, sourceIndex);
					int targetIndex = indexOf((List<EObject>) sourceList, key, targetObject, sourceIndex);
					if (existingTargetIndex == -1) {
						/*
						 * The object does not exist in the target list already, so we have to
						 * either add it or replace the exiting target object if it is not needed
						 */
						if (targetIndex == -1) {
							addCommand(SetCommand.create(getEditingDomain(), target, ref, sourceObject, sourceIndex));
							addRemovedObject(targetObject);
							targetList.set(sourceIndex, sourceObject);
						} else {
							addCommand(AddCommand.create(getEditingDomain(), target, ref, sourceObject, sourceIndex));
							targetList.add(sourceIndex, sourceObject);
						}
						continue;
					}

					/*
					 * There are no use for the current target element - just remove it
					 */
					if (targetIndex == -1) {
						addCommand(RemoveCommand.create(getEditingDomain(), target, ref, targetObject));
						addRemovedObject(sourceObject);
						targetList.remove(sourceIndex);
						done = false;
						continue;
					}
					/*
					 * There are a later use for the target element...
					 */
					if (targetIndex > existingTargetIndex) {
						if (targetList.size() <= targetIndex) {
							targetIndex = targetList.size() - 1;
						}
						addCommand(MoveCommand.create(getEditingDomain(), target, ref, sourceObject, targetIndex));
						targetList.move(targetIndex, sourceIndex);
						done = false;
						continue;
					}
					addCommand(MoveCommand.create(getEditingDomain(), target, ref, sourceObject, sourceIndex));
					targetList.move(targetIndex, sourceIndex);
					sync(targetList.get(sourceIndex), sourceObject);
				} while (!done);
			}

			/*
			 * Remove any excess elements in the target list
			 */
			for (int i = targetList.size() - 1; i >= sourceListSize; i--) {
				final EObject obj = targetList.get(i);
				addCommand(RemoveCommand.create(getEditingDomain(), target, ref, obj));
				addRemovedObject(obj);
			}
		}

		// TODO
		private <T extends EObject> void syncContainmentValue(EReference ref, T target, T source) {
			final EAttribute key = findKeyAttribute(ref);
			final EObject targetValue = (EObject) target.eGet(ref);
			final EObject sourceValue = (EObject) source.eGet(ref);

			if (targetValue == sourceValue) return;

			/*
			 * Simple reference.
			 * 
			 * If either the source or the target is null then we just assign the new value,
			 * otherwise we synchronize
			 */
			if (targetValue == null || sourceValue == null) {
				addCommand(SetCommand.create(getEditingDomain(), target, ref, sourceValue));
				return;
			}
			if (key != null && UIBindingsUtils.equals(targetValue, sourceValue, key)) {
				sync(targetValue, sourceValue);
				return;
			}
			addCommand(SetCommand.create(getEditingDomain(), target, ref, sourceValue));
		}

		private EAttribute findKeyAttribute(EReference ref) {
			final EList<EAttribute> keys = ref.getEKeys();
			if (keys.size() > 0) return keys.get(0);
			return ref.getEReferenceType().getEIDAttribute();
		}

		private int indexOf(List<EObject> list, EAttribute key, EObject lookup, int index) {
			for (int i = index; i < list.size(); i++) {
				if (UIBindingsUtils.equals(lookup, list.get(i), key)) return i;
			}
			return -1;
		}

		/**
		 * Adds the specified command to the contained compound command of this controller.
		 * 
		 * @param c the new command to add
		 */
		private void addCommand(Command c) {
			if (myCompoundCommand == null) {
				myCompoundCommand = new CompoundCommand();
			}

			// LogUtils.debug(this, EcoreExtUtils.toString(c));
			myCompoundCommand.append(c);
		}

		private void addRemovedObject(EObject obj) {
			if (myRemovedObjects == null) {
				myRemovedObjects = new ArrayList<EObject>();
			}
			myRemovedObjects.add(obj);
		}

		/**
		 * Returns a list with the {@link EObject objects} that will be removed from the target
		 * object if this controller is committed.
		 * 
		 * @return the list of objects - can be <code>null</code>
		 */
		public List<EObject> getRemovedObjects() {
			return myRemovedObjects;
		}

		/**
		 * Synchronizes the information from the <code>source</code> object into the
		 * <code>target</code> object.
		 * <p>
		 * The class of <code>target</code> and <code>source</code> must be the same, e.g.
		 * <code>source.getClass() == target.getClass()</code>.
		 * 
		 * @param <T> the type of the involved objects
		 * @param target the object synchronized into
		 * @param source the object synchronized from
		 */
		public <T extends EObject> void sync(EList<T> target, EList<T> source) {
			if (target == source) return;
			Assert.isTrue(target instanceof EObjectContainmentEList);
			final EObjectContainmentEList<T> tEList = (EObjectContainmentEList<T>) target;
			syncContainmentList((EReference) tEList.getEStructuralFeature(), (T) tEList.getEObject(), source);
		}

		/**
		 * Sets the editing domain for this controller.
		 * 
		 * @param editingDomain the editing domain to use for this controller
		 */
		public void setEditingDomain(EditingDomain editingDomain) {
			myEditingDomain = editingDomain;
		}

		/**
		 * Returns the editing domain for this controller.
		 * 
		 * @return the editing domain
		 */
		public EditingDomain getEditingDomain() {
			return myEditingDomain;
		}
	}

	/**
	 * Returns a string that describes the specified command is clear human readable text.
	 * 
	 * @param c the command
	 * @return the clear text description
	 */
	public static String toString(Command c) {
		if (c == null) return "<null>";

		final StringBuilder sb = new StringBuilder(50);

		sb.append(c.getClass().getSimpleName()).append('(');
		if (c instanceof AddCommand) {
			final AddCommand cc = (AddCommand) c;

			sb.append(getEObjectName(cc.getOwner())).append(", ").append(cc.getFeature().getName()).append(", ")
					.append(toString(cc.getCollection()));
		} else if (c instanceof RemoveCommand) {
			final RemoveCommand cc = (RemoveCommand) c;

			sb.append(getEObjectName(cc.getOwner())).append(", ").append(cc.getFeature().getName()).append(", ")
					.append(toString(cc.getCollection()));
		} else if (c instanceof SetCommand) {
			final SetCommand cc = (SetCommand) c;

			sb.append(getEObjectName(cc.getOwner())).append(", ").append(cc.getFeature().getName()).append(", ")
					.append(formatSetCommandArg(cc.getOldValue())).append(", ")
					.append(formatSetCommandArg(cc.getValue()));
		} else {
			sb.append("...");
		}
		sb.append(')');
		return sb.toString();
	}

	private static String toString(Collection<?> collection) {
		final StringBuilder sb = new StringBuilder(200);
		sb.append('[');
		for (final Object o : collection) {
			if (sb.length() > 1) {
				sb.append(", ");
			}
			if (o instanceof EObject) {
				sb.append(IBindingObjectInformation.Factory.getLongName((EObject) o));
			} else {
				sb.append(o);
			}
		}
		sb.append(']');
		return sb.toString();
	}

	private static String formatSetCommandArg(Object oldValue) {
		return (oldValue == SetCommand.UNSET_VALUE) ? "<default> " : ("" + oldValue);
	}

	public static String getEObjectName(EObject owner) {
		return IBindingObjectInformation.Factory.getLongName(owner);
	}
}
