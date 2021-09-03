package org.self.dynamic.knapsack;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class btnValueListener extends MouseAdapter {

	private JLabel lblValue;
	private JTextField tfdValue;
	private GraphicalUserInterface gui;
	// 物品的序列号和价值
	private int number, value;

	public btnValueListener(JLabel lblValue, JTextField tfdValue, GraphicalUserInterface gui) {
		this.gui = gui;
		this.lblValue = lblValue;
		this.tfdValue = tfdValue;
		number = 1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 1) {
			if (tfdValue.getText().equals("") || tfdValue.getText().equals("价值"))
				JOptionPane.showMessageDialog(gui, "请输入价值", "提示", JOptionPane.ERROR_MESSAGE);
			else if (!Pattern.matches("^\\d+", tfdValue.getText()))
				JOptionPane.showMessageDialog(gui, "输入整数", "警告", JOptionPane.WARNING_MESSAGE);
			else {
				gui.inroRepository(number++, Integer.parseInt(tfdValue.getText()), 0);
				tfdValue.setText("");
				lblValue.setText("输入" + number + "号物品价值");
			}
		}
	}

	public int getNumber() {
		return number;
	}

	public int getValue() {
		return value;
	}

}
