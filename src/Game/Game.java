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
	private static int turn;
	private boolean isOver;

	public Game(int duration) {
		this.duration = duration;
		players = new Player[2];
		players[0] = new Player(Color.WHITE, duration);
		players[1] = new Player(Color.BLACK, duration);
		this.board = new Board();
		this.moveHistory = new Move[2][];
		turn = 0;
		this.isOver = false;
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
		//Screen screen = new Screen(board);
		Clock clock = new Clock();
		clock.start();
		String input;
		Move newMove;
		this.board.printTheBoard();
		while (!isOver) {
			input = c.getCommandLineInput();
			newMove = c.getTheNextMove();
			if (input.equals("quit")) {
				isOver = true;
			} else if (input.equals("change")) {
				clock.changeTurn();
				turn ^= 1;
			} else {

				Piece p = newMove.getPiece();
				if (p.isValid(newMove, board)) {
					/*
					 * hamleyi isle --> p.move(newMove); oyun sonunu kontrol et if(yes){ kullanıcıyı
					 * bilgilendir isOver = true; }
					 * 
					 * sırayı değiştir turn ^= 1; tahtayı yazdır --> this.board.printTheBoard();
					 */
				} else {
					System.out.println("Invalid move");
				}

			}
		}
		clock.terminate();
	}

	public boolean isCheckMate() {
		if (board.isChecked(players[turn].getColor())) {
			return isStaleMate();
		}
		return false;
	}

	public boolean isStaleMate() {
		Collection<Piece> pieces = board.getPiecesOfColor(players[turn].getColor());
		ArrayList<Move> moves;
		int i = 0;
		for (Piece piece : pieces) {
			moves = (ArrayList<Move>) piece.getAllPossibleMoves(board);
			i = 0;
			while (i < moves.size()) {
				board.doMove(moves.get(i));
				if (!board.isChecked(players[turn].getColor())) {
					board.undoMove(moves.get(i++));
					break;
				} else {
					board.undoMove(moves.get(i++));
				}
			}
			if (i != moves.size()) {
				return false;
			}
		}
		return true;
	}

}
