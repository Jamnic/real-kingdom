package engine.utility;

public enum PriorityType {

	LIFE_SAVING(5), CRITICAL(4), MAJOR(3), TYPICAL(2), MINOR(1);

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
