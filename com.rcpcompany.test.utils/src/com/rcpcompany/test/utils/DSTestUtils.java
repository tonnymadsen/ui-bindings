package com.rcpcompany.test.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
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
		String problems = "";

		final Enumeration<String> dsFileEnumerator = bundle.getEntryPaths("OSGI-INF");
		if (dsFileEnumerator != null) {
			while (dsFileEnumerator.hasMoreElements()) {
				final String e = dsFileEnumerator.nextElement();
				if (e.startsWith(".")) {
					continue;
				}
				if (!e.endsWith(".xml")) {
					continue;
				}

				foundDSFiles.add("/" + e);

				InputStream is = null;
				try {
					is = FileLocator.openStream(bundle, new Path(e), false);
				} catch (final IOException ex) {
					problems += "\n  Found, but cannot open as stream: " + e + " - " + ex;
					continue;
				}

				Node node = null;
				try {
					node = XMLDiff.toNode(is);
				} catch (final Exception ex) {
					problems += "\n  Found, but cannot parse: " + e + " - " + ex;
					continue;
				}

				/*
				 * Get component node
				 */
				node = node.getFirstChild();
				for (Node n = node.getFirstChild(); n != null; n = n.getNextSibling()) {
					if (n.getNodeName().equals("implementation")) {
						final NamedNodeMap attributes = n.getAttributes();
						final Node className = attributes.getNamedItem("class");

						if (className == null) {
							problems += "\n  no class specified in " + e;
						}
						final URL classRes = bundle.getResource(className.getNodeValue().replace('.', '/') + ".class");

						if (classRes == null) {
							problems += "\n  Class in DS '" + className.getNodeValue() + "'does not exist " + e;
						}
						continue;
					}
					if (n.getNodeName().equals("reference")) {
						final NamedNodeMap attributes = n.getAttributes();
						final Node className = attributes.getNamedItem("interface");

						if (className == null) {
							problems += "\n  no interface specified in " + e;
						}
						final URL classRes = bundle.getResource(className.getNodeValue().replace('.', '/') + ".class");

						if (classRes == null) {
							problems += "\n  Interface in DS '" + className.getNodeValue() + "' does not exist (" + e
									+ ")";
						}
						continue;
					}
				}
			}
		}

		final Dictionary<String, String> headers = bundle.getHeaders();
		assertNotNull(headers);
		final String scHeader = headers.get(ComponentConstants.SERVICE_COMPONENT);

		if (scHeader != null) {
			try {
				final ManifestElement[] elements = ManifestElement.parseHeader(ComponentConstants.SERVICE_COMPONENT,
						scHeader);
				for (final ManifestElement e : elements) {
					final String v = e.getValue();
					if (v.startsWith("../")) {
						problems += "\n  Element of " + ComponentConstants.SERVICE_COMPONENT + " includes '../'";
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
			problems += "\n  Bundle-ActivationPolicy must be 'lazy'";
		}

		for (final String ds : expectedDSFiles) {
			final int ind = ds.lastIndexOf('/');
			final String path = ind != -1 ? ds.substring(0, ind) : "/"; //$NON-NLS-1$

			final Enumeration<URL> urls = bundle.findEntries(path, ind != -1 ? ds.substring(ind + 1) : ds, false);
			if (urls == null || !urls.hasMoreElements()) {
				problems += "\n  DS string '" + ds + "' does not point to any file";
				continue;
			}
			while (urls.hasMoreElements()) {
				final URL u = urls.nextElement();
				// Internal problem...
				assertTrue("Cannot remove entry " + u.getPath(), foundDSFiles.remove(u.getPath()));
			}
		}
		for (final String file : foundDSFiles) {
			problems += "\n  file with no pattern: " + file;
		}

		if (problems.length() > 0) {
			fail("Problems with DS files " + bundleName + ":" + problems);
		}
	}

}
