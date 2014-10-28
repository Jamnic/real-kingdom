package engine.model;

import static com.google.common.base.Preconditions.checkNotNull;
import architecture.Entity;

import com.google.common.base.Optional;

/**
 * 1.0003 Field
 * 
 * Represents single immovable place on map.
 */
public class Field extends Entity {

	/* ========== Public ========== */
	public Field(TerrainType terrainType, Coords coords) {

		checkNotNull(terrainType);
		checkNotNull(coords);

		this.terrainType = terrainType;
		this.coords = coords;

	}

	public TerrainType getTerrainType() {
		return terrainType;
	}

	public void setTerrainType(TerrainType terrainType) {
		checkNotNull(terrainType);
		this.terrainType = terrainType;
	}

	public Coords getCoords() {
		return coords;
	}

	public Optional<Creature> getOccupyingCreature() {
		return occupyingCreature;
	}

	public void setOccupyingCreature(Optional<Creature> occupyingCreature) {
		this.occupyingCreature = occupyingCreature;
	}

	/* ========== Private ========== */
	private static final long serialVersionUID = -1071084747871367184L;
	private TerrainType terrainType;
	private final Coords coords;
	private Optional<Creature> occupyingCreature;

}
