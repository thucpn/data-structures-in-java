/*
 * 1. LinkedList-Based Stack: 
 * 	-- Stack được xây dựng dựa trên LinkedList
 * 	-- Khi bắt đầu xây dựng ta phải quyết định top của Stack là nằm ở head hay tail của
 * 		linkedlist. Và rõ ràng là chọn head rồi, vì các method ở head của LinkedList đều 
 * 		là O(1)
 * 
 * 2. Các thao tác:
 * 	-- O(1)		: size(), isEmpty(), push(), top(), pop()
 * 	-- O(n)		: toString()
 * 
 * 3. Tốt:
 * 	-- ngoài các điểm tốt của ArrayStack, LinkedListStack còn cho phép ko giới hạn kích thước
 * 
 * 4. Xấu:
 * 	tốn không gian lưu trữ hơn ArrayStack
 * 
 * 5. Ứng dụng:
 * 	-- làm công cụ để phát triển nhiều thuật toán và cấu trúc dữ liệu khác
 * 	-- ứng dụng nhiều trong thực tế.
 * 		ví dụ: Matching HTML tag, matching các dấu ngoặc, ...
 * 	-- stack hiện tại của Java.util chính là được xây dựng dựa trên LinkedList
 */

package ds03_stack;

import ds02_linked.SinglyLinkedList;

/**
 * LinkedList-Base Stack implementation.
 *
 * @author Pham Ngoc Thuc
 */

public class LinkedStack<E> implements Stack<E> {

	/** The primary storage for elements of the stack */
	private SinglyLinkedList<E> list = new SinglyLinkedList<>(); // an empty list

	/** Constructs an initially empty stack. */
	public LinkedStack() {
	} // new stack relies on the initially empty list

	/**
	 * Returns the number of elements in the stack.
	 * 
	 * @return number of elements in the stack
	 */
	@Override
	public int size() {
		return list.size();
	}

	/**
	 * Tests whether the stack is empty.
	 * 
	 * @return true if the stack is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Inserts an element at the top of the stack.
	 * 
	 * @param element the element to be inserted
	 */
	@Override
	public void push(E element) {
		list.addFirst(element);
	}

	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * 
	 * @return top element in the stack (or null if empty)
	 */
	@Override
	public E top() {
		return list.first();
	}

	/**
	 * Removes and returns the top element from the stack.
	 * 
	 * @return element removed (or null if empty)
	 */
	@Override
	public E pop() {
		return list.removeFirst();
	}

	/**
	 * Produces a string representation of the contents of the stack. (ordered from
	 * top to bottom)
	 *
	 * This exists for debugging purposes only.
	 *
	 * @return textual representation of the stack
	 */
	public String toString() {
		return list.toString();
	}
}
