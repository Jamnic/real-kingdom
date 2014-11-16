package api.managers;

import model.Board;
import model.Field;
import model.World;
import model.embedded.Coords;
import model.enums.BoardSize;

import com.google.common.base.Optional;

public interface BoardManager {

	/**
	 * 2.0002 Stworzenie nowej Planszy
	 * 
	 * @param boardName
	 *            - name of {@link Board} to be created.
	 * @param boardSize
	 *            - size of {@link Board}.
	 * @return Newly created {@link Board}.
	 */
	Board createNewBoard(String boardName, BoardSize boardSize);

	/**
	 * 2.0003 Wygenerowanie nazwy Planszy
	 * 
	 * @param worldName
	 *            - name of {@link World} to be created.
	 * @return Prepared {@link Board} name.
	 */
	String createBoardName(String worldName);

	Iterable<Field> getIterator(Board board);

	Optional<Field> getField(Board board, Coords coords);

}