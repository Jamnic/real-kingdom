package components.managers;

import model.Field;
import model.embedded.Coords;
import model.enums.ProductionFacility;
import model.enums.RoadType;
import model.enums.TerrainType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.FieldDao;
import api.managers.BoardManager;
import api.managers.FieldManager;

@Component
public class FieldManagerImpl implements FieldManager {

	@Autowired
	private FieldDao fieldDao;

	@Autowired
	private BoardManager boardManager;

	/* ========== Public ========== */
	@Override
	public Field createNewField(TerrainType type, Coords coords) {

		Field field = new Field();

		field.setTerrainType(type);
		field.setCoords(coords);
		field.setProductionFacility(ProductionFacility.NONE);
		field.setRoad(RoadType.NO_ROAD);

		return fieldDao.save(field);
	}

	/* ========== Private ========== */

}
