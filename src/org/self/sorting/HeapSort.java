package org.self.sorting;

/**
 * 堆排序
 * <p>
 * 将要排序的data看成完全二叉树的顺序存储结构
 * <p>
 * 这里使用最大堆排序，排序结构从左至右，从小到大
 * 
 * @author TungWang
 */
public class HeapSort {

	private SortType type;
	private int inlineData[];

	public HeapSort() {
		this(SortType.ASCEND);
	}

	public HeapSort(SortType type) {
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
		// 将 data 变为全局引用
		inlineData = data;
		// 每次都对无序区重新调整树结构，无序区长度-1，有序区长度+1
		for (int high = end; high > start; high--) {
			// 上浮极值到第一位
			swim(inlineData, high);
			// 交换无序区第一个元素与最后一个元素
			int tmp = getValue(1);
			setValue(1, getValue(high));
			setValue(high, tmp);
		}
	}

	/**
	 * 自顶向下的调整，上浮最大点
	 * 
	 * @param data 要调整结构的数组
	 * @param high 数组的边界，可能小于数组长度
	 */
	private void swim(int data[], int high) {
		// internal: 内部节点，初始为最大有子节点的双亲节点的索引
		for (int internal = high / 2; internal >= 1; internal--) {
			// 极值点设为左节点
			int extremum = internal * 2;
			// 左右子树中找出极值
			int left = getValue(extremum);
			if (extremum + 1 <= high && type.notAccord(getValue(extremum + 1), left))
				extremum = extremum + 1;
			// 子节点和双亲节点中找出极值，并交换值
			int child = getValue(extremum), parent = getValue(internal);
			if (type.notAccord(child, parent)) {
				setValue(internal, child);
				setValue(extremum, parent);
			}
		}
	}

	/**
	 * @param index 由于堆使用二叉树的原因，根节点的索引为1
	 * @return 在二叉树上 index 处的值
	 */
	private int getValue(int index) {
		return inlineData[index - 1];
	}

	// 同理 getValue
	private void setValue(int index, int value) {
		inlineData[index - 1] = value;
	}

}
