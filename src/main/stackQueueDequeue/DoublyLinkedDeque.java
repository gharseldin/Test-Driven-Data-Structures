package stackQueueDequeue;

import LinkedLists.DoublyLinkedList;

public class DoublyLinkedDeque<E> implements Deque<E>{

	private DoublyLinkedList<E> deque = new DoublyLinkedList<>();
	@Override
	public int size() {
		return deque.size();
	}

	@Override
	public boolean isEmpty() {
		return deque.isEmpty();
	}

	@Override
	public E first() {
		return deque.first();
	}

	@Override
	public E last() {
		return deque.last();
	}

	@Override
	public void addFirst(E e) {
		deque.addFirst(e);
	}

	@Override
	public void addLast(E e) {
		deque.addLast(e);
	}

	@Override
	public E removeFirst() {
		return deque.removeFirst();
	}

	@Override
	public E removeLast() {
		return deque.removeLast();
	}

}
