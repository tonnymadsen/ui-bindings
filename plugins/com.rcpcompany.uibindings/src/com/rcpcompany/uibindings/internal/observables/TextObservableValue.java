package com.rcpcompany.uibindings.internal.observables;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.util.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.utils.basic.ToStringUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * {@link IObservableValue} for a number of widgets: {@link Text}, {@link StyledText}, {@link Combo}
 * and {@link CCombo}.
 * <p>
 * It handles all the possible change strategies as defined in
 * {@link IBindingContext#getTextCommitStrategyCalculated()} .
 * <p>
 * Loosely based on classes from the data binding framework.
 */
public class TextObservableValue extends AbstractSWTObservableValue implements IUpdatableObservable,
		IDelayedChangeObservable {

	/**
	 * The observed widget.
	 */
	protected final Control myControl;

	/**
	 * The adapter for the widget.
	 */
	protected final ControlAdapter myAdapter;

	/**
	 * <code>true</code> while the widget is updated via {@link #setValue(Object)}. Used to prevent
	 * reporting the changes.
	 */
	protected boolean updating = false;

	/**
	 * The last value reported via a change event - also used for ESCAPE
	 */
	protected String myOldValue;

	/**
	 * <code>true</code> if this observable will use ENTER to force the value.
	 */
	protected boolean myHandleENTER;

	/**
	 * The expect value of the text widget at the next modify event - if non-<code>null</code>.
	 * <p>
	 * Used to work around a problem with changes to Text(MULTI) widgets:
	 * <ul>
	 * <li>set text to "a"</li>
	 * <li>select text</li>
	 * <li>enter "b"</li>
	 * </ul>
	 * This results in two modify events: "a" to "" and "" to "b". Though only one verify event...
	 * <p>
	 * Also see <a href="http://jira.marintek.sintef.no/jira/browse/SIMA-623">SIMA-623: Text widget
	 * with Focus out commit strategy, seems to commit early.</a>
	 */
	protected String myNextModifyValue = null;

	private final Listener myControlListener = new Listener() {
		@Override
		public void handleEvent(Event event) {
			LogUtils.debug(this, "Text='" + myAdapter.getText(myControl) + "'\n" + ToStringUtils.toString(event));
			if (updating) return;

			/*
			 * Special handling for some of the event types
			 */
			switch (event.type) {
			case SWT.KeyDown:
				/*
				 * Handle ENTER and ESCAPE
				 */
				switch (event.keyCode) {
				case SWT.CR:
					if (myHandleENTER) {
						forceUpdateValue();
						/*
						 * Cannot eat the keydown as it is also used when the binding is put into a
						 * cell of a viewer // event.doit = false;
						 */
					}
					break;
				case SWT.ESC:
					doSetValue(myOldValue);
					break;
				default:
					break;
				}
				return;
			case SWT.Verify:
				/*
				 * Predict the new value
				 */
				final String v = myAdapter.getText(myControl);
				myNextModifyValue = v.substring(0, event.start) + event.text + v.substring(event.end);
				return;
			case SWT.Modify:
				if (myNextModifyValue != null && !myAdapter.getText(myControl).equals(myNextModifyValue)) /*
																										 * See
																										 * comment
																										 * for
																										 * myNextModifyValue
																										 * .
																										 */
				return;
				myNextModifyValue = null;
				break;
			case SWT.FocusOut:
				forceUpdateValue();
				break;
			case SWT.Selection:
				forceUpdateValue();
				break;
			default:
				break;
			}

			/*
			 * Handling of the different strategies
			 */
			switch (myStrategy) {
			case ON_MODIFY:
				if (event.type != SWT.Modify) return;
				break;
			case ON_FOCUS_OUT:
				// if (event.type != SWT.FocusOut)
				// return;
				break;
			case ON_MODIFY_DELAY:
				if (event.type != SWT.Modify) return;
				break;
			default:
				LogUtils.error(this, "Unknown strategy " + myStrategy);
			}

			updateValue(event.type == SWT.Modify, false);
		}
	};

	/**
	 * The binding context of this observable...
	 */
	protected IBindingContext myContext;

	/**
	 * The current strategy of the observable.
	 */
	protected TextCommitStrategy myStrategy;

	/**
	 * Used to suppress the events provoked by strategy changes.
	 */
	protected boolean mySuppressStrategyChanges = false;

	/**
	 * <code>true</code> when stale has been fired.
	 */
	private boolean isStale = false;

	private final boolean myHandleSelection;

	@Override
	public boolean isStale() {
		super.isStale();
		return isStale;
	}

	/**
	 * Returns the current strategy of the observable.
	 * 
	 * @return the strategy
	 */
	public TextCommitStrategy getStrategy() {
		return myStrategy;
	}

	/**
	 * Sets the wanted strategy of the observable.
	 * 
	 * @param strategy the strategy
	 */
	public void setStrategy(TextCommitStrategy strategy) {
		myStrategy = strategy;
		if (!mySuppressStrategyChanges) {
			forceUpdateValue();
		}
	}

	/**
	 * Constructs and returns a new observable for the control. Private!
	 * 
	 * @param realm the wanted realm or <code>null</code>
	 * @param control the control in question
	 * @param adapter adapter for the control
	 * @param handleENTER whether ENTER is handled
	 * @param handleSelection TODO
	 */
	private TextObservableValue(final Realm realm, Control control, ControlAdapter adapter, boolean handleENTER,
			boolean handleSelection) {
		super(realm, control);

		myControl = control;
		myAdapter = adapter;
		myOldValue = adapter.getText(control);
		myHandleENTER = handleENTER;
		myHandleSelection = handleSelection;
	}

	/**
	 * Constructs and returns a new observable for the Text widget.
	 * 
	 * @param text the Text widget
	 */
	public TextObservableValue(final Text text) {
		this(SWTObservables.getRealm(text.getDisplay()), text);
	}

	/**
	 * Constructs and returns a new observable for the {@link Text} widget.
	 * 
	 * @param realm the wanted realm or <code>null</code>
	 * @param text the Text widget
	 */
	public TextObservableValue(final Realm realm, Text text) {
		this(realm, text, TEXT_ADAPTER, (text.getStyle() & SWT.SINGLE) == SWT.SINGLE, false);
	}

	/**
	 * Constructs and returns a new observable for the StyledText widget.
	 * 
	 * @param text the StyledText widget
	 */
	public TextObservableValue(final StyledText text) {
		this(SWTObservables.getRealm(text.getDisplay()), text);
	}

	/**
	 * Constructs and returns a new observable for the {@link StyledText} widget.
	 * 
	 * @param realm the wanted realm or <code>null</code>
	 * @param text the Text widget
	 */
	public TextObservableValue(final Realm realm, StyledText text) {
		this(realm, text, STYLEDTEXT_ADAPTER, false, false);
	}

	/**
	 * Constructs and returns a new observable for the Combo widget.
	 * 
	 * @param combo the Combo widget
	 */
	public TextObservableValue(final Combo combo) {
		this(SWTObservables.getRealm(combo.getDisplay()), combo);
	}

	/**
	 * Constructs and returns a new observable for the {@link Combo} widget.
	 * 
	 * @param realm the wanted realm or <code>null</code>
	 * @param combo the Text widget
	 */
	public TextObservableValue(final Realm realm, Combo combo) {
		this(realm, combo, COMBO_ADAPTER, true, true);
	}

	/**
	 * Constructs and returns a new observable for the CCombo widget.
	 * 
	 * @param combo the CCombo widget
	 */
	public TextObservableValue(final CCombo combo) {
		this(SWTObservables.getRealm(combo.getDisplay()), combo);
	}

	/**
	 * Constructs and returns a new observable for the {@link CCombo} widget.
	 * 
	 * @param realm the wanted realm or <code>null</code>
	 * @param combo the Text widget
	 */
	public TextObservableValue(final Realm realm, CCombo combo) {
		this(realm, combo, CCOMBO_ADAPTER, true, true);
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
		try {
			mySuppressStrategyChanges = true;
			super.firstListenerAdded();

			final IBinding binding = IBindingContext.Factory.getBindingForWidget(myControl);
			if (binding != null) {
				myContext = binding.getContext();
				setStrategy(myContext.getTextCommitStrategyCalculated());
				myContext.eAdapters().add(myStrategyListener);
			} else {
				setStrategy(IManager.Factory.getManager().getTextCommitStrategy());
				IManager.Factory.getManager().eAdapters().add(myStrategyListener);
			}

			myControl.addListener(SWT.FocusOut, myControlListener);
			myControl.addListener(SWT.Modify, myControlListener);
			myControl.addListener(SWT.KeyDown, myControlListener);
			myControl.addListener(SWT.Verify, myControlListener);
			myControl.addListener(SWT.FocusOut, myControlListener);
			if (myHandleSelection) {
				myControl.addListener(SWT.Selection, myControlListener);
			}

			// LogUtils.debug(this, "" + hashCode());
		} finally {
			mySuppressStrategyChanges = false;
		}
	}

	@Override
	protected void lastListenerRemoved() {
		super.lastListenerRemoved();
		if (!myControl.isDisposed()) {
			myControl.removeListener(SWT.FocusOut, myControlListener);
			myControl.removeListener(SWT.Modify, myControlListener);
			myControl.removeListener(SWT.KeyDown, myControlListener);
			myControl.removeListener(SWT.Verify, myControlListener);
			myControl.removeListener(SWT.FocusOut, myControlListener);
			if (myHandleSelection) {
				myControl.removeListener(SWT.Selection, myControlListener);
			}
		}

		if (myContext != null) {
			myContext.eAdapters().remove(myStrategyListener);
		} else {
			IManager.Factory.getManager().eAdapters().remove(myStrategyListener);
		}

		// LogUtils.debug(this, "" + hashCode());
	}

	@Override
	public Object doGetValue() {
		return myAdapter.getText(myControl);
	}

	@Override
	public Object getValueType() {
		return String.class;
	}

	private ValueUpdater myUpdater = null;

	/**
	 * Updates the value of this observable.
	 * 
	 * @param isModify the value is updated because of a modify event
	 * @param force the update is immediately - i.e. it is not delayed
	 */
	protected void updateValue(boolean isModify, boolean force) {
		final String newValue = myAdapter.getText(myControl);

		cancelScheduledUpdate(); // if any

		if (isModify && myStrategy != TextCommitStrategy.ON_MODIFY && !force) {
			fireDelayedChange();

			if (!isStale) {
				isStale = true;
				fireStale();
			}

			scheduleUpdate();
			return;
		}

		if (!Util.equals(myOldValue, newValue)) {
			isStale = false;
			fireValueChange(Diffs.createValueDiff(myOldValue, myOldValue = newValue));
		}
	}

	@Override
	protected void doSetValue(Object value) {
		updating = true;
		try {
			// Principle of least surprise: setValue overrides any pending
			// update from observable.
			isStale = false;
			cancelScheduledUpdate();

			if (value == null) {
				value = "";
			}
			myAdapter.setText(myControl, value.toString());

			if (!Util.equals(myOldValue, value)) {
				fireValueChange(Diffs.createValueDiff(myOldValue, value));
				myOldValue = value.toString();
			}
		} finally {
			updating = false;
		}
	}

	@Override
	public void forceUpdateValue() {
		updateValue(false, true);
	}

	/**
	 * Schedules a delayed update of this observable.
	 */
	protected void scheduleUpdate() {
		if (myStrategy != TextCommitStrategy.ON_MODIFY_DELAY) return;
		myUpdater = new ValueUpdater();
		myControl.getDisplay().timerExec(IManager.Factory.getManager().getTextCommitStrategyDelay(), myUpdater);
	}

	/**
	 * Cancels an already scheduled update of this observable - if any.
	 */
	protected void cancelScheduledUpdate() {
		if (myUpdater != null) {
			myUpdater.cancel();
			myUpdater = null;
		}
	}

	/**
	 * Private class used to force an delayed update.
	 */
	protected class ValueUpdater implements Runnable {
		private boolean cancel = false;

		void cancel() {
			cancel = true;
		}

		@Override
		public void run() {
			if (isDisposed()) return;
			if (!cancel) {
				forceUpdateValue();
			}
		}
	}

	/**
	 * Adapter for the preferences that forces an update of the current value.
	 */
	private final Adapter myStrategyListener = new AdapterImpl() {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) return;
			if (msg.getFeature() == IUIBindingsPackage.Literals.BINDING_CONTEXT__TEXT_COMMIT_STRATEGY_CALCULATED) {
				setStrategy(myContext.getTextCommitStrategyCalculated());
			}
			if (msg.getFeature() == IUIBindingsPackage.Literals.MANAGER__TEXT_COMMIT_STRATEGY) {
				setStrategy(IManager.Factory.getManager().getTextCommitStrategy());
			}
		}
	};

	@Override
	public void addDelayedChangeListener(IDelayedChangeListener listener) {
		addListener(DelayedChangeEvent.TYPE, listener);
	}

	@Override
	public void removeDelayedChangeListener(IDelayedChangeListener listener) {
		removeListener(DelayedChangeEvent.TYPE, listener);
	}

	/**
	 * Fires a {@link DelayedChangeEvent} to all {@link IDelayedChangeListener relevant listeners}.
	 */
	protected void fireDelayedChange() {
		checkRealm();
		fireEvent(new DelayedChangeEvent(this));
	}

	/**
	 * Interface used to iron out differences between supported widget types.
	 */
	protected interface ControlAdapter {
		/**
		 * Returns the text of the widget.
		 * 
		 * @param w the widget
		 * @return the current text
		 */
		String getText(Control w);

		/**
		 * Sets the text of the widget.
		 * 
		 * @param w the widget
		 * @param newText the new text
		 */
		void setText(Control w, String newText);
	}

	/**
	 * Access methods for {@link Text} widgets.
	 */
	protected static final ControlAdapter TEXT_ADAPTER = new ControlAdapter() {
		@Override
		public String getText(Control w) {
			return ((Text) w).getText();
		}

		@Override
		public void setText(Control w, String newText) {
			((Text) w).setText(newText);
		}
	};

	/**
	 * Access methods for {@link StyledText} widgets.
	 */
	protected static final ControlAdapter STYLEDTEXT_ADAPTER = new ControlAdapter() {
		@Override
		public String getText(Control w) {
			return ((StyledText) w).getText();
		}

		@Override
		public void setText(Control w, String newText) {
			((StyledText) w).setText(newText);
		}
	};

	/**
	 * Access methods for {@link Combo} widgets.
	 */
	protected static final ControlAdapter COMBO_ADAPTER = new ControlAdapter() {
		@Override
		public String getText(Control w) {
			return ((Combo) w).getText();
		}

		@Override
		public void setText(Control w, String newText) {
			((Combo) w).setText(newText);
		}
	};

	/**
	 * Access methods for {@link CCombo} widgets.
	 */
	protected static final ControlAdapter CCOMBO_ADAPTER = new ControlAdapter() {
		@Override
		public String getText(Control w) {
			return ((CCombo) w).getText();
		}

		@Override
		public void setText(Control w, String newText) {
			((CCombo) w).setText(newText);
		}
	};
}
