/**
 * @author Thabang Mamoloko
 */

import java.util.ArrayList;
import java.util.Map.Entry;

/**
 * 
 */
public class ProbeHashMap<K, V> extends AbstractHashMap<K, V> {
	private MapEntry<K, V>[] table;
	private MapEntry<K, V> DEFUNCT = new MapEntry<K, V>(null, null);
	
	/**
	 * Reference to the super default constructor
	 */
	public ProbeHashMap() {
		super();
	}
	
	/**
	 * Reference to super constructor
	 * @param capacity
	 */
	public ProbeHashMap(int capacity) {
		super(capacity);
	}
	
	/**
	 * Reference to the super constructor
	 * @param capacity
	 * @param prime
	 */
	public ProbeHashMap(int capacity, int prime) {
		super(capacity, prime);
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		ArrayList<Entry<K, V>> buffer = new ArrayList<>();
		for(int h = 0; h < capacity; h++) {
			if(!isAvailable(h)) {
				buffer.add(table[h]);
			}
		}
		return buffer;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void createTable() {
		// TODO Auto-generated method stub
		table = (MapEntry<K, V>[]) new MapEntry[capacity];
	}

	@Override
	protected V bucketGet(Object hashValue, K key) {
		// TODO Auto-generated method stub
		int i = findSlot((int)hashValue, key);
		if(i < 0) {
			return null;
		}
		return table[i].getValue();
	}

	@Override
	protected V bucketPut(Object hashValue, K key, V value) {
		// TODO Auto-generated method stub
		int i = findSlot((int)hashValue, key);
		if(i >= 0) {
			return table[i].setValue(value);
		}
		table[-(i + 1)] = new MapEntry<>(key, value);
		n++;
		return null;
	}

	@Override
	protected V bucketRemove(Object hashValue, K key) {
		// TODO Auto-generated method stub
		int i = findSlot((int)hashValue, key);
		if(i < 0) {
			return null;
		}
		V answer = table[i].getValue();
		table[i] = DEFUNCT;
		n--;
		return answer;
	}
	
	/**
	 * Method return true if location is either empty or the "defucnt" sentinel
	 * @param j
	 * @return
	 */
	private boolean isAvailable(int i) {
		return (table[i] == null || table[i] == DEFUNCT);
	}
	
	/**
	 * Method returns index with key k, or -(a + 1) such that k could be added at index a
	 * @param h
	 * @param k
	 * @return
	 */
	private int findSlot(int h, K k) {
		int avail = -1;
		int i = h;
		do {
			if(isAvailable(i)) {
				if(avail == -1) {
					avail = i;
				}
				if(table[i] == null) {
					break;
				}
			}else if(table[i].getKey().equals(k)) {
				return i;
			}
		    i = (i + 1) % capacity;
		}while(i != h);
		return -(avail + 1);
	}

}
