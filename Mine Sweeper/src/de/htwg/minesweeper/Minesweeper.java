package de.htwg.minesweeper;

import de.htwg.minesweeper.aview.gui.BaseFrame;
import de.htwg.minesweeper.aview.tui.TextUI;
import de.htwg.minesweeper.controller.impl.Controller;
import de.htwg.minesweeper.model.impl.Field;

public class Minesweeper {

	public static void main(String[] args) {
		Controller contr = new Controller(new Field());
		TextUI tui = new TextUI(contr);
		new BaseFrame(contr);
		boolean quit = false;
		tui.printStart();

		while (!quit) {
			quit = tui.processCmd();
		}
		
	}

}
