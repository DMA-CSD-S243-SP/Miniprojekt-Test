package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllayer.ControlPrice;
import databaselayer.DatabaseLayerException;
import modellayer.PPrice;

class TestGetPriceByZoneID
{
	ControlPrice cp = new ControlPrice();
	@BeforeEach
	void setUp() throws Exception
	{
		
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void test1()
	{
		PPrice price = null;
		try
		{
			price = cp.getPriceRemote(2);
		} catch (DatabaseLayerException e)
		{
			fail("Zone 2 should have a stored price.");
		}
		assertNotEquals(price, null, "Price should not be null");
		assertEquals(price.getParkingPrice(), 24, "parkingPrice should be 24");
		assertEquals(price.getParkingZone(), 2, "parkingZone should be 2");
		assertEquals(price.getExchangeEuroDkk(), 7.5, "Exchange rate should be 7.5");
	}
	
	@Test
	void test2()
	{
		PPrice price = null;
		try
		{
			price = cp.getPriceRemote(2);
		} catch (DatabaseLayerException e)
		{
			fail("Zone 2 should have a stored price.");
		}
		assertEquals(price, null, "Price should not be null");
	}

}
