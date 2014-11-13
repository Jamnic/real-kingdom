package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import model.enums.BoardSize;

/**
 * 1.0008 Board
 * 
 * Represents a play {@link Board} in the game.
 */
@Entity
@Table
public class Board {

	/* ========== Fields ========== */
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column
	private Field[][] board;

	@Enumerated
	private BoardSize boardSize;

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

	public Field[][] getBoard() {
		return board;
	}

	public void setBoard(Field[][] board) {
		this.board = board;
	}

	public BoardSize getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(BoardSize boardSize) {
		this.boardSize = boardSize;
	}

}
