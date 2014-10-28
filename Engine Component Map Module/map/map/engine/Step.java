package map.engine;

import map.engine.model.FieldMapWrapper;

public class Step {

	public Step(FieldMapWrapper startField, FieldMapWrapper destinationField) {
		super();

		this.startField = startField;
		this.destinationField = destinationField;
	}

	/* Properties */
	public FieldMapWrapper getStartField() {
		return startField;
	}

	public FieldMapWrapper getDestinationField() {
		return destinationField;
	}

	/* Private */
	private FieldMapWrapper startField;
	private FieldMapWrapper destinationField;
}
