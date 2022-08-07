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

	/**
	 * @param subject 主串，目标串
	 * @param template 模式串
	 * @param Optimized 开启优化
	 * @return 目标串匹配模式串的起始位置
	 */
	public static int index(String subjectStr, String templateStr, boolean Optimized) {
		// 字符串转换成字符数组
		char subCharArr[] = subjectStr.toCharArray(), tmplCharArr[] = templateStr.toCharArray();
		// 部分匹配表
		int[] partialMatchTable = null;
		if (Optimized)
			partialMatchTable = getOptimizedPartialMatchTable(tmplCharArr);
		else
			partialMatchTable = getPartialMatchTableBy(tmplCharArr);

		// 主串和模式串的索引
		int index4sub = 0, index4tmpl = 0;
		// 主串索引超过主串字符数组的最大索引, 即意味着匹配失败; 模式串索引超过模式串字符数组的最大索引, 即意味着匹配成功
		while (index4sub < subCharArr.length && index4tmpl < tmplCharArr.length) {
			if (index4sub == -1 || subCharArr[index4sub] == tmplCharArr[index4tmpl]) {
				index4sub++;
				index4tmpl++;
			} else
				index4sub = partialMatchTable[index4tmpl];
		}

		// 返回结果
		return index4tmpl == tmplCharArr.length ? index4sub - index4tmpl : -1;
	}

	/**
	 *            a a a a b
	 * index4pmt  0 1 2 3 4
	 * pmtValue  -1 0 1 2 3
	 * 
	 * @param tmplCharArr
	 * @return
	 */
	public static int[] getPartialMatchTableBy(char[] tmplCharArr) {
		int[] partialMatchTable = new int[tmplCharArr.length];

		// 部分匹配表的首项值为 -1
		partialMatchTable[0] = -1;

		// index4pmt: 部分匹配表的索引, 即 tmplCharArr 下标值; pmtValue: 部分匹配表存储的模式串索引
		for (int index4pmt = 0, pmtValue = -1; index4pmt < tmplCharArr.length - 1;) {
			// 如果 index4pmt 指向的 tmplChar 与 pmtValue 指向的 tmplChar 相同, 则 index4pmt 与 pmtValue
			// 步进
			if (pmtValue == -1 || tmplCharArr[index4pmt] == tmplCharArr[pmtValue]) {
				partialMatchTable[++index4pmt] = ++pmtValue;
			} else {
				// 将 pmtValue 回退到之前的 partialMatchTable[pmtValue]
				pmtValue = partialMatchTable[pmtValue];
			}
		}

		return partialMatchTable;
	}

	/**
	 *            a  a  a  a  b
	 * index4pmt  0  1  2  3  4
	 * pmtValue  -1 -1 -1 -1  3
	 * 
	 * @param tmplCharArr
	 * @return
	 */
	public static int[] getOptimizedPartialMatchTable(char[] tmplCharArr) {
		int[] partialMatchTable = new int[tmplCharArr.length];

		// 部分匹配表的首项值为 -1
		partialMatchTable[0] = -1;

		// index4pmt: 部分匹配表的索引, 即 tmplCharArr 下标值; pmtValue: 部分匹配表存储的模式串索引
		for (int index4pmt = 0, pmtValue = -1; index4pmt < tmplCharArr.length - 1;) {
			// 如果 index4pmt 指向的 tmplChar 与 pmtValue 指向的 tmplChar 相同, 则 index4pmt 与 pmtValue
			// 步进
			if (pmtValue == -1 || tmplCharArr[index4pmt] == tmplCharArr[pmtValue]) {
				index4pmt++;
				pmtValue++;
				// 如果 index4pmt 与 pmtValue 步进的情况与之前的情况一样相同, 则使用 pmtValue 的指向与 index4pmt 对应
				// 否则使用 pmtValue 作为 index4pmt 的值
				if (tmplCharArr[index4pmt] == tmplCharArr[pmtValue])
					partialMatchTable[index4pmt] = partialMatchTable[pmtValue];
				else
					partialMatchTable[index4pmt] = pmtValue;
			} else {
				// 将 pmtValue 回退到之前的 partialMatchTable[pmtValue]
				pmtValue = partialMatchTable[pmtValue];
			}
		}

		return partialMatchTable;
	}

}
