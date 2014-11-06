package architecture;

import managers.world.BoardManager;
import managers.world.BoardManagerImpl;
import managers.world.WorldManager;
import managers.world.WorldManagerImpl;
import game.Game;
import game.MainGameThread;
import game.MainGameThreadImpl;
import properties.PropertiesReader;
import utilities.DiceUtility;
import utilities.LoggerUtility;

/**
 * Contains all components of the {@link Game} engine, providing easy access to them when needed.<br>
 * <br>
 * 
 * Every component should be independent during creation.<br>
 * <br>
 */
public abstract class EngineComponentMapModule {

	/* Manager */
	public final static WorldManager worldManager = new WorldManagerImpl();
	public final static BoardManager boardManager = new BoardManagerImpl();

	/* Utility section */
	public final static LoggerUtility log = new LoggerUtility(true, true, true, false);
	public final static DiceUtility dice = new DiceUtility();
	public final static PropertiesReader mapProperties = new PropertiesReader("map.properties");

	/* GameThread */
	public final static Game game = new Game();
	public final static MainGameThread mainGameThread = new MainGameThreadImpl();

	// /* Algorithm section */
	// protected final static RoutingAlgorithm routingAlgorithm = new SimpleRoutingAlgorithmImpl();
	//
	// /* Manager section */
	// protected final static CreatureManager creatureManager = new CreatureManagerImpl();
	// protected final static ArchiveManager archiveManager = new ArchiveManagerImpl();
	// protected final static RouteManager routeManager = new RouteManagerImpl();
	// protected final static FieldManager fieldManager = new FieldManagerImpl();
	// protected final static TaskManager taskManager = new TaskManagerImpl();
	// protected final static MapManager mapManager = new MapManagerImpl();
	//

}
