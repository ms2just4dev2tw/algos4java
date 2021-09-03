package org.self.dynamic.knapsack;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * 图形用户界面
 * 
 * @author Administrator
 */
public class GraphicalUserInterface extends JFrame {

	private static final long serialVersionUID = 1L;

	// 主界面
	private JPanel pnlMain;
	// 输出界面
	private JScrollPane srpEast;
	// 输入界面
	private JPanel pnlMainWest;

	// 输入的各组件
	private JLabel lblVolume, lblValue, lblCapacity;
	private JTextField tfdVolume, tfdValue, tfdCapacity;
	private JButton btnVolume, btnValue, btnCapacity, btnStart, btnReset;

	// 输出表组件
	private JTable table;
	// 背包
	private Knapsack knapsack;
	// 物品仓库
	private List<Material> repository;

	// 2,2,6,5,4
	// 6,3,5,4,6
	public static void main(String[] args) {
		new GraphicalUserInterface().init();
	}

	public GraphicalUserInterface() {
		pnlMain = new JPanel(null);
		srpEast = new JScrollPane();
		pnlMainWest = new JPanel(null);
		// 初始化组件
		lblVolume = new JLabel("输入1号物品体积");
		lblVolume.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		lblValue = new JLabel("输入1号物品价值");
		lblValue.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		lblCapacity = new JLabel("输入背包总体积");
		lblCapacity.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		tfdVolume = new JTextField("体积");
		tfdValue = new JTextField("价值");
		tfdCapacity = new JTextField("背包总体积");
		btnVolume = new JButton("确定");
		btnVolume.setToolTipText("鼠标左键单击确定");
		btnValue = new JButton("确定");
		btnValue.setToolTipText("鼠标左键单击确定");
		btnCapacity = new JButton("确定");
		btnCapacity.setToolTipText("鼠标左键单击确定");
		btnStart = new JButton("计算");
		btnStart.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		btnStart.setEnabled(false);
		btnReset = new JButton("重置");
		btnReset.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		btnReset.setToolTipText("谨慎使用");
		// 初始化数据模型
		repository = new ArrayList<>();
		knapsack = new Knapsack(repository);
	}

	// 初始化方法
	public void init() {
		pnlMainWest.setBounds(1, 5, 179, 409);
		srpEast.setBounds(190, 5, 600, 409);
		lblVolume.setBounds(20, 5, 150, 20);
		tfdVolume.setBounds(20, 40, 70, 20);
		btnVolume.setBounds(100, 40, 60, 20);
		lblValue.setBounds(20, 100, 150, 20);
		tfdValue.setBounds(20, 135, 70, 20);
		btnValue.setBounds(100, 135, 60, 20);
		lblCapacity.setBounds(20, 205, 150, 20);
		tfdCapacity.setBounds(20, 240, 70, 20);
		btnCapacity.setBounds(100, 240, 60, 20);
		btnStart.setBounds(15, 355, 75, 40);
		btnReset.setBounds(100, 355, 75, 40);

		pnlMain.add(pnlMainWest);
		pnlMainWest.add(lblVolume);
		pnlMainWest.add(tfdVolume);
		pnlMainWest.add(btnVolume);
		pnlMainWest.add(lblValue);
		pnlMainWest.add(tfdValue);
		pnlMainWest.add(btnValue);
		pnlMainWest.add(lblCapacity);
		pnlMainWest.add(tfdCapacity);
		pnlMainWest.add(btnCapacity);
		pnlMainWest.add(btnStart);
		pnlMainWest.add(btnReset);
		pnlMain.add(srpEast);

		// 文本框事件监听
		tfdVolume.addMouseListener(new tfdResetListener(tfdVolume));
		tfdValue.addMouseListener(new tfdResetListener(tfdValue));
		tfdCapacity.addMouseListener(new tfdResetListener(tfdCapacity));

		// 按钮事件监听
		btnVolume.addMouseListener(new btnVolumeListener(lblVolume, tfdVolume, this));
		btnValue.addMouseListener(new btnValueListener(lblValue, tfdValue, this));
		btnCapacity.addMouseListener(new btnCapacityListener(tfdCapacity, this));
		btnStart.addMouseListener(new btnStartListener(this));
		btnReset.addMouseListener(new btnResetListener(this));

		// 窗口设置
		this.setSize(805, 460);
		this.setResizable(false);
		this.add(pnlMain);
		this.setLocation(300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	// 插入物品到仓库
	public void inroRepository(int number, int value, int volume) {
		if (repository.size() < number)
			repository.add(new Material(number, value, volume));
		else if (value != 0)
			repository.get(number - 1).setValue(value);
		else
			repository.get(number - 1).setVolume(volume);
	}

	// 开始准备计算
	public void prepare(int capacity) {
		this.knapsack.setCapacity(capacity);
		btnStart.setEnabled(true);
	}

	// 显示表格的方法
	public void showTable() {
		if (!btnStart.isEnabled())
			return;
		this.setVisible(false);
		String data[][] = knapsack.calculate();
		String columnName[] = knapsack.getTableHeader();
		DefaultTableModel tabmodel = new DefaultTableModel(data, columnName);
		table = new JTable(tabmodel);
		table.setRowSorter(new TableRowSorter<DefaultTableModel>(tabmodel));
		srpEast.setViewportView(this.table);
		this.setVisible(true);
	}

	// 界面重置的方法
	public void reset() {
		lblVolume.setText("输入1号物品体积");
		lblValue.setText("输入1号物品价值");
		tfdVolume.setText("");
		tfdValue.setText("");
		tfdCapacity.setText("");
		repository.clear();

		this.setVisible(false);
		this.table = null;
		srpEast.setViewportView(null);
		btnStart.setEnabled(false);
		this.setVisible(true);
	}

}
