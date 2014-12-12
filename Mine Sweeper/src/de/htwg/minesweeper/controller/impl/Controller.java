package de.htwg.minesweeper.controller.impl;

import de.htwg.util.observer.Observable;
import de.htwg.minesweeper.model.IField;
import de.htwg.minesweeper.controller.IController;

public class Controller extends Observable implements IController {
	private Field field;

	public Field getField() {
		return this.field;
	}

	public int trigger(int x, int y) {
		if (field.getCell(x, y).getMine()) {
			return gameOver();
		}
		triggerR(x, y);
		notifyObservers();
		return checkWin();
	}

	public void triggerR(int x, int y) {
		try {
			if (!field.getCell(x, y).getVisible()) {
				field.makeCellVisible(x, y);
				if (field.getCell(x, y).getNumberAdjMines() == 0) {
					for (int yOffset = -1; yOffset <= +1; yOffset++) {
						for (int xOffset = -1; xOffset <= +1; xOffset++) {
							triggerR(x + xOffset, y + yOffset);
						}
					}
				}
			}
		} catch (IndexOutOfBoundsException e) {
			return;
		}
	}

	private int gameOver() {
		field.markMines();
		return 0;
	}

	public int checkWin() {
		if (field.getVisCount() == field.getHeight() * field.getWidth() - field.getNumMines()) {
			field.markMines();
			return 1;
		}
		return 2;
	}

	public void mark(int x, int y) {
		field.getCell(x, y).setMarked();
		notifyObservers();
	}

	public void setup(int x, int y, int iNumMines) {
		field = new Field(x, y);
		field.setNumMines(iNumMines);
		field.initField();
	}

	@Override
	public String toString() {
		return field.toString();
	}
}
