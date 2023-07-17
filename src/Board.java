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
		this.squares[0] = new Square(0,0,"black");
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
