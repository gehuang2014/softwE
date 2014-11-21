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
	public void testSetNumMines() {
		assertEquals(0, field.getNumMines());
		field.setNumMines(10);
		assertEquals(10, field.getNumMines());
	}

	@Test
	public void testInitField() {
		field.setNumMines(10);
		field.initField();
		int iMineCounter = 0;
		for (int i = 1; i <= width; i++) {
			for (int j = 1; j <= height; j++) {
				if (field.getCell(i, j).getMine()) {
					iMineCounter++;
				}
			}
		}
		assertEquals(10, iMineCounter);
	}

	@Test
	public void testMark() {
		assertFalse(field.getCell(3, 3).getMarked());
		field.mark(3, 3);
		assertTrue(field.getCell(3, 3).getMarked());
	}

	@Test
	public void testTrigger() {
		
	}

	@Test
	public void testGameOver() {
		assertTrue(true);
	}
	
	@Test
	public void testToString() {
		field.getCell(3, 3).incNumberAdjMines();
		field.getCell(3, 3).setVisible();
		field.getCell(3, 4).setMarked();
		assertEquals(testString, field.toString());
	}
}
