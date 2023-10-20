package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import Pieces.*;

public class Board {
	private Square[][] squares;
	private String gameRepresentation;

	private Piece lastTakenPiece = null;
	public Board() {
		this.squares = new Square[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					this.squares[i][j] = new Square(i, j, "black");
				} else {
					this.squares[i][j] = new Square(i, j, "white");
				}
			}
		}

		importGamesFromFEN("C:\\Users\\muhammed.kilic\\Desktop\\temp.txt");
	}

	public void printTheBoard() {
		for (int i = 0; i < this.gameRepresentation.length(); i++) {
			int character = this.gameRepresentation.charAt(i);
			if (character == 47) {
				System.out.println();
			} else if (character >= 48 && character <= 57) {
				for (int y = 0; y < character - 48; y++) {
					System.out.print(" ");
				}
			} else {
				System.out.print(this.gameRepresentation.charAt(i));
			}

		}
		System.out.println();
	}

	public void importGamesFromFEN(String filePath){
		try {

			File f1 = new File(filePath);
			Scanner dataReader = new Scanner(f1);
			while (dataReader.hasNextLine()) {
				String fenString = dataReader.nextLine();
				this.gameRepresentation = fenString;
				String[] FENFields = parseFENString(fenString);
				parsePiecePlacementField(FENFields[0]);
				Game.setTurn(FENFields[1].charAt(0) == 'w' ? 0 : 1);
			}
			dataReader.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private String[] parseFENString(String fenString){
		return fenString.split(" ");
	}

	private void parsePiecePlacementField(String piecePlacementString){
		int i=7,j=0;
		String[] ranks = piecePlacementString.split("/");
		for(String rank : ranks) {
			j=0;
			for(char c: rank.toCharArray()){

				if (isCharANumber(c)) {
					for (int counter = 0; counter < c - 48; counter++) {
						this.squares[i][j].setPiece(null);
						j++;
					}
				} else {
					this.squares[i][j].setPiece(charToPiece(c));
					j++;
				}
			}
			i--;

		}
	}

	private boolean isCharANumber(char c){
        return c >= 48 && c <= 57;
    }

	private Piece charToPiece(char c){
        switch (c) {
            case 'p':
            	return new Pawn(Color.BLACK);
            case 'r':
            	return new Rook(Color.BLACK);
            case 'n':
            	return new Knight(Color.BLACK);
            case 'b':
            	return new Bishop(Color.BLACK);
            case 'q':
            	return new Queen(Color.BLACK);
            case 'k':
            	return new King(Color.BLACK);
            case 'P':
            	return new Pawn(Color.WHITE);
            case 'R':
            	return new Rook(Color.WHITE);
            case 'N':
            	return new Knight(Color.WHITE);
            case 'B':
            	return new Bishop(Color.WHITE);
            case 'Q':
            	return new Queen(Color.WHITE);
            case 'K':
            	return new King(Color.WHITE);
            default:
            	return null;
        }
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

	public Piece getLastTakenPiece() {
		return lastTakenPiece;
	}

	public void setLastTakenPiece(Piece lastTakenPiece) {
		this.lastTakenPiece = lastTakenPiece;
	}

	public void setGameRepresentation(String gameRepresentation) {
		this.gameRepresentation = gameRepresentation;
	}

	public boolean isChecked(Color color) {

		King k = getKingOfColor(color);

		Collection<Piece> opponentPieces = getPiecesOfColor(color.getOppositeColor());

		for (Piece piece : opponentPieces) {
			if (piece.isAttacks(k.getSquare(), this)) {
				return true;
			}
		}
		return false;
	}

	private King getKingOfColor(Color color) {
		int i = 0;
		int j = 0;

		while( i < 8 ){
			j=0;
			while( j < 8){
				if(squares[i][j].getPiece() != null){
					if(squares[i][j].getPiece().getClass() == King.class && squares[i][j].getPiece().getColor() == color ){
						break;
					}
				}
				j++;
			}
			if(j != 8){
				break;
			}
			i++;
		}
		if (i == 8) {
			return null;
		} else {
			return (King) squares[i][j].getPiece();
		}
	}
	
	public Collection<Square> getSquares(Square from, Square destination){
		Collection<Square> squareList = new ArrayList<Square>();
		
		int fromRow = from.getRow();
		int fromColumn = from.getColumn();
		int destinationRow = destination.getRow();
		int destinationColumn = destination.getColumn();

		if(Math.abs(fromRow - destinationRow) == Math.abs(fromColumn - destinationColumn)){
			if(fromRow < destinationRow) {
				if(fromColumn < destinationColumn ) {
					for(int i=1; i < destinationRow - fromRow; i++) {
						squareList.add(squares[fromRow+i][fromColumn+i]);
					}
				}

				else {
					for(int i=1; i < destinationRow - fromRow; i++) {
						squareList.add(squares[fromRow+i][fromColumn-i]);
					}
				}
			}

			else {
				if(fromColumn < destinationColumn) {
					for(int i=1; i < fromRow - destinationRow; i++) {
						squareList.add(squares[fromRow-i][fromColumn+i]);
					}
				}

				else {
					for(int i=1; i < fromRow - destinationRow; i++) {
						squareList.add(squares[fromRow-i][fromColumn-i]);
					}
				}
			}
		}
		else if(fromRow == destinationRow || fromColumn == destinationColumn){
			if(fromColumn == destinationColumn) {
				if(fromRow < destinationRow){
					for(int i=1; i < destinationRow - fromRow; i++) {
						squareList.add(squares[fromRow+i][fromColumn]);
					}
				}
				else{
					for(int i=1; i < fromRow - destinationRow; i++) {
						squareList.add(squares[fromRow-i][fromColumn]);
					}
				}

			}
			else{
				if(fromColumn < destinationColumn) {
					for(int i=1; i < destinationColumn - fromColumn; i++) {
						squareList.add(squares[fromRow][fromColumn+i]);
					}
				}
				else {
					for(int i=1; i < fromColumn - destinationColumn; i++) {
						squareList.add(squares[fromRow][fromColumn-i]);
					}
				}
			}
		}

		return squareList;
	}

	public Collection<Piece> getPiecesOfColor(Color color) {
		Collection<Piece> pieces = new ArrayList<Piece>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(squares[i][j].getPiece() != null){
					if (squares[i][j].getPiece().getColor() == color) {
						pieces.add(squares[i][j].getPiece());
					}
				}

			}
		}

		return pieces;
	}

	public boolean isCheckMate(Player[] players,int turn ) {
		if (isChecked(players[turn].getColor())) {
			return isStaleMate(players, turn);
		}
		return false;
	}

	public boolean isStaleMate(Player[] players, int turn) {
		Collection<Piece> pieces = getPiecesOfColor(players[turn].getColor());
		ArrayList<Move> moves;
		int i = 0;
		for (Piece piece : pieces) {
			moves = (ArrayList<Move>) piece.getAllPossibleMoves(this);
			i = 0;
			while (i < moves.size()) {
				moves.get(i).doMove(this);
				if (!isChecked(players[turn].getColor())) {
					moves.get(i++).undoMove(this);
					break;
				} else {
					moves.get(i++).undoMove(this);
				}
			}
			if (i != moves.size()) {
				return false;
			}
		}
		return true;
	}
}
