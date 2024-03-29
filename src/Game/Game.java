package Game;

import GUI.BoardPanel;
import GUI.Screen;

public class Game {

	private final Screen screen;
	private int duration;

	private static Player[] players = new Player[2];
	private Board board;

	private BoardPanel boardPanel;
	private Move[][] moveHistory;
	private static int turn = 0;
	public static boolean isOver = false;

	public static Move oldMove=null;
	public static Move newMove=null;

	public Game(int duration) {
		this.duration = duration;
		players[0] = new Player(Color.WHITE, duration);
		players[1] = new Player(Color.BLACK, duration);
		this.board = new Board();
		this.moveHistory = new Move[2][];
		this.screen = new Screen(this);
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

	private Square getSelectedSquare(){
		return boardPanel.getSelectedSquare();
	}
	private boolean isValidMove(Move move){
		return move != null && getSelectedSquare().getPiece().isAbleToMove(move, board) && getSelectedSquare().getPiece().isLegal(move, board);
	}

	private void undoSelection(){
		boardPanel.drawBoard(board);
		boardPanel.borderUnhighlight();
		boardPanel.setSelectedSquare(null);
	}
	private boolean isEndOfTheGame(){
		if(board.isCheckMate(players,turn)){
			System.out.println("checkmate");
			return true;
		}
		if(board.isStaleMate(players,turn)){
			System.out.println("stalemate");
			return true;
		}
		return false;
		//return (board.isCheckMate(players,turn) || board.isStaleMate(players,turn));
	}

	private void changeTurn(){
		Game.setTurn(Game.getTurn() ^ 1);
	}
	public void start() {
//		Clock clock = new Clock();
//		clock.start();
		Move move;
		while(!isOver) {
			move = getTheNextMove();
			if(isValidMove(move)){
				getSelectedSquare().getPiece().doMove(move, board);
				changeTurn();

			}
			undoSelection();
			if(isEndOfTheGame()){
				System.out.println("game over");
				System.exit(0);
			}

		}
//		clock.terminate();
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

	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

	public void setBoardPanel(BoardPanel boardPanel) {
		this.boardPanel = boardPanel;
	}

}
