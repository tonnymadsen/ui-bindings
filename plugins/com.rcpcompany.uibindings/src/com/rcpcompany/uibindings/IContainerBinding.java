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

import com.rcpcompany.uibindings.bindingMessages.ValidationLabelDecorator;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Container Binding</b></em>'.
 * <!-- end-user-doc -->
 * 
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getContainerBinding()
 * @generated
 */
public interface IContainerBinding extends IBinding {

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
	 */
	ValidationLabelDecorator getValidationLabelDecorator();
} // IContainerBinding
