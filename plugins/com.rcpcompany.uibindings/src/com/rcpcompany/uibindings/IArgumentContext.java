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
package com.rcpcompany.uibindings;

/**
 * This interface describes the context used when new objects are created in
 * {@link IManager#convertArgumentValue(String, org.eclipse.core.runtime.IConfigurationElement, String, String, Class, IArgumentValueCreationContext)}
 * .
 * 
 * @author Tonny Madsen, The RCP Company
 * @param <ArgumentType> the wanted argument type
 */
public interface IArgumentContext<ArgumentType> {
	/**
	 * The binding of this context.
	 * 
	 * @return the binding
	 */
	IBinding getBinding();

	/**
	 * The name of the argument to return.
	 * 
	 * @return the name
	 */
	String getName();

	/**
	 * The binding type of the argument.
	 * 
	 * @return the type
	 */
	String getType();

	/**
	 * The expected type of the argument to return.
	 * 
	 * @return the argument type
	 */
	Class<? extends ArgumentType> getArgumentType();

	/**
	 * Whether to return one or all possible argument values.
	 * 
	 * @return <code>true</code> if only one result is wanted
	 */
	boolean firstOnly();

	/**
	 * Adds a new result to the list of results for this argument.
	 * 
	 * @param source the source of the argument value - e.g. an {@link IArgumentProvider}
	 * @param value the value
	 */
	void addResult(Object source, ArgumentType value);

	/**
	 * Whether enough results has been found.
	 * 
	 * @return <code>true</code> if enough results have been found so far
	 */
	boolean isResultFound();
}
