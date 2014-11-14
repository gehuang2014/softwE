package minesweeper.model;


public class Field {
	private Cell[][] field;
	int x;
	int y;

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

		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				sb.append(sbLineSep).append("| ");
			}
		}
		return sb.toString();
	}
}
