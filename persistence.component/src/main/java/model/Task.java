package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.enums.PriorityType;
import model.enums.TaskStatus;

/**
 * 1.0005 Task
 * 
 * Represents executable {@link Task} for {@link Creature}.
 */
@Entity
@Table
public class Task {

	/* ========== Fields ========== */
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private Creature creature;

	@Enumerated(EnumType.STRING)
	private TaskStatus status;

	@Enumerated(EnumType.STRING)
	private PriorityType priority;

	/* ========== Properties ========== */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Creature getCreature() {
		return creature;
	}

	public void setCreature(Creature creature) {
		this.creature = creature;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public PriorityType getPriority() {
		return priority;
	}

	public void setPriority(PriorityType priority) {
		this.priority = priority;
	}

}
