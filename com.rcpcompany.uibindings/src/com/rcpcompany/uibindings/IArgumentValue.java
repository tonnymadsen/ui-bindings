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
package com.rcpcompany.uibindings;

/**
 * One argument value record as returned by {@link IBinding#getArguments(String, Class, boolean)}
 * and many other methods.
 * 
 * @param <ArgumentType> the wanted argument type
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IArgumentValue<ArgumentType> {
	/**
	 * The source of the specific argument value.
	 * <p>
	 * In most cases, this is an {@link IArgumentProvider} object.
	 * 
	 * @return the source of the value - possibly in the form of an {@link IArgumentProvider}
	 */
	Object getSource();

	/**
	 * The value returned by the source.
	 * 
	 * @return the value
	 */
	ArgumentType getValue();
}
