/**
 * @author Thabang Mamoloko
 */

import java.util.Map.Entry;

/**
 * Interface contains methods for the implementation of the Map ADT
 */
public interface Map<K, V> {
	/**
	 * The method to return the number of entries in the map M
	 * @return int etries
	 */
	int size();
	
	
	/**
	 * Method to determine whether the map M is empty
	 * @return true if empty and false is not
	 */
	boolean isEmpty();
	
	
	/**
	 * Method to return the value V associated with the specified key V
	 * @param key - The specified key
	 * @return value V
	 */
	V get(K key);
	
	
	/**
	 * Method to replace with the specified value V, the value at the specified key K
	 * @param key - Key associated with a value to replace
	 * @param value - The new value to add
	 * @return the replaced value
	 */
	V put(K key, V value);
	
	
	/**
	 * Method to remove the value associated with the specified key V
	 * @param key - The key of the value to be removed
	 * @return the removed value V
	 */
	V remove(K key);
	
	
	/**
	 * Method to return an iterable collection of all keys stored in map M
	 * @return an iterable collection of Keys
	 */
	Iterable<K> keySet();
	
	
	/**
	 * Method to return an iterable collections of value entries in map M
	 * @return collection of Values V
	 */
	Iterable<V> values();
	
	
	/**
	 * Method to return an iterable collection of key-value entries in map M
	 * @return
	 */
	Iterable<Entry<K, V>> entrySet();
}
