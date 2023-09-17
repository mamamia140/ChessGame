package src.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen {
	private final JFrame gameFrame;
	private final BoardPanel boardPanel;
	
	private final java.awt.Color lightTileColor = new java.awt.Color(255,255,255);
	private final java.awt.Color darkTileColor = new java.awt.Color(0,0,0);
	
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600,600); 
	private final static Dimension BOARD_PANEL_DIMENSION = new Dimension(400,400);
	private final static Dimension TILE_PANEL_DIMENSION = new Dimension(50,50); 
	
	public Screen() {
		this.gameFrame = new JFrame("MyChessGame");
		this.gameFrame.setLayout(new BorderLayout());
		this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
		
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
			assignTileColor();
			validate();
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
