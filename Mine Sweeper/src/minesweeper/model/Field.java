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
					if ((xOffset != 0 || yOffset != 0) && (width + xOffset) >= 0 && (height + yOffset) >= 0 && (width + xOffset) <= x - 1 && (height + yOffset) <= y - 1) {
						field[width + xOffset][height + yOffset].incNumberAdjMines();
					}
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
				if (field[j][i].getVisible()) {
					if (field[j][i].getMine()) {
						sb.append("X");
					} else {
						sb.append(field[j][i].getNumberAdjMines());
					}
				} else {
					if (field[j][i].getMarked()) {
						sb.append("!");
					} else {
						sb.append(" ");
					}
				}
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
		System.out.print(field.toString());
	}*/
}
