package minesweeper.controller;

import static org.junit.Assert.*;
import minesweeper.model.Field;

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
