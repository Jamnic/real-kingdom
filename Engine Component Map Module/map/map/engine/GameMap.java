package map.engine;

import main.game.Game;
import map.engine.algorithm.impl.TerrainGeneratorAlgorithmImpl;
import map.engine.managers.impl.MapManagerImpl;

/**
 * Represents a map of a {@link Game}. It is managed by {@link MapManagerImpl}, and allows to put on it entities.
 */
public final class GameMap {

	/* ========== Public ========== */
	/**
	 * Initializes the main board and prepares it to be played. Uses {@link TerrainGeneratorAlgorithmImpl} to generate fields'
	 * type.
	 * 
	 * @param width
	 *            width of desired map.
	 * @param height
	 *            height of desired map.
	 */
	public GameMap(Board board) {

		this.board = board;

	}

	public Board getBoard() {
		return board;
	}

	/* ========== Private ========== */
	private Board board;

}
