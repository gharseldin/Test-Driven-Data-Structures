package ListIterators;

import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {

	private class ArrayIterator implements Iterator<E>{

		private int j=0;	//index of next element to report
		private boolean removable = false;
		
		@Override
		public boolean hasNext() {
			return j<size;
		}

		@Override
		public E next() throws NoSuchElementException{
			if(j== size) throw new NoSuchElementException("No next element");
			removable = true;
			return list[j++];
		}

		@Override
		public void remove() throws IllegalStateException{
			if(!removable) 
				throw new IllegalStateException("nothing to remove");
			j--;
			removable = false;
		}
		
	}
	
	public Iterator<E> iterator(){
		return new ArrayIterator();
	}
	
	public static final int CAPACITY = 1000;
	private int size = 0;
	private E[] list;
	
	public ArrayList(){
		list = (E[])new Object[CAPACITY];
	}
	
	public ArrayList(int capacity){
		list = (E[])new Object[capacity];
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i);
		if(i >= size)
			throw new IndexOutOfBoundsException();
		return list[i];
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i);
		if(i >= size)
			throw new IndexOutOfBoundsException();
		E value = list[i];
		list[i] = e;
		return value;
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if(size == list.length)
			resize(2*list.length);
		checkIndex(i);
		if(i > size)
			throw new IndexOutOfBoundsException();
		// shift cells up
		for(int j = size; j>i; j--)
			list[j] = list[j-1];
		list[i] = e;
		size++;
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i);
		if(i >= size)
			throw new IndexOutOfBoundsException();
		
		//get value
		E value = list[i];
		for (int j = i; i<size; i++){
			list[j] = list[j+1];
		}
		size--;
		return value;
	}

	private void checkIndex(int i) throws IndexOutOfBoundsException{
		if(i<0 || i>=list.length )
			throw new IndexOutOfBoundsException();
	}
	
	private void resize(int size){
		E[] newArray = (E[])new Object[size];
		for (int i=0; i<list.length; i++)
			newArray[i] = list[i];
		list = newArray;
	}
}
