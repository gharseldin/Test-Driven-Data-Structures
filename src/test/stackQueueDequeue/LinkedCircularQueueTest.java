package stackQueueDequeue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedCircularQueueTest extends QueueTest{

	@Before
	public void setup() {
		queue = new LinkedCircularQueue<>();
	}
	
	@Test
	public void testRotate() {
		queue.enqueue("Amr");
		queue.enqueue("M");
		queue.enqueue("Gharseldin");
		((LinkedCircularQueue<String>)queue).rotate();
		assertEquals("1 rotation takes Amr to the back and M to the front", queue.first(), "M");
		((LinkedCircularQueue<String>)queue).rotate();
		assertEquals("2 rotation takes M to the back and Gharseldin to the front", queue.first(), "Gharseldin");
	}

}
