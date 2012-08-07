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
package com.rcpcompany.uibindings;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.services.IServiceLocator;

import com.rcpcompany.uibindings.internal.BindingImpl;

/**
 * <!-- begin-user-doc -->
 * <p>
 * The context for a set of bindings.
 * <p>
 * Bindings are normally setup with the following pattern:
 * 
 * <pre>
 * &#064;Override
 * public void createControl(Composite parent) {
 * 	// Setup the part...
 * 
 * 	bind();
 * }
 * 
 * private void bindUI() {
 * 	IBindingContext context = IBindingContext.Factory.createContext(this);
 * 
 * 	context.addBinding(bodyName.getControl(), myBody, IUIBindingsPackage.Literals.NAMED_OBJECT__NAME);
 * 	context.addBinding(bodyTypeCombo, myBody, IUIBindingsPackage.Literals.BODY__TYPE);
 * 	context.addBinding(xField.getControl(), myBody.getInitialPosition(), IUIBindingsPackage.Literals.TUPLE6__X);
 * 
 * 	context.finish();
 * }
 * </pre>
 * 
 * Note that the bindings are not made effective before {@link #finish()} is called.
 * </p>
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IBindingContext#getBindings <em>Bindings</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingContext#getOkBindings <em>Ok Bindings</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingContext#getTop <em>Top</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingContext#getDbContext <em>Db Context</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingContext#getServiceLocator <em>Service Locator</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingContext#getState <em>State</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingContext#getTextCommitStrategy <em>Text Commit
 * Strategy</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingContext#getTextCommitStrategyCalculated <em>Text
 * Commit Strategy Calculated</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingContext#getEditingDomain <em>Editing Domain</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IBindingContext#getFinalizers <em>Finalizers</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingContext()
 * @generated
 */
public interface IBindingContext extends IBaseObject, IDisposable {
	/**
	 * The factory used to create and manage binding contexts.
	 */
	final class Factory {
		private Factory() {
		}

		/**
		 * Constructs and returns a new binding context.
		 * <p>
		 * The binding context has have a top component before any bindings can be added.
		 * 
		 * @return the new context
		 */
		public static IBindingContext createContext() {
			return IUIBindingsFactory.eINSTANCE.createBindingContext();
		}

		/**
		 * Constructs and returns a new binding context for a Composite.
		 * <p>
		 * The context is disposed with the context.
		 * 
		 * @param top the top composite
		 * 
		 * @return the new context
		 */
		public static IBindingContext createContext(Composite top) {
			return IUIBindingsFactory.eINSTANCE.createBindingContext(top);
		}

		/**
		 * Constructs and returns a new binding context for a scrolled form.
		 * 
		 * @param toolkit the used forms toolkit
		 * @param form the top form
		 * 
		 * @return the new context
		 * @deprecated use createContext(form)
		 */
		@Deprecated
		public static IBindingContext createContext(FormToolkit toolkit, ScrolledForm form) {
			return createContext(form);
		}

		/**
		 * Constructs and returns a new binding context for a scrolled form.
		 * 
		 * @param form the top form
		 * 
		 * @return the new context
		 */
		public static IBindingContext createContext(ScrolledForm form) {
			return IUIBindingsFactory.eINSTANCE.createBindingContext(form);
		}

		/**
		 * Constructs and returns a new binding context for a {@link Dialog dialog}.
		 * 
		 * @param dialog the dialog
		 * 
		 * @return the new context
		 */
		public static IBindingContext createContext(Dialog dialog) {
			return IUIBindingsFactory.eINSTANCE.createBindingContext(dialog.getShell());
		}

		/**
		 * Constructs and returns a new binding context for a wizard page.
		 * 
		 * @param page the wizard page
		 * 
		 * @return the new context
		 */
		public static IBindingContext createContext(WizardPage page) {
			return IUIBindingsFactory.eINSTANCE.createBindingContext(page);
		}

		/**
		 * Returns the binding associated with the specified widget if any.
		 * 
		 * @param widget the widget
		 * @return the associated binding or <code>null</code>
		 */
		public static IBinding getBindingForWidget(Widget widget) {
			return BindingImpl.getBindingForWidget(widget);
		}
	}

	/**
	 * Updates all bindings for the specified objects.
	 * 
	 * @param objects the changed objects or <code>null</code>
	 */
	void updateBindings(Object[] objects);

	/**
	 * Signals that all bindings are performed for this context.
	 * <p>
	 * At this point all added bindings will be {@link IBinding#finish1() finished} as well.
	 * <p>
	 * Short for
	 * <code>{@link #finish(FinishOption) finish}({@link FinishOption#LAZY FinishOption.LAZY})</code>.
	 */
	void finish();

	/**
	 * Possible options for {@link IBindingContext#finish(FinishOption)}.
	 */
	enum FinishOption {
		/**
		 * Lazily finish the context via {@link Display#asyncExec(Runnable)}.
		 */
		LAZY,

		/**
		 * Force an immediate finish of the context.
		 */
		FORCE,

		/**
		 * Lazily finish the context, iff the context is already in finished state.
		 */
		IF_ALREADY_FINISHED
	}

	/**
	 * Signals that this context should be {@link #finish() finished} if finish has previously been
	 * called.
	 * <p>
	 * Otherwise, this method is ignored.
	 * 
	 * @param option the finish option to execute
	 */
	void finish(FinishOption option);

	/**
	 * Requests the form/wizard/whatever that hosts this context is reflowed/re-layout...
	 */
	void reflow();

	/**
	 * Constructs and returns a new value binding to this context.
	 * 
	 * @return the new binding
	 */
	IValueBinding addBinding();

	/**
	 * Constructs and returns a new value binding to this context
	 * <p>
	 * Shortcut for <code>createBinding().widget(widget).emf(object, feature)</code>.
	 * 
	 * @param widget the widget to bind
	 * @param object the model object
	 * @param feature the feature
	 * 
	 * @return the new binding
	 */
	IValueBinding addBinding(Widget widget, EObject object, EStructuralFeature feature);

	/**
	 * Constructs and returns a new value binding to this context
	 * <p>
	 * Shortcut for <code>createBinding().widget(widget, attribute).emf(object, feature)</code>.
	 * 
	 * @param widget the widget to bind
	 * @param attribute the attribute of the widget
	 * @param object the model object
	 * @param feature the feature
	 * 
	 * @return the new binding
	 */
	IValueBinding addBinding(Widget widget, String attribute, EObject object, EStructuralFeature feature);

	/**
	 * Constructs and returns a new value binding to this context
	 * <p>
	 * Shortcut for <code>createBinding().widget(widget).emf(object, feature)</code>.
	 * 
	 * @param widget the widget to bind
	 * @param object the model object
	 * @param feature the feature
	 * 
	 * @return the new binding
	 */
	IValueBinding addBinding(Widget widget, IObservableValue object, EStructuralFeature feature);

	/**
	 * Constructs and returns a new value binding to this context
	 * <p>
	 * Shortcut for <code>createBinding().widget(widget, attribute).emf(object, feature)</code>.
	 * 
	 * @param widget the widget to bind
	 * @param attribute the attribute of the widget
	 * @param object the model object
	 * @param feature the feature
	 * 
	 * @return the new binding
	 */
	IValueBinding addBinding(Widget widget, String attribute, IObservableValue object, EStructuralFeature feature);

	/**
	 * Constructs and returns a new viewer binding.
	 * 
	 * @return the new binding
	 */
	IViewerBinding addViewer();

	/**
	 * Constructs and returns a new binding in the context for the input of a viewer.
	 * 
	 * @param viewer the viewer to bind
	 * @param object the model object
	 * @param reference the feature
	 * 
	 * @return the new binding
	 */
	IViewerBinding addViewer(ColumnViewer viewer, EObject object, EReference reference);

	/**
	 * Constructs and returns a new binding in the context for the input of a table.
	 * 
	 * @param table the table to bind
	 * @param object the model object
	 * @param reference the feature
	 * 
	 * @return the new binding
	 */
	IViewerBinding addViewer(Table table, EObject object, EReference reference);

	/**
	 * Constructs and returns a new binding in the context for the input of a viewer.
	 * 
	 * @param table the table to bind
	 * @param object the model object
	 * @param reference the feature
	 * 
	 * @return the new binding
	 */
	IViewerBinding addViewer(Table table, IObservableValue object, EReference reference);

	/**
	 * Constructs and returns a new binding in the context for the input of a viewer.
	 * 
	 * @param viewer the viewer to bind
	 * @param object the model object
	 * @param reference the feature
	 * 
	 * @return the new binding
	 */
	IViewerBinding addViewer(ColumnViewer viewer, IObservableValue object, EReference reference);

	/**
	 * Constructs and returns a new binding in the context for the input of a viewer.
	 * <p>
	 * The specified list is disposed by the framework.
	 * 
	 * @param viewer the viewer to bind
	 * @param list the objects of the viewer - disposed in the framework
	 * 
	 * @return the new binding
	 */
	IViewerBinding addViewer(ColumnViewer viewer, IObservableList list);

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.IBinding}. It is bidirectional and its
	 * opposite is ' {@link com.rcpcompany.uibindings.IBinding#getContext <em>Context</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * This all registered bindings for this context. They can be in all states, not just
	 * {@link BindingState#OK}.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingContext_Bindings()
	 * @see com.rcpcompany.uibindings.IBinding#getContext
	 * @generated
	 */
	EList<IBinding> getBindings();

	/**
	 * Returns the value of the '<em><b>Ok Bindings</b></em>' reference list. The list contents are
	 * of type {@link com.rcpcompany.uibindings.IBinding}. <!-- begin-user-doc -->
	 * <p>
	 * All bindings on this list are in {@link BindingState#OK} state.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Ok Bindings</em>' reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingContext_OkBindings()
	 * @generated
	 */
	EList<IBinding> getOkBindings();

	/**
	 * Returns the value of the '<em><b>Top</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Top</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingContext_Top()
	 * @generated
	 */
	Composite getTop();

	/**
	 * Returns the value of the '<em><b>Db Context</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> The Data binding context used by this UI Binding
	 * context <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Db Context</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingContext_DbContext()
	 * @generated
	 */
	DataBindingContext getDbContext();

	/**
	 * Returns the value of the '<em><b>Service Locator</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Locator</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Service Locator</em>' attribute.
	 * @see #setServiceLocator(IServiceLocator)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingContext_ServiceLocator()
	 * @generated
	 */
	IServiceLocator getServiceLocator();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IBindingContext#getServiceLocator
	 * <em>Service Locator</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Service Locator</em>' attribute.
	 * @see #getServiceLocator()
	 * @generated
	 */
	void setServiceLocator(IServiceLocator value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute. The default value is
	 * <code>"INIT"</code>. The literals are from the enumeration
	 * {@link com.rcpcompany.uibindings.BindingState}. <!-- begin-user-doc --> The current state of
	 * this context. <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>State</em>' attribute.
	 * @see com.rcpcompany.uibindings.BindingState
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingContext_State()
	 * @generated
	 */
	BindingState getState();

	/**
	 * Returns the value of the '<em><b>Text Commit Strategy</b></em>' attribute. The default value
	 * is <code>"true"</code>. The literals are from the enumeration
	 * {@link com.rcpcompany.uibindings.TextCommitStrategy}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Commit Strategy</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Text Commit Strategy</em>' attribute.
	 * @see com.rcpcompany.uibindings.TextCommitStrategy
	 * @see #setTextCommitStrategy(TextCommitStrategy)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingContext_TextCommitStrategy()
	 * @generated
	 */
	TextCommitStrategy getTextCommitStrategy();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IBindingContext#getTextCommitStrategy
	 * <em>Text Commit Strategy</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Text Commit Strategy</em>' attribute.
	 * @see com.rcpcompany.uibindings.TextCommitStrategy
	 * @see #getTextCommitStrategy()
	 * @generated
	 */
	void setTextCommitStrategy(TextCommitStrategy value);

	/**
	 * Returns the value of the '<em><b>Text Commit Strategy Calculated</b></em>' attribute. The
	 * literals are from the enumeration {@link com.rcpcompany.uibindings.TextCommitStrategy}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Commit Strategy Calculated</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Text Commit Strategy Calculated</em>' attribute.
	 * @see com.rcpcompany.uibindings.TextCommitStrategy
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingContext_TextCommitStrategyCalculated()
	 * @generated
	 */
	TextCommitStrategy getTextCommitStrategyCalculated();

	/**
	 * Returns the value of the '<em><b>Editing Domain</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The editing domain is used for all changes made to the model in this context.
	 * <p>
	 * If not set, the the editing domain of {@link IManager} is used.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Editing Domain</em>' attribute.
	 * @see #setEditingDomain(EditingDomain)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingContext_EditingDomain()
	 * @generated
	 */
	EditingDomain getEditingDomain();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IBindingContext#getEditingDomain
	 * <em>Editing Domain</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Editing Domain</em>' attribute.
	 * @see #getEditingDomain()
	 * @generated
	 */
	void setEditingDomain(EditingDomain value);

	/**
	 * Returns the value of the '<em><b>Finalizers</b></em>' attribute list. The list contents are
	 * of type {@link com.rcpcompany.uibindings.IBindingContextFinalizer}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finalizers</em>' attribute list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Finalizers</em>' attribute list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getBindingContext_Finalizers()
	 * @generated
	 */
	EList<IBindingContextFinalizer> getFinalizers();
} // IBindingContext
