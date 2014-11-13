package components.algorithms;

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
import dto.BoardDto;
import dto.CoordsDto;
import dto.FieldDto;

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
	public BoardDto createBoardDtoWithGeneratedTerrain(BoardSize boardSize) {

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
		
		return boardDto;
	}

	/* ========== Private ========== */
	private static final int MAX_MAGNITUDE = 100;
	private static final int MAX_FREQUENCY = 100;

	private BoardDto boardDto;

	private void initializeBoardWithOceans(BoardSize boardSize) {

		int boardWidth = boardSize.getWidth();
		int boardHeight = boardSize.getHeight();

		FieldDto[][] newArray = new FieldDto[boardWidth][];

		for (int i = 0; i < boardWidth; ++i) {
			newArray[i] = new FieldDto[boardHeight];

			for (int j = 0; j < boardHeight; ++j)
				newArray[i][j] = new FieldDto(TerrainType.OCEANS, new CoordsDto(i, j));
		}

		boardDto = new BoardDto(newArray, boardSize);
	}

	private void generateSpreadTerrain(int seedFrequency, int initialMagnitude, TerrainType terrain) {

		boolean seedFrequencyIsInvalid = seedFrequency < 1 || seedFrequency > MAX_FREQUENCY;
		boolean initialMagnitudeIsInvalid = initialMagnitude < 1 || initialMagnitude > MAX_MAGNITUDE;

		if (seedFrequencyIsInvalid || initialMagnitudeIsInvalid) {
			log.err(this.getClass(), "Invalid parameters (seedFrequency = " + seedFrequency + ", initialMagnitude = "
					+ initialMagnitude + "). Cannot calculate proper board.");
			return;
		}

		for (FieldDto field : boardManager.getIterator(boardDto)) {

			boolean fieldCanBeChanged = field.getTerrainType() == TerrainType.OCEANS;
			boolean someLuck = dice.check(MAX_FREQUENCY / seedFrequency);

			if (fieldCanBeChanged && someLuck)
				setTerrainAndSpreadToNeighbours(initialMagnitude, terrain, field);
		}
	}

	private void setTerrainAndSpreadToNeighbours(int magnitude, TerrainType terrain, FieldDto field) {

		field.setTerrainType(terrain);
		CoordsDto coords = field.getCoordsDto();

		if (magnitude == 0)
			return;

		int x = coords.getX();
		int y = coords.getY();

		spreadFurtherToNeighbour(magnitude, terrain, new CoordsDto(x + 1, y + 0));
		spreadFurtherToNeighbour(magnitude, terrain, new CoordsDto(x + 0, y + 1));
		spreadFurtherToNeighbour(magnitude, terrain, new CoordsDto(x + 0, y - 1));
		spreadFurtherToNeighbour(magnitude, terrain, new CoordsDto(x - 1, y + 0));
	}

	private void spreadFurtherToNeighbour(int magnitude, TerrainType terrain, CoordsDto coordsDto) {

		Optional<FieldDto> fieldOptional = boardManager.getFieldDto(boardDto, coordsDto);

		if (!fieldOptional.isPresent())
			return;

		boolean fieldCanBeChanged = fieldOptional.get().getTerrainType() == TerrainType.OCEANS;
		boolean someLuck = dice.check(MAX_MAGNITUDE / magnitude);

		if (fieldCanBeChanged && someLuck)
			setTerrainAndSpreadToNeighbours(magnitude - 1, terrain, fieldOptional.get());

	}

}
