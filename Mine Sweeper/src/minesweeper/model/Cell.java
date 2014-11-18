package minesweeper.model;

public class Cell {
	private int x;
	private int y;
	private boolean bMine = false;
	private boolean bVisible = false;
	private boolean bMarked = false;
	private int iAdjMines = 0;

	public Cell(int column, int row) {
		this.x = column;
		this.y = row;
	}

	public int getColumn() {
		return this.x;
	}

	public int getRow() {
		return this.y;
	}

	public boolean getMine() {
		return this.bMine;
	}

	public void setMine() {
		this.bMine = true;
	}

	public void setMarked(boolean m) {
		this.bMarked = m;
	}

	public boolean getMarked() {
		return this.bMarked;
	}

	public boolean getVisible() {
		return this.bVisible;
	}

	public void setVisible() {
		this.bVisible = true;
	}

	public int getNumberAdjMines() {
		return this.iAdjMines;
	}

	public void incNumberAdjMines() {
		this.iAdjMines++;
	}
}
