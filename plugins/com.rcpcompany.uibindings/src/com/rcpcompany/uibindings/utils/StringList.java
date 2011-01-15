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
package com.rcpcompany.uibindings.utils;

import java.util.Arrays;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.EcorePackage;

import com.rcpcompany.uibindings.IObservableListFactory;
import com.rcpcompany.uibindings.IValueBinding;

/**
 * Creates a {@link IObservableList} (element type <code>EString</code>) with the specified strings.
 * <p>
 * To use, specify the wanted strings as ':' separated arguments after the class.
 * <p>
 * <code>StringList:a:b:c</code> results in a list with the elements "a", "b" and "c".
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class StringList implements IObservableListFactory, IExecutableExtension {
	@Override
	public IObservableList createList(IValueBinding binding) {

		return myList;
	}

	private IObservableList myList;

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		if (data instanceof String) {
			final String s = (String) data;

			myList = Observables.staticObservableList(Arrays.asList(s.split(":")), EcorePackage.Literals.ESTRING);
		}

		if (myList == null) {
			myList = Observables.emptyObservableList(EcorePackage.Literals.ESTRING);
		}
	}
}
