package org.self.random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TestLCG {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@RepeatedTest(value = 4)
	void test() {
		System.out.println("==========线性同余法生成器==========");
		LinearCongruentialGenerator lcg = new LinearCongruentialGenerator();
		System.out.println(lcg.next());
		System.out.println("===============================\r\n");
	}

	@RepeatedTest(value = 10)
	void testRandomMask() {
		LinearCongruentialGenerator lcg = new LinearCongruentialGenerator();
		long first = lcg.next(), count = 1L;
		System.out.println("first=" + first);
		for (long tmp = lcg.next(); tmp != first; tmp = lcg.next()) {
			count++;
			System.out.println("tmp=" + tmp);
		}
		System.out.println(count);
	}

}
