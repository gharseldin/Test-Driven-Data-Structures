package ListIterators;

public interface PositionalList<E> {
	
	int size();
	
	int isEmpty();
	
	Position<E> first();
	
	Position<E> last();
	
	Position<E> before(Position<E> p);
	
	Position<E> after(Position<E> p);
	
	Position<E> addFirst(E e);
	
	Position<E> addLast(E e);
	
	Position<E> addBEfore(Position<E> p, E e);
	
	Position<E> addAfter(Position<E> p, E e);
	
	E set(Position<E> p , E e);
	
	E remove(Position<E> p);

}
