/**
 * 
 */

import java.util.Map.Entry;

/**
 * 
 */
public class MapEntry<K, V> implements Entry<K, V> {
	private K key;
	private V value;
	
	

	/**
	 * @param key
	 * @param value
	 */
	public MapEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(K key) {
		this.key = key;
	}

	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public V setValue(V value) {
		// TODO Auto-generated method stub
		V old = this.value;
		this.value = value;
		return old;
	}

}
