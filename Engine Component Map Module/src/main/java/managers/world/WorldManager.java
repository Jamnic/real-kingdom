package managers.world;

import model.World;
import model.enums.WorldSize;

/**
 * Manages {@link World} entity.
 */
public interface WorldManager {

	/**
	 * 2.0001 Stworzenie nowego świata
	 */
	void createNewWorld(String worldName, WorldSize worldSize);

}