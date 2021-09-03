package org.self.dynamic.knapsack;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class btnVolumeListener extends MouseAdapter {

	private JLabel lblVolume;
	private JTextField tfdVolume;
	private GraphicalUserInterface gui;
	// 物品的序列号和体积
	private int number, volume;

	public btnVolumeListener(JLabel lblVolume, JTextField tfdVolume, GraphicalUserInterface gui) {
		this.gui = gui;
		this.lblVolume = lblVolume;
		this.tfdVolume = tfdVolume;
		number = 1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 1) {
			if (tfdVolume.getText().equals("") || tfdVolume.getText().equals("体积"))
				JOptionPane.showMessageDialog(gui, "请输入体积", "提示", JOptionPane.ERROR_MESSAGE);
			else if (!Pattern.matches("^\\d+", tfdVolume.getText()))
				JOptionPane.showMessageDialog(gui, "输入整数", "警告", JOptionPane.WARNING_MESSAGE);
			else {
				gui.inroRepository(number++, 0, Integer.parseInt(tfdVolume.getText()));
				tfdVolume.setText("");
				lblVolume.setText("输入" + number + "号物品体积");
			}
		}
	}

	public int getNumber() {
		return number;
	}

	public int getVolume() {
		return volume;
	}

}
