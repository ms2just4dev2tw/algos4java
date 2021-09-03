package org.self.searching;

import java.util.ArrayList;

import org.self.queue.ArrayQueue;
import org.self.stack.ArrayStack;

public class Maze {

	private class MazePath {
		// 当前 point 在整个搜索路径中的下标
		private int sub;
		// 当前 point 在整个搜索路径中上一个 point 的下标，下标为 0 的 point 设置 pre 为 -1
		private int pre;
		private MazePoint point;

		public MazePath(MazePoint point, int sub, int pre) {
			this.pre = pre;
			this.sub = sub;
			this.point = point;
		}
	}

	// 迷宫的地图坐标数据
	private int map[][];
	// 迷宫的起点和终点
	private MazePoint start, end;

	public Maze() {
		int defaultMap[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 0, 1, 0, 0, 0, 1, 0, 1 }, { 1, 0, 0, 0, 0, 1, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, { 1, 0, 1, 0, 0, 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, };
		map = defaultMap;
		start = new MazePoint(1, 1);
		end = new MazePoint(8, 8);
	}

	public Maze(int map[][], MazePoint start, MazePoint end) {
		this.map = map;
		this.end = end;
		this.start = start;
	}

	// 广度优先搜索
	public void BFS() {
		ArrayQueue<MazePath> queue = new ArrayQueue<>();
		enterPoint(queue, start, 0, -1);
		// 如果队列中还有节点
		int sub = 0;
		do {
			MazePath tmp = queue.poll();
			int pre = tmp.sub;
			int row = tmp.point.getRow(), col = tmp.point.getCol();
			// 顺时针
			// 1，如果上面是通路，加入队列
			if (isPass(row - 1, col)) {
				MazePath next = new MazePath(new MazePoint(row - 1, col), ++sub, pre);
				enterPath(queue, next);
				// 找到出口
				if (findExport(queue, next))
					return;
			}
			// 2，如果右边是通路，加入队列
			if (isPass(row, col + 1)) {
				MazePath next = new MazePath(new MazePoint(row, col + 1), ++sub, pre);
				enterPath(queue, next);
				// 找到出口
				if (findExport(queue, next))
					return;
			}
			// 3，如果下面是通路，加入队列
			if (isPass(row + 1, col)) {
				MazePath next = new MazePath(new MazePoint(row + 1, col), ++sub, pre);
				enterPath(queue, next);
				// 找到出口
				if (findExport(queue, next))
					return;
			}
			// 4，如果左边是通路，加入队列
			if (isPass(row, col - 1)) {
				MazePath next = new MazePath(new MazePoint(row, col - 1), ++sub, pre);
				enterPath(queue, next);
				// 找到出口
				if (findExport(queue, next))
					return;
			}
		} while (!queue.isEmpty());
		System.out.println("BFS方式找不到路径");
	}

	// 深度有优先搜索
	public void DFS() {
		ArrayStack<MazePoint> stack = new ArrayStack<>();
		map[start.getRow()][start.getCol()] = -1;
		MazePoint tmp = start;
		// 如果栈为空，或者找到出口
		do {
			int row = tmp.getRow(), col = tmp.getCol();
			// 按照顺时针的顺序依次试探路径
			if (isPass(row - 1, col)) { // 1，上面
				tmp = nextPoint(stack, tmp, row - 1, col);
			} else if (isPass(row, col + 1)) { // 2，右边
				tmp = nextPoint(stack, tmp, row, col + 1);
			} else if (isPass(row + 1, col)) { // 3，下面
				tmp = nextPoint(stack, tmp, row + 1, col);
			} else if (isPass(row, col - 1)) { // 4，左边
				tmp = nextPoint(stack, tmp, row, col - 1);
			} else // 弹出栈
				tmp = stack.pop();
		} while (!stack.isEmpty() && !tmp.equals(end));
		// 将最后的 point 压入栈
		stack.push(tmp);
		//
		display(stack);
	}

	/**
	 * 地图中 row 行 col 列 是否是通路
	 * 
	 * @param row 行数
	 * @param col 列数
	 * @return
	 */
	private boolean isPass(int row, int col) {
		return map[row][col] == 0;
	}

	///
	private MazePoint nextPoint(ArrayStack<MazePoint> stack, MazePoint p, int row, int col) {
		stack.push(p);
		// 将访问过的节点标为 -1
		map[row][col] = -1;
		// 将 tmp 改为访问节点
		return new MazePoint(row, col);
	}

	private void enterPoint(ArrayQueue<MazePath> queue, MazePoint p, int sub, int pre) {
		enterPath(queue, new MazePath(p, sub, pre));
	}

	private void enterPath(ArrayQueue<MazePath> queue, MazePath path) {
		// 将访问过的节点标为 -1
		map[path.point.getRow()][path.point.getCol()] = -1;
		//
		queue.enter(path);
	}

	// 找到出口
	private boolean findExport(ArrayQueue<MazePath> queue, MazePath path) {
		if (path.point.equals(end)) {
			display(queue);
			return true;
		} else
			return false;
	}

	// 根据栈结构打印迷宫路径
	private void display(ArrayStack<MazePoint> stack) {
		if (stack.peek().equals(end))
			while (!stack.isEmpty())
				System.out.println(stack.pop());
		else
			System.out.println("DFS方式找不到路径");
	}

	// 根据队列打印迷宫路径
	private void display(ArrayQueue<MazePath> queue) {
		ArrayList<MazePath> array = new ArrayList<>();
		for (MazePath path : queue)
			array.add(path);
		//
		MazePath path = array.get(array.size() - 1);
		for (; path.pre != -1; path = array.get(path.pre))
			System.out.println(path.point);
		System.out.println(path.point);
	}

}
