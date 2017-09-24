package trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ListIterators.Position;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

	private class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> posIterator = positions().iterator();
		public boolean hasNext() {return posIterator.hasNext();}
		public E next() { return posIterator.next().getElement();}
		public void remove(){posIterator.remove();}
	}
	
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
		Node<E> node = validate(p);
		return(node.getLeft() == null && node.getRight() == null);
	}

	@Override
	public boolean isRoot(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node == root();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
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
		Node<E> node = validate(p);
		E value = node.getElement();
		node.setElement(e);
		return value;
	}
	
	public void attach(Position<E> p , LinkedBinaryTree<E> leftTree, LinkedBinaryTree<E> rightTree) throws IllegalStateException{
		Node<E> node = validate(p);
		if(isInternal(p)) throw new IllegalArgumentException("The node must be a leaf");
		size = leftTree.size() + rightTree.size();
		Node<E> leftRoot = (Node<E>)leftTree.root();
		Node<E> rightRoot = (Node<E>)rightTree.root();
		node.setLeft(leftRoot);
		node.setRight(rightRoot);
		leftRoot.setParent(node);
		rightRoot.setParent(node);
		leftTree.root = null;
		leftTree.size = 0;
		rightTree.root = null;
		rightTree.size = 0;
	}
	
	public E remove(Position<E> p) throws IllegalStateException{
		Node<E> node = validate(p);
		if(numChildren(p) == 2)
			throw new IllegalStateException("p has two children");
		Node<E> child = (node.getLeft()!=null? node.getLeft():node.getRight());
		if(child!=null)
			child.setParent(node.getParent());
		if(node == root)
			root = child;
		else{
			Node<E> parent = node.getParent();
			if(node == parent.getLeft())
				parent.setLeft(child);
			else
				parent.setRight(child);
		}
		size--;
		E temp = node.getElement();
		node.setElement(null);
		node.setLeft(null);
		node.setRight(null);
		node.setParent(null);
		return temp;
			
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	@Override
	public Iterable<Position<E>> positions() {
		return preorder();
	}
	
	private Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if(!(p instanceof Node))
			throw new IllegalArgumentException();
		Node<E> node = (Node<E>)p;		// safe cast
		if(node.getParent() == node)	// defunct node
			throw new IllegalArgumentException();
		return node;
	}
	
	private void preorderSubTree(Position<E> p, List<Position<E>> snapshot){
		snapshot.add(p);
		for(Position<E> c : children(p))
			preorderSubTree(c, snapshot);
		
	}
	
	public Iterable<Position<E>> preorder(){
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty())
			preorderSubTree(root(), snapshot);
		return snapshot;
	}
	
	private void postOrderSubTree(Position<E> p, List<Position<E>> snapshot){
		for(Position<E> c : children(p))
			postOrderSubTree(c, snapshot);
		snapshot.add(p);
	}
	
	public Iterable<Position<E>> postorder(){
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty())
			postOrderSubTree(root(), snapshot);
		return snapshot;
	}
}
