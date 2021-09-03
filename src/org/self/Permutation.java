package org.self;

/**
 * 
 * Permutation 排列
 * 
 * @author Administrator
 *
 */
public class Permutation {

	private Permutation() {
	}

	/**
	 * 
	 * @param length 集合长度
	 * @return 集合的排列方式的计数
	 */
	public int getCount(int length) {
		int count = 1;

		do {
			count *= length;
			length--;
		} while (length > 0);

		return count;
	}

	/**
	 * 
	 * @param array 数组
	 * @return 数组的排列方式
	 */
	public int getPermutation(int[] array) {
		return 0;
	}
}
