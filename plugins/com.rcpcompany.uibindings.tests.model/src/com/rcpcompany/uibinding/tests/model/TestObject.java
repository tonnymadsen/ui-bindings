/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibinding.tests.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Test Object</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestObject#getNumber <em>Number</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestObject#getD <em>D</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestObject#getF <em>F</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestObject#getDate <em>Date</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestObject#getText <em>Text</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestObject#getParent <em>Parent</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestObject#isB <em>B</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestObject#getAc <em>Ac</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestObject#getUnit <em>Unit</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestObject#getTimeUnit <em>Time Unit</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestObject#getByte <em>Byte</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestObject#getShort <em>Short</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestObject#getLong <em>Long</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestObject#getBigDecimal <em>Big Decimal</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestObject#getBigInteger <em>Big Integer</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestObject()
 * @model
 * @generated
 */
public interface TestObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #isSetNumber()
	 * @see #unsetNumber()
	 * @see #setNumber(int)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestObject_Number()
	 * @model unsettable="true" annotation="http://rcp-company.com/schemas/uibindings foobar='b'"
	 * @generated
	 */
	int getNumber();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestObject#getNumber
	 * <em>Number</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #isSetNumber()
	 * @see #unsetNumber()
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(int value);

	/**
	 * Unsets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestObject#getNumber
	 * <em>Number</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isSetNumber()
	 * @see #getNumber()
	 * @see #setNumber(int)
	 * @generated
	 */
	void unsetNumber();

	/**
	 * Returns whether the value of the '
	 * {@link com.rcpcompany.uibinding.tests.model.TestObject#getNumber <em>Number</em>}' attribute
	 * is set. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return whether the value of the '<em>Number</em>' attribute is set.
	 * @see #unsetNumber()
	 * @see #getNumber()
	 * @see #setNumber(int)
	 * @generated
	 */
	boolean isSetNumber();

	/**
	 * Returns the value of the '<em><b>D</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>D</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>D</em>' attribute.
	 * @see #setD(double)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestObject_D()
	 * @model
	 * @generated
	 */
	double getD();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestObject#getD
	 * <em>D</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>D</em>' attribute.
	 * @see #getD()
	 * @generated
	 */
	void setD(double value);

	/**
	 * Returns the value of the '<em><b>F</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>F</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>F</em>' attribute.
	 * @see #setF(float)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestObject_F()
	 * @model
	 * @generated
	 */
	float getF();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestObject#getF
	 * <em>F</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>F</em>' attribute.
	 * @see #getF()
	 * @generated
	 */
	void setF(float value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestObject_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestObject#getDate
	 * <em>Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

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
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestObject_Text()
	 * @model annotation="http://rcp-company.com/schemas/uibindings foobar='not used: feature text'"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestObject#getText
	 * <em>Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference. It is bidirectional
	 * and its opposite is ' {@link com.rcpcompany.uibinding.tests.model.TestContainer#getChildren
	 * <em>Children</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(TestContainer)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestObject_Parent()
	 * @see com.rcpcompany.uibinding.tests.model.TestContainer#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	TestContainer getParent();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestObject#getParent
	 * <em>Parent</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(TestContainer value);

	/**
	 * Returns the value of the '<em><b>B</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>B</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>B</em>' attribute.
	 * @see #setB(boolean)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestObject_B()
	 * @model
	 * @generated
	 */
	boolean isB();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestObject#isB <em>B</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>B</em>' attribute.
	 * @see #isB()
	 * @generated
	 */
	void setB(boolean value);

	/**
	 * Returns the value of the '<em><b>Ac</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ac</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Ac</em>' attribute.
	 * @see #setAc(AmountAndCurrency)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestObject_Ac()
	 * @model dataType="com.rcpcompany.uibinding.tests.model.AmountAndCurrencyStruct"
	 * @generated
	 */
	AmountAndCurrency getAc();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestObject#getAc
	 * <em>Ac</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Ac</em>' attribute.
	 * @see #getAc()
	 * @generated
	 */
	void setAc(AmountAndCurrency value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute. The literals are from the
	 * enumeration {@link com.rcpcompany.uibinding.tests.model.WeightUnit}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see com.rcpcompany.uibinding.tests.model.WeightUnit
	 * @see #setUnit(WeightUnit)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestObject_Unit()
	 * @model required="true"
	 * @generated
	 */
	WeightUnit getUnit();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestObject#getUnit
	 * <em>Unit</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see com.rcpcompany.uibinding.tests.model.WeightUnit
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(WeightUnit value);

	/**
	 * Returns the value of the '<em><b>Time Unit</b></em>' attribute. The literals are from the
	 * enumeration {@link com.rcpcompany.uibinding.tests.model.TimeUnit}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Unit</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Time Unit</em>' attribute.
	 * @see com.rcpcompany.uibinding.tests.model.TimeUnit
	 * @see #setTimeUnit(TimeUnit)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestObject_TimeUnit()
	 * @model transient="true"
	 * @generated
	 */
	TimeUnit getTimeUnit();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestObject#getTimeUnit
	 * <em>Time Unit</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Time Unit</em>' attribute.
	 * @see com.rcpcompany.uibinding.tests.model.TimeUnit
	 * @see #getTimeUnit()
	 * @generated
	 */
	void setTimeUnit(TimeUnit value);

	/**
	 * Returns the value of the '<em><b>Byte</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Byte</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Byte</em>' attribute.
	 * @see #setByte(byte)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestObject_Byte()
	 * @model
	 * @generated
	 */
	byte getByte();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestObject#getByte
	 * <em>Byte</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Byte</em>' attribute.
	 * @see #getByte()
	 * @generated
	 */
	void setByte(byte value);

	/**
	 * Returns the value of the '<em><b>Short</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Short</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Short</em>' attribute.
	 * @see #setShort(short)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestObject_Short()
	 * @model annotation="http://rcp-company.com/schemas/uibindings foobar='b'"
	 * @generated
	 */
	short getShort();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestObject#getShort
	 * <em>Short</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Short</em>' attribute.
	 * @see #getShort()
	 * @generated
	 */
	void setShort(short value);

	/**
	 * Returns the value of the '<em><b>Long</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Long</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Long</em>' attribute.
	 * @see #setLong(long)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestObject_Long()
	 * @model annotation="http://rcp-company.com/schemas/uibindings foobar='b'"
	 * @generated
	 */
	long getLong();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestObject#getLong
	 * <em>Long</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Long</em>' attribute.
	 * @see #getLong()
	 * @generated
	 */
	void setLong(long value);

	/**
	 * Returns the value of the '<em><b>Big Decimal</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Big Decimal</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Big Decimal</em>' attribute.
	 * @see #setBigDecimal(BigDecimal)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestObject_BigDecimal()
	 * @model
	 * @generated
	 */
	BigDecimal getBigDecimal();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestObject#getBigDecimal
	 * <em>Big Decimal</em>} ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Big Decimal</em>' attribute.
	 * @see #getBigDecimal()
	 * @generated
	 */
	void setBigDecimal(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Big Integer</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Big Integer</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Big Integer</em>' attribute.
	 * @see #setBigInteger(BigInteger)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestObject_BigInteger()
	 * @model
	 * @generated
	 */
	BigInteger getBigInteger();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestObject#getBigInteger
	 * <em>Big Integer</em>} ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Big Integer</em>' attribute.
	 * @see #getBigInteger()
	 * @generated
	 */
	void setBigInteger(BigInteger value);

} // TestObject
