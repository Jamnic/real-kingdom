package map.engine;

import architecture.Entity;

/**
 * Represents graphical representation of {@link Entity}.
 */
public class Picture {

	/* ========== Public ========== */
	public Picture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return picture;
	}

	/* ========== Private ========== */
	private String picture;

}
