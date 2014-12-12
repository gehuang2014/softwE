package de.htwg.minesweeper.model.impl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import de.htwg.minesweeper.model.IField;

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
	public void testMakeCellVisible() {
		assertFalse(field.getCell(1, 1).getVisible());
		field.makeCellVisible(1, 1);
		assertTrue(field.getCell(1, 1).getVisible());
	}

	@Test
	public void testGetVisCount() {
		assertEquals(0, field.getVisCount());
		field.makeCellVisible(1, 1);
		assertEquals(1, field.getVisCount());
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
	public void getWidth() {
		assertEquals(width, field.getWidth());
	}

	@Test
	public void getHeight() {
		assertEquals(height, field.getHeight());
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
	public void testMarkMines() {
		field.getCell(5, 5).setMine();
		field.getCell(3, 3).setMine();
		assertEquals(" ", field.getCell(5, 5).toString());
		assertEquals(" ", field.getCell(3, 3).toString());
		field.markMines();
		assertEquals("X", field.getCell(5, 5).toString());
		assertEquals("X", field.getCell(3, 3).toString());
	}
	
	@Test
	public void testToString() {
		field.getCell(3, 3).incNumberAdjMines();
		field.getCell(3, 3).setVisible();
		field.getCell(3, 4).setMarked();
		assertEquals(testString, field.toString());
	}
}
