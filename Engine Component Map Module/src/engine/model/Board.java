package engine.model;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Iterator;

import com.google.common.base.Optional;

/**
 * 1.0008 Board
 * 
 * Represents a play {@link Board} in the game.
 */
public class Board implements Iterable<Field> {

	/* ========== Public ========== */
	public Board(String name, Field[][] board, int width, int height) {

		checkNotNull(name);
		checkNotNull(board);

		this.name = name;
		this.board = board;
		this.height = height;
		this.width = width;
	}

	public String getName() {
		return name;
	}

	public Field[][] getBoard() {
		return board;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Optional<Field> get(Coords coords) {

		int x = coords.getX();
		int y = coords.getY();

		if (fitInBoard(x, y)) {
			return Optional.fromNullable(this.board[x][y]);
		}

		return Optional.absent();
	}

	/**
	 * Resets current and returns newly set {@link BoardIterator}.
	 * 
	 * @return Newly set {@link BoardIterator}.
	 */
	@Override
	public Iterator<Field> iterator() {
		return new BoardIterator(this);
	}

	/* ========== Private ========== */
	private final String name;
	private final Field[][] board;
	private final int height;
	private final int width;

	private boolean fitInBoard(int x, int y) {
		return x < width && x >= 0 && y < height && y >= 0;
	}

}
