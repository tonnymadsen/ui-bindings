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
package com.rcpcompany.uibindings.internal.utils.dnd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.command.DragAndDropFeedback;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.IChildCreationSpecification;
import com.rcpcompany.uibindings.IContainerBinding;
import com.rcpcompany.uibindings.IContainerBinding.IContainerDropContext;
import com.rcpcompany.uibindings.IManager;

/**
 * Implementation of a drag 'n drop command.
 * <p>
 * The real work is delegated to a drag and drop command.
 * <p>
 * Based on {@link org.eclipse.emf.edit.command.DragAndDropCommand}.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class ContainerDragAndDropCommand extends AbstractCommand implements DragAndDropFeedback {
	/**
	 * This caches the label.
	 */
	protected static final String LABEL = EMFEditPlugin.INSTANCE.getString("_UI_DragAndDropCommand_label");

	/**
	 * This caches the description.
	 */
	protected static final String DESCRIPTION = EMFEditPlugin.INSTANCE.getString("_UI_DragAndDropCommand_description");

	/**
	 * This keeps track of the domain in which this command is created.
	 */
	protected EditingDomain myDomain;

	/**
	 * This keeps track of the lower range of locations in which the effect of this command remains
	 * unchanged.
	 */
	protected float myLowerLocationBound;

	/**
	 * This keeps track of the upper range of locations in which the effect of this command remains
	 * unchanged.
	 */
	protected float myUpperLocationBound;

	/**
	 * This keeps track of the permitted operations.
	 */
	protected int myOperations;

	/**
	 * This keeps track of the current operation that will be returned by {@link #getOperation}.
	 */
	protected int myOperation;

	/**
	 * This keeps track of the feedback that will be returned by {@link #getFeedback}.
	 */
	protected int feedback;

	/**
	 * This keeps track of the collection of dragged sources.
	 */
	protected Collection<EObject> mySourceObjects;

	/**
	 * This keeps track of the command that implements the drag side of the operation.
	 */
	protected Command myDragCommand = IdentityCommand.INSTANCE;

	public Command getDragCommand() {
		return myDragCommand;
	}

	public Command getDropCommand() {
		return myDropCommand;
	}

	/**
	 * This keeps track of the command that implements the drop side of the operation.
	 */
	protected Command myDropCommand = UnexecutableCommand.INSTANCE;

	/**
	 * The container binding for the target.
	 */
	private final IContainerBinding myContainer;

	private boolean isDragCommandExecuted;

	private IContainerDropContext myContext;

	/**
	 * Creates an instance in the given domain and for the given information. The location should be
	 * in the range of 0.0 to 1.0, indicating the relative vertical location of the drag operation,
	 * where 0.0 is at the top and 1.0 is at the bottom. The operations is a bitwise mask of the
	 * DROP_* values. The operation is the desired operation as specified by a DROP_* value. And the
	 * collection contains the source objects being dragged.
	 * 
	 * @param binding
	 * @param target
	 * @param location
	 * @param operations
	 * @param operation
	 * @param source
	 */
	public ContainerDragAndDropCommand(IContainerBinding container, IContainerDropContext context, int operations,
			int operation, Collection<EObject> source) {
		super(LABEL, DESCRIPTION);

		myContainer = container;
		myContext = context;
		myDomain = myContainer.getEditingDomain();
		myOperations = operations;
		myOperation = operation;
		mySourceObjects = source;
	}

	/**
	 * This implementation of prepare is called again to implement {@link #validate validate}. The
	 * method {@link #reset} will have been called before doing so.
	 */
	@Override
	protected boolean prepare() {
		boolean result = false;

		/*
		 * If there isn't something obviously wrong with the arguments...
		 */
		if (myContext.getDropTargetObject() == null || mySourceObjects == null || myOperations == DROP_NONE
				|| myOperation == DROP_NONE) {
			myLowerLocationBound = 0.0F;
			myUpperLocationBound = 1.0F;
			return false;
		}

		/*
		 * If the location is near the boundary, we'll start by trying to do a drop insert.
		 */
		if (myContext.getDropLocation() <= 0.20 || myContext.getDropLocation() >= 0.80) {
			/*
			 * If we could do a drop insert operation...
			 */
			result = prepareDropInsert();
			if (result) {
				/*
				 * Set the bounds so that we re-check when we are closer to the middle.
				 */
				if (myContext.getDropLocation() <= 0.20) {
					myLowerLocationBound = 0.0F;
					myUpperLocationBound = 0.2F;
				} else {
					myLowerLocationBound = 0.8F;
					myUpperLocationBound = 1.0F;
				}
			} else {
				/*
				 * We can try to do a drop on instead.
				 */
				reset();
				result = prepareDropOn();

				/*
				 * Set the bounds so that we re-check when we get near the other end.
				 */
				if (myContext.getDropLocation() <= 0.20) {
					myLowerLocationBound = 0.0F;
					myUpperLocationBound = 0.8F;
				} else {
					myLowerLocationBound = 0.2F;
					myUpperLocationBound = 1.0F;
				}
			}
		}
		/*
		 * We are near the middle, so we'll start by trying to do a drop on.
		 */
		else {
			/*
			 * If we can do a drop on operation.
			 */
			result = prepareDropOn();
			if (result) {
				/*
				 * Set the range so that we re-check when we get aren't in the middle.
				 */
				myLowerLocationBound = 0.2F;
				myUpperLocationBound = 0.8F;
			} else {
				/*
				 * We can reset and try a drop insert instead.
				 */
				reset();
				result = prepareDropInsert();

				/*
				 * Set the range so that we re-check when we get into the other half.
				 */
				if (myContext.getDropLocation() <= 0.50) {
					myLowerLocationBound = 0.0F;
					myUpperLocationBound = 0.5F;
				} else {
					myLowerLocationBound = 0.5F;
					myUpperLocationBound = 1.0F;
				}
			}
		}

		// LogUtils.debug(this, "result=" + result + "\ndrag=" +
		// EcoreExtUtils.toString(myDragCommand) + "\ndrop="
		// + EcoreExtUtils.toString(myDropCommand));

		return result;
	}

	/**
	 * Finds the best possible {@link IChildCreationSpecification} for the parent and sibling given
	 * the current collection of dragged objects.
	 * <p>
	 * Exactly one of parent and sibling must be non-<code>null</code>.
	 * 
	 * @param parent the parent object or <code>null</code>
	 * @param sibling the sibling object or <code>null</code>
	 * @return the best specification or <code>null</code>
	 */
	private IChildCreationSpecification findBestChildCreationSpecification(EObject parent, EObject sibling) {
		final List<IChildCreationSpecification> possibleChildObjects = myContext.getPossibleChildObjects(parent,
				sibling);
		if (possibleChildObjects == null) return null;

		/*
		 * See, if we can find a direct match on the type (remember that the list already contains
		 * all known sub-types, so we need not use instanceof)...
		 */
		OUTER: for (final IChildCreationSpecification pcs : possibleChildObjects) {
			final EClass childType = pcs.getChildType();
			if (childType == null) {
				continue;
			}
			for (final EObject source : mySourceObjects) {
				if (source.eClass() != childType) {
					continue OUTER;
				}
			}

			return pcs;
		}

		/*
		 * No match.
		 * 
		 * Check if we can find a converter to a supported child type...
		 * 
		 * TODO
		 */

		return null;
	}

	/**
	 * This attempts to prepare a drop insert operation.
	 */
	protected boolean prepareDropInsert() {
		boolean result = false;

		/*
		 * The feedback is set based on which half we are in. If the command isn't executable, these
		 * values won't be used.
		 */
		feedback = myContext.getDropLocation() < 0.5 ? FEEDBACK_INSERT_BEFORE : FEEDBACK_INSERT_AFTER;

		final IChildCreationSpecification spec = findBestChildCreationSpecification(null,
				myContext.getDropTargetObject());
		if (spec == null) return false;

		/*
		 * If we can't determine the parent.
		 */
		int index = spec.getIndex();

		/*
		 * If the location indicates after, add one more to get the correct index.
		 */
		if (myContext.getDropLocation() >= 0.5 && index != -1) {
			++index;
		}

		/*
		 * Try to create a specific command based on the current desired operation.
		 */
		switch (myOperation) {
		case DROP_MOVE:
			result = prepareDropMoveInsert(spec, index);
			break;
		case DROP_COPY:
			result = prepareDropCopyInsert(spec, index);
			break;
		case DROP_LINK:
			result = prepareDropLinkInsert(spec, index);
			break;
		}

		/*
		 * If there isn't an executable command we should maybe try a copy operation, but only if
		 * we're allowed and not doing a link.
		 */
		if (!result && myOperation != DROP_COPY && myOperation != DROP_LINK && (myOperations & DROP_COPY) != 0) {
			reset();
			result = prepareDropCopyInsert(spec, index);

			if (result) {
				/*
				 * We've switch the operation!
				 */
				myOperation = DROP_COPY;
			}
		}

		/*
		 * If there isn't an executable command we should maybe try a link operation, but only if
		 * we're allowed and not doing a link.
		 */
		if (!result && myOperation != DROP_LINK && (myOperations & DROP_LINK) != 0) {
			reset();
			result = prepareDropLinkInsert(spec, index);
			if (result) {
				/*
				 * We've switch the operation!
				 */
				myOperation = DROP_LINK;
			}
		}

		return result;
	}

	/**
	 * This attempts to prepare a drop move insert operation.
	 */
	protected boolean prepareDropMoveInsert(IChildCreationSpecification spec, int index) {
		if (isCrossDomain()) return false;

		/*
		 * We don't want to move insert an object before or after itself...
		 */
		if (mySourceObjects.contains(myContext.getDropTargetObject())) return false;

		/*
		 * We need containment to move
		 */
		if (!spec.getReference().isContainment()) return false;

		/*
		 * If the dragged objects are already present in the list, then move them in the list rather
		 * than adding them to the new list...
		 */
		final Object o = spec.getParent().eGet(spec.getReference());
		if (o instanceof List<?>) {
			final List<?> children = (List<?>) o;
			if (children.containsAll(mySourceObjects)) {
				/*
				 * Create move commands for all the objects in the collection.
				 */
				final CompoundCommand compoundCommand = new CompoundCommand();
				final List<Object> before = new ArrayList<Object>();
				final List<Object> after = new ArrayList<Object>();

				int j = 0;
				for (final Object object : children) {
					if (mySourceObjects.contains(object)) {
						if (j < index) {
							before.add(object);
						} else if (j > index) {
							after.add(object);
						}
					}
					++j;
				}

				for (final Object object : before) {
					compoundCommand.append(MoveCommand.create(myDomain, spec.getParent(), spec.getReference(), object,
							index - 1));
				}

				for (final ListIterator<Object> objects = after.listIterator(after.size()); objects.hasPrevious();) {
					final Object object = objects.previous();
					compoundCommand.append(MoveCommand.create(myDomain, spec.getParent(), spec.getReference(), object,
							index));
				}

				switch (compoundCommand.getCommandList().size()) {
				case 0:
					myDropCommand = IdentityCommand.INSTANCE;
					break;
				case 1:
					myDropCommand = compoundCommand.unwrap();
					break;
				default:
					myDropCommand = compoundCommand;
					break;
				}

				return myDragCommand.canExecute() && myDropCommand.canExecute();
			}
		}

		/*
		 * Just remove the objects and add them.
		 */
		myDragCommand = RemoveCommand.create(myDomain, mySourceObjects);
		myDropCommand = AddCommand.create(myDomain, spec.getParent(), spec.getReference(), mySourceObjects, index);

		return myDragCommand.canExecute() && myDropCommand.canExecute();
	}

	protected boolean isCrossDomain() {
		for (final EObject item : mySourceObjects) {
			final EditingDomain itemDomain = AdapterFactoryEditingDomain.getEditingDomainFor(item);
			if (itemDomain != null && itemDomain != myDomain) return true;
		}
		return false;
	}

	/**
	 * This attempts to prepare a drop copy insert operation.
	 */
	protected boolean prepareDropCopyInsert(final IChildCreationSpecification spec, final int index) {
		/*
		 * We need containment to copy
		 */
		if (!spec.getReference().isContainment()) return false;

		if (isCopyOnSameParent(spec)) return false;

		/*
		 * We don't want to copy insert an object before or after itself...
		 */
		if (mySourceObjects.contains(spec.getParent())) return false;

		/*
		 * Copy the collection
		 */
		myDragCommand = CopyCommand.create(myDomain, mySourceObjects);
		if (myDragCommand.canExecute() && myDragCommand.canUndo()) {
			myDragCommand.execute();
			isDragCommandExecuted = true;
			myDropCommand = AddCommand.create(myDomain, spec.getParent(), spec.getReference(),
					myDragCommand.getResult(), index);
		}
		return myDragCommand.canExecute() && myDropCommand.canExecute();
	}

	/**
	 * This attempts to prepare a drop link insert operation.
	 */
	protected boolean prepareDropLinkInsert(IChildCreationSpecification spec, int index) {
		/*
		 * We need NON-containment to link
		 */
		final EReference ref = spec.getReference();
		if (ref.isContainment()) return false;

		/*
		 * Also, if this is a to-many reference with an opposite, then it cannot be a link
		 */
		if (ref.isMany() && ref.getEOpposite() != null) return false;

		/*
		 * We don't want to insert an object before or after itself...
		 */
		if (mySourceObjects.contains(spec.getParent())) return false;

		myDropCommand = AddCommand.create(myDomain, spec.getParent(), ref, mySourceObjects, index);
		return myDragCommand.canExecute() && myDropCommand.canExecute();
	}

	/**
	 * This attempts to prepare a drop on operation.
	 */
	protected boolean prepareDropOn() {
		boolean result = false;

		/*
		 * This is the feedback we use to indicate drop on; it will only be used if the command is
		 * executable.
		 */
		feedback = FEEDBACK_SELECT;

		final EObject targetObject = myContext.getDropTargetObject();
		final IChildCreationSpecification spec = findBestChildCreationSpecification(targetObject, null);
		if (spec == null) {
			// LogUtils.debug(this, "No specs, trying assignment");
			/*
			 * No matching specs...
			 * 
			 * See if we can find an assignment instead
			 */
			if (mySourceObjects.size() != 1) return false;
			final EObject obj = mySourceObjects.iterator().next();

			final Command assignCommand = IManager.Factory.getManager().assignObject(myDomain, myContainer,
					targetObject, obj);
			if (assignCommand == null) return false;
			myDropCommand = assignCommand;
			return true;
		}

		/*
		 * Prepare the right type of operation.
		 */
		switch (myOperation) {
		case DROP_MOVE:
			result = prepareDropMoveOn(spec);
			break;
		case DROP_COPY:
			result = prepareDropCopyOn(spec);
			break;
		case DROP_LINK:
			result = prepareDropLinkOn(spec);
			break;
		}

		/*
		 * If there isn't an executable command we should maybe try a copy operation, but only if
		 * we're allowed and not doing a link.
		 */
		if (!result && myOperation != DROP_COPY && myOperation != DROP_LINK && (myOperations & DROP_COPY) != 0) {
			reset();
			result = prepareDropCopyOn(spec);
			if (result) {
				myOperation = DROP_COPY;
			}
		}

		/*
		 * If there isn't an executable command we should maybe try a link operation, but only if
		 * we're allowed and not doing a link.
		 */
		if (!result && myOperation != DROP_LINK && (myOperations & DROP_LINK) != 0) {
			reset();
			result = prepareDropLinkOn(spec);
			if (result) {
				myOperation = DROP_LINK;
			}
		}

		return result;
	}

	/**
	 * This attempts to prepare a drop move on operation.
	 * 
	 * @param spec
	 */
	protected boolean prepareDropMoveOn(IChildCreationSpecification spec) {
		if (isCrossDomain()) return false;

		/*
		 * We need containment to move
		 */
		if (!spec.getReference().isContainment()) return false;

		myDragCommand = RemoveCommand.create(myDomain, mySourceObjects);
		myDropCommand = AddCommand.create(myDomain, spec.getParent(), spec.getReference(), mySourceObjects);

		return myDragCommand.canExecute() && myDropCommand.canExecute();
	}

	/**
	 * This attempts to prepare a drop copy on operation.
	 * 
	 * @param spec
	 */
	protected boolean prepareDropCopyOn(IChildCreationSpecification spec) {
		/*
		 * We need containment to copy
		 */
		if (!spec.getReference().isContainment()) return false;

		if (isCopyOnSameParent(spec)) return false;

		myDragCommand = CopyCommand.create(myDomain, mySourceObjects);
		if (myDragCommand.canExecute() && myDragCommand.canUndo()) {
			myDragCommand.execute();
			isDragCommandExecuted = true;
			myDropCommand = AddCommand.create(myDomain, spec.getParent(), spec.getReference(),
					myDragCommand.getResult());
		}
		return myDragCommand.canExecute() && myDropCommand.canExecute();
	}

	/**
	 * Only allow a COPY on the same parent, when explicitly requested.
	 * 
	 * @return <code>true</code> if the copy operation should not be allowed
	 */
	private boolean isCopyOnSameParent(IChildCreationSpecification spec) {
		if (myOperation != DROP_COPY) {
			for (final EObject so : mySourceObjects) {
				if (so.eContainer() == spec.getParent()) return true;
			}
		}

		return false;
	}

	/**
	 * This attempts to prepare a drop link on operation.
	 * 
	 * @param spec
	 */
	protected boolean prepareDropLinkOn(IChildCreationSpecification spec) {
		/*
		 * We need NON-containment to copy
		 */
		final EReference ref = spec.getReference();
		if (ref.isContainment()) return false;

		/*
		 * Also, if this is a to-many reference with an opposite, then it cannot be a link
		 */
		if (ref.isMany() && ref.getEOpposite() != null) return false;

		myDropCommand = AddCommand.create(myDomain, spec.getParent(), ref, mySourceObjects);

		return myDropCommand.canExecute();
	}

	/**
	 * This restores the command to its default initialized state, disposing an command that may
	 * have been contained.
	 */
	protected void reset() {
		if (isDragCommandExecuted) {
			myDragCommand.undo();
			isDragCommandExecuted = false;
		}
		myDragCommand.dispose();

		myDropCommand.dispose();

		isPrepared = false;
		isExecutable = false;

		myDragCommand = IdentityCommand.INSTANCE;
		myDropCommand = UnexecutableCommand.INSTANCE;
	}

	@Override
	public boolean validate(Object owner, float location, int operations, int operation, Collection<?> collection) {
		throw new RuntimeException("Method not supported");
	}

	public boolean revalidate(IContainerDropContext context, int operations, int operation) {
		/*
		 * If the operation has NOT changed significantly, then just return the cached result.
		 */
		if (context.getDropTargetObject() == myContext.getDropTargetObject()
				&& (context.getDropLocation() >= myLowerLocationBound && context.getDropLocation() <= myUpperLocationBound)
				&& operation == myOperation) return isExecutable;

		reset();
		myContext = context;
		myOperations = operations;
		myOperation = operation;

		return canExecute();
	}

	@Override
	public int getFeedback() {
		return isExecutable ? feedback : FEEDBACK_SELECT;
	}

	@Override
	public int getOperation() {
		return isExecutable ? myOperation : DROP_NONE;
	}

	@Override
	public void execute() {
		// LogUtils.debug(this,
		// "\ndrag=" + EcoreExtUtils.toString(myDragCommand) + "\ndrop=" +
		// EcoreExtUtils.toString(myDropCommand));

		if (myDropCommand.canExecute() && !isDragCommandExecuted) {
			myDragCommand.execute();
		}
		isDragCommandExecuted = true;

		if (myDropCommand.canExecute()) {
			myDropCommand.execute();
		}
	}

	@Override
	public void undo() {
		/*
		 * Reverse sequence...
		 */
		myDropCommand.undo();
		myDragCommand.undo();
	}

	@Override
	public void redo() {
		myDragCommand.redo();
		myDropCommand.redo();
	}

	@Override
	public void dispose() {
		reset();
	}

	@Override
	public Collection<?> getResult() {
		return myDropCommand.getResult();
	}

	@Override
	public Collection<?> getAffectedObjects() {
		return myDropCommand.getAffectedObjects();
	}

	@Override
	public String toString() {
		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (domain: " + myDomain + ")");
		result.append(" (owner: " + myContext.getDropTargetObject() + ")");
		result.append(" (location: " + myContext.getDropLocation() + ")");
		result.append(" (lowerLocationBound: " + myLowerLocationBound + ")");
		result.append(" (upperLocationBound: " + myUpperLocationBound + ")");
		result.append(" (operations: " + myOperations + ")");
		result.append(" (operation: " + myOperation + ")");
		result.append(" (collection: " + mySourceObjects + ")");
		result.append(" (feedback: " + feedback + ")");

		return result.toString();
	}
}
