package engine.world;

import architecture.Manager;
import engine.model.WorldSize;

/**
 * Default implementation of {@link WorldManager}.
 */
public class WorldManagerImpl extends Manager implements WorldManager {

	/* ========== Public ========== */

	/** {@inheritDoc} */
	@Override
	public void createNewWorld(String worldName, WorldSize worldSize) {

		// String mainBoardName = boardManager.createBoardName(worldName);
		// Board mainBoard = boardManager.createNewBoard(mainBoardName, worldSize.getWidth(), worldSize.getHeight());

		// World newWorld = new World(worldName, mainBoard, worldSize);

		// save
	}

	/* ========== Private ========== */
}
