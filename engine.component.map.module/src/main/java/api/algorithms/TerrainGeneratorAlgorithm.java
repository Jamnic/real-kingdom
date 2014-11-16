package api.algorithms;

import model.Board;
import model.enums.BoardSize;

/**
 * Interface for algorithm of generating terrain.
 */
public interface TerrainGeneratorAlgorithm {

	/**
	 * 2.0004 Wygenerowanie losowego terenu
	 * 
	 * @param boardSize
	 *            - size of desired {@link Board}.
	 * @return {@link BoardDto} with generated terrain.
	 */
	Board createBoardWithGeneratedTerrain(BoardSize boardSize);

}
