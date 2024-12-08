package beverageShop;

import java.util.Random;
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
public class Order implements OrderInterface, Comparable {

	
	private int orderNum;
	private int time;
	private Day day;
	String customerName;
	private int age;
	private ArrayList<Beverage> beverages = new ArrayList<Beverage>();
	
	/*
	 * Generates a random order number
	 */
	private int getRandOrderNum()
	{
		Random rand = new Random();
		return rand.nextInt(10000, 90000);
	}
	
	/*
	 * Constructor for order
	 */
	public Order(int time, Day day, String customerName, int age)
	{
		this.orderNum = getRandOrderNum();
		this.time = time;
		this.day = day;
		this.customerName = customerName;
		this.age = age;
	}
	
	/*
	 * Constructor for order
	 */
	public Order(int time, Day day, Customer customer)
	{
		this.orderNum = getRandOrderNum();
		this.time = time;
		this.day = day;
		this.customerName = customer.getName();
		this.age = customer.getAge();
	}
	
	/*
	 * return beverage at index
	 */
	@Override
	public Beverage getBeverage(int itemNo) {
		return beverages.get(itemNo);
	}

	/*
	 * Add new coffee to order
	 */
	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		//Coffee
		
		beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
		
		
	}

	/*
	 * Add new alcohol to order
	 */
	@Override
	public void addNewBeverage(String bevName, Size size) {
		// Alcohol
		// Might have to add age check here?
		if(age >= 21)
		{
			beverages.add(new Alcohol(bevName, size, (day.getValue() > 4)));
		}
		else
		{
			System.out.println("You are not old enough to order alcohol!");
		}

	}

	/*
	 * Add new smoothie to order
	 */
	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		// Smoothie
		beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));

	}

	/*
	 * Calculate the order total
	 */
	@Override
	public double calcOrderTotal() {
		double price = 0;
		for(Beverage element : beverages)
		{
			price += element.calcPrice();
		}
		return price;
	}

	/*
	 * Find how many drinks of the selected type are in order
	 */
	@Override
	public int findNumOfBeveType(Type type) {
		
		int temp = 0;
		for(Beverage element : beverages)
		{
			if(element.getType() == type)
			{
				temp++;
			}
		}
		return temp;
	}

	/*
	 * Check how orderNum compares to other order
	 */
	public int compareTo(Order a) {
		if((orderNum == a.orderNum))
		{
			return 0;
		}
		else if (orderNum > a.orderNum)
		{
			return 1;
		}
		else if (orderNum < a.orderNum)
		{
			return -1;
		}
		return orderNum;
	}

	/*
	 * Checks if weekend
	 */
	@Override
	public boolean isWeekend() {
		if(day.getValue() > 4)
		{
			return true;
		}
		return false;
	}

	/*
	 * Returns total amount of beverages in order
	 */ 
	public int getTotalItems()
	{

		return beverages.size();
	}
	
	/*
	 * toString
	 */
	@Override
	public String toString() {
		String returnVal = "";
		returnVal += "Order [orderNum=" + orderNum + ", time=" + time + ", day=" + day + ", customer name:" + customerName + "]";
		for(Beverage element : beverages)
		{
			returnVal += "[" + element.toString() + "]";
		}
		return returnVal;
	}

	

	
	
	
	
	/*
	 * Getters and setters
	 */
	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	

	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}

	public void setBeverages(ArrayList<Beverage> beverages) {
		this.beverages = beverages;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	//TODO add customer deep copy
	
	


}
