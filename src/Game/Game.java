package Game;

public class Game {
	private int duration;

	private Player[] players;
	private Board board;
	private Move[][] moveHistory;
	private int turn = 0;
	private boolean isOver = false;

	public Game(int duration) {
		this.duration = duration;
		players = new Player[2];
		players[0] = new Player(Color.WHITE, duration);
		players[1] = new Player(Color.BLACK, duration);
		this.board = new Board();
		this.moveHistory = new Move[2][];
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Player[] getPlayers() {
		return players;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Move[][] getMoveHistory() {
		return moveHistory;
	}

	public void setMoveHistory(Move[][] moveHistory) {
		this.moveHistory = moveHistory;
	}

	public int getTurn() {
		return this.turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public Player getCurrentPlayer() {
		return getPlayers()[this.getTurn()];
	}

	public void start() {

	}

	public boolean isCheckMate() {
		return board.isCheckMate(players,turn);
	}

	public boolean isStaleMate() {
		return board.isStaleMate(players, turn);
	}
}
