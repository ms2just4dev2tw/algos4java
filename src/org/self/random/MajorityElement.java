package org.self.random;

/**
 * 主元素问题
 * 
 * @author TungWang
 */
public class MajorityElement {

	private RandomNumber rn;

	public MajorityElement() {
		rn = new RandomNumber();
	}

	public boolean compute(int array[]) {
		for (int index = 0; index < array.length; index++)
			if (isMajority(index, array))
				return true;
		return false;
	}

	/**
	 * Monte Carlo 蒙特卡罗算法
	 * 
	 * @param array 数组
	 * @return array 是否是主元素数组
	 */
	public boolean MonteCarlo(int array[]) {
		int index = rn.nextInt(array.length);
		return isMajority(index, array);
	}

	/**
	 * @param index 索引
	 * @param array 数组
	 * @return 在 index 处的元素是否是主元素
	 */
	private boolean isMajority(int index, int array[]) {
		int major = array[index], count = 0;
		for (int i = 0; i < array.length; i++)
			if (array[i] == major)
				count++;
		return count > (array.length / 2);
	}

}
