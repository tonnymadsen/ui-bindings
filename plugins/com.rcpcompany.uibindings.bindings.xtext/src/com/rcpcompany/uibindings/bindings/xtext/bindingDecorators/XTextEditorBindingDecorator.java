package com.rcpcompany.uibindings.bindings.xtext.bindingDecorators;

import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.SyntaxError;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.EcoreExtUtils;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.bindingMessages.AbstractBindingMessage;
import com.rcpcompany.uibindings.bindings.xtext.IUIBXTextBindingContext;
import com.rcpcompany.uibindings.bindings.xtext.UIBXTextContants;
import com.rcpcompany.uibindings.bindings.xtext.internal.uiAttributes.EditorAttribute;
import com.rcpcompany.uibindings.bindings.xtext.internal.xtext.EmbeddedXtextEditorModule;
import com.rcpcompany.uibindings.bindings.xtext.xtext.EmbeddedXtextEditor;
import com.rcpcompany.uibindings.decorators.BaseUIBindingDecorator;
import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.moao.IMOAOFacet;
import com.rcpcompany.uibindings.moao.IMOAOMessage;
import com.rcpcompany.uibindings.moao.Severity;
import com.rcpcompany.uibindings.moao.internal.MOAOMessageImpl;
import com.rcpcompany.utils.logging.LogUtils;

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

	/**
	 * An {@link IObservableValue} that should be updated with the AST of the current content of the editor.
	 * <p>
	 * Can be <code>null</code>.
	 */
	private IObservableValue myASTOV;

	/**
	 * Any messages from the editor
	 */
	private final IObservableList myMessages = WritableList.withElementType(IBindingMessage.class);
	private IBindingMessage mySyntaxErrorMessage;
	private IMOAOFacet mySyntaxErrorFacet;

	@Override
	public void init(IValueBinding binding) {
		Assert.isNotNull(binding);
		setBinding(binding);
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

		final IUIBXTextBindingContext context = new IUIBXTextBindingContext() {
			@Override
			public IValueBinding getBinding() {
				return XTextEditorBindingDecorator.this.getBinding();
			}

			@Override
			public IObservableValue getModelOV() {
				return getBinding().getModelObservableValue();
			}

			@Override
			public EObject getModelObject() {
				return getBinding().getModelObject();
			}
		};
		/*
		 * Based on the supplied module, create the needed injector
		 */
		final Module m = b.getArgument(UIBXTextContants.ARG_XTEXT_INJECTOR_MODULE, Module.class, null);
		b.assertTrue(m != null, "XText Decoratoe requires an injector");
		// m = Modules.override(m).with(new EmbeddedXtextEditorOverrideModule());
		myInjector = Guice.createInjector(new EmbeddedXtextEditorModule(context), m);

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

		/*
		 * Decorate the binding...
		 */
		super.decorate();

		/*
		 * Connect to any AST obserable
		 */
		myASTOV = getBinding().getArgument(UIBXTextContants.ARG_XTEXT_AST_OV, IObservableValue.class, null);

		/*
		 * Update the state and make sure the state is updated whenever the model changes.
		 */
		final IXtextDocument document = myEditor.getDocument();
		document.addModelListener(new IXtextModelListener() {
			@Override
			public void modelChanged(XtextResource resource) {
				updateState();
			}
		});
		updateState();
	}

	@Override
	public IObservableList getMessages() {
		return myMessages;
	}

	/**
	 * Updates the state for the binding based on the editor parse result.
	 * <p>
	 * This includes:
	 * <ul>
	 * <li>{@link #myASTOV} from the AST if needed</li>
	 * <li>errors if relevant</li>
	 * </ul>
	 */
	protected void updateState() {
		final XtextResource resource = myEditor.getResource();
		final IParseResult pr = resource.getParseResult();
		final List<SyntaxError> errors = pr.getParseErrors();

		myMessages.getRealm().exec(new Runnable() {
			@Override
			public void run() {
				if (errors != null && errors.size() > 0) {
					LogUtils.debug(this, "errors: " + errors);
					/*
					 * Gate the errors to Messages...
					 * 
					 * TODO
					 */
					if (mySyntaxErrorMessage == null) {
						mySyntaxErrorMessage = new Message();
					}
					if (!myMessages.contains(mySyntaxErrorMessage)) {
						myMessages.add(mySyntaxErrorMessage);
					}

					/*
					 * Short term solution: if the module object is IMOAO, then add a facet...
					 */
					final EObject modelObject = getBinding().getModelObject();
					if (modelObject instanceof IMOAO) {
						final IMOAO mo = (IMOAO) modelObject;
						if (mySyntaxErrorFacet == null) {
							mySyntaxErrorFacet = new ErrorFacet();
						}

						mySyntaxErrorFacet.setObject(mo);
					}
					return;
				}
				myMessages.clear();
				if (mySyntaxErrorFacet != null) {
					mySyntaxErrorFacet.setObject(null);
				}
			}
		});

		if (myASTOV != null) {
			final EObject newValue = pr.getRootASTElement();
			myASTOV.getRealm().exec(new Runnable() {
				@Override
				public void run() {
					if (newValue == null) {
						myASTOV.setValue(null);
					} else {
						EObject oldValue = (EObject) myASTOV.getValue();
						if (oldValue != null && oldValue.eClass() != newValue.eClass()) {
							oldValue = null;
						}
						if (oldValue == null) {
							oldValue = EcoreUtil.create(newValue.eClass());
						}
						/*
						 * Sync before we set the values. This way the initial sync will only result in a single set
						 * operation.
						 */
						EcoreExtUtils.sync(oldValue, EcoreUtil.copy(newValue));
						myASTOV.setValue(oldValue);
					}
				}
			});
		}
	}

	@Override
	public IObservableList getValidUIList() {
		/*
		 * No list possible here
		 */
		return null;
	}

	/**
	 * Message used to signal syntaxt errors.
	 * 
	 * @author Tonny Madsen, The RCP Company
	 */
	public class Message extends AbstractBindingMessage {
		protected Message() {
			super(XTextEditorBindingDecorator.this.getBinding(), XTextEditorBindingDecorator.this.getBinding()
					.getModelObject(), XTextEditorBindingDecorator.this.getBinding().getModelFeature());
		}

		@Override
		public String getMessage() {
			return "Syntax error";
		}

		@Override
		public BindingMessageSeverity getSeverity() {
			return BindingMessageSeverity.ERROR;
		}

		@Override
		public String getSource() {
			return IUIBindingsPackage.eNS_URI;
		}

		@Override
		public int getCode() {
			return -1;
		}
	}

	public class ErrorFacet extends MOAOMessageImpl implements IMOAOMessage {
		protected ErrorFacet() {
			setDescription("Syntax error");
			setSeverity(Severity.ERROR);
			setFeature(getBinding().getModelFeature());
		}
	}
}
