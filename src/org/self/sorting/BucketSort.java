package org.self.sorting;

import org.self.queue.BinaryHeapEnum;
import org.self.queue.PriorityQueue;

/**
 * 桶排序
 * <p>
 * 要求排序的数据是符合均匀分布
 * 
 * @author TungWang
 */
public class BucketSort {

	// 数据数目与桶数目的比例，默认为 1
	private int rate;
	private final static int DEFAULT_RATE = 1;
	// 桶的堆数据结构类型
	private BinaryHeapEnum type;
	// 桶·的起始边界，终止边界
	private int frontEdge, rearEdge;
	// 桶的间距大小
	private int bucketGap;
	// 所有的桶
	private PriorityQueue<Integer> bucketArr[];

	public BucketSort() {
		this(SortType.ASCEND, DEFAULT_RATE);
	}

	public BucketSort(SortType type) {
		this(type, DEFAULT_RATE);
	}

	public BucketSort(SortType type, int rate) {
		this.rate = rate;
		// 根据 SortType 的类型指定堆的类型
		this.type = BinaryHeapEnum.MIN_HEAP;
		if (type == SortType.DESCEND)
			this.type = BinaryHeapEnum.MAX_HEAP;
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
		// 1，得出桶的个数
		// [start，end) 内有 num 个数
		int num = end - start;
		// 如果 rate 的值使得每个桶中的元素不是概率相等
		rate = num % rate == 0 ? rate : DEFAULT_RATE;
		// 桶的个数
		int bucketNum = num / rate;
		// 2，得出桶的间距
		// 选出最大值和最小值
		int min = data[start], max = data[start];
		for (int index = start + 1; index < end; index++) {
			min = min > data[index] ? data[index] : min;
			max = max < data[index] ? data[index] : max;
		}
		// [start，end] 间隔的数值总数 gap
		int gap = max - min + 1;
		// 扩大 gap，根据 gap % bucketNum == 0 的结果而定
		int remain = gap % bucketNum == 0 ? 0 : bucketNum - gap % bucketNum;
		frontEdge = min - remain / 2;
		rearEdge = max + (remain - remain / 2);
		// [start，end] -> [frontEdge，rearEdge]，改变 gap 的范围
		gap = rearEdge - frontEdge + 1;
		// 桶的间距
		bucketGap = gap / bucketNum;
		// 3，初始化桶列表
		initBuckteList(bucketNum);
		// 4，将所有的数据放入桶中
		for (int index = start; index < end; index++)
			enterBucket(data[index]);
		// 5，重写数据
		overwriteData(data, start, end);
	}

	@SuppressWarnings("unchecked")
	private void initBuckteList(int bucketNum) {
		bucketArr = new PriorityQueue[bucketNum];
	}

	private void enterBucket(int value) {
		int index = indexOf(value);
		PriorityQueue<Integer> buckte = bucketArr[index];
		// 延迟初始化
		if (buckte == null) {
			buckte = new PriorityQueue<Integer>(rate, type);
			bucketArr[index] = buckte;
		}
		// 插入数值
		buckte.insert(value);
	}

	private int indexOf(int value) {
		return (value - frontEdge) / bucketGap;
	}

	// 覆写数据
	private void overwriteData(int data[], int start, int end) {
		int i4data = start;
		if (type == BinaryHeapEnum.MIN_HEAP)
			for (int index = 0; index < bucketArr.length; index++)
				while (bucketArr[index] != null && !bucketArr[index].isEmpty())
					data[i4data++] = bucketArr[index].pop();
		else if (type == BinaryHeapEnum.MAX_HEAP)
			for (int index = bucketArr.length - 1; index >= 0; index--)
				while (bucketArr[index] != null && !bucketArr[index].isEmpty())
					data[i4data++] = bucketArr[index].pop();
	}

}
