/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.extests;

import static org.junit.Assert.*;

import org.eclipse.jface.resource.JFaceResources;
import org.junit.Test;

public class ColorsAndFontsTests {

	@Test
	public void testColors() {
		assertNotNull(JFaceResources.getColorRegistry().get("ACTIVE_HYPERLINK_COLOR"));
		assertNotNull(JFaceResources.getColorRegistry().get(
				"com.rcpcompany.uibindings.colorDefinitions.EvenRowBackground"));
	}
}
