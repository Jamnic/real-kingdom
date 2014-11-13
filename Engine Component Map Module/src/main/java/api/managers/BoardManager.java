package api.managers;

import model.Board;
import model.World;
import model.enums.BoardSize;

import com.google.common.base.Optional;

import dto.BoardDto;
import dto.CoordsDto;
import dto.FieldDto;

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

	Iterable<FieldDto> getIterator(BoardDto board);

	Optional<FieldDto> getFieldDto(BoardDto boardDto, CoordsDto coordsDto);

}