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
package com.rcpcompany.uibindings.internal.formatters;

import java.util.Formatter;

import com.rcpcompany.uibindings.IFormatter;
import com.rcpcompany.uibindings.IFormatterProvider;

/**
 * Default implementation of {@link IFormatterProvider}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DefaultFormatterProvider implements IFormatterProvider {
	@Override
	public IFormatter getFormatter(Appendable dest, String format) {
		return new JavaFormatter(dest, format);
	}

	/**
	 * {@link IFormatter} wrapper for {@link Formatter}.
	 */
	public class JavaFormatter implements IFormatter {
		private final Formatter myFormatter;
		private final String myFormat;

		/**
		 * Constructs and returns a new Java {@link Formatter}.
		 * 
		 * @param dest the destination
		 * @param format the format
		 */
		public JavaFormatter(Appendable dest, String format) {
			myFormat = format;
			myFormatter = new Formatter(dest);
		}

		@Override
		public void format(Object... args) {
			myFormatter.format(myFormat, args);
		}
	}
}
