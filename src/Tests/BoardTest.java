package Tests;

import Game.Board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

	@Test
    void importGamesFromFEN() {
        Board board = new Board();
        board.importGamesFromFEN("C:\\Users\\muhammed.kilic\\Desktop\\temp.txt");
    }
}