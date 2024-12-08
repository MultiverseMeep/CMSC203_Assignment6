package beverageShop;
/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Simulate a cafe that serves beverages and keeps track of orders
 * Due: 10/28/2024
 * Platform/compiler: Eclipse/Java
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Alayna Goss
*/
public class BevShopDriverApp {
	
	public static void main(String[] args){
		int time = 10;
		int age = 18;
		String customerName = "Alayna";
		Day day = Day.MONDAY;
		
		BevShop alaynaCafe = new BevShop();
		alaynaCafe.startNewOrder(time, day, customerName, age);
		alaynaCafe.getCurrentOrder().addNewBeverage("Latte", Size.LARGE, false, false);
		alaynaCafe.getCurrentOrder().addNewBeverage("Banana Smoothie", Size.MEDIUM, 4, true);
		alaynaCafe.getCurrentOrder().addNewBeverage("Tequila Sunrise", Size.SMALL);
	
		System.out.println(alaynaCafe.toString());
		
		System.out.println("\nMade by Alayna Goss");
	}
	
}
