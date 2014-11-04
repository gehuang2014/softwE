package minesweeper.field;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FieldTest {
	Field field;
	int width = 10;
	int height = 10;
	
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
}
