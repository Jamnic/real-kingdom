package engine.model;

import static com.google.common.base.Preconditions.checkNotNull;
import architecture.Entity;

/**
 * 1.0007 Coords
 * 
 * Immutable {@link Coords} class representing coordinates in {@link Board}.
 */
public class Coords extends Entity {

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
	private static final long serialVersionUID = 8455426871491846006L;
	private final int xPosition;
	private final int yPosition;
}
