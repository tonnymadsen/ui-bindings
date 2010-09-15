package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.TextObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;
import com.rcpcompany.uibindings.widgets.FileNameControl;

/**
 * Default {@link IUIAttributeFactory} for {@link FileNameControl} controls.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FileNameControlDefaultUIAttributeFactory implements IUIAttributeFactory {

	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new Attribute(widget, attribute);
	}

	private static class Attribute extends SimpleUIAttribute {
		private final IControlContentAdapter myAdapter;

		public Attribute(Widget widget, String attribute) {
			super(widget, attribute, new TextObservableValue(((FileNameControl) widget).getTextControl(),
					(FileNameControl) widget), true);

			myAdapter = new TextContentAdapter();
		}

		@Override
		public IControlContentAdapter getFieldAssistAdapter() {
			return myAdapter;
		}

		@Override
		public Control getFieldAssistControl() {
			return ((FileNameControl) getWidget()).getTextControl();
		}
	}
}
