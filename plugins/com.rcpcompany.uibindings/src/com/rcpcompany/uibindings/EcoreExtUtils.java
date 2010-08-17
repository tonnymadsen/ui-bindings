package com.rcpcompany.uibindings;

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

/**
 * Various Ecore oriented utility methods.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public final class EcoreExtUtils {
	private EcoreExtUtils() {

	}

	private static final EditingDomain THE_EDITING_DOMAIN = UIBindingsUtils.createEditingDomain();

	/**
	 * Synchronizes the information from the <code>source</code> object into the <code>target</code>
	 * object.
	 * <p>
	 * The sync is potentially destructive for the <code>source</code> object.
	 * 
	 * @param target the object synchronized into
	 * @param source the object synchronized from
	 */
	public static <T extends EObject> void sync(T target, T source) {
		Assert.isTrue(source.getClass() == target.getClass(), "target and source must have exactly the same types");
		final SyncController controller = new SyncController();
		controller.setEditingDomain(THE_EDITING_DOMAIN);
		controller.sync(target, source);
		controller.commit();
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
	public static <T extends EObject> void sync(EList<T> target, EList<T> source) {
		final SyncController controller = new SyncController();
		controller.setEditingDomain(THE_EDITING_DOMAIN);
		controller.sync(target, source);
		controller.commit();
	}

	/**
	 * Synchronizes the information from the <code>source</code> object into the <code>target</code>
	 * object.
	 * <p>
	 * The behavior of the synchronization is controlled via the sync controller.
	 * <p>
	 * The changes are not made until the controller is committed.
	 * <p>
	 * The class of <code>target</code> and <code>source</code> must be the same, e.g.
	 * <code>source.getClass() == target.getClass()</code>.
	 * 
	 * @param <T> the type of the involved objects
	 * @param target the object synchronized into
	 * @param source the object synchronized from
	 * @param controller the controller for the operation
	 */
	public static <T extends EObject> void sync(T target, T source, SyncController controller) {
		Assert.isTrue(source.getClass() == target.getClass(), "target and source must have exactly the same types");
		controller.sync(source, target);
	}

	/**
	 * This class is used to control a synchronize operation in
	 * {@link EcoreExtUtils#sync(EObject, EObject, SyncController)}.
	 */
	public static class SyncController {
		private EditingDomain myEditingDomain;
		/**
		 * A compound command that collects all the created commands.
		 */
		private CompoundCommand myCompoundCommand;

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
						addCommand(RemoveCommand.create(getEditingDomain(), target, sf, sourceObject));
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
			for (int i = targetList.size(); i > sourceList.size();) {
				addCommand(RemoveCommand.create(getEditingDomain(), target, sf, targetList.get(--i)));
			}
		}

		/**
		 * Synchronizes the specified containment structural feature from the <code>source</code>
		 * object into the <code>target</code> object.
		 * 
		 * @param <T> the type of the involved objects
		 * @param ref the structural feature to synchronize
		 * @param target the object synchronized into
		 * @param sourceList the objects synchronized from
		 */
		private <T extends EObject> void syncContainmentList(EReference ref, T target, EList<T> sourceList) {
			final EList<EObject> targetList = new BasicEList<EObject>((EList<EObject>) target.eGet(ref));
			final EAttribute key = findKeyAttribute(ref);
			if (targetList == sourceList) return;
			if (targetList.isEmpty() && sourceList.isEmpty()) return;

			for (int index = 0; index < sourceList.size(); index++) {
				final EObject sourceObject = sourceList.get(index);
				/*
				 * Is targetList long enougth
				 */
				if (index >= targetList.size()) {
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
					final EObject targetObject = targetList.get(index);
					if (targetObject == sourceObject) {
						continue;
					}

					if (key != null && UIBindingsUtils.equals(targetObject, sourceObject, key)) {
						sync(targetObject, sourceObject);
						continue;
					}

					final int existingTargetIndex = indexOf(targetList, key, sourceObject, index);
					int targetIndex = indexOf((EList<EObject>) sourceList, key, targetObject, index);
					if (existingTargetIndex == -1) {
						/*
						 * The object does not exist in the target list already, so we have to add
						 * it or replace the exiting object if it is not needed
						 */
						if (targetIndex == -1) {
							addCommand(SetCommand.create(getEditingDomain(), target, ref, sourceObject, index));
							targetList.set(index, sourceObject);
						} else {
							addCommand(AddCommand.create(getEditingDomain(), target, ref, sourceObject, index));
							targetList.add(index, sourceObject);
						}
						continue;
					}

					/*
					 * There are no use for the current target element - just remove it
					 */
					if (targetIndex == -1) {
						addCommand(RemoveCommand.create(getEditingDomain(), target, ref, sourceObject));
						targetList.remove(index);
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
						targetList.move(targetIndex, index);
						done = false;
						continue;
					}
					addCommand(MoveCommand.create(getEditingDomain(), target, ref, sourceObject, index));
					targetList.move(targetIndex, index);
					sync(targetList.get(index), sourceObject);
				} while (!done);
			}
			/*
			 * Remove any excess elements
			 */
			for (int i = targetList.size(); i > sourceList.size();) {
				addCommand(RemoveCommand.create(getEditingDomain(), target, ref, targetList.get(--i)));
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

		private int indexOf(EList<EObject> list, EAttribute key, EObject lookup, int index) {
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

			myCompoundCommand.append(c);
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
			Assert.isTrue(target instanceof EObjectContainmentEList);
			final EObjectContainmentEList<T> t = (EObjectContainmentEList<T>) target;
			syncContainmentList((EReference) t.getEStructuralFeature(), (T) t.getEObject(), source);
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
}
