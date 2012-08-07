package com.rcpcompany.uibindings.bindings.xtext.xtext;

/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.ui.texteditor.IUpdate;

class TextViewerAction extends Action implements IUpdate {

	private int fOperationCode = -1;
	private final ITextOperationTarget fOperationTarget;

	/**
	 * Creates a new action.
	 * 
	 * @param viewer the viewer
	 * @param operationCode the opcode
	 */
	public TextViewerAction(ITextViewer viewer, int operationCode) {
		fOperationCode = operationCode;
		fOperationTarget = viewer.getTextOperationTarget();
		update();
	}

	@Override
	public void update() {
		final boolean wasEnabled = isEnabled();
		final boolean isEnabled = (fOperationTarget != null && fOperationTarget.canDoOperation(fOperationCode));
		setEnabled(isEnabled);

		if (wasEnabled != isEnabled) {
			firePropertyChange(ENABLED, wasEnabled ? Boolean.TRUE : Boolean.FALSE, isEnabled ? Boolean.TRUE
					: Boolean.FALSE);
		}
	}

	@Override
	public void run() {
		if (fOperationCode != -1 && fOperationTarget != null) {
			fOperationTarget.doOperation(fOperationCode);
		}
	}
}
