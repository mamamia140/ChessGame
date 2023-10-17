package Pieces;

import java.util.ArrayList;
import java.util.Collection;

import Game.Board;
import Game.Color;
import Game.Move;
import Game.Square;

public abstract class Piece {
	private int points;
	private Color color;
	private boolean isTaken = false;
	private Square square;

	public Piece(Color color) {
		this.color = color;
	}

	public abstract void move();

	public abstract boolean isValid(Move move, Board board);

	public boolean isAttacks(Square square, Board board) {
		return isValid(new Move(this.getSquare(), square), board);
	}

	public Collection<Move> getAllPossibleMoves(Board board) {

		Collection<Move> allPossibleMoves = new ArrayList<Move>();
		Square[][] squares = board.getSquares();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Move tempMove = new Move(this.square, squares[i][j]);
				if (isValid(tempMove, board)) {
					allPossibleMoves.add(tempMove);
				}
			}
		}
		return allPossibleMoves;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isTaken() {
		return isTaken;
	}

	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

}
