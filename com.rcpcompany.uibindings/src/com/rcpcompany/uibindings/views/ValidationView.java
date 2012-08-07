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
package com.rcpcompany.uibindings.views;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IBindingMessageTarget;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IDnDSupport;
import com.rcpcompany.uibindings.utils.ITableCreator;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * Simple view that shows the current validation status.
 * <p>
 * To get objects to be propertly shown in the view, they should support the decorator type
 * {@link Constants#TYPE_LONG_NAME}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ValidationView extends ViewPart {

	private final IValidatorAdapterManager myVAM = IValidatorAdapterManager.Factory.getManager();
	/* package */ITableCreator myTable; // For testing
	private IBindingContext myContext;
	/* package */Composite myTop; // For testing

	/**
	 * The current messages in the view.
	 */
	protected IObservableList myMessages;
	private final IListChangeListener myMessageListListener = new IListChangeListener() {
		@Override
		public void handleListChange(ListChangeEvent event) {
			updateViewTooltip();
		}
	};

	/**
	 * Updates the tooltip on the view tab.
	 */
	protected void updateViewTooltip() {
		if (myMessages.size() == 0) {
			setTitleToolTip(null);
			return;
		}
		int errors = 0, warnings = 0, infos = 0;
		for (final Object o : myMessages) {
			switch (((IBindingMessage) o).getSeverity()) {
			case ERROR:
				errors++;
				break;
			case WARNING:
				warnings++;
				break;
			case INFORMATION:
				infos++;
				break;
			default:
				break;
			}
		}
		String tt = "";
		if (errors > 0) {
			tt += ", " + errors + " errors";
		}
		if (warnings > 0) {
			tt += ", " + warnings + " warnings";
		}
		if (infos > 0) {
			tt += ", " + infos + " informational";
		}
		setTitleToolTip(tt.substring(2));
	}

	@Override
	public void createPartControl(Composite parent) {
		myTop = parent;

		myContext = IBindingContext.Factory.createContext(parent);

		myMessages = myVAM.getUnboundMessagesOL();
		myMessages.addListChangeListener(myMessageListListener);
		myTable = ITableCreator.Factory.create(myContext, myTop, SWT.H_SCROLL | ITableCreator.FILTER, myMessages);
		myTable.getBinding().readonly();

		myTable.addColumn("severity(w=20,ww=0,label='',format='')");
		myTable.addColumn("__NONE__(w=150,ww=200,label='Object')")
				.model(new ModelObjectFactory(), EcorePackage.Literals.EJAVA_OBJECT).dynamic()
				.type(Constants.TYPE_QUALIFIED_NAME).arg(Constants.ARG_SHOW_IMAGE, true);
		myTable.addColumn("__NONE__(w=50,ww=100,label='Feature')")
				.model(new ModelFeatureFactory(), EcorePackage.Literals.EJAVA_OBJECT).dynamic();
		myTable.addColumn("message(w=200, ww=400)");

		myContext.finish();

		IBindingContextSelectionProvider.Factory.adapt(myContext, getSite());
		IDnDSupport.Factory.installOn(myContext);
		updateViewTooltip();
	}

	@Override
	public void dispose() {
		if (myTable != null) {
			myTable.dispose();
			myTable = null;
		}
		if (myContext != null) {
			myContext.dispose();
			myContext = null;
		}
		if (myMessages != null && !myMessages.isDisposed()) {
			myMessages.removeListChangeListener(myMessageListListener);
		}
		super.dispose();
	}

	@Override
	public void setFocus() {
		myTable.setFocus();
	}

	/**
	 * {@link IObservableFactory} that finds the model object of a {@link IBindingMessage binding
	 * message}.
	 * <p>
	 * The common model object of all tagrtes of the message or <code>null</code>.
	 */
	protected static class ModelObjectFactory implements IObservableFactory {
		@Override
		public IObservable createObservable(Object obj) {
			final IBindingMessage m = (IBindingMessage) obj;
			final EList<IBindingMessageTarget> targets = m.getTargets();
			EObject modelObject = null;
			switch (targets.size()) {
			case 0:
				break;
			case 1:
				modelObject = targets.get(0).getModelObject();
				break;
			default:
				modelObject = targets.get(0).getModelObject();
				for (final IBindingMessageTarget t : targets) {
					if (t.getModelObject() != modelObject) {
						final WritableValue value = WritableValue.withValueType(EcorePackage.Literals.ESTRING);
						value.setValue("<multiple objects>");
						return value;
					}
				}
				break;
			}
			final WritableValue value = WritableValue.withValueType(modelObject != null ? modelObject.eClass()
					: EcorePackage.Literals.EOBJECT);
			value.setValue(modelObject);
			return value;
		}
	}

	/**
	 * {@link IObservableFactory} that finds the model feature of a {@link IBindingMessage binding
	 * message}.
	 * <p>
	 * The common model feature of all targets of the message or <code>null</code>.
	 */
	protected static class ModelFeatureFactory implements IObservableFactory {
		@Override
		public IObservable createObservable(Object obj) {
			final IBindingMessage m = (IBindingMessage) obj;
			final EList<IBindingMessageTarget> targets = m.getTargets();
			EStructuralFeature feature = null;
			switch (targets.size()) {
			case 0:
				break;
			case 1:
				feature = targets.get(0).getModelFeature();
				break;
			default:
				feature = targets.get(0).getModelFeature();
				for (final IBindingMessageTarget t : targets) {
					if (t.getModelFeature() != feature) {
						final WritableValue value = WritableValue.withValueType(EcorePackage.Literals.ESTRING);
						value.setValue("<multiple features>");
						return value;
					}
				}
				break;
			}
			final WritableValue value = WritableValue.withValueType(EcorePackage.Literals.ESTRUCTURAL_FEATURE);
			value.setValue(feature);
			return value;
		}
	}
}
