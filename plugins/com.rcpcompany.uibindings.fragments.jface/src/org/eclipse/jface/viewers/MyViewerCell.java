/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package org.eclipse.jface.viewers;

/**
 * {@link ViewerCell} with a public constructor.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class MyViewerCell extends ViewerCell {
	/**
	 * Public constant viewer cell.
	 */
	public static final ViewerCell INSTANCE = new MyViewerCell();

	public MyViewerCell() {
		super(null, 0, 0);
	}
}
