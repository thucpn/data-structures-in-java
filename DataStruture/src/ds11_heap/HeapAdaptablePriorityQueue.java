/*
 * 1. HeapAdaptablePriorityQueue: Là heap nhưng thích nghi hơn với nhiều ứng dụng với các 
 * 		thao tác thêm xoá sửa tại bất kì vị trí nào
 * 	
 * 2. Các thao tác:
 * 	-- O(1)		: size(), min(), replaceValue()
 * 	-- O(logn)	: insert(), remove(), removeMin(), replaceKey()
 * 
 * 3. Tốt:	
 * 	--  Linh động trong việc xoá, sửa, đảo vị trí ưu tiên tại vị trí bất kì
 * 
 * 4. Xấu:
 * 	-- Chưa linh động trong việc xoá sửa thêm tại vị trí bất kì
 * 
 * 5. Ứng dụng:
 * 	--  Heap thông thường chỉ đáp ứng được nhu cầu xoá ở đầu nhưng trong thực tế dễ nảy sinh 
 * 		nhiều tình huống như sau:
 * 			+ 1 khách hàng bị nhầm thẻ thứ tự, do đó họ đã yêu cầu nhân viên xem xét và 
 * 				thay đổi lại thứ tự --> cần replaceKey()
 * 			+ 1 khách hàng muốn đổi vé một bà già --> cần phải replaceValue()
 * 			+ 1 khách hàng ở vị trí x gian lận, bị tống cổ khỏi hàng đợi --> cần phải remove()
 * 
 * 	-- Hàng đợi thích nghi ưu tiên đã đáp ứng được các nhu cầu trên với chi phí thấp: logn
 * 		
 */
package ds11_heap;

import java.util.Comparator;

//import ds10_priority_queue.AbstractPriorityQueue;
import ds10_priority_queue.Entry;

/**
 * An implementation of an adaptable priority queue using an array-based heap.
 *
 * @author Pham Ngoc Thuc
 */
public class HeapAdaptablePriorityQueue<K, V> extends HeapPriorityQueue<K, V> implements AdaptablePriorityQueue<K, V> {

	// ---------------- nested AdaptablePQEntry class ----------------
	/** Extension of the PQEntry to include location information. */
	protected static class AdaptablePQEntry<K, V> extends PQEntry<K, V> {
		private int index; // entry's current index within the heap

		public AdaptablePQEntry(K key, V value, int j) {
			super(key, value); // this sets the key and value
			index = j; // this sets the new field
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int j) {
			index = j;
		}
	} // ----------- end of nested AdaptablePQEntry class -----------

	/** Creates an empty adaptable priority queue using natural ordering of keys. */
	public HeapAdaptablePriorityQueue() {
		super();
	}

	/**
	 * Creates an empty adaptable priority queue using the given comparator to order
	 * keys.
	 * 
	 * @param comp comparator defining the order of keys in the priority queue
	 */
	public HeapAdaptablePriorityQueue(Comparator<K> comp) {
		super(comp);
	}

	// protected utilites
	/**
	 * Validates an entry to ensure it is location-aware.
	 * 
	 * @param entry an entry instance
	 * @return the entry cast as an AdaptablePQEntry instance
	 * @throws IllegalArgumentException if the given entry was not valid
	 */
	protected AdaptablePQEntry<K, V> validate(Entry<K, V> entry) throws IllegalArgumentException {
		if (!(entry instanceof AdaptablePQEntry))
			throw new IllegalArgumentException("Invalid entry");
		AdaptablePQEntry<K, V> locator = (AdaptablePQEntry<K, V>) entry; // safe
		int j = locator.getIndex();
		if (j >= heap.size() || heap.get(j) != locator)
			throw new IllegalArgumentException("Invalid entry");
		return locator;
	}

	/** Exchanges the entries at indices i and j of the array list. */
	@Override
	protected void swap(int i, int j) {
		super.swap(i, j); // perform the swap
		((AdaptablePQEntry<K, V>) heap.get(i)).setIndex(i); // reset entry's index
		((AdaptablePQEntry<K, V>) heap.get(j)).setIndex(j); // reset entry's index
	}

	/**
	 * Restores the heap property by moving the entry at index j upward/downward.
	 */
	protected void bubble(int j) {
		if (j > 0 && compare(heap.get(j), heap.get(parent(j))) < 0)
			upheap(j);
		else
			downheap(j); // although it might not need to move
	}
	// public methods

	/**
	 * Inserts a key-value pair and return the entry created.
	 * 
	 * @param key   the key of the new entry
	 * @param value the associated value of the new entry
	 * @return the entry storing the new key-value pair
	 * @throws IllegalArgumentException if the key is unacceptable for this queue
	 */
	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key); // might throw an exception
		Entry<K, V> newest = new AdaptablePQEntry<>(key, value, heap.size());
		heap.add(newest); // add to the end of the list
		upheap(heap.size() - 1); // upheap newly added entry
		return newest;
	}

	/**
	 * Removes the given entry from the priority queue.
	 *
	 * @param entry an entry of this priority queue
	 * @throws IllegalArgumentException if e is not a valid entry for the priority
	 *                                  queue.
	 */
	@Override
	public void remove(Entry<K, V> entry) throws IllegalArgumentException {
		AdaptablePQEntry<K, V> locator = validate(entry);
		int j = locator.getIndex();
		if (j == heap.size() - 1) // entry is at last position
			heap.remove(heap.size() - 1); // so just remove it
		else {
			swap(j, heap.size() - 1); // swap entry to last position
			heap.remove(heap.size() - 1); // then remove it
			bubble(j); // and fix entry displaced by the swap
		}
	}

	/**
	 * Replaces the key of an entry.
	 *
	 * @param entry an entry of this priority queue
	 * @param key   the new key
	 * @throws IllegalArgumentException if e is not a valid entry for the priority
	 *                                  queue.
	 */
	@Override
	public void replaceKey(Entry<K, V> entry, K key) throws IllegalArgumentException {
		AdaptablePQEntry<K, V> locator = validate(entry);
		checkKey(key); // might throw an exception
		locator.setKey(key); // method inherited from PQEntry
		bubble(locator.getIndex()); // with new key, may need to move entry
	}

	/**
	 * Replaces the value of an entry.
	 *
	 * @param entry an entry of this priority queue
	 * @param value the new value
	 * @throws IllegalArgumentException if e is not a valid entry for the priority
	 *                                  queue.
	 */
	@Override
	public void replaceValue(Entry<K, V> entry, V value) throws IllegalArgumentException {
		AdaptablePQEntry<K, V> locator = validate(entry);
		locator.setValue(value); // method inherited from PQEntry
	}
}
