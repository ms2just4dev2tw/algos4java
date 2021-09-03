package org.self;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * FCC Advanced Algorithm Scripting 的高级算法
 * 
 * @see <a href="https://www.freecodecamp.cn/challenges/no-repeats-please">详情可以点击链接 </a>
 * @author Administrator
 */
public class NoRepeatsPlease {

	private String str;

	private NoRepeatsPlease() {
	}

	// 输入字符串
	public void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			str = br.readLine();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 开始计算
	public void workout() {
		// 找出每一个重复字符的个数
		char[] ch = str.toCharArray();

		// 计算重复字符涉及的排列

		// 根据情况输出
	}

}
