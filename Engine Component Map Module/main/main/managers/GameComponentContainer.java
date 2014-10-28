package main.managers;

import main.game.Game;
import main.utilities.DiceUtility;
import main.utilities.LoggerUtility;
import map.engine.algorithm.RoutingAlgorithm;
import map.engine.algorithm.TerrainGeneratorAlgorithm;
import map.engine.algorithm.impl.SimpleRoutingAlgorithmImpl;
import map.engine.algorithm.impl.TerrainGeneratorAlgorithmImpl;
import map.engine.managers.ArchiveManager;
import map.engine.managers.FieldManager;
import map.engine.managers.MapManager;
import map.engine.managers.RouteManager;
import map.engine.managers.impl.ArchiveManagerImpl;
import map.engine.managers.impl.FieldManagerImpl;
import map.engine.managers.impl.MapManagerImpl;
import map.engine.managers.impl.RouteManagerImpl;
import map.engine.utils.ArrayUtility;
import model.managers.impl.CreatureManager;
import model.managers.impl.CreatureManagerImpl;
import model.managers.impl.TaskManager;
import model.managers.impl.TaskManagerImpl;
import thread.engine.MainGameThread;
import thread.engine.MainGameThreadImpl;

/**
 * Contains all components of the {@link Game} engine, providing easy access to them when needed.<br>
 * <br>
 * 
 * Every component should be independent during creation.<br>
 * <br>
 */
public abstract class GameComponentContainer {

	/* Utility section */
	protected final static LoggerUtility log = new LoggerUtility(true, true, true, false);
	protected final static ArrayUtility arrays = new ArrayUtility();
	protected final static DiceUtility dice = new DiceUtility();

	/* Algorithm section */
	protected final static TerrainGeneratorAlgorithm terrainGeneratorAlgorithm = new TerrainGeneratorAlgorithmImpl();
	protected final static RoutingAlgorithm routingAlgorithm = new SimpleRoutingAlgorithmImpl();

	/* Manager section */
	protected final static CreatureManager creatureManager = new CreatureManagerImpl();
	protected final static ArchiveManager archiveManager = new ArchiveManagerImpl();
	protected final static RouteManager routeManager = new RouteManagerImpl();
	protected final static FieldManager fieldManager = new FieldManagerImpl();
	protected final static TaskManager taskManager = new TaskManagerImpl();
	protected final static MapManager mapManager = new MapManagerImpl();

	/* GameThread section */
	protected final static Game game = new Game();
	protected final static MainGameThread mainGameThread = new MainGameThreadImpl();

}
