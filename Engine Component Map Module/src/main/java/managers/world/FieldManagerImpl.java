package managers.world;

import model.Field;
import model.embedded.Coords;
import model.enums.TerrainType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dto.CoordsDto;
import dto.FieldDto;
import repository.FieldDao;

@Component
public class FieldManagerImpl implements FieldManager {

	@Autowired
	private FieldDao fieldDao;
	
	@Autowired
	private BoardManager boardManager;

	/* ========== Public ========== */
	@Override
	public Field createNewField(TerrainType type, CoordsDto coordsDto) {

		Field field = new Field();

		Coords coords = assembleCoordsFromCoordsDto(coordsDto);

		field.setTerrainType(type);
		field.setCoords(coords);

		return fieldDao.save(field);
	}

	@Override
	public Field[][] assembleFieldFromFieldDto(FieldDto[][] board) {
		
		for (FieldDto[] fieldArray : board);
		
		return null;
	}

	/* ========== Private ========== */
	private Coords assembleCoordsFromCoordsDto(CoordsDto coordsDto) {

		Coords coords = new Coords();

		coords.setX(coordsDto.getX());
		coords.setY(coordsDto.getY());

		return coords;
	}

}
