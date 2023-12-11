package Pieces;

import Game.Board;
import Game.Color;
import Game.Move;
import Game.Square;

public class Queen extends Piece {

	public Queen(Color color) {
		super(color);
		this.setPoints(9);
	}

	@Override
	public boolean isAbleToMove(Move move, Board board) {
		if (move.getDestinationPiece() != null
				&& move.getDestinationPiece().getColor() == move.getFromPiece().getColor()) {
			return false;
		} else {
			if (Math.abs(move.getFrom().getColumn() - move.getTo().getColumn()) == Math
					.abs(move.getFrom().getRow() - move.getTo().getRow())) {
				return isPathEmptyDiagonal(move.getFrom(), move.getTo(), board);
			}

			if (move.getFrom().getRow() == move.getTo().getRow()
					|| move.getFrom().getColumn() == move.getTo().getColumn()) {
				return isPathEmptyStraight(move.getFrom(), move.getTo(), board);
			}
			return false;
		}

	}

	@Override
	public void doMove(Move move, Board board) {
		move.doMove(board);
	}

	@Override
	public void undoMove(Move move, Board board) {
		move.undoMove(board);
	}

	private boolean isPathEmptyDiagonal(Square from, Square to, Board board) {
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

	private boolean isPathEmptyStraight(Square from, Square to, Board board) {

		int fromColumn = from.getColumn();
		int fromRow = from.getRow();
		int toColumn = to.getColumn();
		int toRow = to.getRow();
		int i = 1;

		if (fromColumn == toColumn) {
			if (fromRow < toRow) {
				while (i < (toRow - fromRow) && board.getSquare(fromRow + i, fromColumn).isEmpty()) {
					i++;
				}
			} else {
				while (i < (fromRow - toRow) && board.getSquare(fromRow - i, fromColumn).isEmpty()) {
					i++;
				}
			}
		} else {
			if (fromColumn < toColumn) {
				while (i < (toColumn - fromColumn) && board.getSquare(fromRow, fromColumn + i).isEmpty()) {
					i++;
				}
			} else {
				while (i < (fromColumn - toColumn) && board.getSquare(fromRow, fromColumn - i).isEmpty()) {
					i++;
				}
			}
		}

		if (i == Math.abs(fromColumn - toColumn) || i == Math.abs(fromRow - toRow)) {
			return true;
		} else {
			return false;
		}
	}
}