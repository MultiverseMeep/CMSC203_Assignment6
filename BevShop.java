package beverageShop;
import java.util.ArrayList;
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
public class BevShop implements BevShopInterface {

	
	int MIN_AGE_FOR_ALCOHOL = 21;  //Minimum age for offering alcohol drink
	int MAX_ORDER_FOR_ALCOHOL= 3;   /*Maximum number of alcohol beverages
										that can be ordered within an order  */
	int MIN_TIME= 8;				//earliest time for the order
	int MAX_TIME= 23;				//latest  time for the order
	int MAX_FRUIT = 5;				//Maximum number of fruits that this shop offers for SMOOTHIE beverage
	int alcoholInOrder = 0;
	
	
	private ArrayList<Order> orders = new ArrayList<Order>();
	
	/*
	 * Constructor
	 */
	public BevShop()
	{
		
	}
	
	/*
	 * Checks if the shop is open
	 */
	@Override
	public boolean isValidTime(int time) {

		if((time >= 8)&&(time <= 23))
		{
			return true;
		}
		
		
		return false;
	}
	
	/*
	 * Checks how many fruits can go in a smoothie 
	 */
	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	/*
	 * Checks if Customer is 21
	 */
	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	/*
	 * Checks if smoothie has the max number of fruits
	 */
	@Override
	public boolean isMaxFruit(int numOfFruits) {
		if(numOfFruits >= MAX_FRUIT)
		{
			return true;
		}
		return false;
	}

	/*
	 * Returns the maximum amount of alcohol you can order
	 */
	@Override
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	/*
	 * Checks if the customer can have more alcohol
	 */
	@Override
	public boolean isEligibleForMore() {
		if(alcoholInOrder < MAX_ORDER_FOR_ALCOHOL)
		{
			return true;
		}
		return false;
	}

	/*
	 * Checks how many alcoholic drinks are in current order
	 */
	@Override
	public int getNumOfAlcoholDrink() {
		return alcoholInOrder;
	}

	/*
	 * Checks if the customer is old enough to order alcohol
	 */
	@Override
	public boolean isValidAge(int age) {
		if(age >= MIN_AGE_FOR_ALCOHOL)
		{
			return true;
		}
		return false;
	}

	/*
	 * Start a new order
	 */
	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		orders.add(new Order(time, day, customerName, customerAge));
		
	}

	/*
	 * Add coffee to current order
	 */
	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
		
	}

	/*
	 * Add alcohol to current order
	 */
	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		getCurrentOrder().addNewBeverage(bevName, size);
		
	}

	/*
	 * Add smoothie to current order
	 */
	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
		
	}

	/*
	 * Locate order index based off of orderNumber
	 */
	@Override
	public int findOrder(int orderNo) {
		for(int i = 0; i < orders.size(); i++)
		{
		
			if(orders.get(i).getOrderNum() == orderNo)
			{
				return i;
			}
		}
		return -1;
	}

	/*
	 * Return the total price of the order
	 */
	@Override
	public double totalOrderPrice(int orderNo) {
		
		return orders.get(findOrder(orderNo)).calcOrderTotal();
		
	}

	/*
	 * Return the price of all orders combined
	 */
	@Override
	public double totalMonthlySale() {
		double price = 0;
		for(Order element : orders)
		{
			price += element.calcOrderTotal();
		}
		return price;
	}

	/*
	 * Returns the amount of orders 
	 */
	@Override
	public int totalNumOfMonthlyOrders() {
		
		return orders.size();
	}

	/*
	 * Returns the index of the current order
	 */
	@Override
	public Order getCurrentOrder() {
		return orders.get(orders.size()-1);
	}

	/*
	 * Returns the order at index
	 */
	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	/*
	 * Sort the orders array based on price, min to high
	 */
	@Override
	public void sortOrders() {		
		
		for(int i = 0; i < orders.size(); i++)
		{
			int min = orders.get(0).getOrderNum();
			
			for(int k = i + 1; k < orders.size(); k++)
			{
				if(orders.get(k).getOrderNum() < min)
				{
					min = k;
				}
			}
			
			
			Order temp = orders.get(i);
			orders.set(min, orders.get(min));
			orders.set(min, temp);

		}

	}
	
	/*
	 * ToString with monthly total and orders
	 */
	@Override
	public String toString()
	{
		String returnVal = "Monthly total of: " + totalMonthlySale() + ", with orders of: ";
		for (Order element : orders)
		{
			returnVal += element.toString();
		}
		return returnVal;
	}
	

}
