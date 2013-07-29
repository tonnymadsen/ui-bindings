package com.rcpcompany.test.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.ManifestElement;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.service.component.ComponentConstants;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.rcpcompany.test.utils.xml.XMLDiff;

/**
 * Various utilities to ease testing of OSGi Declarative Services.
 * 
 * @author Tonny Madsen, tonny.madsen@gmail.com
 */
public class DSTestUtils {

	/**
	 * Tests that the Declarative Services are correctly configured
	 * 
	 * @param bundleName
	 *            the name of the bundle
	 */
	@SuppressWarnings("null")
	public static void checkDSFiles(String bundleName) {
		final Bundle bundle = Platform.getBundle(bundleName);
		assertNotNull("bundle '" + bundleName + "' not found", bundle);

		final List<String> foundDSFiles = new ArrayList<String>();
		final List<String> expectedDSFiles = new ArrayList<String>();
		final StringBuilder problems = new StringBuilder();
		try {
			final Enumeration<URL> dsFileEnumerator = bundle.findEntries("/OSGI-INF", "*.xml", true);
			if (dsFileEnumerator != null) {
				while (dsFileEnumerator.hasMoreElements()) {
					final URL url = dsFileEnumerator.nextElement();
					final String path = url.getPath();
					if (path.startsWith(".")) {
						continue;
					}
					if (!path.endsWith(".xml")) {
						continue;
					}

					foundDSFiles.add(path);

					parseDSFile(bundle, url, problems);
				}
			}

			final Dictionary<String, String> headers = bundle.getHeaders();
			assertNotNull(headers);
			final String scHeader = headers.get(ComponentConstants.SERVICE_COMPONENT);

			if (scHeader != null) {
				try {
					final ManifestElement[] elements = ManifestElement.parseHeader(
							ComponentConstants.SERVICE_COMPONENT, scHeader);
					for (final ManifestElement e : elements) {
						final String v = e.getValue();
						if (v.startsWith("../")) {
							problems.append("\n  Element of " + ComponentConstants.SERVICE_COMPONENT
									+ " includes '../': '" + v + "'");
							continue;
						}
						if (v.contains(" ") || v.contains("\t")) {
							problems.append("\n  Element of " + ComponentConstants.SERVICE_COMPONENT
									+ " includes white space (' ' or tab) - missing comma?: '" + v + "'");
							continue;
						}
						expectedDSFiles.add(v);
					}
				} catch (final BundleException ex) {
					fail("" + ex);
					return;
				}
			}

			final String activationPolicy = headers.get("Bundle-ActivationPolicy");
			if (activationPolicy == null || !activationPolicy.equals("lazy")) {
				problems.append("\n  'Bundle-ActivationPolicy: lazy' required");
			}

			/*
			 * Go through the file specs of the ComponentConstants.SERVICE_COMPONENT header. And remove all matching
			 * files, one by one.
			 */
			for (final String ds : expectedDSFiles) {
				final int ind = ds.lastIndexOf('/');
				final String folder = ind != -1 ? ds.substring(0, ind) : "/"; //$NON-NLS-1$
				final String filePattern = ind != -1 ? ds.substring(ind + 1) : ds;
				final Enumeration<URL> urls = bundle.findEntries(folder, filePattern, false);
				if (urls == null || !urls.hasMoreElements()) {
					problems.append("\n  DS string '" + ds + "' does not match any files");
					continue;
				}
				while (urls.hasMoreElements()) {
					final String path = urls.nextElement().getPath();
					if (!foundDSFiles.remove(path)) {
						problems.append("\n  entry not found in resources: " + path);
					}
				}
			}
			for (final String file : foundDSFiles) {
				problems.append("\n  resource with no pattern: " + file);
			}
		} catch (final Exception ex) {
			problems.append(ex);
		}
		if (problems.length() > 0) {
			fail("Problems with DS files " + bundleName + ":" + problems);
		}
	}

	/**
	 * Parses the specified URL as an DS file and reports any problems.
	 * 
	 * @param bundle
	 *            the host bundle of the file
	 * @param url
	 *            the URL for the DS filer (possibly in a fragment)
	 * @param problems
	 *            any problems
	 */
	private static void parseDSFile(Bundle bundle, URL url, StringBuilder problems) {
		final String path = url.getPath();
		InputStream is = null;
		Node node = null;
		try {
			is = url.openStream();
			node = XMLDiff.toNode(is);
		} catch (final Exception ex1) {
			problems.append("\n  " + path + ": Found, but cannot open or parse: " + ex1);
			return;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (final IOException ex) {
					// Ignore
				}
			}
		}

		/*
		 * Get component node
		 */
		node = node.getFirstChild();
		for (Node n = node.getFirstChild(); n != null; n = n.getNextSibling()) {
			if (n.getNodeName().equals("implementation")) {
				final NamedNodeMap attributes = n.getAttributes();
				final Node classNameNode = attributes.getNamedItem("class");

				if (classNameNode == null) {
					problems.append("\n  " + path + ": no implementation class specified");
					continue;
				}
				final String classNameResource = classNameNode.getNodeValue().replace('.', '/') + ".class";
				final URL classRes = bundle.getResource(classNameResource);

				if (classRes == null) {
					problems.append("\n  " + path + ": implementation class '" + classNameNode.getNodeValue()
							+ "' not found");
				}
				continue;
			}
			if (n.getNodeName().equals("reference")) {
				final NamedNodeMap attributes = n.getAttributes();
				final Node nameNode = attributes.getNamedItem("name");
				final Node interfaceNameNode = attributes.getNamedItem("interface");

				if (interfaceNameNode == null) {
					problems.append("\n  " + path + "/" + nameNode + ": no reference interface specified");
					continue;
				}
				final String classNameResource = interfaceNameNode.getNodeValue().replace('.', '/') + ".class";
				/*
				 * WRONG: search the correct bundle - can be from a fragment, which can have a different classpath
				 */
				final URL classRes = bundle.getResource(classNameResource);

				if (classRes == null) {
					problems.append("\n  " + path + "/" + nameNode + ": reference interface '"
							+ interfaceNameNode.getNodeValue() + "' not found");
				}
				continue;
			}
		}
	}
}
