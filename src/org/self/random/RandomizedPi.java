package org.self.random;

/**
 * 随机化的圆周率 Pi
 * <p>
 * 半径为1的圆在第一象限内，随机落入圆内的概率为 Pi * r * r / 4 * r * r
 * 
 * @author TungWang
 * @see Math#PI 圆周率，3.14159265358979323846
 */
public class RandomizedPi {

	private RandomNumber random;

	public RandomizedPi() {
		random = new RandomNumber();
	}

	public double compute(int times) {
		int count = 0;
		for (int i = 0; i < times; i++) {
			double x = random.nextDouble();
			double y = random.nextDouble();
			// 如果在圆内
			if (x * x + y * y <= 1)
				count++;
		}
		// 计算圆周率
		System.out.println(count);
		System.out.println(1 / (double) times);
		return 4 * count / (double) times;
	}

}
