package org.self.sorting;

/**
 * 折半插入排序
 * <p>
 * 1，每次从序列的末尾选择一个元素 tmp <p> 
 * 2，从[0, length-1]中找到 tmp 的插入位置 index <p> 
 * 3，在 index 处和之后的所有元素后移
 * <p>
 * 
 * @author TungWang
 */
public class BinaryInsertionSort {

	private SortType type;
	private int inlineData[];

	public BinaryInsertionSort() {
		this(SortType.ASCEND);
	}

	public BinaryInsertionSort(SortType type) {
		this.type = type;
	}

	public void sort(int data[]) {
		sort(data, 0, data.length);
	}

	/**
	 * 对 data 的 [start，end)数据排序
	 * 
	 * @param data
	 * @param start
	 * @param end
	 */
	public void sort(int data[], int start, int end) {
		// 将 data 变为全局引用
		inlineData = data;
		// low,high: 有序区的边界
		int low = start, high;
		// 有序区初始只有 start 一个元素
		for (int i4unorder = start + 1; i4unorder < end; i4unorder++) {
			// 每次循环重新界定有序区的边界
			high = i4unorder - 1;
			// 二分查找到 i4unorder 的插入位置
			int index = binarySearch(low, high, data[i4unorder]);
			// 在 index 处和之后的所有元素后移，插入 i4unorder 到 index
			rearwardMove(data[i4unorder], index, high);
		}
	}

	/**
	 *  二分查找
	 *  
	 * @param low
	 * @param high
	 * @param key 要插入的元素
	 * @return
	 */
	private int binarySearch(int low, int high, int key) {
		for (int mid = (low + high) / 2; low <= high; mid = (low + high) / 2)
			if (type.isAccord(key, inlineData[mid]))
				high = mid - 1;
			else
				low = mid + 1;
		return low;
	}

	/**
	 *  向后移动
	 *  
	 * @param key 元素
	 * @param index 元素 key 要插入的位置
	 * @param high 有序区的边界
	 */
	private void rearwardMove(int key, int index, int high) {
		// 元素后移
		for (int i = high; i >= index; i--)
			inlineData[i + 1] = inlineData[i];
		inlineData[index] = key;
	}

}
