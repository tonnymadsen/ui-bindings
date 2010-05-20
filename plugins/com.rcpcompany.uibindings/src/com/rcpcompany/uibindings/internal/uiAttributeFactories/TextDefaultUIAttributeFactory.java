package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.ControlCursorObservableValue;
import com.rcpcompany.uibindings.internal.observables.TextObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

public class TextDefaultUIAttributeFactory implements IUIAttributeFactory {

	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new Attribute(widget, attribute);
	}

	protected static IObservableValue createValue(Control c, String attribute) {
		if (Constants.ATTR_BACKGROUND.equals(attribute)) {
			return SWTObservables.observeBackground(c);
		} else if (Constants.ATTR_FOREGROUND.equals(attribute)) {
			return SWTObservables.observeForeground(c);
		} else if (Constants.ATTR_FONT.equals(attribute)) {
			return SWTObservables.observeFont(c);
		} else if (Constants.ATTR_ENABLED.equals(attribute)) {
			return SWTObservables.observeEnabled(c);
		} else if (Constants.ATTR_VISIBLE.equals(attribute)) {
			return SWTObservables.observeVisible(c);
		} else if (Constants.ATTR_TOOLTIP.equals(attribute)) {
			return SWTObservables.observeTooltipText(c);
		} else if (Constants.ATTR_CURSOR.equals(attribute)) {
			return new ControlCursorObservableValue(c);
		}
		return null;
	}

	private static class Attribute extends SimpleUIAttribute {
		class ControlUIAttribute extends SimpleUIAttribute {
			public ControlUIAttribute(Widget widget, String attribute) {
				super(widget, attribute, createValue((Control) widget, attribute), true);
			}
		}

		private final IControlContentAdapter myAdapter;

		public Attribute(Widget widget, String attribute) {
			super(widget, attribute, new TextObservableValue((Text) widget), true);

			myAdapter = new TextContentAdapter();
		}

		@Override
		public IControlContentAdapter getFieldAssistAdapter() {
			return myAdapter;
		}
	}
}
