/**
 * @author Thabang Mamoloko
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

/**
 * 
 */
public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
	private ArrayList<MapEntry<K, V>> table = new ArrayList<>();
	
	/**
	 * constructor
	 */
	public UnsortedTableMap() {}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return table.size();
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		int i = findIndex(key);
		if(i == -1) {
			return null;
		}
		return table.get(i).getValue();
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		int i = findIndex(key);
		if(i == -1) {
			table.add(new MapEntry<>(key, value));
			return null;
		}else {
			return table.get(i).setValue(value);
		}
		
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		int i = findIndex(key);
		int n = size();
		if(i == -1) {
			return null;
		}
		V answer = table.get(i).getValue();
		if(i != n - 1) {
			table.set(i, table.get(n - 1));
		}
		table.remove(n - 1);
		return answer;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return new EntryIterable();
	}
	
	/**
	 * Method to get index for the specified key
	 * @param key - The key of interest""
	 * @return - return the key index if it exists, return -1 if it does not exist
	 */
	private int findIndex(K key) {
		int n = table.size();
		for(int j = 0; j < n; j ++) {
			if(table.get(j).getKey().equals(key)) {
				return j;
			}
		}
		return -1;
	}
	
	/**
	 * 
	 */
	private class EntryIterator implements Iterator<Entry<K, V>>{
		private int i = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i < table.size();
		}

		@Override
		public Entry<K, V> next() {
			// TODO Auto-generated method stub
			if(i == table.size()) {
				throw new NoSuchElementException("Element foes not exist");
			}
			return table.get(i++);
		}
		
		/**
		 * Removal not allowed
		 */
		public void remove() {
			throw new UnsupportedOperationException("Remova not allowed");
		}
		
	}
	
	private class EntryIterable implements Iterable<Entry<K, V>>{

		@Override
		public Iterator<Entry<K, V>> iterator() {
			// TODO Auto-generated method stub
			return new EntryIterator();
		}
		
	}

}
