package Tests;

import static org.junit.jupiter.api.Assertions.*;

import Game.Board;
import Game.Color;
import Game.Move;
import Pieces.Bishop;
import Pieces.Piece;
import Pieces.Rook;
import org.junit.jupiter.api.Test;
public class PieceTest {

    Board board = new Board();
    Move move;
    @Test
    void test() {
        Piece p = board.getSquare(0,2).getPiece();
        move = new Move(board.getSquare(1,3),board.getSquare(1,5));
        board.doMove(move);
        move = new Move(board.getSquare(0,2), board.getSquare(1,3));
        assertEquals(true,p.isValid(move,board));
    }
}
