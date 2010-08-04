package com.rcpcompany.uibindings.extests.observables;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.internal.observables.DelayedChangeEvent;
import com.rcpcompany.uibindings.internal.observables.IDelayedChangeListener;
import com.rcpcompany.uibindings.internal.observables.TextObservableValue;

/**
 * Tests the {@link TextObservableValue} behaves.
 * 
 * Do all tests for both single and multi line Texts.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
@RunWith(Parameterized.class)
public class TextObservableValueTest<X extends Control> {
	private static final int DELAY = 1000;
	final IManager manager = IManager.Factory.getManager();
	private final int myTextStyle;
	private final Class<X> myCls;
	private final boolean mySingleLine;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

				// Class<X> cls, int style, boolean singleLine

				{ Text.class, SWT.SINGLE, true },

				{ Text.class, SWT.MULTI, false },

				{ StyledText.class, SWT.NONE, false },

				{ Combo.class, SWT.NONE, true },

				{ CCombo.class, SWT.NONE, true },

		});
	}

	public TextObservableValueTest(Class<X> cls, int style, boolean singleLine) {
		myCls = cls;
		myTextStyle = style;
		mySingleLine = singleLine;
	}

	private X w1;
	private TextObservableValue ov1;
	/*
	 * Used for focus out
	 */
	private Text w2;

	public String getText() {
		if (w1 instanceof Text) return ((Text) w1).getText();
		if (w1 instanceof StyledText) return ((StyledText) w1).getText();
		if (w1 instanceof Combo) return ((Combo) w1).getText();
		if (w1 instanceof CCombo) return ((CCombo) w1).getText();
		return null;
	}

	public void setText(String string) {
		if (w1 instanceof Text) {
			((Text) w1).setText(string);
		}
		if (w1 instanceof StyledText) {
			((StyledText) w1).setText(string);
		}
		if (w1 instanceof Combo) {
			((Combo) w1).setText(string);
		}
		if (w1 instanceof CCombo) {
			((CCombo) w1).setText(string);
		}
	}

	public void selectAll() {
		if (w1 instanceof Text) {
			((Text) w1).selectAll();
		}
		if (w1 instanceof StyledText) {
			((StyledText) w1).selectAll();
		}
		if (w1 instanceof Combo) {
			final Combo c = (Combo) w1;
			c.setSelection(new Point(0, c.getText().length()));
		}
		if (w1 instanceof CCombo) {
			final CCombo c = (CCombo) w1;
			c.setSelection(new Point(0, c.getText().length()));
		}
	}

	/**
	 * Executes the specified runnable and monitors whether the specified value change occurs and
	 * whether the value changes.
	 * <p>
	 * <em>NOTE:</em> There are a special case with multi-line Text widgets: when the complete
	 * selected text is changed, it happens in two parts: First the text of the widget is changed to
	 * "" and then it is changed to the new text.
	 * 
	 * @param changeFromValue the from value expect in a change event
	 * @param changeToValue the to value expect in a change event
	 * @param expectDelayChangeEvents <code>true</code> if a {@link DelayedChangeEvent} event is
	 *            expected
	 * @param getValue the expected value of the ov1 after the change
	 * @param change the {@link Runnable} to execute
	 */
	public void performChange(final String changeFromValue, final String changeToValue,
			final boolean expectDelayChangeEvents, String getValue, Runnable change) {

		final boolean[] changeExpected = new boolean[] { !(changeToValue.equals(changeFromValue)) };
		final boolean[] dceExpected = new boolean[] { expectDelayChangeEvents };

		final IValueChangeListener valueListener = new IValueChangeListener() {
			String fromValue = changeFromValue;
			String toValue = changeToValue;

			@Override
			public void handleValueChange(ValueChangeEvent event) {
				// LogUtils.debug(this, "'" + event.diff.getOldValue() + "' -> '" +
				// event.diff.getNewValue() + "'");
				assertTrue("No value change expected", changeExpected[0]);
				assertEquals(fromValue, event.diff.getOldValue());
				if (event.diff.getNewValue().equals("")) {
					fromValue = "";
					return;
				}
				assertEquals(toValue, event.diff.getNewValue());
				changeExpected[0] = false;
			}
		};

		final IDelayedChangeListener dcListener = new IDelayedChangeListener() {
			@Override
			public void handleDelayedChange(DelayedChangeEvent event) {
				// LogUtils.debug(this, "");
				assertTrue("No delayed change expected", dceExpected[0]);
				dceExpected[0] = false;
			}
		};

		try {
			ov1.addValueChangeListener(valueListener);
			ov1.addDelayedChangeListener(dcListener);

			if (change != null) {
				change.run();
			}
			yield();
		} finally {
			ov1.removeValueChangeListener(valueListener);
			ov1.removeDelayedChangeListener(dcListener);
		}

		assertEquals(getValue, ov1.getValue());

		assertEquals(false, changeExpected[0]);
		assertEquals(false, dceExpected[0]);
	}

	@Before
	public void before() {
		w1 = createWidget(myCls, myTextStyle);

		if (w1 instanceof Text) {
			ov1 = new TextObservableValue((Text) w1);
		}
		if (w1 instanceof StyledText) {
			ov1 = new TextObservableValue((StyledText) w1);
		}
		if (w1 instanceof Combo) {
			ov1 = new TextObservableValue((Combo) w1);
		}
		if (w1 instanceof CCombo) {
			ov1 = new TextObservableValue((CCombo) w1);
		}

		w2 = createWidget(Text.class, SWT.None);
	}

	@After
	public void tearDown() {
		ov1.dispose();
		manager.setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		manager.setTextCommitStrategyDelay(400);
	}

	/**
	 * Tests that getDelayedChange and getValue is correct for all strategies for the sequence
	 * <nl>
	 * <li>set iov value to "a" (reset)</li>
	 * <li>set value to "b"</li>
	 * <li>wait DELAY/5</li>
	 * <li>set value to "c"</li>
	 * <li>wait 2*DELAY</li>
	 * <li>focus out</li>
	 * </nl>
	 * 
	 * @param strategy the strategy to test
	 * @param b1 expected value change after setting the value to "b"
	 * @param b2 expected value change after DELAY/5
	 * @param b3 expected value change after setting the value to "c"
	 * @param b4 expected value change after 2*DELAY
	 * @param b5 expected value change after focus out
	 */
	public void testAStrategy(TextCommitStrategy strategy, String b1, String b2, String b3, String b4, String b5) {
		manager.setTextCommitStrategy(strategy);
		manager.setTextCommitStrategyDelay(DELAY);

		w1.setFocus();

		ov1.setValue("a"); // <<<<
		assertEquals("a", getText());

		performChange("a", b1, strategy != TextCommitStrategy.ON_MODIFY, "b", new Runnable() {
			@Override
			public void run() {
				setText("b"); // <<<<
			}
		});

		performChange(b1, b2, false, "b", new Runnable() {
			public void run() {
				sleep(DELAY / 5); // <<<<
			}
		});

		performChange(b2, b3, strategy != TextCommitStrategy.ON_MODIFY, "c", new Runnable() {
			@Override
			public void run() {
				setText("c"); // <<<<
			}
		});

		performChange(b3, b4, false, "c", new Runnable() {
			@Override
			public void run() {
				sleep(2 * DELAY); // <<<<
			}
		});

		performChange(b4, b5, false, "c", new Runnable() {
			@Override
			public void run() {
				w2.setFocus(); // <<<<
			}
		});
	}

	@Test
	public void testModifyStrategy() {
		testAStrategy(TextCommitStrategy.ON_MODIFY, "b", "b", "c", "c", "c");
	}

	@Test
	public void testModifyDelayStrategy() {
		testAStrategy(TextCommitStrategy.ON_MODIFY_DELAY, "a", "a", "a", "c", "c");
	}

	@Test
	public void testFocusOutStrategy() {
		testAStrategy(TextCommitStrategy.ON_FOCUS_OUT, "a", "a", "a", "a", "c");
	}

	/**
	 * Tests that getDelayedChange and getValue is correct for all strategies for the sequence
	 * <nl>
	 * <li>set iov value to "a" (reset)</li>
	 * <li>select all text (programatically) and enter "b"</li>
	 * <li>wait DELAY/5</li>
	 * <li>select all text (programatically) and enter "c"</li>
	 * <li>wait 2*DELAY</li>
	 * <li>focus out</li>
	 * </nl>
	 * 
	 * @param strategy the strategy to test
	 * @param b1 expected value change after entering "b"
	 * @param b2 expected value change after DELAY/5
	 * @param b3 expected value change after entering "c"
	 * @param b4 expected value change after 2*DELAY
	 * @param b5 expected value change after focus out
	 */
	public void testAKeyStrategy(TextCommitStrategy strategy, String b1, String b2, String b3, String b4, String b5) {
		manager.setTextCommitStrategy(strategy);
		manager.setTextCommitStrategyDelay(DELAY);

		w1.setFocus();

		ov1.setValue("a"); // <<<<
		assertEquals("a", getText());

		performChange("a", b1, strategy != TextCommitStrategy.ON_MODIFY, "b", new Runnable() {
			public void run() {
				selectAll();
				// postKeyDown(w1, "CTRL+A");
				postKeyStroke(w1, "b");
			}
		});

		performChange(b1, b2, false, "b", new Runnable() {
			public void run() {
				sleep(DELAY / 5); // <<<<
			}
		});

		performChange(b2, b3, strategy != TextCommitStrategy.ON_MODIFY, "c", new Runnable() {
			public void run() {
				selectAll();
				// postKeyDown(w1, "CTRL+A");
				postKeyStroke(w1, "c");
			}
		});

		performChange(b3, b4, false, "c", new Runnable() {
			public void run() {
				sleep(2 * DELAY); // <<<<
			}
		});

		performChange(b4, b5, false, "c", new Runnable() {
			public void run() {
				w2.setFocus(); // <<<<
			}
		});
	}

	@Test
	public void testModifyKeyStrategy() {
		try {
			testAKeyStrategy(TextCommitStrategy.ON_MODIFY, "b", "b", "c", "c", "c");
		} finally {
			sleep(DELAY);
		}
	}

	@Test
	public void testModifyDelayKeyStrategy() {
		testAKeyStrategy(TextCommitStrategy.ON_MODIFY_DELAY, "a", "a", "a", "c", "c");
	}

	@Test
	public void testFocusOutKeyStrategy() {
		testAKeyStrategy(TextCommitStrategy.ON_FOCUS_OUT, "a", "a", "a", "a", "c");
	}

	/**
	 * Tests that getDelayedChange and getValue is correct for all strategies for the sequence
	 * <nl>
	 * <li>set iov value to "a" (reset)</li>
	 * <li>set value to "b"</li>
	 * <li>do stroke</li>
	 * </nl>
	 * 
	 * @param strategy the strategy to test
	 * @param b1 expected value after setting the value
	 * @param stroke the key to press
	 * @param b2 expected value after 2*DELAY
	 * @param expectDelayChangeEvents <code>true</code> if a {@link DelayedChangeEvent} event is
	 *            expected
	 * @param getValue the value of the observable value after the operation
	 */
	public void testKeyStrategy(TextCommitStrategy strategy, String b1, final String stroke, String b2,
			boolean expectDelayChangeEvents, String getValue) {
		manager.setTextCommitStrategy(strategy);
		manager.setTextCommitStrategyDelay(DELAY);

		w1.setFocus();
		final String initial = "a";

		ov1.setValue(initial); // <<<<

		performChange(initial, b1, strategy != TextCommitStrategy.ON_MODIFY, "b", new Runnable() {
			public void run() {
				setText("b"); // <<<<
			}
		});

		performChange(b1, b1, false, "b", new Runnable() {
			public void run() {
				sleep(DELAY / 2); // <<<<
			}
		});

		performChange(b1, b2, expectDelayChangeEvents, getValue, new Runnable() {
			public void run() {
				postKeyStroke(w1, stroke); // <<<<
			}
		});
	}

	@Test
	public void testModifyEnterStrategy() {
		testKeyStrategy(TextCommitStrategy.ON_MODIFY, "b", "ENTER", mySingleLine ? "b" : "\r\nb", false,
				mySingleLine ? "b" : "\r\nb");
	}

	@Test
	public void testModifyDelayEnterStrategy() {
		testKeyStrategy(TextCommitStrategy.ON_MODIFY_DELAY, "a", "ENTER", mySingleLine ? "b" : "a", !mySingleLine,
				mySingleLine ? "b" : "\r\nb");
	}

	@Test
	public void testFocusOutEnterStrategy() {
		testKeyStrategy(TextCommitStrategy.ON_FOCUS_OUT, "a", "ENTER", mySingleLine ? "b" : "a", !mySingleLine,
				mySingleLine ? "b" : "\r\nb");
	}

	@Test
	public void testModifyEscapeStrategy() {
		testKeyStrategy(TextCommitStrategy.ON_MODIFY, "b", "ESCAPE", "b", false, "b");
	}

	@Test
	public void testModifyDelayEscapeStrategy() {
		testKeyStrategy(TextCommitStrategy.ON_MODIFY_DELAY, "a", "ESCAPE", "a", false, "a");
	}

	@Test
	public void testFocusOutEscapeStrategy() {
		testKeyStrategy(TextCommitStrategy.ON_FOCUS_OUT, "a", "ESCAPE", "a", false, "a");
	}

	/**
	 * Tests that getDelayedChange and getValue is correct for all strategies for the sequence
	 * <nl>
	 * <li>set iov value to "a" (reset)</li>
	 * <li>do stroke</li>
	 * <li>wait DELAY/2</li>
	 * <li>focus out</li>
	 * </nl>
	 * 
	 * @param strategy the strategy to test
	 * @param b1 expected value after setting the value
	 * @param stroke the key to press
	 */
	public void testKeyStrategyFocusOut(TextCommitStrategy strategy, String b1, final String stroke) {
		manager.setTextCommitStrategy(strategy);
		manager.setTextCommitStrategyDelay(DELAY);

		w1.setFocus();
		final String initial = "a";

		ov1.setValue(initial); // <<<<

		performChange(initial, b1, strategy != TextCommitStrategy.ON_MODIFY, b1, new Runnable() {
			public void run() {
				postKeyStroke(w1, stroke); // <<<<
				sleep(DELAY / 2); // <<<<
				w2.setFocus(); // <<<<
			}
		});
	}

	@Test
	public void testModifyFocusOutStrategy() {
		testKeyStrategyFocusOut(TextCommitStrategy.ON_MODIFY, "ba", "b");
	}

	@Test
	public void testModifyDelayFocusOutStrategy() {
		testKeyStrategyFocusOut(TextCommitStrategy.ON_MODIFY_DELAY, "ba", "b");
	}

	@Test
	public void testFocusOutFocusOutStrategy() {
		testKeyStrategyFocusOut(TextCommitStrategy.ON_FOCUS_OUT, "ba", "b");
	}

	/**
	 * Tests that getDelayedChange and getValue are correct when the strategy is changed for the
	 * sequence
	 * <nl>
	 * <li>set iov value to "a" (reset)</li>
	 * <li>wait DELAY/2</li>
	 * <li>change strategy</li>
	 * </nl>
	 * 
	 * @param fromStrategy original strategy
	 * @param expectDelayChangeEvents <code>true</code> if a {@link DelayedChangeEvent} event is
	 *            expected
	 * @param b1 the new value
	 * @param toStrategy new strategy
	 */
	protected void testA2BStrategy(TextCommitStrategy fromStrategy, boolean expectDelayChangeEvents, String b1,
			final TextCommitStrategy toStrategy) {
		manager.setTextCommitStrategy(fromStrategy);
		manager.setTextCommitStrategyDelay(DELAY);

		w1.setFocus();

		ov1.setValue("a");

		performChange("a", b1, expectDelayChangeEvents, "b", new Runnable() {
			public void run() {
				setText("b"); // <<<<
			}
		});

		performChange(b1, b1, false, "b", new Runnable() {
			public void run() {
				sleep(DELAY / 2);
			}
		});

		performChange(b1, "b", false, "b", new Runnable() {
			public void run() {
				manager.setTextCommitStrategy(toStrategy);
			}
		});
	}

	@Test
	public void testModify2FocusOutStrategy() {
		testA2BStrategy(TextCommitStrategy.ON_MODIFY, false, "b", TextCommitStrategy.ON_FOCUS_OUT);
	}

	@Test
	public void testModify2ModifyDelayStrategy() {
		testA2BStrategy(TextCommitStrategy.ON_MODIFY, false, "b", TextCommitStrategy.ON_MODIFY_DELAY);
	}

	@Test
	public void testFocusOut2ModifyStrategy() {
		testA2BStrategy(TextCommitStrategy.ON_FOCUS_OUT, true, "a", TextCommitStrategy.ON_MODIFY);
	}

	@Test
	public void testFocusOut2ModifyDelayStrategy() {
		testA2BStrategy(TextCommitStrategy.ON_FOCUS_OUT, true, "a", TextCommitStrategy.ON_MODIFY_DELAY);
	}

	@Test
	public void testModifyDelay2ModifyStrategy() {
		testA2BStrategy(TextCommitStrategy.ON_MODIFY_DELAY, true, "a", TextCommitStrategy.ON_MODIFY);
	}

	@Test
	public void testModifyDelay2FocusOutStrategy() {
		testA2BStrategy(TextCommitStrategy.ON_MODIFY_DELAY, true, "a", TextCommitStrategy.ON_FOCUS_OUT);
	}

	/**
	 * Tests that getDelayedChange and getValue is correct for all strategies for the sequence
	 * <nl>
	 * <li>set iov value to "a" (reset)</li>
	 * <li>set value to "b"</li>
	 * <li>wait 2*DELAY</li>
	 * <li>set iov to new value "c"</li>
	 * </nl>
	 * 
	 * @param fromStrategy the strategy to test
	 * @param expectDelayChangeEvents <code>true</code> if a {@link DelayedChangeEvent} event is
	 *            expected
	 */
	private void testASetValueStrategy(TextCommitStrategy fromStrategy, boolean expectDelayChangeEvents, String b1) {
		manager.setTextCommitStrategy(fromStrategy);
		manager.setTextCommitStrategyDelay(1000);

		w1.setFocus();

		ov1.setValue("a");

		performChange("a", b1, expectDelayChangeEvents, "b", new Runnable() {
			public void run() {
				setText("b"); // <<<<
			}
		});

		performChange(b1, b1, false, "b", new Runnable() {
			public void run() {
				sleep(DELAY / 2);
			}
		});

		performChange(b1, "c", false, "c", new Runnable() {
			public void run() {
				ov1.setValue("c");
			}
		});
	}

	@Test
	public void testModifySetValueStrategy() {
		testASetValueStrategy(TextCommitStrategy.ON_MODIFY, false, "b");
	}

	@Test
	public void testFocusOutSetValueStrategy() {
		testASetValueStrategy(TextCommitStrategy.ON_FOCUS_OUT, true, "a");
	}

	@Test
	public void testModifyDelaySetValueStrategy() {
		testASetValueStrategy(TextCommitStrategy.ON_MODIFY_DELAY, true, "a");
	}
}
