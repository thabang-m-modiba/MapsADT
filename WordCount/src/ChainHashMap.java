/**
 * @author Thabang Mamoloko
 */

import java.util.ArrayList;
import java.util.Map.Entry;

/**
 * 
 */
public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
	private UnsortedTableMap<K, V>[] table;
	
	/**
	 * Reference to super constructor
	 */
	public ChainHashMap() {
		super();
	}
	
	/**
	 * Reference to super constructor
	 * @param capacity
	 */
	public ChainHashMap(int capacity) {
		super(capacity);
	}
	
	/**
	 * Reference to super constructor
	 * @param capacity
	 * @param prime
	 */
	public ChainHashMap(int capacity, int prime) {
		super(capacity, prime);
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		ArrayList<Entry<K, V>> buffer = new ArrayList<>();
		for(int h = 0; h < capacity; h++) {
			if(table[h] != null) {
				for(Entry<K, V> entry : table[h].entrySet()) {
					buffer.add(entry);
				}
			}
		}
		return buffer;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void createTable() {
		// TODO Auto-generated method stub
		table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];

	}

	@Override
	protected V bucketGet(Object hashValue, K key) {
		// TODO Auto-generated method stub
		UnsortedTableMap<K, V> bucket = table[(int) hashValue];
		if(bucket == null) {
			return null;
		}
		return bucket.get(key);
	}

	@Override
	protected V bucketPut(Object hashValue, K key, V value) {
		// TODO Auto-generated method stub
		UnsortedTableMap<K, V> bucket = table[(int) hashValue];
		if(bucket == null) {
			bucket = table[(int) hashValue] = new UnsortedTableMap<>();
		}
		int oldSize = bucket.size();
		V answer = bucket.put(key, value);
		n += (bucket.size() - oldSize);
		return answer;
	}

	@Override
	protected V bucketRemove(Object hashValue, K key) {
		// TODO Auto-generated method stub
		UnsortedTableMap<K, V> bucket = table[(int) hashValue];
		if(bucket == null) {
			return null;
		}
		int oldSize = bucket.size();
		V answer = bucket.remove(key);
		n -= (oldSize - bucket.size());
		return answer;
	}

}
