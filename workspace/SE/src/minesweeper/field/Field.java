package minesweeper.field;

public class Field {
	private Cell[][] field;

	public Field(int width, int height) {
		field = new Cell[width][height];
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				field[i][j] = new Cell(i + 1, j + 1);
			}
		}
	}

	public Cell getCell(int x, int y) {
		return field[x - 1][y - 1];
	}
}
