package Pieces;

import Game.Board;
import Game.Color;
import Game.Move;
import Game.Square;

public class Pawn extends Piece {
	private boolean isPromoted=false;



	public Pawn(Color color) {
		super(color);
		this.setPoints(1);
	}

	@Override
	public boolean isValid(Move move, Board board) {

		if (move.getTo().getPiece() != null
				&& move.getTo().getPiece().getColor() == move.getFrom().getPiece().getColor()) {
			return false;
		}

		else {
			int fromColumn = move.getFrom().getColumn();
			int fromRow = move.getFrom().getRow();
			int toColumn = move.getTo().getColumn();
			int toRow = move.getTo().getRow();
			if (this.getColor() == Color.BLACK) {
				if (fromRow == 6 && toRow == 4 && fromColumn == toColumn && board.getSquare(5, fromColumn).isEmpty()) {
					return true;
				}
				if ((fromRow - toRow == 1) && ((fromColumn == toColumn && move.getTo().getPiece() == null)
						|| (Math.abs(fromColumn - toColumn) == 1 && move.getTo().getPiece() != null))) {
					return true;
				}
			} else {
				if (fromRow == 1 && toRow == 3 && fromColumn == toColumn && board.getSquare(2, fromColumn).isEmpty()) {
					return true;
				}

				if ((toRow - fromRow == 1) && ((fromColumn == toColumn && move.getTo().getPiece() == null)
						|| (Math.abs(fromColumn - toColumn) == 1 && move.getTo().getPiece() != null))) {
					return true;
				}

			}
			return false;
		}

	}

	public boolean isPromoted() {
		return isPromoted;
	}

	public void setPromoted(boolean isPromoted) {
		this.isPromoted = isPromoted;
	}

}
