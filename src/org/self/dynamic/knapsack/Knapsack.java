package org.self.dynamic.knapsack;

import java.util.List;

public class Knapsack {

	// 背包体积容量
	private int capacity;
	// 数据模型的仓库
	private List<Material> repository;
	// 当前容量Capacity下选择物品 i 的最优值，max使用二维数组保存，optimal使用一维数组保存
	private int max[][], optimal[];

	public Knapsack(List<Material> repository) {
		this.repository = repository;
	}

	/**
	 * 使用max保存计算过程中每一步的结果
	 * <p>
	 * 完全版本的动态规划过程
	 */
	public String[][] calculate() {
		String data[][] = tableData();
		int length = repository.size();
		max = new int[length + 1][capacity + 1];
		// 初始化
		for (int i = 0; i <= capacity; i++)
			max[0][i] = 0;
		for (int i = 1; i <= length; i++)
			max[i][0] = 0;
		// 动态规划
		for (int i = 1; i <= length; i++) {// 从第一个物品到最后一个物品
			// 为data设置一些字符串
			for (int j = 1; j <= capacity; j++)
				data[j][i + 1] = "m[" + j + "][" + i + "]: m[" + (j - 1) + "][" + i + "]";
			//
			for (int c = 1; c <= capacity; c++) { // 从容量1到最大容量capacity
				int value = repository.get(i - 1).getValue(), volume = repository.get(i - 1).getVolume();
				if (volume > c) // 如果当前物品 i 的体积超过了当前容量 c，就沿用上个 i 的最优值
					max[i][c] = max[i - 1][c];
				else { // 从{max[i - 1][c]，max[i - 1][c - volume] + value}中选择最大值
					int newValue = max[i - 1][c - volume] + value;
					max[i][c] = newValue > max[i - 1][c] ? newValue : max[i - 1][c];
					// 当max[i][c]的值更新为newValue时，设置个特殊的字符串
					if (newValue > max[i - 1][c])
						data[c][i + 1] = "m[" + c + "][" + i + "]: m[" + (c - volume) + "][" + (i - 1) + "]+value" + i
								+ "=" + newValue;
				}
			}
		}
		return data;
	}

	/**
	 * 使用optimal保存一行数据就行
	 * <p>
	 * 优化一些非必要的操作
	 */
	public String[][] optimal() {
		int length = repository.size();
		optimal = new int[capacity + 1];
		// 初始化
		for (int i = 0; i <= capacity; i++)
			optimal[i] = 0;
		// 动态规划
		for (int i = 0; i <= length; i++) { // 从第一个物品到最后一个物品
			// 为data设置一些字符串

			//
			int value = repository.get(i - 1).getValue(), volume = repository.get(i - 1).getVolume();
			for (int c = volume; c <= capacity; c++) { // 对于容量 c 小于volume的情况，直接跳过
				int newValue = max[i - 1][c - volume] + value;
				max[i][c] = newValue > max[i - 1][c] ? newValue : max[i - 1][c];
				// 当max[i][c]的值更新为newValue时，设置个特殊的字符串

			}
		}
		return null;
	}

	// 生成一个表数据
	private String[][] tableData() {
		String data[][] = new String[capacity + 1][repository.size() + 2];
		// 初始化一些数据
		for (int i = 1; i < data.length; i++) {
			data[i][0] = "容量：" + i;
			data[i][1] = "m[" + i + "][1]：0";
		}
		for (int i = 1; i < repository.size() + 2; i++)
			data[0][i] = "m[0][" + (i - 1) + "]：0";
		return data;
	}

	public String[] getTableHeader() {
		String header[] = new String[repository.size() + 2];
		header[0] = "";
		header[1] = "";
		for (int i = 2; i < header.length; i++) {
			Material m = repository.get(i - 2);
			header[i] = "物品(" + i + ") 价值(" + m.getValue() + ") 体积(" + m.getVolume() + ")";
		}
		return header;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
