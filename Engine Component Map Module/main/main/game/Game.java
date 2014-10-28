package main.game;

import architecture.GameThread;

/**
 * Main class of whole {@link Game}. It initializes work of all components, and invokes tick and render commands for all
 * components.
 */
public final class Game extends GameThread implements Tickable, Renderable {

	/* ========== Public ========== */
	/**
	 * Initializes the work of whole {@link Game}.
	 */
	public void initialize() {
		mapManager.createNewGameMap(300, 100);
	}

	/** {@inheritDoc} */
	@Override
	public void render() {

		// TODO render

	}

	/** {@inheritDoc} */
	@Override
	public void tick() {

		// TODO tick

	}

	/* ========== Private ========== */

}
