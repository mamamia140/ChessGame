
public class Square {
	private int x;
	private int y;
	private String color;
	private Piece piece;
	
	public Square(int x, int y, String color) {
		this.x = x;
		this.y = y;
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getColor() {
		return color;
	}
	
	
}
