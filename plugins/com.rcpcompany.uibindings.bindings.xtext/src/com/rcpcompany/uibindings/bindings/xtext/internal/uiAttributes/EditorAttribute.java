package com.rcpcompany.uibindings.bindings.xtext.internal.uiAttributes;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.swt.custom.StyledText;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.bindings.xtext.observables.DocumentObservableValue;
import com.rcpcompany.uibindings.bindings.xtext.xtext.EmbeddedXtextEditor;
import com.rcpcompany.uibindings.observables.StyledTextRangesObservableList;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

/**
 * Special {@link IUIAttribute} used for the editor of the editor itself...
 * 
 * @auther Tonny Madsen, The RCP Company
 */
public class EditorAttribute extends SimpleUIAttribute {
	public EditorAttribute(EmbeddedXtextEditor editor) {
		super(editor.getControl(), "", new DocumentObservableValue(editor.getDocument()), true);
	}

	@Override
	public IObservableList getStyleRangeList() {
		final StyledText c = (StyledText) getWidget();
		return addObservable(new StyledTextRangesObservableList(c));
	}
}
