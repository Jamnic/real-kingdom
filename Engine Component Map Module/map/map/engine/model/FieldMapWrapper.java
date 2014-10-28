package map.engine.model;

import map.engine.utils.Coords;

import com.google.common.base.Optional;

import engine.model.Field;

public class FieldMapWrapper extends MapWrapper<Field> {

	/* ========== Public ========== */
	public FieldMapWrapper(Field wrappedObject, Coords coords) {
		super(wrappedObject);

		this.coords = coords;

		occupyingEntity = Optional.absent();
	}

	public Coords getCoords() {
		return coords;
	}

	public Optional<CreatureMapWrapper> getOccupyingCreature() {
		return occupyingEntity;
	}

	public void setOccupyingEntity(CreatureMapWrapper occupyingEntity) {
		this.occupyingEntity = Optional.fromNullable(occupyingEntity);
	}
	
	@Override
	public String toString() {
		return getCoords() + " (" + getWrappedObject().toString() + ")";
	}

	/* ========== Private ========== */
	private Optional<CreatureMapWrapper> occupyingEntity;
	private Coords coords;

}
