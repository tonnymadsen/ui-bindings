/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings;

/**
 * This interface is used to format a set of objects with a formatter.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IFormatter {
	/**
	 * Formats the the specified arguments according to the formatting specification of this
	 * formatter.
	 * 
	 * @param args the arguments
	 */
	void format(Object... args);
}
