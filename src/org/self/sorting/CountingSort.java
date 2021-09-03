package org.self.sorting;

/**
 * 计数排数
 * 
 * @author TungWang
 */
public class CountingSort {

	private SortType type;
	// 输入数据数组
	private int inputArr[];
	// 数据计数数组，startNum: countArr在索引0处代表的数
	private int countArr[], startNum;
	// 输出数据数组
	// private int outputArr[];

	public CountingSort() {
		this(SortType.ASCEND);
	}

	public CountingSort(SortType type) {
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
	public void sort(int[] data, int start, int end) {
		// 将要排序数据缓存到输入数组
		inputArr = new int[end - start];
		for (int i4data = start, i4input = 0; i4data < end; i4data++, i4input++)
			inputArr[i4input] = data[i4data];
		// 选出最大值和最小值
		int min = data[start], max = data[start];
		for (int index = start + 1; index < end; index++) {
			min = min > data[index] ? data[index] : min;
			max = max < data[index] ? data[index] : max;
		}
		// 开辟计数数组
		startNum = min;
		countArr = new int[max - min + 1];
		// 开始计数
		for (int index = start; index < end; index++)
			setCount(data[index]);
		// 计数叠加
		for (int index = 1; index < countArr.length; index++)
			countArr[index] += countArr[index - 1];
		// 重新覆写数组
		overwriteData(data, start, end);
	}

	/**
	 * 每次设置一次count，count都变大一次
	 * 
	 * @param value inputArr的数据
	 */
	private void setCount(int value) {
		countArr[value - startNum]++;
	}

	/**
	 * 每次取一次count，count都变小一次
	 * 
	 * @param value inputArr的数据
	 * @return
	 */
	private int getCount(int value) {
		return countArr[value - startNum]--;
	}

	// 覆写数据
	private void overwriteData(int data[], int start, int end) {
		if (type == SortType.ASCEND)
			for (int index = 0; index < inputArr.length; index++) {
				int count = getCount(inputArr[index]);
				data[start + count - 1] = inputArr[index];
			}
		else if (type == SortType.DESCEND)
			for (int index = 0; index < inputArr.length; index++) {
				int count = getCount(inputArr[index]);
				data[end - count] = inputArr[index];
			}
	}

}
