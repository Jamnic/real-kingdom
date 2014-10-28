package engine.model;

import architecture.Entity;

/**
 * Represents single immovable place on map.
 */
public class Field extends Entity {

	/* ========== Public ========== */
	public Field(TerrainType terrainType) {
		super(terrainType.getPicture());

		this.terrainType = terrainType;
	}

	public TerrainType getTerrainType() {
		return terrainType;
	}

	/** Cannot be set to null! */
	public void setTerrainType(TerrainType terrainType) {
		this.terrainType = terrainType;
	}
	
	@Override
	public String toString() {
		return getTerrainType().getPicture().toString();
	}

	/* ========== Private ========== */
	private TerrainType terrainType;

}
