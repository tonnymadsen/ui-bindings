package com.rcpcompany.uibindings.internal.observables;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.util.Util;
import org.eclipse.nebula.widgets.radiogroup.RadioGroup;
import org.eclipse.nebula.widgets.radiogroup.RadioItem;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

/**
 * {@link IObservableValue} for the current value of a {@link RadioGroup}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class RadioGroupValueObservableValue extends AbstractSWTObservableValue {

	private final RadioGroup myRadioGroup;
	private SelectionListener mySelectionListener = null;
	private Object myCurrentValue;

	public RadioGroupValueObservableValue(RadioGroup widget) {
		super(widget);
		myRadioGroup = widget;

		myCurrentValue = doGetValue();
	}

	@Override
	protected void firstListenerAdded() {
		if (mySelectionListener == null) {
			mySelectionListener = new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					/*
					 * A RadioGroup issues two selection events when a new item is selected:
					 * old->null and then null->new.
					 * 
					 * We silently ignore events that switch to "null"...
					 */
					if (e.item == null) return;
					handleSelectionChanged();
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
				}
			};
		}
		myRadioGroup.addSelectionListener(mySelectionListener);
		super.firstListenerAdded();
	}

	@Override
	protected void lastListenerRemoved() {
		myRadioGroup.removeSelectionListener(mySelectionListener);
		super.lastListenerRemoved();
	}

	@Override
	public synchronized void dispose() {
		if (hasListeners()) {
			lastListenerRemoved();
		}
		super.dispose();
	}

	@Override
	protected Object doGetValue() {
		final RadioItem selection = myRadioGroup.getSelection();
		if (selection == null) return null;
		return selection.getText();
	}

	@Override
	protected void doSetValue(Object value) {
		for (final RadioItem i : myRadioGroup.getItems()) {
			if (i.getText().equals(value)) {
				myRadioGroup.setSelection(i);
				return;
			}
		}
	}

	@Override
	public Object getValueType() {
		return String.class;
	}

	/**
	 * Selection changed...
	 */
	protected void handleSelectionChanged() {
		final Object newValue = doGetValue();
		if (Util.equals(myCurrentValue, newValue)) return;
		fireValueChange(Diffs.createValueDiff(myCurrentValue, myCurrentValue = newValue));
	}
}
