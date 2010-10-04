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
 * This interface describes the context used looking up arguments in
 * {@link IManager#convertArgumentValue(String, org.eclipse.core.runtime.IConfigurationElement, String, String, Class, IArgumentValueCreationContext)}
 * .
 * 
 * @author Tonny Madsen, The RCP Company
 * @param <ArgumentType> the wanted argument type
 */
public interface IArgumentContext<ArgumentType> {
	/**
	 * The binding of this context.
	 * <p>
	 * Only set for {@link IBinding#getArgument(String, Class, Object)} and
	 * {@link IBinding#getArguments(String, Class, boolean)}, but not
	 * {@link IBindingDataType#getArgument(String, String, Class, Object)}.
	 * 
	 * 
	 * @return the binding or <code>null</code>
	 */
	IBinding getBinding();

	/**
	 * The name of the argument to return.
	 * 
	 * @return the name
	 */
	String getName();

	/**
	 * Returns the known information about the argument name.
	 * <p>
	 * If the argument has not been declared default information is returned.
	 * 
	 * @return the argument information
	 */
	IArgumentInformation getArgumentInformation();

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
