package architecture;

import map.engine.Picture;

/**
 * Database entity with immutable parameters. Abstraction over all model classes.<br>
 * <br>
 * 
 * <b>Architecture</b><br>
 * They can not provide any more logic, than simple assigning and providing data. All modifications and calculations are
 * under proper {@link Manager} control.<br>
 * <br>
 * 
 * <b>Coding conventions</b><br>
 * {@link Enity} should be constructed as a simple JavaBean class and it should not have any interface.<br>
 * <br>
 */
public abstract class Entity {

	/* ========== Public ========== */
	/**
	 * Creates an {@link Entity} providing generated database <code>id</code> number, and assigning proper
	 * <code>Picture</code>. This constructor should be invoked by any model class.
	 * 
	 * @param picture
	 *            - to be set as a symbol of created {@link Entity}.
	 */
	public Entity(Picture picture) {
		// TODO Picutre nie moze byc w entity, bo niektorze rzeczy (np ekwipunek) moga nie byc pokazywane na mapie.
		this.picture = picture;

		this.id = INDEX++;
	}

	/**
	 * @return Database <code>id</code> of given {@link Entity}.
	 */
	public long getId() {
		return id;
	}

	public Picture getPicture() {
		return picture;
	}

	/* ========== Private ========== */
	private static long INDEX = 0;

	private Picture picture;
	private long id;

}
