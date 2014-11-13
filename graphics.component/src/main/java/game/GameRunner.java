package game;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import api.game.MainGameThread;

import components.game.Game;
import components.game.GameWindowImpl;

/**
 * This is a place, where {@link Game} can be run.
 */
@ContextConfiguration(locations = { "/engine-component-map-module-spring.xml" })
public final class GameRunner {

	/* ========== Main ========== */
	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"/graphics-component-spring.xml");

		Game game = (Game) context.getBean("game");
		GameWindowImpl gameWindow = (GameWindowImpl) context.getBean("gameWindowImpl");
		MainGameThread mainGameThread = (MainGameThread) context.getBean("mainGameThreadImpl");

		try {
			gameWindow.initialize();

//			game.initialize();
//
//			mainGameThread.start();
//
//			mainGameThread.stop();

//		} catch (InterruptedException e) {
//			// Game crash!
		} finally {
			context.close();
		}

		new GameRunner();
	}

}
