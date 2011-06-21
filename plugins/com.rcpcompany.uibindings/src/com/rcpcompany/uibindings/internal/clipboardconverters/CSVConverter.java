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
package com.rcpcompany.uibindings.internal.clipboardconverters;

import java.util.Arrays;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;

import com.rcpcompany.utils.logging.LogUtils;

/**
 * {@link IClipboardConverter} for Comma-Separated-Values.
 * <p>
 * Very common interchange format.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CSVConverter implements IClipboardConverter {
	private final String myName;
	private final String mySeparatorRE;

	/**
	 * Constructs and returns a new converter with the specified name and the specified separator
	 * {@link String#split(String) regular expression}.
	 * 
	 * @param name the name of the converter
	 * @param separatorRE the regular expression for the converter
	 */
	public CSVConverter(String name, String separatorRE) {
		myName = name;
		mySeparatorRE = separatorRE;
	}

	@Override
	public String getName() {
		return myName;
	}

	@Override
	public String[][] convert(Clipboard clipboard) {
		String content = (String) clipboard.getContents(TextTransfer.getInstance());
		if (content == null) return null;
		while (content.endsWith("\n")) {
			content = content.substring(0, content.length() - 1);
		}
		content = content.replace("\r", "");
		final String[] lines = content.split("\n");
		final int noLines = lines.length;
		final String[][] result = new String[noLines][0];
		for (int i = 0; i < lines.length; i++) {
			result[i] = lines[i].split(mySeparatorRE);
			LogUtils.debug(this, "RE='" + mySeparatorRE + "': '" + lines[i] + "->" + Arrays.toString(result[i]));
		}
		return result;
	}
}
