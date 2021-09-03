package org.self.sorting;

/**
 * 归并排序
 * 
 * @author TungWang
 */
public class MergeSort {

	private SortType type;
	private int inlineData[];

	public MergeSort() {
		this(SortType.ASCEND);
	}

	public MergeSort(SortType type) {
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
		// step: 每次归并的步长；进行log2(data.length)趟归并
		for (int step = 1; step < end; step = 2 * step)
			mergePass(step, start, end - start);
	}

	/**
	 *  一趟归并排序
	 *  
	 * @param step 步长
	 * @param start 起始位置
	 * @param length  序列要排序的长度
	 */
	private void mergePass(int step, int start, int length) {
		for (int i = start; i < length; i += 2 * step)
			// 判断能有两个长度为step的子表
			if (i + 2 * step <= length)
				merge(i, i + step, i + 2 * step);
			// 判断能有两个子表
			else if (i + step < length)
				merge(i, i + step, length);
		// 最后只剩下一个表就轮空本趟排序
	}

	/**
	 * 一次归并排序，合并两个子表
	 * <p>
	 * 子表1 [low，mid)，子表2[mid，high)
	 * 
	 * @param low
	 * @param mid
	 * @param high
	 */
	private void merge(int low, int mid, int high) {
		// 创建一个 tmp 表
		int tmp[] = new int[high - low];

		// start1: 子表1的起始点，start2: 子表2的起始点，index: 循环执行完在tmp的位置
		int start1 = low, start2 = mid, index = 0;
		for (; start1 < mid && start2 < high;) {
			if (type.isAccord(inlineData[start1], inlineData[start2]))
				tmp[index++] = inlineData[start1++];
			else
				tmp[index++] = inlineData[start2++];
		}

		// 这里最多只有一个表有剩余的元素
		for (; start1 < mid; start1++, index++)
			tmp[index] = inlineData[start1];
		for (; start2 < high; start2++, index++)
			tmp[index] = inlineData[start2];

		// 将tmp表中数据覆写入 inlineData，index4data: 是本次归并的最开始的位置
		for (int index4data = low, index4tmp = 0; index4data < high;)
			inlineData[index4data++] = tmp[index4tmp++];
	}

}
