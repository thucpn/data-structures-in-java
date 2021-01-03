/*
 * A> Tree:
 * 	1. Định nghĩa:
 * 		Tree T là 1 tập hợp các Nodes lưu trữ dữ liệu sao cho các node phải thoả mãn
 * 			quan hệ parent-child như sau:
 * 			+ Nếu T không rỗng, T có 1 node đặc biệt được gọi là "root", root ko có parent
 * 			+ Các node khác root có duy nhất 1 parent và là child của parent đó
 * 	2. Các khái niệm khác:
 * 		-- các node có chung parent là "siblings"
 * 		-- 1 node ko có child là "external" hoặc là "leaf"
 * 		-- 1 node có child(s) là "internal"
 * 		-- 1 node có cấp bậc là cha, ông nội, ông cố, ... của 1 node khác 
 * 			gọi là "ancestor" của node đó
 * 			lưu ý: 1 node cũng là ancestor của chính nó
 * 		-- 1 node có cấp bậc là con, cháu, chít, ... trở xuống của 1 node khác 
 * 			gọi là "descendant" của node đó
 * 			lưu ý; 1 node cũng là descendant của chính nó
 * 		-- 1 "subtree" (cây con) tại 1 node bao gồm các descendant của nó
 * 		-- 1 "edge" là 1 cặp node (u,v) sao cho u và v có quan hệ cha-con
 * 		-- 1 "path" là 1 chuỗi các node (a,b,c,d) tạo thành 1 đường liền trên cây
 * 		-- "ordered tree" - cây có thứ tự là cây mà các node được sắp xếp theo 1 thứ tự nhất định
 * 			ví dụ: 	cây gia phả sắp xếp tổ tiên trên, con cháu dưới,
 * 				  	cây alphabet sắp xếp các chữ cái đầu bên trái, chữ cái sau bên phải,...
 * 		-- "depth" của 1 node là số ancestor của node đó (trừ nó ra)
 * 			+ depth of root = 0
 * 			+ depth of a node = depth of its parent + 1
 * 		-- "height" of tree là maximum "depth" của tất cả các node trong cây đó
 * 		-- tập hợp các node có depth x bằng nhau tạo thành level x của cây
 * 	
 * 	==> Đột phá về hiệu suất là suy nghĩ theo hướng phi tuyến tính
 * 
 */
package ds08_general_tree;

import java.util.Iterator;

/**
 * An interface for a tree where nodes can have an arbitrary number of children.
 *
 * @author Pham Ngoc Thuc
 */
public interface Tree<E> extends Iterable<E> {

	/**
	 * Returns the root Position of the tree (or null if tree is empty).
	 * 
	 * @return root Position of the tree (or null if tree is empty)
	 */
	Position<E> root();

	/**
	 * Returns the Position of p's parent (or null if p is root).
	 *
	 * @param p A valid Position within the tree
	 * @return Position of p's parent (or null if p is root)
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */
	Position<E> parent(Position<E> p) throws IllegalArgumentException;

	/**
	 * Returns an iterable collection of the Positions representing p's children.
	 *
	 * @param p A valid Position within the tree
	 * @return iterable collection of the Positions of p's children
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */
	Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

	/**
	 * Returns the number of children of Position p.
	 *
	 * @param p A valid Position within the tree
	 * @return number of children of Position p
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */
	int numChildren(Position<E> p) throws IllegalArgumentException;

	/**
	 * Returns true if Position p has one or more children.
	 *
	 * @param p A valid Position within the tree
	 * @return true if p has at least one child, false otherwise
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */
	boolean isInternal(Position<E> p) throws IllegalArgumentException;

	/**
	 * Returns true if Position p does not have any children.
	 *
	 * @param p A valid Position within the tree
	 * @return true if p has zero children, false otherwise
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */
	boolean isExternal(Position<E> p) throws IllegalArgumentException;

	/**
	 * Returns true if Position p represents the root of the tree.
	 *
	 * @param p A valid Position within the tree
	 * @return true if p is the root of the tree, false otherwise
	 * @throws IllegalArgumentException if p is not a valid Position for this tree.
	 */
	boolean isRoot(Position<E> p) throws IllegalArgumentException;

	/**
	 * Returns the number of nodes in the tree.
	 * 
	 * @return number of nodes in the tree
	 */
	int size();

	/**
	 * Tests whether the tree is empty.
	 * 
	 * @return true if the tree is empty, false otherwise
	 */
	boolean isEmpty();

	/**
	 * Returns an iterator of the elements stored in the tree.
	 * 
	 * @return iterator of the tree's elements
	 */
	Iterator<E> iterator();

	/**
	 * Returns an iterable collection of the positions of the tree.
	 * 
	 * @return iterable collection of the tree's positions
	 */
	Iterable<Position<E>> positions();
}
