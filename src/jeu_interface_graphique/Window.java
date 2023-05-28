/**
 * 
 */
package jeu_interface_graphique;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.imageio.*;

/**
 * @author Vital FOCHEUX
 *
 */
@SuppressWarnings("serial")
public class Window extends JFrame {
	
	private JScrollPane sp;
	private JPanel histo;
	private JButton buttonNewGame, buttonPlayManual, buttonNextRound, buttonPlayAuto;
	private JLabel[][] imageLabel;

	public Window(int X, int Y) {
		JFrame frame = new JFrame("Treasure Hunt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(X,Y));
        panel.setSize(X*25, Y*25);

        imageLabel = new JLabel[X][Y];
        
        try {
            BufferedImage smallImage = ImageIO.read(new File("src/jeu_interface_graphique/image/Tiles/Path.png"));

            for (int row = 0; row < X; row++) {
                for (int col = 0; col < Y; col++) {
                    imageLabel[row][col] = new JLabel(new ImageIcon(smallImage));
                    panel.add(imageLabel[row][col]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        histo = new JPanel();
        histo.setLayout(new GridLayout(0,1));
        
        sp = new JScrollPane(histo);

        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setPreferredSize(new Dimension(700,0));
        
        buttonNewGame = new JButton("Nouvelle partie");
        buttonPlayManual = new JButton("Mode manuel");
        buttonPlayAuto = new JButton("Mode automatique");
        buttonNextRound = new JButton("Tour suivant");
        
        buttonPlayManual.setEnabled(false);
        buttonPlayAuto.setEnabled(false);
        buttonNextRound.setEnabled(false);
        
        JPanel buttons = new JPanel();
        
        buttons.add(buttonNewGame);
        buttons.add(buttonPlayManual);
        buttons.add(buttonPlayAuto);
        buttons.add(buttonNextRound);
        
		
		frame.add(sp, BorderLayout.EAST);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttons, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
	}
	
	public Window() {
		this(14, 29);
	}
	
	public void addListener(ActionListener listener) {
		buttonNewGame.addActionListener(listener);
		buttonPlayManual.addActionListener(listener);
		buttonPlayAuto.addActionListener(listener);
		buttonNextRound.addActionListener(listener);
	}
	
	public void updateMap(ImageIcon image, int i, int j) {
		imageLabel[i][j].setIcon(image);
	}
	
	public void enabledNewGame(boolean activer) {
		buttonNewGame.setEnabled(activer);
	}
	
	public void enabledPlayManual(boolean activer) {
		buttonPlayManual.setEnabled(activer);
	}
	
	public void enabledPlayAuto(boolean activer) {
		buttonPlayAuto.setEnabled(activer);
	}
	
	public void enabledNextRound(boolean activer) {
		buttonNextRound.setEnabled(activer);
	}
	
	public void updateHistory(String message) {
	    JLabel label = new JLabel(message);
	    histo.add(label);
	    sp.revalidate(); // Met à jour le JScrollPane
	    sp.getVerticalScrollBar().setValue(sp.getVerticalScrollBar().getMaximum()); // Fait défiler vers le bas
	}

	public void cleanHistory() {
		histo.removeAll();
		sp.revalidate();
	}
	
}
