package com.rcpcompany.uibindings.observables;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.WritableValue;

/**
 * Implementation of {@link WritableValue} that implements {@link IDisposePendingObservable}.
 * 
 * @since 1.0
 */
public class DisposePendingWritableValue extends WritableValue implements IDisposePendingObservable {

	/**
	 * Constructs a new instance with the default realm.
	 * 
	 * @param initialValue can be <code>null</code>
	 * @param valueType can be <code>null</code>
	 */
	public DisposePendingWritableValue(Object initialValue, Object valueType) {
		this(Realm.getDefault(), initialValue, valueType);
	}

	/**
	 * Constructs a new instance with the provided <code>realm</code>, a <code>null</code> value
	 * type, and a <code>null</code> initial value.
	 * 
	 * @param realm
	 */
	public DisposePendingWritableValue(Realm realm) {
		this(realm, null, null);
	}

	/**
	 * Constructs a new instance.
	 * 
	 * @param realm
	 * @param initialValue can be <code>null</code>
	 * @param valueType can be <code>null</code>
	 */
	public DisposePendingWritableValue(Realm realm, Object initialValue, Object valueType) {
		super(realm, initialValue, valueType);
	}

	/**
	 * @param elementType can be <code>null</code>
	 * @return new instance with the default realm and a value of <code>null</code>
	 */
	public static DisposePendingWritableValue withValueType(Object elementType) {
		return new DisposePendingWritableValue(Realm.getDefault(), null, elementType);
	}

	@Override
	public void fireDisposePending() {
		checkRealm();
		fireEvent(new DisposePendingEvent(this));
	}

	@Override
	public void addDisposePendingListener(IDisposePendingListener listener) {
		addListener(DisposePendingEvent.TYPE, listener);
	}

	@Override
	public void removeDisposePendingListener(IDisposePendingListener listener) {
		removeListener(DisposePendingEvent.TYPE, listener);
	}
}
