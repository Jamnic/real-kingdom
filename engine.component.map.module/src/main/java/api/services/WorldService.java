package api.services;

import model.World;
import model.enums.BoardSize;
import model.enums.WorldSize;

public interface WorldService {

	World[] getAvailableWorlds();

	void deleteWorld(Long id);

	void createNewWorld(String text, WorldSize worldSize, BoardSize boardSize);

	
	
}