package map.engine.algorithm.impl;

import map.engine.Board;
import map.engine.BoardIterator;
import map.engine.algorithm.TerrainGeneratorAlgorithm;
import map.engine.model.FieldMapWrapper;
import map.engine.utils.Coords;
import architecture.Algorithm;

import com.google.common.base.Optional;

import engine.model.Field;
import engine.model.TerrainType;

/**
 * Default implementation of {@link TerrainGeneratorAlgorithm}.
 */
public class TerrainGeneratorAlgorithmImpl extends Algorithm implements TerrainGeneratorAlgorithm {

	/* ========== Public ========== */
	/** {@inheritDoc} */
	@Override
	public Board generateBoard(final int boardWidth, final int boardHeight) {

		log.info(this.getClass(), "Initializing game board...");
		initializeBoardWithOceans(boardWidth, boardHeight);

		log.info(this.getClass(), "Generating wastelands...");
		generateSpreadTerrain(5, 50, TerrainType.WASTELANDS);

		log.info(this.getClass(), "Generating mountains...");
		generateSpreadTerrain(7, 30, TerrainType.MOUNTAINS);

		log.info(this.getClass(), "Generating hills...");
		generateSpreadTerrain(20, 5, TerrainType.HILLS);

		log.info(this.getClass(), "Generating savannah...");
		generateSpreadTerrain(20, 20, TerrainType.SAVANNAH);

		return board;
	}

	/* ========== Private ========== */
	private static final int MAX_MAGNITUDE = 100;
	private static final int MAX_FREQUENCY = 100;

	private Board board;

	private void initializeBoardWithOceans(int boardWidth, int boardHeight) {

		FieldMapWrapper[][] newArray = new FieldMapWrapper[boardWidth][];

		for (int i = 0; i < boardWidth; ++i) {
			newArray[i] = new FieldMapWrapper[boardHeight];

			for (int j = 0; j < boardHeight; ++j) {
				Field field = new Field(TerrainType.OCEANS);
				
				newArray[i][j] = new FieldMapWrapper(field, new Coords(i, j));
			}
			
		}

		board = new Board(newArray, boardWidth, boardHeight);
	}

	private void generateSpreadTerrain(int seedFrequency, int initialMagnitude, TerrainType terrain) {

		boolean seedFrequencyIsInvalid = seedFrequency < 1 || seedFrequency > MAX_FREQUENCY;
		boolean initialMagnitudeIsInvalid = initialMagnitude < 1 || initialMagnitude > MAX_MAGNITUDE;

		if (seedFrequencyIsInvalid || initialMagnitudeIsInvalid) {
			log.err(this.getClass(), "Invalid parameters (seedFrequency = " + seedFrequency + ", initialMagnitude = "
					+ initialMagnitude + "). Cannot calculate proper board.");
			return;
		}

		BoardIterator iterator = board.getIterator();

		while (iterator.hasNext()) {
			FieldMapWrapper field = iterator.next();

			boolean fieldCanBeChanged = field.getWrappedObject().getTerrainType() == TerrainType.OCEANS;
			boolean someLuck = dice.check(MAX_FREQUENCY / seedFrequency);

			if (fieldCanBeChanged && someLuck)
				setTerrainAndSpreadToNeighbours(initialMagnitude, terrain, field.getCoords());
		}
	}

	private void setTerrainAndSpreadToNeighbours(int magnitude, TerrainType terrain, Coords coords) {

		Field field = new Field(terrain);
		board.set(new FieldMapWrapper(field, coords));

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

		Optional<FieldMapWrapper> fieldOptional = board.get(coords);

		if (!fieldOptional.isPresent())
			return;

		boolean fieldCanBeChanged = fieldOptional.get().getWrappedObject().getTerrainType() == TerrainType.OCEANS;
		boolean someLuck = dice.check(MAX_MAGNITUDE / magnitude);

		if (fieldCanBeChanged && someLuck)
			setTerrainAndSpreadToNeighbours(magnitude - 1, terrain, coords);

	}

}
