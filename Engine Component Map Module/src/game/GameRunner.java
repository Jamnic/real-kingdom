package game;

import architecture.EngineComponentMapModule;

/**
 * This is a place, where {@link Game} can be run.
 */
public final class GameRunner extends EngineComponentMapModule {

	/* ========== Main ========== */
	public static void main(String[] args) {
		try {

			game.initialize();

			mainGameThread.start();

			mainGameThread.stop();

		} catch (InterruptedException e) {
			log.err(GameRunner.class, "Game has crashed.\n" + e.getMessage());

			// Game crash!
		}
	}

}
