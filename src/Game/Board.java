package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import Pieces.*;

public class Board {
	private Square[][] squares;
	private String gameRepresentation;
	
	public Board() {
		this.squares = new Square[8][8];
		for(int i=0; i < 8; i++) {
			for(int j=0; j< 8; j++) {
				if((i+j)%2 == 0) {
					this.squares[i][j] = new Square(i,j,"black");
				}
				else {
					this.squares[i][j] = new Square(i,j,"white");
				}
			}
		}
		
		initializeTheBoard();
		
	}
	
	private void initializeTheBoard() {
		this.squares[0][0].setPiece(new Rook(5, this.squares[0][0],Color.WHITE,"queen"));
		this.squares[0][1].setPiece(new Knight(3, this.squares[0][1],Color.WHITE));
		this.squares[0][2].setPiece(new Bishop(3, this.squares[0][2],Color.WHITE));
		this.squares[0][3].setPiece(new Queen(9, this.squares[0][3],Color.WHITE));
		this.squares[0][4].setPiece(new King(0,this.squares[0][4],Color.WHITE));
		this.squares[0][5].setPiece(new Bishop(3, this.squares[0][5],Color.WHITE));
		this.squares[0][6].setPiece(new Knight(3, this.squares[0][6],Color.WHITE));
		this.squares[0][7].setPiece(new Rook(5, this.squares[0][7],Color.WHITE,"king"));
		for(int i=0;i<8;i++) {
			this.squares[1][i].setPiece(new Pawn(1,this.squares[0][i],Color.WHITE));
		}
		for(int i=2;i<6;i++) {
			for(int j=0; j<8;j++ ) {
				this.squares[i][j].setPiece(null);
			}
		}
		for(int i=0;i<8;i++) {
			this.squares[6][i].setPiece(new Pawn(1,this.squares[6][i],Color.BLACK));
		}
		this.squares[7][0].setPiece(new Rook(5, this.squares[7][0],Color.BLACK,"queen"));
		this.squares[7][1].setPiece(new Knight(3, this.squares[7][1],Color.BLACK));
		this.squares[7][2].setPiece(new Bishop(3, this.squares[7][2],Color.BLACK));
		this.squares[7][3].setPiece(new Queen(9, this.squares[7][3],Color.BLACK));
		this.squares[7][4].setPiece(new King(0,this.squares[7][4],Color.BLACK));
		this.squares[7][5].setPiece(new Bishop(3, this.squares[7][5],Color.BLACK));
		this.squares[7][6].setPiece(new Knight(3, this.squares[7][6],Color.BLACK));
		this.squares[7][7].setPiece(new Rook(5, this.squares[7][7],Color.BLACK,"king"));
		this.gameRepresentation = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
	}
	
	public void  printTheBoard() {
		for(int i=0 ; i < this.gameRepresentation.length(); i++) {
			int character = (int) this.gameRepresentation.charAt(i);
			if(character == 47) {
				System.out.println();
			}
			else if(character >= 48 && character <= 57) {
				for(int y=0; y < character - 48; y++) {
					System.out.print(" ");
				}
			}
			else {
				System.out.print(this.gameRepresentation.charAt(i));
			}
			
		}
		System.out.println();
	}


	public void doMove(Move move) {
		Square from = move.getFrom();
		Square to = move.getTo();
		
		to.setPiece(from.getPiece());
		from.setPiece(null);
	}
	
	public void undoMove(Move move) {
		Square from = move.getFrom();
		Square to = move.getTo();
		
		from.setPiece(from.getPiece());
		to.setPiece(to.getPiece());
	}
	
	@Override
	public String toString() {
		return "Board \n" + Arrays.toString(squares);
	}


	public Square[][] getSquares() {
		return squares;
	}


	public void setSquares(Square[][] squares) {
		this.squares = squares;
	}

	public Square getSquare(int x, int y) {
		return this.squares[x][y];
	}

	public String getGameRepresentation() {
		return gameRepresentation;
	}


	public void setGameRepresentation(String gameRepresentation) {
		this.gameRepresentation = gameRepresentation;
	}
	
	public boolean isChecked(Color color){
		
		King k = getKingOfColor(color);
		
		Collection<Piece> opponentPieces = getPiecesOfColor(color.getOppositeColor());
		
		for(Piece piece: opponentPieces) {
			if(piece.isAttacks(k.getSquare(), this)) {
				return true;
			}
		}
		return false;
	}
	
	private King getKingOfColor(Color color) {
		int i = 0;
		int j = 0;
		while(i < 8 && !(squares[i][j].getPiece().getClass() == King.class && squares[i][j].getPiece().getColor() == color)) {
			i++;
			if(j==8) {
				j=0;
			}
		}
		if(i==8) {
			return null;
		}
		else {
			return (King) squares[i][j].getPiece();
		}
	}
	
	public Collection<Piece> getPiecesOfColor(Color color){
		Collection<Piece> pieces = new ArrayList<Piece>();
		for(int i=0; i < 8; i++) {
			for(int j=0; j < 8; j++) {
				if(squares[i][j].getPiece().getColor() == color){
					pieces.add(squares[i][j].getPiece());
				}
			}
		}
		
		return pieces;
	}
}
