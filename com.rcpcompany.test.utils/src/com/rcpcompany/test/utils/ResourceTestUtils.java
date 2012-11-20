package com.rcpcompany.test.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * Various test utilities that are good for testing the workspace...
 * 
 * @author Tonny Madsen, tma@bording.dk
 */
public class ResourceTestUtils {
	/**
	 * The workspace..
	 */
	protected static final IWorkspace WS = ResourcesPlugin.getWorkspace();

	/**
	 * The workspace Root..
	 */
	protected static final IWorkspaceRoot ROOT = WS.getRoot();

	/**
	 * Deletes the specified project if it exists.
	 * 
	 * @param projectName
	 *            the name of the project to delete
	 */
	public static void deleteProject(String projectName) {
		final IProject p = ROOT.getProject(projectName);
		try {
			p.delete(true, new NullProgressMonitor());
		} catch (final CoreException ex) {
			fail("" + ex);
		}
		assertFalse("project deleted", p.exists());
	}

	/**
	 * Deletes everything in the workspace.
	 */
	public static void deleteEverything() {
		for (final IProject p : ROOT.getProjects()) {
			try {
				p.delete(true, new NullProgressMonitor());
			} catch (final CoreException ex) {
				// Ignore!
			}
		}
		assertEquals("no projects left", 0, ROOT.getProjects().length);
	}
}
