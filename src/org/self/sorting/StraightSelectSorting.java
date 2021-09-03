package org.self.sorting;

/**
 * 直接选择排序
 * <p>
 * 建议使用场景，从大量的数据中选择一部分最大或最小的数据
 * 
 * @author TungWang
 */
public class StraightSelectSorting {

	private SortType type;

	public StraightSelectSorting() {
		this(SortType.ASCEND);
	}

	public StraightSelectSorting(SortType type) {
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
		// 每次都只进行一次交换
		for (int index = start; index < end - 1; index++) {
			// 初始选择的点为 index
			int selected = index;

			// 标记出此次找到的极值的位置
			for (int i4unorder = index + 1; i4unorder < end; i4unorder++)
				// 如果 selected 与 i4unorder 不符合 type 规则
				if (type.notAccord(data[selected], data[i4unorder]))
					selected = i4unorder;

			// 如果 selected 的值不为初始值，就交换值
			if (selected != index) {
				int tmp = data[index];
				data[index] = data[selected];
				data[selected] = tmp;
			}
		}
	}

}
