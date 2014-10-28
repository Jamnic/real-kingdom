package engine.taskable.task;


public interface Task<T extends Taskable> {

	void execute(T t);
	
}
