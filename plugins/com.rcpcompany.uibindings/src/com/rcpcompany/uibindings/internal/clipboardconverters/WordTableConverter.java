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
