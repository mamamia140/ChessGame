package main;

public class Board {
	private Square[] squares;
	private String gameRepresentation;
	
	public Board() {
		this.squares = new Square[64];
		this.gameRepresentation = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
	}
}
