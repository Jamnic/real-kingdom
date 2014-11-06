package model.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import model.Board;

/**
 * 1.0007 Coords
 * 
 * Class representing coordinates in {@link Board}.
 */
@Embeddable
public class Coords {

	/* ========== Fields ========== */
	@Column
	private int x;

	@Column
	private int y;

	/* ========== Properties ========== */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
