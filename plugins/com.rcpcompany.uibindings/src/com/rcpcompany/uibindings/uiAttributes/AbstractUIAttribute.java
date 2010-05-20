package com.rcpcompany.uibindings.uiAttributes;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.internal.UIAttributeImpl;

/**
 * Abstract base class for all {@link IUIAttribute} implementations. Used to isolate the concreate implementations from
 * trivial changes in the interface.
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
	public IObservableList getPossibleValuesList() {
		return null;
	}

	@Override
	public IObservableList getStyleRangeList() {
		return null;
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
	public IObservableValue getForegroundValue() {
		return null;
	}

	@Override
	public IObservableValue getBackgroundValue() {
		return null;
	}

	@Override
	public IObservableValue getEnabledValue() {
		return null;
	}
}
