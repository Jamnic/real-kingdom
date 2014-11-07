package game;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import api.game.MainGameThread;

import components.game.Game;

/**
 * This is a place, where {@link Game} can be run.
 */
@ContextConfiguration(locations = { "/engine-component-map-module-spring.xml" })
public final class GameRunner {

	/* ========== Main ========== */
	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"/engine-component-map-module-spring.xml");

		Game game = (Game) context.getBean("game");
		MainGameThread mainGameThread = (MainGameThread) context.getBean("mainGameThread");

		try {
			game.initialize();

			mainGameThread.start();

			mainGameThread.stop();

		} catch (InterruptedException e) {
			// Game crash!
		} finally {
			context.close();
		}

		new GameRunner();
	}

}
