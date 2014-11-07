package api.managers;

import model.World;
import model.enums.BoardSize;
import model.enums.WorldSize;

/**
 * Manages {@link World} entity.
 */
public interface WorldManager {

	/**
	 * 2.0001 Stworzenie nowego świata.
	 * 
	 * @param worldName
	 *            - name of {@link World} to be created.
	 * @param worldSize
	 *            - picked size.
	 * @param mainBoardSize
	 *            - size of main {@link Board} of created {@link World}.
	 * 
	 * @return Newly created {@link World}.
	 */
	World createNewWorld(String worldName, WorldSize worldSize, BoardSize mainBoardSize);

}