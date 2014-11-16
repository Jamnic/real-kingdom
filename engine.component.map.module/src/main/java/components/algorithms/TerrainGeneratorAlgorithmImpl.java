package components.algorithms;

import java.util.ArrayList;
import java.util.List;

import model.Board;
import model.Field;
import model.FieldColumn;
import model.embedded.Coords;
import model.enums.BoardSize;
import model.enums.TerrainType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.algorithms.TerrainGeneratorAlgorithm;
import api.managers.BoardManager;
import api.managers.FieldManager;

import com.google.common.base.Optional;
import components.utilities.DiceUtility;
import components.utilities.LoggerUtility;

/**
 * Default implementation of {@link TerrainGeneratorAlgorithm}.
 */
@Component
public class TerrainGeneratorAlgorithmImpl implements TerrainGeneratorAlgorithm {

	@Autowired
	private BoardManager boardManager;

	@Autowired
	private FieldManager fieldManager;

	@Autowired
	private DiceUtility dice;

	@Autowired
	private LoggerUtility log;

	/* ========== Public ========== */
	/** {@inheritDoc} */
	@Override
	public Board createBoardWithGeneratedTerrain(BoardSize boardSize) {

		log.info(TerrainGeneratorAlgorithmImpl.class, "Initializing worlds with oceans...");
		initializeBoardWithOceans(boardSize);

		log.info(TerrainGeneratorAlgorithmImpl.class, "Creating wastelands...");
		generateSpreadTerrain(5, 10, TerrainType.WASTELANDS);
		log.info(TerrainGeneratorAlgorithmImpl.class, "Creating mountains...");
		generateSpreadTerrain(7, 2, TerrainType.MOUNTAINS);
		log.info(TerrainGeneratorAlgorithmImpl.class, "Creating hills...");
		generateSpreadTerrain(20, 5, TerrainType.HILLS);
		log.info(TerrainGeneratorAlgorithmImpl.class, "Creating savannah...");
		generateSpreadTerrain(20, 7, TerrainType.SAVANNAH);

		return board;
	}

	/* ========== Private ========== */
	private static final int MAX_MAGNITUDE = 100;
	private static final int MAX_FREQUENCY = 100;

	private Board board;

	private void initializeBoardWithOceans(BoardSize boardSize) {

		int boardWidth = boardSize.getWidth();
		int boardHeight = boardSize.getHeight();

		List<FieldColumn> newArray = new ArrayList<FieldColumn>(boardWidth);

		for (int i = 0; i < boardWidth; ++i) {

			FieldColumn fieldColumn = new FieldColumn();
			newArray.add(fieldColumn);
			fieldColumn.setFields(new ArrayList<Field>(boardHeight));

			for (int j = 0; j < boardHeight; ++j) {
				Field field = new Field();
				field.setTerrainType(TerrainType.OCEANS);
				field.setCoords(new Coords(i, j));
				fieldColumn.getFields().add(field);
			}
		}

		board = new Board();
		board.setFieldColumns(newArray);
		board.setBoardSize(boardSize);
	}

	private void generateSpreadTerrain(int seedFrequency, int initialMagnitude, TerrainType terrain) {

		boolean seedFrequencyIsInvalid = seedFrequency < 1 || seedFrequency > MAX_FREQUENCY;
		boolean initialMagnitudeIsInvalid = initialMagnitude < 1 || initialMagnitude > MAX_MAGNITUDE;

		if (seedFrequencyIsInvalid || initialMagnitudeIsInvalid) {
			log.err(this.getClass(), "Invalid parameters (seedFrequency = " + seedFrequency + ", initialMagnitude = "
					+ initialMagnitude + "). Cannot calculate proper board.");
			return;
		}

		for (Field field : boardManager.getIterator(board)) {

			boolean fieldCanBeChanged = field.getTerrainType() == TerrainType.OCEANS;
			boolean someLuck = dice.check(MAX_FREQUENCY / seedFrequency);

			if (fieldCanBeChanged && someLuck)
				setTerrainAndSpreadToNeighbours(initialMagnitude, terrain, field);
		}
	}

	private void setTerrainAndSpreadToNeighbours(int magnitude, TerrainType terrain, Field field) {

		field.setTerrainType(terrain);
		Coords coords = field.getCoords();

		if (magnitude == 0)
			return;

		int x = coords.getX();
		int y = coords.getY();

		spreadFurtherToNeighbour(magnitude, terrain, new Coords(x + 1, y + 0));
		spreadFurtherToNeighbour(magnitude, terrain, new Coords(x + 0, y + 1));
		spreadFurtherToNeighbour(magnitude, terrain, new Coords(x + 0, y - 1));
		spreadFurtherToNeighbour(magnitude, terrain, new Coords(x - 1, y + 0));
	}

	private void spreadFurtherToNeighbour(int magnitude, TerrainType terrain, Coords coords) {

		Optional<Field> fieldOptional = boardManager.getField(board, coords);

		if (!fieldOptional.isPresent())
			return;

		boolean fieldCanBeChanged = fieldOptional.get().getTerrainType() == TerrainType.OCEANS;
		boolean someLuck = dice.check(MAX_MAGNITUDE / magnitude);

		if (fieldCanBeChanged && someLuck)
			setTerrainAndSpreadToNeighbours(magnitude - 1, terrain, fieldOptional.get());

	}

}
