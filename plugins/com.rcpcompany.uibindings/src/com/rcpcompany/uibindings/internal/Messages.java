package com.rcpcompany.uibindings.internal;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.rcpcompany.uibindings.internal.Messages"; //$NON-NLS-1$

	private Messages() {
	}

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	public static String ColumnBindingImpl_RowNo_ColumnHeader;
	public static String ColumnBindingImpl_TreeItem_ColumnHeader;
	/*
	 * xxxMessageDecoratorContextAdapter
	 */
	public static String MessageDecoratorContextAdapter_sMessageSummary;
	public static String MessageDecoratorContextAdapter_sWarningSummary;
	public static String MessageDecoratorContextAdapter_sErrorSummary;
	public static String MessageDecoratorContextAdapter_pMessageSummary;
	public static String MessageDecoratorContextAdapter_pWarningSummary;
	public static String MessageDecoratorContextAdapter_pErrorSummary;
	public static String ValueBindingImpl_NullString;
	public static String ValueBindingMessageImageDecorator_ContentAssistAvailanble;
	public static String ValueBindingMessageImageDecorator_ValueRequired;
}
