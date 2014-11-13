package components.managers;

import model.Board;
import model.enums.BoardSize;
import model.enums.TerrainType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import priority.BoardIterator;
import repository.BoardDao;
import api.algorithms.TerrainGeneratorAlgorithm;
import api.managers.BoardManager;
import api.managers.FieldManager;
import architecture.Manager;

import com.google.common.base.Optional;

import dto.BoardDto;
import dto.CoordsDto;
import dto.FieldDto;

@Component
public class BoardManagerImpl extends Manager implements BoardManager {

	@Autowired
	private BoardDao boardDao;

	@Autowired
	private FieldManager fieldManager;

	@Autowired
	private TerrainGeneratorAlgorithm terrainGeneratorAlgorithm;

	/* ========== Public ========== */
	/** {@inheritDoc} */
	@Override
	public Board createNewBoard(String boardName, BoardSize boardSize) {

		BoardDto boardDto = terrainGeneratorAlgorithm.createBoardDtoWithGeneratedTerrain(boardSize);

		Board board = assembleBoardFromBoardDto(boardName, boardDto);

		return boardDao.save(board);
	}

	/** {@inheritDoc} */
	@Override
	public String createBoardName(String worldName) {

		StringBuilder builder = new StringBuilder();
		builder.append(worldName);
		builder.append("_");

		return builder.toString();
	}

	/** {@inheritDoc} */
	@Override
	public Iterable<FieldDto> getIterator(BoardDto board) {
		return new BoardIterator(board);
	}

	/** {@inheritDoc} */
	@Override
	public Optional<FieldDto> getFieldDto(BoardDto boardDto, CoordsDto coordsDto) {

		int y = coordsDto.getY();
		int x = coordsDto.getX();

		if (x < 0 || x >= boardDto.getBoardSize().getWidth() || y < 0 || y >= boardDto.getBoardSize().getHeight())
			return Optional.absent();

		TerrainType terrainType = boardDto.getBoard()[x][y].getTerrainType();
		FieldDto fieldDto = new FieldDto(terrainType, new CoordsDto(x, y));

		return Optional.fromNullable(fieldDto);
	}

	/* ========== Private ========== */
	private Board assembleBoardFromBoardDto(String boardName, BoardDto boardDto) {

		Board board = new Board();

		board.setBoard(fieldManager.assembleFieldFromFieldDto(boardDto.getBoard()));
		board.setBoardSize(boardDto.getBoardSize());
		board.setName(boardName);

		return board;

	}

}
