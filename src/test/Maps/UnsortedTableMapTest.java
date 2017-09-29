package Maps;

import static org.junit.Assert.*;

import org.junit.Test;

import Maps.AbstractMap.MapEntry;

public class UnsortedTableMapTest extends MapTest{

	public void setup(){
		EmployeeAges = new UnsortedTableMap<>();
	}
	
	@Test
	public void testPutAndGet(){
		initialize();
		assertEquals("Getting a value that is not in the map should return null",
				null, EmployeeAges.get("Some Name"));
		assertEquals("Adding an item that is not already in the list will result in a null return",
				null,EmployeeAges.put("Some Name", 999));
		assertEquals("Adding an item that is already in the list will result in an old value return",
				(Integer)999, EmployeeAges.put("Some Name", 88));
		assertEquals("getting a vlaue that is in the map should return it",
				(Integer)88, EmployeeAges.get("Some Name"));
	}
	
	@Test
	public void testRemove(){
		initialize();
		int size = EmployeeAges.size();
		assertEquals("removing an item should return its value", (Integer)36, EmployeeAges.remove("Amr"));
		assertEquals("Size should now be less by one", size-1, EmployeeAges.size());
		assertEquals("Trying to retrieve the removed Item should return a null value",
				null, EmployeeAges.get("Amr"));
	}
	
	@Test 
	public void testIterators(){
		testIterator(EmployeeAges.entries());
		testIterator(EmployeeAges.keySet());
		testIterator(EmployeeAges.values());
	}
	
	private <T> void testIterator(Iterable<T> iterable){
		initialize();
		int count = 0;
		for(T item : iterable){
			count++;
			assertTrue("The item is not null",item != null);
		}
		assertEquals("There should be 8 items in the map", 8, count);
	}
}
