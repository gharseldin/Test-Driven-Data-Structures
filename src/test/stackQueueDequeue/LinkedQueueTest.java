package stackQueueDequeue;

import org.junit.Before;

public class LinkedQueueTest extends QueueTest{

	@Before
	public void setup(){
		queue = new LinkedQueue<>();
	}
}
