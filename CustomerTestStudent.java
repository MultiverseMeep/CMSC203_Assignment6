package beverageShop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTestStudent {

	Customer alayna;
	
	
	@BeforeEach
	void setUp() throws Exception {
		alayna = new Customer("Alayna", 19);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testToString() {
		String test = ("Name: " + alayna.getName() + ", age:" + alayna.getAge());
		assertEquals(alayna.toString(), test);
	}

	@Test
	void testGetName() {
		assertEquals("Alayna", alayna.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(19, alayna.getAge());
	}

}
