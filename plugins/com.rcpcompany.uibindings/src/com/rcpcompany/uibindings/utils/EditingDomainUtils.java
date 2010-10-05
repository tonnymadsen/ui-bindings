package com.rcpcompany.uibindings.utils;

import java.util.Collection;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.IManager;

/**
 * {@link EditingDomain} utility methods for use in UI Bindings.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EditingDomainUtils {
	/**
	 * Constructor to insure the utility class cannot be constructed.
	 */
	private EditingDomainUtils() {
	}

	/**
	 * Returns the editing domain to use...
	 * 
	 * @return the editing domain
	 */
	public static EditingDomain getEditingDomain() {
		return IManager.Factory.getManager().getEditingDomain();
	}

	/**
	 * Adds an object to the specified cotainer.
	 * 
	 * @param container the container
	 * @param feature the reference to the value
	 * @param value the new value
	 */
	public static void add(EObject container, EStructuralFeature feature, Object value) {
		execute(AddCommand.create(getEditingDomain(), container, feature, value));
	}

	/**
	 * @param container
	 * @param feature
	 * @param value
	 */
	public static void add(EObject container, EStructuralFeature feature, Object value, int index) {
		execute(AddCommand.create(getEditingDomain(), container, feature, value, index));
	}

	/**
	 * @param container
	 * @param feature
	 * @param value
	 */
	public static void add(EObject container, EStructuralFeature feature, Collection<? extends Object> values) {
		final CompoundCommand compoundCommand = new CompoundCommand();
		for (final Object obj : values) {
			compoundCommand.append(AddCommand.create(getEditingDomain(), container, feature, obj));
		}
		execute(compoundCommand);
	}

	/**
	 * @param container
	 * @param feature
	 * @param value
	 */
	public static void remove(EObject container, EStructuralFeature feature, Object value) {
		execute(RemoveCommand.create(getEditingDomain(), container, feature, value));
	}

	public static void delete(EObject element) {
		execute(DeleteCommand.create(getEditingDomain(), element));
	}

	/**
	 * @param container
	 * @param feature
	 * @param value
	 */
	public static void remove(EObject container, EStructuralFeature feature, Collection<? extends Object> values) {
		final CompoundCommand compoundCommand = new CompoundCommand();
		for (final Object obj : values) {
			final Command cmd = RemoveCommand.create(getEditingDomain(), container, feature, obj);
			compoundCommand.append(cmd);
		}
		execute(compoundCommand);
	}

	/**
	 * @param container
	 * @param feature
	 * @param value
	 */
	public static void set(EObject container, EStructuralFeature feature, Object value) {
		final Object oldValue = container.eGet(feature);
		if (oldValue == null ? value == null : oldValue.equals(value)) return;
		execute(SetCommand.create(getEditingDomain(), container, feature, value));
	}

	/**
	 * @param container
	 * @param feature
	 * @param value
	 */
	public static void set(EObject container, EStructuralFeature feature, Object value, int index) {
		execute(SetCommand.create(getEditingDomain(), container, feature, value, index));
	}

	public static BasicCommandStack getCommandStack() {
		return (BasicCommandStack) getEditingDomain().getCommandStack();
	}

	/**
	 * Executes the specified command if possible.
	 * 
	 * @param cmd the command to execute.
	 */
	public static void execute(Command cmd) {
		if (!cmd.canExecute()) throw new IllegalArgumentException("Command cannot be executed");
		getCommandStack().execute(cmd);
	}
}
