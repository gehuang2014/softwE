package de.htwg.minesweeper.model;
/**
 * Interface for Cell Class
 * @author hokruepp
 *
 */
public interface ICell {

	/**
	 * Returns the column of this cell.
	 * @return the column
	 */
	public int getColumn();

	/**
	 * Returns the row of this cell.
	 * @return the row
	 */
	public int getRow();

	/**
	 * Returns the mine-status of this cell.
	 * @return true if there is a mine at this cell, false otherwise
	 */
	public boolean getMine();

	/**
	 * Sets a mine at this cell.
	 */
	public void setMine();

	/**
	 * Marks this cell if it is unmarked, unmarks this cell if it is already marked.
	 */
	public void setMarked();

	/**
	 * Returns the marked-status of this cell.
	 * @return true if this cell is marked, false otherwise
	 */
	public boolean getMarked();

	/**
	 * Returns the visibility of this cell.
	 * @return true if this cell is visible, false otherwise
	 */
	public boolean getVisible();

	/**
	 * Sets this cell as visible
	 */
	public void setVisible();

	/**
	 * Returns the number of adjacent mines of this cell.
	 * @return the number of adjacent mines of this cell
	 */
	public int getNumberAdjMines();

	/**
	 * Increments the number of adjacent mines of this cell by one.
	 */
	public void incNumberAdjMines();

	/**
	 * Returns the string representation of this cell.
	 * @return the string representation of this cell
	 */
	@Override
	public String toString();
}
