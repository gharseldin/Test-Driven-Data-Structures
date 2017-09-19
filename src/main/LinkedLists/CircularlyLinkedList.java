package LinkedLists;

public class CircularlyLinkedList<E> {

	public static class Node<E> {
		E element;
		Node<E> next;
		
		public Node(E e, Node<E> n){
			element = e;
			next = n;
		}
		
		public E getElement() {return element;}
		public Node<E> getNext() { return next;}
		public void setNext(Node<E> n) {next = n;}
	}
	
	private int size;
	private Node<E> tail;
	
	public int size() {return size;}
	
	public boolean isEmpty() {return size==0;}
	
	public E first() {
		if(isEmpty()) return null;
		return tail.getNext().getElement();
	}
	
	public E last() {
		if(isEmpty()) return null;
		return tail.getElement();
	}
	
	public void rotate() {
		if(isEmpty()) return;
		tail = tail.getNext();
	}
	
	public void addFirst(E e) {
		Node<E> node = new Node<>(e, null);
		if(isEmpty()) 
			tail = node;
		else
			node.setNext(tail.getNext());
		tail.setNext(node);
		size++;
	}
	
	public void addLast(E e) {
		Node<E> node = new Node<>(e, null);
		if(isEmpty()) {
			tail = node;
			tail.setNext(node);
		}else {
			node.setNext(tail.getNext());
			tail.setNext(node);
			tail = node;
		}
		size++;
	}
	
	public E removeFirst() {
		if(isEmpty()) return null;
		E value = tail.getNext().getElement();
		tail.setNext(tail.getNext().getNext());
		size--;
		return value;
	}
	
}
