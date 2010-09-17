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
package com.rcpcompany.uibindings.grid;

import org.eclipse.core.databinding.observable.list.IObservableList;

/**
 * Simple implementation of {@link IGridModel} that will cover 99% of all needs.
 * <p>
 * Sub classes must implement the abstract {@link IGridModel#getCell(Object, Object)}. The typical
 * implementation is:
 * 
 * <pre>
 * protected class Model extends SimpleGridModel {
 * 	public Model(Shop shop) {
 * 		super(UIBindingsEMFObservables.observeList(shop, ShopPackage.Literals.SHOP__ORDERS), UIBindingsEMFObservables
 * 				.observeList(shop, ShopPackage.Literals.SHOP__SHOP_ITEMS));
 * 	}
 * 
 * 	&#064;Override
 * 	public IGridCell getCell(Object columnID, Object rowID) {
 * 		return new Cell(columnID, rowID);
 * 	}
 * }
 * </pre>
 * 
 * @see AbstractGridCell
 * @author Tonny Madsen, The RCP Company
 */
public abstract class SimpleGridModel implements IGridModel {
	private final IObservableList myColumns;
	private final IObservableList myRows;

	/**
	 * Constructs and returns a new simple model.
	 * 
	 * @param columns the columns in the grid
	 * @param rows the rows in the grid
	 */
	public SimpleGridModel(IObservableList columns, IObservableList rows) {
		myColumns = columns;
		myRows = rows;
	}

	@Override
	public IObservableList getColumnIDs() {
		return myColumns;
	}

	@Override
	public IObservableList getRowIDs() {
		return myRows;
	}

	@Override
	public void dispose() {
	}
}
