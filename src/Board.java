import java.util.Arrays;

public class Board {
	private Square[] squares;
	private String gameRepresentation;
	
	public Board() {
		this.squares = new Square[64];
		for(int i=0; i < 8; i++) {
			for(int j=0; j< 8; j++) {
				if((i+j)%2 == 0) {
					this.squares[i*8+j] = new Square(i,j,"black");
				}
				else {
					this.squares[i*8+j] = new Square(i,j,"white");
				}
			}
		}
		
		this.squares[0].setPiece(new Rook(5, this.squares[0],"white","queen"));
		this.squares[1].setPiece(new Knight(3, this.squares[1],"white"));
		this.squares[2].setPiece(new Bishop(3, this.squares[2],"white"));
		this.squares[3].setPiece(new Queen(9, this.squares[3],"white"));
		this.squares[4].setPiece(new King(0,this.squares[4],"white"));
		this.squares[5].setPiece(new Bishop(3, this.squares[5],"white"));
		this.squares[6].setPiece(new Knight(3, this.squares[6],"white"));
		this.squares[7].setPiece(new Rook(5, this.squares[7],"white","king"));
		for(int i=0;i<8;i++) {
			this.squares[8+i].setPiece(new Pawn(1,this.squares[8+i],"white"));
		}
		for(int i=2;i<6;i++) {
			for(int j=0; j<8;j++ ) {
				this.squares[i*8 + j].setPiece(null);
			}
		}
		for(int i=0;i<8;i++) {
			this.squares[48+i].setPiece(new Pawn(1,this.squares[48+i],"black"));
		}
		this.squares[56].setPiece(new Rook(5, this.squares[56],"black","queen"));
		this.squares[57].setPiece(new Knight(3, this.squares[57],"black"));
		this.squares[58].setPiece(new Bishop(3, this.squares[58],"black"));
		this.squares[59].setPiece(new Queen(9, this.squares[59],"black"));
		this.squares[60].setPiece(new King(0,this.squares[60],"black"));
		this.squares[61].setPiece(new Bishop(3, this.squares[61],"black"));
		this.squares[62].setPiece(new Knight(3, this.squares[62],"black"));
		this.squares[63].setPiece(new Rook(5, this.squares[63],"black","king"));
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


	@Override
	public String toString() {
		return "Board \n" + Arrays.toString(squares);
	}
	
	
}
