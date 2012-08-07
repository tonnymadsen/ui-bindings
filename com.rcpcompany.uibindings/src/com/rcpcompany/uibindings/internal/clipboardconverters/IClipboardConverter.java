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

import org.eclipse.swt.dnd.Clipboard;

import com.rcpcompany.uibindings.utils.IClipboardConverterManager;

/**
 * Clip board converter for one clipboard format.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IClipboardConverter {
	/**
	 * Returns the name of the format for this converter.
	 * <p>
	 * E.g. "CSV", "HTML Table", etc
	 * 
	 * @return the format name
	 */
	String getName();

	/**
	 * Converts the current format of the clipboard to a table of <code>Strings</code>.
	 * <p>
	 * The returned table is in the format specified by
	 * {@link IClipboardConverterManager.IResult#getTable()}.
	 * <p>
	 * The formnat is check by the caller.
	 * 
	 * @param clipboard the clipboard to copy from
	 * @return the converted table or <code>null</code> if not possible
	 */
	String[][] convert(Clipboard clipboard);
}
