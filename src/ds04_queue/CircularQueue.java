/*
 * Tương tự như Circlar LinkedList, Hàng đợi xoay vòng được tạo ra để dùng cho các bài toán
 * 	xoay vòng và chỉ có nhu cầu FIFO
 */
package ds04_queue;

/**
 * Circular Queue interface
 *
 * @author Pham Ngoc Thuc
 */
public interface CircularQueue<E> extends Queue<E> {
	/**
	 * Rotates the front element of the queue to the back of the queue. This does
	 * nothing if the queue is empty.
	 */
	void rotate();
}
