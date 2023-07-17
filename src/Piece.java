
public abstract class Piece {
	private int points;
	private String color;
	private boolean isTaken;
	private Square square;
	
	
	public Piece(int points, Square square, String color) {
		this.points = points;
		this.square = square;
		this.color = color;
		this.isTaken = false;
	}
	public void move() {};
}
