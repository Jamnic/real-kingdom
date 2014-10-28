package map.engine;

import main.managers.GameComponentContainer;
import map.engine.model.FieldMapWrapper;
import map.engine.utils.Coords;

import com.google.common.base.Optional;

/**
 * Immutable {@link Board} which represents a board on which terrain and entities can be placed.
 */
public final class Board extends GameComponentContainer {

	/* ========== Public ========== */
	/**
	 * Constructs the board, and sets board width and height.
	 * 
	 * @param board
	 *            - sets the {@link Board}.
	 * @param width
	 *            - sets the width of {@link Board}.
	 * @param height
	 *            - sets the height of {@link Board}.
	 */
	public Board(FieldMapWrapper[][] board, final int width, final int height) {
		super();

		this.board = board;
		this.width = width;
		this.height = height;

		iterator = new BoardIterator(this);
	}

	/**
	 * Returns {@link Optional} which may contain {@link FieldMapWrapper} when given {@link Coords} are valid and fit
	 * the {@link Board} size.
	 * 
	 * @param coords
	 *            - {@link Coords} of needed {@link FieldMapWrapper}.
	 * @return {@link Optional} which may contain {@link FieldMapWrapper} when given {@link Coords} are valid and fit
	 *         the {@link Board} size.
	 */
	public Optional<FieldMapWrapper> get(Coords coords) {

		int x = coords.getX();
		int y = coords.getY();

		if (x < 0 || x >= width || y < 0 || y >= height)
			return Optional.absent();

		return Optional.of(board[x][y]);
	}

	/**
	 * Sets given {@link FieldMapWrapper} into specified with {@link Coords} place on {@link Board}. If {@link Coords}
	 * are not valid, an error message is being sent.
	 * 
	 * @param field
	 *            - {@link FieldMapWrapper} to be set on position of its {@link Coords} on {@link Board}.
	 */
	public void set(FieldMapWrapper field) {

		Coords coords = field.getCoords();

		int x = coords.getX();
		int y = coords.getY();

		if (x < 0 || x >= width || y < 0 || y >= height)
			log.err(this.getClass(), "Cannot set a Field at position " + coords + "! It does not fit board size.");

		board[x][y] = field;
	}

	public FieldMapWrapper[][] getBoard() {
		return board;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	/**
	 * Resets current and returns newly set {@link BoardIterator}.
	 * 
	 * @return Newly set {@link BoardIterator}.
	 */
	public BoardIterator getIterator() {
		iterator.resetIterator();

		return iterator;
	}

	/* ========== Private ========== */
	private BoardIterator iterator;
	private FieldMapWrapper[][] board;
	private int width;
	private int height;

}
