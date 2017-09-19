package LinkedLists;

public class DoublyLinkedList<E> {

	public static class Node<E>{
		E element;
		Node<E> prev;
		Node<E> next;
		
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}
		
		public E getElement(){
			return element;
		}
		public Node<E> getPrev(){
			return prev;
		}
		public Node<E> getNext(){
			return next;
		}
		public void setNext(Node<E> n) {
			next = n;
		}
		public void setPrev(Node<E> p) {
			prev = p;
		}
	}
	
	private int size;
	// two sentinels
	private Node<E> header;
	private Node<E> trailer;
	
	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<E>(null, header, null);
		header.setNext(trailer);
	}
	
	public int size() {return size;}
	
	public boolean isEmpty() { return size==0;}
	
	public E first() {
		if(isEmpty()) return null;
		return header.getNext().getElement();
	}
	
	public E last() {
		if(isEmpty()) return null;
		return trailer.getPrev().getElement();
	}
	
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}
	
	public void addLast(E e) {
		addBetween(e, trailer.prev, trailer);
	}
	
	public E removeFirst() {
		if(isEmpty()) return null;
		return remove(header.getNext()); 

	}
	
	public E removeLast() {
		if(isEmpty()) return null;
		return remove(trailer.getPrev());
	}
	
	private void addBetween(E e, Node<E> prev, Node<E> next) {
		Node<E> node = new Node<>(e, prev, next);
		next.setPrev(node);
		prev.setNext(node);
		size++;
	}
	
	private E remove(Node<E> node) {
		E value = node.getElement();
		node.getNext().setPrev(node.prev);
		node.getPrev().setNext(node.next);
		size--;
		return value;
	}
}
