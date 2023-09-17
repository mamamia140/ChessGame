package src;

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
	
	public abstract boolean isAttacks(Square square, Board board);
	
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
