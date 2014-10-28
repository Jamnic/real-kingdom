package map.engine.utils;

/**
 * Immutable object that represents certain position on map. Can print out its values.
 */
public final class Coords {

	/* ========== Public ========== */
	/**
	 * Creates immutable {@link Coords} object representing map coordinates.
	 * 
	 * @param x
	 *            - number of column.
	 * @param y
	 *            - number of row.
	 */
	public Coords(int x, int y) {
		super();

		this.x = x;
		this.y = y;
	}

	/**
	 * Returns String representation of {@link Coords} object.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Coordinates: (");
		builder.append(x);
		builder.append(", ");
		builder.append(y);
		builder.append(")");
		return builder.toString();
	}

	/**
	 * @return Column position.
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return Row position.
	 */
	public int getY() {
		return y;
	}

	/* ========== Private ========== */
	private final int x;
	private final int y;
}
