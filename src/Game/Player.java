package Game;

import Pieces.*;

public class Player {

	private Color color;
	private Piece[] pieces;
	private boolean checked;
	private long timeLeft;

	public Player(Color color, long timeLeft) {
		this.color = color;
		this.checked = false;
		this.timeLeft = timeLeft;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color side) {
		this.color = side;
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

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	

}
