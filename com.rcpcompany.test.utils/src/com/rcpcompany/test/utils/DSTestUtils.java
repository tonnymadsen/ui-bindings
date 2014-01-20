package com.rcpcompany.test.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.ManifestElement;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.service.component.ComponentConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.rcpcompany.test.utils.xml.XMLDiff;
import com.rcpcompany.utils.logging.LogUtils;

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
	public static void checkDSFiles(String bundleName) {
		final Bundle b = Platform.getBundle(bundleName);
		assertNotNull("bundle '" + bundleName + "' not found", b);

		final Context cxt = new Context(b);

		parseDSClasses(cxt);

		try {
			final Enumeration<URL> dsFileEnumerator = cxt.bundle.findEntries("/OSGI-INF", "*.xml", true);
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

					cxt.osgiinfDSFiles.add(path);

					parseDSFile(cxt, url);
				}
			}

			final Dictionary<String, String> headers = cxt.bundle.getHeaders();
			assertNotNull(headers);
			final String scHeader = headers.get(ComponentConstants.SERVICE_COMPONENT);

			if (scHeader != null) {
				try {
					final ManifestElement[] elements = ManifestElement.parseHeader(
							ComponentConstants.SERVICE_COMPONENT, scHeader);
					for (final ManifestElement e : elements) {
						final String v = e.getValue();
						if (v.startsWith("../")) {
							cxt.addProblem("Element of " + ComponentConstants.SERVICE_COMPONENT + " includes '../': '"
									+ v + "'");
							continue;
						}
						if (v.contains(" ") || v.contains("\t")) {
							cxt.addProblem("Element of " + ComponentConstants.SERVICE_COMPONENT
									+ " includes white space (' ' or tab) - missing comma?: '" + v + "'");
							continue;
						}
						cxt.manifestDSFiles.add(v);
					}
				} catch (final BundleException ex) {
					fail("" + ex);
					return;
				}
			}

			if (!cxt.manifestDSFiles.isEmpty()) {
				final String activationPolicy = headers.get("Bundle-ActivationPolicy");
				if (activationPolicy == null || !activationPolicy.equals("lazy")) {
					cxt.addProblem("'Bundle-ActivationPolicy: lazy' required");
				}
			}

			/*
			 * Go through the file specs of the ComponentConstants.SERVICE_COMPONENT header. And remove all matching
			 * files, one by one.
			 */
			for (final String ds : cxt.manifestDSFiles) {
				final int ind = ds.lastIndexOf('/');
				final String folder = ind != -1 ? ds.substring(0, ind) : "/"; //$NON-NLS-1$
				final String filePattern = ind != -1 ? ds.substring(ind + 1) : ds;
				final Enumeration<URL> urls = cxt.bundle.findEntries(folder, filePattern, false);
				if (urls == null || !urls.hasMoreElements()) {
					cxt.addProblem("DS string '" + ds + "' does not match any files");
					continue;
				}
				while (urls.hasMoreElements()) {
					final String path = urls.nextElement().getPath();
					if (!cxt.osgiinfDSFiles.remove(path)) {
						cxt.addProblem("entry not found in resources: " + path);
					}
				}
			}
			for (final String file : cxt.osgiinfDSFiles) {
				cxt.addProblem("resource with no pattern: " + file);
			}
		} catch (final Exception ex) {
			cxt.problems.append(ex);
		}

		for (final String c : cxt.dsClasses) {
			cxt.addProblem(c + " has @Component but it is not found in any DS files");
		}

		if (cxt.problems.length() > 0) {
			fail("Problems with DS files in bundle " + bundleName + ":" + cxt.problems);
		}
	}

	public static void parseDSClasses(final Context cxt) {
		try {
			final Enumeration<URL> classFileEnumerator = cxt.bundle.findEntries("/", "*.class", true);
			while (classFileEnumerator.hasMoreElements()) {
				final URL u = classFileEnumerator.nextElement();
				String e = u.getPath();
				if (!e.endsWith(".class")) {
					continue;
				}
				e = e.substring(1);
				e = e.replaceAll(".class$", "");
				e = e.replace("target/classes/", "");
				e = e.replace("/", ".");

				final String className = e;
				final InputStream classStream = u.openStream();

				try {
					final ClassReader classReader = new ClassReader(classStream);
					classReader.accept(new ClassVisitor(Opcodes.ASM4) {
						@Override
						public AnnotationVisitor visitAnnotation(final String annotationDesc, boolean visible) {
							if (annotationDesc.equals("Lorg/osgi/service/component/annotations/Component;")) {
								cxt.dsClasses.add(className);
								LogUtils.debug(u, "annotation: " + className + " - " + annotationDesc);
								return new AnnotationVisitor(Opcodes.ASM4) {
									@Override
									public void visit(String propertyName, Object propertyValue) {
										LogUtils.debug(u, "   property: " + propertyName + "=" + propertyValue);
									}
								};
							}
							return null;
						}

						@Override
						public MethodVisitor visitMethod(int access, final String methodName, String desc,
								String signature, String[] exceptions) {
							return new MethodVisitor(Opcodes.ASM4) {
								@Override
								public AnnotationVisitor visitAnnotation(final String annotationDesc, boolean visible) {
									if (annotationDesc.equals("Lorg/osgi/service/component/annotations/Reference;")) {
										cxt.dsMethods.add(className + " - " + methodName);
										if (!cxt.dsClasses.contains(className)) {
											cxt.addProblem(className + "." + methodName
													+ " has @Reference, but class does not have @Component");
										}
										LogUtils.debug(u, "annotation: " + className + "." + methodName + " - "
												+ annotationDesc);
										return new AnnotationVisitor(Opcodes.ASM4) {
											@Override
											public void visit(String propertyName, Object propertyValue) {
												LogUtils.debug(u, "   property: " + propertyName + "=" + propertyValue);
												super.visit(propertyName, propertyValue);
											}
										};
									}
									if (annotationDesc.equals("Lorg/osgi/service/component/annotations/Activate;")) {
										cxt.dsActivates.add(className + " - " + methodName);
										if (!cxt.dsClasses.contains(className)) {
											cxt.addProblem(className + "." + methodName
													+ " has @Activate, but class does not have @Component");
										}
										LogUtils.debug(u, "annotation: " + className + "." + methodName + " - "
												+ annotationDesc);
										return new AnnotationVisitor(Opcodes.ASM4) {
											@Override
											public void visit(String propertyName, Object propertyValue) {
												LogUtils.debug(u, "   property: " + propertyName + "=" + propertyValue);
												super.visit(propertyName, propertyValue);
											}
										};
									}
									if (annotationDesc.equals("Lorg/osgi/service/component/annotations/Deactivate;")) {
										cxt.dsDeactivates.add(className + " - " + methodName);
										if (!cxt.dsClasses.contains(className)) {
											cxt.addProblem(className + "." + methodName
													+ " has @Deactivate, but class does not have @Component");
										}
										LogUtils.debug(u, "annotation: " + className + "." + methodName + " - "
												+ annotationDesc);
										return new AnnotationVisitor(Opcodes.ASM4) {
											@Override
											public void visit(String propertyName, Object propertyValue) {
												LogUtils.debug(u, "   property: " + propertyName + "=" + propertyValue);
												super.visit(propertyName, propertyValue);
											}
										};
									}
									return null;
								}
							};
						}
					}, ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG);
				} finally {
					IOUtils.closeQuietly(classStream);
				}
			}
		} catch (final Exception ex) {
			cxt.addProblem("" + ex);
		}
	}

	/**
	 * Parses the specified URL as an DS file and reports any cxt.problems.
	 * 
	 * @param cxt
	 *            the context
	 * @param url
	 *            the URL for the DS filer (possibly in a fragment)
	 */
	private static void parseDSFile(Context cxt, URL url) {
		final String path = url.getPath();

		InputStream is = null;
		Node node = null;
		try {
			is = url.openStream();
			node = XMLDiff.toNode(is);
		} catch (final Exception ex) {
			cxt.addProblem(path + ": Found, but cannot open or parse: " + ex);
			return;
		} finally {
			IOUtils.closeQuietly(is);
		}

		/*
		 * Validate the XML
		 */
		// final String p = XMLTestUtils.validate(url, "http://www.osgi.org/xmlns/scr/v1.1.0/scr.xsd");
		// if (p != null) {
		// cxt.addProblem(path + ": File is not valid: " + p);
		// }

		String implementationName = null;
		final List<String> interfaces = new ArrayList<String>();

		/*
		 * TODO activate and deactivate
		 */

		/*
		 * Look inside component node
		 */
		final Node children = node.getFirstChild();

		/*
		 * Find the implementation node and parse this
		 */
		for (Node n = children.getFirstChild(); n != null; n = n.getNextSibling()) {
			final String nodeName1 = n.getNodeName();
			if (nodeName1.equals("implementation")) {
				if (implementationName != null) {
					cxt.addProblem(path + ": implementation class specified multiple times");
					continue;
				}
				final NamedNodeMap attributes = n.getAttributes();
				final Node implementationNameNode = attributes.getNamedItem("class");

				if (implementationNameNode == null) {
					cxt.addProblem(path + ": no implementation class specified");
					continue;
				}
				implementationName = implementationNameNode.getNodeValue();
				if (cxt.dsClasses.remove(implementationName)) {
					continue;
				}
				final URL classRes = cxt.bundle.getResource(implementationName.replace('.', '/') + ".class");

				if (classRes == null) {
					cxt.problems
							.append("\n  " + path + ": implementation class '" + implementationName + "' not found");
				} else {
					cxt.addProblem(path + ": implementation class '" + implementationName
							+ "' found, but misses @Component");
				}
				continue;
			}
		}
		if (implementationName == null) {
			cxt.addProblem(path + ": No implementation class found");
			return;
		}

		/*
		 * Parse all other nodes
		 */
		for (Node n = children.getFirstChild(); n != null; n = n.getNextSibling()) {
			final String nodeName2 = n.getNodeName();
			if (nodeName2.equals("implementation")) {
				continue;
			}

			if (nodeName2.equals("service")) {
				for (Node sn = node.getFirstChild(); sn != null; sn = sn.getNextSibling()) {
					if (sn.getNodeName().equals("provide")) {
						final NamedNodeMap attributes = sn.getAttributes();
						final Node interfaceNameNode = attributes.getNamedItem("interface");

						if (interfaceNameNode == null) {
							cxt.addProblem(path + ": no interface specified");
							continue;
						}
						interfaces.add(interfaceNameNode.getNodeValue());
					}
				}
				continue;
			}
			if (nodeName2.equals("reference")) {
				final NamedNodeMap attributes = n.getAttributes();
				final Node nameNode = attributes.getNamedItem("name");
				final Node bindNode = attributes.getNamedItem("bind");
				final Node interfaceNameNode = attributes.getNamedItem("interface");

				if (nameNode == null) {
					cxt.addProblem(path + ": no name specified for reference");
					continue;
				}
				if (bindNode == null) {
					cxt.addProblem(path + "/" + nameNode + ": no bind method specified");
					continue;
				}
				if (interfaceNameNode == null) {
					cxt.addProblem(path + "/" + nameNode + ": no reference interface specified");
					continue;
				}
				final String bindName = bindNode.getNodeValue();
				if (!cxt.dsMethods.remove(implementationName + " - " + bindName)) {
					cxt.addProblem(path + "/" + nameNode + ": bind method '" + bindName + "' does not have @Reference");
				}
				final String interfaceName = interfaceNameNode.getNodeValue();
				/*
				 * WRONG: search the correct bundle - can be from a fragment, which can have a different classpath
				 */
				final URL classRes = cxt.bundle.getResource(interfaceName.replace('.', '/') + ".class");

				if (classRes == null) {
					cxt.addProblem(path + "/" + nameNode + ": reference interface '" + interfaceName + "' not found");
				}
				continue;
			}
			if (nodeName2.equals("#text")) {
				continue;
			}
			if (nodeName2.equals("property")) {
				continue;
			}
			cxt.addProblem(path + "/" + nodeName2 + ": unknown node");
		}

		for (final String mn : cxt.dsMethods) {
			if (!mn.startsWith(implementationName + " - ")) {
				continue;
			}
			cxt.addProblem(path + ": " + mn + " has @Reference but is not referenced in this file");
		}
	}

	protected static class Context {
		public Context(Bundle b) {
			bundle = b;
		}

		/**
		 * Adds a new problem to the problems string...
		 * 
		 * @param text
		 */
		public void addProblem(String text) {
			problems.append("\n   " + text);
		}

		public final Bundle bundle;

		/**
		 * Found class with the {@link Component} annotation.
		 */
		public final List<String> dsClasses = new ArrayList<String>();

		/**
		 * Found methods with the {@link Reference} annotation.
		 * <p>
		 * On the form "className - methodName".
		 */
		public final List<String> dsMethods = new ArrayList<String>();

		/**
		 * Found methods with the {@link Reference} annotation.
		 * <p>
		 * On the form "className - methodName".
		 */
		public final List<String> dsActivates = new ArrayList<String>();

		/**
		 * Found methods with the {@link Reference} annotation.
		 * <p>
		 * On the form "className - methodName".
		 */
		public final List<String> dsDeactivates = new ArrayList<String>();

		/**
		 * Found files in OSGI-INF
		 */
		public final List<String> osgiinfDSFiles = new ArrayList<String>();

		/**
		 * Found references in MANIFEST.MF
		 */
		public final List<String> manifestDSFiles = new ArrayList<String>();

		/**
		 * Accumulated problems.
		 */
		public final StringBuilder problems = new StringBuilder();
	}
}
