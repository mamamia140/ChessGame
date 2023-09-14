

public class Knight extends Piece{
	
	public Knight(int points, Square square ,Color color) {
		super(points, square, color);
	}
	
	@Override
	public void move() {};
	
	@Override
	public boolean isValid(Move move, Board board) {
		int fromColumn = move.getFrom().getColumn();
		int fromRow = move.getFrom().getRow();
		int toColumn = move.getTo().getColumn();
		int toRow = move.getTo().getRow();
		
		if((Math.abs(fromRow - toRow) == 1 && Math.abs(fromColumn - toColumn) == 2) ||  (Math.abs(fromRow - toRow) == 2 && Math.abs(fromColumn - toColumn) == 1)) {
			return true;
		}
		else {
			return false;
		}
	}
}
