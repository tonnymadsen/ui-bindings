package com.rcpcompany.test.utils.rap.rules;

import org.eclipse.rap.rwt.lifecycle.PhaseId;
import org.eclipse.rap.rwt.testfixture.Fixture;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.rules.ExternalResource;

/**
 * Simple JUnit Rule to allow testing of RAP based functionality.
 * 
 * @author Tonny Madsen
 */
public class RAPFixture extends ExternalResource {
	private Shell myShell = null;

	@Override
	protected void before() throws Throwable {
		Fixture.setUp();
		Fixture.fakePhase(PhaseId.PROCESS_ACTION);
		final Display display = new Display();
		myShell = new Shell(display);
	}

	@Override
	protected void after() {
		if (myShell != null) {
			myShell.getDisplay().dispose();
			myShell.dispose();
		}
		myShell = null;

		Fixture.tearDown();
	}

	public Shell getShell() {
		return myShell;
	}
}
