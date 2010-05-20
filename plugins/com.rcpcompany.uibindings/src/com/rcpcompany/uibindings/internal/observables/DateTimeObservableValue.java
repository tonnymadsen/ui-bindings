package com.rcpcompany.uibindings.internal.observables;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.DateTime;

/**
 * 
 */
public class DateTimeObservableValue extends AbstractSWTObservableValue {

	private final DateTime dateTime;

	private boolean updating = false;

	private Date currentDate;

	private SelectionListener selectionListener;

	/**
	 * @param dateTime the widget
	 */
	public DateTimeObservableValue(DateTime dateTime) {
		super(dateTime);
		this.dateTime = dateTime;
		init();
	}

	/**
	 * @param realm the realm
	 * @param dateTime the widget
	 */
	public DateTimeObservableValue(Realm realm, DateTime dateTime) {
		super(realm, dateTime);
		this.dateTime = dateTime;
		init();
	}

	private void init() {
		currentDate = (Date) doGetValue();
		selectionListener = new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				if (!updating) {
					final Date d = (Date) doGetValue();
					notifyIfChanged(currentDate, d);
					currentDate = d;
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		dateTime.addSelectionListener(selectionListener);
	}

	@Override
	public void doSetValue(final Object value) {
		final Date newValue = (Date) value;
		final Calendar c = Calendar.getInstance();
		try {
			updating = true;
			if (newValue != null) {
				c.setTime(newValue);
				dateTime.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
				dateTime.setTime(c.get(Calendar.HOUR), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
			}
			final Date n = (Date) doGetValue();
			notifyIfChanged(currentDate, n);
			currentDate = n;
		} finally {
			updating = false;
		}
	}

	@Override
	public Object doGetValue() {
		final Calendar c = Calendar.getInstance();
		c.clear();
		c.set(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay());
		c.set(Calendar.HOUR, dateTime.getHours());
		c.set(Calendar.MINUTE, dateTime.getMinutes());
		c.set(Calendar.SECOND, dateTime.getSeconds());
		return c.getTime();
	}

	public Object getValueType() {
		return Date.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue #dispose()
	 */
	@Override
	public synchronized void dispose() {
		super.dispose();
		if (selectionListener != null && !dateTime.isDisposed()) {
			dateTime.removeSelectionListener(selectionListener);
		}
	}

	private void notifyIfChanged(Date oldValue, Date newValue) {
		if (!oldValue.equals(newValue)) {
			fireValueChange(Diffs.createValueDiff(oldValue, newValue));
		}
	}
}
