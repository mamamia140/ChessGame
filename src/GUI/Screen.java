package GUI;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {

	private JPanel chessboardPanel;
	private JButton[][] squares;

	public Screen() {
		// Initialize the JFrame and set layout
		setTitle("Chessboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Initialize the chessboard panel with GridLayout
		chessboardPanel = new JPanel(new GridLayout(8, 8));

		// Calculate the size for square buttons to make them square
		int squareSize = Math.min(
				Toolkit.getDefaultToolkit().getScreenSize().width / 10,
				Toolkit.getDefaultToolkit().getScreenSize().height / 10
		);

		// Create an 8x8 array of square buttons
		squares = new JButton[8][8];

		// Populate the chessboard with square buttons
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				squares[i][j] = new JButton();
				squares[i][j].setPreferredSize(new Dimension(squareSize, squareSize));

				// Set the background color based on the square's position
				if ((i + j) % 2 == 0) {
					squares[i][j].setBackground(Color.WHITE);
				} else {
					squares[i][j].setBackground(Color.BLACK);
				}

				// Customize the appearance and behavior of each square
				// Add mouse listeners to handle interactions
				chessboardPanel.add(squares[i][j]);
			}
		}
		initializeBoardIcons();
		// Add the chessboard panel to the JFrame
		add(chessboardPanel, BorderLayout.CENTER);

		// Pack and display the JFrame
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	private void initializeBoardIcons() {
		// Load and resize the icons for each chess piece
		ImageIcon whitePawnIcon = resizeIcon(new ImageIcon("assets/chess_sets/cburnett/wP.png"));
		ImageIcon blackPawnIcon = resizeIcon(new ImageIcon("assets/chess_sets/cburnett/bP.png"));
		ImageIcon whiteRookIcon = resizeIcon(new ImageIcon("assets/chess_sets/cburnett/wR.png"));
		ImageIcon blackRookIcon = resizeIcon(new ImageIcon("assets/chess_sets/cburnett/bR.png"));
		ImageIcon whiteKnightIcon = resizeIcon(new ImageIcon("assets/chess_sets/cburnett/wN.png"));
		ImageIcon blackKnightIcon = resizeIcon(new ImageIcon("assets/chess_sets/cburnett/bN.png"));
		ImageIcon whiteBishopIcon = resizeIcon(new ImageIcon("assets/chess_sets/cburnett/wB.png"));
		ImageIcon blackBishopIcon = resizeIcon(new ImageIcon("assets/chess_sets/cburnett/bB.png"));
		ImageIcon whiteQueenIcon = resizeIcon(new ImageIcon("assets/chess_sets/cburnett/wQ.png"));
		ImageIcon blackQueenIcon = resizeIcon(new ImageIcon("assets/chess_sets/cburnett/bQ.png"));
		ImageIcon whiteKingIcon = resizeIcon(new ImageIcon("assets/chess_sets/cburnett/wK.png"));
		ImageIcon blackKingIcon = resizeIcon(new ImageIcon("assets/chess_sets/cburnett/bK.png"));

		// Set the icons on the appropriate squares
		squares[0][0].setIcon(blackRookIcon);
		squares[0][1].setIcon(blackKnightIcon);
		squares[0][2].setIcon(blackBishopIcon);
		squares[0][3].setIcon(blackQueenIcon);
		squares[0][4].setIcon(blackKingIcon);
		squares[0][5].setIcon(blackBishopIcon);
		squares[0][6].setIcon(blackKnightIcon);
		squares[0][7].setIcon(blackRookIcon);

		squares[7][0].setIcon(whiteRookIcon);
		squares[7][1].setIcon(whiteKnightIcon);
		squares[7][2].setIcon(whiteBishopIcon);
		squares[7][3].setIcon(whiteQueenIcon);
		squares[7][4].setIcon(whiteKingIcon);
		squares[7][5].setIcon(whiteBishopIcon);
		squares[7][6].setIcon(whiteKnightIcon);
		squares[7][7].setIcon(whiteRookIcon);

		for (int i = 0; i < 8; i++) {
			squares[1][i].setIcon(blackPawnIcon);
			squares[6][i].setIcon(whitePawnIcon);
		}

		// Set icons for other squares as needed
	}
	private ImageIcon resizeIcon(ImageIcon icon) {
		// Resize the icon to fit the square (e.g., 80% of the square's size)
		int iconSize = (int) (squares[0][0].getPreferredSize().width * 0.8);
		Image image = icon.getImage();
		Image resizedImage = image.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}

}
