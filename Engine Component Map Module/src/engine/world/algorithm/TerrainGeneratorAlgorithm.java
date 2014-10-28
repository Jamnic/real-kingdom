package engine.world.algorithm;

import model.Board;

public interface TerrainGeneratorAlgorithm {

	Board generateBoard(final String name, final int boardWidth, final int boardHeight);

}
