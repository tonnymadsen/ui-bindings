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

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.ScrolledForm;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage
 * @generated
 */
public interface IUIBindingsFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	IUIBindingsFactory eINSTANCE = com.rcpcompany.uibindings.internal.UIBindingsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Manager</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Manager</em>'.
	 * @generated
	 */
	IManager createManager();

	/**
	 * Returns the singleton manager.
	 * 
	 * @return the manager
	 */
	IManager getManager();

	/**
	 * Returns a new object of class '<em>Binding Context</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Binding Context</em>'.
	 * @generated
	 */
	IBindingContext createBindingContext();

	/**
	 * Returns a new object of class '<em>Binding Context</em>' for the specified {@link Composite}.
	 * 
	 * @param top the top {@link Composite}
	 * @return a new object of class '<em>Binding Context</em>'.
	 */
	IBindingContext createBindingContext(Composite top);

	/**
	 * Returns a new object of class '<em>Binding Context</em>' for the specified {@link WizardPage}
	 * .
	 * 
	 * @param top the top {@link WizardPage}
	 * @return a new object of class '<em>Binding Context</em>'.
	 */
	IBindingContext createBindingContext(WizardPage top);

	/**
	 * Returns a new object of class '<em>Binding Context</em>' for the specified
	 * {@link ScrolledForm}.
	 * 
	 * @param top the top {@link ScrolledForm}
	 * @return a new object of class '<em>Binding Context</em>'.
	 */
	IBindingContext createBindingContext(ScrolledForm top);

	/**
	 * Returns a new object of class '<em>Value Binding</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Value Binding</em>'.
	 * @generated
	 */
	IValueBinding createValueBinding();

	/**
	 * Returns a new object of class '<em>Column Binding</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Column Binding</em>'.
	 * @generated
	 */
	IColumnBinding createColumnBinding();

	/**
	 * Returns a new object of class '<em>Column Binding Cell Information</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Column Binding Cell Information</em>'.
	 * @generated
	 */
	IColumnBindingCellInformation createColumnBindingCellInformation();

	/**
	 * Constructs and returns a new cell information object for the specified column binding and row
	 * element.
	 * 
	 * @param column the column
	 * @param element the row element
	 * @return the new cell information object
	 */
	IColumnBindingCellInformation createColumnBindingCellInformation(IColumnBinding column, Object element);

	/**
	 * Returns a new object of class '<em>Viewer Binding</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Viewer Binding</em>'.
	 * @generated
	 */
	IViewerBinding createViewerBinding();

	/**
	 * Returns a new object of class '<em>Argument Information</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Argument Information</em>'.
	 * @generated
	 */
	IArgumentInformation createArgumentInformation();

	/**
	 * Returns a new object of class '<em>Java Decorator Provider</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Java Decorator Provider</em>'.
	 * @generated
	 */
	IJavaDecoratorProvider createJavaDecoratorProvider();

	/**
	 * Returns a new object of class '<em>Enum Decorator Provider</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Enum Decorator Provider</em>'.
	 * @generated
	 */
	IEnumDecoratorProvider createEnumDecoratorProvider();

	/**
	 * Returns a new object of class '<em>Enum Decorator Provider Entry</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Enum Decorator Provider Entry</em>'.
	 * @generated
	 */
	IEnumDecoratorProviderEntry createEnumDecoratorProviderEntry();

	/**
	 * Returns a new object of class '<em>Number Decorator Provider</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Number Decorator Provider</em>'.
	 * @generated
	 */
	INumberDecoratorProvider createNumberDecoratorProvider();

	/**
	 * Returns a new object of class '<em>Model Info</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Model Info</em>'.
	 * @generated
	 */
	IModelInfo createModelInfo();

	/**
	 * Returns a new object of class '<em>Model Class Info</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Model Class Info</em>'.
	 * @generated
	 */
	IModelClassInfo createModelClassInfo();

	/**
	 * Returns a new object of class '<em>Model Feature Info</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Model Feature Info</em>'.
	 * @generated
	 */
	IModelFeatureInfo createModelFeatureInfo();

	/**
	 * Returns a new object of class '<em>UI Binding Decorator Extender Descriptor</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>UI Binding Decorator Extender Descriptor</em>'.
	 * @generated
	 */
	IUIBindingDecoratorExtenderDescriptor createUIBindingDecoratorExtenderDescriptor();

	/**
	 * Returns a new object of class '<em>Assignment Participants Manager</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Assignment Participants Manager</em>'.
	 * @generated
	 */
	IAssignmentParticipantsManager createAssignmentParticipantsManager();

	/**
	 * Returns a new object of class '<em>Assignment Participant Descriptor</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Assignment Participant Descriptor</em>'.
	 * @generated
	 */
	IAssignmentParticipantDescriptor createAssignmentParticipantDescriptor();

	/**
	 * Returns a new object of class '<em>Quickfix Proposal Processor Descriptor</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Quickfix Proposal Processor Descriptor</em>'.
	 * @generated
	 */
	IQuickfixProposalProcessorDescriptor createQuickfixProposalProcessorDescriptor();

	/**
	 * Returns a new object of class '<em>Tree Item Relation</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Tree Item Relation</em>'.
	 * @generated
	 */
	ITreeItemRelation createTreeItemRelation();

	/**
	 * Returns a new object of class '<em>Tree Item Descriptor</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Tree Item Descriptor</em>'.
	 * @generated
	 */
	ITreeItemDescriptor createTreeItemDescriptor();

	/**
	 * Returns a new object of class '<em>Constant Tree Item</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Constant Tree Item</em>'.
	 * @generated
	 */
	IConstantTreeItem createConstantTreeItem();

	/**
	 * Returns a new object of class '<em>Binding Message Target</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Binding Message Target</em>'.
	 * @generated
	 */
	IBindingMessageTarget createBindingMessageTarget();

	/**
	 * Returns a new object of class '<em>UI Attribute Image Decoration</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>UI Attribute Image Decoration</em>'.
	 * @generated
	 */
	IUIAttributeImageDecoration createUIAttributeImageDecoration();

	/**
	 * Returns a new object of class '<em>UI Attribute Factory Descriptor</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>UI Attribute Factory Descriptor</em>'.
	 * @generated
	 */
	IUIAttributeFactoryDescriptor createUIAttributeFactoryDescriptor();

	/**
	 * Returns a new object of class '<em>EMF Observable Factory Descriptor</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>EMF Observable Factory Descriptor</em>'.
	 * @generated
	 */
	IEMFObservableFactoryDescriptor createEMFObservableFactoryDescriptor();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	IUIBindingsPackage getUIBindingsPackage();
} // IUIBindingsFactory
