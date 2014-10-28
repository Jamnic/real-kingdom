package model;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Class which helps with iteration over 2D array in {@link Board}.
 */
public final class BoardIterator implements Iterator<Field>, Serializable {

	/* ========== Public ========== */
	/**
	 * Initializes the {@link BoardIterator}
	 * 
	 * @param board
	 */
	public BoardIterator(Board board) {
		super();

		this.iteratedBoard = board;

		setCurrentXPositionOfIterator(0);
		setCurrentYPositionOfIterator(0);
	}

	/**
	 * Returns next {@link Field} in order. Iteration can be modified by other methods of this class.
	 * 
	 * @return Next {@link Field} in order.
	 */
	@Override
	public Field next() {

		return iterateOnHeightAndWidth(iteratedBoard.getBoard(), iteratedBoard.getHeight(), iteratedBoard.getWidth());

	}

	/**
	 * Checks, if {@link BoardIterator} has another object to give during iteration.
	 * 
	 * @return True, if there is a possibility of further iteration, false if not.
	 */
	@Override
	public boolean hasNext() {

		return !checkIfCurrentReachedMaximum(currentXPositionOfIterator, iteratedBoard.getWidth());

	}

	/**
	 * Returns current position of iterator creating {@link Coords} object.
	 * 
	 * @return Current position of iterator using{@link Coords} object.
	 */
	public Coords getCurrentCoords() {

		return new Coords(currentXPositionOfIterator, currentYPositionOfIterator);

	}

	/**
	 * Resets the state of iterator - sets it current pointers to 0.
	 * 
	 * @return Reseted object.
	 */
	public BoardIterator resetIterator() {

		setIteratorOn(new Coords(0, 0));

		return this;

	}

	/**
	 * Sets the iterator on given {@link Coords} coordinates.
	 * 
	 * @param coords
	 *            - {@link Coords} on which iterator should be set on.
	 */
	public void setIteratorOn(final Coords coords) {

		setCurrentXPositionOfIterator(coords.getX());
		setCurrentYPositionOfIterator(coords.getY());

	}

	/**
	 * Not supported operation.
	 */
	@Override
	@Deprecated
	public void remove() {
	}

	/* ========== Private ========== */
	private static final long serialVersionUID = 5642501676714628479L;
	private int currentXPositionOfIterator;
	private int currentYPositionOfIterator;
	private Board iteratedBoard;

	private void setCurrentXPositionOfIterator(final int newXPosition) {
		if (newXPosition < 0 && newXPosition >= iteratedBoard.getWidth())
			// TODO exception
			return;

		this.currentXPositionOfIterator = newXPosition;
	}

	private void setCurrentYPositionOfIterator(final int newYPosition) {
		if (newYPosition < 0 && newYPosition >= iteratedBoard.getHeight())
			// TODO exception
			return;

		this.currentYPositionOfIterator = newYPosition;
	}

	private Field iterateOnHeightAndWidth(Field[][] array, final int maximumHeight, final int maximumWidth) {

		if (checkIfCurrentReachedMaximum(currentYPositionOfIterator, maximumHeight)) {
			// Iterate on another row.

			setCurrentYPositionOfIterator(0);
			return iterateOnWidth(array, maximumWidth);
		} else {
			// Get another Field in row.

			setCurrentYPositionOfIterator(currentYPositionOfIterator + 1);
			return array[currentXPositionOfIterator][currentYPositionOfIterator];
		}
	}

	private Field iterateOnWidth(Field[][] array, final int maximumWidth) {

		if (checkIfCurrentReachedMaximum(currentXPositionOfIterator, maximumWidth))

			throw new ArrayIndexOutOfBoundsException();
		else {
			// Iterate on another column.

			setCurrentXPositionOfIterator(currentXPositionOfIterator + 1);
			return array[currentXPositionOfIterator][currentYPositionOfIterator];
		}
	}

	private boolean checkIfCurrentReachedMaximum(final int current, final int maximum) {
		return current + 1 == maximum;
	}

}
