package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<FieldColumn> fieldColumns;

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

	public List<FieldColumn> getFieldColumns() {
		return fieldColumns;
	}

	public void setFieldColumns(List<FieldColumn> fieldColumns) {
		this.fieldColumns = fieldColumns;
	}

	public BoardSize getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(BoardSize boardSize) {
		this.boardSize = boardSize;
	}

}
