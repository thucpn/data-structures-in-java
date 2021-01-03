package ds10_priority_queue;

/**
 * Interface for a key-value pair.
 *
 * @author Pham Ngoc Thuc
 */
public interface Entry<K, V> {
	/**
	 * Returns the key stored in this entry.
	 * 
	 * @return the entry's key
	 */
	K getKey();

	/**
	 * Returns the value stored in this entry.
	 * 
	 * @return the entry's value
	 */
	V getValue();
}
