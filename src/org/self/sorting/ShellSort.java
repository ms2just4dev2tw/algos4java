package org.self.sorting;

/**
 * 希尔排序（分组插入）
 * 
 * @author TungWang
 */
public class ShellSort {

	private SortType type;
	private int inlineData[];

	public ShellSort() {
		this(SortType.ASCEND);
	}

	public ShellSort(SortType type) {
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
		// gap: 初始为长度/2，循环 gap = gap/2，直到 gap == 1
		for (int gap = (end - start) / 2; gap > 0; gap /= 2) {
			// 对每个分组进行直接插入排序，分组排序的结果是局部有序
			StraightInsertionSort(gap, start, end);
		}
	}

	/**
	 * 对所有间隔了 gap 个元素的元素进行直接插入排序
	 * 
	 * @param gap
	 * @param start
	 * @param end
	 */
	private void StraightInsertionSort(int gap, int start, int end) {
		// i4unorder: 还未排序的元素
		for (int i4unorder = gap; i4unorder < end; i4unorder++) {
			// 将 tmp 元素插入到合适的位置
			int tmp = inlineData[i4unorder];
			// i4order: 已经排序的元素
			int i4order = i4unorder - gap;
			// 如果排序后的元素与 tmp 相比不符合 type 规则，排序元素后移，再继续向前比较
			for (; i4order >= start && type.notAccord(inlineData[i4order], tmp); i4order -= gap)
				inlineData[i4order + gap] = inlineData[i4order];
			// 最后将 tmp 元素归位
			inlineData[i4order + gap] = tmp;
		}
	}

}
