package src.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.Board;

public class Screen {
	private final JFrame gameFrame;
	private final BoardPanel boardPanel;
	private final Board board;
	
	private final java.awt.Color lightTileColor = java.awt.Color.decode("#edd4ac");
	private final java.awt.Color darkTileColor = java.awt.Color.decode("#ad7d59");
	
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600,600); 
	private final static Dimension BOARD_PANEL_DIMENSION = new Dimension(400,400);
	private final static Dimension TILE_PANEL_DIMENSION = new Dimension(50,50); 
	
	public Screen(Board board) {
		this.gameFrame = new JFrame("MyChessGame");
		this.gameFrame.setLayout(new BorderLayout());
		this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
		this.board = board;
		this.gameFrame.setVisible(true);
		this.boardPanel = new BoardPanel();
		this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
	}
	
	private class BoardPanel extends JPanel{
		final List<TilePanel> boardTiles;
		
		BoardPanel(){
			super (new GridLayout(8,8));
			this.boardTiles = new ArrayList<TilePanel>();
			
			for(int i=0; i < 64 ; i++) {
				final TilePanel tilePanel = new TilePanel(this, i);
				this.boardTiles.add(tilePanel);
				add(tilePanel);
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
			validate();
		}
		
		private void assignTilePieceIcon(final Board board) {
			this.removeAll();
			if(board.getSquare(tileId/8, tileId%8).getPiece() != null) {
				String iconPath = "";
				
				try {
					File file = new File("assets/chess_sets/cburnett/wK.svg");
					final BufferedImage image = ImageIO.read(file); //ImageIO.read() fonksiyonu svg okumuyor. Okumasi 
					//icin soyle bi cozum gordum https://stackoverflow.com/a/35812847.
					add(new JLabel(new ImageIcon(image)));
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}

		private void assignTileColor() {
			int row = this.tileId / 8;
			
			if(row == 0 || row == 2 || row == 4 || row == 6) {
				if(this.tileId % 2 == 0 ) {
					setBackground(lightTileColor);
				}
				else {
					setBackground(darkTileColor);
				}
			}
			else {
				if(this.tileId % 2 == 0 ) {
					setBackground(darkTileColor);
				}
				else {
					setBackground(lightTileColor);
				}
			}
		}
	}
}
