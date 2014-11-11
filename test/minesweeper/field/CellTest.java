package minesweeper.field;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CellTest {

	Cell cell;

	@Before
	public void setUp() throws Exception {
		cell = new Cell(1, 2);
	}

	@Test
	public void testGetColumn() {
		assertEquals(1, cell.getColumn());
	}

	@Test
	public void testGetRow() {
		assertEquals(2, cell.getRow());
	}

	@Test
	public void testGetMine() {
		assertFalse(cell.getMine());
		cell.setMine();
		assertTrue(cell.getMine());
	}

	@Test
	public void testGetVisible() {
		assertFalse(cell.getVisible());
		cell.setVisible();
		assertTrue(cell.getVisible());
	}

	@Test
	public void testGetNumberAdjMines() {
		assertEquals(0, cell.getNumberAdjMines());
		cell.incNumberAdjMines();
		assertEquals(1, cell.getNumberAdjMines());
	}
}
