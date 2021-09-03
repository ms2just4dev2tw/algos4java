package org.self.sorting;

import org.self.queue.CircularQueue;

/**
 * 基数排序
 * 
 * @author TungWang
 */
public class RadixSort {

	private class Element {
		private int value;
		private char radixArr[];

		private Element(int value) {
			this.value = value;
			this.radixArr = int2chars(value);
		}

		private int getRadix(int slide) {
			return radixArr[slide] - 48;
		}
	}

	// 基数，默认十进制
	private int radix;
	// 元素中的最大元组数
	private int maxTuple;
	private SortType type;

	public RadixSort() {
		this(SortType.ASCEND, 10);
	}

	public RadixSort(SortType type) {
		this(type, 10);
	}

	public RadixSort(SortType type, int radix) {
		this.type = type;
		this.radix = radix;
	}

	public void sort(int data[]) {
		sort(data, 0, data.length, findMaxTuple(data, 0, data.length));
	}

	public void sort(int data[], int maxTuple) {
		sort(data, 0, data.length, maxTuple);
	}

	public void sort(int data[], int start, int end) {
		sort(data, start, end, findMaxTuple(data, start, end));
	}

	/**
	 * 对 data 的 [start，end)数据排序
	 * 
	 * @param data
	 * @param start
	 * @param end
	 * @param maxTuple
	 */
	public void sort(int data[], int start, int end, int maxTuple) {
		this.maxTuple = maxTuple;
		// 初始化队列 queue
		CircularQueue<Element> queue = new CircularQueue<>(end - start);
		for (int i = start; i < end; i++)
			queue.enter(new Element(data[i]));
		// 初始化基数队列 radixQueue
		@SuppressWarnings("unchecked")
		CircularQueue<Element> radixQueue[] = new CircularQueue[radix];
		for (int i = 0; i < radix; i++)
			radixQueue[i] = new CircularQueue<>();
		//
		for (int slide = 0; slide < maxTuple; slide++) {
			// 将队列 queue 中的元素根据在 slide 位的基数放入对应的基数队列
			for (int index = start; index < end; index++) {
				Element el = queue.poll();
				radixQueue[el.getRadix(slide)].enter(el);
			}
			// 将所有基数队列 radixQueue 添加进队列 queue
			for (int i = 0; i < radix; i++)
				while (!radixQueue[i].isEmpty())
					queue.enter(radixQueue[i].poll());
		}
		// 最后将 queue 的数据写到 data 中
		for (int i = 0; i < end - start; i++) {
			Element el = queue.poll();
			if (type == SortType.ASCEND)
				data[start + i] = el.value;
			else if (type == SortType.DESCEND)
				data[end - i - 1] = el.value;
		}
	}

	private int findMaxTuple(int data[], int start, int end) {
		int max = data[start];
		for (int i = start + 1; i < end; i++)
			if (max < data[i])
				max = data[i];
		//
		return String.valueOf(max).toCharArray().length;
	}

	private char[] int2chars(int value) {
		char result[] = new char[maxTuple];
		char tmp[] = String.valueOf(value).toCharArray();
		// 将 tmp 的数据赋值给 result
		for (int index = 0; index < tmp.length; index++)
			result[index] = tmp[index];
		return result;
	}

}
