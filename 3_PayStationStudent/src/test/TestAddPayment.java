package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import controllayer.ControlPayStation;
import controllayer.IllegalCoinException;

import org.junit.*;

import modellayer.*;
import modellayer.Currency.ValidCurrency;

public class TestAddPayment
{
	private static ControlPayStation ps;

	/** Fixture for pay station testing. */
	@BeforeAll
	public static void setUp()
	{
		ps = new ControlPayStation();
	}
	
	@BeforeEach
	public void clean()
	{
		ps.setReady();
	}

	private void shouldntThrowException(int coinValue, Currency.ValidCurrency coinCurrency,
			Currency.ValidCoinType coinType)
	{
		// Arrange
		int expectedParkingTime = 0; // In minutes
		boolean exceptionThrown = false;

		// Act
		try
		{
			ps.addPayment(coinValue, coinCurrency, coinType);
		} catch (IllegalCoinException e)
		{
			exceptionThrown = true;
		}
		assertTrue(!exceptionThrown);
	}
	
	private void shouldThrowException(int coinValue, Currency.ValidCurrency coinCurrency,
			Currency.ValidCoinType coinType)
	{
		// Arrange
		int expectedParkingTime = 0; // In minutes
		boolean exceptionThrown = false;

		// Act
		try
		{
			ps.addPayment(coinValue, coinCurrency, coinType);
		} catch (IllegalCoinException e)
		{
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);
	}

	private void shouldEqualValue(int coinValue, Currency.ValidCurrency coinCurrency, Currency.ValidCoinType coinType,
			int expectedParkingTime)
	{
		try
		{
			ps.addPayment(coinValue, coinCurrency, coinType);
		} catch (IllegalCoinException e)
		{

		}
		String displayString = "Should display " + expectedParkingTime + " min for " + coinValue + " "
				+ coinCurrency.name();
		assertEquals(expectedParkingTime, ps.readDisplay(), displayString);
	}
	

	@Test
	public void test1Boolean()
	{
		shouldThrowException(25, Currency.ValidCurrency.DKK, Currency.ValidCoinType.FRACTION);
	}
	
	@Test
	public void test1Value()
	{
		shouldEqualValue(25, Currency.ValidCurrency.DKK, Currency.ValidCoinType.FRACTION, 0);
	}
	
	@Test
	public void test2Boolean()
	{
		shouldntThrowException(50, Currency.ValidCurrency.DKK, Currency.ValidCoinType.FRACTION);
	}
	
	@Test
	public void test2Value()
	{
		shouldEqualValue(50, Currency.ValidCurrency.DKK, Currency.ValidCoinType.FRACTION, 3);
	}
	
	
	@Test
	public void test3Boolean()
	{
		shouldntThrowException(20, Currency.ValidCurrency.DKK, Currency.ValidCoinType.INTEGER);
	}
	
	@Test
	public void test3Value()
	{
		shouldEqualValue(20, Currency.ValidCurrency.DKK, Currency.ValidCoinType.INTEGER, 107);
	}
	
	
	@Test
	public void test4Boolean()
	{
		shouldThrowException(50, Currency.ValidCurrency.DKK, Currency.ValidCoinType.INTEGER);
	}
	
	@Test
	public void test4Value()
	{
		shouldEqualValue(50, Currency.ValidCurrency.DKK, Currency.ValidCoinType.INTEGER, 0);
	}
	
	
	@Test
	public void test5Boolean()
	{
		shouldntThrowException(1, Currency.ValidCurrency.EURO, Currency.ValidCoinType.FRACTION);
	}
	
	@Test
	public void test5Value()
	{
		shouldEqualValue(1, Currency.ValidCurrency.EURO, Currency.ValidCoinType.FRACTION, 1);
	}
	
	
	@Test
	public void test6Boolean()
	{
		shouldntThrowException(2, Currency.ValidCurrency.EURO, Currency.ValidCoinType.INTEGER);
	}
	
	@Test
	public void test6Value()
	{
		shouldEqualValue(2, Currency.ValidCurrency.EURO, Currency.ValidCoinType.INTEGER, 80);
	}
	
	
	@Test
	public void test7Boolean()
	{
		shouldThrowException(5, Currency.ValidCurrency.EURO, Currency.ValidCoinType.INTEGER);
	}
	
	@Test
	public void test7Value()
	{
		shouldEqualValue(5, Currency.ValidCurrency.EURO, Currency.ValidCoinType.INTEGER, 0);
	}
	
	
	@Test
	public void test8Boolean()
	{
		shouldThrowException(2, Currency.ValidCurrency.NOK, Currency.ValidCoinType.INTEGER);
	}
	
	@Test
	public void test8Value()
	{
		shouldEqualValue(2, Currency.ValidCurrency.NOK, Currency.ValidCoinType.INTEGER, 0);
	}
	
	
	/** Fixture for pay station testing. */
	@AfterAll
	public static void cleanUp()
	{
		ps.setReady();
	}

}
