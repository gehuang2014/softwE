package de.htwg.minesweeper;

import de.htwg.minesweeper.controller.IController;
import de.htwg.minesweeper.view.tui.TextUI;

public class Minesweeper {

	public static void main(String[] args) {
		TextUI tui = new TextUI(new Controller());
		boolean quit = false;
		tui.printStart();

		while (!quit) {
			quit = tui.printTUI();
		}
		
	}

}
