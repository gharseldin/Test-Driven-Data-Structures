package stackQueueDequeue;

public class ArrayQueue<E> implements Queue<E> {

	public static final int CAPACITY = 1000;
	private E[] queue;
	private int first = 0;
	private int size = 0;
	
	public ArrayQueue(){
		queue = (E[])new Object[CAPACITY];
	}
	
	public ArrayQueue(int capacity){
		queue = (E[])new Object[capacity];
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
	public void enqueue(E e) throws IllegalStateException {
		if(size == queue.length)
			throw new IllegalStateException("Queue is full");
		queue[(size+first)%queue.length] = e;
		size++;
	}

	@Override
	public E first() {
		if(isEmpty()) return null;
		return queue[first];
	}

	@Override
	public E dequeue() {
		if(isEmpty()) return null;
		E value = queue[first];
		queue[first] = null;
		first = (first + 1)% queue.length;
		size--;
		return value;
	}
	
}
