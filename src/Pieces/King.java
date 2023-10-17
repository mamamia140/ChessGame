package Pieces;

import java.util.ArrayList;
import java.util.Collection;

import Game.Board;
import Game.Color;
import Game.Move;
import Game.Square;

public class King extends Piece {

	private boolean isMoved=false;

	public King(Color color) {
		super(color);
		this.setPoints(0);
	}

	@Override
	public void move() {
	};

	@Override
	public boolean isValid(Move move, Board board) {
		if (move.getTo().getPiece() != null
				&& move.getTo().getPiece().getColor() == move.getFrom().getPiece().getColor()) {
			return false;
		} else {
			int fromColumn = move.getFrom().getColumn();
			int fromRow = move.getFrom().getRow();
			int toColumn = move.getTo().getColumn();
			int toRow = move.getTo().getRow();
			if (Math.abs(fromColumn - toColumn) <= 1 && Math.abs(fromRow - toRow) <= 1) {
				return true;
			} else {
				return false;
			}
		}

	}
	
	public boolean canCastle(Rook rook, Board board) {
		if(!this.isMoved && !rook.isMoved() && !board.isChecked(this.getColor()) && checkIfPathIsClear(rook,board)) {
			return true;
		}
		return false;
	}
	
	private boolean checkIfPathIsClear(Rook rook, Board board) {

		ArrayList<Square> squares = (ArrayList<Square>) board.getSquares(rook.getSquare(), this.getSquare());
		Move tempMove;
		int i=0;
		while(i < squares.size()) {		
			if(squares.get(i).isEmpty()) {
				tempMove = new Move(this.getSquare(),squares.get(i), this); 
				board.doMove(tempMove);
				if(board.isChecked(this.getColor())) {
					board.undoMove(tempMove);
					break;
				}
				board.undoMove(tempMove);
			}
			i++;
		}
		if(i==squares.size()) {
			return true;
		}
		else {
			return false;
		}
		
	}

	public boolean isMoved() {
		return isMoved;
	}

	public void setMoved(boolean isMoved) {
		this.isMoved = isMoved;
	}

}
