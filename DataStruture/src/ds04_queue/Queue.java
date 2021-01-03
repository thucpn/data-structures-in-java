/*
 * -- Queue là anh em với Stack
 * -- Queue giúp giải quyết các bài toán có cơ chế FIFO (đầu vào input cùng chiều với hướng
 * 		giải quyết)
 * 		ví dụ: xếp hàng, hàng chờ điện thoại tư vấn
 * -- Queue interface hỗ trợ các phương thức căn bản của Queue 
 * 		(size, isEmpty, enqueue, dequeue, first)
 * -- Trong java đã có lớp concrete là java.util.Queue nhưng chúng ta sẽ viết lại Queue đó 
 * 		bằng cách xây dựng từ array và linkedlist
 */

package ds04_queue;

/**
 * Array implementation.
 *
 * @author Pham Ngoc Thuc
 */

public interface Queue<E> {
	/**
	 * Returns the number of elements in the queue.
	 * 
	 * @return number of elements in the queue
	 */
	int size();

	/**
	 * Tests whether the queue is empty.
	 * 
	 * @return true if the queue is empty, false otherwise
	 */
	boolean isEmpty();

	/**
	 * Inserts an element at the rear of the queue.
	 * 
	 * @param e the element to be inserted
	 */
	void enqueue(E e);

	/**
	 * Returns, but does not remove, the first element of the queue.
	 * 
	 * @return the first element of the queue (or null if empty)
	 */
	E first();

	/**
	 * Removes and returns the first element of the queue.
	 * 
	 * @return element removed (or null if empty)
	 */
	E dequeue();
}
