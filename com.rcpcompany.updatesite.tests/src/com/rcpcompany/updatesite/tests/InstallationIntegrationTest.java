package com.rcpcompany.updatesite.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.tools.FileObject;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.equinox.internal.p2.rollback.FormerState;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.engine.IEngine;
import org.eclipse.equinox.p2.engine.IProfile;
import org.eclipse.equinox.p2.engine.IProfileRegistry;
import org.eclipse.equinox.p2.engine.IProvisioningPlan;
import org.eclipse.equinox.p2.engine.ProvisioningContext;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.planner.IPlanner;
import org.eclipse.equinox.p2.planner.IProfileChangeRequest;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepositoryManager;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.agetor.constants.AgetorServerConstants;
import com.agetor.test.utils.ARCH;
import com.google.common.io.LineReader;
import com.rcpcompany.test.utils.MonitoredMonitor;
import com.rcpcompany.utils.basic.TSStatusUtils;

/**
 * Tests that various different installations can be updated to this version of the workbench.
 * <p>
 * The implementation creates a backup profile and uses this to backup the original configuration to allow us to revert
 * the configuration afterwards
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class InstallationIntegrationTest {
	@Rule
	public Timeout globalTimeout = new Timeout(20 * 60 * 1000); // 20 minutes max per method tested

	/**
	 * Path to the installation area for the package.
	 */
	private URI myInstallAreaURI;

	/**
	 * Main repository as an URI.
	 */
	private URI WB_REPO;

	/**
	 * The URL for the installation package as supported by Apache Commons VFS
	 */
	private final String myInstallationURL;

	/**
	 * The architecture of the installation package.
	 */
	private final ARCH myArch;

	/**
	 * The relative path inside the installation package to the Product root (usually "eclipse").
	 */
	private final String myProductPath;

	/**
	 * The relative path inside the installation package to the P2 root (usually "eclipse/p2").
	 */
	private final String myP2Path;

	/**
	 * The p2 profile ID
	 */
	private String myP2Profile;

	private final String what;

	@Parameters
	public static List<Object[]> data() {
		/*
		 * Directories where products might be found.
		 * 
		 * Only used for "file:" lines...
		 */
		final String folderList[] = { "/Eclipse/Downloads", "D:\\Downloads" };

		/*
		 * The lost of the known products what should be installed into
		 * 
		 * Format: VFS URL for package file/dir, architecture, internal path for product root, internal path for p2
		 * root, p2 profile (null means use the only defined)
		 */
		final Object[][] bruttoList = new Object[][] {
				// { "tgz:file:eclipse-rcp-juno-macosx-cocoa-x86_64.tar.gz", ARCH.MACOSX,
				// "eclipse", "eclipse/p2",
				// null },
				{ "file:eclipse-SDK-3.8-macosx-cocoa-x86_64", ARCH.MACOSX, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-SDK-3.8-win32-x86_64", ARCH.WIN32_64, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-SDK-3.8.1-macosx-cocoa-x86_64", ARCH.MACOSX, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-SDK-3.8.2-linux-gtk-x86_64", ARCH.LINUX_64, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-SDK-3.8.2-macosx-cocoa-x86_64", ARCH.MACOSX, "eclipse", "eclipse/p2", null },
				// { "file:eclipse-SDK-3.8.2-solaris-gtk", ARCH.SOLARIS_64, "eclipse", "eclipse/p2", null
				// },
				{ "file:eclipse-SDK-3.8.2-win32-x86_64", ARCH.WIN32_64, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-java-kepler-R-win32-x86_64", ARCH.WIN32_64, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-jee-juno-SR2-macosx-cocoa-x86_64", ARCH.MACOSX, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-jee-juno-SR2-win32-x86_64", ARCH.WIN32_64, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-jee-kepler-R-macosx-cocoa-x86_64", ARCH.MACOSX, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-jee-kepler-R-win32-x86_64", ARCH.WIN32_64, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-platform-3.8.2-macosx-cocoa-x86_64", ARCH.MACOSX, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-platform-3.8.2-win32-x86_64", ARCH.WIN32_64, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-rcp-indigo-SR2-macosx-cocoa-x86_64", ARCH.MACOSX, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-rcp-juno-SR1-macosx-cocoa-x86_64", ARCH.MACOSX, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-rcp-juno-SR1-win32-x86_64", ARCH.WIN32_64, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-rcp-juno-SR2-macosx-cocoa-x86_64", ARCH.MACOSX, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-rcp-juno-SR2-win32-x86_64", ARCH.WIN32_64, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-rcp-juno-macosx-cocoa-x86_64", ARCH.MACOSX, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-rcp-kepler-R-macosx-cocoa-x86_64", ARCH.MACOSX, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-rcp-kepler-R-win32-x86_64", ARCH.WIN32_64, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-reporting-kepler-R-win32-x86_64", ARCH.WIN32_64, "eclipse", "eclipse/p2", null },
				{ "file:eclipse-standard-kepler-R-macosx-cocoa-x86_64", ARCH.MACOSX, "eclipse", "eclipse/p2", null },
		// { "file:eclipse-rcp-kepler-R-macosx-cocoa-x86_64", ARCH.MACOSX, "eclipse", "eclipse/p2", null },

		};
		final List<ARCH> testArchs = ARCH.getTestValues();
		final List<Object[]> found = new ArrayList<Object[]>();
		for (final Object[] l : bruttoList) {
			String url = (String) l[0];
			final ARCH arch = (ARCH) l[1];
			final String productPath = (String) l[2];
			final String p2Path = (String) l[3];
			final String p2Profile = (String) l[4];

			if (!testArchs.contains(arch)) {
				continue;
			}

			final int i = url.indexOf("file:");
			if (i != -1) {
				final String filename = url.substring(i + 5);
				String ff = null;
				for (final String folder : folderList) {
					final File f = new File(folder + "/" + filename);
					if (f.exists()) {
						ff = f.toURI().toString();
						break;
					}
				}
				if (ff == null) {
					continue;
				}
				url = url.substring(0, i) + ff;
			}

			found.add(new Object[] { url, arch, productPath, p2Path, p2Profile });
		}
		return found;
	}

	public InstallationIntegrationTest(String installaionURL, ARCH arch, String productPath, String p2Path,
			String p2Profile) {
		myInstallationURL = installaionURL;
		myArch = arch;
		myProductPath = productPath;
		myP2Path = p2Path;
		myP2Profile = p2Profile;

		what = myInstallationURL;

		System.out.println("*** " + what);
	}

	private IProvisioningAgent myAgent = null;
	private IProfileRegistry myProfileRegistry;
	private IMetadataRepositoryManager myMetadataManager;
	private IArtifactRepositoryManager myArtifactManager;
	private IPlanner myPlanner;
	private IEngine myEngine;
	private IProfile myProfile;
	private long myProfileTimestamp;
	private IProfile myBackupProfile;

	private URI myProductURI;

	@Before
	public void setupManager() {
		System.out.println("    - Setup");
		final String prop = System.getProperty("WB_REPO");
		assertNotNull("No WB_REPO property specified", prop);
		final File f = new File(prop);
		assertTrue("WB Repository does not exist: " + f, f.exists());
		WB_REPO = f.toURI();

		assertNotNull(what + ": location defined", DSLocation.get());
		assertEquals(what + ": Only file: location protocol is supported", "file", DSLocation.get().getURL()
				.getProtocol());
		assertNotNull(what + ": agent provider defined", DSAgent.get());

		assertEquals(what + ": location r/w", false, DSLocation.get().isReadOnly());

		if (myInstallationURL.startsWith("file:")) {
			/*
			 * So we are talking a a plain folder in the file system... test it...
			 */
			myInstallAreaURI = URI.create(myInstallationURL);
		} else {
			/*
			 * Find a place to install the product
			 */
			try {
				myInstallAreaURI = DSLocation.get().getDataArea("install-area").toURI();
			} catch (final Exception ex) {
				fail(what + ": getDataAea: " + ex);
				return;
			}

			deleteArea(myInstallAreaURI);

			/*
			 * Install the existing product into this place
			 */
			try {
				final FileSystemManager fsManager = VFS.getManager();
				final FileObject archive = fsManager.resolveFile(myInstallationURL);

				// List the children of the archive file
				System.out.println("    - Unpacking installation");

				unpack(archive);
			} catch (final FileSystemException ex) {
				fail(what + ": VFS: " + ex);
				return;
			} catch (final Exception ex) {
				fail(what + ": " + ex);
				return;
			}
		}
		assertTrue(what + ": " + myInstallAreaURI + " not a plain directory", new File(myInstallAreaURI).isDirectory());
		myProductURI = URIUtil.append(myInstallAreaURI, myProductPath);

		/*
		 * Now open the area as a P2 area
		 */
		final URI myP2URI = URIUtil.append(myInstallAreaURI, myP2Path);
		assertTrue(what + ": " + myP2URI + " not a plain directory", new File(myP2URI).isDirectory());

		try {
			myAgent = DSAgent.get().createAgent(myP2URI);
		} catch (final ProvisionException ex) {
			fail(what + ": createAgent: " + ex);
			return;
		}

		try {
			// From the director app
			myAgent.registerService(IProvisioningAgent.INSTALLER_AGENT, DSAgent.get().createAgent(null));
		} catch (final ProvisionException ex) {
			fail(what + ": createAgent: " + ex);
			return;
		}

		myProfileRegistry = (IProfileRegistry) myAgent.getService(IProfileRegistry.SERVICE_NAME);
		assertNotNull(myProfileRegistry);
		myMetadataManager = (IMetadataRepositoryManager) myAgent.getService(IMetadataRepositoryManager.SERVICE_NAME);
		assertNotNull(myMetadataManager);
		myArtifactManager = (IArtifactRepositoryManager) myAgent.getService(IArtifactRepositoryManager.SERVICE_NAME);
		assertNotNull(myArtifactManager);
		myPlanner = (IPlanner) myAgent.getService(IPlanner.SERVICE_NAME);
		assertNotNull(myPlanner);
		myEngine = (IEngine) myAgent.getService(IEngine.SERVICE_NAME);
		assertNotNull(myEngine);
		// From the director app
		myAgent.registerService("eclipse.p2.profile", myP2Profile);

		final IProfile[] profiles = myProfileRegistry.getProfiles();
		if (myP2Profile == null) {
			assertTrue(profiles != null && profiles.length == 1);
			myP2Profile = profiles[0].getProfileId();
		}
		myProfile = myProfileRegistry.getProfile(myP2Profile);

		if (myProfile == null) {
			String profileDesc = "";
			for (final IProfile p : profiles) {
				if (profileDesc.length() > 0) {
					profileDesc += ", ";
				}
				profileDesc += p.getProfileId();
			}
			fail(what + ": Expected profile '" + myP2Profile + "' but found [" + profileDesc + "]");
		}

		/*
		 * Find the current timestamp for the profile
		 */
		final long[] profileTimestamps = myProfileRegistry.listProfileTimestamps(myP2Profile);
		myProfileTimestamp = 0;
		for (final long ts : profileTimestamps) {
			if (myProfileTimestamp < ts) {
				myProfileTimestamp = ts;
			}
		}

		/*
		 * Make a backup of the main profile
		 */
		myBackupProfile = myProfileRegistry.getProfile(myP2Profile, myProfileTimestamp);
		// if (myBackupProfile == null) {
		// try {
		// myBackupProfile = myProfileRegistry.addProfile("TEST-BACKUP");
		// } catch (final ProvisionException ex) {
		// fail(what + ": addProfile: " + ex);
		// return;
		// }
		// }
		assertNotNull(myBackupProfile);

		// copyProfile(myProfile, myBackupProfile);
	}

	/**
	 * Copies all provisioning from one profile to another.
	 * 
	 * @param from
	 *            the profile to copy from
	 * @param to
	 *            the profile to copy to
	 */
	private void copyProfile(IProfile from, IProfile to) {
		System.out.println("    - Copy profile " + from.getProfileId() + "[" + from.getTimestamp() + "] -> "
				+ to.getProfileId() + "[" + to.getTimestamp() + "]");
		@SuppressWarnings("restriction")
		final IProfileChangeRequest deltaChangeRequest = FormerState.generateProfileDeltaChangeRequest(to, from);
		assertNotNull(deltaChangeRequest);
		final String productPath = myProductURI.getPath();
		deltaChangeRequest.setProfileProperty(IProfile.PROP_INSTALL_FOLDER, productPath);
		deltaChangeRequest.setProfileProperty(IProfile.PROP_CACHE, productPath);

		final ProvisioningContext context = new ProvisioningContext(myAgent);
		final IProvisioningPlan plan = myPlanner.getProvisioningPlan(deltaChangeRequest, context,
				new MonitoredMonitor());
		assertNotNull(plan);
		IStatus status = plan.getStatus();
		assertTrue(what + ": Cannot plan backup:\n" + TSStatusUtils.toString(status), status.isOK());

		status = myEngine.perform(plan, new MonitoredMonitor());
		assertTrue(what + ": Cannot install backup:\n" + TSStatusUtils.toString(status), status.isOK());
	}

	@After
	public void cleanup() {
		if (myProfile != null && myBackupProfile != null) {
			copyProfile(myBackupProfile, myProfile);
		}
		if (myAgent != null) {
			myAgent.stop();
		}
		if (!myInstallationURL.startsWith("file:")) {
			deleteArea(myInstallAreaURI);
		}
	}

	/**
	 * Tests whether the product can be updated with {@link AgetorServerConstants#WB_FEATURE_ID}.
	 * <p>
	 * Only the planner is run - the product is not actually updated.
	 */
	@SuppressWarnings("resource")
	@Test
	public void testUpdate() {
		try {
			System.out.println("    - Adding repository location: " + WB_REPO);
			myMetadataManager.loadRepository(WB_REPO, null);
			myArtifactManager.addRepository(WB_REPO);

			final IInstallableUnit iu = findFeature();
			updateProperties();
			installFeature(iu);

			// assertBundleInfo();
		} catch (final Exception ex) {
			fail(what + ": " + ex);
		} finally {
			myMetadataManager.removeRepository(WB_REPO);
			myArtifactManager.removeRepository(WB_REPO);
		}
	}

	public void assertBundleInfo() throws Exception {
		final String configPath = myProductURI.getPath() + "/configuration/config.ini";
		final File configFile = new File(configPath);
		assertTrue("config.ini does not exist", configFile.exists());
		final Properties configProperties = new Properties();
		FileInputStream configIS = null;
		try {
			configIS = new FileInputStream(configFile);
			configProperties.load(configIS);
		} catch (final FileNotFoundException ex) {
			fail(what + ": " + ex);
		} catch (final IOException ex) {
			fail(what + ": " + ex);
		} finally {
			IOUtils.closeQuietly(configIS);
		}
		/*
		 * Find bundle.info
		 */
		final String biURL = (String) configProperties.get("org.eclipse.equinox.simpleconfigurator.configUrl");
		assertNotNull("Cannot find bundle.info", biURL);
		final URI biURI = URIUtil
				.makeAbsolute(URIUtil.fromString(biURL), URIUtil.append(myProductURI, "configuration"));
		final File biFile = URIUtil.toFile(biURI);
		/*
		 * Parse the bundle.info file
		 */
		FileInputStream biIS = null;
		try {
			biIS = new FileInputStream(biFile);
			final LineReader lr = new LineReader(new InputStreamReader(new BufferedInputStream(biIS)));
			String l;
			while ((l = lr.readLine()) != null) {
				if (l.startsWith("#")) {
					continue;
				}
				final String[] s = l.split(",");
				if (s[0].equals("com.agetor.core.logging.impl")) {
					assertEquals("start-level of " + s[0], "1", s[3]);
					assertEquals("auto-start of " + s[0], "true", s[4]);
				}
			}
		} finally {
			IOUtils.closeQuietly(biIS);
		}
	}

	public IInstallableUnit findFeature() {
		System.out.println("    - Finding feature " + AgetorServerConstants.WB_FEATURE_ID);
		final IQuery<IInstallableUnit> query = QueryUtil.createIUQuery(AgetorServerConstants.WB_FEATURE_ID
				+ AgetorServerConstants.FEATURE_SUFFIX);
		final IQueryResult<IInstallableUnit> result = myMetadataManager.query(query, new MonitoredMonitor());
		final Set<IInstallableUnit> set = result.toSet();
		assertEquals(what + ": did not find one result: " + set, 1, set.size());
		final IInstallableUnit iu = set.iterator().next();
		assertNotNull(iu);
		return iu;
	}

	public void updateProperties() {
		final String productPath = URIUtil.append(myInstallAreaURI, myProductPath).getPath();
		final Map<String, String> properties = myProfile.getProperties();
		if (productPath.equals(properties.get(IProfile.PROP_CACHE))
				&& productPath.equals(properties.get(IProfile.PROP_INSTALL_FOLDER)))
			return;

		System.out.println("    - Updating install properties");
		final IProfileChangeRequest request = myPlanner.createChangeRequest(myProfile);
		assertNotNull(request);
		request.setProfileProperty(IProfile.PROP_INSTALL_FOLDER, productPath);
		request.setProfileProperty(IProfile.PROP_CACHE, productPath);
		//request.setProfileProperty(IProfile.PROP_ROAMING, "false"); //$NON-NLS-1$

		final ProvisioningContext context = new ProvisioningContext(myAgent);
		final IProvisioningPlan plan = myPlanner.getProvisioningPlan(request, context, new MonitoredMonitor());
		assertNotNull(plan);
		IStatus status = plan.getStatus();
		assertTrue(what + ": Cannot plan for update of properties:\n" + TSStatusUtils.toString(status), status.isOK());

		/*
		 * Execute plan
		 */
		status = myEngine.perform(plan, new MonitoredMonitor());
		assertTrue(what + ": Cannot update properties:\n" + TSStatusUtils.toString(status), status.isOK());
	}

	public void installFeature(final IInstallableUnit iu) {
		System.out.println("    - Installing iu");
		final IProfileChangeRequest request = myPlanner.createChangeRequest(myProfile);
		assertNotNull(request);
		request.add(iu);

		final ProvisioningContext context = new ProvisioningContext(myAgent);
		/*
		 * Only download from our own repository
		 */
		final URI[] repositories = new URI[] { WB_REPO };
		context.setMetadataRepositories(repositories);
		context.setArtifactRepositories(repositories);
		/*
		 * Create a plan...
		 */
		final IProvisioningPlan plan = myPlanner.getProvisioningPlan(request, context, new MonitoredMonitor());
		assertNotNull(plan);
		IStatus status = plan.getStatus();
		assertTrue(
				what + ": Cannot plan " + AgetorServerConstants.WB_FEATURE_ID + ":\n" + TSStatusUtils.toString(status),
				status.isOK());

		/*
		 * Do test installation
		 */
		status = myEngine.perform(plan, new MonitoredMonitor());
		assertTrue(
				what + ": Cannot install " + AgetorServerConstants.WB_FEATURE_ID + ":\n"
						+ TSStatusUtils.toString(status), status.isOK());
	}

	private void unpack(final FileObject archive) throws FileSystemException, FileNotFoundException, IOException {
		for (final FileObject fo : archive.getChildren()) {
			if (!fo.isReadable()) {
				continue;
			}
			switch (fo.getType()) {
			case FOLDER:
				unpack(fo);
				break;
			case FILE:
				final FileContent fc = fo.getContent();
				final InputStream is = fc.getInputStream();
				final File f = new File(myInstallAreaURI + "/" + fo.getName().getPath());
				f.getParentFile().mkdirs();
				final OutputStream os = new FileOutputStream(f);

				try {
					IOUtils.copyLarge(is, os);
				} finally {
					IOUtils.closeQuietly(is);
					IOUtils.closeQuietly(os);
				}
				break;
			case IMAGINARY:
			case FILE_OR_FOLDER:
				break;
			}
		}
	}

	private void deleteArea(URI installAreaURI) {
		if (installAreaURI == null)
			return;

		final File file = new File(installAreaURI);

		if (!file.exists())
			return;

		deleteFile(file);
		if (!file.exists())
			return;
		fail(what + ": files still exists - not deleted:\n" + listFiles(file));
	}

	private String listFiles(File file) {
		try {
			if (!file.exists())
				return "";
			if (file.isDirectory()) {
				final File[] files = file.listFiles();
				if (files.length == 0)
					return file.getCanonicalPath();
				String l = "";
				for (final File f : files) {
					if (l.length() > 0) {
						l += "\n";
					}
					l += listFiles(f);
				}
			}
			return file.getCanonicalPath();
		} catch (final IOException ex) {
			return "" + ex;
		}
	}

	private void deleteFile(File file) {
		if (file.isDirectory()) {
			for (final File f : file.listFiles()) {
				deleteFile(f);
			}
		}
		assertTrue(what + ": cannot delete file: " + file, file.delete());
	}
}
