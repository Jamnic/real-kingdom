package engine.model;

import map.engine.Picture;
import architecture.Entity;
import engine.taskable.task.Taskable;

/**
 * Represents non living mechanisms which can perform some tasks (melting, transmitting etc.).
 */
public class Automat extends Entity implements Taskable {

	/* ========== Public ========== */
	public Automat(String name, Picture picture) {
		super(picture);

		this.name = name;
	}

	@Override
	public String toString() {
		return name + " (" + getPicture() + ")";
	}

	/* ========== Private ========== */
	private String name;

}
