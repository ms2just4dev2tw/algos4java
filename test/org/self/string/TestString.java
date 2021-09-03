package org.self.string;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestString {

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
	void testBruteForce() {
		BruteForce bf = new BruteForce();
		System.out.println(bf.index("aaaaab", "aaab"));
		System.out.println(bf.index("ababcabcacbab", "abcac"));
		System.out.println(bf.index("abc", "ac"));
		System.out.println(bf.index("abc", "abcd"));
		System.out.println();
	}

	@Test
	void testKnuthMorrisPratt() {
		KnuthMorrisPratt kmp = new KnuthMorrisPratt();
		System.out.println(kmp.index("aaaaab", "aaab"));
		System.out.println(kmp.index("aaaaab", "aaab", true));
		System.out.println(kmp.index("ababcabcacbab", "abcac"));
		System.out.println(kmp.index("ababcabcacbab", "abcac", true));
		System.out.println(kmp.index("abcaabbabcabaacbacba", "abcabaa"));
		System.out.println(kmp.index("abcaabbabcabaacbacba", "abcabaa", true));
		System.out.println();
	}

	/**
	 * 										  	x=0(j=1,2)		x=1(j=3)	x=2(j=4)	x=3(j=5)
	 * 初始化		0(A)	循环开始	j=1(B)	j=2(A)	j=1(B)	j=2(A)	j=1(C)
	 * 	输入表(A)	  1						   1		   3		   1		   5		   1
	 * 输入表(B)							   2		   0		   4		   0		   4
	 * 输入表(C)							   0		   0		   0		   0		   6
	 */
	@Test
	void testDFA() {
		System.out.println(new DFA("ABABAC").search("BCBAABACAABABACAA"));
		System.out.println();
	}

}
