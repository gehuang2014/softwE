package de.htwg.minesweeper.model;

import de.htwg.minesweeper.model.ICell;

/**
 * Interface for Field class.
 * @author hokruepp
 *
 */
public interface IField {

	/**
	 * Creates a new field with the given width and height.
	 * @param width the width of the new field.
	 * @param height the height of the new field.
	 */
	public void create(int width, int height);

	/**
	 * Makes the cell at the given coordinates of this field visible.
	 * @param x the x coordinate of the cell.
	 * @param y the y coordinate of the cell.
	 */
	public void makeCellVisible(int x, int y);

	/**
	 * Returns the number of visible cells in this field.
	 * @return the number of visible cells in this field.
	 */
	public int getVisCount();

	/**
	 * Returns the cell at the given coordinates of this field.
	 * @param x the x coordinate of the cell.
	 * @param y the y coordinate of the cell.
	 * @return the cell at the given coordinates of this field.
	 */
	public ICell getCell(int x, int y);

	/**
	 * Sets the number of mines for this field.
	 * @param num the number of mines.
	 */
	public void setNumMines(int num);

	/**
	 * Returns the width of this field.
	 * @return the width of this field.
	 */
	public int getWidth();

	/**
	 * Returns the height of this field.
	 * @return the height of this field.
	 */
	public int getHeight();

	/**
	 * Returns the number of mines of this field.
	 * @return the number of mines of this field.
	 */
	public int getNumMines();

	/**
	 * Randomly places the set number of mines in the cells of this field
	 * and sets the mine counts of the cells.
	 */
	public void initField();

	/**
	 * Makes all cells with a mine in this field visible.
	 */
	public void markMines();

	/**
	 * Returns the string representation of this field.
	 * @return the string representation of this field.
	 */
	@Override
	public String toString();
}
