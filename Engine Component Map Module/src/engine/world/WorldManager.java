package engine.world;

import engine.model.WorldSize;

/**
 * Manages {@link World} entity.
 */
public interface WorldManager {

	/**
	 * 2.0001 Stworzenie nowego Œwiata
	 */
	void createNewWorld(String worldName , WorldSize worldSize);

}