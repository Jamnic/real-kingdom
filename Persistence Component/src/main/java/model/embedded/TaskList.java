package model.embedded;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

import model.Creature;
import model.Task;

/**
 * 1.0013 TaskList
 * 
 * Represents list of tasks assigned to the given {@link Creature}.
 */
@Embeddable
public class TaskList {

	/* ========== Fields ========== */
	@OneToMany
	private List<Task> priorityList;

	/* ========== Properties ========== */
	public List<Task> getPriorityList() {
		return priorityList;
	}

	public void setPriorityList(List<Task> priorityList) {
		this.priorityList = priorityList;
	}

}
