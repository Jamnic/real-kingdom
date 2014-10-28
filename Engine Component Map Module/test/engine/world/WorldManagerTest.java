package engine.world;

import model.WorldSize;

import org.junit.Before;
import org.junit.Test;

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
				
	}
	
	/* ========== Private ========== */
}
