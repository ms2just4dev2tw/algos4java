package org.self.dynamic.knapsack;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 重置按钮监听器
 * 
 * @author TungWang
 */
public class btnResetListener extends MouseAdapter {

	private GraphicalUserInterface gui;

	public btnResetListener(GraphicalUserInterface gui) {
		this.gui = gui;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 1 && e.getClickCount() > 1)
			gui.reset();
	}

}
