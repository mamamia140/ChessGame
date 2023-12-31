package Game;

import Pieces.*;

public class Square {
	private final int row;
	private final int column;
	private final String color;
	private Piece piece;

	public Square(int row, int column, String color) {
		this.row = row;
		this.column = column;
		this.color = color;
	}

	@Override
	public String toString() {
		if (this.piece != null) {
			return this.piece.toString();
		}
		return "Empty";
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {

		this.piece = piece;
		if(piece != null){
			piece.setSquare(this);
		}
		
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public String getColor() {
		return color;
	}

	public boolean isEmpty() {
        return this.piece == null;
	}

}
