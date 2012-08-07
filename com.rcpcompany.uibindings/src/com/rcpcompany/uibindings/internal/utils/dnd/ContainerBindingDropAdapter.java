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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DragAndDropCommand;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;

import com.rcpcompany.uibindings.IContainerBinding;
import com.rcpcompany.uibindings.IContainerBinding.IContainerDropContext;

/**
 * Drop adapter for use with {@link IContainerBinding}.
 * <p>
 * This is an adaption of {@link org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ContainerBindingDropAdapter extends DropTargetAdapter {
	/**
	 * This indicates whether the current platform is motif, which needs special treatment, since it
	 * cannot do early data transfer, but doesn't cleanly return null either.
	 */
	protected final static boolean IS_MOTIF = "motif".equals(SWT.getPlatform());

	/**
	 * This is the viewer for which this is a drop target listener.
	 */

	/**
	 * This is the collection of source objects being dragged.
	 */
	protected Collection<EObject> mySourceObjects;

	/**
	 * This is the command created during dragging which provides the feedback and will carry out
	 * the action upon completion.
	 */
	protected ContainerDragAndDropCommand myDragAndDropCommand;

	/**
	 * This records the object for which the {@link #myDragAndDropCommand} was created.
	 */
	protected Object myCommandTarget;

	/**
	 * This keeps track of the original operation that the user requested, before we started
	 * changing the event.detail. We always try to create the command using this.
	 */
	protected int myDragEnterOperation;

	/**
	 * This keeps track of the information used to create {@link #myDragAndDropCommand}, but does
	 * not need to be disposed. This allows us to dispose of the command in dragLeave, and then, if
	 * we need to execute it, recreate it in drop.
	 * 
	 * TODO Factor this out!
	 */
	protected DragAndDropCommandInformation myDragAndDropCommandInformation;

	/**
	 * The container of the adapter
	 */
	protected final IContainerBinding myContainer;

	/**
	 * This creates an instance with the given container.
	 * 
	 * @param binding the container
	 */
	public ContainerBindingDropAdapter(IContainerBinding binding) {
		myContainer = binding;
	}

	/**
	 * This is called when the mouse first enters or starts dragging in the viewer.
	 */
	@Override
	public void dragEnter(DropTargetEvent event) {
		// Remember the requested operation.
		myDragEnterOperation = event.detail;

		helper(event);
	}

	@Override
	public void dragLeave(DropTargetEvent event) {
		if (myDragAndDropCommand != null) {
			myDragAndDropCommand.dispose();
			myDragAndDropCommand = null;
		}
		myCommandTarget = null;

		mySourceObjects = null;
	}

	@Override
	public void dragOperationChanged(DropTargetEvent event) {
		// Remember the requested operation.
		myDragEnterOperation = event.detail;

		helper(event);
	}

	@Override
	public void dragOver(DropTargetEvent event) {
		helper(event);
	}

	@Override
	public void dropAccept(DropTargetEvent event) {
		helper(event);
	}

	@Override
	public void drop(DropTargetEvent event) {
		// A command was created if the source was available early, and the
		// information used to create it was cached...
		//
		if (myDragAndDropCommandInformation == null) {
			// Otherwise, the source should be available now as event.data, and we
			// can create the command.
			//
			mySourceObjects = extractDragSourceObjects(event.data);
			final IContainerDropContext dropContext = myContainer.getDropContext(event);
			if (dropContext == null) // event.detail = DND.DROP_NONE;
				return;

			myDragAndDropCommandInformation = new DragAndDropCommandInformation(dropContext, event.operations,
					myDragEnterOperation);
		}

		// Recreate the command.
		//
		myDragAndDropCommand = myDragAndDropCommandInformation.createCommand();

		// If the command can execute...
		//
		if (myDragAndDropCommand != null && myDragAndDropCommand.canExecute()) {
			// Execute it.
			//
			myContainer.getEditingDomain().getCommandStack().execute(myDragAndDropCommand);
		} else {
			// Otherwise, let's call the whole thing off.
			//
			event.detail = DND.DROP_NONE;
			myDragAndDropCommand.dispose();
		}

		// Clean up the state.
		//
		myDragAndDropCommand = null;
		myCommandTarget = null;
		mySourceObjects = null;
		myDragAndDropCommandInformation = null;
	}

	/**
	 * This method is called the same way for each of the
	 * {@link org.eclipse.swt.dnd.DropTargetListener} methods, except for leave and drop. If the
	 * source is available early, it creates or revalidates the {@link DragAndDropCommand}, and
	 * updates the event's detail (operation) and feedback (drag under effect), appropriately.
	 */
	protected void helper(DropTargetEvent event) {
		// If we can't do anything else, we'll provide the default select feedback
		// and enable auto-scroll and auto-expand effects.
		event.feedback = DND.FEEDBACK_SELECT | getAutoFeedback();

		// If we don't already have it, try to get the source early. We can't give
		// feedback if it's not available yet (this is platform-dependent).
		//
		if (mySourceObjects == null) {
			mySourceObjects = getDragSource(event);
			if (mySourceObjects == null) {
				// Clear out any old information from a previous drag.
				//
				myDragAndDropCommandInformation = null;
				return;
			}
		}

		// Get the target object from the item widget and the mouse location in it.
		//
		final IContainerDropContext dropContext = myContainer.getDropContext(event);
		if (dropContext == null) {
			event.detail = DND.DROP_NONE;
			return;
		}

		final EObject target = dropContext.getDropTargetObject();

		//
		//
		if (myDragAndDropCommand == null) {
			/*
			 * If we don't have a previous cached command...
			 */
			// We'll need to keep track of the information we use to create the
			// command, so that we can recreate it in drop.
			myDragAndDropCommandInformation = new DragAndDropCommandInformation(dropContext, event.operations,
					myDragEnterOperation);

			// Remember the target; create the command and test if it is executable.
			//
			myCommandTarget = target;
			myDragAndDropCommand = myDragAndDropCommandInformation.createCommand();
		} else if (target == myCommandTarget) {
			/*
			 * The target has not changed...
			 * 
			 * re-validate the command.
			 */
			myDragAndDropCommand.revalidate(dropContext, event.operations, myDragEnterOperation);

			// Keep track of any changes to the command information.
			myDragAndDropCommandInformation = new DragAndDropCommandInformation(dropContext, event.operations,
					myDragEnterOperation);
		} else {
			// If not, dispose the current command and create a new one.
			//
			myDragAndDropCommand.dispose();
			myDragAndDropCommandInformation = new DragAndDropCommandInformation(dropContext, event.operations,
					myDragEnterOperation);
			myCommandTarget = target;
			myDragAndDropCommand = myDragAndDropCommandInformation.createCommand();
		}

		if (!myDragAndDropCommand.canExecute()) {
			event.detail = DND.DROP_NONE;
			return;
		}
		event.detail = myDragAndDropCommand.getOperation();
		event.feedback = myDragAndDropCommand.getFeedback() | getAutoFeedback();
	}

	/**
	 * This returns the bitwise OR'ed flags for desired auto-feedback effects. Drag under effect DND
	 * constants are always OR'ed with this to enable them. This implementation enables
	 * {@link DND#FEEDBACK_SCROLL auto-scroll} and {@link DND#FEEDBACK_EXPAND auto-expand} (hover).
	 */
	protected int getAutoFeedback() {
		return DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;
	}

	/**
	 * This attempts to extract the drag source from the event early, i.e., before the drop method.
	 */
	protected Collection<EObject> getDragSource(DropTargetEvent event) {
		// Check whether the current data type can be transfered locally.
		//
		final BindingTransfer localTransfer = BindingTransfer.getInstance();
		if (!localTransfer.isSupportedType(event.currentDataType)) {
			// Iterate over the data types to see if there is a data type that supports a local
			// transfer.
			//
			final TransferData[] dataTypes = event.dataTypes;
			for (int i = 0; i < dataTypes.length; ++i) {
				final TransferData transferData = dataTypes[i];

				// If the local transfer supports this data type, switch to that data type
				//
				if (localTransfer.isSupportedType(transferData)) {
					event.currentDataType = transferData;
				}
			}

		}
		// Motif kludge: we would get something random instead of null.
		//
		if (IS_MOTIF) return null;

		// Transfer the data and, if non-null, extract it.
		//
		final Object object = localTransfer.nativeToJava(event.currentDataType);
		return object == null ? null : extractDragSourceObjects(object);
	}

	/**
	 * Extracts a collection of dragged source objects from the given object retrieved from the
	 * transfer agent.
	 * 
	 * @param object the object from the transfer type
	 * @return the collection of relevant objects
	 */
	protected Collection<EObject> extractDragSourceObjects(Object object) {
		Collection<?> list = null;
		if (object instanceof Collection) {
			list = (Collection<?>) object;
		}
		if (object instanceof IStructuredSelection) {
			list = ((IStructuredSelection) object).toList();
		}
		if (list == null) return Collections.EMPTY_LIST;

		/*
		 * Check the elements in the list
		 */

		return (Collection<EObject>) list;
	}

	/**
	 * This holds all of the information used to create a {@link DragAndDropCommand}, but does not
	 * need to be disposed.
	 */
	protected class DragAndDropCommandInformation {
		private final int operations;
		private final int operation;
		private final IContainerDropContext context;

		public DragAndDropCommandInformation(IContainerDropContext context, int operations, int operation) {
			this.context = context;
			this.operations = operations;
			this.operation = operation;
		}

		public ContainerDragAndDropCommand createCommand() {
			return new ContainerDragAndDropCommand(myContainer, context, operations, operation, mySourceObjects);
		}
	}
}
