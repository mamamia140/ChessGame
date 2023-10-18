package Game;

import Pieces.*;

public class Move {
	private final Square from;
	private final Square to;
	private final Piece fromPiece;

	private final Piece destinationPiece;

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
