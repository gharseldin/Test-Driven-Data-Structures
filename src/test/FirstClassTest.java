import static org.junit.Assert.*;

import org.junit.Test;

public class FirstClassTest {

	@Test
	public void testIncrement() {
		FirstClass first = new FirstClass();
		assertEquals(0, first.variable);
		first.increment();
		assertEquals(1, first.variable);
	}

}
