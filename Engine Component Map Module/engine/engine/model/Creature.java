package engine.model;

import engine.taskable.task.Taskable;
import map.engine.Picture;
import architecture.Entity;

/**
 * Represents a living, movable creature, which can be assigned some tasks to do.
 */
public class Creature extends Entity implements Taskable {

	/* ========== Public ========== */
	public Creature(String name, Picture picture) {
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
