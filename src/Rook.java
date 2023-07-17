

public class Rook extends Piece{
	private boolean isMoved;
	private String side;
	
	public Rook(int points, Square square ,String color, String side) {
		super(points, square, color);
		this.side = side;
		this.isMoved = false;
	}
	public void move() {};
}
