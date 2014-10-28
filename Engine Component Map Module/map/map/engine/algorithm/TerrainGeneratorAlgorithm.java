package map.engine.algorithm;

import engine.model.Field;
import map.engine.Board;

/**
 * Generates diversified terrain presented as new {@link Board} object.
 */
public interface TerrainGeneratorAlgorithm {

	/**
	 * Creates diversified terrain returning newly created {@link Board}. It should generate oceans, rivers, mountain
	 * ranges, swamps, savannah etc. and provide them with proper names.
	 * 
	 * @param boardWidth
	 *            - width of desired {@link Board}.
	 * @param boardHeight
	 *            - height of desired {@link Board}.
	 * @return newly created {@link Board} with diversified terrain composed with {@link Field}s.
	 */
	Board generateBoard(final int boardWidth, final int boardHeight);

}
