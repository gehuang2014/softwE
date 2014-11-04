package minesweeper.field;

public class Cell {
	private int x;
	private int y;
	private boolean bMine = false;
	private boolean bVisible = false;
	private int iAdjMines = 0;

	public Cell(int column, int row) {
		x = column;
		y = row;
	}

	public int getColumn() {
		return x;
	}

	public int getRow() {
		return y;
	}

	public boolean getMine() {
		return bMine;
	}

	public void setMine() {
		this.bMine = true;
	}

	public boolean getVisible() {
		return bVisible;
	}

	public void setVisible() {
		this.bVisible = true;
	}

	public int getNumberAdjMines() {
		return iAdjMines;
	}

	public void incNumberAdjMines() {
		this.iAdjMines++;
	}
}
