package org.self.random;

/**
 * 线性同余生成器
 * <p>
 * gcd(乘数,模数) = 1,
 * 
 * @author TungWang
 * @see java.util.Random
 */
public class LinearCongruentialGenerator implements PseudoRandomNumberGenerator {

	// 乘数为素数，25214903917
	private static final long multiplier = 0x5DEECE66DL;
	// 加数
	private static final long addend = 0b1011L;
	// 模数为机器大数，也是随机数的周期
	private static final long mask = (1L << 48) - 1;

	// 种子
	private long seed;

	public LinearCongruentialGenerator() {
		this(0);
	}

	public LinearCongruentialGenerator(long seed) {
		// 如果 seed == 0，就用系统时间产生种子
		if (seed == 0)
			this.seed = System.nanoTime();
		else
			this.seed = seed;
	}

	@Override
	public long next() {
		seed = (seed * multiplier + addend) & mask;
		return seed;
	}

	@Override
	public int next(int bits) {
		// >>> 无符号右移，高位补0
		return (int) (next() >>> (48 - bits));
	}

}
