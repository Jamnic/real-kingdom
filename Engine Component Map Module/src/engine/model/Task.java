package engine.model;

import static com.google.common.base.Preconditions.checkNotNull;
import engine.utility.Prioritable;
import engine.utility.PriorityType;

/**
 * 1.0005 Task
 * 
 * Represents executable {@link Task} for {@link Creature}.
 */
public class Task implements Prioritable {

	/* ========== Public ========== */
	public Task(Creature creature, PriorityType priority, TaskStatus status) {

		checkNotNull(creature);
		checkNotNull(priority);
		checkNotNull(status);

		this.creature = creature;
		this.priority = priority;
		this.status = status;

	}

	public Creature getCreature() {
		return creature;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		checkNotNull(status);
		this.status = status;
	}

	@Override
	public PriorityType getPriority() {
		return priority;
	}

	public void setPriority(PriorityType priority) {
		checkNotNull(priority);
		this.priority = priority;
	}

	/* ========== Private ========== */
	private final Creature creature;
	private TaskStatus status;
	private PriorityType priority;

}
