package de.htwg.minesweeper.model.impl;

import de.htwg.minesweeper.model.IField;

public class Field implements IField {
	private Cell[][] field;
	private int x;
	private int y;
	private int iNumMines = 0;
	private int iVisCount = 0;

	public Field(int width, int height) {
		field = new Cell[width][height];
		x = width;
		y = height;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				field[i][j] = new Cell(i + 1, j + 1);
			}
		}
	}

	public void makeCellVisible(int x, int y) {
		this.field[x - 1][y - 1].setVisible();
		iVisCount++;
	}

	public int getVisCount() {
		return this.iVisCount;
	}

	public Cell getCell(int x, int y) {
		return this.field[x - 1][y - 1];
	}

	public void setNumMines(int num) {
		this.iNumMines = num;
	}

	public int getWidth() {
		return x;
	}

	public int getHeight() {
		return y;
	}

	public int getNumMines() {
		return this.iNumMines;
	}

	public void initField() {
		for (int i = 0; i < iNumMines; i++) {
			int width;
			int height;
			do {
				width = (int) Math.floor(Math.random() * x);
				height = (int) Math.floor(Math.random() * y);
			} while(field[width][height].getMine());
			field[width][height].setMine();

			for (int yOffset = -1; yOffset <= +1; yOffset++) {
				for (int xOffset = -1; xOffset <= +1; xOffset++) {
					try {
						field[width + xOffset][height + yOffset].incNumberAdjMines();
					} catch (IndexOutOfBoundsException e) {
						continue;
					}
				}
			}
		}
	}

	public void markMines() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (field[i][j].getMine()) {
					field[i][j].setVisible();
				}
			}
		}
	}

	@Override
	public String toString() {
		StringBuffer sbLineSep = new StringBuffer();
		StringBuffer sb = new StringBuffer();

		sbLineSep.append("+");
		for (int i = 1; i <= x; i++) {
			sbLineSep.append("---+");
		}
		sbLineSep.append("\n");

		for (int i = 0; i < y; i++) {
			sb.append(sbLineSep);
			for (int j = 0; j < x; j++) {
				sb.append("| ");
				sb.append(field[j][i].toString());
				sb.append(" ");
			}
			sb.append("|\n");
		}
		sb.append(sbLineSep);
		return sb.toString();
	}
}
