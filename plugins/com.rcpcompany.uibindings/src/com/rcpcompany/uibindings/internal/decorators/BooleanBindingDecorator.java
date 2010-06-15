package com.rcpcompany.uibindings.internal.decorators;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;

import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.decorators.SimpleUIBindingDecorator;

/**
 * Decorator for boolean values.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BooleanBindingDecorator extends SimpleUIBindingDecorator implements IUIBindingDecorator {
	/**
	 * The mapping of model values to UI values.
	 */
	static final protected Map<Boolean, String> theModelToUIMap = new HashMap<Boolean, String>();
	/**
	 * The mapping of UI values to model values.
	 */
	static final protected Map<String, Boolean> theUIToModelMap = new HashMap<String, Boolean>();
	static final protected IObservableList theValidUIList;

	static {
		theModelToUIMap.put(Boolean.TRUE, "true");
		theUIToModelMap.put("true", Boolean.TRUE);
		theUIToModelMap.put("1", Boolean.TRUE);
		theUIToModelMap.put("+", Boolean.TRUE);
		theUIToModelMap.put("yes", Boolean.TRUE);

		theModelToUIMap.put(Boolean.FALSE, "false");
		theUIToModelMap.put("false", Boolean.FALSE);
		theUIToModelMap.put("0", Boolean.FALSE);
		theUIToModelMap.put("-", Boolean.FALSE);
		theUIToModelMap.put("no", Boolean.FALSE);

		// Otherwise use a list with the currently defined target to model key - properly sorted
		final List<String> bl = new ArrayList<String>();
		bl.addAll(theUIToModelMap.keySet());
		Collections.sort(bl);

		theValidUIList = Observables.staticObservableList(bl, String.class);
	}

	@Override
	public IObservableList getValidUIList() {
		return theValidUIList;
	}

	@Override
	protected Object convertModelToUI(Object fromObject) {
		return theModelToUIMap.get(fromObject);
	}

	@Override
	protected Object convertUIToModel(Object fromObject) {
		if (!theUIToModelMap.containsKey(fromObject))
			throw new IllegalArgumentException(MessageFormat.format("Illegal value ''{0}''", fromObject));
		return theUIToModelMap.get(fromObject);
	}

}
