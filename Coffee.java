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
public class Coffee extends Beverage{

	private boolean extraShot;
	private boolean syrup;
	private final double extraShotCost = .5;
	private final double syrupCost = .5;
	static Type type = Type.COFFEE;	
	
	/*
	 * Constructor
	 */
	public Coffee(String name, Size size, boolean extraShot, boolean syrup) {
		super(name, type, size);
		this.extraShot = extraShot;
		this.syrup = syrup;
	}

	/*
	 * calculates price
	 */
	@Override
	public double calcPrice() {
		
		return super.addSizePrice() + (extraShotCost * (extraShot? 1:0)) + (syrupCost * (syrup? 1:0));
		
	
	}
	
	/*
	 * equality checker
	 */
	@Override
	public boolean equals(Object a)
	{
		Coffee coffee = (Coffee) a;
		if((super.equals(a)) && (coffee.extraShot == extraShot) && (coffee.syrup == syrup))
		{
			return true;
		}
		return false;
	}
	
	/*
	 * toString
	 */
	@Override
	public String toString()
	{
		return ("Beverage: " + name + ", size: " + size + ", has extra shot: " + extraShot + ", has extra syrup: " + syrup + ", price:" + calcPrice());
	}

	
	
	/*
	 * getters and setters
	 */
	public boolean isExtraShot() {
		return extraShot;
	}

	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	public boolean isSyrup() {
		return syrup;
	}

	public void setSyrup(boolean syrup) {
		this.syrup = syrup;
	}
	
	

	
	
}
