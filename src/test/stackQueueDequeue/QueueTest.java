package stackQueueDequeue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class QueueTest {

	Queue<String> queue;
	
	@Before
	public abstract void setup();
	
	@Test
	public void testSize() {
		assertTrue("Queue is empty when instantiated", queue.isEmpty());
		assertEquals("Queue has size zero", queue.size(), 0);
	}
	
	@Test
	public void testEnqueue(){
		assertTrue("Queue is empty", queue.isEmpty());
		queue.enqueue("Amr");
		queue.enqueue("M");
		queue.enqueue("Gharseldin");
		assertEquals("Array size = 3 since 3 elements enqueued", queue.size(), 3);
	}
	
	@Test
	public void testFirst(){
		assertTrue("Queue is empty", queue.isEmpty());
		queue.enqueue("Amr");
		queue.enqueue("M");
		queue.enqueue("Gharseldin");
		assertEquals("Array size = 3 since 3 elements enqueued", queue.size(), 3);
		assertEquals("first element is Amr", queue.first(), "Amr");
		assertEquals("Array size stays the same", queue.size(), 3);
	}
	
	@Test
	public void testDequeue(){
		assertTrue("Queue is empty", queue.isEmpty());
		queue.enqueue("Amr");
		queue.enqueue("M");
		queue.enqueue("Gharseldin");
		assertEquals("Array size = 3 since 3 elements enqueued", queue.size(), 3);
		assertEquals("Dequed values are correct", queue.dequeue(), "Amr");
		assertEquals("Array size = 2 since 3 elements enqueued and 1 element dequeued", queue.size(), 2);
	}
}
