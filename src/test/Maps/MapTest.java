package Maps;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class MapTest {

	Map<String, Integer> EmployeeAges;
	
	@Before
	public abstract void setup();
	
	public void initialize(){
		EmployeeAges.put("Amr", 36);
		EmployeeAges.put("Melissa", 36);
		EmployeeAges.put("Ahmed", 32);
		EmployeeAges.put("Mai", 34);
		EmployeeAges.put("baby", 1);
		EmployeeAges.put("Emily", 16);
		EmployeeAges.put("Justin", 9);
		EmployeeAges.put("Ryan", 5);
	}
	
	@Test
	public void testIsEmpty(){
		assertTrue("size is initially Empty", EmployeeAges.isEmpty());
		initialize();
		assertFalse("size in not empty after adding entries", EmployeeAges.isEmpty());
	}
	
	@Test
	public void testSize(){
		assertEquals("size should be zero at start", 0, EmployeeAges.size());
		initialize();
		assertEquals("size should be 8 after adding 8 items ", 8, EmployeeAges.size());
	}
}
