package LinkedLists;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest {

	SinglyLinkedList<Integer> list;
	
	@Before
	public void setup(){
		list = new SinglyLinkedList<>();
	}
	
	private void populateFrontOfList(){
		Random randomGenerator = new Random(System.currentTimeMillis());
		for(int i=0 ; i<10; i++){
			list.addFirst(randomGenerator.nextInt(100));
		}
	}
	
	private void populateEndOfList(){
		Random randomGenerator = new Random(System.currentTimeMillis());
		for(int i=0 ; i<10; i++){
			list.addLast(randomGenerator.nextInt(100));
		}
	}
	
	@Test
	public void testSize() {
		assertEquals("Initialized list", 0, list.size());
		populateFrontOfList();
		assertEquals("Added 10 elements to front", 10, list.size());
		populateEndOfList();
		assertEquals("Added 10 elements to end", 20, list.size());
		list.removeFirst();
		assertEquals("remove 1 element from front", 19, list.size());
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue ("A freshly initialized LinkedList should be empty.", list.isEmpty());
		list.addFirst(12);
		assertFalse ("A linkedList with elements should not be empty.", list.isEmpty());
		list.removeFirst();
		assertTrue("A linked list with all elements deleted should be empty.", list.isEmpty());
	}
	
	@Test
	public void testAddFirst() {
		list.addFirst(999);
		assertEquals("check size after adding element to front", 1, list.size());
		assertEquals("check the first value to be the same as inserted at front", 999, (int)list.first());
	}
	
	@Test
	public void testAddLast() {
		list.addLast(888);
		assertEquals("check size after adding element to end", 1, list.size());
		assertEquals("check the last value to be the same as inserted at end", 888, (int)list.last());
	}
	
	@Test
	public void testfirst() {
		list.addFirst(777);
		assertTrue("Value inserted is at the first position", list.first() == 777);
	}
	
	@Test
	public void testLast() {
		list.addLast(666);
		assertTrue("Value inserted is at the last position", list.last() == 666);
	}
	
	@Test
	public void testRemovefirst() {
		populateFrontOfList();
		populateEndOfList();
		assertTrue("Size is 20", list.size() == 20);
		list.addFirst(555);
		assertTrue("Size is 21", list.size() == 21);
		assertTrue("Value inserted is at the start position is removed correctly"
				, list.removeFirst() == 555);
		assertTrue("Size is 20", list.size() == 20);
	}
	
}