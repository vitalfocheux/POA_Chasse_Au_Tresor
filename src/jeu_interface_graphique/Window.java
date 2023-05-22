/**
 * 
 */
package jeu_interface_graphique;

import javax.swing.JFrame;

/**
 * @author Vital FOCHEUX
 *
 */
public class Window extends JFrame {

	public Window() {
		this.setTitle("Treasure Hunt");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.pack();
		this.setSize(900,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
