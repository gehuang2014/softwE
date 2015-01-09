package de.htwg.minesweeper.controller;

import de.htwg.minesweeper.model.IField;
import de.htwg.util.observer.IObservable;

/**
 * Interface for controller class.
 * @author hokruepp
 *
 */
public interface IController extends IObservable {

	/**
	 * Returns the field of this controller.
	 * @return the field of this controller.
	 */
	public IField getField();

	/**
	 * Triggers the cell at the given coordinates of the field of this controller.
	 * Checks if there is a mine at the cell or if all cells now visible,
	 * otherwise makes the cell visible. If there are no adjacent mines, recursively
	 * makes all adjacent fields visible.
	 * @param x the x coordinate of the cell.
	 * @param y the y coordinate of the cell.
	 * @return 	0 if there is a mine at the cell,
	 * 			1 if all cells are visible,
	 * 			2 otherwise.
	 */
	public int trigger(int x, int y);

	/**
	 * Marks the cell at the given coordinates of the field of this controller.
	 * @param x the x coordinate of the cell.
	 * @param y the y coordinate of the cell.
	 */
	public void mark(int x, int y);

	/**
	 * Creates a new field with the given width and height for this controller.
	 * The given number of mines are then randomly placed at cells in the field.
	 * @param x the width of the field.
	 * @param y the height of the field.
	 * @param iNumMines the number of mines for the field.
	 */
	public void setup(int x, int y, int iNumMines);

	/**
	 * Returns the string representation of the field of this controller.
	 * @return the string representation of the field of this controller.
	 */
	@Override
	public String toString();
}
