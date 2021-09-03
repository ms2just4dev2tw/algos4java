package org.self.sorting;

/**
 * 冒泡排序
 * 
 * @author TungWang
 */
public class BubbleSort {

	private SortType type;

	public BubbleSort() {
		this(SortType.ASCEND);
	}

	public BubbleSort(SortType type) {
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
		for (int before = start; before < end; before++) {
			for (int after = before + 1; after < end; after++) {
				int tmp = data[before];

				// 如果 data[before] 与 data[after] 是不符合 type 规则
				if (type.notAccord(data[before], data[after])) {
					data[before] = data[after];
					data[after] = tmp;
				}
			}
		}
	}

}
