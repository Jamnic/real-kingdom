package dto;

import model.enums.BoardSize;

public class BoardDto {

	/* ========== Fields ========== */
	private final FieldDto[][] board;
	private final BoardSize boardSize;

	/* ========== Fields ========== */
	public BoardDto(FieldDto[][] board, BoardSize boardSize) {
		this.board = board;
		this.boardSize = boardSize;
	}

	/* ========== Properties ========== */
	public FieldDto[][] getBoard() {
		return board;
	}

	public BoardSize getBoardSize() {
		return boardSize;
	}

}
