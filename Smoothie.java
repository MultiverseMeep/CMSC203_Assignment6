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
public class Smoothie extends Beverage {

	
	public int numFruits;
	private boolean hasProtein;
	private final double proteinCost = 1.5;
	private final double fruitCost = .5;
	static Type type = Type.SMOOTHIE;
	
	/*
	 * Constructor 
	 */
	public Smoothie(String name, Size size, int numFruits, boolean hasProtein) {
		super(name, type, size);
		this.numFruits = numFruits;
		this.hasProtein = hasProtein;
	}
	
	/*
	 * Calculate price
	 */
	@Override
	public double calcPrice() {

		return super.addSizePrice() + (fruitCost * numFruits) + (proteinCost * (hasProtein? 1:0));
	}
	
	/*
	 * Checks equality with another drink
	 */
	@Override
	public boolean equals(Object a)
	{
		Smoothie smoothie =  (Smoothie) a;
		if((super.equals(a)) && (smoothie.numFruits == numFruits) && (smoothie.hasProtein == hasProtein))
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
		return ("Beverage: " + name + ", size: " + size + ", number of fruits: " + numFruits + ", has extra protein: " + hasProtein + ", price:" + calcPrice());
	}

	/*
	 * Getter for protein
	 */
	public Boolean hasProtein() {
		return hasProtein;
	}
	
	/*
	 * getter for num fruits
	 */
	public int getNumFruits()
	{
		return numFruits;
	}
}
