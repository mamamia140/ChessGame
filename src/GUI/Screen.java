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

import javax.imageio.ImageIO;
import javax.swing.*;

import Game.*;
import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import Pieces.Rook;

public class Screen {
	public static final Dimension TILE_PANEL_DIMENSION = new Dimension(50,50);

	public static final Dimension OUTER_FRAME_DIMENSION=new Dimension(600,600);
	public static final Dimension BOARD_PANEL_DIMENSION=new Dimension(400,400);
	private final JFrame gameFrame;
	private final BoardPanel boardPanel;
	private final Board board;

	private final Game game;

	public static final java.awt.Color lightTileColor = java.awt.Color.decode("#edd4ac");
	public static final java.awt.Color darkTileColor = java.awt.Color.decode("#ad7d59");

	public static final java.awt.Color highlightColor = java.awt.Color.decode("#a1eb34");

	
	public static String SET_NAME = "cburnett";
	
	public Screen(Game game) {
		this.game = game;
		this.gameFrame = new JFrame("MyChessGame");
		this.gameFrame.setLayout(new BorderLayout());
		this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
		this.board = game.getBoard();
		this.gameFrame.setVisible(true);
		this.boardPanel = new BoardPanel(board);
		this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
		this.gameFrame.addWindowListener(new ScreenEventHandler());
		this.gameFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	}

	private class ScreenEventHandler extends WindowAdapter{

		private Clock clock;
		public ScreenEventHandler(){
			//this.clock = new Clock();
			//clock.start();
		}

		public void windowClosing(WindowEvent event){
			//this.clock.terminate();
		}
	}

}
