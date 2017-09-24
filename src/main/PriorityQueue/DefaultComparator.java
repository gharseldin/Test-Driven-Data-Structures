package PriorityQueue;

import java.util.Comparator;

public class DefaultComparator<E> implements Comparator<E> {

	@Override
	public int compare(E o1, E o2) throws ClassCastException{
		return ((Comparable)o1).compareTo(o2);
	}

}