package components.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.game.MainGameThread;
import architecture.GameThread;

import components.utilities.LoggerUtility;

/**
 * Default implementation of {@link MainGameThread}.
 * 
 * {@inheritDoc}
 */
@Component
public class MainGameThreadImpl extends GameThread implements MainGameThread {

	@Autowired
	private Game game;

	@Autowired
	private LoggerUtility log;

	/* ========== Public ========== */
	/** {@inheritDoc} */
	@Override
	public void start() throws InterruptedException {

		if (!isRunning) {
			log.info(MainGameThreadImpl.class, "Starting main game thread.");

			gameThread.start();
		}

		isRunning = true;
	}

	/** {@inheritDoc} */
	@Override
	public void stop() throws InterruptedException {

		if (isRunning) {
			log.info(MainGameThreadImpl.class, "Stopped main game thread.");

			gameThread.join();
		}

		isRunning = false;
	}

	/* ========== Private ========== */
	private static final long ONE_SECOND_TICK_DELAY = 1000000000;
	private static final long DESIRED_TPS_PER_SECOND = 60;

	private boolean isRunning;

	private Thread gameThread = new Thread(new Runnable() {

		@Override
		public void run() {
			fpsCounter();
		}

	});

	private void fpsCounter() {
		long previousInterval = getCurrentNanoTime();
		int fps = 0;
		int tps = 0;

		while (true) {
			long currentInterval = getCurrentNanoTime();

			boolean oneTickHasPassed = currentInterval - previousInterval >= (tps + 1)
					* (ONE_SECOND_TICK_DELAY / DESIRED_TPS_PER_SECOND);
			boolean oneSecondHasPassed = currentInterval - ONE_SECOND_TICK_DELAY >= previousInterval;

			if (oneTickHasPassed) {
				tick();
				tps++;
			}

			if (oneSecondHasPassed) {
				previousInterval = currentInterval;
				log.info(MainGameThreadImpl.class, "FPS: " + fps + ", TPS: " + tps);
				fps = 0;
				tps = 0;
			}

			render();
			fps++;

		}
	}

	private long getCurrentNanoTime() {
		return System.nanoTime();
	}

	private void render() {
		game.render();
	}

	private void tick() {
		game.tick();
	}

}
