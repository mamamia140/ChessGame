package Pieces;

import java.util.ArrayList;
import java.util.Collection;

import Game.*;

public abstract class Piece {
	private int points;
	private Color color;
	private boolean isTaken = false;
	private Square square;

	public abstract boolean isAbleToMove(Move move, Board board);


	public boolean isLegal(Move move, Board board){
		doMove(move, board);
		if(board.isChecked(this.getColor())){
			undoMove(move, board);
			return false;
		}
		if(board.areKingsHuggingEachOther()){
			undoMove(move,board);
			return false;
		}

		undoMove(move, board);
		return true;
	}
	public boolean isAttacks(Square square, Board board) {
		return isAbleToMove(new StandartMove(this.getSquare(), square), board);
	}

	public abstract void doMove(Move move, Board board);

	public abstract void undoMove(Move move, Board board);

	public Collection<Move> getAllPossibleMoves(Board board) {

		Collection<Move> allPossibleMoves = new ArrayList<Move>();
		Square[][] squares = board.getSquares();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Move tempMove = new StandartMove(this.square, squares[i][j]);
				if (isAbleToMove(tempMove, board) && isLegal(tempMove,board)) {
					allPossibleMoves.add(tempMove);
				}
			}
		}
		return allPossibleMoves;
	}

	Piece(Color color) {
		this.color = color;
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
