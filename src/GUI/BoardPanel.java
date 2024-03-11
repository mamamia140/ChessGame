package GUI;

import Game.Board;
import Game.Move;
import Game.Square;
import Game.StandartMove;
import Pieces.Piece;

import javax.swing.*;
import java.awt.*;

import static GUI.Screen.BOARD_PANEL_DIMENSION;
import static GUI.Screen.highlightColor;

public class BoardPanel extends JPanel {
    final TilePanel[][] boardTiles;
    Square selectedSquare = null;

    private Board board;

    BoardPanel(Board board){
        super (new GridLayout(8,8));
        this.boardTiles = new TilePanel[8][8];
        this.board = board;
        for(int i=7; i >= 0 ; i--) {
            for(int j=0; j<8;j++){
                this.boardTiles[i][j] = new TilePanel(this.board,this, i*8+j);
                add(this.boardTiles[i][j]);
            }
        }
        setPreferredSize(BOARD_PANEL_DIMENSION);
        validate();
    }

    public void drawBoard(Board board) {
        removeAll();

        for(int i=7; i >= 0 ; i--) {
            for(int j=0; j<8;j++){
                boardTiles[i][j].drawTile(board);
                add(boardTiles[i][j]);
            }
        }
        validate();
        repaint();
    }

    public void highlightTheBoard(Piece piece, Board board){

        for(int i=7; i >= 0 ; i--) {
            for(int j=0; j<8;j++){
                Move move = new StandartMove(piece.getSquare(),board.getSquare(i,j));
                if(piece.isAbleToMove(move,board)){
                    if(piece.isLegal(move,board)){
                        boardTiles[i][j].highlight(board);
                    }
                }
            }
        }
        validate();
        repaint();
    }

    public void changeTheTurn(){

    }

    public void borderHighlight(int tileId){
        boardTiles[tileId/8][tileId%8].setBorder(BorderFactory.createLineBorder(Screen.highlightColor));
    }

    public void borderUnhighlight(){
        boardTiles[selectedSquare.getRow()][selectedSquare.getColumn()].setBorder(null);
    }

}
