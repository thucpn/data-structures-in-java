/*
 * 	-- Trong thực tế, có nhiều trường hợp Stack, Queue, Deque không đáp ứng được yêu cầu 
 * 		thao tác dữ liệu ở vị trí tuỳ ý. Chẳng hạn như khi khách hàng ở giữa không muốn 
 * 		chờ nữa mà rời hàng hoặc 1 đại gia lấn 1 bà già lên trên. Do đó người ta phải tạo
 * 		ra 1 cấu trúc dữ liệu mới có sự ưu tiên. Yếu tố ưu tiên tuỳ vào quyết định của 
 * 		người lập trình. Ví dụ, để quản lí thứ tự các chuyến bay hạ cánh thì phải tuỳ
 * 		thuộc vào kích thước, sải cánh, độ dài của máy bay,...
 * 
 * 	-- Người ta sử dụng 1 cặp (K, V) để biểu diễn cho cấu trúc dữ liệu này. Trong đó K là 	
 * 		1 số nguyên. Với K càng nhỏ thì đối tượng tại ví trí đó càng có độ ưu tiên cao
 * 
 *  -- UnsortedPriorityQueue: Hiện thuật hoá Hàng đợi ưu tiên dựa trên Unsorted List
 * 	
 * 	-- Các thao tác:
 * 		O(1)		: size(), isEmpty(), insert()
 * 		O(n)		: min(), removeMin()
 * 	
 */
package ds10_priority_queue;

import java.util.Comparator;

import ds06_arraylist.Position;

/**
 * An implementation of a priority queue with an unsorted list.
 *
 * @author Pham Ngoc Thuc
 */
public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
	/** primary collection of priority queue entries */
	private PositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

	/**
	 * Creates an empty priority queue based on the natural ordering of its keys.
	 */
	public UnsortedPriorityQueue() {
		super();
	}

	/**
	 * Creates an empty priority queue using the given comparator to order keys.
	 * 
	 * @param comp comparator defining the order of keys in the priority queue
	 */
	public UnsortedPriorityQueue(Comparator<K> comp) {
		super(comp);
	}

	/**
	 * Returns the Position of an entry having minimal key. This should only be
	 * called on a nonempty priority queue
	 * 
	 * @return Position of entry with minimal key
	 */
	private Position<Entry<K, V>> findMin() { // only called when nonempty
		Position<Entry<K, V>> small = list.first();
		for (Position<Entry<K, V>> walk : list.positions())
			if (compare(walk.getElement(), small.getElement()) < 0)
				small = walk; // found an even smaller key
		return small;
	}

	/**
	 * Inserts a key-value pair and returns the entry created.
	 * 
	 * @param key   the key of the new entry
	 * @param value the associated value of the new entry
	 * @return the entry storing the new key-value pair
	 * @throws IllegalArgumentException if the key is unacceptable for this queue
	 */
	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key); // auxiliary key-checking method (could throw exception)
		Entry<K, V> newest = new PQEntry<>(key, value);
		list.addLast(newest);
		return newest;
	}

	/**
	 * Returns (but does not remove) an entry with minimal key.
	 * 
	 * @return entry having a minimal key (or null if empty)
	 */
	@Override
	public Entry<K, V> min() {
		if (list.isEmpty())
			return null;
		return findMin().getElement();
	}

	/**
	 * Removes and returns an entry with minimal key.
	 * 
	 * @return the removed entry (or null if empty)
	 */
	@Override
	public Entry<K, V> removeMin() {
		if (list.isEmpty())
			return null;
		return list.remove(findMin());
	}

	/**
	 * Returns the number of items in the priority queue.
	 * 
	 * @return number of items
	 */
	@Override
	public int size() {
		return list.size();
	}
}
