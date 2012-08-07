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

/**
 * {@link IClipboardConverter} for Word Table.
 * <p>
 * Used by Microsoft Word.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class WordTableConverter implements IClipboardConverter {
	@Override
	public String getName() {
		return "Microsoft Word Table";
	}

	@Override
	public String[][] convert(Clipboard clipboard) {
		return null;
	}
}
