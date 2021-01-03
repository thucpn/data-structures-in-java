/*
 * -- Stack là cấu trúc dữ liệu đơn giản nhất, được sử dụng rộng rãi trong nhiều ứng dụng
 * 		và là công cụ hỗ trợ cho nhiều cấu trúc dữ liệu và giải thuật phức tạp khác
 * -- Stack giúp giải quyết các bài toán có cơ chế LIFO (đầu vào input ngược với hướng
 * 		giải quyết)
 * -- Stack interface hỗ trợ các phương thức căn bản của Stack (size, isEmpty, push, pop, top)
 * -- Trong java đã có lớp concrete là java.util.Stack nhưng chúng ta sẽ viết lại Stack đó 
 * 		bằng cách xây dựng từ array và linkedlist
 */
package ds03_stack;

/**
 * Array implementation.
 *
 * @author Pham Ngoc Thuc
 */
public interface Stack<E> {

	/**
	 * Returns the number of elements in the stack.
	 * 
	 * @return number of elements in the stack
	 */
	int size();

	/**
	 * Tests whether the stack is empty.
	 * 
	 * @return true if the stack is empty, false otherwise
	 */
	boolean isEmpty();

	/**
	 * Inserts an element at the top of the stack.
	 * 
	 * @param e the element to be inserted
	 */
	void push(E e);

	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * 
	 * @return top element in the stack (or null if empty)
	 */
	E top();

	/**
	 * Removes and returns the top element from the stack.
	 * 
	 * @return element removed (or null if empty)
	 */
	E pop();
}
