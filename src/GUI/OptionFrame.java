package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class OptionFrame{
    private static final Dimension PIECE_FRAME_DIMENSION = new Dimension(80,80);
    private final JFrame optionWindow;
    private PieceTile[][] pieceTiles;
    OptionFrame() {

        this.pieceTiles = new PieceTile[1][4];
        this.optionWindow = new JFrame();
        this.optionWindow.setLayout(new GridLayout(1,4));
        this.optionWindow.setTitle("Select a piece");
        this.optionWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.optionWindow.setResizable(false);

        for(int i=0; i< 4;i++){
            this.pieceTiles[0][i] = new PieceTile(i);
            this.optionWindow.add(this.pieceTiles[0][i]);
        }
        this.optionWindow.pack();
        this.optionWindow.setVisible(true);

    }

    public static void main(String[] args){
        new OptionFrame();
    }

    private class PieceTile extends JPanel{
        private final int id;

        PieceTile(final int id){
            super(new GridBagLayout());
            this.id = id;
            setPreferredSize(PIECE_FRAME_DIMENSION);
            assignIcon();
            setBorder(BorderFactory.createLineBorder(Color.black));
            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println(id);
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

        private void assignIcon() {
            this.removeAll();
            File file=null;
            try {
                switch (this.id){
                    case 0:
                        file = new File("assets/chess_sets/cburnett/bR.png");
                        break;
                    case 1:
                        file = new File("assets/chess_sets/cburnett/bN.png");
                        break;
                    case 2:
                        file = new File("assets/chess_sets/cburnett/bB.png");
                        break;
                    case 3:
                        file = new File("assets/chess_sets/cburnett/bQ.png");
                        break;
                    default:
                        break;
                }
                final BufferedImage image = ImageIO.read(file);
                add(new JLabel(resizeIcon(new ImageIcon(image))));

            }catch(Exception e) {
                e.printStackTrace();
            }


        }

        private ImageIcon resizeIcon(ImageIcon icon) {
            int iconSize = 50;
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(iconSize, iconSize, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        }
    }
}


