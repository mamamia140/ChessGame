package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import Game.Board;
import Game.Clock;
import Game.Color;
import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import Pieces.Rook;

public class Screen {
	private final JFrame gameFrame;
	private final BoardPanel boardPanel;
	private final Board board;


	private final java.awt.Color lightTileColor = java.awt.Color.decode("#edd4ac");
	private final java.awt.Color darkTileColor = java.awt.Color.decode("#ad7d59");
	
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600,600); 
	private final static Dimension BOARD_PANEL_DIMENSION = new Dimension(400,400);
	private final static Dimension TILE_PANEL_DIMENSION = new Dimension(50,50);
	
	private static String SET_NAME = "cburnett";
	
	public Screen(Board board) {
		this.gameFrame = new JFrame("MyChessGame");
		this.gameFrame.setLayout(new BorderLayout());
		this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
		this.board = board;
		this.gameFrame.setVisible(true);
		this.boardPanel = new BoardPanel();
		this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
		this.gameFrame.addWindowListener(new ScreenEventHandler());
		this.gameFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	}

	private class ScreenEventHandler extends WindowAdapter{

		private Clock clock;
		public ScreenEventHandler(){
			this.clock = new Clock();
			clock.start();
		}

		public void windowClosing(WindowEvent event){
			this.clock.terminate();
		}
	}

	
	private class BoardPanel extends JPanel{
		final TilePanel[][] boardTiles;
		
		BoardPanel(){
			super (new GridLayout(8,8));
			this.boardTiles = new TilePanel[8][8];
			
			for(int i=7; i >= 0 ; i--) {
				for(int j=0; j<8;j++){
					this.boardTiles[i][j] = new TilePanel(this, i*8+j);
					add(this.boardTiles[i][j]);
				}
			}
			setPreferredSize(BOARD_PANEL_DIMENSION);
			validate();
		}


	}
	
	private class TilePanel extends JPanel{
		private final int tileId;
		
		TilePanel(final BoardPanel boardPanel, final int tileId){
			super(new GridBagLayout());
			this.tileId = tileId;
			setPreferredSize(TILE_PANEL_DIMENSION);
			assignTilePieceIcon(board);
			assignTileColor();

			addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(tileId);
					assignTilePieceIcon(board);
				}

				@Override
				public void mousePressed(MouseEvent e) {

				}

				@Override
				public void mouseReleased(MouseEvent e) {

				}

				@Override
				public void mouseEntered(MouseEvent e) {

				}

				@Override
				public void mouseExited(MouseEvent e) {

				}
			});

			validate();
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
	}
}
