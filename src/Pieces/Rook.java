package Pieces;

import java.util.Stack;

import Game.Board;
import Game.Color;
import Game.Game;
import Game.Move;
import Game.Square;

public class Rook extends Piece {
	
	private Stack<Boolean> stack;

	public Rook( Color color) {
		super(color);
		this.stack = new Stack<>();
		this.stack.setSize(2);
		this.stack.push(false);
		this.setPoints(5);
	}

	@Override
	public boolean isAbleToMove(Move move, Board board) {

		if (move.getDestinationPiece() != null
				&& move.getDestinationPiece().getColor() == move.getFromPiece().getColor()) {
			return false;
		} else {
			if (move.getFrom().getRow() == move.getTo().getRow()
					|| move.getFrom().getColumn() == move.getTo().getColumn()) {
				return isPathEmpty(move.getFrom(), move.getTo(), board);
			}
		}
		return false;
	}

	@Override
	public void doMove(Move move, Board board) {
		this.stack.push(true);
		move.doMove(board);
	}

	@Override
	public void undoMove(Move move, Board board) {
		this.stack.pop();
		move.undoMove(board);
	}

	private boolean isPathEmpty(Square from, Square to, Board board) {

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

        return (i == Math.abs(fromColumn - toColumn)) || (i == Math.abs(fromRow - toRow));
	}

	public boolean isMoved() {
		return this.stack.peek();
	}

	public void setMoved(boolean isMoved) {
		this.stack.push(isMoved);
	}

	public Stack<Boolean> getStack() {
		return stack;
	}

	public void setStack(Stack<Boolean> stack) {
		this.stack = stack;
	}
	
	

	
}
