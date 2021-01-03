package ds12_unsorted_map;

import java.util.Iterator;

import ds10_priority_queue.Entry;

/**
 * @author Pham Ngoc Thuc
 */
public abstract class AbstractMap<K, V> implements Map<K, V> {

	/**
	 * Tests whether the map is empty.
	 * 
	 * @return true if the map is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	// ---------------- nested MapEntry class ----------------
	/**
	 * A concrete implementation of the Entry interface to be used within a Map
	 * implementation.
	 */
	protected static class MapEntry<K, V> implements Entry<K, V> {
		private K k; // key
		private V v; // value

		public MapEntry(K key, V value) {
			k = key;
			v = value;
		}

		// public methods of the Entry interface
		public K getKey() {
			return k;
		}

		public V getValue() {
			return v;
		}

		// utilities not exposed as part of the Entry interface
		protected void setKey(K key) {
			k = key;
		}

		public V setValue(V value) {
			V old = v;
			v = value;
			return old;
		}

		/** Returns string representation (for debugging only) */
		public String toString() {
			return "<" + k + ", " + v + ">";
		}
	} // ----------- end of nested MapEntry class -----------

	// Provides support for keySet() and values() methods, based upon
	// the entrySet() method that must be provided by subclasses

	// ---------------- nested KeyIterator class ----------------
	private class KeyIterator implements Iterator<K> {
		private Iterator<Entry<K, V>> entries = entrySet().iterator(); // reuse entrySet

		public boolean hasNext() {
			return entries.hasNext();
		}

		public K next() {
			return entries.next().getKey();
		} // return key!

		public void remove() {
			throw new UnsupportedOperationException("remove not supported");
		}
	} // ----------- end of nested KeyIterator class -----------

	// ---------------- nested KeyIterable class ----------------
	private class KeyIterable implements Iterable<K> {
		public Iterator<K> iterator() {
			return new KeyIterator();
		}
	} // ----------- end of nested KeyIterable class -----------

	/**
	 * Returns an iterable collection of the keys contained in the map.
	 *
	 * @return iterable collection of the map's keys
	 */
	@Override
	public Iterable<K> keySet() {
		return new KeyIterable();
	}

	// ---------------- nested ValueIterator class ----------------
	private class ValueIterator implements Iterator<V> {
		private Iterator<Entry<K, V>> entries = entrySet().iterator(); // reuse entrySet

		public boolean hasNext() {
			return entries.hasNext();
		}

		public V next() {
			return entries.next().getValue();
		} // return value!

		public void remove() {
			throw new UnsupportedOperationException("remove not supported");
		}
	} // ----------- end of nested ValueIterator class -----------

	// ---------------- nested ValueIterable class ----------------
	private class ValueIterable implements Iterable<V> {
		public Iterator<V> iterator() {
			return new ValueIterator();
		}
	} // ----------- end of nested ValueIterable class -----------

	/**
	 * Returns an iterable collection of the values contained in the map. Note that
	 * the same value will be given multiple times in the result if it is associated
	 * with multiple keys.
	 *
	 * @return iterable collection of the map's values
	 */
	@Override
	public Iterable<V> values() {
		return new ValueIterable();
	}
}
