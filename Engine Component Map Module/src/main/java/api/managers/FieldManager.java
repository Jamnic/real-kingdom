package api.managers;

import dto.CoordsDto;
import dto.FieldDto;
import model.Field;
import model.enums.TerrainType;

public interface FieldManager {

	Field createNewField(TerrainType type, CoordsDto coords);

	Field[][] assembleFieldFromFieldDto(FieldDto[][] board);

}