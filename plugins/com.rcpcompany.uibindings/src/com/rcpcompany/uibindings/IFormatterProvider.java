package com.rcpcompany.uibindings;

import java.util.Formatter;

/**
 * This interface is used to provide number formattimg in a plugable manner that allows a user to
 * replace or extend the implementation.
 * <p>
 * All implementations must return a Java {@link Formatter} compatible implementation for all
 * formats supported by this - e.g. <code>%g</code> - but is free to supåport any other format as
 * well.
 * <p>
 * Formatter providers are stored {@link IManager#getFormatterProvider()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IFormatterProvider {
	/**
	 * Constructs and returns a new formatter with the specified destination.
	 * 
	 * @param dest the destination
	 * @param format the format specification
	 * @return the created formatter
	 */
	IFormatter getFormatter(Appendable dest, String format);
}
