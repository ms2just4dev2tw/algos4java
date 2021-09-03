package org.self.random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TestMajorityElement {

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

	@RepeatedTest(value = 10)
	void test() {
		System.out.println("一般概率");
		MajorityElement me = new MajorityElement();
		int array[] = { 1, 3, 3, 4, 3, 6, 3, 3, 3, 10 };
		int trueCount = 0, falseCount = 0;
		for (int times = 0; times < 100; times++)
			if (me.MonteCarlo(array) == true)
				trueCount++;
			else
				falseCount++;
		System.out.println("true" + trueCount);
		System.out.println("false" + falseCount);
		System.out.println();
	}

	@RepeatedTest(value = 4)
	void testProbability() {
		System.out.println("提高概率");
		MajorityElement me = new MajorityElement();
		int array[] = { 1, 3, 3, 4, 3, 6, 3, 3, 3, 10 };
		int trueCount = 0, falseCount = 0;
		for (int times = 0; times < 100; times++)
			if (me.MonteCarlo(array) | me.MonteCarlo(array) | me.MonteCarlo(array))
				trueCount++;
			else
				falseCount++;
		System.out.println("true" + trueCount);
		System.out.println("false" + falseCount);
		System.out.println();
	}
}
