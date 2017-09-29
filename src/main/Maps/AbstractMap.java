package Maps;

import java.util.Iterator;
import java.util.Map.Entry;

public abstract class AbstractMap<K, V> implements Map<K, V>{
	
	public boolean isEmpty(){return size() == 0;}
	
	protected static class MapEntry<K, V> implements Entry<K,V>{
		K key;
		V value;
		
		public MapEntry(K k, V v){
			key = k;
			value = v;
		}
		
		@Override
		public K getKey() {
			return key;
		}
		
		@Override
		public V getValue() {
			return value;
		}
		
		@Override
		public V setValue(V value) {
			V temp = this.value;
			this.value = value;
			return temp;
		}
		
		public void setKey(K k){
			key = k;
		}
	}
	private class KeyIterator implements Iterator<K>{

		Iterator<MapEntry<K, V>> buffer = entries().iterator();
		
		@Override
		public boolean hasNext() {
			return buffer.hasNext();
		}

		@Override
		public K next() {
			return buffer.next().getKey();
		}
		
		@Override
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
	
	private class KeyIterable implements Iterable<K>{

		@Override
		public Iterator<K> iterator() {
			return new KeyIterator();
		}
	}
	
	public Iterable<K> keySet(){
		return new KeyIterable();
	}
	
	private class ValueIterator implements Iterator<V>{

		Iterator<MapEntry<K, V>> buffer = entries().iterator();
		
		@Override
		public boolean hasNext() {
			return buffer.hasNext();
		}

		@Override
		public V next() {
			return buffer.next().getValue();
		}
		
		public void remove(){
			throw new UnsupportedOperationException("removing values while iterating through a value set is an unsupported operation");
		}
	}
	
	private class ValueIterable implements Iterable<V>{
		
		public Iterator<V> iterator(){
			return new ValueIterator();
		}
	}
	
	public Iterable<V> values(){
		return new ValueIterable();
	}
}
