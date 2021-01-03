/*
 * 1. LinkedList-Based Queue: 
 * 	-- Queue được xây dựng dựa trên LinkedList
 * 	-- Các thao tác ở đầu LinkedList đều O(1), rất thích hợp cho Queue
 * 
 * 2. Các thao tác:
 * 	-- O(1)		: size(), isEmpty(), enqueue(), dequeue(), first()
 * 	-- O(n)		: toString()
 * 
 * 3. Tốt:
 * 	-- ngoài các điểm tốt của ArrayQueue, LinkedListQueue còn cho phép ko giới hạn kích thước
 * 
 * 4. Xấu:
 * 	-- tốn không gian lưu trữ hơn ArrayQueue
 * 
 * 5. Ứng dụng:
 * 	-- làm công cụ để phát triển nhiều thuật toán và cấu trúc dữ liệu khác
 * 	-- ứng dụng nhiều trong thực tế.
 * 		ví dụ: hệ thống tiếp nhận tư vấn, ...
 * 	-- queue hiện tại của Java.util chính là được xây dựng dựa trên LinkedList
 */

package ds04_queue;

import ds02_linked.SinglyLinkedList;

/**
 * LinkedList-Base Queue implementation.
 *
 * @author Pham Ngoc Thuc
 */

public class LinkedQueue<E> implements Queue<E> {

	/** The primary storage for elements of the queue */
	private SinglyLinkedList<E> list = new SinglyLinkedList<>(); // an empty list

	/** Constructs an initially empty queue. */
	public LinkedQueue() {
	} // new queue relies on the initially empty list

	/**
	 * Returns the number of elements in the queue.
	 * 
	 * @return number of elements in the queue
	 */
	@Override
	public int size() {
		return list.size();
	}

	/**
	 * Tests whether the queue is empty.
	 * 
	 * @return true if the queue is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Inserts an element at the rear of the queue.
	 * 
	 * @param element the element to be inserted
	 */
	@Override
	public void enqueue(E element) {
		list.addLast(element);
	}

	/**
	 * Returns, but does not remove, the first element of the queue.
	 * 
	 * @return the first element of the queue (or null if empty)
	 */
	@Override
	public E first() {
		return list.first();
	}

	/**
	 * Removes and returns the first element of the queue.
	 * 
	 * @return element removed (or null if empty)
	 */
	@Override
	public E dequeue() {
		return list.removeFirst();
	}

	/**
	 * Produces a string representation of the contents of the queue. (from front to
	 * back). This exists for debugging purposes only.
	 */
	public String toString() {
		return list.toString();
	}
}
