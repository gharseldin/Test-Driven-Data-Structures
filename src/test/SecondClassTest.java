import static org.junit.Assert.*;

import org.junit.Test;

public class SecondClassTest {

	@Test
	public void testDecrement() {
		SecondClass second = new SecondClass();
		assertEquals(10, second.variable);
		second.decrement();
		assertEquals(9, second.variable);
	}

}
