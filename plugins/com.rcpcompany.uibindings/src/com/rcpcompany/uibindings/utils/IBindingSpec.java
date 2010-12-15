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
package com.rcpcompany.uibindings.utils;

import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.internal.utils.BindingSpecFactory;
import com.rcpcompany.uibindings.observables.EListKeyedElementObservableValue;

/**
 * This interface is used to parse a text string that describes a binding target in terms of a
 * starting type and a string..
 * <p>
 * Format is described in the wiki.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IBindingSpec {
	/**
	 * Factory methods for {@link ITableCreator}.
	 */
	final class Factory {
		private Factory() {

		}

		/**
		 * Parses and returns a new binding specification for the specified specification.
		 * 
		 * @param startType the starting type
		 * @param spec the specification to parse
		 * @param context the context for the specification
		 * @return the returned specification
		 * 
		 * @throws IllegalArgumentException if the specification cannot be parsed
		 */
		public static List<IBindingSpec> parseSingleSpec(EClass startType, String spec, Context context) {
			return BindingSpecFactory.parseSingleSpec(startType, spec, context);
		}
	}

	/**
	 * The possible contexts for the parse operation.
	 * <p>
	 * The different values specifies which features will be available in the specification
	 * language.
	 */
	public enum Context {
		/**
		 * Specification for table column.
		 */
		TABLE_COLUMN,

		/**
		 * Specification for form.
		 */
		FORM_FIELD,

		/**
		 * Specification for an {@link IObservable observable} without UI aspects.
		 */
		OBSERVABLE
	}

	/**
	 * The possible base type for binding spec objects.
	 */
	public enum BaseType {
		/**
		 * Spec for "__NONE__".
		 */
		NONE("__NONE__"),

		/**
		 * Spec for "__ROW_NO__".
		 */
		ROW_NO("__ROW_NO__"),

		/**
		 * Spec for "__ROW_ELEMENT__".
		 */
		ROW_ELEMENT("__ROW_ELEMENT__"),

		/**
		 * Spec is based on feature.
		 * 
		 * @see IBindingSpec#getFeature()
		 */
		FEATURE(""),

		/**
		 * Spec is based on to-many feature with a key-value type.
		 * 
		 * @see IBindingSpec#getFeature()
		 * @see IBindingSpec#getKeyFeature()
		 * @see IBindingSpec#getKeyValue()
		 * @see IBindingSpec#getValueFeature()
		 * @see EListKeyedElementObservableValue
		 */
		KEY_VALUE("");

		private final String myName;

		BaseType(String name) {
			myName = name;
		}

		@Override
		public String toString() {
			return myName;
		}
	};

	/**
	 * Returns the base type of this spec.
	 * 
	 * @return the base type
	 */
	BaseType getType();

	/**
	 * Returns whether this specification is the last in the list.
	 * 
	 * @return <code>true</code> if last
	 */
	boolean isLast();

	/**
	 * Returns the feature of this spec.
	 * <p>
	 * Only relevant for {@link #getType()}<code> == </code>{@link BaseType#FEATURE} or
	 * {@link BaseType#KEY_VALUE}
	 * 
	 * @return the feature
	 */
	EStructuralFeature getFeature();

	/**
	 * Returns the result feature of this spec.
	 * <ul>
	 * <li>For #getType() == BaseType.FEATURE this is getFeature().</li>
	 * <li>For #getType() == BaseType.KEY_VALUE this is getValueFeature().</li>
	 * </ul>
	 * 
	 * @return the feature
	 */
	EStructuralFeature getResultFeature();

	/**
	 * Returns the key feature of this spec.
	 * <p>
	 * Only relevant for {@link #getType()}<code> == </code>{@link BaseType#KEY_VALUE}
	 * 
	 * @return the key feature
	 */
	EStructuralFeature getKeyFeature();

	/**
	 * Returns the key value of this spec.
	 * <p>
	 * Only relevant for {@link #getType()}<code> == </code>{@link BaseType#KEY_VALUE}
	 * 
	 * @return the key value
	 */
	Object getKeyValue();

	/**
	 * Returns the value feature of this spec.
	 * <p>
	 * Only relevant for {@link #getType()}<code> == </code>{@link BaseType#KEY_VALUE}
	 * 
	 * @return the value feature
	 */
	EStructuralFeature getValueFeature();

	/**
	 * Returns the associated arguments for the feature.
	 * <p>
	 * The supported arguments are all defined as constants in {@link IBindingSpec}.
	 * 
	 * @return the arguments
	 */
	Map<String, Object> getArguments();

	/**
	 * The argument name for the width of the binding. The value has type {@link Integer}.
	 * <p>
	 * Alias for {@link Constants#ARG_WIDTH}.
	 */
	String WIDTH = "w";

	/**
	 * The argument name for the height of the binding. The value has type {@link Integer}.
	 * <p>
	 * Alias for {@link Constants#ARG_HEIGHT}.
	 */
	String HEIGHT = "h";

	/**
	 * The argument name for the width weight of the binding. The value has type {@link Integer}.
	 */
	String WIDTH_WEIGHT = "ww";

	/**
	 * Alias for {@link Constants#ARG_DYNAMIC}.
	 */
	String DYNAMIC = "d";

	/**
	 * The argument name for the alignment of the binding. The value has type {@link String} with
	 * the possible values "l", "c" and "r".
	 * <p>
	 * Alias for {@link Constants#ARG_ALIGNMENT}.
	 */
	String ALIGNMENT = "a";

	/**
	 * The argument name for the scrollbars of the binding. The value has type {@link String} with
	 * the possible values "h" (horizontal), "v" (vertical) and "b" (both).
	 */
	String SCROLLBARS = "sb";

	/**
	 * The argument name for the tooltip of the binding. The value has type {@link String}.
	 */
	String TOOLTIP = Constants.ARG_TOOL_TIP_TEXT;

	/**
	 * The argument name for the label of the binding. The value has type {@link String}.
	 */
	String LABEL = Constants.ARG_LABEL;

	/**
	 * The argument name for the type of the binding. The value has type {@link String}.
	 */
	String TYPE = Constants.ARG_TYPE;

	/**
	 * The argument name for the message format of the binding. The value has type {@link String}.
	 */
	String MESSAGE_FORMAT = Constants.ARG_MESSAGE_FORMAT;

	/**
	 * The argument name for read-only of the binding. The value has type {@link String} with the
	 * possible values "false", and "true".
	 */
	String READONLY = Constants.ARG_READONLY;

	/**
	 * The argument name for multi-line binding. The value has type {@link String} with the possible
	 * values "false", and "true".
	 */
	String MULTI = "multi";

	/**
	 * The argument name for password fields. The value has type {@link String} with the possible
	 * values "false", and "true".
	 */
	String PASSWORD = Constants.ARG_PASSWORD;

	/**
	 * The argument name for message collecting binding. The value has type {@link String} with the
	 * possible values "false", and "true".
	 */
	String COLLECT_MESSAGES = Constants.ARG_MODEL_OBJECT_MESSAGES;
}
