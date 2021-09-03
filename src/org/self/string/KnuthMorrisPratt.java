package org.self.string;

/**
 * KMP算法，D.E.Knuth,J.H.Morris,V.R.Pratt
 * <p>
 * 相较于BF匹配，KMP保留了部分匹配的结果，不会
 * 
 * 
 * @author TungWang
 */
public class KnuthMorrisPratt {

	// 保留部分匹配信息的next数组
	private int next[];

	public KnuthMorrisPratt() {
	}

	// 一般的KMP算法
	public int index(String subject, String template) {
		return index(subject, template, false);
	}

	/**
	 * 
	 * @param subject 主串，目标串
	 * @param template 模式串
	 * @param Optimized 开启优化
	 * @return 目标串匹配模式串的起始位置
	 */
	public int index(String subject, String template, boolean Optimized) {
		char sub[] = subject.toCharArray(), tmp[] = template.toCharArray();
		if (Optimized)
			initNextOptimize(tmp);
		else
			initNext(tmp);
		//
		int indexi = 0, indexj = 0;
		for (; indexi < sub.length && indexj < tmp.length;) {
			if (indexj == -1 || sub[indexi] == tmp[indexj]) {
				indexi++;
				indexj++;
			} else
				indexj = next[indexj];
		}
		// 返回结果
		return indexj == tmp.length ? indexi - indexj : -1;
	}

	/**
	 * 这个是一般的初始化next数组的方法
	 * <p>
	 * 在 0 < index < j 时有<p>
	 * next[index] = MAX{k | "t0t1......t(k-1)" == "t(index-k)t(index-k+1)......t(index-1)"}
	 * <p>
	 * 在index = 0 时有<p>
	 * next[index] = -1
	 * <p>
	 * 其他情况<p>
	 * next[index] = 0
	 * 
	 * @param tmp 模式串的字符数组
	 */
	private void initNext(char tmp[]) {
		next = new int[tmp.length];
		next[0] = -1;
		for (int j = 0, k = -1; j < tmp.length - 1;) {
			if (k == -1 || tmp[j] == tmp[k]) {
				j++;
				k++;
				next[j] = k;
			} else
				k = next[k];
		}
	}

	/**
	 * 对于 aaaab这样的模式串和主串aaabaaaab
	 * <p>
	 * 如果在<b>i=3，j=3</b>处匹配失败， 会使得 i 的值保持不变，j的值变为next[j] = 2
	 * <p>
	 * 上面的情况会多次发生，直到<b> i 的值变为4，j 的值变为0</b>
	 * <p>
	 * 对于这样的情况，需要对于tmp[j] == tmp[k]这样的情况使得next[j] = next[k];
	 * 
	 * @param tmp
	 */
	private void initNextOptimize(char tmp[]) {
		next = new int[tmp.length];
		next[0] = -1;
		for (int j = 0, k = -1; j < tmp.length - 1;) {
			if (k == -1 || tmp[j] == tmp[k]) {
				j++;
				k++;
				if (tmp[j] != tmp[k])
					next[j] = k;
				else
					next[j] = next[k];
			} else
				k = next[k];
		}
	}

}
