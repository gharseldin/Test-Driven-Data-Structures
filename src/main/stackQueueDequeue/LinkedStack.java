package stackQueueDequeue;

import LinkedLists.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {

	private SinglyLinkedList<E> stack = new SinglyLinkedList<>();

	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public boolean isEmpty() {
		return stack.size() == 0;
	}

	@Override
	public void push(E e) {
		stack.addFirst(e);
	}

	@Override
	public E top() {
		return stack.first(); 
	}

	@Override
	public E pop() {
		return stack.removeFirst();
	}
	
}
