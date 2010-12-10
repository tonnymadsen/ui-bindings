package com.rcpcompany.uibindings.internal.clipboardconverters;

import org.eclipse.swt.dnd.Clipboard;

/**
 * {@link IClipboardConverter} for PDF Table.
 * <p>
 * Used when copying a table from a PDF document
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class PDFTableConverter implements IClipboardConverter {
	@Override
	public String getName() {
		return "PDF Table";
	}

	@Override
	public String[][] convert(Clipboard clipboard) {
		return null;
	}
}
