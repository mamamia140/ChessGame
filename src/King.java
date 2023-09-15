package src;

public class King extends Piece{
	
	private boolean isMoved;
	
	public King(int points, Square square ,Color color) {
		super(points, square, color);
		this.isMoved = 	false;
	}
	@Override
	public void move() {};
	
	@Override
	public boolean isValid(Move move, Board  board) {
		if(move.getTo().getPiece() != null && move.getTo().getPiece().getColor() == move.getFrom().getPiece().getColor()) {
			return false;
		}
		else {
			int fromColumn = move.getFrom().getColumn();
			int fromRow = move.getFrom().getRow();
			int toColumn = move.getTo().getColumn();
			int toRow = move.getTo().getRow();
			if( Math.abs(fromColumn - toColumn) <= 1 && Math.abs(fromRow - toRow) <= 1) {
				return true;
			}
			else {
				return false;
			}
		}
		
		
	}
	public boolean isMoved() {
		return isMoved;
	}
	public void setMoved(boolean isMoved) {
		this.isMoved = isMoved;
	}
	
	
}
