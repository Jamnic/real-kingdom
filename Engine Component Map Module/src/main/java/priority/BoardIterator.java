package priority;

import java.io.Serializable;
import java.util.Iterator;

import model.Board;
import model.Field;
import dto.BoardDto;
import dto.CoordsDto;
import dto.FieldDto;

/**
 * Class which helps with iteration over 2D array in {@link Board}.
 */
public final class BoardIterator implements Iterator<FieldDto>, Iterable<FieldDto>, Serializable {

	/* ========== Public ========== */
	/**
	 * Initializes the {@link BoardIterator}
	 * 
	 * @param board
	 */
	public BoardIterator(BoardDto board) {
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
	public FieldDto next() {

		return iterateOnHeightAndWidth(iteratedBoard.getBoard(), iteratedBoard.getBoardSize().getHeight(),
				iteratedBoard.getBoardSize().getWidth());

	}

	/**
	 * Checks, if {@link BoardIterator} has another object to give during iteration.
	 * 
	 * @return True, if there is a possibility of further iteration, false if not.
	 */
	@Override
	public boolean hasNext() {

		return !checkIfCurrentReachedMaximum(currentXPositionOfIterator, iteratedBoard.getBoardSize().getWidth());

	}

	/**
	 * Returns current position of iterator creating {@link CoordsDto} object.
	 * 
	 * @return Current position of iterator using{@link CoordsDto} object.
	 */
	public CoordsDto getCurrentCoords() {

		return new CoordsDto(currentXPositionOfIterator, currentYPositionOfIterator);

	}

	/**
	 * Resets the state of iterator - sets it current pointers to 0.
	 * 
	 * @return Reseted object.
	 */
	public BoardIterator resetIterator() {

		setIteratorOn(new CoordsDto(0, 0));

		return this;

	}

	/**
	 * Sets the iterator on given {@link CoordsDto} coordinates.
	 * 
	 * @param coords
	 *            - {@link CoordsDto} on which iterator should be set on.
	 */
	public void setIteratorOn(CoordsDto coords) {

		setCurrentXPositionOfIterator(coords.getX());
		setCurrentYPositionOfIterator(coords.getY());

	}

	@Override
	public Iterator<FieldDto> iterator() {
		return this;
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
	private BoardDto iteratedBoard;

	private void setCurrentXPositionOfIterator(final int newXPosition) {
		if (newXPosition < 0 && newXPosition >= iteratedBoard.getBoardSize().getWidth())
			// TODO exception
			return;

		this.currentXPositionOfIterator = newXPosition;
	}

	private void setCurrentYPositionOfIterator(final int newYPosition) {
		if (newYPosition < 0 && newYPosition >= iteratedBoard.getBoardSize().getHeight())
			// TODO exception
			return;

		this.currentYPositionOfIterator = newYPosition;
	}

	private FieldDto iterateOnHeightAndWidth(FieldDto[][] array, final int maximumHeight, final int maximumWidth) {

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

	private FieldDto iterateOnWidth(FieldDto[][] array, final int maximumWidth) {

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
