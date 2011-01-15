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
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DragAndDropCommand;
import org.eclipse.emf.edit.command.DragAndDropFeedback;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IViewerBinding;

/**
 * This is an adaption of {@link org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerBindingDropAdapter extends DropTargetAdapter {
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
	protected Collection<EObject> mySource;

	/**
	 * This is the command created during dragging which provides the feedback and will carry out
	 * the action upon completion.
	 */
	protected Command myCommand;

	/**
	 * This records the object for which the {@link #myCommand} was created.
	 */
	protected Object myCommandTarget;

	/**
	 * This keeps track of the original operation that the user requested, before we started
	 * changing the event.detail. We always try to create the command using this.
	 */
	protected int myDragEnterOperation;

	/**
	 * This keeps track of the information used to create {@link #myCommand}, but does not need to
	 * be disposed. This allows us to dispose of the command in dragLeave, and then, if we need to
	 * execute it, recreate it in drop.
	 */
	protected DragAndDropCommandInformation myDragAndDropCommandInformation;

	private final IViewerBinding myBinding;

	/**
	 * This creates an instance with the given domain and viewer.
	 */
	public ViewerBindingDropAdapter(IViewerBinding binding) {
		myBinding = binding;
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
		if (myCommand != null) {
			myCommand.dispose();
			myCommand = null;
		}
		myCommandTarget = null;

		mySource = null;
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
		if (myDragAndDropCommandInformation != null) {
			// Recreate the command.
			//
			myCommand = myDragAndDropCommandInformation.createCommand();
		} else {
			// Otherwise, the source should be available now as event.data, and we
			// can create the command.
			//
			mySource = extractDragSource(event.data);
			final Object target = extractDropTarget(event.item);
			myCommand = DragAndDropCommand.create(myBinding.getEditingDomain(), target, getLocation(event),
					event.operations, myDragEnterOperation, mySource);
		}

		// If the command can execute...
		//
		if (myCommand.canExecute()) {
			// Execute it.
			//
			myBinding.getEditingDomain().getCommandStack().execute(myCommand);
		} else {
			// Otherwise, let's call the whole thing off.
			//
			event.detail = DND.DROP_NONE;
			myCommand.dispose();
		}

		// Clean up the state.
		//
		myCommand = null;
		myCommandTarget = null;
		mySource = null;
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
		if (mySource == null) {
			mySource = getDragSource(event);
			if (mySource == null) {
				// Clear out any old information from a previous drag.
				//
				myDragAndDropCommandInformation = null;
				return;
			}
		}

		// Get the target object from the item widget and the mouse location in it.
		//
		final EObject target = extractDropTarget(event.item);
		final float location = getLocation(event);

		// Determine if we can create a valid command at the current location.
		//
		boolean valid = false;

		// If we don't have a previous cached command...
		//
		if (myCommand == null) {
			// We'll need to keep track of the information we use to create the
			// command, so that we can recreate it in drop.
			myDragAndDropCommandInformation = new DragAndDropCommandInformation(target, location, event.operations,
					myDragEnterOperation, mySource);

			// Remember the target; create the command and test if it is executable.
			//
			myCommandTarget = target;
			myCommand = myDragAndDropCommandInformation.createCommand();
			valid = myCommand.canExecute();
		} else {
			// Check if the cached command can provide DND feedback/revalidation.
			//
			if (target == myCommandTarget && myCommand instanceof DragAndDropFeedback) {
				// If so, revalidate the command.
				//
				valid = ((DragAndDropFeedback) myCommand).validate(target, location, event.operations,
						myDragEnterOperation, mySource);

				// Keep track of any changes to the command information.
				myDragAndDropCommandInformation = new DragAndDropCommandInformation(target, location, event.operations,
						myDragEnterOperation, mySource);
			} else {
				// If not, dispose the current command and create a new one.
				//
				myDragAndDropCommandInformation = new DragAndDropCommandInformation(target, location, event.operations,
						myDragEnterOperation, mySource);
				myCommandTarget = target;
				myCommand.dispose();
				myCommand = myDragAndDropCommandInformation.createCommand();
				valid = myCommand.canExecute();
			}
		}

		// If this command can provide detailed drag and drop feedback...
		//
		if (myCommand instanceof DragAndDropFeedback) {
			// Use it for the operation and drag under effect.
			//
			final DragAndDropFeedback dragAndDropFeedback = (DragAndDropFeedback) myCommand;
			event.detail = dragAndDropFeedback.getOperation();
			event.feedback = dragAndDropFeedback.getFeedback() | getAutoFeedback();
		} else if (!valid) {
			// There is no executable command, so we'd better nix the whole deal.
			//
			event.detail = DND.DROP_NONE;
		}
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

			// TODO ????
			return null;
		} else {
			// Motif kludge: we would get something random instead of null.
			//
			if (IS_MOTIF) return null;

			// Transfer the data and, if non-null, extract it.
			//
			final Object object = localTransfer.nativeToJava(event.currentDataType);
			return object == null ? null : extractDragSource(object);
		}
	}

	/**
	 * Extracts a collection of dragged source objects from the given object retrieved from the
	 * transfer agent.
	 * 
	 * @param object the object from the transfer type
	 * @return the collection of relevant objects
	 */
	protected Collection<EObject> extractDragSource(Object object) {
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
	 * This extracts an object from the given item widget, providing the special support required by
	 * an {@link org.eclipse.emf.common.ui.viewer.ExtendedTableTreeViewer.ExtendedTableTreeItem}.
	 */
	protected EObject extractDropTarget(Widget item) {
		if (item == null) return null;
		if (item.getData() instanceof EObject) return (EObject) item.getData();
		return null;
	}

	/**
	 * This returns the location of the mouse in the vertical direction, relative to the item
	 * widget, from 0 (top) to 1 (bottom).
	 */
	protected float getLocation(DropTargetEvent event) {
		if (event.item instanceof TreeItem) {
			final TreeItem treeItem = (TreeItem) event.item;
			final Control control = treeItem.getParent();
			final Point point = control.toControl(new Point(event.x, event.y));
			final Rectangle bounds = treeItem.getBounds();
			return (float) (point.y - bounds.y) / (float) bounds.height;
		} else if (event.item instanceof TableItem) {
			final TableItem tableItem = (TableItem) event.item;
			final Control control = tableItem.getParent();
			final Point point = control.toControl(new Point(event.x, event.y));
			final Rectangle bounds = tableItem.getBounds(0);
			return (float) (point.y - bounds.y) / (float) bounds.height;
		} else
			return 0.0F;
	}

	/**
	 * This holds all of the information used to create a {@link DragAndDropCommand}, but does not
	 * need to be disposed.
	 */
	protected class DragAndDropCommandInformation {
		protected EObject target;
		protected float location;
		protected int operations;
		protected int operation;
		protected Collection<EObject> source;

		public DragAndDropCommandInformation(EObject target, float location, int operations, int operation,
				Collection<EObject> source) {
			this.target = target;
			this.location = location;
			this.operations = operations;
			this.operation = operation;
			this.source = new ArrayList<EObject>(source);
		}

		public Command createCommand() {
			return new ViewerDragAndDropCommand(myBinding, target, location, operations, operation, source);
		}
	}
}
