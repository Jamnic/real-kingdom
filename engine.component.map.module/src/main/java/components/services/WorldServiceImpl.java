package components.services;

import java.util.List;

import model.World;
import model.enums.BoardSize;
import model.enums.WorldSize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.managers.WorldManager;
import api.services.WorldService;

@Service
public class WorldServiceImpl implements WorldService {

	@Autowired
	private WorldManager worldManager;

	/* ========== Public ========== */
	@Override
	public World[] getAvailableWorlds() {
		List<World> availableWorlds = worldManager.getAvailableWorlds();

		int size = availableWorlds.size();
		
		System.out.println(size);

		return size > 10 ? availableWorlds.subList(0, 10).toArray(new World[10]) : availableWorlds
				.toArray(new World[size]);
	}

	@Override
	public void deleteWorld(Long id) {
		
		worldManager.deleteWorld(id);

	}

	@Override
	public void createNewWorld(String worldName, WorldSize worldSize, BoardSize boardSize) {

		worldManager.createNewWorld(worldName, worldSize, boardSize);

	}

	/* ========== Private ========== */
}
