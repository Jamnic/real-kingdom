package model.enums;

import model.Board;

/**
 * 1.0015 BoardSize
 * 
 * Represents available {@link Board} size values.
 */
public enum BoardSize {

	// @formatter:off
	TINY(128, 128),
	MEDIUM(256, 256),
	BIG(512, 512);
	// @formatter:off
	
	/* ========== Public ========== */
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	/* ========== Private ========== */
	private final int width;
	private final int height;

	private BoardSize(final int width, final int height) {
		this.width = width;
		this.height = height;
	}
	
}
