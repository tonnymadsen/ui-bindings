package com.rcpcompany.test.utils.ui;

import java.util.Map;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.ui.ISourceProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.ISourceProviderService;

import com.rcpcompany.utils.logging.LogUtils;

/**
 * Various test methods for the extension registry.
 * <p>
 * Provides a number of convenience methods...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ExtensionUITestUtils {
	/**
	 * 
	 * @param sourceName
	 */
	public static void dumpBindingSourceState(String sourceName) {
		final ISourceProviderService sourceProviders = (ISourceProviderService) PlatformUI
				.getWorkbench().getService(ISourceProviderService.class);
		final ISourceProvider provider = sourceProviders
				.getSourceProvider(sourceName);
		@SuppressWarnings("unchecked")
		final Map<String, Object> currentState = provider.getCurrentState();

		final StringBuilder sb = new StringBuilder("Binding sources state:");
		for (final Map.Entry<String, Object> i : currentState.entrySet()) {
			final String s = i.getKey();
			sb.append("\n  ").append(s).append("='");
			final Object v = i.getValue();
			if (v == null) {
				sb.append("<null>");
			} else if (v == IEvaluationContext.UNDEFINED_VARIABLE) {
				sb.append("<undef>");
			} else {
				sb.append(v.toString());
			}
			sb.append("'");
		}
		LogUtils.debug(provider, sb.toString());
	}
}
