package com.rcpcompany.uibindings.internal.clipboardconverters;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.HTMLTransfer;

/**
 * {@link IClipboardConverter} for HTML Table.
 * <p>
 * Used by Excel.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class HTMLTableConverter implements IClipboardConverter {

	/**
	 * The pattern used to decode the HTML
	 */
	private static final Pattern myPattern = Pattern.compile("(<[^>]+>|[^<>]+)");

	@Override
	public String getName() {
		return "HTML Table";
	}

	@Override
	public String[][] convert(Clipboard clipboard) {
		String content = (String) clipboard.getContents(HTMLTransfer.getInstance());
		if (content == null) return null;
		// LogUtils.debug(this, ">>>\n" + content + "\n<<<");

		/*
		 * Massage the content a little to get rid of a few bad eggs...
		 * 
		 * - remove all attributes!!!
		 * 
		 * - remove all visual tags except p, as these often does not match
		 * 
		 * - replace <p> with newline
		 */
		content = content.replaceAll("<(/?[a-z:.]+) [^>]*>", "<$1>");
		if (!content.contains("<td>")) return null;
		content = content.replaceAll(">[\t \r\n]+<", "><");

		final List<List<String>> elements = new ArrayList<List<String>>();
		String nextElement = null;

		/*
		 * The following loop is not very pretty, but it does the job...
		 */
		final Matcher matcher = myPattern.matcher(content);
		while (matcher.find()) {
			final String s = matcher.group();
			// LogUtils.debug(this, "s='" + s + "'");
			if ("<tr>".equals(s)) {
				elements.add(new ArrayList<String>());
			} else if ("<td>".equals(s)) {
				nextElement = "";
			} else if ("<p>".equals(s)) {
				nextElement += "\n";
			} else if ("</td>".equals(s)) {
				if (nextElement.startsWith("\n")) {
					nextElement = nextElement.substring(1);
				}
				if (elements.size() == 0) {
					elements.add(new ArrayList<String>());
				}
				elements.get(elements.size() - 1).add(nextElement);
			} else if (s.startsWith("<")) {
				// Ignore
			} else if ("<p>".equals(s)) {
				nextElement += "\n";
			} else {
				// TODO handle &...; constructs
				nextElement += s;
			}
		}

		/*
		 * Convert to String[][]
		 */
		final String[][] result = new String[elements.size()][];
		for (int i = 0; i < result.length; i++) {
			result[i] = elements.get(i).toArray(new String[0]);
		}
		return result;
	}
}
