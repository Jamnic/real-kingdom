package engine.utility;

/**
 * Interface for all classes willing to be used in {@link PriorityList}.
 */
public interface Prioritable {

	/**
	 * Returns the prority.
	 */
	PriorityType getPriority();

}
