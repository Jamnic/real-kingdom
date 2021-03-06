package model.enums;

import model.World;

/**
 * 1.0012 WorldSize
 * 
 * Represents available {@link World} size values.
 */
public enum WorldSize {

	// @formatter:off
	TINY(16, 16),
	MEDIUM(32, 32),
	BIG(64, 64),
	HUGE(128, 128);
	// @formatter:on

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

	private WorldSize(final int width, final int height) {
		this.width = width;
		this.height = height;
	}
}
