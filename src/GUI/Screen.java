package GUI;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Screen {
	private final JFrame gameFrame;
	
	private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600,600); 
	public Screen() {
		this.gameFrame = new JFrame("MyChessGame");
		
		this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
		
		this.gameFrame.setVisible(true);
	}
}
