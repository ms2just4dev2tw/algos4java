package org.self.random;

/**
 * 随机数
 * 
 * @author TungWang
 */
public class RandomNumber {

	private PseudoRandomNumberGenerator prng;

	public RandomNumber() {
		prng = new LinearCongruentialGenerator();
	}

	public RandomNumber(PseudoRandomNumberGenerator prng) {
		this.prng = prng;
	}

	public int nextInt() {
		return prng.next(32);
	}

	public int nextInt(int bound) {
		if (bound <= 0)
			throw new IllegalArgumentException("bound is less than and equal of 0");

		int r = prng.next(31);
		int m = bound - 1;
		if ((bound & m) == 0) // bound 是 2 的倍数
			r = (int) ((bound * (long) r) >> 31);
		else {
			int u = r;
			r = u % bound;
			while (u - r + m < 0) {
				u = prng.next(31);
				r = u % bound;
			}
		}
		return r;
	}

	public long nextLong() {
		return ((long) (prng.next(32)) << 32) + prng.next(32);
	}

	public boolean nextBoolean() {
		return prng.next(1) != 0;
	}

	/**
	 * @return [0,1]之间的 float 值
	 */
	public float nextFloat() {
		return prng.next(24) / ((float) (1 << 24));
	}

	/**
	 * @return [0,1]之间的 double 值
	 */
	public double nextDouble() {
		// 1.0 / (1L << 53)
		double DOUBLE_UNIT = 0x1.0p-53;
		return (((long) (prng.next(26)) << 27) + prng.next(27)) * DOUBLE_UNIT;
	}

}
