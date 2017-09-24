package PriorityQueue;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V>{

	protected static class PQEntry<K,V> implements Entry<K,V>{
		K key;
		V value;
		
		public PQEntry(K k, V v){
			key = k;
			value = v;
		}
		
		public K getKey(){ return key;}
		public V getValue(){return value;}
		protected void setKey(K k){
			key = k;
		}
		protected void setValue(V v){
			value = v;
		}
	}

	private Comparator<K> comp;
	
	protected AbstractPriorityQueue(Comparator<K> c){
		comp = c;
	}
	protected AbstractPriorityQueue(){
		this(new DefaultComparator<>());
	}
	
	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	protected boolean checkKey(K key) throws IllegalArgumentException{
		try{
			return (comp.compare(key, key)==0);	// see if it is comparable
		}catch (ClassCastException e){
			throw new IllegalArgumentException("Incompatible key");
		}
	}
}
