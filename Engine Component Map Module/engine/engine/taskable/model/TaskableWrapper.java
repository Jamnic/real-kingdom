package engine.taskable.model;

import engine.taskable.task.Task;
import engine.taskable.task.Taskable;
import architecture.AbstractWrapper;

public abstract class TaskableWrapper<T extends Taskable> extends AbstractWrapper<T> {

	/* ========== Public ========== */
	public TaskableWrapper(T wrappedObject) {
		super(wrappedObject);
	}

	public void setTask(Task<T> task) {
		this.task = task;
	}

	public Task<T> getTask() {
		return task;
	}

	/* ========== Private ========== */
	private List<Task<T> task;

}
