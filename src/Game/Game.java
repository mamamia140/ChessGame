package Game;

public class Game {
	private int duration;

	private static Player[] players = new Player[2];
	private Board board;
	private Move[][] moveHistory;
	private static int turn = 0;
	private boolean isOver = false;

	public static Move oldMove=null;
	public static Move newMove=null;

	public Game(int duration) {
		this.duration = duration;
		players[0] = new Player(Color.WHITE, duration);
		players[1] = new Player(Color.BLACK, duration);
		this.board = new Board();
		this.moveHistory = new Move[2][];
	}

	private Move getTheNextMove(){
		try {
			while (oldMove == newMove) {
				Thread.sleep(100);
			}
			oldMove = newMove;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return newMove;
	}


	public void start() {
		Clock clock = new Clock();
		clock.start();
		Move input;
		while(!isOver) {
			input = getTheNextMove();
			System.out.println(input);
			//System.out.println(this.board.toString());
			//hamleyi isle
			//oyun sonunu kontrol et
			//turu degistir
			/*
				* hamlenin geçerliliðini kontrol et
				* if(yes){
				*	hamleyi isle
				*	oyun sonunu kontrol et
				*	if(yes){
				*		kullanýcýyý bilgilendir
				*		isOver = true;
				*	}
				*
				*	sýrayý deðiþtir
				*   tahtayý yazdýr --> this.board.printTheBoard();
				*}
				* else{
				*	kullanýcýyý uyar
				*}
			*/
		}

		clock.terminate();
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
		return Game.turn;
	}

	public static void setTurn(int turn) {
		Game.turn = turn;
	}

	public static Player getCurrentPlayer() {
		return players[turn];
	}

	public boolean isCheckMate() {
		return board.isCheckMate(players,turn);
	}

	public boolean isStaleMate() {
		return board.isStaleMate(players, turn);
	}
}
