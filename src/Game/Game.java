package Game;

import java.util.ArrayList;
import java.util.Collection;

import GUI.*;
import Pieces.*;

public class Game {
	private int duration;
	private static Player[] players;
	private Board board;
	private Move[][] moveHistory;
	private static int turn = 0;
	private boolean isOver = false;

	public Game(int duration) {
		this.duration = duration;
		players = new Player[2];
		players[0] = new Player(Color.WHITE, duration);
		players[1] = new Player(Color.BLACK, duration);
		this.moveHistory = new Move[2][];
		this.board = new Board();
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

	public void start() {

	}

	public boolean isCheckMate() {
		return board.isCheckMate(players,turn);
	}

	public boolean isStaleMate() {
		return board.isStaleMate(players, turn);
	}
}
