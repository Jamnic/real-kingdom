package managers.world.algorithm;

import managers.world.FieldManager;
import model.embedded.Coords;
import model.enums.TerrainType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import architecture.Algorithm;

import com.google.common.base.Optional;

import dto.BoardDto;
import dto.CoordsDto;
import dto.FieldDto;

/**
 * Default implementation of {@link TerrainGeneratorAlgorithm}.
 */
@Component
public class TerrainGeneratorAlgorithmImpl extends Algorithm implements TerrainGeneratorAlgorithm {

	@Autowired
	private FieldManager fieldManager;

	/* ========== Public ========== */
	/** {@inheritDoc} */
	@Override
	public BoardDto generateBoard(final String name, final int boardWidth, final int boardHeight) {

		log.info(this.getClass(), "Initializing game board...");
		initializeBoardWithOceans(name, boardWidth, boardHeight);

		log.info(this.getClass(), "Generating wastelands...");
		generateSpreadTerrain(5, 50, TerrainType.WASTELANDS);

		log.info(this.getClass(), "Generating mountains...");
		generateSpreadTerrain(7, 30, TerrainType.MOUNTAINS);

		log.info(this.getClass(), "Generating hills...");
		generateSpreadTerrain(20, 5, TerrainType.HILLS);

		log.info(this.getClass(), "Generating savannah...");
		generateSpreadTerrain(20, 20, TerrainType.SAVANNAH);

		return boardDto;
	}

	/* ========== Private ========== */
	private static final int MAX_MAGNITUDE = 100;
	private static final int MAX_FREQUENCY = 100;

	private BoardDto boardDto;

	private void initializeBoardWithOceans(String name, int boardWidth, int boardHeight) {

		FieldDto[][] newArray = new FieldDto[boardWidth][];

		for (int i = 0; i < boardWidth; ++i) {
			newArray[i] = new FieldDto[boardHeight];

			for (int j = 0; j < boardHeight; ++j)
				newArray[i][j] = new FieldDto(TerrainType.OCEANS, new CoordsDto(i, j));
		}

		boardDto = new BoardDto(name, newArray, boardWidth, boardHeight);
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
		Coords coords = field.getCoords();

		if (magnitude == 0)
			return;

		int x = coords.getX();
		int y = coords.getY();

		spreadFurtherToNeighbour(magnitude, terrain, new CoordsDto(x + 1, y + 0));
		spreadFurtherToNeighbour(magnitude, terrain, new CoordsDto(x + 0, y + 1));
		spreadFurtherToNeighbour(magnitude, terrain, new CoordsDto(x + 0, y - 1));
		spreadFurtherToNeighbour(magnitude, terrain, new CoordsDto(x - 1, y + 0));
	}

	private void spreadFurtherToNeighbour(int magnitude, TerrainType terrain, CoordsDto coords) {

		Optional<FieldDto> fieldOptional = board.get(coords);

		if (!fieldOptional.isPresent())
			return;

		boolean fieldCanBeChanged = fieldOptional.get().getTerrainType() == TerrainType.OCEANS;
		boolean someLuck = dice.check(MAX_MAGNITUDE / magnitude);

		if (fieldCanBeChanged && someLuck)
			setTerrainAndSpreadToNeighbours(magnitude - 1, terrain, fieldOptional.get());

	}

}
