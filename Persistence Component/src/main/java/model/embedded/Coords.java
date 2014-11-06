package model.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import model.Board;

/**
 * 1.0007 Coords
 * 
 * Immutable {@link Coords} class representing coordinates in {@link Board}.
 */
@Embeddable
public class Coords {

	/* ========== Fields ========== */
	@Column
	private int xPosition;

	@Column
	private int yPosition;

	/* ========== Properties ========== */
	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

}
