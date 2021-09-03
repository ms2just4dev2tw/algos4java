package org.self.dynamic.knapsack;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class btnCapacityListener extends MouseAdapter {

	private JTextField tfdCapacity;
	private GraphicalUserInterface gui;

	public btnCapacityListener(JTextField tfdCapacity, GraphicalUserInterface gui) {
		this.gui = gui;
		this.tfdCapacity = tfdCapacity;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 1) {
			if (tfdCapacity.getText().equals("") || tfdCapacity.getText().equals("背包总体积"))
				JOptionPane.showMessageDialog(gui, "请输入背包总体积", "提示", JOptionPane.ERROR_MESSAGE);
			else if (!Pattern.matches("^\\d+", tfdCapacity.getText()))
				JOptionPane.showMessageDialog(gui, "输入整数", "警告", JOptionPane.WARNING_MESSAGE);
			else {
				gui.prepare(Integer.parseInt(tfdCapacity.getText()));
				tfdCapacity.setText("");
			}
		}
	}

}
