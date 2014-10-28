package engine.world.algorithm;

import engine.model.Board;

public interface TerrainGeneratorAlgorithm {

	Board generateBoard(final String name, final int boardWidth, final int boardHeight);

}
