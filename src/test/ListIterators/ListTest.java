package ListIterators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class ListTest {

	protected List<Integer> list;
	
	@Before
	public abstract void setup();
	

	@Test
	public void testSize(){
		assertEquals("Initial size = 0", 0, list.size());
		assertTrue("Initial list is empty", list.isEmpty());
	}
	
	
	@Test
	public void testAdd(){
		testSize();
		list.add(0, 10);
		assertEquals("size equals 1", 1, list.size());
	}
	
	@Test
	public void testRemove(){
		testSize();
		list.add(0, 10);
		list.add(1, 20);
		assertEquals("size equals 2", 2, list.size());
		list.remove(0, 10);
		assertEquals("size equals 1", 1, list.size());
		assertEquals("first element is 20", (Integer)20, list.get(0));
	}
	
	@Test
	public void testSetAndGet() throws Exception{
		testSize();
		list.add(0, 123);
		list.add(1, 789);
		assertEquals("size equals 2", 2, list.size());
		assertEquals("first element is 123", new Integer(123), list.get(0));
		assertEquals("second element is 789", new Integer(789), list.get(1));
		assertEquals("size unchanged", 2, list.size());
		list.set(0, 555);
		list.set(1, 666);
		assertEquals("first element is 555", new Integer(555), list.get(0));
		assertEquals("second element is 666", new Integer(666), list.get(1));
		assertEquals("size unchanged", 2, list.size());
		try{
			list.set(8, 8);
			fail("Setting an index that has not been added should throw and exception");
		}catch (IndexOutOfBoundsException e){
			// Do nothing.
		}
	}
}