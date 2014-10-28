package map.engine.managers.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import map.engine.Board;
import map.engine.managers.ArchiveManager;
import architecture.Manager;

import com.google.common.collect.Lists;

// TODO javadoc
public class ArchiveManagerImpl extends Manager implements ArchiveManager {

	/* ========== Public ========== */
	/** {@inheritDoc} */
	@Override
	public void archiveMap(Board mapToArchive) {

		log.info(this.getClass(), "Archiving old map...");

		archivedMaps.add(mapToArchive);

		log.info(this.getClass(), "Map archived successfully!");

	}

	/** {@inheritDoc} */
	@Override
	public CopyOnWriteArrayList<Board> getArchivedMaps() {

		return Lists.newCopyOnWriteArrayList(archivedMaps);

	}

	/* ========== Private ========== */
	private List<Board> archivedMaps = Lists.newArrayList();

}
