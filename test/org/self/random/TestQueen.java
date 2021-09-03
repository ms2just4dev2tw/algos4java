package org.self.random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestQueen {

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

	@Test
	void test() {
		Queen queen = new Queen(8);
		System.out.println(queen.compute());
	}

	void testContinue() {
		for (int i = 0; i < 5; i++)
			if (i == 2) {
				i++;
				System.out.println("continue");
				continue;
			} else
				System.out.println(i);
	}

}
