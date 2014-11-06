package dto;

import model.enums.TerrainType;

public class FieldDto {

	/* ========== Fields ========== */
	private TerrainType terrainType;
	private final CoordsDto coordsDto;

	/* ========== Constructors ========== */
	public FieldDto(TerrainType oceans, CoordsDto coordsDto) {
		this.terrainType = oceans;
		this.coordsDto = coordsDto;
	}

	/* ========== Properties ========== */
	public TerrainType getTerrainType() {
		return terrainType;
	}

	public void setTerrainType(TerrainType terrainType) {
		this.terrainType = terrainType;
	}

	public CoordsDto getCoordsDto() {
		return coordsDto;
	}
}
