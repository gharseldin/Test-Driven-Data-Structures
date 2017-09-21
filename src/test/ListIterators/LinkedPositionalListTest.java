package ListIterators;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LinkedPositionalListTest {

	PositionalList<String> list;
	
	
	@Before
	public void setup(){
		list = new LinkedPositionalList<String>();
	}
	
	@Test
	public void testInitialSize(){
		assertEquals("Initial list is of size 0", 0, list.size());
		assertTrue("Initial list is empty", list.isEmpty());
	}
	
	@Test
	public void testaddFirstAndFirst(){
		list.addFirst("First Element");
		assertEquals("First Element", list.first());
	}
	
	@Test
	public void testAddLastAndLast(){
		list.addFirst("First Element");
		list.addLast("Last Element");
		assertEquals("Last Element", list.last());
	}
	
	@Test
	public void testAddAfterAndAfter(){
		Position<String> firstName = list.addFirst("Amr");
		Position<String> lastName = list.addAfter(firstName, "Gharseldin");
		assertEquals("Initial list is of size 2", 2, list.size());
		assertEquals(lastName, list.after(firstName));
		try{
			list.after(lastName);
			fail("And Exceptino shoudl be thrown by trying to find an element that is not present");
		}catch(IllegalStateException e){
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testAddBEforeAndBefore(){
		Position<String> lastName = list.addFirst("Gharseldin");
		Position<String> firstName = list.addBEfore(lastName, "Amr");
		assertEquals("Amr", list.before(lastName));
	}
	
	@Test
	public void testSet(){
		Position<String> firstName = list.addFirst("Amr");
		assertEquals("Amr", list.set(firstName, "Ahmed"));
		assertEquals("Ahmed", list.first());
	}
	
	@Test
	public void testRemove(){
		Position<String> firstName = list.addFirst("Amr");
		Position<String> lastName = list.addAfter(firstName, "Gharseldin");
		assertEquals("Gharseldin", list.remove(lastName));
		assertEquals(1, list.size());
		assertEquals("Amr", list.last());
	}

}
