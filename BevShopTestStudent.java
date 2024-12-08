package beverageShop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTestStudent {
	Order orderOne, orderTwo, orderThree, orderFour;
	BevShop a;
	Smoothie s;
	Alcohol alc;
	
	@BeforeEach
	void setUp() throws Exception {
		orderOne = new Order(8, Day.MONDAY, new Customer("Mary", 22));
		orderTwo = new Order(12, Day.SATURDAY, new Customer("John", 45));
		orderThree = new Order(10, Day.SUNDAY, new Customer("Kate", 21));
		
		
		a = new BevShop();
		
		orderOne.addNewBeverage("drip coffee", Size.MEDIUM, false, false);
		orderOne.addNewBeverage("Almond milk latte", Size.LARGE, true, true);
		
		
		orderOne.addNewBeverage("Tequila Sunrise", Size.MEDIUM);
		orderOne.addNewBeverage("Mai Tai", Size.SMALL);
		orderOne.addNewBeverage("Martini, shaken, not stirred", Size.SMALL);
		orderOne.addNewBeverage("Banana and spirulina", Size.MEDIUM, 4, true);
		
		s = new Smoothie("Banana and spirulina", Size.MEDIUM, 4, true);
		alc = new Alcohol("Tequila Sunrise", Size.MEDIUM, false);
		
		
	}


	@Test
	void testIsValidTime() {
		assertEquals(true, a.isValidTime(8));
	}

	@Test
	void testGetMaxNumOfFruits() {
		assertEquals(5, a.getMaxNumOfFruits());
	}

	@Test
	void testGetMinAgeForAlcohol() {
		assertEquals(21, a.getMinAgeForAlcohol());
	}

	@Test
	void testIsMaxFruit() {
		assertEquals(false, a.isMaxFruit(s.getNumFruits()));
	}

	@Test
	void testGetMaxOrderForAlcohol() {
		assertEquals(3, a.getMaxOrderForAlcohol());
	}

	@Test
	void testIsEligibleForMore() {
		assertEquals(true, a.isEligibleForMore());
	}

	@Test
	void testGetNumOfAlcoholDrink() {
		assertEquals(0, a.getNumOfAlcoholDrink());
	}

	@Test
	void testIsValidAge() {
		assertEquals(true, a.isValidAge(21));
	}


}
