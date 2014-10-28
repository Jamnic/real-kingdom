package architecture;

import engine.world.BoardManager;
import engine.world.BoardManagerImpl;
import engine.world.WorldManager;
import engine.world.WorldManagerImpl;
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
public abstract class GameComponentContainer {

	/* Manager */
	protected final static WorldManager worldManager = new WorldManagerImpl();
	protected final static BoardManager boardManager = new BoardManagerImpl();

	/* Utility section */
	protected final static LoggerUtility log = new LoggerUtility(true, true, true, false);
	protected final static DiceUtility dice = new DiceUtility();
	protected final static PropertiesReader mapProperties = new PropertiesReader("map.properties");

	/* GameThread */
	protected final static Game game = new Game();
	protected final static MainGameThread mainGameThread = new MainGameThreadImpl();

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
