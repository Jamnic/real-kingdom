package thread.engine;

import architecture.GameThread;

/**
 * Default implementation of {@link MainGameThread}.
 * 
 * {@inheritDoc}
 */
public class MainGameThreadImpl extends GameThread implements MainGameThread {

	/* ========== Public ========== */
	/** {@inheritDoc} */
	@Override
	public void start() throws InterruptedException {

		if (!isRunning)
			gameThread.start();

		isRunning = true;
	}

	/** {@inheritDoc} */
	@Override
	public void stop() throws InterruptedException {

		if (isRunning)
			gameThread.join();

		isRunning = false;
	}

	/* ========== Private ========== */
	private static final long ONE_SECOND_TICK_DELAY = 1000000000;
	private static final long FRAME_GENERATION_DELAY = 16800000;

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

		while (true) {
			long currentInterval = getCurrentNanoTime();

			boolean oneFrameHasPassed = currentInterval - previousInterval > fps * FRAME_GENERATION_DELAY;
			boolean oneSecondHasPassed = currentInterval - ONE_SECOND_TICK_DELAY >= previousInterval;

			if (oneFrameHasPassed) {
				render();
				fps++;
			}

			if (oneSecondHasPassed) {
				tick();
				previousInterval = currentInterval;
				fps = 0;
			}
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
