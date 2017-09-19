package stackQueueDequeue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class StackTest {

	Stack<Character> stack;
	
	@Before
	public abstract void setup();
	
	
	@Test
	public void testSize(){
		assertTrue("Stack is empty", stack.isEmpty());
		assertTrue("Size of an empty stack is 0", stack.size() == 0);
	}
	
	@Test
	public void testPush() throws Exception{
		assertTrue("Size of an empty stack is 0", stack.size() == 0);
		stack.push('A');
		stack.push('M');
		stack.push('R');
		assertTrue("Size after pushing 3 elements is 3", stack.size() ==3 );
	}
	
	@Test
	public void testTop() throws Exception{
		assertTrue("Size of an empty stack is 0", stack.size() == 0);
		stack.push('A');
		stack.push('M');
		stack.push('R');
		assertEquals((char)stack.top(), 'R');
		assertTrue("Size after pushing 3 elements is 3", stack.size() ==3 );
	}
	
	@Test
	public void testPop() throws Exception{
		assertTrue("Size of an empty stack is 0", stack.size() == 0);
		stack.push('A');
		stack.push('M');
		stack.push('R');
		assertEquals((char)stack.pop(), 'R');
		assertEquals((char)stack.pop(), 'M');
		assertEquals("Size after pushing 3 elements and poping 2 is 1", stack.size(), 1 );
	}
}
