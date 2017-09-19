package stackQueueDequeue;

import org.junit.Before;

public class ArrayQueueTest extends QueueTest{

	@Before
	public void setup(){
		queue = new ArrayQueue<>(10);
	}
}
