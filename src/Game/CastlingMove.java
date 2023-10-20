package Game;

public class CastlingMove extends Move{


    public CastlingMove(Square from, Square to) {
        super(from, to);
    }

    @Override
    public void doMove(Board board) {
        Square from = this.getFrom();
        Square to = this.getTo();

        if(from.getColumn() < to.getColumn()){
            board.getSquare(from.getRow(),from.getColumn() + 2).setPiece(from.getPiece());
            board.getSquare(from.getRow(),from.getColumn() + 1).setPiece(to.getPiece());
            from.setPiece(null);
            to.setPiece(null);
        }
        else{
            board.getSquare(from.getRow(),from.getColumn() - 2).setPiece(from.getPiece());
            board.getSquare(from.getRow(),from.getColumn() - 1).setPiece(to.getPiece());
            from.setPiece(null);
            to.setPiece(null);
        }
    }

    @Override
    public void undoMove(Board board) {
        Square from = this.getFrom();
        Square to = this.getTo();

        if(from.getColumn() < to.getColumn()){

            from.setPiece(this.getFromPiece());
            board.getSquare(from.getRow(),from.getColumn() + 2).setPiece(null);
            to.setPiece(this.getDestinationPiece());
            board.getSquare(from.getRow(),from.getColumn() + 1).setPiece(null);

        }
        else{
            from.setPiece(this.getFromPiece());
            board.getSquare(from.getRow(),from.getColumn() - 2).setPiece(null);
            to.setPiece(this.getDestinationPiece());
            board.getSquare(from.getRow(),from.getColumn() - 1).setPiece(null);
        }
    }
}
