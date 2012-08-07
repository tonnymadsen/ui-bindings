package com.rcpcompany.uibindings.internal.propertyTesters;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.ui.services.IEvaluationService;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Simple {@link PropertyTester} that can test for the value of a specific preference.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class PreferenceStorePropertyTester extends PropertyTester {
	// TODO calculate
	public static String PROPERTY_NAME = Constants.PREFIX + "preference";

	/**
	 * The preference stores that are current surveyed.
	 */
	private final Map<String, IPreferenceStore> myPreferenceStores = new HashMap<String, IPreferenceStore>();

	IPropertyChangeListener myChangeListener = new IPropertyChangeListener() {
		private IEvaluationService evalService = null;

		@Override
		public void propertyChange(PropertyChangeEvent event) {
			if (evalService == null) {
				evalService = (IEvaluationService) PlatformUI.getWorkbench().getService(IEvaluationService.class);
				if (evalService == null) {
					LogUtils.error(PreferenceStorePropertyTester.this, "Cannot request the IEvaluationService.");
				}
			}
			if (evalService != null) {
				if (Activator.getDefault().TRACE_PROPERTY_TESTERS) {
					LogUtils.debug(this, "Request re-eval: " + PROPERTY_NAME);
				}
				evalService.requestEvaluation(PROPERTY_NAME);
			}
		}
	};

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (Activator.getDefault().TRACE_PROPERTY_TESTERS) {
			LogUtils.debug(this, Constants.PREFIX + property + "(" + receiver + ")");
		}
		if (!property.equals("preference")) return false;
		if (args.length != 2) {
			LogUtils.error(this, "Expected two arguments");
			return false;
		}
		final String pluginID = "" + args[0];
		final String preferenceName = "" + args[1];
		if (expectedValue == null) {
			expectedValue = "true";
		}

		IPreferenceStore ps = myPreferenceStores.get(pluginID);
		if (ps == null) {
			ps = new ScopedPreferenceStore(new InstanceScope(), pluginID);
			myPreferenceStores.put(pluginID, ps);
			ps.addPropertyChangeListener(myChangeListener);
		}

		final String value = ps.getString(preferenceName);

		return UIBindingsUtils.equals(value, "" + expectedValue);
	}
}
