package com.rcpcompany.uibindings;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Widget;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Column Adapter</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IColumnAdapter#getWidget <em>Widget</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnAdapter#getText <em>Text</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnAdapter#getAlignment <em>Alignment</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnAdapter#getImage <em>Image</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnAdapter#isMoveable <em>Moveable</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnAdapter#isResizable <em>Resizable</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnAdapter#getWidth <em>Width</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IColumnAdapter#getToolTipText <em>Tool Tip Text</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnAdapter()
 * @generated
 */
public interface IColumnAdapter extends EObject {
	/**
	 * Returns the value of the '<em><b>Widget</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Widget</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnAdapter_Widget()
	 * @generated
	 */
	Widget getWidget();

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnAdapter_Text()
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IColumnAdapter#getText <em>Text</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Alignment</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alignment</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Alignment</em>' attribute.
	 * @see #setAlignment(int)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnAdapter_Alignment()
	 * @generated
	 */
	int getAlignment();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IColumnAdapter#getAlignment
	 * <em>Alignment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Alignment</em>' attribute.
	 * @see #getAlignment()
	 * @generated
	 */
	void setAlignment(int value);

	/**
	 * Returns the value of the '<em><b>Image</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Image</em>' attribute.
	 * @see #setImage(Image)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnAdapter_Image()
	 * @generated
	 */
	Image getImage();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IColumnAdapter#getImage
	 * <em>Image</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Image</em>' attribute.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(Image value);

	/**
	 * Returns the value of the '<em><b>Moveable</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moveable</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Moveable</em>' attribute.
	 * @see #setMoveable(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnAdapter_Moveable()
	 * @generated
	 */
	boolean isMoveable();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IColumnAdapter#isMoveable
	 * <em>Moveable</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Moveable</em>' attribute.
	 * @see #isMoveable()
	 * @generated
	 */
	void setMoveable(boolean value);

	/**
	 * Returns the value of the '<em><b>Resizable</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resizable</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Resizable</em>' attribute.
	 * @see #setResizable(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnAdapter_Resizable()
	 * @generated
	 */
	boolean isResizable();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IColumnAdapter#isResizable
	 * <em>Resizable</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Resizable</em>' attribute.
	 * @see #isResizable()
	 * @generated
	 */
	void setResizable(boolean value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnAdapter_Width()
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IColumnAdapter#getWidth
	 * <em>Width</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Returns the value of the '<em><b>Tool Tip Text</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tool Tip Text</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Tool Tip Text</em>' attribute.
	 * @see #setToolTipText(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getColumnAdapter_ToolTipText()
	 * @generated
	 */
	String getToolTipText();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IColumnAdapter#getToolTipText
	 * <em>Tool Tip Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Tool Tip Text</em>' attribute.
	 * @see #getToolTipText()
	 * @generated
	 */
	void setToolTipText(String value);

	/**
	 * Adds a selection listener for this column
	 * 
	 * @param listener the listener to add
	 */
	public void addSelectionListener(SelectionListener listener);

	/**
	 * Removes a selection listener from this column
	 * 
	 * @param listener the listener to remove
	 */
	public void removeSelectionListener(SelectionListener listener);
} // IColumnAdapter
