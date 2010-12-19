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
import java.util.StringTokenizer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.utils.IBindingSpec;
import com.rcpcompany.uibindings.utils.IBindingSpec.BaseType;
import com.rcpcompany.uibindings.utils.IBindingSpec.SpecContext;
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
		theFontHeight = f.getFontData()[0].getHeight();
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
	 * @param context the context for the specification
	 * @return the spec list or <code>null</code> if the specification cannot be parsed
	 */
	public static List<IBindingSpec> parseSingleSpec(final EClass startType, final String spec,
			final SpecContext context) {
		Map<String, List<IBindingSpec>> typeSpecs = CALCULATED_SPECS.get(startType);
		if (typeSpecs == null) {
			typeSpecs = new HashMap<String, List<IBindingSpec>>();
			CALCULATED_SPECS.put(startType, typeSpecs);
		}
		final List<IBindingSpec> oldSL = typeSpecs.get(spec);
		if (oldSL != null) return oldSL;

		final List<IBindingSpec> newSL = new ArrayList<IBindingSpec>();

		try {
			final IBindingSpecParserContext pc = new MyBindingSpecParserContext(newSL, context, spec, startType);

			pc.nextToken();
			while (!pc.isTokenType(StreamTokenizer.TT_EOF)) {
				parseBaseSpec(pc);

				if (pc.isTokenType('(')) {
					parseSpecArguments(pc);
				}
				if (pc.isTokenType('.')) {
					pc.nextToken();
					continue;
				}
				if (pc.isTokenType(StreamTokenizer.TT_EOF)) {
					break;
				}
			}
			if (!pc.isTokenType(StreamTokenizer.TT_EOF)) {
				pc.syntaxError("Spec ::= BaseSpec Arguments?", "<feature>");
			}

			if (pc.getLastSpec() != null) {
				pc.getLastSpec().setLast(true);
			}
			/*
			 * All but the last spec must be a to-one
			 */
			for (final IBindingSpec s : newSL) {
				final EStructuralFeature resultFeature = s.getResultFeature();

				if (s.isLast() && pc.getSpecContext() == SpecContext.OBSERVABLE) {
					if (!(resultFeature instanceof EReference)) {
						pc.error("Last feature " + resultFeature.getContainerClass().getName() + "."
								+ resultFeature.getName() + " is not reference");
					}
					break;
				}

				if (resultFeature != null && resultFeature.isMany()) {
					pc.error("Feature " + resultFeature.getContainerClass().getName() + "." + resultFeature.getName()
							+ "." + " must be to-one");
				}
			}
		} catch (final IOException ex) {
			LogUtils.error(startType, "", ex);
			return null;
		} catch (final RuntimeException ex) {
			return null;
		}

		typeSpecs.put(spec, newSL);
		return newSL;
	}

	/**
	 * Parses the base part of a specification.
	 * <p>
	 * Spec ::= BaseSpec Arguments?
	 * 
	 * BaseSpec ::= ( Feature | Feature | ContainerSpec )
	 * 
	 * @param pc the parse context
	 * @throws IOException from {@link StringTokenizer}
	 */
	private static void parseBaseSpec(final IBindingSpecParserContext pc) throws IOException {
		pc.newSpecLevel();
		if (pc.getSpecClass() == null) {
			pc.error("New level not allowed unless previous level has a EClass type");
		}

		String featureName = null;
		if (pc.isTokenType(StreamTokenizer.TT_WORD)) {
			featureName = pc.getTokenString();
			pc.nextToken();

			final BaseType bt = BaseType.parse(featureName);
			if (bt != null) {
				pc.checkContext("Virtual feature " + bt + " only supported for tables", SpecContext.TABLE_COLUMN);
				pc.addSpec(new MyBindingSpecVirtual(bt), null);
			} else {
				final EStructuralFeature feature = findFeature(pc.getSpec(), pc.getSpecClass(), featureName);
				/*
				 * PARSE: optional MapSpec:=***'('<name>'='<value>':'<name>'}'
				 */
				if (pc.isTokenType('{')) {
					parseMapSpec(pc, feature);
				} else {
					if (feature.getEType() instanceof EClass) {
						pc.addSpec(new MyBindingSpecFeature(feature), (EClass) feature.getEType());
					} else {
						pc.addSpec(new MyBindingSpecFeature(feature), null);
					}
				}
			}
		} else if (pc.isTokenType('^')) {
			parseContainerSpec(pc);
		} else {
			pc.syntaxError("BaseSpec ::= ( Feature | Feature | ContainerSpec )", "one of word or '^'");
		}
	}

	/**
	 * Parses container.
	 * <p>
	 * Container ::= '^' ( | '^' '=' EClass )
	 * 
	 * @param pc the parse context
	 * @throws IOException from {@link StreamTokenizer}
	 */
	private static void parseContainerSpec(IBindingSpecParserContext pc) throws IOException {
		pc.nextToken();

		if (pc.isTokenType('^')) {
			pc.nextToken();
			if (!pc.isTokenType('=')) {
				pc.syntaxError("Container ::= '^' ( | '^'***'=' EClass )", "'='");
			}
			pc.nextToken();
			if (!pc.isTokenType(StreamTokenizer.TT_WORD)) {
				pc.syntaxError("Container ::= '^' ( | '^' '=' *** EClass )", "<EClass>");
			}
			final String containerClass = pc.getTokenString();
			pc.nextToken();

			pc.error("Not implemented");
		} else {
			for (final EReference ref : pc.getSpecClass().getEReferences()) {
				if (ref.isContainer()) {
					pc.addSpec(new MyBindingSpecFeature(ref), ref.getEReferenceType());
					return;
				}
			}
			pc.error(pc.getSpecClass() + " does not have a container.");
		}
	}

	/**
	 * Parses MapSpec.
	 * <p>
	 * MapSpec ::= '('<name>'='<value>':'<name>'}'
	 * 
	 * @param pc the parse context
	 * @param feature the feature
	 * @throws IOException
	 */
	private static void parseMapSpec(final IBindingSpecParserContext pc, final EStructuralFeature feature)
			throws IOException {
		pc.nextToken();

		/*
		 * Feature must be to-many reference
		 */
		if (!(feature instanceof EReference)) {
			pc.error("Feature " + feature.getContainerClass().getName() + "." + feature.getName() + " is not reference");
		}
		if (!feature.isMany()) {
			pc.error("Feature " + feature.getContainerClass().getName() + "." + feature.getName() + " must be to-many");
		}
		if (!((EReference) feature).isContainment()) {
			pc.error("Feature " + feature.getContainerClass().getName() + "." + feature.getName()
					+ " must be containment");
		}

		/*
		 * Type of detail
		 */
		final EClass defailClass = (EClass) feature.getEType();

		/*
		 * PARSE: MapSpec:='('***<name>'='<value>':'<name>'}'
		 */
		if (!pc.isTokenType(StreamTokenizer.TT_WORD)) {
			pc.syntaxError("MapSpec:='('***<name>'='<value>':'<name>'}'", "<name>");
		}
		final EStructuralFeature keyFeature = findFeature(pc.getSpec(), defailClass, pc.getTokenString());
		pc.nextToken();

		/*
		 * PARSE: MapSpec:='('<name>***'='<value>':'<name>'}'
		 */
		if (pc.isTokenType('=')) {
			pc.nextToken();
		} else {
			pc.syntaxError("MapSpec:='('<name>***'='<value>':'<name>'}'", "=");
		}

		/*
		 * PARSE: MapSpec:='('***<name>'='<value>':'<name>'}'
		 */
		Object keyValue = null;
		switch (pc.getTokenType()) {
		case StreamTokenizer.TT_NUMBER:
			keyValue = pc.getTokenInteger();
			pc.nextToken();
			break;
		case StreamTokenizer.TT_WORD:
			keyValue = pc.getTokenString();
			pc.nextToken();
			break;
		case '"':
		case '\'':
			keyValue = pc.getTokenString();
			pc.nextToken();
			break;
		default:
			pc.syntaxError("MapSpec:='('<name>'='***<value>':'<name>'}'", "one of integer, string or word");
		}

		/*
		 * PARSE: MapSpec:='('<name>'='<value>':'<name>***'}'
		 */
		if (pc.isTokenType(':')) {
			pc.nextToken();
		} else {
			pc.syntaxError("MapSpec:='('<name>'='<value>***':'<name>'}'", "':'");
		}

		/*
		 * PARSE: MapSpec:='('<name>'='<value>':'***<name>'}'
		 */
		if (!pc.isTokenType(StreamTokenizer.TT_WORD)) {
			pc.syntaxError("MapSpec:='('<name>'='<value>':***'<name>'}'", "'<name>'");
		}
		final EStructuralFeature valueFeature = findFeature(pc.getSpec(), defailClass, pc.getTokenString());
		pc.nextToken();

		if (keyFeature == valueFeature) {
			pc.error("key and value features identical: " + keyFeature.getContainerClass().getName() + "."
					+ keyFeature.getName());
		}

		if (valueFeature.getEType() instanceof EClass) {
			pc.addSpec(new MyBindingSpecFeatureKeyValue(feature, keyFeature, keyValue, valueFeature),
					(EClass) feature.getEType());
		} else {
			pc.addSpec(new MyBindingSpecFeatureKeyValue(feature, keyFeature, keyValue, valueFeature), null);
		}

		/*
		 * PARSE: MapSpec:='('<name>'='<value>':'<name>***'}'
		 */
		if (pc.isTokenType('}')) {
			pc.nextToken();
		} else {
			pc.syntaxError("MapSpec:='('<name>'='<value>':'<name>***'}'", "'}'");
		}
	}

	/**
	 * Parses an argument.
	 * <p>
	 * Arguments ::= '(' Argument ( ',' Argument )+ ')' Argument ::= Name ( '=' Value Unit? )?
	 * 
	 * @param pc the parse context
	 * @throws IOException from {@link StreamTokenizer}
	 */
	private static void parseSpecArguments(final IBindingSpecParserContext pc) throws IOException {
		pc.checkContext("Arguments are not supported", SpecContext.FORM_FIELD, SpecContext.TABLE_COLUMN);
		pc.nextToken();
		final Map<String, Object> arguments = pc.getLastSpec().getArguments();

		while (pc.isTokenType(StreamTokenizer.TT_WORD)) {
			String argName = pc.getTokenString();
			pc.nextToken();
			if (ALIASES.containsKey(argName)) {
				argName = ALIASES.get(argName);
			}
			Object argValue = null;
			String argUnit = null;
			if (pc.isTokenType('=')) {
				pc.nextToken();
				argValue = pc.getTokenArgumentValue();
				if (argValue == null) {
					pc.syntaxError("Argument ::= Name ( '=' *** Value Unit? )?", "one of integer, string or word");
				}
				if (pc.isTokenType(StreamTokenizer.TT_WORD)) {
					argUnit = pc.getTokenString();
					pc.nextToken();
				}
			} else if ((pc.isTokenType(',')) || (pc.isTokenType(')'))) {
				argValue = "true";
			} else {
				pc.syntaxError("Argument ::= Name ( *** '=' Value Unit? )?", "'='");
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
				pc.error("Unknown argument '" + argName + "'");
			}
			final Class<?> argClass = ARGUMENT_TYPES.get(argName);
			if (argClass == Boolean.class) {
				argValue = Boolean.parseBoolean("" + argValue);
			} else if (!(argClass.isInstance(argValue))) {
				pc.error("Argument '" + argName + "' takes an " + argClass.getSimpleName() + " as argument, got '"
						+ argValue + "'");
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
					pc.error("Unit of argument '" + argName + "' can be 'em', 'dlu' or 'mm', got '" + argUnit + "'");
				}
				argValue = Math.round(((Integer) argValue) * factor);
			} else {
				if (argUnit != null) {
					pc.error("Argument '" + argName + "' does not support units, got unit '" + argUnit + "'");
				}
			}
			if (arguments.containsKey(argName)) {
				pc.error("Argument '" + argName + "' specified multiple times");
			}
			arguments.put(argName, argValue);

			// More arguments?
			if (pc.isTokenType(',')) {
				pc.nextToken();
			} else if (pc.isTokenType(')')) {
				break;
			} else {
				pc.syntaxError("Arguments ::= '(' Argument *** ( ',' Argument )+ ')'", "one of ',' or ')'");
			}
		}
		// End of arguments
		if (pc.isTokenType(')')) {
			pc.nextToken();
		} else {
			pc.syntaxError("Arguments ::= '(' Argument ( ',' Argument )+ *** ')'", "<name> or ')'");
		}
	}

	/**
	 * @param spec
	 * @param type
	 * @param featureName
	 * @return
	 */
	private static EStructuralFeature findFeature(String spec, EClass type, final String featureName) {
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
			LogUtils.throwException(type, "In spec: '" + spec + "': " + type.getName() + "#" + featureName
					+ " does not exist", null);
			// Not reached!
		}
		return feature;
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

	/**
	 * Implementation of {@link IBindingSpecParserContext} used in
	 * {@link BindingSpecFactory#parseSingleSpec(EClass, String, SpecContext)}.
	 */
	private static final class MyBindingSpecParserContext implements IBindingSpecParserContext {
		private final List<IBindingSpec> myNewSL;
		private final SpecContext myContext;
		private final String mySpec;
		private final EClass myStartType;
		final StreamTokenizer st;
		private MyBindingSpecBase myLastSpec = null;
		private EClass mySpecClass;

		private MyBindingSpecParserContext(List<IBindingSpec> newSL, SpecContext context, String spec, EClass startType) {
			myNewSL = newSL;
			myContext = context;
			mySpec = spec;
			myStartType = startType;
			st = createTokenizer(mySpec);
			mySpecClass = myStartType;
		}

		@Override
		public void newSpecLevel() {
			myLastSpec = null;
		}

		@Override
		public void addSpec(MyBindingSpecBase spec, EClass newSpecClass) {
			myNewSL.add(spec);
			myLastSpec = spec;
			mySpecClass = newSpecClass;
		}

		@Override
		public MyBindingSpecBase getLastSpec() {
			return myLastSpec;
		}

		@Override
		public EClass getSpecClass() {
			return mySpecClass;
		}

		@Override
		public void nextToken() throws IOException {
			st.nextToken();
		}

		@Override
		public int getTokenType() {
			return st.ttype;
		}

		@Override
		public String getTokenString() {
			switch (st.ttype) {
			case '"':
			case '\'':
			case StreamTokenizer.TT_WORD:
				return st.sval;
			default:
				throw new IllegalArgumentException("Not a string token!");
			}
		}

		@Override
		public int getTokenInteger() {
			if (st.ttype != StreamTokenizer.TT_NUMBER) throw new IllegalArgumentException("Not a number !");
			return (int) st.nval;
		}

		@Override
		public Object getTokenArgumentValue() throws IOException {
			Object value = null;
			switch (getTokenType()) {
			case StreamTokenizer.TT_NUMBER:
				value = getTokenInteger();
				nextToken();
				break;
			case StreamTokenizer.TT_WORD:
				value = getTokenString();
				nextToken();
				break;
			case '"':
			case '\'':
				value = getTokenString();
				nextToken();
				break;
			default:
				break;
			}

			return value;
		}

		@Override
		public boolean isTokenType(int token) {
			return getTokenType() == token;
		}

		@Override
		public String getSpec() {
			return mySpec;
		}

		@Override
		public SpecContext getSpecContext() {
			return myContext;
		}

		@Override
		public void checkContext(String message, SpecContext... legalContexts) {
			for (final SpecContext c : legalContexts) {
				if (c == getSpecContext()) return;
			}
			error(message);
		}

		@Override
		public void error(String message) {
			LogUtils.throwException(myStartType, "In spec: '" + getSpec() + "': " + message, null);
		}

		@Override
		public void syntaxError(String bnf, String expectedToken) {
			error("In " + bnf + ": expected " + expectedToken + ", got '" + st.toString() + "'");
		}
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

		@Override
		public EStructuralFeature getResultFeature() {
			return getFeature();
		}
	}

	protected static class MyBindingSpecFeatureKeyValue extends MyBindingSpecBase {
		private final EStructuralFeature myFeature;
		private final EStructuralFeature myKeyFeature;
		private final Object myKeyValue;
		private final EStructuralFeature myValueFeature;

		protected MyBindingSpecFeatureKeyValue(EStructuralFeature feature, EStructuralFeature keyFeature,
				Object keyValue, EStructuralFeature valueFeature) {
			myFeature = feature;
			myKeyFeature = keyFeature;
			myKeyValue = keyValue;
			myValueFeature = valueFeature;
		}

		@Override
		public BaseType getType() {
			return BaseType.KEY_VALUE;
		}

		@Override
		public EStructuralFeature getFeature() {
			return myFeature;
		}

		@Override
		public EStructuralFeature getKeyFeature() {
			return myKeyFeature;
		}

		@Override
		public Object getKeyValue() {
			return myKeyValue;
		}

		@Override
		public EStructuralFeature getValueFeature() {
			return myValueFeature;
		}

		@Override
		public EStructuralFeature getResultFeature() {
			return super.getValueFeature();
		}
	}

	protected static class MyBindingSpecVirtual extends MyBindingSpecBase {

		private final BaseType myType;

		protected MyBindingSpecVirtual(BaseType type) {
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
		private boolean myLast = false;

		@Override
		public Map<String, Object> getArguments() {
			if (myArguments == null) {
				myArguments = new HashMap<String, Object>();
			}
			return myArguments;
		}

		@Override
		public EStructuralFeature getResultFeature() {
			return null;
		}

		@Override
		public EStructuralFeature getKeyFeature() {
			return null;
		}

		@Override
		public Object getKeyValue() {
			return null;
		}

		@Override
		public EStructuralFeature getValueFeature() {
			return null;
		}

		@Override
		public boolean isLast() {
			return myLast;
		}

		public void setLast(boolean last) {
			myLast = last;
		}
	}

	/**
	 * Context used during parsing of a binding specification.
	 */
	public interface IBindingSpecParserContext {

		/**
		 * Returns the context specified to
		 * {@link IBindingSpec.Factory#parseSingleSpec(EClass, String, SpecContext)}.
		 * 
		 * @return the context
		 */
		SpecContext getSpecContext();

		/**
		 * Adds a new specification record to the list of records for this current specification
		 * string
		 * 
		 * @param spec the new record
		 * @param newSpecClass the resulting {@link EClass}
		 */
		void addSpec(MyBindingSpecBase spec, EClass newSpecClass);

		/**
		 * Returns the class at the start of this spec record.
		 * 
		 * @return the current class
		 */
		EClass getSpecClass();

		/**
		 * Tests whether the next token is of the specified type.
		 * <p>
		 * See {@link StreamTokenizer#ttype} for further information.
		 * 
		 * @param token the token to test
		 * @return <code>true</code> if the next token is the specified
		 */
		boolean isTokenType(int token);

		/**
		 * The integer value of the current token if relevant.
		 * 
		 * @return the integer value
		 */
		int getTokenInteger();

		/**
		 * The string value of the current token if relevant.
		 * 
		 * @return the string value
		 */
		String getTokenString();

		/**
		 * The value of the current token if understood as an argument value.
		 * 
		 * @return the value ({@link String} or {@link Integer}) or <code>null</code> if not found
		 */
		Object getTokenArgumentValue() throws IOException;

		/**
		 * Starts a new specification level.
		 */
		void newSpecLevel();

		/**
		 * The last specification record added.
		 * 
		 * @return the last record
		 */
		MyBindingSpecBase getLastSpec();

		/**
		 * Issues an error and returns null from
		 * {@link IBindingSpec.Factory#parseSingleSpec(EClass, String, SpecContext)}.
		 * 
		 * @param message the messages of the error
		 */
		void error(String message);

		/**
		 * Issues a syntax error and returns null from
		 * {@link IBindingSpec.Factory#parseSingleSpec(EClass, String, SpecContext)}.
		 * 
		 * @param bnf the BNF currently being parsed
		 * @param expectedToken the expected token or tokens "one of..."
		 */
		void syntaxError(String bnf, String expectedToken);

		/**
		 * Checks the the specification context is one of the specified...
		 * 
		 * @param message the message to use for the error if not one of the specified contexts
		 * @param legalContexts the legal contexts
		 */
		void checkContext(String message, SpecContext... legalContexts);

		/**
		 * Returns the current token type.
		 * <p>
		 * See {@link StreamTokenizer#ttype} for further information.
		 * 
		 * @return the current token
		 */
		int getTokenType();

		/**
		 * Moves to the next token.
		 * 
		 * @throws IOException from {@link StringTokenizer}
		 */
		void nextToken() throws IOException;

		/**
		 * The specification string being parsed.
		 * 
		 * @return the specification string
		 */
		String getSpec();
	}
}
