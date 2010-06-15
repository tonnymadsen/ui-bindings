package com.rcpcompany.uibindings.decorators;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.list.IObservableList;

import com.rcpcompany.uibindings.IUIBindingDecorator;

/**
 * Simple abstract class used to make simple decorators. To use this class you must implement the
 * followed methods:
 * <ul>
 * <li>{@link #convertModelToUI(Object)} which must convert the specified object from the model
 * representation to the UI representation</li>
 * <li>{@link #convertUIToModel(Object)} which must convert the specified object from the UI
 * representation to the model representation</li>
 * <li>{@link #getValidUIList()} which must return a {@link IObservableList} with all the valid
 * {@code String} values of the UI control</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class SimpleUIBindingDecorator extends BaseUIBindingDecorator implements IUIBindingDecorator {

	@Override
	public final IConverter getModelToUIConverter() {
		return new AbstractModelToUIConverter() {
			@Override
			public Object convert(Object fromObject) {
				/*
				 * The decorator can be disposed already, if this listener is further
				 * "down the listener list"...
				 */
				if (getBinding() == null) return null;
				return convertModelToUI(fromObject);
			}
		};
	}

	@Override
	public final IConverter getUIToModelConverter() {
		return new AbstractUIToModelConverter() {
			@Override
			public Object convert(Object fromObject) {
				return convertUIToModel(fromObject);
			}
		};
	}

	/**
	 * The implementation of the model-to-UI {@link IConverter#convert(Object)}.
	 * 
	 * @param fromObject the value to convert from
	 * @return the result of the convertion
	 */
	protected abstract Object convertModelToUI(Object fromObject);

	/**
	 * The implementation of the UI-to-model {@link IConverter#convert(Object)}.
	 * 
	 * @param fromObject the value to convert from
	 * @return the result of the convertion
	 */
	protected abstract Object convertUIToModel(Object fromObject);
}
