package managers.world.algorithm;

import dto.BoardDto;
import model.Board;

public interface TerrainGeneratorAlgorithm {

	BoardDto generateBoard(final String name, final int boardWidth, final int boardHeight);

}
