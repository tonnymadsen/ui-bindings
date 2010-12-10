package com.rcpcompany.uibindings.internal.clipboardconverters;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.HTMLTransfer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.rcpcompany.utils.logging.LogUtils;

/**
 * {@link IClipboardConverter} for HTML Table.
 * <p>
 * Used by Excel.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class HTMLTableConverter implements IClipboardConverter {

	@Override
	public String getName() {
		return "HTML Table";
	}

	@Override
	public String[][] convert(Clipboard clipboard) {
		String content = (String) clipboard.getContents(HTMLTransfer.getInstance());
		if (content == null) return null;
		// LogUtils.debug(this, "Test:\n" + content + "\n<<<<");

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
		content = content.replaceAll(">[\t \r\n]+<", "><");
		content = content.replaceAll("</?(br|span|a|div|font) *>", "");
		content = content.replaceAll("<p *>", "\n");
		content = content.replaceAll("</p *>", "");

		final InputStream is = new StringBufferInputStream(content);

		try {
			final SAXParserFactory factory = SAXParserFactory.newInstance();
			final SAXParser p = factory.newSAXParser();

			// p.getXMLReader().setFeature("http://apache.org/xml/features/continue-after-fatal-error",
			// true);

			final DefaultHandler handler = new TableHandleBase();
			myElements.clear();
			p.parse(is, handler);
		} catch (final SAXException ex) {
			// TODO Auto-generated catch block
			LogUtils.error(this, ex);
		} catch (final IOException ex) {
			// Should never happen
			LogUtils.error(this, ex);
			return null;
		} catch (final ParserConfigurationException ex) {
			// TODO Auto-generated catch block
			LogUtils.error(this, ex);
			return null;
		}

		final String[][] result = new String[myElements.size()][];
		for (int i = 0; i < result.length; i++) {
			result[i] = myElements.get(i).toArray(new String[0]);
		}
		return result;
	}

	public final List<List<String>> myElements = new ArrayList<List<String>>();
	public String myNextElement = null;

	/**
	 * SAX Parser node handler for HTML tables.
	 * 
	 * @author Tonny Madsen, The RCP Company
	 */
	public class TableHandleBase extends DefaultHandler {
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			// LogUtils.debug(this, "uri=" + uri + ", localName=" + localName + ", qName=" + qName);
			if ("tr".equals(qName)) {
				myElements.add(new ArrayList<String>());
			} else if ("td".equals(qName)) {
				myNextElement = "";
			} else if ("p".equals(qName)) {
				myNextElement += "\n";
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			// LogUtils.debug(this, "uri=" + uri + ", localName=" + localName + ", qName=" + qName);
			if ("td".equals(qName)) {
				if (myNextElement.startsWith("\n")) {
					myNextElement = myNextElement.substring(1);
				}
				myElements.get(myElements.size() - 1).add(myNextElement);
			}
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			final String s = new String(ch, start, length);
			myNextElement += s;
			LogUtils.debug(this, "s=" + s);
		}
	}
}
