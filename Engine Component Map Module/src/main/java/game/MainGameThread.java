package game;

/**
 * Interface for {@link MainGameThread}. It runs the heart of the game, and invokes ticks and renders of the graphics.
 */
public interface MainGameThread {

	/**
	 * Safely starts the main thread.
	 * 
	 * @throws InterruptedException
	 */
	void start() throws InterruptedException;

	/**
	 * Safely stops the main thread.
	 * 
	 * @throws InterruptedException
	 */
	void stop() throws InterruptedException;

}