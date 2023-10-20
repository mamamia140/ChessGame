package Pieces;

import Game.Board;
import Game.Color;
import Game.Move;
import Game.Square;

public class Knight extends Piece {

	public Knight(Color color) {
		super(color);
		this.setPoints(3);
	}

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

			if ((Math.abs(fromRow - toRow) == 1 && Math.abs(fromColumn - toColumn) == 2)
					|| (Math.abs(fromRow - toRow) == 2 && Math.abs(fromColumn - toColumn) == 1)) {
				this.doMove(move,board);
				if(!board.isChecked(this.getColor())){
					this.undoMove(move,board);
					return true;
				}
				else{
					this.undoMove(move,board);
					return false;
				}
			} else {
				return false;
			}
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

}
