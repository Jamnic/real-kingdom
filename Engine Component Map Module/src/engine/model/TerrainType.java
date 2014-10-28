package engine.model;

/**
 * 1.0004 TerrainType
 * 
 * Type of terrain for {@link Field}.
 */
public enum TerrainType {

	// @formatter:off
	HILLS(new Sprite()),
	OCEANS(new Sprite()),
	SAVANNAH(new Sprite()),
	MOUNTAINS(new Sprite()),
	WASTELANDS(new Sprite());
	// @formatter:on

	/* ========== Public ========== */
	public Sprite getSprite() {
		return sprite;
	}

	/* ========== Private ========== */
	private final Sprite sprite;

	private TerrainType(Sprite sprite) {
		this.sprite = sprite;
	}

}
