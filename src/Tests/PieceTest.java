package Tests;

import Game.Board;
import Game.Move;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PieceTest {
    Board board;

    @BeforeAll
    public void before(){
        this.board = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
    }
    @BeforeEach
    public void beforeEach(){

    }

    @AfterEach
    public void afterEach(){

    }
    @AfterAll
    public void after(){

    }
    @Test
    @DisplayName("test1")
    void test() {
        board.printTheBoard();
    }
}
