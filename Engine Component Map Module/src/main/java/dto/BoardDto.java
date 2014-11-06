package dto;

public class BoardDto {

	/* ========== Fields ========== */
	private final String name;
	private final FieldDto[][] board;
	private final int boardWidth;
	private final int boardHeight;

	/* ========== Fields ========== */
	public BoardDto(String name, FieldDto[][] board, int boardWidth, int boardHeight) {
		this.name = name;
		this.board = board;
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
	}

	/* ========== Properties ========== */
	public String getName() {
		return name;
	}

	public FieldDto[][] getBoard() {
		return board;
	}

	public int getBoardWidth() {
		return boardWidth;
	}

	public int getBoardHeight() {
		return boardHeight;
	}
}
