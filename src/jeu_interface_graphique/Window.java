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
 * Represents a graphical interface window for a treasure hunt game.
 * The window contains a grid of labels representing the game map,
 * buttons for controlling the game, and a history panel for displaying messages.
 * @author Vital FOCHEUX
 */
@SuppressWarnings("serial")
public class Window extends JFrame {
	
	/**
	 * Scroll pane used for displaying content in the window.
	 */
	private JScrollPane sp;
	/**
	 * Panel for displaying the game history
	 */
	private JPanel histo;
	
	/**
	 * Button for starting a new game.
	 */
	private JButton buttonNewGame;
	/**
	 * Button for manual mode play.
	 */
	private JButton buttonPlayManual;
	/**
	 * Button for proceeding to the next round.
	 */
	private JButton buttonNextRound;
	/**
	 * Button for automatic mode play.
	 */
	private JButton buttonPlayAuto;
	/**
	 * A 2D array of JLabels used to display images in the graphical user interface.
	 */
	private JLabel[][] imageLabel;

	/**
	 * Constructs a window with the specified dimensions.
	 * @param X The number of rows in the game map.
	 * @param Y The number of columns in the game map.
	 */
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
	
	/**
	 * Constructs a window with default dimensions of 14 rows and 29 columns.
	 */
	public Window() {
		this(14, 29);
	}
	
	/**
	 * Adds an action listener to the window's buttons.
	 * @param listener The action listener to be added.
	 */
	public void addListener(ActionListener listener) {
		buttonNewGame.addActionListener(listener);
		buttonPlayManual.addActionListener(listener);
		buttonPlayAuto.addActionListener(listener);
		buttonNextRound.addActionListener(listener);
	}
	
	/**
	 * Updates the image of a specific cell in the game map.
	 * @param image The new image for the cell.
	 * @param i The row index of the cell.
	 * @param j The column index of the cell.
	 */
	public void updateMap(ImageIcon image, int i, int j) {
		imageLabel[i][j].setIcon(image);
	}
	
	/**
	 * Enables or disables the "Nouvelle partie" button.
	 * @param activer {@code true} to enable the button, {@code false} to disable it.
	 */
	public void enabledNewGame(boolean activer) {
		buttonNewGame.setEnabled(activer);
	}
	
	/**
	 * Enables or disables the "Mode manuel" button.
	 * @param activer {@code true} to enable the button, {@code false} to disable it. 
	 */
	public void enabledPlayManual(boolean activer) {
		buttonPlayManual.setEnabled(activer);
	}
	
	/**
	 * Enables or disables the "Mode automatique" button.
	 * @param activer {@code true} to enable the button, {@code false} to disable it.
	 */
	public void enabledPlayAuto(boolean activer) {
		buttonPlayAuto.setEnabled(activer);
	}
	
	/**
	 * Enables or disables the "Tour suivant" button.
	 * @param activer {@code true} to enable the button, {@code false} to disable it.
	 */
	public void enabledNextRound(boolean activer) {
		buttonNextRound.setEnabled(activer);
	}
	
	/**
	 * Updates the history panel with a new message.
	 * @param message The message to be displayed.
	 */
	public void updateHistory(String message) {
	    JLabel label = new JLabel(message);
	    histo.add(label);
	    sp.revalidate();
	    sp.getVerticalScrollBar().setValue(sp.getVerticalScrollBar().getMaximum());
	}
	
	/**
	 * Clears the history panel.
	 */
	public void cleanHistory() {
		histo.removeAll();
		sp.revalidate();
	}
	
}
