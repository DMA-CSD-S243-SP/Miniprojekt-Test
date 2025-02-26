package test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllayer.*;
import modellayer.Currency;


import controllayer.*;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik B�rbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestIllegalCoin {

	ControlPayStation ps;

	/** Fixture for pay station testing. */
	@BeforeEach
	public void setUp() {
		ps = new ControlPayStation();
	}
	


	/**
	 * Verify that illegal coins are rejected.
	 */
	

	// Norwegian coin
	@Test
	void shouldRejectIllegalCurrencyNokCoin() throws IllegalCoinException {
		// Arrange
		int coinValue = 1;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.NOK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		// Act
		
		// Assert
		Assertions.assertThrows(IllegalCoinException.class, () -> ps.addPayment(coinValue, coinCurrency, coinType));
		System.out.println("Handled IllegalCoinException");
	}
	
}
