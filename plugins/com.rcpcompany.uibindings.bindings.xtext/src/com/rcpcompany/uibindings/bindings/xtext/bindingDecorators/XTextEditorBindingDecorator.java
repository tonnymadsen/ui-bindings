package com.rcpcompany.uibindings.bindings.xtext.bindingDecorators;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.bindings.xtext.UIBXTextContants;
import com.rcpcompany.uibindings.bindings.xtext.internal.uiAttributes.EditorAttribute;
import com.rcpcompany.uibindings.bindings.xtext.internal.xtext.EmbeddedXtextEditorModule;
import com.rcpcompany.uibindings.bindings.xtext.xtext.EmbeddedXtextEditor;
import com.rcpcompany.uibindings.decorators.BaseUIBindingDecorator;

/**
 * {@link IUIBindingDecorator} for XText Editors.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class XTextEditorBindingDecorator extends BaseUIBindingDecorator implements IUIBindingDecorator {
	/**
	 * The injector used for the XText editor.
	 * <p>
	 * Found as an argument of the binding.
	 */
	private Injector myInjector;

	/**
	 * The XText Editor itself.
	 */
	private EmbeddedXtextEditor myEditor;

	@Override
	public void init(IValueBinding binding) {
		Assert.isNotNull(binding);
		setBinding(binding);
	}

	@Override
	public void dispose() {
	}

	@Override
	public void decorate() {
		final IValueBinding b = getBinding();

		/*
		 * Sanity checks
		 */
		final IObservableValue modelOV = b.getModelObservableValue();
		b.assertTrue(modelOV != null, "Decorator requires an observable value");
		Object modelType = modelOV.getValueType();
		if (modelType instanceof EStructuralFeature) {
			modelType = ((EStructuralFeature) modelType).getEType();
		}
		b.assertTrue(modelType == EcorePackage.Literals.ESTRING, "Model observable value must refer to String");

		/*
		 * Check that the control of the binding is an Composite
		 */
		final Control c = b.getControl();
		b.assertTrue(c instanceof Composite, "Control of XText Editor Binding must be a Composite");

		/*
		 * Based on the supplied module, create the needed injector
		 */
		Module m = b.getArgument(UIBXTextContants.ARG_XTEXT_INJECTOR_MODULE, Module.class, null);
		b.assertTrue(m != null, "XText Decoratoe requires an injector");
		m = Modules.override(m).with(new EmbeddedXtextEditorModule());
		myInjector = Guice.createInjector(m);

		/*
		 * Create the editor
		 */
		myEditor = new EmbeddedXtextEditor(getBinding(), myInjector, SWT.BORDER | SWT.V_SCROLL);

		/*
		 * Replace the original UI Attribute with a new one that points directly at control of the editor rather than
		 * the composite that holds the control...
		 * 
		 * This must happen before the decoration and the type of the new attribute, must be identical to the old type.
		 */
		final IUIAttribute oldUIAttribute = b.getUIAttribute();
		b.setUIAttribute(new EditorAttribute(myEditor));
		oldUIAttribute.dispose();

		super.decorate();
	}

	@Override
	public IObservableList getValidUIList() {
		/*
		 * No list possible here
		 */
		return null;
	}
}
