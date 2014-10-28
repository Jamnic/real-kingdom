package map.engine.managers;

import map.engine.GameMap;
import map.engine.algorithm.TerrainGeneratorAlgorithm;
import map.engine.model.CreatureMapWrapper;
import map.engine.model.FieldMapWrapper;
import map.engine.utils.Coords;

import com.google.common.base.Optional;

/**
 * Manages the {@link GameMap} and other maps.
 */
public interface MapManager {

	/**
	 * Initializes the work of {@link MapManager}. Without {@link GameMap} many services cannot be used.<br>
	 * <br>
	 * Archives previous {@link GameMap} (if present) and generates a new one using {@link TerrainGeneratorAlgorithm}.
	 * 
	 * @param width
	 *            - number of columns of newly created {@link GameMap}.
	 * @param height
	 *            - number of rows of newly created {@link GameMap}.
	 */
	void createNewGameMap(final int width, final int height);

	/**
	 * Tries to put given {@link CreatureMapWrapper} on {@link FieldMapWrapper}. When creature already occupies field,
	 * or field is already occupied by creature, operation cannot be performed.
	 * 
	 * @param creature
	 *            - {@link CreatureMapWrapper} we are willing to put on field.
	 * @param field
	 *            - {@link FieldMapWrapper} we are willing to creature to be put on.
	 * @return true if operation was successful, false if not.
	 */
	boolean putCreature(CreatureMapWrapper creature, FieldMapWrapper field);

	/**
	 * Tries to pick given {@link CreatureMapWrapper} from occupied {@link FieldMapWrapper}. If creature does not occupy
	 * any field, false is returned. Otherwise, true is returned.
	 * 
	 * @param creature
	 *            - {@link CreatureMapWrapper} we are willing to pick from field.
	 * @return true if operation was successful, false if creature was not standing anywhere. Dont panic.
	 */
	boolean pickCreature(CreatureMapWrapper creature);

	/**
	 * Tries to pick {@link CreatureMapWrapper} from its previous location, and put on given {@link FieldMapWrapper}. If
	 * nothing wrong happens, the operation is successful. If not, there is an attempt to rollback these changes.
	 * 
	 * @param creature
	 *            - {@link CreatureMapWrapper} we are willing to pick and put on another field.
	 * @param field
	 *            - {@link FieldMapWrapper} we are willing to creature to be put on.
	 * @return true if operation was successful, false if not.
	 */
	boolean moveCreature(CreatureMapWrapper creature, FieldMapWrapper field);

	/**
	 * Returns {@link Optional} containing requested {@link FieldMapWrapper}. If {@link Coords} does not fit the
	 * {@link GameMap} size, returned optional is empty.
	 * 
	 * @param coords
	 *            - {@link Coords} of requested {@link FieldMapWrapper}.
	 * @return {@link Optional} containing requested {@link FieldMapWrapper}. If {@link Coords} does not fit the
	 *         {@link GameMap} size, returned optional is empty.
	 */
	Optional<FieldMapWrapper> getFieldFromGameMap(final Coords coords);

	/**
	 * Prints current state of {@link GameMap} in console output.
	 */
	void printGameMap();

}
