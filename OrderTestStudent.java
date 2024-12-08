package beverageShop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTestStudent {
	Order orderOne, orderTwo, orderThree, orderFour;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		orderOne = new Order(8, Day.MONDAY, new Customer("Mary", 22));
		orderTwo = new Order(12, Day.SATURDAY, new Customer("John", 45));
		orderThree = new Order(10, Day.SUNDAY, new Customer("Kate", 21));
		orderFour = new Order(14, Day.SUNDAY, new Customer("Elle", 23));
		
		orderOne.addNewBeverage("drip coffee", Size.MEDIUM, false, false);
		orderOne.addNewBeverage("Almond milk latte", Size.LARGE, true, true);
		orderOne.addNewBeverage("Tequila Sunrise", Size.MEDIUM);
		orderOne.addNewBeverage("Mai Tai", Size.SMALL);
		orderOne.addNewBeverage("Martini, shaken, not stirred", Size.SMALL);
		orderOne.addNewBeverage("Banana and spirulina", Size.MEDIUM, 4, true);
		
		
		orderTwo.addNewBeverage("Black coffee", Size.SMALL, false, false);
		orderTwo.addNewBeverage("Strawberry Daquiri", Size.SMALL);
		orderTwo.addNewBeverage("Pineapple and mango", Size.MEDIUM, 2, false);
			
	}

	@Test
	void testGetBeverage() {
		Coffee cf = new Coffee("Black coffee", Size.SMALL, false, false);
		Alcohol al = new Alcohol("Strawberry Daquiri", Size.SMALL, false);
		Smoothie sm1 = new Smoothie("Pineapple and mango", Size.MEDIUM, 2, false);

		
		assertTrue(orderTwo.getBeverage(0).equals(cf));
		assertTrue(orderTwo.getBeverage(1).equals(al));
		assertTrue(orderTwo.getBeverage(2).equals(sm1));
	}

	@Test
	void testAddNewBeverage() {
		assertTrue(orderThree.getTotalItems() == 0);
		orderThree.addNewBeverage("regular Coffee", Size.SMALL, false, false);
		assertTrue(orderThree.getBeverage(0).getType().equals(Type.COFFEE));
		orderThree.addNewBeverage("Mohito", Size.SMALL);
		assertTrue(orderThree.getBeverage(1).getType().equals(Type.ALCOHOL));
		orderThree.addNewBeverage("Detox", Size.MEDIUM, 1, false);
		assertTrue(orderThree.getBeverage(2).getType().equals(Type.SMOOTHIE));
		assertTrue(orderThree.getTotalItems() == 3);

		orderFour.addNewBeverage("Detox", Size.MEDIUM, 4, true);
		assertTrue(orderFour.getBeverage(0).getType().equals(Type.SMOOTHIE));
		orderFour.addNewBeverage("Mohito", Size.SMALL);
		assertTrue(orderFour.getBeverage(1).getType().equals(Type.ALCOHOL));
		orderFour.addNewBeverage("regular Coffee", Size.MEDIUM, true, false);
		assertTrue(orderFour.getBeverage(2).getType().equals(Type.COFFEE));
		assertTrue(orderFour.getTotalItems() == 3);
	}

	@Test
	void testCalcOrderTotal() {
		

		assertEquals(19.0, orderOne.calcOrderTotal(), .01);

		orderTwo.addNewBeverage("regular Coffee", Size.MEDIUM, true, false);
		orderTwo.addNewBeverage("Mohito", Size.SMALL);
		orderTwo.addNewBeverage("Detox", Size.MEDIUM, 4, true);

		assertEquals(19.7, orderTwo.calcOrderTotal(), .01);
	}

	@Test
	void testFindNumOfBeveType() {
		
		
		assertEquals(2, orderOne.findNumOfBeveType(Type.COFFEE));
		assertEquals(3, orderOne.findNumOfBeveType(Type.ALCOHOL));
		assertEquals(1, orderOne.findNumOfBeveType(Type.SMOOTHIE));
	}

	@Test
	void testCompareTo() {
		orderOne.setOrderNum(10000);
		orderTwo.setOrderNum(10000);
		
		assertEquals(0, orderOne.compareTo(orderTwo));
		
		orderOne.setOrderNum(20000);
		orderTwo.setOrderNum(10000);
		
		assertEquals(1, orderOne.compareTo(orderTwo));
		
		orderOne.setOrderNum(10000);
		orderTwo.setOrderNum(20000);
		
		assertEquals(-1, orderOne.compareTo(orderTwo));
	}

	@Test
	void testIsWeekend() {
		assertEquals(false, orderOne.isWeekend());
		assertEquals(true, orderTwo.isWeekend());
	}

	@Test
	void testGetTotalItems() {
		assertEquals(6, orderOne.getTotalItems());
	}

	@Test
	void testToString() {
		
		String orderOneString = "Order [orderNum=" + orderOne.getOrderNum() + ", time=8, day=MONDAY, customer name:Mary][Beverage: drip coffee, size: MEDIUM, has extra shot: false, has extra syrup: false, price:2.5][Beverage: Almond milk latte, size: LARGE, has extra shot: true, has extra syrup: true, price:4.0][Beverage: Tequila Sunrise, size: MEDIUM, is a weekend: false, price:2.5][Beverage: Mai Tai, size: SMALL, is a weekend: false, price:2.0][Beverage: Martini, shaken, not stirred, size: SMALL, is a weekend: false, price:2.0][Beverage: Banana and spirulina, size: MEDIUM, number of fruits: 4, has extra protein: true, price:6.0]";
		assertEquals(orderOneString, orderOne.toString());
		

	}

	@Test
	void testGetOrderNum() {
		assertEquals(orderOne.getOrderNum(), orderOne.getOrderNum());
	}

	@Test
	void testGetTime() {
		assertEquals(8, orderOne.getTime());
	}

	@Test
	void testGetDay() {
		assertEquals(Day.MONDAY, orderOne.getDay());
	}

	@Test
	void testGetBeverages() {
		
		
		Order orderFive = new Order(12, Day.SATURDAY, new Customer("John", 45));
		orderFive.addNewBeverage("Black coffee", Size.SMALL, false, false);
		orderFive.addNewBeverage("Strawberry Daquiri", Size.SMALL);
		orderFive.addNewBeverage("Pineapple and mango", Size.MEDIUM, 2, false);
		
		orderFive.setOrderNum(14000);
		orderTwo.setOrderNum(14000);
		
		assertEquals(orderFive.toString(), orderTwo.toString());
	}


}
