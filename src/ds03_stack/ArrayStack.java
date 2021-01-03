/*
 * 1. Array-Based Stack: Stack xây dựng dựa trên mảng
 * 
 * 2. Các thao tác:
 * 	-- O(1)		: size(), isEmpty(), push(), top(), pop()
 * 	-- O(n)		: toString()
 * 
 * 3. Tốt:
 * 	-- trong trường hợp người dùng xác định được kích thước chính xác thì ArrayStack thật 
 * 		sự tuyệt vời vì các method đều O(1)
 * 
 * 4. Xấu:
 * 	-- bị giới hạn kích thước
 * 
 * 5. Ứng dụng:
 * 	-- vì ArrayStack đơn giản nên được sử dụng trong các ứng dụng đơn giản kích thước cố định
 * 		ví dụ: đảo ngược mảng, ...
 * 	-- ArrayStack là cơ sở để phát triển nhiều cấu trúc dữ liệu khác ko bị giới hạn kích thước
 */

package ds03_stack;

/**
 * Array-Based Stack Implementation
 *
 * @author Pham Ngoc Thuc
 */

public class ArrayStack<E> implements Stack<E> {
	/** Default array capacity. */
	public static final int CAPACITY = 1000; // default array capacity

	/** Generic array used for storage of stack elements. */
	private E[] data; // generic array used for storage

	/** Index of the top element of the stack in the array. */
	private int t = -1; // index of the top element in stack

	/** Constructs an empty stack using the default array capacity. */
	public ArrayStack() {
		this(CAPACITY);
	} // constructs stack with default capacity

	/**
	 * Constructs and empty stack with the given array capacity.
	 * 
	 * @param capacity length of the underlying array
	 */
	@SuppressWarnings({ "unchecked" })
	public ArrayStack(int capacity) { // constructs stack with given capacity
		data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
	}

	/**
	 * Returns the number of elements in the stack.
	 * 
	 * @return number of elements in the stack
	 */
	@Override
	public int size() {
		return (t + 1);
	}

	/**
	 * Tests whether the stack is empty.
	 * 
	 * @return true if the stack is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return (t == -1);
	}

	/**
	 * Inserts an element at the top of the stack.
	 * 
	 * @param e the element to be inserted
	 * @throws IllegalStateException if the array storing the elements is full
	 */
	@Override
	public void push(E e) throws IllegalStateException {
		if (size() == data.length)
			throw new IllegalStateException("Stack is full");
		data[++t] = e; // increment t before storing new item
	}

	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * 
	 * @return top element in the stack (or null if empty)
	 */
	@Override
	public E top() {
		if (isEmpty())
			return null;
		return data[t];
	}

	/**
	 * Removes and returns the top element from the stack.
	 * 
	 * @return element removed (or null if empty)
	 */
	@Override
	public E pop() {
		if (isEmpty())
			return null;
		E answer = data[t];
		data[t] = null; // dereference to help garbage collection
		t--;
		return answer;
	}

	/**
	 * Produces a string representation of the contents of the stack. (ordered from
	 * top to bottom). This exists for debugging purposes only.
	 *
	 * @return textual representation of the stack
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		for (int j = t; j >= 0; j--) {
			sb.append(data[j]);
			if (j > 0)
				sb.append(", ");
		}
		sb.append(")");
		return sb.toString();
	}
}
