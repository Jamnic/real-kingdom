package components.managers;

import java.util.List;

import model.Board;
import model.Field;
import model.FieldColumn;
import model.World;
import model.enums.BoardSize;
import model.enums.WorldSize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import repository.WorldDao;
import api.managers.BoardManager;
import api.managers.WorldManager;

/**
 * Default implementation of {@link WorldManager}.
 */
@Component
@Transactional
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

		for (FieldColumn array : world.getMainBoard().getFieldColumns()) {
			for (Field field : array.getFields()) {
				System.out.print(field.getSprite().getImage());
			}
		}

	}

	@Override
	public World[] getAvailableWorlds() {

		List<World> availableWorlds = worldDao.findAll();

		int size = availableWorlds.size();

		return size > 10 ? availableWorlds.subList(0, 10).toArray(new World[10]) : availableWorlds
				.toArray(new World[size]);

	}

	@Override
	public void deleteWorld(Long id) {

		worldDao.delete(id);

	}

	/* ========== Private ========== */
}
