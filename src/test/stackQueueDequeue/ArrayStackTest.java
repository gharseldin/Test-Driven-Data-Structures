package stackQueueDequeue;

import org.junit.Before;

public class ArrayStackTest extends StackTest {

	@Before
	public void setup(){
		stack = new ArrayStack<>(10);
	}
	
}
