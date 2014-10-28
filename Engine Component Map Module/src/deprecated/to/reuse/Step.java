package deprecated.to.reuse;

import engine.model.Field;

public class Step {

	public Step(Field startField, Field destinationField) {
		super();

		this.startField = startField;
		this.destinationField = destinationField;
	}

	/* Properties */
	public Field getStartField() {
		return startField;
	}

	public Field getDestinationField() {
		return destinationField;
	}

	/* Private */
	private Field startField;
	private Field destinationField;
}
