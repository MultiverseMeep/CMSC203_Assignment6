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
public abstract class Beverage {

	public String name;
	public Type type;
	public Size size;
	public final double basePrice = 2.0;
	public final double sizePrice = .5;
	
	
	/*
	 * Constructor
	 */
	public Beverage(String name, Type type, Size size)
	{
		this.name = name;
		this.type = type;
		this.size = size;
	}
	
	/*
	 * Adds 50 cents per size larger than small
	 */
	public double addSizePrice()
	{
		return basePrice + (size.getValue() * sizePrice);
		
		
	}
	
	/*
	 * Abstract calcPrice to be used in subclasses 
	 */
	public abstract double calcPrice();
	
	/*
	 * ToString with name and size
	 */
	public String toString()
	{
		return ("Beverage: " + name + ", size: " + size);
	}
	
	/*
	 * Checks equality
	 */
	public boolean equals(Beverage a)
	{
		if((name.equals(a.name)) && (type.equals(a.type)) && (size.equals(a.size)))
			{
				return true;
			}	
		return false;
	}


	
	
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public Size getSize() {
		return size;
	}


	public void setSize(Size size) {
		this.size = size;
	}
	
	
	
	
	
}
