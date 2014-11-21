package minesweeper.model;


public class Field {
	private Cell[][] field;
	private int x;
	private int y;
	private int iNumMines = 0;

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

	public Cell getCell(int x, int y) {
		return field[x - 1][y - 1];
	}

	public void setNumMines(int num) {
		iNumMines = num;
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

	public void trigger(int x, int y) {
		int width = x - 1;
		int height = y - 1;
		if (field[width][height].getMine()) {
			gameOver();
			return;
		}
		triggerR(width, height);
	}

	public void triggerR(int x, int y) {
		try {
			if (!field[x][y].getVisible()) {
				field[x][y].setVisible();
				if (field[x][y].getNumberAdjMines() == 0) {
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
		field[x - 1][y - 1].setMarked();
	}

	public void gameOver() {
		
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
	/*public static void main(String args[]) {
		Field field = new Field(10, 10);
		field.setNumMines(10);
		field.initField();
		field.trigger(1, 1);
		System.out.print(field.toString());
	}*/
}
