package model.enums;

/**
 * 1.0014 PriorityType
 * 
 * Represents the priority of the {@link Task}.
 */
public enum PriorityType {

	// @formatter:off
	LIFE_SAVING(5),
	CRITICAL(4),
	MAJOR(3),
	TYPICAL(2),
	MINOR(1);
	// @formatter:on

	/* ========== Public ========== */
	private PriorityType(int priorityIndex) {
		this.priorityIndex = priorityIndex;
	}

	public int compare(PriorityType compared) {
		return priorityIndex.compareTo(compared.priorityIndex);
	}

	/* ========== Private ========== */
	private Integer priorityIndex;

}
