/*
 * B> Binary Tree:
 * 	1. Định nghĩa:
 * 		Binary Tree là 1 "ordered tree" có các đặc điểm sau:
 * 			+ Mỗi node có tối đa 2 con
 * 			+ Con bên trái gọi là left-child, con bên phải gọi là right-child
 * 			+ left-child "precedes" right-child ( precedes: nằm trước, được xử lí trước, ...)
 * 	2. Các khái niệm khác:
 * 		-- "left subtree" 	: cây con bên trái của root
 * 		-- "right subtree"	: cây con bên phải của root
 * 		-- binary tree được gọi là "proper" (đầy đặn) nếu mỗi node có chính xác 2 con.
 * 			Trong proper binary tree số external node = internal node + 1
 * 		-- cây nhị phân không đầy đặn gọi là "improper" binary tree.
 * 		-- binary tree còn được gọi là "decision tree" - cây quyết định vì 2 nhánh của
 * 			mỗi node giống như các quyết định yes/no
 */
package ds09_binary_tree;

import ds08_general_tree.Position;
import ds08_general_tree.Tree;

/**
 * An interface for a binary tree, in which each node has at most two children.
 *
 * @author Pham Ngoc Thuc
 */
public interface BinaryTree<E> extends Tree<E> {

	/**
	 * Returns the Position of p's left child (or null if no child exists).
	 *
	 * @param p A valid Position within the tree
	 * @return the Position of the left child (or null if no child exists)
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 */
	Position<E> left(Position<E> p) throws IllegalArgumentException;

	/**
	 * Returns the Position of p's right child (or null if no child exists).
	 *
	 * @param p A valid Position within the tree
	 * @return the Position of the right child (or null if no child exists)
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 */
	Position<E> right(Position<E> p) throws IllegalArgumentException;

	/**
	 * Returns the Position of p's sibling (or null if no sibling exists).
	 *
	 * @param p A valid Position within the tree
	 * @return the Position of the sibling (or null if no sibling exists)
	 * @throws IllegalArgumentException if p is not a valid Position for this tree
	 */
	Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
