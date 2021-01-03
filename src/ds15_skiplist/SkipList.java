/*
 * 1. SkipList: 
 * 	-- 1 câu trúc dữ liệu bao gồm nhiều List xếp thành tầng
 * 	-- Tầng S0 chứa tất cả các tất cả các phần tử ba đầu
 * 	-- Các tầng từ S1 trở đi là 1 ramdom tập con của tầng trước đó
 * 	-- Trong java, skipList được hiện thực dưới dạng ConcurrentSkipListMap hoặc 
 * 		ConcurrentSkipListSet
 * 2. Các thao tác:
 * 	-- O(1)		: size(), isEmpty(), firstEntry(), lastEntry()
 * 	-- O(logn)	: get(), put(), remove(), 
 * 					ceilingEntry(), floorEntry(), lowerEntry(), higherEntry()
 * 	-- O(logn+s): subMap() - s là số phần tử tập con cần truy vấn
 * 	-- O(n)		: entrySet(), keySet()
 * 
 * 3. Tốt:	
 * 	-- SkipList là bước tiếp hoá của cấu trúc map, tận dụng được ưu thế di chuyển dễ dàng
 * 		giữa các entry, đồng thời tận dụng không gian 2 chiều để nhảy bước, bỏ qua các 
 * 		entry không cần thiết để đến đích
 * 
 * 4. Xấu:
 * 	-- Hơi tốn không gian lưu trữ. Bở việc random các tầng con khác nhau từ tầng ban đầu.
 * 	-- Chi phí không gian mong đợi là O(n)
 * 
 * 5. Ứng dụng:
 * 	-- SkipList hỗ trợ hiệu quả các thao tác search(), remove() so với HashTable
 * 		
 */

/**
 * @author Pham Ngoc Thuc
 */
package ds15_skiplist;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class SkipList<K, V> extends ConcurrentSkipListMap<K, V> {
	private static final long serialVersionUID = 1L;

	public SkipList() {

	}

	@Override
	public int size() {
		return super.size();
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

	@Override
	public V get(Object key) {
		return super.get(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		super.putAll(m);
	}

	@Override
	public V remove(Object key) {
		return super.remove(key);
	}

	@Override
	public Entry<K, V> firstEntry() {
		return super.firstEntry();
	}

	@Override
	public Entry<K, V> lastEntry() {
		return super.lastEntry();
	}

	@Override
	public ConcurrentNavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
		return super.subMap(fromKey, fromInclusive, toKey, toInclusive);
	}
	
	
}
