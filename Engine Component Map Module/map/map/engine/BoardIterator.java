package map.engine;

import java.util.Iterator;

import main.managers.GameComponentContainer;
import map.engine.model.FieldMapWrapper;
import map.engine.utils.Coords;

/**
 * Class which helps with iteration over 2D array in {@link Board}.
 */
public final class BoardIterator extends GameComponentContainer implements Iterator<FieldMapWrapper> {

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
	 * Returns next {@link FieldMapWrapper} in order. Iteration can be modified by other methods of this class.
	 * 
	 * @return Next {@link FieldMapWrapper} in order.
	 */
	@Override
	public FieldMapWrapper next() {

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
	 */
	public void resetIterator() {

		setIteratorOn(new Coords(0, 0));

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
	private int currentXPositionOfIterator;
	private int currentYPositionOfIterator;
	private Board iteratedBoard;

	private void setCurrentXPositionOfIterator(final int newXPosition) {
		if (newXPosition < 0 && newXPosition >= iteratedBoard.getWidth())
			log.err(this.getClass(), "Cannot set currentX to '" + newXPosition
					+ "'! This value exceeds the size of given board.");

		this.currentXPositionOfIterator = newXPosition;
	}

	private void setCurrentYPositionOfIterator(final int newYPosition) {
		if (newYPosition < 0 && newYPosition >= iteratedBoard.getHeight())
			log.err(this.getClass(), "Cannot set currentY to '" + newYPosition
					+ "'! This value exceeds the size of given board.");

		this.currentYPositionOfIterator = newYPosition;
	}

	private FieldMapWrapper iterateOnHeightAndWidth(FieldMapWrapper[][] array, final int maximumHeight,
			final int maximumWidth) {
		
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

	private FieldMapWrapper iterateOnWidth(FieldMapWrapper[][] array, final int maximumWidth) {
		
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
