package game;

import engine.model.WorldSize;
import architecture.GameThread;

/**
 * Main class of whole {@link Game}. It initializes work of all components, and invokes tick and render commands for all
 * components.
 */
public final class Game extends GameThread {

	/* ========== Public ========== */
	/**
	 * Initializes the work of whole {@link Game}.
	 */
	public void initialize() {
		worldManager.createNewWorld("Alicia", WorldSize.TINY);
	}

	public void render() {

		// TODO render

	}

	public void tick() {

		// TODO tick

	}

	/* ========== Private ========== */

}
