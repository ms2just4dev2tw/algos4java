package org.self.sorting;

/**
 * 快速排序（基于冒泡排序）
 * 
 * @author TungWang
 */
public class QuickSort {

	private SortType type;
	private int inlineData[];

	public QuickSort() {
		this(SortType.ASCEND);
	}

	public QuickSort(SortType type) {
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
		inlineData = data;
		located(start, end - 1);
	}

	/**
	 * 每执行一次都在给定区间 [start，end] 内，归位一个元素
	 * <p>
	 * 在归位元素的两边在进行快速排序
	 * 
	 * @param start
	 * @param end
	 */
	private void located(int start, int end) {
		// tmp: 要归位的元素；left: 满足 type 规则在 tmp 左边；right: 同理 left
		int left = start, right = end, tmp = inlineData[start];
		while (left < right) {
			// 如果右边的数据大于 tmp，就保持原地不动
			while (right > left && type.isAccord(tmp, inlineData[right]))
				right--;
			// 否则移到左边的left处
			inlineData[left] = inlineData[right];
			// 如果左边的数据小于 tmp，就保持原地不动
			while (right > left && type.isAccord(inlineData[left], tmp))
				left++;
			// 否则移到右边的right处
			inlineData[right] = inlineData[left];
		}
		// 当 left == right 时，tmp 元素应该归位
		inlineData[left] = tmp;

		// 递归执行归位元素左边
		if (left - start > 1)
			located(start, left - 1);
		// 递归执行归位元素右边
		if (end - left > 1)
			located(left + 1, end);
	}

}
