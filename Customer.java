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
public class Customer {

	private String name;
	private int age;
	
	/*
	 * Constructor
	 */
	public Customer(String name, int age)
	{
		this.name = name; 
		this.age = age; 
	}
	
	// Copy constructor
	public Customer(Customer a)
	{
		this.name = a.getName();
		this.age = a.getAge();
	}
	
	/*
	 * ToString with name and age
	 */
	@Override
	public String toString()
	{
		return ("Name: " + name + ", age:" + age);
	}

	
	
	
	
	/*
	 * Getter for name
	 */
	public String getName() {
		return name;
	}

	/*
	 * Setter for name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * Getter for age
	 */
	public int getAge() {
		return age;
	}

	/*
	 * Setter for age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
}
