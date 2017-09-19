package stackQueueDequeue;

public class ArrayStack<E> implements Stack<E> {

	public static final int CAPACITY = 1000;
	private E[] stack;
	private int size = 0;
	
	// initialize an empty Array stack with capacity 1000
	public ArrayStack(){
		stack = (E[])new Object[CAPACITY];
	}
	
	public ArrayStack(int capacity){
		stack = (E[])new Object[capacity];
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
	public void push(E e) throws IllegalStateException {
		if(size == stack.length)
			throw new IllegalStateException("Stack is full");
		stack[size] = e;
		size++;	
	}

	@Override
	public E top() {
		if(isEmpty()) return null;
		return stack[size-1];
	}

	@Override
	public E pop() throws IllegalStateException{
		if(isEmpty())
			throw new IllegalStateException("Stack is empty");
		E value = stack[size-1];
		stack[size-1] = null;
		size--;
		return value;
	}
}
