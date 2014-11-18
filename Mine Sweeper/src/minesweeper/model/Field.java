package minesweeper.model;


public class Field {
	private Cell[][] field;
	private int x;
	private int y;

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

	public void initField(int iNumMines) {
		for (int i = 0; i < iNumMines; i++) {
			
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
					sb.append(field[j][i].getNumberAdjMines());
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
}
