package components.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import model.Board;
import model.Field;
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
public class WorldManagerImpl implements WorldManager {

	@Autowired
	private BoardManager boardManager;

	@Autowired
	private WorldDao worldDao;

	@Autowired
	private EntityManagerFactory emf;

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

		System.out.println("SADASDASdASD");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			World save = worldDao.save(newWorld);
			tx.commit();

			return save;
		} catch (Exception e) {
			tx.rollback();
		}

		return null;
	}

	public void printSelectedWorld(long worldId) {

		World world = worldDao.getOne(worldId);

		for (Field[] array : world.getMainBoard().getBoard()) {
			for (Field field : array) {
				System.out.print(field.getSprite().getImage());
			}
		}

	}

	@Override
	public List<World> getAvailableWorlds() {

		return worldDao.findAll();

	}

	@Override
	public void deleteWorld(Long id) {

		worldDao.delete(id);

	}

	/* ========== Private ========== */
}
