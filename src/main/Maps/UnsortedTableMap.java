package Maps;

import java.util.ArrayList;

public class UnsortedTableMap<K, V> extends AbstractMap<K,V>{

	private ArrayList<MapEntry<K,V>> map;
	
	public UnsortedTableMap(){
		map = new ArrayList<>();
	}
	
	@Override
	public int size() {
		return map.size();
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Maps.AbstractMap.MapEntry<K, V>> entries() {
		// TODO Auto-generated method stub
		return null;
	}

}
