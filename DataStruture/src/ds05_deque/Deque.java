/*
 * Double-Ended-Queue:
 * 	-- Có vài tình huống, ta có nhu cầu thêm vào đầu hàng đợi ( chẳng hạn thêm 1 khách hàng VIP)
 * 		hoặc xoá ở cuối hàng đợi ( chẳng hạn khách hàng ở cuối ko kiên nhẫn và bỏ đi ).
 * 		Ở những trường hợp này, Queue cần phải có thêm phương thức AddFirst() và RemoveLast()
 * 	-- Do đó người ta đã tạo ra Hàng đợi 2 đầu cho các tình huống tổng quát
 * 	-- Ta có thể xây dựng hàng đợi 2 đầu dựa trên mảng xoay vòng hoặc DoublyLinkedList nhưng 
 * 		sử dụng DoublyLinkedList hiệu quả hơn
 */
package ds05_deque;

/**
 * Dequeue interface.
 *
 * @author Pham Ngoc Thuc
 */
public interface Deque<E> {

	/**
	 * Returns the number of elements in the deque.
	 * 
	 * @return number of elements in the deque
	 */
	int size();

	/**
	 * Tests whether the deque is empty.
	 * 
	 * @return true if the deque is empty, false otherwise
	 */
	boolean isEmpty();

	/**
	 * Returns (but does not remove) the first element of the deque.
	 * 
	 * @return first element of the deque (or null if empty)
	 */
	E first();

	/**
	 * Returns (but does not remove) the last element of the deque.
	 * 
	 * @return last element of the deque (or null if empty)
	 */
	E last();

	/**
	 * Inserts an element at the front of the deque.
	 * 
	 * @param e the new element
	 */
	void addFirst(E e);

	/**
	 * Inserts an element at the back of the deque.
	 * 
	 * @param e the new element
	 */
	void addLast(E e);

	/**
	 * Removes and returns the first element of the deque.
	 * 
	 * @return element removed (or null if empty)
	 */
	E removeFirst();

	/**
	 * Removes and returns the last element of the deque.
	 * 
	 * @return element removed (or null if empty)
	 */
	E removeLast();
}
