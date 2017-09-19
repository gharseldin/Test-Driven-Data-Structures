package stackQueueDequeue;

import LinkedLists.CircularlyLinkedList;

public class LinkedCircularQueue<E> implements CircularQueue<E> {

	CircularlyLinkedList<E> queue;
	
	public LinkedCircularQueue(){
		queue = new CircularlyLinkedList<>();
	}
	
	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		queue.addLast(e);
	}

	@Override
	public E first() {
		return queue.first();
	}

	@Override
	public E dequeue() {
		return queue.removeFirst();
	}
	
	@Override
	public void rotate() {
		queue.rotate();
	}
}
