package engine.model.dao;

import java.io.File;

import engine.model.World;

public class WorldDao extends Dao<World> {

	/* ========== Public ========== */
	public WorldDao(File file) {
		initialize(file);
	}

	/* ========== Private ========== */
}
