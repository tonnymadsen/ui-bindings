package com.rcpcompany.uibindings.utils;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.internal.utils.BindingSpecFactory;

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
	public static final class Factory {
		private Factory() {

		}

		/**
		 * Parses and returns a new binding specification for the specified specification.
		 * 
		 * @param startType the starting type
		 * @param spec the spec to parse
		 * 
		 * @return the returned specification
		 */
		public static List<IBindingSpec> parseSingleSpec(EClass startType, String spec) {
			return BindingSpecFactory.parseSingleSpec(startType, spec);
		}
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
		 * Spec is based on feature.
		 * 
		 * @see IBindingSpec#getFeature()
		 */
		FEATURE("");

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
	 * Returns the feature of this spec.
	 * 
	 * @return the feature
	 */
	EStructuralFeature getFeature();

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
	 * The argument name for message collecting binding. The value has type {@link String} with the
	 * possible values "false", and "true".
	 */
	String COLLECT_MESSAGES = Constants.ARG_MODEL_OBJECT_MESSAGES;
}
