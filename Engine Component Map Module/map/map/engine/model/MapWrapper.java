package map.engine.model;

import architecture.AbstractWrapper;
import architecture.Entity;

/**
 * Immutable class that provides additional parameters for database {@link Entity} objects.
 */
public abstract class MapWrapper<T extends Entity> extends AbstractWrapper<T> {

	/* ========== Public ========== */
	public MapWrapper(T wrappedObject) {
		super(wrappedObject);
	}

	/* ========== Private ========== */

}
