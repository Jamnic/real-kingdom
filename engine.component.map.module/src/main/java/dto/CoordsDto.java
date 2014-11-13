package dto;

public class CoordsDto {

	/* ========== Fields ========== */
	private final int x;
	private final int y;

	/* ========== Constructors ========== */
	public CoordsDto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/* ========== Properties ========== */
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
