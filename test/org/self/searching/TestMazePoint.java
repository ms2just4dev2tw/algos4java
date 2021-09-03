package org.self.searching;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMazePoint {

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
		MazePoint p1 = new MazePoint(0, 0);
		MazePoint p2 = new MazePoint(8, 8);
		MazePoint p3 = new MazePoint(8, 8);

		boolean b = p2 == p3;
		System.out.println(p1 == p2);
		System.out.println(b);
		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p3));
	}

}
