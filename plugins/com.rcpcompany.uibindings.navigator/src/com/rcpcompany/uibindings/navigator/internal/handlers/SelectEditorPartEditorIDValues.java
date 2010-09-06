package com.rcpcompany.uibindings.navigator.internal.handlers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.IParameterValues;

import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.internal.NavigatorConstants;

/**
 * Returns the possible values for {@link NavigatorConstants#EDITOR_ID_PARAMETER}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SelectEditorPartEditorIDValues implements IParameterValues {

	@Override
	public Map getParameterValues() {
		final INavigatorManager manager = INavigatorManager.Factory.getManager();
		final Map<String, String> map = new HashMap<String, String>();
		for (final IEditorPartDescriptor desc : manager.getDescriptors()) {
			map.put(desc.getName(), desc.getId());
		}
		return map;
	}

}
