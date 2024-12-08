package beverageShop;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent {

	Coffee a,b, c;
	
	@BeforeEach
	void setUp() throws Exception {
		a = new Coffee("Almond Latte", Size.LARGE, false, false);
		b = new Coffee("Black Coffee", Size.SMALL, false, false);
		c = new Coffee("Caramel Latte", Size.LARGE, true, true);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalcPrice() {
		assertEquals(3, a.calcPrice(), .1);
		assertEquals(2, b.calcPrice(), .1);
		assertEquals(4, c.calcPrice(), .1);
	}

	@Test
	void testToString() {
		String test = ("Beverage: " + a.name + ", size: " + a.size + ", has extra shot: " + a.isExtraShot() + ", has extra syrup: " + a.isSyrup() + ", price:" + a.calcPrice());
		assertEquals(a.toString(), test);
	}

	@Test
	void testEqualsObject() {
		assertEquals(a,a);
	}

	@Test
	void testIsExtraShot() {
		assertEquals(true, c.isExtraShot());
	}

	@Test
	void testIsSyrup() {
		assertEquals(true, c.isSyrup());
	}


}
