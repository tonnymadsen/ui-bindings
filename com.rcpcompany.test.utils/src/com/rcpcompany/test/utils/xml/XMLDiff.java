package com.rcpcompany.test.utils.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 * Utility class for finding differences in XML structures
 * 
 * @author Tonny Madsen, tonny.madsen@gmail.com
 */
public class XMLDiff {
	private final boolean nodeTypeDiff = true;
	private final boolean nodeValueDiff = true;

	private static DocumentBuilderFactory theFactory;

	public static DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
		if (theFactory == null) {
			theFactory = DocumentBuilderFactory.newInstance();
			// dbf.setNamespaceAware(true);
			// dbf.setValidating(true);
			theFactory.setCoalescing(false);
			theFactory.setIgnoringElementContentWhitespace(true);
			theFactory.setIgnoringComments(true);
		}
		return theFactory.newDocumentBuilder();
	}

	/**
	 * Converts a String with XML to the corresponding XML Node.
	 * 
	 * @param xml
	 *            the XML string
	 * @return the XML Node
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static Node toNode(String xml) throws ParserConfigurationException, SAXException, IOException {
		return toNode(new ByteArrayInputStream(xml.getBytes("UTF-8")));
	}

	public static Node toNode(InputStream is) throws ParserConfigurationException, SAXException, IOException {
		final DocumentBuilder db = newDocumentBuilder();

		final Document doc = db.parse(is);

		doc.normalizeDocument();

		return doc;
	}

	/**
	 * Returns a description of the differences between the two XML strings.
	 * 
	 * @param xml1
	 *            XML String #1
	 * @param xml2
	 *            XML String #2
	 * @param diffs
	 *            the differences
	 * @return <code>true</code> if there are any differences
	 * @throws Exception
	 */
	public boolean diff(String xml1, String xml2, List<String> diffs) throws Exception {
		return diff(toNode(xml1), toNode(xml2), diffs);
	}

	/**
	 * Returns a description of the differences between the two XML Nodes.
	 * 
	 * @param node1
	 *            XML Node #1
	 * @param node2
	 *            XML Node #2
	 * @param diffs
	 *            the differences
	 * @return <code>true</code> if there are any differences
	 * @throws Exception
	 */
	public boolean diff(Node node1, Node node2, List<String> diffs) throws Exception {
		if (diffNodeExists(node1, node2, diffs))
			return true;

		if (nodeTypeDiff) {
			diffNodeType(node1, node2, diffs);
		}

		if (nodeValueDiff) {
			diffNodeValue(node1, node2, diffs);
		}

		// System.out.println(node1.getNodeName() + "/" + node2.getNodeName());

		diffAttributes(node1, node2, diffs);
		diffNodes(node1, node2, diffs);

		return diffs.size() > 0;
	}

	/**
	 * Diff the nodes
	 */
	private boolean diffNodes(Node node1, Node node2, List<String> diffs) throws Exception {
		// Sort by Name
		final Map<String, List<Node>> children1 = new HashMap<String, List<Node>>();
		for (Node child1 = node1.getFirstChild(); child1 != null; child1 = child1.getNextSibling()) {
			if (child1 instanceof Text && child1.getNodeValue().trim().isEmpty()) {
				continue;
			}
			List<Node> list = children1.get(child1.getNodeName());
			if (list == null) {
				list = new ArrayList<Node>();
				children1.put(child1.getNodeName(), list);
			}

			list.add(child1);
		}

		// Sort by Name
		final Map<String, List<Node>> children2 = new HashMap<String, List<Node>>();
		for (Node child2 = node2.getFirstChild(); child2 != null; child2 = child2.getNextSibling()) {
			if (child2 instanceof Text && child2.getNodeValue().trim().isEmpty()) {
				continue;
			}
			List<Node> list = children2.get(child2.getNodeName());
			if (list == null) {
				list = new ArrayList<Node>();
				children2.put(child2.getNodeName(), list);
			}

			list.add(child2);
		}

		// Diff all the children1
		for (final List<Node> list1 : children1.values()) {
			for (final Node child1 : list1) {
				final List<Node> list2 = children2.get(child1.getNodeName());
				Node child2 = null;
				if (list2 != null) {
					final Iterator<Node> c2iterator = list2.iterator();
					if (c2iterator.hasNext()) {
						child2 = c2iterator.next();
						c2iterator.remove();
					}
				}
				diff(child1, child2, diffs);
			}
		}

		// Diff all the children2 left over
		for (final List<Node> list2 : children2.values()) {
			for (final Node child2 : list2) {
				diff(null, child2, diffs);
			}
		}

		return diffs.size() > 0;
	}

	/**
	 * Diff the nodes
	 */
	private boolean diffAttributes(Node node1, Node node2, List<String> diffs) throws Exception {
		// Sort by Name
		final NamedNodeMap nodeMap1 = node1.getAttributes();
		final Map<String, Node> attributes1 = new LinkedHashMap<String, Node>();
		for (int index = 0; nodeMap1 != null && index < nodeMap1.getLength(); index++) {
			attributes1.put(nodeMap1.item(index).getNodeName(), nodeMap1.item(index));
		}

		// Sort by Name
		final NamedNodeMap nodeMap2 = node2.getAttributes();
		final Map<String, Node> attributes2 = new LinkedHashMap<String, Node>();
		for (int index = 0; nodeMap2 != null && index < nodeMap2.getLength(); index++) {
			attributes2.put(nodeMap2.item(index).getNodeName(), nodeMap2.item(index));

		}

		// Diff all the attributes1
		for (final Node attribute1 : attributes1.values()) {
			final Node attribute2 = attributes2.remove(attribute1.getNodeName());
			diff(attribute1, attribute2, diffs);
		}

		// Diff all the attributes2 left over
		for (final Node attribute2 : attributes2.values()) {
			final Node attribute1 = attributes1.get(attribute2.getNodeName());
			diff(attribute1, attribute2, diffs);
		}

		return diffs.size() > 0;
	}

	/**
	 * Check that the nodes exist
	 */
	private boolean diffNodeExists(Node node1, Node node2, List<String> diffs) throws Exception {
		if (node1 == null && node2 == null) {
			diffs.add(getPath(node2) + ":node " + node1 + "!=" + node2 + "\n");
			return true;
		}

		if (node1 == null && node2 != null) {
			diffs.add(getPath(node2) + ":node " + node1 + "!=" + node2.getNodeName());
			return true;
		}

		if (node1 != null && node2 == null) {
			diffs.add(getPath(node1) + ":node " + node1.getNodeName() + "!=" + node2);
			return true;
		}

		return false;
	}

	/**
	 * Diff the Node Type
	 */
	private boolean diffNodeType(Node node1, Node node2, List<String> diffs) throws Exception {
		if (node1.getNodeType() != node2.getNodeType()) {
			diffs.add(getPath(node1) + ":type " + node1.getNodeType() + "!=" + node2.getNodeType());
			return true;
		}

		return false;
	}

	/**
	 * Diff the Node Value
	 */
	private boolean diffNodeValue(Node node1, Node node2, List<String> diffs) throws Exception {
		if (node1.getNodeValue() == null && node2.getNodeValue() == null)
			return false;

		if (node1.getNodeValue() == null && node2.getNodeValue() != null) {
			diffs.add(getPath(node1) + ":type " + node1 + "!=" + node2.getNodeValue());
			return true;
		}

		if (node1.getNodeValue() != null && node2.getNodeValue() == null) {
			diffs.add(getPath(node1) + ":type " + node1.getNodeValue() + "!=" + node2);
			return true;
		}

		if (!node1.getNodeValue().equals(node2.getNodeValue())) {
			diffs.add(getPath(node1) + ":type " + node1.getNodeValue() + "!=" + node2.getNodeValue());
			return true;
		}

		return false;
	}

	/**
	 * Get the node path
	 * 
	 * @param node
	 *            an XML node
	 * @return the XPath to the node
	 */
	public String getPath(Node node) {
		final StringBuilder path = new StringBuilder();

		do {
			path.insert(0, node.getNodeName());
			path.insert(0, "/");
		} while ((node = node.getParentNode()) != null);

		return path.toString();
	}
}