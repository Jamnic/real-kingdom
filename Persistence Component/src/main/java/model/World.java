package model;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 1.0009 World
 * 
 * Represents couple of {@link Board}'s in one {@link World}.
 */
public class World {

	/* ========== Public ========== */
	public World(String name, Board mainBoard, WorldSize worldSize) {

		super();

		checkNotNull(name);
		checkNotNull(mainBoard);

		this.name = name;
		this.mainBoard = mainBoard;
		this.worldSize = worldSize;

		lastUpdate = new Date();
		boards = new LinkedList<Board>();
	}

	public String getName() {
		return name;
	}

	public Board getMainBoard() {
		return mainBoard;
	}

	public List<Board> getBoards() {
		return boards;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		checkNotNull(lastUpdate);
		this.lastUpdate = lastUpdate;
	}

	public WorldSize getWorldSize() {
		return worldSize;
	}

	/* ========== Private ========== */
	private final String name;
	private final Board mainBoard;
	private final List<Board> boards;
	private Date lastUpdate;
	private final WorldSize worldSize;

}
