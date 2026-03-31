/**
 * @author Thabang Mamoloko
 */

import java.util.Iterator;
import java.util.Map.Entry;

/**
 * Abstract implements some of the methods in Map
 */
public abstract class AbstractMap<K, V> implements Map<K, V>{
	
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
	
	@Override
	public Iterable<K> keySet(){
		return new KeyIterable();
	}
	
	@Override
	public Iterable<V> values(){
		return new ValueIterable();
	}
	
	/**
	 * 
	 */
	private class KeyIterator implements Iterator<K>{
		private Iterator<Entry<K, V>> entries = entrySet().iterator();

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return entries.hasNext();
		}

		@Override
		public K next() {
			// TODO Auto-generated method stub
			return entries.next().getKey();
		}
		
		/**
		 * Removal is not supported
		 */
		public void remove() {
			throw new UnsupportedOperationException("Removal Not Supported!");
		}
		
	}
	
	/**
	 * 
	 */
	private class KeyIterable implements Iterable<K>{

		@Override
		public Iterator<K> iterator() {
			// TODO Auto-generated method stub
			return new KeyIterator();
		}
		
	}
	
	private class ValueIterator implements Iterator<V>{
		private Iterator<Entry<K, V>> entries = entrySet().iterator();

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return entries.hasNext();
		}

		@Override
		public V next() {
			// TODO Auto-generated method stub
			return entries.next().getValue();
		}
		
		/**
		 * Removal not supported
		 */
		public void remove() {
			throw new UnsupportedOperationException("Removal Not Supported!");
		}
		
	}
	
	private class ValueIterable implements Iterable<V>{

		@Override
		public Iterator<V> iterator() {
			// TODO Auto-generated method stub
			return new ValueIterator();
		}
		
	}
}
