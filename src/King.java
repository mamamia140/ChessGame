

public class King extends Piece{
	
	private boolean isMoved;
	
	public King(int points, Square square ,String color) {
		super(points, square, color);
		this.isMoved = 	false;
	}
	public void move() {};
}
