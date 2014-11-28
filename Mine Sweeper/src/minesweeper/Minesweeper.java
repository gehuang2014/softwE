package minesweeper;

import minesweeper.controller.Controller;
import minesweeper.view.tui.TextUI;

public class Minesweeper {

	public static void main(String[] args) {
		TextUI tui = new TextUI(new Controller());
		boolean quit = false;

		while (!quit) {
			quit = tui.printTUI();
		}
		
	}

}
