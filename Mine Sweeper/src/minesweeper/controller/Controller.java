package minesweeper.controller;

import java.util.Observable;

import minesweeper.model.Field;

public class Controller extends Observable {
	private Field field;

	public Controller(int x, int y, int iNumMines) {
		field = new Field(x, y);
		field.setNumMines(iNumMines);
		field.initField();
	}

	public Field getField() {
		return this.field;
	}

	public void trigger(int x, int y) {
		if (field.getCell(x, y).getMine()) {
			// game over needed here
			return;
		}
		triggerR(x, y);
		notifyObservers();
	}

	public void triggerR(int x, int y) {
		try {
			if (!field.getCell(x, y).getVisible()) {
				field.getCell(x, y).setVisible();
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

	public void mark(int x, int y) {
		field.getCell(x, y).setMarked();
		notifyObservers();
	}

	@Override
	public String toString() {
		return field.toString();
	}
}
