package com.rcpcompany.uibindings.internal.clipboardconverters;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;

/**
 * {@link IClipboardConverter} for Space-Separated-Values.
 * <p>
 * It handles a mixture of tab and space separators.
 * <p>
 * Used in some plain text documents.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SpaceSVConverter implements IClipboardConverter {

	@Override
	public String getName() {
		return "Space separated values";
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
			result[i] = lines[i].split("[\t ]+");
		}
		return result;
	}

}
