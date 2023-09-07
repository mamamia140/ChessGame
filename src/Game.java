
public class Game {
	private Clock[] clocks;
	private int duration;
	private static Player[] players;
	private Board board;
	private Move[][] moveHistory;
	private static int turn;
	private boolean isOver;
	
	public Game(int duration) {
		this.clocks = new Clock[2];
		this.duration = duration;
		this.players = new Player[2];
		this.players[0] = new Player("white",duration);
		this.players[1] = new Player("black",duration);
		this.board = new Board();
		this.moveHistory = new Move[2][];
		this.turn = 0;
		this.isOver = false;
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

	public static Player[] getPlayers() {
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

	public static int getTurn() {
		return turn;
	}

	public static void setTurn(int newTurn) {
		turn = newTurn;
	}
	public static Player getCurrentPlayer() {
		return Game.getPlayers()[Game.getTurn()];
	}
	public void start(Controller c) {
		Clock clock = new Clock();
		clock.start();
		String input;
		this.board.printTheBoard();
		while(!isOver) {
			input = c.getTheNextMove();
			if(input.equals("quit")) {
				isOver = true;
			}
			else if(input.equals("change")) {
				clock.changeTurn();
				turn ^= 1;
			}
			else {
				/*
				* hamlenin geçerliliğini kontrol et
				* if(yes){
				*	hamleyi isle
				*	oyun sonunu kontrol et
				*	if(yes){
				*		kullanıcıyı bilgilendir
				*		isOver = true;
				*	}
				*	
				*	sırayı değiştir turn ^= 1;
				*   tahtayı yazdır --> this.board.printTheBoard();	 		
				*}
				* else{
				*	kullanıcıyı uyar
				*}
				*/
			}
		}
		clock.terminate();
	}
}
