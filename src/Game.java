
public class Game {
	private Clock[] clocks;
	private int duration;
	private Player players;
	private Board board;
	private Move[][] moveHistory;
	private String turn;
	private boolean isOver;
	
	public Game() {
		this.clocks = new Clock[2];
		this.board = new Board();
		this.isOver = false;
		this.moveHistory = new Move[2][];
	}

	public Clock[] getClocks() {
		return clocks;
	}

	public void setClocks(Clock[] clocks) {
		this.clocks = clocks;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Player getPlayers() {
		return players;
	}

	public void setPlayers(Player players) {
		this.players = players;
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

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}
	
	public void start(Controller c) {
		String input;
		while(!isOver) {
			this.board.printTheBoard();
			input = c.getTheNextMove();
			if(input.equals("quit")) {
				isOver = true;
			}
			else {
				System.out.println(this.board.toString());
				//hamleyi isle
				//oyun sonunu kontrol et
				//turu degistir
			}
		}
	}
}
