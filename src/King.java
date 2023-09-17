package src;

public class King extends Piece{
	
	private boolean isMoved;
	private boolean isChecked;
	
	public King(int points, Square square ,Color color) {
		super(points, square, color);
		this.isMoved = 	false;
		this.isChecked = false;
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
	
	public boolean isAttacks(Square square, Board board){
		return isValid(new Move(this.getSquare(), square, this), board);
	}
	
	public boolean isMoved() {
		return isMoved;
	}
	public void setMoved(boolean isMoved) {
		this.isMoved = isMoved;
	}
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
	
	
	
}
