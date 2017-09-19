package stackQueueDequeue;

import org.junit.Before;

public class LinkedStackTest extends StackTest{

	@Before
	public void setup(){
		stack = new LinkedStack<>();
	}
}
