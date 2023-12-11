package Pieces;

import Game.Board;
import Game.Color;
import Game.Game;
import Game.Move;
import Game.Square;

import java.util.ArrayList;
import java.util.Collection;

public class Bishop extends Piece {

	public Bishop(Color color) {
		super(color);
		this.setPoints(3);
	}

	@Override
	public boolean isAbleToMove(Move move, Board board) {
		if (move.getDestinationPiece() != null
				&& move.getDestinationPiece().getColor() == move.getFromPiece().getColor()) {
			return false;
		} else {
			if (Math.abs(move.getFrom().getColumn() - move.getTo().getColumn()) == Math
					.abs(move.getFrom().getRow() - move.getTo().getRow())) {
				return isPathEmpty(move.getFrom(), move.getTo(), board);
				
			}
		}

		return false;
	}

	@Override
	public void doMove(Move move, Board board) {
		move.doMove(board);
	}

	@Override
	public void undoMove(Move move, Board board) {
		move.undoMove(board);
	}

	private boolean isPathEmpty(Square from, Square to, Board board) {
		int fromColumn = from.getColumn();
		int fromRow = from.getRow();
		int toColumn = to.getColumn();
		int toRow = to.getRow();
		int i = 1;
		if (fromColumn < toColumn) {
			if (fromRow < toRow) {
				while (i < (toColumn - fromColumn) && board.getSquare(fromRow + i, fromColumn + i).isEmpty()) {
					i++;
				}
			} else {
				while (i < (toColumn - fromColumn) && board.getSquare(fromRow - i, fromColumn + i).isEmpty()) {
					i++;
				}
			}
		} else {
			if (fromRow < toRow) {
				while (i < (fromColumn - toColumn) && board.getSquare(fromRow + i, fromColumn - i).isEmpty()) {
					i++;
				}
			} else {
				while (i < (fromColumn - toColumn) && board.getSquare(fromRow - i, fromColumn - i).isEmpty()) {
					i++;
				}
			}
		}
		if (i == (toColumn - fromColumn) || i == (fromColumn - toColumn)) {
			return true;
		} else {
			return false;
		}
	}


}