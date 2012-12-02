package com.rcpcompany.test.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FilenameFilter;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.rcpcompany.utils.logging.LogUtils;

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
		if (!p.exists())
			return;
		try {
			p.close(new MonitoredMonitor());
		} catch (final CoreException ex) {
			ex.printStackTrace();
			fail("" + ex);
		}
		try {
			p.delete(true, true, new NullProgressMonitor());
		} catch (final CoreException ex) {
			ex.printStackTrace();
			fail("" + ex);
		}
		assertFalse("project deleted", p.exists());
	}

	/**
	 * Deletes everything in the workspace.
	 */
	public static void deleteEverything() {
		for (final IProject p : ROOT.getProjects(IWorkspaceRoot.INCLUDE_HIDDEN)) {
			try {
				p.close(new MonitoredMonitor());
			} catch (final CoreException ex) {
				ex.printStackTrace();
				fail("" + ex);
			}
			try {
				p.delete(true, true, new NullProgressMonitor());
			} catch (final CoreException ex) {
				ex.printStackTrace();
				fail("" + ex);
			}
		}
		assertEquals("no projects left", 0, ROOT.getProjects(IWorkspaceRoot.INCLUDE_HIDDEN).length);

		final IPath rootLocation = ROOT.getLocation();
		final File rootFile = rootLocation.toFile();
		assertTrue("ROOT does not exist", rootFile.exists());
		rootFile.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				LogUtils.debug(this, "file name=" + name);
				if (name.equals(".metadata"))
					return false;
				fail("File exists after delete: " + name);
				return false;
			}
		});
	}
}
