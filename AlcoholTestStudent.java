package beverageShop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent {

	Alcohol a;
	
	@BeforeEach
	void setUp() throws Exception {
		
		a = new Alcohol("Tequila Sunrise", Size.MEDIUM, true);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalcPrice() {
		assertEquals(3.1, a.calcPrice(), .1);
	}

	@Test
	void testToString() {
		String test = ("Beverage: " + a.name + ", size: " + a.size + ", is a weekend: " + a.isWeekend() + ", price:" + a.calcPrice());
		assertEquals(a.toString(), test);
	}

	@Test
	void testEqualsObject() {
		Alcohol b = new Alcohol("Tequila Sunrise", Size.MEDIUM, true);
		assertEquals(a, b);
	}

	@Test
	void testIsWeekend() {
		assertEquals(true, a.isWeekend());
	}

	@Test
	void testGetWeekendPrice() {
		assertEquals(.6, a.getWeekendPrice(), .1);
	}

}
