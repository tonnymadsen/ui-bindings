package com.rcpcompany.uibindings.bindings.xtext.observables;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;

import com.rcpcompany.uibindings.model.utils.BasicUtils;

/**
 * {@link IObservableValue} for {@link IDocument}.
 * <p>
 * TODO Handle re-write sessions better.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DocumentObservableValue extends AbstractObservableValue {

	private final IDocument myDocument;
	private IDocumentListener myDocumentListener = null;

	public DocumentObservableValue(IDocument document) {
		myDocument = document;
	}

	@Override
	public synchronized void dispose() {
		if (hasListeners()) {
			lastListenerRemoved();
		}
		super.dispose();
	}

	@Override
	protected void firstListenerAdded() {
		myDocumentListener = new IDocumentListener() {
			private String oldValue = null;

			@Override
			public void documentAboutToBeChanged(DocumentEvent event) {
				oldValue = myDocument.get();
			}

			@Override
			public void documentChanged(DocumentEvent event) {
				fireValueChange(Diffs.createValueDiff(oldValue, myDocument.get()));
			}
		};
		myDocument.addDocumentListener(myDocumentListener);
	}

	@Override
	protected void lastListenerRemoved() {
		if (myDocumentListener != null) {
			myDocument.removeDocumentListener(myDocumentListener);
		}
	}

	@Override
	public Object getValueType() {
		return EcorePackage.Literals.ESTRING;
	}

	@Override
	protected Object doGetValue() {
		return myDocument.get();
	}

	@Override
	protected void doSetValue(Object value) {
		final String s;
		if (value == null) {
			s = "";
		} else {
			s = value.toString();
		}
		if (BasicUtils.equals(s, doGetValue()))
			return;
		myDocument.set(s);
	}
}
