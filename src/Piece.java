package src;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Piece {
	private int points;
	private Color color;
	private boolean isTaken;
	private Square square;
	
	
	public Piece(int points, Square square, Color color) {
		this.points = points;
		this.square = square;
		this.color = color;
		this.isTaken = false;
	}
	public abstract void move();
	
	public abstract boolean isValid(Move move, Board board);
	
	public boolean isAttacks(Square square, Board board) {
		return isValid(new Move(this.getSquare(), square, this), board);
	}
	
	public Collection<Move> getAllPossibleMoves(Board board){
		
		Collection<Move> allPossibleMoves = new ArrayList<Move>();
		Square[][] squares = board.getSquares();
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				Move tempMove = new Move(this.square,squares[i][j],this);
				if(isValid(tempMove,board)) {
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
