package org.self.sorting;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBucketSort {

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
		System.out.println("BucketSort - ASCEND");
		int data[] = { 5, 9, 17, 19, 2, 11, 13, 22, 7, 15 };
		display(data);
		new BucketSort().sort(data, 4, 9);
		display(data);
	}

	@Test
	void testDescend() {
		System.out.println("BucketSort - DESCEND");
		int data[] = { 5, 9, 17, 19, 2, 11, 13, 22, 7, 15 };
		display(data);
		new BucketSort(SortType.DESCEND).sort(data, 4, 9);
		display(data);
	}

	private void display(int data[]) {
		for (int i = 0; i < data.length; i++)
			System.out.print(data[i] + "\t");
		System.out.println();
	}

}
