package org.self.string;

/**
 * Deterministic Finite Automaton 确定有穷状态机
 * <p>
 * 1，非空有穷的状态集合
 * <p>
 * 2，非空有穷的输入字母表
 * <p>
 * 3，状态转移函数，DFA的状态转移函数对于每一个状态和输入只有一个转移结果
 * <p>
 * 4，初始状态
 * <p>
 * 5，终结状态集合
 * 
 * @author TungWang
 */
public class DFA {

	private final int R; // the radix
	private final int m; // length of pattern
	private int[][] dfa; // the KMP automoton

	/**
	 * 生成模式串的DFA数组
	 *
	 * @param 模式串
	 */
	public DFA(String pat) {
		this.R = 256; // 表示使用扩展ASCII码
		this.m = pat.length();

		// 生成模式串的DFA数组
		dfa = new int[R][m];
		dfa[pat.charAt(0)][0] = 1;
		for (int x = 0, j = 1; j < m; j++) {
			// 对于所有的输入字母表，这里是256个扩展ASCII码
			System.out.println(pat.charAt(j) + "x=" + x);
			for (int c = 0; c < R; c++)
				dfa[c][j] = dfa[c][x]; // 不匹配的结果，是返回重启的状态
			// 匹配的结果
			dfa[pat.charAt(j)][j] = j + 1;
			// 更新重启状态
			x = dfa[pat.charAt(j)][x];
		}
	}

	/**
	 * Returns the index of the first occurrrence of the pattern string
	 * in the text string.
	 *
	 * @param  txt the text string
	 * @return the index of the first occurrence of the pattern string
	 *         in the text string; N if no such match
	 */
	public int search(String txt) {
		// simulate operation of DFA on text
		int n = txt.length();
		int i, j;
		for (i = 0, j = 0; i < n && j < m; i++) {
			j = dfa[txt.charAt(i)][j];
		}
		if (j == m)
			return i - m; // found
		return n; // not found
	}

}
