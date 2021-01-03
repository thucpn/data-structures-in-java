/*
 * 1. Array: tập hợp các phần tử có cùng kiểu dữ liệu.
 * 
 * 2. Các thao tác:
 * 	-- O(1)		: size(), isEmpty(), get(), addLast(), removeLast()
 * 	-- O(logn)	: binarySeach()
 * 	-- O(n)		: linearSearch(), add(), remove(), toString(), equals(), deepClone()
 * 	-- O(n^2)	: insertionSort()
 * 
 * 3. Tốt:
 * 	-- tốc độ truy xuất get() nhanh
 *  -- dễ sử dụng
 *  -- ngoài mảng 1 chiều còn có mảng 2-chiều, n-chiều.
 * 
 * 4. Xấu:
 * 	-- kích thước cố định
 *  -- các thao tác add(), remove() ở vị trí bất kì tốn chi phí cao [ O(n) ]
 * 
 * 5. Ứng dụng:
 * 	-- nên dùng khi ứng dụng chỉ lưu trữ và truy cập data. Các thao tác thêm, xoá ít
 * 	-- nên cân nhắc sử dụng binarySearch() vì nó yêu cầu mảng đã dc sắp xếp và tốn nhiều bộ nhớ
 * 	-- tuỳ vào tình huống mà sử dụng giải thuật sort khác nhau, nhưng ổn định nhất
 * 		để sort mảng là InsertionSort()
 */

package ds01_array;

/**
 * Array implementation.
 *
 * @author Pham Ngoc Thuc
 */

public class Array {
	private int numElement = 0; // number of actual element
	private int[] arr; // array of element

	public Array(int capacity) {
		arr = new int[capacity];
	}

	public int size() {
		return numElement;
	}

	public boolean isEmpty() {
		return numElement == 0;
	}

	public int get(int i) {
		if (i < arr.length) {
			return arr[i];
		}
		return -1;
	}

	public void addLast(int x) {
		if (numElement < arr.length) {
			numElement++;
			arr[numElement - 1] = x;
		}
	}

	public int removeLast() {
		if (numElement > 0) {
			int temp = arr[numElement - 1];
			arr[numElement - 1] = 0;
			numElement--;
			return temp;
		}
		return -1;

	}

	public int binarySearch(int l, int r, int x) {
		if (r >= l) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == x)
				return mid;
			if (arr[mid] > x)
				return binarySearch(l, mid - 1, x);
			return binarySearch(mid + 1, r, x);
		}
		return -1;
	}

	public int linearSearch(int x) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] == x)
				return i;
		}
		return -1;
	}

	public void add(int x, int pos) {
		if (numElement < arr.length) {
			numElement++;
			for (int i = numElement - 2; i >= pos; i--) {
				arr[i + 1] = arr[i];
			}
			arr[pos] = x;
		}
	}

	public int remove(int i) {
		if (numElement > 0) {
			int temp = arr[i];
			for (int j = i; j < numElement - 1; j++)
				arr[j] = arr[j + 1];
			arr[numElement - 1] = 0;
			numElement--;
			return temp;
		}
		return -1;
	}

	public void insertionSort() {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("( ");
		for (int i = 0; i < numElement; i++) {
			sb.append(i + " ");
		}
		sb.append(")");
		return sb.toString();
	}

	public boolean equals(int b[]) {
		if (b.length != numElement) {
			return false;
		}
		for (int i = 0; i < numElement; i++) {
			if (arr[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	public int[] deepClone(int[] original) {
		int[] backup = new int[original.length];
		for (int k = 0; k < original.length; k++)
			backup[k] = original[k];
		return backup;
	}

}
