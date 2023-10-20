package Pieces;

import java.util.ArrayList;
import java.util.Stack;

import Game.*;

public class King extends Piece {

	private Stack<Boolean> stack;


	public King(Color color) {
		super(color);
		this.stack = new Stack<>();
		this.stack.setSize(2);
		this.stack.push(false);
		this.setPoints(0);
	}


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

	public boolean canCastle(Rook rook, Board board) {
        return !this.isMoved() && !rook.isMoved() && !board.isChecked(this.getColor()) && checkIfPathIsClear(rook, board);
    }
	
	private boolean checkIfPathIsClear(Rook rook, Board board) {

		ArrayList<Square> squares = (ArrayList<Square>) board.getSquares(rook.getSquare(), this.getSquare());
		Move move;
		int i=0;
		if(squares.size() > 3){
			return false;
		}
		while(i < squares.size() && squares.get(i).isEmpty()) {

			move = new StandartMove(this.getSquare(),squares.get(i));
			this.doMove(move,board);
			if(board.isChecked(this.getColor())) {
				this.undoMove(move,board);
				break;
			}
			this.undoMove(move,board);
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
