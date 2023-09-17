package src;

public class Pawn extends Piece {
	private boolean isPromoted;

	public Pawn(int points, Square square, Color color) {
		super(points, square, color);
		this.isPromoted = false;
	}

	@Override
	public void move() {
		
	}

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
			if (this.getColor() == Color.BLACK) {
				if (fromRow == 6 && toRow == 4 && fromColumn == toColumn && board.getSquare(5, fromColumn).isEmpty()) {
					return true;
				}
				if ((fromRow - toRow == 1) && (fromColumn == toColumn
						|| (Math.abs(fromColumn - toColumn) == 1 && move.getTo().getPiece() != null))) {
					return true;
				}
			} else {
				if (fromRow == 1 && toRow == 3 && fromColumn == toColumn && board.getSquare(2, fromColumn).isEmpty()) {
					return true;
				}

				if ((toRow - fromRow == 1) && (fromColumn == toColumn
						|| (Math.abs(fromColumn - toColumn) == 1 && move.getTo().getPiece() != null))) {
					return true;
				}
				
			}
			return false;
		}
		
	}
	
	public boolean isAttacks(Square square, Board board){
		return isValid(new Move(this.getSquare(), square, this), board);
	}

	public boolean isPromoted() {
		return isPromoted;
	}

	public void setPromoted(boolean isPromoted) {
		this.isPromoted = isPromoted;
	}

}
