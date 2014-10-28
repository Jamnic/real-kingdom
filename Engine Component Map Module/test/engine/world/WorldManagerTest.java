package engine.world;

import org.junit.Before;
import org.junit.Test;

import engine.model.Field;
import engine.model.World;
import engine.model.WorldSize;
import architecture.Manager;

public class WorldManagerTest extends Manager {

	private WorldManager testedManager;
	
	@Before
	public void init() {
		testedManager = new WorldManagerImpl();
	}
	
	/* ========== Public ========== */
	@Test
	public void testCreateNewWorld() {
		
		String testName = "Asteroth";
		WorldSize worldSize = WorldSize.BIG;
		
		testedManager.createNewWorld(testName, worldSize);
		
		World loadedWorld = worldDao.load();
		
		for (Field field : loadedWorld.getMainBoard()) {
			System.out.println(field.getTerrainType());
		}
		
	}
	
	/* ========== Private ========== */
}
