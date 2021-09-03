/**
 * <h3>插入排序</h3>
 * <p>
 * <ul>
 * 		<i>{@link org.self.sorting.StraightInsertionSort 直接插入排序}</i>
 * 		<p>
 * 		<i>{@link org.self.sorting.BinaryInsertionSort 折半插入排序}</i>
 * 		<p>
 * 		<i>{@link org.self.sorting.ShellSort 希尔排序}</i>
 * </ul>
 * 
 * <h3>交换排序</h3>
 * <p>
 * <ul>
 * 		<i>{@link org.self.sorting.BubbleSort 冒泡排序}</i>
 * 		<p>
 *  	<i>{@link org.self.sorting.QuickSort 快速排序}</i>
 * </ul>
 * 
 * <h3>选择排序</h3>
 * <p>
 * <ul>
 * 		<i>{@link org.self.sorting.StraightSelectSorting 直接选择排序}</i>
 * 		<p>
 * 		<i>{@link org.self.sorting.HeapSort 堆排序}</i>
 * </ul>
 * 
 * <h3>归并排序</h3>
 * <p>
 * {@link org.self.sorting.MergeSort 归并排序}
 * 
 * <h3>基数排序</h3>
 * <p>
 * {@link org.self.sorting.RadixSort 基数排序}
 * 
 * <h3>性能比较</h3>
 * <p>
 * 排序方法 平均情况 最坏情况 最坏情况 空间复杂度 稳定性 复杂性
 * <p>
 * 直接插入 O(n2) ----O(n2) --O(n) -----O(1) -------稳定 --简单
 * <p>
 * 希尔 -----O(n1.3) ----------------------O(1) -------不稳定 较复杂
 * <p>
 * 冒泡 -----O(n2) ----O(n2) ---O(n) ----O(1) -------稳定 --简单
 * <p>
 * 快速 -----O(nlog2(n)) O(n2) O(nlog2(n)) O(nlog2(n)) 不稳定 较复杂
 * <p>
 * 直接选择 O(n2) ----O(n2) --O(n2) -----O(1) ------不稳定 简单
 * <p>
 * 堆 O(nlog2(n)) O(nlog2(n)) O(nlog2(n)) O(1) ----不稳定 较复杂
 * <p>
 * 归并 O(nlog2(n)) O(nlog2(n)) O(nlog2(n)) O(n) --稳定 较复杂
 * <p>
 * 基数 -----O(d(n+r)) O(d(n+r)) O(d(n+r)) O(r) 稳定 较复杂
 * 
 */
package org.self.sorting;
