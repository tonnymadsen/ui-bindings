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
package com.rcpcompany.uibindings.internal.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingContext.FinishOption;
import com.rcpcompany.uibindings.IChildCreationSpecification;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.participants.ISuperCreateParticipant;
import com.rcpcompany.uibindings.participants.ISuperCreateParticipantContext;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;
import com.rcpcompany.uibindings.utils.ExtendedCommandStack;
import com.rcpcompany.uibindings.utils.IBindingHighlightContext;
import com.rcpcompany.uibindings.utils.IBindingHighlightContext.STAGE;
import com.rcpcompany.uibindings.utils.IClipboardConverterManager;
import com.rcpcompany.uibindings.utils.IClipboardConverterManager.IResult;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Handler for <code>com.rcpcompany.uibindings.commands.SuperCreate</code> for within
 * {@link IViewerBinding}...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerSuperCreateHandler extends AbstractHandler implements IHandler {
	@Override
	public Object execute(ExecutionEvent event) {
		if (Activator.getDefault().TRACE_HANDLERS) {
			LogUtils.debug(this, "");
		}
		final Object bb = HandlerUtil.getVariable(event, Constants.SOURCES_ACTIVE_CONTAINER_BINDING);
		if (!(bb instanceof IViewerBinding)) return null;
		final IViewerBinding container = (IViewerBinding) bb;
		final IBindingContext context = container.getContext();

		final IValueBinding binding = (IValueBinding) HandlerUtil.getVariable(event, Constants.SOURCES_ACTIVE_BINDING);
		if (binding == null) return null;

		final List<IResult> conversions = IClipboardConverterManager.Factory.getManager().getClipboardConversions();

		if (conversions.size() == 0) {
			MessageDialog.openError(HandlerUtil.getActiveShell(event), "Cannot create data",
					"Data format of the created data is not supported");
			return null;
		}
		/*
		 * Just select the first
		 */
		final IResult result = conversions.get(0);
		final int rows = result.getRows();
		final int columns = result.getColumns();
		final String[][] table = result.getTable();

		/*
		 * Check that we have room for the create...
		 */
		final Point p = binding.getCell().getPosition(true);
		if (p == null) {
			MessageDialog.openError(HandlerUtil.getActiveShell(event), "Cannot create data",
					"Can only create into a viewer");
			return null;
		}

		/*
		 * Create the needed rows in the viewer
		 */
		final ISuperCreateParticipantContext pcontext = new ISuperCreateParticipantContext() {
			@Override
			public IViewerBinding getViewer() {
				return container;
			}

			@Override
			public EReference getReference() {
				final IObservableList l = getViewer().getList();
				if (l.getElementType() instanceof EReference) return (EReference) l.getElementType();
				return null;
			}

			@Override
			public EObject getParent() {
				final IObservableList l = getViewer().getList();
				if (l instanceof IObserving) return (EObject) ((IObserving) l).getObserved();
				return null;
			}

			private final Point myP = new Point(p.x, p.y);

			@Override
			public Point getPosition() {
				return myP;
			}

			@Override
			public EditingDomain getEditingDomain() {
				return context.getEditingDomain();
			}

			@Override
			public IResult getClipboardContent() {
				return result;
			}
		};
		final ISuperCreateParticipant participant = container.getArgument(Constants.ARG_SUPER_CREATE_PARTICIPANT,
				ISuperCreateParticipant.class, myDefaultParticipant);

		final IBindingHighlightContext successHighlightContext = IBindingHighlightContext.Factory.createContext();

		final Map<IValueBinding, String> assignmentMap = new HashMap<IValueBinding, String>();
		final CommandStack commandStack = IManager.Factory.getManager().getEditingDomain().getCommandStack();

		try {
			if (commandStack instanceof ExtendedCommandStack) {
				((ExtendedCommandStack) commandStack).setCollectCommandMode(true);
			}
			boolean success = false;
			try {
				success = participant.createNeededRows(pcontext);
			} catch (final Exception ex) {
				LogUtils.error(participant, ex);
			}
			if (!success) {
				MessageDialog.openError(HandlerUtil.getActiveShell(event), "Cannot create data", "Can not create rows");
				return null;
			}

			for (int r = 0; r < rows; r++) {
				/*
				 * The index of the column to copy into - needed as some columns can be zero width
				 * and must be ignored
				 */
				int ci = p.x;
				for (int c = 0; c < columns; c++) {
					final String data = table[r][c];

					IValueBindingCell cell;
					do {
						cell = container.getCell(ci, p.y + r, true);
						ci++;
						if (cell == null) {
							MessageDialog.openError(HandlerUtil.getActiveShell(event), "Cannot create data",
									"No room for data");
							return null;
						}
					} while (cell.getColumnBinding() != null
							&& cell.getColumnBinding().getColumnAdapter().getWidth() == 0);
					final IValueBinding b = cell.getLabelBinding();
					if (!b.isChangeable()) {
						cell.setFocus();
						MessageDialog.openError(HandlerUtil.getActiveShell(event), "Cannot create data",
								"Target cell is not changeable");
						return null;
					}
					successHighlightContext.add(b);

					/*
					 * Make a new create binding and add this to the assignmentMap...
					 */
					final WritableValue ov = new WritableValue("", String.class);
					final IUIAttribute attribute = new SimpleUIAttribute(null, null, ov, true);
					final IValueBinding createBinding = context.addBinding().model(b.getModelObservableValue())
							.ui(attribute);
					if (b.hasArguments()) {
						createBinding.getExtraArgumentProviders().add(b);
					}
					if (b.getParentBinding() != null) {
						createBinding.getExtraArgumentProviders().add(b.getParentBinding());
					}
					if (b.eIsSet(IUIBindingsPackage.Literals.BINDING__EXTRA_ARGUMENT_PROVIDERS)) {
						createBinding.getExtraArgumentProviders().addAll(b.getExtraArgumentProviders());
					}

					createBinding.setCell(cell);
					assignmentMap.put(createBinding, data);
				}
			}

			/*
			 * Assign all values
			 */
			context.finish(FinishOption.FORCE);

			for (final Entry<IValueBinding, String> d : assignmentMap.entrySet()) {
				final IValueBinding b = d.getKey();
				final String value = d.getValue();
				b.getUIAttribute().getCurrentValue().setValue(value);
				/*
				 * Check for errors in the binding
				 */
				final List<String> errors = b.getErrors();
				if (errors != null && errors.size() > 0) {
					b.getCell().setFocus();
					// TODO Should concat to get all errors
					// TODO highlight error bindings

					/*
					 * Not really correct... Will allow the first set of changes...
					 */
					MessageDialog.openError(HandlerUtil.getActiveShell(event), "Cannot paste data", "Setting value '"
							+ value + "' : " + errors.get(0));
					return null;
				}
			}
			successHighlightContext.activate();
		} finally {
			if (commandStack instanceof ExtendedCommandStack) {
				((ExtendedCommandStack) commandStack).setCollectCommandMode(false);
			}
			/*
			 * If we did not succeed, the dispose the highlight context...
			 */
			if (successHighlightContext.getStage() == STAGE.INIT) {
				successHighlightContext.dispose();
			}

			/*
			 * Dispose all the created bindings
			 */
			for (final Entry<IValueBinding, String> d : assignmentMap.entrySet()) {
				d.getKey().dispose();
			}
		}

		return null;
	}

	/**
	 * The default {@link ISuperCreateParticipant} based on new information...
	 */
	private static ISuperCreateParticipant myDefaultParticipant = new ISuperCreateParticipant() {

		@Override
		public boolean createNeededRows(ISuperCreateParticipantContext context) {
			final List<IChildCreationSpecification> specs = context.getViewer().getPossibleChildObjects(null, null);
			if (specs == null || specs.size() != 1) {
				LogUtils.debug(this, "Cannot creete rows. Specs=" + specs);
				return false;
			}

			final IChildCreationSpecification s = specs.get(0);
			final List<EObject> rows = new ArrayList<EObject>();
			final EditingDomain ed = context.getEditingDomain();
			final CompoundCommand cc = new CompoundCommand();
			for (int r = 0; r < context.getClipboardContent().getRows(); r++) {
				/*
				 * Create a new row
				 */
				final EObject row = EcoreUtil.create(s.getChildType());
				/*
				 * Initialize the row
				 */
				cc.append(IManager.Factory.getManager().initializeObject(s.getParent(), s.getReference(), row));
				rows.add(row);
			}
			/*
			 * Add the created rows to the list
			 */
			cc.append(AddCommand.create(ed, context.getParent(), context.getReference(), rows, context.getPosition().y));

			/*
			 * Execute the created command
			 */
			ed.getCommandStack().execute(cc);

			return true;
		}
	};
}
