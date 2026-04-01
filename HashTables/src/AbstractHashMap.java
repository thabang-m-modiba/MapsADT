/**
 * @author Thabang Mamoloko
 */

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Random;

/**
 * 
 */
public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
	protected int n = 0; // Number of entries
	protected int capacity; // length of the table
	private int prime; // Prime factor
	private long scale;
	private long shift;

	/**
	 * @param capacity
	 * @param prime
	 */
	public AbstractHashMap(int capacity, int prime) {
		this.capacity = capacity;
		this.prime = prime;
		
		Random rand = new Random();
		scale = rand.nextInt(prime - 1) + 1;
		shift = rand.nextInt(prime);
		createTable();
	}
	
	/**
	 * Constructor
	 * @param capacity
	 */
	public AbstractHashMap(int capacity) {
		this(capacity, 109345121); // Default prime
	}
	
	/**
	 * Default constructor
	 */
	public AbstractHashMap() {
		this(17); // Default capacity
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return bucketGet(hashValue(key), key);
	}	

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		V answer = bucketPut(hashValue(key), key, value);
		if(n > capacity/2) {
			resize(2*capacity-1);
		}
		return answer;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return bucketRemove(hashValue(key), key);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	private Object hashValue(K key) {
		// TODO Auto-generated method stub
		return (int) ((Math.abs(key.hashCode()*scale + shift) % prime) % capacity);
	}
	
	/**
	 * 
	 * @param i
	 */
	private void resize(int newCap) {
		// TODO Auto-generated method stub
		ArrayList<Entry<K, V>> buffer = new ArrayList<>(n);
		for(Entry<K, V> e : entrySet()) {
			buffer.add(e);
		}
		capacity = newCap;
		createTable();
		n = 0;
		for(Entry<K, V> e : buffer) {
			put(e.getKey(), e.getValue());
		}
	}

	protected abstract void createTable();
	protected abstract V bucketGet(Object hashValue, K key);
	protected abstract V bucketPut(Object hashValue, K key, V value);
	protected abstract V bucketRemove(Object hashValue, K key);

}
