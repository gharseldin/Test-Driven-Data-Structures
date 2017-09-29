package Maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedTableMap<K, V> extends AbstractMap<K,V>{

	private ArrayList<MapEntry<K,V>> map;
	
	public UnsortedTableMap(){
		map = new ArrayList<>();
	}
	
	private int findIndex(K key){
		int index = -1;
		for(int i = 0; i<map.size(); i++)
			if(map.get(i).getKey() == key)
				index = i;
		return index;
	}
	
	@Override
	public int size() {
		return map.size();
	}

	@Override
	public V get(K key) {
		int index = findIndex(key);
		if(index == -1)
			return null;
		else
			return map.get(index).getValue();
	}

	@Override
	public V put(K key, V value) {
		int index = findIndex(key);
		V returnValue;
		if(index == -1){
			returnValue = null;
			map.add(new MapEntry<K, V>(key, value));
		} else {
			returnValue = map.get(index).getValue();
			map.set(index, new MapEntry<K, V>(key, value));
		}
		return returnValue;
	}

	@Override
	public V remove(K key) {
		int index = findIndex(key);
		int n = map.size();
		if(index == -1)
			return null;
		V value = map.get(index).getValue();
		map.set(index, map.get(n-1));
		map.remove(n-1);
		return value;
	}

	private class EntriesIterator implements Iterator<MapEntry<K, V>>{

		int iterator = 0;
		
		@Override
		public boolean hasNext() {
			return iterator < map.size();
		}

		@Override
		public Maps.AbstractMap.MapEntry<K, V> next() {
			if (iterator == map.size()) throw new NoSuchElementException();
			return map.get(iterator++);
		}
		
		public void remove(){
			throw new UnsupportedOperationException("Remove Operation is not supported on the Entry Iterator");
		}
	}
	
	private class EntriesIterable implements Iterable<MapEntry<K,V>>{
		public Iterator<Maps.AbstractMap.MapEntry<K, V>> iterator(){
			return new EntriesIterator();
		}
	}
	@Override
	public Iterable<Maps.AbstractMap.MapEntry<K, V>> entries() {
		return new EntriesIterable();
	}

}
