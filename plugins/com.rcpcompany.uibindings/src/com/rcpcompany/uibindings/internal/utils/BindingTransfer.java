package com.rcpcompany.uibindings.internal.utils;

import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;

/**
 * This {@link Transfer} is used to copy/paste and drag'n'drop of binding objects.
 * <p>
 * Really a copy of {@link org.eclipse.emf.edit.ui.dnd.LocalTransfer} because we don't want to have
 * this dependency.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingTransfer extends ByteArrayTransfer {
	/**
	 * This is the register transfer type name.
	 */
	protected static final String TYPE_NAME = "binding-transfer-format";

	/**
	 * This is the ID that is registered to the name.
	 */
	protected static final int TYPE_ID = registerType(TYPE_NAME);

	/**
	 * This is initialized and returned by {@link #getInstance}.
	 */
	private static BindingTransfer instance;

	/**
	 * This returns the one instance of this transfer agent.
	 * 
	 * @return the transfer object
	 */
	public static BindingTransfer getInstance() {
		if (instance == null) {
			instance = new BindingTransfer();
		}

		return instance;
	}

	/**
	 * This records the time at which the transfer data was recorded.
	 */
	protected long startTime;

	/**
	 * This records the data being transferred.
	 */
	protected Object object;

	/**
	 * This creates an instance; typically you get one from {@link #getInstance}.
	 */
	protected BindingTransfer() {
		super();
	}

	/**
	 * This returns the transfer IDs that this agent supports.
	 */
	@Override
	protected int[] getTypeIds() {
		return new int[] { TYPE_ID };
	}

	/**
	 * This returns the transfer names that this agent supports.
	 */
	@Override
	public String[] getTypeNames() {
		return new String[] { TYPE_NAME };
	}

	/**
	 * This records the object and current time and encodes only the current time into the transfer
	 * data.
	 */
	@Override
	public void javaToNative(Object object, TransferData transferData) {
		startTime = System.currentTimeMillis();
		this.object = object;
		if (transferData != null) {
			super.javaToNative(String.valueOf(startTime).getBytes(), transferData);
		}
	}

	/**
	 * This decodes the time of the transfer and returns the recorded the object if the recorded
	 * time and the decoded time match.
	 */
	@Override
	public Object nativeToJava(TransferData transferData) {
		final byte[] bytes = (byte[]) super.nativeToJava(transferData);
		if (bytes == null) return null;

		try {
			final long startTime = Long.valueOf(new String(bytes)).longValue();
			return this.startTime == startTime ? object : null;
		} catch (final NumberFormatException exception) {
			return null;
		}
	}
}
