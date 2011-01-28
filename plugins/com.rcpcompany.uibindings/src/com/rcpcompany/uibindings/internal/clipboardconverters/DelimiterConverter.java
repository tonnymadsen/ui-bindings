package com.rcpcompany.uibindings.internal.clipboardconverters;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;

/**
 * {@link IClipboardConverter} for space and tab characters. Consequitive separator characters are
 * merged.
 * <p>
 * Very common interchange format.
 * 
 * @author Frode Meling, The MARINTEK
 */
public class DelimiterConverter implements IClipboardConverter {
	private final String myName;
	private final String mySeparator;

	private final static String[] EMPTY_STRING_ARR = new String[0];

	public DelimiterConverter(String name, String separator) {
		myName = name;
		mySeparator = separator;
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
			result[i] = splitLine(lines[i]);
		}

		return result;
	}

	private String[] splitLine(String line) {
		final StringTokenizer tokenizer = new StringTokenizer(line, mySeparator);

		final ArrayList<String> result = new ArrayList<String>();
		while (tokenizer.hasMoreTokens()) {
			result.add(tokenizer.nextToken());
		}

		return result.toArray(EMPTY_STRING_ARR);
	}
}
