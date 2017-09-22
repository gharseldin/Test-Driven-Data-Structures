package ListIterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E> {


	private class PositionIterator implements Iterator<Position<E>>{
		
		private Position<E> cursor = first();
		private Position<E> recent = null;
		
		@Override
		public boolean hasNext() {
			return cursor != null;
		}

		@Override
		public Position<E> next() {
			if(cursor == null)
				throw new NoSuchElementException("nothing left");
			recent = cursor;
			cursor = after(cursor);
			return recent;
		}

		@Override
		public void remove() {
			if(recent == null)
				throw new IllegalStateException("Nothing to remove");
			
			LinkedPositionalList.this.remove(recent);
			recent = null;
		}
	}
	
	private class PositionIterable implements Iterable<Position<E>>{
		public Iterator<Position<E>> iterator() { return new PositionIterator();}
	}
	
	public Iterable<Position<E>> positions(){
		return new PositionIterable();
	}
	
	private class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> posIterator = new PositionIterator();
	
		@Override
		public boolean hasNext() {
			return posIterator.hasNext();
		}

		@Override
		public E next() {
			return posIterator.next().getElement();
		}
		
		public void remove(){
			posIterator.remove();
		}	
	}
	
	public Iterator<E> iterator(){ return new ElementIterator();}
	
	public static class Node<E> implements Position<E>{

		private E element;
		private Node<E> prev;
		private Node<E> next;
		
		public Node(E e, Node<E> p, Node<E> n){
			element = e;
			prev = p;
			next = n;
		}
		
		@Override
		public E getElement() throws IllegalStateException {
			if(next == null)	// convention for defunct node;
				throw new IllegalStateException();
			return element;
		}
		
		public void setElement(E e){
			element = e;
		}
		
		public Node<E> getPrev(){
			return prev;
		}
		
		public Node<E> getNext(){
			return next;
		}
		
		public void setPrev(Node<E> p){
			prev = p;
		}
		
		public void setNext(Node<E> n){
			next = n;
		}
	}
	
	private int size = 0;
	private Node<E> header;
	private Node<E> trailer;
	
	public LinkedPositionalList(){
		header = new Node(null, null, null);
		trailer = new Node(null, header, null);
		header.setNext(trailer);
	}
	
	private Node<E> validate(Position<E> p){
		if(p.getClass() != Node.class)
			throw new IllegalArgumentException(" Invalid P ");
		Node<E> n = (Node<E>)p; //safe cast
		if(n.getNext()==null || n==header)
			throw new IllegalArgumentException(" P is no longer in the list ");
		return n;
	}
	private Position<E> position(Node<E> node){
		if(node == header || node == trailer)
			return null;
		return node;
	}
	
	private Position<E> addBetween(E e, Node<E> prev, Node<E> next){
		Node<E> node = new Node<>(e, prev, next);
		prev.setNext(node);
		next.setPrev(node);
		size++;
		return node;
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public Position<E> first() {
		return position(header.getNext());
	}

	@Override
	public Position<E> last() {
		return position(trailer.getPrev());
	}

	@Override
	public Position<E> before(Position<E> p)  throws IllegalArgumentException{
		Node<E> n = validate(p);
		return position(n.getPrev());
	}

	@Override
	public Position<E> after(Position<E> p)  throws IllegalArgumentException{
		Node<E> n = validate(p);
		return position(n.getNext());
	}

	@Override
	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}

	@Override
	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}

	@Override
	public Position<E> addBefore(Position<E> p, E e)  throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node );
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e)  throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	@Override
	public E set(Position<E> p, E e)  throws IllegalArgumentException{
		Node<E> node = validate(p);
		E value = node.getElement();
		node.setElement(e);
		return value;
	}

	@Override
	public E remove(Position<E> p)  throws IllegalArgumentException{
		Node<E> node = validate(p);
		E value = node.getElement();
		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());
		node.setElement(null);
		node.prev = null;
		node.next = null;	//defunct
		size--;
		return value;
	}
	

}
