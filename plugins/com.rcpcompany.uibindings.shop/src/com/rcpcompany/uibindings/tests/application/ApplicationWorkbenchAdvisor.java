package com.rcpcompany.uibindings.tests.application;

import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.rcpcompany.uibindings.moao.util.MOAOMessageValidatorAdapter;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.utils.IGlobalNavigationManager;
import com.rcpcompany.uibindings.validators.ConstraintValidatorAdapter;
import com.rcpcompany.uibindings.validators.EValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * The workbench advisor.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "com.rcpcompany.uibindings.example.application.perspectives.Shop";

	@Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}

	@Override
	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}

	@Override
	public void preStartup() {
		super.preStartup();

		getWorkbenchConfigurer().setSaveAndRestore(true);
	}

	@Override
	public void postStartup() {
		super.postStartup();

		final IValidatorAdapterManager vam = IValidatorAdapterManager.Factory.getManager();
		final Shop theShop = ShopFactory.eINSTANCE.getShop();
		vam.addRoot(theShop, new EValidatorAdapter());
		vam.addRoot(theShop, new ConstraintValidatorAdapter());
		vam.addRoot(theShop, new MOAOMessageValidatorAdapter());

		IGlobalNavigationManager.Factory.installMouseHandling();
	}
}
