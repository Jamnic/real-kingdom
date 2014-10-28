package map.engine.model;

import com.google.common.base.Optional;

import engine.model.Creature;

public class CreatureMapWrapper extends MapWrapper<Creature> {

	/* ========== Public ========== */
	public CreatureMapWrapper(Creature wrappedObject) {
		super(wrappedObject);
	}

	public Optional<FieldMapWrapper> getOccupiedField() {
		return occupiedField;
	}

	public void setOccupiedField(FieldMapWrapper occupiedField) {
		this.occupiedField = Optional.fromNullable(occupiedField);
	}
	
	@Override
	public String toString() {
		return getWrappedObject().toString();
	}

	/* ========== Private ========== */
	private Optional<FieldMapWrapper> occupiedField = Optional.absent();

}
