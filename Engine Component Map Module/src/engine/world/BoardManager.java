package engine.world;

import engine.model.Board;
import engine.model.World;

public interface BoardManager {

	/**
	 * 2.0003 Wygenerowanie nazwy Planszy
	 * 
	 * @param worldName
	 *            - name of {@link World}.
	 * @return Prepared {@link Board} name.
	 */
	String createBoardName(String worldName);

	Board createNewBoard(String boardName, int width, int height);

}