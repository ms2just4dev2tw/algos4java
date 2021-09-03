package org.self.random;

/**
 * 伪随机数生成器
 * 
 * @author TungWang
 */
public interface PseudoRandomNumberGenerator {

	long next();

	int next(int bits);

}
