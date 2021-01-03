/*
 * Set là 1 tính năng mới với cơ chế ko chấp nhận các phần tử trùng nhau
 * 
 * Set có thể phối hợp với các cấu trúc dữ liệu khác để tạo thành các combo như:
 * 	+ TreeSet 				= Set + Balance Tree
 * 	+ HashSet				= Set + HashTable
 * 	+ ConcurrentSkipListSet = Set + SkipList 
 * 	+ ...
 * 
 * Set được ứng dụng để xây dựng lí thuyết tập hợp, các ứng dụng yêu cầu các phần tử ko lặp nhau
 */
package ds16_set;

import java.util.Set;

public interface MySet<E> extends Set<E>{
	
}
