package architecture;

import repository.WorldDao;
import repository.WorldDaoImpl;

public final class PersistenceComponent {

	public final static WorldDao worldDao = new WorldDaoImpl();
	
}
