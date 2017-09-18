import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SortingTest {

	private Sorting sort;
	private Integer[] arrayToBeSorted;
	
	@Before
	public void setup(){
		sort = new Sorting();
		
		Random randomGenerator = new Random(System.currentTimeMillis());
		arrayToBeSorted = new Integer[7];
		for(int i=0; i<arrayToBeSorted.length; i++)
			arrayToBeSorted[i] = randomGenerator.nextInt(100);
		System.out.println(Arrays.toString(arrayToBeSorted));
	}

	@Test
	public void testInsertionSort() throws Exception{
		Arrays.sort(arrayToBeSorted);
		assertArrayEquals(arrayToBeSorted, sort.insertionSort(arrayToBeSorted));
		System.out.println(Arrays.toString(arrayToBeSorted));
	}
	
	@Test
	public void testmoreEfficientInsertionSort() throws Exception{
		Arrays.sort(arrayToBeSorted);
		assertArrayEquals(arrayToBeSorted, sort.moreEfficientInsertionSort(arrayToBeSorted));
		System.out.println(Arrays.toString(arrayToBeSorted));
	}
}
