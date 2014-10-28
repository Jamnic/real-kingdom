package deprecated.to.reuse;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import architecture.Manager;

import com.google.common.collect.Lists;

import engine.model.Board;

// TODO javadoc
public class ArchiveManagerImpl extends Manager {

	/* ========== Public ========== */
	/** {@inheritDoc} */
	public void archiveMap(Board mapToArchive) {

		log.info(this.getClass(), "Archiving old map...");

		archivedMaps.add(mapToArchive);

		log.info(this.getClass(), "Map archived successfully!");

	}

	/** {@inheritDoc} */
	public CopyOnWriteArrayList<Board> getArchivedMaps() {

		return Lists.newCopyOnWriteArrayList(archivedMaps);

	}

	/* ========== Private ========== */
	private List<Board> archivedMaps = Lists.newArrayList();

}
