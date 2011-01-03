package com.rcpcompany.uibindings.debug.internals.views;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.debug.IDebugFactory;
import com.rcpcompany.uibindings.debug.IDebugPackage;
import com.rcpcompany.uibindings.debug.IScriptConsoleContext;
import com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor;
import com.rcpcompany.uibindings.scripting.IScriptEvaluationContext;
import com.rcpcompany.uibindings.scripting.IScriptExpression;
import com.rcpcompany.uibindings.scripting.IScriptManager;
import com.rcpcompany.uibindings.scripting.ScriptEngineException;
import com.rcpcompany.uibindings.utils.IFormChooser;
import com.rcpcompany.uibindings.utils.IFormChooserCreator;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.SelectionUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Simple Script Console.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ScriptConsole extends ViewPart {
	private IFormCreator myForm;
	private final IScriptConsoleContext myData;
	protected IValueBinding myScriptBinding;

	private final EditingDomain myEditingDomain;

	public ScriptConsole() {
		myData = IDebugFactory.eINSTANCE.createScriptConsoleContext();
		myData.eAdapters().add(myAdapter);

		myEditingDomain = UIBindingsUtils.createEditingDomain();
	}

	@Override
	public void dispose() {
		final ISelectionService ss = getSite().getPage().getWorkbenchWindow().getSelectionService();
		ss.removePostSelectionListener(mySelectionListener);

		final IScriptExpression e = myData.getExpression();
		if (e != null) {
			e.dispose();
			myData.setExpression(null);
		}
		myData.eAdapters().remove(myAdapter);

		super.dispose();
	}

	private final Adapter myAdapter = new AdapterImpl() {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) return;

			if (msg.getNotifier() == myData) {
				if (msg.getFeature() == IDebugPackage.Literals.SCRIPT_CONSOLE_CONTEXT__LANGUAGE
						|| msg.getFeature() == IDebugPackage.Literals.SCRIPT_CONSOLE_CONTEXT__OBJECT
						|| msg.getFeature() == IDebugPackage.Literals.SCRIPT_CONSOLE_CONTEXT__SCRIPT) {
					updateExpression();
				}
			}
			if (msg.getNotifier() instanceof IScriptExpression) {
				updateResult();
			}
		};
	};

	private final ISelectionListener mySelectionListener = new ISelectionListener() {
		@Override
		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			final List<EObject> s = SelectionUtils.computeSelection(selection, EObject.class);
			if (s == null || s.size() != 1) return;

			myData.setObject(s.get(0));
		}
	};

	@Override
	public void createPartControl(Composite parent) {
		myForm = IFormCreator.Factory.createScrolledForm(myData, parent, "Script");
		/*
		 * We have our own editing domain....
		 */
		myForm.getContext().setEditingDomain(myEditingDomain);

		final StyledText output = new StyledText(myForm.addComposite(true, true), SWT.V_SCROLL | SWT.H_SCROLL);
		output.setText("");

		myForm.addField("object(readonly,type=qualifiedName)");
		final IValueBinding languageBinding = myForm.addField("language");

		final IFormChooser languageChooser = myForm.addFormChooser(languageBinding);

		final Collection<IScriptEngineDescriptor> engines = IScriptManager.Factory.getManager().getEngines().values();
		for (final IScriptEngineDescriptor l : engines) {
			languageChooser.addFormValue(l.getLanguage(), new IFormChooserCreator() {
				@Override
				public void createForm(IBindingContext context, IObservableValue discriminant, Composite parent) {
					final IFormCreator subForm = myForm.subForm(parent);
					myScriptBinding = subForm.addField("script").type("script-" + l.getLanguage());
					myForm.finish();
					myForm.getTop().layout();
					myScriptBinding.setFocus();
				}
			});
		}

		myForm.addField("result(readonly)");
		myForm.addField("exception(readonly)");
		myForm.finish();

		final ISelectionService ss = getSite().getPage().getWorkbenchWindow().getSelectionService();
		ss.addPostSelectionListener(mySelectionListener);
	}

	/**
	 * Updates the language and expression of the facet based on the script
	 */
	protected void updateExpression() {
		IScriptExpression e = myData.getExpression();
		if (e != null && (e.getEngine() == null || !e.getEngine().getLanguage().equals(myData.getLanguage()))) {
			e.dispose();
			e.eAdapters().remove(myAdapter);
			myData.setExpression(null);
			e = null;
		}
		final EObject object = myData.getObject();
		if (e == null) {
			/*
			 * Need the language first
			 */
			if (myData.getLanguage() == null) return;

			final IScriptManager manager = IScriptManager.Factory.getManager();
			try {

				final IScriptEvaluationContext context = manager.getRegisteredEvaluationContext(object);
				final Map<String, Object> locals = new HashMap<String, Object>();
				locals.put("SELECTION", object);

				e = manager.addScript(myData.getLanguage(), myData.getScript(), String.class, context, locals);
				e.eAdapters().add(myAdapter);
				myData.setExpression(e);
			} catch (final ScriptEngineException ex) {
				LogUtils.error(this, ex);
				myData.setException(ex.getMessage());
				myData.setResult("");
				return;
			}
		} else if (!UIBindingsUtils.equals(e.getScript(), myData.getScript())) {
			e.setScript(myData.getScript());
		} else if (!UIBindingsUtils.equals(e.getEvaluationContext().getVariables().get("SELECTION"), object)) {
			e.getEvaluationContext().getVariables().put("SELECTION", object);
		}
		// e.evaluate();
	}

	/**
	 * Updates the results part of the view.
	 */
	protected void updateResult() {
		final IScriptExpression e = myData.getExpression();
		if (e == null) {
			myData.setException("");
			myData.setResult("");
			return;
		}
		myData.setException(e.getErrorMessage());
		myData.setResult("" + e.getCurrentValue());
	}

	@Override
	public void setFocus() {
		myForm.setFocus();
	}
}
