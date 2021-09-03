package org.self.random;

/**
 * Las Vegas 的皇后问题
 * 
 * @author TungWang
 */
public class Queen {

	private int n;
	// row: point 的索引；column: point 的值
	private int point[];

	public Queen() {
		this(8); // 默认 8 皇后
	}

	public Queen(int n) {
		if (n < 4)
			throw new IllegalArgumentException("n must great than 3");
		this.n = n;
		point = new int[n];
		//
		for (int index = 0; index < n; index++)
			point[index] = -1;
	}

	public int compute() {
		// current: 当前: count: 解的计数
		int count = 0;
		for (int row = 0; row >= 0;) {
			// 找到一个解
			if (row == n) {
				count++;
				display(count);
				row = backtrack(row - 1);
			}
			for (int col = point[row] + 1; col <= n; col++) {
				if (col == n) {
					// 当前行找不到合适的位置，先将当前行设为-1，再向上回溯
					point[row--] = -1;
					break;
				}
				if (isPlace(row, col)) {
					// 放置皇后，并移到下一行
					point[row++] = col;
					break;
				}
			}
		}
		return count;
	}

	private void display(int count) {
		System.out.println("第" + count + "个解");
		for (int index = 0; index < n; index++) {
			System.out.print("[" + (index + 1) + " ," + point[index] + "]  ");
		}
		System.out.println("\r\n");
	}

	/**
	 * 如果在前位的 point 的值大于后位的 point 的值，说明前位的 point 已经试验过后位值的情况
	 * 
	 * @param index 
	 * @return 回溯到一个没有试验过的行
	 */
	private int backtrack(int index) {
		int after = point[index];
		for (int i = index - 1; i >= 0; i--) {
			int before = point[i];
			point[i + 1] = -1;
			if (before < after)
				return i;
			after = before;
		}
		return -1;
	}

	/**
	 * @param row 行
	 * @param col 列
	 * @return 返回在 row 行 col 列能否放置元素
	 */
	private boolean isPlace(int row, int col) {
		// 从之前已经放置的皇后中找出冲突
		for (int index = 0; index < row; index++)
			// 该位置若满足同列或同斜线
			if (point[index] == col || Math.abs(index - row) == Math.abs(point[index] - col))
				return false;
		return true;
	}

}
