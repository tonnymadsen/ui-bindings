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
package com.rcpcompany.uibindings.moao.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.moao.IMOAOFacet;
import com.rcpcompany.uibindings.moao.IMOAOFactory;
import com.rcpcompany.uibindings.moao.IMOAOMessage;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.moao.Severity;
import com.rcpcompany.uibindings.moao.ui.internal.dialogs.CommentEditorDialog;

public class EditCommentHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Shell shell = HandlerUtil.getActiveShellChecked(event);
		/*
		 * Find the binding and the object in question
		 */
		final Object binding = HandlerUtil.getVariableChecked(event, Constants.SOURCES_ACTIVE_BINDING);
		if (!(binding instanceof IValueBinding)) return null;
		final IValueBinding vb = (IValueBinding) binding;
		if (!(vb.getModelObject() instanceof IMOAO)) return null;
		/*
		 * The IMOAO and the feature
		 */
		final IMOAO moao = (IMOAO) vb.getModelObject();
		final EStructuralFeature feature = vb.getModelFeature();

		String oldDescription = null;
		String oldDetails = null;
		/*
		 * Find the comments Status Object or create a new
		 */
		IMOAOMessage comment = null;
		if (moao.eIsSet(IMOAOPackage.Literals.MOAO__FACETS)) {
			for (final IMOAOFacet f : moao.getFacets()) {
				if (!(f instanceof IMOAOMessage)) {
					continue;
				}
				final IMOAOMessage s = (IMOAOMessage) f;
				if (s.getSeverity() == Severity.COMMENT && s.getFeature() == feature) {
					comment = s;
					break;
				}
			}
		}
		if (comment == null) {
			comment = IMOAOFactory.eINSTANCE.createMOAOMessage();
			comment.setOwner("TODO");
			comment.setSeverity(Severity.COMMENT);
			comment.setFeature(feature);
			comment.setDescription("Comment by " + System.getProperty("user.name"));
			comment.setDetails("");
			moao.getFacets().add(comment);
		} else {
			oldDescription = comment.getDescription();
			oldDetails = comment.getDetails();
		}

		/*
		 * Create and open the dialog
		 */
		final CommentEditorDialog dialog = new CommentEditorDialog(shell, comment);
		final int result = dialog.open();
		switch (result) {
		case Window.OK:
			break;
		case Window.CANCEL:
			if (oldDescription == null) {
				moao.getFacets().remove(comment);
			} else {
				comment.setDescription(oldDescription);
				comment.setDetails(oldDetails);
			}
			break;
		case CommentEditorDialog.DELETE:
			moao.getFacets().remove(comment);
			break;
		}

		vb.updateBinding();

		return null;
	}
}
