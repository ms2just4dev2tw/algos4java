package org.self.dynamic.knapsack;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class btnStartListener extends MouseAdapter {

	private GraphicalUserInterface gui;

	public btnStartListener(GraphicalUserInterface gui) {
		this.gui = gui;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		gui.showTable();
	}

}
