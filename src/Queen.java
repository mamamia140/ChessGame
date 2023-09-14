

public class Queen extends Piece{
	
	
	public Queen(int points, Square square ,Color color) {
		super(points, square, color);
	}
	
	@Override
	public void move() {};
	
	@Override
	public boolean isValid(Move move) {
		
		return true;
	}
}