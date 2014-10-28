package map.engine.managers;

import java.util.concurrent.CopyOnWriteArrayList;

import map.engine.Board;

// TODO javadoc
public interface ArchiveManager {

	// TODO javadoc
	void archiveMap(Board mapToArchive);

	// TODO javadoc
	CopyOnWriteArrayList<Board> getArchivedMaps();

}
