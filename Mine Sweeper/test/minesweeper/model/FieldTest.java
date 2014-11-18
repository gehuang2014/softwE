package minesweeper.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FieldTest {
	Field field;
	int width = 10;
	int height = 10;
	String testString = "+---+---+---+---+---+---+---+---+---+---+\n" +
						"|   |   |   |   |   |   |   |   |   |   |\n" +
						"+---+---+---+---+---+---+---+---+---+---+\n" +
						"|   |   |   |   |   |   |   |   |   |   |\n" +
						"+---+---+---+---+---+---+---+---+---+---+\n" +
						"|   |   | 1 |   |   |   |   |   |   |   |\n" +
						"+---+---+---+---+---+---+---+---+---+---+\n" +
						"|   |   | ! |   |   |   |   |   |   |   |\n" +
						"+---+---+---+---+---+---+---+---+---+---+\n" +
						"|   |   |   |   |   |   |   |   |   |   |\n" +
						"+---+---+---+---+---+---+---+---+---+---+\n" +
						"|   |   |   |   |   |   |   |   |   |   |\n" +
						"+---+---+---+---+---+---+---+---+---+---+\n" +
						"|   |   |   |   |   |   |   |   |   |   |\n" +
						"+---+---+---+---+---+---+---+---+---+---+\n" +
						"|   |   |   |   |   |   |   |   |   |   |\n" +
						"+---+---+---+---+---+---+---+---+---+---+\n" +
						"|   |   |   |   |   |   |   |   |   |   |\n" +
						"+---+---+---+---+---+---+---+---+---+---+\n" +
						"|   |   |   |   |   |   |   |   |   |   |\n" +
						"+---+---+---+---+---+---+---+---+---+---+\n";
	
	@Before
	public void setUp() throws Exception {
		field = new Field(width, height);
		field.getCell(3, 3).incNumberAdjMines();
		field.getCell(3, 3).setVisible();
		field.getCell(3, 4).setMarked(true);
	}

	@Test
	public void testGetCell() {
		for (int i = 1; i <= width; i++) {
			for (int j = 1; j <= height; j++) {
				assertEquals(i, field.getCell(i, j).getColumn());
				assertEquals(j, field.getCell(i, j).getRow());
			}
		}
	}

	@Test
	public void testToString() {
		assertEquals(testString, field.toString());
	}
}
