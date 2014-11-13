package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.enums.WorldSize;

/**
 * 1.0009 World
 * 
 * Represents couple of {@link Board}'s in one {@link World}.
 */
@Entity
@Table
public class World {

	/* ========== Fields ========== */
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@OneToOne
	private Board mainBoard;

	@OneToMany
	private List<Board> boards;

	@Column
	private Date lastUpdate;

	@Column
	private WorldSize worldSize;

	/* ========== Properties ========== */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Board getMainBoard() {
		return mainBoard;
	}

	public void setMainBoard(Board mainBoard) {
		this.mainBoard = mainBoard;
	}

	public List<Board> getBoards() {
		return boards;
	}

	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public WorldSize getWorldSize() {
		return worldSize;
	}

	public void setWorldSize(WorldSize worldSize) {
		this.worldSize = worldSize;
	}

}
