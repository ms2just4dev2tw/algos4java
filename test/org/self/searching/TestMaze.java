package org.self.searching;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMaze {

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
	void testBFS() {
		System.out.println("广度优先");
		new Maze().BFS();
		System.out.println();
	}

	@Test
	void testDFS() {
		System.out.println("深度优先");
		new Maze().DFS();
		System.out.println();
	}

}
