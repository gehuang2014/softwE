package de.htwg.minesweeper.controller.impl;

import static org.junit.Assert.*;
import de.htwg.minesweeper.controller.IController;
import de.htwg.minesweeper.model.IField;

import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
	Controller controller;
	int width = 10;
	int height = 10;
	int numMines = 10;
	String testString = "+---+---+---+---+---+---+---+---+---+---+\n" +
						"|   |   |   |   |   |   |   |   |   |   |\n" +
						"+---+---+---+---+---+---+---+---+---+---+\n" +
						"|   |   |   |   |   |   |   |   |   |   |\n" +
						"+---+---+---+---+---+---+---+---+---+---+\n" +
						"|   |   |   |   |   |   |   |   |   |   |\n" +
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
		controller = new Controller();
		controller.setup(width, height, numMines);
	}

	@Test
	public void testGetField() {
		Field field = new Field(width, height);
		for (int i = 1; i <= width; i++) {
			for (int j = 1; j <= height; j++) {
				assertEquals(field.getCell(i, j).getColumn(), controller.getField().getCell(i, j).getColumn());
				assertEquals(field.getCell(i, j).getRow(), controller.getField().getCell(i, j).getRow());
			}
		}
	}

	@Test
	public void testTrigger() {
		controller = new Controller();
		controller.setup(width, height, 0);
		controller.getField().getCell(1, 1).setMine();
		controller.getField().getCell(3, 1).setMine();
		assertEquals(0, controller.trigger(1, 1));
		controller.getField().getCell(2, 1).incNumberAdjMines();
		controller.getField().getCell(2, 1).incNumberAdjMines();
		controller.getField().getCell(2, 2).incNumberAdjMines();
		controller.getField().getCell(2, 2).incNumberAdjMines();
		controller.getField().getCell(1, 2).incNumberAdjMines();
		controller.getField().getCell(3, 2).incNumberAdjMines();
		controller.getField().getCell(4, 1).incNumberAdjMines();
		controller.getField().getCell(4, 2).incNumberAdjMines();
		assertEquals(2, controller.trigger(5, 5));
		controller = new Controller();
		controller.setup(width, height, 0);
		controller.getField().getCell(1, 1).setMine();
		assertEquals(1, controller.trigger(2, 1));
	}

	@Test
	public void testMark() {
		assertFalse(controller.getField().getCell(3, 3).getMarked());
		controller.mark(3, 3);
		assertTrue(controller.getField().getCell(3, 3).getMarked());
	}

	@Test
	public void testSetup() {
		
	}

	@Test
	public void testToString() {
		controller.getField().getCell(3, 4).setMarked();
		assertEquals(testString, controller.toString());
	}
}
