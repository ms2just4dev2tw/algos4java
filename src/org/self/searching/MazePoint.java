package org.self.searching;

public class MazePoint {

	// 节点的 行，列
	private int row, col;
	private int hashCode;

	public MazePoint(int row, int col) {
		this.col = col;
		this.row = row;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	public boolean equals(Object obj) {
		MazePoint p = (MazePoint) obj;
		return row == p.row && col == p.col;
	}

	// 重写 equals 同时也应该重写 hashCode
	@Override
	public int hashCode() {
		int result = hashCode;
		if (result == 0) {
			result = Integer.hashCode(row);
			result = 31 * result + Integer.hashCode(col);
			hashCode = result;
		}
		return result;
	}

	@Override
	public String toString() {
		return "(" + row + " , " + col + ")";
	}

}
