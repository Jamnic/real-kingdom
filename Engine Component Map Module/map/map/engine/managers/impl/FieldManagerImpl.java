package map.engine.managers.impl;

import map.engine.Picture;
import map.engine.managers.FieldManager;
import map.engine.model.CreatureMapWrapper;
import map.engine.model.FieldMapWrapper;
import architecture.Manager;

import com.google.common.base.Optional;

// TODO javadoc
public class FieldManagerImpl extends Manager implements FieldManager {

	/* ========== Public ========== */
	/** {@inheritDoc} */
	@Override
	public Picture printFieldPicture(FieldMapWrapper field) {

		Optional<CreatureMapWrapper> entityOptional = field.getOccupyingCreature();

		return entityOptional.isPresent() ? entityOptional.get().getWrappedObject().getPicture() : field
				.getWrappedObject().getPicture();
	}
	

	/* ========== Private ========== */

}
