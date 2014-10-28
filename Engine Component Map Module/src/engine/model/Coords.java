package engine.model;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 1.0007 Coords
 * 
 * Immutable {@link Coords} class representing coordinates in {@link Board}.
 */
public class Coords {

	/* ========== Public ========== */
	public Coords(int xPosition, int yPosition) {

		checkNotNull(xPosition);
		checkNotNull(yPosition);

		this.xPosition = xPosition;
		this.yPosition = yPosition;

	}

	public int getX() {
		return xPosition;
	}

	public int getY() {
		return yPosition;
	}

	/* ========== Private ========== */
	private final int xPosition;
	private final int yPosition;
}
