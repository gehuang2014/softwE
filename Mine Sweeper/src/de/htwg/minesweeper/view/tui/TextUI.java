package de.htwg.minesweeper.view.tui;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import de.htwg.minesweeper.controller.Controller;

public class TextUI implements Observer {
	private Controller contr;
	private Scanner scanner;
	private final int MINSIZE = 5;
	private final int MAXSIZE = 20;

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
		int[] coords;
		int iState;
		String[] cmd;

		System.out.println(contr.toString());
		System.out.println("Enter command: x y - trigger cell at coordinates (x,y) | x y ! - mark cell at coordinates (x,y) | q - quit");

		cmd = scanner.nextLine().split(" ");
		coords = checkCommand(cmd);
		if (coords[0] == -2) {
			return true;
		}

		if (coords[0] == -1) {
			return false;
		}

		if (coords[2] == 1) {
			contr.mark(coords[0], coords[1]);
		} else {
			iState = contr.trigger(coords[0], coords[1]);
			switch (iState) {
				case 0:
					System.out.println(contr.toString());
					System.out.println("You lost!");
					return true;
				case 1:
					System.out.println(contr.toString());
					System.out.println("You win!");
					return true;
				case 2:
					return false;
			}
		}
		return false;
	}

	private int[] checkCommand(String[] cmd) {
		int[] coords = {0, 0, 0};
		if (cmd.length == 1 && cmd[0].equals("q")) {
			coords[0] = -2;
			return coords;
		}
		if (cmd.length < 2 || cmd.length > 3) {
			System.out.println("Invalid argument count!");
			coords[0] = -1;
			return coords;
		}
		try {
			coords[0] = Integer.parseInt(cmd[0]);
			coords[1] = Integer.parseInt(cmd[1]);
		} catch (NumberFormatException e) {
			System.out.println("Invalid coordinates!");
			coords[0] = -1;
			return coords;
		}
		if (coords[0] < 1 || coords[0] > contr.getField().getWidth() || coords[1] < 1 || coords[1] > contr.getField().getHeight()) {
			System.out.println("Coordinates out of bounds!");
			coords[0] = -1;
			return coords;
		}
		if (cmd.length == 3) {
			if (!cmd[2].equals("!")) {
				System.out.println("Unknown argument!");
				coords[0] = -1;
				return coords;
			}
			coords[2] = 1;
		} 
		return coords;
	}

	public void printStart() {
		int width, height, numMines;
		System.out.println("Welcome to Minesweeper!");
		do {
			System.out.println("Enter width (5-20):");
			width = scanner.nextInt();
		} while (width < MINSIZE || width > MAXSIZE);
		do {
			System.out.println("Enter height (5-20):");
			height = scanner.nextInt();
		} while (height < MINSIZE || height > MAXSIZE);
		do {
			System.out.println("Enter number of mines:");
			numMines = scanner.nextInt();
		} while (numMines < 1 || numMines > width * height - 1);
		contr.setup(width, height, numMines);
	}
}
