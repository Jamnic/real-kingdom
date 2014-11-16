package game;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import components.game.Game;
import components.game.GameWindowImpl;
import components.utilities.LoggerUtility;

/**
 * This is a place, where {@link Game} can be run.
 */
public final class GameRunner {

	public GameRunner() {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/graphics-component-spring.xml");

		LoggerUtility log = (LoggerUtility) context.getBean("loggerUtility");
		log.info(GameRunner.class, "Starting game");

		Game game = (Game) context.getBean("game");
		GameWindowImpl gameWindow = (GameWindowImpl) context.getBean("gameWindowImpl");
		// MainGameThread mainGameThread = (MainGameThread) context.getBean("mainGameThreadImpl");

		gameWindow.initialize();

		game.initialize();
		log.info(GameRunner.class, "Game started");

		// context.close(); // Nie zamykac bo sie entitymanager wypieprzy

	}

	/* ========== Main ========== */
	public static void main(String[] args) {

		new GameRunner();
	}

}
