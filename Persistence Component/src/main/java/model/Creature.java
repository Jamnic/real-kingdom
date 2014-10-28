package model;

import static com.google.common.base.Preconditions.checkNotNull;
import priority.PriorityList;

import com.google.common.base.Optional;

/**
 * 1.0001 Creature
 * 
 * Represents a living, movable creature, which can be assigned some tasks to do.
 */
public class Creature {

	/* ========== Public ========== */
	public Creature(String name, Sprite sprite) {

		checkNotNull(name);

		this.name = name;

		this.status = CreatureStatus.ALIVE;
		this.occupiedField = Optional.absent();
		this.taskList = new PriorityList<Task>();
		this.sprite = sprite;

	}

	public String getName() {
		return name;
	}

	public CreatureStatus getStatus() {
		return status;
	}

	public void setStatus(CreatureStatus status) {
		checkNotNull(status);
		this.status = status;
	}

	public Optional<Field> getOccupiedField() {
		return occupiedField;
	}

	public void setOccupiedField(Field occupiedField) {
		this.occupiedField = Optional.fromNullable(occupiedField);
	}

	public Task getTask() {
		return taskList.peek();
	}

	public Sprite getSprite() {
		return sprite;
	}

	/* ========== Private ========== */
	private final String name;
	private CreatureStatus status;
	private Optional<Field> occupiedField;
	private final PriorityList<Task> taskList;
	private final Sprite sprite;

}
