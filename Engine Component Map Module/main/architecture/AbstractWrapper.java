package architecture;

import main.managers.GameComponentContainer;


/**
 * Immutable class that provides wrapping abstraction for all {@link AbstractWrapper} extending classes.
 */
public abstract class AbstractWrapper<T> extends GameComponentContainer {

	/* ========== Public ========== */
	public AbstractWrapper(T wrappedObject) {
		this.wrappedObject = wrappedObject;
	}

	public T getWrappedObject() {
		return wrappedObject;
	}

	/* ========== Private ========== */
	private T wrappedObject;

}
