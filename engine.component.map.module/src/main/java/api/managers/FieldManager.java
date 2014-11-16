package api.managers;

import model.Field;
import model.embedded.Coords;
import model.enums.TerrainType;

public interface FieldManager {

	Field createNewField(TerrainType type, Coords coords);

}