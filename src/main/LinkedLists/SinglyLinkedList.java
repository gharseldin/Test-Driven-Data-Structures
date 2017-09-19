package LinkedLists;

public class SinglyLinkedList <E> {
	
	
	// Internal node class
	public static class Node<E> {
		E element;
		Node<E> next;
		
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		
		public Node<E> getNext(){
			return next;
		}
		
		public E getElement() {
			return element;
		}
		
		public void setNext(Node<E> n) {
			next = n;
		}
	}

	
	int size = 0;
	Node<E> head = null;
	Node<E> tail = null;
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public E first(){
		if(isEmpty())
			return null;
		return head.getElement();
	}
	
	public E last(){
		if(isEmpty())
			return null;
		return tail.getElement();
	}
	
	public void addFirst(E element){
		Node<E> node = new Node<>(element, head);
		head = node;
		if(isEmpty())
			tail = node;
		size++;
	}
	
	public void addLast(E element){
		Node<E> node = new Node<>(element, null);
		if(isEmpty()) 
			head = node;
		 else
			tail.setNext(node);
		tail = node;
		size++;
	}
	
	public E removeFirst(){
		if(isEmpty())
			return null;
		E value = head.getElement();
		head = head.getNext();
		//in case this was the last element
		if(head == null)
			tail = null;
		size--;
		return value;
	}
}
