package Pieces;

import java.util.ArrayList;
import java.util.Stack;

import Game.Board;
import Game.Color;
import Game.Move;
import Game.Square;

public class King extends Piece {

	private Stack<Boolean> stack;


	public King(Color color) {
		super(color);
		this.stack = new Stack<Boolean>();
		this.stack.setSize(2);
		this.stack.push(false);
		this.setPoints(0);
	}

	@Override
	public void move() {
	};

	@Override
	public boolean isValid(Move move, Board board) {
		if (move.getTo().getPiece() != null
				&& move.getTo().getPiece().getColor() == this.getColor()) {
			if(move.getTo().getPiece().getClass() == Rook.class){
				return canCastle((Rook) move.getTo().getPiece(),board);
			}
			return false;
		}
		else {
			int fromColumn = move.getFrom().getColumn();
			int fromRow = move.getFrom().getRow();
			int toColumn = move.getTo().getColumn();
			int toRow = move.getTo().getRow();
			if (Math.abs(fromColumn - toColumn) <= 1 && Math.abs(fromRow - toRow) <= 1) {
				return true;
			}
			else {
				return false;
			}
		}

	}
	
	public boolean canCastle(Rook rook, Board board) {
        return !this.isMoved() && !rook.isMoved() && !board.isChecked(this.getColor()) && checkIfPathIsClear(rook, board);
    }
	
	private boolean checkIfPathIsClear(Rook rook, Board board) {

		ArrayList<Square> squares = (ArrayList<Square>) board.getSquares(rook.getSquare(), this.getSquare());
		Move tempMove;
		int i=0;
		if(squares.size() > 3){
			return false;
		}
		while(i < squares.size() && squares.get(i).isEmpty()) {

			tempMove = new Move(this.getSquare(),squares.get(i));
			board.doMove(tempMove);
			if(board.isChecked(this.getColor())) {
				board.undoMove(tempMove);
				break;
			}
			board.undoMove(tempMove);
			i++;
		}
        return i == squares.size() && i != 0;
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
