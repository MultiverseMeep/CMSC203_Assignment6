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
public class Alcohol extends Beverage{

	private boolean isWeekend;
	
	private final double weekendPrice = .6;
	static Type type = Type.ALCOHOL;
	
	/*
	 * Constructor
	 */
	public Alcohol(String name, Size size, boolean isWeekend) {
		super(name, type, size);
		this.isWeekend = isWeekend;
	}

	/*
	 * calculates price
	 */
	@Override
	public double calcPrice() {
	
		return super.addSizePrice() + (weekendPrice * (isWeekend()? 1:0));
	}
	
	/*
	 * equality checker
	 */
	@Override
	public boolean equals(Object a)
	{
		Alcohol alcohol =  (Alcohol) a;
		return super.equals(alcohol);
		
	}
	
	
	
	/*
	 * toString
	 */
	@Override
	public String toString()
	{
		return ("Beverage: " + name + ", size: " + size + ", is a weekend: " + isWeekend + ", price:" + calcPrice());
	}


	/*
	 * checks if is weekend
	 */
	public boolean isWeekend()
	{
		if (isWeekend)
			{
				return true;
			}
		
		
		return false;
	}
	
	/*
	 * Returns the weekend price increase
	 */
	public double getWeekendPrice() {
		return weekendPrice;
	}
	
	
	
	
	

}
