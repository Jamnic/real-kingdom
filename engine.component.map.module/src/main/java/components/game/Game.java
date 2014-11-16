package components.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.managers.WorldManager;
import architecture.GameThread;

import components.utilities.LoggerUtility;

/**
 * Main class of whole {@link Game}. It initializes work of all components, and invokes tick and render commands for all
 * components.
 */
@Component
public final class Game extends GameThread {

	@Autowired
	private WorldManager worldManager;
	
	@Autowired
	private LoggerUtility log;

	/* ========== Public ========== */
	/**
	 * Initializes the work of whole {@link Game}.
	 */
	public void initialize() {
		
//		log.info(Game.class, "Initializing new world...");
//		
//		worldManager.createNewWorld("Alicia", WorldSize.TINY, BoardSize.MEDIUM);
//		
//		log.info(Game.class, "World successfully created!");
	}

	public void render() {

		// TODO render

	}

	public void tick() {

		// TODO tick

	}

	/* ========== Private ========== */

}
