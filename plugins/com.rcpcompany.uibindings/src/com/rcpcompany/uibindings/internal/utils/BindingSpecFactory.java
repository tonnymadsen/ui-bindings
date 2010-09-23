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
package com.rcpcompany.uibindings.internal.utils;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.utils.IBindingSpec;
import com.rcpcompany.uibindings.utils.IBindingSpec.BaseType;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Factory for {@link IBindingSpec}.
 * <p>
 * For unit conversions, it supports the following from <a
 * href="http://www.w3schools.com/css/css_units.asp">the CSS2 standard</a>:
 * <dl>
 * <dt>px</dt>
 * <dd>pixels (a dot on the computer screen)</dd>
 * <dt>em</dt>
 * <dd>1em is equal to the current font size. 2em means 2 times the size of the current font. E.g.,
 * if an element is displayed with a font of 12 pt, then '2em' is 24 pt. The 'em' is a very useful
 * unit in CSS, since it can adapt automatically to the font that the reader uses</dd>
 * <dt>mm</dt>
 * <dd>millimeter</dd>
 * </dl>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public final class BindingSpecFactory {
	private BindingSpecFactory() {

	}

	/**
	 * The aliases: alias -&gt; canonical version.
	 */
	private static final Map<String, String> ALIASES = new HashMap<String, String>();

	/**
	 * The types of all all defined arguments.
	 */
	private static final Map<String, Class<?>> ARGUMENT_TYPES = new HashMap<String, Class<?>>();

	/**
	 * List of the arguments that supports a unit.
	 */
	private static final Map<String, Boolean> ARGUMENTS_WITH_UNITS = new HashMap<String, Boolean>();

	/**
	 * The display used for unit conversions.
	 */
	private static final Display DISPLAY;

	/**
	 * The font metrics used for the default font. Used for unit conversions.
	 */
	private static FontMetrics theFontMetrics;

	/**
	 * The current font height used for unit conversions.
	 */
	private static float theFontHeight;

	static {
		ALIASES.put(IBindingSpec.WIDTH, Constants.ARG_WIDTH);
		ARGUMENT_TYPES.put(Constants.ARG_WIDTH, Integer.class);
		ARGUMENTS_WITH_UNITS.put(Constants.ARG_WIDTH, true);

		ALIASES.put(IBindingSpec.HEIGHT, Constants.ARG_HEIGHT);
		ARGUMENT_TYPES.put(Constants.ARG_HEIGHT, Integer.class);

		ALIASES.put(IBindingSpec.DYNAMIC, Constants.ARG_WIDTH);

		ARGUMENT_TYPES.put(IBindingSpec.WIDTH_WEIGHT, Integer.class);

		ALIASES.put(IBindingSpec.ALIGNMENT, Constants.ARG_ALIGNMENT);
		ARGUMENT_TYPES.put(Constants.ARG_ALIGNMENT, String.class);

		ARGUMENT_TYPES.put(IBindingSpec.SCROLLBARS, String.class);
		ARGUMENT_TYPES.put(IBindingSpec.MULTI, Boolean.class);
		ARGUMENT_TYPES.put(IBindingSpec.COLLECT_MESSAGES, Boolean.class);

		ARGUMENT_TYPES.put(Constants.ARG_READONLY, Boolean.class);
		ARGUMENT_TYPES.put(Constants.ARG_DYNAMIC, Boolean.class);
		ARGUMENT_TYPES.put(Constants.ARG_PASSWORD, Boolean.class);
		ARGUMENT_TYPES.put(Constants.ARG_TOOL_TIP_TEXT, String.class);
		ARGUMENT_TYPES.put(Constants.ARG_LABEL, String.class);
		ARGUMENT_TYPES.put(Constants.ARG_TYPE, String.class);
		ARGUMENT_TYPES.put(Constants.ARG_MESSAGE_FORMAT, String.class);
		ARGUMENT_TYPES.put(Constants.ARG_UNIT, String.class);

		// Compute and store a font metric
		DISPLAY = Display.getDefault();
		final GC gc = new GC(DISPLAY);
		final Font f = JFaceResources.getDefaultFont();
		theFontHeight = f.getFontData()[0].height;
		gc.setFont(f);
		theFontMetrics = gc.getFontMetrics();
		gc.dispose();
	}

	/**
	 * All calculated specs so far.
	 */
	private static final Map<EClass, Map<String, List<IBindingSpec>>> CALCULATED_SPECS = new HashMap<EClass, Map<String, List<IBindingSpec>>>();

	/**
	 * Parses the specified spec based on the specified startType and returns the calculated spec
	 * list.
	 * 
	 * @param startType the start type
	 * @param spec the specification
	 * @return the spec list
	 */
	public static List<IBindingSpec> parseSingleSpec(EClass startType, String spec) {
		Map<String, List<IBindingSpec>> typeSpecs = CALCULATED_SPECS.get(startType);
		if (typeSpecs == null) {
			typeSpecs = new HashMap<String, List<IBindingSpec>>();
			CALCULATED_SPECS.put(startType, typeSpecs);
		}
		List<IBindingSpec> sl = typeSpecs.get(spec);
		if (sl != null) return sl;

		sl = new ArrayList<IBindingSpec>();

		EClass type = startType;
		try {
			final StreamTokenizer st = createTokenizer(spec);
			st.nextToken();

			while (st.ttype == StreamTokenizer.TT_WORD) {
				final String featureName = st.sval;
				final IBindingSpec s;
				if (type == null) {
					LogUtils.throwException(startType, "In spec: '" + spec + "': Composite '" + featureName
							+ "' not allowed unless previous feature has a EClass type", null);
				}
				if (featureName.equals(BaseType.NONE.toString())) {
					s = new MyBindingSpecOther(BaseType.NONE);
					type = null;
				} else if (featureName.equals(BaseType.ROW_NO.toString())) {
					s = new MyBindingSpecOther(BaseType.ROW_NO);
					type = null;
				} else if (featureName.equals(BaseType.ROW_ELEMENT.toString())) {
					s = new MyBindingSpecOther(BaseType.ROW_ELEMENT);
					type = null;
				} else {
					EStructuralFeature feature = type.getEStructuralFeature(featureName);
					/*
					 * No direct match... Try ignoring case!
					 */
					if (feature == null) {
						for (final EStructuralFeature f : type.getEAllStructuralFeatures()) {
							if (f.getName().equalsIgnoreCase(featureName)) {
								feature = f;
								break;
							}
						}
					}
					if (feature == null) {
						LogUtils.throwException(startType, "In spec: '" + spec + "': " + startType.getName() + "#"
								+ featureName + " does not exist", null);
						// Not reached!
					}
					s = new MyBindingSpecFeature(feature);
					if (feature.getEType() instanceof EClass) {
						type = (EClass) feature.getEType();
					} else {
						type = null;
					}
				}
				sl.add(s);
				st.nextToken();
				if (st.ttype == '(') {
					st.nextToken();
					final Map<String, Object> arguments = s.getArguments();

					while (st.ttype == StreamTokenizer.TT_WORD) {
						String argName = st.sval;
						if (ALIASES.containsKey(argName)) {
							argName = ALIASES.get(argName);
						}
						Object argValue = null;
						String argUnit = null;
						st.nextToken();
						if (st.ttype == '=') {
							st.nextToken();
							switch (st.ttype) {
							case StreamTokenizer.TT_NUMBER:
								argValue = (int) (st.nval);
								st.nextToken();
								break;
							case StreamTokenizer.TT_WORD:
								argValue = st.sval;
								st.nextToken();
								break;
							case '"':
							case '\'':
								argValue = st.sval;
								st.nextToken();
								break;
							default:
								LogUtils.throwException(startType, "In spec: '" + spec
										+ "': In arguments:='('<name>{=}: "
										+ "expected one of integer, string or word, got '" + st.toString() + "'", null);
							}
							if (st.ttype == StreamTokenizer.TT_WORD) {
								argUnit = st.sval;
								st.nextToken();
							}
						} else if ((st.ttype == ',') || (st.ttype == ')')) {
							argValue = "true";
						} else {
							LogUtils.throwException(startType,
									"In spec: '" + spec
											+ "': In arguments:='('<name>{'='<value>}','++')': expected '=', got '"
											+ st.toString() + "'", null);
						}
						// Check the argument names and values
						if (!ARGUMENT_TYPES.containsKey(argName)) {
							for (final String nn : ARGUMENT_TYPES.keySet()) {
								if (nn.equalsIgnoreCase(argName)) {
									argName = nn;
									break;
								}
							}
						}
						if (!ARGUMENT_TYPES.containsKey(argName)) {
							LogUtils.throwException(startType, "In spec: '" + spec + "': Unknown argument '" + argName
									+ "'", null);
						}
						final Class<?> argClass = ARGUMENT_TYPES.get(argName);
						if (argClass == Boolean.class) {
							argValue = Boolean.parseBoolean("" + argValue);
						} else if (!(argClass.isInstance(argValue))) {
							LogUtils.throwException(
									startType,
									"In spec: '" + spec + "': Argument '" + argName + "' takes an "
											+ argClass.getSimpleName() + " as argument, got '" + argValue + "'", null);
						}
						if (ARGUMENTS_WITH_UNITS.get(argName) == Boolean.TRUE) {
							final float factor;
							if (argUnit == null) {
								factor = 1;
							} else if (argUnit.equals("px")) {
								factor = 1;
							} else if (argUnit.equals("em")) {
								factor = theFontHeight;
							} else if (argUnit.equals("mm")) {
								factor = DISPLAY.getDPI().x / 25.4f;
							} else if (argUnit.equals("dlu")) {
								factor = theFontHeight / 4.0f;
							} else {
								factor = 0;
								LogUtils.throwException(startType, "In spec: '" + spec + "': Unit of argument '"
										+ argName + "' can be 'em', 'dlu' or 'mm', got '" + argUnit + "'", null);
							}
							argValue = Math.round(((Integer) argValue) * factor);
						} else {
							if (argUnit != null) {
								LogUtils.throwException(startType, "In spec: '" + spec + "': Argument '" + argName
										+ "' does not support units, got unit '" + argUnit + "'", null);
							}
						}
						if (arguments.containsKey(argName)) {
							LogUtils.throwException(startType, "In spec: '" + spec + "': Argument '" + argName
									+ "' specified multiple times", null);
						}
						arguments.put(argName, argValue);

						// More arguments?
						if (st.ttype == ',') {
							st.nextToken();
						} else if (st.ttype == ')') {
							break;
						} else {
							LogUtils.throwException(
									startType,
									"In spec: '"
											+ spec
											+ "': In arguments:='('<name>{'='<value>}','++')': expected one of ',' or ')', got '"
											+ st.toString() + "'", null);
						}
					}
					// End of arguments
					if (st.ttype == ')') {
						st.nextToken();
					} else {
						LogUtils.throwException(
								startType,
								"In spec: '"
										+ spec
										+ "': In arguments:='('<name>{'='<value>}','++')': expected <name> or ')', got '"
										+ st.toString() + "'", null);
					}
				}
				if (st.ttype == '.') {
					st.nextToken();
					continue;
				}
				if (st.ttype == StreamTokenizer.TT_EOF) {
					break;
				}
			}
			if (st.ttype != StreamTokenizer.TT_EOF) {
				LogUtils.throwException(startType, "In spec: '" + spec
						+ "': In spec:=<feature><arguments>?: expected '<feature>', got '" + st.toString() + "'", null);
			}
		} catch (final IOException ex) {
			LogUtils.throwException(startType, "", ex);
		}
		typeSpecs.put(spec, sl);
		return sl;
	}

	/**
	 * Creates and returns a new tokenizer for the specified string.
	 * 
	 * @param spec the specification string
	 * @return the new tokenizer
	 */
	private static StreamTokenizer createTokenizer(String spec) {
		final StreamTokenizer st = new StreamTokenizer(new StringReader(spec));
		// st.commentChar('#');
		st.lowerCaseMode(false);
		st.parseNumbers();
		st.quoteChar('"');
		st.quoteChar('\'');
		st.slashSlashComments(false);
		st.slashStarComments(false);
		st.ordinaryChar('.');
		st.wordChars('_', '_');

		return st;
	}

	protected static class MyBindingSpecFeature extends MyBindingSpecBase {

		private final EStructuralFeature myFeature;

		protected MyBindingSpecFeature(EStructuralFeature feature) {
			myFeature = feature;
		}

		@Override
		public BaseType getType() {
			return BaseType.FEATURE;
		}

		@Override
		public EStructuralFeature getFeature() {
			return myFeature;
		}
	}

	protected static class MyBindingSpecOther extends MyBindingSpecBase {

		private final BaseType myType;

		protected MyBindingSpecOther(BaseType type) {
			myType = type;
		}

		@Override
		public BaseType getType() {
			return myType;
		}

		@Override
		public EStructuralFeature getFeature() {
			return null;
		}
	}

	protected abstract static class MyBindingSpecBase implements IBindingSpec {

		private Map<String, Object> myArguments;

		@Override
		public Map<String, Object> getArguments() {
			if (myArguments == null) {
				myArguments = new HashMap<String, Object>();
			}
			return myArguments;
		}
	}
}
