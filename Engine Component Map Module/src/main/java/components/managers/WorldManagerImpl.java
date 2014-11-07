package components.managers;

import model.Board;
import model.Field;
import model.World;
import model.enums.BoardSize;
import model.enums.WorldSize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.WorldDao;
import api.managers.BoardManager;
import api.managers.WorldManager;

/**
 * Default implementation of {@link WorldManager}.
 */
@Component
public class WorldManagerImpl implements WorldManager {

	@Autowired
	private BoardManager boardManager;

	@Autowired
	private WorldDao worldDao;

	/* ========== Public ========== */
	/** {@inheritDoc} */
	@Override
	public World createNewWorld(String worldName, WorldSize worldSize, BoardSize mainBoardSize) {

		String mainBoardName = boardManager.createBoardName(worldName);
		Board mainBoard = boardManager.createNewBoard(mainBoardName, mainBoardSize);

		World newWorld = new World();
		newWorld.setName(worldName);
		newWorld.setWorldSize(worldSize);
		newWorld.setMainBoard(mainBoard);

		return worldDao.save(newWorld);
	}

	public void printSelectedWorld(long worldId) {

		World world = worldDao.getOne(worldId);

		for (Field[] array : world.getMainBoard().getBoard()) {
			for (Field field : array) {
				System.out.print(field.getSprite().getImage());
			}
		}

	}

	/* ========== Private ========== */
}
