package beverageShop;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BeverageTestStudent {

	Beverage a,b,c;
	
	@BeforeEach
	void setUp() throws Exception {
		
		a = new Coffee("Almond Latte", Size.LARGE, false, false);
		b = new Alcohol("Tequila Sunrise", Size.MEDIUM, true);
		c = new Smoothie("Banana", Size.SMALL, 3, false);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	@Test
	void testAddSizePrice() {
		assertEquals(3, a.addSizePrice(), .1);
	}

	@Test
	void testCalcPrice() {
		assertEquals(3, a.calcPrice(), .1);
	}

	@Test
	void testEqualsBeverage() {
		assertEquals(a,a);
	}

	@Test
	void testGetName() {
		assertEquals(a.getName(), "Almond Latte");
	}

	@Test
	void testGetType() {
		assertEquals(Type.COFFEE, a.getType());
	}

	@Test
	void testGetSize() {
		assertEquals(Size.LARGE, a.getSize());
	}

}
