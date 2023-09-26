package Game;

import Pieces.*;

public class Move {
	private Square from;
	private Square to;
	private Piece piece;

	public Move(Square from, Square to, Piece piece) {
		this.from = from;
		this.to = to;
		this.piece = piece;
	}

	public Square getFrom() {
		return from;
	}

	public void setFrom(Square from) {
		this.from = from;
	}

	public Square getTo() {
		return to;
	}

	public void setTo(Square to) {
		this.to = to;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

}
