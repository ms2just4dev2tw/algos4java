package org.self.sorting;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBubbleSort {

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
	void testAscend() {
		System.out.println("BubbleSort - ASCEND");
		int data[] = { 6, 8, 7, 9, 0, 1, 3, 2, 4, 5 };
		display(data);
		new BubbleSort().sort(data);
		display(data);
	}

	@Test
	void testDescend() {
		System.out.println("BubbleSort - DESCEND");
		int data[] = { 6, 8, 7, 9, 0, 1, 3, 2, 4, 5 };
		display(data);
		new BubbleSort(SortType.DESCEND).sort(data);
		display(data);
	}

	private void display(int data[]) {
		for (int i = 0; i < data.length; i++)
			System.out.print(data[i] + "\t");
		System.out.println();
	}

}
