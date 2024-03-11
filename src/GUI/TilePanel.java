package GUI;

import Game.Board;
import Pieces.*;
import Game.Color;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static GUI.Screen.*;


public class TilePanel extends JPanel {
    private final int tileId;
    TilePanel(Board board, BoardPanel boardPanel, int tileId){
        super(new GridBagLayout());
        this.tileId = tileId;
        setPreferredSize(Screen.TILE_PANEL_DIMENSION);
        assignTilePieceIcon(board);
        assignTileColor();
        addMouseListener(new TileMouseListener(board,boardPanel,tileId));
        validate();
    }


    void drawTile(Board board) {
        assignTileColor();
        assignTilePieceIcon(board);
        validate();
        repaint();
    }

    private void assignTilePieceIcon(final Board board) {
        this.removeAll();
        Piece piece = board.getSquare(tileId/8, tileId%8).getPiece();
        if(piece != null) {
            String iconPath = getPieceIconPath(piece);

            try {
                File file = new File(iconPath);
                final BufferedImage image = ImageIO.read(file);
                add(new JLabel(resizeIcon(new ImageIcon(image))));
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String getPieceIconPath(Piece piece) {
        Object obj = piece.getClass();
        if(obj == Pawn.class) {
            if(piece.getColor() == Color.WHITE) {
                return "assets/chess_sets/"+ SET_NAME +"/wP.png";
            }
            else {
                return "assets/chess_sets/"+ SET_NAME +"/bP.png";
            }

        }
        else if(obj == Rook.class){
            if(piece.getColor() == Color.WHITE) {
                return "assets/chess_sets/"+ SET_NAME +"/wR.png";
            }
            else {
                return "assets/chess_sets/"+ SET_NAME +"/bR.png";
            }
        }
        else if(obj == Knight.class){
            if(piece.getColor() == Color.WHITE) {
                return "assets/chess_sets/"+ SET_NAME +"/wN.png";
            }
            else {
                return "assets/chess_sets/"+ SET_NAME +"/bN.png";
            }
        }
        else if(obj == Bishop.class){
            if(piece.getColor() == Color.WHITE) {
                return "assets/chess_sets/"+ SET_NAME +"/wB.png";
            }
            else {
                return "assets/chess_sets/"+ SET_NAME +"/bB.png";
            }
        }
        else if(obj == King.class){
            if(piece.getColor() == Color.WHITE) {
                return "assets/chess_sets/"+ SET_NAME +"/wK.png";
            }
            else {
                return "assets/chess_sets/"+ SET_NAME +"/bK.png";
            }
        }
        else if(obj == Queen.class){
            if(piece.getColor() == Color.WHITE) {
                return "assets/chess_sets/"+ SET_NAME +"/wQ.png";
            }
            else {
                return "assets/chess_sets/"+ SET_NAME +"/bQ.png";
            }
        }
        else {
            return null;
        }
    }

    private void assignTileColor() {
        int row = this.tileId / 8;

        if(row == 0 || row == 2 || row == 4 || row == 6) {
            if(this.tileId % 2 == 0 ) {
                setBackground(darkTileColor);

            }
            else {
                setBackground(lightTileColor);
            }
        }
        else {
            if(this.tileId % 2 == 0 ) {
                setBackground(lightTileColor);

            }
            else {
                setBackground(darkTileColor);
            }
        }
    }

    private ImageIcon resizeIcon(ImageIcon icon) {
        // Resize the icon to fit the square (e.g., 80% of the square's size)
        int iconSize = 50;
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public void highlight(Board board) {
        setBackground(Screen.highlightColor);
        assignTilePieceIcon(board);
        validate();
        repaint();
    }
}
