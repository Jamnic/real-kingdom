package engine.model;

import map.engine.Picture;

public enum TerrainType {

	// @formatter:off
	OCEANS(new Picture(".")),
	MOUNTAINS(new Picture("M")),
	HILLS(new Picture("h")),
	SAVANNAH(new Picture("s")),
	WASTELANDS(new Picture("o"));
	// @formatter:on

	/* ========== Public ========== */
	private TerrainType(final Picture picture) {
		this.picture = picture;
	}

	public Picture getPicture() {
		return picture;
	}

	/* ========== Private ========== */
	private Picture picture;
}
