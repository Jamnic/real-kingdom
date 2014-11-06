package managers.world;

import model.Board;
import architecture.Manager;

public class BoardManagerImpl extends Manager implements BoardManager {

	/* ========== Public ========== */
	/** {@inheritDoc} */
	@Override
	public Board createNewBoard(final String boardName, final int width, final int height) {
		
//		return terrainGeneratorAlgorithm.generateBoard(boardName, width, height);
		return new Board();
		
	}
	
	/** {@inheritDoc} */
	@Override
	public String createBoardName(String worldName) {

		StringBuilder builder = new StringBuilder();
		builder.append(worldName);
		builder.append("_");

		return builder.toString();
	}

	/* ========== Private ========== */
	
	/* ========== Components ========== */
//	private final static TerrainGeneratorAlgorithm terrainGeneratorAlgorithm = new TerrainGeneratorAlgorithmImpl();

}
