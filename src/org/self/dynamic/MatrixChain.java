package org.self.dynamic;

/**
 * 矩阵连乘问题
 * <p>
 * 有一个矩阵连乘例子：A1(30x35)A2(35x15)A3(15x5)A4(5x10)A5(10x20)A6(20x25)
 * <p>
 * 0(0)	15750(1)	7875(2)		9375(3)		11875(4)	15125(5)
 * 			0(0)			2625(1)		4375(2)		7125(3)		10500(4)
 * 							0(0)			750(1)		2500(2)		5375(3)
 * 											0(0)			1000(1)		3500(2)
 * 															0(0)			5000(1)
 * 																			0(0)
 * 
 * @author TungWang
 */
public class MatrixChain {

	// 压缩存储矩阵上三角元素
	private class TriangleArray {
		// rank: 矩阵的阶；array: 存储的数据
		private int rank, array[];

		private TriangleArray(int rank) {
			this.rank = rank;
			int length = (rank + 1) * rank / 2 + rank % 2 * (rank + 1) / 2;
			array = new int[length];
		}

		private void setValue(int start, int end, int value) {
			int triangleLen = rank - start;
			// triangle是 start下面的小三角拥有元素的个数或者说是面积
			int triangle = triangleLen / 2 * (triangleLen + 1) + triangleLen % 2 * (triangleLen + 1) / 2;
			int index = array.length - triangle + end - start;
			array[index] = value;
		}

		private int getValue(int start, int end) {
			int triangleLen = rank - start;
			// triangle是 start 下面的小三角拥有元素的个数或者说是面积
			int triangle = triangleLen / 2 * (triangleLen + 1) + triangleLen % 2 * (triangleLen + 1) / 2;
			return array[array.length - triangle + end - start];
		}
	}

	// 矩阵元素
	private class Matrix {
		private int row;
		private int column;

		private Matrix(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}

	private Matrix array[];
	private TriangleArray triangleArray;

	// 默认的初始化方式
	public MatrixChain() {
		array = new Matrix[6];
		array[0] = new Matrix(30, 35);
		array[1] = new Matrix(35, 15);
		array[2] = new Matrix(15, 5);
		array[3] = new Matrix(5, 10);
		array[4] = new Matrix(10, 20);
		array[5] = new Matrix(20, 25);
		triangleArray = new TriangleArray(6);
	}

	public MatrixChain(Matrix[] array) {
		this.array = array;
		triangleArray = new TriangleArray(array.length);
	}

	public void calculate() {
		// 初始化边界zero
		for (int i = 0; i < array.length; i++)
			triangleArray.setValue(i, i, 0);

		// 逐次求解m[row][column]的最小值
		for (int gap = 1; gap < array.length; gap++)
			for (int row = 0, column = row + gap; column < array.length; row++, column++) {
				triangleArray.setValue(row, column, Integer.MAX_VALUE);
				// 从m[row][row+x]+m[row+x+1][column]+p1xp2xp3中找出m[row][column]的最小值
				for (int x = row; x < column; x++) {
					int newValue = triangleArray.getValue(row, x) + triangleArray.getValue(x + 1, column);
					newValue += array[row].row * array[x].column * array[column].column;
					if (newValue < triangleArray.getValue(row, column))
						triangleArray.setValue(row, column, newValue);
				}
			}
		displayTriangleArray();
	}

	private void displayTriangleArray() {
		for (int row = 0; row < triangleArray.rank; row++) {
			for (int column = row; column < triangleArray.rank; column++)
				System.out.print("    " + triangleArray.getValue(row, column));
			System.out.println();
		}
	}

}
