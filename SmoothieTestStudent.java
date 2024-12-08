package beverageShop;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {
	Smoothie a,b,c;
	
	@BeforeEach
	void setUp() throws Exception {
		
		a = new Smoothie("Banana", Size.SMALL, 3, false);
		b = new Smoothie("Spinach", Size.MEDIUM, 2, true);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalcPrice() {
		assertEquals(3.5, a.calcPrice(), .1);
		assertEquals(5, b.calcPrice(), .1);
	}

	@Test
	void testToString() {
		String test = ("Beverage: " + a.name + ", size: " + a.size + ", number of fruits: " + a.numFruits + ", has extra protein: " + a.hasProtein() + ", price:" + a.calcPrice());
		assertEquals(a.toString(), test);
	}

	@Test
	void testEqualsObject() {
		assertEquals(a,a);
	}

}
