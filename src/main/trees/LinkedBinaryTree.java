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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> root() {
		return position(root);
	}

	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInternal(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
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
	
	public void addLeft(Position<E> p, E e){
		
	}
	
	public void addRight(Position<E> p, E e){
		
	}
	
	public void set(Position<E> p, E e){
		
	}
	
	public void attach(Position<E> p , LinkedBinaryTree<E> leftTree, LinkedBinaryTree<E> rightTree){
		
	}
	
	public E remove(Position<E> p){
		
		return null;
	}
	
	private Position<E> position(Node<E> n){
		return n;
	}

}
