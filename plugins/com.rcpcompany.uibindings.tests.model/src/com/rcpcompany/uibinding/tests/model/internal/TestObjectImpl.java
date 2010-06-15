/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibinding.tests.model.internal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.rcpcompany.uibinding.tests.model.AmountAndCurrency;
import com.rcpcompany.uibinding.tests.model.TestContainer;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibinding.tests.model.TimeUnit;
import com.rcpcompany.uibinding.tests.model.WeightUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Test Object</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl#getNumber <em>Number
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl#getD <em>D</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl#getF <em>F</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl#getDate <em>Date</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl#getText <em>Text</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl#getParent <em>Parent
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl#isB <em>B</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl#getAc <em>Ac</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl#getUnit <em>Unit</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl#getTimeUnit <em>Time Unit
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl#getByte <em>Byte</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl#getShort <em>Short</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl#getLong <em>Long</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl#getBigDecimal <em>Big
 * Decimal</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestObjectImpl#getBigInteger <em>Big
 * Integer</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TestObjectImpl extends EObjectImpl implements TestObject {
	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected int number = NUMBER_EDEFAULT;

	/**
	 * This is true if the Number attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean numberESet;

	/**
	 * The default value of the '{@link #getD() <em>D</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getD()
	 * @generated
	 * @ordered
	 */
	protected static final double D_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getD() <em>D</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getD()
	 * @generated
	 * @ordered
	 */
	protected double d = D_EDEFAULT;

	/**
	 * The default value of the '{@link #getF() <em>F</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getF()
	 * @generated
	 * @ordered
	 */
	protected static final float F_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getF() <em>F</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getF()
	 * @generated
	 * @ordered
	 */
	protected float f = F_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #isB() <em>B</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isB()
	 * @generated
	 * @ordered
	 */
	protected static final boolean B_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isB() <em>B</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isB()
	 * @generated
	 * @ordered
	 */
	protected boolean b = B_EDEFAULT;

	/**
	 * The default value of the '{@link #getAc() <em>Ac</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAc()
	 * @generated
	 * @ordered
	 */
	protected static final AmountAndCurrency AC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAc() <em>Ac</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAc()
	 * @generated
	 * @ordered
	 */
	protected AmountAndCurrency ac = AC_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnit() <em>Unit</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected static final WeightUnit UNIT_EDEFAULT = WeightUnit.G;

	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected WeightUnit unit = UNIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeUnit() <em>Time Unit</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTimeUnit()
	 * @generated
	 * @ordered
	 */
	protected static final TimeUnit TIME_UNIT_EDEFAULT = TimeUnit.SEC;

	/**
	 * The cached value of the '{@link #getTimeUnit() <em>Time Unit</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTimeUnit()
	 * @generated
	 * @ordered
	 */
	protected TimeUnit timeUnit = TIME_UNIT_EDEFAULT;

	/**
	 * The default value of the '{@link #isByte() <em>Byte</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isByte()
	 * @generated
	 * @ordered
	 */
	protected static final byte BYTE_EDEFAULT = 0x00;

	/**
	 * The cached value of the '{@link #isByte() <em>Byte</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isByte()
	 * @generated
	 * @ordered
	 */
	protected byte byte_ = BYTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getShort() <em>Short</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getShort()
	 * @generated
	 * @ordered
	 */
	protected static final short SHORT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getShort() <em>Short</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getShort()
	 * @generated
	 * @ordered
	 */
	protected short short_ = SHORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getLong() <em>Long</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getLong()
	 * @generated
	 * @ordered
	 */
	protected static final long LONG_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getLong() <em>Long</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLong()
	 * @generated
	 * @ordered
	 */
	protected long long_ = LONG_EDEFAULT;

	/**
	 * The default value of the '{@link #getBigDecimal() <em>Big Decimal</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBigDecimal()
	 * @generated
	 * @ordered
	 */
	protected static final BigDecimal BIG_DECIMAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBigDecimal() <em>Big Decimal</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBigDecimal()
	 * @generated
	 * @ordered
	 */
	protected BigDecimal bigDecimal = BIG_DECIMAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getBigInteger() <em>Big Integer</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBigInteger()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger BIG_INTEGER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBigInteger() <em>Big Integer</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBigInteger()
	 * @generated
	 * @ordered
	 */
	protected BigInteger bigInteger = BIG_INTEGER_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TestObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestModelPackage.Literals.TEST_OBJECT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setNumber(int newNumber) {
		final int oldNumber = number;
		number = newNumber;
		final boolean oldNumberESet = numberESet;
		numberESet = true;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_OBJECT__NUMBER, oldNumber,
					number, !oldNumberESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void unsetNumber() {
		final int oldNumber = number;
		final boolean oldNumberESet = numberESet;
		number = NUMBER_EDEFAULT;
		numberESet = false;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.UNSET, TestModelPackage.TEST_OBJECT__NUMBER, oldNumber,
					NUMBER_EDEFAULT, oldNumberESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isSetNumber() {
		return numberESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public double getD() {
		return d;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setD(double newD) {
		final double oldD = d;
		d = newD;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_OBJECT__D, oldD, d));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public float getF() {
		return f;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setF(float newF) {
		final float oldF = f;
		f = newF;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_OBJECT__F, oldF, f));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setDate(Date newDate) {
		final Date oldDate = date;
		date = newDate;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_OBJECT__DATE, oldDate, date));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setText(String newText) {
		final String oldText = text;
		text = newText;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_OBJECT__TEXT, oldText, text));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public TestContainer getParent() {
		if (eContainerFeatureID() != TestModelPackage.TEST_OBJECT__PARENT) return null;
		return (TestContainer) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParent(TestContainer newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParent, TestModelPackage.TEST_OBJECT__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setParent(TestContainer newParent) {
		if (newParent != eInternalContainer()
				|| (eContainerFeatureID() != TestModelPackage.TEST_OBJECT__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newParent != null) {
				msgs = ((InternalEObject) newParent).eInverseAdd(this, TestModelPackage.TEST_CONTAINER__CHILDREN,
						TestContainer.class, msgs);
			}
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_OBJECT__PARENT, newParent,
					newParent));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isB() {
		return b;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setB(boolean newB) {
		final boolean oldB = b;
		b = newB;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_OBJECT__B, oldB, b));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public AmountAndCurrency getAc() {
		return ac;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setAc(AmountAndCurrency newAc) {
		final AmountAndCurrency oldAc = ac;
		ac = newAc;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_OBJECT__AC, oldAc, ac));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public WeightUnit getUnit() {
		return unit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setUnit(WeightUnit newUnit) {
		final WeightUnit oldUnit = unit;
		unit = newUnit == null ? UNIT_EDEFAULT : newUnit;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_OBJECT__UNIT, oldUnit, unit));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public TimeUnit getTimeUnit() {
		return timeUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setTimeUnit(TimeUnit newTimeUnit) {
		final TimeUnit oldTimeUnit = timeUnit;
		timeUnit = newTimeUnit == null ? TIME_UNIT_EDEFAULT : newTimeUnit;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_OBJECT__TIME_UNIT, oldTimeUnit,
					timeUnit));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public byte getByte() {
		return byte_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setByte(byte newByte) {
		final byte oldByte = byte_;
		byte_ = newByte;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_OBJECT__BYTE, oldByte, byte_));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public short getShort() {
		return short_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setShort(short newShort) {
		final short oldShort = short_;
		short_ = newShort;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_OBJECT__SHORT, oldShort, short_));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public long getLong() {
		return long_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setLong(long newLong) {
		final long oldLong = long_;
		long_ = newLong;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_OBJECT__LONG, oldLong, long_));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setBigDecimal(BigDecimal newBigDecimal) {
		final BigDecimal oldBigDecimal = bigDecimal;
		bigDecimal = newBigDecimal;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_OBJECT__BIG_DECIMAL,
					oldBigDecimal, bigDecimal));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public BigInteger getBigInteger() {
		return bigInteger;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setBigInteger(BigInteger newBigInteger) {
		final BigInteger oldBigInteger = bigInteger;
		bigInteger = newBigInteger;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_OBJECT__BIG_INTEGER,
					oldBigInteger, bigInteger));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TestModelPackage.TEST_OBJECT__PARENT:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetParent((TestContainer) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TestModelPackage.TEST_OBJECT__PARENT:
			return basicSetParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case TestModelPackage.TEST_OBJECT__PARENT:
			return eInternalContainer().eInverseRemove(this, TestModelPackage.TEST_CONTAINER__CHILDREN,
					TestContainer.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case TestModelPackage.TEST_OBJECT__NUMBER:
			return getNumber();
		case TestModelPackage.TEST_OBJECT__D:
			return getD();
		case TestModelPackage.TEST_OBJECT__F:
			return getF();
		case TestModelPackage.TEST_OBJECT__DATE:
			return getDate();
		case TestModelPackage.TEST_OBJECT__TEXT:
			return getText();
		case TestModelPackage.TEST_OBJECT__PARENT:
			return getParent();
		case TestModelPackage.TEST_OBJECT__B:
			return isB();
		case TestModelPackage.TEST_OBJECT__AC:
			return getAc();
		case TestModelPackage.TEST_OBJECT__UNIT:
			return getUnit();
		case TestModelPackage.TEST_OBJECT__TIME_UNIT:
			return getTimeUnit();
		case TestModelPackage.TEST_OBJECT__BYTE:
			return getByte();
		case TestModelPackage.TEST_OBJECT__SHORT:
			return getShort();
		case TestModelPackage.TEST_OBJECT__LONG:
			return getLong();
		case TestModelPackage.TEST_OBJECT__BIG_DECIMAL:
			return getBigDecimal();
		case TestModelPackage.TEST_OBJECT__BIG_INTEGER:
			return getBigInteger();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case TestModelPackage.TEST_OBJECT__NUMBER:
			setNumber((Integer) newValue);
			return;
		case TestModelPackage.TEST_OBJECT__D:
			setD((Double) newValue);
			return;
		case TestModelPackage.TEST_OBJECT__F:
			setF((Float) newValue);
			return;
		case TestModelPackage.TEST_OBJECT__DATE:
			setDate((Date) newValue);
			return;
		case TestModelPackage.TEST_OBJECT__TEXT:
			setText((String) newValue);
			return;
		case TestModelPackage.TEST_OBJECT__PARENT:
			setParent((TestContainer) newValue);
			return;
		case TestModelPackage.TEST_OBJECT__B:
			setB((Boolean) newValue);
			return;
		case TestModelPackage.TEST_OBJECT__AC:
			setAc((AmountAndCurrency) newValue);
			return;
		case TestModelPackage.TEST_OBJECT__UNIT:
			setUnit((WeightUnit) newValue);
			return;
		case TestModelPackage.TEST_OBJECT__TIME_UNIT:
			setTimeUnit((TimeUnit) newValue);
			return;
		case TestModelPackage.TEST_OBJECT__BYTE:
			setByte((Byte) newValue);
			return;
		case TestModelPackage.TEST_OBJECT__SHORT:
			setShort((Short) newValue);
			return;
		case TestModelPackage.TEST_OBJECT__LONG:
			setLong((Long) newValue);
			return;
		case TestModelPackage.TEST_OBJECT__BIG_DECIMAL:
			setBigDecimal((BigDecimal) newValue);
			return;
		case TestModelPackage.TEST_OBJECT__BIG_INTEGER:
			setBigInteger((BigInteger) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case TestModelPackage.TEST_OBJECT__NUMBER:
			unsetNumber();
			return;
		case TestModelPackage.TEST_OBJECT__D:
			setD(D_EDEFAULT);
			return;
		case TestModelPackage.TEST_OBJECT__F:
			setF(F_EDEFAULT);
			return;
		case TestModelPackage.TEST_OBJECT__DATE:
			setDate(DATE_EDEFAULT);
			return;
		case TestModelPackage.TEST_OBJECT__TEXT:
			setText(TEXT_EDEFAULT);
			return;
		case TestModelPackage.TEST_OBJECT__PARENT:
			setParent((TestContainer) null);
			return;
		case TestModelPackage.TEST_OBJECT__B:
			setB(B_EDEFAULT);
			return;
		case TestModelPackage.TEST_OBJECT__AC:
			setAc(AC_EDEFAULT);
			return;
		case TestModelPackage.TEST_OBJECT__UNIT:
			setUnit(UNIT_EDEFAULT);
			return;
		case TestModelPackage.TEST_OBJECT__TIME_UNIT:
			setTimeUnit(TIME_UNIT_EDEFAULT);
			return;
		case TestModelPackage.TEST_OBJECT__BYTE:
			setByte(BYTE_EDEFAULT);
			return;
		case TestModelPackage.TEST_OBJECT__SHORT:
			setShort(SHORT_EDEFAULT);
			return;
		case TestModelPackage.TEST_OBJECT__LONG:
			setLong(LONG_EDEFAULT);
			return;
		case TestModelPackage.TEST_OBJECT__BIG_DECIMAL:
			setBigDecimal(BIG_DECIMAL_EDEFAULT);
			return;
		case TestModelPackage.TEST_OBJECT__BIG_INTEGER:
			setBigInteger(BIG_INTEGER_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case TestModelPackage.TEST_OBJECT__NUMBER:
			return isSetNumber();
		case TestModelPackage.TEST_OBJECT__D:
			return d != D_EDEFAULT;
		case TestModelPackage.TEST_OBJECT__F:
			return f != F_EDEFAULT;
		case TestModelPackage.TEST_OBJECT__DATE:
			return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
		case TestModelPackage.TEST_OBJECT__TEXT:
			return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
		case TestModelPackage.TEST_OBJECT__PARENT:
			return getParent() != null;
		case TestModelPackage.TEST_OBJECT__B:
			return b != B_EDEFAULT;
		case TestModelPackage.TEST_OBJECT__AC:
			return AC_EDEFAULT == null ? ac != null : !AC_EDEFAULT.equals(ac);
		case TestModelPackage.TEST_OBJECT__UNIT:
			return unit != UNIT_EDEFAULT;
		case TestModelPackage.TEST_OBJECT__TIME_UNIT:
			return timeUnit != TIME_UNIT_EDEFAULT;
		case TestModelPackage.TEST_OBJECT__BYTE:
			return byte_ != BYTE_EDEFAULT;
		case TestModelPackage.TEST_OBJECT__SHORT:
			return short_ != SHORT_EDEFAULT;
		case TestModelPackage.TEST_OBJECT__LONG:
			return long_ != LONG_EDEFAULT;
		case TestModelPackage.TEST_OBJECT__BIG_DECIMAL:
			return BIG_DECIMAL_EDEFAULT == null ? bigDecimal != null : !BIG_DECIMAL_EDEFAULT.equals(bigDecimal);
		case TestModelPackage.TEST_OBJECT__BIG_INTEGER:
			return BIG_INTEGER_EDEFAULT == null ? bigInteger != null : !BIG_INTEGER_EDEFAULT.equals(bigInteger);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (number: ");
		if (numberESet) {
			result.append(number);
		} else {
			result.append("<unset>");
		}
		result.append(", d: ");
		result.append(d);
		result.append(", f: ");
		result.append(f);
		result.append(", date: ");
		result.append(date);
		result.append(", text: ");
		result.append(text);
		result.append(", b: ");
		result.append(b);
		result.append(", ac: ");
		result.append(ac);
		result.append(", unit: ");
		result.append(unit);
		result.append(", timeUnit: ");
		result.append(timeUnit);
		result.append(", byte: ");
		result.append(byte_);
		result.append(", short: ");
		result.append(short_);
		result.append(", long: ");
		result.append(long_);
		result.append(", bigDecimal: ");
		result.append(bigDecimal);
		result.append(", bigInteger: ");
		result.append(bigInteger);
		result.append(')');
		return result.toString();
	}

} // TestObjectImpl
