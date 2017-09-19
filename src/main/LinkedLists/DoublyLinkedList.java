package LinkedLists;

public class DoublyLinkedList<E> implements Cloneable{

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
	
	public boolean equals(Object o){
		if(o == null) return false;
		if(getClass() != o.getClass()) return false;
		DoublyLinkedList<E> other = (DoublyLinkedList<E>)o;
		Node<E> walkA = this.header;
		Node<E> walkB = other.header;
		while(walkA.getNext().getElement()!=null){
			if(walkA.getElement() != walkB.getElement())return false;
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		return true;
	}
	
	public DoublyLinkedList<E> clone() throws CloneNotSupportedException{
		DoublyLinkedList<E> other  = (DoublyLinkedList<E>)super.clone();
		if(size > 0){
			other.header = new Node<>(null, null, null);
			other.trailer = new Node<>(null, other.header, null);
			other.header.setNext(trailer);
			
			Node<E> walk = header;
			Node<E> last = other.header;
			// iterate till the end
			while(walk.getNext().getElement() != null){
				walk = walk.getNext();
				other.addBetween(walk.getElement(), last, other.trailer);
				last = last.getNext();
			}
		}
		return other;
	}
	
	public String printFromFrontToEnd(){
		String result = "";
		Node<E> walk = header;
		result += ("{ ");
		while(walk.getNext().getElement() != null){
			walk = walk.getNext();
			result += (walk.getElement() + " ");
		}
		result += ("}");
		return result;
	}
	
	public String printFromEndToFront(){
		String result = "";
		Node<E> walk = trailer;
		result += ("{ ");
		while(walk.getPrev().getElement()!=null){
			walk = walk.getPrev();
			result += (walk.getElement() + " ");
		}
		result += ("}");
		return result;
	}
}
