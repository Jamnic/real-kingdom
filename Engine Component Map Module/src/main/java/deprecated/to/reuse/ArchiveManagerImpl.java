package deprecated.to.reuse;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import model.Board;
import architecture.Manager;

import com.google.common.collect.Lists;

// TODO javadoc
public class ArchiveManagerImpl extends Manager {

	/* ========== Public ========== */
	/** {@inheritDoc} */
	public void archiveMap(Board mapToArchive) {

		archivedMaps.add(mapToArchive);

	}

	/** {@inheritDoc} */
	public CopyOnWriteArrayList<Board> getArchivedMaps() {

		return Lists.newCopyOnWriteArrayList(archivedMaps);

	}

	/* ========== Private ========== */
	private List<Board> archivedMaps = Lists.newArrayList();

}
