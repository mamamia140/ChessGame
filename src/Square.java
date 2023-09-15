package src;

public class Square {
	private int row;
	private int column;
	private String color;
	private Piece piece;
	
	public Square(int row, int column, String color) {
		this.row = row;
		this.column = column;
		this.color = color;
	}

	@Override
	public String toString() {
		if(this.piece != null) {
			return this.piece.toString();
		}
		return "Empty";
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
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
		if(this.piece == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
