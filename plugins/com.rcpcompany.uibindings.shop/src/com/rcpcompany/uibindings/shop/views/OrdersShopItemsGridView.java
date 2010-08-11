package com.rcpcompany.uibindings.shop.views;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.grid.AbstractGridCell;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.IGridCell;
import com.rcpcompany.uibindings.grid.IGridModel;
import com.rcpcompany.uibindings.grid.SimpleGridModel;
import com.rcpcompany.uibindings.tests.shop.Order;
import com.rcpcompany.uibindings.tests.shop.OrderItem;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * The "Orders versus Shop Items" view.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class OrdersShopItemsGridView extends ViewPart {

	private IFormCreator myForm;

	@Override
	public void createPartControl(Composite parent) {
		final Shop shop = ShopFactory.eINSTANCE.getShop();
		myForm = IFormCreator.Factory.createScrolledForm(shop, parent, "Orders versus Shop Items");

		final Grid g = new Grid(myForm.addComposite(true, true), SWT.NONE);

		final IGridModel model = new SimpleGridModel(UIBindingsEMFObservables.observeList(myForm.getContext()
				.getEditingDomain(), shop, ShopPackage.Literals.SHOP__SHOP_ITEMS),
				UIBindingsEMFObservables.observeList(myForm.getContext().getEditingDomain(), shop,
						ShopPackage.Literals.SHOP__ORDERS)) {
			@Override
			public IGridCell getCell(Object columnID, Object rowID) {
				return new Cell(columnID, rowID);
			}
		};

		IGridBinding.Factory.createGrid(myForm.getContext(), g, model);

		myForm.finish();
		IBindingContextSelectionProvider.Factory.adapt(myForm.getContext(), getSite());
	}

	@Override
	public void setFocus() {
		myForm.setFocus();
	}

	/**
	 * Cell implementation for the grid model.
	 */
	protected class Cell extends AbstractGridCell<ShopItem, Order> {
		public Cell(Object columnID, Object rowID) {
			super(columnID, rowID);
		}

		@Override
		public Map<String, Object> getArguments() {
			switch (getCellType()) {
			case COLUMN_HEADER:
				return null;
			case ROW_HEADER:
				final Map<String, Object> map = new HashMap<String, Object>();
				map.put(Constants.ARG_FEATURE_NAME, ShopPackage.Literals.ORDER__NO.getName());
				return map;
			case DATA:
				final Map<String, Object> dataMap = new HashMap<String, Object>();
				// dataMap.put(Constants.ARG_READONLY, true);
				return dataMap;
			default:
				break;
			}
			return null;
		}

		@Override
		public IObservableValue getValue() {
			switch (getCellType()) {
			case COLUMN_HEADER:
				return Observables.constantObservableValue(getColumnItem(), getColumnItem().eClass());
			case ROW_HEADER:
				return Observables.constantObservableValue(getRowItem(), getRowItem().eClass());
			case DATA:
				// Both myItem and myCustomer non-null!!!
				for (final OrderItem oi : getRowItem().getItems()) {
					if (oi.getItem() == getColumnItem())
						return UIBindingsEMFObservables.observeValue(null, myForm.getContext().getEditingDomain(), oi,
								ShopPackage.Literals.ORDER_ITEM__COUNT);
				}
				return Observables.constantObservableValue(SWTObservables.getRealm(Display.getCurrent()), null,
						String.class);
			default:
				break;
			}
			return null;
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}
	}
}
