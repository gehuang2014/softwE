package minesweeper.view.tui;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import minesweeper.controller.Controller;

public class TextUI implements Observer {
	private Controller contr;
	private Scanner scanner;

	public TextUI(Controller c) {
		this.contr = c;
		contr.addObserver(this);
		scanner = new Scanner(System.in);
	}

	@Override
	public void update(Observable o, Object arg) {
		printTUI();
	}

	public boolean printTUI() {
		System.out.println(contr.toString());
		System.out.println("Enter command: x y - trigger cell at coordinates (x,y) | x y ! - mark cell at coordinates (x,y) | q - quit");
		if (scanner.next().equalsIgnoreCase("q")) {
			return true;
		}
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		if (contr.trigger(x, y)) {
			System.out.println("You lost!");
			return true;
		}
		return false;
	}

	public void printStart() {
		int width, height, numMines;
		System.out.println("Welcome to Minesweeper!");
		do {
			System.out.println("Enter width (5-20):");
			width = scanner.nextInt();
		} while (width < 5 && width > 20);
		do {
			System.out.println("Enter height (5-20):");
			height = scanner.nextInt();
		} while (height < 5 && height > 20);
		do {
			System.out.println("Enter number of mines:");
			numMines = scanner.nextInt();
		} while (numMines < 1 && numMines > width * height);
		contr.setup(width, height, numMines);
	}
}
