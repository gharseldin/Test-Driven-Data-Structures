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
		assertEquals("First Element", list.first().getElement());
	}
	
	@Test
	public void testAddLastAndLast(){
		list.addFirst("First Element");
		list.addLast("Last Element");
		assertEquals("Last Element", list.last().getElement());
	}
	
	@Test
	public void testAddAfterAndAfter(){
		Position<String> firstName = list.addFirst("Amr");
		Position<String> lastName = list.addAfter(firstName, "Gharseldin");
		assertEquals("Initial list is of size 2", 2, list.size());
		assertEquals(lastName.getElement(), list.after(firstName).getElement());
	}
	
	@Test
	public void testAddBeforeAndBefore(){
		Position<String> lastName = list.addFirst("Gharseldin");
		Position<String> firstName = list.addBefore(lastName, "Amr");
		assertEquals("Amr", list.before(lastName).getElement());
	}
	
	@Test
	public void testSet(){
		Position<String> firstName = list.addFirst("Amr");
		assertEquals("Amr", list.set(firstName, "Ahmed"));
		assertEquals("Ahmed", list.first().getElement());
	}
	
	@Test
	public void testRemoveAndExceptions(){
		Position<String> firstName = list.addFirst("Amr");
		Position<String> lastName = list.addAfter(firstName, "Gharseldin");
		assertEquals("Gharseldin",(list.remove(lastName)));
		assertEquals(1, list.size());
		assertEquals("Amr", list.last().getElement());
		
		
		try{
			list.addAfter(lastName, "test");
			fail("Illegal Argument Expected from defunt argument");
		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		
		try{
			list.addBefore(lastName, "test");
			fail("Illegal Argument Expected from defunt argument");
		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		
		try{
			list.after(lastName);
			fail("Illegal Argument Expected from defunt argument");
		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		
		try{
			list.before(lastName);
			fail("Illegal Argument Expected from defunt argument");
		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		
		try{
			list.set(lastName, "test");
			fail("Illegal Argument Expected from defunt argument");
		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		
		try{
			list.remove(lastName);
			fail("Illegal Argument Expected from defunt argument");
		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}

}
