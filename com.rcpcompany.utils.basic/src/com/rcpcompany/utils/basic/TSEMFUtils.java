/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.utils.basic;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * This utility class provides a number of static functions that can ease
 * formatting of data.
 * 
 * @author Tonny Madsen, The RCP Company
 */

public final class TSEMFUtils {

	/**
	 * Returns a multi-line description of the specific Event.
	 * 
	 * @param event
	 *            the event
	 * @return the description
	 */
	public static String toString(Notification msg) {
		final StringBuilder sb = new StringBuilder();

		if (msg.getEventType() < Notification.EVENT_TYPE_COUNT) {
			sb.append(NOTIFICATION_TYPE_NAMES[msg.getEventType()]);
		} else {
			sb.append("NOTIFICATION#").append(msg.getEventType()); //$NON-NLS-1$
		}
		final Object notifier = msg.getNotifier();
		if (notifier != null) {
			sb.append(": ").append(notifier.getClass().getSimpleName());
		} else {
			sb.append(": NULL");
		}
		final EStructuralFeature sf = (EStructuralFeature) msg.getFeature();
		if (sf != null) {
			sb.append('.').append(sf.getName());
		}
		if (msg.isTouch()) {
			sb.append(" [TOUCH]"); //$NON-NLS-1$
		}
		if (msg.getPosition() != Notification.NO_INDEX) {
			sb.append(" index="); //$NON-NLS-1$
			sb.append(msg.getPosition());
		}
		sb.append(" OBJ: ").append(msg.getNotifier());
		switch (msg.getEventType()) {
		case Notification.REMOVING_ADAPTER:
			sb.append("\nadapter: ").append(ClassUtils.getLastClassName(msg.getOldValue())); //$NON-NLS-1$
			break;
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
		case Notification.RESOLVE:
			sb.append("\nresolved to: ").append(ClassUtils.getLastClassName(msg.getOldValue())); //$NON-NLS-1$
			break;
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

		return sb.toString();
	}

	/**
	 * The name for all defined {@link Notification#getEventType() event types}.
	 */
	private static final String[] NOTIFICATION_TYPE_NAMES = {
			"<illegal 0>", "SET", "UNSET", "ADD", "REMOVE", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			"ADD_MANY", "REMOVE_MANY", "MOVE", "REMOVING_ADAPTER", "RESOLVE", }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

}