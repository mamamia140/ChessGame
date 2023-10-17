package Game;

import Pieces.*;

public class Move {
	private Square from;
	private Square to;
	private Piece fromPiece;

	private Piece destinationPiece;

	public Move(Square from, Square to) {
		this.from = from;
		this.to = to;
		this.fromPiece = from.getPiece();
		this.destinationPiece = to.getPiece();
	}

	public Square getFrom() {
		return from;
	}


	public Square getTo() {
		return to;
	}


	public Piece getFromPiece() {
		return fromPiece;
	}

	public Piece getDestinationPiece() {
		return destinationPiece;
	}
}
