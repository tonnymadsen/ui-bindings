/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.internal.utils.dnd.ContainerDragAndDropCommand;
import com.rcpcompany.uibindings.model.utils.EcoreExtendedUtils;
import com.rcpcompany.uibindings.model.utils.EcoreExtendedUtils.SyncController;
import com.rcpcompany.uibindings.utils.IBindingObjectInformation;

/**
 * Various Ecore oriented utility methods.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public final class EcoreExtUtils {
	private EcoreExtUtils() {

	}

	public static final EditingDomain THE_EDITING_DOMAIN = UIBindingsUtils.createEditingDomain();

	/**
	 * Synchronizes the information from the <code>source</code> object into the <code>target</code>
	 * object.
	 * <p>
	 * The sync is potentially destructive for the <code>source</code> object.
	 * 
	 * @param target the object synchronized into
	 * @param source the object synchronized from
	 */
	public static <T extends EObject> SyncController sync(T target, T source) {
		return EcoreExtendedUtils.sync(THE_EDITING_DOMAIN, target, source);
	}

	/**
	 * Synchronizes the information from the <code>source</code> object into the <code>target</code>
	 * object.
	 * <p>
	 * The sync is potentially destructive for the <code>source</code> list.
	 * 
	 * @param target the object synchronized into
	 * @param source the object synchronized from
	 */
	public static <T extends EObject> SyncController sync(EList<T> target, EList<T> source) {
		return EcoreExtendedUtils.sync(THE_EDITING_DOMAIN, target, source);
	}

	/**
	 * Returns a string that describes the specified command is clear human readable text.
	 * 
	 * @param c the command
	 * @return the clear text description
	 */
	public static String toString(Command c) {
		if (c == null) return "<null>";

		final StringBuilder sb = new StringBuilder(50);

		sb.append(c.getClass().getSimpleName()).append('(');
		if (c instanceof IdentityCommand) {
		} else if (c instanceof UnexecutableCommand) {
		} else if (c instanceof AddCommand) {
			final AddCommand cc = (AddCommand) c;

			sb.append(getEObjectName(cc.getOwner())).append(", ").append(cc.getFeature().getName()).append(", ")
					.append(toString(cc.getCollection()));
			if (cc.getFeature().isMany() && cc.getIndex() != -1) {
				sb.append(", ").append(cc.getIndex());
			}
		} else if (c instanceof RemoveCommand) {
			final RemoveCommand cc = (RemoveCommand) c;

			sb.append(getEObjectName(cc.getOwner())).append(", ").append(cc.getFeature().getName()).append(", ")
					.append(toString(cc.getCollection()));
		} else if (c instanceof MoveCommand) {
			final MoveCommand cc = (MoveCommand) c;

			sb.append(getEObjectName(cc.getOwner())).append(", ").append(cc.getFeature().getName()).append(", ")
					.append(toString(cc.getValue())).append(", ").append(cc.getIndex());
		} else if (c instanceof SetCommand) {
			final SetCommand cc = (SetCommand) c;

			sb.append(getEObjectName(cc.getOwner())).append(", ").append(cc.getFeature().getName()).append(", ")
					.append(formatSetCommandArg(cc.getOldValue())).append(", ")
					.append(formatSetCommandArg(cc.getValue()));
			if (cc.getFeature().isMany()) {
				sb.append(", ").append(cc.getIndex());
			}
		} else if (c instanceof CompoundCommand) {
			final CompoundCommand cc = (CompoundCommand) c;
			boolean first = true;
			for (final Command ic : cc.getCommandList()) {
				if (!first) {
					sb.append(", ");
				}
				sb.append(toString(ic));
				first = false;

			}
		} else if (c instanceof ContainerDragAndDropCommand) {
			final ContainerDragAndDropCommand cc = (ContainerDragAndDropCommand) c;
			sb.append(toString(cc.getDragCommand())).append(", ").append(toString(cc.getDropCommand()));
		} else {
			sb.append("...");
		}
		sb.append(')');
		return sb.toString();
	}

	private static String toString(Object o) {
		final StringBuilder sb = new StringBuilder(200);
		if (o instanceof EObject) {
			sb.append(IBindingObjectInformation.Factory.getLongName((EObject) o));
		} else {
			sb.append(o);
		}
		return sb.toString();
	}

	private static String toString(Collection<?> collection) {
		final StringBuilder sb = new StringBuilder(200);
		sb.append('[');
		for (final Object o : collection) {
			if (sb.length() > 1) {
				sb.append(", ");
			}
			sb.append(toString(o));
		}
		sb.append(']');
		return sb.toString();
	}

	private static String formatSetCommandArg(Object oldValue) {
		return (oldValue == SetCommand.UNSET_VALUE) ? "<default> " : ("" + oldValue);
	}

	private static String getEObjectName(EObject owner) {
		return IBindingObjectInformation.Factory.getQualifiedName(owner);
	}

	/**
	 * Returns a list of all <em>known</em> sub-classes for the specified class.
	 * 
	 * @param cls the super-class
	 * @return list of all sub-classes - possibly <code>null</code>
	 * @deprecated Use {@link EcoreExtendedUtils#getSubClasses(EClass)} instead
	 */
	@Deprecated
	public static Collection<EClass> getSubClasses(EClass cls) {
		return EcoreExtendedUtils.getSubClasses(cls);
	}
}
