

public class Pawn extends Piece{
	private boolean isPromoted;
	
	public Pawn(int points, Square square ,String color) {
		super(points, square, color);
		this.isPromoted = false;
	}
	public void move() {};
}
