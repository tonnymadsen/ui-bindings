package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertNoLog;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IFormChooser;
import com.rcpcompany.uibindings.utils.IFormChooserCreator;

/**
 * Test of {@link IFormChooser}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FormChooserTest {
	private ShopItem myShopItem;
	private IObservableValue myDiscriminant;

	private TestView myView;
	private Composite myBody;
	private Composite myComposite;

	private IBindingContext myContext;
	private IFormChooser myChooser;

	@Before
	public void before() {
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
		bindUI();

		myView.getSite().getPage().activate(myView);
	}

	private void createModel() {
		myShopItem = ShopFactory.eINSTANCE.createShopItem();
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();

		myComposite = new Composite(myBody, SWT.NONE);
		myComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Binds the UI
	 */
	public void bindUI() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());

				myContext.finish();
				yield();

				myDiscriminant = UIBindingsEMFObservables.observeValue(null, myContext.getEditingDomain(), myShopItem,
						ShopPackage.Literals.SHOP_ITEM__INFORMATION);
			}
		});
	}

	protected Text myDisposeText = null;

	/**
	 * Tests that the created forms are properly disposed again
	 */
	@Test
	public void testDisposeItems() {
		myDisposeText = null;
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myChooser = IFormChooser.Factory.create(myContext, myDiscriminant, myComposite);
				myChooser.addFormEClass(ShopPackage.Literals.SHOP_ITEM_DESCRIPTION, new IFormChooserCreator() {
					@Override
					public void createForm(final IBindingContext context, final IObservableValue discriminant,
							Composite parent) {
						myDisposeText = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);

						assertNoLog(new Runnable() {
							@Override
							public void run() {
								context.addBinding().ui(myDisposeText)
										.model(discriminant, ShopPackage.Literals.SHOP_ITEM_DESCRIPTION__DESCRIPTION);
								context.finish();
								yield();
							}
						});
					}
				});
				myChooser.addFormEClass(ShopPackage.Literals.SHOP_ITEM_URL, new IFormChooserCreator() {
					@Override
					public void createForm(IBindingContext context, IObservableValue discriminant, Composite parent) {
						final Label label = new Label(parent, SWT.NONE);
						label.setText("URL");
					}
				});
			}
		});

		final EList<IBinding> bindings = myContext.getBindings();
		final int noBindings = bindings.size();

		assertEquals(null, myDisposeText);
		// The dummy Composite
		assertEquals(1, myComposite.getChildren().length);

		/*
		 * - description
		 */
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myShopItem.setInformation(ShopFactory.eINSTANCE.createShopItemDescription());
				yield();
				assertNotSame(null, myDisposeText);
				assertEquals(1, myComposite.getChildren().length);
				assertEquals(BindingState.OK, myContext.getState());
				assertEquals(noBindings + 1, bindings.size());
			}
		});

		/*
		 * - url
		 */
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myShopItem.setInformation(ShopFactory.eINSTANCE.createShopItemURL());
				yield();
				assertTrue(myDisposeText.isDisposed());
				assertEquals(1, myComposite.getChildren().length);
				assertEquals(noBindings, bindings.size());
			}
		});

		/*
		 * - description
		 */
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myShopItem.setInformation(ShopFactory.eINSTANCE.createShopItemDescription());
				yield();
				assertNotSame(null, myDisposeText);
				assertEquals(1, myComposite.getChildren().length);
				assertEquals(noBindings + 1, bindings.size());
			}
		});

		/*
		 * - null
		 */
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myShopItem.setInformation(null);
				yield();
				assertTrue(myDisposeText.isDisposed());
				assertEquals(1, myComposite.getChildren().length);
				assertEquals(noBindings, bindings.size());
			}
		});

	}

	/**
	 * Tests that the complete chooser is disposed correctly
	 */
	@Test
	public void testDisposeComposite() {
		myDisposeText = null;
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myChooser = IFormChooser.Factory.create(myContext, myDiscriminant, myComposite);
				myChooser.addFormEClass(ShopPackage.Literals.SHOP_ITEM_DESCRIPTION, new IFormChooserCreator() {
					@Override
					public void createForm(final IBindingContext context, final IObservableValue discriminant,
							Composite parent) {
						myDisposeText = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);

						assertNoLog(new Runnable() {
							@Override
							public void run() {
								context.addBinding().ui(myDisposeText)
										.model(discriminant, ShopPackage.Literals.SHOP_ITEM_DESCRIPTION__DESCRIPTION);
								context.finish();
								yield();
							}
						});
					}
				});
			}
		});

		final EList<IBinding> bindings = myContext.getBindings();
		final int noBindings = bindings.size();

		assertEquals(null, myDisposeText);

		/*
		 * - description
		 */
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myShopItem.setInformation(ShopFactory.eINSTANCE.createShopItemDescription());
				yield();
				assertNotSame(null, myDisposeText);
				assertEquals(1, myComposite.getChildren().length);
				assertEquals(noBindings + 1, bindings.size());
			}
		});

		/*
		 * Disposed
		 */
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myComposite.dispose();
				yield();
				assertTrue(myDisposeText.isDisposed());
				assertEquals(noBindings, bindings.size());
			}
		});

	}

	/**
	 * Tests that the addForm...(..) methods properly updates the current child
	 */
	@Test
	public void testAddUpdates() {
		myDisposeText = null;
		myShopItem.setInformation(ShopFactory.eINSTANCE.createShopItemDescription());

		yield();
		final EList<IBinding> bindings = myContext.getBindings();
		final int noBindings = bindings.size();

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myChooser = IFormChooser.Factory.create(myContext, myDiscriminant, myComposite);
				myChooser.addFormEClass(ShopPackage.Literals.SHOP_ITEM_DESCRIPTION, new IFormChooserCreator() {
					@Override
					public void createForm(final IBindingContext context, final IObservableValue discriminant,
							Composite parent) {
						myDisposeText = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);

						assertNoLog(new Runnable() {
							@Override
							public void run() {
								context.addBinding().ui(myDisposeText)
										.model(discriminant, ShopPackage.Literals.SHOP_ITEM_DESCRIPTION__DESCRIPTION);
								context.finish();
								yield();
							}
						});
					}
				});
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				yield();
				assertNotSame(null, myDisposeText);
				assertEquals(1, myComposite.getChildren().length);
				assertEquals(noBindings + 1, bindings.size());
			}
		});
	}

	protected boolean chooserRun = false;

	/**
	 * Tests that the addFormExactEClass(..) is handled correctly
	 */
	@Test
	public void testExactEClass() {
		chooserRun = false;
		myShopItem.setInformation(null);

		yield();

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myChooser = IFormChooser.Factory.create(myContext, myDiscriminant, myComposite);
				myChooser.addFormExactEClass(ShopPackage.Literals.SHOP_ITEM_DESCRIPTION, new IFormChooserCreator() {
					@Override
					public void createForm(final IBindingContext context, final IObservableValue discriminant,
							Composite parent) {
						chooserRun = true;
					}
				});
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myShopItem.setInformation(ShopFactory.eINSTANCE.createShopItemInformation());
				yield();
				assertEquals(false, chooserRun);
			}
		});
	}
}
