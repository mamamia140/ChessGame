
public class Square {
	private int x;
	private int y;
	private String color;
	private Piece piece;
	
	public Square(int x, int y, String color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	@Override
	public String toString() {
		if(this.color.equals("white")) {
			return " ";
		}
		else {
			return "#";
		}
	}
	
	
}
