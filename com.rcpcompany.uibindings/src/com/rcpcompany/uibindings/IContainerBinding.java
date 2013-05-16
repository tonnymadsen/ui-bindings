/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings;

import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.widgets.Table;

import com.rcpcompany.uibindings.bindingMessages.ValidationLabelDecorator;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Container Binding</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IContainerBinding#getSingleSelection <em>Single Selection
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getContainerBinding()
 * @generated
 */
public interface IContainerBinding extends IBinding {

	/**
	 * Returns the value of the '<em><b>Single Selection</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Single Selection</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Single Selection</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getContainerBinding_SingleSelection()
	 * @generated
	 */
	IObservableValue getSingleSelection();

	/**
	 * Returns the drop context for the specified event
	 * 
	 * @param event the event to test
	 * @return the context or <code>null</code> if no context can be created
	 */
	IContainerDropContext getDropContext(DropTargetEvent event);

	/**
	 * Context that describes one drop event as seen from the container.
	 */
	public interface IContainerDropContext {
		/**
		 * Returns the relative location of the specified drop event in the current item of this
		 * container.
		 * <p>
		 * The orientation of the location (up-down or left-right) depends on the container and the
		 * event.
		 * 
		 * @return <code>0.0</code> at the beginning (top/left) and <code>1.0</code> at the end
		 *         (bottom/right)
		 */
		float getDropLocation();

		/**
		 * Returns the current drop cell of this drop event, if it can be determined from the event.
		 * 
		 * @return the cell or <code>null</code>
		 */
		IValueBindingCell getDropCell();

		/**
		 * Returns the target object of this drop event, if it can be determined from the event.
		 * 
		 * @return the target object or <code>null</code>S
		 */
		EObject getDropTargetObject();

		/**
		 * Constructs and returns a new {@link Command} to handle the Drop operation for this
		 * container
		 * 
		 * @return the command
		 */
		// Command createDragAndDropCommand(DragAndDropCommandContext context);

		/**
		 * Returns a list of the possible objects that can be created as sub-elements of the
		 * specified parent.
		 * <p>
		 * If the parent is <code>null</code> top-level objects are created.
		 * <p>
		 * If a sibling is non-<code>null</code>, the children should be as close to immediately
		 * following that sibling as possible.
		 * <p>
		 * For {@link Table tables} the element is ignored.
		 * 
		 * @param parent the view element that should be the parent of the child
		 * @param sibling if non-<code>null</code> the wanted sibling
		 * @return a list of possible children or <code>null</code> if no children a found
		 */
		List<IChildCreationSpecification> getPossibleChildObjects(EObject parent, EObject sibling);
	}

	/**
	 * Returns the cell in the container with the specified row and column (<code>(0, 0)</code>
	 * based).
	 * 
	 * @param column column number
	 * @param row row number
	 * @param visualModel <code>true</code> if the visual model should be used, <code>false</code>
	 *            if the logical model should be used
	 * 
	 * @return the cell or <code>null</code>
	 */
	IValueBindingCell getCell(int column, int row, boolean visualModel);

	/**
	 * Returns an {@link ValidationLabelDecorator} (possibly <code>null</code>) for use in the
	 * container. The decorator decorates according to the current {@link IValidatorAdapterManager}
	 * validation state and the current element hierarchy of the container.
	 * 
	 * @return the label decorator
	 * @deprecated will be removed
	 */
	@Deprecated
	ValidationLabelDecorator getValidationLabelDecorator();
} // IContainerBinding
