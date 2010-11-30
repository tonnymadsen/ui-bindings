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
import org.eclipse.swt.widgets.Control;
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
		if (array == null) return "<null>"; //$NON-NLS-1$
		if (array.length == 0) return ""; //$NON-NLS-1$

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
				sb.append(" or "); //$NON-NLS-1$
			} else {
				sb.append(", "); //$NON-NLS-1$
			}

			final String s = r.toString();
			if (s.indexOf(' ') != -1 || s.indexOf('\t') != -1) {
				delimiter = "\""; //$NON-NLS-1$
			} else {
				delimiter = ""; //$NON-NLS-1$
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
		if (list == null) return "<null>"; //$NON-NLS-1$
		if (list.size() == 0) return ""; //$NON-NLS-1$

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
				sb.append(" or "); //$NON-NLS-1$
			} else {
				sb.append(", "); //$NON-NLS-1$
			}

			final String s = r.toString();
			if (s.indexOf(' ') != -1 || s.indexOf('\t') != -1) {
				delimiter = "\""; //$NON-NLS-1$
			} else {
				delimiter = ""; //$NON-NLS-1$
			}
			sb.append(delimiter);
			sb.append(s);
		}
		sb.append(delimiter);
		return sb.toString();
	}

	private static final String[] EVENT_TYPE_NAMES = { "None", "KeyDown", "KeyUp", "MouseDown", "MouseUp", "MouseMove", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
			"MouseEnter", "MouseExit", "MouseDoubleClick", "Paint", "Move", "Resize", "Dispose", "Selection", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			"DefaultSelection", "FocusIn", "FocusOut", "Expand", "Collapse", "Iconify", "Deiconify", "Close", "Show", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
			"Hide", "Modify", "Verify", "Activate", "Deactivate", "Help", "DragDetect", "Arm", "Traverse", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
			"MouseHover", "HardKeyDown", "HardKeyUp", "MenuDetect", "SetData", "MouseWheel", "<unassigned>", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
			"Settings", "EraseItem", "MeasureItem", "PaintItem", "ImeComposition" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

	/**
	 * Returns a multi-line description of the specific Event.
	 * 
	 * @param event the event
	 * @return the description
	 */
	public static String toString(Event event) {
		if (event == null) return "<null>"; //$NON-NLS-1$

		final StringBuilder sb = new StringBuilder();

		sb.append(EVENT_TYPE_NAMES[event.type]).append("[").append(event.type) //$NON-NLS-1$
				.append("] hc=" + event.hashCode() + ": "); //$NON-NLS-1$ //$NON-NLS-2$
		if (event.widget == null) {
			sb.append("<null widget>"); //$NON-NLS-1$
		} else {
			sb.append(event.widget.toString()).append(" [").append(event.widget.hashCode()).append("]"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		sb.append("\n  x=").append(event.x).append(", y=").append(event.y).append(", doit=").append(event.doit); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		switch (event.type) {
		case SWT.KeyDown:
		case SWT.KeyUp:
			sb.append("\n  "); //$NON-NLS-1$
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
			sb.append("\n  "); //$NON-NLS-1$
			if ((event.stateMask & SWT.ALT) == SWT.ALT) {
				sb.append("ALT "); //$NON-NLS-1$
			}
			if ((event.stateMask & SWT.SHIFT) == SWT.SHIFT) {
				sb.append("SHIFT "); //$NON-NLS-1$
			}
			if ((event.stateMask & SWT.CTRL) == SWT.CTRL) {
				sb.append("CTRL "); //$NON-NLS-1$
			}
			if ((event.stateMask & SWT.COMMAND) == SWT.COMMAND) {
				sb.append("COMMAND "); //$NON-NLS-1$
			}
			if ((event.stateMask & SWT.BUTTON1) == SWT.BUTTON1) {
				sb.append("BUTTON1 "); //$NON-NLS-1$
			}
			if ((event.stateMask & SWT.BUTTON2) == SWT.BUTTON2) {
				sb.append("BUTTON2 "); //$NON-NLS-1$
			}
			if ((event.stateMask & SWT.BUTTON3) == SWT.BUTTON3) {
				sb.append("BUTTON3 "); //$NON-NLS-1$
			}
			if ((event.stateMask & SWT.BUTTON4) == SWT.BUTTON4) {
				sb.append("BUTTON4 "); //$NON-NLS-1$
			}
			if ((event.stateMask & SWT.BUTTON5) == SWT.BUTTON5) {
				sb.append("BUTTON5 "); //$NON-NLS-1$
			}

			sb.append("button=").append(event.button).append(", count=").append(event.count); //$NON-NLS-1$ //$NON-NLS-2$
			break;
		case SWT.Paint:
			sb.append("\n  gc=").append(event.gc).append(", width=").append(event.width).append(", height=") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					.append(event.height).append(", count=").append(event.count); //$NON-NLS-1$
			break;
		case SWT.Move:
		case SWT.Resize:
			break;
		case SWT.Dispose:
			break;
		case SWT.Selection:
		case SWT.DefaultSelection:
			sb.append("\n  "); //$NON-NLS-1$
			if ((event.stateMask & SWT.ALT) == SWT.ALT) {
				sb.append("ALT "); //$NON-NLS-1$
			}
			if ((event.stateMask & SWT.SHIFT) == SWT.SHIFT) {
				sb.append("SHIFT "); //$NON-NLS-1$
			}
			if ((event.stateMask & SWT.CTRL) == SWT.CTRL) {
				sb.append("CTRL "); //$NON-NLS-1$
			}
			if ((event.stateMask & SWT.COMMAND) == SWT.COMMAND) {
				sb.append("COMMAND "); //$NON-NLS-1$
			}
			if ((event.stateMask & SWT.BUTTON1) == SWT.BUTTON1) {
				sb.append("BUTTON1 "); //$NON-NLS-1$
			}
			if ((event.stateMask & SWT.BUTTON2) == SWT.BUTTON2) {
				sb.append("BUTTON2 "); //$NON-NLS-1$
			}
			if ((event.stateMask & SWT.BUTTON3) == SWT.BUTTON3) {
				sb.append("BUTTON3 "); //$NON-NLS-1$
			}
			if ((event.stateMask & SWT.BUTTON4) == SWT.BUTTON4) {
				sb.append("BUTTON4 "); //$NON-NLS-1$
			}
			if ((event.stateMask & SWT.BUTTON5) == SWT.BUTTON5) {
				sb.append("BUTTON5 "); //$NON-NLS-1$
			}
			sb.append("width=").append(event.width).append(", height=").append(event.height).append(", detail="); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			if ((event.detail & SWT.CHECK) == SWT.CHECK) {
				sb.append("CHECK "); //$NON-NLS-1$
			}
			sb.append(event.detail).append(", text='").append(event.text).append("'"); //$NON-NLS-1$ //$NON-NLS-2$
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
			sb.append("\n  "); //$NON-NLS-1$
			sb.append("[").append(event.start).append("; ").append(event.end).append("[='").append(event.text) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					.append("'"); //$NON-NLS-1$
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
			sb.append("\n  "); //$NON-NLS-1$
			if ((event.detail & SWT.TRAVERSE_ESCAPE) == SWT.TRAVERSE_ESCAPE) {
				sb.append("Escape"); //$NON-NLS-1$
			}
			if ((event.detail & SWT.TRAVERSE_RETURN) == SWT.TRAVERSE_RETURN) {
				sb.append("RETURN"); //$NON-NLS-1$
			}
			if ((event.detail & SWT.TRAVERSE_TAB_PREVIOUS) == SWT.TRAVERSE_TAB_PREVIOUS) {
				sb.append("TAB PREVIOUS"); //$NON-NLS-1$
			}
			if ((event.detail & SWT.TRAVERSE_TAB_NEXT) == SWT.TRAVERSE_TAB_NEXT) {
				sb.append("TAB NEXT"); //$NON-NLS-1$
			}
			if ((event.detail & SWT.TRAVERSE_ARROW_PREVIOUS) == SWT.TRAVERSE_ARROW_PREVIOUS) {
				sb.append("ARROW PREVIOUS"); //$NON-NLS-1$
			}
			if ((event.detail & SWT.TRAVERSE_ARROW_NEXT) == SWT.TRAVERSE_ARROW_NEXT) {
				sb.append("ARROW NEXT"); //$NON-NLS-1$
			}
			if ((event.detail & SWT.TRAVERSE_MNEMONIC) == SWT.TRAVERSE_MNEMONIC) {
				sb.append("MNEMONIC"); //$NON-NLS-1$
			}
			if ((event.detail & SWT.TRAVERSE_PAGE_PREVIOUS) == SWT.TRAVERSE_PAGE_PREVIOUS) {
				sb.append("PAGE PREVIOUS"); //$NON-NLS-1$
			}
			if ((event.detail & SWT.TRAVERSE_PAGE_NEXT) == SWT.TRAVERSE_PAGE_NEXT) {
				sb.append("PAGE NEXT"); //$NON-NLS-1$
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
			sb.append("\n  gc=").append(event.gc).append(", index(column)=").append(event.index).append(", width=") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					.append(event.width).append(", height=").append(event.height).append(", count=") //$NON-NLS-1$ //$NON-NLS-2$
					.append(event.count);
			break;
		case SWT.PaintItem:
			sb.append("\n  gc=").append(event.gc).append(", index(column)=").append(event.index).append(", width=") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					.append(event.width).append(", height=").append(event.height).append(", count=") //$NON-NLS-1$ //$NON-NLS-2$
					.append(event.count).append(", detail="); //$NON-NLS-1$
			int d = event.detail;
			if ((d & SWT.DRAG) == SWT.DRAG) {
				sb.append("DRAG+"); //$NON-NLS-1$
				d &= ~SWT.DRAG;
			}
			if ((d & SWT.FOCUSED) == SWT.FOCUSED) {
				sb.append("FOCUSED+"); //$NON-NLS-1$
				d &= ~SWT.FOCUSED;
			}
			if ((d & SWT.SELECTED) == SWT.SELECTED) {
				sb.append("SELECTED+"); //$NON-NLS-1$
				d &= ~SWT.SELECTED;
			}
			if ((d & SWT.BACKGROUND) == SWT.BACKGROUND) {
				sb.append("BACKGROUND+"); //$NON-NLS-1$
				d &= ~SWT.BACKGROUND;
			}
			if ((d & SWT.FOREGROUND) == SWT.FOREGROUND) {
				sb.append("FOREGROUND+"); //$NON-NLS-1$
				d &= ~SWT.FOREGROUND;
			}
			if ((d & SWT.HOT) == SWT.HOT) {
				sb.append("HOT+"); //$NON-NLS-1$
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
			sb.append("\n  "); //$NON-NLS-1$
			sb.append("item=").append(item).append(" [data=").append(item.getData()); //$NON-NLS-1$ //$NON-NLS-2$
			if (item instanceof TableItem) {
				final TableItem ti = (TableItem) item;
				sb.append(", text=").append(ti.getText()); //$NON-NLS-1$
			}
			sb.append("]"); //$NON-NLS-1$
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

		if (event == null) return "<null>"; //$NON-NLS-1$

		toStringKey(sb, event.keyCode, event.stateMask, event.character);

		return sb.toString();
	}

	private static void toStringKey(final StringBuilder sb, int keyCode, int stateMask, char character) {
		if ((stateMask & SWT.ALT) == SWT.ALT) {
			sb.append("ALT "); //$NON-NLS-1$
		}
		if ((stateMask & SWT.SHIFT) == SWT.SHIFT) {
			sb.append("SHIFT "); //$NON-NLS-1$
		}
		if ((stateMask & SWT.CTRL) == SWT.CTRL) {
			sb.append("CTRL "); //$NON-NLS-1$
		}
		if ((stateMask & SWT.COMMAND) == SWT.COMMAND) {
			sb.append("COMMAND "); //$NON-NLS-1$
		}
		if ((stateMask & SWT.BUTTON1) == SWT.BUTTON1) {
			sb.append("BUTTON1 "); //$NON-NLS-1$
		}
		if ((stateMask & SWT.BUTTON2) == SWT.BUTTON2) {
			sb.append("BUTTON2 "); //$NON-NLS-1$
		}
		if ((stateMask & SWT.BUTTON3) == SWT.BUTTON3) {
			sb.append("BUTTON3 "); //$NON-NLS-1$
		}
		if ((stateMask & SWT.BUTTON4) == SWT.BUTTON4) {
			sb.append("BUTTON4 "); //$NON-NLS-1$
		}
		if ((stateMask & SWT.BUTTON5) == SWT.BUTTON5) {
			sb.append("BUTTON5 "); //$NON-NLS-1$
		}
		sb.append("character="); //$NON-NLS-1$
		if (Character.isISOControl(character)) {
			sb.append((int) character);
		} else {
			sb.append("'").append(character).append("'"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		sb.append(", keyCode="); //$NON-NLS-1$
		switch (keyCode) {
		case SWT.ARROW_UP:
			sb.append("ARROW_UP"); //$NON-NLS-1$
			break;
		case SWT.ARROW_DOWN:
			sb.append("ARROW_DOWN"); //$NON-NLS-1$
			break;
		case SWT.ARROW_LEFT:
			sb.append("ARROW_LEFT"); //$NON-NLS-1$
			break;
		case SWT.ARROW_RIGHT:
			sb.append("ARROW_RIGHT"); //$NON-NLS-1$
			break;
		case SWT.PAGE_UP:
			sb.append("PAGE_UP"); //$NON-NLS-1$
			break;
		case SWT.PAGE_DOWN:
			sb.append("PAGE_DOWN"); //$NON-NLS-1$
			break;
		case SWT.HOME:
			sb.append("HOME"); //$NON-NLS-1$
			break;
		case SWT.END:
			sb.append("END"); //$NON-NLS-1$
			break;
		case SWT.INSERT:
			sb.append("INSERT"); //$NON-NLS-1$
			break;
		case SWT.F1:
			sb.append("F1"); //$NON-NLS-1$
			break;
		case SWT.F2:
			sb.append("F2"); //$NON-NLS-1$
			break;
		case SWT.F3:
			sb.append("F3"); //$NON-NLS-1$
			break;
		case SWT.F4:
			sb.append("F4"); //$NON-NLS-1$
			break;
		case SWT.F5:
			sb.append("F5"); //$NON-NLS-1$
			break;
		case SWT.F6:
			sb.append("F6"); //$NON-NLS-1$
			break;
		case SWT.F7:
			sb.append("F7"); //$NON-NLS-1$
			break;
		case SWT.F8:
			sb.append("F8"); //$NON-NLS-1$
			break;
		case SWT.F9:
			sb.append("F9"); //$NON-NLS-1$
			break;
		case SWT.F10:
			sb.append("F10"); //$NON-NLS-1$
			break;
		case SWT.F11:
			sb.append("F11"); //$NON-NLS-1$
			break;
		case SWT.F12:
			sb.append("F12"); //$NON-NLS-1$
			break;
		case SWT.F13:
			sb.append("F13"); //$NON-NLS-1$
			break;
		case SWT.F14:
			sb.append("F14"); //$NON-NLS-1$
			break;
		case SWT.F15:
			sb.append("F15"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_MULTIPLY:
			sb.append("KEYPAD_MULTIPLY"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_ADD:
			sb.append("KEYPAD_ADD"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_SUBTRACT:
			sb.append("KEYPAD_SUBTRACT"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_DECIMAL:
			sb.append("KEYPAD_DECIMAL"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_DIVIDE:
			sb.append("KEYPAD_DIVIDE"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_0:
			sb.append("KEYPAD_0"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_1:
			sb.append("KEYPAD_1"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_2:
			sb.append("KEYPAD_2"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_3:
			sb.append("KEYPAD_3"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_4:
			sb.append("KEYPAD_4"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_5:
			sb.append("KEYPAD_5"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_6:
			sb.append("KEYPAD_6"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_7:
			sb.append("KEYPAD_7"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_8:
			sb.append("KEYPAD_8"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_9:
			sb.append("KEYPAD_9"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_EQUAL:
			sb.append("KEYPAD_EQUAL"); //$NON-NLS-1$
			break;
		case SWT.KEYPAD_CR:
			sb.append("KEYPAD_CR"); //$NON-NLS-1$
			break;
		case SWT.HELP:
			sb.append("HELP"); //$NON-NLS-1$
			break;
		case SWT.CAPS_LOCK:
			sb.append("CAPS_LOCK"); //$NON-NLS-1$
			break;
		case SWT.NUM_LOCK:
			sb.append("NUM_LOCK"); //$NON-NLS-1$
			break;
		case SWT.SCROLL_LOCK:
			sb.append("SCROLL_LOCK"); //$NON-NLS-1$
			break;
		case SWT.PAUSE:
			sb.append("PAUSE"); //$NON-NLS-1$
			break;
		case SWT.BREAK:
			sb.append("BREAK"); //$NON-NLS-1$
			break;
		case SWT.PRINT_SCREEN:
			sb.append("PRINT_SCREEN"); //$NON-NLS-1$
			break;
		case SWT.ALT:
			sb.append("ALT"); //$NON-NLS-1$
			break;
		case SWT.SHIFT:
			sb.append("SHIFT"); //$NON-NLS-1$
			break;
		case SWT.CTRL:
			sb.append("CTRL"); //$NON-NLS-1$
			break;
		case SWT.COMMAND:
			sb.append("COMMAND"); //$NON-NLS-1$
			break;
		case SWT.BUTTON1:
			sb.append("BUTTON1"); //$NON-NLS-1$
			break;
		case SWT.BUTTON2:
			sb.append("BUTTON2"); //$NON-NLS-1$
			break;
		case SWT.BUTTON3:
			sb.append("BUTTON3"); //$NON-NLS-1$
			break;
		case SWT.BUTTON4:
			sb.append("BUTTON4"); //$NON-NLS-1$
			break;
		case SWT.BUTTON5:
			sb.append("BUTTON5"); //$NON-NLS-1$
			break;
		default:
			if ((keyCode & SWT.KEYCODE_BIT) == SWT.KEYCODE_BIT) {
				sb.append("KEYCODE_BIT+").append(keyCode & SWT.KEY_MASK); //$NON-NLS-1$
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
	private static final String[] NOTIFICATION_TYPE_NAMES = { "<illegal 0>", "SET", "UNSET", "ADD", "REMOVE", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			"ADD_MANY", "REMOVE_MANY", "MOVE", "REMOVING_ADAPTER", "RESOLVE", }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

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
			sb.append("NOTIFICATION#").append(msg.getEventType()); //$NON-NLS-1$
		}
		sb.append(":"); //$NON-NLS-1$
		final EStructuralFeature sf = (EStructuralFeature) msg.getFeature();
		if (sf != null) {
			sb.append(' ').append(sf.getName());
		}
		if (msg.isTouch()) {
			sb.append(" [TOUCH]"); //$NON-NLS-1$
		}
		if (msg.getPosition() != Notification.NO_INDEX) {
			sb.append(" index="); //$NON-NLS-1$
			sb.append(msg.getPosition());
		}
		switch (msg.getEventType()) {
		case Notification.SET:
		case Notification.UNSET:
		case Notification.REMOVE:
		case Notification.REMOVE_MANY:
		case Notification.MOVE:
			sb.append("\nold: "); //$NON-NLS-1$
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
			sb.append("\nnew: "); //$NON-NLS-1$
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

	/**
	 * Returns a description of the path of the specified control.
	 * 
	 * @param c the control to return the path for
	 * @return the path
	 */
	public static String toPath(Control c) {
		String s = null;
		while (c != null) {
			if (s != null) {
				s = " > " + s; //$NON-NLS-1$
			} else {
				s = ""; //$NON-NLS-1$
			}
			s = c + "@" + System.identityHashCode(c) + s; //$NON-NLS-1$
			c = c.getParent();
		}
		return s;
	}
}
