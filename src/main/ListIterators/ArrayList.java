package ListIterators;

public class ArrayList<E> implements List<E> {

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
	public E remove(int i, E e) throws IndexOutOfBoundsException {
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
}
