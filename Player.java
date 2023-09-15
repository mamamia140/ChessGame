

public class Player {

	private String side;
	private Piece[] pieces;
	private long timeLeft;
	
	public Player(String side, long timeLeft) {
		this.side = side;
		this.timeLeft = timeLeft;
	}
	
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public Piece[] getPieces() {
		return pieces;
	}
	public void setPieces(Piece[] pieces) {
		this.pieces = pieces;
	}
	public long getTimeLeft() {
		return timeLeft;
	}
	public void setTimeLeft(long timeLeft) {
		this.timeLeft = timeLeft;
	}
	
	
}
