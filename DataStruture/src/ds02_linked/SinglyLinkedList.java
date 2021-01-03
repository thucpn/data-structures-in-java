/*
 * 1. Singly Linked List: 
 * 	-- tập hợp Node, mỗi Node chứa data và reference to Node kế tiếp
 * 
 * 2. Các thao tác:
 * 	-- O(1)		: size(), isEmpty(), first(), last(), addFirst(), addLast(), removeFirst()
 * 	-- O(n)		: removeLast(), get(), linearSearch(), recusiveSearch(), deepClone()
 * 
 * 3. Tốt:
 * 	-- tốc độ first(), last(), addFirst(), addLast(), removeFirst() nhanh
 *  -- cấu trúc dữ liệu động (kích thước ko xác định)
 * 
 * 4. Xấu:
 *  -- truy xuất chậm
 *  -- việc sắp xếp khó khăn
 * 
 * 5. Ứng dụng:
 * 	-- nên dùng khi ứng dụng các thao tác thêm, xoá nhiều. Truy vấn dữ liệu ít
 * 	-- nên sử dụng khi muốn lưu trữ cấu trúc dữ liệu động (kích thước ko xác định)
 * 	-- sử dụng thêm 1 đuôi tail tuy tốn bộ nhớ nhưng dễ dàng hơn trong việc thao tác
 * 	-- nếu tần suất removeLast() cao thì nên sử dụng 
 * 	-- việc sắp xếp single linked list vô cùng khó khăn và nếu cần thì nên sử dụng mergeSort
 */

package ds02_linked;

/**
 * Singly linked list implementation.
 *
 * @author Pham Ngoc Thuc
 */
public class SinglyLinkedList<E> implements Cloneable {
	// ---------------- nested Node class ----------------
	/**
	 * Node of a singly linked list, which stores a reference to its element and to
	 * the subsequent node in the list (or null if this is the last node).
	 */
	private static class Node<E> {

		/** The element stored at this node */
		private E element; // reference to the element stored at this node

		/** A reference to the subsequent node in the list */
		private Node<E> next; // reference to the subsequent node in the list

		/**
		 * Creates a node with the given element and next node.
		 *
		 * @param e the element to be stored
		 * @param n reference to a node that should follow the new node
		 */
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		// Accessor methods
		/**
		 * Returns the element stored at the node.
		 * 
		 * @return the element stored at the node
		 */
		public E getElement() {
			return element;
		}

		/**
		 * Returns the node that follows this one (or null if no such node).
		 * 
		 * @return the following node
		 */
		public Node<E> getNext() {
			return next;
		}

		// Modifier methods
		/**
		 * Sets the node's next reference to point to Node n.
		 * 
		 * @param n the node that should follow this one
		 */
		public void setNext(Node<E> n) {
			next = n;
		}
	} // ----------- end of nested Node class -----------

	// instance variables of the SinglyLinkedList
	/** The head node of the list */
	private Node<E> head = null; // head node of the list (or null if empty)

	/** The last node of the list */
	private Node<E> tail = null; // last node of the list (or null if empty)

	/** Number of nodes in the list */
	private int size = 0; // number of nodes in the list

	/** Constructs an initially empty list. */
	public SinglyLinkedList() {

	} // constructs an initially empty list

	// access methods
	/**
	 * Returns the number of elements in the linked list.
	 * 
	 * @return number of elements in the linked list
	 */
	public int size() {
		return size;
	}

	/**
	 * Tests whether the linked list is empty.
	 * 
	 * @return true if the linked list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns (but does not remove) the first element of the list
	 * 
	 * @return element at the front of the list (or null if empty)
	 */
	public E first() { // returns (but does not remove) the first element
		if (isEmpty())
			return null;
		return head.getElement();
	}

	/**
	 * Returns (but does not remove) the last element of the list.
	 * 
	 * @return element at the end of the list (or null if empty)
	 */
	public E last() { // returns (but does not remove) the last element
		if (isEmpty())
			return null;
		return tail.getElement();
	}

	// update methods
	/**
	 * Adds an element to the front of the list.
	 * 
	 * @param e the new element to add
	 */
	public void addFirst(E e) { // adds element e to the front of the list
		head = new Node<>(e, head); // create and link a new node
		if (size == 0)
			tail = head; // special case: new node becomes tail also
		size++;
	}

	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param e the new element to add
	 */
	public void addLast(E e) { // adds element e to the end of the list
		Node<E> newest = new Node<>(e, null); // node will eventually be the tail
		if (isEmpty())
			head = newest; // special case: previously empty list
		else
			tail.setNext(newest); // new node after existing tail
		tail = newest; // new node becomes the tail
		size++;
	}

	/**
	 * Removes and returns the first element of the list.
	 * 
	 * @return the removed element (or null if empty)
	 */
	public E removeFirst() { // removes and returns the first element
		if (isEmpty())
			return null; // nothing to remove
		E answer = head.getElement();
		head = head.getNext(); // will become null if list had only one node
		size--;
		if (size == 0)
			tail = null; // special case as list is now empty
		return answer;
	}

	/**
	 * Removes and returns the last element of the list.
	 * 
	 * @return the removed element (or null if empty)
	 */
	public E removeLast() {
		if (isEmpty())
			return null; // nothing to remove

		if (head.next == null) {
			return null; // return null if list had only one node
		}

		E answer = head.getElement();

		// Find the second last node
		Node<E> second_last = head;
		while (second_last.next.next != null) {
			second_last = second_last.next;
		}

		// Change next of second last
		second_last.next = null;

		return answer;
	}

	/**
	 * Get node by index
	 * 
	 * @param index position to get
	 * 
	 * @return Node if found (null if versa)
	 */
	public E get(int index) {
		Node<E> current = head;
		int count = 0;
		while (current != null) {
			if (count == index)
				return current.element;
			count++;
			current = current.next;
		}
		return null;
	}

	/**
	 * Check if x in list by iteration
	 * 
	 * @param x value to find
	 * 
	 * @return true if found
	 */
	public boolean linearSearch(E x) {
		Node<E> current = head;
		while (current != null) {
			if (current.element.equals(x))
				return true; // data found
			current = current.next;
		}
		return false; // data not found
	}

	/**
	 * Check if x in list by recusive
	 * 
	 * @param startNode the node that searching starts ( it should be Head )
	 * @param x         value to find
	 * 
	 * @return true if found
	 */
	public boolean recusiveSearch(Node<E> startNode, E x) {
		// Base case
		if (startNode == null)
			return false;

		// If key is present in current node,
		// return true
		if (startNode.element.equals(x))
			return true;

		// Recur for remaining list
		return recusiveSearch(startNode.next, x);
	}

	@SuppressWarnings("rawtypes")
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		SinglyLinkedList other = (SinglyLinkedList) o; // use nonparameterized type
		if (size != other.size)
			return false;
		Node walkA = head; // traverse the primary list
		Node walkB = other.head; // traverse the secondary list
		while (walkA != null) {
			if (!walkA.getElement().equals(walkB.getElement()))
				return false; // mismatch
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		return true; // if we reach this, everything matched successfully
	}

	@SuppressWarnings({ "unchecked" })
	public SinglyLinkedList<E> deepClone() throws CloneNotSupportedException {
		// always use inherited Object.clone() to create the initial copy
		SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
		if (size > 0) { // we need independent chain of nodes
			other.head = new Node<>(head.getElement(), null);
			Node<E> walk = head.getNext(); // walk through remainder of original list
			Node<E> otherTail = other.head; // remember most recently created node
			while (walk != null) { // make a new node storing same element
				Node<E> newest = new Node<>(walk.getElement(), null);
				otherTail.setNext(newest); // link previous node to this one
				otherTail = newest;
				walk = walk.getNext();
			}
		}
		return other;
	}

	/**
	 * Produces a string representation of the contents of the list. This exists for
	 * debugging purposes only.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		Node<E> walk = head;
		while (walk != null) {
			sb.append(walk.getElement());
			if (walk != tail)
				sb.append(", ");
			walk = walk.getNext();
		}
		sb.append(")");
		return sb.toString();
	}
}
