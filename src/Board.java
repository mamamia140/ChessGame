
public class Board {
	private Square[] squares;
	private String gameRepresentation;
	
	public Board() {
		this.squares = new Square[64];
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
	
	
}
