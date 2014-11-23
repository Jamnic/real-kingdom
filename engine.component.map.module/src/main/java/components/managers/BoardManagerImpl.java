package components.managers;

import java.util.List;

import model.Board;
import model.Field;
import model.FieldColumn;
import model.embedded.Coords;
import model.enums.BoardSize;
import model.enums.TerrainType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import priority.BoardIterator;
import repository.BoardDao;
import repository.FieldColumnDao;
import api.algorithms.TerrainGeneratorAlgorithm;
import api.managers.BoardManager;
import api.managers.FieldManager;
import architecture.Manager;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

@Component
public class BoardManagerImpl extends Manager implements BoardManager {

	@Autowired
	private BoardDao boardDao;

	@Autowired
	private FieldManager fieldManager;
	
	@Autowired
	private FieldColumnDao fieldColumnDao;

	@Autowired
	private TerrainGeneratorAlgorithm terrainGeneratorAlgorithm;

	/* ========== Public ========== */
	/** {@inheritDoc} */
	@Override
	public Board createNewBoard(String boardName, BoardSize boardSize) {

		Board board = terrainGeneratorAlgorithm.createBoardWithGeneratedTerrain(boardSize);

		board.setName(boardName);
		
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
	public Iterable<Field> getIterator(Board board) {
		return new BoardIterator(board);
	}

	/** {@inheritDoc} */
	@Override
	public Optional<Field> getField(Board board, Coords coords) {

		int y = coords.getY();
		int x = coords.getX();

		if (x < 0 || x >= board.getBoardSize().getWidth() || y < 0 || y >= board.getBoardSize().getHeight())
			return Optional.absent();

		TerrainType terrainType = board.getFieldColumns().get(x).getFields().get(y).getTerrainType();
		Field field = new Field();
		field.setTerrainType(terrainType);
		field.setCoords(new Coords(x, y));

		return Optional.fromNullable(field);
	}

	/* ========== Private ========== */

}
