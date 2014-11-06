package managers.world;

import model.Board;
import model.World;
import model.enums.WorldSize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.WorldDao;
import architecture.Manager;

/**
 * Default implementation of {@link WorldManager}.
 */
@Component
public class WorldManagerImpl extends Manager implements WorldManager {

	@Autowired
	private WorldDao worldDao;

	/* ========== Public ========== */
	/** {@inheritDoc} */
	@Override
	public void createNewWorld(String worldName, WorldSize worldSize) {

		String mainBoardName = boardManager.createBoardName(worldName);
		Board mainBoard = boardManager.createNewBoard(mainBoardName, worldSize.getWidth(), worldSize.getHeight());

		World newWorld = new World();
		newWorld.setName(worldName);
		newWorld.setWorldSize(worldSize);
		newWorld.setMainBoard(mainBoard);

		worldDao.save(newWorld);
	}

	/* ========== Private ========== */
}
