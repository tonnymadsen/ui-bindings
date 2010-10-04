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

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.rcpcompany.uibindings.internal.observableFactories.DefaultEMFObservableFactory;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Manager</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IManager#getEditingDomain <em>Editing Domain</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getFormToolkit <em>Form Toolkit</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getArgumentInformation <em>Argument Information
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getProviders <em>Providers</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getUiAttributeFactories <em>Ui Attribute Factories
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getDecoratorExtenders <em>Decorator Extenders</em>}
 * </li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getModelArgumentMediators <em>Model Argument
 * Mediators</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getModelArgumentMediatorClasses <em>Model Argument
 * Mediator Classes</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getTextCommitStrategy <em>Text Commit Strategy
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getTextCommitStrategyDelay <em>Text Commit Strategy
 * Delay</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#isEditCellAnyKey <em>Edit Cell Any Key</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#isEditCellSingleClick <em>Edit Cell Single Click
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getMessageDecorationPosition <em>Message Decoration
 * Position</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getMessageDecorationMinimumSeverity <em>Message
 * Decoration Minimum Severity</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getAlternativeDecorationPosition <em>Alternative
 * Decoration Position</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#isAutoApplySingleQuickfix <em>Auto Apply Single
 * Quickfix</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#isAlternateRowColors <em>Alternate Row Colors</em>}
 * </li>
 * <li>{@link com.rcpcompany.uibindings.IManager#isValidationErrorsAreFatal <em>Validation Errors
 * Are Fatal</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getValidationDelay <em>Validation Delay</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getValidationDelayWindow <em>Validation Delay
 * Window</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#isRequiredVBImageDecorationShown <em>Required VB
 * Image Decoration Shown</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#isAssistVBImageDecorationShown <em>Assist VB Image
 * Decoration Shown</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#isQuickfixVBImageDecorationShown <em>Quickfix VB
 * Image Decoration Shown</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#isViewNavigationRecorded <em>View Navigation
 * Recorded</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getModelInfo <em>Model Info</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getTreeItems <em>Tree Items</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getClipboard <em>Clipboard</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getObservableFactories <em>Observable Factories
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getQuickfixProposalProcessors <em>Quickfix Proposal
 * Processors</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getContexts <em>Contexts</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#getFormatterProvider <em>Formatter Provider</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IManager#isDeleteHandlerCheckEnabled <em>Delete Handler
 * Check Enabled</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager()
 * @generated
 */
public interface IManager extends IBaseObject {
	/**
	 * Factory for a number of objects including the manager itself.
	 */
	final class Factory {
		private Factory() {
		}

		/**
		 * Returns the manager singleton.
		 * 
		 * @return the manager
		 */
		public static IManager getManager() {
			return IUIBindingsFactory.eINSTANCE.getManager();
		}
	}

	/**
	 * Updates all bindings for the specified objects.
	 * 
	 * @param objects the changed objects or <code>null</code>
	 */
	void updateBindings(Object[] objects);

	/**
	 * Returns the value of the '<em><b>Providers</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.IDecoratorProvider}. It is
	 * bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.IDecoratorProvider#getManager <em>Manager</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providers</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Providers</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_Providers()
	 * @see com.rcpcompany.uibindings.IDecoratorProvider#getManager
	 * @generated
	 */
	EList<IDecoratorProvider> getProviders();

	/**
	 * Returns the value of the '<em><b>Ui Attribute Factories</b></em>' reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ui Attribute Factories</em>' reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Ui Attribute Factories</em>' reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_UiAttributeFactories()
	 * @generated
	 */
	EList<IUIAttributeFactoryDescriptor> getUiAttributeFactories();

	/**
	 * Returns the value of the '<em><b>Decorator Extenders</b></em>' reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decorator Extenders</em>' reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Decorator Extenders</em>' reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_DecoratorExtenders()
	 * @generated
	 */
	EList<IUIBindingDecoratorExtenderDescriptor> getDecoratorExtenders();

	/**
	 * Returns the value of the '<em><b>Model Argument Mediators</b></em>' attribute list. The list
	 * contents are of type {@link com.rcpcompany.utils.extensionpoints.CEObjectHolder}
	 * &lt;com.rcpcompany.uibindings.IModelArgumentMediator>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Argument Mediators</em>' attribute list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Argument Mediators</em>' attribute list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_ModelArgumentMediators()
	 * @generated
	 */
	EList<CEObjectHolder<IModelArgumentMediator>> getModelArgumentMediators();

	/**
	 * Runs all defined model argument mediators if not already done for the specified class.
	 * 
	 * @param classifier the class to run the mediators for
	 */
	void runModelArgumentMediators(EClassifier classifier);

	/**
	 * Returns the value of the '<em><b>Model Argument Mediator Classes</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Argument Mediator Classes</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Argument Mediator Classes</em>' attribute.
	 * @see #setModelArgumentMediatorClasses(Map)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_ModelArgumentMediatorClasses()
	 * @generated
	 */
	Map<EClassifier, Object> getModelArgumentMediatorClasses();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IManager#getModelArgumentMediatorClasses
	 * <em>Model Argument Mediator Classes</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Model Argument Mediator Classes</em>' attribute.
	 * @see #getModelArgumentMediatorClasses()
	 * @generated
	 */
	void setModelArgumentMediatorClasses(Map<EClassifier, Object> value);

	/**
	 * Returns the value of the '<em><b>Text Commit Strategy</b></em>' attribute. The default value
	 * is <code>"ON_MODIFY_DELAY"</code>. The literals are from the enumeration
	 * {@link com.rcpcompany.uibindings.TextCommitStrategy}. <!-- begin-user-doc -->
	 * <p>
	 * The strategy specifies when changes are performed in cells.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Text Commit Strategy</em>' attribute.
	 * @see com.rcpcompany.uibindings.TextCommitStrategy
	 * @see #setTextCommitStrategy(TextCommitStrategy)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_TextCommitStrategy()
	 * @generated
	 */
	TextCommitStrategy getTextCommitStrategy();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IManager#getTextCommitStrategy
	 * <em>Text Commit Strategy</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Text Commit Strategy</em>' attribute.
	 * @see com.rcpcompany.uibindings.TextCommitStrategy
	 * @see #getTextCommitStrategy()
	 * @generated
	 */
	void setTextCommitStrategy(TextCommitStrategy value);

	/**
	 * Returns the value of the '<em><b>Text Commit Strategy Delay</b></em>' attribute. The default
	 * value is <code>"400"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Commit Strategy Delay</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Text Commit Strategy Delay</em>' attribute.
	 * @see #setTextCommitStrategyDelay(int)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_TextCommitStrategyDelay()
	 * @generated
	 */
	int getTextCommitStrategyDelay();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IManager#getTextCommitStrategyDelay
	 * <em>Text Commit Strategy Delay</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Text Commit Strategy Delay</em>' attribute.
	 * @see #getTextCommitStrategyDelay()
	 * @generated
	 */
	void setTextCommitStrategyDelay(int value);

	/**
	 * Returns the value of the '<em><b>Edit Cell Any Key</b></em>' attribute. The default value is
	 * <code>"true"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edit Cell Any Key</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Edit Cell Any Key</em>' attribute.
	 * @see #setEditCellAnyKey(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_EditCellAnyKey()
	 * @generated
	 */
	boolean isEditCellAnyKey();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IManager#isEditCellAnyKey
	 * <em>Edit Cell Any Key</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Edit Cell Any Key</em>' attribute.
	 * @see #isEditCellAnyKey()
	 * @generated
	 */
	void setEditCellAnyKey(boolean value);

	/**
	 * Returns the value of the '<em><b>Edit Cell Single Click</b></em>' attribute. The default
	 * value is <code>"true"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edit Cell Single Click</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Edit Cell Single Click</em>' attribute.
	 * @see #setEditCellSingleClick(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_EditCellSingleClick()
	 * @generated
	 */
	boolean isEditCellSingleClick();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IManager#isEditCellSingleClick
	 * <em>Edit Cell Single Click</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Edit Cell Single Click</em>' attribute.
	 * @see #isEditCellSingleClick()
	 * @generated
	 */
	void setEditCellSingleClick(boolean value);

	/**
	 * Returns the value of the '<em><b>Message Decoration Position</b></em>' attribute. The default
	 * value is <code>"BOTTOM_LEFT"</code>. The literals are from the enumeration
	 * {@link com.rcpcompany.uibindings.DecorationPosition}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Decoration Position</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Message Decoration Position</em>' attribute.
	 * @see com.rcpcompany.uibindings.DecorationPosition
	 * @see #setMessageDecorationPosition(DecorationPosition)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_MessageDecorationPosition()
	 * @generated
	 */
	DecorationPosition getMessageDecorationPosition();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IManager#getMessageDecorationPosition
	 * <em>Message Decoration Position</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Message Decoration Position</em>' attribute.
	 * @see com.rcpcompany.uibindings.DecorationPosition
	 * @see #getMessageDecorationPosition()
	 * @generated
	 */
	void setMessageDecorationPosition(DecorationPosition value);

	/**
	 * Returns the value of the '<em><b>Message Decoration Minimum Severity</b></em>' attribute. The
	 * default value is <code>"WARNING"</code>. The literals are from the enumeration
	 * {@link com.rcpcompany.uibindings.BindingMessageSeverity}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Decoration Minimum Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Message Decoration Minimum Severity</em>' attribute.
	 * @see com.rcpcompany.uibindings.BindingMessageSeverity
	 * @see #setMessageDecorationMinimumSeverity(BindingMessageSeverity)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_MessageDecorationMinimumSeverity()
	 * @generated
	 */
	BindingMessageSeverity getMessageDecorationMinimumSeverity();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IManager#getMessageDecorationMinimumSeverity
	 * <em>Message Decoration Minimum Severity</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Message Decoration Minimum Severity</em>' attribute.
	 * @see com.rcpcompany.uibindings.BindingMessageSeverity
	 * @see #getMessageDecorationMinimumSeverity()
	 * @generated
	 */
	void setMessageDecorationMinimumSeverity(BindingMessageSeverity value);

	/**
	 * Returns the value of the '<em><b>Alternative Decoration Position</b></em>' attribute. The
	 * default value is <code>"TOP_LEFT"</code>. The literals are from the enumeration
	 * {@link com.rcpcompany.uibindings.DecorationPosition}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternative Decoration Position</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Alternative Decoration Position</em>' attribute.
	 * @see com.rcpcompany.uibindings.DecorationPosition
	 * @see #setAlternativeDecorationPosition(DecorationPosition)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_AlternativeDecorationPosition()
	 * @generated
	 */
	DecorationPosition getAlternativeDecorationPosition();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IManager#getAlternativeDecorationPosition
	 * <em>Alternative Decoration Position</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Alternative Decoration Position</em>' attribute.
	 * @see com.rcpcompany.uibindings.DecorationPosition
	 * @see #getAlternativeDecorationPosition()
	 * @generated
	 */
	void setAlternativeDecorationPosition(DecorationPosition value);

	/**
	 * Returns the value of the '<em><b>Auto Apply Single Quickfix</b></em>' attribute. The default
	 * value is <code>"false"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Apply Single Quickfix</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Auto Apply Single Quickfix</em>' attribute.
	 * @see #setAutoApplySingleQuickfix(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_AutoApplySingleQuickfix()
	 * @generated
	 */
	boolean isAutoApplySingleQuickfix();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IManager#isAutoApplySingleQuickfix
	 * <em>Auto Apply Single Quickfix</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Auto Apply Single Quickfix</em>' attribute.
	 * @see #isAutoApplySingleQuickfix()
	 * @generated
	 */
	void setAutoApplySingleQuickfix(boolean value);

	/**
	 * Returns the value of the '<em><b>Alternate Row Colors</b></em>' attribute. The default value
	 * is <code>"true"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternate Row Colors</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Alternate Row Colors</em>' attribute.
	 * @see #setAlternateRowColors(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_AlternateRowColors()
	 * @generated
	 */
	boolean isAlternateRowColors();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IManager#isAlternateRowColors
	 * <em>Alternate Row Colors</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Alternate Row Colors</em>' attribute.
	 * @see #isAlternateRowColors()
	 * @generated
	 */
	void setAlternateRowColors(boolean value);

	/**
	 * Returns the value of the '<em><b>Validation Errors Are Fatal</b></em>' attribute. The default
	 * value is <code>"false"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validation Error Is Warning</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Validation Errors Are Fatal</em>' attribute.
	 * @see #setValidationErrorsAreFatal(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_ValidationErrorsAreFatal()
	 * @generated
	 */
	boolean isValidationErrorsAreFatal();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IManager#isValidationErrorsAreFatal
	 * <em>Validation Errors Are Fatal</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Validation Errors Are Fatal</em>' attribute.
	 * @see #isValidationErrorsAreFatal()
	 * @generated
	 */
	void setValidationErrorsAreFatal(boolean value);

	/**
	 * Returns the value of the '<em><b>Validation Delay</b></em>' attribute. The default value is
	 * <code>"200"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validation Delay</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Validation Delay</em>' attribute.
	 * @see #setValidationDelay(int)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_ValidationDelay()
	 * @generated
	 */
	int getValidationDelay();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IManager#getValidationDelay
	 * <em>Validation Delay</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Validation Delay</em>' attribute.
	 * @see #getValidationDelay()
	 * @generated
	 */
	void setValidationDelay(int value);

	/**
	 * Returns the value of the '<em><b>Validation Delay Window</b></em>' attribute. The default
	 * value is <code>"25"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validation Delay Window</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Validation Delay Window</em>' attribute.
	 * @see #setValidationDelayWindow(int)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_ValidationDelayWindow()
	 * @generated
	 */
	int getValidationDelayWindow();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IManager#getValidationDelayWindow
	 * <em>Validation Delay Window</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Validation Delay Window</em>' attribute.
	 * @see #getValidationDelayWindow()
	 * @generated
	 */
	void setValidationDelayWindow(int value);

	/**
	 * Returns the value of the '<em><b>Required VB Image Decoration Shown</b></em>' attribute. The
	 * default value is <code>"true"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required VB Image Decoration Shown</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Required VB Image Decoration Shown</em>' attribute.
	 * @see #setRequiredVBImageDecorationShown(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_RequiredVBImageDecorationShown()
	 * @generated
	 */
	boolean isRequiredVBImageDecorationShown();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IManager#isRequiredVBImageDecorationShown
	 * <em>Required VB Image Decoration Shown</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Required VB Image Decoration Shown</em>' attribute.
	 * @see #isRequiredVBImageDecorationShown()
	 * @generated
	 */
	void setRequiredVBImageDecorationShown(boolean value);

	/**
	 * Returns the value of the '<em><b>Assist VB Image Decoration Shown</b></em>' attribute. The
	 * default value is <code>"true"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assist VB Image Decoration Shown</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Assist VB Image Decoration Shown</em>' attribute.
	 * @see #setAssistVBImageDecorationShown(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_AssistVBImageDecorationShown()
	 * @generated
	 */
	boolean isAssistVBImageDecorationShown();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IManager#isAssistVBImageDecorationShown
	 * <em>Assist VB Image Decoration Shown</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Assist VB Image Decoration Shown</em>' attribute.
	 * @see #isAssistVBImageDecorationShown()
	 * @generated
	 */
	void setAssistVBImageDecorationShown(boolean value);

	/**
	 * Returns the value of the '<em><b>Quickfix VB Image Decoration Shown</b></em>' attribute. The
	 * default value is <code>"true"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quickfix VB Image Decoration Shown</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Quickfix VB Image Decoration Shown</em>' attribute.
	 * @see #setQuickfixVBImageDecorationShown(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_QuickfixVBImageDecorationShown()
	 * @generated
	 */
	boolean isQuickfixVBImageDecorationShown();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IManager#isQuickfixVBImageDecorationShown
	 * <em>Quickfix VB Image Decoration Shown</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Quickfix VB Image Decoration Shown</em>' attribute.
	 * @see #isQuickfixVBImageDecorationShown()
	 * @generated
	 */
	void setQuickfixVBImageDecorationShown(boolean value);

	/**
	 * Returns the value of the '<em><b>View Navigation Recorded</b></em>' attribute. The default
	 * value is <code>"true"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View Navigation Recorded</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>View Navigation Recorded</em>' attribute.
	 * @see #setViewNavigationRecorded(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_ViewNavigationRecorded()
	 * @generated
	 */
	boolean isViewNavigationRecorded();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IManager#isViewNavigationRecorded
	 * <em>View Navigation Recorded</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>View Navigation Recorded</em>' attribute.
	 * @see #isViewNavigationRecorded()
	 * @generated
	 */
	void setViewNavigationRecorded(boolean value);

	/**
	 * Returns the value of the '<em><b>Model Info</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type
	 * {@link com.rcpcompany.uibindings.IModelClassInfo}, <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Info</em>' reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Info</em>' map.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_ModelInfo()
	 * @generated
	 */
	EMap<String, IModelClassInfo> getModelInfo();

	/**
	 * Returns the value of the '<em><b>Tree Items</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.ITreeItemDescriptor}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tree Items</em>' reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Tree Items</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_TreeItems()
	 * @generated
	 */
	EList<ITreeItemDescriptor> getTreeItems();

	/**
	 * Finds and returns the {@link ITreeItemDescriptor} that best matches the specified model
	 * object.
	 * <p>
	 * If no descriptor can be found a new is invented in place.
	 * 
	 * @param modelObject the model object to match against.
	 * @return the descriptor that matches
	 */
	ITreeItemDescriptor getTreeItem(EObject modelObject);

	/**
	 * Finds and returns the {@link ITreeItemDescriptor} for the specified ID.
	 * 
	 * @param id the ID to find
	 * @return the descriptor with the ID or <code>null</code>
	 */
	ITreeItemDescriptor getTreeItem(String id);

	/**
	 * Returns the value of the '<em><b>Clipboard</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clipboard</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Clipboard</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_Clipboard()
	 * @generated
	 */
	Clipboard getClipboard();

	/**
	 * Returns the value of the '<em><b>Observable Factories</b></em>' containment reference list.
	 * The list contents are of type
	 * {@link com.rcpcompany.uibindings.IEMFObservableFactoryDescriptor}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observable Factories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Observable Factories</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_ObservableFactories()
	 * @generated
	 */
	EList<IEMFObservableFactoryDescriptor> getObservableFactories();

	/**
	 * Returns the value of the '<em><b>Quickfix Proposal Processors</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor}. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Quickfix Proposal Processors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Quickfix Proposal Processors</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_QuickfixProposalProcessors()
	 * @generated
	 */
	EList<IQuickfixProposalProcessorDescriptor> getQuickfixProposalProcessors();

	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.IBindingContext}. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contexts</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_Contexts()
	 * @generated
	 */
	EList<IBindingContext> getContexts();

	/**
	 * Returns the value of the '<em><b>Formatter Provider</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Formatter Provider</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Formatter Provider</em>' attribute.
	 * @see #setFormatterProvider(IFormatterProvider)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_FormatterProvider()
	 * @generated
	 */
	IFormatterProvider getFormatterProvider();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IManager#getFormatterProvider
	 * <em>Formatter Provider</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Formatter Provider</em>' attribute.
	 * @see #getFormatterProvider()
	 * @generated
	 */
	void setFormatterProvider(IFormatterProvider value);

	/**
	 * Returns the value of the '<em><b>Delete Handler Check Enabled</b></em>' attribute. The
	 * default value is <code>"false"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delete Handler Check Enabled</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Delete Handler Check Enabled</em>' attribute.
	 * @see #setDeleteHandlerCheckEnabled(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_DeleteHandlerCheckEnabled()
	 * @generated
	 */
	boolean isDeleteHandlerCheckEnabled();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IManager#isDeleteHandlerCheckEnabled
	 * <em>Delete Handler Check Enabled</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Delete Handler Check Enabled</em>' attribute.
	 * @see #isDeleteHandlerCheckEnabled()
	 * @generated
	 */
	void setDeleteHandlerCheckEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Editing Domain</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The editing domain is used for all changes performed on model objects.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Editing Domain</em>' attribute.
	 * @see #setEditingDomain(EditingDomain)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_EditingDomain()
	 * @generated
	 */
	EditingDomain getEditingDomain();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IManager#getEditingDomain
	 * <em>Editing Domain</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Editing Domain</em>' attribute.
	 * @see #getEditingDomain()
	 * @generated
	 */
	void setEditingDomain(EditingDomain value);

	/**
	 * Returns the value of the '<em><b>Form Toolkit</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The form toolkit is used in the UI Bindings framework whenever a widget must be created.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Form Toolkit</em>' attribute.
	 * @see #setFormToolkit(FormToolkit)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_FormToolkit()
	 * @generated
	 */
	FormToolkit getFormToolkit();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IManager#getFormToolkit
	 * <em>Form Toolkit</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Form Toolkit</em>' attribute.
	 * @see #getFormToolkit()
	 * @generated
	 */
	void setFormToolkit(FormToolkit value);

	/**
	 * Returns the value of the '<em><b>Argument Information</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type
	 * {@link com.rcpcompany.uibindings.IArgumentInformation}, <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument Information</em>' map isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Argument Information</em>' map.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getManager_ArgumentInformation()
	 * @generated
	 */
	EMap<String, IArgumentInformation> getArgumentInformation();

	/**
	 * Returns argument information about the specified argument.
	 * <p>
	 * Returns a newly created object if it does not already exist.
	 * 
	 * @param name the argument name
	 * @return the argument information
	 */
	IArgumentInformation getArgumentInformation(String name);

	/**
	 * Returns the {@link IEMFObservableFactory observable factory} to used for the specified
	 * {@link EObject}.
	 * 
	 * @param object the object to test
	 * @return the used factory - defaults to {@link DefaultEMFObservableFactory}
	 */
	IEMFObservableFactory getObservableFactory(EObject object);

	/**
	 * Returns the model class information record for the specified model class.
	 * 
	 * @param className the class name
	 * @param type the binding type
	 * @param create <code>true</code> if the record should be created if not already present
	 * @return the record
	 */
	IModelClassInfo getModelClassInfo(String className, String type, boolean create);

	/**
	 * Returns the model feature information record for the specified model class and feature.
	 * 
	 * @param className the class name
	 * @param featureName the feature name
	 * @param type the binding type
	 * @param create <code>true</code> if the record should be created if not already present
	 * @return the record or <code>null</code>
	 */
	IModelFeatureInfo getModelFeatureInfo(String className, String featureName, String type, boolean create);

	/**
	 * Returns the decorator provider for the combined triple model type, UI type and type name.
	 * 
	 * @param modelType the model type
	 * @param uiType the UI type
	 * @param type the type name
	 * @return the decorator provider
	 */
	IDecoratorProvider getProvider(Class<?> modelType, Class<?> uiType, String type);

	/**
	 * Returns a list of quick fixes for the specified message.
	 * 
	 * @param message the message to test for quick fixes
	 * @param list the list to add to
	 */
	void getQuickfixes(IBindingMessage message, List<IQuickfixProposal> proposals);

	/**
	 * Creates new UI attribute from the widget type and the wanted attribute.
	 * 
	 * @param widget the widget
	 * @param attribute the attribute of the widget
	 * @return new UI attribute or <code>null</code> if none can be created
	 */
	IUIAttribute createUIAttribute(Widget widget, String attribute);

	/**
	 * Returns whether the specified editor activation event should in fact start a new editor.
	 * 
	 * @param event the activation event
	 * @param cell TODO
	 * @return <code>true</code> if a new editor should be started
	 */
	boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event, IValueBindingCell cell);

	/**
	 * Handles any additions of arguments from {@link IArgumentProvider argument providers}.
	 * 
	 * @param <ArgumentType> the argument type
	 * @param provider the argument provider
	 * @param context argument context
	 */
	<ArgumentType> void addArgumentProviderArguments(IArgumentProvider provider, IArgumentContext<ArgumentType> context);

	/**
	 * Returns the named argument or <code>null</code> if not set.
	 * <p>
	 * Will look for the argument among the arguments of the binding first and then among the
	 * annotations (declared arguments) of the data type.
	 * 
	 * @param <ArgumentType> the wanted argument type
	 * 
	 * @param context the argument context
	 * @param source the argument source - e.g. an {@link IArgumentProvider}
	 * @param ce the source configuration element or <code>null</code>
	 * @param attributeName the name of the attribute in ce
	 * @param value the value
	 */
	<ArgumentType> void addArgumentValue(IArgumentContext<ArgumentType> context, Object source,
			IConfigurationElement ce, String attributeName, String value);
} // IManager
