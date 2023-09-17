package src;

public class Knight extends Piece{
	
	public Knight(int points, Square square ,Color color) {
		super(points, square, color);
	}
	
	@Override
	public void move() {};
	
	@Override
	public boolean isValid(Move move, Board board) {
		
		if(move.getTo().getPiece() != null && move.getTo().getPiece().getColor() == move.getFrom().getPiece().getColor()) {
			return false;
		}
		else {
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
	
	public boolean isAttacks(Square square, Board board){
		return isValid(new Move(this.getSquare(), square, this), board);
	}
}
