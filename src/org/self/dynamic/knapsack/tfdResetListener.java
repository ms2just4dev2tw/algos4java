package org.self.dynamic.knapsack;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

/**
 * 所有文本框的字符重置为空的监听器
 * 
 * @author TungWang
 */
public class tfdResetListener extends MouseAdapter {

	private JTextField tfd;

	public tfdResetListener(JTextField tfd) {
		this.tfd = tfd;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		tfd.setText("");
	}

}
