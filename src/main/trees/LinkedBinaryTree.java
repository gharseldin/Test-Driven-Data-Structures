package trees;

import java.util.Iterator;

import ListIterators.Position;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

	protected static class Node<E> implements Position<E>{
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		
		public Node(E e, Node<E> p, Node<E> l, Node<E> r){
			element = e;
			parent = p;
			left = l;
			right = r;
		}
		
		public E getElement() {return element;}
		public Node<E> getParent(){ return parent;}
		public Node<E> getLeft(){return left;}
		public Node<E> getRight(){return right;}
		
		public void setElement(E e){ element = e;}
		public void setParent(Node<E> p){parent = p;}
		public void setLeft(Node<E> l){left = l;}
		public void setRight(Node<E> r){right = r;}
		
	}
	
	protected Node<E> getNode(E e, Node<E> parent, Node<E> left, Node<E> right){
		return new Node<>(e, parent, left, right);
	}
	
	private int size = 0;
	private Node<E> root = null;	//initial empty Tree
	
	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getLeft();
	}

	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getRight();
	}

	@Override
	public Position<E> root() {
		return root;
	}

	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInternal(Position<E> p) throws IllegalArgumentException {
		Node<E> node  = validate(p);
		return (node.getLeft()!=null || node.getRight()!=null);
	}

	@Override
	public boolean isExternal(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRoot(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
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
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Position<E>> positions() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Update methods
	public Position<E> addRoot(E e) throws IllegalStateException{
		if(!isEmpty())
			throw new IllegalStateException("Tree is not empty");
		root = getNode(e, null, null, null);
		size++;
		return root;
		
	}
	
	public Position<E> addLeft(Position<E> p, E e){
		Node<E> parent = validate(p);
		Node<E> newest = getNode(e, parent, null, null);
		parent.setLeft(newest);
		size++;
		return newest;
	}
	
	public Position<E> addRight(Position<E> p, E e){
		Node<E> parent = validate(p);
		Node<E> newest = getNode(e, parent, null, null);
		parent.setRight(newest);
		size++;
		return newest;
	}
	
	public E set(Position<E> p, E e){
		return null;
	}
	
	public void attach(Position<E> p , LinkedBinaryTree<E> leftTree, LinkedBinaryTree<E> rightTree){
		
	}
	
	public E remove(Position<E> p){
		
		return null;
	}
	
	private Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if(!(p instanceof Node))
			throw new IllegalArgumentException();
		Node<E> node = (Node<E>)p;		// safe cast
		if(node.getParent() == node)	// defunct node
			throw new IllegalArgumentException();
		return node;
	}
	
	private Position<E> position(Node<E> n){
		return n;
	}

}
