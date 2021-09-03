package org.self.sorting;

/**
 * 直接插入排序
 * 
 * @author TungWang
 */
public class StraightInsertionSort {

	private SortType type;

	public StraightInsertionSort() {
		this(SortType.ASCEND);
	}

	public StraightInsertionSort(SortType type) {
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
		int tmp;
		// 循环开始时有序区只有唯一元素data[0]，i4unorder是无序区的起始索引
		for (int i4unorder = start + 1; i4unorder < end; i4unorder++) {
			tmp = data[i4unorder];

			// 开始使用 tmp 与有序区的数据从右往左比较，i4order初始为有序区的终止索引
			int i4order = i4unorder - 1;
			for (; i4order >= 0 && type.notAccord(data[i4order], tmp); i4order--)
				data[i4order + 1] = data[i4order];
			// 将 tmp 插入合适的位置，有序区的长度+1，无序区的长度-1
			data[i4order + 1] = tmp;
		}
	}

}
