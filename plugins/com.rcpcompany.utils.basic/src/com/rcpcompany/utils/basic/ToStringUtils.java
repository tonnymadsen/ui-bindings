/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.utils.basic;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Widget;

/**
 * This utility class provides a number of static functions that can ease formatting of data.
 * 
 * @author Tonny Madsen, The RCP Company
 */

public final class ToStringUtils {

	/**
	 * Formats the source string to be a human readable name.
	 * <p>
	 * The source string is expected to be on the usual mixed-case format as used for Java method
	 * and class names.
	 * <p>
	 * Some examples:
	 * <ul>
	 * <li>"shopName" becomes "Shop Name"</li>
	 * <li>"currentRowNo" becomes "Current Row No"</li>
	 * <li>"id" becomes "Id"</li>
	 * <li>"activeZ" becomes "Active Z"</li>
	 * <li>"ActiveZ" becomes "Active Z"</li>
	 * <li>"ActiveZZ" becomes "Active ZZ"</li>
	 * <li>"isDNAAvailable" becomes "Is DNA Available"</li>
	 * <li>"ShopItemDescription" becomes "Shop Item Description"</li>
	 * <li>"eShop" becomes "E Shop"</li>
	 * <li>"eDNA" becomes "E DNA"</li>
	 * </ul>
	 * <p>
	 * The algorithm:
	 * <ul>
	 * <li>Divide in groups "(l*)(U(U*|l*))*" where U = uppercase letter and l is everything else</li>
	 * <li>Uppercase the first letter of each group</li>
	 * <li>Append the non-empty groups separated with space</li>
	 * </ul>
	 * 
	 * @param source the source name
	 * @return the human readable version
	 */
	public static String formatHumanReadable(String source) {
		// System.out.println("==" + source);
		final StringBuilder sb = new StringBuilder();
		final int len = source.length();
		int i = 0;
		char ch;
		/*
		 * At "!!(l*)(U(U*|l*))*"
		 */
		// System.out.println("  >> " + i);
		while (i < len && !Character.isUpperCase(ch = source.charAt(i))) {
			if (i == 0) {
				ch = Character.toUpperCase(ch);
			}
			sb.append(ch);
			i++;
		}

		/*
		 * At "(l*)!!(U(U*|l*))*"
		 */
		while (i < len) {
			if (i != 0) {
				sb.append(' ');
			}
			// System.out.println("  >> " + i);
			ch = source.charAt(i++);
			sb.append(ch);
			/*
			 * At "(l*)(U!!(U*|l*))*"
			 */
			if (i >= len) {
				break;
			}
			if (Character.isUpperCase(source.charAt(i))) {
				/*
				 * At "(l*)(U(!!U*|l*))*"
				 */
				while (i < len) {
					ch = source.charAt(i++);
					if (Character.isUpperCase(ch) && (i < len && !Character.isUpperCase(source.charAt(i)))) {
						i--;
						break;
					}
					sb.append(ch);
				}
			} else {
				/*
				 * At "(l*)(U(U*|!!l*))*"
				 */
				while (i < len && !Character.isUpperCase(ch = source.charAt(i))) {
					sb.append(ch);
					i++;
				}
			}
			/*
			 * At "(l*)(U(U*|l*)!!)*"
			 */
		}

		final String res = sb.toString();
		// System.out.println(" =" + res);
		return res;
	}

	/**
	 * Returns a string with all the possible choices from the specified array. E.g. if the array is
	 * {@code ["red",
	 * "yellow", "green"]}, the result is the string {@code "red", "yellow" or "green"}.
	 * 
	 * @param array the array
	 * @return the constructed string
	 */
	public static String toOrString(Object[] array) {
		if (array == null) return "<null>";
		if (array.length == 0) return "";

		final StringBuffer sb = new StringBuffer();
		String delimiter = null;
		final Object first = array[0];
		final Object last = array[array.length - 1];
		for (final Object r : array) {
			if (delimiter != null) {
				sb.append(delimiter);
			}
			if (r == first) {
				// nothing
			} else if (r == last) {
				sb.append(" or ");
			} else {
				sb.append(", ");
			}

			final String s = r.toString();
			if (s.indexOf(' ') != -1 || s.indexOf('\t') != -1) {
				delimiter = "\"";
			} else {
				delimiter = "";
			}
			sb.append(delimiter);
			sb.append(s);
		}
		sb.append(delimiter);
		return sb.toString();
	}

	/**
	 * Returns a string with all the possible choices from the specified list. E.g. if the list is
	 * {@code ["red",
	 * "yellow", "green"]}, the result is the string {@code "red", "yellow" or "green"}.
	 * 
	 * @param <T> the type of the elements
	 * @param list the list
	 * @return the constructed string
	 */
	public static <T extends Object> String toOrString(List<T> list) {
		if (list == null) return "<null>";
		if (list.size() == 0) return "";

		final StringBuffer sb = new StringBuffer();
		String delimiter = null;
		final Object first = list.get(0);
		final Object last = list.get(list.size() - 1);
		for (final Object r : list) {
			if (delimiter != null) {
				sb.append(delimiter);
			}
			if (r == first) {
				// nothing
			} else if (r == last) {
				sb.append(" or ");
			} else {
				sb.append(", ");
			}

			final String s = r.toString();
			if (s.indexOf(' ') != -1 || s.indexOf('\t') != -1) {
				delimiter = "\"";
			} else {
				delimiter = "";
			}
			sb.append(delimiter);
			sb.append(s);
		}
		sb.append(delimiter);
		return sb.toString();
	}

	private static final String[] EVENT_TYPE_NAMES = { "None", "KeyDown", "KeyUp", "MouseDown", "MouseUp", "MouseMove",
			"MouseEnter", "MouseExit", "MouseDoubleClick", "Paint", "Move", "Resize", "Dispose", "Selection",
			"DefaultSelection", "FocusIn", "FocusOut", "Expand", "Collapse", "Iconify", "Deiconify", "Close", "Show",
			"Hide", "Modify", "Verify", "Activate", "Deactivate", "Help", "DragDetect", "Arm", "Traverse",
			"MouseHover", "HardKeyDown", "HardKeyUp", "MenuDetect", "SetData", "MouseWheel", "<unassigned>",
			"Settings", "EraseItem", "MeasureItem", "PaintItem", "ImeComposition" };

	/**
	 * Returns a multi-line description of the specific Event.
	 * 
	 * @param event the event
	 * @return the description
	 */
	public static String toString(Event event) {
		if (event == null) return "<null>";

		final StringBuilder sb = new StringBuilder();

		sb.append(EVENT_TYPE_NAMES[event.type]).append("[").append(event.type)
				.append("] hc=" + event.hashCode() + ": ");
		if (event.widget == null) {
			sb.append("<null widget>");
		} else {
			sb.append(event.widget.toString()).append(" [").append(event.widget.hashCode()).append("]");
		}
		sb.append("\n  x=").append(event.x).append(", y=").append(event.y).append(", doit=").append(event.doit);

		switch (event.type) {
		case SWT.KeyDown:
		case SWT.KeyUp:
			sb.append("\n  ");
			toStringKey(sb, event.keyCode, event.stateMask, event.character);
			break;
		case SWT.MouseDown:
		case SWT.MouseUp:
		case SWT.MouseMove:
		case SWT.MouseEnter:
		case SWT.MouseExit:
		case SWT.MouseDoubleClick:
		case SWT.MouseHover:
		case SWT.MouseWheel:
			sb.append("\n  ");
			if ((event.stateMask & SWT.ALT) == SWT.ALT) {
				sb.append("ALT ");
			}
			if ((event.stateMask & SWT.SHIFT) == SWT.SHIFT) {
				sb.append("SHIFT ");
			}
			if ((event.stateMask & SWT.CTRL) == SWT.CTRL) {
				sb.append("CTRL ");
			}
			if ((event.stateMask & SWT.COMMAND) == SWT.COMMAND) {
				sb.append("COMMAND ");
			}
			if ((event.stateMask & SWT.BUTTON1) == SWT.BUTTON1) {
				sb.append("BUTTON1 ");
			}
			if ((event.stateMask & SWT.BUTTON2) == SWT.BUTTON2) {
				sb.append("BUTTON2 ");
			}
			if ((event.stateMask & SWT.BUTTON3) == SWT.BUTTON3) {
				sb.append("BUTTON3 ");
			}
			if ((event.stateMask & SWT.BUTTON4) == SWT.BUTTON4) {
				sb.append("BUTTON4 ");
			}
			if ((event.stateMask & SWT.BUTTON5) == SWT.BUTTON5) {
				sb.append("BUTTON5 ");
			}

			sb.append("button=").append(event.button).append(", count=").append(event.count);
			break;
		case SWT.Paint:
			sb.append("\n  gc=").append(event.gc).append(", width=").append(event.width).append(", height=")
					.append(event.height).append(", count=").append(event.count);
			break;
		case SWT.Move:
		case SWT.Resize:
			break;
		case SWT.Dispose:
			break;
		case SWT.Selection:
		case SWT.DefaultSelection:
			sb.append("\n  ");
			if ((event.stateMask & SWT.ALT) == SWT.ALT) {
				sb.append("ALT ");
			}
			if ((event.stateMask & SWT.SHIFT) == SWT.SHIFT) {
				sb.append("SHIFT ");
			}
			if ((event.stateMask & SWT.CTRL) == SWT.CTRL) {
				sb.append("CTRL ");
			}
			if ((event.stateMask & SWT.COMMAND) == SWT.COMMAND) {
				sb.append("COMMAND ");
			}
			if ((event.stateMask & SWT.BUTTON1) == SWT.BUTTON1) {
				sb.append("BUTTON1 ");
			}
			if ((event.stateMask & SWT.BUTTON2) == SWT.BUTTON2) {
				sb.append("BUTTON2 ");
			}
			if ((event.stateMask & SWT.BUTTON3) == SWT.BUTTON3) {
				sb.append("BUTTON3 ");
			}
			if ((event.stateMask & SWT.BUTTON4) == SWT.BUTTON4) {
				sb.append("BUTTON4 ");
			}
			if ((event.stateMask & SWT.BUTTON5) == SWT.BUTTON5) {
				sb.append("BUTTON5 ");
			}
			sb.append("width=").append(event.width).append(", height=").append(event.height).append(", detail=");
			if ((event.detail & SWT.CHECK) == SWT.CHECK) {
				sb.append("CHECK ");
			}
			sb.append(event.detail).append(", text='").append(event.text).append("'");
			break;
		case SWT.FocusIn:
		case SWT.FocusOut:
			break;
		case SWT.Expand:
		case SWT.Collapse:
		case SWT.Iconify:
		case SWT.Deiconify:
			// TODO
			break;
		case SWT.Close:
		case SWT.Show:
		case SWT.Hide:
			// TODO
			break;
		case SWT.Modify:
			// TODO
			break;
		case SWT.Verify:
			sb.append("\n  ");
			sb.append("[").append(event.start).append("; ").append(event.end).append("[='").append(event.text)
					.append("'");
			break;
		case SWT.Activate:
		case SWT.Deactivate:
			// TODO
			break;
		case SWT.Help:
			// TODO
			break;
		case SWT.DragDetect:
			// TODO
			break;
		case SWT.Arm:
			// TODO
			break;
		case SWT.Traverse:
			sb.append("\n  ");
			if ((event.detail & SWT.TRAVERSE_ESCAPE) == SWT.TRAVERSE_ESCAPE) {
				sb.append("Escape");
			}
			if ((event.detail & SWT.TRAVERSE_RETURN) == SWT.TRAVERSE_RETURN) {
				sb.append("RETURN");
			}
			if ((event.detail & SWT.TRAVERSE_TAB_PREVIOUS) == SWT.TRAVERSE_TAB_PREVIOUS) {
				sb.append("TAB PREVIOUS");
			}
			if ((event.detail & SWT.TRAVERSE_TAB_NEXT) == SWT.TRAVERSE_TAB_NEXT) {
				sb.append("TAB NEXT");
			}
			if ((event.detail & SWT.TRAVERSE_ARROW_PREVIOUS) == SWT.TRAVERSE_ARROW_PREVIOUS) {
				sb.append("ARROW PREVIOUS");
			}
			if ((event.detail & SWT.TRAVERSE_ARROW_NEXT) == SWT.TRAVERSE_ARROW_NEXT) {
				sb.append("ARROW NEXT");
			}
			if ((event.detail & SWT.TRAVERSE_MNEMONIC) == SWT.TRAVERSE_MNEMONIC) {
				sb.append("MNEMONIC");
			}
			if ((event.detail & SWT.TRAVERSE_PAGE_PREVIOUS) == SWT.TRAVERSE_PAGE_PREVIOUS) {
				sb.append("PAGE PREVIOUS");
			}
			if ((event.detail & SWT.TRAVERSE_PAGE_NEXT) == SWT.TRAVERSE_PAGE_NEXT) {
				sb.append("PAGE NEXT");
			}
			break;
		case SWT.HardKeyDown:
		case SWT.HardKeyUp:
			// TODO
			break;
		case SWT.MenuDetect:
			// TODO
			break;
		case SWT.SetData:
			// TODO
			break;
		case SWT.Settings:
			// TODO
			break;
		case SWT.EraseItem:
		case SWT.MeasureItem:
			sb.append("\n  gc=").append(event.gc).append(", index(column)=").append(event.index).append(", width=")
					.append(event.width).append(", height=").append(event.height).append(", count=")
					.append(event.count);
			break;
		case SWT.PaintItem:
			sb.append("\n  gc=").append(event.gc).append(", index(column)=").append(event.index).append(", width=")
					.append(event.width).append(", height=").append(event.height).append(", count=")
					.append(event.count).append(", detail=");
			int d = event.detail;
			if ((d & SWT.DRAG) == SWT.DRAG) {
				sb.append("DRAG+");
				d &= ~SWT.DRAG;
			}
			if ((d & SWT.FOCUSED) == SWT.FOCUSED) {
				sb.append("FOCUSED+");
				d &= ~SWT.FOCUSED;
			}
			if ((d & SWT.SELECTED) == SWT.SELECTED) {
				sb.append("SELECTED+");
				d &= ~SWT.SELECTED;
			}
			if ((d & SWT.BACKGROUND) == SWT.BACKGROUND) {
				sb.append("BACKGROUND+");
				d &= ~SWT.BACKGROUND;
			}
			if ((d & SWT.FOREGROUND) == SWT.FOREGROUND) {
				sb.append("FOREGROUND+");
				d &= ~SWT.FOREGROUND;
			}
			if ((d & SWT.HOT) == SWT.HOT) {
				sb.append("HOT+");
				d &= ~SWT.HOT;
			}
			sb.append(d);
			break;
		case SWT.ImeComposition:
			// TODO
			break;
		default:
			// TODO
			break;
		}
		if (event.item != null) {
			final Widget item = event.item;
			sb.append("\n  ");
			sb.append("item=").append(item).append(" [data=").append(item.getData());
			if (item instanceof TableItem) {
				final TableItem ti = (TableItem) item;
				sb.append(", text=").append(ti.getText());
			}
			sb.append("]");
		}

		return sb.toString();
	}

	/**
	 * Returns a multi-line description of the specific Event.
	 * 
	 * @param event the event
	 * @return the description
	 */
	public static String toString(KeyEvent event) {
		final StringBuilder sb = new StringBuilder();

		if (event == null) return "<null>";

		toStringKey(sb, event.keyCode, event.stateMask, event.character);

		return sb.toString();
	}

	private static void toStringKey(final StringBuilder sb, int keyCode, int stateMask, char character) {
		if ((stateMask & SWT.ALT) == SWT.ALT) {
			sb.append("ALT ");
		}
		if ((stateMask & SWT.SHIFT) == SWT.SHIFT) {
			sb.append("SHIFT ");
		}
		if ((stateMask & SWT.CTRL) == SWT.CTRL) {
			sb.append("CTRL ");
		}
		if ((stateMask & SWT.COMMAND) == SWT.COMMAND) {
			sb.append("COMMAND ");
		}
		if ((stateMask & SWT.BUTTON1) == SWT.BUTTON1) {
			sb.append("BUTTON1 ");
		}
		if ((stateMask & SWT.BUTTON2) == SWT.BUTTON2) {
			sb.append("BUTTON2 ");
		}
		if ((stateMask & SWT.BUTTON3) == SWT.BUTTON3) {
			sb.append("BUTTON3 ");
		}
		if ((stateMask & SWT.BUTTON4) == SWT.BUTTON4) {
			sb.append("BUTTON4 ");
		}
		if ((stateMask & SWT.BUTTON5) == SWT.BUTTON5) {
			sb.append("BUTTON5 ");
		}
		sb.append("character=");
		if (Character.isISOControl(character)) {
			sb.append((int) character);
		} else {
			sb.append("'").append(character).append("'");
		}
		sb.append(", keyCode=");
		switch (keyCode) {
		case SWT.ARROW_UP:
			sb.append("ARROW_UP");
			break;
		case SWT.ARROW_DOWN:
			sb.append("ARROW_DOWN");
			break;
		case SWT.ARROW_LEFT:
			sb.append("ARROW_LEFT");
			break;
		case SWT.ARROW_RIGHT:
			sb.append("ARROW_RIGHT");
			break;
		case SWT.PAGE_UP:
			sb.append("PAGE_UP");
			break;
		case SWT.PAGE_DOWN:
			sb.append("PAGE_DOWN");
			break;
		case SWT.HOME:
			sb.append("HOME");
			break;
		case SWT.END:
			sb.append("END");
			break;
		case SWT.INSERT:
			sb.append("INSERT");
			break;
		case SWT.F1:
			sb.append("F1");
			break;
		case SWT.F2:
			sb.append("F2");
			break;
		case SWT.F3:
			sb.append("F3");
			break;
		case SWT.F4:
			sb.append("F4");
			break;
		case SWT.F5:
			sb.append("F5");
			break;
		case SWT.F6:
			sb.append("F6");
			break;
		case SWT.F7:
			sb.append("F7");
			break;
		case SWT.F8:
			sb.append("F8");
			break;
		case SWT.F9:
			sb.append("F9");
			break;
		case SWT.F10:
			sb.append("F10");
			break;
		case SWT.F11:
			sb.append("F11");
			break;
		case SWT.F12:
			sb.append("F12");
			break;
		case SWT.F13:
			sb.append("F13");
			break;
		case SWT.F14:
			sb.append("F14");
			break;
		case SWT.F15:
			sb.append("F15");
			break;
		case SWT.KEYPAD_MULTIPLY:
			sb.append("KEYPAD_MULTIPLY");
			break;
		case SWT.KEYPAD_ADD:
			sb.append("KEYPAD_ADD");
			break;
		case SWT.KEYPAD_SUBTRACT:
			sb.append("KEYPAD_SUBTRACT");
			break;
		case SWT.KEYPAD_DECIMAL:
			sb.append("KEYPAD_DECIMAL");
			break;
		case SWT.KEYPAD_DIVIDE:
			sb.append("KEYPAD_DIVIDE");
			break;
		case SWT.KEYPAD_0:
			sb.append("KEYPAD_0");
			break;
		case SWT.KEYPAD_1:
			sb.append("KEYPAD_1");
			break;
		case SWT.KEYPAD_2:
			sb.append("KEYPAD_2");
			break;
		case SWT.KEYPAD_3:
			sb.append("KEYPAD_3");
			break;
		case SWT.KEYPAD_4:
			sb.append("KEYPAD_4");
			break;
		case SWT.KEYPAD_5:
			sb.append("KEYPAD_5");
			break;
		case SWT.KEYPAD_6:
			sb.append("KEYPAD_6");
			break;
		case SWT.KEYPAD_7:
			sb.append("KEYPAD_7");
			break;
		case SWT.KEYPAD_8:
			sb.append("KEYPAD_8");
			break;
		case SWT.KEYPAD_9:
			sb.append("KEYPAD_9");
			break;
		case SWT.KEYPAD_EQUAL:
			sb.append("KEYPAD_EQUAL");
			break;
		case SWT.KEYPAD_CR:
			sb.append("KEYPAD_CR");
			break;
		case SWT.HELP:
			sb.append("HELP");
			break;
		case SWT.CAPS_LOCK:
			sb.append("CAPS_LOCK");
			break;
		case SWT.NUM_LOCK:
			sb.append("NUM_LOCK");
			break;
		case SWT.SCROLL_LOCK:
			sb.append("SCROLL_LOCK");
			break;
		case SWT.PAUSE:
			sb.append("PAUSE");
			break;
		case SWT.BREAK:
			sb.append("BREAK");
			break;
		case SWT.PRINT_SCREEN:
			sb.append("PRINT_SCREEN");
			break;
		case SWT.ALT:
			sb.append("ALT");
			break;
		case SWT.SHIFT:
			sb.append("SHIFT");
			break;
		case SWT.CTRL:
			sb.append("CTRL");
			break;
		case SWT.COMMAND:
			sb.append("COMMAND");
			break;
		case SWT.BUTTON1:
			sb.append("BUTTON1");
			break;
		case SWT.BUTTON2:
			sb.append("BUTTON2");
			break;
		case SWT.BUTTON3:
			sb.append("BUTTON3");
			break;
		case SWT.BUTTON4:
			sb.append("BUTTON4");
			break;
		case SWT.BUTTON5:
			sb.append("BUTTON5");
			break;
		default:
			if ((keyCode & SWT.KEYCODE_BIT) == SWT.KEYCODE_BIT) {
				sb.append("KEYCODE_BIT+").append(keyCode & SWT.KEY_MASK);
			} else {
				sb.append(keyCode);
			}
			break;
		}
	}

	public String toString(Layout layout) {
		final StringBuilder sb = new StringBuilder();

		return sb.toString();
	}

	/**
	 * The name for all defined {@link Notification#getEventType() event types}.
	 */
	private static final String[] NOTIFICATION_TYPE_NAMES = { "<illegal 0>", "SET", "UNSET", "ADD", "REMOVE",
			"ADD_MANY", "REMOVE_MANY", "MOVE", "REMOVING_ADAPTER", "RESOLVE", };

	/**
	 * Returns a multi-line description of the specific Event.
	 * 
	 * @param event the event
	 * @return the description
	 */
	public static String toString(Notification msg) {
		final StringBuilder sb = new StringBuilder();

		if (msg.getEventType() < Notification.EVENT_TYPE_COUNT) {
			sb.append(NOTIFICATION_TYPE_NAMES[msg.getEventType()]);
		} else {
			sb.append("NOTIFICATION#").append(msg.getEventType());
		}
		sb.append(":");
		final EStructuralFeature sf = (EStructuralFeature) msg.getFeature();
		if (sf != null) {
			sb.append(' ').append(sf.getName());
		}
		if (msg.isTouch()) {
			sb.append(" [TOUCH]");
		}
		if (msg.getPosition() != Notification.NO_INDEX) {
			sb.append(" index=");
			sb.append(msg.getPosition());
		}
		switch (msg.getEventType()) {
		case Notification.SET:
		case Notification.UNSET:
		case Notification.REMOVE:
		case Notification.REMOVE_MANY:
		case Notification.MOVE:
			sb.append("\nold: ");
			sb.append(msg.getOldValue());
			break;
		default:
			break;
		}
		switch (msg.getEventType()) {
		case Notification.SET:
		case Notification.ADD:
		case Notification.ADD_MANY:
		case Notification.MOVE:
			sb.append("\nnew: ");
			sb.append(msg.getNewValue());
			break;
		default:
			break;
		}
		switch (msg.getEventType()) {
		case Notification.SET:
			break;
		case Notification.UNSET:
			break;
		case Notification.ADD:
			break;
		case Notification.REMOVE:
			break;
		case Notification.ADD_MANY:
			break;
		case Notification.REMOVE_MANY:
			break;
		case Notification.MOVE:
			break;
		case Notification.REMOVING_ADAPTER:
			break;
		case Notification.RESOLVE:
			break;
		default:
			break;
		}

		return sb.toString();
	}
}
