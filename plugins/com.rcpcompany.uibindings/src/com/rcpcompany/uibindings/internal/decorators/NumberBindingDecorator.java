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
/**
 * 
 */
package com.rcpcompany.uibindings.internal.decorators;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IFormatter;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.INumberDecoratorProvider;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.decorators.SimpleUIBindingDecorator;
import com.rcpcompany.uibindings.units.IUnitBindingSupport;
import com.rcpcompany.uibindings.units.IUnitBindingSupportContext;
import com.rcpcompany.uibindings.units.IUnitBindingSupportListener;
import com.rcpcompany.uibindings.utils.CoreRuntimeException;
import com.rcpcompany.uibindings.validators.ConstraintValidatorAdapter;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * {@link IUIBindingDecorator Binding decorator} for number formats.
 * <p>
 * This number decorator can be used even after it has been disposed!!! This is used in
 * {@link ConstraintValidatorAdapter}.
 * <p>
 * Currently with a hack to solve SIMA-457: Editors in the MassData form does not recognise
 * scientific notation on input http://jira.marintek.sintef.no/jira/browse/SIMA-457
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NumberBindingDecorator extends SimpleUIBindingDecorator implements IUIBindingDecorator,
		IUnitBindingSupportContext, IUnitBindingSupportListener {
	/**
	 * A single interval as described in {@link Constants#ARG_RANGE}.
	 */
	public class Interval {
		/**
		 * Whether min has been set for this interval.
		 */
		public boolean myMinSet = false;

		/**
		 * Whether max has been set for this interval.
		 */
		public boolean myMaxSet = false;

		/**
		 * Whether min value is inclusive.
		 */
		public boolean myMinInclusive = true;

		/**
		 * Whether max value is inclusive.
		 */
		public boolean myMaxInclusive = true;

		/**
		 * The minimum value for this interval.
		 */
		public BigDecimal myMin = myAdapter.getMinimum();

		/**
		 * The maximum value for this interval.
		 */
		public BigDecimal myMax = myAdapter.getMaximum();

		/**
		 * Returns whther any of the limits has been set.
		 * 
		 * @return <code>true</code> if set
		 */
		public boolean isMinOrMaxSet() {
			return myMinSet || myMaxSet;
		}

		/**
		 * Parses and applies the limits from the range string. See {@link Constants#ARG_RANGE} for
		 * details on the syntax.
		 * <p>
		 * A manual parser to ensure the correct conversion of numbers is used
		 * 
		 * @param range the range specification
		 * @throws CoreRuntimeException if the range is malformed
		 */
		public void parseRanges(String range) {
			try {
				final StreamTokenizer st = createTokenizer(range);
				st.nextToken();

				switch (st.ttype) {
				case ']':
					myMinInclusive = false;
					//$FALL-THROUGH$ fallthrough
				case '[':
					st.nextToken();
					break;
				default:
					LogUtils.throwException(NumberBindingDecorator.this, "In Range '" + range
							+ "': Expected '[' or ']', got '" + st.toString() + "'", null);
				}
				if (st.ttype == StreamTokenizer.TT_NUMBER) {
					myMin = new BigDecimal(st.nval);
					myMinSet = true;
					setLimitsSet();
					st.nextToken();
				}
				if (st.ttype != ';') {
					LogUtils.throwException(NumberBindingDecorator.this, "In Range '" + range
							+ "': Expected ';', got '" + st.toString() + "'", null);
				}
				st.nextToken();
				if (st.ttype == StreamTokenizer.TT_NUMBER) {
					myMax = new BigDecimal(st.nval);
					myMaxSet = true;
					setLimitsSet();
					st.nextToken();
				}
				switch (st.ttype) {
				case '[':
					myMaxInclusive = false;
					//$FALL-THROUGH$ fallthrough
				case ']':
					st.nextToken();
					break;
				default:
					LogUtils.throwException(NumberBindingDecorator.this, "In Range '" + range
							+ "': Expected '[' or ']', got '" + st.toString() + "'", null);
				}

				if (st.ttype != StreamTokenizer.TT_EOF) {
					LogUtils.throwException(NumberBindingDecorator.this, "In Range '" + range
							+ "': Expected <EOS>, got '" + st.toString() + "'", null);
				}
			} catch (final IOException ex) {
				LogUtils.throwException(NumberBindingDecorator.this, "In Range '" + range + "'", ex);
			}
		}

		/**
		 * Be backward compatible - apply limits from min and max arguments.
		 */
		public void retrieveMinMaxLimits() {
			BigDecimal argument;
			argument = getBinding().getArgument(Constants.ARG_MIN, BigDecimal.class, null);
			if (argument != null) {
				if (myMin == null || myMin.compareTo(argument) < 0) {
					myMin = argument;
					myMinSet = true;
					setLimitsSet();
				}
			}
			argument = getBinding().getArgument(Constants.ARG_MAX, BigDecimal.class, null);
			if (argument != null) {
				if (myMax == null || myMax.compareTo(argument) > 0) {
					myMax = argument;
					myMaxSet = true;
					setLimitsSet();
				}
			}
		}

		/**
		 * Checks the specified number against the range of this decorator.
		 * 
		 * @param fromObject the original object
		 * @param number the number to test
		 * @param typeOfCheck the type of check performed: "declared" or "native"
		 * @return message if range is violated, otherwise <code>null</code>
		 * 
		 *         TODO: possibly change format of min and max in the returned messages
		 */
		public String checkRange(Object fromObject, final BigDecimal number, String typeOfCheck) {
			final boolean minViolated = number.compareTo(myMin) < (myMinInclusive ? 0 : 1);
			final boolean maxViolated = number.compareTo(myMax) > (myMaxInclusive ? 0 : -1);

			if (!minViolated && !maxViolated) return null;

			if (minViolated && !myMaxSet) {
				if (BigDecimal.ZERO.equals(myMin)) {
					if (myMinInclusive)
						return MessageFormat.format("{0}: ''{1}'' must be positive or zero", getLabel(), fromObject,
								typeOfCheck, myMin, myMax);
					else
						return MessageFormat.format("{0}: ''{1}'' must be positive", getLabel(), fromObject,
								typeOfCheck, myMin, myMax);
				} else {
					if (myMinInclusive)
						return MessageFormat.format("{0}: ''{1}'' outside {2} range (min {3})", getLabel(), fromObject,
								typeOfCheck, myMin, myMax);
					else
						return MessageFormat.format("{0}: ''{1}'' outside {2} range (greater than {3})", getLabel(),
								fromObject, typeOfCheck, myMin, myMax);
				}
			}
			if (maxViolated && !myMinSet) {
				if (BigDecimal.ZERO.equals(myMax)) {
					if (myMaxInclusive)
						return MessageFormat.format("{0}: ''{1}'' must be negative or zero", getLabel(), fromObject,
								typeOfCheck, myMin, myMax);
					else
						return MessageFormat.format("{0}: ''{1}'' must be negative", getLabel(), fromObject,
								typeOfCheck, myMin, myMax);
				} else {
					if (myMaxInclusive)
						return MessageFormat.format("{0}: ''{1}'' outside {2} range (max {4})", getLabel(), fromObject,
								typeOfCheck, myMin, myMax);
					else
						return MessageFormat.format("{0}: ''{1}'' outside {2} range (less than {4})", getLabel(),
								fromObject, typeOfCheck, myMin, myMax);
				}
			}
			return MessageFormat.format("{0}: ''{1}'' outside {2} range {3}{4}; {5}{6}", getLabel(), fromObject,
					typeOfCheck, myMinInclusive ? "[" : "]", myMin, myMax, myMaxInclusive ? "]" : "[");
		}

	}

	/**
	 * The error code used in {@link IBindingMessage messages} for number errors.
	 */
	public static final int NUMBER_ERROR_CODE = 1000;

	/**
	 * Unit support for this binding or <code>null</code>.
	 */
	private IUnitBindingSupport myUnitSupport;

	/**
	 * The provider.
	 */
	private final INumberDecoratorProvider myProvider;

	/**
	 * @param provider the number decorator provider
	 */
	public NumberBindingDecorator(INumberDecoratorProvider provider) {
		myProvider = provider;
	}

	/**
	 * The formatter instance.
	 */
	private IFormatter myFormatter;

	/**
	 * The buffer used for the output.
	 */
	private StringBuilder myBuffer;

	/**
	 * The used adapter for the specific model type.
	 */
	protected NumberAdapter myAdapter;

	/**
	 * Whether any limits has been set for this decorator.
	 */
	private boolean myLimitsSet = false;

	/**
	 * The last object converted in {@link #convertUIToModel(Object)}.
	 */
	protected Object myLastFromObject;

	/**
	 * The last {@link BigDecimal} result in {@link #convertUIToModel(Object)}.
	 */
	protected BigDecimal myLastConvertedValue;

	/**
	 * The precision and rounding mode used.
	 */
	private static final MathContext MATH_CONTEXT = MathContext.DECIMAL64;

	/**
	 * Sets whether limits have been set.
	 */
	public void setLimitsSet() {
		myLimitsSet = true;
	}

	/**
	 * Whether any limits has been set for this decorator.
	 * 
	 * @return true if set
	 */
	public boolean isLimitsSet() {
		return myLimitsSet;
	}

	/**
	 * Returns whether the number of this decorator is an integral number - e.g. one of {@link Byte}
	 * , {@link Short}, {@link Integer} or {@link Long} or their corresponding primitive types.
	 * 
	 * @return <code>true</code> if it is an integral number and <code>false</code> if it is a real
	 *         number
	 */
	public boolean isIntegralNumber() {
		return myAdapter.isIntegralNumber();
	}

	@Override
	public void init(IValueBinding binding) {
		super.init(binding);

		myBuffer = new StringBuilder();
		myFormatter = IManager.Factory.getManager().getFormatterProvider()
				.getFormatter(myBuffer, myProvider.getFormat());

		initForValidation(getBinding());

		myUnitSupport = getBinding().getArgument(Constants.ARG_UNIT_SUPPORT, IUnitBindingSupport.class, null);
		if (myUnitSupport != null) {
			myUnitSupport.addListener(this);
		}
	}

	@Override
	public void dispose() {
		super.dispose();

		if (myUnitSupport != null) {
			myUnitSupport.removeListener(this);
		}
	}

	@Override
	public void unitsChanged() {
		getBinding().updateUI();
		getBinding().updateBinding();
	}

	/**
	 * Special version of init when the decorator is only used for validation.
	 * 
	 * @param binding the binding
	 */
	public void initForValidation(IValueBinding binding) {
		setBinding(binding);
		calculateAdapter(binding);

		final String range = getBinding().getArgument(Constants.ARG_RANGE, String.class, null);
		myDeclaredInterval = new Interval();
		if (range != null) {
			myDeclaredInterval.parseRanges(range);
		} else {
			myDeclaredInterval.retrieveMinMaxLimits();
		}

		if (myDeclaredInterval.isMinOrMaxSet()) {
			myNativeInterval = new Interval();
		} else {
			myNativeInterval = myDeclaredInterval;
		}
	}

	/**
	 * Finds the adapter to use for the model type of this binding.
	 * 
	 * @param binding the binding
	 */
	private void calculateAdapter(IValueBinding binding) {
		final Class<?> modelType = binding.getModelType();

		if (modelType == Byte.class || modelType == Byte.TYPE) {
			myAdapter = BYTE_ADAPTER;
		} else if (modelType == Short.class || modelType == Short.TYPE) {
			myAdapter = SHORT_ADAPTER;
		} else if (modelType == Integer.class || modelType == Integer.TYPE) {
			myAdapter = INTEGER_ADAPTER;
		} else if (modelType == Long.class || modelType == Long.TYPE) {
			myAdapter = LONG_ADAPTER;
		} else if (modelType == Float.class || modelType == Float.TYPE) {
			myAdapter = FLOAT_ADAPTER;
		} else if (modelType == Double.class || modelType == Double.TYPE) {
			myAdapter = DOUBLE_ADAPTER;
		} else if (modelType == BigDecimal.class) {
			myAdapter = BIG_INTERGER_ADAPTER;
		} else if (modelType == BigInteger.class) {
			myAdapter = BIG_DECIMAL_ADAPTER;
		}

		if (myAdapter == null) {
			binding.addErrorCondition("Cannot convert model type " + modelType.getName() + " to String");
			return;
		}
	}

	/**
	 * Returns the label for the binding.
	 * 
	 * @return the label
	 */
	public String getLabel() {
		return getBinding().getLabel();
	}

	@Override
	protected Object convertModelToUI(Object fromObject) {
		if (myUnitSupport != null) {
			final double factor = getUnitFactor();
			if (factor != 1.0) {
				fromObject = myAdapter.scale(fromObject, factor, true);
			}
		}
		final Class<?> uiType = getBinding().getUIType();

		if (uiType == Integer.class || uiType == Integer.TYPE)
			return fromObject;
		else if (uiType == String.class) {
			myBuffer.setLength(0);
			myFormatter.format(fromObject);
			return myBuffer.toString();
		} else
			return null;
	}

	private double getUnitFactor() {
		if (myUnitSupport == null) return 1.0;
		return myUnitSupport.getFactor(this);
	}

	@Override
	protected Object convertUIToModel(Object fromObject) {
		/*
		 * Micro Cache:
		 * 
		 * Avoid converting the from object if identical to the last value.
		 * 
		 * convertToBigDecimal can result in an exception so we delay setting the from object
		 */
		if (myLastFromObject != fromObject) {
			myLastConvertedValue = convertToBigDecimal(fromObject);
			if (myUnitSupport != null) {
				final double factor = getUnitFactor();
				if (factor != 1.0) {
					try {
						myLastConvertedValue = myLastConvertedValue.divide(new BigDecimal(factor), MATH_CONTEXT);
					} catch (final ArithmeticException ex) {
						LogUtils.error(this, myLastConvertedValue + "/" + factor + ": " + ex.getMessage(), ex);
						throw ex;
					}
				}
			}
			myLastFromObject = fromObject;
		}

		/*
		 * - Check the limits
		 */
		final String m = myNativeInterval.checkRange(fromObject, myLastConvertedValue, "native");
		if (m != null) {
			UIBindingsUtils.throwError(true, NUMBER_ERROR_CODE, m);
		}

		/*
		 * - Convert to the wanted model type
		 */
		return myAdapter.getConformantNumber(myLastConvertedValue);
	}

	@Override
	public IValidator getUIToModelAfterConvertValidator() {
		return new IValidator() {
			@Override
			public IStatus validate(Object value) {
				/*
				 * - Check the limits
				 */
				final String m = checkRange(myLastFromObject, myLastConvertedValue);
				if (m != null) return UIBindingsUtils.error(NUMBER_ERROR_CODE, m);
				return Status.OK_STATUS;
			}
		};
	}

	/**
	 * Converts the specified object to a {@link BigDecimal} if possible.
	 * 
	 * @param fromObject the object to convert
	 * @return the corresponding {@link BigDecimal} or <code>null</code>
	 * 
	 * @throws CoreRuntimeException if the object is <code>null</code>
	 */
	private BigDecimal convertToBigDecimal(Object fromObject) {
		if (myAdapter == null) return null;

		BigDecimal d = null;
		final Class<?> uiType = getBinding().getUIType();
		if (uiType == Integer.class || uiType == Integer.TYPE) {
			getBinding().assertTrue(fromObject instanceof Integer, "fromObject not an Integer");
			d = new BigDecimal((Integer) fromObject);
		} else if (uiType == String.class) {
			getBinding().assertTrue(fromObject instanceof String, "fromObject not a String");
			final String s = (String) fromObject;
			/*
			 * - Parse the string
			 */
			if (s == null || s.length() == 0) {
				UIBindingsUtils.throwError(true, NUMBER_ERROR_CODE, "number missing");
			}
			final ParsePosition parsePosition = new ParsePosition(0);
			final boolean formatUsesGroupings = myProvider.getFormat().indexOf(',') >= 0;
			final NumberFormat format = formatUsesGroupings ? myAdapter.getGroupingParseFormat() : myAdapter
					.getPlainParseFormat();
			Number number = format.parse(s.toLowerCase(), parsePosition);

			/*
			 * - Check the result
			 * 
			 * If we have an error AND the wanted type is float, double or BigDecimal, then give it
			 * a second try with Double.parseDouble().
			 */
			if (parsePosition.getErrorIndex() != -1 || parsePosition.getIndex() != s.length()) {
				boolean ok = false;
				try {
					if (myAdapter == FLOAT_ADAPTER || myAdapter == DOUBLE_ADAPTER || myAdapter == BIG_DECIMAL_ADAPTER) {
						number = BigDecimal.valueOf(Double.parseDouble(s));
						ok = true;
					}
				} catch (final NumberFormatException ex) {
					// Do nothing
				}
				if (!ok) {
					final int errorPos = (parsePosition.getErrorIndex() != -1) ? parsePosition.getErrorIndex()
							: parsePosition.getIndex();
					UIBindingsUtils.throwError(true, NUMBER_ERROR_CODE, MessageFormat.format(
							"Illegal number: ''{1}'' at position {2}: ''{3}''", getLabel(), fromObject, errorPos + 1,
							s.charAt(errorPos)));
				}
			}

			/*
			 * - Handle the special values
			 */
			if (number instanceof Double) {
				if (Double.isNaN(number.doubleValue())) return null;
				if (number.doubleValue() == Double.NEGATIVE_INFINITY) {
					d = getMin();
				} else if (number.doubleValue() == Double.POSITIVE_INFINITY) {
					d = getMax();
				}
			} else {
				d = (BigDecimal) number;
			}
		}
		return d;
	}

	/**
	 * The "declared" interval of the decorator based on the {@link Constants#ARG_RANGE}.
	 */
	private Interval myDeclaredInterval = null;

	/**
	 * The "native" interval of the decorator based on the EMF field.
	 */
	private Interval myNativeInterval = null;

	/**
	 * Checks the specified number against the range of this decorator.
	 * 
	 * @param fromObject the original object
	 * @param number the number to test
	 * @return message if range is violated, otherwise <code>null</code>
	 */
	public String checkRange(Object fromObject, final BigDecimal number) {
		return myDeclaredInterval.checkRange(fromObject, number, "declared");
	}

	/**
	 * Returns the minimum value of the decorator.
	 * 
	 * @return the minimum value
	 */
	public BigDecimal getMin() {
		return myDeclaredInterval.myMin;
	}

	/**
	 * Returns the maximum value of this decorator.
	 * 
	 * @return the maximum value
	 */
	public BigDecimal getMax() {
		return myDeclaredInterval.myMax;
	}

	/**
	 * Creates and returns a new tokenizer for the specified string.
	 * 
	 * @param spec the string to parse
	 * @return the new tokenizer
	 */
	protected StreamTokenizer createTokenizer(String spec) {
		final StreamTokenizer st = new StreamTokenizer(new StringReader(spec));
		// st.commentChar('#');
		st.lowerCaseMode(false);
		st.parseNumbers();
		st.quoteChar('"');
		st.quoteChar('\'');
		st.slashSlashComments(false);
		st.slashStarComments(false);
		st.ordinaryChar('.');

		return st;
	}

	/**
	 * Sets up the specified format for use in {@link #convertUIToModel(Object)}.
	 * 
	 * @param format the format to modify
	 * @param allowGroupings <code>true</code> if groupings are allowed
	 * @return a modified copy
	 */
	protected static DecimalFormat setupDecimalFormat(NumberFormat format, boolean allowGroupings) {
		final DecimalFormat f = (DecimalFormat) format.clone();
		f.setParseBigDecimal(true);
		final DecimalFormatSymbols symbols = f.getDecimalFormatSymbols();
		symbols.setExponentSeparator(symbols.getExponentSeparator().toLowerCase());
		symbols.setNaN(symbols.getNaN().toLowerCase());
		symbols.setInfinity(symbols.getInfinity().toLowerCase());
		if (!allowGroupings) {
			symbols.setGroupingSeparator('\0');
		}
		f.setDecimalFormatSymbols(symbols);

		return f;
	}

	/**
	 * This interface is used to hide the differences between the {@link Number} sub-classes.
	 * <p>
	 * The objects of this class are immutable - does not change.
	 */
	private interface NumberAdapter {
		/**
		 * Returns the format used to parse this type.
		 * <p>
		 * The parser must return a {@link BigDecimal} or {@link Double} as described in
		 * {@link DecimalFormat#parse(String, ParsePosition)} with
		 * {@link DecimalFormat#setParseBigDecimal(boolean) setParseBigDecimal(true)}.
		 * 
		 * @return the format
		 */
		NumberFormat getPlainParseFormat();

		/**
		 * Returns whether the number of this decorator is an integral number - e.g. one of
		 * {@link Byte} , {@link Short}, {@link Integer} or {@link Long} or their corresponding
		 * primitive types.
		 * 
		 * @return <code>true</code> if it is an integral number and <code>false</code> if it is a
		 *         real number
		 */
		boolean isIntegralNumber();

		/**
		 * Scales and returns a new number of the correct type.
		 * 
		 * @param fromObject the number to scale
		 * @param factor the scaling factor
		 * @param viewToUI whether to scale from view to UI (multiply by the factor) or UI to model
		 *            (divide by the factor)
		 * @return the new number
		 */
		Object scale(Object fromObject, double factor, boolean viewToUI);

		/**
		 * Returns the format used to parse this type with groupings.
		 * <p>
		 * See {@link #getPlainParseFormat()}.
		 * 
		 * @return the format
		 */
		NumberFormat getGroupingParseFormat();

		/**
		 * Returns the minimum value for the type. The value is the same type as TODO
		 * 
		 * @return the minimum
		 */
		BigDecimal getMinimum();

		/**
		 * Returns the minimum value for the type. The value is the same type as TODO
		 * 
		 * @return the minimum
		 */
		BigDecimal getMaximum();

		/**
		 * Returns a new number with the same value, but of the correct type. When this method is
		 * called, it is already checked that {@code source} is within the bounds of
		 * {@link #getMinimum()} and {@link #getMaximum()}.
		 * 
		 * @param source the source number to be converted
		 * @return the resulting number
		 */
		Number getConformantNumber(BigDecimal source);
	}

	/**
	 * The adapter for {@link Byte}{@code .class} and {@link Byte}{@code .TYPE}.
	 */
	private static final NumberAdapter BYTE_ADAPTER = new NumberAdapter() {
		private final DecimalFormat myPlainFormat = setupDecimalFormat(NumberFormat.getIntegerInstance(), false);
		private final DecimalFormat myGroupingFormat = setupDecimalFormat(NumberFormat.getIntegerInstance(), true);

		@Override
		public NumberFormat getPlainParseFormat() {
			return myPlainFormat;
		}

		@Override
		public NumberFormat getGroupingParseFormat() {
			return myGroupingFormat;
		};

		private final BigDecimal min = new BigDecimal(Byte.MIN_VALUE);

		@Override
		public BigDecimal getMinimum() {
			return min;
		}

		private final BigDecimal max = new BigDecimal(Byte.MAX_VALUE);

		@Override
		public BigDecimal getMaximum() {
			return max;
		}

		@Override
		public Number getConformantNumber(BigDecimal source) {
			try {
				return Byte.valueOf(source.byteValueExact());
			} catch (final ArithmeticException ex) {
				UIBindingsUtils.throwError(true, NUMBER_ERROR_CODE, "Fraction not allowed");
			}
			return null;
		}

		@Override
		public Object scale(Object fromObject, double factor, boolean viewToUI) {
			return fromObject;
		}

		@Override
		public boolean isIntegralNumber() {
			return true;
		};
	};

	/**
	 * The adapter for {@link Short}{@code .class} and {@link Short}{@code .TYPE}.
	 */
	private static final NumberAdapter SHORT_ADAPTER = new NumberAdapter() {
		private final DecimalFormat myPlainFormat = setupDecimalFormat(NumberFormat.getIntegerInstance(), false);
		private final DecimalFormat myGroupingFormat = setupDecimalFormat(NumberFormat.getIntegerInstance(), true);

		@Override
		public NumberFormat getPlainParseFormat() {
			return myPlainFormat;
		}

		@Override
		public NumberFormat getGroupingParseFormat() {
			return myGroupingFormat;
		};

		private final BigDecimal min = new BigDecimal(Short.MIN_VALUE);

		@Override
		public BigDecimal getMinimum() {
			return min;
		}

		private final BigDecimal max = new BigDecimal(Short.MAX_VALUE);

		@Override
		public BigDecimal getMaximum() {
			return max;
		}

		@Override
		public Number getConformantNumber(BigDecimal source) {
			try {
				return Short.valueOf(source.shortValueExact());
			} catch (final ArithmeticException ex) {
				UIBindingsUtils.throwError(true, NUMBER_ERROR_CODE, "Fraction not allowed");
			}
			return null;
		}

		@Override
		public Object scale(Object fromObject, double factor, boolean viewToUI) {
			return fromObject;
		};

		@Override
		public boolean isIntegralNumber() {
			return true;
		};
	};

	/**
	 * The adapter for {@link Integer}{@code .class} and {@link Integer}{@code .TYPE}.
	 */
	private static final NumberAdapter INTEGER_ADAPTER = new NumberAdapter() {
		private final DecimalFormat myPlainFormat = setupDecimalFormat(NumberFormat.getIntegerInstance(), false);
		private final DecimalFormat myGroupingFormat = setupDecimalFormat(NumberFormat.getIntegerInstance(), true);

		@Override
		public NumberFormat getPlainParseFormat() {
			return myPlainFormat;
		}

		@Override
		public NumberFormat getGroupingParseFormat() {
			return myGroupingFormat;
		};

		private final BigDecimal min = new BigDecimal(Integer.MIN_VALUE);

		@Override
		public BigDecimal getMinimum() {
			return min;
		}

		private final BigDecimal max = new BigDecimal(Integer.MAX_VALUE);

		@Override
		public BigDecimal getMaximum() {
			return max;
		}

		@Override
		public Number getConformantNumber(BigDecimal source) {
			try {
				return Integer.valueOf(source.intValueExact());
			} catch (final ArithmeticException ex) {
				UIBindingsUtils.throwError(true, NUMBER_ERROR_CODE, "Fraction not allowed");
			}
			return null;
		}

		@Override
		public Object scale(Object fromObject, double factor, boolean viewToUI) {
			return fromObject;
		};

		@Override
		public boolean isIntegralNumber() {
			return true;
		};
	};

	/**
	 * The adapter for {@link Long}{@code .class} and {@link Long}{@code .TYPE}.
	 */
	private static final NumberAdapter LONG_ADAPTER = new NumberAdapter() {
		private final DecimalFormat myPlainFormat = setupDecimalFormat(NumberFormat.getIntegerInstance(), false);
		private final DecimalFormat myGroupingFormat = setupDecimalFormat(NumberFormat.getIntegerInstance(), true);

		@Override
		public NumberFormat getPlainParseFormat() {
			return myPlainFormat;
		}

		@Override
		public NumberFormat getGroupingParseFormat() {
			return myGroupingFormat;
		};

		private final BigDecimal min = new BigDecimal(Long.MIN_VALUE);

		@Override
		public BigDecimal getMinimum() {
			return min;
		}

		private final BigDecimal max = new BigDecimal(Long.MAX_VALUE);

		@Override
		public BigDecimal getMaximum() {
			return max;
		}

		@Override
		public Number getConformantNumber(BigDecimal source) {
			try {
				return Long.valueOf(source.longValueExact());
			} catch (final ArithmeticException ex) {
				UIBindingsUtils.throwError(true, NUMBER_ERROR_CODE, "Fraction not allowed");
			}
			return null;
		}

		@Override
		public Object scale(Object fromObject, double factor, boolean viewToUI) {
			return fromObject;
		};

		@Override
		public boolean isIntegralNumber() {
			return true;
		};
	};

	/**
	 * The adapter for {@link Float}{@code .class} and {@link Float}{@code .TYPE}.
	 */
	private static final NumberAdapter FLOAT_ADAPTER = new NumberAdapter() {
		private final DecimalFormat myPlainFormat = setupDecimalFormat(NumberFormat.getNumberInstance(), false);
		private final DecimalFormat myGroupingFormat = setupDecimalFormat(NumberFormat.getNumberInstance(), true);

		@Override
		public NumberFormat getPlainParseFormat() {
			return myPlainFormat;
		}

		@Override
		public NumberFormat getGroupingParseFormat() {
			return myGroupingFormat;
		};

		private final BigDecimal min = new BigDecimal(-Float.MAX_VALUE);

		@Override
		public BigDecimal getMinimum() {
			return min;
		}

		private final BigDecimal max = new BigDecimal(Float.MAX_VALUE);

		@Override
		public BigDecimal getMaximum() {
			return max;
		}

		@Override
		public Number getConformantNumber(BigDecimal source) {
			return new Float(source.floatValue());
		}

		@Override
		public Object scale(Object fromObject, double factor, boolean viewToUI) {
			final Float i = (Float) fromObject;
			if (viewToUI)
				return i * factor;
			else
				return i / factor;
		};

		@Override
		public boolean isIntegralNumber() {
			return false;
		};
	};

	/**
	 * The adapter for {@link Double}{@code .class} and {@link Double}{@code .TYPE}.
	 */
	private static final NumberAdapter DOUBLE_ADAPTER = new NumberAdapter() {
		private final DecimalFormat myPlainFormat = setupDecimalFormat(NumberFormat.getNumberInstance(), false);
		private final DecimalFormat myGroupingFormat = setupDecimalFormat(NumberFormat.getNumberInstance(), true);

		@Override
		public NumberFormat getPlainParseFormat() {
			return myPlainFormat;
		}

		@Override
		public NumberFormat getGroupingParseFormat() {
			return myGroupingFormat;
		};

		private final BigDecimal min = new BigDecimal(-Double.MAX_VALUE);

		@Override
		public BigDecimal getMinimum() {
			return min;
		}

		private final BigDecimal max = new BigDecimal(Double.MAX_VALUE);

		@Override
		public BigDecimal getMaximum() {
			return max;
		}

		@Override
		public Number getConformantNumber(BigDecimal source) {
			return new Double(source.doubleValue());
		}

		@Override
		public Object scale(Object fromObject, double factor, boolean viewToUI) {
			final Double i = (Double) fromObject;
			if (viewToUI)
				return i * factor;
			else
				return i / factor;
		};

		@Override
		public boolean isIntegralNumber() {
			return false;
		};
	};

	/**
	 * The adapter for {@link BigInteger}{@code .class} and {@link BigInteger}{@code .TYPE}.
	 */
	private static final NumberAdapter BIG_INTERGER_ADAPTER = new NumberAdapter() {
		private final DecimalFormat myPlainFormat = setupDecimalFormat(NumberFormat.getNumberInstance(), false);
		private final DecimalFormat myGroupingFormat = setupDecimalFormat(NumberFormat.getNumberInstance(), true);

		@Override
		public NumberFormat getPlainParseFormat() {
			return myPlainFormat;
		}

		@Override
		public NumberFormat getGroupingParseFormat() {
			return myGroupingFormat;
		};

		@Override
		public BigDecimal getMinimum() {
			return null;
		}

		@Override
		public BigDecimal getMaximum() {
			return null;
		}

		@Override
		public Number getConformantNumber(BigDecimal source) {
			try {
				return source.toBigIntegerExact();
			} catch (final ArithmeticException ex) {
				UIBindingsUtils.throwError(true, NUMBER_ERROR_CODE, "Fraction not allowed");
			}
			return null;
		}

		@Override
		public Object scale(Object fromObject, double factor, boolean viewToUI) {
			return fromObject;
		};

		@Override
		public boolean isIntegralNumber() {
			return true;
		};
	};

	/**
	 * The adapter for {@link BigDecimal}{@code .class} and {@link BigDecimal}{@code .TYPE}.
	 */
	private static final NumberAdapter BIG_DECIMAL_ADAPTER = new NumberAdapter() {
		private final DecimalFormat myPlainFormat = setupDecimalFormat(NumberFormat.getNumberInstance(), false);
		private final DecimalFormat myGroupingFormat = setupDecimalFormat(NumberFormat.getNumberInstance(), true);

		@Override
		public NumberFormat getPlainParseFormat() {
			return myPlainFormat;
		}

		@Override
		public NumberFormat getGroupingParseFormat() {
			return myGroupingFormat;
		};

		@Override
		public BigDecimal getMinimum() {
			return null;
		}

		@Override
		public BigDecimal getMaximum() {
			return null;
		}

		@Override
		public Number getConformantNumber(BigDecimal source) {
			return source;
		}

		@Override
		public Object scale(Object fromObject, double factor, boolean viewToUI) {
			final BigDecimal i = (BigDecimal) fromObject;
			if (viewToUI)
				return i.multiply(new BigDecimal(factor, null), MATH_CONTEXT);
			else
				return i.divide(new BigDecimal(factor, null), MATH_CONTEXT);
		};

		@Override
		public boolean isIntegralNumber() {
			return false;
		};
	};

}
