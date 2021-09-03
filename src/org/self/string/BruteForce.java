package org.self.string;

/**
 * BF算法，又称简单匹配算法
 * <p>
 * 从目标串的第一个字符开始与模式串的第一个字符匹配，直到成功或失败
 * <p>
 * 若本次匹配失败，则从目标串的第二个字符开始与模式串的第一个字符匹配，依此类推
 * <p>
 * 最后根据模式串的匹配的index是否等于模式串长度返回结果
 * 
 * @author TungWang
 */
public class BruteForce {

	public BruteForce() {
	}

	/**
	 * 
	 * @param subject 主串，目标串
	 * @param template 模式串
	 * @return 目标串匹配模式串的起始位置
	 */
	public int index(String subject, String template) {
		char sub[] = subject.toCharArray(), tmp[] = template.toCharArray();
		//
		int indexi = 0, indexj = 0;
		for (; indexi < sub.length && indexj < tmp.length;) {
			if (sub[indexi++] != tmp[indexj++]) { // 这里隐含了匹配成功的结果
				// 匹配失败，就修改sub的索引
				indexi = indexi - indexj + 1;
				indexj = 0;
			}
		}
		// 返回结果
		return indexj == tmp.length ? indexi - indexj : -1;
	}

}
