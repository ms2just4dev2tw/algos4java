package org.self.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 接收字符串并输出序列
 * 
 * @author TungWang
 */
public class StringUtil {

	private int[] data;

	public StringUtil() {
	}

	/**
	 * 接收排序序列
	 * 
	 * @return
	 */
	public int[] inputString() {
		String str = null;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			str = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outputData(str);
	}

	/**
	 * 输出过滤后的数据
	 * 
	 * @param str
	 * @return
	 */
	private int[] outputData(String str) {
		String[] array = str.split("[^\\d]{1,}");
		data = new int[array.length];

		for (int i = 0; i < array.length; i++)
			data[i] = Integer.parseInt(array[i]);
		return data;
	}

	/**
	 * @deprecated
	 * @return
	 */
	@Deprecated
	public String[] stringGet() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(isr);
		String s;
		String[] array = null;

		try {
			System.out.println("请输入数组列表");
			s = reader.readLine();
			int count = 0;
			String stringtemp = s;
			char[] c = stringtemp.toCharArray();
			for (int i = 0; i < c.length; i++) {
				if (Character.isDigit(c[i])) {
				} else {
					if (i + 1 < c.length) {
						if (Character.isDigit(c[i + 1])) {
							count++;
						}
					}
					continue;
				}
			}

			array = new String[count + 1];
			for (int i = 0; i < array.length; i++) {
				array[i] = "";
			}

			count = 0;
			for (int i = 0; i < c.length; i++) {
				if (Character.isDigit(c[i])) {
					array[count] = array[count] + String.valueOf(c[i]);
				} else {
					if (i + 1 < c.length) {
						if (Character.isDigit(c[i + 1])) {
							count++;
						}
					}
					continue;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return array;
	}
}
