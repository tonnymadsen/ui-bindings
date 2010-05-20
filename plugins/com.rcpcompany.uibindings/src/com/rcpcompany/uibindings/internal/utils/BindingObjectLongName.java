package com.rcpcompany.uibindings.internal.utils;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.uiAttributes.VirtualUIAttribute;
import com.rcpcompany.uibindings.utils.IBindingObjectLongName;

/**
 * Implementation of {@link IBindingObjectLongName}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingObjectLongName implements IBindingObjectLongName {
	private final EObject myObj;
	private IBindingContext myContext;
	private VirtualUIAttribute myAttribute;

	/**
	 * Constructs and returns a new name object for the specified object and binding type
	 * 
	 * @param obj the object
	 * @param type the binding type - defaults to {@link Constants#TYPE_LONG_NAME}
	 */
	public BindingObjectLongName(EObject obj, String type) {
		myObj = obj;
		if (myObj != null) {
			if (type == null) {
				type = Constants.TYPE_LONG_NAME;
			}

			myContext = IBindingContext.Factory.createContext();

			myAttribute = new VirtualUIAttribute(String.class);
			final WritableValue value = new WritableValue(myObj, myObj.eClass());
			myContext.addBinding().model(value).ui(myAttribute).type(type);

			myContext.finish();
		}
	}

	@Override
	public String getName() {
		if (myContext == null) {
			return "<null>";
		}
		return (String) myAttribute.getCurrentValue().getValue();
	}

	@Override
	public void dispose() {
		if (myContext != null) {
			myContext.dispose();
			myContext = null;
		}
	}
}
