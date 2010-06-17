package org.eclipse.jface.viewers;

/**
 * {@link ViewerCell} with a public constructor.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class MyViewerCell extends ViewerCell {
	/**
	 * Public constant viewer cell.
	 */
	public static final ViewerCell INSTANCE = new MyViewerCell();

	public MyViewerCell() {
		super(null, 0, 0);
	}
}
