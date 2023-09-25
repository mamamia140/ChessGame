package Game;

public enum Color {

	WHITE,
	
	BLACK;
	
	public Color getOppositeColor(){
		switch(this) {
		case WHITE:
			return BLACK;

		case BLACK:
			return WHITE;
			
		default:
			return null;
		}
	}
}
