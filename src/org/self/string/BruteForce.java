package org.self.string;

/**
 * BF算法，又称简单匹配算法
 * <p>
 * 从目标串的第一个字符开始与模式串的第一个字符匹配，直到成功或失败
 * <p>
 * 若本次匹配失败，则从目标串的第二个字符开始与模式串的第一个字符匹配，依此类推
 * <p>
 * 最后根据模式串匹配的 index 是否等于模式串长度返回结果
 * 
 * @author TungWang
 */
public class BruteForce {

	/**
	 * @param subjectStr 主串，目标串
	 * @param templateStr 模式串
	 * @return 目标串匹配模式串的起始位置
	 */
	public static int index(String subjectStr, String templateStr) {
		// 字符串转换成字符数组
		char subCharArr[] = subjectStr.toCharArray(), tmplCharArr[] = templateStr.toCharArray();

		// 主串和模式串的索引
		int index4sub = 0, index4tmpl = 0;
		// 主串索引超过主串字符数组的最大索引, 即意味着匹配失败; 模式串索引超过模式串字符数组的最大索引, 即意味着匹配成功
		while (index4sub < subCharArr.length && index4tmpl < tmplCharArr.length) {
			// 主串 index4sub 与模式串 index4tmpl 匹配后, index4sub 与 index4tmpl 步进
			if (subCharArr[index4sub++] != tmplCharArr[index4tmpl++]) {
				// 匹配失败后, 主串回溯到匹配之间的状态, 且主串 index4sub 步进
				index4sub = index4sub - index4tmpl + 1;
				// 匹配失败, 模式串 index4tmpl 重置为 0
				index4tmpl = 0;
			}
		}

		// 返回结果
		return index4tmpl == tmplCharArr.length ? index4sub - index4tmpl : -1;
	}

}
