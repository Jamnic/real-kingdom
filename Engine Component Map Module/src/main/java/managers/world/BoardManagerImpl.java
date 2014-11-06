package managers.world;

import managers.world.algorithm.TerrainGeneratorAlgorithm;
import model.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import priority.BoardIterator;
import repository.BoardDao;
import architecture.Manager;
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
	public Board createNewBoard(final String boardName, final int width, final int height) {

		BoardDto boardDto = terrainGeneratorAlgorithm.generateBoard(boardName, width, height);

		Board board = assembleBoardFromBoardDto(boardDto);

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

	public FieldDto get(Board board, CoordsDto coordsDto) {

		int y = coordsDto.getY();
		int x = coordsDto.getX();

		return new FieldDto(board.getBoard()[x][y].getTerrainType(), new CoordsDto(x, y));
	}

	/* ========== Private ========== */
	private Board assembleBoardFromBoardDto(BoardDto boardDto) {

		Board board = new Board();

		board.setBoard(fieldManager.assembleFieldFromFieldDto(boardDto.getBoard()));
		board.setHeight(boardDto.getBoardHeight());
		board.setWidth(boardDto.getBoardWidth());
		board.setName(boardDto.getName());

		return board;

	}
	
}
