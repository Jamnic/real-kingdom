package engine.world;

import model.Board;
import model.World;
import model.WorldSize;
import architecture.Manager;
import architecture.PersistenceComponent;

/**
 * Default implementation of {@link WorldManager}.
 */
public class WorldManagerImpl extends Manager implements WorldManager {

	/* ========== Public ========== */

	/** {@inheritDoc} */
	@Override
	public void createNewWorld(String worldName, WorldSize worldSize) {

		 String mainBoardName = boardManager.createBoardName(worldName);
		 Board mainBoard = boardManager.createNewBoard(mainBoardName, worldSize.getWidth(), worldSize.getHeight());

		 World newWorld = new World(worldName, mainBoard, worldSize);

		 PersistenceComponent.worldDao.save(newWorld);
		 
	}

	/* ========== Private ========== */
}
