package Game;

public class StandartMove extends Move{
    public StandartMove(Square from, Square to) {
        super(from, to);
    }

    @Override
    public void doMove(Board board) {
        Square from = this.getFrom();
        Square to = this.getTo();

        board.setLastTakenPiece(to.getPiece());
        to.setPiece(from.getPiece());
        from.setPiece(null);
        
    }

    @Override
    public void undoMove(Board board) {
        Square from = this.getFrom();
        Square to = this.getTo();

        from.setPiece(this.getFromPiece());
        to.setPiece(board.getLastTakenPiece());
        
    }
}
