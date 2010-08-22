package com.rcpcompany.uibindings.uiAttributes;

import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.internal.UIAttributeImpl;

/**
 * Abstract base class for all {@link IUIAttribute} implementations. Used to isolate the concreate
 * implementations from trivial changes in the interface.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public abstract class AbstractUIAttribute extends UIAttributeImpl {

	@Override
	public abstract Widget getWidget();

	@Override
	public abstract IObservableValue getCurrentValue();

	@Override
	public Cursor getCursor() {
		final IObservableValue value = getFontValue();
		if (value == null) return null;
		return (Cursor) value.getValue();
	}

	@Override
	public IObservableList getPossibleValuesList() {
		return null;
	}

	@Override
	public IObservableList getStyleRangeList() {
		return null;
	}

	@Override
	public List<StyleRange> getStyleRanges() {
		final IObservableList list = getStyleRangeList();
		if (list == null) return null;
		return list;
	}

	@Override
	public IObservableValue getMaxValue() {
		return null;
	}

	@Override
	public IObservableValue getMinValue() {
		return null;
	}

	@Override
	public IObservableValue getTooltipValue() {
		return null;
	}

	@Override
	public IControlContentAdapter getFieldAssistAdapter() {
		return null;
	}

	@Override
	public IObservableValue getFontValue() {
		return null;
	}

	@Override
	public Font getFont() {
		final IObservableValue value = getFontValue();
		if (value == null) return null;
		return (Font) value.getValue();
	}

	@Override
	public IObservableValue getForegroundValue() {
		return null;
	}

	@Override
	public Color getForeground() {
		final IObservableValue value = getForegroundValue();
		if (value == null) return null;
		return (Color) value.getValue();
	}

	@Override
	public IObservableValue getBackgroundValue() {
		return null;
	}

	@Override
	public Color getBackground() {
		final IObservableValue value = getBackgroundValue();
		if (value == null) return null;
		return (Color) value.getValue();
	}

	@Override
	public IObservableValue getEnabledValue() {
		return null;
	}

	@Override
	public Boolean isEnabled() {
		final IObservableValue value = getEnabledValue();
		if (value == null) return null;
		return (Boolean) value.getValue();
	}
}
